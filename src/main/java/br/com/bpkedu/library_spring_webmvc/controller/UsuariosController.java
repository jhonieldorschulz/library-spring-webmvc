package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioService livroService;

    @GetMapping("/listar")
    public String listarLivros(Model model) {
        model.addAttribute("usuarios", UsuarioService.listarTodos());
        return "autores/listar";
    }

    @GetMapping("/{id:\\d+}")
    public String detalharUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuarios", UsuarioService.buscarPorId(id));
        return "autores/detalhar";
    }

    @GetMapping("/novo")
    public String formularioNovoUsuarios(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "autores/novo";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        UsuarioService.salvar(usuario);
        return "redirect:/autores/listar";
    }

    @GetMapping("/editar/{id:\\d+}")
    public String formularioEditarUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", UsuarioService.buscarPorId(id));
        return "autores/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        usuario.setId(id); // Garante que o ID do livro seja o mesmo da URL
        UsuarioService.salvar(usuario); // Atualiza o livro no banco de dados
        return "redirect:/autores/listar"; // Redireciona para a listagem de livros
    }



    @GetMapping("/deletar/{id:\\d+}")
    public String deletarUsuario(@PathVariable Long id) {
        UsuarioService.deletar(id);
        return "redirect:/autores/listar";
    }
}