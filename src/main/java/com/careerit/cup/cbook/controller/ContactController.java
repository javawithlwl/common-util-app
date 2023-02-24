package com.careerit.cup.cbook.controller;

import com.careerit.cup.cbook.domin.Contact;
import com.careerit.cup.cbook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {

  private final ContactService contactService;

  @PostMapping
  public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
    return ResponseEntity.ok(contactService.addContact(contact));
  }

  @PutMapping()
  public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
    return ResponseEntity.ok(contactService.updateContact(contact));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteContact(@PathVariable(name = "id",required = true) final String contactId) {
    return ResponseEntity.ok(contactService.deleteContact(contactId));
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Contact> getContact(@PathVariable("id") String id) {
    return ResponseEntity.ok(contactService.getContactById(id));
  }

  @GetMapping("/list")
  public ResponseEntity<List<Contact>> getContacts() {
    return ResponseEntity.ok(contactService.getContacts());
  }

}
