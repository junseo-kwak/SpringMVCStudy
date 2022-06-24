package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            printStartLine(request);
    }

    private void printStartLine(HttpServletRequest request) {
        // request : http://localhost:8080//request-header?id=3&name=test

        System.out.println("================ printStartLine =====================");
        System.out.println("request.getProtocol() = " + request.getProtocol()); // HTTP/1.1
        System.out.println("request.getMethod() = " + request.getMethod());  // GET
        System.out.println("request.getScheme() = " + request.getScheme()); // http
        System.out.println("request.getRequestURI() = " + request.getRequestURI()); // /request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL()); // http://localhost:8080//request-header
        System.out.println("request.getQueryString() = " + request.getQueryString()); // id=3&name=test


    }
}
