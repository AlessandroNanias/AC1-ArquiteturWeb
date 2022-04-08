package com.example.aula3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="tbl_categorias")
public class Categorias {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id_categoria;
private String cat_nome;
private String cat_descricao;

@OneToMany(mappedBy = "id_categoria")
private List<Produtos> produto;

public Categorias(int id_categoria, String cat_nome, String cat_descricao) {
    this.id_categoria = id_categoria;
    this.cat_nome = cat_nome;
    this.cat_descricao = cat_descricao;
}

public Categorias() {
}

public int getId_categoria() {
    return id_categoria;
}

public void setId_categoria(int id_categoria) {
    this.id_categoria = id_categoria;
}

public String getCat_nome() {
    return cat_nome;
}

public void setCat_nome(String cat_nome) {
    this.cat_nome = cat_nome;
}

public String getCat_descricao() {
    return cat_descricao;
}

public void setCat_descricao(String cat_descricao) {
    this.cat_descricao = cat_descricao;
}

public List<Produtos> getProduto() {
    return produto;
}

public void setProduto(List<Produtos> produto) {
    this.produto = produto;
}

}
