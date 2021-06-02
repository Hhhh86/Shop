package wushanqiyong.shop.handler;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ProjectName shop-api
 * @ClassName MyMetaObjectHandler
 * @create 2021-06-01 22:56
 * @Author by hyp
 */
@Slf4j
@Component
public class MyMetaObjectHandler {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
