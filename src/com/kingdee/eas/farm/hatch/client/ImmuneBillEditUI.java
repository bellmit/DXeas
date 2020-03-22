/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;

/**
 * output class name
 */
public class ImmuneBillEditUI extends AbstractImmuneBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ImmuneBillEditUI.class);

	private HashSet<String> stoSet=new HashSet<String>();//孵化场 对应库存组织ID
	/**
	 * output class constructor
	 */
	public ImmuneBillEditUI() throws Exception
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
		return com.kingdee.eas.farm.hatch.ImmuneBillFactory.getRemoteInstance();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

        this.prmtreceivePerson.setEditFormat("$name$");		
        
        
        
        this.prmtreceivePerson.setCommitFormat("$name$");		
		
		
		this.prmtdriver.setEditFormat("$drivername$");		
		this.prmtdriver.setCommitFormat("$drivername$");		

		pkBizDate.setTimeEnabled(true);
		pkfinishTime.setTimeEnabled(true);


		txtqty.setHorizontalAlignment(SwingConstants.RIGHT);
		txtqty.setPrecision(0);



		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);

		setPrmtHatchFactoryFilterAndSetDefaultData();
		prmtsendPerson.setValue(SysContext.getSysContext().getCurrentUserInfo().getPerson());

		prmtsendPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
		prmtreceivePerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");

	}

	/**
	 * 表头孵化场过滤
	 */
	private void setPrmtHatchFactoryFilterAndSetDefaultData() {
		// TODO Auto-generated method stub
		//设置孵化场过滤1---加载孵化区
		HatchBaseDataCollection hatchBaseDataCollection;
		try {
			hatchBaseDataCollection = HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataCollection("where BillStatus in (3,4)");
			hatchBaseDataCollection.sort("name");

			//第一次设置默认值
			if(oprtState.equals("ADDNEW")&&hatchBaseDataCollection.size()>0&&hatchBaseDataCollection.get(0).getHatchFactory()!=null)
				prmthatchFactory.setValue(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(hatchBaseDataCollection.get(0).getHatchFactory().getString("id"))));
			Iterator iterator = hatchBaseDataCollection.iterator();


			while(iterator.hasNext()){
				HatchBaseDataInfo object = (HatchBaseDataInfo) iterator.next();
				if(object.getHatchFactory()==null)
					continue;
				if(!stoSet.contains(object.getHatchFactory().getString("id")))
					stoSet.add(object.getHatchFactory().getString("id"));
				//存在同库存组织孵化场 时覆盖原来的默认值
				if(oprtState.equals("ADDNEW")&&SysContext.getSysContext().getCurrentStorageUnit()!=null&&SysContext.getSysContext().getCurrentStorageUnit().getString("id").equals(object.getHatchFactory().getString("id")))
					prmthatchFactory.setValue(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(object.getHatchFactory().getString("id"))));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置孵化场过滤2
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		if(stoSet.size()==0)
			stoSet.add("1111");
		filter.getFilterItems().add(new FilterItemInfo("id",stoSet,CompareType.INCLUDE));
		evi.setFilter(filter);
		System.out.println("孵化区过滤："+filter);
		prmthatchFactory.setEntityViewInfo(evi);
	}


	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.ImmuneBillInfo objectValue = new com.kingdee.eas.farm.hatch.ImmuneBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());
		objectValue.setDepartment(SysContext.getSysContext().getCurrentAdminUnit());
		objectValue.setBigDecimal("qty", BigDecimal.ZERO);
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}

}