package br.com.erudio.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.models.Livro;


public class LivroMock {

	public Livro mockLivro() {
		return mockEntity(1);
	}
	
	
	public List<Livro> mockEntityList() {
		List<Livro> livros = new ArrayList<Livro>();

		for(int i = 0; i < 10; i++) {
			livros.add(mockEntity(i));
		}
				
		return livros;
	}
	
	
	public Livro mockEntity(Integer number) {
		
		Livro livro = new Livro();
		
		livro.setTitulo("Livro mock no " +  number);
		livro.setEditora("Editora mock " + number);
		livro.setAutores("Autor mock " + number);
		livro.setAno(2023);
		livro.setId(number);
		
		
		return livro;
		
	}
	
	
}
