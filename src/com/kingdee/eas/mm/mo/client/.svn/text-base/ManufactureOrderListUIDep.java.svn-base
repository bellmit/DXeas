package com.kingdee.eas.mm.mo.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.eas2temp.ProductStatus;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;

public class ManufactureOrderListUIDep {
	
	protected ManufactureOrderStockListUI  ui;
	
	/**
	 * onload后 设置界面 空间 内容；添加监听
	 * @param param
	 */
	public void afterOnload(final UIParam param){
		if(!(param.getUI() instanceof ManufactureOrderStockListUI)) {
			return;
		}
		ui = (ManufactureOrderStockListUI) param.getUI();
		//KDTable增加表格编辑事件监听
		param.getKDWorkButton("btnGetTempProductStatus").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getTempProductStatus(param.getKDTable("tblMain"));
			}});
		param.getKDWorkButton("setProductStatus").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setProductStatus(param.getKDTable("tblMain"));
			}});
	}
	
	/**
	 * 获取中控订单状态
	 */
	public void getTempProductStatus(KDTable table) {
		if(table.getColumn("productStatus")==null) {
			return;
		}
		
		Connection conn=null;
		try {
			conn = null;//EASWUtils.getTempConnection(null, SysContext.getSysContext().getCurrentStorageUnit().getString("id"), TargetSystem.MUYANGSYSTEM_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			MsgBox.showInfo("请确认连接参数设置正确");
			return;
		}
		try {
			PreparedStatement ptm = conn.prepareStatement("select status from t_tasks where erpID=?");
			
			ArrayList<String> idLists=new ArrayList<String>();
			String id,productStatus;
			ResultSet rs;
			for(int rowIndex=0;rowIndex<table.getRowCount();rowIndex++)  {
				id=table.getCell(rowIndex, "id").getValue().toString();
				if(idLists.contains(id)) {
					continue;
				}
				if(table.getCell(rowIndex,"productStatus").getValue()!=null&&(table.getCell(rowIndex,"productStatus").getValue().toString().equals(ProductStatus.finish)||table.getCell(rowIndex,"productStatus").getValue().toString().equals(ProductStatus.FINISH_VALUE))) {
					continue;
				}
				productStatus=null;
				ptm.setString(1, id);
				rs=ptm.executeQuery();
				if(rs.next()) {
					productStatus=rs.getString("status");
				}
				if(StringUtils.isNotEmpty(productStatus)) {
					CommSqlFacadeFactory.getRemoteInstance().execute("update T_MM_ManufactureOrder set CFProductStatus="+Integer.valueOf(productStatus)+" where fid='"+id+"'");
				}
				idLists.add(id);
			}
		} catch (Exception err) {
			MsgBox.showWarning(err.getMessage());
		}
		MsgBox.showInfo("生产状态更新完成！请刷新界面");
	}
	
	
	/**
	 * 手工设置订单状态
	 */
	public void setProductStatus(KDTable table) {
		if(table.getColumn("productStatus")==null) {
			return;
		}
		IRow row = KDTableUtil.getSelectedRow(table);
		if(row==null||row.getRowIndex()==-1) {
			return;
		}
		if(row.getCell("productStatus").getValue()!=null&&(row.getCell("productStatus").getValue().toString().equals(ProductStatus.finish)||row.getCell("productStatus").getValue().toString().equals(ProductStatus.FINISH_VALUE))) {
			return;
		}
		try {
	    	UIContext uiContext = new UIContext(this);
	    	IUIWindow uiWindow = null ;
	    	// UIFactoryName.MODEL 为弹出模式
	    	uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.eas2temp.client.ProductStatusSetUI", uiContext, null,OprtState.VIEW);
	    	//开始展现UI
	    	uiWindow.show();
	    	if(uiWindow.getUIObject().getUIContext().containsKey("result")) {
				//更新状态
				CommSqlFacadeFactory.getRemoteInstance().execute("update T_MM_ManufactureOrder set CFProductStatus="+((ProductStatus)(uiWindow.getUIObject().getUIContext().get("result"))).getValue()+" where fid='"+row.getCell("id").getValue().toString()+"'");
				
	    	}
	    	}catch(Exception err) {
	    		 MsgBox.showWarning(err.getMessage());
	    	}
	    MsgBox.showInfo("生产状态更新完成！请刷新界面");
	}
}
