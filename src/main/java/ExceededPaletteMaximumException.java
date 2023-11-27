public class ExceededPaletteMaximumException extends  IllegalArgumentException{
    final String message;

    ExceededPaletteMaximumException(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
