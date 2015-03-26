/**
 * Created by poojar on 3/26/2015.
 */
public class InvalidMoveException extends Exception {
    @Override
    public String getMessage() {
        return "Position Already Used";
    }
}