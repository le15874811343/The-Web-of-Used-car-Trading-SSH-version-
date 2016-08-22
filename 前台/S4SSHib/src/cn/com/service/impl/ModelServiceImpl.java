package cn.com.service.impl;

import java.util.*;


import cn.com.pojo.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class ModelServiceImpl implements IModelService{
  private IModelDao modelDao=null;

public IModelDao getModelDao() {
	return modelDao;
}

public void setModelDao(IModelDao modelDao) {
	this.modelDao = modelDao;
}

@Override
public List<Model> getModelByWhere(Model model) {
	// TODO Auto-generated method stub
	return modelDao.getModelByWhere(model);
}
}
