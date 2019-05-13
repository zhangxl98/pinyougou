package com.pinyougou.shop.controller;

import com.pinyougou.utils.FastDFSClient;
import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 5/13/19 10:14 AM
 * @OS Ubuntu 18.04 LTS
 * @Device DELL-Inspiron-15-7559
 * @Modified By
 * @Version V1.0.0
 * @Description 文件上传控制层
 */
@RestController
public class UploadController {

    /**
     * 文件服务器地址
     */
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    /**
     * 文件上传
     * <pre>createTime:
     * 5/13/19 10:33 AM</pre>
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        // 获取文件扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        try {
            // 创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");

            // 执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);

            // 拼接返回的 URL 和 IP 地址，拼成完整的 URL
            String url = FILE_SERVER_URL + path;

            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }
}
