package id.co.ahm.mo.mst.app351.service;

import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.jxf.dto.DtoResponse;

public interface Mst351Service {

    public DtoResponse getSlocData(String vitemcode);
    
    public DtoResponse getNoShip(DtoParamPaging input);

    public DtoResponse getDataHdrShip(DtoParamPaging input);

    public DtoResponse getDataHdrShipList(DtoParamPaging param);

    public DtoResponse getCountSlocData(String vitemcode);

    public DtoResponse getProcInput(DtoParamPaging input, String Token);

    public DtoResponse getDataAcc(DtoParamPaging input);

    public DtoResponse getProcDelete(DtoParamPaging param, String Token);

    public DtoResponse getCountBOM();

    public DtoResponse getSearchDtlAcc(DtoParamPaging param);

    public DtoResponse getSearchDtlAcc1(DtoParamPaging param);

    public DtoResponse getSearchDtlAcc2(DtoParamPaging param);

    public DtoResponse getDeleteAcc(DtoParamPaging param, String Token);

    public DtoResponse getReport();

    public DtoResponse getReport2();

    public DtoResponse getDataNoShip(DtoParamPaging param);

}
