package com.kingdee.eas.custom.signwasthetable.client;

public class signTableUtil {

	
	/**
	 * �ж�һ��Ԭ���Ƿ������һ��������
	 * @param obj   Ԫ��
	 * @param array ����
	 * @return      �ǣ�true ��false
	 */
	public static boolean isInArray(Object obj,Object[] array){
		for(int i=0;i<array.length;i++)
			if(array[i].equals(obj))
				return true;
		return false;
	}
}
