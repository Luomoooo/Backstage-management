package fun.luomo.controller;

import fun.luomo.domain.SysLog;
import fun.luomo.service.ISysLogService;
import fun.luomo.utils.UUIDUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Luomo
 * @since 2020/2/18 14:43
 */

@Component
@Aspect
public class LogAop {

    private Date visitTime;
    private Class clazz;
    private Method method;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    @Before("execution(* fun.luomo.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }


    }

    @After("execution(* fun.luomo.controller.*.*(..)) && !execution(* fun.luomo.controller.SysLogController.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime();

        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class) {

            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String classValue = (classAnnotation.value())[0];

                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String methodValue = methodAnnotation.value()[0];
                    url = classValue + methodValue;

                    String ip = request.getRemoteAddr();
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String userName = user.getUsername();
                    SysLog sysLog = new SysLog();
                    sysLog.setId(UUIDUtils.getUUID());
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(userName);
                    sysLog.setVisitTime(visitTime);

                    sysLogService.save(sysLog);
                }
            }
        }


    }
}
