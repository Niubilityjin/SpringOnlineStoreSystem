package cn.tedu.store.bean;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -52681504315954110L;
	private Integer state;
	private String message;
	private T data;
	
	public ResponseResult(Integer state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
		
	}
	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
