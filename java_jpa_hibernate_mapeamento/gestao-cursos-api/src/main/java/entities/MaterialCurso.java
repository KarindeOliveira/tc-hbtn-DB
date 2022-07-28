package entities;

import javax.persistence.*;

@Entity
@Table(name = "MaterialCurso")
public class MaterialCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String url;
    @OneToOne(mappedBy = "materialCurso")
    private Curso curso;

    public MaterialCurso(Long id, String url, Curso curso) {
        this.id = id;
        this.url = url;
        this.curso = curso;
    }

    public MaterialCurso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MaterialCurso(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "MaterialCurso{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", curso=" +  curso +
                '}';
    }
}
