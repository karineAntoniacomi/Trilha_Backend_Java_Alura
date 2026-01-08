package br.com.alura.screenmatch.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private Integer totalTemporadas;

    private Double avaliacao;

    @Enumerated(EnumType.STRING)
    private Categoria genero;

    private String atores;

    private String poster;

    private String sinopse;

    // ignora temporariamente e não salva no banco este atributo
    @Transient
    private List<Episodio> episodios = new ArrayList<>();

    public Serie() {}

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        // OptionalDouble tenta converter o valor em double, caso falhe orEllse atribui zero
        this.avaliacao = (dadosSerie.avaliacao() != null &&
                !dadosSerie.avaliacao().equalsIgnoreCase("N/A"))
                ? Double.parseDouble(dadosSerie.avaliacao())
                : 0.0;
        this.genero = Optional.ofNullable(dadosSerie.genero())
                .map(g -> g.split(",")[0].trim())
                .map(Categoria::fromString)
                .orElse(null);
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        // this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse().trim());
//        this.sinopse = Optional.ofNullable(dadosSerie.sinopse())
//                .map(ConsultaMyMemory::obterTraducao)
//                .map(String::trim)
//                .orElse("Sinopse não disponível");
        this.sinopse = Optional.ofNullable(dadosSerie.sinopse())
                .orElse("Sinopse não disponível");

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'';
    }
}
