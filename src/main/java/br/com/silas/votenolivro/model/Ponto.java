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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "PONTOS")
public class Ponto implements Serializable {

	private static final long serialVersionUID = 8700929064624677226L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", nullable = false)
	private Usuario usuario;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	public Ponto() {
	}
	
	public Ponto(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Ponto(Integer usuario, Integer quantidade) {
		this.usuario = new Usuario(usuario);
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void aumentaUmPonto() {
		if (this.quantidade == null) {
			this.quantidade = 0;
		}
		this.quantidade = this.quantidade + 1;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(usuario)
				.append(quantidade)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Ponto) {
			Ponto other = (Ponto) obj;
			isEquals = new EqualsBuilder()
					.append(id, other.id)
					.append(usuario, other.usuario)
					.append(quantidade, other.quantidade)
					.isEquals();
		}
		return isEquals;
	}
}