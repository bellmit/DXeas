/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.wlhllicensemanager.util.JUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;

/**
 * output class name
 */
public class SettlementPolicyUpdateTestUI extends AbstractSettlementPolicyUpdateTestUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettlementPolicyUpdateTestUI.class);
    
    /**
     * output class constructor
     */
    public SettlementPolicyUpdateTestUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * 更新信息
     * output kDWorkButton1_actionPerformed method
     */
    protected void kDWorkButton1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.kDWorkButton1_actionPerformed(e);
    }

    /**
     * 新增行
     */
	@Override
	protected void kDWorkButton2_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton2_actionPerformed(e);
	}

	/**
	 * 删除行
	 */
	@Override
	protected void kDWorkButton3_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton3_actionPerformed(e);
	}

	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		super.loadFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub
		super.initLayout();
		kDTable1.checkParsed();
		
	
		IColumn col1 = null;
		col1 = kDTable1.addColumn(0);
		col1.setKey("matNum");
		col1.setWidth(100);
		col1.getStyleAttributes().setLocked(false);
		final KDCheckBox fidCheck = new KDCheckBox();
		fidCheck.setName("fidCheck_CheckBox");
		
		
		final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_material_PromptBox.setEditFormat("$number$");
		kdtEntrys_material_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kDTable1.getColumn("matNum").setEditor(kdtEntrys_material_CellEditor);
		
		
	}

	/**
	 * 创建head
	 * @return
	 */
	private RptTableHeader createHeader() {


		RptTableHeader header = new RptTableHeader();
		StringBuffer headerLabel=new StringBuffer();
		JSONObject colJson = null;
		RptTableColumn col = null;

		//设置是否选择Boolean类型
		headerLabel.append("是否选择");
		header.addColumn(new RptTableColumn("isSelect"));

		headerLabel.append(",");
		headerLabel.append("同步结果");
		//设置同步结果的显示宽度
		col = new RptTableColumn();
		col.setWidth(300);
		col.setName("synResult");
		header.addColumn(col);

		header.setLabels(new Object[][] { headerLabel.toString().split(",") });
		return header;
	
	}

}