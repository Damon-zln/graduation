package per.dazhan.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import per.dazhan.graduation.constant.IStatusMessage;
import per.dazhan.graduation.exception.ServiceException;
import per.dazhan.graduation.model.RestResponse;
import per.dazhan.graduation.service.FileUpAndDownService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dazhan on 2019/3/6 14:06.
 */
@Controller
public class FileUploadController {

    @Resource
    private FileUpAndDownService fileUpAndDownService;

    @PostMapping("/upload")
    @ResponseBody
    public RestResponse setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file) {
        RestResponse response = new RestResponse();
        try {
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                response.setCode(Integer.parseInt(IStatusMessage.SystemStatus.ERROR.getCode()));
                response.setMsg((String) resultMap.get("msg"));
                return response;
            } else {
                response.setCode(Integer.parseInt(IStatusMessage.SystemStatus.SUCCESS.getCode()));
                response.setMsg((String) resultMap.get("result"));
                response.setSuccess(true);
                response.setData(resultMap);
            }
        } catch (ServiceException e) {
            response.setCode(Integer.parseInt(IStatusMessage.SystemStatus.ERROR.getCode()));
            response.setMsg(IStatusMessage.FILE_UPLOAD_ERROR);
        }
        return response;
    }

    private Map<String, Object> upload(MultipartFile file) throws ServiceException {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpAndDownService.uploadPicture(file);
                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    return picMap;
                } else {
                    returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                    returnMap.put("msg", picMap.get("result"));
                }
            } else {
                returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                returnMap.put("msg", IStatusMessage.FILE_UPLOAD_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(IStatusMessage.FILE_UPLOAD_ERROR);
        }
        return returnMap;
    }

    @GetMapping("/loadPic")
    @ResponseBody
    public String loadPic() {
        System.out.println("ssssssssss");
        return "okkkkkkk";
    }
}
