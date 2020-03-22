/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.data.event.RequestRowSetEvent;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIFrame;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.RegularExpressionUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.Person.IdcardInfoExtractor;
import com.kingdee.eas.custom.commld.Person.IdcardValidator;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.batchHandler.client.UIActionPostman;
import com.kingdee.eas.framework.util.UIConfigUtility;
import com.kingdee.eas.hr.rec.GenderEnum;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class FarmerQualicationApplEditUI extends AbstractFarmerQualicationApplEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmerQualicationApplEditUI.class);
	/**
	 * output class constructor
	 */
	public FarmerQualicationApplEditUI() throws Exception
	{
		super();
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.tBtnUnAudit.setEnabled(false);
		KDBizPromptBox kdtEntrys_farmGrop_PromptBox = new KDBizPromptBox(); 
		kdtEntrys_farmGrop_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmGroupQuery");
		kdtEntrys_farmGrop_PromptBox.setVisible(true);
		kdtEntrys_farmGrop_PromptBox.setEditable(true);
		kdtEntrys_farmGrop_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_farmGrop_PromptBox.setEditFormat("$number$");
		kdtEntrys_farmGrop_PromptBox.setCommitFormat("$number$");
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentCtrlUnit().getString("id"),CompareType.EQUALS));
		ev.setFilter(filter);
		kdtEntrys_farmGrop_PromptBox.setEntityViewInfo(ev);
		KDTDefaultCellEditor kdtEntrys_farmGrop_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmGrop_PromptBox);
		this.kdtFarmEntry.getColumn("farmGrop").setEditor(kdtEntrys_farmGrop_CellEditor); 
		ObjectValueRender kdtEntrys_farmGrop_OVR = new ObjectValueRender();
		kdtEntrys_farmGrop_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtFarmEntry.getColumn("farmGrop").setRenderer(kdtEntrys_farmGrop_OVR);

		// prmtfarmerGrop	
		SelectorListener[] ls = prmtfarmerGrop.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarmerGrop.removeSelectorListener(ls[i]);
		}
		this.prmtfarmerGrop.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerGroupQuery");		
		this.prmtfarmerGrop.setVisible(true);		
		this.prmtfarmerGrop.setEditable(true);		
		this.prmtfarmerGrop.setDisplayFormat("$name$");		
		this.prmtfarmerGrop.setEditFormat("$number$");		
		this.prmtfarmerGrop.setCommitFormat("$number$");	
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
		setFilter();
	}

	private void initControl() {
		// TODO Auto-generated method stub		
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}
		});
		setFilter();
	}

	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		FocusListener[] focusListeners = txtidentity.getListeners(FocusListener.class);
		for(int i=0;i<focusListeners.length;i++)
			txtidentity.removeFocusListener(focusListeners[i]);
		super.loadFields(); 
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
		if(this.editData.getFarmer()!=null) {
			this.actionUnAudit.setEnabled(false);
		}

		if(chkaddFarm.isSelected()){
			prmtfarmer.setEnabled(true);
			txtname.setEnabled(false);
		}else{
			prmtfarmer.setValue(null);
			prmtfarmer.setEnabled(false);
			txtname.setEnabled(true);
		}
		
		pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setGuaranty();
				setFilter();
			}
		});
		
		for(int i=0;i<focusListeners.length;i++)
			txtidentity.addFocusListener(focusListeners[i]);
		/**
		 * 身份证校验和相关信息带出
		 */
		txtidentity.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent paramFocusEvent) {
				txtidentity.setStringValue(txtidentity.getStringValue().trim());
				if(StringUtils.isNotEmpty(txtidentity.getStringValue())){
					if(txtidentity.getStringValue().length()!=15&&txtidentity.getStringValue().length()!=18){
						txtidentity.setStringValue(null);
						txtidentity.requestFocus();
						commUtils.giveUserTipsAndRetire("身份证号码有误，请重新输入");
					}
					String IDCardNo = txtidentity.getStringValue();
					IdcardValidator vr=new IdcardValidator();
					if(vr.is15Idcard(IDCardNo))
						IDCardNo=vr.convertIdcarBy15bit(IDCardNo);
					if(!vr.isValidate18Idcard(IDCardNo)){
						txtidentity.setStringValue(null);
						txtidentity.requestFocus();
						commUtils.giveUserTipsAndRetire("身份证号码有误，请重新输入正确的中华人民共和国境内身份证号码");
					}

					IdcardInfoExtractor ex=new IdcardInfoExtractor(txtidentity.getStringValue());
					txtage.setValue(ex.getAge());
					txtaddress.setStringValue(ex.getRegion());
					if(ex.getGender().equals("男"))
						sex.setSelectedItem(GenderEnum.male);
					else
						sex.setSelectedItem(GenderEnum.female);

					//重复性校验
					if(prmtcompany.getValue()==null)
						commUtils.giveUserTipsAndRetire("请先填写公司");
					String companyID = ((IPropertyContainer)prmtcompany.getValue()).getString("id");
					String str="select FIdentity from CT_FM_Farmer where FIdentity='"+txtidentity.getStringValue()+"' and FCompanyID='"+companyID+"'\n";
					str+="union all\n";
					str+="select FIdentity from CT_FM_FarmerQualicationAppl where FIdentity='"+txtidentity.getStringValue()+"' and FCompanyID='"+companyID+"'\n";
					if(editData.getId()!=null)
						str+="where FID<>'"+editData.getString("id")+"'";

					try {
						if(SQLExecutorFactory.getRemoteInstance(str).executeSQL().size()>0){
							txtidentity.setStringValue(null);
							txtidentity.requestFocus();
							commUtils.giveUserTipsAndRetire("该身份证号已被引用");
						}
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}super.focusLost(paramFocusEvent);
			}
		});

		/**
		 * 手机号检验
		 */
		txtmobileTel.addFocusListener(new FocusAdapter(){

			public void focusLost(FocusEvent paramFocusEvent) {
				// TODO Auto-generated method stub
				super.focusLost(paramFocusEvent);
				txtmobileTel.setStringValue(txtmobileTel.getStringValue().trim());
				if(StringUtils.isNotEmpty(txtmobileTel.getStringValue())){
					if(!RegularExpressionUtil.isChinaPhoneLegal(txtmobileTel.getStringValue())){
						txtmobileTel.setStringValue(null);
						txtmobileTel.requestFocus();
						commUtils.giveUserTipsAndRetire("手机号码有误，请重新输入正确的中华人民共和国境内手机号码");
					}
				}
			}
		});
		/*  if(chkisTemplate.isSelected()) {
        	kdtEntrys.setEnabled(true);
        	  this.kdtEntrys.getColumn("checkItem").getStyleAttributes().setLocked(false);
        }*/
		txtbankNo.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent paramFocusEvent) {
				// TODO Auto-generated method stub
				txtbankNo.setStringValue(txtbankNo.getStringValue().trim());
				super.focusLost(paramFocusEvent);
			}});

		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				farmer_changed();
			}
		});

		kdtFarmEntry_detailPanel.getRemoveLinesButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KDTSelectManager selectManager = kdtFarmEntry.getSelectManager();
				int size = selectManager.size();
				KDTSelectBlock selectBlock = null;
				Set indexSet = new HashSet();
				for (int blockIndex = 0; blockIndex < size; ++blockIndex) {
					selectBlock = selectManager.get(blockIndex);
					int top = selectBlock.getBeginRow();
					int bottom = selectBlock.getEndRow();
					if (kdtFarmEntry.getRow(top) == null) {
						MsgBox.showInfo(EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
						return;
					}
					for (int i = top; i <= bottom; ++i) {
						indexSet.add(new Integer(i));
					}
				}
				Integer[] indexArr = new Integer[indexSet.size()];
				Object[] indexObj = indexSet.toArray();
				System.arraycopy(indexObj, 0, indexArr, 0, indexArr.length);
				Arrays.sort(indexArr);
				if (indexArr == null)
					return;
				for (int i = indexArr.length - 1; i >= 0; --i) {
					int rowIndex = Integer.parseInt(String.valueOf(indexArr[i]));
					if(kdtFarmEntry.getCell(rowIndex, "farm").getValue()!=null){
						MsgBox.showWarning("养殖户原有养殖场不允许删除!");
						SysUtil.abort();
					}
				}
			}});

		chkaddFarm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chkaddFarm.isSelected()){
					prmtfarmer.setEnabled(true);
					txtname.setEnabled(false);
				}else{
					prmtfarmer.setValue(null);
					prmtfarmer.setEnabled(false);
					txtname.setEnabled(true);
				}
			}
		});

	}
	
	private void setGuaranty() {
		if(prmtfarmer.getValue()==null||pkBizDate.getValue()==null){
			prmtguaranty.setValue(null);
			return;
		}
		String id = ((IPropertyContainer)prmtfarmer.getValue()).getString("id");
		FarmerGuaranteeBillInfo guaranteeBill = StockingComm.getGuaranteeBill(null,id,(Date) pkBizDate.getValue());
		prmtguaranty.setValue(guaranteeBill);
	}

	private void farmer_changed() {
		// TODO Auto-generated method stub
		kdtFarmEntry.removeRows();
		if(prmtfarmer.getValue()!=null){
			String farmerID = ((IPropertyContainer)prmtfarmer.getValue()).getString("id");
			try {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("person.*");
				slor.add("BEBank.*");
				slor.add("FarmEntry.*");
				slor.add("FarmEntry.farm.*");
				slor.add("FarmEntry.farm.treeid.*");
				FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerID),slor);
				//填数吧 〒▽〒
				txtname.setText(farmer.getName());
				sex.setSelectedItem(farmer.getSex());
				txtidentity.setText(farmer.getIdentity());
				txtage.setValue(farmer.getAge());
				txtnation.setText(farmer.getNation());
				eduLvl.setSelectedItem(farmer.getEduLvl());
				txtfamilyPeronCount.setValue(farmer.getFamilyPersonCount());
				txtfarmActualName.setText(farmer.getFarmerActualName());
				prmttechnologyPerson.setValue(farmer.getPerson());
				txtmobileTel.setText(farmer.getMobileTel());
				txttel.setText(farmer.getTel());
				prmtfarmerGrop.setValue(farmer.getTreeid());
				txtaddress.setText(farmer.getAddress());
				prmtBEBank.setValue(farmer.getBEBank());
				txtbankNo.setText(farmer.getBankNo());
				txtbankAccountNo.setText(farmer.getBankNo());
				txtbankAddress.setText(farmer.getBankAddress());
				setGuaranty();
				for(int i=0;i<farmer.getFarmEntry().size();i++){
					FarmInfo farm = farmer.getFarmEntry().get(i).getFarm();
					IRow row = kdtFarmEntry.addRow();
					row.getCell("farm").setValue(farm);
					row.getCell("name").setValue(farm.getName());
					row.getCell("area").setValue(farm.getArea());
					row.getCell("floorArea").setValue(farm.getFloorArea());
					row.getCell("succahQty").setValue(farm.getSuccahQty());
					row.getCell("address").setValue(farm.getAddress());
					row.getCell("mileStd").setValue(farm.getMileStd());
					row.getCell("recyMiles").setValue(farm.getRecyMiles());
					row.getCell("mnemonicCode").setValue(farm.getMnemonicCode());
                    //设置养殖规模和养殖模式
					row.getCell("farmQty").setValue(farm.getGm());
					row.getCell("farmTypea").setValue(farm.getFaemsType());
                    //设置成本中心
					row.getCell("costCenter").setValue(farm.getCostCenter());
					
					row.getStyleAttributes().setLocked(true);
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//清数吧 〒▽〒
			txtname.setText(null);
			sex.setSelectedItem(null);
			txtidentity.setText(null);
			txtage.setValue(null);
			txtnation.setText(null);
			eduLvl.setSelectedItem(null);
			txtfamilyPeronCount.setValue(null);
			txtfarmActualName.setText(null);
			prmttechnologyPerson.setValue(null);
			txtmobileTel.setText(null);
			txttel.setText(null);
			prmtfarmerGrop.setValue(null);
			txtaddress.setText(null);
			prmtBEBank.setValue(null);
			txtbankNo.setText(null);
			txtbankAccountNo.setText(null);
			txtbankAddress.setText(null);
			prmtguaranty.setValue(null);
		}
		setFilter();
	}

	@Override
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAddNew_actionPerformed(e);
		setFilter();
	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		if(editData.getId()==null){
			super.actionPre_actionPerformed(e);
		}
	}

	@Override
	public void actionViewGuaranteeBill_actionPerformed(ActionEvent e)
	throws Exception {
		if(prmtguaranty.getValue()==null){
			MsgBox.showWarning("该单据未关联担保书!");
			SysUtil.abort();
		}
		String billID=((IPropertyContainer)prmtguaranty.getValue()).getString("id");
		UIContext uiContext = new UIContext(this);
		uiContext.put("ID", billID);
		IUIWindow uiWindow = null;
		if (SwingUtilities.getWindowAncestor(this) != null
				&& (SwingUtilities.getWindowAncestor(this) instanceof JDialog))
			uiWindow = UIFactory.createUIFactory(
			"com.kingdee.eas.base.uiframe.client.UIModelDialogFactory")
			.create("com.kingdee.eas.farm.carnivorous.basebiz.client.FarmerGuaranteeBillEditUI", uiContext, null, OprtState.VIEW);
		else
			uiWindow = UIFactory.createUIFactory(getEditUIModal()).create(
					"com.kingdee.eas.farm.carnivorous.basebiz.client.FarmerGuaranteeBillEditUI", uiContext, null, OprtState.VIEW);
		uiWindow.show();
	}

	protected String getEditUIModal() {
		String openModel = UIConfigUtility.getOpenModel();
		if (openModel != null)
			return openModel;
		else
			return "com.kingdee.eas.base.uiframe.client.UINewFrameFactory";
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(arg0);
	}
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}


	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		//加载模板
		if(SysContext.getSysContext().getCurrentFIUnit()!=null){
			FarmerQualicationApplInfo info=this.getDefaultData(SysContext.getSysContext().getCurrentFIUnit().getString("id"));
			if(info!=null) {
				objectValue=info;
				objectValue.setId(null);
				for(int index=0;index<objectValue.getEntrys().size();index++) {
					objectValue.getEntrys().get(index).setId(null);
				}
				for(int index=0;index<objectValue.getFarmEntry().size();index++) {
					objectValue.getFarmEntry().get(index).setId(null);
				}
			}
		}
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new java.util.Date());
		objectValue.setIsTemplate(false);
		objectValue.setBillStatus(BillBaseStatusEnum.ADD);
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}
	/**
	 * 获取默认的模板
	 * @param storageOrgUnit
	 * @return
	 */
	private FarmerQualicationApplInfo getDefaultData(String companyID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from CT_FM_FarmerQualicationAppl ");
			sql.append(" where FCompanyID='").append(companyID).append("'");
			sql.append(" and FIsTemplate=1");
			sql.append(" order by FCreateTime desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				return FarmerQualicationApplFactory.getRemoteInstance().getFarmerQualicationApplInfo(new ObjectUuidPK(rs.getString("fid")),getSelectors());

			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	private void setFilter() {
		String companyID=null;
		if(this.prmtcompany.getValue()!=null) {
			companyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentCtrlUnit().getString("id"),CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtFarmEntry.getColumn("farmGrop").getEditor().getComponent()).setEntityViewInfo(ev);

		EntityViewInfo ev2=new EntityViewInfo();
		FilterInfo filter2=new FilterInfo();
		filter2.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentCtrlUnit().getString("id"),CompareType.EQUALS));
		ev2.setFilter(filter2);
		this.prmtfarmerGrop.setEntityViewInfo(ev2);
		//养殖户过滤
		setFarmerFilter(prmtfarmer, companyID);
		prmtfarmer.setRequired(false);
		//养殖场过滤
		StockingComm.setFarmFilter((KDBizPromptBox)kdtFarmEntry.getColumn("farm").getEditor().getComponent(), companyID, null,null);
		//评定项目过滤
		StockingComm.setFarmingCheckItemFilter((KDBizPromptBox)kdtEntrys.getColumn("checkItem").getEditor().getComponent(), companyID);
		//养户类型过滤
		StockingComm.setFarmerTypeFilter(prmtfarmerType, companyID);
		//设置担保申请表过滤
		String farmerID="";
		if(prmtfarmer.getValue()!=null){
			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
		}
		Date bizDate=null;
		if(this.pkBizDate.getValue()!=null) {
			bizDate=(Date) pkBizDate.getValue();
		}
		StockingComm.setGuaranteeBillFilter(prmtguaranty, companyID,farmerID,bizDate);
	}

	/* 设置养殖户过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	private  void setFarmerFilter(KDBizPromptBox prmtfarmer,String companyID) {
		SelectorListener[] ls = prmtfarmer.getSelectorListeners();
		for(int i=0;i<ls.length;i++) {
			prmtfarmer.removeSelectorListener(ls[i]);
		}
		prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
		prmtfarmer.setEditable(true);		
		prmtfarmer.setDisplayFormat("$name$");		
		prmtfarmer.setEditFormat("$name$");		
		prmtfarmer.setCommitFormat("$number$;$name$");	
		prmtfarmer.setRequired(true);

		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(companyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.FROZEN_VALUE,CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("FarmEntry.seq",1,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filter);
		prmtfarmer.setEntityViewInfo(evi);
	}


	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);
	}	

	/**
	 * 根据编码或名称获取养殖场Info
	 * @param companyID
	 * @param number
	 * @param name
	 * @return
	 * @throws EASBizException 
	 */
	public static FarmInfo getFarmInfoByNumOrName(String companyID,String number,String name) throws EASBizException {
		if(StringUtils.isBlank(companyID)) {
			throw new EASBizException(new NumericExceptionSubItem("001","财务组织不能为空！"));
		}
		if(StringUtils.isBlank(number)&&StringUtils.isBlank(name)) {
			throw new EASBizException(new NumericExceptionSubItem("001","编码和名称不能同时为空！"));
		}
		try {
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.enable,CompareType.EQUALS));
			if(StringUtils.isNotBlank(number)) {
				filter.getFilterItems().add(new FilterItemInfo("number",number,CompareType.EQUALS));
			}
			if(StringUtils.isNotBlank(name)) {
				filter.getFilterItems().add(new FilterItemInfo("name",name,CompareType.EQUALS));
			}
			ev.setFilter(filter);
			FarmCollection col = FarmFactory.getRemoteInstance().getFarmCollection(ev);
			if(col!=null&&col.size()>0) {
				return col.get(0);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		if(chkonlyFarm.isSelected()){
			if(kdtFarmEntry.getRowCount()<=0){
				MsgBox.showWarning("未填写养殖场数据!");
				SysUtil.abort();
			}
			if(prmtfarmer.getValue()!=null){
				MsgBox.showWarning("仅新增养殖场不能选择养殖户!");
				SysUtil.abort();
			}
		}else{
			if(StringUtils.isBlank(txtname.getText())){
				MsgBox.showWarning("未填写养殖户姓名!");
				SysUtil.abort();
			}
//			if(sex.getSelectedItem()==null){
//				MsgBox.showWarning("未选择养殖户性别!");
//				SysUtil.abort();
//			}
			if(StringUtils.isBlank(txtidentity.getText())){
				MsgBox.showWarning("未填写身份证号码!");
				SysUtil.abort();
			}
			if(StringUtils.isBlank(txtmobileTel.getText())){
				MsgBox.showWarning("未填写手机号码!");
				SysUtil.abort();
			}
//			if(StringUtils.isBlank(txtbankNo.getText())){
//				MsgBox.showWarning("未填写银行账号!");
//				SysUtil.abort();
//			}
		}
		checkExistIdentityFarmer();
	}

	/**
	 * 检查是否存在身份证号的养殖户
	 * @return
	 * @throws BOSException 
	 */
	private boolean checkExistIdentityFarmer() throws BOSException {

		String identity=this.txtidentity.getText().trim();
		String name=this.txtname.getText().trim();
		if(prmtfarmer.getValue()!=null&&((FarmerInfo)prmtfarmer.getValue()).getIdentity().equals(identity)) {
			return false;
		}
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",((IPropertyContainer) this.prmtcompany.getValue()).getString("id"),CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("identity",identity,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("name",name,CompareType.EQUALS));
		ev.setFilter(filter);
		FarmerCollection col = FarmerFactory.getRemoteInstance().getFarmerCollection(ev);
		if(col!=null&&col.size()>0) {
			//				if(this.editData.getFarmer()!=null&&this.editData.getFarmer().getId().equals(col.get(0).getId())) {
			//					
			//				}else {
			MsgBox.showWarning("相同\"姓名+身份证号\"的养殖户已经存在,不允许重复申请！");
			SysUtil.abort();
			//				}
		}
		return false;
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
			}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBillStatus(BillBaseStatusEnum.ADD);
		//        editData.setNumber(null);
		editData.setFarmer(null);
		editData.setBizDate(new java.util.Date());
		editData.setFarmer(null);
		editData.getEntrys().clear();
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();

		setMakeRelations(null);
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(!this.chkisTemplate.isSelected()) {//不可见，非m模板
			super.beforeStoreFields(arg0);
		}
		//		if(this.kdtFarmEntry.getRowCount()<=0) {
		//			MsgBox.showWarning("养殖场信息不能为空！");
		//			SysUtil.abort();
		//		}
	}
}