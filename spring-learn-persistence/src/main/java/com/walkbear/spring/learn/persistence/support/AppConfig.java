package com.walkbear.spring.learn.persistence.support;

import com.walkbear.spring.learn.persistence.util.SpringUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * user: qiujingwang
 * date: 2016/2/29 16:34
 * 配置
 */
@Component
@Data
@Slf4j
public class AppConfig {

    private static AppConfig appConfig = null;

    public static AppConfig getInstance() {
        if (appConfig == null) {
            synchronized (AppConfig.class) {
                if (appConfig == null) {
                    appConfig = SpringUtil.getBean("appConfig");
                }
            }
        }
        return appConfig;
    }

    @Value("${img.server.url}")
    private String imgPath;


    @PostConstruct
    public void init() {

        if (StringUtils.isBlank(getImgPath())) {
            log.error("imgPath 不能为空>>>请检查properties[imgPath]配置");
            throw new IllegalArgumentException("imgPath 不能为空>>>请检查properties[imgPath]配置");
        }
    }

    /**
     * 返回URL 全路径，
     * 例：http://img.sibumbg.com/G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg 返回 http://img.sibumbg.com/G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg
     * 例：G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg 返回 http://img.sibumbg.com/G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg
     * @param imageUrl
     * @return
     */
    public String getImagePath(String imageUrl) {
        if (imageUrl != null && !(imageUrl = imageUrl.trim()).isEmpty() && !imageUrl.startsWith("http")) {
            return appConfig.getImgPath() + (imageUrl.startsWith("/") ? imageUrl : "/" + imageUrl);
        }
        return imageUrl;
    }

    /**
     * 根据URL 获取 相对fdfs相对路径，
     * 例：http://img.sibumbg.com/G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg 即返回 G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg
     * 例：/G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg 即返回 G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg
     * 例：G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg 即返回 G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg
     * @param imageUrl
     * @return G1/M00/05/1C/CixGgVeLHLSAIDT5AA8Yd_IevSc952.jpg
     */
    public String getImageRelativeFdfsPath(String imageUrl) {
        if (imageUrl != null && !(imageUrl = imageUrl.trim()).isEmpty()) {
            String imagePath = appConfig.getImgPath();
            if(imageUrl.startsWith(imagePath)){
                imageUrl = imageUrl.substring(imageUrl.indexOf(imagePath) + imagePath.length());
            }
            if(imageUrl.startsWith("/")){
                imageUrl = imageUrl.substring(1);
            }
        }
        return imageUrl;
    }
}
