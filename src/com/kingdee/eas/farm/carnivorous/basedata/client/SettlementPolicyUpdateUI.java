/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.util.editor.ICellEditor;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.KDComboBox;
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
import com.kingdee.util.enums.EnumUtils;

/**
 * output class name
 */
public class SettlementPolicyUpdateUI extends AbstractSettlementPolicyUpdateUI
{
	private static final Logger logger = CoreUIObject.getLogger(SettlementPolicyUpdateUI.class);

	/**
	 * output class constructor
	 */
	public SettlementPolicyUpdateUI() throws Exception
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
	 * ������Ϣ
	 */
	@Override
	protected void kDWorkButton1_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton1_actionPerformed(e);

		//������£����������õ�����ֵ���ŵ�Map����
		//Map<materialid,>
		Map<String,SettlePolicyPriceEntryInfo> choMap = new HashMap<String,SettlePolicyPriceEntryInfo>();
		SettlePolicyPriceEntryInfo entryInfo = null;
		for(int i = 0,size = kDTable1.getRowCount();i<size;i++){
			if(kDTable1.getCell(i,"matNum").getValue() != null){
				entryInfo = new SettlePolicyPriceEntryInfo();
				MaterialInfo matInfo = (MaterialInfo) kDTable1.getCell(i,"matNum").getValue();
				SettlementItemInfo itemInfo = (SettlementItemInfo) kDTable1.getCell(i,"settleItem").getValue();
				MeasureUnitInfo meaInfo = null;
				if(matInfo.getBaseUnit() != null){
					meaInfo = matInfo.getBaseUnit();
					meaInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(meaInfo.getId()));
				}
				//����
				entryInfo.setMaterial(matInfo);
				//������λ
				entryInfo.setUnit(meaInfo);
				//������Ŀ
				entryInfo.setSettlementItem(itemInfo);
				//��������
				entryInfo.setSettleItemType((SettleItemType) kDTable1.getCell(i,"settleItemType").getValue());
				//�����۸�
				entryInfo.setBasePrice(UIRuleUtil.getBigDecimal(kDTable1.getCell(i,"basePrice").getValue()));
				//��ҩ����
				entryInfo.setOverRate(UIRuleUtil.getBigDecimal(kDTable1.getCell(i,"overRate").getValue()));
				choMap.put(matInfo.getId().toString(), entryInfo);
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

	/**
	 * ������
	 */
	@Override
	protected void kDWorkButton2_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton2_actionPerformed(e);
		kDTable1.addRows(10);


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

		//������λ
		final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
		kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
		kdtEntrys_unit_PromptBox.setVisible(true);
		kdtEntrys_unit_PromptBox.setEditable(true);
		kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_unit_PromptBox.setEditFormat("$number$");
		kdtEntrys_unit_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
		this.kDTable1.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);

		//������Ŀ
		final KDBizPromptBox kdtPriceEntry_settlementItem_PromptBox = new KDBizPromptBox();
		kdtPriceEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
		kdtPriceEntry_settlementItem_PromptBox.setVisible(true);
		kdtPriceEntry_settlementItem_PromptBox.setEditable(true);
		kdtPriceEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
		kdtPriceEntry_settlementItem_PromptBox.setEditFormat("$number$");
		kdtPriceEntry_settlementItem_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtPriceEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settlementItem_PromptBox);
		this.kDTable1.getColumn("settleItem").setEditor(kdtPriceEntry_settlementItem_CellEditor);

		//������Ŀ���
		KDComboBox kdtPriceEntry_settleItemType_ComboBox = new KDComboBox();
		kdtPriceEntry_settleItemType_ComboBox.setName("kdtPriceEntry_settleItemType_ComboBox");
		kdtPriceEntry_settleItemType_ComboBox.setVisible(true);
		kdtPriceEntry_settleItemType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.SettleItemType").toArray());
		KDTDefaultCellEditor kdtPriceEntry_settleItemType_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settleItemType_ComboBox);
		this.kDTable1.getColumn("settleItemType").setEditor(kdtPriceEntry_settleItemType_CellEditor);

	}

	/**
	 * ɾ����
	 */
	@Override
	protected void kDWorkButton3_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton3_actionPerformed(e);

		for(int i = 0,size = kDTable1.getRowCount();i<size;i++){
			//ɾ��ѡ����
			if(kDTable1.getCell(i,"isSelect").getValue() != null
					&& kDTable1.getCell(i,"isSelect").getValue().equals(true)){
				kDTable1.removeRow(i);
				i = 0;
				size = size - 1;
			}
		}


	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub
		super.initLayout();

	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		init();


	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void init() {
		// TODO Auto-generated method stub
		//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		//��¼��Ӽ����¼�
		kDTable1.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				matEntryLis(e);
			}

		});

	}

	/**
	 *��¼�����¼�
	 * @param e
	 */
	protected void matEntryLis(KDTEditEvent e) {
		// TODO Auto-generated method stub
		try {
			if("matNum".equalsIgnoreCase(kDTable1.getColumn(e.getColIndex()).getKey())){
				if(kDTable1.getCell(e.getRowIndex(), "matNum").getValue() != null){
					MaterialInfo matInfo = (MaterialInfo) kDTable1.getCell(e.getRowIndex(), "matNum").getValue();
					MeasureUnitInfo meaInfo = matInfo.getBaseUnit();
					meaInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(meaInfo.getId()));
					kDTable1.getCell(e.getRowIndex(), "matName").setValue(matInfo.getName());
					kDTable1.getCell(e.getRowIndex(), "model").setValue(matInfo.getModel());
					kDTable1.getCell(e.getRowIndex(), "unit").setValue(meaInfo);

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
}