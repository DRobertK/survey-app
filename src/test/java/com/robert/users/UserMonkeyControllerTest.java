package com.robert.users;

import com.robert.user.UserMonkey;
import com.robert.user.UserMonkeyController;
import com.robert.user.UserMonkeyService;
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

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class UserMonkeyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserMonkeyService userMonkeyService;

    @InjectMocks
    private UserMonkeyController controller;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    public void givenListWithOneUser_whenGetUsers_shouldReturnOk() throws Exception {
        List<UserMonkey> users = Arrays.asList(new UserMonkey("gigi", "san",
                "gigi@gmail.com", "bucharest", "romania"));
        Mockito.when(controller.findAll()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", Matchers.is("gigi")));

        Mockito.verify(userMonkeyService, Mockito.times(1)).findAll();
    }

    // TODO: unit test the controller methods
}