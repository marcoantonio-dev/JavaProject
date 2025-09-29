package br.com.fatecads.fatecads.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false, length = 40)
    private Long idDisciplina;

    @Column(nullable = false, length = 150)
    private String nomeDisciplina;
    
    @Column(nullable = false, length = 3)
    // chDisciplina = Carca Horária disciplina
    private int cargaHorariaDisciplina;

}
