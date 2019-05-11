package com.robert.user.rest.dto;

import com.robert.user.domain.User;

public class UserMapper {

    public UserResponse convertToUserResponseFromUserRequest(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();

        userResponse.setCity(userRequest.getCity());
        userRequest.setCountry(userRequest.getCountry());
        userResponse.setEmail(userRequest.getEmail());

        return userResponse;
    }

    public UserRequest convertToUserRequestFromUserResponse(UserResponse userResponse) {
        UserRequest userRequest = new UserRequest();

        userRequest.setCountry(userResponse.getCountry());
        userRequest.setCity(userResponse.getCity());
        userRequest.setEmail(userResponse.getEmail());

        return userRequest;
    }

    // TODO : move this to a mapper
    public static void map(User user, UserResponse dto) {
        user.setUsername(dto.getCity());
        user.setPassword(dto.getCountry());
        user.setEmail(dto.getEmail());
    }
}
