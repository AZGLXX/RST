/**
 * 
 */
package com.azglxx.rst.rs.module.rights;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azglxx.common.context.CurrentContext;
import com.azglxx.common.context.UserInfo;
import com.azglxx.rst.rs.SuperRs;
import com.azglxx.rst.rs.constants.PathConst;
import com.azglxx.rst.service.IRightsService;

/**
 * user management resource
 * 
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 * @date 2013-7-20
 * @version 1.0
 */
@Path(UserRs.PATH)
@Service
public class UserRs extends SuperRs {
	public static final String PATH = PathConst.RIGHTS_MGT + "/user";

	@Autowired
	IRightsService rightsService;

	@Path("/login")
	@POST
	public Response login(UserInfo user) {
		CurrentContext.setCurrentUser(user);
		return ok();
	}

	@Path("/logout")
	@POST
	public Response logout() {
		CurrentContext.invalidSession();
		return ok();
	}
}
