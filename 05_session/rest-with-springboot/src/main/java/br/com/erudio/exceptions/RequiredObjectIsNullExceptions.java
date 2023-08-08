package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RequiredObjectIsNullExceptions(String ex) {
		super(ex);
	}
	
	public RequiredObjectIsNullExceptions() {
		super("); Its is not allowed to persist a null object!");
	}
	
}
