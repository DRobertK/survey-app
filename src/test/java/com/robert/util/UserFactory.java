package com.robert.util;

import com.robert.user.domain.Address;
import com.robert.user.domain.Profile;
import com.robert.user.domain.Role;

import java.time.LocalDate;

public class UserFactory {

    public UserFactory() {
    }

    public static Profile createFullUser() {
        Address address = new Address("str Marasesti", "nr.12, bl.51a", "Ploiesti", "Romania");
        LocalDate createdOn = LocalDate.now();

        return new Profile("gigi", "san",
                "gigi@gmail.com", "GigiPredus", "Romania12486Mare", createdOn, address, Role.ADMIN);
    }
}
