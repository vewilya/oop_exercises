package ch.hslu.oop.SW09.Temperature;

public class MyTypeErrorException extends Exception {
 
    public MyTypeErrorException() {
        super();
    }

    public MyTypeErrorException(String message) {
        super(message);
    }

    @Override
    public Throwable getCause() {
        return super.getCause();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public String toString() {
        return super.toString();
    }  
}
