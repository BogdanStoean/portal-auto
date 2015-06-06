package ro.rocknrolla.portal_auto.bean;

public class Response {
	private boolean success;
	private String message;

	public static final Response OK = new Response(true, "Successful");

	public Response(boolean success) {
		this.success = success;
	}

	public Response(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
