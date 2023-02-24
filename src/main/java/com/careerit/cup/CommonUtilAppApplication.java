package com.careerit.cup;

import com.careerit.cup.cbook.domin.Contact;
import com.careerit.cup.cbook.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CommonUtilAppApplication implements CommandLineRunner {

	@Autowired
	private ContactRepo contactRepo;
	public static void main(String[] args) {
		SpringApplication.run(CommonUtilAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		contactRepo.deleteAll();
		Contact contact1 = Contact.builder().name("Ashok").mobile("9876765432").build();
		Contact contact2 = Contact.builder().name("Satya").mobile("5876765439").build();
		Contact contact3 = Contact.builder().name("Mouli").mobile("6876765433").build();
		contactRepo.saveAll(List.of(contact1,contact2,contact3));

	}
}
