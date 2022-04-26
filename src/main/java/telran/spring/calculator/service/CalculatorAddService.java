package telran.spring.calculator.service;
//HW-56

import org.springframework.stereotype.Service;

@Service
public class CalculatorAddService implements CalculatorService {

	@Override
	public double calculate(double[] operands) {
		return operandsValid(operands) ? operands[0] + operands[1] : Double.MAX_VALUE;
	}

	@Override
	public String getType() {
		return "+";
	}
}
