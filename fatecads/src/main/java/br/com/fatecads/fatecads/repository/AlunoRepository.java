package br.com.fatecads.fatecads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatecads.fatecads.dto.AlunoTelefone;
import br.com.fatecads.fatecads.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    //Listar o nome de telefone dos alunos
    @Query("SELECT new br.com.fatecads.fatecads.dto.AlunoTelefone(a.nomeAluno, a.telAluno) from Aluno a")
    List<AlunoTelefone> buscarNomeETelefone();


}
