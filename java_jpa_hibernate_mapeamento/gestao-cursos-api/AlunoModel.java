package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        public void create(Aluno aluno) {

            try {
                System.out.println("Iniciando a transação");
                em.getTransaction().begin();
                em.persist(aluno);
                em.getTransaction().commit();
                System.out.println("Aluno criado com sucesso !!!");
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
                e.printStackTrace();
            } finally {
                System.out.println("Finalizando a transação");
            }
        }


        public Aluno findById(Long id) {
        return em.find(Aluno.class, id);

    }

    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = new ArrayList<>();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Query consulta = em.createNativeQuery ("FROM" + Aluno.class.getSimpleName());
            alunos = consulta.getResultList();
            em.getTransaction().commit();
            System.out.println("Aluno encontrado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao encontrar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno1;

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            aluno1 = em.find(Aluno.class, aluno.getId());
            aluno1.setNomeCompleto(aluno.getNomeCompleto());
            aluno1.setMatricula(aluno.getMatricula());
            aluno1.setEmail(aluno.getEmail());
            em.merge(aluno1);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        em.find(Aluno.class, aluno);
        em.remove(aluno);
    }
}

