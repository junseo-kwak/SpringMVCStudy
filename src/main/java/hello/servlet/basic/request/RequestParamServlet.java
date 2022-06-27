package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        System.out.println("request.getMethod() = " + request.getMethod());
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + ":" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String userName = request.getParameter("userName");
        System.out.println("request.getParameter(userName) = " + userName);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(userName)");
        String[] userNames = request.getParameterValues("userName");

        for(String name : userNames){
            System.out.println("userName = " + name);
        }

        response.getWriter().write("OK");

    }
}
