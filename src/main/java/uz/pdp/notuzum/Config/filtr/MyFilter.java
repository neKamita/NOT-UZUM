package uz.pdp.notuzum.Config.filtr;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import uz.pdp.notuzum.Entity.User;

import java.io.IOException;

@Component
public class MyFilter implements Filter {

    @Autowired
    @Lazy
    UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private TokenBlacklist tokenBlacklist;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authorization = request.getHeader("Authorization");

        // Skip JWT validation for the registration endpoint
        if (request.getRequestURI().equals("/api/auth/register")) {
            filterChain.doFilter(request, servletResponse);
            return;
        }

        if (authorization == null || authorization.isBlank()) {
            filterChain.doFilter(request, servletResponse);
            return;
        }

        if (authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            if (tokenBlacklist.isTokenBlacklisted(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token is blacklisted");
                return;
            }

            String username = jwtProvider.getUsernameFromToken(token);
            if (username != null && validateRequest(request, token)) {
                setUserToContext(username);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void setUserToContext(String username) {
        User user = (User) userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        user.getAuthorities()
                );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private boolean validateRequest(HttpServletRequest request, String token) {
        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        String originalIpAddress = getOriginalIpAddress(token);
        String originalUserAgent = getOriginalUserAgent(token);

        return ipAddress.equals(originalIpAddress) && userAgent.equals(originalUserAgent);
    }

    public String getOriginalIpAddress(String token) {
        Claims claims = getClaims(token);
        return claims.get("ip", String.class);
    }

    public String getOriginalUserAgent(String token) {
        Claims claims = getClaims(token);
        return claims.get("userAgent", String.class);
    }

    private Claims getClaims(String token) {
        return jwtProvider.getClaims(token);
    }
}