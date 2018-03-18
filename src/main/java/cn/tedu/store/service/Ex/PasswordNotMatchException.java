package cn.tedu.store.service.Ex;

import java.io.Serializable;

public class PasswordNotMatchException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5472688368120612111L;
	public PasswordNotMatchException() {
		
	}
public PasswordNotMatchException(String message) {
		super(message);
	}
}
