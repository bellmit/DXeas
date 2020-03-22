///**
// * output package name
// */
//package com.kingdee.eas.farm.carnivorous.recyclebiz.client;
//
//import java.awt.Color;
//import java.awt.event.*;
//import java.sql.SQLException;
//import java.util.Date;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import org.apache.log4j.Logger;
//
//import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.entity.SelectorItemCollection;
//import com.kingdee.bos.ui.face.CoreUIObject;
//import com.kingdee.bos.ctrl.kdf.table.IRow;
//import com.kingdee.bos.ctrl.kdf.table.undo.KDTUndoRedoAction;
//import com.kingdee.bos.dao.IObjectValue;
//import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
//import com.kingdee.bos.dao.query.SQLExecutorFactory;
//import com.kingdee.eas.base.core.util.DateUtil;
//import com.kingdee.eas.common.EASBizException;
//import com.kingdee.eas.custom.commld.commUtils;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.CarSendBillFactory;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.CarSendBillInfo;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.DkSettleBillFactory;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.ICarSendBill;
//import com.kingdee.eas.framework.*;
//import com.kingdee.eas.util.client.KDTableUtil;
//import com.kingdee.jdbc.rowset.IRowSet;
//
///**
// * output class name
// */
//public class SettleBillFilterUI extends AbstractSettleBillFilterUI
//{
//	private static final Logger logger = CoreUIObject.getLogger(SettleBillFilterUI.class);
//
//	/**
//	 * output class constructor
//	 */
//	public SettleBillFilterUI() throws Exception
//	{
//		super();
//	}
//
//	/**
//	 * output storeFields method
//	 */
//	public void storeFields()
//	{
//		super.storeFields();
//	}
//
//	/**
//	 * output btnConfirm_actionPerformed method
//	 */
//	protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
//	{
//		super.btnConfirm_actionPerformed(e);
//	}
//
//	@Override
//	protected IObjectValue createNewData() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected ICoreBase getBizInterface() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void onLoad() throws Exception {
//		// TODO Auto-generated method stub
//		super.onLoad();
//		toolBar.setVisible(false);
//		pkBeginDate.setValue(DateUtil.getFirstDayOfCurMonth());
//		pkEndDate.setValue(new Date());
//		kDLabel1.setText("将为以下养殖户创建结算单");
//		kDLabel1.setForeground(Color.blue);
//		kDTable1.getStyleAttributes().setLocked(true);
//		
//		final String companyID=(String) getUIContext().get("companyID");
//		btnConfirm.addMouseListener(new MouseAdapter(){
//
//			public void mouseClicked(MouseEvent paramMouseEvent) {
//				// TODO Auto-generated method stub
//				super.mouseClicked(paramMouseEvent); 
//				kDTable1.getColumn("select").getStyleAttributes().setLocked(false);
//				kDTable1.removeRows();
//				
//				StringBuffer sb=new StringBuffer();
//				sb.append("select\n");
//				sb.append("t1.FID,\n");
//				sb.append("min(t2.FIsBack)\n");
//				sb.append("from \n");
//				sb.append("T_FM_CarSendBill                   t1\n");
//				sb.append("inner join T_FM_CarSendBillEntry   t2 on t1.FID=t2.FParentID\n");
//				sb.append("left  join T_FM_DkSettleBill       t3 on t3.FBatchID=t1.FBatchID\n");
//				sb.append("where (t3.FID is null or t3.CFBillStatus<>2)\n");
//				sb.append(" and t1.FCompanyID='").append(companyID).append("'\n");
//				sb.append("group by t1.FID having min(t2.FIsBack)=1\n");
//				
//				try {
//					ICarSendBill iCarSendBill = CarSendBillFactory.getRemoteInstance();
//					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
//					SelectorItemCollection slor=new SelectorItemCollection();
//					slor.add("*");
//					slor.add("batch.*");
//					slor.add("farmer.*");
//					slor.add("farm.*");
//					CarSendBillInfo carSendInfo;
//					IRow row;
//					while(rs.next()){
//						row = kDTable1.addRow();
//						row.getCell("select").setValue(true);
//						carSendInfo = iCarSendBill.getCarSendBillInfo(new ObjectUuidPK(rs.getString("FID")),slor);
//						row.getCell("batch").setValue(carSendInfo.getBatch());
//						row.getCell("farmer").setValue(carSendInfo.getFarmer());
//						row.getCell("farm").setValue(carSendInfo.getFarm());
//					}
//				} catch (BOSException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (EASBizException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}});
//		btnBegin.addMouseListener(new MouseAdapter(){
//
//			@Override
//			public void mouseClicked(MouseEvent paramMouseEvent) {
//				// TODO Auto-generated method stub
//				super.mouseClicked(paramMouseEvent);
//				JSONArray jsonArray=new JSONArray();
//				for(int i=0;i<kDTable1.getRowCount();i++){
//					if(kDTable1.getCell(i, "select").getValue().equals(true))
//						jsonArray.add(((IObjectValue)kDTable1.getCell(i, "batch").getValue()).getString("id"));
//				}
//				if(jsonArray.size()==0){
//					commUtils.giveUserTipsAndRetire("请选择一行数据");
//				}
//				JSONObject json=new JSONObject();
//				json.put("data", jsonArray);
//				try {
//					DkSettleBillFactory.getRemoteInstance().execByCondition(json.toString());
//				} catch (EASBizException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (BOSException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}});
//	}
//
//
//
//
//}