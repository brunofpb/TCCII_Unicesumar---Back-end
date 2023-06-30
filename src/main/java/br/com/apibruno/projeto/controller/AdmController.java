package br.com.apibruno.projeto.controller;
import br.com.apibruno.projeto.model.Administracao;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.apibruno.projeto.service.AdmService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/login")
public class AdmController {
	
    public AdmService admService;
    	
	public AdmController(AdmService admService) {
		this.admService = admService;                
        }
	
	@GetMapping 
	public ResponseEntity <List<Administracao>> listaAdministracao() {
		return ResponseEntity.status(200).body(admService.ListarAdministracao());
	}
               
        @PostMapping
        public ResponseEntity<Administracao> validarSenha(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        boolean valid = admService.validarSenha(email, senha);
            if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        
        @PutMapping
	public ResponseEntity <Administracao> editarAdministracao (@Valid @RequestBody Administracao administracao) {
            return ResponseEntity.status(200).body(admService.editarAdministracao(administracao));
	}      
        
}

