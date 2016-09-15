package cn.com.service.impl;
import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.IEmissionstandardDao;
import cn.com.dao.impl.*;
import cn.com.service.*;
/**
 * 
 * 排放标准服务实现类
 *@author  lej
 */
public class EmissionstandardServiceImpl implements IEmissionstandardService {
	//排放标准操作接口的引用
    private IEmissionstandardDao emissionstandardDao=null;
	public IEmissionstandardDao getEmissionstandardDao() {
		return emissionstandardDao;
	}
	public void setEmissionstandardDao(IEmissionstandardDao emissionstandardDao) {
		this.emissionstandardDao = emissionstandardDao;
	}
	/**
	 * 按热度获取排放标准信息的服务
	 * @Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandardByCount();
	}

}
