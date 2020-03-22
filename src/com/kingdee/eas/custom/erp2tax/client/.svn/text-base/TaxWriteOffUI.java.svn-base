/**
 * output package name
 */
package com.kingdee.eas.custom.erp2tax.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.erp2tax.ERP2TaxFacadeFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class TaxWriteOffUI extends AbstractTaxWriteOffUI
{
    private static final Logger logger = CoreUIObject.getLogger(TaxWriteOffUI.class);
    
    /**
     * output class constructor
     */
    public TaxWriteOffUI() throws Exception
    {
        super();
        this.setUITitle("电子发票红冲");
    }

	@Override
	protected void btnExe_actionPerformed(ActionEvent e) throws Exception {
		/**
		 * 
		 */
		BigDecimal offAmt,offQty;
		JSONArray ja=new JSONArray();
		JSONObject jo;
		for(int rowIndex=0;rowIndex<kDTable1.getRowCount();rowIndex++) {
			IRow row = kDTable1.getRow(rowIndex);
			if(UIRuleUtil.getBigDecimal(row.getCell("finalAmount").getValue()).signum()<0) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行，最后金额不能小于0！");
				SysUtil.abort();
			}
			offAmt=UIRuleUtil.getBigDecimal(row.getCell("offAmount").getValue());
			//红冲金额
			if(offAmt.signum()>0) {
				offQty=UIRuleUtil.getBigDecimal(row.getCell("offQty").getValue());
				jo=new JSONObject();
				jo.put("entryID",row.getCell("entry.id").getValue().toString());
				jo.put("offAmt", offAmt);
				jo.put("offQty", offQty);
				jo.put("taxCode", row.getCell("taxCode").getValue().toString());
				ja.add(jo);
			}
		}
		if(ja.size()>0) {
			try {
				jo=new JSONObject();
				jo.put("companyID", ((IObjectValue) prmtStorageOrgUnit.getValue()).getString("id"));
				jo.put("opType", "other");
				jo.put("data", ja);
				ERP2TaxFacadeFactory.getRemoteInstance().ExportWriteBack2Tax(jo.toString());
			}catch(Exception err) {
				handleException(err);
			}
			MsgBox.showInfo("冲回完成");
		}
	}

	@Override
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		if(prmtStorageOrgUnit.getValue()==null){
			MsgBox.showWarning("库存组织不能为空！");
			return;
		}
		String storageOrgUnitID=((PropertyContainer) prmtStorageOrgUnit.getValue()).getString("id");
		String number=txtNumber.getText();
		if(StringUtils.isEmpty(number)) {
			MsgBox.showWarning("单据编码不能为空！");
			return;
		}
		kDTable1.removeRows();
		pkBizDate.setValue(null);
		txtCustomer.setText(null);
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select tbill.fid FID,tcus.fname_l2 FcustomerName,to_char(tbill.FBizDate,'yyyy-MM-dd') FbizDate,")
		.append(" tentry.fid FEntryID,tm.fnumber FMaterialNum,tm.fname_l2 FMaterialName,tm.FModel,tu.fname_l2 FUnitName,")
		.append(" tentry.FQty,tentry.FTaxPrice,tentry.FAmount,tbill.CFTaxCode")
		.append(" from T_IM_SaleIssueBill tbill")
		.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FCustomerID")
		.append(" inner join T_IM_SaleIssueEntry tentry on tentry.Fparentid=tbill.fid")
		.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialid")
		.append(" inner join t_bd_measureunit tu on tu.fid=tentry.FUnitID")
		.append(" where FStorageOrgUnitID='").append(storageOrgUnitID).append("'")
		.append(" and tbill.fnumber='").append(number).append("'")
		.append(" order by tentry.fseq asc")
		;
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		IRow row;
		while(rs.next()) {
			if(rs.getRow()==1) {
				txtCustomer.setText(rs.getString("FCustomerName"));
				pkBizDate.setValue(rs.getDate("FBizDate"));
			}
			row=kDTable1.addRow();
			row.getCell("materialNum").setValue(rs.getString("FMaterialNum"));
			row.getCell("materialName").setValue(rs.getString("FMaterialName"));
			row.getCell("model").setValue(rs.getString("FModel"));
			row.getCell("unit").setValue(rs.getString("FUnitName"));
			
			row.getCell("qty").setValue(rs.getBigDecimal("FQty"));
			row.getCell("price").setValue(rs.getBigDecimal("FTaxPrice"));
			row.getCell("amount").setValue(rs.getBigDecimal("FAmount"));
			
			row.getCell("taxCode").setValue(rs.getBigDecimal("cftaxCode"));
		}
	}

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		StorageF7 sf7=new StorageF7();
		prmtStorageOrgUnit.setSelector(sf7);
		prmtStorageOrgUnit.setValue(SysContext.getSysContext().getCurrentStorageUnit());
		prmtStorageOrgUnit.setDisplayFormat("$name$");
		prmtStorageOrgUnit.setEditFormat("$number$");
		prmtStorageOrgUnit.setCommitFormat("$number$");
		
		this.kDTable1.checkParsed();
		this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.kDTable1.getStyleAttributes().setLocked(true);
		this.kDTable1.getColumn("unQty").getStyleAttributes().setLocked(false);
		this.kDTable1.getColumn("unAmount").getStyleAttributes().setLocked(false);
		
       KDFormattedTextField kdtEntrys_originalQty_TextField = new KDFormattedTextField();
        kdtEntrys_originalQty_TextField.setName("kdtEntrys_originalQty_TextField");
        kdtEntrys_originalQty_TextField.setVisible(true);
        kdtEntrys_originalQty_TextField.setEditable(true);
        kdtEntrys_originalQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_originalQty_TextField.setDataType(1);
    	kdtEntrys_originalQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
    	kdtEntrys_originalQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_originalQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_originalQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_originalQty_TextField);
        this.kDTable1.getColumn("qty").setEditor(kdtEntrys_originalQty_CellEditor);
        KDFormattedTextField kdtEntrys_originalPrice_TextField = new KDFormattedTextField();
        kdtEntrys_originalPrice_TextField.setName("kdtEntrys_originalPrice_TextField");
        kdtEntrys_originalPrice_TextField.setVisible(true);
        kdtEntrys_originalPrice_TextField.setEditable(true);
        kdtEntrys_originalPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_originalPrice_TextField.setDataType(1);
        	kdtEntrys_originalPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_originalPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_originalPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_originalPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_originalPrice_TextField);
        this.kDTable1.getColumn("price").setEditor(kdtEntrys_originalPrice_CellEditor);
        KDFormattedTextField kdtEntrys_originalAmount_TextField = new KDFormattedTextField();
        kdtEntrys_originalAmount_TextField.setName("kdtEntrys_originalAmount_TextField");
        kdtEntrys_originalAmount_TextField.setVisible(true);
        kdtEntrys_originalAmount_TextField.setEditable(true);
        kdtEntrys_originalAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_originalAmount_TextField.setDataType(1);
        	kdtEntrys_originalAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_originalAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_originalAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_originalAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_originalAmount_TextField);
        this.kDTable1.getColumn("amount").setEditor(kdtEntrys_originalAmount_CellEditor);
        
        this.kDTable1.getColumn("offQty").setEditor(kdtEntrys_originalAmount_CellEditor);
        this.kDTable1.getColumn("offAmount").setEditor(kdtEntrys_originalAmount_CellEditor);
	
		this.kDTable1.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				kdtEdit_stoped(e.getRowIndex(), e.getColIndex());
			}});
	}
	
	private void kdtEdit_stoped(int rowIndex,int colIndex) {
		if(kDTable1.getColumnKey(colIndex).equals("unQty")) {
			BigDecimal price=UIRuleUtil.getBigDecimal(kDTable1.getCell(rowIndex, "price").getValue());
			BigDecimal offQty=UIRuleUtil.getBigDecimal(kDTable1.getCell(rowIndex, "offQty").getValue());
			BigDecimal offAmount=price.multiply(offQty).setScale(2,BigDecimal.ROUND_HALF_UP);
			BigDecimal amount=UIRuleUtil.getBigDecimal(kDTable1.getCell(rowIndex, "amount").getValue());
			kDTable1.getCell(rowIndex, "offAmount").setValue(offAmount);
			kDTable1.getCell(rowIndex, "finalAmount").setValue(amount.subtract(offAmount));
		}
	}
    
}