package com.crazycode.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 * 当控制器方法出错的时候,抛出异常的时候,
 * 就会交给SysExceptionHandler来调用带有@ExceptionHandler的方法来进行异常处理
 *
 * @author Administrator
 */
@ControllerAdvice
public class AllExceptionHandler {
    /**
     * 异常处理方法形参类只能接收异常信息,不能有其它参数
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        SysException se = null;
        if (ex instanceof SysException) {
            se = (SysException) ex;
        } else {
            se = new SysException(ex.getMessage());
        }
        modelAndView.addObject("ex", se);
        modelAndView.setViewName("error");
        return modelAndView;

    }
}
