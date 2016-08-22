package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.pojo.*;
import cn.com.dao.ICommentDao;
import cn.com.dao.IPageDao;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

public class CommentDaoImpl extends BaseDao implements ICommentDao, IPageDao {

	@Override
	public int addComment(Comment1 comment) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			super.getHibernateTemplate().save(comment);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteComment(Comment1 comment) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			super.getHibernateTemplate().delete(comment);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Comment1 getComment(Comment1 comment) {
		// TODO Auto-generated method stub
		Comment1 _comment = null;
		String sql = " from Comment1 where CId=?";

		try {
			_comment = (Comment1) super.getHibernateTemplate()
					.find(sql, comment.getCId()).get(0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return _comment;
	}

	@Override
	public Map<Long, Comment1> getTheTowComment(Comment1 comment, int min, int max) {
		// TODO Auto-generated method stub
		Map<Long, Comment1> comMap = new HashMap<Long, Comment1>();

	
		String hql="from Comment1 where CAdmin=?   order by CDate desc";
           List<Object> parmas=new ArrayList<Object>();
           parmas.add(comment.getCAdmin());
		try {
			List<Comment1> comlist = PageUtil.querylist(min, max, hql, parmas);
					
			for (Comment1 c : comlist) {
				comMap.put(c.getCId(), c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comMap;
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

		StringBuffer sql = new StringBuffer(
				"select count(*) from Comment1 where 1=1");
                 
		try {
			count = (Long) super.getHibernateTemplate().find(sql.toString())
					.listIterator().next();
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

		Map<Long, Object> trendsMap = new HashMap<Long, Object>();

	
   String hql="from Comment1 order by CDate desc";
		try {
			List<Comment1> list = PageUtil.querylist(curPage, rowsPrePage, hql, null);
			for (Comment1 o : list) {
				trendsMap.put(o.getCId(), o);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsMap;
	}

}
