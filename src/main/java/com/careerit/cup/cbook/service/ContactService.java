package com.careerit.cup.cbook.service;

import com.careerit.cup.cbook.domin.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactById(String id);
    List<Contact> getContacts();
    Contact updateContact(Contact contact);
    Contact addContact(Contact contact);
    boolean deleteContact(String id);
}
