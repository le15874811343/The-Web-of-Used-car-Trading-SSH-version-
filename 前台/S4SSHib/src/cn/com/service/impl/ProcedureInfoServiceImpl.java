package cn.com.service.impl;

import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;
import cn.com.dao.impl.ProcedureInfoDaoImpl;
import cn.com.service.IProcedureInfoService;

public class ProcedureInfoServiceImpl implements IProcedureInfoService{
private IProcedureInfoDao procedureInfoDaoImpl=null;
	public IProcedureInfoDao getProcedureInfoDaoImpl() {
	return procedureInfoDaoImpl;
}

public void setProcedureInfoDaoImpl(IProcedureInfoDao procedureInfoDaoImpl) {
	this.procedureInfoDaoImpl = procedureInfoDaoImpl;
}

	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getAllProcedureInfo();
	}

	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getProcedureInfoById(carInfo);
	}

	@Override
	public boolean addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.addProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.updateProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		
		return flag;
	}

}
