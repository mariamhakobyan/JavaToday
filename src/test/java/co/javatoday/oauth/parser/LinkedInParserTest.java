package co.javatoday.oauth.parser;

import static junit.framework.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import co.javatoday.data.model.User;
import co.javatoday.data.model.UserSource;

public class LinkedInParserTest {

	@BeforeClass
	public static void setUpOnce() {
	}

	@AfterClass
	public static void tearDownOnce() {
	}

	@Test
	public void testUserParse() {
		String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
		        + "<person>"
		        + "<id>OjiuGIIlya</id>"
		        + "<first-name>Artur</first-name>"
		        + "<last-name>Mkrtchyan</last-name>"
		        + "<industry>Computer Software</industry>"
		        + "<headline>Software Engineer at AtTask, Inc.</headline>"
		        + "</person>";
		
		LinkedInParser parser = new LinkedInParser();
		
		User user = parser.getUser(xmlData);
		System.out.println(user);
		assertEquals("OjiuGIIlya", user.getSocialId());
		assertEquals("Artur", user.getFirstName());
		assertEquals("Mkrtchyan", user.getLastName());
		assertEquals("Software Engineer at AtTask, Inc.", user.getTitle());
		assertEquals(UserSource.LinkedIn, user.getUserSourceAsEnum());
		
	}
}
