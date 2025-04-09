package com.example.demo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController // Indica que essa classe é um controlador REST, ou seja, ela recebe e responde
				// requisições HTTP (como GET, POST, PUT, DELETE).

@RequestMapping("/categorias") // Define que todas as requisições que começarem com /categorias serão tratadas
								// por essa classe.

//Essa classe será usada para criar a API REST da Categoria, permitindo acessar e gerenciar categorias via requisições HTTP. 
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping // Retorna todas as categorias
	public List<Categoria> listar() {

		return categoriaRepository.findAll();

		
	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid  @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriasalva = categoriaRepository.save(categoria);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(categoriasalva.getCodigo()).toUri(); // pegar a partir da requisição da uri atual
																		// adicionar o codigo e adicionar o codigo na
																		// uri, e alterar usando Seter em location com a
																		// uri
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(categoriasalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
	    Categoria categoria = categoriaRepository.findById(codigo).orElse(null);
	    return (categoria != null) ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}


}
