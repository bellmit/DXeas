/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryFactory;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderFactory;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.comm.ClientComm;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class OrderSelectUI extends AbstractOrderSelectUI
{
    private static final Logger logger = CoreUIObject.getLogger(OrderSelectUI.class);
    public static final int SaleOrder_Value=1;
    public static final int PurOrder_Value=2;
    private int billType;
    
    
    /**
     * output class constructor
     */
    public OrderSelectUI() throws Exception
    {
        super();
        this.setUITitle("订单选择");
    }

	@Override
	protected void btnOK_actionPerformed(ActionEvent e) throws Exception {
		setResultAndClose();
	}

	@Override
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		destroyWindow();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		billType=(Integer) this.getUIContext().get("billType");
		if(billType<=0) {
			MsgBox.showWarning("单据类型不能为空");
			SysUtil.abort();
		}
		this.kDTable1.getStyleAttributes().setLocked(true);
		this.kDTable1.checkParsed();
		this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.kDTable1.getColumn("qty").getStyleAttributes().setNumberFormat("#.0000");
		this.kDTable1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					setResultAndClose();
				}
			}});
		IRowSet rs=(IRowSet) this.getUIContext().get("rowset");
		if(rs!=null) {
			fillTableByRowset(rs);
		}
		
	}
	
	private void fillTableByRowset(IRowSet rs) throws SQLException {
		this.kDTable1.removeRows();
		rs.beforeFirst();
		IRow row;
		while (rs.next()){
			row=this.kDTable1.addRow();
			row.getCell("id").setValue(rs.getString("fid"));
			row.getCell("number").setValue(rs.getString("fnumber"));
			row.getCell("bizDate").setValue(rs.getString("fbizdate"));
			row.getCell("customerName").setValue(rs.getString("fcustomerName"));
			row.getCell("entryID").setValue(rs.getString("fentryid"));
			row.getCell("materialName").setValue(rs.getString("fmaterialName"));
			row.getCell("unitName").setValue(rs.getString("funitName"));
			row.getCell("model").setValue(rs.getString("fmodel"));
			row.getCell("qty").setValue(rs.getBigDecimal("fqty"));
		}
	}
	/**
	 * 设置返回结果
	 */
	private void setResultAndClose() {
		IRow row = KDTableUtil.getSelectedRow(kDTable1);
		if(row==null) {
			MsgBox.showWarning("请选择订单！");
			return;
		}
		String billID=row.getCell("id").getValue().toString();
		String entryID=row.getCell("entryID").getValue().toString();
		try {
			BTPTransformResult tmp =null;
			if(billType==PurOrder_Value) {
				transToInBillByID(billID, entryID);
			
			}
			else if(billType==SaleOrder_Value) {
				transToOutBillByID(billID, entryID);
			
			}
			this.getUIContext().put("result", tmp);
		} catch (Exception e) {
			handUIException(e);
		}
		this.destroyWindow();
	}
	
	public static BTPTransformResult  dealOrder(int billType,String orderNum) throws Exception {
		BTPTransformResult tmp=null;
		if(billType==PurOrder_Value) {
			tmp=createBillFromPurOrder(billType,orderNum);
		}else if(billType==SaleOrder_Value) {
			tmp=createBillFromSaleOrder(billType,orderNum);
		}else{
			
		}
		return tmp;
	}
	
	
	private static BTPTransformResult createBillFromPurOrder(int billType,String orderNum) throws Exception {
		BTPTransformResult tmp=null;
		String billID,entryID;
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.fid,tbill.fnumber,to_char(tbill.FbizDate,'yyyy-MM-dd') FbizDate,tentry.fid FEntryID, ")
		.append(" ts.fname_l2 FCustomerName,tm.fname_l2 FmaterialName,tm.FModel,")
		.append(" tu.fname_l2 FUnitName,tentry.Fqty")
		.append(" from T_SM_PurOrder tbill")
		.append(" inner join T_SM_PurOrderEntry tentry on tentry.fparentid=tbill.fid")
		.append(" inner join t_bd_supplier ts on ts.fid=tbill.fsupplierid")
		.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialid")
		.append(" inner join t_bd_measureunit tu on tu.fid=tentry.funitid")
		.append(" where 1=1")
		.append(" and ( tbill.FBaseStatus=4 or tbill.FBaseStatus=7)")
		.append(" and tbill.fnumber like '%").append(orderNum).append("%'")
		.append(" order by tentry.FSeq");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		if(rs.next()) {
			billID=rs.getString("fid");
			entryID=rs.getString("FEntryID");
			//多于一条记录，则显示选择界面
			if(rs.size()==1) {
				tmp=transToInBillByID(billID, entryID);
			}else{
				rs.beforeFirst();
				tmp=showSelectUI(billType,orderNum,rs);
			}
		}
		return tmp;
	}
	
	private static BTPTransformResult transToInBillByID(String billID,String entryID) throws Exception {
		PurOrderInfo info = PurOrderFactory.getRemoteInstance().getPurOrderInfo(new ObjectUuidPK(billID));
		PurOrderEntryInfo entryInfo = PurOrderEntryFactory.getRemoteInstance().getPurOrderEntryInfo(new ObjectUuidPK(billID));
		info.getEntries().clear();
		info.getEntries().add(entryInfo);
		return ClientComm.createToSCMBill(info, "52D6BAC2");
	}
	/**
	 * 显示窗口并返回结果
	 * @throws UIException 
	 */
	private static BTPTransformResult showSelectUI(int billType,String orderNum,IRowSet rs) throws UIException {
		String UICLASSNAME = "com.kingdee.eas.weighbridge.client.OrderSelectUI";
		UIContext uicontext = new UIContext();
		uicontext.put("billType", billType);
		uicontext.put("orderNum", orderNum);
		uicontext.put("rowset", rs);
		IUIWindow uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(UICLASSNAME, uicontext, null, OprtState.VIEW);
		uiWindow.show();
		return (BTPTransformResult) uiWindow.getUIObject().getUIContext().get("result");
		
	}
	
	private static BTPTransformResult createBillFromSaleOrder(int billType,String orderNum) throws Exception {
		BTPTransformResult tmp=null;
		String billID,entryID;
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.fid,tbill.fnumber,to_char(tbill.FbizDate,'yyyy-MM-dd') FbizDate,tentry.fid FEntryID, ")
		.append(" ts.fname_l2 FCustomerName,tm.fname_l2 FmaterialName,tm.FModel,")
		.append(" tu.fname_l2 FUnitName,tentry.Fqty")
		.append(" from T_sd_saleOrder tbill")
		.append(" inner join T_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid")
		.append(" inner join t_bd_customer ts on ts.fid=tbill.FOrderCustomerID")
		.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialid")
		.append(" inner join t_bd_measureunit tu on tu.fid=tentry.funitid")
		.append(" where 1=1")
		.append(" and (tbill.FBaseStatus=4 or tbill.FBaseStatus=7)")
		.append(" and tbill.fnumber like '%").append(orderNum).append("%'")
		.append(" order by tentry.FSeq");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		if(rs.next()) {
			billID=rs.getString("fid");
			entryID=rs.getString("FEntryID");
			//多于一条记录，则显示选择界面
			if(rs.size()==1) {
				tmp=transToInBillByID(billID, entryID);
			}else{
				rs.beforeFirst();
				tmp=showSelectUI(billType,orderNum,rs);
			}
		}
		return tmp;
	}
	
	
	private static BTPTransformResult transToOutBillByID(String billID,String entryID) throws BOSException, EASBizException {
		SaleOrderInfo info = SaleOrderFactory.getRemoteInstance().getSaleOrderInfo(new ObjectUuidPK(billID));
		SaleOrderEntryInfo entryInfo = SaleOrderEntryFactory.getRemoteInstance().getSaleOrderEntryInfo(new ObjectUuidPK(billID));
		info.getEntries().clear();
		info.getEntries().add(entryInfo);
		return ClientComm.createToSCMBill(info, "5BA96D8F");
	}
	

}