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
import co.javatoday.oauth.parser.LinkedInParser;
import co.javatoday.util.StringUtils;
import static co.javatoday.web.SessionAttributes.*;

@Controller
public class LinkedInController {
	
	@Autowired
	@Qualifier("linkedInServiceProvider")
	private OAuthServiceProvider linkedInServiceProvider;
	
	@RequestMapping(value={"/login-linkedin"}, method = RequestMethod.GET)
	public String login(WebRequest request) {
		
		// getting request and access token from session
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		Token accessToken = (Token) request.getAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
		if(requestToken == null || accessToken == null) {
			// generate new request token
			OAuthService service = linkedInServiceProvider.getService();
			requestToken = service.getRequestToken();
			request.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken, SCOPE_SESSION);
			
			// redirect to linkedin auth page
			return "redirect:" + service.getAuthorizationUrl(requestToken);
		}
		return "welcomePage";
	}
	
	@RequestMapping(value={"/linkedin-callback"}, method = RequestMethod.GET)
	public ModelAndView callback(@RequestParam(value="oauth_verifier", required=false) String oauthVerifier, WebRequest request) {
		
		// getting request tocken
		OAuthService service = linkedInServiceProvider.getService();
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		
		// getting access token
		Verifier verifier = new Verifier(oauthVerifier);
		Token accessToken = service.getAccessToken(requestToken, verifier);
		
		// store access token as a session attribute
		request.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken, SCOPE_SESSION);
		
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "http://api.linkedin.com/v1/people/~:(id,first-name,last-name,industry,headline)");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		
		String responseBody = oauthResponse.getBody();
		if(StringUtils.isNotBlank(responseBody)) {
			LinkedInParser parser = new LinkedInParser();
			User user = parser.getUser(responseBody);
			request.setAttribute(ATTR_LOGGED_IN_USER, user, SCOPE_SESSION);
		}

		ModelAndView mav = new ModelAndView("redirect:welcome");
		return mav;
	}
}