package telran.spring.sender;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import telran.spring.sender.service.SenderService;


@SpringBootApplication
public class SpringIntroductionApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringIntroductionApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		Sender sender = ctx.getBean(Sender.class);
		System.out.println(sender.getSenderGreeting());
		
		while(true) {
//			System.out.println("Enter  exit for graceful shutdown");
			System.out.println("Enter service type or exit for graceful shutdown");
			String line = scanner.nextLine();
			if (line.equals("exit")) {
				ctx.close();
				break;
			}
			SenderService service = sender.getServiceByType(line);
			if(service==null) {
				System.out.printf("service %s isn't implemented yet\n", line);
			} else {
				System.out.println("Type message:");
				line = scanner.nextLine();
				service.send(line);
			}
		}
		scanner.close();
	}
}
