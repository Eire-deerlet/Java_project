package com.first.group.filter;

import com.first.group.comment.ThreadLocalUtils;
import com.first.group.parts.pojos.PcPartsOne;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取登录信息的过滤器
 */
@Component
@WebFilter(filterName = "AppTokenFilter",urlPatterns = "/*")
public class AppTokenFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1 =(HttpServletRequest)request;
        HttpServletResponse response1 =(HttpServletResponse) response;

        String coding = request1.getParameter("coding");

        //如果存在，则存入ThreadLocal 对象
        if (StringUtils.isNotEmpty(coding) && !coding.equals("0")){
            //访客不需要存入ThreadLocal

            PcPartsOne partsOne = new PcPartsOne();
            partsOne.setCoding(Integer.parseInt(coding));


            ThreadLocalUtils.set(partsOne);
        }

        //放行
        filterChain.doFilter(request1,response1);
    }


}
