/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.service.impl;

import id.co.ahm.jxf.constant.StatusMsgEnum;
import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.jxf.dto.DtoResponse;
import id.co.ahm.jxf.util.DtoHelper;
import id.co.ahm.mo.mst.app351.dao.Mst351ObjectDao;
import id.co.ahm.mo.mst.app351.service.Mst351Service;
import id.co.ahm.mo.mst.app351.vo.Mst351VoAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoCekAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoDataAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoHdrShipList;
import id.co.ahm.mo.mst.app351.vo.Mst351VoShip;
import id.co.ahm.mo.mst.app351.vo.Mst351VoSloc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author patria
 */
@Service("mst351Service")
@Transactional(readOnly = true)
public class Mst351ServiceImpl implements Mst351Service{
    @Autowired
    @Qualifier("mst351ObjectDao")
    private Mst351ObjectDao mst351ObjectDao;
    
    @Override
    public DtoResponse getSlocData(String vitemcode) {
        List<Mst351VoSloc> data = mst351ObjectDao.getSloc(vitemcode);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getNoShip(DtoParamPaging input) {
        List<Mst351VoShip> data = mst351ObjectDao.getNoShip(input);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }
    
    @Override
    public DtoResponse getDataHdrShip(DtoParamPaging input) {
        List<Mst351VoShip> data = mst351ObjectDao.getHdrShip(input);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }
    
    @Override
    public DtoResponse getDataHdrShipList(DtoParamPaging input) {
        List<Mst351VoHdrShipList> data = mst351ObjectDao.getHdrShipList(input);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getCountSlocData(String vitemcode) {
        List<Mst351VoSloc> data = mst351ObjectDao.getCountSlocData(vitemcode);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getProcInput(DtoParamPaging input, String Token) {
        List<Object> data = mst351ObjectDao.getProcInput(input, Token);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getProcDelete(DtoParamPaging input,String Token) {
        List<Object> data = mst351ObjectDao.getProcDelete(input, Token);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getDataAcc(DtoParamPaging input) {
        List<Mst351VoAcc> data = mst351ObjectDao.getDataAcc(input);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getCountBOM() {
        List<Mst351VoCekAcc> data = mst351ObjectDao.getCountBOM();
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getSearchDtlAcc(DtoParamPaging param) {
        List<Mst351VoDataAcc> data = mst351ObjectDao.getSearchDtl(param);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getSearchDtlAcc1(DtoParamPaging param) {
        List<Mst351VoDataAcc> data = mst351ObjectDao.getSearchDtl1(param);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }
    
    @Override
    public DtoResponse getSearchDtlAcc2(DtoParamPaging param) {
        List<Mst351VoDataAcc> data = mst351ObjectDao.getSearchDtl2(param);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getDeleteAcc(DtoParamPaging input, String Token) {
        List<Object> data = mst351ObjectDao.getProcDeleteAcc(input, Token);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getReport() {
        List<Mst351VoSloc> data = mst351ObjectDao.getDataReport();
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getReport2() {
        List<Mst351VoSloc> data = mst351ObjectDao.getDataReport2();
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }

    @Override
    public DtoResponse getDataNoShip(DtoParamPaging param) {
        List<Mst351VoShip> data = mst351ObjectDao.getDataNoShip(param);
        return DtoHelper.constructResponse(StatusMsgEnum.SUKSES, null, data);
    }
}
