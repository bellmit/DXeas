package com.kingdee.eas.dep.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.client.MaterialReqBillEditUI;
import com.kingdee.eas.scm.im.inv.client.SaleIssueBillEditUI;
import com.kingdee.eas.scm.sd.sale.SaleContractInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

public class SaleIssueEditDEP {
	
	protected SaleIssueBillEditUI ui;
	// 界面 对象
	protected SaleIssueBillInfo editData;

	/**
	 * 校验 使用余额是否大于可用余额
	 * @param param
	 */
	public void checkUseDisAmount(UIParam param){
		BigDecimal canUseAmount = param.getKDFormattedTextField("txtcanUseDis").getBigDecimalValue();
		BigDecimal useDis = param.getKDFormattedTextField("txtuseDis").getBigDecimalValue();
		if(useDis != null){
			if(canUseAmount != null){
				if(useDis.compareTo(canUseAmount) > 0){
					MsgBox.showInfo("使用余额不能大于当前客户的可用余额");
					SysUtil.abort();
				}
			}else{
				MsgBox.showInfo("当前客户可用余额为空，不能使用折让余额");
				SysUtil.abort();
			}
		}
	}
	/**
	 * 根据各个分录的 销量 基本数量拆分 使用折让金额到 分录中，尾差 放到最后一行分录
	 * @param param
	 * @throws ParseException 
	 */
	public void splitUseDisToEntry(UIParam param) throws ParseException{
		param.getKDFormattedTextField("txtuseDis").commitEdit();
		BigDecimal useDis = param.getKDFormattedTextField("txtuseDis").getBigDecimalValue();
		if(useDis != null && useDis.compareTo(BigDecimal.ZERO) > 0){
			// 价税合计
			BigDecimal txtTotalTaxAmount = BigDecimal.ZERO;
			// 分录
			KDTable entryTable = param.getKDTable("detailTable");
			// 逐行分摊金额
			for(int i = 0; i < entryTable.getRowCount(); i++){
				BigDecimal taxAmount = (BigDecimal) entryTable.getRow(i).getCell("taxAmount").getValue();
				txtTotalTaxAmount = txtTotalTaxAmount.add(taxAmount);
				
			}
//			if(txtTotalTaxAmount != null && txtTotalTaxAmount.compareTo(BigDecimal.ZERO) > 0){
				
				BigDecimal hasSplitAmount = BigDecimal.ZERO;
				// 拆分比例
				BigDecimal splitRate = useDis.divide(txtTotalTaxAmount, 6, RoundingMode.HALF_UP);
				
				
				// 记录最后一笔非0的分摊
				BigDecimal lastSplitDis = BigDecimal.ZERO;
				int lastSplitSeq = -1;
				// 逐行分摊金额
				for(int i = 0; i < entryTable.getRowCount(); i++){
					BigDecimal taxAmount = (BigDecimal) entryTable.getRow(i).getCell("taxAmount").getValue();
					BigDecimal afterDisAmount = taxAmount.multiply(new BigDecimal(1));
					
					if(taxAmount != null){
						BigDecimal entryDis = taxAmount.multiply(splitRate);
						// 取两位有效数字
						entryDis = entryDis.setScale(2,RoundingMode.HALF_UP);
						hasSplitAmount = hasSplitAmount.add(entryDis);
						// 保存分录分摊折让
						entryTable.getRow(i).getCell("dis").setValue(entryDis);
						
						if(entryDis != null && entryDis.compareTo(BigDecimal.ZERO) > 0){
							lastSplitDis = entryDis;
							lastSplitSeq = i;
						}
						
						// 计算折让后价税合计、这让后单价
						afterDisAmount = afterDisAmount.subtract(entryDis);
						entryTable.getRow(i).getCell("afterDisAmount").setValue(afterDisAmount);
						BigDecimal afterDisBasePrice = BigDecimal.ZERO;
						BigDecimal baseQty = (BigDecimal) entryTable.getRow(i).getCell("baseQty").getValue();
						if(baseQty != null && baseQty.compareTo(BigDecimal.ZERO) > 0){
							afterDisBasePrice = afterDisAmount.divide(baseQty,6, RoundingMode.HALF_UP);
						}
						
						entryTable.getRow(i).getCell("afterDisBasePrice").setValue(afterDisBasePrice);
						
						
					}
				}
				
				// 如果分摊后有差额 则累计到最后一行有折让的分录中，并重新计算单价
				if(hasSplitAmount != null && hasSplitAmount.compareTo(useDis) != 0){
					BigDecimal remainDis = useDis.subtract(hasSplitAmount);
					if(lastSplitSeq != -1){
						BigDecimal dis = (BigDecimal) entryTable.getRow(lastSplitSeq).getCell("dis").getValue();
						if(dis != null && dis.compareTo(BigDecimal.ZERO) != 0){
							dis = dis.add(remainDis);
							entryTable.getRow(lastSplitSeq).getCell("dis").setValue(dis);
							BigDecimal baseQty = (BigDecimal) entryTable.getRow(lastSplitSeq).getCell("baseQty").getValue();
							BigDecimal taxAmount = (BigDecimal) entryTable.getRow(lastSplitSeq).getCell("taxAmount").getValue();
							BigDecimal afterDisAmount = taxAmount.multiply(new BigDecimal(1));
							
							// 重新计算折让后金额
							afterDisAmount = afterDisAmount.subtract(dis);
							entryTable.getRow(lastSplitSeq).getCell("afterDisAmount").setValue(afterDisAmount);
							BigDecimal afterDisBasePrice = BigDecimal.ZERO;
							
						
							
							if(baseQty != null && baseQty.compareTo(BigDecimal.ZERO) > 0){
								afterDisBasePrice = afterDisAmount.divide(baseQty,6, RoundingMode.HALF_UP);
							}
							
							entryTable.getRow(lastSplitSeq).getCell("afterDisBasePrice").setValue(afterDisBasePrice);
						}
					}
					
				}
			}
			
		
			
//		}
//		
	}
	

	/**
	 * 校验中转库 领料出时设置 合同情况
	 * 如果中转库 出库 必须选择 销售合同
	 * @param param 
	 */
	public void checkTransReqContract(UIParam param){
		ui = (SaleIssueBillEditUI) param.getUI();
		editData = (SaleIssueBillInfo) ui.getEditData();
		
		// 逐行判断是否有从中转库领料的情况，如果有 则校验必须填写销售合同
		SaleContractInfo contractInfo = (SaleContractInfo) param.getKDBizPromptBox("prmtsaleContract").getValue();
		if(contractInfo == null){
			KDTable entryTable = param.getKDTable("detailTable");
			
			// 逐行分摊金额
			for(int i = 0; i < entryTable.getRowCount(); i++){
				WarehouseInfo warehouseInfo = (WarehouseInfo) entryTable.getCell(i, "warehouse").getValue();
				
				if(warehouseInfo != null){
					if(BSXConstant.ZZK_ID.equals(warehouseInfo.getId().toString())){
						MsgBox.showInfo("分录中存在【仓库】为中转库的数据，单据头中的【 销售合同】不能为空");
						SysUtil.abort();
					}
				}
			}
		}
		
	}
	
}
