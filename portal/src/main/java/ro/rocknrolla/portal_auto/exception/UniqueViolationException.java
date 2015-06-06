package ro.rocknrolla.portal_auto.exception;

public class UniqueViolationException extends RuntimeException {
	private String field;

	public UniqueViolationException(String field, String message) {
		super(message);
		this.field = field;
	}

	public String getField() {
		return field;
	}
}
