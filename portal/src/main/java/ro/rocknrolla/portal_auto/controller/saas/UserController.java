package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.rocknrolla.portal_auto.bean.Response;
import ro.rocknrolla.portal_auto.controller.bean.UserModel;
import ro.rocknrolla.portal_auto.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET)
	public Principal getLoggedUser(Principal user) {
		return user;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> create(@RequestBody @Valid UserModel userModel) {
		userService.createUser(userModel);

		return new ResponseEntity<>(new Response(true), HttpStatus.CREATED);
	}

}
