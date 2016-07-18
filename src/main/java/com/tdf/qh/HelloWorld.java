package com.tdf.qh;

/**
 * 
 * @author shamanchen
 *
 */
public class HelloWorld {
	private String message;
	private String message1;
	private String message2;
	public void setMessage(String message) {
		this.message = message;
	}
	public void getMessage() {
		System.out.println("This Message: " + message);
	}
	public void setMessage1(String message) {
		this.message1 = message;
	}
	
	public void getMessage1() {
		System.out.println("World Message: " + message1);
	}
	
	public void setMessage2(String message) {
		this.message2 = message;
	}
	
	public void getMessage2() {
		System.out.println("World Message: " + message2);
	}
	
	// Init-method
	public void init() {
		System.out.println("Init before construction");
	}
	
	// Destroy-method
	public void destroy() {
		System.out.println("Destroy after desconstruction");
	}
}
