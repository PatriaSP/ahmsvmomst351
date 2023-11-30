/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.rest;

import id.co.ahm.jxf.constant.CommonConstant;
import id.co.ahm.jxf.constant.StatusMsgEnum;
import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.jxf.dto.DtoResponse;
import id.co.ahm.jxf.security.TokenPstUtil;
import id.co.ahm.jxf.util.DtoHelper;
import id.co.ahm.jxf.vo.VoPstUserCred;
import id.co.ahm.mo.mst.app351.service.Mst351Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author patria
 */
@Controller
@RequestMapping("mo/mst351")
public class Mst351Rest {

    @Autowired
    @Qualifier(value = "tokenPstUtil")
    private TokenPstUtil tokenPstUtil;

    @Autowired
    @Qualifier(value = "mst351Service")
    private Mst351Service mst351Service;

    @RequestMapping(value = "get-user", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getUser(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token) {
        VoPstUserCred vo = tokenPstUtil.getUserCred(token);
        Map<String, Object> data = new HashMap<>();
        data.put("userId", vo.getUserid());
        data.put("userName", vo.getUsername());
        List lst = new ArrayList<>();
        lst.add(data);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, lst);
    }

    @RequestMapping(value = "get-lov-storage-location", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getSlocData(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getSlocData("");
    }

    @RequestMapping(value = "get-count-storage-location", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getCountSlocData(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getCountSlocData(param.getSearch().get("VITEMCODE").toString());
    }

    @RequestMapping(value = "get-no-shipping", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getNoShip(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getNoShip(param);
    }

    @RequestMapping(value = "get-search-data-hdrshp", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDataHdrShip(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getDataHdrShip(param);
    }

    @RequestMapping(value = "get-search-data-hdrshp-list", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDataHdrShipList(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getDataHdrShipList(param);
    }

    @RequestMapping(value = "get-proc-input", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getProcInput(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        VoPstUserCred vo = tokenPstUtil.getUserCred(token);
        String Token;
        Token = vo.getUserid();
        return mst351Service.getProcInput(param, Token);
    }

    @RequestMapping(value = "get-proc-delete", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getProcDelete(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        VoPstUserCred vo = tokenPstUtil.getUserCred(token);
        String Token;
        Token = vo.getUserid();
        return mst351Service.getProcDelete(param, Token);
    }

    @RequestMapping(value = "get-data-acc", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDataAcc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getDataAcc(param);
    }
    
    @RequestMapping(value = "get-count-BOM-Acc", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getCountBomAcc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getCountBOM();
    }
    
    @RequestMapping(value = "get-search-dtl-acc", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getSearchAcc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getSearchDtlAcc(param);
    }
    
    @RequestMapping(value = "get-search-dtl-acc1", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getSearchAcc1(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getSearchDtlAcc1(param);
    }
    
    @RequestMapping(value = "get-search-dtl-acc2", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getSearchAcc2(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getSearchDtlAcc2(param);
    }
    
    @RequestMapping(value = "get-proc-del-acc", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getProcDeleteAcc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        VoPstUserCred vo = tokenPstUtil.getUserCred(token);
        String Token;
        Token = vo.getUserid();
        return mst351Service.getDeleteAcc(param, Token);
    }
    
    @RequestMapping(value = "get-report", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDataReport(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getReport();
    }
    
    @RequestMapping(value = "get-report2", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDataReport2(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getReport2();
    }
    
    @RequestMapping(value = "get-data-noship", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DtoResponse getDataNoShip(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody DtoParamPaging param) {
        return mst351Service.getDataNoShip(param);
    }    
}
