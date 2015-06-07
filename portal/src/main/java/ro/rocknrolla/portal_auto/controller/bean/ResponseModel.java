package ro.rocknrolla.portal_auto.controller.bean;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
public class ResponseModel {

    private String status;
    private String message;


    public ResponseModel() {
    }

    public ResponseModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
