package br.com.erudio.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titulo", nullable = false, length = 40)
	private String titulo;
	
	@Column(name = "editora", nullable = true, length = 30)
	private String editora;
	
	@Column(name = "autores", nullable = true, length = 40)	
	private String autores;
	
	@Column(name = "ano", nullable = true)
	private int ano;
	
	public Livro() {}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, autores, editora, id, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return ano == other.ano && Objects.equals(autores, other.autores) && Objects.equals(editora, other.editora)
				&& id == other.id && Objects.equals(titulo, other.titulo);
	}
	
	
	
	
	
	
	
	
	
}
