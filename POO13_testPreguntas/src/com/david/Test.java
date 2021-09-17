	package com.david;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import com.david.ListaDinamica;



public class Test {

	private ListaDinamica<Pregunta> preguntas;
	private double puntosAcumulados;
	private int preguntaActual;

	public Test() {
		preguntas = new ListaDinamica<Pregunta>();
		puntosAcumulados = 0;
		preguntaActual = 0;
	}

	public ListaDinamica<Pregunta> getPreguntas() {
		return preguntas;
	}

	public double getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}

	public Pregunta siguientePregunta() {

		// cojo la siguiente pregunta
		Pregunta p = preguntas.get(preguntaActual);

		// si la pregunta es distinto de null, paso la siguiente
		if (p != null) {
			preguntaActual++;
		}

		return p;
	}

	public void reiniciarTest() {
		preguntaActual = 0;
		puntosAcumulados = 0;
		
	}

	public void realizarTest() {

		if (preguntas.isEmpty()) {
			System.out.println("no hay preguntas");
		}else {
			
			
			Leer teclado = new Leer();  //pedir el resultado
			int i = 0, respuesta;
			Pregunta p = null;
			while (i < preguntas.size()) {  //vamos a ver el array creado de la pregunta
				p = preguntas.get(i);  //cogemos UNA pregunta
				
			//	System.out.println(p.toString());
				p.mostrarPregunta();  //la mostramos
					
				
				respuesta= teclado.pedirIntRango(1, p.getRespuestas().size(), "introduce la respuesta");
		
//				Scanner sc = new Scanner(System.in);
//				int respuesta2 = sc.nextInt();
				
				
				
				if(p.comprobarRespuesta(respuesta)) {
					puntosAcumulados +=p.getPuntos();
					 System.out.println("Has acertado");
				}else {
                    System.out.println("No has acertado");
                }
				i++;
			}
		}
		
		System.out.println("has obtenido: " + puntosAcumulados + " puntos.");  //muestro los puntos
	}

	public void cargarFichero(String fichero) throws IOException {
		
		ListaDinamica<Respuesta> respuestas = new ListaDinamica<Respuesta>();
		BufferedReader entrada = new BufferedReader(new FileReader(fichero));
		String linea = "", textoPregunta = null, textoRespuesta;
		boolean pregunta = false, respuesta = false, puntos = false;
		int puntosPregunta = 0, opcionCorrecta = 0;
		Pregunta p;

		while ((linea = entrada.readLine()) != null) { // cogo las lineas

			try {
				if (linea.startsWith(";P;")) {  //si empieza por P es una pregunta
					textoPregunta = linea.substring(4); // a partir de la letra 3 de la linea hasta el final
					pregunta = true; //ya tengo la pregunta
					
				} else if (pregunta && linea.startsWith(";R;")) {
					respuesta = true;
					opcionCorrecta = Integer.parseInt(linea.substring(3).trim());
				} else if (respuesta) {
					puntosPregunta = Integer.parseInt(linea.trim());
					puntos = true;  //marco los puntos y ya tengo todo, pues llego al final
				} else if (pregunta) {
					respuestas.addLast(new Respuesta(linea));
					
					if (respuestas.size() > 4) {
						//Si tiene mas de 4 respuestas, lanzo excepcion
						throw new Exception("respuestas mas de 4");

					}
				} // else if
                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
				if (pregunta && respuesta && puntos && respuestas.size() >= 2 && respuestas.size() <=4) {
					//estas son las 4 obligaciones para q pueda mostrar la pregunta
					respuestas.get(opcionCorrecta - 1).setCorrecto(true); //para decirle cual es la respuesta correcta
					p = new Pregunta(textoPregunta, respuestas, puntosPregunta);
					preguntas.addLast(p);  //añadimos la pregunta
					
					// reiniciamos
					pregunta = false;
					respuesta = false;
					puntos = false;
					respuestas = new ListaDinamica<>();
				}
			} // try
			catch (Exception e) {
				// reiniciamos
				pregunta = false;
				respuesta = false;
				puntos = false;
				respuestas = new ListaDinamica<>();
				e.printStackTrace();

			}
		}
		entrada.close();

	}

}
