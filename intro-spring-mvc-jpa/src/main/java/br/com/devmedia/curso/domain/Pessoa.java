package br.com.devmedia.curso.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@NotNull(message = "O campo 'nome' é requerido")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@NotBlank
	@NotNull(message = "O campo 'sobrenome' é requerido")
	@Size(min = 5, max = 50, message = "O campo 'sobrenome' requerido no mínimo {min} e no máximo {max} caracteres " )
	@Column(name = "sobrenome", length = 50, nullable = false)
	private String sobrenome;
	
	@NotBlank
	@Column(name = "endereco", length = 50, nullable = false)
	@NotNull(message = "O campo 'endereco' é requerido")
	private String endereco;
	
	@Deprecated
	public Pessoa() {
		
	}
	
	public Pessoa(long id, String nome, String sobrenome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
	}



	public Pessoa(String nome, String sobrenome, String endereco) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", endereco=" + endereco + "]";
	}
	

}
