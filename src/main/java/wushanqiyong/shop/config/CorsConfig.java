package wushanqiyong.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName shop-api
 * @ClassName CorsConfigurer
 * @create 2021-06-02 21:23
 * @Author by hyp
 */
/*跨域配置*/
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE","HEAD")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
