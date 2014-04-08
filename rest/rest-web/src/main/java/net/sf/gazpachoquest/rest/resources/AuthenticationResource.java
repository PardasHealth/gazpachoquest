package net.sf.gazpachoquest.rest.resources;

import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.security.AuthenticationManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/auth")
@Api(value = "/auth", description = "Authentication Interface")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationResource.class);

    @Autowired
    @Qualifier("respondentAuthManager")
    private AuthenticationManager respondentAuthManager;

    @GET
    @Path("/respondent")
    @ApiOperation(value = "Authentication for respondents", response = RespondentAccount.class)
    public Response authenticate(@QueryParam("invitation")
    @ApiParam(value = "Invitation")
    String invitation) {
        logger.info("New respondent authentication petition received");
        Account account = null;
        try {
            account = respondentAuthManager.authenticate(null, invitation);
        } catch (AccountNotFoundException e) {
            logger.warn("Login access failure", e);
            return Response.status(Status.UNAUTHORIZED).build();
        }
        return Response.ok(account).build();
    }
}
