package co.javatoday.oauth.parser;

import java.io.StringReader;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import co.javatoday.data.model.User;
import co.javatoday.data.model.UserSource;

public class TwitterParser extends OauthParser {

	public User getUser(String xmlData) {
		final User user = new User();
		user.setUserSource(UserSource.Twitter);
		
		DefaultHandler handler = new DefaultHandler() {
			
			private StringBuffer buffer;
			private String tagName;
			private boolean isParsingFinished = false;
			
			
			@Override
			public void startDocument() throws SAXException {
				buffer = new StringBuffer();
			}

			@Override
			public void characters(char[] ch, int start, int length)
			        throws SAXException {
				if(isParsingFinished) {
					return;
				}
				if (tagName.equals("name")) {
					buffer.append(new String(ch, start, length).trim());
				} else if (tagName.equals("id")) {
					buffer.append(new String(ch, start, length).trim());
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName)
			        throws SAXException {
				if(isParsingFinished) {
					return;
				}
				if (qName.equals("name")) {
					user.setFirstName(buffer.toString());
					user.setLastName("");
				} else if(qName.equals("id")){
					user.setId(buffer.toString());
				}
			}

			@Override
			public void startElement(String uri, String localName,
			        String qName, Attributes attributes) throws SAXException {
				if(isParsingFinished) {
					return;
				}
				buffer.setLength(0);
				tagName = qName;
				if(tagName.equals("status")) {
					isParsingFinished = true;
				}
			}

		};

		InputSource is = new InputSource(new StringReader(xmlData));
		is.setEncoding("UTF-8");

		try {
			getSAXParser().parse(is, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
