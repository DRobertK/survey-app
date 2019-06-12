package com.robert.users;

import com.robert.user.UserService;
import com.robert.user.domain.Profile;
import com.robert.user.rest.UserController;
import com.robert.util.UserFactory;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    public void givenListWithOneUser_whenGetUsers_shouldReturnOk() throws Exception {
        List<Profile> profiles = Collections.singletonList(UserFactory.createFullUser());
        Mockito.when(controller.findAll()).thenReturn(profiles);

        mockMvc.perform(get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", Matchers.is("gigi")));

        Mockito.verify(userService, Mockito.times(1)).findAll();
    }

    // TODO: unit test the controller methods
//    @Test
//    public void givenIdUser_whenGetUserById_shouldReturnUser(Long id){
//       userService.findById(id);
//      Mockito.verify(userService.findById(id));
//    }
}