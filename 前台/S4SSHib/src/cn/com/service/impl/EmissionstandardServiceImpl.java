package cn.com.service.impl;
import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.IEmissionstandardDao;
import cn.com.dao.impl.*;
import cn.com.service.*;

public class EmissionstandardServiceImpl implements IEmissionstandardService {
    private IEmissionstandardDao emissionstandardDao=null;
	public IEmissionstandardDao getEmissionstandardDao() {
		return emissionstandardDao;
	}
	public void setEmissionstandardDao(IEmissionstandardDao emissionstandardDao) {
		this.emissionstandardDao = emissionstandardDao;
	}
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandardByCount();
	}

}
