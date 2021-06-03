//package wushanqiyong.shop.config;
//
//import org.apache.tomcat.util.security.MD5Encoder;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @ProjectName shop-api
// * @ClassName SecurityConfig
// * @create 2021-06-02 21:44
// * @Author by hyp
// */
///*SpringSecurity配置*/
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /*授权*/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/administrate/**").hasRole("role");
//
//
//        /*无权限则跳转登录页面*/
//        http.formLogin();
//    }
//
//    /*认证*/
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("huangpeng").password(new BCryptPasswordEncoder().encode("123456"))
//                .roles("role");
//    }
//}
