package com.azglxx.rst.rs;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azglxx.common.utils.JsonUtils;
import com.azglxx.rst.rs.constants.PathConst;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public abstract class RsTestTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(RsTestTemplate.class);

	protected static String URL = "http://localhost:8080/rst-web/rest";
	protected static ClientConfig clientConfig;
	protected static Client client;
	protected static WebResource resource;
	protected static Cookie cookie;

	@BeforeClass
	public static void beforeTestClass() throws IOException {
		clientConfig = new DefaultClientConfig();
		client = Client.create(clientConfig);
		client.setFollowRedirects(true);
		resource = client.resource(URL);
		for (NewCookie cookie : login()) {
			RsTestTemplate.cookie = cookie;
		}
	}

	protected static List<NewCookie> login() {
		HashMap<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("username", "SuperAdmin");
		userInfo.put("password", "888888");
		ClientResponse response = resource.path(PathConst.RIGHTS_MGT + "/user/login")
				.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, JsonUtils.toJson(userInfo));
		assertOk(response);
		return response.getCookies();
	}

	protected abstract WebResource pathResource();

	protected static void assertOk(ClientResponse cr) {
		LOGGER.info("reponse status is " + cr.getStatus());
		assertEquals("reponse status is not OK", 200, cr.getStatus());
	}
}
