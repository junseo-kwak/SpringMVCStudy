package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            printStartLine(request);
            printHeaders(request);
            printHeaderUtils(request);
            printEtc(request);
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
        System.out.println("request.isSecure() = " + request.isSecure()); // false

        System.out.println("================ printStartLine END =====================");
        System.out.println();


    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("== Headers Start == ");

//        Enumeration<String> headerNames = request.getHeaderNames();
//
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + " : " + request.getHeader(headerName));
//        }

        request.getHeaderNames()
                .asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ":" + request.getHeader(headerName)));

        System.out.println("== Headers End == ");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("== Header 편의 조회 start == ");
        System.out.println("[Host 편의 조회] ");
        System.out.println("request.getSererName() = " + request.getServerName()); // Host 주소
        System.out.println("request.getServerPort() = " + request.getServerPort()); // Host 포트
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie 편의 조회]");
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }

        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("Header 편의 조회 End");
        System.out.println();
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("== 기타 정보 조회 ==");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("== 기타 정보 조회 End ==");
        System.out.println();

    }



}
