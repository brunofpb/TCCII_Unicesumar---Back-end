package br.com.apibruno.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.apibruno.projeto.model.Solicitacao;
import br.com.apibruno.projeto.repository.ISolicitacao;


@Service
public class SolicitacaoService {
	
	private final ISolicitacao repository;
	
	public SolicitacaoService (ISolicitacao repository) {
		this.repository = repository;
	}


	public List <Solicitacao> ListarSolicitacao(){
		List <Solicitacao> lista = repository.findAll();
		return lista;
	}
	
	public Solicitacao criarSolicitacao (Solicitacao solicitacao) {
		Solicitacao solicitacaoNova = repository.save(solicitacao);
		return solicitacaoNova;
		
	}

	public Solicitacao editarSolicitacao (Solicitacao solicitacao) {
		Solicitacao solicitacaoNova = repository.save(solicitacao);
		return solicitacaoNova;
		
	}
	
	public Boolean excluirSolicitacao (Integer id) {
		repository.deleteById(id);
		return true;
		
	}
	
}
