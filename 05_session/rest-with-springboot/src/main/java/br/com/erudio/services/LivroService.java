package br.com.erudio.services;

import java.util.logging.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.models.Livro;
import br.com.erudio.repositories.LivroRepository;



@Service
public class LivroService {

	
	@Autowired
	private LivroRepository repository;
	
	private Logger logger = Logger.getLogger(LivroService.class.getName()); 
	
	
	public Livro findById(int id) {
		
		logger.info(">: buscando um livro");
		
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("<: Livro não encontrado"));
	}
	
	public List<Livro> findAll() {
		logger.info(">: buscando todos os livros");
		return repository.findAll();
	}
	
	public Livro create(Livro livro) {
		logger.info(">: salvando um novo livro");
		
		Livro newLivro = repository.save(livro);
		return newLivro;
	}
	
	public Livro update(Livro livro) {
		
		logger.info(">: Atualizando o livro");
		
		Livro entity = repository.findById(livro.getId()).orElseThrow(
				() -> new ResourceNotFoundException("<:Livro não encontrado"));
		
		entity.setTitulo(livro.getTitulo());
		entity.setEditora(livro.getEditora());
		entity.setAutores(livro.getAutores());
		entity.setAno(livro.getAno());
		
		repository.save(entity);
				
		return entity;
	}

	public void delete(int id) {
		
		logger.info(">: Deletando livro");
		
		Livro entity = this.findById(id);
		
		repository.delete(entity);
		
	}
	
	
	
}
