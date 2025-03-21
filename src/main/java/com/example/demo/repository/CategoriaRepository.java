package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;
//Essa interface já tem métodos prontos para CRUD (Criar, Ler, Atualizar e Deletar) sem precisar implementar nada
/*categoriaRepository.findAll(); // Lista todas as categorias
categoriaRepository.findById(1L); // Busca uma categoria pelo ID
categoriaRepository.save(new Categoria()); // Salva uma nova categoria
categoriaRepository.deleteById(1L); // Deleta uma categoria pelo ID*/

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
