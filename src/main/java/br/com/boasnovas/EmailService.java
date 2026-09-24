package br.com.boasnovas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender enviadorDeEmail;

    public void enviarEmailContato(ContatoDTO dto) {
        // Quem vai receber todas as mensagens enviadas pelo site
        String emailDestino = "boasnovas.ltda1@gmail.com";

        // Monta o assunto do e-mail
        String assunto = "Novo Contato do Site: " + dto.getAssunto();

        // Monta o corpo/texto do e-mail com as informações organizadas
        String corpo = "Você recebeu uma nova mensagem enviada pelo formulário do site:\n\n"
                + "Nome: " + dto.getNome() + "\n"
                + "Telefone/WhatsApp: " + dto.getTelefone() + "\n"
                + "Assunto: " + dto.getAssunto() + "\n\n"
                + "Mensagem/Descrição:\n"
                + dto.getDescricao();

        // Prepara a mensagem
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(emailDestino);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);

        // Dispara o e-mail
        enviadorDeEmail.send(mensagem);
    }
}