package cn.com.service;

import java.util.*;

import cn.com.pojo.*;

public interface IModelService {
	public List<Model> getModelByWhere(Model model);
	public boolean addModel(Model model);
	public boolean updateModel(Model model);
	public boolean deleteModel(Model model);
}
