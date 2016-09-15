package cn.com.dao;
import java.util.*;
import cn.com.pojo.*;
/**
 * 品牌信息操作接口
 * @author lej
 */
public interface ICarBrandDao {
   /**
   * 按热度获取品牌信息的方法
   * @return  Map<Integer, CarBrand>
   */
  public Map<Integer, Carbrand> getCarBrandByCount();
  /**
   * 获取所有品牌信息的方法
   * @return Map<Integer,CarBrand>
   */
  public Map<Integer, Carbrand> getAllBrand();
  /**
   * 根据品牌编号获取品牌信息的方法
   * @param carBrand
   * @return CarBrand
   */
  public Carbrand getBrandByID(Carbrand carBrand);
   /**
   * 根据品牌名称获取品牌的方法
   *@return CarBrand 
   */
  public Carbrand getBrandByName(Carbrand carBrand);
}
