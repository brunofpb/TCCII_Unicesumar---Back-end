package br.com.apibruno.projeto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "solicitacao") //dentificação tabala banco
public class Solicitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotBlank (message = "O nome é Obrigatorio!")
	@Column(name = "nome", length = 50, nullable = true)
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
        //@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "DT", columnDefinition = "TIMESTAMP" , nullable = true)
	private Timestamp data;
	
	@Email (message = "Insira um email valido!")
	@NotBlank (message = "O email é Obrigatorio!")
	@Column(name = "email", length = 50, nullable = true)
	private String email;
	
	@NotBlank (message = "O telefone é Obrigatorio!")
	@Column(name = "telefone", length = 15, nullable = true)
	private String telefone;
	
	@NotBlank (message = "O setor é Obrigatorio!")
	@Column(name = "setor", length = 20, nullable = true)
	private String setor;
	
	@NotBlank (message = "A prioridade é Obrigatoria!")
	@Column(name = "prioridade", length = 15, nullable = true)
	private String prioridade;
	
	@NotBlank (message = "A Descrição da solicitação é Obrigatoria!")
	@Column(name = "desc_solicitacao", length = 10000, nullable = true)
	private String desc_solicitacao;
        
        
	@Column(name = "status", length = 20, nullable = true)
        private String status;
        
        
	@Column(name = "consideracao", length = 1000, nullable = true)
        private String consideracao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getDesc_solicitacao() {
		return desc_solicitacao;
	}
	public void setDesc_solicitacao(String desc_solicitacao) {
		this.desc_solicitacao = desc_solicitacao;
	}
        
        public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
        
        public String getConsideracao() {
		return consideracao;
	}
	public void setConsideracao(String consideracao) {
		this.consideracao = consideracao;
	}
	
}