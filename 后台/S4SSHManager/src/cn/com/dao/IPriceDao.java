package cn.com.dao;

import java.util.List;
import cn.com.pojo.*;

public interface IPriceDao {
	public  List<Price> getsellinfo(int year,int month,int day);
	public List<Price> getsellinfo(int year,int month);
	public List<Price> getsellinfo(int year);
	public List<Price> getsellinfo();
}
