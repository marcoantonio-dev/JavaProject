package br.com.fatecads.fatecads.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(nullable = false, length = 40)
    private Integer idAluno;

    @Column(nullable = false, length = 40)
    private String nomeAluno;

    @Column(nullable = false, length = 40)
    private String endAluno;

    @Column(nullable = false, length = 11)
    private String telAluno;

    private Integer raAluno;

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setEndAluno(String endAluno) {
        this.endAluno = endAluno;
    }

    public void setTelAluno(String telAluno) {
        this.telAluno = telAluno;
    }

    public void setRaAluno(Integer raAluno) {
        this.raAluno = raAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getEndAluno() {
        return endAluno;
    }

    public String getTelAluno() {
        return telAluno;
    }

    public Integer getRaAluno() {
        return raAluno;
    }

    @ManyToOne
    @JoinColumn(name = "idCurso_fk")
    private Curso curso;
}
