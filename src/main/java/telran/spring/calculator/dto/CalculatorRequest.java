package telran.spring.calculator.dto;
//HW-56

public class CalculatorRequest {

public String operation;
public double[] operands;
public CalculatorRequest() {
}
public CalculatorRequest(String operation, double[] operands) {
	this.operation = operation;
	this.operands = operands;
}

}
