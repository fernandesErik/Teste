package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.event.RecursocriadoEvent;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping // mapeamento do get para a url pessoas
	public List<Pessoa> listar() {
		return pessoaRepository.findAll(); // uma operação que ja foi implementada, significa selec * From pessoa
	}

	@Autowired // publicador de eventos para aplicação
	private ApplicationEventPublisher publisher;

	// parte responsalvel por pegar o post em formato jason e salvar no banco de
	// dados como objeto
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {

		Pessoa pessoaSalva = pessoaRepository.save(pessoa);

		publisher.publishEvent(new RecursocriadoEvent(this, response, pessoaSalva.getcodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);

	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloId(@PathVariable Long codigo) {
		Pessoa pessoa = pessoaRepository.findById(codigo).orElse(null);
		return (pessoa != null) ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		if (!pessoaRepository.existsById(codigo)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada");
		}

		pessoaRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {

		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);

		return ResponseEntity.ok(pessoaSalva);
	}

	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		pessoaService.atualizarPropriedadeAtivo(codigo, ativo);
	}
}
