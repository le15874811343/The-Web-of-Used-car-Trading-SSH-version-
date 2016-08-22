package cn.com.dao;

import java.util.List;
import java.util.Map;

import cn.com.pojo.*;

public interface ICarchartDao {
public List<Carchart> chartinfo(int year,int month);
public List<Carchart> chartinfo( );
public Map<String, Carchart> chartinfo(int year,int month,int day);
public Map<String, Carchart> chartinfo(int year);
}
