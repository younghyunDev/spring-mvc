package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회]");
        req.getParameterNames().asIterator()
                .forEachRemaining(paraName-> System.out.println( paraName+"="+req.getParameter(paraName)));

        System.out.println("[전체 파라미터  조회] - 종료");

        System.out.println("[단일파라미터 조회]");
        String username =req.getParameter("username");
        System.out.println("username = " + username);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames=req.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("s = " + s);
        }
        
        //req.getParameterNames()
    }
}
