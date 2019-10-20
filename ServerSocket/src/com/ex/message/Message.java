package com.ex.message;

import java.io.Serializable;

public class Message<T> implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = -4097402169188489608L;
private T t;
public T getT() {
	return t;
}
public void setT(T t) {
	this.t = t;
}
}
