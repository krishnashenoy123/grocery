package com.grocery.controller;

import com.grocery.model.Address;
import com.grocery.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAddresses(){
        List<Address> addresses = addressService.getAdresseses();
        if (addresses.isEmpty()) {
            return ResponseEntity.noContent().build();  // 204 No Content
        }
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/addresses")
    public ResponseEntity<?> addAddress(@RequestBody Address address){
        try {
            if (address.getUser_id() == 0 || address.getStreet() == null || address.getCity() == null) {
                return ResponseEntity.badRequest().body("Missing required fields: userId, street, or city.");
            }

            int rows = addressService.addAddress(address);

            if (rows > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body(address);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Could not insert address due to server error.");
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            // You need to throw this explicitly if, for example, userId does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error: " + e.getMessage());
        }
    }

    @PutMapping("/addresses")
    public ResponseEntity<?> updateAddress(@RequestBody Address address){
        if(address == null || address.getCity() == null || address.getStreet() == null
                || address.getState() == null || address.getPin_code() == null){
            return ResponseEntity.badRequest().body("Missing values for Street, City, State or Pin Code");
        }
        try{
            int rows = addressService.updateAddress(address);
            if(rows > 0){
                Address updatedAddress = addressService.getAddressByParams(address.getUser_id(), address.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(updatedAddress);
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Could not update address due to server error.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable int id) {
        if(id < 1){
            return ResponseEntity.badRequest().body("Id cannot be empty or negative");
        }
        try {
            int rowsDeleted = addressService.deleteAddress(id);
            if (rowsDeleted > 0) {
                return ResponseEntity.ok("Address deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting address: " + e.getMessage());
        }
    }

}
