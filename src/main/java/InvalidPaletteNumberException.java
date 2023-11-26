public class InvalidPaletteNumberException extends IllegalArgumentException {
    final String message;

    public InvalidPaletteNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
