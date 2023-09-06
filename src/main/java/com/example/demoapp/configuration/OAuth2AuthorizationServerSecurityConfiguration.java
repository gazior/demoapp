package com.example.demoapp.configuration;

import com.example.demoapp.service.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity

public class OAuth2AuthorizationServerSecurityConfiguration {




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .oauth2Login(o -> o.userInfoEndpoint(a -> a.userService(this.oauth2UserService())))
                .oauth2Client(withDefaults())
        ;
        return http.build();
    }

    private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return new CustomOAuth2UserService();
    }


//    @Bean
//    public RegisteredClientRepository registeredClientRepository() {
//        RegisteredClient loginClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("login-client")
//                .clientSecret("{noop}openid-connect")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("http://127.0.0.1:8080/login/oauth2/code/login-client")
//                .redirectUri("http://127.0.0.1:8080/authorized")
//                .scope(OidcScopes.OPENID)
//                .scope(OidcScopes.PROFILE)
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("messaging-client")
//                .clientSecret("{noop}secret")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .scope("message:read")
//                .scope("message:write")
//                .build();
//
//        return new InMemoryRegisteredClientRepository(loginClient, registeredClient);
//    }

}