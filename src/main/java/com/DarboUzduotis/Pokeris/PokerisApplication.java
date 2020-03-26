package com.DarboUzduotis.Pokeris;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import gui.GUI;
//paleidimo klase. Iskviecia GUI, kad butu galima pasirinkti faila
@SpringBootApplication
public class PokerisApplication {

	public static void main(String[] args) {
        GUI g = new GUI();
        g.fileChooser();	
    }
}