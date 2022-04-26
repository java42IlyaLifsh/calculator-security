package telran.spring.calculator;
//HW-56
import java.util.Scanner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringWebCalculatorAppl {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringWebCalculatorAppl.class, args);
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = ctx.getBean(Calculator.class);
		System.out.println(calculator.greetingMessage());
		
		while(true) {
			System.out.println("Enter  exit for graceful shutdown");
			String line = scanner.nextLine();
			if (line.equals("exit")) {
				ctx.close();
				break;
			}			
		}
	}
}
