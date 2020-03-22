/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FarmerInterestEditUI extends AbstractFarmerInterestEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmerInterestEditUI.class);

	/**
	 * output class constructor
	 */
	public FarmerInterestEditUI() throws Exception
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
		return com.kingdee.eas.farm.stocking.basedata.FarmerInterestFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		kdtEntry.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);
				kdteditStarted(e);
			}
		});
	}
	private void kdteditStarted(KDTEditEvent e) {
		// TODO Auto-generated method stub
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntry.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
			//			KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntry.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntry.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntry.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntry.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
			if(this.kdtEntry.getCell(rowIndex, "farmer").getValue()!=null) {
				farmerID=((IPropertyContainer) this.kdtEntry.getCell(rowIndex, "farmer").getValue()).getString("id");
			}
			if(this.kdtEntry.getCell(rowIndex, "outHouse").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntry.getCell(rowIndex, "outHouse").getValue()).getString("id");
			}

			String curCompanyID = "";
			if(prmtcompany.getValue()!=null)
				curCompanyID=((CompanyOrgUnitInfo)prmtcompany.getValue()).getString("id");

			//批次过滤
			if(key.equals("stockingBatch"))
				StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			//养殖场过滤
			if(key.equals("farm"))
				StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			if(key.equals("house")){
				//棚舍过滤
				HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
				EntityViewInfo ev=new EntityViewInfo();
				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
				ev.setFilter(filter);
				((KDBizPromptBox)this.kdtEntry.getColumn("outHouse").getEditor().getComponent()).setEntityViewInfo(ev);
			}
		}
	}

}