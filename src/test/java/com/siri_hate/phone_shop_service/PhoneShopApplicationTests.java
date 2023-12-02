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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PhoneShopApplicationTests {

    @MockBean
    PhoneRepository phoneRepository;

    @Autowired
    PhoneShopService phoneShopService;

    @Test
    void addPhoneTest() {

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

        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        Assertions.assertEquals(phone, phoneShopService.addNewPhoneToShop(phoneRequest));
    }

    @Test
    void getPhoneByIdTest() {

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

        when(phoneRepository.findById(id)).thenReturn(Optional.of(phone));

        Assertions.assertEquals(phone, phoneShopService.getPhoneFromShop(id));

    }

    @Test
    void getAllPhonesTest() {

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

        when(phoneRepository.findAll()).thenReturn(phoneList);

        Assertions.assertEquals(phoneList, phoneShopService.getAllPhonesFromShop());

    }

    @Test
    void updatePhoneInfoTest() {
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

        when(phoneRepository.findById(id)).thenReturn(Optional.of(phone));
        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        Assertions.assertEquals(phone, phoneShopService.updatePhoneInfoInShop(id, phoneRequest));

    }

    @Test
    void deletePhoneTest() {

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

        when(phoneRepository.findById(id)).thenReturn(Optional.of(phone));

        Assertions.assertEquals(message, phoneShopService.deletePhoneFromShop(id));
    }

}