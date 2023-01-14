package com.primerproyecto.miportfolio.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final  UserDetailsService userDetailsService;
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {

        JwtAuthenFilter jwtAuthenFilter = new JwtAuthenFilter();
        jwtAuthenFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenFilter.setFilterProcessesUrl("/login");



        return httpSecurity
                .csrf().disable()      // desabilita crossSiteRequestForgery
                .authorizeHttpRequests()
                .anyRequest() //cualquier llamado
                .authenticated() // debe de estar autenticado
                .and() //ademas
                .httpBasic() //habilitamos autenticacion basica (a futuro sera desabiitado)
                .and()  //ademas
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //establecemos la politica de sesiones sin estados(Stateless)
                .and()
                .addFilter(jwtAuthenFilter)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build(); // finalmente lo construimos

    }

 /*   @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin")).roles().build());
        return manager;
    }*/

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()).and().build();

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

   /*public static void main(String[] args) {
        System.out.println("pass: " + new BCryptPasswordEncoder().encode("abrEtesesamo"));
    }*/
}
