package ro.rocknrolla.portal_auto.exception;

/**
 * Created by Bogdan Stoean on 6/6/15.
 */
public class ServerEntityNotFoundException extends RuntimeException {

    private String field;

    public ServerEntityNotFoundException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }

}
