package br.com.bpkedu.library_spring_webmvc.dto;

import br.com.bpkedu.library_spring_webmvc.domain.Usuario;

public class UsuarioDTO {

    private String nome;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toUsuario(UsuarioDTO usuarioDTO){
        return new Usuario(
                this.nome,
                this.senha
        );
    }
}
