/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.basedata.org.client.f7.CostCenterF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.KDTableUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FarmersAllEditUI extends AbstractFarmersAllEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmersAllEditUI.class);
    private BaseSysSettingInfo sysSetting;
    private  IUIWindow iUIFarm=null;
    /**
     * output class constructor
     */
    public FarmersAllEditUI() throws Exception
    {
        super();
        kdtFarmEntry.checkParsed();
    }

    @Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	storeFields();
    	super.actionCancel_actionPerformed(e);
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		storeFields();
		super.actionCancelCancel_actionPerformed(e);
	}
	
	

	@Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
		kdtFarmEntry.getSelectManager().select(0,0,0,0);
		try {
			addFarmPanel();
		} catch (BOSException e) {
			handleException(e);
		}
	}
    
    
    
    @Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionEdit_actionPerformed(e);
		addFarmPanel();
	}
    
	/**
	 * 添加 养殖场页签
	 */
	public void addFarmPanel() throws BOSException {
		for(int i=0;i<kDPanelFarm.getComponentCount();) {
			kDPanelFarm.remove(i);
		}
		try {
			String farmID=null;
			iUIFarm=null;
			int rowIndex=kdtFarmEntry.getSelectManager().get().getBeginRow();
			if(rowIndex>=0&&kdtFarmEntry.getCell(KDTableUtil.getSelectedRow(kdtFarmEntry),"farm").getValue()!=null) {
				farmID=((IPropertyContainer) kdtFarmEntry.getCell(rowIndex,"farm").getValue()).getString("id");
			}
			Map uiContext = new HashMap();
			
			String oprt = OprtState.ADDNEW;
			if(StringUtils.isNotEmpty(farmID)) {
				uiContext.put("ID", farmID);
				oprt = oprtState;
			}
			// uiContext.put("InitDataObject", boarInfo);
			iUIFarm = UIFactory.createUIFactory().create("com.kingdee.eas.farm.stocking.basedata.client.FarmEditUI",
							uiContext, null,oprt );
			// 设置布局
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(5);
			kDPanelFarm.setLayout(borderLayout);
			// 设置 工具栏
			Container con = iUIFarm.getUIObject().getUIContentPane();
			kDPanelFarm.add(con, "Center");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmersFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FarmersInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmersInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBaseStatus(FarmBaseStatusEnum.unApprove);
        return objectValue;
    }
    @Override
	protected void setFieldsNull(AbstractObjectValue arg0) {
		// TODO Auto-generated method stub
		super.setFieldsNull(arg0);
		arg0.put("baseStatus",new Integer(1));
	}
	@Override
	public void storeFields() {
		// TODO Auto-generated method stub
		super.storeFields();
		if(iUIFarm!=null) {
			iUIFarm.getUIObject().storeFields();
			this.editData.put("nowFarmInfo", iUIFarm.getUIObject().getDataObject());
		}else {
			this.editData.put("nowFarmInfo", null);
		}
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
	}
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.put("baseStatus", FarmBaseStatusEnum.UNAPPROVE_VALUE);
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}
    
	@Override
	protected void doAfterSave(IObjectPK pk) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterSave(pk);
	}

	@Override
	protected void doAfterSubmit(IObjectPK pk) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterSubmit(pk);
	}

	private void initControl() {
		this.setUITitle("养殖场场长");
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		//内部管理
		if(sysSetting.isIsInner()) {
			this.contsupplier.setVisible(false);
			this.contcostCenter.setVisible(true);
			if(sysSetting.getAccountType().equals(AccountTypeEnum.farmer)) {
				contcostCenter.setVisible(true);
			}else{
				contcostCenter.setVisible(false);
			}
		}else{
			this.contsupplier.setVisible(true);
			this.contcostCenter.setVisible(false);;
		}
		//		OrgF7 of7=new OrgF7();
////		of7.setIsCUFilter(true);
//		of7.setContainSealUp(true);
//		of7.setIsShowContainSealUp(true);
//		of7.setIsShowSub(true);
//		of7.setShowVirtual(true);
//		of7.setShowAssistantOrg(true);
////		of7.set
//		of7.setOrgTypes(new OrgType[]{OrgType.});
//		this.prmtcostCenter.setSelector(of7);
		
		CostCenterF7 cf7=new CostCenterF7();
		cf7.setIsCUFilter(true);
		this.prmtcostCenter.setSelector(cf7);
		
		
		prmtfarmersTree.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
		prmtfarmersTree.setVisible(true);
		prmtfarmersTree.setEditable(false);
		prmtfarmersTree.setDisplayFormat("$name$");
		prmtfarmersTree.setEditFormat("$name$");
		prmtfarmersTree.setCommitFormat("$name$");
		
		   this.kdtFarmEntry.checkParsed();
	        KDFormattedTextField kdtFarmEntry_seq_TextField = new KDFormattedTextField();
	        kdtFarmEntry_seq_TextField.setName("kdtFarmEntry_seq_TextField");
	        kdtFarmEntry_seq_TextField.setVisible(true);
	        kdtFarmEntry_seq_TextField.setEditable(true);
	        kdtFarmEntry_seq_TextField.setHorizontalAlignment(2);
	        kdtFarmEntry_seq_TextField.setDataType(0);
	        KDTDefaultCellEditor kdtFarmEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_seq_TextField);
	        this.kdtFarmEntry.getColumn("seq").setEditor(kdtFarmEntry_seq_CellEditor);
	        final KDBizPromptBox kdtFarmEntry_farm_PromptBox = new KDBizPromptBox();
	        kdtFarmEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
	        kdtFarmEntry_farm_PromptBox.setVisible(true);
	        kdtFarmEntry_farm_PromptBox.setEditable(true);
	        kdtFarmEntry_farm_PromptBox.setDisplayFormat("$number$");
	        kdtFarmEntry_farm_PromptBox.setEditFormat("$number$");
	        kdtFarmEntry_farm_PromptBox.setCommitFormat("$number$");
	        KDTDefaultCellEditor kdtFarmEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farm_PromptBox);
	        this.kdtFarmEntry.getColumn("farm").setEditor(kdtFarmEntry_farm_CellEditor);
	        ObjectValueRender kdtFarmEntry_farm_OVR = new ObjectValueRender();
	        kdtFarmEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
	        this.kdtFarmEntry.getColumn("farm").setRenderer(kdtFarmEntry_farm_OVR);
	        			kdtFarmEntry_farm_PromptBox.addSelectorListener(new SelectorListener() {
				com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtFarmEntry_farm_PromptBox_F7ListUI = null;
				public void willShow(SelectorEvent e) {
					if (kdtFarmEntry_farm_PromptBox_F7ListUI == null) {
						try {
							kdtFarmEntry_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						HashMap ctx = new HashMap();
						ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFarmEntry_farm_PromptBox_F7ListUI));
						kdtFarmEntry_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
						kdtFarmEntry_farm_PromptBox.setSelector(kdtFarmEntry_farm_PromptBox_F7ListUI);
					}
				}
			});
	        			
	      this.kdtFarmEntry.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent arg0) {
				try {
					addFarmPanel();
				} catch (BOSException e) {
					handleException(e);
				}
			}});
		
	}
	
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		storeFields();
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);
		
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		storeFields();
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
		  checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
		  IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
		  if (objectValue != null)
		  {
		    try
		    {
		      String id = this.idList.getID(this.idList.getCurrentIndex());
		      setOprtState("RELEASEALL");
		      pubFireVOChangeListener(id);
		    }
		    catch (Throwable E) {
		    }
		  }
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");
		

		this.editData.setBaseStatus(null);
		
		setDataObject(this.editData);
//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		//内部管理
		if(sysSetting.isIsInner()) {
			if(this.prmtcostCenter.getValue()==null) {
				MsgBox.showWarning("成本中心不能为空！");
				SysUtil.abort();
			}
		}else{
			if(this.prmtsupplier.getValue()==null) {
				MsgBox.showWarning("客户和供应商不能为空！");
				SysUtil.abort();
			}
		}
	}
}