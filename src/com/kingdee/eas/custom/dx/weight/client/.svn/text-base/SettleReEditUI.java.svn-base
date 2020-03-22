/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.eas.farm.feemanager.basedata.Driver;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class SettleReEditUI extends AbstractSettleReEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettleReEditUI.class);
    BigDecimal DailyPrice = BigDecimal.ZERO;
    BigDecimal ADDPrice = BigDecimal.ZERO;
    BigDecimal SmPrice = BigDecimal.ZERO;
    /**
     * output class constructor
     */
    public SettleReEditUI() throws Exception
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

   
    private String getDailyPrice(String string, Date bizDate) {
		// TODO Auto-generated method stub
    	String date = DateFormat.getDateInstance(DateFormat.DEFAULT).format(bizDate);
    	String sql = "select fprice from (  select FPrice from T_SET_ChickenDailyPrice where FBaseStatus = 2 and FCompanyID ='"+string+"'  order by FCreateTime desc) where rownum=1 ";
    	try {
			IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql);
			while(rs.next()){
				return rs.getString("FPrice");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}
    
    private String getADDPrice(String string, Date bizDate) {
		// TODO Auto-generated method stub
    	String date = DateFormat.getDateInstance(DateFormat.DEFAULT).format(bizDate);
    	String sql = "select CFAddPrice from (  select CFAddPrice from T_SET_ChickenDailyPrice where FBaseStatus = 2 and FCompanyID ='"+string+"'  order by FCreateTime desc) where rownum=1 ";
    	try {
			IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql);
			while(rs.next()){
				return rs.getString("CFAddPrice");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}
    
    private String getsmPrice(String string, Date bizDate) {
		// TODO Auto-generated method stub
    	String date = DateFormat.getDateInstance(DateFormat.DEFAULT).format(bizDate);
    	String sql = "select CFSmallChickPrice from (  select CFSmallChickPrice from T_SET_ChickenDailyPrice where FBaseStatus = 2 and FCompanyID ='"+string+"'  order by FCreateTime desc) where rownum=1 ";
    	try {
			IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql);
			while(rs.next()){
				return rs.getString("CFSmallChickPrice");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//初始化控件
		IUPls();
		
    	//市场价格维护校验
    	String price = getDailyPrice(SysContext.getSysContext().getCurrentFIUnit().getId().toString(),editData.getBizDate());
    	String addprice = getADDPrice(SysContext.getSysContext().getCurrentFIUnit().getId().toString(),editData.getBizDate());
    	String smprice = getsmPrice(SysContext.getSysContext().getCurrentFIUnit().getId().toString(),editData.getBizDate());
    	
    	if(price!=null){
    		DailyPrice = new BigDecimal(price);
    		if(this.txtGrossPrice.getBigDecimalValue()==null){
    			this.txtGrossPrice.setValue(DailyPrice);
    		}
    		
    		ADDPrice = new BigDecimal(addprice).setScale(2, BigDecimal.ROUND_HALF_UP);
    		SmPrice = new BigDecimal(smprice).setScale(2, BigDecimal.ROUND_HALF_UP);
    	}else{
    		MsgBox.showWarning("没有匹配的价格维护，请检查毛鸡市场价维护！");
			SysUtil.abort();
    	}
    	
    	//派车单更新
    	prmtCarSend.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				CarSendChanged();
			}

			
    		
    	});
    	
    	//扣款信息更新
    	txtDeductionPY.addDataChangeListener(new DataChangeListener(){
    	
    				
    				public void dataChanged(DataChangeEvent arg0) {
    					// TODO Auto-generated method stub
    					setKKAmount();
    				}
    	    		
    	    	});
    	txtDeductionSZ.addDataChangeListener(new DataChangeListener(){
    	
    				
    				public void dataChanged(DataChangeEvent arg0) {
    					// TODO Auto-generated method stub
    					setKKAmount();
    					
    				}
    	    		
    	    	});
    	txtDeductionPY.addDataChangeListener(new DataChangeListener(){
    	
    				
    				public void dataChanged(DataChangeEvent arg0) {
    					// TODO Auto-generated method stub
    					setKKAmount();
    					
    				}
    	    		
    	    	});
    	txtDeductionZY.addDataChangeListener(new DataChangeListener(){
    	
    				
    				public void dataChanged(DataChangeEvent arg0) {
    					// TODO Auto-generated method stub
    					setKKAmount();
    					
    				}
    	    		
    	    	});
    	txtDeductionKF.addDataChangeListener(new DataChangeListener(){
    	
    				
    				public void dataChanged(DataChangeEvent arg0) {
    					// TODO Auto-generated method stub
    					setKKAmount();
    					
    					
    				}
    	    		
    	    	});
    	txtDeductionKSS.addDataChangeListener(new DataChangeListener(){
        	
			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				setKKAmount();
				
				
			}
    		
    	});
    	txtGrossPrice.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
					setKKAmount();
				}
//				if(txtfarmAmount.getBigDecimalValue()!=null){
//					setPriceAmount();
//				}
			}
	
    	});
    	
//    	//皮炎  车间检测后报数，手工录入到结算检测单中，扣罚金额=扣皮炎重量/1000*只数*毛鸡市场价格
//    	txtchickenPYWgt.addDataChangeListener(new DataChangeListener(){
//
//			
//			public void dataChanged(DataChangeEvent arg0) {
//				// TODO Auto-generated method stub
//				BigDecimal pyamount = txtchickenPYWgt.getBigDecimalValue().multiply(txtQCQty.getBigDecimalValue())
//				.multiply(DailyPrice).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
//				txtDeductionPY.setValue(pyamount);
//				
//			}
//    		
//    	});
//    	//嗉子 车间检测后报数，手工录入到结算检测单中，扣罚金额=（扣嗉子重量-30）/1000*只数*毛鸡市场价格
//    	txtchickenSZWgt.addDataChangeListener(new DataChangeListener(){
//
//			
//			public void dataChanged(DataChangeEvent arg0) {
//				// TODO Auto-generated method stub
//				if(txtchickenSZWgt.getBigDecimalValue().subtract(new BigDecimal("30")).compareTo(BigDecimal.ZERO)==1){
//					BigDecimal szamount = txtchickenSZWgt.getBigDecimalValue().subtract(new BigDecimal("30"));
//					szamount = szamount.multiply(txtQCQty.getBigDecimalValue()).multiply(DailyPrice).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
//					txtDeductionSZ.setValue(szamount);
//				}else{
//					txtDeductionSZ.setValue(BigDecimal.ZERO);
//				}
//				
//			}
//    		
//    	});
//    	//爪炎  车间检测后报数，手工录入到结算检测单中，扣罚金额=扣爪炎重量/1000*只数*毛鸡市场价格
//    	txtchickenZYWgt.addDataChangeListener(new DataChangeListener(){
//
//			
//			public void dataChanged(DataChangeEvent arg0) {
//				// TODO Auto-generated method stub
//				BigDecimal zyamount = txtchickenZYWgt.getBigDecimalValue().multiply(txtQCQty.getBigDecimalValue())
//				.multiply(DailyPrice).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
//				txtDeductionZY.setValue(zyamount);
//			}
//    		
//    	});
//    	//鸡粪  单只鸡扣减XX，结算时将扣粪重量减去；
//    	txtFaecesPrice.addDataChangeListener(new DataChangeListener(){
//
//			
//			public void dataChanged(DataChangeEvent arg0) {
//				// TODO Auto-generated method stub
//				BigDecimal jfamount = txtFaecesPrice.getBigDecimalValue().multiply(txtQCQty.getBigDecimalValue()).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
//				txtDeductionKF.setValue(jfamount);
//				BigDecimal cset = BigDecimal.ZERO;
//				cset = txtChickenSet.getBigDecimalValue();
//				txtChickenSet.setValue(cset.subtract(jfamount));
//			}
//    		
//    	});
		
	}
	private void IUPls() {
		// TODO Auto-generated method stub
		 this.prmtCarSend.setQueryInfo("com.kingdee.eas.custom.dx.weight.app.CarSendBillF7Query");		
	     this.prmtCarSend.setVisible(true);		
	     this.prmtCarSend.setEditable(true);		
	     this.prmtCarSend.setDisplayFormat("$number$");		
	     this.prmtCarSend.setEditFormat("$number$");		
	     this.prmtCarSend.setCommitFormat("$number$");		
	     this.prmtCarSend.setRequired(false);
	     EntityViewInfo view = new EntityViewInfo();
		 FilterInfo filter = new FilterInfo();
		 filter.getFilterItems().add(new FilterItemInfo("isSettle", 1,CompareType.ISNOT));
		// filter.getFilterItems().add(new FilterItemInfo("isweight", 1,CompareType.EMPTY));
		// filter.setMaskString("#0 and #1");
		 view.setFilter(filter);
		 this.prmtCarSend.setEntityViewInfo(view);
	     
	     
	     this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		 this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		 
		 this.prmtcar.setDisplayFormat("$name$");		
	     this.prmtcar.setEditFormat("$name$");		
	     this.prmtcar.setCommitFormat("$name$");
		
	     this.prmtdriver.setDisplayFormat("$drivername$");		
	     this.prmtdriver.setEditFormat("$drivername$");		
	     this.prmtdriver.setCommitFormat("$drivername$");
	     
	     
		 this.txtCriChickenWgt.setPrecision(1);
		 this.txtCriChickenQty.setPrecision(0);
		 this.txtDeductionKF.setPrecision(0);
		 this.txtDeductionPY.setPrecision(0);
		 this.txtDeductionSZ.setPrecision(0);
		 this.txtDeductionZY.setPrecision(0);
		 this.txtGrossQty.setPrecision(0);
		 this.txtGrossWgt.setPrecision(1);
		 this.txtSmChickenQty.setPrecision(0);
		 this.txtSmChickenWgt.setPrecision(1);
	     
		 
		 this.txtChickenSet.setPrecision(1);
		 this.txtchickenPYWgt.setPrecision(1);
		 this.txtchickenSZWgt.setPrecision(1);
		 this.txtchickenZYWgt.setPrecision(1);
		 this.txtDeductionKSS.setPrecision(1);
		 this.txtSetAmount.setPrecision(0);
		 this.txtQCQty.setPrecision(1);
		 this.txtQCWgt.setPrecision(1);
		// this.txtFaecesPrice.setPrecision(1);
//		 this.txtt.setPrecision(1);
//		 this.txtQCWgt.setPrecision(1);
//		 
	     
		
	}
	//根据派车单 传入数据
    private void CarSendChanged() {
		// TODO Auto-generated method stub
		try {
			CarSendBillInfo info = CarSendBillFactory.getRemoteInstance().getCarSendBillInfo(new ObjectUuidPK(((CarSendBillInfo)prmtCarSend.getValue()).getId().toString()));
			if(info!=null){
				BigDecimal gossQty = BigDecimal.ZERO;
				BigDecimal gossWgt = BigDecimal.ZERO;
				BigDecimal SmChickenQty = BigDecimal.ZERO;
				BigDecimal SmChickenWgt = BigDecimal.ZERO;
				BigDecimal DQty = BigDecimal.ZERO;
				BigDecimal DWgt = BigDecimal.ZERO;
				
				for(int i=0;i<info.getEntrys().size();i++){
					CarSendBillEntryInfo einfo = info.getEntrys().get(i);
//					if(einfo.getCarcassType().equals(CarcassType.gross)){
//						gossQty = gossQty.add(einfo.getQty());
//						gossWgt = gossWgt.add(einfo.getWgt());
//					}
					if(einfo.getCarcassType().equals(CarcassType.chick)){
						SmChickenQty = SmChickenQty.add(einfo.getQty());
						SmChickenWgt = SmChickenWgt.add(einfo.getWgt());
					}
					if(einfo.getCarcassType().equals(CarcassType.cj)){
						DQty = DQty.add(einfo.getQty());
						DWgt = DWgt.add(einfo.getWgt());
					}
				}
				if(info.getQty()!=null){
					gossQty = gossQty.add(info.getQty());
				}
				//毛鸡重量=毛鸡过磅净重（包括毛鸡、小鸡、残鸡），保留一位小数
				gossWgt = info.getSuttleWgt().add(SmChickenWgt).add(DWgt);
				
				//entitySettlDetection.setGrossQty(gossQty);
				this.txtGrossQty.setValue(gossQty);
				this.txtGrossWgt.setValue(info.getSuttleWgt());
				this.txtSmChickenQty.setValue(SmChickenQty);
				this.txtSmChickenWgt.setValue(SmChickenWgt);
				this.txtCriChickenQty.setValue(DQty);
				this.txtCriChickenWgt.setValue(DWgt);
				this.txtGrossSumQty.setValue(gossQty);
				gossQty = gossQty.subtract(SmChickenQty).subtract(DQty);
				this.txtQCQty.setValue(gossQty);
				this.txtQCWgt.setValue(gossWgt);
				this.txtChickenSet.setValue(gossWgt.add(SmChickenWgt));
			
				if(info.getCar()!=null){
					this.txtcarNum.setText(info.getCarNum());
					CarInfo carinfo = CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(info.getCar().getId().toString()));
					this.prmtcar.setValue(carinfo);
				}
				if(info.getDriver()!=null){
					DriverInfo driverinfo = DriverFactory.getRemoteInstance().getDriverInfo(new ObjectUuidPK(info.getDriver().getId().toString()));
					this.prmtdriver.setValue(driverinfo);
					//editData.setDriver(item)
				}
				//reloadData();
				
				
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
	}
    //计算扣款金额和结算金额
    private void setKKAmount() {
    	 BigDecimal pyamount = BigDecimal.ZERO;
    	 
    	 DailyPrice = this.txtGrossPrice.getBigDecimalValue();
    		if(txtDeductionSZ.getBigDecimalValue()!=null){
    			pyamount = pyamount.add(txtDeductionSZ.getBigDecimalValue());
    		}
    		if(txtDeductionPY.getBigDecimalValue()!=null){
    			pyamount = pyamount.add(txtDeductionPY.getBigDecimalValue());
    		}
    		if(txtDeductionZY.getBigDecimalValue()!=null){
    			pyamount = pyamount.add(txtDeductionZY.getBigDecimalValue());
    		}
    		if(txtDeductionKF.getBigDecimalValue()!=null){
    			pyamount = pyamount.add(txtDeductionKF.getBigDecimalValue());
    		}
    		if(txtDeductionKSS.getBigDecimalValue()!=null){
    			pyamount = pyamount.add(txtDeductionKSS.getBigDecimalValue());
    		}
    		if(txtGrossWgt.getBigDecimalValue()!=null){
    			pyamount = txtGrossWgt.getBigDecimalValue().subtract(pyamount).setScale(1, BigDecimal.ROUND_HALF_UP);
    			txtQCWgt.setValue(pyamount);
    			//txtQCWgt
    			
    		}
    		if(txtCriChickenWgt.getBigDecimalValue()!=null&&txtSmChickenWgt.getBigDecimalValue()!=null){
    			BigDecimal cs = txtQCWgt.getBigDecimalValue().subtract(txtCriChickenWgt.getBigDecimalValue()).subtract(txtSmChickenWgt.getBigDecimalValue());
    			txtChickenSet.setValue(cs);
    			txtGrossSumQty.setValue(txtQCQty.getBigDecimalValue().add(txtSmChickenQty.getBigDecimalValue()).setScale(1, BigDecimal.ROUND_HALF_UP)); 
    			BigDecimal cset = txtChickenSet.getBigDecimalValue().multiply(DailyPrice.add(ADDPrice));
    			cset = cset.add(txtSmChickenWgt.getBigDecimalValue().multiply(SmPrice)).setScale(1, BigDecimal.ROUND_HALF_UP);
    			txtSetAmount.setValue(cset);
    			//txtQCWgt.setValue(cset);
    		}
    }
   
	
	
    
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.SettleReFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.dx.weight.SettleReInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettleReInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

//	/**
//	 * 重载单据内容
//	 * @throws Exception 
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 */
//	private void reloadData() throws EASBizException, BOSException, Exception{
//
//		if ((this.editData == null) || (this.editData.getId() == null)) {
//			return;
//		}
//		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
//		setDataObject(getValue(pk));
//		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
//		loadFields();
//		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
//		initOldData(this.editData);
//		setSave(true);
//		setSaved(true);
//		// 中断
//		SysUtil.abort();
//	}
    /**
	 * 审核 
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		//reloadData();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
	/**
	 * 提交
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		//reloadData();
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		//reloadData();
	}

}