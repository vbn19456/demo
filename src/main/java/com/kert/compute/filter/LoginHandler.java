package com.kert.compute.filter;

import com.kert.compute.exception.BusinessException;
import com.kert.compute.model.vo.ResultVO;
import com.kert.compute.service.UserService;
import com.kert.compute.utils.JsonUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginHandler implements HandlerInterceptor {
    private final UserService userService;
    public LoginHandler(UserService userService){
        this.userService=userService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        try {
            System.out.println("====================================================preHandle");
            return userService.verify(request.getHeader("Authorization"));
        }catch (BusinessException e ){
            /*response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","application/json");
            PrintWriter writer = response.getWriter();
            ResultVO resultVO = new ResultVO();
            resultVO.setCode(e.getErrCode().getCode());
            resultVO.setMessage(e.getErrCode().getMsg());
            writer.write(JsonUtil.toStr(resultVO));*/
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("====================================================afterCompletion");
        assert ex != null;
        ex.printStackTrace();
    }
}
