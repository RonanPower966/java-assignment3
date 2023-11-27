public class InvalidRGBValueException extends  IllegalArgumentException{
    final String message;

    public InvalidRGBValueException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
