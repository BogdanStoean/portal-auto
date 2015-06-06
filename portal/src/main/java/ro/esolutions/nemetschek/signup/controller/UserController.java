package ro.esolutions.nemetschek.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.esolutions.nemetschek.bean.Response;
import ro.esolutions.nemetschek.signup.bean.UserModel;
import ro.esolutions.nemetschek.signup.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: marius
 * Date: 5/4/15
 * Time: 2:23 PM
 */

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
