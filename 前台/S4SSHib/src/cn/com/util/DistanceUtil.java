package cn.com.util;

public class DistanceUtil {
  private  int minDis=0;
  private int maxDis=0;
public int getMinDis() {
	return minDis;
}
public void setMinDis(int minDis) {
	this.minDis = minDis;
}
public int getMaxDis() {
	return maxDis;
}
public void setMaxDis(int maxDis) {
	this.maxDis = maxDis;
}
public DistanceUtil(String disTance){
	if(disTance.contains("����")){
	String [] s=disTance.split("��");
	this.maxDis=Integer.parseInt(s[0]);
	}
	if(disTance.contains("����")){
		String [] s=disTance.split("��");
		this.minDis=Integer.parseInt(s[0]);
	}
	if(disTance.contains("-")){
		String [] s=disTance.split("��");
		String [] s1 =   s[0].split("-");
		this.maxDis=Integer.parseInt(s1[1]);
		this.minDis=Integer.parseInt(s1[0]);
	}
}
}
