package com.mangani;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mangani.beans.Caminhao;
import com.mangani.beans.Motorista;
import com.mangani.beans.Seguro;
import com.mangani.controller.Motoristas;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	
    	Motoristas motoristas = new Motoristas();
    	List<String> names = Arrays.asList("Mangani", "João", "Sérgio", "Baltazar", "José");
    	
    	for (String name : names) {
			printWhoIsCovered(name, motoristas);
		}
    }
    
    public static final void printWhoIsCovered(String name, Motoristas motoristas) {
    	
    	boolean isCovered = Optional.<Motorista>ofNullable(motoristas.porNome(name))
    			.map(Motorista::getCaminhao)
    			.map(Caminhao::getSeguro)
    			.map(Seguro::getCobertura)
    			.isPresent();
    	
    	if(isCovered) {
    		print(name);
    	}
    }
    
    private static final void print(String name) {
    	Optional.ofNullable(name).ifPresent(n -> System.out.println(String.format("Trucker %s is covered.", n)));    	
    }
}
