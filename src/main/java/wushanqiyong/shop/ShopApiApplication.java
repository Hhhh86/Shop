package wushanqiyong.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wushanqiyong.shop.utils.GithubUploader;


@SpringBootApplication
@MapperScan("wushanqiyong.mapper")
public class ShopApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApiApplication.class, args);
    }


    @Bean
    public GithubUploader githubUploader(){
      return   new GithubUploader();
    }



}
