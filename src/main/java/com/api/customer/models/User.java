package com.api.customer.models;

import javafx.beans.binding.Bindings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Indexed
    private String firstName;

    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String role;
    private Address address;

}
