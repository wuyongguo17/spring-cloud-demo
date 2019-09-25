package com.wyg.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否过滤，设置为true
    }

    //过滤器的具体业务代码
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //当前例子为请求参数必须有token，没有就会被过滤器拦截，响应非法请求。
        String token = request.getParameter("token");
        if (token == null){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                HttpServletResponse response = currentContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
