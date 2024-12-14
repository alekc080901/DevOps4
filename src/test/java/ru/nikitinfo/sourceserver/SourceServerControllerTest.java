package ru.nikitinfo.sourceserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SourceServerController.class)
class SourceServerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testController() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        SourceServerResponse responseObj = new ObjectMapper().readValue(response, SourceServerResponse.class);
        assertEquals(1, responseObj.id);
        assertEquals("Information from SourceServer", responseObj.payload);
    }
}