package telran.spring.calculator.exeptions;
//HW-56
 
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BadRequestException(String message) {
		super(message);
	}

}
