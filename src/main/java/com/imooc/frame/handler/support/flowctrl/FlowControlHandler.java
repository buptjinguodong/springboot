package com.imooc.frame.handler.support.flowctrl;

import com.imooc.frame.flowctrl.flowcheck.DefaultFlowControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.*;
import java.io.IOException;

public class FlowControlHandler implements Filter {

    @Autowired
    @Qualifier("defaultFlowControl")
    DefaultFlowControl defaultFlowControl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
