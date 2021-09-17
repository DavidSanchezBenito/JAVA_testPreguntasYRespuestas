package com.david;
import com.david.ListaDinamica;

//

public class Pregunta {

	/*
	 * Una pregunta consta de: • Pregunta (tendrá delante dos puntos y coma ;P;) •
	 * Opciones de la pregunta (entre 2 y 4) • Opción correcta (tendrá delante dos
	 * puntos y coma ;R;) • Puntos
	 * 
	 */

	private String pregunta;
	private ListaDinamica<Respuesta> respuestas;
	private double puntos;

	public Pregunta(String pregunta, ListaDinamica<Respuesta> respuestas, double puntos) {

		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.puntos = puntos;
	}

	
	
	public String getPregunta() {
		return pregunta;
	}

	public ListaDinamica<Respuesta> getRespuestas() {
		return respuestas;
	}

	public double getPuntos() {
		return puntos;
	}

	
	public void mostrarPregunta() {   //Pregunta tiene la pregunta y las respuestas
		System.out.println(pregunta);  //muestra la pregunta del test
		
		int i=0;
		while(i<respuestas.size()) {
			System.out.println("\t" + (i+1) + ". " + respuestas.get(i)); //   "\t" creo q es tabulador
			i++;
		}
	}
	
	public boolean comprobarRespuesta(int respuesta) {
		
	       Respuesta r = respuestas.get(respuesta - 1);
	        
	        if(r!=null){
	            return r.getCorrecto();
	        }	
	        
	        return false;
	}



	@Override
	public String toString() {
		return "ARRAY: [pregunta=" + pregunta + ", respuestas=" + respuestas + ", puntos=" + puntos + "/FIN/";
	}


}
	