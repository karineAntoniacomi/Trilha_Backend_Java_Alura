package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    // o MedicoRepository foi injetado no MedicoController usando a anotação @Autowired, permitindo que o controller utilize os métodos do repository para salvar os dados dos médicos
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    // anotação para permitir atualizações/inserções no BD
    @Transactional
    // @Valid : anotação para o Spring disparar o processo de validação do Bean Validation
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        // pegar o repository e persistir no BD
        // converter o DTO para um objeto do tipo médico / entidade JPA
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        // return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();
        // page devolve a lista de médicos e a paginação
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        // repository acessa o BD e carrega o Id que chega pelo dto
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}") // Parâmetro dinâmico, na função é indicado pela anotação que indica que é uma variável do caminho da url
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
