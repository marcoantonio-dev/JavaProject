package br.com.fatecads.fatecads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecads.fatecads.entity.Graduacao;
import br.com.fatecads.fatecads.repository.GraduacaoRepository;

@Service
public class GraduacaoService {

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    // Buscar todas as graduações
    public List<Graduacao> findAll() {
        return graduacaoRepository.findAll();
    }

    // Salvar ou atualizar uma graduação
    public Graduacao save(Graduacao graduacao) {
        return graduacaoRepository.save(graduacao);
    }

    // Excluir graduação por ID
    public void deleteById(Integer id) {
        graduacaoRepository.deleteById(id);
    }

    // Buscar graduação por ID
    public Graduacao findById(Integer id) {
        return graduacaoRepository.findById(id).orElse(null);
    }
}
