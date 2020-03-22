/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class HatchBillCoefficientEditUI extends AbstractHatchBillCoefficientEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(HatchBillCoefficientEditUI.class);

	private StorageOrgUnitInfo stoOrgUnitInfo;

	/**
	 * output class constructor
	 */
	public HatchBillCoefficientEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
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
		return com.kingdee.eas.farm.hatch.HatchBillCoefficientFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));

		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//		stoOrgUnitInfo=SysContext.getSysContext().getCurrentStorageUnit();
		chkisCompany.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent paramChangeEvent) {
				// TODO Auto-generated method stub
				if(chkisCompany.isSelected()){
					prmtcompany.setRequired(true);
					chkisGroup.setSelected(false);
					chkisGroup.setEnabled(false);
				}else{
					prmtcompany.setRequired(false);
				}
			}});
		chkisGroup.addChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent paramChangeEvent) {
				// TODO Auto-generated method stub
				if(chkisCompany.isSelected()){
					chkisCompany.setSelected(false);
				}else{
					prmtcompany.setValue(null);
					prmtcompany.setEnabled(false);
					chkisCompany.setSelected(false);
					chkisCompany.setEnabled(true);
				}
			}});

	}
	@Override
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(chkisCompany.isSelected()&&prmtcompany.getValue()==null)
			commUtils.giveUserTipsAndRetire("勾选公司统一时请选择公司");
		else if(!chkisCompany.isSelected()&&prmtcompany.getValue()!=null){
			commUtils.giveUserTipsAndRetire("未勾选公司统一请不要选择公司");
		}
		super.beforeStoreFields(e);
	}

}