package telran.spring.sender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import telran.spring.sender.Sender;
import telran.spring.sender.dto.Message;
import telran.spring.sender.service.SenderService;

@RestController
@RequestMapping("/messages")
public class SenderController {
	@Autowired
	Sender sender;
	@PostMapping
	String sendMessage(@RequestBody Message message) {
		SenderService service = sender.getServiceByType(message.senderType);
		if (service == null) {
			return String.format("service %s is not implemented", message.senderType);
		}
		service.send(message.text);
		return "message has been sent - see logs";
	}
}
