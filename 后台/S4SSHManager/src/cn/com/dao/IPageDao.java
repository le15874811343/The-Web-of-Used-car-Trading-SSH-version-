package cn.com.dao;
import java.util.*;
public interface IPageDao {

	/**
	 * ��ȡ�ܼ�¼����
	 * @return int
	 */
	public Long queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge);

	/**
	 * ����������ȡ��¼����
	 * @param curPage ��ǰҳ
	 * @param rowsPrePage ÿҳ���¼��
	 * @return Map<Integer,Object>
	 */
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge);
	
	public Long queryPersonCarCount(Object object);

	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,Object object);


}
