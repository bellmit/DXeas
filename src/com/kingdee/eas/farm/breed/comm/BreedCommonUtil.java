package com.kingdee.eas.farm.breed.comm;

/**
 * ��ֳͨ�÷���
 * @author USER
 *
 */
public class BreedCommonUtil {

	/**
	 * ������������ ��λ ����Ӵ�
	 * ����� 1��1����  �򷵻� 0101
	 * �����20��1�����򷵻� 2001
	 * 
	 * @param week
	 * @param day
	 * @return
	 */
	public static String getWeekDayStr(int week,int day){
		if(week < 10){
			return "0"+week+"0"+day;
		}else{
			return week+"0"+day;
		}
		
	}
	/**
	 * ��õ�������
	 * ����С��10     ���� 0+����   ���� 5 ���䷵��  05
	 * ���䲻С��10   ֱ�ӷ�������  ���� 15���䷵��  15
	 *@param  week
	 *@return
	 */
	public static String getWeekStr(int week)
	{
		if(week<10){
			return "0"+week;
		}
		else{
			return String.valueOf(week);
		}
	}
}
