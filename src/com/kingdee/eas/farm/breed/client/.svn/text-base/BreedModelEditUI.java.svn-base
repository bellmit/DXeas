/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.breed.DisableState;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BreedModelEditUI extends AbstractBreedModelEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BreedModelEditUI.class);

	/**
	 * output class constructor
	 */
	public BreedModelEditUI() throws Exception
	{
		super();

	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}
	/**
	 * 绑定前校验
	 */
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		super.beforeStoreFields(arg0);
		// 商品鸡  分录 日龄不能为空，  育成
		HenhouseType selType = (HenhouseType) this.houseType.getSelectedItem();
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if(!HenhouseType.CC.equals(selType)){
				int week = (Integer) kdtEntrys.getCell(i,"week").getValue();
				if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"week").getValue()) || week == 0) {
					throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"周龄"});
				}
			}else{
				int days = (Integer) kdtEntrys.getCell(i,"weekDay").getValue();
				if (kdtEntrys.getCell(i,"weekDay").getValue() == null || days < 0) {
					throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"日龄"});
				}
			}
		}

	}
	@Override
	public void onLoad() throws Exception {

		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		if(this.editData != null && this.editData.getId() != null && this.editData.getDeletedStatus() == null){
			if("EDIT".equals(this.getOprtState()) || "VIEW".equals(this.getOprtState())){
				this.btnCancelCancel.setEnabled(true);
			}
		}


		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		kdtImmuneEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopping(e);
				MaterialInfo matInfo = null;
				MeasureUnitInfo unitInfo = null;
				if("immuneMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(e.getColIndex()).getKey())){
					if(kdtImmuneEntrys.getCell(e.getRowIndex(), "immuneMaterial").getValue() != null){
						matInfo = (MaterialInfo) kdtImmuneEntrys.getCell(e.getRowIndex(), "immuneMaterial").getValue();
						try {
							matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(matInfo.getId()));
							unitInfo = matInfo.getBaseUnit();
							unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(unitInfo.getId()));
							kdtImmuneEntrys.getCell(e.getRowIndex(), "unit").setValue(unitInfo);
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


	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.breed.BreedModelFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.farm.breed.BreedModelTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.breed.BreedModelInfo objectValue = new com.kingdee.eas.farm.breed.BreedModelInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setDeletedStatus(DisableState.Enable);
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setHouseType(HenhouseType.CC);
		return objectValue;
	}
	/**
	 * 鸡舍类别修改后，饲喂计划中的 必填项和隐藏内容修改
	 */
	@Override
	protected void houseType_actionPerformed(ActionEvent e) throws Exception {
		HenhouseType selType = (HenhouseType) this.houseType.getSelectedItem();
		//		if(selType != null){
		// 商品鸡 养殖时不区分  公母
		//			if(HenhouseType.CC.equals(selType)){
		//				this.kdtEntrys.getColumn("henMaterial").getStyleAttributes().setLocked(true);
		//				this.kdtEntrys.getColumn("henQtyPerday").getStyleAttributes().setLocked(true);
		//				this.kdtEntrys.getColumn("cockMaterial").getStyleAttributes().setLocked(true);
		//				this.kdtEntrys.getColumn("cockQtyPerday").getStyleAttributes().setLocked(true);
		//				this.kdtEntrys.getColumn("week").getStyleAttributes().setLocked(true);
		//				
		//				this.kdtEntrys.getColumn("henMaterial").getStyleAttributes().setHided(true);
		//				this.kdtEntrys.getColumn("henQtyPerday").getStyleAttributes().setHided(true);
		//				this.kdtEntrys.getColumn("cockMaterial").getStyleAttributes().setHided(true);
		//				this.kdtEntrys.getColumn("cockQtyPerday").getStyleAttributes().setHided(true);
		//				this.kdtEntrys.getColumn("week").getStyleAttributes().setHided(true);
		//				
		//				// 显示商品鸡设置
		//				this.kdtEntrys.getColumn("weekDay").getStyleAttributes().setLocked(false);
		//				this.kdtEntrys.getColumn("material").getStyleAttributes().setLocked(false);
		//				this.kdtEntrys.getColumn("qtyPerday").getStyleAttributes().setLocked(false);
		//				
		//				this.kdtEntrys.getColumn("weekDay").getStyleAttributes().setHided(false);
		//				this.kdtEntrys.getColumn("material").getStyleAttributes().setHided(false);
		//				this.kdtEntrys.getColumn("qtyPerday").getStyleAttributes().setHided(false);
		//				
		//			}else{
		//				this.kdtEntrys.getColumn("henMaterial").getStyleAttributes().setLocked(false);
		//				this.kdtEntrys.getColumn("henQtyPerday").getStyleAttributes().setLocked(false);
		//				this.kdtEntrys.getColumn("cockMaterial").getStyleAttributes().setLocked(false);
		//				this.kdtEntrys.getColumn("cockQtyPerday").getStyleAttributes().setLocked(false);
		//				this.kdtEntrys.getColumn("week").getStyleAttributes().setLocked(false);
		//				
		//				this.kdtEntrys.getColumn("henMaterial").getStyleAttributes().setHided(false);
		//				this.kdtEntrys.getColumn("henQtyPerday").getStyleAttributes().setHided(false);
		//				this.kdtEntrys.getColumn("cockMaterial").getStyleAttributes().setHided(false);
		//				this.kdtEntrys.getColumn("cockQtyPerday").getStyleAttributes().setHided(false);
		//				this.kdtEntrys.getColumn("week").getStyleAttributes().setHided(false);
		//				// 显示商品鸡设置
		//				this.kdtEntrys.getColumn("material").getStyleAttributes().setLocked(true);
		//				this.kdtEntrys.getColumn("qtyPerday").getStyleAttributes().setLocked(true);
		//				this.kdtEntrys.getColumn("weekDay").getStyleAttributes().setLocked(true);
		//				
		//				
		//				this.kdtEntrys.getColumn("weekDay").getStyleAttributes().setHided(true);
		//				this.kdtEntrys.getColumn("material").getStyleAttributes().setHided(true);
		//				this.kdtEntrys.getColumn("qtyPerday").getStyleAttributes().setHided(true);
		//				
		//				this.kdtEntrys.getColumn("weekDay").getStyleAttributes().setHided(false);
		//			}
		//		}
		// 重新加载内容
		//		reloadData();
	}

	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();



	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		MsgBox.showInfo("养殖规范只能停用不能删除");
		//		super.actionRemove_actionPerformed(arg0);
	}

	/**
	 * 校验保存的时候是否有重复的日龄和周龄
	 */
	public void validateData(){

	}
}