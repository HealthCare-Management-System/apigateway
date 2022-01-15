//package com.citius.apigateway;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
//import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import javax.crypto.spec.SecretKeySpec;
//@Configuration
//@EnableWebFluxSecurity
//public class ResourceServerConfig {
//
//
//    @Bean
//    @Primary
//    SecurityWebFilterChain sprSecurityWebFilterChain(ServerHttpSecurity httpSecurity) {
//        httpSecurity.authorizeExchange()
//                .anyExchange()
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public ReactiveJwtDecoder jwtDecoder() {
//        byte[] key = "123456789012345678901234567890AB".getBytes();
//        SecretKeySpec originalKey = new SecretKeySpec(key, 0, key.length, "AES");
//        return NimbusReactiveJwtDecoder.withSecretKey(originalKey).build();
//    }
//}
