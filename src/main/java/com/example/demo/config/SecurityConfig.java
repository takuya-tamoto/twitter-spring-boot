package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/webjars/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/webjars/**").permitAll() //webjarsへアクセス許可
		.antMatchers("/css/**").permitAll() //cssへアクセス許可
		.antMatchers("/login").permitAll() //ログインページは直リンクOK
		.antMatchers("/signup").permitAll() //ユーザー登録画面は直リンクOK
		.antMatchers("/admin").hasAuthority("ROLE_ADMIN") //アドミンユーザーに許可
		.anyRequest().authenticated(); //それ以外は直リンク禁止

		http
		.formLogin()
		.loginProcessingUrl("/login") //ログイン処理のパス
		.loginPage("/login") //ログインページの指定
		.failureUrl("/login") //ログイン失敗時の遷移先
		.usernameParameter("userId") //ログインページのユーザーID
		.passwordParameter("password") //ログインページのパスワード
		.defaultSuccessUrl("/home", true); //ログイン成功後の遷移先

//		http
//		.logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutUrl("/logout")
//		.logoutSuccessUrl("/login");

		//csrf対策無効に設定
		http.csrf().disable();


	}


}
