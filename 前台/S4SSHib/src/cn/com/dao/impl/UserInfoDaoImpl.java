package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;

public class UserInfoDaoImpl extends BaseDao implements IUserInfoDao, IPageDao {

	@Override
	public Userinfo3 login(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		Userinfo3 _userInfo = null;
		StringBuffer sql = new StringBuffer(" from Userinfo3 ");
		sql.append("where UTel=? and UPwd=?");

		try {
		List<Userinfo3>	_userlist = super.getHibernateTemplate().find(
					sql.toString(),
					new Object[] { userInfo.getUTel(), userInfo.getUPwd() });
		if(_userlist.size()>0){
			_userInfo=_userlist.get(0);
		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userInfo;
	}

	@Override
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		Userinfo3 _userInfo = null;
		StringBuffer sql = new StringBuffer("from Userinfo3 ");
		sql.append("where 1=1 ");
		List<Object> parmas = new ArrayList<Object>();
		if (userInfo.getUTel() != 0) {
			sql.append(" and UTel=? ");
			parmas.add(userInfo.getUTel());
		}
		Object[] o = new Object[parmas.size()];
		for (int i = 0; i < parmas.size(); i++) {
			o[i] = parmas.get(i);
		}

		try {
			List<Userinfo3> userlist = super.getHibernateTemplate()
					.find(sql.toString(), o);
			if(userlist.size()>0){
				_userInfo=userlist.get(0);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userInfo;
	}

	@Override
	public int addUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(userInfo);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int updateUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("update  Userinfo3 set UId=? ");
		List<Object> params = new ArrayList<Object>();
		params.add(userInfo.getUId());
		if (userInfo.getUName() != null) {
			sql.append(" , UName=?");
			params.add(userInfo.getUName());
		}
		if (userInfo.getUSex() != null) {
			sql.append(" , USex=?");
			params.add(userInfo.getUSex());
		}
		if (userInfo.getUCard() != null) {
			sql.append(" , UCard=?");
			params.add(userInfo.getUCard());
		}
		if (userInfo.getUAdr() != null) {
			sql.append(" , UAdr=?");
			params.add(userInfo.getUAdr());
		}
		if (userInfo.getUQq() != null) {
			sql.append(" , UQq=?");
			params.add(userInfo.getUQq());
		}
		if (userInfo.getUEmail() != null) {
			sql.append(" , UEmail=?");
			params.add(userInfo.getUEmail());
		}

		sql.append(" where UId=?");
		params.add(userInfo.getUId());
		Object[] o = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			o[i] = params.get(i);
		}

		return super.getHibernateTemplate().bulkUpdate(sql.toString(), o);
	}

	@Override
	public int updateUserPwd(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(
				"update Userinfo3 set UPwd=? where UId=?");

		return super.getHibernateTemplate().bulkUpdate(sql.toString(),
				new Object[] { userInfo.getUPwd(), userInfo.getUId() });
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
		Long count = null;
		Userinfo3 userInfo = (Userinfo3) object;
		List<Object> parmas = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				"select count(*) from Userinfo3 where 1=1");
		if (userInfo.getUAdmin() != null) {
			sql.append(" and UAdmin=?");
			parmas.add(userInfo.getUAdmin());
		}
		Object[] o = new Object[parmas.size()];
		for (int i = 0; i < parmas.size(); i++) {
			o[i] = parmas.get(i);
		}

		try {
			count = (Long) super.getHibernateTemplate()
					.find(sql.toString(), o).listIterator().next();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Userinfo3 userInfo = (Userinfo3) object;
		StringBuffer sql = new StringBuffer(
				"select * from(select rownum rn , b.* from(select  a.* from Userinfo3  a  where 1=1");
		Map<Long, Object> userMap = new HashMap<Long, Object>();
		List<Object> params = new ArrayList<Object>();

		if (userInfo.getUAdmin() != null) {
			sql.append(" and UAdmin=?");
			params.add(userInfo.getUAdmin());
		}
	   
		
		try {
			List<Userinfo3> ulist = PageUtil.querylist(curPage, rowsPrePage, sql.toString(), params);
			for (Userinfo3 u : ulist) {
				userMap.put(u.getUId(), u);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userMap;
	}

}
