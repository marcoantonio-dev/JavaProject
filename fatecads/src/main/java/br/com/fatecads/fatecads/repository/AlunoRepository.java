package br.com.fatecads.fatecads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fatecads.fatecads.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Object fatecads = null;
}
