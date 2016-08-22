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

public class HardwareConfigDaoImpl extends BaseDao implements IHardwareConfig {

	@Override
	public Map<Long, Hardwareconfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		String sql = " from Hardwareconfig";
		Map<Long, Hardwareconfig> hardMap = new HashMap<Long, Hardwareconfig>();
	
		try {
		List<Hardwareconfig> harlist=	super.getHibernateTemplate().find(sql);
		for(Hardwareconfig h:harlist){
			hardMap.put(h.getCId(), h);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hardMap;
	}

	@Override
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Hardwareconfig hardwareConfig2 = null;
		String sql = "from Hardwareconfig where UId=? and CId=?";
	
		
		try {
			hardwareConfig2=	(Hardwareconfig) super.getHibernateTemplate().find(sql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hardwareConfig2;
	}

	@Override
	public int addHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(hardwareConfig);
			count=1;
			}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		
		StringBuffer sql = new StringBuffer(
				"update  Hardwareconfig set consoleLcdScreen=?,autoLight=?,headLights=?,lightWash=?,efgv=?,seatNumber=?,fuelForm=?,cvt=?,drivingMethod=?,pke=?,keyLessgo=?,sunRoof=?,leatherSeat=? where u_id=? and c_id=?");
		
        
		return  super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{hardwareConfig.getConsolelcdscreen(),hardwareConfig.getAutolight(),hardwareConfig.getHeadlights()
      	  ,hardwareConfig.getLightwash(),hardwareConfig.getEfgv(),hardwareConfig.getSeatnumber(),hardwareConfig.getFuelform(),hardwareConfig.getCvt()
    	  
        ,hardwareConfig.getDrivingmethod(),hardwareConfig.getPke(),hardwareConfig.getKeylessgo(),hardwareConfig.getSunroof(),hardwareConfig.getLeatherseat(),hardwareConfig.getUId()
        ,hardwareConfig.getCId()});

	}

}
