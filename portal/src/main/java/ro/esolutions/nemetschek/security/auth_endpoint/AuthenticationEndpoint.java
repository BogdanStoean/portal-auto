package ro.esolutions.nemetschek.security.auth_endpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.esolutions.nemetschek.security.token.TokenProvider;

import javax.annotation.Resource;

/**
 * Created by virgil on 4/20/15.
 * for project nemetschek-broker
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationEndpoint {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationEndpoint.class);

	@Resource
	private TokenProvider tokenProvider;

	@RequestMapping(value = "/getPrincipal/{token}", method = RequestMethod.GET)
	public ResponseEntity getPrincipal(@PathVariable String token) {
		if (token == null || token.trim().length() == 0) {
			return ResponseEntity.ok("");
		}
		String username = tokenProvider.getUsernameForToken(token);
		LOGGER.info("Validating token:-" + token + "- for: " + username);
		return ResponseEntity.ok(username);
	}

	@RequestMapping(value = "/logout/{token}", method = RequestMethod.GET)
	public String logout(@PathVariable String token) {
		if (token != null) {
			tokenProvider.removeToken(token);
		}
		LOGGER.info("Logging out:" + token);
		return "OK";
	}

}
