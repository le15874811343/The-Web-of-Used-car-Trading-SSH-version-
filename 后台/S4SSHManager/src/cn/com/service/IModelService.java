package cn.com.service;

import java.util.*;

import cn.com.pojo.*;
/**
 * 车系信息服务接口
 * @author lej
 */
public interface IModelService {
      /**
       * 按条件获取车系信息的服务
       * @parma model
       *@return List<Model> 
       */
	public List<Model> getModelByWhere(Model model);
      /**
       * 添加车系信息的服务
       * @parma model
       *@return boolean
       */
	public boolean addModel(Model model);
      /**
       * 修改车系信息的服务
       * @parma model
       *@return boolean
       */
	public boolean updateModel(Model model);
      /**
       * 删除车系信息的服务
       * @parma model
       *@return boolean
       */
	public boolean deleteModel(Model model);
}
