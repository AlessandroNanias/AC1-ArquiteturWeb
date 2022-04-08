package com.example.aula3.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.aula3.entity.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produtos inserir(Produtos produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Transactional
    public Produtos atualizar(Produtos produto){
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public Produtos remover(Produtos produto){
        entityManager.remove(produto);
        return produto;
    }

    @Transactional(readOnly = true)
    public List<Produtos> obterTodos() {
        return entityManager.createQuery("from Produtos",Produtos.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Produtos obterPorID(int id){
        String jpql = "select u from Produtos u where u.id=:id";
        TypedQuery<Produtos> query = entityManager.createQuery(jpql,Produtos.class);
        query.setParameter("id", + id );
        return query.getSingleResult();
    }
}
