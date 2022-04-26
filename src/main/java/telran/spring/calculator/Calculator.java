package telran.spring.calculator;
//HW-56

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import telran.spring.calculator.service.CalculatorService;

@Component
public class Calculator {
	
	Map<String, CalculatorService> mapServices;
	@Autowired
	public Calculator(List<CalculatorService> services) {
		mapServices = services.stream().collect(Collectors.toMap(CalculatorService::getType, s -> s));
	}
	
	public Calculator() {
		
	}
	
	public CalculatorService getService4Operation(String type) {
		return mapServices.get(type);
	}
	
	public String greetingMessage() {
		return "I am WEB Calculator";
	}
	
}
