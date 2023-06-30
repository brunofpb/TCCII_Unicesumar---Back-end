package br.com.apibruno.projeto.service;
import br.com.apibruno.projeto.model.Administracao;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.apibruno.projeto.repository.IAdministracao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AdmService {
	
	private final IAdministracao repository;
        private final PasswordEncoder passwordEncoder;
	
	public AdmService (IAdministracao repository) {
		this.repository = repository;
                this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public List <Administracao> ListarAdministracao(){
		List <Administracao> lista = repository.findAll();
		return lista;
	}
	
	public Administracao criarAdministracao(Administracao administracao) {
                String encoder = this.passwordEncoder.encode(administracao.getSenha());
                administracao.setSenha(encoder);
		Administracao administracaoNova = repository.save(administracao);
		return administracaoNova;
		
	}        
 
	public Administracao editarAdministracao (Administracao administracao) {
                String encoder = this.passwordEncoder.encode(administracao.getSenha());
                administracao.setSenha(encoder);
		Administracao administracaoNova = repository.save(administracao);
		return administracaoNova;
		
	}	

        public boolean validarSenha(String email, String senha) {
                Administracao administracaoEncontrada = repository.findByEmail(email);
                if (administracaoEncontrada != null) {
                String senhaArmazenada = administracaoEncontrada.getSenha();
                boolean senhaValida = passwordEncoder.matches(senha, senhaArmazenada);
                return senhaValida;
        }
            return false;
        }
	
}