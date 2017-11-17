package com.mangani.beans;

import java.util.List;

public class Pessoa {
	
	private String nome;
	private List<Telefone> fones;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Telefone> getFones() {
		return fones;
	}
	public void setFones(List<Telefone> fones) {
		this.fones = fones;
	}
}