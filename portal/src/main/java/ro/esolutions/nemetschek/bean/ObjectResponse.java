package ro.esolutions.nemetschek.bean;

/**
 * Created with IntelliJ IDEA.
 * User: marius
 * Date: 4/27/15
 * Time: 11:50 AM
 */
public class ObjectResponse extends Response {

	private Object data;

	public ObjectResponse(Object data) {
		super(true, "ok");
		this.data = data;
	}

	public ObjectResponse(Object data, Boolean success) {
		super(success, "ok");
		this.data = data;
	}

	public ObjectResponse(Object data, Boolean success, String message) {
		super(success, message);
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}
