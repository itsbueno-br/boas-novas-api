package br.com.boasnovas;

import jakarta.validation.constraints.NotBlank;

public class ContatoDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O assunto é obrigatório")
    private String assunto;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    // Construtor vazio (necessário para o Spring converter o JSON do site)
    public ContatoDTO() {
    }

    public ContatoDTO(String nome, String telefone, String assunto, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}