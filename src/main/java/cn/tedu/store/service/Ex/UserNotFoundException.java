package cn.tedu.store.service.Ex;

import java.io.Serializable;

public class UserNotFoundException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6241640769559234011L;
	public UserNotFoundException() {
		
	}
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
