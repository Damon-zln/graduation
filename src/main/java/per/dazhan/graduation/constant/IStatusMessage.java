package per.dazhan.graduation.constant;

/**
 * Created by dazhan on 2019/3/6 17:35.
 */
public interface IStatusMessage {
    String getCode();
    String getMessage();
    String FILE_UPLOAD_ERROR = "上传图片失败";
    String FILE_UPLOAD_NULL = "上传图片为空文件";

    enum SystemStatus implements IStatusMessage {

        SUCCESS("1000", "操作成功"), //请求成功
        ERROR("1001", "网络异常，请稍后重试~"), ;      //请求失败

        private String code;
        private String message;

        SystemStatus(String code, String message) {
            this.code = code;
            this.message = message;
        }
        public String getCode() {
            return this.code;
        }
        public String getMessage() {
            return this.message;
        }
    }
}
