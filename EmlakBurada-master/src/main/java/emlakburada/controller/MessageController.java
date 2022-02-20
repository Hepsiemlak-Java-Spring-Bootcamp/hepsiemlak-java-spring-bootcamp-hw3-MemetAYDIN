package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.response.MessageResponse;
import emlakburada.repository.MessageRepository;


@RestController
public class MessageController {


	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	MessageResponse messsage;
	
	@GetMapping(value = "/messages")
	public ResponseEntity<List<MessageResponse>> createMessage() {
		return new ResponseEntity<>(messageRepository.createMessage(messsage), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/messages")
	public ResponseEntity<List<MessageResponse>> getAllMessage() {
		return new ResponseEntity<>(messageRepository.getAllMessage(), HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/messages/{messageNo}")
	public ResponseEntity<MessageResponse> getMessageById(@PathVariable(required = false) int messageNo) {
		return new ResponseEntity<>(messageRepository.findByIdMessage(messageNo), HttpStatus.OK);
	}

	
	
	
}
