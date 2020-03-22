/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.taihe.basesetting.TaiheBaseSettingInfo;
import com.kingdee.eas.custom.taihe.contract.ISuccessiveContract;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo;
import com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo;
import com.kingdee.eas.custom.taihe.utils.TaiheUtils;
import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BatchContractEditUI extends AbstractBatchContractEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchContractEditUI.class);
    private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//组织
	private boolean isLoadField=false;
	private String supplierid;
    /**
     * output class constructor
     */
    public BatchContractEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    private void contractType(){
		if(prmtcontractType.getValue()!=null&&prmtcompany.getValue()!=null){
			String contractType = ((IPropertyContainer)prmtcontractType.getValue()).getString("id");
			String companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
			EntityViewInfo ev1=new EntityViewInfo();
			FilterInfo filter1=new FilterInfo();
			filter1.getFilterItems().add(new FilterItemInfo("contractType.id",contractType,CompareType.EQUALS));
			filter1.getFilterItems().add(new FilterItemInfo("baseStatus",UsedStatusEnum.APPROVED_VALUE,CompareType.EQUALS));
			filter1.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
			ev1.setFilter(filter1);
			prmtsettlePolicy.setEntityViewInfo(ev1);
		}else{
			EntityViewInfo ev2=new EntityViewInfo();
			FilterInfo filter2=new FilterInfo();
			filter2.getFilterItems().add(new FilterItemInfo("company.id","8989qwe",CompareType.EQUALS));
			ev2.setFilter(filter2);
			prmtsettlePolicy.setEntityViewInfo(ev2);
		}
	}
    public void loadFields()
    {
//		ListenerUtil.F7RemoveDateChangeListener(prmtsupplier);
		isLoadField=true;
		super.loadFields();
		isLoadField=false;
		contractType();

    }
    
    private void initDataChaneListener() {
//		chkwhetherRepeat.addChangeListener(new ChangeListener(){
//		public void stateChanged(ChangeEvent e) {
//			// TODO Auto-generated method stub
//			if(prmtsuccessiveContract.getValue()!=null){
//				ISuccessiveContract isc;
//				try {
//					isc = SuccessiveContractFactory.getRemoteInstance();
//					BOSUuid successiveContractID = ((SuccessiveContractInfo)prmtsuccessiveContract.getValue()).getId();
//					SuccessiveContractInfo info = isc.getSuccessiveContractInfo(new ObjectUuidPK(successiveContractID));
//					int a =info.getHasSuccessiveQty()+1;
//					int b = 0;
//					/*txtsuccessiveQty.setText(String.valueOf(a));*/
//					String sql= "/*dialect*/ select CFsuccessiveQty qty,FID from CT_CON_BatchContract " +
//							" where CFsuccessiveQty =( " +
//							" select max(CFsuccessiveQty) qty " +
//							" from CT_CON_BatchContract " +
//							" where FSuccessivecontrac = '"+successiveContractID+"')";
//					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
//					if(rs.next()){
//						b = Integer.valueOf(rs.getString("qty")).intValue();
//						if(editData.getId()!=null){
//							if(rs.getString("FID").equals(editData.getId().toString())){
//								txtsuccessiveQty.setValue(b);
//							}else{
//								if(chkwhetherRepeat.isSelected()){
//									txtsuccessiveQty.setValue(b);
//								}else{
//									txtsuccessiveQty.setValue(b+1);
//								}
//							}
//						}else{
//							if(chkwhetherRepeat.isSelected()){
//								txtsuccessiveQty.setValue(b);
//							}else{
//								txtsuccessiveQty.setValue(b+1);
//							}
//						}
//					}
//					
//					
//					
//				} catch (BOSException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (EASBizException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}else{
//				txtsuccessiveQty.setText(null);
//			}
//		}
//		
//		
//	});
	prmtsuccessiveContract.addDataChangeListener(new DataChangeListener(){
		public void dataChanged(DataChangeEvent arg0) {
			if(isLoadField) {
				return;
			}
			if(prmtsuccessiveContract.getValue()!=null){
				ISuccessiveContract isc;
				try {
					isc = SuccessiveContractFactory.getRemoteInstance();
					BOSUuid successiveContractID = ((SuccessiveContractInfo)prmtsuccessiveContract.getValue()).getId();
					SuccessiveContractInfo info = isc.getSuccessiveContractInfo(new ObjectUuidPK(successiveContractID));
//					int a =info.getHasSuccessiveQty()+1;
					int a = 0;
					int b = 0;
					/*txtsuccessiveQty.setText(String.valueOf(a));*/
					String sql= "/*dialect*/ select CFsuccessiveQty,FID from CT_CON_BatchContract where CFsuccessiveQty =( select max(CFsuccessiveQty) qty from CT_CON_BatchContract where FSuccessivecontrac= '"+successiveContractID+"')";
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
					if(rs.next()){
						System.out.println(rs.getString("CFsuccessiveQty"));
						b = Integer.valueOf(rs.getString("CFsuccessiveQty")).intValue();
						if(editData.getId()!=null){
							if(rs.getString("FID").equals(editData.getId().toString())){
								txtsuccessiveQty.setValue(b);
							}else{
								if(chkwhetherRepeat.isSelected()){
									txtsuccessiveQty.setValue(b);
								}else{
									txtsuccessiveQty.setValue(b+1);
								}
							}
						}else{
							if(chkwhetherRepeat.isSelected()){
								txtsuccessiveQty.setValue(b);
							}else{
								txtsuccessiveQty.setValue(b+1);
							}
						}
						
					}
					
					
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				txtsuccessiveQty.setText(null);
			}
		}
		
	});
	prmtcontractType.addDataChangeListener(new DataChangeListener(){
		public void dataChanged(DataChangeEvent arg0) {
			// TODO Auto-generated method stub
			if(isLoadField) {
				return;
			}
			prmtsettlePolicy.setValue(null);
			contractType();
		}
		
	});
	prmtsupplier.addDataChangeListener(new DataChangeListener(){
		public void dataChanged(DataChangeEvent arg0) {
			if(isLoadField) {
				return;
			}
			// TODO Auto-generated method stub
			if(prmtsupplier.getValue()!=null){
//				txtpartyBCell.setStringValue(String.valueOf(((SupplierReqInfo)prmtsupplier.getValue()).getTelephone()));
				txtpartyBAddress.setStringValue(((SupplierInfo)prmtsupplier.getValue()).getAddress());
//				txtpartyBBank.setStringValue(((SupplierReqInfo)prmtsupplier.getValue()).getBank());
//				txtpartyBAccount.setStringValue(((SupplierReqInfo)prmtsupplier.getValue()).getAccountNum());
				txtpartyBID.setStringValue(((SupplierInfo)prmtsupplier.getValue()).getTaxRegisterNo());
				setSupplierInfo();
				supplierid=((SupplierInfo)prmtsupplier.getValue()).getId().toString();
				asdasdasdasdasd();
				
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
				txtpartyBBank.setStringValue(rs.getString("FBank"));
				txtpartyBAccount.setStringValue(rs.getString("FBankAccount"));
			}
			
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	public static SelectorListener[] F7GetSelectorListener(KDBizPromptBox f7){
		SelectorListener[] listenerArray = f7.getListeners((SelectorListener.class));
		return listenerArray;
	}
	private void asdasdasdasdasd(){
		for(int i = 0; i < F7GetSelectorListener(this.prmtfarm).length; i++){
	     	   this.prmtfarm.removeSelectorListener(F7GetSelectorListener(this.prmtfarm)[i]);
	        }
	        	prmtfarm.addSelectorListener(new SelectorListener() {
				com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
				public void willShow(SelectorEvent e) {
					if (prmtfarm_F7ListUI == null) {
						try {
							prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI()
							{
								@Override
								protected FilterInfo getDefaultFilterForQuery() {
									FilterInfo filterInfo=new FilterInfo();
									String Org = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
									filterInfo.getFilterItems().add(new FilterItemInfo("company.id",Org,CompareType.EQUALS));
									if(StringUtils.isNotBlank(supplierid)){
										filterInfo.getFilterItems().add(new FilterItemInfo("Supplier.id",supplierid,CompareType.EQUALS));
									}
									return filterInfo;
								}
							};
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						HashMap ctx = new HashMap();
						ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
						prmtfarm_F7ListUI.setF7Use(true,ctx);
						prmtfarm.setSelector(prmtfarm_F7ListUI);
					}
				}
			});
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
        return com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance();
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
		 this.prmtfarm.setDisplayFormat("$name$");		
	        this.prmtfarm.setEditFormat("$name$");		
	        this.prmtfarm.setCommitFormat("$name$");	
		contCreateTime.setVisible(true);
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
		
		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				prmtsettlePolicy.setValue(null);
				contractType();
				//setSuccessContractFilter();
			}});
		
		orgInfo = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);
		f7Manager.registerBizSupplierF7(prmtsupplier, null, null, orgInfo);
		
		
		this.chkinitialization.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chkinitialization.isSelected()){
					txtinitialCumulativeQty.setRequired(true);
				}else{
					txtinitialCumulativeQty.setRequired(false);
				}
				
			}
			
		});
		this.chkisSuccessive.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chkisSuccessive.isSelected()) {
					prmtsuccessiveContract.setRequired(true);
				}else {
					prmtsuccessiveContract.setRequired(false);
				}
			}});
		
		this.prmtsettlePolicy.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent es) {
				settlePolicy_changed();
			}});
		this.prmtsettlePolicy.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent es) {
				contractType_changed();
			}});
		//setSuccessContractFilter();
		this.pkinDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(!isLoadField) {
					inData_changed();
				}
			}});
		
		this.txtoutDaysStd.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(!isLoadField) {
					inData_changed();
				}
			}});
		this.txtdiffDays.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(!isLoadField) {
					inData_changed();
				}
			}});
		this.pkbeginDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(pkbeginDate.getValue()!=null){
					pkinDate.setValue(pkbeginDate.getValue());
				}else{
					pkinDate.setValue(null);
				}
			}
			
		});
		kdtAllotEntry_detailPanel.setVisible(false);
		
		initDataChaneListener();
	}
 
	@Override
	public void actionBackClose_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionBackClose_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionClose_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionClose_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionDistribution_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionDistribution_actionPerformed(e);
		if(editData.getId()==null) {
			MsgBox.showWarning("请先保存单据！");
			return;
		}
		UIContext uiContext = new UIContext(this);
    	uiContext.put("billID", editData.getString("id"));//id
    	IUIWindow uiWindow = null ;
    	// UIFactoryName.MODEL 为弹出模式
    	uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.taihe.contract.client.BatchContractAllotUI", uiContext, null,OprtState.VIEW);
    	//开始展现UI
    	uiWindow.show();
	}
	private void inData_changed() {
    	Date inDate=(Date) pkinDate.getValue();
    	if(inDate==null) {
    		return;
    	}
    	int outDays=txtoutDaysStd.getIntegerValue();
    	int diffDays=txtdiffDays.getIntegerValue();
    	Calendar cal=Calendar.getInstance();
    	cal.setTime(inDate);
    	cal.add(Calendar.DAY_OF_MONTH, outDays);
    	cal.add(Calendar.DAY_OF_MONTH, (-1)*diffDays);
    	pkrecycleBeginDate.setValue(cal.getTime());
    	
    	cal.setTime(inDate);
    	cal.add(Calendar.DAY_OF_MONTH, outDays);
    	cal.add(Calendar.DAY_OF_MONTH, diffDays);
    	pkrecycleEndDate.setValue(cal.getTime());
    }
    
    /**
     * 结算政策改变
     */
    private void settlePolicy_changed() {
    	if(isLoadField||prmtsettlePolicy.getValue()==null||prmtcontractType.getValue()==null) {
    		return;
    	}
    	TaiHeSettlePolicyInfo settleInfo=(TaiHeSettlePolicyInfo) prmtsettlePolicy.getValue();
    	String contractTypeName=((IPropertyContainer) prmtcontractType.getValue()).getString("id");
    	//合同
    	if(contractTypeName.equals(settleInfo.getContractType().getString("id"))){
    		txtchickenSzCoeff.setValue(settleInfo.getChickenSzCoeff());
    		txtcontractSafePrice.setValue(settleInfo.getContractPrice());
    		txtpolicySafePrice.setValue(settleInfo.getPolicyPrice());
    		
    		txtbasePrice.setValue(settleInfo.getBasePrice());
    		txthedgingPrice.setValue(settleInfo.getHedgingPrice());
    		txtfixedCoeff.setValue(settleInfo.getFixedCoeff());
    		txtshareCoeff.setValue(settleInfo.getShareCoeff());
    	}else {
    		txtchickenSzCoeff.setValue(BigDecimal.ZERO);
    		txtcontractSafePrice.setValue(BigDecimal.ZERO);
    		txtpolicySafePrice.setValue(BigDecimal.ZERO);
    		
    		txtbasePrice.setValue(BigDecimal.ZERO);
    		txthedgingPrice.setValue(BigDecimal.ZERO);
    		txtfixedCoeff.setValue(BigDecimal.ZERO);
    		txtshareCoeff.setValue(BigDecimal.ZERO);
    	}
    	
    }
    
    private void contractType_changed() {
    	settlePolicy_changed();
	}
    
    /**
     * 设置连养合同过滤条件
     */
   /* private void setSuccessContractFilter() {
    	String companyID="1231231";
    	if(prmtcompany.getValue()!=null) {
    		companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
    	}
    	EntityViewInfo ev=new EntityViewInfo();
    	FilterInfo filter=new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
    	filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		ev.setFilter(filter);
		prmtsuccessiveContract.setEntityViewInfo(ev);
		
//		StockingClientComm.setSettlePolicyFilter(prmtstatementPolicy, companyID,null);
		StockingClientComm.setFarmFilter(prmtfarm, companyID);
		
		ev=new EntityViewInfo();
		filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",UsedStatusEnum.APPROVED_VALUE,CompareType.EQUALS));
		ev.setFilter(filter);
		this.prmtsettlePolicy.setEntityViewInfo(ev);
		
		this.prmtawardPolicy.setEntityViewInfo(ev);
		
    }*/
    
	@Override
	public void prmtfarm_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtfarm_Changed();
	}
	@Override
	public void prmtsuccessiveContract_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtsuccessiveContract_Changed();
	}
	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.BatchContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizDate(new Date());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        
        if(objectValue.getCompany()!=null) {
			try {
				TaiheBaseSettingInfo setInfo = TaiheUtils.getBaseSetting(null, objectValue.getCompany().getString("id"));
				objectValue.setOutDaysStd(setInfo.getStdOutDays());
				objectValue.setFeedType(setInfo.getFeedingType());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
        
        return objectValue;
    }
	public void setTableToSumField() {
		setTableToSumField(getDetailTable(), getSumColNames());
	}
	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return super.getDetailTable();
	}
    public String[] getSumColNames() {
    	ArrayList<String> list=new ArrayList<String>();
    	for(int i=0;i<kdtEntry.getColumnCount();i++)
    		if(kdtEntry.getColumnKey(i).toLowerCase().contains("amt")||kdtEntry.getColumnKey(i).toLowerCase().contains("amount"))
    			list.add(kdtEntry.getColumnKey(i));
    	
    	String[] sumCol=(String[]) list.toArray(new String[list.size()]);
		return sumCol;
    	
    }
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		if(chkisSuccessive.isSelected()&&prmtsuccessiveContract.getValue()==null) {
			MsgBox.showWarning("连养合同不能为空！");
			SysUtil.abort();
		}
		if(chkinitialization.isSelected()&&StringUtils.isBlank(txtinitialCumulativeQty.getText())){
			MsgBox.showWarning("初始累计回收数量不能为空！");
			SysUtil.abort();
		}
	}
    
}