package br.com.fatecads.fatecads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecads.fatecads.entity.Graduacao;
import br.com.fatecads.fatecads.service.GraduacaoService;

@Controller
@RequestMapping("/graduacoes")
public class GraduacaoController {

    @Autowired
    private GraduacaoService graduacaoService;

    // Lista todas as graduações
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Graduacao> graduacoes = graduacaoService.findAll();
        model.addAttribute("graduacoes", graduacoes);
        return "graduacao/listaGraduacoes";
    }

    // Formulário de criação de graduação
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("graduacao", new Graduacao());
        return "graduacao/formularioGraduacao";
    }

    // Salva nova graduação ou atualiza existente
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Graduacao graduacao) {
        graduacaoService.save(graduacao);
        return "redirect:/graduacoes/listar";
    }

    // Exclui uma graduação
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        graduacaoService.deleteById(id);
        return "redirect:/graduacoes/listar";
    }

    // Formulário de edição de graduação
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Graduacao graduacao = graduacaoService.findById(id);
        model.addAttribute("graduacao", graduacao);
        return "graduacao/formularioGraduacao";
    }
}
