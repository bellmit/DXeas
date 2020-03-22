/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class SettlDetectionEditUI extends AbstractSettlDetectionEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettlDetectionEditUI.class);
    BigDecimal DailyPrice = BigDecimal.ZERO;
    /**
     * output class constructor
     */
    public SettlDetectionEditUI() throws Exception
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
    	String sql = "select FPrice from T_SET_ChickenDailyPrice where FCompanyID ='"+string+"' and to_char(FUnEffectDate,'yyyy-MM-dd')<'"+date+"'";
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
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
    	//市场价格维护校验
    	
    	String price = getDailyPrice(SysContext.getSysContext().getCurrentFIUnit().getId().toString(),editData.getBizDate());
    	if(price!=null){
    		DailyPrice = new BigDecimal(price);
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
    	//皮炎  车间检测后报数，手工录入到结算检测单中，扣罚金额=扣皮炎重量/1000*只数*毛鸡市场价格
    	txtchickenPYWgt.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				BigDecimal pyamount = txtchickenPYWgt.getBigDecimalValue().multiply(txtQCQtyt.getBigDecimalValue())
				.multiply(DailyPrice).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
				txtDeductionPY.setValue(pyamount);
				
			}
    		
    	});
    	//嗉子 车间检测后报数，手工录入到结算检测单中，扣罚金额=（扣嗉子重量-30）/1000*只数*毛鸡市场价格
    	txtchickenSZWgt.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(txtchickenSZWgt.getBigDecimalValue().subtract(new BigDecimal("30")).compareTo(BigDecimal.ZERO)==1){
					BigDecimal szamount = txtchickenSZWgt.getBigDecimalValue().subtract(new BigDecimal("30"));
					szamount = szamount.multiply(txtQCQtyt.getBigDecimalValue()).multiply(DailyPrice).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
					txtDeductionSZ.setValue(szamount);
				}else{
					txtDeductionSZ.setValue(BigDecimal.ZERO);
				}
				
			}
    		
    	});
    	//爪炎  车间检测后报数，手工录入到结算检测单中，扣罚金额=扣爪炎重量/1000*只数*毛鸡市场价格
    	txtchickenZYWgt.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				BigDecimal zyamount = txtchickenZYWgt.getBigDecimalValue().multiply(txtQCQtyt.getBigDecimalValue())
				.multiply(DailyPrice).divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
				txtDeductionZY.setValue(zyamount);
			}
    		
    	});
    	//鸡粪  单只鸡扣减XX，结算时将扣粪重量减去；
    	txtFaecesPrice.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				BigDecimal jfamount = txtFaecesPrice.getBigDecimalValue().multiply(txtQCQtyt.getBigDecimalValue());
				txtDeductionKF.setValue(jfamount);
				BigDecimal cset = BigDecimal.ZERO;
				cset = txtChickenSet.getBigDecimalValue();
				txtChickenSet.setValue(cset.subtract(jfamount));
			}
    		
    	});
		
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
				//entitySettlDetection.setGrossQty(gossQty);
				this.txtGrossQty.setValue(gossQty);
				this.txtGrossWgt.setValue(gossWgt);
				this.txtSmChickenQty.setValue(SmChickenQty);
				this.txtSmChickenWgt.setValue(SmChickenWgt);
				this.txtCriChickenQty.setValue(DQty);
				this.txtCriChickenWgt.setValue(DWgt);
				this.txtQCQtyt.setValue(gossQty.add(SmChickenQty).add(DQty));
				this.txtQCWgt.setValue(gossWgt.add(SmChickenWgt).add(DWgt));
				this.txtChickenSet.setValue(gossWgt.subtract(SmChickenWgt).subtract(DWgt));
//				entitySettlDetection.setGrossWgt(gossWgt);
//				entitySettlDetection.setSmChickenQty(SmChickenQty);
//				entitySettlDetection.setSmChickenWgt(SmChickenWgt);
//				entitySettlDetection.setCriChickenQty(DQty);
//				entitySettlDetection.setCriChickenWgt(DWgt);
//				entitySettlDetection.setQCQtyt(gossQty.add(SmChickenQty).add(DQty));
//				entitySettlDetection.setQCWgt(gossWgt.add(SmChickenWgt).add(DWgt));
//				entitySettlDetection.setChickenSet(gossWgt.subtract(SmChickenWgt).subtract(DWgt));
				if(info.getCar()!=null){
					this.txtcarNum.setText(info.getCarNum());
					this.prmtcar.setValue(info.getCar());
				}
				if(info.getDriver()!=null){
					this.prmtdriver.setValue(info.getDriver());
				}
				//this.prmtcompany.setValue(info.setc)
				
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
	}
    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

 

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.SettlDetectionFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.dx.weight.SettlDetectionInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettlDetectionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
//        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

        return objectValue;
    }

}