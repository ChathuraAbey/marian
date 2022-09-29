/*
 *                 IFS Research & Development
 *
 *  This program is protected by copyright law and by international
 *  conventions. All licensing, renting, lending or copying (including
 *  for private use), and all other use of the program, which is not
 *  expressively permitted by IFS Research & Development (IFS), is a
 *  violation of the rights of IFS. Such violations will be reported to the
 *  appropriate authorities.
 *
 *  VIOLATIONS OF ANY COPYRIGHT IS PUNISHABLE BY LAW AND CAN LEAD
 *  TO UP TO TWO YEARS OF IMPRISONMENT AND LIABILITY TO PAY DAMAGES.
 */
package com.ifs.scim.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.charon3.core.encoder.JSONEncoder;
import org.wso2.charon3.core.exceptions.CharonException;
import org.wso2.charon3.core.exceptions.FormatNotSupportedException;
import org.wso2.charon3.core.protocol.SCIMResponse;
import org.wso2.charon3.core.protocol.endpoints.AbstractResourceManager;
import com.ifs.scim.utils.SCIMProviderConstants;

import java.util.Map;
import javax.ws.rs.core.Response;

/**
 * Endpoint parent class.
 */
public class AbstractResource /*implements Microservice*/ {

    private static Logger logger = LoggerFactory.getLogger(AbstractResource.class);

    //identify the output format
    public boolean isValidOutputFormat(String format) {
        if (format == null || "*/*".equals(format)
                || format.equalsIgnoreCase(SCIMProviderConstants.APPLICATION_JSON)
                || format.equalsIgnoreCase(SCIMProviderConstants.APPLICATION_SCIM_JSON)) {
            return true;
        } else {
            return false;
        }
    }

    //identify the input format
    public boolean isValidInputFormat(String format) {

        if (format == null) {
            return true;
        }

        String mediaType = format.split(";")[0];
        if ("*/*".equals(mediaType)
                || mediaType.equalsIgnoreCase(SCIMProviderConstants.APPLICATION_JSON)
                || mediaType.equalsIgnoreCase(SCIMProviderConstants.APPLICATION_SCIM_JSON)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Build an error message for a Charon exception. We go with the
     * JSON encoder as default if not specified.
     *
     * @param e CharonException
     * @param encoder
     * @return
     */
    protected Response handleCharonException(CharonException e, JSONEncoder encoder) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getMessage(), e);
        }

        return buildResponse(AbstractResourceManager.encodeSCIMException(e));
    }

    /*
     * Build the error response if the requested input or output format is not supported. We go with JSON encoder as
     * the encoder for the error response.
     *
     * @param e
     * @return
     */
    protected Response handleFormatNotSupportedException(FormatNotSupportedException e) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getMessage(), e);
        }

        // use the default JSON encoder to build the error response.
        return buildResponse(AbstractResourceManager.encodeSCIMException(e));
    }

    /*
     * build the jaxrs response
     * @param scimResponse
     * @return
     */
    public Response buildResponse(SCIMResponse scimResponse) {
        //create a response builder with the status code of the response to be returned.
        Response.ResponseBuilder responseBuilder = Response.status(scimResponse.getResponseStatus());
        //set the headers on the response
        Map<String, String> httpHeaders = scimResponse.getHeaderParamMap();
        if (httpHeaders != null && !httpHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {

                responseBuilder.header(entry.getKey(), entry.getValue());
            }
        }
        //set the payload of the response, if available.
        if (scimResponse.getResponseMessage() != null) {
            responseBuilder.entity(scimResponse.getResponseMessage());
        }
        return responseBuilder.build();
    }

}
