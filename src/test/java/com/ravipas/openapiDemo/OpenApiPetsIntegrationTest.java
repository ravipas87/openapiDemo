package com.ravipas.openapiDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenapiDemoApplication.class)
@AutoConfigureMockMvc
public class OpenApiPetsIntegrationTest {

    private static final String PETS_PATH = "/pets/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenReadAll_thenStatusIsOk() throws Exception {
        // now we have the overrided response
        this.mockMvc.perform(get(PETS_PATH))
                .andExpect(status().isOk());
    }

    @Test
    public void whenReadOne_thenStatusIsNotImplemented() throws Exception {
        this.mockMvc.perform(get(PETS_PATH + 1))
                .andExpect(status().isNotImplemented());
    }
}