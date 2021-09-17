package com.david;

import java.io.IOException;


// https://www.youtube.com/watch?v=tlvSnJrhOfA&t=826s
//empezado el 10 y acabado el 17.9.21


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		
		
		
		
		try {
			t.cargarFichero("d:/preguntas-correcto.txt");
//			t.cargarFichero("d:/preguntas-incorrecto.txt");
			
			t.realizarTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("mensaje error:  " + e );
		}
		

	}

}
