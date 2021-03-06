package com.azglxx.rst.rs.module.bizs;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.azglxx.rst.rs.SuperRs;
import com.azglxx.rst.rs.constants.PathConst;

/**
 * customer information management
 * 
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 * @date 2013-7-20
 * @version 1.0
 */
@Path(CustomerRs.PATH)
@Component
public class CustomerRs extends SuperRs{
	public static final String PATH = PathConst.BIZS + "/customer";
}
