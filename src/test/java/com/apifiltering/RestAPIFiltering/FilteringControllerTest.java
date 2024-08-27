package com.apifiltering.RestAPIFiltering;


import com.apifiltering.RestAPIFiltering.controller.FilteringController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(FilteringController.class)
public class FilteringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;  // To convert objects to JSON (optional)

    @BeforeEach
    void setUp() {
        // This method runs before each test case
    }

    @Test
    public void testFiltering() throws Exception {
        // Perform a GET request to the /filtering endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/filtering")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").value("Paras Bagga"))
                .andExpect(jsonPath("$.city").value("Gurgaon"))
                .andExpect(jsonPath("$.mobile").doesNotExist());
    }

    @Test
    public void testFilteringList() throws Exception {
        // Perform a GET request to the /filtering-list endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/filtering-list")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].name").value("Paras Bagga"))
                .andExpect(jsonPath("$[0].mobile").value("8437861802"))
                .andExpect(jsonPath("$[0].city").doesNotExist())
                .andExpect(jsonPath("$[1].name").value("Twinkle Mahajan"))
                .andExpect(jsonPath("$[1].mobile").value("9000001234"))
                .andExpect(jsonPath("$[1].city").doesNotExist())
                .andExpect(jsonPath("$[2].name").value("Aarushi Mahajan"))
                .andExpect(jsonPath("$[2].mobile").value("9999991234"))
                .andExpect(jsonPath("$[2].city").doesNotExist());
    }
}

