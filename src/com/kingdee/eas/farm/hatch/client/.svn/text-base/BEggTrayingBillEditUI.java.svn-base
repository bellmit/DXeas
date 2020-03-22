/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.format.Orientation;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.hatch.HatchBaseData;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.HatchHouseFactory;
import com.kingdee.eas.farm.hatch.HatchHouseInfo;
import com.kingdee.eas.farm.hatch.HatchingBoxInfo;
import com.kingdee.eas.farm.hatch.IncubatorInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;

/**
 * output class name
 */
public class BEggTrayingBillEditUI extends AbstractBEggTrayingBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BEggTrayingBillEditUI.class);
	

	/**
	 * output class constructor
	 */
	public BEggTrayingBillEditUI() throws Exception
	{
		super();
	}
	@Override
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		kdtEntrys_material_PromptBox2.setVisible(true);
		kdtEntrys_material_PromptBox2.setEditable(true);
		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		kdtEggEntries.getColumn("outArea").setEditor(kdtEntrys_material_CellEditor2);  
		kdtEggEntries.getColumn("outArea").setRenderer(kdtEntrys_material_OVR2);
		kdtEggEntries.getColumn("outBabyBox").getStyleAttributes().setLocked(false);

	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		kdtEggEntries.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);
				if("outBabyHouse".equalsIgnoreCase(kdtEggEntries.getColumn(e.getColIndex()).getKey()));
					//setIncubatorFilter(e);
//				if(kdtEggEntries.getColumn(e.getColIndex()).getKey().toLowerCase().equals("outbabybox")){
//					String treeid="";
//					if(kdtEggEntries.getCell(e.getRowIndex(), "outBabyHouse").getValue()!=null)
//						treeid = ((IPropertyContainer)kdtEggEntries.getCell(e.getRowIndex(), "outBabyHouse").getValue()).getString("id");
//					KDBizPromptBox f7 = (KDBizPromptBox)kdtEggEntries.getColumn("outBabyBox").getEditor().getComponent();
//					//StockingClientComm.setHatchingBoxFilterForHatch(f7,treeid); 
//				}
			}

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				if(kdtEggEntries.getColumn(e.getColIndex()).getKey().toLowerCase().contains("qty")){
					Integer candlingHealth = (Integer)kdtEggEntries.getCell(e.getRowIndex(), "candingHealthEggQty").getValue();
					Integer sunBad = (Integer)kdtEggEntries.getCell(e.getRowIndex(), "sunBadEggQty").getValue();
					Integer trayingSad = (Integer)kdtEggEntries.getCell(e.getRowIndex(), "trayingSadEggQty").getValue();
					Integer eggQty = (Integer)kdtEggEntries.getCell(e.getRowIndex(), "eggQty").getValue();
					Integer psEggQty = (Integer)kdtEggEntries.getCell(e.getRowIndex(), "psEggQty").getValue();

					kdtEggEntries.getCell(e.getRowIndex(), "healthTrayingEggQty").setValue(candlingHealth-sunBad-trayingSad-psEggQty);
					Integer healthTrayingEggQty = (Integer)kdtEggEntries.getCell(e.getRowIndex(), "healthTrayingEggQty").getValue();

					if(eggQty==0)
						kdtEggEntries.getCell(e.getRowIndex(), "candlingFertiRate").setValue(null);
					else
						kdtEggEntries.getCell(e.getRowIndex(), "candlingFertiRate").setValue((new BigDecimal(100)).multiply((new BigDecimal(candlingHealth)).divide((new BigDecimal(eggQty)),4,BigDecimal.ROUND_HALF_EVEN)));
						kdtEggEntries.getCell(e.getRowIndex(), "allFertilityRate").setValue((new BigDecimal(100)).multiply((new BigDecimal(healthTrayingEggQty)).divide((new BigDecimal(eggQty)),4,BigDecimal.ROUND_HALF_EVEN)));


				}

				

//				if(kdtEggEntries.getColumn(e.getColIndex()).getKey().equals("outBabyHouse")){
//					if(e.getValue()==null)
//						kdtEggEntries.getCell(e.getRowIndex(), "outBabyBox").setValue(null);
//					else{
//						for(int i=0;i<kdtEggEntries.getRowCount();i++)
//							if(i!=e.getRowIndex()&&kdtEggEntries.getCell(i, "outBabyHouse").getValue()==null){
//								kdtEggEntries.getCell(i, "outBabyHouse").setValue(e.getValue());
//							}
//					}
//				}
			}

		});
	}

	/**
	 * 根据分录上孵厅的数据过滤出雏箱的数据
	 * @param e 
	 */
	private void setIncubatorFilter(KDTEditEvent e) {
		// TODO Auto-generated method stub
//				String hatchHouseNum="";
//				if(kdtEggEntries.getCell(e.getRowIndex(), "hatchHouse").getValue()!=null)
//					hatchHouseNum=((HatchHouseInfo)kdtEggEntries.getCell(e.getRowIndex(), "hatchHouse").getValue()).getNumber();
//				StockingClientComm.setIncubatorFilter(((KDBizPromptBox)kdtEggEntries.getColumn("incubator").getEditor().getComponent()), hatchHouseNum);
		
		
//		// 出雏箱添加过滤条件
//		EntityViewInfo view = new EntityViewInfo();
//		FilterInfo filterInfo = new FilterInfo();
//
//		if(this.prmthatchFactory != null){
//			HatchBaseDataInfo hatchFactory = (HatchBaseDataInfo) this.prmthatchFactory.getValue();
//			filterInfo.getFilterItems().add(new FilterItemInfo("hatchFactory.name",hatchFactory.getName(),CompareType.EQUALS));
//		}
//
//		view.setFilter(filterInfo);
//		((KDBizPromptBox)kdtEggEntries.getColumn("outBabyHouse").getEditor().getComponent()).setEntityViewInfo(view);
//		 KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEggEntries.getColumn("outBabyHouse").getEditor().getComponent(); 
		 //prmtPost.setEntityViewInfo(view);
		
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


		kdtEggEntries.addKDTEditListener(new KDTEditAdapter(){

			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				if(kdtEggEntries.getColumnKey(e.getColIndex()).equals("supplier")){
					if(e.getValue()!=null)
						kdtEggEntries.getCell(e.getRowIndex(), "outArea").setValue(null);
				}
				else if(kdtEggEntries.getColumnKey(e.getColIndex()).equals("outArea")){
					if(e.getValue()!=null)
						kdtEggEntries.getCell(e.getRowIndex(), "supplier").setValue(null);
				}
				else if(kdtEggEntries.getColumnKey(e.getColIndex()).equals("outBabyBox")){
					if(e.getValue()!=null){
						HatchingBoxInfo info  = (HatchingBoxInfo) e.getValue();
					try {
						HatchHouseInfo hinfo = HatchHouseFactory.getRemoteInstance().getHatchHouseInfo(new ObjectUuidPK(info.getHatchHouse().getId().toString()));
						if(hinfo!=null){
							kdtEggEntries.getCell(e.getRowIndex(), "outBabyHouse").setValue(hinfo);
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
			}

		});


		// 图标设置
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		KDTableHelper.setEnterKeyJumpOrientation(kdtEggEntries, Orientation.HORIZONTAL.getValue());
		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);

		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		apendFootRow(new KDTable[]{kdtEggEntries});
		//字段隐藏
		String [] array={"healthEggQty","trayingWeight","addleEggQty","otherEggQty"};
		for(String i:array)
			kdtEggEntries.getColumn(i).getStyleAttributes().setHided(true);
		kdtEggEntries.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(
					KDTPropertyChangeEvent paramKDTPropertyChangeEvent) {
				// TODO Auto-generated method stub
				apendFootRow(new KDTable[]{kdtEggEntries});

			}

		});
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		HatchBaseDataInfo hatchBaseInfo = (HatchBaseDataInfo) this.prmthatchFactory.getValue();
		if(hatchBaseInfo != null){
			filter.getFilterItems().add(new FilterItemInfo("hatchFactory.id",hatchBaseInfo.getId().toString(),CompareType.EQUALS));
		}
//
//		if(StringUtils.isNotBlank(areaInfoID)){
//			filter.getFilterItems().add(new FilterItemInfo("hatchArea.id",areaInfoID,CompareType.EQUALS));
//		}
		evi.setFilter(filter);
		
		//分录F7添加过滤
//	 	//Post
	    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEggEntries.getColumn("outBabyBox").getEditor().getComponent(); //孵化箱F7 
	    prmtPost.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchingBoxQuery");
	    prmtPost.setVisible(true);
	    prmtPost.setEditable(true);
	    prmtPost.setDisplayFormat("$number$");
        prmtPost.setEditFormat("$number$");
        prmtPost.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outBabyBox_CellEditor = new KDTDefaultCellEditor(prmtPost);
        this.kdtEggEntries.getColumn("outBabyBox").setEditor(kdtEggEntries_outBabyBox_CellEditor);
        ObjectValueRender kdtEggEntries_outBabyBox_OVR = new ObjectValueRender();
        kdtEggEntries_outBabyBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outBabyBox").setRenderer(kdtEggEntries_outBabyBox_OVR);
	    
	    prmtPost.setEntityViewInfo(evi); // 重新设定视图  
	    
	    
	}
	/**
	 * 表格【】  以amout，amt，qty结尾的字段添加合计行
	 * @param table
	 */
	public static void apendFootRow(KDTable table[]){
		ArrayList<String> columnName=new ArrayList<String>();
		for(int i=0;i<table.length;i++){
			columnName.clear();
			for(int j=0;j<table[i].getColumnCount();j++)
				if(table[i].getColumn(j).getKey().toLowerCase().contains("qty")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amount")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amt"))
					columnName.add(table[i].getColumn(j).getKey());
			apendFootRow(table[i], columnName.toArray(new String[columnName.size()]));
		}
	}
	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		refreshCurPage();

	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.setMessageText("审核成功");
		showMessage();
		refreshCurPage();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.setMessageText("反审核成功");
		this.btnEdit.setEnabled(true);
		showMessage();
		refreshCurPage();
	}
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
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
			sumValue.put(fields[i], new BigDecimal("0"));  
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
			if(row.getStyleAttributes().isHided())
				continue;
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0}f";  

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

	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

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
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BEggTrayingBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggTrayingBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}
	/**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}
	@Override
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int rowIndex=0;rowIndex<kdtEggEntries.getRowCount();rowIndex++) {
//			if(kdtEggEntries.getCell(rowIndex, "genderType").getValue()==null)
//				kdtEggEntries.getCell(rowIndex, "genderType").setValue(GenderType.Void);
		}
		
		
		Integer candlingHealth=0;
		Integer sunBad=0;
		Integer trayingSad=0;
		Integer eggQty=0;
		Integer allCandlingHealth=0;
		Integer AllSAddle=0;
		Integer AllHealth=0;
		Integer AllEggQty=0;
		Integer psEggQty=0;
		Integer AllpsEggQty=0;
		
		super.beforeStoreFields(e);
		for(int i=0;i<kdtEggEntries.getRowCount();i++){
			candlingHealth = (Integer)kdtEggEntries.getCell(i, "candingHealthEggQty").getValue();
			sunBad = (Integer)kdtEggEntries.getCell(i, "sunBadEggQty").getValue();
			trayingSad = (Integer)kdtEggEntries.getCell(i, "trayingSadEggQty").getValue();
			eggQty = (Integer)kdtEggEntries.getCell(i, "eggQty").getValue();
			psEggQty = (Integer)kdtEggEntries.getCell(i, "psEggQty").getValue();
			
			AllEggQty+=eggQty;
			allCandlingHealth+=candlingHealth;
			AllpsEggQty += psEggQty;
			AllSAddle+=(Integer)kdtEggEntries.getCell(i, "addleEggQty").getValue();
			AllHealth+=(Integer)kdtEggEntries.getCell(i, "healthEggQty").getValue();
			
			kdtEggEntries.getCell(i, "healthTrayingEggQty").setValue(candlingHealth-sunBad-trayingSad-psEggQty);
//			
//			healthTrayingEggQty = candingHealthEggQty-psEggQty
			
			if(eggQty==0)
				kdtEggEntries.getCell(i, "candlingFertiRate").setValue(null);
			else
				kdtEggEntries.getCell(i, "candlingFertiRate").setValue((new BigDecimal(100)).multiply((new BigDecimal(candlingHealth)).divide((new BigDecimal(eggQty)),4,BigDecimal.ROUND_HALF_EVEN)));


		}
		//上孵总数
		txtallHatchEggQty.setValue(AllEggQty);
		txtallCandlingHealthEggQty.setValue(allCandlingHealth);
		txtallAddleEggQty.setValue(AllSAddle);
		txtallHealthEggQty.setValue(AllHealth);
		txtotherLoss.setValue(AllpsEggQty);
	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("审核状态下禁止编辑！");
			SysUtil.abort();
		}
		
		
		super.actionEdit_actionPerformed(arg0);
	}
	
}