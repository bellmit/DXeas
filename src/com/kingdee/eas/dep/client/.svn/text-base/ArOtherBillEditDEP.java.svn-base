package com.kingdee.eas.dep.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.fi.ar.OtherBillInfo;
import com.kingdee.eas.fi.ar.client.OtherBillEditUI;

/**
 * 应收单编辑界面扩展
 * @author USER
 *
 */
public class ArOtherBillEditDEP {
	
	
	protected OtherBillEditUI ui;
	// 界面 对象
	protected OtherBillInfo editData;
	
	
	
	/**
	 * onload后 设置界面 空间 内容；添加监听
	 * @param param
	 */
	public void afterOnload(final UIParam param){
		
		ui = (OtherBillEditUI) param.getUI();
		editData = (OtherBillInfo) ui.getEditData();
		
		//KDTable增加表格编辑事件监听
		param.getKDTable("kdtEntry").addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				try {
					tableValueChanged(param,e);
				} catch (Exception e1) {
					e1.printStackTrace();
				};
			}}
		);
	}
	
	
	/**
	 * 分录 值变化 事件
	 * @param param
	 * @param selectRow
	 * @param selectCol
	 * @throws Exception
	 */
	 public void tableValueChanged(UIParam param,KDTEditEvent e)throws Exception
	  {
		 ui = (OtherBillEditUI) param.getUI();
	     editData = (OtherBillInfo) ui.getEditData();
		 
		 int selectRow = e.getRowIndex();
		 int selectCol = e.getColIndex();	
			
		 KDTable kDTable = param.getKDTable("kdtEntry");
		 String colName = kDTable.getColumnKey(selectCol);
		 
		 
		 if ("afterDisTax".equals(colName)){
			 BigDecimal afterDisTax=(BigDecimal)param.getKDTable("kdtEntry").getRow(selectRow).getCell("afterDisTax").getValue();
			 afterDisTax = afterDisTax == null?BigDecimal.ZERO:afterDisTax;
			 
			 BigDecimal afterDisNoTaxAmount=(BigDecimal)param.getKDTable("kdtEntry").getRow(selectRow).getCell("afterDisNoTaxAmount").getValue();
			 afterDisNoTaxAmount = afterDisNoTaxAmount == null?BigDecimal.ZERO:afterDisNoTaxAmount;
			 
			 BigDecimal afterDisAmount=(BigDecimal)param.getKDTable("kdtEntry").getRow(selectRow).getCell("afterDisAmount").getValue();
			 afterDisAmount = afterDisAmount == null?BigDecimal.ZERO:afterDisAmount;
			 
			 // 更新对应字段值
			 afterDisNoTaxAmount = afterDisAmount.subtract(afterDisTax);
			 
			 param.getKDTable("kdtEntry").getRow(selectRow).getCell("afterDisNoTaxAmount").setValue(afterDisNoTaxAmount);
			 param.getKDTable("kdtEntry").getRow(selectRow).getCell("isManualTax").setValue(Boolean.TRUE);
		 }
		
	  }
	
	  
	 
	/**
	 * 根据单据体税率  和 折扣后加税合计计算 折扣后税额
	 * @param param
	 * @throws ParseException 
	 */
	public void updateAfterDisTax(UIParam param) throws ParseException{
		
		KDTable entryTable = param.getKDTable("kdtEntry");
		
		// 获取是否含税标志
		Boolean isInTax = param.getKDCheckBox("cbIsInTax").isSelected();
		// 是否价外税
		Boolean isPriceWithoutTax = param.getKDCheckBox("cbIsPriceWithoutTax").isSelected();
		// 逐行计算折让后 税额
		for(int i = 0; i < entryTable.getRowCount(); i++){
			BigDecimal afterDisAmount = (BigDecimal) entryTable.getRow(i).getCell("afterDisAmount").getValue();
			afterDisAmount = afterDisAmount == null?BigDecimal.ZERO:afterDisAmount;
			BigDecimal afterDisNoTaxAmount = (BigDecimal) entryTable.getRow(i).getCell("afterDisNoTaxAmount").getValue();
			BigDecimal afterDisTax = (BigDecimal) entryTable.getRow(i).getCell("afterDisTax").getValue();
			Boolean isManualTax = (Boolean) entryTable.getRow(i).getCell("isManualTax").getValue();
			// 未手动设置税额的行 系统根据税率自动计算税额
			if(!isManualTax){
				BigDecimal taxRate = (BigDecimal) entryTable.getRow(i).getCell("taxRate").getValue();
				
				if(taxRate == null || taxRate.compareTo(BigDecimal.ZERO) == 0){
					afterDisNoTaxAmount = afterDisAmount;
					afterDisTax = BigDecimal.ZERO;
				}else{
					taxRate = taxRate.divide(new BigDecimal(100));
					
					// 不含税时，折扣后税额     税额=折扣后金额*税率%
					// 销售订单含税时，折扣后税额=折扣后价税合计/(1+税率%)*税率%
					// 含税
					if(isInTax){
						afterDisTax = (afterDisAmount.divide((taxRate.add(new BigDecimal(1))),6,RoundingMode.HALF_UP)).multiply(taxRate);
						afterDisTax = afterDisTax.divide(new BigDecimal(1),2,RoundingMode.HALF_UP);
						afterDisNoTaxAmount = afterDisAmount.subtract(afterDisTax);
					}else{
						afterDisTax = afterDisAmount.multiply(taxRate);
						afterDisNoTaxAmount = afterDisAmount.subtract(afterDisTax);
					}
					// 计算税额 和这让后不含税金额
				}
				
			}
			
			

			entryTable.getRow(i).getCell("afterDisNoTaxAmount").setValue(afterDisNoTaxAmount);
			entryTable.getRow(i).getCell("afterDisTax").setValue(afterDisTax);
		}
		
		
	}
			
		
			

		
	
		
}
