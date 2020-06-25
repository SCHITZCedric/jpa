package com.testbdd.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DICTIONARY")

public class Dictionnaire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "word")
	private String word;
	
	@Column(name = "firstletter")
	private String fLetter;
	
	@Column(name = "length")
	private int length;
	
	public String getWord() {
		return word;
	}
	
	public String getFletter() {
		return fLetter;
	}
	
	public int getLength() {
		return length;
	}
}