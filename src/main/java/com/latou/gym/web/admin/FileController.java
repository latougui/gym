package com.latou.gym.web.admin;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin/file")
public class FileController {


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map hello(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) {

        JSONObject jsonObject=new JSONObject();
        Map<String, Object> map = new HashMap<String, Object>();


        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
        //    String rootPath = request.getSession().getServletContext().getRealPath("/static/ui/images/");
            String rootPath = "D:\\download\\毕业设计\\gym\\src\\main\\resources\\static\\ui\\images";
            System.out.println("editormd上传图片："+rootPath);

            /**
             * 文件路径不存在则需要创建文件路径
             */
            File filePath = new File(rootPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            // 最终文件名
            File realFile = new File(rootPath + File.separator + attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
            // 下面response返回的json格式是editor.md所限制的，规范输出就OK

            map.put("success", 1);
            map.put("message", "上传成功");
            map.put("url", "/ui/images/"+attach.getOriginalFilename());

//            jsonObject.put("success", 1);
//            jsonObject.put("message", "上传成功");
//            jsonObject.put("url", "/ui/images/"+attach.getOriginalFilename());
        } catch (Exception e) {
            map.put("success", 0);
            //jsonObject.put("success", 0);
        }

        return map;
    }

}
