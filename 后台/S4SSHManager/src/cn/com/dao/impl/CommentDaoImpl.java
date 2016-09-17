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
/**
 * 评论操作实现类
 * @author lej
 */
public class CommentDaoImpl extends BaseDao implements ICommentDao, IPageDao {
          /**
           * 添加评论的方法
           * @parma comment
           * @return int
           */
	@Override
	public int addComment(Comment1 comment) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			super.getHibernateTemplate().save(comment);  //加入
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 删除评论的方法
           * @parma comment
           * @return int
           */
	@Override
	public int deleteComment(Comment1 comment) {
		// TODO Auto-generated method stub

		int count = 0;
		try {
			super.getHibernateTemplate().delete(comment); //删除
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 获取评论的方法
           * @parma comment
           * @return Comment
           */
	@Override
	public Comment1 getComment(Comment1 comment) {
		// TODO Auto-generated method stub
		Comment1 _comment = null;
		String sql = " from Comment1 where CId=?";

		try {
			_comment = (Comment1) super.getHibernateTemplate()
					.find(sql, comment.getCId()).get(0);  //获取结果
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return _comment;
	}
          /**
           * 获取两条最新的评论的方法
           * @parma comment
           * @parma min 最小行
           * @parma max 最大行
           * @return Map<Long,Comment>
           */
	@Override
	public Map<Long, Comment1> getTheTowComment(Comment1 comment, int min, int max) {
		// TODO Auto-generated method stub
		Map<Long, Comment1> comMap = new HashMap<Long, Comment1>();

	
		String hql="from Comment1 where CAdmin=?   order by CDate desc";
		//参数准备
           List<Object> parmas=new ArrayList<Object>();
           parmas.add(comment.getCAdmin());
		try {
			List<Comment1> comlist = PageUtil.querylist(min, max, hql, parmas);  //获取指定行数区间符合条件的结果集
					//遍历结果集。将结果压入map中
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
          /**
           * 获取评论总记录条数的方法
           * @return Long
           */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count = null;

		StringBuffer sql = new StringBuffer(
				"select count(*) from Comment1 where 1=1");
                 
		try {
			 //获取结果
			count = (Long) super.getHibernateTemplate().find(sql.toString())
					.listIterator().next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 分页获取评论信息
           * @param curPage 当前页
           * @param rowsPrePage 每页展示条数
           * @return Map<Long, Object> 
           */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub

		Map<Long, Object> trendsMap = new HashMap<Long, Object>();

	
   String hql="from Comment1 order by CDate desc";
		try {
			List<Comment1> list = PageUtil.querylist(curPage, rowsPrePage, hql, null); //获取结果集
			//遍历结果集，加入map中
			for (Comment1 o : list) {
				trendsMap.put(o.getCId(), o);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendsMap;
	}
          /**
           * 修改评论的方法
           * @parma comment
           * @return int
           */
	@Override
	public int updateComment(Comment1 comment) {
		// TODO Auto-generated method stub
		String sql="update Comment1 set CBt=?,CImg=?,CAdmin=? where CId=?" ;
		//返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{comment.getCBt(),comment.getCImg(),comment.getCAdmin(),comment.getCId()});
	}

}
