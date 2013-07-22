package com.azglxx.rst.rs.module.basicdata;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.azglxx.rst.rs.SuperRs;

/**
 * Description:
 * 
 * @author Arian Zhang
 * @email hzhang@digitnexus.com
 * @Date 2013-7-22 下午2:51:42
 * @since v1.0.0
 */
@Path(AboutUsRs.PATH)
@Component
public class AboutUsRs extends SuperRs {

    public final static String PATH = "/aboutus";
    
    
    private final static Logger logger = LoggerFactory.getLogger(AboutUsRs.class);
    
    
    /* (non-Javadoc)
     * @see com.azglxx.rst.rs.SuperRs#getData(java.lang.String)
     */
    @Override
    public Response getData(@HeaderParam("lastUpdate") String lastUpdate) {
        return super.getData(lastUpdate);
    }
}
