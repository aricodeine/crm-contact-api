package com.example.crmcontactapi.model;

public record Contact(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
