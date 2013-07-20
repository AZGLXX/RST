package com.azglxx.rst.rs;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response.Status;

import junit.framework.Assert;

import org.junit.Before;

import com.azglxx.rst.rs.handler.GsonMessageBodyHandler;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RsTestTemplate {

	protected String URL = "http://127.0.0.1:8080/rstweb/rest/root";
	ClientConfig clientConfig;
	Client client;
	WebResource resource;
	Cookie cookies;

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
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("username", "SuperAdmin");
		userInfo.put("password", "888888");
		ClientResponse response = resource.path("/user/login").accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, userInfo);
		Assert.assertTrue("login success!", (response.getStatus() == Status.OK.getStatusCode()));
		return response.getCookies();
	}
}
