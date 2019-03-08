package per.dazhan.graduation.exception;

/**
 * Created by dazhan on 2019/3/6 17:34.
 */
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Throwable throwable){
        super(throwable);
    }
    public ServiceException(String message ,Throwable throwable){
        super(message, throwable);
    }
}
