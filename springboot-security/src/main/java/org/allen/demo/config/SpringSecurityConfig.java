package org.allen.demo.config;

import org.allen.demo.domain.Permission;
import org.allen.demo.domain.User;
import org.allen.demo.service.PermissionService;
import org.allen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Value("${server.servlet.context-path}")
    private String rootUrl;

    @Value("${server.port}")
    private String port;

    @Override
    protected void configure(HttpSecurity http) throws Exception {//配置相关操作策略
        http
                .authorizeRequests()
                    // 配置可以匿名访问
                    // / 和/index请求 已经/static/**下的静态文件可匿名访问
                    .antMatchers("/", "/index", "/static/**").permitAll()
                    //配置除了可匿名访问的资源外，其他全部请求需要认证后才可访问
                    .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                    .successForwardUrl("/main")
                    //.successHandler(loginSuccessHandler())
                    .failureUrl("/login")
                .and().logout()
                    .logoutUrl("/logout")//.logoutSuccessUrl("http://localhost:"+port+"/"+rootUrl+"/login")//.permitAll()
                    .addLogoutHandler(logoutHandler())
                    .logoutSuccessHandler(logoutSuccessHandler())
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                    .clearAuthentication(true)
                .and().sessionManagement().maximumSessions(20).expiredUrl("/login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(5);
    }


    /**
     * 退出系统成功后处理
     * @return
     */
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler(){
        return new LogoutSuccessHandler(){
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication
                    authentication){
                SecurityUser user = (SecurityUser) authentication.getPrincipal();
                System.out.println("USER "+user.getUsername()+" LOGOUT SUCCESS!");
                try {
                    response.sendRedirect("http://localhost:"+port+"/"+rootUrl+"/login");
                } catch (IOException e) {
                    System.out.println("user "+ user.getUsername() + " LOGOUT EXCEPTION, e:"+e.getMessage());
                }
            }
        };
    }

    @Bean
    public LogoutHandler logoutHandler(){
        return new LogoutHandler(){
            @Override
            public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                System.out.println("this is logouthandler, you can do want you want before logout");
            }
        };
    }

    /**
     * 登录成功处理
     * @return
     */
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler(){
        return new SavedRequestAwareAuthenticationSuccessHandler(){
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
                User userDetails = (User) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }


    /**
     * 用户登录实现
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userService.findByUsername(username);
                if(user == null) throw new UsernameNotFoundException("User name:"+username+" not fount");
                SecurityUser securityUser= new SecurityUser(user);
                return securityUser;

            }
        };
    }

    /**
     * 真正用于登录验证的安全用户（UserDetails）
     */
    class SecurityUser extends User implements UserDetails {
        /**
         * 用户权限
         */
        private Set<SimpleGrantedAuthority> permissions;
        public Set<SimpleGrantedAuthority> getPermissions() {
            return permissions;
        }
        public void setPermissions(Set<SimpleGrantedAuthority> permissions) {
            this.permissions = permissions;
        }

        public SecurityUser(User user){
            if(user != null){
                this.setUserId(user.getUserId());
                this.setUsername(user.getUsername());
                this.setPassword(user.getPassword());
                this.setEmail(user.getEmail());
                this.setTelephone(user.getTelephone());
                Set<SimpleGrantedAuthority> gasSet = (Set<SimpleGrantedAuthority>) getAuthorities();
                if(gasSet.size()>0){
                    this.setPermissions(gasSet);
                }
            }
        }

        /**
         * 获取用户权限
         * @return
         */
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            int userId = this.getUserId();
            //要返回的用户权限集合
            Set<GrantedAuthority> permsSet = new HashSet<GrantedAuthority>();
            //数据库查询用户所拥有的角色对应的权限
            List<Permission> permList = permissionService.loadPermissionsByUserId(userId);
            if(!CollectionUtils.isEmpty(permList)){
                permList.forEach(
                    permission->{
                        GrantedAuthority sga = new SimpleGrantedAuthority(permission.getPermUrl());
                        permsSet.add(sga);
                    }
                );
            }
            return permsSet;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
