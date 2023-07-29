package br.com.erudio.models;

import java.io.Serializable;
import java.util.Objects;

public class Greeting implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final long id;
	private final String content;
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		return Objects.equals(content, other.content) && id == other.id;
	}

	

}
