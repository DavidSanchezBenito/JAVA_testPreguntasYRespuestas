package com.david;
//empezado 10-9-21
public class Respuesta {

	private String respuesta;
	private boolean correcto;
	
	public Respuesta (String respuesta) {
		this.respuesta = respuesta;
	}

	
	public String getRespuesta(){
		return respuesta;
	}
	
	
	
	public boolean getCorrecto() {
		return correcto;
	}
	
	
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}


	@Override
	public String toString() {
		return respuesta;
	}

	
	
	
}

