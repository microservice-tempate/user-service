package vn.academy.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String username;

    private String password;
}