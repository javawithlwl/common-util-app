package com.careerit.cup.cbook.service;

import com.careerit.cup.cbook.domin.Contact;
import com.careerit.cup.cbook.repo.ContactRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements  ContactService{

  private final ContactRepo contactRepo;
  @Override
  @Cacheable(value = "contact", key = "#id")
  public Contact getContactById(String id) {
      Optional<Contact> optContact = contactRepo.findById(id);
      if (optContact.isPresent()) {
        log.info("Contact got from DB : {}", id);
        Contact contact = optContact.get();
        return contact;
      }
    throw new IllegalArgumentException("Contact is not found with given id");
  }

  @Override
  public List<Contact> getContacts() {
    return contactRepo.findAll();
  }

  @Override
  @CachePut(value = "contact", key = "#contact.id")
  public Contact updateContact(Contact contact) {
      return contactRepo.save(contact);
  }

  @Override
  public Contact addContact(Contact contact) {
      return contactRepo.save(contact);
  }

  @Override
  @CacheEvict(value = "contact", key = "#contact.id")
  public boolean deleteContact(String id) {
    Optional<Contact> optContact = contactRepo.findById(id);
    if (optContact.isPresent()) {
      log.info("Contact got from DB : {}", id);
      Contact contact = optContact.get();
      contactRepo.delete(contact);
      return true;
    }
    throw new IllegalArgumentException("Contact is not found with given id");
  }
}
