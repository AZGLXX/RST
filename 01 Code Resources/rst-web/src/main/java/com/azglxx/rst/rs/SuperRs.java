package com.azglxx.rst.rs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public abstract class SuperRs {

	protected static Response ok() {
		return ok(null);
	}

	protected static Response ok(Object obj) {
		return createResult(obj);
	}

	protected static Response createNotAcceptable() {
		return createResult(Status.NOT_ACCEPTABLE, null);
	}

	protected static Response createResult(Object obj) {
		return createResult(Status.OK, obj);
	}

	protected static Response createResult(String key, Object value) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("lastUpdate", System.nanoTime());
		result.put(key, value);
		return createResult(Status.OK, result);
	}

	protected static Response createResult(Status status, Object obj) {
		return createResult(status.getStatusCode(), obj);
	}

	protected static Response createResult(Status status, Object obj, Map<String, String> headers) {
		return createResult(status.getStatusCode(), obj, headers);
	}

	protected static Response createResult(int status, Object obj) {
		return createResult(status, obj, null);
	}

	protected static Response createResult(int status, Object obj, Map<String, String> headers) {
		ResponseBuilder builder = Response.status(status).entity(obj);
		if (headers != null) {
			for (String key : headers.keySet()) {
				builder = builder.header(key, headers.get(key));
			}
		}
		return builder.build();
	}

}
