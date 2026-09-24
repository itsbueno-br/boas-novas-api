package br.com.boasnovas;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contato")
// Permite requisições locais do navegador durante o desenvolvimento
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", "http://localhost:8080", "*"})
public class ContatoController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> enviarContato(@Valid @RequestBody ContatoDTO dto) {
        try {
            emailService.enviarEmailContato(dto);
            return ResponseEntity.ok("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}