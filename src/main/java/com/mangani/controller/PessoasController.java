package com.mangani.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.mangani.beans.Cidade;
import com.mangani.beans.DDD;
import com.mangani.beans.Pessoa;
import com.mangani.beans.Telefone;

public class PessoasController {
	
	public static void main(String[] args) {
		
		List<Telefone> fones = new ArrayList<>();
		Telefone telefone = new Telefone();
		telefone.setCidade(new Cidade());
		telefone.getCidade().setNome("São Paulo");
		telefone.getCidade().setDdd(new DDD());
		telefone.getCidade().getDdd().setDdd("011");
		fones.add(telefone);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Mangani");
		pessoa.setFones(fones);
		
		String ddd = Optional.ofNullable(pessoa)
				.filter(isNotEmpty -> isNotEmpty(pessoa.getFones()))
				.map(Pessoa::getFones)
				.map(fone -> pessoa.getFones().get(0))
				.map(Telefone::getCidade)
				.map(Cidade::getDdd)
				.map(DDD::getDdd)
				.orElse("não existe");
			
		System.out.println("DDD: " + ddd);
	}
	
	private static final boolean isNotEmpty(Collection<?> collection) {
		return collection != null && !collection.isEmpty();
	}
}
