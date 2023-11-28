public class ColourAlreadyExistsException extends  IllegalArgumentException{
    final String message;

    public ColourAlreadyExistsException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
