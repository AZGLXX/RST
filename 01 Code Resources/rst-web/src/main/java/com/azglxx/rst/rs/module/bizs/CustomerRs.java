package com.azglxx.rst.rs.module.bizs;

import javax.ws.rs.Path;

import org.springframework.stereotype.Service;

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
@Service
public class CustomerRs {
	public static final String PATH = PathConst.BIZS + "/customer";
}
