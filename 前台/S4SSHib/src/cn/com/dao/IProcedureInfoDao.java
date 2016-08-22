package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;

public interface IProcedureInfoDao {
public Map<Long, Procedureinfo> getAllProcedureInfo();
public Procedureinfo getProcedureInfoById(Carinfo carInfo);
public int addProcedureInfo(Procedureinfo procedureInfo);
public int updateProcedureInfo(Procedureinfo procedureInfo);
}
