package com.example.crmcontactapi.salesforce;

import com.example.crmcontactapi.config.SalesforceProperties;
import com.example.crmcontactapi.model.Contact;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class SalesforceClient {

    private final SalesforceProperties props;

    private final RestClient client =
            RestClient.create();

    public SalesforceClient(
            SalesforceProperties props
    ) {
        this.props = props;
    }

    public AuthResponse authenticate() {

        return client.post()

                .uri(
                        props.baseUrl()
                                + "/services/oauth2/token"
                )

                .contentType(
                        org.springframework.http.MediaType
                                .APPLICATION_FORM_URLENCODED
                )

                .body(
                        "grant_type=client_credentials"
                                + "&client_id="
                                + props.clientId()
                                + "&client_secret="
                                + props.clientSecret()
                )

                .retrieve()

                .body(
                        AuthResponse.class
                );
    }

    public Map<?, ?> getContacts() {

        AuthResponse auth =
                authenticate();

        return client.get()

                .uri(
                        auth.instance_url()
                                +
                                "/services/data/v64.0/query"
                                +
                                "?q=SELECT+Id,FirstName,LastName,Email+FROM+Contact"
                )

                .header(
                        "Authorization",
                        "Bearer "
                                + auth.access_token()
                )

                .retrieve()

                .body(
                        Map.class
                );
    }

    public Map<?, ?> createContact(Contact contact) {

        AuthResponse auth =
                authenticate();

        return client.post()

                .uri(
                        auth.instance_url()
                                +
                                "/services/data/v64.0/sobjects/Contact/"
                )

                .header(
                        "Authorization",
                        "Bearer "
                                + auth.access_token()
                )
                .contentType(
                        MediaType.APPLICATION_JSON
                )
                .body(
                        contact
                )

                .retrieve()

                .body(
                        Map.class
                );
    }

    public Map<?, ?> getContactById(String Id) {

        AuthResponse auth =
                authenticate();

        return client.get()

                .uri(
                        auth.instance_url()
                                +
                                "/services/data/v64.0/query"
                                +
                                "?q=SELECT+Id,FirstName,LastName,Email+FROM+Contact+Where+Id='"+Id+"'"
                )

                .header(
                        "Authorization",
                        "Bearer "
                                + auth.access_token()
                )

                .retrieve()

                .body(
                        Map.class
                );
    }

    public Map<?, ?> updateContact(String id, Map<String, Object> contact) {

        AuthResponse auth =
                authenticate();

        return client.patch()

                .uri(
                        auth.instance_url()
                                +
                                "/services/data/v64.0/sobjects/Contact/"+ id
                )

                .header(
                        "Authorization",
                        "Bearer "
                                + auth.access_token()
                )
                .contentType(
                        MediaType.APPLICATION_JSON
                )
                .body(
                        contact
                )

                .retrieve()

                .body(
                        Map.class
                );
    }

    public Map<?, ?> deleteContact(String id) {

        AuthResponse auth =
                authenticate();

        return client.delete()

                .uri(
                        auth.instance_url()
                                +
                                "/services/data/v64.0/sobjects/Contact/"+ id
                )

                .header(
                        "Authorization",
                        "Bearer "
                                + auth.access_token()
                )

                .retrieve()

                .body(
                        Map.class
                );
    }

}
