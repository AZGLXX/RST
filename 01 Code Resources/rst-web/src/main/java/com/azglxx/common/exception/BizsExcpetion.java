package com.azglxx.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * 
 * @author Arian Zhang
 * @email hzhang@digitnexus.com
 * @Date 2013-7-22 上午11:41:11
 * @since v1.0.0
 */
public class BizsExcpetion extends RuntimeException {

    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private final static Logger logger = LoggerFactory.getLogger(BizsExcpetion.class);

    public BizsExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BizsExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public BizsExcpetion(Throwable cause) {
        super(cause);
    }

}
