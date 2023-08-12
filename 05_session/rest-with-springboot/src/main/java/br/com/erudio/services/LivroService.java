package br.com.erudio.services;

import java.util.logging.Logger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.RequiredObjectIsNullExceptions;
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
		
		if (livro == null) throw new RequiredObjectIsNullExceptions();
		
		Livro newLivro = repository.save(livro);
		return newLivro;
	}
	
	public Livro update(Livro livro) {
		
		logger.info(">: Atualizando o livro");
		
		if (livro == null) throw new RequiredObjectIsNullExceptions();
		
		//Livro entity = repository.findById(livro.getId()).orElseThrow(
			//	() -> new ResourceNotFoundException("<:Livro não encontrado"));
		
		Optional<Livro> entity = repository.findById(livro.getId());
		
		if (entity.isEmpty()) {
			throw new ResourceNotFoundException("<:Livro não encontrado");
		}
		
		Livro model = entity.get();
		
		model.setTitulo(livro.getTitulo());
		model.setEditora(livro.getEditora());
		model.setAutores(livro.getAutores());
		model.setAno(livro.getAno());
		
		repository.save(model);
				
		return model;
	}

	public void delete(int id) {
		
		logger.info(">: Deletando livro");
		
		Livro entity = this.findById(id);
		
		repository.delete(entity);
		
	}
	
	
	
}
