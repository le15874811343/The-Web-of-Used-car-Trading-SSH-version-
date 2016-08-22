package cn.com.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PageUtil {
	/**
	 * 查询分页
	 * @param pageNo 第几页
	 * @param pageSize 页面记录数
	 * @param hql 查询语句
	 * @return List
	 */

	private int curPage;// 当前页码
	private int rowsPrePage;// 每页记录条数
	private int maxPage;// 总共有多少页
	private Long maxRowsCount;// 总共有多少条数据

	/**
	 * 构造方法
	 * @param rowsPrePage 每页记录条数
	 * @param maxRowsCount 总共有多少条数据
	 */
	public PageUtil(int rowsPrePage, Long maxRowsCount) {

		this.rowsPrePage = rowsPrePage;
		this.maxRowsCount = maxRowsCount;
		maxPage();//
	}

	public PageUtil() {

	}

	// 计算总页码
	public void maxPage() {

		if (maxRowsCount % rowsPrePage == 0) {

			maxPage = Integer.parseInt(maxRowsCount.toString()) / rowsPrePage;
		} else {
			maxPage = Integer.parseInt(maxRowsCount.toString())  / rowsPrePage + 1;
		}
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowsPrePage() {
		return rowsPrePage;
	}

	public void setRowsPrePage(int rowsPrePage) {
		this.rowsPrePage = rowsPrePage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public Long getMaxRowsCount() {
		return maxRowsCount;
	}

	public void setMaxRowsCount(Long maxRowsCount) {
		this.maxRowsCount = maxRowsCount;
	}
	public static List querylist(int pageNo,int pageSize,String hql,List<Object> parmas ){
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(hql);
		int firstReusultIndex=pageSize*(pageNo-1);//计算记录起始数
		query.setFirstResult(firstReusultIndex);//设置记录起始数
		query.setMaxResults(pageSize);//设置最大记录数
	   if(parmas!=null){
		   
		   for(int i=0;i<parmas.size();i++){
			   System.out.println(parmas.get(i));
			   query.setParameter(i, parmas.get(i));
		   }
	   }
	 
		return query.list();
	}
	

}
