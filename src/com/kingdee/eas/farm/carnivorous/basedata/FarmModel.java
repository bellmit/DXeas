package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptBox;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.batch.viewer.AbstractPropertyViewer;
import com.kingdee.eas.basedata.master.batch.viewer.EnumViewer;
import com.kingdee.eas.basedata.master.batch.viewer.F7Viewer;
import com.kingdee.eas.basedata.master.batch.viewer.FormattedViewer;
import com.kingdee.eas.basedata.master.batch.viewer.TextViewer;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.util.PropertyContainer;
import com.kingdee.util.enums.EnumUtils;

public class FarmModel extends PropertyContainer{
	private static Map<String, String> properties=new HashMap<String, String>();
	private static	AbstractPropertyViewer av=null;
	protected transient JComponent controller;
	private static void setTable(String modelName) {
		String table=null;
		if(modelName.equals("FarmerModel")){
			table="CT_FM_Farmer";
		}
		FarmModel.table = table;
	}

	private static String table="CT_FM_Farmer";
	public FarmModel(String modelName){
		setProperties(modelName);
		setTable(modelName);
	}

	public static Map<String, String> getProperties() {
		return properties;
	}

	@SuppressWarnings("null")
	private static void setProperties(String modelName) {
		if(modelName.equals("FarmerModel")){
			properties.put("地址", "FAddress");
			properties.put("性别", "FSex");
			properties.put("年龄", "FAge");
			properties.put("民族", "FNation");
			properties.put("文化程度", "FEduLvl");
			properties.put("家庭人口数", "FFamilyPersonCount");
			properties.put("业务员", "CFPersonID");
			properties.put("养殖户类别", "CFFarmerTypeID");
			properties.put("描述", "FDescription");
		}
	}

	public static String getTable() {
		return table;
	}

	public Object[] toArray() {
		Object[] objs = new Object[properties.size()];
		Set<String> set = properties.keySet(); //取出所有的key值
		int i=0;
		for (String key:set) {
			objs[i]=key;
			i++;
		}
		return objs;
	}


	public AbstractPropertyViewer getViewer(String columnKey,Boolean isInit) {
		if(isInit){
			if(columnKey.equals("业务员")){
				av=new F7Viewer();
				controller=new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();;
				((KDBizPromptBox) controller).setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
				controller.setVisible(true);		
				((KDBizPromptBox) controller).setEditable(true);		
				((KDBizPromptBox) controller).setDisplayFormat("$name$");		
				((KDBizPromptBox) controller).setEditFormat("$number$");		
				((KDBizPromptBox) controller).setCommitFormat("$number$");		
				av.setRequired("true");
			}else if(columnKey.equals("养殖户类别")){
				av=new F7Viewer();
				controller= new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
				((KDBizPromptBox) controller).setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerTypeQuery");		
				controller.setVisible(true);		
				((KDBizPromptBox) controller).setEditable(true);		
				((KDBizPromptBox) controller).setDisplayFormat("$name$");		
				((KDBizPromptBox) controller).setEditFormat("$number$");		
				((KDBizPromptBox) controller).setCommitFormat("$number$");		
				EntityViewInfo eviprmtfarmerType = new EntityViewInfo ();
				eviprmtfarmerType.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
				FilterInfo filter=new FilterInfo();
				if(SysContext.getSysContext().getCurrentFIUnit()!=null){
					filter.getFilterItems().add(new FilterItemInfo("FIcompany.id",SysContext.getSysContext().getCurrentFIUnit().getId().toString(),CompareType.EQUALS));
				}
				filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.APPROVE_VALUE,CompareType.EQUALS));
				eviprmtfarmerType.setFilter(filter);
				((KDBizPromptBox) controller).setEntityViewInfo(eviprmtfarmerType);
				av.setRequired("true");
			}else if(columnKey.equals("年龄")||columnKey.equals("家庭人口数")){
				av=new FormattedViewer();
				controller= new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
				controller.setVisible(true);		
				((KDFormattedTextField) controller).setHorizontalAlignment(2);		
				((KDFormattedTextField) controller).setDataType(0);		
				((KDFormattedTextField) controller).setSupportedEmpty(true);		
				av.setRequired("true");
			}else if(columnKey.equals("文化程度")){
				av=new EnumViewer();
				controller= new com.kingdee.bos.ctrl.swing.KDComboBox();
				controller.setVisible(true);		
				((KDComboBox) controller).addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.EduLvlEnum").toArray());		
				av.setRequired("true");
			}else if(columnKey.equals("性别")){
				av=new EnumViewer();
				controller=new com.kingdee.bos.ctrl.swing.KDComboBox();
				controller.setVisible(true);
				((KDComboBox) controller).addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());
				av.setRequired("true");
			}else{
				av=new TextViewer();
				controller= new com.kingdee.bos.ctrl.swing.KDTextField();
				((KDTextField) controller).setHorizontalAlignment(2);		
				((KDTextField) controller).setMaxLength(20);	
				av.setRequired("true");
			}
			av.setController(controller);
		}
		return av;
	}
}
