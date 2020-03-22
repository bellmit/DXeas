/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.dao.xml.impl.AbstractMDValue;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo;
import com.kingdee.eas.custom.taihe.contract.utils.THContractUtils;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class PreBillOfContractEditUI extends AbstractPreBillOfContractEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(PreBillOfContractEditUI.class);
	 private F7ContextManager f7Manager;
		private OrgUnitInfo orgInfo = null;//×éÖ¯
	/**
	 * output class constructor
	 */
	public PreBillOfContractEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{

		ListenerUtil.F7RemoveDateChangeListener(prmtbailPolicy);
		ListenerUtil.F7RemoveDateChangeListener(prmtsupplier);
		ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
		ListenerUtil.F7RemoveDateChangeListener(prmtsuccessiveContract);
		
		super.loadFields();
		prmtsuccessiveContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtsuccessiveContract.getValue()!=null){
					String successiveID = ( (IPropertyContainer) prmtsuccessiveContract.getValue()).getString("id");
					try {
						SuccessiveContractInfo info = SuccessiveContractFactory.getRemoteInstance().getSuccessiveContractInfo(new ObjectUuidPK(successiveID));
						SupplierInfo spinfo = SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(info.getSupplier().getId()));
						FarmInfo finfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
						prmtsupplier.setValue(spinfo);
						prmtfarm.setValue(finfo);
//						txteveyHomeNum.setText(finfo.getEveryHomeNum());
//						pkbuildDate.setValue(finfo.getBuildDate());
//						txtmilesStd.setValue(finfo.getMilesStd());
//						txtheardcell.setText(finfo.getTelePhone());
//						feedingType.setSelectedItem(finfo.getFeedType());
//						chkprohibitArea.setSelected(finfo.isProhibitArea());
//						txthomeNum.setText(finfo.getHomesNum().toString());
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					prmtsupplier.setValue(null);
					prmtfarm.setValue(null);
					txteveyHomeNum.setText(null);
					pkbuildDate.setValue(null);
					txtmilesStd.setValue(null);
					txtheardcell.setText(null);
					feedingType.setSelectedItem(null);
					chkprohibitArea.setSelected(false);
					txthomeNum.setText(null);
					txtheard.setText(null);
					txtfarmScale.setValue(null);
				}
			}
		});
		prmtsupplier.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				/*if(prmtsupplier.getValue()!=null){
					txtpartyBCell.setStringValue(String.valueOf(((SupplierReqInfo)prmtsupplier.getValue()).getTelephone()));
				}*/
				setSupplierInfo();
			}});
		prmtbailPolicy.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtbailPolicy.getValue()!=null){
					txtsafePrice.setValue(((AssureAmtPolicyInfo)prmtbailPolicy.getValue()).getLowPrice());
					txtpromisePrice.setValue(((AssureAmtPolicyInfo)prmtbailPolicy.getValue()).getAssurePrice());
				}
			}});
	}
	
	private void setSupplierInfo() {
		try {
			if(prmtcompany.getValue()==null){
				return;
			}
			if(prmtsupplier.getValue()==null){
				return;
			}
			String companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
			String supplierID=((IPropertyContainer) prmtsupplier.getValue()).getString("id");
			StringBuffer sql=new StringBuffer();
			sql.append(" select tc.FPhone,tcb.FBank,tcb.FBankAccount from T_BD_SupplierCompanyInfo tc")
			.append(" left join  T_BD_SupplierCompanyBank tcb on tcb.FSupplierCompanyInfoID=tc.fid and tcb.fseq=1")
			.append(" where tc.FComOrgID='").append(companyID).append("'")
			.append(" and tc.FSupplierID='").append(supplierID).append("'")
			.append(" ")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				txtpartyBCell.setStringValue(rs.getString("FPhone"));
//				txtpartyBBank.setStringValue(rs.getString("FBank"));
//				txtpartyBBankNo.setStringValue(rs.getString("FBankAccount"));
			}
			
		}catch(Exception err) {
			err.printStackTrace();
		}
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
		return com.kingdee.eas.custom.taihe.contract.PreBillOfContractFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		chkisSuccessive.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chkisSuccessive.isSelected()) {
					prmtsuccessiveContract.setRequired(true);
				}else {
					prmtsuccessiveContract.setRequired(false);
				}
			}});
		chkisSupplier.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chkisSupplier.isSelected()) {
					txtnewSupplier.setEnabled(true);
					txtnewSupplier.setEditable(true);
					prmtsupplier.setEnabled(false);
					
				}else{
					txtnewSupplier.setEnabled(false);
					prmtsupplier.setEnabled(true);
				}
			}
			
		});
		chkisFarm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chkisFarm.isSelected()) {
					txtnewFarm.setEnabled(true);
					txtnewFarm.setEditable(true);
					prmtfarm.setEnabled(false);
					
				}else{
					txtnewFarm.setEnabled(false);
					prmtfarm.setEnabled(true);
				}
			}
			
		});
		contCreateTime.setVisible(true);
		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		contauditTime.setEnabled(false);
		txtmaterialClerk.setStringValue((SysContext.getSysContext().getCurrentUserInfo()).getName());
		
		orgInfo = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);
		f7Manager.registerBizSupplierF7(prmtsupplier, null, null, orgInfo);
		
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
			}});
		
		setFilter();
	}
	
	private void setFilter() {
		String companyID="1231231";
    	if(prmtcompany.getValue()!=null) {
    		companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
    	}
    	
    	THContractUtils.setFilter(prmtbailPolicy, companyID);
		
		StockingClientComm.setFarmFilter(prmtfarm, companyID);
	}
	
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.taihe.contract.PreBillOfContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.PreBillOfContractInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		
		//objectValue.setPurchasePeron();

		return objectValue;
	}

}