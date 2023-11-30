/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.dao;

import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.mo.mst.app351.vo.Mst351VoAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoCekAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoDataAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoHdrShipList;
import id.co.ahm.mo.mst.app351.vo.Mst351VoShip;
import id.co.ahm.mo.mst.app351.vo.Mst351VoSloc;
import java.util.List;

/**
 *
 * @author patria
 */
public interface Mst351ObjectDao {

    public List<Mst351VoSloc> getSloc(String vitemcode);
    
    public List<Mst351VoShip> getNoShip(DtoParamPaging input);

    public List<Mst351VoShip> getHdrShip(DtoParamPaging input);

    public List<Mst351VoHdrShipList> getHdrShipList(DtoParamPaging input);

    public List<Mst351VoSloc> getCountSlocData(String vitemcode);

    public List<Object> getProcInput(DtoParamPaging input, String Token);

    public List<Object> getProcDelete(DtoParamPaging input, String Token);

    public List<Mst351VoAcc> getDataAcc(DtoParamPaging input);

    public List<Mst351VoCekAcc> getCountBOM();

    public List<Mst351VoDataAcc> getSearchDtl(DtoParamPaging input);

    public List<Mst351VoDataAcc> getSearchDtl1(DtoParamPaging param);

    public List<Mst351VoDataAcc> getSearchDtl2(DtoParamPaging param);

    public List<Object> getProcDeleteAcc(DtoParamPaging input, String Token);

    public List<Mst351VoSloc> getDataReport();

    public List<Mst351VoSloc> getDataReport2();

    public List<Mst351VoShip> getDataNoShip(DtoParamPaging param);
}
