package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    private Long id;
    @Column
    private String nome;
    @Column
    private String sigla;

    @ManyToMany
    @JoinTable(name = "curso-aluno", joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"))
    private List<Aluno> alunos = new ArrayList<>();

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "professor_id")
     private Professor professor;

     @OneToOne
     @JoinColumn(name = "material_id", referencedColumnName = "id")
     private MaterialCurso material;


    public Curso(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Curso() {

    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public MaterialCurso getMaterial() {
        return material;
    }

    public void setMaterial(MaterialCurso material) {
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
