/**
 * 
 */
package com.azglxx.rst.rs.rightsmgt;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.azglxx.rst.rs.SuperRs;

/**
 * user management resource
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 * @date 2013-7-20
 * @version 1.0
 */
@Path("/user")
@Service
public class UserRs extends SuperRs{

	@Path("login")
	@POST
	public Response login(){
		return ok(null);
	}
}
