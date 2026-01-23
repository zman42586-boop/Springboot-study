package com.zhangjunjie.springboot_day1.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class AliOssUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static final String ENDPOINT = "https://oss-cn-hangzhou.aliyuncs.com";

    // ⚠️注意：正式上线时，AccessKey ID和Secret千万不要直接写在代码里，很不安全！这里仅供学习测试
    private static final String ACCESS_KEY_ID = "LTAI5tMgt6R2yvMNDPtJHm8w";
    private static final String ACCESS_KEY_SECRET = "6wj5rR5lheh85vvILBS70GbKcK9rmB";
    private static final String BUCKETNAME = "wodeleadnews";

    public static String uploadFile(String objectName, InputStream in) throws Exception {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        String url = "";
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, objectName, in);

            // 上传文件。
            ossClient.putObject(putObjectRequest);

            // 1. 把 ENDPOINT 里的 https:// 去掉，只留域名 (oss-cn-hangzhou.aliyuncs.com)
            String domain = ENDPOINT.split("//")[1];

            // 2. 拼接最终地址
            url = "https://"+BUCKETNAME+"."+ENDPOINT.substring(ENDPOINT.lastIndexOf("/")+1)+"/"+objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException");
            System.out.println("Error Message:" + oe.getErrorMessage());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        // 返回拼接好的 URL
        return url;
    }
}