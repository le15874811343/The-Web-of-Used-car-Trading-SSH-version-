package cn.com.dao;

import java.util.Map;
import cn.com.pojo.*;
public interface IPriceIntervalDao {
  public Map<Integer,Priceinterval> getPriceIntervalByCount();
}
