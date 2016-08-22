package cn.com.dao;
import java.util.*;
import cn.com.pojo.*;
public interface ICarBrandDao {
  public Map<Integer, Carbrand> getCarBrandByCount();
  public Map<Integer, Carbrand> getAllBrand();
  public Carbrand getBrandByID(Carbrand carBrand);
  public Carbrand getBrandByName(Carbrand carBrand);
}
