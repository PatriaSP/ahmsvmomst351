/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.rest.advice;

import id.co.ahm.jxf.constant.StatusMsgEnum;
import id.co.ahm.jxf.dto.DtoResponseWorkspace;
import id.co.ahm.jxf.util.DtoHelper;
import id.co.ahm.mo.mst.app351.exception.Mst351Exception;
import id.co.ahm.mo.mst.app351.rest.Mst351Rest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author patria
 */

@ControllerAdvice(basePackageClasses = {Mst351Rest.class})
public class Mst351RestAdvice {
          @ExceptionHandler({Exception.class})
    public DtoResponseWorkspace handleException(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        return DtoHelper.constructResponseWorkspace(StatusMsgEnum.GAGAL, null, "Server Processing Error", null, null);
    }

    @ExceptionHandler({Mst351Exception.class})
    public DtoResponseWorkspace handleException(Mst351Exception e, HttpServletResponse response) {
        e.printStackTrace();
        return DtoHelper.constructResponseWorkspace(StatusMsgEnum.GAGAL, e.getMessage(), e.getErrorList(), null);
    }
    
}
