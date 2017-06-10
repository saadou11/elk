package elk.context;

public class CustomException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomException(String customExceptionMessage) {
		super(customExceptionMessage);
	}

}
