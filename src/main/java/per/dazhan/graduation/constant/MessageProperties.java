package per.dazhan.graduation.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by dazhan on 2019/3/6 17:09.
 */
@Component
public class MessageProperties {

    @Value("${message.fileSize}")
    private long fileSize;  //压缩大小

    @Value("${message.scaleRatio}")
    private double scaleRatio; //压缩比例

    @Value("${message.upPath}")
    private String upPath; //保存路径

    @Value("${message.imageType}")
    private String imageType; //图片类型

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public double getScaleRatio() {
        return scaleRatio;
    }

    public void setScaleRatio(double scaleRatio) {
        this.scaleRatio = scaleRatio;
    }

    public String getUpPath() {
        return upPath;
    }

    public void setUpPath(String upPath) {
        this.upPath = upPath;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
