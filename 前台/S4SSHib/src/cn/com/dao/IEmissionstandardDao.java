package cn.com.dao;

import java.util.*;
import cn.com.pojo.*;
/**
 * 
 * 排放标准操作接口
 *@author  lej
 */
public interface IEmissionstandardDao {
	/**
	 * 按热度获取排放标准信息的方法
	 * @return  Map<Integer,Emissionstandard>
	 */
	public Map<Integer,Emissionstandard> getEmissionstandardByCount();
}
