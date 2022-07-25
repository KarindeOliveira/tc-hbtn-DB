package models;

import entities.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class ProdutoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
    EntityManager em = emf.createEntityManager();

    public void create(Produto p) {

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public List<Produto> findAll() {
        List<Produto> pessoas = new ArrayList<Produto>();
        pessoas = em.createQuery("FROM " + Produto.class.getSimpleName()).getResultList();
        return pessoas;

    }

    public Produto findById(Produto p) {
        return em.find(Produto.class, p.getId());
    }

    public void update(Produto p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void delete(Produto p) {
        try {
            Produto produto = findById(p);
            remove(produto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void remove(Produto produto) {
        try {
            em.getTransaction().begin();
            produto = em.find(Produto.class, produto.getId());
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}