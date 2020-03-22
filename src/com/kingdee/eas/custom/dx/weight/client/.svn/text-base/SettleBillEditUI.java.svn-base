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

import mondrian.rolap.BitKey.Big;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import com.kingdee.eas.custom.dx.weight.SettleReFactory;
import com.kingdee.eas.custom.dx.weight.SettleReInfo;
import com.kingdee.eas.custom.dx.weight.StapleSupplier;
import com.kingdee.eas.custom.dx.weight.StapleSupplierFactory;
import com.kingdee.eas.custom.dx.weight.StapleSupplierInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
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
public class SettleBillEditUI extends AbstractSettleBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettleBillEditUI.class);
    BigDecimal DailyPrice = BigDecimal.ZERO;
    BigDecimal ADDPrice = BigDecimal.ZERO;
    BigDecimal SmPrice = BigDecimal.ZERO;
    /**
     * output class constructor
     */
    public SettleBillEditUI() throws Exception
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
    		DailyPrice = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP);
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
    	txtfarmAmount.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				setKKAmount();
				setPriceAmount();
			}
    		
    	});
    	txtDeductionKF.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
				setKKAmount();
				//}
				if(txtfarmAmount.getBigDecimalValue()!=null){
					setPriceAmount();
				}
			}
    		
    	});
    	txtDeductionSZ.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
					setKKAmount();
				//}
				if(txtfarmAmount.getBigDecimalValue()!=null){
					setPriceAmount();
				}
			}
    		
    	});
    	
    	txtOtherAmount.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
					setKKAmount();
				//}
				if(txtfarmAmount.getBigDecimalValue()!=null){
					setPriceAmount();
				}
			}
    		
    	});
    	txtDeductionPY.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
					setKKAmount();
				//}
				//setSettleAmount();
				if(txtfarmAmount.getBigDecimalValue()!=null){
					setPriceAmount();
				}
			}
	
    	});
    	txtDeductionZY.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
					setKKAmount();
				//}
				if(txtfarmAmount.getBigDecimalValue()!=null){
					setPriceAmount();
				}
			}
	
    	});
    	txtGrossPrice.addDataChangeListener(new DataChangeListener(){

			
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//if(txtDeductionPY.getBigIntegerValue()!=null&&txtDeductionZY.getBigDecimalValue()!=null&&txtDeductionSZ.getBigDecimalValue()!=null&&txtDeductionKF.getBigDecimalValue()!=null){
					setKKAmount();
				//}
				if(txtfarmAmount.getBigDecimalValue()!=null){
					setPriceAmount();
				}
			}
	
    	});
		
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
		 filter.getFilterItems().add(new FilterItemInfo("isSettle", 0,CompareType.EQUALS));
		 //filter.getFilterItems().add(new FilterItemInfo("isweight", 1,CompareType.EMPTY));
		 //filter.setMaskString("#0 and #1");
		 view.setFilter(filter);
		 SorterItemCollection sc = new SorterItemCollection();
		 SorterItemInfo sorterItem = new SorterItemInfo("number");
		 sorterItem.setSortType(SortType.DESCEND);
		 sc.add(sorterItem);
		 view.setSorter(sc);
		 this.prmtCarSend.setEntityViewInfo(view);

	     this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		 this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		 
		 
		 this.txtAmount.setPrecision(0);
		 this.txtCriChickenWgt.setPrecision(1);
		 this.txtCriChickenQty.setPrecision(0);
		 this.txtDeductionKF.setPrecision(2);
		 this.txtDeductionPY.setPrecision(2);
		 this.txtDeductionSZ.setPrecision(2);
		 this.txtDeductionZY.setPrecision(2);
		// this.txtDescription.setPrecision(0);
		 this.txtfarmAmount.setPrecision(1);
		 this.txtfinlAmount.setPrecision(0);
		 this.txtFrightAmount.setPrecision(1);
		 this.txtGrossQty.setPrecision(0);
		 this.txtGrossWgt.setPrecision(1);
		 this.txtSettleAmount.setPrecision(1);
		 this.txtSmChickenQty.setPrecision(0);
		 this.txtSmChickenWgt.setPrecision(1);
		 this.txtPyFarmAmount.setPrecision(0);
		 
		
		
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
				if(info.getQty()!=null){
					gossQty = gossQty.add(info.getQty());
				}
				for(int i=0;i<info.getEntrys().size();i++){
					CarSendBillEntryInfo einfo = info.getEntrys().get(i);
//					if(einfo.getCarcassType().equals(CarcassType.gross)){
//						if(einfo.getQty()!=null){
//							gossQty = gossQty.add(einfo.getQty());
//						}
//						gossWgt = gossWgt.add(einfo.getWgt());
//					}
					
					if(einfo.getCarcassType().equals(CarcassType.chick)){
						if(einfo.getQty()!=null){
							SmChickenQty = SmChickenQty.add(einfo.getQty());
						}
						if(einfo.getWgt()!=null){
							SmChickenWgt = SmChickenWgt.add(einfo.getWgt());
						}
					}
					if(einfo.getCarcassType().equals(CarcassType.cj)){
						if(einfo.getQty()!=null){
							DQty = DQty.add(einfo.getQty());
						}
						if(einfo.getWgt()!=null){
							DWgt = DWgt.add(einfo.getWgt());
						}
					}
				}
				this.txtGrossQty.setValue(gossQty.setScale(0, BigDecimal.ROUND_HALF_UP));
				this.txtGrossWgt.setValue(info.getSuttleWgt());
				this.txtSmChickenQty.setValue(SmChickenQty.setScale(0, BigDecimal.ROUND_HALF_UP));
				this.txtSmChickenWgt.setValue(SmChickenWgt);
				this.txtCriChickenQty.setValue(DQty.setScale(0, BigDecimal.ROUND_HALF_UP));
				this.txtCriChickenWgt.setValue(DWgt);
				if(info.getCar()!=null){
					this.txtcarNum.setText(info.getCarNum());
				}
				
				if(info.getStaplesupplier()!=null){
					StapleSupplierInfo suppinfo= StapleSupplierFactory.getRemoteInstance().getStapleSupplierInfo(new ObjectUuidPK(info.getStaplesupplier().getId().toString()));
					SupplierInfo suinfo = SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(suppinfo.getSupplier().getId().toString()));	
					this.prmtsupplier.setValue(suinfo);
				}
				
				if(info.getCar()!=null){
					CarInfo carInfo= CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(info.getCar().getId().toString()));
					if(carInfo.getEntry().size()>0){
						DriverInfo driverInfo= DriverFactory.getRemoteInstance().getDriverInfo(new ObjectUuidPK(carInfo.getEntry().get(0).getDriver().getId().toString()));
						this.prmtdriver.setValue(driverInfo);
					}
					
					this.txtcarMaster.setText(carInfo.getCarOwner());
				}
				
				String Deductionid = getDeduction(((CarSendBillInfo)prmtCarSend.getValue()).getId().toString());
		    	if(Deductionid!=null){
						SettleReInfo Rinfo = SettleReFactory.getRemoteInstance().getSettleReInfo(new ObjectUuidPK(Deductionid));
						this.txtSettleAmount.setValue(Rinfo.getQCWgt().setScale(1, BigDecimal.ROUND_HALF_UP));
						this.txtAmount.setValue(Rinfo.getSetAmount().setScale(0, BigDecimal.ROUND_HALF_UP));
						this.txtchickavwgt.setValue(this.txtSettleAmount.getBigDecimalValue().divide(this.txtGrossQty.getBigDecimalValue(),2,BigDecimal.ROUND_HALF_UP));
		    	}else{
		    		MsgBox.showWarning("该派车单没有生成相应的结算检测单，请先检测！");
					SysUtil.abort();
		    	}
		    	
		    	
//				setKKAmount();
//				setSettleAmount();
				
				
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
	}

    //计算运费
    private void setPriceAmount() {
    	
    	
    	
    	
    }
    //计算扣款金额
    private void setKKAmount() {
    	BigDecimal DailyPrices = this.txtGrossPrice.getBigDecimalValue();
    	BigDecimal DeductionSZ = BigDecimal.ZERO;
    	BigDecimal DeductionPY = BigDecimal.ZERO;
    	BigDecimal DeductionZY = BigDecimal.ZERO;
    	BigDecimal DeductionKF = BigDecimal.ZERO;
    	BigDecimal Deductionfarm = BigDecimal.ZERO;
    	BigDecimal DeductionOther = BigDecimal.ZERO;
		if(this.txtDeductionSZ.getBigDecimalValue()!=null){
			//扣嗉子
			DeductionSZ = DeductionSZ.add(this.txtDeductionSZ.getBigDecimalValue());
			DeductionSZ = DeductionSZ.multiply(DailyPrices).setScale(0, BigDecimal.ROUND_HALF_UP);
		}
		if(this.txtDeductionPY.getBigDecimalValue()!=null){
			DeductionPY = DeductionPY.add(this.txtDeductionPY.getBigDecimalValue());
			//扣皮炎
			DeductionPY = DeductionPY.multiply(DailyPrices).setScale(0, BigDecimal.ROUND_HALF_UP);
		}
		if(this.txtDeductionZY.getBigDecimalValue()!=null){
			//扣爪炎
			DeductionZY = DeductionZY.add(this.txtDeductionZY.getBigDecimalValue());
			DeductionZY = DeductionZY.multiply(DailyPrices).setScale(0, BigDecimal.ROUND_HALF_UP);
		}
		if(this.txtDeductionKF.getBigDecimalValue()!=null){
			//扣粪
			DeductionKF = DeductionKF.add(this.txtDeductionKF.getBigDecimalValue());
			DeductionKF = DeductionKF.multiply(DailyPrices).setScale(0, BigDecimal.ROUND_HALF_UP);
		}
		if(txtfarmAmount.getBigDecimalValue()!=null){
			//扣养户
			Deductionfarm = Deductionfarm.add(txtfarmAmount.getBigDecimalValue());
		}
		if(txtOtherAmount.getBigDecimalValue()!=null){
			//扣其他
			DeductionOther = DeductionOther.add(txtOtherAmount.getBigDecimalValue());
		}
		//Deduction
		//Deduction=sz+py+zy+kf+扣养户+其他扣重
		BigDecimal Deduction = DeductionSZ.add(DeductionPY).add(DeductionZY).add(DeductionKF);
		//Deductions = sz+py+zy+kf+其他扣重*价格
		BigDecimal Deductions = DeductionSZ.add(DeductionPY).add(DeductionZY).add(DeductionKF).add(DeductionOther.multiply(DailyPrices));	
		BigDecimal friht = BigDecimal.ZERO;
		//结算金额=结算金额-其他扣款
		this.txtreAmount.setValue(this.txtAmount.getBigDecimalValue().subtract(DeductionOther));
		//friht=0+结算金额-养殖户结算金额
    	friht = friht.add(this.txtreAmount.getBigDecimalValue()).subtract(this.txtfarmAmount.getBigDecimalValue());
    	//运费1=friht
    	this.txtFrightAmount.setValue(friht.setScale(0, BigDecimal.ROUND_HALF_UP));  	
    	//BigDecimal sumWgt = this.txtGrossWgt.getBigDecimalValue().add(this.txtSmChickenWgt.getBigDecimalValue()).add(this.txtCriChickenWgt.getBigDecimalValue());
		//修改
		//运费2=Deductions
    	Deductions.setScale(0, BigDecimal.ROUND_HALF_UP);
    	Deduction.setScale(0, BigDecimal.ROUND_HALF_UP);
		this.txtfirghttwo.setValue(Deduction);
		//付客户结算金额
		this.txtPyFarmAmount.setValue(this.txtfarmAmount.getBigDecimalValue().subtract(Deduction));
		//合计运费=运费2+运费1
		this.txtfinlAmount.setValue(this.txtfirghttwo.getBigDecimalValue().add(this.txtFrightAmount.getBigDecimalValue()));
		//总重量=毛鸡数+小鸡数+残鸡数
		BigDecimal sumWgt = this.txtGrossQty.getBigDecimalValue().add(this.txtSmChickenQty.getBigDecimalValue()).add(this.txtCriChickenQty.getBigDecimalValue());
    	//运费单价=合计运费/总数量
		sumWgt = this.txtfinlAmount.getBigDecimalValue().divide(sumWgt, 4, BigDecimal.ROUND_HALF_UP);
    	this.txtfirghtprice.setValue(sumWgt);
		

    }
    //获取相应的结算检测单
    private String getDeduction(String string) {
		// TODO Auto-generated method stub
    	String sql = "select FID from CT_DX_SettleRe where CFCarSendID ='"+string+"'";
    	try {
			IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql);
			while(rs.next()){
				return rs.getString("FID");
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
	/**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }
	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		} 
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
	}
    /**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		reloadData();
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
		//单只运费校验
		SetFrightPrice();
		super.actionSubmit_actionPerformed(e);
		reloadData();
	}
	//单只运费校验
	private void SetFrightPrice() {
		// TODO Auto-generated method stub
		BigDecimal sumWgt = this.txtGrossWgt.getBigDecimalValue().add(this.txtSmChickenWgt.getBigDecimalValue()).add(this.txtCriChickenWgt.getBigDecimalValue());
		sumWgt = this.txtFrightAmount.getBigDecimalValue().divide(sumWgt, 4, BigDecimal.ROUND_HALF_UP);
		String dzyf = getdzyf(SysContext.getSysContext().getCurrentFIUnit().getId().toString(),editData.getBizDate());
		BigDecimal dzyfb = new BigDecimal(dzyf);
		if(sumWgt.compareTo(dzyfb)==1){
			MsgBox.showInfo("单只运费单价大于标准单只单价，请修改扣罚信息后再提交！");
			SysUtil.abort();
		}
		
	}
	//获取标准单价
	private String getdzyf(String string, Date bizDate) {
		// TODO Auto-generated method stub
		String date = DateFormat.getDateInstance(DateFormat.DEFAULT).format(bizDate);
    	String sql = "select FPrice from CT_DX_StandardFright where FBaseStatus = 2 and FCompanyID ='"+string+"' and to_char(FUnEffectDate,'yyyy-MM-dd')>'"+date+"'";
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
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		reloadData();
	}
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.SettleBillInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettleBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}