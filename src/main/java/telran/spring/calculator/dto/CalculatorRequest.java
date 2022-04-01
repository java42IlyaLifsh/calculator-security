package telran.spring.calculator.dto;

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
