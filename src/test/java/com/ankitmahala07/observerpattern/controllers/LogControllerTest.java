package com.ankitmahala07.observerpattern.controllers;

import com.ankitmahala07.observerpattern.context.LogContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateLog() throws Exception {
        /*
            Note: No asserts added since we are directly using the Bean of logContext and not the Mock Instance
                  so our validation is only that we were successfully able to invoke the post method and not
                  precisely that we were able to invoke the exact log methods of each observer.
         */

        String logMessage = "Test log message";

        mockMvc.perform(post("/logs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(logMessage))
                .andExpect(status().isOk());
    }
}