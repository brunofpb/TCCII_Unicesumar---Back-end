package br.com.apibruno.projeto.repository;

import br.com.apibruno.projeto.model.Administracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdministracao extends JpaRepository<Administracao, Long> {
    Administracao findByEmail(String email);
}
