package caseItplus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class user implements Serializable {
	private String id;
	private String name;
	private String pass;

	public user(String name, String pass) {
		super();
		this.id = LocalDateTime.now().toString();
		this.name = name;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}

}
