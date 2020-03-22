package com.kingdee.eas.custom.commld;

/*************************************************************
 * Lunar.java,��Ϊũ���࣬����ũ�����㷨�������Ӧ������ũ�����ں�ũ�����ա�
*************************************************************/
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
import java.util.Date;

import com.kingdee.eas.util.client.MsgBox;
 
   public class Lunar {
     private int year;
     private int month;
     private int day;
     private int dayofmonth;//��¼һ���µ�����
     private boolean leap;
     private String lftv;
      final static String chineseNumber[] = {"һ", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ", "ʮһ", "ʮ��"};
     static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy��MM��dd��");//����ģʽ
     final static long[] lunarInfo = new long[]
      {0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2,
      0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
      0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970,
      0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950,
      0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557,
      0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
      0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
      0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
      0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570,
      0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0,
      0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5,
      0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930,
      0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
      0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
      0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0};
 
     //====== ����ũ�� y���������
      final private static int yearDays(int y) {
         int i, sum = 348;
          for (i = 0x8000; i > 0x8; i >>= 1) {
             if ((lunarInfo[y - 1900] & i) != 0) sum += 1;
         }
         return (sum + leapDays(y));
     }
 
     //====== ����ũ�� y�����µ�����
      final private static int leapDays(int y) {
          if (leapMonth(y) != 0) {
             if ((lunarInfo[y - 1900] & 0x10000) != 0)
                 return 30;
             else
                 return 29;
         } else
             return 0;
     }
 
     //====== ����ũ�� y�����ĸ��� 1-12 , û�򴫻� 0
      final private static int leapMonth(int y) {
         return (int) (lunarInfo[y - 1900] & 0xf);
     }
 
     //====== ����ũ�� y��m�µ�������
      final private static int monthDays(int y, int m) {
         if ((lunarInfo[y - 1900] & (0x10000 >> m)) == 0)
             return 29;
         else
             return 30;
     }
 
     //====== ����ũ�� y�����Ф
      final public String animalsYear() {
          final String[] Animals = new String[]{"��", "ţ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
         return Animals[(year - 4) % 12];
     }
 
     //====== ���� ���յ�offset ���ظ�֧, 0=����
      final private static String cyclicalm(int num) {
          final String[] Gan = new String[]{"��", "��", "��", "��", "��", "��", "��", "��", "��", "��"};
          final String[] Zhi = new String[]{"��", "��", "��", "î", "��", "��", "��", "δ", "��", "��", "��", "��"};
         return (Gan[num % 10] + Zhi[num % 12]);
     }
 
     //====== ���� offset ���ظ�֧, 0=����
      final public String cyclical() {
         int num = year - 1900 + 36;
         return (cyclicalm(num));
     }
 
      /**********************************************
      * ����y��m��d�ն�Ӧ��ũ��.
      * yearCyl3:ũ������1864�������   
      * monCyl4:��1900��1��31������,������
      * dayCyl5:��1900��1��31����������,�ټ�40
      * @param cal 
      * @return 
      *********************************************/
      public Lunar(Calendar cal) {
         
    	 int yearCyl, monCyl, dayCyl;
         int leapMonth = 0;
         Date baseDate = null;
          try {
             baseDate = chineseDateFormat.parse("1900��1��31��");
          } catch (ParseException e) {
             e.printStackTrace();  //To change body of catch statement use Options | File Templates.
         }
 
         //�����1900��1��31����������
         int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);
         dayCyl = offset + 40;
         monCyl = 14;
 
         //��offset��ȥÿũ���������
         // ���㵱����ũ���ڼ���
         //i���ս����ũ�������
         //offset�ǵ���ĵڼ���
         int iYear, daysOfYear = 0;
          for (iYear = 1900; iYear < 2050 && offset > 0; iYear++) {
             daysOfYear = yearDays(iYear);
             offset -= daysOfYear;
             monCyl += 12;
         }
          if (offset < 0) {
             offset += daysOfYear;
             iYear--;
             monCyl -= 12;
         }
         //ũ�����
         year = iYear;
 
         yearCyl = iYear - 1864;
         leapMonth = leapMonth(iYear); //���ĸ���,1-12
         leap = false;
 
         //�õ��������offset,�����ȥÿ�£�ũ��������������������Ǳ��µĵڼ���
         int iMonth, daysOfMonth = 0;
          for (iMonth = 1; iMonth < 13 && offset > 0; iMonth++) {
             //����
              if (leapMonth > 0 && iMonth == (leapMonth + 1) && !leap) {
                 --iMonth;
                 leap = true;
                 daysOfMonth = leapDays(year);
             } else
                 daysOfMonth = monthDays(year, iMonth);
 
             offset -= daysOfMonth;
             //�������
             if (leap && iMonth == (leapMonth + 1)) leap = false;
             if (!leap) monCyl++;
         }
         //offsetΪ0ʱ�����Ҹղż�����·������£�ҪУ��
          if (offset == 0 && leapMonth > 0 && iMonth == leapMonth + 1) {
              if (leap) {
                 leap = false;
              } else {
                 leap = true;
                 --iMonth;
                 --monCyl;
             }
         }
         //offsetС��0ʱ��ҲҪУ��
          if (offset < 0) {
             offset += daysOfMonth;
             --iMonth;
             --monCyl;
         }
         month = iMonth;
         day = offset + 1;
         dayofmonth=monthDays(year, month);//�õ���һ�µ�������
        
         
     }
 
      public static String getChinaDayString(int day) {
          String chineseTen[] = {"��", "ʮ", "إ", "ئ"};
         int n = day % 10 == 0 ? 9 : day % 10 - 1;
         if (day > 30)
             return "";
         if (day == 10)
             return "��ʮ";
         else
             return chineseTen[day / 10] + chineseNumber[n];
     }
 
      public String toString() {  //////��ʾũ����ʽ,����������,����,��Ф,��ɵ�֧��.
         return year + "��" + (leap ? "��" : "") + chineseNumber[month - 1] + "��" + getChinaDayString(day);
     }
      public String LunarFestival(){
    	  
    	  Festival ftv=new Festival();//���ý��������ʾũ�����յĺ���,�ж�ũ��12�µ�����.
    	  return ftv.showLFtv(month, day,dayofmonth);
      }
      public static void getLunarDate(Date date) throws ParseException {
  		Calendar today = Calendar.getInstance();
  		today.setTime(date);// ���ص�ǰ����
  		// today.setTime(chineseDateFormat.parse("2006��10��30��"));//�����Զ�������

  		Lunar lunar = new Lunar(today);
  		int year = today.get(Calendar.YEAR);
  		int month = today.get(Calendar.MONTH);
  		int day = today.get(Calendar.DATE);
  		System.out.println(year);// �õ���ǰʱ������
  		System.out.println(month);// �õ���ǰʱ����·�
  		System.out.println(day);// �õ���ǰʱ�����
  		System.out.println("����:" + year + "-" + month + "-" + day + "   ");

  		Festival ft = new Festival();// �������ն���

  		/* ����DEMO */
//  		System.out
//  				.println("*********************�����������������Ϣ**************************");
  		// today.set(year, month,1);
//  		String s = ft.showSFtv(month, day);// �����·ݺ����ڶ����Ի��
//  		String s1 = ft.showSFtv(11, 11);
//  		System.out.println(s + "+++++++++++++==");
//  		System.out.println("11��11����" + s1 + "++++++++");

  		/* ũ��DEMO */
//  		System.out
//  				.println("*********************�������ũ��������Ϣ**************************");
//  		System.out
//  				.println(lunar.animalsYear() + "++++" + lunar.LunarFestival());
  		String l = ft.showLFtv(1, 1, 1);
  		MsgBox.showInfo(l + "&&&&&&&&&");
  		MsgBox.showInfo(lunar.cyclical() + "��");// ��������������
  		MsgBox.showInfo(lunar.toString());// ���������������
  		MsgBox.showInfo(lunar.animalsYear());// �����������
//  		MsgBox.showInfo(new java.sql.Date(today.getTime().getTime()));// �����������
//  		System.out.println("����"
//  				+ lunar.getChinaWeekdayString(today.getTime().toString()
//  						.substring(0, 3)));// ����������ڼ�
  		
  		Calendar now = Calendar.getInstance();
  		now.setTime(date);
  		Lunar nowtest=new Lunar(now);
  		
  		MsgBox.showInfo(nowtest.animalsYear());
  		MsgBox.showInfo(nowtest.LunarFestival());
  	}
 } 