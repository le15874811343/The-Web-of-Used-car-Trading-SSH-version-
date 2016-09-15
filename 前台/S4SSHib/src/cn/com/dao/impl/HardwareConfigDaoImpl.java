package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.IHardwareConfig;
import cn.com.util.DbUtil;
/**
 * 汽车硬件配置信息操作实现类
 *@author lej 
 */
public class HardwareConfigDaoImpl extends BaseDao implements IHardwareConfig {
  /**
   * 
   * 获取所有汽车硬件配置信息的方法
   *@return Map<Long,HardwareConfig> 
   */
	@Override
	public Map<Long, Hardwareconfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		String sql = " from Hardwareconfig";
		Map<Long, Hardwareconfig> hardMap = new HashMap<Long, Hardwareconfig>();
	
		try {
		List<Hardwareconfig> harlist=	super.getHibernateTemplate().find(sql); //获取结果集
		//遍历结果集，加入map中
		for(Hardwareconfig h:harlist){
			hardMap.put(h.getCId(), h);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hardMap;
	}
/**
 * 按编号获取汽车硬件配置信息的方法
 * @parma carInfo
 * @return HardwareConfig 
 */
	@Override
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Hardwareconfig hardwareConfig2 = null;
		String sql = "from Hardwareconfig where UId=? and CId=?";
	
		
		try {
			//获取结果
			hardwareConfig2=	(Hardwareconfig) super.getHibernateTemplate().find(sql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hardwareConfig2;
	}
/**
 * 添加汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
	@Override
	public int addHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(hardwareConfig);//加入
			count=1;
			}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return count;
	}
/**
 * 修改汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
	@Override
	public int updateHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		
		StringBuffer sql = new StringBuffer(
				"update  Hardwareconfig set consoleLcdScreen=?,autoLight=?,headLights=?,lightWash=?,efgv=?,seatNumber=?,fuelForm=?,cvt=?,drivingMethod=?,pke=?,keyLessgo=?,sunRoof=?,leatherSeat=? where u_id=? and c_id=?");
		
          //返回受影响的行数
		return  super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{hardwareConfig.getConsolelcdscreen(),hardwareConfig.getAutolight(),hardwareConfig.getHeadlights()
      	  ,hardwareConfig.getLightwash(),hardwareConfig.getEfgv(),hardwareConfig.getSeatnumber(),hardwareConfig.getFuelform(),hardwareConfig.getCvt()
    	  
        ,hardwareConfig.getDrivingmethod(),hardwareConfig.getPke(),hardwareConfig.getKeylessgo(),hardwareConfig.getSunroof(),hardwareConfig.getLeatherseat(),hardwareConfig.getUId()
        ,hardwareConfig.getCId()});

	}

}
