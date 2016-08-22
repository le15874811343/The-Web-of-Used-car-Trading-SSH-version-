package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.pojo.*;
import cn.com.dao.IPageDao;
import cn.com.dao.IPersonCarDao;

import cn.com.service.*;

public class PersonCarServiceImpl implements IPerSonCarService,IPageDao {
   private IPersonCarDao personCarDao=null;
   private IPageDao  personcarPage=null;
   
	public IPersonCarDao getPersonCarDao() {
	return personCarDao;
}
public void setPersonCarDao(IPersonCarDao personCarDao) {
	this.personCarDao = personCarDao;
}
public IPageDao getPersoncarPage() {
	return personcarPage;
}
public void setPersoncarPage(IPageDao personcarPage) {
	this.personcarPage = personcarPage;
}
	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
	@Override
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPerSonCarMapByWhere(perSonCar);
	}
	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personcarPage.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personcarPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addPerSonCar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.addPerSonCar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deletePerSoncar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePerSoncar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePerSoncar(Personcar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSoncar(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,
			Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersonList(curPage, rowsPrePage, perSonCar);
	}
	@Override
	public boolean deletepersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletepersoncaruser(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
	@Override
	public boolean deletecidpersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletecidpersoncaruser(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
	@Override
	public boolean checkipersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkipersonuser(p);
	}
	@Override
	public boolean checkcidipersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcidipersonuser(p);
	}
	@Override
	public boolean deletePersonByAll(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePersonByAll(perSonCar)>0)
		{
			flag=true;
		}
		
		return flag;
	}
	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersoncar(personcar);
	}
	@Override
	public boolean checkcuidperson(Personcar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcuidperson(p);
	}
	@Override
	public boolean deletecuidperson(Personcar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletecuidperson(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
}
