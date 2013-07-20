package com.azglxx.rst.rs;

import java.util.HashMap;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azglxx.common.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class RootRsTest extends RsTestTemplate {

	private static final Logger LOGGER = LoggerFactory.getLogger(RootRsTest.class);
	
	@Test
	public void hello() {
		ClientResponse clientResponse = super.resource.path(ROOT+"/hello").accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		assertOk(clientResponse);
		LOGGER.info(clientResponse.getEntity(String.class));
	}

	@Test
	public void hello2() {
		ClientResponse clientResponse = super.resource.path(ROOT+"/hello2").accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		assertOk(clientResponse);
		String res = clientResponse.getEntity(String.class);
		HashMap<String,String> resMap = JsonUtils.fromJson(res, new TypeToken<HashMap<String,String>>(){}.getType());
		LOGGER.info("resMap : " + resMap);
	}
}
