package gefest.rest;

import gefest.rest.controller.PsnOrderNumberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

//@Component
public class MyLogFilter implements Filter{
    private static final Logger log = LoggerFactory.getLogger(MyLogFilter.class);
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestWrapper wrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String fullURL = (queryString != null) ? requestURI + "?" + queryString : requestURI;

        log.info(servletRequest.getRemoteAddr() + "\t " + request.getMethod() + ": " + fullURL);

        if ("POST".equals(wrapper.getMethod())) {
            byte[] body = StreamUtils.copyToByteArray(wrapper.getInputStream());
            String json = new String(body, StandardCharsets.UTF_8);
            log.info(wrapper.getRemoteAddr() + ": " + json);
        }
        filterChain.doFilter(wrapper, servletResponse);
        return;
    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
