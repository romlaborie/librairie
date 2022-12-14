package com.epsiBibliProjet.librairie.security;


import com.epsiBibliProjet.librairie.filter.JwtAuthenicationFilter;
import com.epsiBibliProjet.librairie.filter.JwtAuthorizationFilter;
import com.epsiBibliProjet.librairie.model.Account;
import com.epsiBibliProjet.librairie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AccountService accountService;


    public SecurityConfig(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Account appUser = accountService.loadUserByUsername(username);
                if(appUser == null){
                    throw new UsernameNotFoundException("User not authorized.");
                }
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                appUser.getAppRoles().forEach(r ->{
                    authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                });
                return new User(appUser.getUsername(), appUser.getPassword(), authorities);
            }
        });

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/allBooks").permitAll()
                .antMatchers("/recherche_par_nom_auteur").permitAll()
                .antMatchers("/recherche_par_titre").permitAll()
                .antMatchers("/patron/**").permitAll()
                .antMatchers("/librarian/**").permitAll()
                .antMatchers("/add_auteur").permitAll()
                .antMatchers("/ajout_livre").permitAll()
                .antMatchers("/listeBook").permitAll()
                .antMatchers("/library").permitAll()
                .antMatchers("/roles").permitAll()
                .antMatchers("/addRoleToUser").permitAll()
                .antMatchers("/emprunter/**").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and();
        http.addFilter(new JwtAuthenicationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
