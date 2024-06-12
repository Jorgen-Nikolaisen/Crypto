package controller;

import com.example.cryptographylibrary.controller.CryptoController;
import com.example.cryptographylibrary.service.CryptoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CryptoController.class)
@AutoConfigureMockMvc
public class CryptoControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CryptoService cryptoService;

    @Test
    public void testGenerateRSAKeyPair() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String mockKeyPair = "Public key: mockPublicKey\nPrivate key: mockPrivateKey";
        when(cryptoService.generateRSAKeyPair()).thenReturn(mockKeyPair);

        mockMvc.perform(get("/api/crypto/generate-rsa-keypair"))
                .andExpect(status().isOk())
                .andExpect(content().string(mockKeyPair));
    }

}
