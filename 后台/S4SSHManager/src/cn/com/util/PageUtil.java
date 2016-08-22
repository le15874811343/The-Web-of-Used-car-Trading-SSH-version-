package cn.com.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PageUtil {
	/**
	 * ��ѯ��ҳ
	 * @param pageNo �ڼ�ҳ
	 * @param pageSize ҳ���¼��
	 * @param hql ��ѯ���
	 * @return List
	 */

	private int curPage;// ��ǰҳ��
	private int rowsPrePage;// ÿҳ��¼����
	private int maxPage;// �ܹ��ж���ҳ
	private Long maxRowsCount;// �ܹ��ж���������

	/**
	 * ���췽��
	 * @param rowsPrePage ÿҳ��¼����
	 * @param maxRowsCount �ܹ��ж���������
	 */
	public PageUtil(int rowsPrePage, Long maxRowsCount) {

		this.rowsPrePage = rowsPrePage;
		this.maxRowsCount = maxRowsCount;
		maxPage();//
	}

	public PageUtil() {

	}

	// ������ҳ��
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
		int firstReusultIndex=pageSize*(pageNo-1);//�����¼��ʼ��
		query.setFirstResult(firstReusultIndex);//���ü�¼��ʼ��
		query.setMaxResults(pageSize);//��������¼��
	   if(parmas!=null){
		   
		   for(int i=0;i<parmas.size();i++){
			   System.out.println(parmas.get(i));
			   query.setParameter(i, parmas.get(i));
		   }
	   }
	 
		return query.list();
	}
	

}
