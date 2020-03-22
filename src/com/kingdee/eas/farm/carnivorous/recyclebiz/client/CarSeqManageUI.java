/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDLayout;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.IChickenRecBill;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.framework.client.EditUI;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CarSeqManageUI extends AbstractCarSeqManageUI
{
	private static final Logger logger = CoreUIObject.getLogger(CarSeqManageUI.class);
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
	private ChickenRecBillInfo cInfo=null;

	private Map tableToSumField=new HashMap();
	private Map tableToSumIndex = new ConcurrentHashMap();

	/**
	 * output class constructor
	 */
	public CarSeqManageUI() throws Exception
	{
		super();
	}

	@Override
	public void initUIContentLayout() {
		// TODO Auto-generated method stub
		super.initUIContentLayout();
		kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new FilterInfo(),null,false);
		this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(65, 192, 589, 345, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));       
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.kdtEntrys.checkParsed();

		pkBizDate.setValue(null);
		// prmtfarmer		
		this.prmtFarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
		this.prmtFarmer.setVisible(true);		
		this.prmtFarmer.setDisplayFormat("$name$");		
		this.prmtFarmer.setEditFormat("$number$");		
		this.prmtFarmer.setCommitFormat("$number$");

		// prmtfarm		
		this.prmtFarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
		this.prmtFarm.setVisible(true);		
		this.prmtFarm.setDisplayFormat("$name$");		
		this.prmtFarm.setEditFormat("$number$");		
		this.prmtFarm.setCommitFormat("$number$");		

        // prmtBatchContract		
        this.prmtBatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtBatchContract.setVisible(true);		
        this.prmtBatchContract.setDisplayFormat("$number$");		
        this.prmtBatchContract.setEditFormat("$number$");		
        this.prmtBatchContract.setCommitFormat("$number$");		

        // prmtBreedData
        this.prmtBreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtBreedData.setVisible(true);		
        this.prmtBreedData.setDisplayFormat("$name$");		
        this.prmtBreedData.setEditFormat("$number$");		
        this.prmtBreedData.setCommitFormat("$number$");	
        
		KDFormattedTextField kdtEntrys_seq_TextField = new KDFormattedTextField();
		kdtEntrys_seq_TextField.setVisible(true);
		kdtEntrys_seq_TextField.setEditable(true);
		kdtEntrys_seq_TextField.setHorizontalAlignment(2);
		kdtEntrys_seq_TextField.setDataType(0);
		KDTDefaultCellEditor kdtEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seq_TextField);
		this.kdtEntrys.getColumn("seq").setEditor(kdtEntrys_seq_CellEditor);


		KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
		kdtEntrys_qty_TextField.setVisible(true);
		kdtEntrys_qty_TextField.setEditable(true);
		kdtEntrys_qty_TextField.setHorizontalAlignment(2);
		kdtEntrys_qty_TextField.setDataType(0);
		KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
		this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);

		cmb_Cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				disposeUIWindow();
			}
		});

		cmb_OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				verifyInput();
				dealWork();
			}
		});

		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				UIUtil.apendFootRow(kdtEntrys, new String[]{"qty"});
			}
		});
		initData();
	}


	private void dealWork() {	
		if(MsgBox.showConfirm2("将按当前顺序号及数量生成对应的毛鸡派车单,是否继续?")==MsgBox.YES){
			LongTimeDialog dialog = new LongTimeDialog((Dialog) SwingUtilities.getWindowAncestor(this)); //进度栏
			dialog.setLongTimeTask(new ILongTimeTask(){		
				public void afterExec(Object obj) throws Exception {}
				public Object exec() throws Exception {
					Object obj = "success";  
					for(int i=0;i<kdtEntrys.getRowCount();i++){
						Map map=new HashMap<String, Object>();
						int seq=UIRuleUtil.getIntValue(kdtEntrys.getCell(i, "seq").getValue());
						int qty=UIRuleUtil.getIntValue(kdtEntrys.getCell(i, "qty").getValue());
						map.put("seq", seq);
						map.put("qty", qty);
						ChickenRecBillFactory.getRemoteInstance().manageCarSeq(cInfo, map);
					}
					MsgBox.showInfo("执行成功,点击确定退出");		
					disposeUIWindow();
					return obj;
				}

			});
			Component[] cps=dialog.getContentPane().getComponents();  
			for(Component cp:cps){  
				if(cp instanceof JLabel){  
					((JLabel) cp).setText("正在执行中，请稍等......");  
				}  
			}  
			dialog.show();  
		}
	}


	private void initData() {
		// TODO Auto-generated method stub
		if(getUIContext().get("info")==null){
			return;
		}
		cInfo= (ChickenRecBillInfo) getUIContext().get("info");
		pkBizDate.setValue(cInfo.getBizDate());
//		txtQty.setValue(cInfo.getDeliverQty());
		prmtFarm.setValue(cInfo.getFarm());
		prmtFarmer.setValue(cInfo.getFarmer());
		prmtBreedData.setValue(cInfo.getBreedData());
		prmtBatchContract.setValue(cInfo.getBatchContract());
//		txtPlanAverageWgt.setValue(cInfo.getPlanAverageQty());
		txtWeekDay.setValue(cInfo.getFeedDays());
		kdtEntrys.addRow();
	}

	private void verifyInput(){
		if(getUIContext().get("info")==null){
			MsgBox.showWarning("未获取到回收订单信息!执行失败.");
			SysUtil.abort();
		}
		if(kdtEntrys.getRowCount()<=0){
			MsgBox.showWarning("分录未填写数据!执行失败.");
			SysUtil.abort();
		}
		BigDecimal qty=BigDecimal.ZERO;
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			int seqi=UIRuleUtil.getInt(kdtEntrys.getCell(i, "seq").getValue());
			if(kdtEntrys.getCell(i, "seq").getValue()==null||seqi<=0){
				MsgBox.showWarning("分录第"+(i+1)+"行顺序号未填写或填写数据不符合规范!执行失败.");
				SysUtil.abort();
			}
			if(kdtEntrys.getCell(i, "qty").getValue()==null||UIRuleUtil.getInt(kdtEntrys.getCell(i, "qty").getValue())<=0){
				MsgBox.showWarning("分录第"+(i+1)+"行数量未填写或填写数据不符合规范!执行失败.");
				SysUtil.abort();
			}
			for(int j=i+1;j<kdtEntrys.getRowCount();j++){
				if(seqi==UIRuleUtil.getInt(kdtEntrys.getCell(j, "seq").getValue())){
					MsgBox.showWarning("分录顺序号重复!执行失败.");
					SysUtil.abort();
				}
			}
			qty=qty.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "qty").getValue()));
		}
		BigDecimal dQty=UIRuleUtil.getBigDecimal(txtQty.getBigDecimalValue());
		if(dQty.compareTo(qty)!=0){
			if(MsgBox.showConfirm2("分录总数与回收订单交鸡数不一致,是否继续?")!=MsgBox.YES){
				SysUtil.abort();
			}
		}
	}




}