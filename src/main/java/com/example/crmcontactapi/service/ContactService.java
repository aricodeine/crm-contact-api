package com.example.crmcontactapi.service;

import com.example.crmcontactapi.model.Contact;
import com.example.crmcontactapi.salesforce.SalesforceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*@Service
public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    public ContactService() {

        contacts.add(
                new Contact(
                        UUID.randomUUID().toString(),
                        "John",
                        "Doe",
                        "john@example.com"
                )
        );
    }

    public List<Contact> getAll() {
        return contacts;
    }

    public Contact create(Contact contact) {

        Contact created = new Contact(
                UUID.randomUUID().toString(),
                contact.firstName(),
                contact.lastName(),
                contact.email()
        );

        contacts.add(created);

        return created;
    }

    public Contact getById(String id) {

        return contacts.stream()
                .filter(c -> c.id().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Contact not found")
                );
    }

    public Contact update(String id, Contact updated) {

        Contact existing = getById(id);

        Contact replacement = new Contact(
                existing.id(),
                updated.firstName(),
                updated.lastName(),
                updated.email()
        );

        contacts.remove(existing);
        contacts.add(replacement);

        return replacement;
    }

    public void delete(String id) {

        Contact existing = getById(id);

        contacts.remove(existing);
    }
}*/

@Service
public class ContactService {

    private final SalesforceClient client;

    public ContactService(
            SalesforceClient client
    ) {
        this.client = client;
    }

    public Object getAll() {
        return client.getContacts();
    }

    public Object create(Contact contact) {
        return client.createContact(contact);
    }

    public Object getById(String Id) {
        return client.getContactById(Id);
    }

    public Object update(String id, Map<String, Object> contact) {
        return client.updateContact(id, contact);
    }

    public Object delete(String id) {
        return client.deleteContact(id);
    }

}