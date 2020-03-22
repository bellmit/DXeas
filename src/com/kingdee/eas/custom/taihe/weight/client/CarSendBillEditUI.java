/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.IBatchContract;
import com.kingdee.eas.custom.taihe.weight.PurchaseType;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.farm.feemanager.basedata.IDriver;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarm;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.publicdata.ICar;
import com.kingdee.eas.util.client.MsgBox;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CarSendBillEditUI extends AbstractCarSendBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CarSendBillEditUI.class);
    private boolean isLoadField=false;
    /**
     * output class constructor
     */
    public CarSendBillEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    
    public void loadFields(){
 
    	isLoadField=true;
        super.loadFields();
        isLoadField=false;
        
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
        return com.kingdee.eas.custom.taihe.weight.CarSendBillFactory.getRemoteInstance();
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
		//删除复制按钮
		this.toolBar.remove(btnCopy);
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		contCreateTime.setVisible(true);
		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		pkreachFactoryDate.setTimeEnabled(true);
		pkactualReachDate.setTimeEnabled(true);
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.pktareFirstTime.setTimeEnabled(true);
		this.pktareSecondTime.setTimeEnabled(true);
//		this.prmtfarm.setDisplayFormat("$name$");		
//	    this.prmtfarm.setEditFormat("$name$");		
//	    this.prmtfarm.setCommitFormat("$name$");
	    this.prmtsupplier.setDisplayFormat("$name$");		
	    this.prmtsupplier.setEditFormat("$name$");		
	    this.prmtsupplier.setCommitFormat("$name$");	
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
		
		setFilter();
		
		prmtcar.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(isLoadField){
					return;
				}
				String carID = ((CarInfo)prmtcar.getValue()).getId().toString();
				try {
					String carEntrysql = "select FDriverID from T_PUB_CarEntry where FParentID ='"+carID+"'";
					IRowSet  rs = SQLExecutorFactory.getRemoteInstance(carEntrysql).executeSQL();
					if(rs.next()){
						IDriver idriver = DriverFactory.getRemoteInstance();
						DriverInfo dInfo = idriver.getDriverInfo(new ObjectUuidPK(rs.getString("FDriverID")));
						prmtdriver.setValue(dInfo);
					}
					ICar  ic = CarFactory.getRemoteInstance();
					CarInfo carInfo = ic.getCarInfo(new ObjectUuidPK(carID));
					txtbasketQty.setValue(carInfo.getBasketsNumber());
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
			}
        }); 
		
//		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
//			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
//				if(isLoadField){
//					return;
//				}
//				// TODO Auto-generated method stub
//				if(prmtbatchContract.getValue()!=null){
//					if(purchaseType.getSelectedItem()==PurchaseType.Contract){
//						String batchContractID = ((BatchContractInfo)prmtbatchContract.getValue()).getId().toString();
//						IBatchContract ibc;
//						try {
//							ibc = BatchContractFactory.getRemoteInstance();
//							BatchContractInfo bcInfo = ibc.getBatchContractInfo(new ObjectUuidPK(batchContractID));
//							IFarm iFarm = FarmFactory.getRemoteInstance();
//							FarmInfo farmInfo = iFarm.getFarmInfo(new ObjectUuidPK(bcInfo.getFarm().getId()));
//							prmtfarm.setValue(farmInfo);
//							SupplierInfo supplierInfo = SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(bcInfo.getSupplier().getId()));
//							prmtsupplier.setValue(supplierInfo);
//						} catch (BOSException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (EASBizException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}else{
//						prmtbatchContract.setValue(null);
//						MsgBox.showInfo("非合同类型不能选择批次合同");
//					}
//				}else{
//					prmtfarm.setValue(null);
//					prmtsupplier.setValue(null);
//				}
//				
//			}
//        });
//		purchaseType.addItemListener(new ItemListener(){
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				if(purchaseType.getSelectedItem()!=PurchaseType.Contract){
//					prmtbatchContract.setValue(null);
//					prmtfarm.setValue(null);
//					prmtsupplier.setValue(null);
//				}
//			}
//			
//		});
	}
    
    private void setFilter() {
		String OrgID = "123312123565";
		if(prmtcompany.getValue()!=null) {
			OrgID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
		}
		EntityViewInfo evInfo=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
//		filterInfo.getFilterItems().add(new FilterItemInfo("company.id",OrgID,CompareType.EQUALS));
//		filterInfo.getFilterItems().add(new FilterItemInfo("billStatus",4,CompareType.EQUALS));
		StringBuffer sql=new StringBuffer();
		sql.append(" select fparentid from  T_CON_BatchContractAllotEntry where fallotorgid='").append(OrgID).append("'")
		.append(" union all")
		.append(" select fid from CT_CON_BatchContract where CFCompanyID='").append(OrgID).append("' and fbillstatus=4")
		.append(" ")
		;
		filterInfo.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
		evInfo.setFilter(filterInfo);
//		this.prmtbatchContract.setEntityViewInfo(evInfo);
    }
    
	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
    	
    	com.kingdee.eas.custom.taihe.weight.CarSendBillInfo objectValue = new com.kingdee.eas.custom.taihe.weight.CarSendBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setPurchaseType(PurchaseType.Contract);
        
        Date date = new Date();
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,1);//+1今天的时间加一天
        objectValue.setBizDate(date);
        objectValue.setRecycleDate(calendar.getTime());
        objectValue.setReachFactoryDate(calendar.getTime());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
	@Override
	protected void setFieldsNull(AbstractObjectValue arg0) {
		// TODO Auto-generated method stub
		super.setFieldsNull(arg0);
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,1);//+1今天的时间加一天
		arg0.setDate("recycleDate", calendar.getTime());
		arg0.setDate("reachFactoryDate", calendar.getTime());
	}
	/*public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(prmtsupplier.getValue()==null){
			MsgBox.showInfo("供应商不许为空");
		}
		if(StringUtils.isBlank(txtfarmAddress.getText())){
			MsgBox.showInfo("养殖场地址不许为空");
		}
		if(prmtsupplier.getValue()!=null&&StringUtils.isNotBlank(txtfarmAddress.getText())){
			super.actionSubmit_actionPerformed(e);
		}
		
		
	}*/
	
	
    
}