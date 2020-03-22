package com.kingdee.eas.custom.taihe.door.dep.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.sd.sale.client.SaleOrderListUI;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;

public class SaleOrderListUIDep {
	//界面加载后
	public static void afterOnload(UIParam params) {
		KDWorkButton btn = params.getKDWorkButton("tBtnExeOut");
		if(btn!=null) {
			SaleOrderListUI listui=(SaleOrderListUI) params.getUI();
			final KDTable table = params.getKDTable("tblMain");
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					IRow row = KDTableUtil.getSelectedRow(table);
					if(row==null||row.getRowIndex()<0) {
						MsgBox.showWarning("请先选择行!");
					}
					String id=row.getCell("id").getValue().toString();
					if(MsgBox.showConfirm2("是否将改单据标记为已出门状态？")==MsgBox.YES){
						try {
							ToolFacadeFactory.getRemoteInstance().execute("update t_sd_saleOrder set cfisfinishoutdoor=1 where fid='"+id+"'");
							MsgBox.showInfo("标记完成!");
						} catch (BOSException e1) {
							MsgBox.showError(e1.toString());
						}
					}
				}});
		}
	}
}
