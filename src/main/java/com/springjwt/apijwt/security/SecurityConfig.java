/*todo: Remove this when integrating with React. For now, since the rest calls are
*  stateless, and we do not need JWT authentication as they will be used in login context, -- Session fixation attacks Keep in mind
* commenting the security part  for now */

package com.springjwt.apijwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http.antMatcher("/**").authorizeRequests().antMatchers("/authenticate**", "/error**").
//                permitAll().anyRequest()
//                .authenticated().and().
//                exceptionHandling()
//                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")) // This will throw a 404 when calling the rest url directly.. just because this login path is only valid from browser. Should this be removed, default is 403
//                .and()
//                .logout()
//                .logoutSuccessUrl("/").permitAll()
//                .and()
//                .csrf()
//                .disable(); //todo: remove once the testing is done. This is disabled to enable testing with non browser clients
//
//    }
//



}
