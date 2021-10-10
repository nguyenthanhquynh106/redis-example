package com.quynhdev.bookmanager.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(filterName = "Filter1", urlPatterns = {"/*"})
public class MyFilter implements Filter {
    int count;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init!");
        count = 0;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Các request " + request);
        String remoteAddr = request.getRemoteAddr();
        if (remoteAddr.equals(remoteAddr)) {
            count++;
        }
        System.out.println("Số request là: " + count);
        Thread thread = new Thread(() -> {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    if (count >= 6) {
                        request.setAttribute("error", "request");
                    }

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Số request: " + count);
            count = 0;
            request.setAttribute("error", "");
        });

        thread.start();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
