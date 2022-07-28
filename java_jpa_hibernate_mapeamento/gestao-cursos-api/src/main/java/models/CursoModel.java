package models;

import entities.Aluno;
import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {

    EntityManager em;

    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        return em.find(Curso.class, id);

    }

    public List<Curso> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        List<Curso> cursos = new ArrayList<>();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Query consulta = em.createNativeQuery ("FROM" + Aluno.class.getSimpleName());
            cursos = consulta.getResultList();
            em.getTransaction().commit();
            System.out.println("Curso encontrado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao encontrar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return cursos;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso1;

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            curso1 = em.find(Curso.class, curso.getId());
            curso1.setNome(curso.getNome());
            curso1.setSigla(curso.getSigla());
            curso1.setId(curso.getId());
            em.merge(curso1);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        em.find(Curso.class, curso);
        em.remove(curso);
    }
}
