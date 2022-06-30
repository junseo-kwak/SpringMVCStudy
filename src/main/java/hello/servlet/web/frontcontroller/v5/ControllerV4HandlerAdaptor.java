package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdaptor implements MyHandlerAdaptor{

    @Override
    public boolean support(Object handler) {
        if(handler instanceof ControllerV4){
            return true;
        }
        return false;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Map<String,String> paramMap = createParamMap(request);
        Map<String,Object> model = new HashMap<>();

        ControllerV4 controller = (ControllerV4) handler;
        String viewName = controller.process(paramMap, model);

        ModelView mv = new ModelView(viewName);
        mv.setModel(model);
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();

        request.getParameterNames()
                .asIterator()
                .forEachRemaining(key -> paramMap.put(key,request.getParameter(key)));

        return paramMap;
    }
}
