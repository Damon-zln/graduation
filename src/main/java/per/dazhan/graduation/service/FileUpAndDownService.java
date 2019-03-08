package per.dazhan.graduation.service;

import org.springframework.web.multipart.MultipartFile;
import per.dazhan.graduation.exception.ServiceException;

import java.util.Map;

/**
 * Created by dazhan on 2019/3/6 17:12.
 */
public interface FileUpAndDownService {

    Map<String, Object> uploadPicture(MultipartFile file) throws ServiceException;
}
