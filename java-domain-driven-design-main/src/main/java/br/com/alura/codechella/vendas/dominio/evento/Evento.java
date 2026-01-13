package br.com.alura.codechella.vendas.dominio.evento;

import br.com.alura.codechella.vendas.dominio.ingresso.TipoIngresso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Evento - aggregate root
public class Evento {

    private UUID uuid;

    private Categoria categoria;

    private String descricao;

    private LocalDateTime data;

    // value object - objeto de valor que não existe sem a entidade principal
    private Endereco endereco;

    // agregado - TipoIngresso está agregado a evento
    private List<TipoIngresso> tipoIngressos = new ArrayList<>();

    public Evento(Categoria categoria, String descricao, LocalDateTime data, Endereco endereco) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
        this.endereco = endereco;
        
        gerarIdentificadorUnico();
    }

    private Evento() {
        // Construtor privado para garantir a construção apenas através do Builder
    }

    public static class Builder {
        private Evento evento;

        public Builder() {
            evento = new Evento();
        }

        public Builder comCategoria(Categoria categoria) {
            evento.categoria = categoria;
            return this;
        }

        public Builder comDescricao(String descricao) {
            evento.descricao = descricao;
            return this;
        }

        public Builder comEndereco(String cep, Integer numero, String complemento) {
            Endereco endereco = new Endereco(cep, numero, complemento);
            evento.endereco = endereco;
            return this;
        }

        public Builder comData(LocalDateTime data) {
            evento.data = data;
            return this;
        }

        public Evento build() {
            evento.gerarIdentificadorUnico();
            return evento;
        }
    }

    private void gerarIdentificadorUnico() {
        this.uuid = UUID.randomUUID();
    }

    public void incluiNovoTipoDeIngressoAoEvento(TipoIngresso tipoIngresso) {
        this.tipoIngressos.add(tipoIngresso);
    }

    public void aumentaNumeroDeIngressosPorTipo() {
        //implementar aqui
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<TipoIngresso> getTipoIngressos() {
        return tipoIngressos;
    }
}
