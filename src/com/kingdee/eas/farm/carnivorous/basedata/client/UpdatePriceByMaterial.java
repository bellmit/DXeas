/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class UpdatePriceByMaterial extends AbstractUpdatePriceByMaterial
{
	private static final Logger logger = CoreUIObject.getLogger(UpdatePriceByMaterial.class);

	/**
	 * output class constructor
	 */
	public UpdatePriceByMaterial() throws Exception
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




	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		init();
	}
	/**
	 * 初始化控件
	 */
	private void init() {
		// TODO Auto-generated method stub
		//分录添加监听事件
		kDTable1.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				matEntryLis(e);
			}
		});
	}

	protected void matEntryLis(KDTEditEvent e) {
		// TODO Auto-generated method stub
		try {
			if("matNum".equalsIgnoreCase(kDTable1.getColumn(e.getColIndex()).getKey())){
				if(kDTable1.getCell(e.getRowIndex(), "matNum").getValue() != null){
					MaterialInfo matInfo = (MaterialInfo) kDTable1.getCell(e.getRowIndex(), "matNum").getValue();
					MeasureUnitInfo meaInfo = matInfo.getBaseUnit();
					meaInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(meaInfo.getId()));
					kDTable1.getCell(e.getRowIndex(), "matName").setValue(matInfo.getName());
					kDTable1.getCell(e.getRowIndex(), "matid").setValue(matInfo.getId());
				}
			}
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 新增行
	 * output kDWorkButton1_actionPerformed method
	 */
	@Override
	protected void kDWorkButton1_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton1_actionPerformed(e);
		//		kDTable1.addRows(10);
		for(int i =0;i<11;i++ ){
			IRow row1 = kDTable1.addRow();
			row1.getCell("isSelect").setValue(false);
		}
		KDCheckBox kdtEntrys_isSelect_CheckBox = new KDCheckBox();
		kdtEntrys_isSelect_CheckBox.setName("isSelect");
		KDTDefaultCellEditor kdtEntrys_isSelect_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isSelect_CheckBox);
		this.kDTable1.getColumn("isSelect").setEditor(kdtEntrys_isSelect_CellEditor);
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
	 * 删除行
	 */
	@Override
	protected void kDWorkButton3_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton3_actionPerformed(e);
		for(int i = 0,size = kDTable1.getRowCount();i<size;i++){
			//删除选中行
			if(kDTable1.getCell(i,"isSelect").getValue() != null
					&& kDTable1.getCell(i,"isSelect").getValue().equals(true)){
				kDTable1.removeRow(i);
				i = 0;
				size = size - 1;
			}
		}
	}

	/**
	 * 更新单价，金额
	 * output kDWorkButton2_actionPerformed method
	 */
	protected void kDWorkButton2_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.kDWorkButton2_actionPerformed(e);

		//点击更新，将界面设置的属性值，放到Map里面
		//Map<materialid,>
		Map<String,BigDecimal> choMap = new HashMap<String,BigDecimal>();
		for(int i = 0,size = kDTable1.getRowCount();i<size;i++){
			if(kDTable1.getCell(i,"isSelect").getValue().equals(true)){
				if(kDTable1.getCell(i,"matNum").getValue() != null){
					MaterialInfo matInfo = (MaterialInfo) kDTable1.getCell(i,"matNum").getValue();
					BigDecimal price = UIRuleUtil.getBigDecimal( kDTable1.getCell(i,"price").getValue());
					//物料
					choMap.put(matInfo.getId().toString(), price);
				}
			}
		}
		try{
			this.getUIContext().put("matEntry", choMap);
		}catch(Exception e1){
			throw new Exception(e1.getMessage());
		}

		this.getUIWindow().close();
		this.destroyWindow();



	}

}