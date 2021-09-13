package com.study.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet { // servlet은 HttpServlet을 상속받아야 된다

    // 서블릿이 호출되면 service() 메서드가 호출된다
    // 요청이 오면 WAS가 HttpServletRequest, HttpServletResponse 객체를 만들어서 service() 메서드로 전달해준다
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");

        // HttpServletRequest, HttpServletResponse는 인터페이스인데, 다양한 WAS 서버들은 Servlet 표준 스펙을 구현한다
        // request와 response를 출력했을 때 찍히는 org.apache.catalina.connector.Request~ 이게 Servlet 표준 스펙의 구현체이다
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // HTTP Response 헤더 정보에 추가
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // write를 하면 HTTP Response Body에 데이터가 들어간다
        response.getWriter().write("hello " + username);
    }
}
