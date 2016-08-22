package cn.com.dao;

import java.util.*;

import cn.com.pojo.*;

public interface ITrendsDao {
       public List<Trends>  getITrendsByTime(Trends trends,int rows);
       public Trends getTrendsByWhere(Trends trends);
}
