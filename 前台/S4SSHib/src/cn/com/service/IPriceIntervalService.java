package cn.com.service;

import java.util.Map;


import cn.com.pojo.*;
/**
 * 价格区间服务接口
 * @author lej
 */
public interface IPriceIntervalService {
  /**
   * 
   * 按热度获取价格区间信息的服务
   * @return Map<Integer,PriceInterval>
   */
	public Map<Integer, Priceinterval> getPriceIntervalByCount();
}
