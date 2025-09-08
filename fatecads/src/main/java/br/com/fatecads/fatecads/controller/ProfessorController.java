package br.com.fatecads.fatecads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.fatecads.fatecads.entity.Professor;
import br.com.fatecads.fatecads.entity.Graduacao;
import br.com.fatecads.fatecads.service.ProfessorService;
import br.com.fatecads.fatecads.service.GraduacaoService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private GraduacaoService graduacaoService;

    // Lista todos os professores
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        return "professor/listaProfessores";
    }

    // Formulário de criação de professor
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("professor", new Professor());
        List<Graduacao> graduacoes = graduacaoService.findAll();
        model.addAttribute("graduacoes", graduacoes);
        return "professor/formularioProfessor";
    }

    // Salva um novo professor ou atualiza um existente
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor) {
        professorService.save(professor);
        return "redirect:/professores/listar";
    }

    // Exclui um professor
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        professorService.deleteById(id);
        return "redirect:/professores/listar";
    }

    // Formulário de edição de professor
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        List<Graduacao> graduacoes = graduacaoService.findAll();
        model.addAttribute("graduacoes", graduacoes);
        return "professor/formularioProfessor";
    }
}
