package com.grocery.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private char role;
    private Timestamp created_d;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && role == users.role && Objects.equals(first_name, users.first_name) && Objects.equals(last_name, users.last_name) && Objects.equals(username, users.username) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(created_d, users.created_d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, username, email, password, role, created_d);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created_d=" + created_d +
                '}';
    }
}
