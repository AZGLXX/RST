package com.azglxx.rst.rs;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azglxx.rst.rs.handler.GsonMessageBodyHandler;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RsTestTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(RsTestTemplate.class);

	protected String URL = "http://127.0.0.1:8080/rstweb";
	protected String ROOT = "/rest/root";
	protected ClientConfig clientConfig;
	protected Client client;
	protected WebResource resource;
	protected Cookie cookies;

	@Before
	public void beforeTest() throws IOException {
		clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(GsonMessageBodyHandler.class);
		client = Client.create(this.clientConfig);
		client.setFollowRedirects(true);
		resource = client.resource(URL);
		for (NewCookie cookie : login()) {
			cookies = cookie;
		}
	}

	protected List<NewCookie> login() {
		HashMap<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("username", "SuperAdmin");
		userInfo.put("password", "888888");
		ClientResponse response = resource.path(ROOT + "/user/login").accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, userInfo);
		assertOk(response);
		return response.getCookies();
	}

	protected void assertOk(ClientResponse cr) {
		LOGGER.info("reponse status is " + cr.getStatus());
		assertEquals("reponse status is not OK", 200, cr.getStatus());
	}
}
