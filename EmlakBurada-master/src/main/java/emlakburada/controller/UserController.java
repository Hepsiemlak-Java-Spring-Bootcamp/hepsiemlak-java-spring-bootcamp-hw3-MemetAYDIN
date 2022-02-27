package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import emlakburada.dto.response.UserResponse;
import emlakburada.service.KullaniciService;

@RestController
public class UserController {

	@Autowired
	private KullaniciService userService;
	
	@Autowired
	UserResponse userResponse;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUser(), 
				HttpStatus.OK);
	}
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserResponse>> getAllUsert() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserResponse> getByUserId(@PathVariable(required = false) int userId) {
		return new ResponseEntity<>(userService.findByIdUser(userId), HttpStatus.OK);
	}

	
	
}
