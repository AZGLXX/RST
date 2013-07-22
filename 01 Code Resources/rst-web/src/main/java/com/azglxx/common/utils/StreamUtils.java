package com.azglxx.common.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azglxx.common.exception.BizsExcpetion;

/**
 * Description:
 * 
 * @author Arian Zhang
 * @email hzhang@digitnexus.com
 * @Date 2013-7-22 上午11:44:46
 * @since v1.0.0
 */
public class StreamUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(StreamUtils.class);

    /**
     * Write output stream from input stream.
     * 
     * @param inputStream
     * @param outputStream
     */
    public static void writeStream(InputStream inputStream, OutputStream outputStream) {
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        try {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        } catch (IOException e) {
            throw new BizsExcpetion(e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                LOGGER.error("close output stream occur error!", e);
            }
        }
    }
}
