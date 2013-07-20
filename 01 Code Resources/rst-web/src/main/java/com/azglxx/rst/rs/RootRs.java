package com.azglxx.rst.rs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.sun.jersey.spi.resource.Singleton;

@Component
@Path("/root")
@Singleton
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RootRs extends SuperRs {

	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello() {
		return ok("Hello!");
	}

	@Path("/hello2")
	@GET
	public Response hello2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "avalue");
		map.put("b", "bvalue");
		return ok(map);
	}
}
