package com.kingdee.eas.wlhlcomm;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.kingdee.bos.BOSException;

public class DateCommon {

	/**
	 * ����������ڼ��ʱ���
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BOSException 
	 */
	public static int dateDiff(Date beginDate,Date endDate) throws BOSException{
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        try{
//	        	if(bdate.before(smdate)){
//	        		throw new BOSException("��ֳ���ڲ���������������");
//	        	}
	        	
	        	beginDate=sdf.parse(sdf.format(beginDate));  
	        	endDate=sdf.parse(sdf.format(endDate));  
		        Calendar cal = Calendar.getInstance();    
		        cal.setTime(beginDate);    
		        long time1 = cal.getTimeInMillis();                 
		        cal.setTime(endDate);    
		        long time2 = cal.getTimeInMillis();         
		        long between_days=(time2-time1)/(1000*3600*24);  
		            
		        return Math.abs(Integer.parseInt(String.valueOf(between_days)));    
	        }catch(ParseException pe){
	        	throw new BOSException("�������ڲ�ֵ����",pe);
	        }
	}
	/**
	 * �õ���һ��
	 * @param nowDate
	 * @return
	 */
	public static Date getNextDay(Date nowDate) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(nowDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	/**
	 * �ƶ���ʱ���  ����n����
	 * @param beginTime
	 * @param minutes
	 * @return
	 */
	public static Time addMinutes(Time beginTime,int minutes){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginTime);
		cal.add(Calendar.MINUTE, minutes);
//		Date date = cal.getTime();
//		int hour = date.getHours();
//		int minute = date.getMinutes();
//		int second = date.getSeconds();
		return new Time(cal.getTimeInMillis());
	}
	
	/**
	 * ��ȡ�³�ʼ���� 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getMonthBeginDate(int year,int month){
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		cal.set(Calendar.DATE,1);
		
		
		return cal.getTime();
	}
	
	
	/**
	 * ��ȡ�½�������    23:59:59
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getMonthEndTime(int year,int month){
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		cal.set(Calendar.DATE,1);
		
		
	  
        Date now = null; 
        try { 
          
           cal.add(Calendar.MONTH, 1); 
           cal.add(Calendar.DATE, -1); 
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           SimpleDateFormat sdfS = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
           now = cal.getTime();
           
           String nowStr = sdf.format(now);
           return sdfS.parse(nowStr + " 23:59:59");
           
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
		return null;
	}
	
	
}
