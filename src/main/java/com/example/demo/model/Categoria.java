package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Uma entidade é um modelo que liga o Java ao banco de dados, permitindo salvar, buscar e modificar registros sem precisar escrever SQL manualmente

@Entity     //  Indica que a classe será mapeada para uma tabela no banco.
@Table(name = "categoria") // Especifica que essa entidade será salva na tabela chamada "categoria".
public class Categoria { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // Definem que o atributo codigo é a chave primária e será gerado automaticamente pelo banco.
	private Long codigo;
	
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	 //hashCode() → Gera um número único baseado no codigo, útil para coleções como HashSet e HashMap.
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
     // equals() → Diz que dois objetos são iguais se tiverem o mesmo codigo.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

}
