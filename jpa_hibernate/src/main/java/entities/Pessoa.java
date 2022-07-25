package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {


   @Id
   private int id;

   @Column
   private String nome;
   @Column
   private String email;
   @Column
   private int idade;
   @Column
   private int cpf;
   @Column
   private int data_de_nascimento;


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getIdade() {
      return idade;
   }

   public void setIdade(int idade) {
      this.idade = idade;
   }

   public int getCpf() {
      return cpf;
   }

   public void setCpf(int cpf) {
      this.cpf = cpf;
   }

   public int getData_de_nascimento() {
      return data_de_nascimento;
   }

   public void setData_de_nascimento(int data_de_nascimento) {
      this.data_de_nascimento = data_de_nascimento;
   }
}
