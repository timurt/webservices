package kz.tim.samples.model;

/**
 * Class responsible for storing code and message required for some methods in response.
 *
 * @author Timur Tibeyev.
 */
public class Status {

    /** Status code **/
    private int code = 100;

    /** Status message **/
    private String message = "Success";

    /**
     * Getter method for code.
     * @return status code.
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for code.
     * @param code status code.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method for message.
     * @return status message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for message.
     * @param message status message.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
