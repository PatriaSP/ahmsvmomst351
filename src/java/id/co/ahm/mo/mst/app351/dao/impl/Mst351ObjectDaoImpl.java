/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.dao.impl;

import id.co.ahm.jxf.dao.DefaultHibernateDao;
import id.co.ahm.jxf.dto.DtoParamPaging;
import id.co.ahm.mo.mst.app351.constant.Mst351Constant;
import id.co.ahm.mo.mst.app351.dao.Mst351ObjectDao;
import id.co.ahm.mo.mst.app351.vo.Mst351VoAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoCekAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoDataAcc;
import id.co.ahm.mo.mst.app351.vo.Mst351VoHdrShipList;
import id.co.ahm.mo.mst.app351.vo.Mst351VoShip;
import id.co.ahm.mo.mst.app351.vo.Mst351VoSloc;
import java.io.Serializable;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleConnection;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author patria
 */
@Repository("mst351ObjectDao")
public class Mst351ObjectDaoImpl extends DefaultHibernateDao<Object, Serializable> implements Mst351ObjectDao {

    @Override
    public List<Mst351VoSloc> getSloc(String vitemcode) {
        List<Mst351VoSloc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Lov_Storage_Loc);

        Query query = getCurrentSession().createSQLQuery(sql.toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoSloc vo = new Mst351VoSloc();
                vo.setVITEMCODE((String) obj[i++]);
                vo.setVITEMDESC((String) obj[i++]);
                vo.setVITEMNAME((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoShip> getNoShip(DtoParamPaging input) {
        List<Mst351VoShip> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Shipping_No);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("ISHIPYEAR", input.getSearch().get("ISHIPYEAR").toString());
        query.setString("VPLANID", input.getSearch().get("VPLANID").toString());
        query.setString("VSLOCID", input.getSearch().get("VSLOCID").toString());
        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoShip vo = new Mst351VoShip();
                vo.setISHIPNO(obj[i++].toString());
                vo.setDSHIPACT((String) obj[i++]);
                vo.setTRUCKNO((String) obj[i++]);
                vo.setVNODO((String) obj[i++]);
                vo.setVEXPDESC((String) obj[i++]);
                vo.setMSTOR_MPLANT_VPLANTID((String) obj[i++]);
                vo.setISHIPYEAR(obj[i++].toString());
                vo.setCSAREA_ID_CSAREA((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoShip> getHdrShip(DtoParamPaging input) {
        List<Mst351VoShip> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Hdr_Shipping);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("ISHIPNO", input.getSearch().get("ISHIPNO").toString());
        query.setString("ISHIPYEAR", input.getSearch().get("ISHIPYEAR").toString());
        query.setString("VPLANTID", input.getSearch().get("VPLANTID").toString());
        query.setString("VSLOCID", input.getSearch().get("VSLOCID").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoShip vo = new Mst351VoShip();
                vo.setCSAREA_ID_CSAREA((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoHdrShipList> getHdrShipList(DtoParamPaging input) {
        List<Mst351VoHdrShipList> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Shipping_List);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("ISHIPNO", input.getSearch().get("ISHIPNO").toString());
        query.setString("ISHIPYEAR", input.getSearch().get("ISHIPYEAR").toString());
        query.setString("VPLANTID", input.getSearch().get("VPLANTID").toString());
        query.setString("VSLOCID", input.getSearch().get("VSLOCID").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 5;
                Mst351VoHdrShipList vo = new Mst351VoHdrShipList();
                vo.setMENG_VENGNO((String) obj[i++]);
                vo.setMFRAME_VFRMNO(obj[i++].toString());
                vo.setDSHFUD_MTPCOL_RTYPE_VMCTYPEID((String) obj[i++]);
                vo.setDSHFUD_MTPCOL_MCOL_VCOLORID((String) obj[i++]);
                vo.setDSET_VITEMCODE_DPKCODE((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoSloc> getCountSlocData(String vitemcode) {
        List<Mst351VoSloc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Count_Storage_Loc);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("VITEMCODE", vitemcode);

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoSloc vo = new Mst351VoSloc();
                vo.setVITEMCODE((String) obj[i++]);
                vo.setVITEMDESC((String) obj[i++]);
                vo.setVITEMNAME((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Object> getProcInput(DtoParamPaging input, String Token) {
        List<Object> result = new ArrayList<>();
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{call PACKAHMMOMST169.PROCAHMMOMST169(?,?,?,?,?,?,?,?,?,?)}");

            call.setString(1, input.getSearch().get("1").toString());
            call.setString(2, input.getSearch().get("2").toString());
            call.setString(3, input.getSearch().get("3").toString());
            call.setString(4, input.getSearch().get("4").toString());
            call.setString(5, input.getSearch().get("5").toString());
            call.setString(6, input.getSearch().get("6").toString());
            call.setString(7, Token);
            call.setString(8, input.getSearch().get("8").toString());
            call.setString(9, input.getSearch().get("9").toString());
            call.registerOutParameter(10, Types.VARCHAR);

            call.execute();
            result.add(call.getString(10)== null ? null : call.getString(10).replaceAll("ORA-\\d{5}:", ""));
            return result;
        });
        return (List<Object>) doReturningWork;
    }

    @Override
    public List<Object> getProcDelete(DtoParamPaging input, String Token) {
        List<Object> result = new ArrayList<>();
        String tempFrame = input.getSearch().get("6").toString().replaceAll("\\[|\\]", "");;
        String tempEngine = input.getSearch().get("7").toString().replaceAll("\\[|\\]", "");
        String tempTipeMotor = input.getSearch().get("8").toString().replaceAll("\\[|\\]", "");
        String tempWarna = input.getSearch().get("9").toString().replaceAll("\\[|\\]", "");
        String tempJnsKemasan = input.getSearch().get("10").toString().replaceAll("\\[|\\]", "");
        
        String[] Frame = null;
        String[] Engine = null;
        String[] TipeMotor = null;
        String[] Warna = null;
        String[] JnsKemasan = null;
        
        if(!tempFrame.equals("") ){
            Frame = tempFrame.split(", ");
        }
        if(!tempEngine.equals("")){
            Engine = tempEngine.split(", ");
        }
        if(!tempTipeMotor.equals("")){
            TipeMotor = tempTipeMotor.split(", ");
        }
        if(!tempWarna.equals("")){
            Warna = tempWarna.split(", ");
        }
        if(!tempJnsKemasan.equals("")){
            JnsKemasan = tempJnsKemasan.split(", ");
        }
        
        String[] finalFrame = Frame;
        String[] finalEngine = Engine;
        String[] finalTipeMotor = TipeMotor;
        String[] finalWarna = Warna;
        String[] finalJnsKemasan = JnsKemasan;
        
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{call PACKAHMMOMST169.Procahmmomst169_Del_01(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            Array frame1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalFrame);
            Array engine1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalEngine);
            Array tipeMotor1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalTipeMotor);
            Array warna1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalWarna);
            Array jnsKemasan1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalJnsKemasan);
            call.setString(1, input.getSearch().get("1").toString());
            call.setString(2, input.getSearch().get("2").toString());
            call.setString(3, input.getSearch().get("3").toString());
            call.setString(4, input.getSearch().get("4").toString());
            call.setString(5, input.getSearch().get("5").toString());
            call.setArray(6, frame1);
            call.setArray(7, engine1);
            call.setArray(8, tipeMotor1);
            call.setArray(9, warna1);
            call.setArray(10, jnsKemasan1);
            call.setString(11, Token);
            call.setString(12, input.getSearch().get("12").toString());
            call.setString(13, input.getSearch().get("13").toString());
            call.registerOutParameter(14, Types.VARCHAR);

            call.execute();
            result.add(call.getString(14)== null ? null : call.getString(14).replaceAll("ORA-\\d{5}:", ""));
            return result;
        });
        return (List<Object>) doReturningWork;
    }

    @Override
    public List<Mst351VoAcc> getDataAcc(DtoParamPaging input) {
        List<Mst351VoAcc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Acc);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("ISHIPNO", input.getSearch().get("ISHIPNO").toString());
        query.setString("ISHIPYEAR", input.getSearch().get("ISHIPYEAR").toString());
        query.setString("VPLANTID", input.getSearch().get("VPLANTID").toString());
        query.setString("VSLOCID", input.getSearch().get("VSLOCID").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoAcc vo = new Mst351VoAcc();
                vo.setVMCTYPEID((String) obj[i++]);
                vo.setVCOLORID(obj[i++].toString());
                vo.setQTYSHIP(obj[i++].toString());
                vo.setVPLANTID((String) obj[i++]);
                vo.setISHIPNO(obj[i++].toString());
                vo.setISHIPYEAR(obj[i++].toString());
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoCekAcc> getCountBOM() {;
        List<Mst351VoCekAcc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Count_BOM_Acc);

        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
        
        Mst351VoCekAcc vo = new Mst351VoCekAcc();
        String number =  query.uniqueResult().toString();
        
        vo.setTotal(Integer.parseInt(number));
        result.add(vo);
        
        return result;
    }

    @Override
    public List<Mst351VoDataAcc> getSearchDtl(DtoParamPaging input) {
        List<Mst351VoDataAcc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Dtl_Acc);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("JUMLAH", input.getSearch().get("JUMLAH").toString());
        query.setString("PLANTID", input.getSearch().get("PLANTID").toString());
        query.setString("COLORID", input.getSearch().get("COLORID").toString());
        query.setString("TYPEID", input.getSearch().get("TYPEID").toString());
        query.setString("JUMLAH1", input.getSearch().get("JUMLAH1").toString());
        query.setString("PLANTID1", input.getSearch().get("PLANTID1").toString());
        query.setString("COLORID1", input.getSearch().get("COLORID1").toString());
        query.setString("TYPEID1", input.getSearch().get("TYPEID1").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoDataAcc vo = new Mst351VoDataAcc();
                vo.setNoPart((String) obj[i++]);
                vo.setDescPart(obj[i++].toString());
                vo.setUseQTY(obj[i++].toString());
                vo.setMcTypeId((String) obj[i++]);
                vo.setColorId(obj[i++].toString());
                vo.setPlantId(obj[i++].toString());
                vo.setQty(obj[i++].toString());
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoDataAcc> getSearchDtl1(DtoParamPaging input) {
        List<Mst351VoDataAcc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Dtl_Acc1);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("JUMLAH", input.getSearch().get("JUMLAH").toString());
        query.setString("PLANTID", input.getSearch().get("PLANTID").toString());
        query.setString("COLORID", input.getSearch().get("COLORID").toString());
        query.setString("TYPEID", input.getSearch().get("TYPEID").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoDataAcc vo = new Mst351VoDataAcc();
                vo.setNoPart((String) obj[i++]);
                vo.setDescPart(obj[i++].toString());
                vo.setUseQTY(obj[i++].toString());
                vo.setQty(obj[i++].toString());
                result.add(vo);
            }
        }

        return result;
    }
    
    public List<Mst351VoDataAcc> getSearchDtl2(DtoParamPaging input) {
        List<Mst351VoDataAcc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Dtl_Acc2);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("JUMLAH", input.getSearch().get("JUMLAH").toString());
        query.setString("COLORID", input.getSearch().get("COLORID").toString());
        query.setString("TYPEID", input.getSearch().get("TYPEID").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoDataAcc vo = new Mst351VoDataAcc();
                vo.setNoPart((String) obj[i++]);
                vo.setDescPart(obj[i++].toString());
                vo.setUseQTY(obj[i++].toString());
                vo.setQty(obj[i++].toString());
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Object> getProcDeleteAcc(DtoParamPaging input, String Token) {
        List<Object> result = new ArrayList<>();
        String tempQty = input.getSearch().get("5").toString().replaceAll("\\[|\\]", "");
        String tempQtyStd = input.getSearch().get("6").toString().replaceAll("\\[|\\]", "");
        String tempPartnum = input.getSearch().get("7").toString().replaceAll("\\[|\\]", "");
        String tempType = input.getSearch().get("8").toString().replaceAll("\\[|\\]", "");
        String tempColor = input.getSearch().get("9").toString().replaceAll("\\[|\\]", "");
        
        String[] arrNqty = null;
        String[] arrNqtyStd = null;
        String[] arrPartnum = null;
        String[] arrType = null;
        String[] arrColor = null;
        
        if(!tempQty.equals("") ){
            arrNqty = tempQty.split(", ");
        }
        if(!tempQtyStd.equals("")){
            arrNqtyStd = tempQtyStd.split(", ");
        }
        if(!tempPartnum.equals("")){
            arrPartnum = tempPartnum.split(", ");
        }
        if(!tempType.equals("")){
            arrType = tempType.split(", ");
        }
        if(!tempColor.equals("")){
            arrColor = tempColor.split(", ");
        }
        
        String[] finalNqty = arrNqty;
        String[] finalNqtystd = arrNqtyStd;
        String[] finalPartnum = arrPartnum;
        String[] finalType = arrType;
        String[] finalColor = arrColor;
        
        
        
        Object doReturningWork = getCurrentSession().doReturningWork((Connection connection) -> {
            CallableStatement call = connection.prepareCall("{call PACKAHMMOMST169.Procahmmomst169_Del_02(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            Array arrNqty1 = ((OracleConnection) connection).createOracleArray("TYARNUMBER", finalNqty);
            Array arrNqtyStd1 = ((OracleConnection) connection).createOracleArray("TYARNUMBER", finalNqtystd);
            Array arrPartnum1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalPartnum);
            Array arrType1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalType);
            Array arrColor1 = ((OracleConnection) connection).createOracleArray("TYARVARCHAR", finalColor);
            call.setString(1, input.getSearch().get("1").toString());
            call.setString(2, input.getSearch().get("2").toString());
            call.setString(3, input.getSearch().get("3").toString());
            call.setString(4, input.getSearch().get("4").toString());
            call.setArray(5, arrNqty1);
            call.setArray(6, arrNqtyStd1);
            call.setArray(7, arrPartnum1);
            call.setArray(8, arrType1);
            call.setArray(9, arrColor1);
            call.setString(10, Token);
            call.setString(11, input.getSearch().get("11").toString());
            call.setString(12, input.getSearch().get("12").toString());
            call.registerOutParameter(13, Types.VARCHAR);

            call.execute();
            result.add(call.getString(13)== null ? null : call.getString(13).replaceAll("ORA-\\d{5}:", ""));
            return result;
        });
        return (List<Object>) doReturningWork;
    }

    @Override
    public List<Mst351VoSloc> getDataReport() {
        List<Mst351VoSloc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Report);

        Query query = getCurrentSession().createSQLQuery(sql.toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoSloc vo = new Mst351VoSloc();
                vo.setVITEMNAME((String) obj[i++]);
                vo.setVITEMDESC((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoSloc> getDataReport2() {
        List<Mst351VoSloc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Data_Report2);

        Query query = getCurrentSession().createSQLQuery(sql.toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoSloc vo = new Mst351VoSloc();
                vo.setVITEMNAME((String) obj[i++]);
                vo.setVITEMDESC((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

    @Override
    public List<Mst351VoShip> getDataNoShip(DtoParamPaging input) {
        List<Mst351VoShip> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(Mst351Constant.Cek_No_Ship);

        Query query = getCurrentSession().createSQLQuery(sql.toString());
        query.setString("ISHIPNO", input.getSearch().get("ISHIPNO").toString());
        query.setString("ISHIPYEAR", input.getSearch().get("ISHIPYEAR").toString());
        query.setString("VPLANTID", input.getSearch().get("VPLANTID").toString());
        query.setString("VSLOCID", input.getSearch().get("VSLOCID").toString());

        if (query.list().size() > 0) {
            List<Object[]> list = query.list();

            for (Object[] obj : list) {
                int i = 0;
                Mst351VoShip vo = new Mst351VoShip();
                vo.setISHIPNO(obj[i++].toString());
                vo.setDSHIPACT((String) obj[i++]);
                vo.setTRUCKNO((String) obj[i++]);
                vo.setVNODO((String) obj[i++]);
                vo.setVEXPDESC((String) obj[i++]);
                vo.setMSTOR_MPLANT_VPLANTID((String) obj[i++]);
                vo.setISHIPYEAR(obj[i++].toString());
                vo.setCSAREA_ID_CSAREA((String) obj[i++]);
                result.add(vo);
            }
        }

        return result;
    }

}
