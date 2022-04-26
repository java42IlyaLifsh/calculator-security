package telran.spring.calculator.controller;
//HW-56
import java.util.Base64;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import telran.spring.calculator.dto.*;
import telran.spring.calculator.exeptions.*;
import telran.spring.calculator.security.*;


@RestController
@RequestMapping("/login")
@CrossOrigin
public class AuthController {
	static Logger LOG = LoggerFactory.getLogger(AuthController.class);
	AccountingManagement accounting;
	PasswordEncoder passwordEncoder;
	@Value("${app.security.enable: true}")
	 boolean securityEnable;
	@Autowired
	JwtUtils jwtUtils;
	public AuthController(AccountingManagement accounting, PasswordEncoder passwordEncoder) {
		this.accounting = accounting;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping
	LoginResponse login( @RequestBody @Valid LoginData loginData) {
		if (!securityEnable) {
			LOG.debug("login data ignored due to disabled security");
			return new LoginResponse("", "ADMIN");
		}
		LOG.debug("login data are email {}, password: {}", loginData.email, loginData.password);
		Account account = accounting.getAccount(loginData.email);
		
		if(account == null || !passwordEncoder.matches(loginData.password, account.getPasswordHash())) {
			throw new BadRequestException("Wrong credentials");
		}
		LoginResponse response = new LoginResponse(getToken(loginData), account.getRole());
		LOG.debug("accessToken: {}, role {}", response.accessToken, response.role);
		return response;
	}

	private String getToken(LoginData loginData) {
		//"Basic <username:password> in Base64 code
		
		return "Bearer " + jwtUtils.create(loginData.email);
	}

}
