package com.mangani.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.mangani.beans.Caminhao;
import com.mangani.beans.Motorista;
import com.mangani.beans.Seguro;

public class Motoristas {
	
	private Map<String, Optional<Motorista>> motoristas = new HashMap<>();
	
	public Motoristas() {
		Seguro seguro = new Seguro("Parcial não cobre roubo", new BigDecimal("5000"));
		Caminhao caminhao = new Caminhao("Mercedes Atron", Optional.ofNullable(seguro));
		Optional<Motorista> motoristaJoao = Optional.<Motorista>of(new Motorista("João", 40, Optional.ofNullable(caminhao)));
		Optional<Motorista> motoristaJose = Optional.<Motorista>of(new Motorista("José", 25, Optional.ofNullable(null)));
		Optional<Motorista> motoristaMangani = Optional.<Motorista>of(new Motorista("Mangani", 39, Optional.ofNullable(null)));
		Optional<Motorista> motoristaPaulo = Optional.<Motorista>of(new Motorista("Paulo", 39, Optional.ofNullable(null)));
				
		motoristas.put("João", motoristaJoao);
		motoristas.put("José", motoristaJose);
		motoristas.put("Mangani", motoristaMangani);
		motoristas.put("Paulo", motoristaPaulo);
	}
	
	public Optional<Motorista> porNome(String nome) {
		return this.motoristas.get(nome);
	}
}