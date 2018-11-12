package com.call.application.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.call.application.web.rest.vm.ManagedUserVM;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(ManagedUserVM managedUserVm) throws MailException{
		//send mail
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("muhammediscann@gmail.com");
		mail.setTo("muhammediscann@gmail.com");
		mail.setSubject(managedUserVm.getEmail());
		mail.setText("Succesfully! "+ managedUserVm.getUsername()+ " is registered!");
		
		javaMailSender.send(mail);
	}
	public void sendNotificationNewUser(ManagedUserVM managedUserVM) throws MailException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("muhammediscann@gmail.com");
		mail.setTo("muhammed.iscan@iottech.com.tr");
		mail.setSubject(managedUserVM.getEmail());
		mail.setText("Succesfully! "+ managedUserVM.getUsername()+ " is registered!");
		
		javaMailSender.send(mail);
	}
	
	
}
