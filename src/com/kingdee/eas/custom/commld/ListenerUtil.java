package com.kingdee.eas.custom.commld;

import java.awt.Component;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDLabelContainer;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.eas.framework.client.CoreBillEditUI;

public class ListenerUtil {

	/**
	 * 删除f7的值改变事件
	 * @param f7
	 */
	public static void F7RemoveDateChangeListener(KDBizPromptBox f7){
		DataChangeListener[] listenerArray = f7.getListeners(DataChangeListener.class);
		for(int i=0;i<listenerArray.length;i++)
			f7.removeDataChangeListener(listenerArray[i]);
	}
	/**
	 * 删除日期f7的值改变事件
	 * @param f7
	 */
	public static void F7RemoveDateChangeListenerForDate(KDDatePicker f7){
		DataChangeListener[] listenerArray = f7.getListeners(DataChangeListener.class);
		for(int i=0;i<listenerArray.length;i++)
			f7.removeDataChangeListener(listenerArray[i]);
	}
	
	/**
	 * 获取f7的值改变事件
	 * @param f7
	 * @return
	 */
	public static DataChangeListener[] F7GetDateChangeListener(KDBizPromptBox f7){
		DataChangeListener[] listenerArray = f7.getListeners(DataChangeListener.class);
		return listenerArray;
	}

	/**
	 * f7添加值改变事件
	 * @param f7
	 * @return
	 */
	public static void F7AddDateChangeListener(KDBizPromptBox f7,DataChangeListener[] dataChangeListener){
		for(int i=0;i<dataChangeListener.length;i++)
			f7.addDataChangeListener(dataChangeListener[i]);
	}

	/**
	 * KDTable添加动态合计行--指定统计字段
	 * @param f7
	 * @return
	 */
	public static void KDTableAddActiveSumRow(final KDTable[] tableArray){
		for(int i=0;i<tableArray.length;i++){
			final KDTable table = tableArray[i];
			table.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){
				public void propertyChange(KDTPropertyChangeEvent arg0) {
					// TODO Auto-generated method stub
					UIUtil.apendFootRow(table);
				}});
		}
	}

	/**
	 * KDTable添加合计行--指定统计字段
	 * @param f7
	 * @return
	 */
	public static void KDTableAddActiveSumRow(final KDTable[] tableArray,final String[] array){
		for(int i=0;i<tableArray.length;i++){
			final KDTable table = tableArray[i];
			table.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){
				public void propertyChange(KDTPropertyChangeEvent arg0) {
					// TODO Auto-generated method stub
					UIUtil.apendFootRow(table,array);
				}});
		}
	}


	/**
	 * KDTable添加合计行--指定统计字段
	 * @param f7
	 * @return
	 */
	public static void KDTableAddActiveSumRow(final KDTable table,final String[] array){
		table.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){
			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(table,array);
			}});
	}


	/**
	 * KDTable添加合计行--不指定统计字段
	 * @param f7
	 * @return
	 */
	public static void KDTableAddActiveSumRow(final KDTable table){
		table.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){
			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(table);
			}});
	}
	/**
	 * 删除事件
	 * @param carSendBillEditUI
	 * @param class1
	 */
	public static void RemoveListener(CoreBillEditUI carSendBillEditUI,
			String className) {
		// TODO Auto-generated method stub
		//		Component[] components = carSendBillEditUI.getComponents();
		//		Component component=null;
		//		for(int i=0;i<components.length;i++){
		//			component = components[i];
		//			if(component instanceof KDLabelContainer)
		//				if(component instanceof KDBizPromptBox){
		//					if((className!=null&&(KDBizPromptBox.class.getName().equals(className)))||className==null)
		//						F7RemoveDateChangeListener((KDBizPromptBox)component);
		//				}
		//		}
	}

	/**
	 * 文本控件删除值变更事件
	 * @param obj
	 */
	public static void textFieldRemoveDataChangeListener(Object obj){
		if(obj instanceof KDFormattedTextField ){
			DataChangeListener[] listeners = textFieldGetDataChangeListener(obj);
			for(int i=0;i<listeners.length;i++)
				((KDFormattedTextField)obj).removeDataChangeListener(listeners[i]);
		}
	}

	/**
	 * 文本控件获取事件
	 * @param obj
	 * @return
	 */
	public static DataChangeListener[] textFieldGetDataChangeListener(Object obj){
		if(obj instanceof KDFormattedTextField ){
			return ((KDFormattedTextField)obj).getListeners(DataChangeListener.class);
		}else
			return null;
	}



	/**
	 * 文本控件添加事件
	 * @param obj
	 * @return
	 */
	public static void textFieldAddDataChangeListener(Object obj,DataChangeListener[] listeners){
		if(obj instanceof KDFormattedTextField ){
			for(int i=0;i<listeners.length;i++)
				((KDFormattedTextField)obj).addDataChangeListener(listeners[i]);
		}else
			return;
	}
}
