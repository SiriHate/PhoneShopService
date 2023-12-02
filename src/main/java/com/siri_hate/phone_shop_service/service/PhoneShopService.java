package com.siri_hate.phone_shop_service.service;

import com.siri_hate.phone_shop_service.dto.PhoneRequest;
import com.siri_hate.phone_shop_service.entity.Phone;
import com.siri_hate.phone_shop_service.model.Message;

import java.util.List;

/**
 * Service interface defining operations for managing phones in the phone shop.
 * Implementing classes are responsible for handling business logic related to phone operations.
 */
public interface PhoneShopService {

    /**
     * Adds a new phone to the shop based on the provided PhoneRequest.
     *
     * @param phoneRequest The PhoneRequest containing details of the phone to be added.
     * @return The Phone entity representing the newly added phone.
     */
    Phone addNewPhoneToShop(PhoneRequest phoneRequest);

    /**
     * Retrieves information about a phone from the shop based on the provided ID.
     *
     * @param id The ID of the phone to retrieve.
     * @return The Phone entity representing the phone with the specified ID.
     */
    Phone getPhoneFromShop(int id);

    /**
     * Retrieves information about all phones available in the shop.
     *
     * @return A list of Phone entities representing all phones in the shop.
     */
    List<Phone> getAllPhonesFromShop();

    /**
     * Updates information about a phone in the shop based on the provided ID and PhoneRequest.
     *
     * @param id            The ID of the phone to update.
     * @param phoneRequest  The PhoneRequest containing updated details of the phone.
     * @return The Phone entity representing the updated information of the phone.
     */
    Phone updatePhoneInfoInShop(int id, PhoneRequest phoneRequest);

    /**
     * Deletes a phone from the shop based on the provided ID.
     *
     * @param id The ID of the phone to delete.
     * @return A message indicating the result of the delete operation.
     */
    Message deletePhoneFromShop(int id);

}
