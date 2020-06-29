package org.cqipc.edu;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.cqipc.edu.bean.T_job_log;
import org.cqipc.edu.bean.T_login_log;
import org.cqipc.edu.bean.T_user;
import org.cqipc.edu.controller.SystemControllerLog;
import org.cqipc.edu.controller.SystemServiceLog;
import org.cqipc.edu.service.SystemService;
import org.cqipc.edu.service.T_job_logService;
import org.cqipc.edu.util.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.plugin.dom.core.Element;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    //开始时间
    private Long begin;
    //结束时间
    private Long end;

    boolean flag=false;
    String f="";
    //注入Service用于把日志保存数据库

    @Resource
    private T_job_logService t_job_logService;


    T_job_log t_job_log=new T_job_log();
    T_login_log t_login_log=new T_login_log();

    //本地异常日志记录对象
    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * org.cqipc.edu.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称


    @Pointcut("execution(public * org.cqipc.edu.service..*.*(..))")//切入点描述 这个是controller包的切入点
    public void serviceLog(){}//签名，可以理解成这个切入点的一个名称

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint)throws Throwable{


        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        HttpSession session = request.getSession();

        begin = System.currentTimeMillis();
//        T_user user = (T_user)session.getAttribute("LoginParams");
        Object[] param1=(Object[])session.getAttribute("param");
//        System.out.println(param1[0]);
//        T_user user= (T_user) param1[0];
//        System.out.println(user);
        System.out.println(getControllerMethodDescription(joinPoint));
        boolean ss=getControllerMethodDescription(joinPoint).equals("select");

        if (!ss) {

            // 记录下请求内容
            logger.info("################URL : " + request.getRequestURL().toString());
            logger.info("################HTTP_METHOD : " + request.getMethod());
            logger.info("################IP : " + request.getRemoteAddr());
            logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

            //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
            logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
            logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

//            t_job_logService= (T_job_logService) SpringContextUtils.getBean("t_job_logService");
//            System.out.println(SpringContextUtils.getBean("t_job_logService"));
            //*========控制台输出=========*//
            System.out.println("==============前置通知开始==============");
//            System.out.println("请求人："+user.getUsername());

            System.out.println("请求方法：" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            System.out.println("方法描述：" + getControllerMethodDescription(joinPoint));
            String str = Arrays.toString(joinPoint.getArgs());
            System.out.println("参数：" + str);
            Object[] name=joinPoint.getArgs();
//            for (int i=0;i<name.length;i++){
//                System.out.println(name[i]);
//            }
            System.out.println(name[0]);
            System.out.println("请求ip：" + request.getRemoteAddr());
            InetAddress ip4 = Inet4Address.getLocalHost();
            System.out.println(ip4.getHostAddress());
            boolean s1=getControllerMethodDescription(joinPoint).equals("用户登录");
            System.out.println(s1);
            if(s1){
                System.out.println("进入登录日志管理");
                t_login_log.setUsername((String) name[0]);
                t_login_log.setIp(ip4.getHostAddress());
                flag=true;
                f="登录";
            }else {
                t_job_log.setBean_name("1");
                t_job_log.setMethod_name(getControllerMethodDescription(joinPoint));
                t_job_log.setJob_id(BigInteger.valueOf(17));
                t_job_log.setParams(str);
                flag=true;
                f="操作";
            }
        }else {
            System.out.println("查询方法");
        }
    }
    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        if(flag) {
            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            logger.info("RESPONSE : " + ret);
            if (f.equals("登录")){
                t_login_log.setLogin_time(date);
                t_job_logService.addLoginLog(t_login_log);
                System.out.println("插入等率日志完成");
            }else {
                end = System.currentTimeMillis();
                System.out.println("用时" + (end - begin) + "毫秒");

                t_job_log.setTime(end - begin);
                t_job_log.setCreate_time(date);
                t_job_log.setStatus("0");
                t_job_logService.addLog(t_job_log);
            }

        }
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceLog()", throwing = "e")
    public void doAfterThrowingService(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //获取请求ip
        String ip = request.getRemoteAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串

        try {
            /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + Arrays.toString(joinPoint.getArgs()));
            /*==========数据库日志=========*/

            //保存数据库
            t_job_log.setError(e.getClass().getName());
            t_job_log.setStatus("1");
            t_job_logService.addLog(t_job_log);
            System.out.println("=====异常通知结束=====");
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
        /*==========记录本地异常日志==========*/
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), Arrays.toString(joinPoint.getArgs()));

    }



    /**
     * @Description  获取注解中对方法的描述信息 用于Controller层注解
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                }
            }
        }
        return description;
    }


    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
