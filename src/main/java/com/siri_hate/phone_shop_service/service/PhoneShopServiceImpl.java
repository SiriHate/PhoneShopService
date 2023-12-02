package com.siri_hate.phone_shop_service.service;

import com.siri_hate.phone_shop_service.model.Message;
import com.siri_hate.phone_shop_service.repository.PhoneRepository;
import com.siri_hate.phone_shop_service.dto.PhoneRequest;
import com.siri_hate.phone_shop_service.dto.PhoneRequestMapper;
import com.siri_hate.phone_shop_service.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The {@code PhoneShopServiceImpl} class implements the {@link PhoneShopService} interface
 * and provides methods to interact with the phone inventory in a phone shop.
 * It uses a {@link PhoneRepository} to perform CRUD operations on {@link Phone} entities.
 */
@Service
public class PhoneShopServiceImpl implements PhoneShopService {

    private final PhoneRepository phoneRepository;

    /**
     * Constructs a new {@code PhoneShopServiceImpl} instance with the provided {@link PhoneRepository}.
     *
     * @param phoneRepository The repository for managing phone entities.
     */
    @Autowired
    PhoneShopServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    /**
     * Adds a new phone to the shop based on the provided {@link PhoneRequest}.
     *
     * @param phoneRequest The request containing information to create a new phone.
     * @return The created {@link Phone} entity.
     */
    @Override
    @Transactional
    public Phone addNewPhoneToShop(PhoneRequest phoneRequest) {
        Phone phone = PhoneRequestMapper.INSTANCE.toPhoneEntity(phoneRequest);
        return phoneRepository.save(phone);
    }

    /**
     * Retrieves a phone from the shop based on the provided ID.
     *
     * @param id The ID of the phone to retrieve.
     * @return The retrieved {@link Phone} entity.
     * @throws NoSuchElementException if no phone is found with the specified ID.
     */
    @Override
    @Transactional
    public Phone getPhoneFromShop(int id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        return phone.orElseThrow(() -> new NoSuchElementException("Phone with ID " + id + " not found"));
    }

    /**
     * Retrieves all phones from the shop.
     *
     * @return A list of all {@link Phone} entities in the shop.
     * @throws EmptyResultDataAccessException if no phones are found in the shop.
     */
    @Override
    @Transactional
    public List<Phone> getAllPhonesFromShop() {
        List<Phone> phoneList = phoneRepository.findAll();
        if (!phoneList.isEmpty()) {
            return phoneList;
        } else {
            throw new EmptyResultDataAccessException("No phones found", 1);
        }
    }

    /**
     * Updates the information of a phone in the shop based on the provided ID and {@link PhoneRequest}.
     *
     * @param id            The ID of the phone to update.
     * @param phoneRequest  The request containing updated information for the phone.
     * @return The updated {@link Phone} entity.
     * @throws NoSuchElementException if no phone is found with the specified ID.
     */
    @Override
    @Transactional
    public Phone updatePhoneInfoInShop(int id, PhoneRequest phoneRequest) {
        Phone phone = PhoneRequestMapper.INSTANCE.toPhoneEntity(phoneRequest);
        Optional<Phone> previousPhone = phoneRepository.findById(id);
        if (previousPhone.isPresent()) {
            phone.setId(id);
            phoneRepository.save(phone);
            return phone;
        } else {
            throw new NoSuchElementException("Phone with ID " + id + " not found");
        }
    }

    /**
     * Deletes a phone from the shop based on the provided ID.
     *
     * @param id The ID of the phone to delete.
     * @return A message indicating the successful deletion of the phone.
     * @throws NoSuchElementException if no phone is found with the specified ID.
     */
    @Override
    @Transactional
    public Message deletePhoneFromShop(int id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        if (phone.isPresent()) {
            phoneRepository.deleteById(id);
            return new Message("The phone with the id = " + id + " has been successfully deleted!");
        } else {
            throw new NoSuchElementException("Phone with ID " + id + " not found");
        }
    }

}
