package com.kingdee.eas.custom.wages.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;
import java.math.BigDecimal;

public class getWorkmonthFacadeControllerBean extends AbstractgetWorkmonthFacadeControllerBean
{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.app.getWorkmonthFacadeControllerBean");

	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 根据入职日期与当期日期计算月份差
	 */
	@Override
	protected int _getworkmonth(Context ctx, String date) throws BOSException {
		// TODO Auto-generated method stub
		Date newDate=new Date();   
		Date endDate = null;
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			endDate = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bef.setTime(newDate);
		aft.setTime(endDate);
		int result=0;
		result = bef.get(Calendar.MONTH) - aft.get(Calendar.MONTH);
		int month = (bef.get(Calendar.YEAR) - aft.get(Calendar.YEAR))*12;
		return result+month;
	}
	
	
//	/* (non-Javadoc)
//	 * @see com.kingdee.eas.custom.wages.app.AbstractgetWorkmonthFacadeControllerBean#_getdkgs(com.kingdee.bos.Context, java.lang.String)
//	 */
//	@Override
//	protected String _getdkgs(Context ctx, String yssd) throws BOSException {
//		// TODO Auto-generated method stub
//		BigDecimal dkgs = new BigDecimal(yssd);
//		//应发工资减去3500
//		BigDecimal sudkgs = dkgs.subtract(new BigDecimal("3500"));
//		if(sudkgs.compareTo(new BigDecimal("9000"))==1){
//			dkgs = sudkgs.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("1005"));
//		}else if(sudkgs.compareTo(new BigDecimal("4500"))==1){
//			dkgs = sudkgs.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("555"));
//		}else if(sudkgs.compareTo(new BigDecimal("1500"))==1){
//			dkgs = sudkgs.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("105"));
//		}else if(sudkgs.compareTo(BigDecimal.ZERO)==1){
//			dkgs = sudkgs.multiply(new BigDecimal("0.03"));
//		}else{
//			dkgs = new BigDecimal("0");
//		}
//		return dkgs.toString();
//	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.app.AbstractgetWorkmonthFacadeControllerBean#_getdkgs(com.kingdee.bos.Context, java.lang.String)
	 */
	//2018-06-30 太和版本代扣个税
	@Override
	protected String _getdkgs(Context ctx, String yssd,String Company) throws BOSException {
		// TODO Auto-generated method stub
		BigDecimal dkgs = new BigDecimal(yssd);
		BigDecimal taxUp = new BigDecimal("0");
		BigDecimal taxDown = new BigDecimal("0");
		BigDecimal duickDeduction= new BigDecimal("0");
		BigDecimal TaxRate = new BigDecimal("0");
		BigDecimal Taxstandard = new BigDecimal("0");
		//代扣个税  = 符合范围内的税率*（应付工资-税额下限）+速算扣除数
		//获取个税数据
		IRowSet rs = getTaxInfo(Company,ctx);
		System.out.println(dkgs);
		try {
			while(rs.next()){
				//System.out.println(dkgs);
				Taxstandard = rs.getBigDecimal("Taxstandard");
				BigDecimal wages = dkgs.subtract(Taxstandard);
				if(wages.compareTo(new BigDecimal(rs.getString("TaxDown")))==1&&wages.compareTo(new BigDecimal(rs.getString("TaxUp")))<1){
					//System.out.println(dkgs);
					taxUp = rs.getBigDecimal("TaxUp");
					taxDown = rs.getBigDecimal("TaxDown");
					duickDeduction = rs.getBigDecimal("QuickDeduction");
					TaxRate = rs.getBigDecimal("TaxRate");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dkgs.compareTo(Taxstandard)==1){
			dkgs = dkgs.subtract(Taxstandard);
			dkgs = dkgs.subtract(taxDown);
			dkgs = dkgs.multiply(TaxRate).divide(new BigDecimal("100"));
			dkgs = dkgs.add(duickDeduction);
		}else{
			dkgs = BigDecimal.ZERO;
		}
		
		
		return dkgs.toString();
	}

	//获取税率信息
	private IRowSet getTaxInfo(String Company,Context ctx) throws BOSException {
	// TODO Auto-generated method stub
		String sp = "\n";
		StringBuffer sb=new StringBuffer();
		sb.append("/*dialect*/").append(sp);
		sb.append("SELECT t2.CFTaxDown TaxDown, t2.CFTaxUp TaxUp, t2.CFTaxRate TaxRate, t2.CFQuickDeduction QuickDeduction,t1.CFTaxstandard Taxstandard ").append(sp);
		sb.append("FROM   CT_WAG_PersonTax t1 ").append(sp);
		sb.append("inner join CT_WAG_PersonTaxEntry t2  on t2.FParentID=t1.fid ").append(sp);
		sb.append("where t1.CFCompanyID = '"+Company+"'").append(sp);
		sb.append("and t1.CFBaseStatus in (2,4)").append(sp);
		//sb.append("and t1.CFTaxstandard >= '"+wages+"'").append(sp);
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		return rs;
}


	/** 
	 * 获取现在时间
	 *  
	 * @return返回长时间格式 yyyy-MM-dd HH:mm:ss 
	 */  
	public static Date getSqlDate() {  
	    Date sqlDate = new java.sql.Date(new Date().getTime());  
	    return sqlDate;  
	}  
	  
	/** 
	 * 获取现在时间 
	 *  
	 * @return返回长时间格式 yyyy-MM-dd HH:mm:ss 
	 */  
	public static Date getNowDate() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    ParsePosition pos = new ParsePosition(8);  
	    Date currentTime_2 = formatter.parse(dateString, pos);  
	    return currentTime_2;  
	}  
	  
	/** 
	 * 获取现在时间 
	 *  
	 * @return返回短时间格式 yyyy-MM-dd 
	 */  
	public static Date getNowDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    ParsePosition pos = new ParsePosition(8);  
	    Date currentTime_2 = formatter.parse(dateString, pos);  
	    return currentTime_2;  
	}  
	  
	/** 
	 * 获取现在时间 
	 *  
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss 
	 */  
	public static String getStringDate() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * 获取现在时间 
	 *  
	 * @return 返回短时间字符串格式yyyy-MM-dd 
	 */  
	public static String getStringDateShort() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * 获取时间 小时:分;秒 HH:mm:ss 
	 *  
	 * @return 
	 */  
	public static String getTimeShort() {  
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
	    Date currentTime = new Date();  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss 
	 *  
	 * @param strDate 
	 * @return 
	 */  
	public static Date strToDateLong(String strDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(strDate, pos);  
	    return strtodate;  
	}  
	  
	/** 
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss 
	 *  
	 * @param dateDate 
	 * @return 
	 */  
	public static String dateToStrLong(java.util.Date dateDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}  
	  
	/** 
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd 
	 *  
	 * @param dateDate 
	 * @param k 
	 * @return 
	 */  
	public static String dateToStr(java.util.Date dateDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}  
	  
	/** 
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd 
	 *  
	 * @param strDate 
	 * @return 
	 */  
	public static Date strToDate(String strDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(strDate, pos);  
	    return strtodate;  
	}  
	  
	/** 
	 * 得到现在时间 
	 *  
	 * @return 
	 */  
	public static Date getNow() {  
	    Date currentTime = new Date();  
	    return currentTime;  
	}  
	  
	/** 
	 * 提取一个月中的最后一天 
	 *  
	 * @param day 
	 * @return 
	 */  
	public static Date getLastDate(long day) {  
	    Date date = new Date();  
	    long date_3_hm = date.getTime() - 3600000 * 34 * day;  
	    Date date_3_hm_date = new Date(date_3_hm);  
	    return date_3_hm_date;  
	}  
	  
	/** 
	 * 得到现在时间 
	 *  
	 * @return 字符串 yyyyMMdd HHmmss 
	 */  
	public static String getStringToday() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * 得到现在小时 
	 */  
	public static String getHour() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    String hour;  
	    hour = dateString.substring(11, 13);  
	    return hour;  
	}  
	  
	/** 
	 * 得到现在分钟 
	 *  
	 * @return 
	 */  
	public static String getTime() {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);  
	    String min;  
	    min = dateString.substring(14, 16);  
	    return min;  
	}  
	  
	/** 
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。 
	 *  
	 * @param sformat 
	 *            yyyyMMddhhmmss 
	 * @return 
	 */  
	public static String getUserDate(String sformat) {  
	    Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat(sformat);  
	    String dateString = formatter.format(currentTime);  
	    return dateString;  
	}  
	  
	/** 
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟 
	 */  
	public static String getTwoHour(String st1, String st2) {  
	    String[] kk = null;  
	    String[] jj = null;  
	    kk = st1.split(":");  
	    jj = st2.split(":");  
	    if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))  
	        return "0";  
	    else {  
	        double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])  
	                / 60;  
	        double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])  
	                / 60;  
	        if ((y - u) > 0)  
	            return y - u + "";  
	        else  
	            return "0";  
	    }  
	}  
	  
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.app.AbstractgetWorkmonthFacadeControllerBean#_getDaySub(com.kingdee.bos.Context, java.lang.String, java.lang.String)
	 */
	@Override
	protected String _getDaySub(Context ctx, String begindate, String enddate)
			throws BOSException {
		// TODO Auto-generated method stub
		String day = getTwoDay(enddate,begindate);
		return day;
	}


	/** 
	 * 得到二个日期间的间隔天数 
	 */  
	public static String getTwoDay(String sj1, String sj2) {  
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
	    long day = 0;  
	    try {  
	        java.util.Date date = myFormatter.parse(sj1);  
	        java.util.Date mydate = myFormatter.parse(sj2);  
	        day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);  
	    } catch (Exception e) {  
	        return "";  
	    }  
	    return day + "";  
	}  
	  
	/** 
	 * 时间前推或后推分钟,其中JJ表示分钟. 
	 */  
	public static String getPreTime(String sj1, String jj) {  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String mydate1 = "";  
	    try {  
	        Date date1 = format.parse(sj1);  
	        long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;  
	        date1.setTime(Time * 1000);  
	        mydate1 = format.format(date1);  
	    } catch (Exception e) {  
	    }  
	    return mydate1;  
	}  
	  
	/** 
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数 
	 */  
	public static String getNextDay(String nowdate, String delay) {  
	    try {  
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        String mdate = "";  
	        Date d = strToDate(nowdate);  
	        long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24  
	                * 60 * 60;  
	        d.setTime(myTime * 1000);  
	        mdate = format.format(d);  
	        return mdate;  
	    } catch (Exception e) {  
	        return "";  
	    }  
	}  
	  
	/** 
	 * 判断是否润年 
	 *  
	 * @param ddate 
	 * @return 
	 */  
	public static boolean isLeapYear(String ddate) {  
	    /** 
	     * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年 
	     * 3.能被4整除同时能被100整除则不是闰年 
	     */  
	    Date d = strToDate(ddate);  
	    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
	    gc.setTime(d);  
	    int year = gc.get(Calendar.YEAR);  
	    if ((year % 400) == 0)  
	        return true;  
	    else if ((year % 4) == 0) {  
	        if ((year % 100) == 0)  
	            return false;  
	        else  
	            return true;  
	    } else  
	        return false;  
	}  
	  
	/** 
	 * 返回美国时间格式 26 Apr 2006 
	 *  
	 * @param str 
	 * @return 
	 */  
	public static String getEDate(String str) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(str, pos);  
	    String j = strtodate.toString();  
	    String[] k = j.split(" ");  
	    return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);  
	}  
	  
	/** 
	 * 获取一个月的最后一天 
	 *  
	 * @param dat 
	 * @return 
	 */  
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd  
	    String str = dat.substring(0, 8);  
	    String month = dat.substring(5, 7);  
	    int mon = Integer.parseInt(month);  
	    if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8  
	            || mon == 10 || mon == 12) {  
	        str += "31";  
	    } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {  
	        str += "30";  
	    } else {  
	        if (isLeapYear(dat)) {  
	            str += "29";  
	        } else {  
	            str += "28";  
	        }  
	    }  
	    return str;  
	}  
	  
	/** 
	 * 判断二个时间是否在同一个周 
	 *  
	 * @param date1 
	 * @param date2 
	 * @return 
	 */  
	public static boolean isSameWeekDates(Date date1, Date date2) {  
	    Calendar cal1 = Calendar.getInstance();  
	    Calendar cal2 = Calendar.getInstance();  
	    cal1.setTime(date1);  
	    cal2.setTime(date2);  
	    int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);  
	    if (0 == subYear) {  
	        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2  
	                .get(Calendar.WEEK_OF_YEAR))  
	            return true;  
	    } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {  
	        // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周  
	        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2  
	                .get(Calendar.WEEK_OF_YEAR))  
	            return true;  
	    } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {  
	        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2  
	                .get(Calendar.WEEK_OF_YEAR))  
	            return true;  
	    }  
	    return false;  
	}  
	  
	/** 
	 * 产生周序列,即得到当前时间所在的年度是第几周 
	 *  
	 * @return 
	 */  
	public static String getSeqWeek() {  
	    Calendar c = Calendar.getInstance(Locale.CHINA);  
	    String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));  
	    if (week.length() == 1)  
	        week = "0" + week;  
	    String year = Integer.toString(c.get(Calendar.YEAR));  
	    return year + week;  
	}  
	  
	/** 
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号 
	 *  
	 * @param sdate 
	 * @param num 
	 * @return 
	 */  
	public static String getWeek(String sdate, String num) {  
	    // 再转换为时间  
	    Date dd = strToDate(sdate);  
	    Calendar c = Calendar.getInstance();  
	    c.setTime(dd);  
	    if (num.equals("1")) // 返回星期一所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
	    else if (num.equals("2")) // 返回星期二所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);  
	    else if (num.equals("3")) // 返回星期三所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);  
	    else if (num.equals("4")) // 返回星期四所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);  
	    else if (num.equals("5")) // 返回星期五所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);  
	    else if (num.equals("6")) // 返回星期六所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);  
	    else if (num.equals("0")) // 返回星期日所在的日期  
	        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  
	    return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
	}  
	  
	/** 
	 * 根据一个日期，返回是星期几的字符串 
	 *  
	 * @param sdate 
	 * @return 
	 */  
	public static String getWeek(String sdate) {  
	    // 再转换为时间  
	    Date date = strToDate(sdate);  
	    Calendar c = Calendar.getInstance();  
	    c.setTime(date);  
	    // int hour=c.get(Calendar.DAY_OF_WEEK);  
	    // hour中存的就是星期几了，其范围 1~7  
	    // 1=星期日 7=星期六，其他类推  
	    return new SimpleDateFormat("EEEE").format(c.getTime());  
	}  
	  
	public static String getWeekStr(String sdate) {  
	    String str = "";  
	    str = getWeek(sdate);  
	    if ("1".equals(str)) {  
	        str = "星期日";  
	    } else if ("2".equals(str)) {  
	        str = "星期一";  
	    } else if ("3".equals(str)) {  
	        str = "星期二";  
	    } else if ("4".equals(str)) {  
	        str = "星期三";  
	    } else if ("5".equals(str)) {  
	        str = "星期四";  
	    } else if ("6".equals(str)) {  
	        str = "星期五";  
	    } else if ("7".equals(str)) {  
	        str = "星期六";  
	    }  
	    return str;  
	}  
	  
	/** 
	 * 两个时间之间的天数 
	 *  
	 * @param date1 
	 * @param date2 
	 * @return 
	 */  
	public static long getDays(String date1, String date2) {  
	    if (date1 == null || date1.equals(""))  
	        return 0;  
	    if (date2 == null || date2.equals(""))  
	        return 0;  
	    // 转换为标准时间  
	    SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
	    java.util.Date date = null;  
	    java.util.Date mydate = null;  
	    try {  
	        date = myFormatter.parse(date1);  
	        mydate = myFormatter.parse(date2);  
	    } catch (Exception e) {  
	    }  
	    long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);  
	    return day;  
	} 
	
	
}