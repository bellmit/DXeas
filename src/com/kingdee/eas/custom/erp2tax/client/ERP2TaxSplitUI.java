/**
 * output package name
 */
package com.kingdee.eas.custom.erp2tax.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class ERP2TaxSplitUI extends AbstractERP2TaxSplitUI
{
    private static final Logger logger = CoreUIObject.getLogger(ERP2TaxSplitUI.class);
    private BigDecimal maxAmount;
    
    /**
     * output class constructor
     */
    public ERP2TaxSplitUI() throws Exception
    {
        super();
        this.setUITitle("开票拆分");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.txtAllAmount.setValue(this.getUIContext().get("allAmount"));
		this.txtAllAmount.setPrecision(3);
		txtAllAmount.setDataType(KDFormattedTextField.DECIMAL);
		this.txtAllAmount.setEnabled(false);
		maxAmount=(BigDecimal) this.getUIContext().get("maxAmount");
		if(maxAmount==null) {
			maxAmount=BigDecimal.ZERO;
		}
		kDtDetail.checkParsed();
		KDFormattedTextField dd=new KDFormattedTextField();
		dd.setDataType(KDFormattedTextField.DECIMAL);
		dd.setPrecision(3);
		KDTDefaultCellEditor ss=new KDTDefaultCellEditor(dd);
		kDtDetail.getColumn("amount").setEditor(ss);
		kDtDetail.addRow();
		kDtDetail.addRow();
	}
	
	private void getBillEntry() throws Exception {
		String billID=(String) this.getUIContext().get("exportBillID");
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.FID,tbill.FNumber,tcus.FName_l2 FCustomerName,tcus.fnumber FCustomerNum,tcus.FTxRegisterNo,")
		.append(" tentry.FID FEntryID,tm.fid fmaterialID,tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,")
		.append(" tentry.FQuantity FQty,tentry.FPrice,tentry.FTaxPrice,tentry.FAmount,tentry.FRecievePayAmount,tentry.FTaxRate/100 FTaxRate,")
		.append(" tentry.FDiscountAmount,tentry.FSeq,tmc.cftaxCode")//折扣额
		.append(" from t_ar_otherbill tbill")
		.append(" inner join t_ar_otherBillEntry tentry on tentry.fparentid=tbill.fid ")
		.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FAsstActID")
		.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
		.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tbill.FCompanyID")
		.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FMeasureUnitID")
		.append(" where tbill.fid in ('").append(billID).append("')")
		.append(" order by tbill.fnumber, tentry.fseq ");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		IRow row=null;
		while(rs.next()) {
//			row=kDTEntry.addRow();
			row.getCell("entryID").setValue(rs.getString("FEntryID"));
			row.getCell("materialID").setValue(rs.getString("fmaterialID"));
			row.getCell("materialName").setValue(rs.getString("FEntryID"));
			row.getCell("model").setValue(rs.getString("FEntryID"));
			row.getCell("unit").setValue(rs.getString("FEntryID"));
			row.getCell("unit").setValue(rs.getBigDecimal("FEntryID"));
			row.getCell("qty").setValue(rs.getBigDecimal("FEntryID"));
			row.getCell("price").setValue(rs.getBigDecimal("FEntryID"));
			row.getCell("amount").setValue(rs.getBigDecimal("FEntryID"));
			row.getCell("disAmount").setValue(rs.getBigDecimal("FEntryID"));
		}
	}

	@Override
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		this.getUIContext().put("isCancel", true);
		destroyWindow();
	}

	@Override
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		BigDecimal sumAmount=BigDecimal.ZERO;
		ArrayList<BigDecimal> amountList=new ArrayList<BigDecimal>();
		BigDecimal tempAmount;
		for(int rowIndex=0;rowIndex<kDtDetail.getRowCount();rowIndex++) {
			tempAmount=UIRuleUtil.getBigDecimal(kDtDetail.getCell(rowIndex, "amount").getValue());
			if(maxAmount.compareTo(tempAmount)<0){
				MsgBox.showWarning("第"+(rowIndex+1)+"行金额大于最大开票金额！");
				return;
			}
			sumAmount=sumAmount.add(tempAmount);
			if(tempAmount.signum()>0) {
				amountList.add(tempAmount);
			}
		}
		BigDecimal allAmount=this.txtAllAmount.getBigDecimalValue();
		if(allAmount.compareTo(sumAmount)!=0) {
			MsgBox.showWarning("拆分合并金额不等于总开票金额！");
			return;
		}
		this.getUIContext().put("isCancel", false);
		this.getUIContext().put("amountList", amountList);
		this.getUIContext().put("isSplitInit", chkIsSplitInit.isSelected());
		destroyWindow();
	}

	@Override
	protected void btnAdd_actionPerformed(ActionEvent e) throws Exception {
		kDtDetail.addRow();
	}

	@Override
	protected void btnSub_actionPerformed(ActionEvent e) throws Exception {
		IRow row = KDTableUtil.getSelectedRow(kDtDetail);
		if(row==null||row.getRowIndex()<0) {
			MsgBox.showWarning("请先选择删除行！");
			return;
		}
		kDtDetail.removeRow(row.getRowIndex());
	}
    
}