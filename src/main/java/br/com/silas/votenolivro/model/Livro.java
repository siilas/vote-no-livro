package br.com.silas.votenolivro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;

import br.com.silas.votenolivro.enums.GeneroEnum;

@Entity
@Table(name = "LIVROS")
public class Livro implements Serializable {

	private static final long serialVersionUID = -953836441144964828L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@NotNull
	@Type(type = "br.com.silas.votenolivro.usertype.GeneroUserType")
	@Column(name = "GENERO", nullable = false)
	private GeneroEnum genero;
	
	@Size(max = 100)
	@Column(name = "DESCRICAO", length = 100)
	private String descricao;
	
	public Livro() {
	}

	public Livro(Integer id) {
		this.id = id;
	}
	
	public Livro(String nome, GeneroEnum genero) {
		this.nome = nome;
		this.genero = genero;
	}
	
	public Livro(String nome, GeneroEnum genero, String descricao) {
		this.nome = nome;
		this.genero = genero;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(nome)
				.append(genero)
				.append(descricao)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Livro) {
			Livro other = (Livro) obj;
			isEquals = new EqualsBuilder()
					.append(id, other.id)
					.append(nome, other.nome)
					.append(genero, other.genero)
					.append(descricao, other.descricao)
					.isEquals();
		}
		return isEquals;
	}
}