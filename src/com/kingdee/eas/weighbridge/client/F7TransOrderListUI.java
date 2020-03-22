/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.extendcontrols.QueryAgent;
import com.kingdee.bos.ctrl.extendcontrols.util.BosHelper;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.KDPromptSelector;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.client.CoreUI;
import com.kingdee.eas.scm.im.inv.TransferOrderBill;
import com.kingdee.eas.scm.im.inv.TransferOrderBillEntryInfo;
import com.kingdee.eas.scm.im.inv.TransferOrderBillInfo;
import com.kingdee.eas.scm.sd.sale.ISaleOrder;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntry;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderEntry;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.ExceptionHandler;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.F7SelectBillInfo;
import com.kingdee.eas.weighbridge.ICommSqlFacade;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class F7TransOrderListUI extends AbstractF7TransOrderListUI implements KDPromptSelector
{
    private static final Logger logger = CoreUIObject.getLogger(F7TransOrderListUI.class);
    public static final int PURORDER_VALUE=0;//采购订单 
    public static final int SALEORDER_VALUE=1;//销售订单
    public static final int TRANSIN_VALUE=3;//调拨入
    public static final int TRANSOUT_VALUE=4;//调拨出
    private F7SelectBillInfo[] returnInfos;//返回对象
    private int BizType;
    private String orgUnitID;
    private String billBosType;
    private String entryBosType;
    /**
     * output class constructor
     */
    public F7TransOrderListUI(int bizType) throws Exception
    {
        this();
        this.BizType=bizType;
    }
    public F7TransOrderListUI() throws Exception
    {
        super();
        this.setUITitle("单据选择");
    }

	
	public Object getData() {
		return returnInfos;
	}

	
	public boolean isCanceled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		this.tbAll.removeRows();
		this.tbSelected.removeRows();
		String number=this.txtNumber.getText();
		String beginDate=this.dpBeginDate.getText();
		String endDate=this.dpEndDate.getText();
		String materialID=null;
		String objectID=null;
		if(this.prmtBizObject.getValue()!=null) {
			objectID=((CoreBaseInfo) this.prmtBizObject.getValue()).getId().toString();
		}
		if(this.prmtMaterial.getValue()!=null) {
			materialID=((CoreBaseInfo) this.prmtMaterial.getValue()).getId().toString();
		}
		if(StringUtils.isBlank(beginDate)||StringUtils.isBlank(endDate)) {
			MsgBox.showWarning("开始和结束日期不能为空！");
			SysUtil.abort();
		}
		if(this.BizType==PURORDER_VALUE) {
			this.execPurOrderQuery(number,beginDate,endDate,objectID,materialID);
		} else if(this.BizType==SALEORDER_VALUE) {
			this.execSaleOrderQuery(number,beginDate,endDate,objectID,materialID);
		}
		else if(this.BizType==TRANSIN_VALUE) {
			this.execTransOrderQuery(number,beginDate,endDate,objectID,materialID);
		}
	}
	/*
	 * 采购订单查询
	 */
	private void execPurOrderQuery(String number,String beginDate,String endDate,String customerID,String materialID) throws BOSException, SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.FID id,tbill.FNumber number,tbill.FBizDate bizDate,tcus.FName_l2 \"orderCustomer.name\", ");
		sql.append(" tEntry.FID \"entries.id\",tm.FNumber \"material.number\",tm.FName_l2 \"material.name\",tu.Fname_l2 \"unit.name\",tentry.FBaseQty \"entries.baseQty\",");
		sql.append(" tEntry.FSeq \"entries.seq\"");
		sql.append(" from t_sm_PurOrder tbill");
		sql.append(" inner join t_bd_Supplier tcus on tcus.FID=tbill.FSupplierID");
		sql.append(" inner join t_sm_purOrderEntry tEntry on tEntry.FParentID=tbill.FID");
		sql.append(" inner join t_bd_material tm on tm.FID=tEntry.FMaterialID");
		sql.append(" inner join T_BD_MeasureUnit tu on tu.fid=tEntry.FUnitID");
		sql.append(" where 1=1");
		//sql.append(" and  tbill.FPurchaseOrgUnitID=?");
		sql.append(" and tbill.FBizDate>={ts'").append(beginDate).append("'}");
		sql.append(" and tbill.FBizDate<={ts'").append(endDate).append("'}");
		//sql.append(" and tbill.FBaseStatus=4");
		IRowSet rs=getCommSqlFacade().executeQuery(sql.toString());//,new Object[]{this.orgUnitID});
		//IMetaDataPK metaPK = new MetaDataPK("com.kingdee.eas.scm.sd.sale.app.SaleOrderQuery");
		//IRowSet rs=this.getDataByMeta(metaPK, null);
		IRow row;
		BigDecimal qty,weighQty;
		while(rs.next()) {
			row=this.tbAll.addRow();
			row.getCell("id").setValue(rs.getString("id"));
			row.getCell("number").setValue(rs.getString("number"));
			row.getCell("bizDate").setValue(rs.getString("bizDate").substring(0,10));
			row.getCell("supplier").setValue(rs.getString("orderCustomer.name"));
			row.getCell("entryID").setValue(rs.getString("entries.id"));
			row.getCell("entrySeq").setValue(rs.getString("entries.seq"));
			row.getCell("material").setValue(rs.getString("material.number"));
			row.getCell("materialName").setValue(rs.getString("material.name"));
			row.getCell("unit").setValue(rs.getString("unit.name"));
			qty=rs.getBigDecimal("entries.baseQty");
			row.getCell("qty").setValue(qty);
			weighQty=getWeighQty(rs.getString("id"), rs.getString("entries.id"));
			row.getCell("weighQty").setValue(weighQty);
			row.getCell("remainWeighQty").setValue(qty.subtract(weighQty));
		}
;		rs.close();
	}
	/**
	 * 执行销售订单查询
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private void execSaleOrderQuery(String number,String beginDate,String endDate,String supplierID,String materialID) throws BOSException, SQLException {
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.FID id,tbill.FNumber number,tbill.FBizDate bizDate,tcus.FName_l2 \"orderCustomer.name\", ");
		sql.append(" tEntry.FID \"entries.id\",tm.FNumber \"material.number\",tm.FName_l2 \"material.name\",tu.Fname_l2 \"unit.name\",tentry.FBaseQty  \"entries.baseQty\",");
		sql.append(" tEntry.FSeq \"entries.seq\"");
		sql.append(" from t_sd_saleOrder tbill");
		sql.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FOrderCustomerID");
		sql.append(" inner join t_sd_saleOrderEntry tEntry on tEntry.FParentID=tbill.FID");
		sql.append(" inner join t_bd_material tm on tm.FID=tEntry.FMaterialID");
		sql.append(" inner join T_BD_MeasureUnit tu on tu.fid=tEntry.FUnitID");
		sql.append(" where 1=1");
		//sql.append(" and  tbill.FSaleOrgUnitID=?");
		sql.append(" and tbill.FBizDate>={ts'").append(beginDate).append("'}");
		sql.append(" and tbill.FBizDate<={ts'").append(endDate).append("'}");
		//sql.append(" and tbill.FBaseStatus=4");
		IRowSet rs=getCommSqlFacade().executeQuery(sql.toString());//,new Object[]{this.orgUnitID});
		//IMetaDataPK metaPK = new MetaDataPK("com.kingdee.eas.scm.sd.sale.app.SaleOrderQuery");
		//IRowSet rs=this.getDataByMeta(metaPK, null);
		IRow row;
		BigDecimal qty,weighQty;
		while(rs.next()) {
			row=this.tbAll.addRow();
			row.getCell("id").setValue(rs.getString("id"));
			row.getCell("number").setValue(rs.getString("number"));
			row.getCell("bizDate").setValue(rs.getString("bizDate").substring(0,10));
			row.getCell("orderStorageOrgUnit").setValue(rs.getString("orderCustomer.name"));
			row.getCell("entryID").setValue(rs.getString("entries.id"));
			row.getCell("entrySeq").setValue(rs.getString("entries.seq"));
			row.getCell("material").setValue(rs.getString("material.number"));
			row.getCell("materialName").setValue(rs.getString("material.name"));
			row.getCell("unit").setValue(rs.getString("unit.name"));
			qty=rs.getBigDecimal("entries.baseQty");
			row.getCell("qty").setValue(qty);
			weighQty=getWeighQty(rs.getString("id"), rs.getString("entries.id"));
			row.getCell("weighQty").setValue(weighQty);
			row.getCell("remainWeighQty").setValue(qty.subtract(weighQty));
		}
;		rs.close();
	}
	/*
	 * 调拨订单查询
	 */
	private void execTransOrderQuery(String number,String beginDate,String endDate,String customerID,String materialID) throws BOSException, SQLException {
		/*MetaDataPK metaPK = new MetaDataPK("com.kingdee.eas.scm.sm.pur.app.PurOrderQuery");
		//kingdee.eas.scm.im.inv.TransferOrderBillQuery
		IQueryExecutor exec = QueryExecutorFactory.getRemoteInstance(metaPK);
		exec.setObjectView("");   
		exec.option().isAutoTranslateEnum = true;  
		exec.option().isAutoTranslateBoolean = true;
		IRowSet rs=exec.executeQuery();*/
	/*	QueryAgent qa = new QueryAgent();
		qa.setQueryInfoPK((MetaDataPK) metaPK);
		qa.setEntityViewInfo(null);
		qa.setDefaultFilterInfo(null);
		 qa.switchMainOrgContext(SysContext.getSysContext().getCurrentAdminUnit().getId().toString());
		rs=qa.executeQuery(0, 2147483647);*/
//		IRowSet rs=this.getDataByMeta(metaPK, null);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.FID id,tbill.FNumber number,tbill.FBizDate bizDate,tcus.FName_l2 \"orderCustomer.name\", ");
		sql.append(" tEntry.FID \"entries.id\",tm.FNumber \"material.number\",tm.FName_l2 \"material.name\",tu.Fname_l2 \"unit.name\",tentry.FBaseQty \"entries.baseQty\",");
		sql.append(" tEntry.FSeq \"entries.seq\"");
		sql.append(" from T_IM_TransferOrderBill tbill");
		sql.append(" inner join T_ORG_Storage tcus on tcus.FID=tbill.FIssueStorageOrgUnitID");
		sql.append(" inner join T_IM_TransferOrderBillEntry tEntry on tEntry.FParentID=tbill.FID");
		sql.append(" inner join t_bd_material tm on tm.FID=tEntry.FMaterialID");
		sql.append(" inner join T_BD_MeasureUnit tu on tu.fid=tEntry.FUnitID");
		sql.append(" where 1=1");
		//sql.append(" and  tbill.FReceiptStorageOrgUnitID=?");//需方库存组织
		//sql.append(" and  tbill.FIssueStorageOrgUnitID=?");//供方库存组织
		sql.append(" and tbill.FBizDate>={ts'").append(beginDate).append("'}");
		sql.append(" and tbill.FBizDate<={ts'").append(endDate).append("'}");
		//sql.append(" and tbill.FBaseStatus=4");
		IRowSet rs=getCommSqlFacade().executeQuery(sql.toString());//,new Object[]{this.orgUnitID});
		IRow row;
		while(rs.next()) {
			row=this.tbAll.addRow();
			row.getCell("id").setValue(rs.getString("id"));
			row.getCell("number").setValue(rs.getString("number"));
			row.getCell("bizDate").setValue(rs.getString("bizDate").substring(0,10));
			row.getCell("orderStorageOrgUnit").setValue(rs.getString("orderCustomer.name"));
			row.getCell("entryID").setValue(rs.getString("entry.id"));
			row.getCell("entrySeq").setValue(rs.getString("entry.seq"));
			row.getCell("material").setValue(rs.getString("material.number"));
			row.getCell("materialName").setValue(rs.getString("material.name"));
			row.getCell("unit").setValue(rs.getString("unit.name"));
			row.getCell("qty").setValue(rs.getBigDecimal("entry.baseQty"));
			//row.getCell("weighQty").setValue(getWeighQty(rs.getString("id"), rs.getString("entry.id")));
		}
;		rs.close();
	}
	private ICommSqlFacade getCommSqlFacade() throws BOSException {
		return CommSqlFacadeFactory.getRemoteInstance();
	}
	
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		returnInfos=null;
		this.orgUnitID=this.getUIContext().get("orgUnitID").toString();
		this.BizType=Integer.parseInt(this.getUIContext().get("BizBillType").toString());
		if(this.BizType==PURORDER_VALUE) {
			this.billBosType="3171BFAD";//new PurOrderInfo().getBOSType().toString()
			this.entryBosType="26041CC5";//new PurOrderEntryInfo().getBOSType()
		} else if(this.BizType==SALEORDER_VALUE) {
			this.billBosType="C48A423A";//new SaleOrderInfo().getBOSType();
			this.entryBosType="88882A58";//new SaleOrderEntryInfo().getBOSType()
		} else if(this.BizType==TRANSIN_VALUE) {
			this.billBosType="5C2A1F0C";//new TransferOrderBillInfo().getBOSType()
			this.entryBosType="ACCB80C6";//new TransferOrderBillEntryInfo().getBOSType()
		}
	}

	
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
	}
	/**
	 * 初始化控件
	 */
	private void initControl() {
		this.tbAll.getStyleAttributes().setLocked(true);
		this.tbSelected.getStyleAttributes().setLocked(true);
		this.tbAll.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.tbSelected.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		this.prmtBizObject.setDisplayFormat("$name$");
		this.prmtBizObject.setCommitFormat("$number$");
		this.prmtBizObject.setEditFormat("$number$");
		if(this.BizType==PURORDER_VALUE) {
			this.setUITitle("采购订单 选择");
			this.contBizObject.setBoundLabelText("供应商");
			this.tbAll.getColumn("customer").getStyleAttributes().setHided(true);
			this.tbAll.getColumn("orderStorageOrgUnit").getStyleAttributes().setHided(true);
			this.tbSelected.getColumn("customer").getStyleAttributes().setHided(true);
			this.tbSelected.getColumn("orderStorageOrgUnit").getStyleAttributes().setHided(true);
			this.prmtBizObject.setQueryInfo("com.kingdee.eas.scm.sm.pur.app.F7PurOrderQuery");
		} else if(this.BizType==SALEORDER_VALUE) {
			this.setUITitle("销售订单 选择");
			this.contBizObject.setBoundLabelText("客户");
			this.tbAll.getColumn("supplier").getStyleAttributes().setHided(true);
			this.tbAll.getColumn("orderStorageOrgUnit").getStyleAttributes().setHided(true);
			this.tbSelected.getColumn("supplier").getStyleAttributes().setHided(true);
			this.tbSelected.getColumn("orderStorageOrgUnit").getStyleAttributes().setHided(true);
			this.prmtBizObject.setQueryInfo("com.kingdee.eas.scm.sd.sale.app.F7SaleOrderQuery");
		} else if(this.BizType==TRANSIN_VALUE||this.BizType==TRANSOUT_VALUE  ) {
			this.setUITitle("调拨订单 选择");
			this.contBizObject.setBoundLabelText("对方库存组织");
			this.tbAll.getColumn("customer").getStyleAttributes().setHided(true);
			this.tbAll.getColumn("supplier").getStyleAttributes().setHided(true);
			this.tbSelected.getColumn("customer").getStyleAttributes().setHided(true);
			this.tbSelected.getColumn("supplier").getStyleAttributes().setHided(true);
			StorageF7 f7=new StorageF7();
			f7.setShowVirtual(false);
			this.prmtBizObject.setSelector(f7);
			
		}
		F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, prmtMaterial);
		m7.setBaseFilter(new FilterInfo());
		this.prmtMaterial.setSelector(m7);
		this.prmtMaterial.setEditFormat("$number$");
		this.prmtMaterial.setCommitFormat("$number$");
		
		this.tbAll.addKDTMouseListener(new KDTMouseListener(){
			public void tableClicked(KDTMouseEvent e) {
				if(e.getClickCount()==2) {
					try {
						btnAdd_actionPerformed(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}});
		this.tbSelected.addKDTMouseListener(new KDTMouseListener(){
			public void tableClicked(KDTMouseEvent e) {
				if(e.getClickCount()==2) {
					try {
						btnRemove_actionPerformed(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}});
	}
	
	protected void btnAdd_actionPerformed(ActionEvent e) throws Exception {
		IRow row=KDTableUtil.getSelectedRow(this.tbAll);
		if(row==null||row.getRowIndex()<0) {
			//MsgBox.showWarning("请选择记录行！");
			return;
		}
		for(int rowIndex=0;rowIndex<this.tbSelected.getRowCount();rowIndex++) {
			if(this.tbSelected.getRow(rowIndex).getCell("entryID").getValue().equals(this.tbAll.getRow(row.getRowIndex()).getCell("entryID").getValue())) {
				return;
			}
		}
		IRow rowNew=this.tbSelected.addRow();
		for(int i=0;i<this.tbSelected.getColumnCount();i++) {
			rowNew.getCell(i).setValue(row.getCell(i).getValue());
		}
		
	}
	
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		this.disposeUIWindow();
	}
	
	protected void btnOK_actionPerformed(ActionEvent e) throws Exception {
		setSelectVaues();
		this.disposeUIWindow();
	}
	
	protected void btnRemove_actionPerformed(ActionEvent e) throws Exception {
		IRow row=KDTableUtil.getSelectedRow(this.tbAll);
		if(row==null||row.getRowIndex()<0) {
			//MsgBox.showWarning("请选择记录行！");
			return;
		}
		tbSelected.removeRow(row.getRowIndex());
	}
	/**
	 * 设置选择的数据
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void setSelectVaues() throws EASBizException, BOSException {
		IRow row;
		this.returnInfos=new F7SelectBillInfo[this.tbSelected.getRowCount()];
		for(int rowIndex=0;rowIndex<this.tbSelected.getRowCount();rowIndex++) {
			row=this.tbSelected.getRow(rowIndex);
			F7SelectBillInfo info = new F7SelectBillInfo();
			info.setBillBosType(this.billBosType);
			info.setBillID(row.getCell("id").getValue().toString());
			info.setNumber(row.getCell("number").getValue().toString());
			info.setEntryBosType(this.entryBosType);
			info.setEntryID(row.getCell("entryID").getValue().toString());
			info.setEntrySeq(row.getCell("entrySeq").getValue().toString());
			info.setMaterialID(null);
			info.setUnitID(null);
			info.setBaseQty(new BigDecimal(row.getCell("qty").getValue().toString()));
			info.setWeighQty(new BigDecimal(row.getCell("weighQty").getValue().toString()));
			info.setRemainWeighQty(new BigDecimal(row.getCell("remainWeighQty").getValue().toString()));
			returnInfos[rowIndex]=info;
		}
	}
	/**
	 * 获取已过磅数量
	 * @param billID
	 * @param entryID
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	public static BigDecimal getWeighQty(String billID,String entryID) throws BOSException, SQLException {
		BigDecimal value=BigDecimal.ZERO;
		StringBuffer sql=new StringBuffer();
		sql.append(" select isnull(sum(CFWeighQty),0) fqty");
		sql.append(" from ").append(InStorageBillPlatformUI.billDetailTable);
		sql.append(" where CFSourceBillID=? and CFSourceEntryID=?");
		IRowSet rs=CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql.toString(),new Object[]{billID,entryID});
		if(rs.next()) {
			value=rs.getBigDecimal("fqty");
		}
		rs.close();
		return value;
	}
	/**
	 * 得到业务对象实例
	 * @return 
	 */
	private ISaleOrder getBizInstance() {
		try {
			return SaleOrderFactory.getRemoteInstance();
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return null;
	}
	public IRowSet getDataByMeta(IMetaDataPK  qpk,EntityViewInfo ev) {
		IRowSet iRowSet=null;
		try {
			IQueryExecutor exec = QueryExecutorFactory.getRemoteInstance(qpk);
			//exec.option().isAutoTranslateEnum = true;
			//exec.setObjectView(ev);
			iRowSet = exec.executeQuery();

		} catch (Exception e) {
			ExceptionHandler.handle((CoreUI) null, e);
		}
		return iRowSet;
	}
}