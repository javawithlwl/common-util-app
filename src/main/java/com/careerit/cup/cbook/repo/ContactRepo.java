package com.careerit.cup.cbook.repo;

import com.careerit.cup.cbook.domin.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepo extends MongoRepository<Contact,String> {
}
