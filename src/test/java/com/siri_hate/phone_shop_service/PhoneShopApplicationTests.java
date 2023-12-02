package com.siri_hate.phone_shop_service;

import com.siri_hate.phone_shop_service.dto.PhoneRequest;
import com.siri_hate.phone_shop_service.entity.Phone;
import com.siri_hate.phone_shop_service.model.Message;
import com.siri_hate.phone_shop_service.repository.PhoneRepository;
import com.siri_hate.phone_shop_service.service.PhoneShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Integration tests for the PhoneShopService using Mockito to mock the PhoneRepository.
 */
@SpringBootTest
class PhoneShopApplicationTests {

    /**
     * MockBean for simulating the behavior of the PhoneRepository in integration tests.
     * It allows controlling the responses of repository methods during test execution.
     */
    @MockBean
    PhoneRepository phoneRepository;

    /**
     * Autowired instance of the PhoneShopService to be used in integration tests.
     * The service is injected with the mocked PhoneRepository for controlled testing.
     */
    @Autowired
    PhoneShopService phoneShopService;

    /**
     * Test the addition of a new phone to the shop.
     */
    @Test
    void addPhoneTest() {

        // Test data setup
        Phone phone = new Phone(
                1,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        PhoneRequest phoneRequest = new PhoneRequest(
                null,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        // Mock repository behavior
        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        // Perform the test and assert the result
        Assertions.assertEquals(phone, phoneShopService.addNewPhoneToShop(phoneRequest));
    }

    /**
     * Test retrieving a phone by its ID.
     */
    @Test
    void getPhoneByIdTest() {

        // Test data setup
        int id = 5;

        Phone phone = new Phone(
                id,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        // Mock repository behavior
        when(phoneRepository.findById(id)).thenReturn(Optional.of(phone));

        // Perform the test and assert the result
        Assertions.assertEquals(phone, phoneShopService.getPhoneFromShop(id));

    }

    /**
     * Test retrieving a phone by its ID when it does not exist (throws exception).
     */
    @Test
    void getPhoneByIdExceptionTest() {

        // Test data setup
        int id = 5;

        // Mock repository behavior
        when(phoneRepository.findById(id)).thenReturn(Optional.empty());

        // Perform the test and assert the result
        Assertions.assertThrows(NoSuchElementException.class, () -> phoneShopService.getPhoneFromShop(id));

    }

    /**
     * Test retrieving all phones from the shop.
     */
    @Test
    void getAllPhonesTest() {

        // Test data setup
        Phone phone1 = new Phone(
                1,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        Phone phone2 = new Phone(
                2,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        Phone phone3 = new Phone(
                3,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);

        // Mock repository behavior
        when(phoneRepository.findAll()).thenReturn(phoneList);

        // Perform the test and assert the result
        Assertions.assertEquals(phoneList, phoneShopService.getAllPhonesFromShop());

    }

    /**
     * Test retrieving all phones from the shop when the list is empty (throws exception).
     */
    @Test
    void getAllPhonesExceptionTest() {

        // Test data setup
        List<Phone> phoneList = new ArrayList<>();

        // Mock repository behavior
        when(phoneRepository.findAll()).thenReturn(phoneList);

        // Perform the test and assert the result
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> phoneShopService.getAllPhonesFromShop());

    }

    /**
     * Test updating phone information in the shop.
     */
    @Test
    void updatePhoneInfoTest() {

        // Test data setup
        int id = 5;

        Phone phone = new Phone(
                5,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        PhoneRequest phoneRequest = new PhoneRequest(
                null,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        // Mock repository behavior
        when(phoneRepository.findById(id)).thenReturn(Optional.of(phone));
        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        // Perform the test and assert the result
        Assertions.assertEquals(phone, phoneShopService.updatePhoneInfoInShop(id, phoneRequest));

    }

    /**
     * Test updating phone information in the shop when the phone does not exist (throws exception).
     */
    @Test
    void updatePhoneInfoExceptionTest() {

        // Test data setup
        int id = 100;

        PhoneRequest phoneRequest = new PhoneRequest(
                null,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        // Mock repository behavior
        when(phoneRepository.findById(id)).thenReturn(Optional.empty());

        // Perform the test and assert the result
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> phoneShopService.updatePhoneInfoInShop(id, phoneRequest)
        );

    }

    /**
     * Test deleting a phone from the shop.
     */
    @Test
    void deletePhoneTest() {

        // Test data setup
        int id = 5;

        Message message = new Message("The phone with the id = " + id + " has been successfully deleted!");

        Phone phone = new Phone(
                5,
                "Samsung",
                "Galaxy",
                10,
                "Black",
                15000,
                5
        );

        // Mock repository behavior
        when(phoneRepository.findById(id)).thenReturn(Optional.of(phone));

        // Perform the test and assert the result
        Assertions.assertEquals(message, phoneShopService.deletePhoneFromShop(id));
    }

    /**
     * Test deleting a phone from the shop when the phone does not exist (throws exception).
     */
    @Test
    void deletePhoneExceptionTest() {

        // Test data setup
        int id = 100;

        // Mock repository behavior
        when(phoneRepository.findById(id)).thenReturn(Optional.empty());

        // Perform the test and assert the result
        Assertions.assertThrows(NoSuchElementException.class, () -> phoneShopService.deletePhoneFromShop(id));

    }

}