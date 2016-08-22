package cn.com.service;

import java.util.List;



import cn.com.pojo.Price;

public interface IPriceService {
	public   List<Price> getsellinfo(int year,int month,int day);
	public List<Price> getsellinfo(int year,int month);
	public  List<Price> getsellinfo(int year);
	public List<Price> getsellinfo();
}
