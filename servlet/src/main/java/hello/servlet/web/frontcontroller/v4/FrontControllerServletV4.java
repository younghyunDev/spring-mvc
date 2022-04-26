package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.container.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.container.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.container.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV4",urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = req.getRequestURI();

        ControllerV4 controllerV4 = controllerMap.get(requestURI);
        if (controllerV4 == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //paramMap
        Map<String, String> paraMap = createParamMap(req);
        Map<String,Object> model =new HashMap<>(); //추가
        String viewName=controllerV4.process(paraMap,model);
        MyView view = viewResolver(viewName);

        view.render(model,req,resp);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/"+ viewName +".jsp");
    }


    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String,String> paraMap = new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(paraName -> paraMap.put(paraName, req.getParameter(paraName)));
        return paraMap;
    }
}
