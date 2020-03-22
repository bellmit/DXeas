package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JToolBar;

import org.apache.log4j.Logger;

import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.kdf.data.event.RequestRowSetEvent;
import com.kingdee.bos.ctrl.print.IPrintActionListener;
import com.kingdee.bos.ctrl.print.KDPrinter;
import com.kingdee.bos.ctrl.swing.KDPanel;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ObjectNotFoundException;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.ItemAction;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.commonquery.QueryPanelCollection;
import com.kingdee.eas.base.commonquery.QueryPanelInfo;
import com.kingdee.eas.base.commonquery.QuerySolutionInfo;
import com.kingdee.eas.base.commonquery.XMLBean;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.commonquery.client.CustomerParams;
import com.kingdee.eas.base.commonquery.client.CustomerQueryPanel;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.scm.common.client.BDInvClientUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.custom.salediscount.IDiscountSet;
import com.kingdee.eas.framework.FrameWorkException;
import com.kingdee.eas.framework.FrameWorkUtils;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.scm.common.client.SCMGroupClientUtils;
import com.kingdee.eas.scm.common.client.SCMPromptBoxFactory;
import com.kingdee.eas.tools.datatask.DatataskParameter;
import com.kingdee.eas.tools.datatask.client.DatataskCaller;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

public class DiscountSetListUI extends AbstractDiscountSetListUI
{
  private static final Logger logger = CoreUIObject.getLogger(DiscountSetListUI.class);

  private int importInfoIndex = 0;
  private static final String RESOURCE = "com.kingdee.eas.custom.salediscount.client.DiscountSet";
  CommonQueryDialog conditionDialog = null;

  DiscountSetQueryUI conditionPanel = null;

  public DiscountSetListUI()
    throws Exception
  {
	  
    initActionState();
    
    initUiCompanent();
    
//    mainQueryPK = new MetaDataPK("com.kingdee.eas.basedata.scm.sd.sale.app", "PricePolicyQuery");
    mainQueryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");
//    discountSetQueryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");
  }

  /**
   * 界面组件初始化
   */
  private void initUiCompanent(){
	  this.setUITitle("折让政策");
  }
  private void initActionState() {
    this.actionAudit.setEnabled(true);
    this.actionUnAudit.setEnabled(true);
    this.actionBlock.setEnabled(true);
    this.actionUnBlock.setEnabled(true);
    this.actionRemove.setEnabled(true);
    this.btnAudit.setText(EASResource.getString(RESOURCE, "audit"));
    this.btnAudit.setToolTipText(EASResource.getString(RESOURCE, "auditTooltip"));

    this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));

    this.btnUnAudit.setText(EASResource.getString(RESOURCE, "unAudit"));
    this.btnUnAudit.setToolTipText(EASResource.getString(RESOURCE, "unAuditTooltip"));

    this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));

    this.btnBlocked.setText(EASResource.getString(RESOURCE, "blocked"));
    this.btnBlocked.setToolTipText(EASResource.getString(RESOURCE, "blockedTooltip"));

    this.btnBlocked.setIcon(EASResource.getIcon("imgTbtn_forbid"));

    this.btnUnBlocked.setText(EASResource.getString(RESOURCE, "unBlocked"));
    this.btnUnBlocked.setToolTipText(EASResource.getString(RESOURCE, "unBlockedTooltip"));

    this.btnUnBlocked.setIcon(EASResource.getIcon("imgTbtn_staruse"));

    this.menuItemAudit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
    this.menuItemUnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
    this.menuItemBlock.setIcon(EASResource.getIcon("imgTbtn_forbid"));
    this.menuItemUnBlock.setIcon(EASResource.getIcon("imgTbtn_staruse"));
  }

  private void changeActionStateBySltRecord() {
    checkSelected();
  }

  public void loadFields()
  {
    super.loadFields();

    initActionState();
  }

  public void storeFields()
  {
    super.storeFields();
  }

  protected String getEditUIName()
  {
    return DiscountSetEditUI.class.getName();
  }

  protected ICoreBase getBizInterface()
    throws Exception
  {
    return DiscountSetFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
  }

  public void actionAudit_actionPerformed(ActionEvent e)
    throws Exception
  {
    checkSelected();
    int isYes = MsgBox.showConfirm2(this, EASResource.getString(RESOURCE, "auditAlert"));

    if (!(MsgBox.isYes(isYes))) {
      return;
    }
    ArrayList aids = getSelectedIdValues();
    String[] IDs = (String[])aids.toArray(new String[0]);
    IObjectPK[] pks = new ObjectUuidPK[IDs.length];
    for (int i = 0; i < pks.length; ++i) {
      pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
    }
    ((IDiscountSet)getBizInterface()).audit(pks);

    DiscountSetCache.clearCache();
    MsgBox.showInfo(this, EASResource.getString(RESOURCE, "auditSuccess"));
    refreshList();
  }

  public void actionUnAudit_actionPerformed(ActionEvent e)
    throws Exception
  {
    checkSelected();
    int isYes = MsgBox.showConfirm2(this, EASResource.getString(RESOURCE, "unauditAlert"));

    if (!(MsgBox.isYes(isYes)))
      return;
    ArrayList aids = getSelectedIdValues();
    String[] IDs = (String[])aids.toArray(new String[0]);
    IObjectPK[] pks = new ObjectUuidPK[IDs.length];
    for (int i = 0; i < pks.length; ++i) {
      pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
    }

    ((IDiscountSet)getBizInterface()).unAudit(pks);

    DiscountSetCache.clearCache();
    MsgBox.showInfo(this, EASResource.getString(RESOURCE, "unauditSuccess"));

    refreshList();
  }

  public void actionBlock_actionPerformed(ActionEvent e)
    throws Exception
  {
    checkSelected();
    int isYes = MsgBox.showConfirm2(this, EASResource.getString(RESOURCE, "blockAlert"));

    if (!(MsgBox.isYes(isYes)))
      return;
    ArrayList aids = getSelectedIdValues();
    String[] IDs = (String[])aids.toArray(new String[0]);
    IObjectPK[] pks = new ObjectUuidPK[IDs.length];
    for (int i = 0; i < pks.length; ++i) {
      pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
    }

    ((IDiscountSet)getBizInterface()).block(pks);

    DiscountSetCache.clearCache();

    MsgBox.showInfo(this, EASResource.getString(RESOURCE, "blockSuccess"));
    refreshList();
  }

  public void actionUnBlock_actionPerformed(ActionEvent e)
    throws Exception
  {
    checkSelected();

    int isYes = MsgBox.showConfirm2(this, EASResource.getString(RESOURCE, "unblockAlert"));

    if (!(MsgBox.isYes(isYes))) {
      return;
    }
    ArrayList aids = getSelectedIdValues();
    String[] IDs = (String[])aids.toArray(new String[0]);
    IObjectPK[] pks = new ObjectUuidPK[IDs.length];
    for (int i = 0; i < pks.length; ++i) {
      pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
    }

    ((IDiscountSet)getBizInterface()).unBlock(pks);

    DiscountSetCache.clearCache();
    MsgBox.showInfo(this, EASResource.getString(RESOURCE, "unblockSuccess"));

    refreshList();
  }

  public void actionEdit_actionPerformed(ActionEvent e)
    throws Exception
  {
    checkSelected();

    ArrayList sids = getSelectedIdValues();
    if (sids != null) {
      int size = sids.size();
      boolean flag = false;
      for (int i = 0; i < size; ++i) {
        if (((IDiscountSet)getBizInterface()).isCanDelete((String)sids.get(i)))
          continue;
        MsgBox.showInfo(this, EASResource.getString(RESOURCE, "auditcannotedit"));

        SysUtil.abort();
      }
    }

    super.actionEdit_actionPerformed(e);
  }

  public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
    checkSelected();

    ArrayList sids = getSelectedIdValues();
    if (sids != null) {
      int size = sids.size();
      boolean flag = false;
      for (int i = 0; i < size; ++i) {
    	  
    	  boolean isUsed = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed((String)sids.get(i), "");
			if(isUsed){
				MsgBox.showInfo("已经被使用的政策不能删除，操作中断");
				return;
			}
    	  
        if (((IDiscountSet)getBizInterface()).isCanDelete((String)sids.get(i)))
          continue;
        MsgBox.showInfo(this, EASResource.getString(RESOURCE, "auditcannotDel"));

        SysUtil.abort();
      }

    }

    actionRemove_actionPerformed1(e);
  }

  public void actionRemove_actionPerformed1(ActionEvent e) throws Exception
  {
    checkSelected();
    if (!(confirmRemove()))
      return;
    try {
      setOprtState("REMOVE");
      pubFireVOChangeListener(getSelectedKeyValue());
    } catch (Throwable ex) {
      handUIException(ex);
      abort();
    }
    try {
      ArrayList aids = getSelectedIdValues();
      String[] IDs = (String[])aids.toArray(new String[0]);
      IObjectPK[] pks = new ObjectUuidPK[IDs.length];
      for (int i = 0; i < pks.length; ++i) {
        pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
      }
      getBizInterface().delete(pks);
      pubFireVOChangeListener(getSelectedKeyValue());
    } catch (ObjectNotFoundException onfe) {
      onfe.printStackTrace();
      refreshList();
      throw new EASBizException(EASBizException.CHECKEXIST);
    } catch (Throwable e1) {
      e1.printStackTrace();
      handUIException(e1);
      abort();
    } finally {
      try {
        pubFireVOChangeListener(getSelectedKeyValue());
      }
      catch (Throwable e1) {
        e1.printStackTrace();
      }
    }

    refresh(e);
  }

  public void initUIMenuBarLayout()
  {
    this.menuBar.add(this.menuFile);
    this.menuBar.add(this.menuEdit);
    this.menuBar.add(this.menuView);
    this.menuBar.add(this.menuBiz);
    this.menuBar.add(this.menuHelp);

    this.menuFile.add(this.menuItemAddNew);

    this.menuFile.add(this.menuImportData);
    this.menuImportData.add(this.menuItemImportCustomerMaterial);
    this.menuImportData.add(this.menuItemImportCustomerMaterialGroup);
    this.menuImportData.add(this.menuItemImportCustomerGroupMaterial);
    this.menuImportData.add(this.menuItemImportCustomerGroupMaterialGroup);

    this.menuFile.add(this.menuExportData);
    this.menuExportData.add(this.menuItemExportCustomerMaterial);
    this.menuExportData.add(this.menuItemExportCustomerMaterialGroup);
    this.menuExportData.add(this.menuItemExportCustomerGroupMaterial);
    this.menuExportData.add(this.menuItemExportCustomerGroupMaterialGroup);

    this.menuItemExportCustomerGroupMaterialGroup.setEnabled(true);

    this.menuFile.add(this.kDSeparator1);
    this.menuFile.add(this.menuItemPageSetup);
    this.menuFile.add(this.menuItemPrint);
    this.menuFile.add(this.menuItemPrintPreview);
    this.menuFile.add(this.kDSeparator2);
    this.menuFile.add(this.menuItemExitCurrent);

    this.menuEdit.add(this.menuItemEdit);
    this.menuEdit.add(this.menuItemRemove);
    this.menuEdit.add(this.kDSeparator3);
    this.menuEdit.add(this.menuItemAudit);
    this.menuEdit.add(this.menuItemUnAudit);
    this.menuEdit.add(this.kDSeparator4);
    this.menuEdit.add(this.menuItemBlock);
    this.menuEdit.add(this.menuItemUnBlock);

    this.menuView.add(this.menuItemView);
    this.menuView.add(this.menuItemLocate);
    this.menuView.add(this.kDSeparator5);
    this.menuView.add(this.menuItemQuery);
    this.menuView.add(this.menuItemRefresh);

    this.menuHelp.add(this.menuItemHelp);
    this.menuHelp.add(this.kDSeparator12);
    this.menuHelp.add(this.menuItemAbout);

    this.menuBiz.add(this.menuItemCancelCancel);
    this.menuBiz.add(this.menuItemCancel);
    this.menuBiz.add(this.menuItemVoucher);
    this.menuBiz.add(this.menuItemDelVoucher);
    this.menuBiz.add(this.menuItemAudit);
    this.menuBiz.add(this.menuItemUnAudit);
    this.menuBiz.add(this.menuItemBlock);
    this.menuBiz.add(this.menuItemUnBlock);
  }

  public void initUIToolBarLayout()
  {
    this.toolBar.add(this.btnAddNew);
    this.toolBar.add(this.btnView);
    this.toolBar.add(this.btnEdit);
    this.toolBar.add(this.btnRemove);
    this.toolBar.add(this.btnRefresh);
    this.toolBar.add(this.btnQuery);
    JToolBar.Separator separator1 = new JToolBar.Separator();
    separator1.setOrientation(1);
    this.toolBar.add(this.btnLocate);
    this.toolBar.add(separator1);
    this.toolBar.add(this.btnPrint);
    this.toolBar.add(this.btnPrintPreview);
    this.toolBar.add(this.btnPageSetup);

    JToolBar.Separator separator2 = new JToolBar.Separator();
    separator2.setOrientation(1);
    this.toolBar.add(separator2);

    this.toolBar.add(this.btnAudit);
    this.toolBar.add(this.btnUnAudit);
    this.toolBar.add(this.btnBlocked);
    this.toolBar.add(this.btnUnBlocked);
  }

  public void actionPrint_actionPerformed(ActionEvent e)
    throws Exception
  {
    print(false);
  }

  public void actionPrintPreview_actionPerformed(ActionEvent e)
    throws Exception
  {
    print(true);
  }

  private void print(boolean isPreview) {
    preparePrintPage(this.tblMain);
    KDPrinter printer = this.tblMain.getPrintManager().getNewPrintManager().getPrinter();

    PrintListener printListener = new PrintListener();
    printer.addPrintActionListener(printListener);
    if (isPreview)
      this.tblMain.getPrintManager().printPreview();
    else
      this.tblMain.getPrintManager().print();
    printer.removePrintActionListener(printListener);
  }

  public void actionImportData_actionPerformed(ActionEvent e)
    throws Exception
  {
    super.actionImportData_actionPerformed(e);
  }

  public void actionExportData_actionPerformed(ActionEvent e) throws Exception
  {
    super.actionExportData_actionPerformed(e);
  }

  public String getExportQueryInfo(Context ctx)
  {
    return "com.kingdee.eas.custom.salediscount.app.DiscountSetQuery";
  }

  public void actionImportCustomerGroupMaterial_actionPerformed(ActionEvent e)
    throws Exception
  {
    this.importInfoIndex = 2;
    importData();

    actionRefresh_actionPerformed(e);
  }

  public void actionImportCustomerGroupMaterialGroup_actionPerformed(ActionEvent e)
    throws Exception
  {
    this.importInfoIndex = 3;
    importData();

    actionRefresh_actionPerformed(e);
  }

  public void actionImportCustomerMaterial_actionPerformed(ActionEvent e)
    throws Exception
  {
    this.importInfoIndex = 0;
    importData();

    actionRefresh_actionPerformed(e);
  }

  public void actionImportCustomerMaterialGroup_actionPerformed(ActionEvent e)
    throws Exception
  {
    this.importInfoIndex = 1;
    importData();

    actionRefresh_actionPerformed(e);
  }

  public void onLoad() throws Exception {
    super.onLoad();
    this.tblMain.getColumn("number").getStyleAttributes().setHided(false);
//    this.tblMain.getColumn("isEnableAim").getStyleAttributes().setHided(true);
  }

  private void importData()
    throws Exception
  {
    DatataskCaller task = new DatataskCaller();
    task.setParentComponent(this);
    if (getImportParam() != null)
      task.invoke(getImportParam(), 0, true, true);
  }

  protected OrgType getMainBizOrgType()
  {
    return OrgType.Sale;
  }

  protected String getPropertyOfBizOrg(OrgType orgType)
  {
    if (orgType.equals(OrgType.Sale)) {
      return "saleOrgUnit.id";
    }
    return null;
  }

  public KDPanel getConditionPanel() throws Exception {
    if (this.conditionPanel == null) {
      this.conditionPanel = new DiscountSetQueryUI();
    }
    return this.conditionPanel;
  }

  protected CustomerQueryPanel getFilterUI() throws Exception {
    if (this.conditionPanel == null) {
      this.conditionPanel = new DiscountSetQueryUI();
    }
    return this.conditionPanel;
  }

  public CommonQueryDialog initCommonQueryDialog()
  {
    if (this.conditionDialog == null) {
      if (this.mainQuery == null) {
        this.mainQuery = new EntityViewInfo();
      }
      this.conditionDialog = super.initCommonQueryDialog();
      this.conditionDialog.setWidth(450);
      this.conditionDialog.setHeight(310);
      try {
        SCMPromptBoxFactory scmF7Factory = new SCMPromptBoxFactory(getFilterUI(), getMainBizOrgType());
        this.conditionDialog.setPromptBoxFactory(scmF7Factory);

        this.conditionDialog.addUserPanel(getFilterUI());
      } catch (Exception e) {
        handUIException(e);
        SysUtil.abort();
      }
    }
    return this.conditionDialog;
  }

  protected List getMainBizOrgs(QuerySolutionInfo solution)
  {
    List list = new ArrayList();

    if (solution != null) {
      OrgUnitInfo[] orgUnitInfos = getMainOrgFromSolution(solution);

      if ((orgUnitInfos != null) && (orgUnitInfos.length >= 1)) {
        getUIContext().put(getMainBizOrgType(), orgUnitInfos[0]);
        list.add(orgUnitInfos[0].getId().toString());
      }
      else
      {
        getUIContext().put(getMainBizOrgType(), null);

        if (getMainOrgContext() != null) {
          FrameWorkUtils.setCurrentOrgUnit(getMainOrgContext(), null);
        }
      }
    }
    else if (getUIContext().get(getMainBizOrgType()) != null) {
      list.add(((OrgUnitInfo)getUIContext().get(getMainBizOrgType())).getId());
    }

    return list;
  }

  private OrgUnitInfo[] getMainOrgFromSolution(QuerySolutionInfo solution) {
    String key = getPropertyOfBizOrg(getMainBizOrgType());
    if ((solution != null) && (key != null)) {
      QueryPanelCollection queryPanelCollection = solution.getQueryPanelInfo();
      int size = queryPanelCollection.size();
      for (int i = 0; i < size; ++i) {
        QueryPanelInfo queryPanelInfo = queryPanelCollection.get(i);
        if ((queryPanelInfo.getPanelClassName() == null) || (queryPanelInfo.getPanelClassName().equalsIgnoreCase("com.kingdee.eas.base.commonquery.client.CommonFilterPanel")) || (queryPanelInfo.getPanelClassName().equalsIgnoreCase("com.kingdee.eas.base.commonquery.client.CommonSorterPanel"))) {
          continue;
        }

        String params = queryPanelInfo.getCustomerParams();
        if (params != null) {
          ArrayList al = new ArrayList();
          CustomerParams cp = new CustomerParams();
          try {
            al = XMLBean.TransStrToAL(params);
            Iterator j = al.iterator();
            XMLBean xb = new XMLBean();

            while (j.hasNext()) {
              xb = (XMLBean)j.next();
              cp.addCustomerParam(xb.getName(), xb.getValue());
            }

            String orgs = cp.getCustomerParam(key);
            if (orgs != null)
              return SCMGroupClientUtils.getOrgUnitInfos(orgs);
          }
          catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

    }

    return null;
  }

  protected IObjectPK getOrgPK(ItemAction action)
  {
    IObjectPK pk = null;
    if ((getMainOrgContext() != null) && (getMainOrgContext().get(getMainBizOrgType()) != null))
    {
      pk = new ObjectStringPK(((OrgUnitInfo)getMainOrgContext().get(getMainBizOrgType())).getId().toString());
    }

    return pk;
  }

  protected void tblMain_doRequestRowSet(RequestRowSetEvent e)
  {
    if (getUIContext().get(getMainBizOrgType()) == null)
      return;
    super.tblMain_doRequestRowSet(e);
  }

  public void actionExportCustomerGroupMaterial_actionPerformed(ActionEvent e)
    throws Exception
  {
    this.importInfoIndex = 2;
    ExportData();
  }

  public void actionExportCustomerGroupMaterialGroup_actionPerformed(ActionEvent e) throws Exception
  {
    this.importInfoIndex = 3;
    ExportData();
  }

  public void actionExportCustomerMaterial_actionPerformed(ActionEvent e) throws Exception
  {
    this.importInfoIndex = 0;
    ExportData();
  }

  public void actionExportCustomerMaterialGroup_actionPerformed(ActionEvent e) throws Exception
  {
    this.importInfoIndex = 1;
    ExportData();
  }

  protected ArrayList getImportParam()
  {
    DatataskParameter param = new DatataskParameter();

    switch (this.importInfoIndex)
    {
    case 0:
      String solutionName = "eas.scm.scmbd.DiscountSet_Customer_Material";
      param.solutionName = solutionName;
      break;
    case 1:
       solutionName = "eas.scm.scmbd.DiscountSet_Customer_MaterialGroup";
      param.solutionName = solutionName;
      break;
    case 2:
       solutionName = "eas.scm.scmbd.DiscountSet_CustomerGroup_Material";
      param.solutionName = solutionName;
      break;
    case 3:
       solutionName = "eas.scm.scmbd.DiscountSet_CustomerGroup_MaterialGroup";
      param.solutionName = solutionName;
    }

    param.alias = EASResource.getString(RESOURCE, "DiscountSet");
    param.datataskMode = 0;

    ArrayList paramList = new ArrayList();
    paramList.add(param);
    return paramList;
  }

  protected ArrayList getExportParam()
  {
    UserInfo currentUser = SysContext.getSysContext().getCurrentUserInfo();

    DatataskParameter param = new DatataskParameter();

    String solutionName = null;

    switch (this.importInfoIndex)
    {
    case 0:
      solutionName = "eas.scm.scmbd.DiscountSet_Customer_Material";
      param.solutionName = solutionName;
      break;
    case 1:
      solutionName = "eas.scm.scmbd.DiscountSet_Customer_MaterialGroup";
      param.solutionName = solutionName;
      break;
    case 2:
      solutionName = "eas.scm.scmbd.DiscountSet_CustomerGroup_Material";
      param.solutionName = solutionName;
      break;
    case 3:
      solutionName = "eas.scm.scmbd.DiscountSet_CustomerGroup_MaterialGroup";
      param.solutionName = solutionName;
    }

    param.alias = EASResource.getString(RESOURCE, "DiscountSet");
    param.solutionName = solutionName;
    param.datataskMode = 1;

    param.varList = new ArrayList();

    ArrayList paramList = new ArrayList();
    paramList.add(param);

    return paramList;
  }

  private void ExportData()
    throws Exception
  {
    ArrayList para = getExportParam();
    if ((para == null) || (para.size() <= 0)) {
      throw new FrameWorkException(FrameWorkException.EXPORTDATAPARANULL);
    }

    Object tmp = para.get(0);
    if (tmp instanceof DatataskParameter) {
      DatataskParameter dp = (DatataskParameter)tmp;
      MetaDataPK queryPK = null;
      switch (this.importInfoIndex)
      {
      case 0:
        queryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");

        break;
      case 1:
        queryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");

        break;
      case 2:
        queryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");

        break;
      default:
        queryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");
      }

      EntityViewInfo viewInfo = this.mainQuery;
      dp.putContextParam("mainQueryPK", queryPK);
      dp.putContextParam("mainQuery", viewInfo);
    }

    DatataskCaller dc = new DatataskCaller();
    dc.setParentComponent(this);
    dc.invoke(para, 1);
  }
  /**
   * 获得合并列
   */
  public String[] getMergeColumnKeys()
  {
	  return super.getMergeColumnKeys();
//      return new String[] {"number",
//    		  "name",
//    		  "discountType",
//    		  "saleOrgUnit.number",
//    		  "saleOrgUnit.name",
//    		  "blockedStatus",
//    		  "checkedStatus",
//    		  "effectiveDate",
//    		  "expireDate",
//    		  "auditDate"};
  }
  protected boolean isIgnoreCUFilter()
  {
    return true;
  }

  protected boolean initDefaultFilter() {
    return true;
  }

  class PrintListener
    implements IPrintActionListener
  {
    public void beforePrintOrPreview()
    {
    }

    public void beforePreview()
    {
    }

    public void beforePrint()
    {
      BDInvClientUtils.logUIOperation("LOG_PRINT", new DiscountSetInfo().getBOSType());
    }

    public void closePreview()
    {
    }
  }
}
