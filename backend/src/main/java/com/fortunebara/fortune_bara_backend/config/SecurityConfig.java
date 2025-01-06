package com.fortunebara.fortune_bara_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/oauth2/**").permitAll() // 공개 URL
                        .anyRequest().authenticated() // 나머지는 인증 필요
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/google") // Google 로그인 페이지
                        .defaultSuccessUrl("/loginSuccess", true) // 로그인 성공 후 리디렉션
                        .failureUrl("/loginFailure") // 로그인 실패 후 리디렉션
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            SecurityContextHolder.clearContext(); // 인증 정보 제거
                            request.getSession().invalidate(); // 세션 무효화
                            response.addHeader("Set-Cookie", "JSESSIONID=; HttpOnly; Path=/; Max-Age=0");

                            // Google 로그아웃 URL로 리디렉션
                            String googleLogoutUrl = "https://accounts.google.com/Logout";
                            response.sendRedirect(googleLogoutUrl);
                        })
                );


        return http.build();
    }
}
