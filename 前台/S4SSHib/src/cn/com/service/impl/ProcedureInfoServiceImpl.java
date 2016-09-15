package cn.com.service.impl;

import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;
import cn.com.dao.impl.ProcedureInfoDaoImpl;
import cn.com.service.IProcedureInfoService;
/**
 * 手续信息服务实现类
 * @author lej
 */
public class ProcedureInfoServiceImpl implements IProcedureInfoService{
	//手续信息操作接口的引用
private IProcedureInfoDao procedureInfoDaoImpl=null;
	public IProcedureInfoDao getProcedureInfoDaoImpl() {
	return procedureInfoDaoImpl;
}

public void setProcedureInfoDaoImpl(IProcedureInfoDao procedureInfoDaoImpl) {
	this.procedureInfoDaoImpl = procedureInfoDaoImpl;
}
 /**
   * 
   * 获取所有手续信息的服务
   *@return Map<Long,ProcedureInfo> 
   */
	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getAllProcedureInfo();
	}
  /**
   * 
   * 根据编号获取手续信息的服务
   *@return ProcedureInfo
   */
	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getProcedureInfoById(carInfo);
	}
 /**
   * 
   * 添加手续信息的服务
   *@return boolean
   */
	@Override
	public boolean addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.addProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		return flag;
	}
 /**
   * 
   * 修改手续信息的服务
   *@return  boolean
   */
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
