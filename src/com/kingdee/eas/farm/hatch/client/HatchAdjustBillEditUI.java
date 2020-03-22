/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryCollection;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.HatchBillTypeEnum;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.client.KDTableUtil;

/**
 * output class name
 */
public class HatchAdjustBillEditUI extends AbstractHatchAdjustBillEditUI
{
	///////////////////////////////////////////////////////////////////
	//                     .::::.                                    //
	//                   .::::::::.                                  //
	//                  :::::::::::                                  //
	//                ..:::::::::::'                                 //
	//               '::::::::::::'                                  //
	//                 .::::::::::                                   //
	//               '::::::::::::::..                               //
	//                  ..::::::::::::.                              //
	//               ``::::::::::::::::                              //
	//                ::::``:::::::::'        .:::.                  //
	//              ::::'   ':::::'       .::::::::.                 //
	//             .::::'      ::::     .:::::::'::::.               //
	//             .:::'       :::::  .:::::::::' ':::::.            //
	//            .::'        :::::.:::::::::'      ':::::.          //
	//           .::'         ::::::::::::::'         ``::::.        //
	//        ...:::           ::::::::::::'              ``::.      //
	//       ```` ':.          ':::::::::'                  ::::..   //
	//                           '.:::::'                   ':'````..//
	///////////////////////////////////////////////////////////////////
	//-----------------------孵化调整单------------------------------//
	private static final Logger logger = CoreUIObject.getLogger(HatchAdjustBillEditUI.class);
	/**
	 * output class constructor
	 */ 
	public HatchAdjustBillEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();

		if(oprtState.equals("ADDNEW")){
			HatchBillTypeEnum hatchType = (HatchBillTypeEnum)getUIContext().get("srcBillType");
			srcBillType.setSelectedItem(hatchType);

			//上孵单
			if(hatchType.equals(HatchBillTypeEnum.hatchBill)){
				loadBaseInformationWhenSrcBillIsHatchBill();
			}

			//照蛋
			if(srcBillType.getSelectedItem().equals(HatchBillTypeEnum.candlingBill))
				loadBaseInformationWhenSrcBillIsCandlingBill();
		}
	}


	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.HatchAdjustBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.HatchAdjustBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchAdjustBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUiFormat();

		//当前选择行为偶数时不可删除
		kdtEggEntry.addKDTSelectListener(new KDTSelectListener(){

			public void tableSelectChanged(KDTSelectEvent arg0) {
				// TODO Auto-generated method stub
				int[] selectRow=KDTableUtil.getSelectedRows(kdtEggEntry);
				if(selectRow[0]%2==1){
					kdtEggEntry_detailPanel.getInsertLineButton().setEnabled(false);
					kdtEggEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
				}
				else{
					kdtEggEntry_detailPanel.getRemoveLinesButton().setEnabled(true);
					kdtEggEntry_detailPanel.getInsertLineButton().setEnabled(true);
				}
			}});

		kdtEggEntry_detailPanel.addAddListener(new IDetailPanelListener(){

			public void afterEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				// TODO Auto-generated method stub
				kdtEggEntry.addRow();
				setDoubleRowLocked(kdtEggEntry.getRowCount()-1);
			}


			
			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				// TODO Auto-generated method stub
				setDoubleRowLocked(kdtEggEntry.getRowCount()-1);
			}});

		kdtEggEntry_detailPanel.addInsertListener(new IDetailPanelListener(){

			
			public void afterEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				// TODO Auto-generated method stub
				int[] selectRow=KDTableUtil.getSelectedRows(kdtEggEntry);
				kdtEggEntry.addRow(selectRow[0]+1);
				setDoubleRowLocked(selectRow[0]);
			}

			
			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				// TODO Auto-generated method stub

			}});


		kdtEggEntry_detailPanel.addRemoveListener(new IDetailPanelListener(){

			
			public void afterEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				// TODO Auto-generated method stub
			}

			
			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				// TODO Auto-generated method stub
				int[] selectRow=KDTableUtil.getSelectedRows(kdtEggEntry);
				kdtEggEntry.removeRow(selectRow[0]);
				setDoubleRowLocked(-1);
			}});


		kdtEggEntry.addKDTEditListener(new KDTEditAdapter(){

			
			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);
			}

			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				int rowIndex = e.getRowIndex();




				if("seqnum".equalsIgnoreCase(kdtEggEntry.getColumnKey(e.getColIndex())))
					if(rowIndex%2==0&&kdtEggEntry.getRowCount()>(rowIndex+1)){
						//上孵单
						if(srcBillType.getSelectedItem().equals(HatchBillTypeEnum.hatchBill)){
							BEggHatchBillInfo BEggHatchBillInfo = (BEggHatchBillInfo)prmtsrcBill.getValue();
							BEggHatchBillEggEntryCollection entrys = BEggHatchBillInfo.getEggEntry();
							if(entrys.size()>=UIRuleUtil.getIntValue(e.getValue())){
								kdtEggEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getValue());

								BEggHatchBillEggEntryInfo eggHatchBillEggEntryInfo = entrys.get(UIRuleUtil.getIntValue(e.getValue())-1);
								//上孵厅
								kdtEggEntry.getCell(e.getRowIndex(),"hatchHouse").setValue(eggHatchBillEggEntryInfo.getHatchHouse());
								kdtEggEntry.getCell(e.getRowIndex()+1,"hatchHouse").setValue(eggHatchBillEggEntryInfo.getHatchHouse());

								//上孵箱
								kdtEggEntry.getCell(e.getRowIndex(),"incubator").setValue(eggHatchBillEggEntryInfo.getIncubator());
								kdtEggEntry.getCell(e.getRowIndex()+1,"incubator").setValue(eggHatchBillEggEntryInfo.getIncubator());


								//孵化车
								kdtEggEntry.getCell(e.getRowIndex(),"hatchCarNum").setValue(eggHatchBillEggEntryInfo.getHatchCarNum());
								kdtEggEntry.getCell(e.getRowIndex()+1,"hatchCarNum").setValue(eggHatchBillEggEntryInfo.getHatchCarNum());

								//种蛋来源
								kdtEggEntry.getCell(e.getRowIndex(),"eggSourceType").setValue(eggHatchBillEggEntryInfo.getEggSourceType());
								kdtEggEntry.getCell(e.getRowIndex()+1,"eggSourceType").setValue(eggHatchBillEggEntryInfo.getEggSourceType());

								//混合上孵
								kdtEggEntry.getCell(e.getRowIndex(),"isMix").setValue(eggHatchBillEggEntryInfo.getBoolean("isMix"));
								kdtEggEntry.getCell(e.getRowIndex()+1,"isMix").setValue(eggHatchBillEggEntryInfo.getBoolean("isMix"));

								//片区
								kdtEggEntry.getCell(e.getRowIndex(),"outArea").setValue(eggHatchBillEggEntryInfo.getOutArea());
								kdtEggEntry.getCell(e.getRowIndex()+1,"outArea").setValue(eggHatchBillEggEntryInfo.getOutArea());

								//批次
								kdtEggEntry.getCell(e.getRowIndex(),"outBatch").setValue(eggHatchBillEggEntryInfo.getOutBatch());
								kdtEggEntry.getCell(e.getRowIndex()+1,"outBatch").setValue(eggHatchBillEggEntryInfo.getOutBatch());

								//品系
								kdtEggEntry.getCell(e.getRowIndex(),"genderType").setValue(eggHatchBillEggEntryInfo.getGenderType());
								kdtEggEntry.getCell(e.getRowIndex()+1,"genderType").setValue(eggHatchBillEggEntryInfo.getGenderType());

								//养殖户
								kdtEggEntry.getCell(e.getRowIndex(),"farmer").setValue(eggHatchBillEggEntryInfo.getFarmer());
								kdtEggEntry.getCell(e.getRowIndex()+1,"farmer").setValue(eggHatchBillEggEntryInfo.getFarmer());

								//养殖场
								kdtEggEntry.getCell(e.getRowIndex(),"outFarm").setValue(eggHatchBillEggEntryInfo.getOutFarm());
								kdtEggEntry.getCell(e.getRowIndex()+1,"outFarm").setValue(eggHatchBillEggEntryInfo.getOutFarm());

								//棚舍
								kdtEggEntry.getCell(e.getRowIndex(),"outHouse").setValue(eggHatchBillEggEntryInfo.getOutHouse());
								kdtEggEntry.getCell(e.getRowIndex()+1,"outHouse").setValue(eggHatchBillEggEntryInfo.getOutHouse());

//								//交蛋日期
//								kdtEggEntry.getCell(e.getRowIndex(),"sendDate").setValue(eggHatchBillEggEntryInfo.getSendDate());
//								kdtEggEntry.getCell(e.getRowIndex()+1,"sendDate").setValue(eggHatchBillEggEntryInfo.getSendDate());


								//周龄
								kdtEggEntry.getCell(e.getRowIndex(),"weeklyAge").setValue(eggHatchBillEggEntryInfo.getWeeklyAge());
								kdtEggEntry.getCell(e.getRowIndex()+1,"weeklyAge").setValue(eggHatchBillEggEntryInfo.getWeeklyAge());

								//日龄
								kdtEggEntry.getCell(e.getRowIndex(),"dayAge").setValue(eggHatchBillEggEntryInfo.getDayAge());
								kdtEggEntry.getCell(e.getRowIndex()+1,"dayAge").setValue(eggHatchBillEggEntryInfo.getDayAge());

								//是否转正
								kdtEggEntry.getCell(e.getRowIndex(),"isFormal").setValue(eggHatchBillEggEntryInfo.getBoolean("isFormal"));
								kdtEggEntry.getCell(e.getRowIndex()+1,"isFormal").setValue(eggHatchBillEggEntryInfo.getBoolean("isFormal"));

								//供应商
								kdtEggEntry.getCell(e.getRowIndex(),"supplier").setValue(eggHatchBillEggEntryInfo.getSupplier());
								kdtEggEntry.getCell(e.getRowIndex()+1,"supplier").setValue(eggHatchBillEggEntryInfo.getSupplier());

								//合格单类型
								kdtEggEntry.getCell(e.getRowIndex(),"qcEggType").setValue(eggHatchBillEggEntryInfo.getQcEggType());
								kdtEggEntry.getCell(e.getRowIndex()+1,"qcEggType").setValue(eggHatchBillEggEntryInfo.getQcEggType());

								//上孵数量
								kdtEggEntry.getCell(e.getRowIndex(),"eggQty").setValue(eggHatchBillEggEntryInfo.getEggQty());
								kdtEggEntry.getCell(e.getRowIndex()+1,"eggQty").setValue(eggHatchBillEggEntryInfo.getEggQty());

								//蛋库
								kdtEggEntry.getCell(e.getRowIndex(),"eggHouse").setValue(eggHatchBillEggEntryInfo.getEggHouse());
								kdtEggEntry.getCell(e.getRowIndex()+1,"eggHouse").setValue(eggHatchBillEggEntryInfo.getEggHouse());
								//苗批次
								kdtEggEntry.getCell(e.getRowIndex(),"babyBatch").setValue(eggHatchBillEggEntryInfo.getBabyBatch());
								kdtEggEntry.getCell(e.getRowIndex()+1,"babyBatch").setValue(eggHatchBillEggEntryInfo.getBabyBatch());
							}else{
								kdtEggEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(0);
							}
						}
					}else{
						setColor(e.getRowIndex(),e.getColIndex());
						if(e.getValue()!=null&&e.getOldValue()!=null&&e.getOldValue().equals(e.getValue())){
							kdtEggEntry.getCell(e.getRowIndex(), e.getColIndex()).getStyleAttributes().setFontColor(Color.red);
						}
					}
			}
		});
	}

	/**
	 * 界面格式调整
	 */
	private void setUiFormat() {
		// TODO Auto-generated method stub
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		srcBillType.setEnabled(false);
		prmtsrcBill.setEnabled(false);
		prmtstorageOrgUnit.setEnabled(false);
	}
	/**
	 * 设置单元格文字的颜色
	 * @param i行
	 * @param j列
	 */
	private void setColor(int i, int j) {
		// TODO Auto-generated method stub
		if(kdtEggEntry.getCell(i, j).getValue()!=null&&kdtEggEntry.getCell(i+1, j).getValue()!=null&&!kdtEggEntry.getCell(i, j).getValue().equals(kdtEggEntry.getCell(i+1, j).getValue())){
			kdtEggEntry.getCell(i, j).getStyleAttributes().setFontColor(Color.red);
		}
	}
	/**
	 * 对偶数行锁定
	 */
	private void setDoubleRowLocked(int rowNum) {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEggEntry.getRowCount();i++)
			if(i%2==1){
				kdtEggEntry.getRow(i).getStyleAttributes().setLocked(true);
				kdtEggEntry.getRow(i).getStyleAttributes().setBackground(Color.lightGray);
			}
			else
				kdtEggEntry.getRow(i).getStyleAttributes().setLocked(false);
		
		for(int i=0;i<kdtEggEntry.getColumnCount()&&rowNum>=0;i++){
			if(kdtEggEntry.getColumnKey(i).equals("seq"))
				kdtEggEntry.getCell(rowNum+1, i).setValue(kdtEggEntry.getCell(rowNum, i).getValue());
		}
	}
	/**
	 * 照蛋记录单加载初始数据
	 */
	private void loadBaseInformationWhenSrcBillIsCandlingBill() {
		// TODO Auto-generated method stub
		HatchBillTypeEnum hatchType = (HatchBillTypeEnum)srcBillType.getSelectedItem();
		if(hatchType.equals(HatchBillTypeEnum.candlingBill)){



			this.prmtsrcBill.setQueryInfo("com.kingdee.eas.farm.hatch.app.BEggCandlingBillQuery");		
			this.prmtsrcBill.setVisible(true);		
			this.prmtsrcBill.setEditable(true);		
			this.prmtsrcBill.setDisplayFormat("$number$");		
			this.prmtsrcBill.setEditFormat("$number$");		
			this.prmtsrcBill.setCommitFormat("$number$");		
			this.prmtsrcBill.setRequired(false);


			BEggCandlingBillInfo srcBill = (BEggCandlingBillInfo)getUIContext().get("srcBill");
			prmtsrcBill.setValue(srcBill);
			HatchBaseDataInfo hatchBaseInfo;
			try {
				hatchBaseInfo = HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(srcBill.getHatchFactory().getString("id")));
				StorageOrgUnitInfo storageOrgUnitInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(hatchBaseInfo.getHatchFactory().getString("id")));
				prmtstorageOrgUnit.setValue(storageOrgUnitInfo);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	/**
	 * 种蛋上孵单加载初始数据
	 */
	private void loadBaseInformationWhenSrcBillIsHatchBill() {
		// TODO Auto-generated method stub

		BEggHatchBillInfo srcBill = (BEggHatchBillInfo)getUIContext().get("srcBill");
		prmtsrcBill.setValue(srcBill);
		HatchBaseDataInfo hatchBaseInfo;
		try {
			hatchBaseInfo = HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(srcBill.getHatchFactory().getString("id")));
			StorageOrgUnitInfo storageOrgUnitInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(hatchBaseInfo.getHatchFactory().getString("id")));
			prmtstorageOrgUnit.setValue(storageOrgUnitInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set phases can be operated
		if(srcBillType.getSelectedItem()!=null){

			//上孵单设置锁定的列
			if(srcBillType.getSelectedItem().equals(HatchBillTypeEnum.hatchBill)){
				for(int i=0;i<kdtEggEntry.getColumnCount();i++)
					if(kdtEggEntry.getColumnKey(i).toLowerCase().equals("seqnum")||kdtEggEntry.getColumnKey(i).toLowerCase().equals("outbatch")||kdtEggEntry.getColumnKey(i).toLowerCase().equals("outArea"))
						kdtEggEntry.getColumn(i).getStyleAttributes().setLocked(false);
					else
						kdtEggEntry.getColumn(i).getStyleAttributes().setLocked(true);
			}
		}

	}
}