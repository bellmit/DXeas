/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.Context;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.IDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.eas2temp.EAS2TempFacadeFactory;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class InitBarEASRelUI extends AbstractInitBarEASRelUI {
	private static final Logger logger = CoreUIObject
			.getLogger(InitBarEASRelUI.class);

	/**
	 * output class constructor
	 */
	public InitBarEASRelUI() throws Exception {
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		StorageF7 sf7 = new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageUnitOrg.setSelector(sf7);
		this.prmtstorageUnitOrg.setValue(SysContext.getSysContext()
				.getCurrentStorageUnit());

		this.kDTable1.checkParsed();
		KDBizPromptBox kdtEntries_materialNum_PromptBox = new KDBizPromptBox();
		kdtEntries_materialNum_PromptBox
				.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		kdtEntries_materialNum_PromptBox.setVisible(true);
		kdtEntries_materialNum_PromptBox.setEditable(true);
		kdtEntries_materialNum_PromptBox.setDisplayFormat("$number$");
		kdtEntries_materialNum_PromptBox.setEditFormat("$number$");
		kdtEntries_materialNum_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntries_materialNum_CellEditor = new KDTDefaultCellEditor(
				kdtEntries_materialNum_PromptBox);
		this.kDTable1.getColumn("material").setEditor(
				kdtEntries_materialNum_CellEditor);
		String storageOrgUnitID = null;
		if (this.prmtstorageUnitOrg.getValue() != null) {
			storageOrgUnitID = ((IPropertyContainer) this.prmtstorageUnitOrg
					.getValue()).getString("id");
		}
		F7ContextManager f7Manager = new F7ContextManager(this, OrgType.Storage);
		OrgUnitInfo orgInfo = StorageOrgUnitFactory.getRemoteInstance()
				.getOrgUnitInfo(new ObjectUuidPK(storageOrgUnitID));
		// 更改物料F7
		f7Manager.registerBizMaterialF7((KDBizPromptBox) this.kDTable1
				.getColumn("material").getEditor().getComponent(), null, null,
				orgInfo, false);

	}

	@Override
	protected void kDButtonAdd_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kDButtonAdd_actionPerformed(e);
		this.kDTable1.addRow();
	}

	@Override
	protected void kDButtonInit_actionPerformed(ActionEvent e) throws Exception {
		super.kDButtonInit_actionPerformed(e);
		if (this.prmtstorageUnitOrg.getValue() == null) {
			MsgBox.showWarning("库存组织不能为空！");
			return;
		}
		String storageOrgUnitID = null;
		storageOrgUnitID = ((IPropertyContainer) this.prmtstorageUnitOrg
				.getValue()).getString("id");

		for (int i = 0; i < this.kDTable1.getRowCount(); i++) {
			if (this.kDTable1.getRow(i).getCell("material").getValue() != null) {
				MaterialInfo easMaterialInfo = (MaterialInfo) kDTable1.getCell(
						i, "material").getValue();
				EAS2TempFacadeFactory.getRemoteInstance().initBarEASRel(
						easMaterialInfo.getId().toString(), storageOrgUnitID);
			}
		}
		this.kDTable1.removeRows();
		MsgBox.showWarning("执行完成！");

	}

	@Override
	protected void kDButtonRemove_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.kDButtonRemove_actionPerformed(e);
		// this.kDTable1.remove(index);
		this.kDTable1.removeRow(KDTableUtil.getSelectedRow(this.kDTable1)
				.getRowIndex());
	}

}