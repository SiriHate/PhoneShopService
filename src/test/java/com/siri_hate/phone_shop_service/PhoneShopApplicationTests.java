package com.siri_hate.phone_shop_service;

import com.siri_hate.phone_shop_service.dao.PhoneRepository;
import com.siri_hate.phone_shop_service.service.PhoneShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PhoneShopApplicationTests {

    @MockBean
    PhoneRepository phoneRepository;

    @Autowired
    PhoneShopService phoneShopService;



}
