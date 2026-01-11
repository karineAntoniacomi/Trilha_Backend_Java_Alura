package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.service.AdocaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AdocaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private AdocaoService adocaoService;

    @Test
    void deveriaDevolverCodigo400ParaSolicitacaoDeAdocaoComErros() throws Exception {
        //ARRANGE
        String json = "{}";

        //ACT
        // performar uma requisição
        var response = mvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                // pega resposta da requisição
        ).andReturn().getResponse();

        //ASSERT
        Assertions.assertEquals(400, response.getStatus());
    }

    @Test
    void deveriaDevolverCodigo200ParaSolicitacaoDeAdocaoSemErros() throws Exception {
        //ARRANGE
        String json = """
                    {
                        "idPet": 1,
                        "idTutor": 1,
                        "motivo": "Motivo qualquer"
                    }
                """;

        //ACT
        // performar uma requisição
        var response = mvc.perform(
                post("/adocoes")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                // pega resposta da requisição
        ).andReturn().getResponse();

        //ASSERT
        Assertions.assertEquals(200, response.getStatus());
    }
}
