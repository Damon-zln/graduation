package per.dazhan.graduation.exception;

/**
 * @author Damon-zln
 * @date 2019/3/2 17:04
 * @description TipException
 * @update
 */
public class TipException extends RuntimeException {

    public TipException() {
    }

    public TipException(String message) {
        super(message);
    }

    public TipException(String message, Throwable cause) {
        super(message, cause);
    }

    public TipException(Throwable cause) {
        super(cause);
    }
}
