package telran.spring.calculator.controller;
//HW-56

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.spring.calculator.Calculator;
import telran.spring.calculator.dto.CalculatorRequest;
import telran.spring.calculator.service.CalculatorService;
import telran.spring.dto.Message;
import telran.spring.service.SenderService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	@Autowired
	Calculator calculator;
	@PostMapping
	String calculate(@RequestBody CalculatorRequest request) {
		CalculatorService service = calculator.getService4Operation(request.operation);
		if (service == null) {
			return String.format("service %s is not implemented", request.operation);
		}
		if(request.operands.length == 2) {
			System.out.println(service.calculate(request.operands));
			return "calculation has been done - see logs";
		} else  {
			String errorMessage = String.format("Incorrect number of operands is %d\n", 
												request.operands.length);
			System.out.printf(errorMessage);
			return errorMessage;
		}
	}

}
