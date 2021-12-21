package com.kaibacorp.personapi.utils;

import com.kaibacorp.personapi.api.DTO.PhoneDTO;
import com.kaibacorp.personapi.domain.enums.PhoneType;
import com.kaibacorp.personapi.domain.model.Phone;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "(16)99999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static long PHONE_ID = 1L;

    public static PhoneDTO createFakePhoneDTO(){
        return PhoneDTO.builder().
                number(PHONE_NUMBER).
                type(PHONE_TYPE).
                build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder().
                id(PHONE_ID).
                number(PHONE_NUMBER).
                type(PHONE_TYPE).
                build();
    }
}
