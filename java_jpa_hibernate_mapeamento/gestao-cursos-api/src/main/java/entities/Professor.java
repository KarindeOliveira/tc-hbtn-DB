package entities;


import javax.persistence.*;

@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nomeCompleto;
    @Column
    private String matricula;
    @Column
    private String email;

    public Professor(Long id, String nomeCompleto, String matricula, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.email = email;
    }

    public Professor() {

    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nomecompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
