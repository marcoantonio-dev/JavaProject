package br.com.fatecads.fatecads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecads.fatecads.entity.Aluno;
import br.com.fatecads.fatecads.entity.Curso;
import br.com.fatecads.fatecads.service.AlunoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fatecads.fatecads.service.CursoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    // Método para listar todos os alunos
    @GetMapping("/listar")
    public String listar(Model model) {
        // Buscar todos os alunos
        List<Aluno> alunos = alunoService.findAll();
        // Adiciona os alunos
        model.addAttribute("alunos", alunos);
        // Retorna a página de lista de alunos
        return "aluno/listaAlunos";
    }

    // Método para abrir o formulario de criacao de alunos
    @GetMapping("/criar")
    public String criarForm(Model model) {
        // adiciona um novo aluno
        model.addAttribute("aluno", new Aluno());
        // Busca todos os cursos
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        // retorna a pagina do formulario de alunos
        return "aluno/formularioAluno";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        // salvar o aluno
        alunoService.save(aluno);
        // redireciona para a lista de alunos
        return "redirect:/alunos/listar";
    }

    // metodo para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }

    // metodo para abrir o formulario de edição de aluno
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        // busca o aluno pelo id
        Aluno aluno = alunoService.findById(id);
        // adiciona o aluno ao modelo
        model.addAttribute("aluno", aluno);
        // Busca todos os cursos
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        // retorna a pagina do formulario de aluno
        return "aluno/formularioAluno";
    }

}
