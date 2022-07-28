package entities;


import javax.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String DDD;
    @Column
    private String numero;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Telefone() {

    }

    @Override
    public String toString() {
        return "Telefone{" + "id=" + id + ", ddd='" + DDD + '\'' + ", telefone='" + numero + '\'' + '}';
    }

    public Telefone(Long id, String DDD, String numero) {
        this.id = id;
        this.DDD = DDD;
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
