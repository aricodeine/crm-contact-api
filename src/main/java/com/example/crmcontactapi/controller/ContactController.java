package com.example.crmcontactapi.controller;

import com.example.crmcontactapi.model.Contact;
import com.example.crmcontactapi.service.ContactService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Object getById(
            @PathVariable String id
    ) {
        return service.getById(id);
    }

    @PostMapping
    public Object create(
            @RequestBody Contact contact
    ) {
        return service.create(contact);
    }

    @PutMapping("/{id}")
    public Object update(
            @PathVariable String id,
            @RequestBody Map<String, Object> contact
    ) {
        return service.update(id, contact);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable String id
    ) {
        service.delete(id);
    }
}