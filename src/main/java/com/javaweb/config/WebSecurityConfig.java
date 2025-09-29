package com.javaweb.config;
//import com.javaweb.service.impl.CustomUserDetailService;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //Trang phân quyền
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable()//Tắt CRFS token. Nếu để API thì tắt đi cho đỡ rắc rối
                .authorizeRequests()//Bắt đầu cấu hình phân quyền URL
                        //.antMatchers("/admin/building-edit").hasAnyRole("MANAGER")
                        .antMatchers("/admin/**").hasAnyRole("ROLE_MANAGER","ROLE_STAFF","ROLE_ADMIN")//Cấp quyền cho các Role như này
                        .antMatchers("/login", "/resource/**", "/trang-chu", "/api/**").permitAll()//URL này cho phép ai cũng vào được
                .and()
                .formLogin().loginPage("/login")//Bật trang login mà mình custom
                .usernameParameter("username")//Tên field trong form login (trùng với input name trong HTML)
                .passwordParameter("password").permitAll()
                .loginProcessingUrl("/j_spring_security_check")//Khi submit login thì post lên URL này để SprSecu xử lý
                .successHandler(myAuthenticationSuccessHandler())//Nếu success thì chạy ---> CustomSuccessHandler
                .failureUrl("/login?incorrectAccount").and()//Nếu mà login sai thì redirect về URL này
                .logout().logoutUrl("/logout").deleteCookies("JSESSIONID")//Dùng để logout acc và vế sau là xóa cookie
                .and().exceptionHandling().accessDeniedPage("/access-denied").and()//Nếu đăng nhập thành công nhưng không được phân quyền thì bị ghi từ chôi
                .sessionManagement().maximumSessions(1).expiredUrl("/login?sessionTimeout");//Khi session hết hạn
    }*/
	/*@Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(
            "http://localhost:5004",
            "http://localhost:5001",
            "http://localhost:5005"
        ));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With", "Accept", "Origin"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().configurationSource(corsConfigurationSource()) // Kích hoạt CORS
            .and()
            .csrf().disable() // Tắt CSRF cho API
            .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Cho phép OPTIONS
                .antMatchers("/auth/login", "/auth/register").permitAll() // Cho phép tất cả login/register
                .antMatchers("/auth/**").hasAnyAuthority("ADMIN", "TEACHER") // Bảo vệ admin routes
                .antMatchers("/**").permitAll() // Public routes
                .anyRequest().authenticated() // Các request khác cần auth
            .and()
            .logout()
                .logoutUrl("/auth/logout") // API logout
                .deleteCookies("JSESSIONID") // Xóa đi các cookie khi rời khỏi admin
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(200); // Trả status 200 cho API
                });
    }
}
