package dieberroa.demo.asyncsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dieberroa.demo.asyncsync.api.ImpSendMail;
import dieberroa.demo.asyncsync.bl.ImpSendMailManager;
import dieberroa.demo.asyncsync.bl.SendEMailManager;

@SpringBootApplication
public class AsyncsyncApplication {


	public static void main(String[] args) {
		SpringApplication.run(AsyncsyncApplication.class, args);
		SendEMailManager sendEMailManager = new ImpSendMailManager(new ImpSendMail());
		sendEMailManager.sendEmail();
		
	}





}
