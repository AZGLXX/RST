package com.azglxx.rst.rs;

import java.util.HashMap;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azglxx.common.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestRsTest extends RsTestTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestRsTest.class);

	@Test
	public void hello() {
		ClientResponse clientResponse = pathResource().path("/hello").cookie(cookie).accept(MediaType.TEXT_PLAIN)
				.get(ClientResponse.class);
		assertOk(clientResponse);
		LOGGER.info(clientResponse.getEntity(String.class));
	}

	@Test
	public void hello2() {
		ClientResponse clientResponse = pathResource().path("/hello2").cookie(cookie)
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		assertOk(clientResponse);
		String res = clientResponse.getEntity(String.class);
		HashMap<String, String> resMap = JsonUtils.fromJson(res, new TypeToken<HashMap<String, String>>() {
		}.getType());
		LOGGER.info("resMap : " + resMap);
	}

	@Override
	protected WebResource pathResource() {
		return resource.path(TestRs.PATH);
	}
}
