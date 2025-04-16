package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Aluno;
import br.com.bpkedu.library_spring_webmvc.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/listar")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "alunos/listar";
    }

    @GetMapping("/{id:\\d+}")
    public String detalharAluno(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "alunos/detalhes";
    }

    @GetMapping("/novo")
    public String formularioNovoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/novo";
    }

    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos/listar";
    }

    @GetMapping("/editar/{id:\\d+}")
    public String formularioEditarAluno(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "alunos/editar";
    }

    @GetMapping("/deletar/{id:\\d+}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletar(id);
        return "redirect:/alunos/listar";
    }
}