package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Garante que o Mockito seja inicializado e execute os mocks durante o teste.
@ExtendWith(MockitoExtension.class)
class ValidacaoPetDisponivelTest {

    // pega o mock da linha de baixo e injeta no validador
    @InjectMocks
    private ValidacaoPetDisponivel validacao = new ValidacaoPetDisponivel();

    // Mock da dependencia do repository presente na classe
    @Mock
    private PetRepository petRepository;

    @Mock
    private Pet pet;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {

        // Arrange - dado que ao buscar o pet no BD e encontrou, retorne o pet
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);

        // Dado o cenario onde for chamado o petAdotado, deve retornar false (quando não lança erros e o pet está disponível para adoção)
        BDDMockito.given(pet.getAdotado()).willReturn(false);

        // Assert + Act - verifica cenário onde a exceção não deve ser lançada
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoPet() {

        // Arrange - dado que ao buscar o pet no BD e encontrou, retorne o pet
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);

        // Dado o cenario onde for chamado o petAdotado, deve retornar true (quando lança erros e o pet não está disponível para adoção)
        BDDMockito.given(pet.getAdotado()).willReturn(true);

        // Assert + Act - verifica cenário onde a exceção deve ser lançada
        Assertions.assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }
}