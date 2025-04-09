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

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping // mapeamento do get para a url pessoas
	public List<Pessoa> listar() {
		return pessoaRepository.findAll(); // uma operação que ja foi implementada, significa selec * From pessoa
	}

	// parte responsalvel por pegar o post em formato jason e salvar no banco de
	// dados como objeto
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {

		Pessoa pessoaSalva = pessoaRepository.save(pessoa);

		// pegar a partir da requisição da uri atual
		// adicionar o codigo e adicionar o codigo na
		// uri, e alterar usando Seter em location com a
		// uri

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(pessoaSalva.getId())
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(pessoaSalva);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPeloId(@PathVariable Long id) {
	    Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
	    return (pessoa != null) ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}

	
	
}
