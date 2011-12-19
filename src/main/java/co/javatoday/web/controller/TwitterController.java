package co.javatoday.web.controller;


import org.scribe.model.*;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.context.request.RequestAttributes.*;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import co.javatoday.data.model.User;
import co.javatoday.oauth.OAuthServiceProvider;
import co.javatoday.oauth.parser.TwitterParser;
import co.javatoday.service.Service;
import co.javatoday.util.StringUtils;
import static co.javatoday.web.SessionAttributes.*;

@Controller
public class TwitterController {
	
	@Autowired
	@Qualifier("twitterServiceProvider")
	private OAuthServiceProvider twitterServiceProvider;
	
	@Autowired
	@Qualifier("userService")
	Service<User> userService;
	
	@RequestMapping(value={"/login-twitter"}, method = RequestMethod.GET)
	public String login(WebRequest request) {
		
		// getting request and access token from session
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		Token accessToken = (Token) request.getAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
		if(requestToken == null || accessToken == null) {
			// generate new request token
			OAuthService service = twitterServiceProvider.getService();
			requestToken = service.getRequestToken();
			request.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken, SCOPE_SESSION);
			
			// redirect to twitter auth page
			return "redirect:" + service.getAuthorizationUrl(requestToken);
		}
		return "welcomePage";
	}
	
	@RequestMapping(value={"/twitter-callback"}, method = RequestMethod.GET)
	public ModelAndView callback(@RequestParam(value="oauth_token", required=false) String oauthToken,
			@RequestParam(value="oauth_verifier", required=false) String oauthVerifier, WebRequest request) {
		
		// getting request token
		OAuthService service = twitterServiceProvider.getService();
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		
		// getting access token
		Verifier verifier = new Verifier(oauthVerifier);
		Token accessToken = service.getAccessToken(requestToken, verifier);
		
		// store access token as a session attribute
		request.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken, SCOPE_SESSION);
		
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "http://api.twitter.com/1/account/verify_credentials.xml");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		
		String responseBody = oauthResponse.getBody();
		if(StringUtils.isNotBlank(responseBody)) {
			TwitterParser parser = new TwitterParser();
			User user = parser.getUser(responseBody);
			userService.save(user);
			request.setAttribute(ATTR_LOGGED_IN_USER, user, SCOPE_SESSION);
		}

		ModelAndView mav = new ModelAndView("redirect:welcome");
		return mav;
	}
}