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

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5337923985051590441L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "NOME", length = 60, nullable = false)
	private String nome;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "EMAIL", length = 50, nullable = false, unique = true)
	private String email;

	public Usuario() {
	}
	
	public Usuario(Integer id) {
		this.id = id;
	}
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(nome)
				.append(email)
				.toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Usuario) {
			Usuario other = (Usuario) obj;
			isEquals = new EqualsBuilder()
					.append(id, other.id)
					.append(nome, other.nome)
					.append(email, other.email)
					.isEquals();
		}
		return isEquals;
	}
	
	public void copyValuesFrom(Usuario other) {
		this.setId(other.getId());
		this.setNome(other.getNome());
		this.setEmail(other.getEmail());
	}
}