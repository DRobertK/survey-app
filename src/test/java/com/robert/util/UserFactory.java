package com.robert.util;

import com.robert.user.domain.Address;
import com.robert.user.domain.Profile;

import java.time.LocalDate;

public class UserFactory {

    public UserFactory() {
    }

    public static Profile createFullProfile() {
        Address address = new Address();
        address.setAddressLine1("str Marasesti");
        address.setAddressLine2("nr.12, bl.51a");
        address.setCity("Ploiesti");
        address.setCounty("Prahova");
        address.setCountry("Romania");
        LocalDate createdOn = LocalDate.now();

        Profile profile = new Profile();
        profile.setFirstName("gigi");
        profile.setLastName("san");
        profile.setEmail("gigi@gmail.com");
        profile.setAddress(address);
        return profile;
    }
}
