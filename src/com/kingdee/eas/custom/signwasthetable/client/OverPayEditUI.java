/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractTypeFactory;
import com.kingdee.eas.custom.signwasthetable.ContractTypeInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.util.client.MsgBox;
//import com.kingdee.bos.ctrl.freechart.ui.HorizontalAlignment;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;

/**
 * output class name
 */
public class OverPayEditUI extends AbstractOverPayEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(OverPayEditUI.class);

	/**
	 * output class constructor
	 */
	public OverPayEditUI() throws Exception
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
	//设只一个按钮，打开源  合同签呈的编辑界面
	@Override
	public void actionViewSrcBill_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//取得来源单据的id，根据id获得当前合同版本的id和上一版本的id
		if(editData.getId().toString()==null)
			return;
		String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.ContractEditUI";
		Map map = new UIContext(this);
		map.put("ID",editData.getContractSrcId());
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.VIEW);
		//开始展现 UI
		uiWindow.show();
		super.actionViewSrcBill_actionPerformed(e);
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
         
		
		//设置按钮的可见性
		btnAddNew.setVisible(false);
		btnAddLine.setVisible(false);
		btnRemoveLine.setVisible(false);
		btnInsertLine.setVisible(false);
		btnCopy.setVisible(false);
		btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
		btnAudit.setHideActionText(true);
		
		
		//审核状态下不可编辑和删除
		if(this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit))
		{
			btnEdit.setEnabled(false);
			btnRemove.setEnabled(false);
		}
		
		//加载新界面的时候  需要加载 原始单据的某些内容
		if(editData.getId()==null)
		{
			
			//将源合同的id付给字段
			String srcBillID = (String) this.getUIContext().get("srcBillID");
			this.txtContractSrcId.setStringValue(srcBillID);
			this.pkBizDate.setValue(new Date());


			//获取合同签呈的info
			ContractInfo contractInfo = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(srcBillID));
			ContractPaymentCollection Entrys = contractInfo.getPayment();
			this.txtcontractNumber.setStringValue(contractInfo.getNumber());
			
			//我们希望能获得原始单据的合同类型参与工作流
			String contractTypeID = contractInfo.getContractType().getId().toString();
			ContractTypeInfo ctInfo = ContractTypeFactory.getRemoteInstance().getContractTypeInfo(new ObjectUuidPK(contractTypeID));
			if(editData.getSrcBillType()==null)
				editData.setSrcBillType(ctInfo);

			//校验信息统一在这里完成，因此我们要用到  合同金额
			this.txtAmt.setValue(contractInfo.getAmountOriCurrency());

			//设置分录的增插删按钮不可用
			kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
			kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
			kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
			//第一列阶段编码不可用
			kdtEntrys.getColumn("phaseCoding").getStyleAttributes().setLocked(true);
			kdtEntrys.getColumn("phaseCoding").setRequired(true);


			//设置字段向右显示
			for(int i=1;i<kdtEntrys.getColumnCount();i++)
				kdtEntrys.getColumn(i).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);

			//根据原合同读取分录的信息
			//为了完成  填写时的校验信息，引入了是否保证金，已申请付款金额连个字段
			for(int i=0;i<Entrys.size();i++)
			{
				kdtEntrys.addRow();
				kdtEntrys.getRow(i).getCell("phaseCoding").setValue(Entrys.get(i).getPhaseCoding());
				kdtEntrys.getRow(i).getCell("isBailAmt").setValue(Entrys.get(i).getBoolean("isBailAmt"));
//				kdtEntrys.getRow(i).getCell("overAmt").setValue(Entrys.get(i).getOverAmt());
				kdtEntrys.getRow(i).getCell("requiredPayAmount").setValue(Entrys.get(i).getRequiredPayAmount());
				kdtEntrys.getRow(i).getCell("payAmount").setValue(Entrys.get(i).getPayAmount());
//				if(Entrys.get(i).getOverRate()!=null)
//					kdtEntrys.getRow(i).getCell("overRate").setValue(Entrys.get(i).getOverRate());
				if(kdtEntrys.getRow(i).getCell("isBailAmt").getValue().equals(true))
					kdtEntrys.getRow(i).getStyleAttributes().setLocked(true);
			}


			/*
			 * 初始时自动带出合计行
			 */
			String []array={"payAmount","requiredPayAmount","overAmt"};
			apendFootRow(kdtEntrys,array);
			KDTPropertyChangeListener kdtEntrysListener=new KDTPropertyChangeListener()//合计行
			{
				public void propertyChange(KDTPropertyChangeEvent arg0) 
				{
					String []array={"payAmount","requiredPayAmount","overAmt"};
					apendFootRow(kdtEntrys,array);//合计行



					//如果变更的是 超额付款比率或者 最大可付金额
					if(kk==0&&rowOver==0&&(arg0.getColIndex()==kdtEntrys.getColumn("overAmt").getColumnIndex()||arg0.getColIndex()==kdtEntrys.getColumn("overRate").getColumnIndex()))
					{
						rowOver=1;
						kk=1;
						IRow row = KDTableUtil.getSelectedRow(kdtEntrys);//获得修改的行
						if(row!=null)
							checkEntry(row.getRowIndex());
						rowOver=0;
					}
				}
			};
			kdtEntrys.addKDTPropertyChangeListener(kdtEntrysListener);
			//值改变的编辑器事件，保留原来的值
			kdtEntrys.addKDTEditListener(new KDTEditAdapter()
			{
				//编辑器启动前
				public void editStarting(KDTEditEvent e)
				{
					row=e.getRowIndex();
					col=e.getColIndex();
					oldValue=(BigDecimal)kdtEntrys.getRow(row).getCell(col).getValue();
				}
				//编辑器值改变（此时编辑器尚未结束）
				public void editValueChanged(KDTEditEvent e)
				{				
				}
				//编辑器结束前
				public void editStopping(KDTEditEvent e)
				{

				}
				//编辑器结束以后
				public void editStopped(KDTEditEvent e)
				{
					row=-1;
					col=-1;
					oldValue=BigDecimal.ZERO;
					kk=0;
				}
			});
		}
	}
	public  void checkBail(int rowIndex) {
		// TODO Auto-generated method stub
		if(!checkOver(rowIndex))
		{
			MsgBox.showInfo("超出限度，请修改");
			if(col==kdtEntrys.getColumn("overAmt").getColumnIndex())
				kdtEntrys.getRow(rowIndex).getCell("overAmt").setValue(oldValue);
			else if(col==kdtEntrys.getColumn("overRate").getColumnIndex())
				kdtEntrys.getRow(rowIndex).getCell("overRate").setValue(oldValue);
			return;
		}
		if(col==kdtEntrys.getColumn("overAmt").getColumnIndex())
		{
			BigDecimal overAmt = (BigDecimal)kdtEntrys.getRow(rowIndex).getCell("overAmt").getValue();
			BigDecimal trueRate = overAmt.multiply(new BigDecimal("100")).divide(txtAmt.getBigDecimalValue());
			kdtEntrys.getRow(rowIndex).getCell("overRate").setValue(trueRate);
		}
		else if(col==kdtEntrys.getColumn("overRate").getColumnIndex())
		{
			BigDecimal payAmt = (BigDecimal)kdtEntrys.getRow(rowIndex).getCell("payAmount").getValue();
			BigDecimal overAmt = payAmt.multiply(BigDecimal.ONE.add((BigDecimal)kdtEntrys.getRow(rowIndex).getCell("overRate").getValue()).divide(new BigDecimal("100")));
			kdtEntrys.getRow(rowIndex).getCell("overAmt").setValue(overAmt);
		}

	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核通过");
	}
	public void checkEntry(int rowIndex) {
		// TODO Auto-generated method stub
        //信息校验
		if(!checkOver(rowIndex))
		{
			MsgBox.showInfo("超出限度，请修改");
			if(col==kdtEntrys.getColumn("overAmt").getColumnIndex())
				kdtEntrys.getRow(rowIndex).getCell("overAmt").setValue(oldValue);
			else if(col==kdtEntrys.getColumn("overRate").getColumnIndex())
				kdtEntrys.getRow(rowIndex).getCell("overRate").setValue(oldValue);
			return;
		}
		//校验通过后，修改
		BigDecimal overFlow=BigDecimal.ZERO;//overFlow代表超出的金额
		
		//如果修改的是最大可付款金额
		if(col==kdtEntrys.getColumn("overAmt").getColumnIndex())
		{
			BigDecimal overAmt = (BigDecimal)kdtEntrys.getRow(rowIndex).getCell("overAmt").getValue();
			BigDecimal trueRate=overAmt.divide((BigDecimal)kdtEntrys.getRow(rowIndex).getCell("payAmount").getValue(),2,BigDecimal.ROUND_HALF_EVEN);
			trueRate=trueRate.subtract(BigDecimal.ONE).multiply(new BigDecimal("100"));
			//			BigDecimal trueRate = overAmt.multiply(new BigDecimal("100")).divide(txtAmt.getBigDecimalValue(),2,BigDecimal.ROUND_HALF_EVEN);
			overFlow=overAmt.subtract(oldValue);
			kdtEntrys.getRow(rowIndex).getCell("overRate").setValue(trueRate);
		}
		//如果修改的是超额付款比例
		else if(col==kdtEntrys.getColumn("overRate").getColumnIndex())
		{
			BigDecimal payAmt = (BigDecimal)kdtEntrys.getRow(rowIndex).getCell("payAmount").getValue();
			BigDecimal overA = BigDecimal.ZERO;
			if(kdtEntrys.getRow(rowIndex).getCell("overAmt").getValue()!=null)
				overA=(BigDecimal)kdtEntrys.getRow(rowIndex).getCell("overAmt").getValue();
			BigDecimal overAmt = payAmt.multiply(BigDecimal.ONE.add(((BigDecimal)kdtEntrys.getRow(rowIndex).getCell("overRate").getValue()).divide(new BigDecimal("100"))));
			overFlow=overAmt.subtract(overA);
			kdtEntrys.getRow(rowIndex).getCell("overAmt").setValue(overAmt);
		}
		//超出的金额从下面阶段扣除
		for(int i=rowIndex+1;i<kdtEntrys.getRowCount();i++)
		{
			if(kdtEntrys.getRow(i).getCell("isBailAmt").getValue().equals(true))
				continue;
			BigDecimal over=BigDecimal.ZERO;
			BigDecimal req=BigDecimal.ZERO;
			if(kdtEntrys.getRow(i).getCell("overAmt").getValue()!=null)
				over=(BigDecimal)kdtEntrys.getRow(i).getCell("overAmt").getValue();


			if(kdtEntrys.getRow(i).getCell("requiredPayAmount").getValue()!=null)
				req=(BigDecimal)kdtEntrys.getRow(i).getCell("requiredPayAmount").getValue();

			BigDecimal sub = over.subtract(req);
			if(sub.compareTo(overFlow)!=-1)//未申请付款金额大于上一阶段  超额的部分，那么超额的部分在这一阶段完全扣除
			{
				kdtEntrys.getRow(i).getCell("overAmt").setValue(over.subtract(overFlow));
				BigDecimal divide = ((BigDecimal)kdtEntrys.getRow(i).getCell("overAmt").getValue()).divide((BigDecimal)kdtEntrys.getRow(i).getCell("payAmount").getValue(),4,BigDecimal.ROUND_HALF_EVEN);
				kdtEntrys.getRow(i).getCell("overRate").setValue((divide.subtract(BigDecimal.ONE)).multiply(new BigDecimal("100")));
				break;
			}
			else//否则
			{
				kdtEntrys.getRow(i).getCell("overAmt").setValue(req);
				BigDecimal divide = ((BigDecimal)kdtEntrys.getRow(i).getCell("overAmt").getValue()).divide((BigDecimal)kdtEntrys.getRow(i).getCell("payAmount").getValue(),4,BigDecimal.ROUND_HALF_EVEN);
				kdtEntrys.getRow(i).getCell("overRate").setValue((divide.subtract(BigDecimal.ONE)).multiply(new BigDecimal("100")));
				overFlow=overFlow.subtract(sub);
			}
		}
	}
	BigDecimal oldValue=BigDecimal.ZERO;//记录修改前的值
	int row=-1;//记录修改的单元格所在的行和列
	int col=-1;
	int rowOver=0; //防止 监听事件的重复
	int kk=0;
	/**
	 * 合计行
	 */
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount();  
		if(count == 0){
			count = table.getRowCount1();
		}
		if(count == 0){
			count = table.getRowCount3();
		}
		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0.00"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);  
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = com.kingdee.eas.util.client.EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}  
	/**
	 * 获取当前阶段的最大可以超额的金额
	 * 并给出校验结果，填写的数据是否超出范围
	 */
	public boolean checkOver(int index)
	{
		BigDecimal capacityAmt=BigDecimal.ZERO;
		BigDecimal amt=BigDecimal.ZERO;
		for(int i=0;i<index;i++)
		{
			if(kdtEntrys.getRow(i).getCell("overAmt")!=null)
				amt=amt.add((BigDecimal)kdtEntrys.getRow(i).getCell("overAmt").getValue());
		}
		for(int j=index+1;j<kdtEntrys.getRowCount();j++)
		{
			if(kdtEntrys.getRow(j).getCell("isBailAmt").getValue().equals(true)){
				if(kdtEntrys.getRow(j).getCell("overAmt")!=null)
					amt=amt.add((BigDecimal)kdtEntrys.getRow(j).getCell("overAmt").getValue());
			}
			else if(kdtEntrys.getRow(j).getCell("requiredPayAmount").getValue()!=null)
				amt=amt.add((BigDecimal)kdtEntrys.getRow(j).getCell("requiredPayAmount").getValue());		
		}
		capacityAmt=this.txtAmt.getBigDecimalValue().subtract(amt);
		if(col==kdtEntrys.getColumn("overAmt").getColumnIndex())
		{
			if(capacityAmt.compareTo((BigDecimal)kdtEntrys.getRow(index).getCell("overAmt").getValue())==-1)
				return false;
		}
		else if(col==kdtEntrys.getColumn("overRate").getColumnIndex())
		{
			BigDecimal overRate=BigDecimal.ZERO;
			if(kdtEntrys.getRow(index).getCell("overRate").getValue()!=null)
				overRate=(BigDecimal)kdtEntrys.getRow(index).getCell("overRate").getValue();
			BigDecimal trueAmt = ((BigDecimal)kdtEntrys.getRow(index).getCell("payAmount").getValue()).multiply((overRate.divide(new BigDecimal("100")).add(BigDecimal.ONE)));
			if(capacityAmt.compareTo(trueAmt)==-1)
				return false;
		}
		return true;
	}
	
	
	/**
	 * 修改后加入一个校验，不允许修改后的总金额小于原来的总金额
	 */
	public void check()
	{
		BigDecimal amt=BigDecimal.ZERO;
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getRow(i).getCell("overAmt").getValue()!=null)
				amt=amt.add((BigDecimal)kdtEntrys.getRow(i).getCell("overAmt").getValue());
		if(amt.compareTo(editData.getAmt())!=0)
		{
			MsgBox.showInfo("最大可付款金额总额与初始值"+editData.getAmt()+"不相等");
			abort();
		}
				
	}
	@SuppressWarnings("unchecked")
	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		com.kingdee.bos.ctrl.kdf.table.ICell cell =row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}


	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionHelp_actionPerformed
	 */
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionHelp_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAbout_actionPerformed(e);
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception
	{
		check();
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		check();
		super.actionSubmit_actionPerformed(e);
	}
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPrint_actionPerformed(e);
	}

	/**
	 * output actionPrintPreview_actionPerformed
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionPrintPreview_actionPerformed(e);
	}

	/**
	 * output actionCopy_actionPerformed
	 */
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionCopy_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionAddNew_actionPerformed(e);
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
	 * output actionSubmitOption_actionPerformed
	 */
	public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSubmitOption_actionPerformed(e);
	}

	/**
	 * output actionReset_actionPerformed
	 */
	public void actionReset_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionReset_actionPerformed(e);
	}


	public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionViewSubmitProccess_actionPerformed(e);
	}

	/**
	 * output actionMultiapprove_actionPerformed
	 */
	public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionMultiapprove_actionPerformed(e);
	}

	/**
	 * output actionNextPerson_actionPerformed
	 */
	public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionNextPerson_actionPerformed(e);
	}

	/**
	 * output actionStartWorkFlow_actionPerformed
	 */
	public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionStartWorkFlow_actionPerformed(e);
	}

	/**
	 * output actionVoucher_actionPerformed
	 */
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionVoucher_actionPerformed(e);
	}

	/**
	 * output actionWorkFlowG_actionPerformed
	 */
	public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionWorkFlowG_actionPerformed(e);
	}
	public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionWorkflowList_actionPerformed(e);
	}

	/**
	 * output actionViewSignature_actionPerformed
	 */
	public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionViewSignature_actionPerformed(e);
	}

	/**
	 * output actionLocate_actionPerformed
	 */
	public void actionLocate_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionLocate_actionPerformed(e);
	}

	/**
	 * output actionNumberSign_actionPerformed
	 */
	public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionNumberSign_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.signwasthetable.OverPayFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.signwasthetable.OverPayInfo objectValue = new com.kingdee.eas.custom.signwasthetable.OverPayInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}