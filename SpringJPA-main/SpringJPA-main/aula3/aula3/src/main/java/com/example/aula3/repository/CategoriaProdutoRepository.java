package com.example.aula3.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.aula3.entity.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categorias inserir(Categorias categoria){
        entityManager.persist(categoria);
        return categoria;
    }
}
