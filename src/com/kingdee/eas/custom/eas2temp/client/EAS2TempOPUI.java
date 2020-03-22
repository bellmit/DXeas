/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.eas2temp.EAS2TempFacadeFactory;
import com.kingdee.eas.custom.eas2temp.EAS2TempOPTypeEnum;
import com.kingdee.eas.custom.eas2temp.EAS2TempSourceTypeEnum;
import com.kingdee.eas.custom.eas2temp.EASTempClass;
import com.kingdee.eas.custom.eas2temp.IEAS2TempFacade;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */
public class EAS2TempOPUI extends AbstractEAS2TempOPUI {
	private static final Logger logger = CoreUIObject
			.getLogger(EAS2TempOPUI.class);

	/**
	 * output class constructor
	 */
	public EAS2TempOPUI() throws Exception {
		super();
		this.setUITitle("EAS2TEMP接口工具");
		initControl();
	}

	private void initControl() {
		this.kDTable1.getStyleAttributes().setLocked(true);
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setRequired(true);
		this.dpEndDate.setRequired(true);

		StorageF7 sf7 = new StorageF7();
		if (!SysContext.getSysContext().getCurrentOrgUnit().getId().toString()
				.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			sf7.setIsCUFilter(true);
		}
		this.prmtCompany.setSelector(sf7);
		this.prmtCompany.setRequired(true);
		this.prmtCompany.setValue(SysContext.getSysContext()
				.getCurrentStorageUnit());

		this.cmbOPType
				.addItems(EnumUtils.getEnumList(
						"com.kingdee.eas.custom.eas2temp.EAS2TempOPTypeEnum")
						.toArray());
		
		this.cmbTempClass
		.addItems(EnumUtils.getEnumList(
				"com.kingdee.eas.custom.eas2temp.EASTempClass")
				.toArray());

		this.kDTable1.getSelectManager().setSelectMode(
				KDTSelectManager.ROW_SELECT);
		
		
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.exportBOM);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.exportSaleIssue);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.productIn);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.importStockTransferBill);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.importStockTransferBill);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.manufactureOrder);	
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.materialReq);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.productIn);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.exportMaterial);
		this.cmbOPType.removeItem(EAS2TempOPTypeEnum.purInwarehouse);
		
		
		

	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	protected IEAS2TempFacade getBizIntance() throws BOSException {
		return EAS2TempFacadeFactory.getRemoteInstance();
	}

	@Override
	protected void btnExecute_actionPerformed(ActionEvent e) throws Exception {
		// 获得开始结束日期
		String beginDateStr = this.dpBeginDate.getText()+" "+this.kDTimePicker1.getText();
		String endDateStr = this.dpEndDate.getText()+" "+this.kDTimePicker2.getText();
		
		System.out.println(beginDateStr+"------"+endDateStr);
		if (StringUtils.isBlank(beginDateStr)
				|| StringUtils.isBlank(endDateStr)) {
			MsgBox.showWarning("开始日期或结束日期不能为空！");
			SysUtil.abort();
		}

		// 获得公司num和id
		String companyID = null, companyNum = null;
		if (this.prmtCompany.getValue() != null) {
			companyID = ((AbstractCoreBaseInfo) this.prmtCompany.getValue())
					.getString("id");
			companyNum = ((AbstractCoreBaseInfo) this.prmtCompany.getValue())
					.getString("number");
		} else {
			MsgBox.showWarning("公司不能为空");
			SysUtil.abort();
		}
		// 获取所选择的操作类型
		int opType = ((EAS2TempOPTypeEnum) this.cmbOPType.getSelectedItem())
				.getValue();
		String TempClass = ((EASTempClass) this.cmbTempClass.getSelectedItem())
		.getValue();
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("companyID", companyID);
		jsonObj.put("beginDate", beginDateStr);
		jsonObj.put("endDate", endDateStr);
		jsonObj.put("opType", opType);
		//班组
		jsonObj.put("TempClass", TempClass);
		
		
		String result = "执行完成";
System.out.println("beginExecCinet");
		if (opType == EAS2TempOPTypeEnum.PURINWAREHOUSE_VALUE
				|| opType == EAS2TempOPTypeEnum.MATERIALREQ_VALUE
				|| opType == EAS2TempOPTypeEnum.PRODUCTIN_VALUE
				|| opType == EAS2TempOPTypeEnum.MATERIALCOLLREQ_VALUE
				|| opType == EAS2TempOPTypeEnum.IMPORTSTOCKTRANSFERBILL_VALUE) {
			result = getBizIntance().importBill(companyNum, jsonObj.toString(),
					Integer.valueOf(EAS2TempSourceTypeEnum.CLIENT_VALUE));
		} else {
			result = getBizIntance().exportBill(companyNum, jsonObj.toString(),
					Integer.valueOf(EAS2TempSourceTypeEnum.CLIENT_VALUE));
		}

		if (StringUtils.isBlank(result)) {
			result = "执行完成";
		}
		MsgBox.showInfo(result);

	}

	@Override
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		this.disposeUIWindow();
	}

	@Override
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		// 获得开始结束日期
		this.kDTable1.removeRows();
		String beginDateStr = this.dpBeginDate.getText();
		String endDateStr = this.dpEndDate.getText();
		if (StringUtils.isBlank(beginDateStr)
				|| StringUtils.isBlank(endDateStr)) {
			MsgBox.showWarning("开始日期或结束日期不能为空！");
			SysUtil.abort();
		}
		// 获得companyID
		String companyID = "";
		if (this.prmtCompany.getValue() != null) {
			companyID = ((AbstractCoreBaseInfo) this.prmtCompany.getValue())
					.getId().toString();
		}
		// 执行sql查询，查询的是日志log
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from CT_EAS_Logs ");
		sql.append(" where FDate>={d '").append(beginDateStr).append(" '}");
		sql.append(" and FDate<={d '").append(endDateStr).append(" '}+1");
		sql.append(" and FOrgUnitID='").append(companyID).append("'");
		sql.append(" order by FBosType,FDate");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString())
				.executeSQL();
		// 向表格添加查询到的记录
		String bosType, billID;
		String number = "", bizDate;
		CoreBaseInfo iobj = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while (rs.next()) {
			IRow row = kDTable1.addRow();

			bosType = rs.getString("FBosType");
			billID = rs.getString("FbillID");
			if (rs.getDate("FDate") != null) {
				row.getCell("opDate").setValue(f2.format(rs.getDate("FDate")));
			}
			if (EASWUtils.getEntityObjectInfo(bosType) != null) {
				row.getCell("billType").setValue(
						EASWUtils.getEntityObjectInfo(bosType).getAlias());
			}
			try {
				iobj=EASWUtils.getIInstance2(bosType).getValue(new ObjectUuidPK(billID));
				number = iobj.getString("number");
			} catch (Exception e2) {
				number = billID;
			}
			if (StringUtils.isBlank(number)) {
				number = billID;
			}
			bizDate = "";
			if (iobj.get("bizDate") != null) {
				bizDate = f.format(iobj.getDate("bizDate"));
			}
			row.getCell("billNum").setValue(number);
			row.getCell("bizDate").setValue(bizDate);
			row.getCell("result").setValue("成功");
			if ("notSuccess".equals(rs.getString("FIsSuccess"))) {
				row.getCell("result").setValue("失败");
				row.getCell("msg").setValue(rs.getString("FMsg"));
			}
		}
		rs.close();
	}

}