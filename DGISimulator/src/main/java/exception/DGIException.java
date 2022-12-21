package exception;

public class DGIException extends Exception{
    public DGIException(){
        super();
    }
    public DGIException(String message, Throwable cause){
        super(message, cause);
    }
    public DGIException(String message){
        super(message);
    }
}
