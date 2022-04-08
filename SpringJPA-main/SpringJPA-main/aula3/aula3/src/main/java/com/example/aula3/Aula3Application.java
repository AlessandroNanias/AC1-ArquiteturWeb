package com.example.aula3;

import com.example.aula3.entity.Categorias;
import com.example.aula3.entity.Produtos;
import com.example.aula3.repository.CategoriaProdutoRepository;
import com.example.aula3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula3Application {

	@Bean
	public CommandLineRunner 
		init (@Autowired ProdutoRepository produtoReposiory,
				@Autowired CategoriaProdutoRepository categoriaProdutoRepository){
			return args ->{
				//Inserir categoria
				Categorias categoria = new Categorias(0, "Manga", "Quadrinho japones");
				categoriaProdutoRepository.inserir(categoria);

				//inserir Produto
				Produtos produto = new Produtos(0, "BERSERK", 2);
				//Setar o ID da categoria
				produto.setId_categoria(categoria);

				produtoReposiory.inserir(produto);	

			};
		}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}
