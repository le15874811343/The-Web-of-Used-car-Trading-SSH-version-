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
}
