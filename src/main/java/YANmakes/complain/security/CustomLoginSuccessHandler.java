package YANmakes.complain.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request,   HttpServletResponse response, Authentication authentication) throws IOException  {

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


        Collection <? extends GrantedAuthority> authorities = authentication.getAuthorities();



        authorities.forEach(authority -> {

            System.out.println(authority.getAuthority());

            if(authority.getAuthority().equals("ROLE_USER")) {

                try {
                    redirectStrategy.sendRedirect(request, response, "/user-new-complain");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            else if(authority.getAuthority().equals("ROLE_ADMIN")) {
                try {
                    redirectStrategy.sendRedirect(request, response, "/admin-new-complains");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            else if(authority.getAuthority().equals("ROLE_POLICE")) {
                try {
                    redirectStrategy.sendRedirect(request, response, "/police-ongoing-complains?id=1");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                throw new IllegalStateException();
            }
        });

    }
//     @Override
//    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication)
//      throws IOException {
//  
//        handle(request, response, authentication);
//        clearAuthenticationAttributes(request);
//    }

//    @Override
//    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//
//        String targetUrl=determineTargetUrl(authentication);
//
////        if(response.isCommitted())
////            return;
//
//        RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
//        redirectStrategy.sendRedirect(request,response,targetUrl);
//
//    }


//    protected String determineTargetUrl(Authentication authentication){
//
//        String url="/login-error";
//
//        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
//
//        List<String> roles=new ArrayList<>();
//
//        for(GrantedAuthority authority:authorities){
//            roles.add(authority.getAuthority());
//        }
//
//        if(roles.contains("USER"))
//            url="/user-new-complain";
//
//        else if (roles.contains("POLICE"))
//            url="/police-ongoing-complains?id=1";
//
//        else if(roles.contains("ADMIN"))
//            url="/admin-new-complains";
//
//        return url;
//
//
//    }
}
