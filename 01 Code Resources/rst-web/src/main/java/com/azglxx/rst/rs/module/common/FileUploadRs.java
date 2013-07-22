package com.azglxx.rst.rs.module.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.azglxx.common.constants.SessionKey;
import com.azglxx.common.context.ContextScope;
import com.azglxx.common.context.CurrentContext;
import com.azglxx.common.exception.BizsExcpetion;
import com.azglxx.common.utils.StreamUtils;
import com.azglxx.rst.rs.SuperRs;
import com.azglxx.rst.rs.constants.PathConst;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * Description:
 * 
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 * @Date 2013-7-22 上午11:09:41
 * @since v1.0.0
 */
@Path(FileUploadRs.PATH)
@Component
public class FileUploadRs extends SuperRs {

    public final static String PATH = "/fileUpload";

    private final static Logger LOGGER = LoggerFactory.getLogger(FileUploadRs.class);

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadFile(@FormDataParam("file") InputStream inputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
        String realRootPath = CurrentContext.getHttpServletRequest().getServletContext().getRealPath("/");
        String path = PathConst.FILE_UPLOAD_PLACE + System.nanoTime() + fileDetail.getType();
        File file = new File(realRootPath, path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        StreamUtils.writeStream(inputStream, fileOutputStream);
        CurrentContext.put(SessionKey.UPLOADED_FILE_PREFIX_KEY + fileDetail.getName(), path, ContextScope.SESSION);
        return ok();
    }
}
