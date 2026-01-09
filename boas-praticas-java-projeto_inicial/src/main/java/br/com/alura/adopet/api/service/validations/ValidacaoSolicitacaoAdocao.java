package br.com.alura.adopet.api.service.validations;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitacaoAdocaoDto dto);
}
