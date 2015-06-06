package ro.rocknrolla.portal_auto.security.auth_endpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationEndpoint.class);

    @RequestMapping(value = "/getPrincipal/{token}", method = RequestMethod.GET)
    public ResponseEntity getPrincipal(@PathVariable String token) {

        return ResponseEntity.ok("");
    }
}
