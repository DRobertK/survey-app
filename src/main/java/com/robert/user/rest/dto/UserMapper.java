package com.robert.user.rest.dto;

import com.robert.user.domain.Profile;

public class UserMapper {

    // TODO : move this to a mapper
    public static void map(Profile profile, UserResponse dto) {
        profile.setEmail(dto.getEmail());
        profile.setAddress(dto.getAddress());
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
    }

    public UserResponse convertToUserResponseFromUserRequest(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();

        userResponse.setFirstName(userRequest.getCity());
        userRequest.setCountry(userRequest.getCountry());
        userResponse.setEmail(userRequest.getEmail());

        return userResponse;
    }

    public UserRequest convertToUserRequestFromUserResponse(UserResponse userResponse) {
        UserRequest userRequest = new UserRequest();

        userRequest.setCountry(userResponse.getLastName());
        userRequest.setCity(userResponse.getFirstName());
        userRequest.setEmail(userResponse.getEmail());

        return userRequest;
    }
}
