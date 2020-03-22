/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commld.Control.KDBizPromtBoxUtil;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class TechBatchRangeEditUI extends AbstractTechBatchRangeEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(TechBatchRangeEditUI.class);
	private ArrayList<KDBizPromptBox> requiredFields=new ArrayList<KDBizPromptBox>();
	private ArrayList<String> requiredFieldsAlias=new ArrayList<String>();
	/**
	 * output class constructor
	 */
	public TechBatchRangeEditUI() throws Exception
	{
		super();
		requiredFields.add(prmtcompany);
		requiredFieldsAlias.add("公司");
		requiredFields.add(prmtuser);
		requiredFieldsAlias.add("技术员");

	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		ListenerUtil.F7RemoveDateChangeListener(prmtcompany);
		ListenerUtil.F7RemoveDateChangeListener(prmtuser);
		super.loadFields();
		setPersonFilter();
		setBatchFilter();
		addListenner();
	}
	private void setBatchFilter() {
		// TODO Auto-generated method stub
		KDBizPromptBox prmtstockingBatch = (KDBizPromptBox)kdtEntry.getColumn("batch").getEditor().getComponent();
		prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
		prmtstockingBatch.setVisible(true);		
		prmtstockingBatch.setEditable(true);		
		prmtstockingBatch.setDisplayFormat("$name$");		
		prmtstockingBatch.setEditFormat("$number$");		
		prmtstockingBatch.setCommitFormat("$number$;$name$");		
		prmtstockingBatch.setRequired(true);
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
//		filter.getFilterItems().add();
		evi.setFilter(filter);
		prmtstockingBatch.setEntityViewInfo(evi);
	}
	/**
	 * 添加事件
	 */
	private void addListenner() {
		// TODO Auto-generated method stub
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				setPersonFilter();
			}});

		prmtuser.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtuser.getValue()!=null)
					txtName.setSelectedItem(((IPropertyContainer)prmtuser.getValue()).getString("name"));
			}});
	}
	/**
	 * 根据公司过滤用户
	 */
	private void setPersonFilter() {
		// TODO Auto-generated method stub
		FilterInfo filter=new FilterInfo();
		String orgNum="";
		if(prmtcompany.getValue()!=null)
			orgNum=((CompanyOrgUnitInfo)prmtcompany.getValue()).getLongNumber()+"%";
		filter.getFilterItems().add(new FilterItemInfo("id","select FUserID from T_PM_OrgRange t1 inner join T_ORG_BaseUnit   t2 on  t2.FID=t1.FOrgID where t2.FLongNumber like '"+orgNum+"' group by FUserID",CompareType.INNER));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtuser.setEntityViewInfo(evi);
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.basedata.TechBatchRangeFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCU(ClientUtils.getCurrentCtrlUnit());
		objectValue.setCompany(ClientUtils.getCurrentFIUnit());
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//设置字段必录
		KDBizPromtBoxUtil.setKDBizPromtBoxRequired(requiredFields, true);
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
		kdtEntry.setAutoResize(true);
		
		
		
		final KDBizPromptBox kdtEntry_batch_PromptBox = new KDBizPromptBox();
        kdtEntry_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEntry_batch_PromptBox.setVisible(true);
        kdtEntry_batch_PromptBox.setEditable(true);
        kdtEntry_batch_PromptBox.setDisplayFormat("$number$");
        kdtEntry_batch_PromptBox.setEditFormat("$number$");
        kdtEntry_batch_PromptBox.setCommitFormat("$number$");
        EntityViewInfo evi=new EntityViewInfo();
        FilterInfo filter=new FilterInfo();
		evi.setFilter(filter);
		filter.getFilterItems().add(new FilterItemInfo("isAllOut",0,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("allOutDate",null,CompareType.EQUALS));
		kdtEntry_batch_PromptBox.setEntityViewInfo(evi);
        
        
        KDTDefaultCellEditor kdtEntry_batch_CellEditor = new KDTDefaultCellEditor(kdtEntry_batch_PromptBox);
        this.kdtEntry.getColumn("batch").setEditor(kdtEntry_batch_CellEditor);
        ObjectValueRender kdtEntry_batch_OVR = new ObjectValueRender();
        kdtEntry_batch_OVR.setFormat(new BizDataFormat("$number$"));
        
        
        
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		super.actionSubmit_actionPerformed(arg0);
	}



}