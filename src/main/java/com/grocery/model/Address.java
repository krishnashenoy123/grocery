package com.grocery.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;
    private int user_id;
    private String street;
    private String city;
    private String state;
    private String pin_code;
    private Timestamp created_d;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && user_id == address.user_id && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(pin_code, address.pin_code) && Objects.equals(created_d, address.created_d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, street, city, state, pin_code, created_d);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pin_code='" + pin_code + '\'' +
                ", created_d=" + created_d +
                '}';
    }
}
