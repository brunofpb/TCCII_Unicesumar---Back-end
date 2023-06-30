package br.com.apibruno.projeto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apibruno.projeto.model.Solicitacao;

public interface ISolicitacao extends JpaRepository<Solicitacao, Integer>{

}
