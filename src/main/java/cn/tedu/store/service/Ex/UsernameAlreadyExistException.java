package cn.tedu.store.service.Ex;

public class UsernameAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4865161151718858378L;
	/**
	 * @return 
	 * 
	 */
	public UsernameAlreadyExistException() {
		
	}
	public UsernameAlreadyExistException(String message) {
		super(message);
		
	}
	
	
}
