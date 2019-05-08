package com.robert.user.rest.dto;

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
}
