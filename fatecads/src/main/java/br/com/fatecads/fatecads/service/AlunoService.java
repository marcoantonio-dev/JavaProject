package br.com.fatecads.fatecads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecads.fatecads.dto.AlunoTelefone;
import br.com.fatecads.fatecads.entity.Aluno;
import br.com.fatecads.fatecads.repository.AlunoRepository;

@Service
public class AlunoService {
    // Injeção de depêndencia do repositório de alunos
    @Autowired
    private AlunoRepository alunoRepository;

    // Método para buscar todos os alunos

    public List<Aluno> findAll() {
        // Retorna todos os alunos
        return alunoRepository.findAll();

    }

    // metodo para salvar um aluno
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // metodo para excluir um aluno pelo id
    public void deleteById(Integer id) {
        alunoRepository.deleteById(id);
    }

    // metodo para buscar um aluno pelo id
    public Aluno findById(Integer id){
    //retorna o aluno com o id especificado ou null se nao existir 
    return alunoRepository.findById(id).orElse(null);
    }

    public List<AlunoTelefone> buscarNomeETelefone(){
        return alunoRepository.buscarNomeETelefone();
    }

}
