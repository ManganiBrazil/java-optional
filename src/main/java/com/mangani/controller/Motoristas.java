package com.mangani.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.mangani.beans.Caminhao;
import com.mangani.beans.Motorista;
import com.mangani.beans.Seguro;

public class Motoristas {
	
	private Map<String, Motorista> motoristas = new HashMap<>();
	
	public Motoristas() {
		Seguro seguro = new Seguro("Parcial não cobre roubo", new BigDecimal("5000"));
		Caminhao caminhao = new Caminhao("Mercedes Atron", seguro);
		Motorista motoristaJoao = new Motorista("João", 40, caminhao);
		Motorista motoristaJose = new Motorista("José", 25, null);
		Motorista motoristaMangani = new Motorista("Mangani", 39, caminhao);
		Motorista motoristaSergio = new Motorista("Sérgio", 39, null);
		Motorista motoristaBaltazar = new Motorista("Baltazar", 39, null);
						
		motoristas.put("João", motoristaJoao);
		motoristas.put("José", motoristaJose);
		motoristas.put("Mangani", motoristaMangani);
		motoristas.put("Sérgio", motoristaSergio);
		motoristas.put("Baltazar", motoristaBaltazar);
	}
	
	public Motorista porNome(String nome) {
		return this.motoristas.get(nome);
	}
}