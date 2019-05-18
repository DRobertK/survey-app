package com.robert.util;

import com.robert.user.domain.Address;
import com.robert.user.domain.Role;
import com.robert.user.domain.User;

import java.time.LocalDate;

public class UserFactory {

    public UserFactory() {
    }

    public static User createFullUser() {
        Address address = new Address("str Marasesti", "nr.12, bl.51a", "Ploiesti", "Romania");
        LocalDate createdOn = LocalDate.now();

        return new User("gigi", "san",
                "gigi@gmail.com", "GigiPredus", "Romania12486Mare", createdOn, address, Role.ADMIN);
    }
}
