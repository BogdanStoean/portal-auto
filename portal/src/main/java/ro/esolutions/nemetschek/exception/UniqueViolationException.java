package ro.esolutions.nemetschek.exception;

/**
 * Created with IntelliJ IDEA.
 * User: marius
 * Date: 5/4/15
 * Time: 3:05 PM
 */
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
