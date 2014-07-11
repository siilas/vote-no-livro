package br.com.silas.votenolivro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "VOTOS")
public class Voto implements Serializable {

	private static final long serialVersionUID = 5756697763129726323L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public Integer id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LIVRO", nullable = false)
	public Livro livro;
	
	@Column(name = "QUANTIDADE")
	public Integer quantidade;

	public Voto() {
	}
	
	public Voto(Livro livro) {
		this.livro = livro;
	}
	
	public Voto(Integer livro, Integer quantidade) {
		this.livro = new Livro(livro);
		this.quantidade = quantidade;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void aumentaUmVoto() {
		if (this.quantidade == null) {
			this.quantidade = 0;
		}
		this.quantidade = this.quantidade + 1;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(livro)
				.append(quantidade)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Voto) {
			Voto other = (Voto) obj;
			isEquals = new EqualsBuilder()
					.append(id, other.id)
					.append(livro, other.livro)
					.append(quantidade, other.quantidade)
					.isEquals();
		}
		return isEquals;
	}
}