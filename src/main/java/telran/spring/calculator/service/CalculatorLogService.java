package telran.spring.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorLogService implements CalculatorService {

	@Override
	public double calculate(double[] operands) {
		return operandsValid(operands) ? 
				Math.log(operands[1]) / Math.log(operands[0]) : 
				Double.POSITIVE_INFINITY;
	}

	@Override
	public String getType() {
		return "log";
	}
}
