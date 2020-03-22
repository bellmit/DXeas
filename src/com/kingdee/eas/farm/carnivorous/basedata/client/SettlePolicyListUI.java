/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicy;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class SettlePolicyListUI extends AbstractSettlePolicyListUI
{
	private static final Logger logger = CoreUIObject.getLogger(SettlePolicyListUI.class);

	/**
	 * output class constructor
	 */
	public SettlePolicyListUI() throws Exception
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory.getRemoteInstance();
	}

	/**
	 * output getTreeInterface method
	 */
	protected ITreeBase getTreeInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeFactory.getRemoteInstance();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}


	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.tblMain_tableSelectChanged(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
		if(baseStatus.equals("禁用")) {
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
		}else if(baseStatus.equals("核准")) {
			this.actionCancel.setEnabled(true);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(false);
		}else{
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(true);
		}
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		//        super.actionAudit_actionPerformed(e);
		if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("单据已经核准，禁止再次核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		ISettlePolicy  intenface= (ISettlePolicy) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			intenface.audit(intenface.getSettlePolicyInfo(pk));
		}
		MsgBox.showInfo("核准成功！");
		refreshList();
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		//        super.actionAudit_actionPerformed(e);
		if (!this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("未核准单据不能反核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		ISettlePolicy  intenface= (ISettlePolicy) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 反核准操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
			intenface.unAudit(intenface.getSettlePolicyInfo(pk));		
		}
		MsgBox.showInfo("反核准成功！");
		refreshList();
	}



	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}


	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
			return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
			prepareCancel(null).callHandler();
		}
		cancelCancel();
		actionRefresh_actionPerformed(e);
	}
	/**
	 * output getGroupEditUIName method
	 */
	protected String getGroupEditUIName()
	{
		return com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyTreeEditUI.class.getName();
	}

	/**
	 * output getQueryFieldName method
	 */
	protected String getQueryFieldName()
	{
		return "treeid.id";
	}

	/**
	 * output getKeyFieldName method
	 */
	protected String getKeyFieldName()
	{
		return "id";
	}

	/**
	 * output getRootName method
	 */
	protected String getRootName()
	{
		return "结算政策";
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo();

		return objectValue;
	}

	/**
	 * 批量更新结算政策
	 */
	@Override
	public void actionMulUpdate_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionMulUpdate_actionPerformed(e);
		Map map=new UIContext(this);
		//弹出UI界面
		IUIWindow uiWindow=null; 
		String scanUI = "com.kingdee.eas.farm.carnivorous.basedata.client.SettlementPolicyUpdateUI";
		uiWindow = (UIModelDialog) UIFactory.createUIFactory(UIFactoryName.MODEL).create(
				scanUI, map, null, OprtState.VIEW);
		uiWindow.show();


		//获取返回的 物料明细
		Map<String,SettlePolicyPriceEntryInfo> uiMap = (Map<String, SettlePolicyPriceEntryInfo>) uiWindow.getUIObject().getUIContext().get("matEntry");

		//获取选中行
		List<Integer> selectList = new ArrayList<Integer>();
		selectList = getSelectList();
		System.out.println(selectList);
		String billid = null;
		for(int i=0,size=selectList.size();i<size;i++){
			//根据返回的Map，后台更新或者插入结算政策的投入政策分录信息
			billid = tblMain.getCell(selectList.get(i),"id").getValue().toString();
			SettlePolicyInfo settleInfo = SettlePolicyFactory.getRemoteInstance().getSettlePolicyInfo(new ObjectUuidPK(billid));
			SettlePolicyPriceEntryCollection entryColl = settleInfo.getPriceEntry();
			SettlePolicyPriceEntryInfo entryInfo = null;
			//添加投入政策分录信息到Map中
			Map<String,String> entryMap = new HashMap<String,String>();
			for(int j = 0,size1 = entryColl.size();j<size1;j++){
				entryInfo = entryColl.get(j);
				entryMap.put(entryInfo.getMaterial().getId().toString(), entryInfo.getId().toString());
			}

			if(uiMap != null){
				//遍历uiMap
				Set<String> keySet = uiMap.keySet();
				Iterator<String> it = keySet.iterator();
				while(it.hasNext()){
					//物料id
					String matid = it.next();
					MaterialInfo matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(matid));
					SettlePolicyPriceEntryInfo uiEntryInfo = uiMap.get(matid);
					//如果entryMap中包含UImap的物料信息，就执行更新操作
					if(entryMap.containsKey(matid)){
						//获取entryMap物料对应的entryid
						String entryid = entryMap.get(matid);
						String s1 = "/*dialect*/ update T_FM_SettlePolicyPriceEntry set FBasePrice = "+uiEntryInfo.getBasePrice()+"  where fid = '"+entryid+"'";
						CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s1);
					}else{
						//如果entryMap中不包含UImap的物料信息，就执行插入操作--99E1A308
						if(uiEntryInfo.getSettlementItem() != null
								&& uiEntryInfo.getSettleItemType() != null){
							String s1 = "/*dialect*/ insert into T_FM_SettlePolicyPriceEntry (FID,FParentID,FMaterialID,FMaterialName,FModel,FUnitID,FSettlementItemID,CFSettleItemType,FBasePrice,CFOverRate)" +
							" values('"+BOSUuid.create("99E1A308")+"', " +
							" '"+billid+"',"+
							" '"+uiEntryInfo.getMaterial().getId().toString()+"',"+
							" '"+matInfo.getName()+"',"+
							" '"+UIRuleUtil.getString(matInfo.getModel())+"',"+
							" '"+uiEntryInfo.getUnit().getId().toString()+"',"+
							" '"+uiEntryInfo.getSettlementItem().getId().toString()+"', " +
							" '"+uiEntryInfo.getSettleItemType().getValue()+"', "+uiEntryInfo.getBasePrice()+" ," 
							+ uiEntryInfo.getOverRate()+")";
							CommFacadeFactory.getRemoteInstance().excuteUpdateSql(s1);
						}else{
							throw new EASBizException(new NumericExceptionSubItem("001","新增投入政策操作需要填写结算项目和结算项目类别！"));
							//						throw new Exception("新增投入政策操作需要填写结算项目和结算项目类别！");
							//						MsgBox.showWarning("新增投入政策操作需要填写结算项目和结算项目类别！");
							//						SysUtil.abort();
						}
					}
				}
			}



		}

	}

}