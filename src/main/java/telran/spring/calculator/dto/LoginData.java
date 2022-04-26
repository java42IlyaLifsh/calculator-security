package telran.spring.calculator.dto;
//HW-56
import javax.validation.constraints.*;

public class LoginData {
	@Email
public String email;
	@Size(min = 7)
public String password;
}
