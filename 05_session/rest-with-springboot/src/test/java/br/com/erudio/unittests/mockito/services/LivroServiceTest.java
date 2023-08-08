package br.com.erudio.unittests.mockito.services;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.erudio.exceptions.RequiredObjectIsNullExceptions;
import br.com.erudio.models.Livro;
import br.com.erudio.repositories.LivroRepository;
import br.com.erudio.services.LivroService;
import br.com.erudio.unittests.mapper.mocks.LivroMock;




@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

	LivroMock livroMock;
	
	@InjectMocks
	private LivroService service;
	
	@Mock
	LivroRepository repository;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		livroMock = new LivroMock();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Testando LivroService.FindById()")
	void testFindById() {
		Livro livro = livroMock.mockEntity(1);
		
		when(repository.findById(1)).thenReturn(Optional.of(livro));
		
		var result = service.findById(1);
		
		assertAll("Deve retornar um  livro válido", 
				() -> assertNotNull(result),
				() -> assertEquals("Livro mock no 1", result.getTitulo()),
				() -> assertEquals("Editora mock 1", result.getEditora()),
				() -> assertEquals("Autor mock 1", result.getAutores()),
				() -> assertEquals(2023, result.getAno())
			);
	}
	
	@Test 
	@DisplayName("Testando LivroService.create()")
	void testcreate() { 
		Livro livro = livroMock.mockEntity(1);
		
		when(repository.save(livro)).thenReturn(livro);
		
		var result = service.create(livro);
		
		assertAll("Deve retornar um  livro válido", 
				() -> assertNotNull(result),
				() -> assertEquals("Livro mock no 1", result.getTitulo()),
				() -> assertEquals("Editora mock 1", result.getEditora()),
				() -> assertEquals("Autor mock 1", result.getAutores()),
				() -> assertEquals(2023, result.getAno())
			);
	}
	
	@Test 
	@DisplayName("Testando livro null")
	void testcreateWithNullLivro() { 
		
		Exception exception = assertThrows(RequiredObjectIsNullExceptions.class, 
				() -> service.create(null));
		
		String expectedMessage = "); Its is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
		
	}
	
	
	@Test
	@DisplayName("Testando Service.update()")
	void testUpdate() 
	{ 
		Livro livro = livroMock.mockEntity(1);
		
		
		when(repository.findById(1)).thenReturn(Optional.of(livro));
		when(repository.save(livro)).thenReturn(livro);
		
					
		var result = service.update(livro);
		
		assertAll("Deve retornar um  livro válido", 
				() -> assertNotNull(result),
				() -> assertEquals("Livro mock no 1", result.getTitulo()),
				() -> assertEquals("Editora mock 1", result.getEditora()),
				() -> assertEquals("Autor mock 1", result.getAutores()),
				() -> assertEquals(2023, result.getAno())
			);
		
	}
	
	@Test 
	@DisplayName("Testando atualizar livro null")
	void testUpdateWithNullLivro() { 
		
		Exception exception = assertThrows(RequiredObjectIsNullExceptions.class, 
				() -> service.update(null));
		
		String expectedMessage = "); Its is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		
		
	}
	

	@Test 
	@DisplayName("Testando LivroService.delete()")
	void testDelete() { 
		
		Livro livro = livroMock.mockEntity(1);
				
		when(repository.findById(1)).thenReturn(Optional.of(livro));
		
		service.delete(1);
		
	}
	
	 @Test 
	 void testFindAll() { 
		 
		 List<Livro> livros = livroMock.mockEntityList();
		 
		 when(repository.findAll()).thenReturn(livros);
		 
		 List<Livro> result = service.findAll();
		 
		 assertNotNull(result);
		 assertEquals(10, result.size());
		 
		 int[] indexes = {1,7,10,11};
		 
		 for (int i = 0; i < indexes.length; i++) {
			 
			 Livro book = result.get(i);
			 
			 assertAll("Deve retornar um  livro válido", 
						() -> assertNotNull(book),
						() -> assertEquals("Livro mock no " + book.getId(), book.getTitulo()),
						() -> assertEquals("Editora mock " + book.getId(), book.getEditora()),
						() -> assertEquals("Autor mock " + book.getId(), book.getAutores()),
						() -> assertEquals(2023, book.getAno())
					);
		 }
		 
		 
		 
		 
		// assertArrayEquals(livros, result);
		 
		 
		  
	}
	 
	
	/*
	 * @Test void testFindAll() { fail("Not yet implemented"); }
	 * 
	
	
	
	
	 * @Test void testDelete() { fail("Not yet implemented"); }
	 */

}
