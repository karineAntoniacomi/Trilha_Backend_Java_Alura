package br.com.alura.codechella.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity getCpf(String cpf);
    UsuarioEntity getNome(String nome);
    UsuarioEntity getNascimento(LocalDate nascimento);
    UsuarioEntity getEmail(String email);
}
