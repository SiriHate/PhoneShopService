package com.siri_hate.phone_shop_service.controller;

import com.siri_hate.phone_shop_service.dto.PhoneRequest;
import com.siri_hate.phone_shop_service.entity.Phone;
import com.siri_hate.phone_shop_service.model.Message;
import com.siri_hate.phone_shop_service.service.PhoneShopService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * RESTful API controller for managing phone-related operations in the Phone Shop service.
 * Provides endpoints for adding, retrieving, updating, and deleting phones from the shop.
 */
@RestController
@RequestMapping("/api/v1")
@Validated
public class PhoneShopController {

    private final PhoneShopService phoneShopService;

    /**
     * Constructor for PhoneShopController.
     *
     * @param phoneShopService The service responsible for handling phone-related operations.
     */
    @Autowired
    PhoneShopController(PhoneShopService phoneShopService) {
        this.phoneShopService = phoneShopService;
    }

    /**
     * Endpoint for adding a new phone to the shop.
     *
     * @param phoneRequest The request body containing phone details.
     * @return ResponseEntity with the created phone and HTTP status 201 (Created).
     */
    @PostMapping("/phones")
    public ResponseEntity<Phone> addNewPhoneToShop(@RequestBody @Valid PhoneRequest phoneRequest) {
        Phone createdPhone = phoneShopService.addNewPhoneToShop(phoneRequest);
        return new ResponseEntity<>(createdPhone, HttpStatus.CREATED);
    }

    /**
     * Endpoint for retrieving information about a single phone from the shop.
     *
     * @param id The ID of the phone to retrieve.
     * @return ResponseEntity with the phone details and HTTP status 200 (OK).
     */
    @GetMapping("/phones/{id}")
    public ResponseEntity<Phone> getSinglePhoneFromShop(
            @PathVariable @Positive(message = "ID should be greater than zero") int id
    ) {
        Phone phone = phoneShopService.getPhoneFromShop(id);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving information about all phones from the shop.
     *
     * @return ResponseEntity with a list of phones and HTTP status 200 (OK).
     */
    @GetMapping("/phones")
    public ResponseEntity<List<Phone>> getAllPhonesFromShop() {
        List<Phone> phoneList = phoneShopService.getAllPhonesFromShop();
        return new ResponseEntity<>(phoneList, HttpStatus.OK);
    }

    /**
     * Endpoint for updating information about a phone in the shop.
     *
     * @param id            The ID of the phone to update.
     * @param phoneRequest  The request body containing updated phone details.
     * @return ResponseEntity with the updated phone and HTTP status 200 (OK).
     */
    @PutMapping("/phones/{id}")
    public ResponseEntity<Phone> updatePhoneInfoInShop(
            @PathVariable @Positive(message = "ID should be greater than zero") int id,
            @RequestBody @Valid PhoneRequest phoneRequest
    ) {
        Phone updatedPhone = phoneShopService.updatePhoneInfoInShop(id, phoneRequest);
        return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
    }

    /**
     * Endpoint for deleting a phone from the shop.
     *
     * @param id The ID of the phone to delete.
     * @return ResponseEntity with a message indicating the successful deletion and HTTP status 200 (OK).
     */
    @DeleteMapping("/phones/{id}")
    public ResponseEntity<Message> deletePhoneFromShop(
            @PathVariable @Positive(message = "ID should be greater than zero") int id
    ) {
        Message message = phoneShopService.deletePhoneFromShop(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
