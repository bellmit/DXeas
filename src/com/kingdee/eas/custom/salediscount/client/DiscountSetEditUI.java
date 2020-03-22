package com.kingdee.eas.custom.salediscount.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.common.util.ControlUtilities;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.extendcontrols.ext.FilterInfoProducerFactory;
import com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.CurrencyCollection;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardCollection;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.ICSSPGroupStandard;
import com.kingdee.eas.basedata.master.cssp.ICustomer;
import com.kingdee.eas.basedata.master.material.AsstAttrValueInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.MaterialGroupPromptBox;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.OrgF7PromptDialog;
import com.kingdee.eas.basedata.org.client.f7.SaleF7;
import com.kingdee.eas.basedata.scm.common.DiscountConditionEnum;
import com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum;
import com.kingdee.eas.basedata.scm.common.PriceCompositionEnum;
import com.kingdee.eas.basedata.scm.common.client.BDInvClientUtils;
import com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum;
import com.kingdee.eas.basedata.scm.sd.sale.IMaterialBasePrice;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceFactory;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.PricePolicyException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetAgent;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryAgent;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountSetException;
import com.kingdee.eas.custom.salediscount.DiscountSetFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.custom.salediscount.DiscountUnitTypeEnum;
import com.kingdee.eas.custom.salediscount.DsNameTypeEnum;
import com.kingdee.eas.custom.salediscount.EntryState;
import com.kingdee.eas.custom.salediscount.IDiscountFacade;
import com.kingdee.eas.custom.salediscount.IDiscountSet;
import com.kingdee.eas.custom.salediscount.IDiscountSetEntry;
import com.kingdee.eas.framework.CheckedStatusEnum;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.ObjectValueForEditUIUtil;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.client.SCMGroupClientUtils;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.common.util.PrecisionUtil;
import com.kingdee.eas.scm.common.util.SortUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;

public class DiscountSetEditUI extends AbstractDiscountSetEditUI
  implements ItemListener, PropertyChangeListener, TreeWillExpandListener, TreeSelectionListener
{
  private static final Logger logger = CoreUIObject.getLogger(DiscountSetEditUI.class);
  private static final String TB_CUSTOMERGROUPSTDNUMBER = "customerGroupStandardNumber";
  private static final String TB_CUSTOMERGROUPNUMBER = "customerGroupNumber";
  private static final String TB_CUSTOMERGROUPNAME = "customerGroupName";
  private static final String TB_CUSTOMERNUMBER = "customerNumber";
  private static final String TB_CUSTOMERNAME = "customerName";
  private static final String TB_MATERIALGROUPNUMBER = "materialGroupNumber";
  private static final String TB_MATERIALGROUPNAME = "materialGroupName";
  private static final String TB_MATERIALNUMBER = "materialNumber";
  private static final String TB_MATERIALNAME = "materialName";
  private static final String TB_MATERIALMODEL = "materialModel";
  private static final String TB_BASICUNIT = "basicUnit";
  private static final String TB_ASSISTPROPERTY = "asistProperty";
  private static final String TB_CURRENCY = "currency";
  private static final String TB_DISCOUNT = "discount";
  private static final String TB_DISCOUNTMODE = "discountMode";
  private static final String TB_PRICETYPE = "priceType";
  private static final String RESOURCE = "com.kingdee.eas.custom.salediscount.client.DiscountSet";
  
  private static final BigDecimal ZERO = new BigDecimal("0");
  private boolean isCanNotEditPrice = false;

  private DefaultKingdeeTreeNode rootNode = new DefaultKingdeeTreeNode();

  private DefaultKingdeeTreeNode currentNode = null;

  private int precision = 4;

  private String[] samePrecision1 = { "saleLeadTime" };

  private String[] discountPrecision = { };

  private String[] samePrecision2 = {  };

  private String[] precision_currency = { };

  private String[] qtyArray = {  };

  private DataChangeListener prmtMaterialListener = null;

  private String[] numberForRight = { "saleLeadTime" };

  private String[] maxLength = {   };

  private int f7DisplayMode = 0;
  private int discountRatePrecision = 4;
  private List treeNodeInfo = null;
  private boolean isSubordinateAddnewable = false;
  private KDBizPromptBox prmtOrderCustomer = null;
  private KDBizPromptBox bizMaterialBox = null;

  private static final BigDecimal DEFAULTNUM = new BigDecimal("0");
  private static final BigDecimal HUNDREDNUM = new BigDecimal("100");

  private boolean isfirstload = false;

  protected F7ContextManager f7Manager = null;

  private boolean isCopy = false;

  private DiscountSetEntryCollection collection = null;

  private List entryids = null;

  private DefaultKingdeeTreeNode lastTreeNode = null;
  private Map cacheQueryMap = new HashMap();
  private ArrayList cacheCustomers = new ArrayList();
  private ArrayList cacheMaterials = new ArrayList();

  public DiscountSetEditUI()
    throws Exception
  {
    this.f7Manager = new F7ContextManager(this, getMainBizOrgType());
    initCustomerGroupStandard();

    this.actionSave.setVisible(true);
    this.btnSave.setVisible(true);
    this.menuItemSave.setVisible(true);
    this.menuItemSubmit.setVisible(false);
    this.btnSubmit.setVisible(false);
    this.btnPrint.setVisible(false);
    this.btnPrintPreview.setVisible(false);
    this.menuItemPrint.setVisible(false);
    this.menuItemPrintPreview.setVisible(false);
  }

  public void loadFields()
  {
    this.comboPriceCompDetailCustomer.removeItemListener(this);
    this.comboPriceCompDetailMaterial.removeItemListener(this);
    this.comboCustomerGroupStandard.removeItemListener(this);
    super.loadFields();
//    initUI();
//    comboPriceCompDetailCustomerChanged();
//    comboPriceCompDetailMaterialChanged();
//    comboCustomerGroupStandardChanged();
//    if ((this.currentNode != this.rootNode) || (this.chkIncluded.isSelected()))
//    {
//      setEntryDisplay(this.currentNode);
//    }
    addListener();
    this.entryids = new ArrayList();
    try{
    	chkisAllCustomer_actionPerformed(null);
    }catch(Exception e){
    	e.printStackTrace();
    	this.handleException(e);
    }
//    this.chkIncluded.setEnabled(true);
//    this.chkIncluded.setSelected(true);
//    this.chkIncluded.setAccessAuthority(0);
//    
//    initEntryEditableState();
  }

  /**
   * 设置分录的可编辑状态，如果分录已经生成过 折让日志数据的话则锁定该分录的所有字段
 * @throws BOSException 
   * 
   */
  private void initEntryEditableState() {
	  if(!"ADDNEW".equals(this.getOprtState()) && !"VIEW".equals(this.getOprtState())){
		  for(int i = 0; i < this.getDetailTable().getRowCount(); i++){
			  BOSUuid id = (BOSUuid) this.getDetailTable().getRow(i).getCell("id").getValue();
			 
			  
			  if(id != null){
				  
				  try{
					  IDiscountFacade df = DiscountFacadeFactory.getRemoteInstance();
					  boolean entryState = df.isDiscountUsed("", id.toString());
					  
					  if(entryState){
						  this.getDetailTable().getRow(i).getStyleAttributes().setLocked(true);
					  }
				  }catch(Exception e){
					  continue;
				  }
			  }
		  }
	  }
  }
  
  private void initBtnState()
  {
    String curState = getOprtState();
    this.btnBatchAddEntry.setIcon(EASResource.getIcon("imgTbtn_BatchAdd"));
    if ((OprtState.ADDNEW.equals(curState)) || (OprtState.EDIT.equals(curState)))
    {
      this.btnAddLine.setEnabled(true);
      this.btnInsertLine.setEnabled(true);
      this.btnRemoveLine.setEnabled(true);
      this.btnCopyEntry.setEnabled(true);
      this.menuItemAddLine.setEnabled(true);
      this.menuItemInsertLine.setEnabled(true);
      this.menuItemRemoveLine.setEnabled(true);
      this.btnBatchAddEntry.setEnabled(true);
    }
    else {
      this.btnAddLine.setEnabled(false);
      this.btnInsertLine.setEnabled(false);
      this.btnRemoveLine.setEnabled(false);
      this.btnCopyEntry.setEnabled(false);
      this.menuItemAddLine.setEnabled(false);
      this.menuItemInsertLine.setEnabled(false);
      this.menuItemRemoveLine.setEnabled(false);
      this.btnBatchAddEntry.setEnabled(false);
    }
    this.menuItemTraceDown.setVisible(false);
    this.menuItemTraceUp.setVisible(false);
  }

  public void storeFields()
  {
    this.editData.setSyncOldValue(true);
    if (this.editData.getEffectiveDate() == null) {
      this.editData.setEffectiveDate(new Date());
    }
    if (this.editData.getExpireDate() == null) {
      this.editData.setExpireDate(getExpireDate());
    }
    this.dataBinder.bindTableToData(this.kdtEntries, this.editData.getEntries());
    super.storeFields();

    if (this.entryids.size() > 0) {
      try {
        IDiscountSetEntry ientry = DiscountSetEntryFactory.getRemoteInstance();
        IObjectPK[] pks = new IObjectPK[this.entryids.size()];
        int i = 0; for (int n = this.entryids.size(); i < n; ++i) {
          pks[i] = new ObjectStringPK(this.entryids.get(i).toString());
        }
        ientry.delete(pks);
      } catch (BOSException e) {
        e.printStackTrace();
      } catch (EASBizException e) {
        e.printStackTrace();
      }
    }
//
//    PriceCompDetailEnum customeritem = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
//    PriceCompDetailEnum materialitem = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();
//    int customer = customeritem.getValue();
//    int material = materialitem.getValue();
//    this.editData.setPriceComposition(PriceCompositionEnum.getEnum(customer ^ material));
//    this.editData.setSyncOldValue(false);
  }

  private void setNumberForRight() {
    int i = 0; for (int num = this.numberForRight.length; i < num; ++i)
    {
      this.kdtEntries.getColumn(this.numberForRight[i]).getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);
    }
  }

  private void initUI()
  {
    this.priceComposition.setSelectedItem(PriceCompositionEnum.CM);

//    addTreeOperate();

//    setNumberForRight();
    
    this.chkisEnableAim.setVisible(false);
//    initEntryStauts();
//
//    KDBizPromptBox bizCustomerGroupStandardBox = new KDBizPromptBox();
//    bizCustomerGroupStandardBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerGroupStandardQuery");
//
//    bizCustomerGroupStandardBox.setEditFormat("$number$");
//    bizCustomerGroupStandardBox.setDisplayFormat("$number$");
//    bizCustomerGroupStandardBox.setCommitFormat("$number$");
//    this.kdtEntries.getColumn("customerGroupStandardNumber").setEditor(new KDTDefaultCellEditor(bizCustomerGroupStandardBox));


//    KDBizPromptBox bizCustomerGroupBox = new KDBizPromptBox();
//
//    bizCustomerGroupBox.setEditFormat("$number$");
//    bizCustomerGroupBox.setDisplayFormat("$number$");
//    bizCustomerGroupBox.setCommitFormat("$number$");
//    try
//    {
//      CSSPGroupPrompt selectorLisenterCustomerGroup = null;
//
//      selectorLisenterCustomerGroup = new CSSPGroupPrompt(this, 1);
//
//      bizCustomerGroupBox.setSelector(selectorLisenterCustomerGroup);
//    }
//    catch (Exception e)
//    {
//      super.handUIException(e);
//    }
//    this.kdtEntries.getColumn("customerGroupNumber").setEditor(new KDTDefaultCellEditor(bizCustomerGroupBox));

//    this.kdtEntries.getColumn("customerGroupNumber").setRenderer(avr);

    MaterialGroupPromptBox groupBox = new MaterialGroupPromptBox(this);
    KDBizPromptBox bizMaterialGroupBox = new KDBizPromptBox();
    bizMaterialGroupBox.setEditFormat("$number$");
    bizMaterialGroupBox.setDisplayFormat("$name$");
    bizMaterialGroupBox.setCommitFormat("$number$");
    bizMaterialGroupBox.setSelector(groupBox);
    this.kdtEntries.getColumn("accumulaMaterialGroup").setEditor(new KDTDefaultCellEditor(bizMaterialGroupBox));
    

    ObjectValueRender avr = new ObjectValueRender();

    avr.setFormat(new BizDataFormat("$name$"));
    
    this.kdtEntries.getColumn("accumulaMaterialGroup").setRenderer(avr);

    KDTDefaultCellEditor itemEditor = null;

//    KDComboBox comDiscountCond = new KDComboBox();
//    comDiscountCond.addItem(DiscountConditionEnum.AMOUNT);
//    comDiscountCond.addItem(DiscountConditionEnum.QTYANDAMT);
//    comDiscountCond.addItem(DiscountConditionEnum.QTYORAMT);
//    comDiscountCond.addItem(DiscountConditionEnum.QUANTITY);
//    itemEditor = new KDTDefaultCellEditor(comDiscountCond);
//    this.kdtEntries.getColumn("discountCondition").setEditor(itemEditor);

    this.kdtEntries.addPropertyChangeListener(this);

    KDBizPromptBox bizCurrencyBox = new KDBizPromptBox();
    bizCurrencyBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CurrencyQuery");
    bizCurrencyBox.setEditFormat("$number$");
    bizCurrencyBox.setDisplayFormat("$number$");
    bizCurrencyBox.setCommitFormat("$number$");
    bizCurrencyBox.setEditable(true);
    this.kdtEntries.getColumn("currency").setEditor(new KDTDefaultCellEditor(bizCurrencyBox));

//    KDBizPromptBox bizPriceTypeBox = new KDBizPromptBox();
//    bizPriceTypeBox.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7PriceTypeQuery");
//    bizPriceTypeBox.setEditFormat("$number$");
//    bizPriceTypeBox.setDisplayFormat("$name$");
//    bizPriceTypeBox.setCommitFormat("$number$");
//    this.kdtEntries.getColumn("priceType").setEditor(new KDTDefaultCellEditor(bizPriceTypeBox));

    KDBizPromptBox bizMeasureUnitBox = new KDBizPromptBox();
    bizMeasureUnitBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MultiMeasureUnitQuery");
    bizMeasureUnitBox.setEditFormat("$number$");
    bizMeasureUnitBox.setDisplayFormat("$name$");
    bizMeasureUnitBox.setCommitFormat("$number$");
    this.kdtEntries.getColumn("basicUnit").setEditor(new KDTDefaultCellEditor(bizMeasureUnitBox));

//    KDComboBox comDiscount = new KDComboBox();
//    comDiscount.addItem(DiscountModeEnum.PERCENT);
//    comDiscount.addItem(DiscountModeEnum.PERUNIT);
//    itemEditor = new KDTDefaultCellEditor(comDiscount);
//    this.kdtEntries.getColumn("discountMode").setEditor(itemEditor);

//    KDFormattedTextField colTxtField = new KDFormattedTextField();
//    colTxtField.setDataType(1);
//    colTxtField.setSupportedEmpty(true);
//    colTxtField.setPrecision(this.discountRatePrecision);
//    colTxtField.setRemoveingZeroInDispaly(false);
//    colTxtField.setMaximumValue(new BigDecimal("10000000000"));
//    itemEditor = new KDTDefaultCellEditor(colTxtField);
////    this.kdtEntries.getColumn("discount").setEditor(itemEditor);
//
//    KDDatePicker pkExpireDate = new KDDatePicker();
//
//    pkExpireDate.setEditable(true);
//    itemEditor = new KDTDefaultCellEditor(pkExpireDate);
//    this.kdtEntries.getColumn("expireDate").setEditor(itemEditor);
//    this.kdtEntries.getColumn("expireDate").getStyleAttributes().setNumberFormat("%{yyyy-MM-dd}t");

    KDDatePicker pkEffectiveDate = new KDDatePicker();

    pkEffectiveDate.setEditable(true);
    itemEditor = new KDTDefaultCellEditor(pkEffectiveDate);
    this.kdtEntries.getColumn("effectiveDate").setEditor(itemEditor);
    this.kdtEntries.getColumn("effectiveDate").getStyleAttributes().setNumberFormat("%{yyyy-MM-dd}t");

//    KDFormattedTextField txtSaleLeadTime = new KDFormattedTextField(1);
//    txtSaleLeadTime.setEditable(true);
//    txtSaleLeadTime.setPrecision(2);
//    itemEditor = new KDTDefaultCellEditor(txtSaleLeadTime);
//    this.kdtEntries.getColumn("saleLeadTime").setEditor(itemEditor);

//    initHasPrecisionCtrl(this.precision, this.kdtEntries, this.samePrecision1);
//    initHasPrecisionCtrl(this.precision, this.kdtEntries, this.samePrecision2);
//    initHasPrecisionCtrl(0, this.kdtEntries, this.qtyArray);

    KDComboBox comCheckedStatus = new KDComboBox();
    comCheckedStatus.addItem(CheckedStatusEnum.AUDITED);
    comCheckedStatus.addItem(CheckedStatusEnum.UNAUDITED);
    itemEditor = new KDTDefaultCellEditor(comCheckedStatus);
    this.kdtEntries.getColumn("checkedStatus").setEditor(itemEditor);

    this.comboBlockedStatus.setEditable(false);
    this.comboCheckedStatus.setEditable(false);
    this.treeMain.setSelectionNode(this.rootNode);

//    ((SpinnerNumberModel)this.txtPriority.getModel()).setMinimum(new Integer(0));
//    ((SpinnerNumberModel)this.txtPriority.getModel()).setMaximum(new Integer(10000));

    initToolBarIcon();
    this.tHelper.getDisabledTables().add(this.kdtEntries);
    if ((this.editData.getCheckedStatus().equals(CheckedStatusEnum.AUDITED)) || (getOprtState().equals(OprtState.VIEW)))
    {
      this.kdtEntries.getStyleAttributes().setLocked(true);
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(true);
      this.actionRemoveLine.setEnabled(false);
    } else {
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(false);
      this.actionRemoveLine.setEnabled(true);
    }
    if (getOprtState().equals(OprtState.ADDNEW)) {
      if (getMainBizOrg() != null) {
        getMainBizOrg().setReadOnly(false);
        getMainBizOrg().setEnabled(true);
        getMainBizOrg().setEditable(true);
      }
      this.comboPriceCompDetailCustomer.setEnabled(false);
      this.comboPriceCompDetailMaterial.setEnabled(false);
    } else {
      getMainBizOrg().setReadOnly(true);
      this.comboPriceCompDetailCustomer.setEnabled(false);
      this.comboPriceCompDetailMaterial.setEnabled(false);
    }
    this.menuItemQueryPriority.setEnabled(true);
    
    
    if(!"ADDNEW".equals(this.getOprtState()) && !"EDIT".equals(this.getOprtState())){
    	this.btnCopyToEntries.setEnabled(false);
    	this.btnSetLimit.setEnabled(false);
    	this.btnSetQtyStandard.setEnabled(false);
    }else{
    	this.btnCopyToEntries.setEnabled(true);
    	this.btnSetLimit.setEnabled(true);
    	this.btnSetQtyStandard.setEnabled(true);
    }
  }

  private void initEntryStauts()
  {
    this.kdtEntries.getColumn("materialName").getStyleAttributes().setLocked(true);

    this.kdtEntries.getColumn("materialModel").getStyleAttributes().setLocked(true);
    this.kdtEntries.getColumn("materialModel").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("customerName").getStyleAttributes().setLocked(true);

    this.kdtEntries.getColumn("asistProperty").getStyleAttributes().setLocked(true);

//    this.kdtEntries.getColumn("customerGroupName").getStyleAttributes().setLocked(true);

//    this.kdtEntries.getColumn("materialGroupName").getStyleAttributes().setLocked(true);

//    this.kdtEntries.getColumn("customerGroupStandardNumber").getStyleAttributes().setHided(true);
    
    this.kdtEntries.getColumn("basicUnit").getStyleAttributes().setLocked(true);
    this.kdtEntries.getColumn("basicUnit").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("discountUnitType").getStyleAttributes().setLocked(true);
//    this.kdtEntries.getColumn("discountCondition").getStyleAttributes().setLocked(true);
//    this.kdtEntries.getColumn("discountCondition").getStyleAttributes().setHided(true);
    
//    this.kdtEntries.getColumn("qtyMin").getStyleAttributes().setLocked(true);
//    this.kdtEntries.getColumn("qtyMin").getStyleAttributes().setHided(true);
//    this.kdtEntries.getColumn("qtyMax").getStyleAttributes().setLocked(true);
//    this.kdtEntries.getColumn("qtyMax").getStyleAttributes().setHided(true);
    
  }

//  /**
//   * 从分录中循环查找到对应的  明细行
//   * @param entries
//   * @param entryID
//   * @return
//   */
//  private DiscountSetEntryInfo getEntryFromColl(DiscountSetEntryCollection entries,String entryID){
//	  for(int i = 0; i < entries.size(); i++){
//		  DiscountSetEntryInfo entryInfo = entries.get(i);
//		  if(entryID.equals(entryInfo.getId().toString())){
//			  return entryInfo;
//		  }
//	  }
//	  
//	  return null;
//  }
  private void initEntry()
  {
    int rowCount = this.kdtEntries.getRowCount();
    DiscountSetEntryCollection entries = this.editData.getEntries();
    // 分录先整理到map中
    Map<String,DiscountSetEntryInfo > entryMap = new HashMap<String , DiscountSetEntryInfo>();
    for(int i = 0; i < entries.size(); i++){
		  DiscountSetEntryInfo entryInfo = entries.get(i);
		  entryMap.put(entryInfo.getId().toString(), entryInfo);
	  }
    for (int i = 0; i < rowCount; ++i)
    {
    	
    	if(this.kdtEntries.getRow(i).getCell("id").getValue() != null){
	    	String entryID = (String) this.kdtEntries.getRow(i).getCell("id").getValue().toString();
	    	
    		DiscountSetEntryInfo entryInfo = entryMap.get(entryID);
    		
    		if(entryInfo != null && entryID.equals(entryInfo.getId().toString())){
    			this.kdtEntries.getRow(i).getCell("accumulaMaterialGroup").setValue(entryInfo.getAccumulaMaterialGroup());
    		}
	    	
    	}
      if ((this.editData.getPriceComposition().equals(PriceCompositionEnum.CGM)) || (this.editData.getPriceComposition().equals(PriceCompositionEnum.CM)))
      {
        Object tmp = this.kdtEntries.getRow(i).getCell("materialNumber").getValue();
        MaterialInfo mi = getMaterialInfo(tmp);
        if (mi != null) {
          initMaterialPrecisionCtrl(this.kdtEntries, i, this.samePrecision2, mi);
          setEntryAssistProperty(i, mi);
        }
      } else {
        initHasPrecisionCtrl(this.precision, this.kdtEntries, this.samePrecision2);
      }
//      if ((this.kdtEntries.getRow(i).getCell("discountMode").getValue() != null) && (this.kdtEntries.getRow(i).getCell("discountMode").getValue().equals(DiscountModeEnum.PERCENT)))
//      {
//        initCellPrecision(this.discountRatePrecision, this.kdtEntries.getRow(i).getCell("discount"));
//      }
//      else this.kdtEntries.getRow(i).getCell("discount").getStyleAttributes().setNumberFormat(this.kdtEntries.getRow(i).getCell("price").getStyleAttributes().getNumberFormat());

      if (this.kdtEntries.getRow(i).getCell("currency").getValue() instanceof CurrencyInfo)
        initHasPrecisionCtrl(((CurrencyInfo)this.kdtEntries.getRow(i).getCell("currency").getValue()).getPrecision(), i, this.kdtEntries, this.precision_currency);
      else
        initHasPrecisionCtrl(2, i, this.kdtEntries, this.precision_currency);
    }
  }

  private void addListener()
  {
    this.comboPriceCompDetailCustomer.addItemListener(this);
    this.comboPriceCompDetailMaterial.addItemListener(this);
    this.comboCustomerGroupStandard.addItemListener(this);

    this.kdtEntries.addKDTEditListener(new KDTEditAdapter()
    {
      public void editStopped(KDTEditEvent e)
      {
        DiscountSetEditUI.this.autoAssignValue(e);
      }

      public void editStarting(KDTEditEvent e)
      {
        DiscountSetEditUI.this.initEntryStatus(e);
      }
    });
    this.chkIncluded.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        DiscountSetEditUI.this.chkIncludedChanged();
      }
    });
   
  }
  
  
//  /**
//   * 显示客户变化
//   * @param e
//   */
//  protected void displayCustomerChange(DataChangeEvent e) {
////	if(this.prmtDisplayCustomer.getValue() != null){
//		CustomerInfo customerInfo = (CustomerInfo) this.prmtDisplayCustomer.getValue();
//		setEntryCustomerDisplay(this.currentNode,customerInfo);
////	}
//	
//  }

// @Override
protected void btnDisplayCustomer_actionPerformed(ActionEvent e)
		throws Exception {
	Map map = new UIContext(this); 
	
	IUIWindow uiWindow = null;
	
	
   try {
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.salediscount.client.DisplayCustomerSelector", map, null, OprtState.VIEW);
	} catch (UIException uie) {
		uie.printStackTrace();
	}
   uiWindow.show();
   // 获得 选中的 客户和物料
   Map entryS = uiWindow.getUIObject().getUIContext();
   CustomerInfo customerInfo = (CustomerInfo) entryS.get("customer");
   if(customerInfo!= null){
	   setEntryCustomerDisplay(this.currentNode,customerInfo);
   }
}

protected void initEntryStatus(KDTEditEvent e)
  {
    int row = e.getRowIndex();
    int col = e.getColIndex();
    String fieldName = this.kdtEntries.getColumn(col).getKey();
    if (("materialNumber".equals(fieldName)) && (!(this.kdtEntries.getColumn("materialNumber").getStyleAttributes().isHided())))
    {
      return;
    }

    if (("basicUnit".equals(fieldName)) && (!(this.kdtEntries.getColumn("basicUnit").getStyleAttributes().isHided()))) {
      ICell tmpCell = this.kdtEntries.getRow(row).getCell("materialNumber");
      if (tmpCell.getValue() instanceof MaterialInfo) {
        MaterialInfo mi = (MaterialInfo)tmpCell.getValue();
        KDBizPromptBox bizUnitBox = (KDBizPromptBox)this.kdtEntries.getColumn("basicUnit").getEditor().getComponent();
        SCMClientUtils.setF7MeasureUnit(bizUnitBox, mi.getId().toString());
      } else {
        KDBizPromptBox bizUnitBox = (KDBizPromptBox)this.kdtEntries.getColumn("basicUnit").getEditor().getComponent();
        bizUnitBox.setEntityViewInfo(null); }
    } else {
      if ((!("amtMax".equals(fieldName))) && (!("amtMin".equals(fieldName))))
        return;
      if (this.kdtEntries.getRow(row).getCell("currency").getValue() instanceof CurrencyInfo)
        initHasPrecisionCtrl(((CurrencyInfo)this.kdtEntries.getRow(row).getCell("currency").getValue()).getPrecision(), row, this.kdtEntries, this.precision_currency);
      else
        initHasPrecisionCtrl(2, row, this.kdtEntries, this.precision_currency);
    }
  }

  private MaterialInfo getMaterialInfo(String id) throws Exception
  {
    MaterialInfo info = null;
    IMaterial iMaterial = MaterialFactory.getRemoteInstance();
    info = iMaterial.getMaterialInfo(new ObjectStringPK(id));
    return info;
  }

  private void setBaseDataF7WithVirtualOrg(String fieldName, KDBizPromptBox bizBox, String classname, String queryInfo, String relatedpro, String bosType, String f7queryInfo)
  {
    bizBox.setDisplayFormat("$number$");
    bizBox.setCommitFormat("$number$");
    if (f7queryInfo != null) {
      bizBox.setQueryInfo(f7queryInfo);
    }
    if (this.f7DisplayMode == 0) {
      GeneralKDPromptSelectorAdaptor selectorLisenter = null;
      selectorLisenter = new GeneralKDPromptSelectorAdaptor(bizBox, classname, this, bosType, queryInfo, relatedpro, f7queryInfo);
      if (fieldName.equals("materialNumber")) {
        selectorLisenter.setIsMultiSelect(false);
      }
      bizBox.setSelector(selectorLisenter);
      bizBox.addSelectorListener(selectorLisenter);
    }
    if (fieldName.equals("materialNumber")) {
      this.prmtMaterialListener = null;
      bizBox.setEnabledMultiSelection(false);
//      registerDealMultiMateiralInfo(bizBox, fieldName);
    }
    this.kdtEntries.getColumn(fieldName).getEditor().releaseComponent();
    this.kdtEntries.getColumn(fieldName).setEditor(new KDTDefaultCellEditor(bizBox));
    OrgUnitInfo orgInfo = null;
    if (getMainOrgContext() != null) {
      orgInfo = (OrgUnitInfo)getMainOrgContext().get(getMainBizOrgType());
    }
    if (orgInfo != null)
      bizBox.setCurrentMainBizOrgUnit(orgInfo, getMainBizOrgType());
  }

  protected void chkIncludedChanged()
  {
    setEntryDisplay(this.currentNode);
  }

//  protected void registerDealMultiMateiralInfo(KDBizPromptBox promptBox, String fieldName)
//  {
//     final String materialFieldname1 = fieldName;
//
//    this.prmtMaterialListener = new DataChangeListener()
//    {
//      private final String materialFieldname = materialFieldname1;
//
//      public void dataChanged(DataChangeEvent e) {
//        try {
//          KDBizPromptBox f7box = (KDBizPromptBox)e.getSource();
//          if (f7box.getValue() == null)
//          {
//            return;
//          }
//
//          Object[] materialInfos = null;
//          if ((!(f7box.getValue() instanceof Object[])) && (!(f7box.getValue() instanceof MaterialInfo))) {
//            return;
//          }
//
//          if (f7box.getValue() instanceof Object[])
//          {
//            materialInfos = (Object[])f7box.getValue();
//          } else if (f7box.getValue() instanceof MaterialInfo)
//          {
//            materialInfos = new Object[] { (MaterialInfo)f7box.getValue() };
//          }
//
//          KDTable table = DiscountSetEditUI.this.getDetailTable();
//
//          HashMap beforeExceptionMap = new HashMap();
//          HashMap afterExceptionMap = new HashMap();
//          KDTSelectBlock ksb = table.getSelectManager().get();
//          if (ksb == null) return;
//          int beginRow = ksb.getBeginRow();
//          int length = materialInfos.length;
//          if (length > 0)
//          {
//            f7box.removeDataChangeListener(DiscountSetEditUI.this.prmtMaterialListener);
//            IRow curRow2 = null;
//            MaterialInfo mi = null;
//            boolean needInsert = false;
//            int insertedRowCount = 0;
//            int curCol = table.getColumnIndex(materialFieldname);
//            for (int i = 0; i < length; ++i)
//            {
//              if (needInsert)
//              {
//                if (DiscountSetEditUI.this.currentNode == DiscountSetEditUI.this.rootNode)
//                {
//                  MsgBox.showInfo(null, EASResource.getString(RESOURCE, "selectchildnode"));
//                  needInsert = true;
//
//                  break;
//                }
//                DiscountSetEditUI.this.insertLine(beginRow + insertedRowCount);
//                needInsert = false;
//              }
//
//              mi = (MaterialInfo)materialInfos[i];
//
//              if (mi == null)
//              {
//                return;
//              }
//
//              curRow2 = table.getRow(beginRow + insertedRowCount);
//              curRow2.getCell(curCol).setValue(null);
//              try
//              {
//                DiscountSetEditUI.this.beforeInsertMaterialInfo(mi);
//                curRow2.getCell(curCol).setValue(mi);
////                 jsr 63;
//              } catch (Exception ex) {
//                curRow2.getCell(curCol).setValue(mi);
//                curRow2.getCell(curCol).setValue(null);
//                beforeExceptionMap.put(mi, ex);
//              }
//              finally
//              {
////                 jsr 6;
//				}
//              try {
//                DiscountSetEditUI.this.afterInsertMaterialInfo(beginRow + insertedRowCount);
//              }
//              catch (Exception ex) {
//                afterExceptionMap.put(mi, ex); }
////               ret;
//
//              needInsert = true;
//              ++insertedRowCount;
//            }
//
//            if ((!(needInsert)) && (insertedRowCount > 0))
//            {
//              DiscountSetEditUI.this.removeLine(table, beginRow + insertedRowCount);
//            }
//
//            if ((beforeExceptionMap != null) && (beforeExceptionMap.size() > 0))
//            {
//              DiscountSetEditUI.this.handleBeforeInsertRowException(beforeExceptionMap);
//            }
//            if ((afterExceptionMap != null) && (afterExceptionMap.size() > 0))
//            {
//              DiscountSetEditUI.this.handleAfterInsertRowException(afterExceptionMap);
//            }
//
//            f7box.addDataChangeListener(DiscountSetEditUI.this.prmtMaterialListener);
//          }
//        }
//        catch (Exception exc) {
//          DiscountSetEditUI.this.handUIException(exc);
//        }
//        finally
//        {
//        }
//      }
//    };
//    promptBox.addDataChangeListener(this.prmtMaterialListener);
//  }

  protected void insertLine(int row)
  {
    KDTable kdtEntries = getDetailTable();
    if (kdtEntries == null)
    {
      return;
    }
    IObjectValue detailData = createNewDetailData(kdtEntries);
    IRow irow = null;
    irow = kdtEntries.addRow(row);
    loadLineFields(kdtEntries, irow, detailData);
    afterInsertLine(kdtEntries, detailData);
  }

  protected void removeLine(KDTable table, int rowIndex)
  {
    if (table == null)
    {
      return;
    }

    if (table.getRow(rowIndex) == null)
      return;
    
    // 删除前加 校验，如果已经用过 则 不允许删除
    BOSUuid entryID = (BOSUuid) table.getRow(rowIndex).getCell("id").getValue();
    if(entryID != null){
    	try{
    		boolean isExist = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed("", entryID.toString());
    		if(isExist){
    			MsgBox.showInfo("该分录已经被使用，不能删除");
    			SysUtil.abort();
    		}
    	}catch(Exception e){
    		this.handUIException(e);
    	}
    }
    
    IObjectValue detailData = (IObjectValue)table.getRow(rowIndex).getUserObject();
    table.removeRow(rowIndex);
    IObjectCollection collection = (IObjectCollection)table.getUserObject();
    if (collection == null)
    {
      logger.error("collection not be binded to table");
    }
    else if (detailData != null)
    {
      collection.removeObject(detailData);
    }

    afterRemoveLine(table, detailData);
  }

  protected void handleAfterInsertRowException(HashMap afterExceptionMap)
  {
    showExceptionMessage(afterExceptionMap);
  }

  protected void handleBeforeInsertRowException(HashMap beforeExceptionMap)
  {
    showExceptionMessage(beforeExceptionMap);
  }

  protected void beforeInsertMaterialInfo(MaterialInfo materialInfo)
    throws Exception
  {
  }

  protected void afterInsertMaterialInfo(int row)
    throws Exception
  {
    ICell tmpCell = this.kdtEntries.getRow(row).getCell("materialNumber");
    if (!(tmpCell.getValue() instanceof MaterialInfo))
    {
      return;
    }

    MaterialInfo mi = (MaterialInfo)tmpCell.getValue();
    if (mi == null)
      return;
    initMaterialPrecisionCtrl(this.kdtEntries, row, this.samePrecision2, mi);
    this.kdtEntries.getRow(row).getCell("materialName").setValue(mi.getName());
    this.kdtEntries.getRow(row).getCell("materialModel").setValue(mi.getModel());
    
    this.kdtEntries.getRow(row).getCell("asistProperty").setValue(null);
    if ((mi.getBaseUnit() != null) && (mi.getBaseUnit().getId() != null))
    {
      IObjectPK pk = new ObjectStringPK(mi.getBaseUnit().getId().toString());
      try
      {
        IMeasureUnit ie = MeasureUnitFactory.getRemoteInstance();
        MeasureUnitInfo unit = (MeasureUnitInfo)ie.getValue(pk);
        this.kdtEntries.getRow(row).getCell("basicUnit").setValue(unit);
      }
      catch (BOSException e1) {
        handUIException(e1);
      }
      catch (EASBizException e1) {
        handUIException(e1);
      }
    }
    setEntryAssistProperty(row, mi);
    setPriceWithMaterailBasePrice(row);
  }

  private void setPriceWithMaterailBasePrice(int row)
  {
//    PriceSolve priceSolve = new PriceSolve();
    PriceCondition priceCondition = new PriceCondition();
    ICell cell = null;
    cell = this.kdtEntries.getRow(row).getCell("materialNumber");
    if (cell.getValue() instanceof MaterialInfo)
      priceCondition.setMaterialInfo((MaterialInfo)cell.getValue());
    else {
      return;
    }

    if (this.prmtSaleOrgUnit.getData() instanceof SaleOrgUnitInfo) {
      priceCondition.setSaleOrg((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData());
    }

    cell = this.kdtEntries.getRow(row).getCell("asistProperty");
    if (cell.getValue() instanceof AsstAttrValueInfo) {
      priceCondition.setAssiProperty((AsstAttrValueInfo)cell.getValue());
    }
    cell = this.kdtEntries.getRow(row).getCell("currency");
    if (cell.getValue() instanceof CurrencyInfo) {
      priceCondition.setCurrencyInfo((CurrencyInfo)cell.getValue());
    }
    cell = this.kdtEntries.getRow(row).getCell("basicUnit");
    if (cell.getValue() instanceof MeasureUnitInfo) {
      priceCondition.setMeasureUnit(((MeasureUnitInfo)cell.getValue()).getId().toString());
    }
//    cell = this.kdtEntries.getRow(row).getCell("priceType");
//    if (cell.getValue() instanceof PriceTypeInfo) {
//      priceCondition.setPriceTypeID(((PriceTypeInfo)cell.getValue()).getId().toString());
//    }
    Map basepriceMap = null;
    try {
      basepriceMap = MaterialBasePriceFactory.getRemoteInstance().calculatePrice(priceCondition);
    } catch (PricePolicyException e) {
      e.printStackTrace();
    } catch (BOSException e) {
      e.printStackTrace();
    }
    if ((basepriceMap != null) && (basepriceMap.size() > 0)) {
//      if (priceSolve.visitPrice(basepriceMap) != null)
//        this.kdtEntries.getRow(row).getCell("price").setValue(priceSolve.visitPrice(basepriceMap));
//      else {
//        this.kdtEntries.getRow(row).getCell("price").setValue(null);
//      }
//
//      if (priceSolve.visitPriceMin(basepriceMap) != null) {
//        this.kdtEntries.getRow(row).getCell("priceMin").setValue(priceSolve.visitPriceMin(basepriceMap));
//      }
//      else {
//        this.kdtEntries.getRow(row).getCell("priceMin").setValue(null);
//      }
//
//      if (priceSolve.visitPriceMax(basepriceMap) != null) {
//        this.kdtEntries.getRow(row).getCell("priceMax").setValue(priceSolve.visitPriceMax(basepriceMap));
//      }
//      else {
//        this.kdtEntries.getRow(row).getCell("priceMax").setValue(null);
//      }
//      this.kdtEntries.getRow(row).getCell("priceMin").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getRow(row).getCell("priceMax").getStyleAttributes().setLocked(true);
    } else {
//      this.kdtEntries.getRow(row).getCell("price").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getRow(row).getCell("priceMin").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getRow(row).getCell("priceMax").getStyleAttributes().setLocked(false);
    }
  }

  protected void showExceptionMessage(HashMap exceptionMap)
  {
    if ((exceptionMap == null) || (exceptionMap.size() <= 0))
      return;
    StringBuffer exMsg = new StringBuffer();
    Iterator keyIt = exceptionMap.keySet().iterator();
    MaterialInfo materialInfo = null;
    Exception ex = null;
    boolean isFirst = true;
    while (keyIt.hasNext())
    {
      if (!(isFirst))
      {
        exMsg.append("\n");
      }
      else {
        isFirst = false;
      }
      materialInfo = (MaterialInfo)keyIt.next();
      ex = (Exception)exceptionMap.get(materialInfo);
      exMsg.append(materialInfo.getName()).append(":").append(ex.getMessage());
    }
    if (exMsg.length() <= 0)
      return;
    MsgBox.showInfo(exMsg.toString());
  }

  private MaterialInfo getMaterialInfo(Object tmp)
  {
    MaterialInfo mi = null;
    if (tmp instanceof MaterialInfo[])
    {
      mi = ((MaterialInfo[])tmp)[0];
    } else if (tmp instanceof MaterialInfo)
    {
      mi = (MaterialInfo)tmp;
    }
    return mi;
  }

  private void autoAssignPrice(KDTEditEvent e)
  {}

  private boolean isSltRelationCol(int[] condCols, int colIndex)
  {
    for (int i = 0; i < condCols.length; ++i)
    {
      if (colIndex == condCols[i])
      {
        return true;
      }
    }
    return false;
  }

  private void initMaterialPrecisionCtrl(KDTable table, int row, String[] fieldNames, MaterialInfo info)
  {
    int precision = 0;
    KDFormattedTextField colTxtField = new KDFormattedTextField();
    colTxtField.setDataType(1);
    colTxtField.setSupportedEmpty(true);
    precision = info.getPricePrecision();
    colTxtField.setPrecision(precision);
    colTxtField.setRemoveingZeroInDispaly(false);
    KDTDefaultCellEditor col_CellEditor = new KDTDefaultCellEditor(colTxtField);

    String colPrecision = PrecisionUtil.getFormatString(precision);

    int i = 0; for (int num = fieldNames.length; i < num; ++i)
    {
      table.getRow(row).getCell(fieldNames[i]).setEditor(col_CellEditor);
      table.getRow(row).getCell(fieldNames[i]).getStyleAttributes().setNumberFormat(colPrecision);
    }
  }

  private void initHasPrecisionCtrl(int precision, int row, KDTable table, String[] fieldNames)
  {
    KDFormattedTextField colTxtField = new KDFormattedTextField();
    colTxtField.setDataType(1);
    colTxtField.setSupportedEmpty(true);
    colTxtField.setPrecision(precision);
    colTxtField.setRemoveingZeroInDispaly(false);
    KDTDefaultCellEditor col_CellEditor = new KDTDefaultCellEditor(colTxtField);

    String colPrecision = PrecisionUtil.getFormatString(precision);
    colTxtField.setMaximumValue(new BigDecimal("10000000000"));
    int i = 0; for (int num = fieldNames.length; i < num; ++i)
    {
      table.getRow(row).getCell(fieldNames[i]).setEditor(col_CellEditor);
      table.getRow(row).getCell(fieldNames[i]).getStyleAttributes().setNumberFormat(colPrecision);
    }
  }

  private void initHasPrecisionCtrl(int precision, KDTable table, String[] fieldNames)
  {
    KDFormattedTextField colTxtField = new KDFormattedTextField();
    colTxtField.setDataType(1);
    colTxtField.setSupportedEmpty(true);
    colTxtField.setPrecision(precision);
    colTxtField.setRemoveingZeroInDispaly(false);
    KDTDefaultCellEditor col_CellEditor = new KDTDefaultCellEditor(colTxtField);

    String colPrecision = PrecisionUtil.getFormatString(precision);
    colTxtField.setMaximumValue(new BigDecimal("10000000000"));
    int i = 0; for (int num = fieldNames.length; i < num; ++i)
    {
      table.getColumn(fieldNames[i]).setEditor(col_CellEditor);
      table.getColumn(fieldNames[i]).getStyleAttributes().setNumberFormat(colPrecision);
    }
  }

  private void initCellPrecision(int precision, ICell cell) {
    KDFormattedTextField colTxtField = new KDFormattedTextField();
    colTxtField.setDataType(1);
    colTxtField.setSupportedEmpty(true);
    colTxtField.setPrecision(precision);
    colTxtField.setRemoveingZeroInDispaly(false);
    KDTDefaultCellEditor col_CellEditor = new KDTDefaultCellEditor(colTxtField);

    String colPrecision = PrecisionUtil.getFormatString(precision);
    colTxtField.setMaximumValue(new BigDecimal("10000000000"));
    cell.setEditor(col_CellEditor);
    cell.getStyleAttributes().setNumberFormat(colPrecision);
  }

  private void initToolBarIcon()
  {
    this.btnCopyEntry.setText(EASResource.getString(RESOURCE, "copyEntries"));
    this.btnCopyEntry.setToolTipText(EASResource.getString(RESOURCE, "copyEntriesTooltip"));
    setButtonDefaultStyl(this.btnCopyEntry);
    this.btnCopyEntry.setIcon(EASResource.getIcon("imgTbtn_copy"));
    this.btnCopy.setVisible(true);
  }

  private void addTreeOperate()
  {
    this.kDTreeView1.setShowButton(false);
    this.treeMain.setShowsRootHandles(true);

    this.treeMain.setModel(null);

    this.comboPriceCompDetailCustomer.addPropertyChangeListener(this);
    this.comboPriceCompDetailMaterial.addPropertyChangeListener(this);

    this.treeMain.addTreeWillExpandListener(this);

    this.treeMain.addTreeSelectionListener(this);

    this.treeMain.addPropertyChangeListener(this);

    PriceCompositionInfo info = new PriceCompositionInfo();
    info.setId(null);
    info.setIsCustomerGroup(true);
    info.setIsLeaf(false);
    info.setName("客户组");
    this.rootNode.setUserObject(info);
    this.treeMain.setModel(new DefaultTreeModel(this.rootNode));
    ((DefaultTreeModel)this.treeMain.getModel()).setAsksAllowsChildren(true);
  }

  private void changeTree()
  {
    PriceCompDetailEnum sltItem = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();

    int sltItemValue = sltItem.getValue();

    PriceCompositionInfo info = new PriceCompositionInfo();
    info.setId(null);
    info.setIsCustomerGroup(true);
    info.setIsLeaf(false);
    if (sltItemValue == 1)
    {
      info.setName(EASResource.getString(RESOURCE, "customer"));
      this.rootNode.setUserObject(info);
      this.rootNode.setText(info.getName());
      expandCustomer(null, false);
    } else if (sltItemValue == 2)
    {
      info.setName(EASResource.getString(RESOURCE, "customer"));
      this.rootNode.setUserObject(info);
      this.rootNode.setText(info.getName());
      expandCustomer(null, true);
    } else if (sltItemValue == 4)
    {
      info.setName(EASResource.getString(RESOURCE, "material"));
      this.rootNode.setUserObject(info);
      this.rootNode.setText(info.getName());
      expandMaterial(null, true);
    } else if (sltItemValue == 3)
    {
      info.setName(EASResource.getString(RESOURCE, "material"));
      this.rootNode.setUserObject(info);
      this.rootNode.setText(info.getName());
      expandMaterial(null, false);
    }
    this.currentNode = this.rootNode;
  }

  private void expandCustomer(String parentId, boolean isCustomerGroup)
  {
    try {
      IDiscountSet pp = (IDiscountSet)getBizInterface();
      String groupStandardId = null;
      groupStandardId = ((CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem()).getId().toString();

      HashMap queryparams = new HashMap();

      queryparams.put("customergroupStandardId", groupStandardId);
      queryparams.put("isCustomerGroup", Boolean.valueOf(isCustomerGroup));
      queryparams.put("customerparentId", parentId);
      queryparams.put("saleorgid", ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getId().toString());

      ArrayList customers = new ArrayList();
      if ((this.cacheQueryMap != null) && ((((queryparams.get("customergroupStandardId") == null) && (this.cacheQueryMap.get("customergroupStandardId") == null)) || ((queryparams.get("customergroupStandardId") != null) && (this.cacheQueryMap.get("customergroupStandardId") != null) && (queryparams.get("customergroupStandardId").equals(this.cacheQueryMap.get("customergroupStandardId"))) && ((((queryparams.get("isCustomerGroup") == null) && (this.cacheQueryMap.get("isCustomerGroup") == null)) || ((queryparams.get("isCustomerGroup") != null) && (this.cacheQueryMap.get("isCustomerGroup") != null) && (queryparams.get("isCustomerGroup").equals(this.cacheQueryMap.get("isCustomerGroup"))) && ((((queryparams.get("customerparentId") == null) && (this.cacheQueryMap.get("customerparentId") == null)) || ((queryparams.get("customerparentId") != null) && (this.cacheQueryMap.get("customerparentId") != null) && (queryparams.get("customerparentId").equals(this.cacheQueryMap.get("customerparentId"))) && ((((queryparams.get("saleorgid") == null) && (this.cacheQueryMap.get("saleorgid") == null)) || ((queryparams.get("saleorgid") != null) && (this.cacheQueryMap.get("saleorgid") != null) && (queryparams.get("saleorgid").equals(this.cacheQueryMap.get("saleorgid"))))))))))))))))
      {
        customers = (ArrayList)this.cacheCustomers.clone();
      } else {
        customers = pp.getCustomerCollection(queryparams);
        this.cacheCustomers = ((ArrayList)customers.clone());
      }
      this.cacheQueryMap.put("customergroupStandardId", groupStandardId);
      this.cacheQueryMap.put("isCustomerGroup", Boolean.valueOf(isCustomerGroup));
      this.cacheQueryMap.put("customerparentId", parentId);
      this.cacheQueryMap.put("saleorgid", ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getId().toString());
      if (parentId == null) {
        this.treeMain.removeAllChildrenFromParent(this.rootNode);
        int size = customers.size();
        for (int i = 0; i < size; ++i) {
          PriceCompositionInfo pci = (PriceCompositionInfo)customers.get(i);
          DefaultKingdeeTreeNode tmp = new DefaultKingdeeTreeNode(pci);
          if ((pci.isLeaf()) && (!(pci.isCustomerGroup())))
            tmp.setAllowsChildren(false);
          else {
            tmp.setAllowsChildren(true);
          }
          this.treeMain.addNodeInto(tmp, this.rootNode);
        }
      } else {
        this.treeMain.removeAllChildrenFromParent(this.currentNode);
        int size = customers.size();
        for (int i = 0; i < size; ++i) {
          PriceCompositionInfo pci = (PriceCompositionInfo)customers.get(i);
          DefaultKingdeeTreeNode tmp = new DefaultKingdeeTreeNode(pci);
          if ((pci.isLeaf()) && (!(pci.isCustomerGroup())))
            tmp.setAllowsChildren(false);
          else {
            tmp.setAllowsChildren(true);
          }
          this.treeMain.addNodeInto(tmp, this.currentNode);
        }
      }
    } catch (Exception e) {
      logger.error(e);
    }
  }

  private void expandMaterial(String parentId, boolean isMaterialGroup) {
    try {
      IDiscountSet pp = (IDiscountSet)getBizInterface();

      HashMap queryparams = new HashMap();

      queryparams.clear();
      queryparams.put("isMaterialGroup", Boolean.valueOf(isMaterialGroup));
      queryparams.put("materialparentId", parentId);
      queryparams.put("saleorgid", ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getId().toString());
      ArrayList materials = new ArrayList();
      if ((this.cacheQueryMap != null) && ((((queryparams.get("isMaterialGroup") == null) && (this.cacheQueryMap.get("isMaterialGroup") == null)) || ((queryparams.get("isMaterialGroup") != null) && (this.cacheQueryMap.get("isMaterialGroup") != null) && (queryparams.get("isMaterialGroup").equals(this.cacheQueryMap.get("isMaterialGroup"))) && ((((queryparams.get("materialparentId") == null) && (this.cacheQueryMap.get("materialparentId") == null)) || ((queryparams.get("materialparentId") != null) && (this.cacheQueryMap.get("materialparentId") != null) && (queryparams.get("materialparentId").equals(this.cacheQueryMap.get("materialparentId"))) && ((((queryparams.get("saleorgid") == null) && (this.cacheQueryMap.get("saleorgid") == null)) || ((queryparams.get("saleorgid") != null) && (this.cacheQueryMap.get("saleorgid") != null) && (queryparams.get("saleorgid").equals(this.cacheQueryMap.get("saleorgid")))))))))))))
      {
        materials = (ArrayList)this.cacheMaterials.clone();
      } else {
        materials = pp.getMaterialCollection(queryparams);
        this.cacheMaterials = ((ArrayList)materials.clone());
      }
      this.cacheQueryMap.put("isMaterialGroup", Boolean.valueOf(isMaterialGroup));
      this.cacheQueryMap.put("materialparentId", parentId);
      this.cacheQueryMap.put("saleorgid", ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getId().toString());
      if (parentId == null) {
        this.treeMain.removeAllChildrenFromParent(this.rootNode);
        int size = materials.size();
        for (int i = 0; i < size; ++i) {
          PriceCompositionInfo pci = (PriceCompositionInfo)materials.get(i);
          DefaultKingdeeTreeNode tmp = new DefaultKingdeeTreeNode(pci);
          if ((pci.isLeaf()) && (!(pci.isCustomerGroup())))
            tmp.setAllowsChildren(false);
          else {
            tmp.setAllowsChildren(true);
          }
          this.treeMain.addNodeInto(tmp, this.rootNode);
        }
      } else {
        this.treeMain.removeAllChildrenFromParent(this.currentNode);
        int size = materials.size();
        for (int i = 0; i < size; ++i) {
          PriceCompositionInfo pci = (PriceCompositionInfo)materials.get(i);
          DefaultKingdeeTreeNode tmp = new DefaultKingdeeTreeNode(pci);
          if ((pci.isLeaf()) && (!(pci.isCustomerGroup()))) {
            tmp.setAllowsChildren(false);
          }
          else {
            tmp.setAllowsChildren(true);
          }
          this.treeMain.addNodeInto(tmp, this.currentNode);
        }
      }
    } catch (Exception e) {
      logger.error(e);
    }
  }

 

  private void autoAssignValue(KDTEditEvent e)
  {
    int row = e.getRowIndex();
    int col = e.getColIndex();
    String fieldName = this.kdtEntries.getColumn(col).getKey();
    ICell tmpCell = this.kdtEntries.getRow(row).getCell(col);
    if (("materialGroupNumber".equals(fieldName)) && (!(this.kdtEntries.getColumn("materialGroupNumber").getStyleAttributes().isHided())))
    {
      if (!(tmpCell.getValue() instanceof MaterialGroupInfo)) {
        return;
      }
      MaterialGroupInfo mgi = (MaterialGroupInfo)tmpCell.getValue();
      if (mgi != null)
        this.kdtEntries.getRow(row).getCell("materialGroupName").setValue(mgi.getName());
    }
    else if (("customerGroupNumber".equals(fieldName)) && (!(this.kdtEntries.getColumn("customerGroupNumber").getStyleAttributes().isHided())))
    {
      if (!(tmpCell.getValue() instanceof CSSPGroupInfo)) {
        return;
      }
      CSSPGroupInfo cgi = (CSSPGroupInfo)tmpCell.getValue();
      if (cgi != null) {
        this.kdtEntries.getRow(row).getCell("customerGroupName").setValue(cgi.getName());
      }
    }
    else if (("customerNumber".equals(fieldName)) && (!(this.kdtEntries.getColumn("customerNumber").getStyleAttributes().isHided())))
    {
      if (!(tmpCell.getValue() instanceof CustomerInfo)) {
        return;
      }
      CustomerInfo cii = (CustomerInfo)tmpCell.getValue();
      if (cii != null) {
        this.kdtEntries.getRow(row).getCell("customerNumber").setValue(cii);
        this.kdtEntries.getRow(row).getCell("customerName").setValue(cii.getName());
      }
    } else if ("currency".equals(fieldName))
    {
      setPriceWithMaterailBasePrice(row);
    } else if ("asistProperty".equals(fieldName)) {
      setPriceWithMaterailBasePrice(row);
    } else if ("basicUnit".equals(fieldName)) {
      setPriceWithMaterailBasePrice(row);
    } else if (("discount".equals(fieldName)) || ("discountMode".equals(fieldName))) {} else if ("priceType".equals(fieldName)) {}
  }

  private void setEntryAssistProperty(int rowIndex, MaterialInfo materialInfo) {
    if ((materialInfo != null) && (materialInfo.getAssistAttr() != null)) {
      String assistAttrTypeID = (materialInfo.getAssistAttr() == null) ? null : materialInfo.getAssistAttr().getId().toString();

      KDBizPromptBox bizAssistPropertyBox = new KDBizPromptBox();

      SCMClientUtils.setAsstAttrInputF7(bizAssistPropertyBox, materialInfo, this);
      this.kdtEntries.getRow(rowIndex).getCell("asistProperty").setEditor(new KDTDefaultCellEditor(bizAssistPropertyBox));

      this.kdtEntries.getRow(rowIndex).getCell("asistProperty").getStyleAttributes().setLocked(false);
    }
    else
    {
      this.kdtEntries.getRow(rowIndex).getCell("asistProperty").setEditor(null);
      this.kdtEntries.getRow(rowIndex).getCell("asistProperty").setValue(null);

      this.kdtEntries.getRow(rowIndex).getCell("asistProperty").getStyleAttributes().setLocked(true);
      this.kdtEntries.getRow(rowIndex).getCell("asistProperty").getStyleAttributes().setBackground(Color.white);
    }
  }

  public void actionAuditEntries_actionPerformed(ActionEvent e)
    throws Exception
  {
    if (OprtState.ADDNEW.equals(getOprtState())) {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "policycannotaudit"));
      SysUtil.abort();
    }
    checkSelected();
    int isYes = MsgBox.showConfirm2(this, EASResource.getString(RESOURCE, "auditAlert"));
    if (MsgBox.isYes(isYes)) {
      ArrayList aids = null;
      String[] IDs = (String[])aids.toArray(new String[0]);
      IObjectPK[] pks = new ObjectUuidPK[IDs.length];
      for (int i = 0; i < pks.length; ++i) {
        pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
      }
      DiscountSetEntryFactory.getRemoteInstance().auditForEntries(pks);

      DiscountSetCache.clearCache();
    }
    MsgBox.showInfo(this, EASResource.getString(RESOURCE, "auditSuccess"));
    refreshList();
  }

  public void actionUnAuditEntries_actionPerformed(ActionEvent e)
    throws Exception
  {
    if (OprtState.ADDNEW.equals(getOprtState())) {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "policycannotunaudit"));
      SysUtil.abort();
    }
    checkSelected();
    int isYes = MsgBox.showConfirm2(this, EASResource.getString(RESOURCE, "unAuditAlert"));
    if (MsgBox.isYes(isYes)) {
      ArrayList aids = null;
      String[] IDs = (String[])aids.toArray(new String[0]);
      IObjectPK[] pks = new ObjectUuidPK[IDs.length];
      for (int i = 0; i < pks.length; ++i) {
        pks[i] = new ObjectUuidPK(BOSUuid.read(IDs[i]));
      }

      DiscountSetEntryFactory.getRemoteInstance().unAuditForEntries(pks);

      DiscountSetCache.clearCache();
    }
    MsgBox.showInfo(this, EASResource.getString(RESOURCE, "unAuditSuccess"));
    refreshList();
  }

  public void actionCopyEntry_actionPerformed(ActionEvent e)
    throws Exception
  {
    checkSelected();

    ArrayList aids = getSelectedRows();

    int size = aids.size();

    for (int i = 0; i < size; ++i) {
      IRow oldRow = this.kdtEntries.getRow(((Integer)aids.get(i)).intValue());
      DiscountSetEntryInfo info = (DiscountSetEntryInfo)oldRow.getUserObject();

      DiscountSetEntryInfo infoCopy = (DiscountSetEntryInfo)info.clone();
      infoCopy.setId(null);
      addLine(getDetailTable(), infoCopy);
    }

    refreshList();
  }

  private void addLine(KDTable table, IObjectValue detailData)
  {
    if (table == null) {
      return;
    }
    IRow row = table.addRow();
    loadLineFields(table, row, detailData);
    afterAddLine(table, detailData);
  }

  protected ArrayList getSelectedRows()
  {
    ArrayList list = new ArrayList();

    KDTSelectBlock selectBlock = null;
    int size = this.kdtEntries.getSelectManager().size();

    if ((size == 0) || (this.kdtEntries.getSelectManager().getActiveRowIndex() < 0)) {
      return list;
    }

    if ((size == 1) && (this.kdtEntries.getSelectManager().get().getTop() == this.kdtEntries.getSelectManager().get().getBottom()))
    {
      int rowNum = this.kdtEntries.getSelectManager().get().getTop();

      list.add(new Integer(rowNum));
    } else {
      for (int i = 0; i < size; ++i)
      {
        selectBlock = this.kdtEntries.getSelectManager().get(i);

        for (int j = selectBlock.getTop(); j <= selectBlock.getBottom(); ++j) {
          if (!(list.contains(new Integer(j)))) {
            list.add(new Integer(j));
          }
        }
      }
    }

    return list;
  }

  protected String getKeyFieldName() {
    return "id";
  }

  private void refreshList()
  {
  }

  public void checkSelected() {
    if (this.kdtEntries.getSelectManager().size() == 0) {
      MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
      SysUtil.abort();
    }
  }

  protected IObjectValue createNewData()
  {
    DiscountSetInfo ppi = null;
    try {
      ppi = DiscountSetAgent.create();
    } catch (BOSException ex) {
      super.handleException(ex);
    }

    ppi.setBlockedStatus(ForbidStatusEnum.UNFORBID);
    ppi.setCheckedStatus(CheckedStatusEnum.UNAUDITED);
    ppi.setPriceComposition(PriceCompositionEnum.CM);
    ppi.setPriceCompDetailCustomer(PriceCompDetailEnum.CUSTOMER);
    ppi.setPriceCompDetailmaterial(PriceCompDetailEnum.MATERIAL);

    ppi.setGroupStandardCustomer((CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem());
//    Date nowDay = new Date();
    Calendar cl = Calendar.getInstance();
    cl.set(cl.get(1), cl.get(2), cl.get(5),0,0,0);
    
    ppi.setEffectiveDate(cl.getTime());
    ppi.setExpireDate(getExpireDate());

    if (getDefaultMainBizOrg() instanceof SaleOrgUnitInfo)
      ppi.setSaleOrgUnit((SaleOrgUnitInfo)getDefaultMainBizOrg());
    else {
      ppi.setSaleOrgUnit(null);
    }
    return ppi;
  }

  private Date getExpireDate()
  {
    Calendar cl = Calendar.getInstance();
    cl.set(cl.get(1) + 1, cl.get(2), cl.get(5),23,59,59);
    
    return cl.getTime();
  }

  protected ICoreBase getBizInterface()
    throws Exception
  {
    return DiscountSetFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
  }

  protected KDTable getDetailTable()
  {
    return this.kdtEntries;
  }

  protected KDTable getTableForCommon()
  {
    return this.kdtEntries;
  }

  public void actionEdit_actionPerformed(ActionEvent e) throws Exception
  {
    DiscountSetInfo info = (DiscountSetInfo)getUIContext().get("CURRENT.VO");
    if (!(((IDiscountSet)getBizInterface()).isCanDelete(info.getId().toString()))) {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "auditcannotedit"));
      SysUtil.abort();
    }
    super.actionEdit_actionPerformed(e);
//    this.kdtEntries.getStyleAttributes().setLocked(false);
//   
//    initEntry();
//    
//    initUI();
//    
//    // 设置分录 可编辑状态
//    initEntryEditableState();
  }

  public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
    if (!(entryInput())) {
      return;
    }

    super.actionAddLine_actionPerformed(e);
  }

  protected void loadLineFields(KDTable table, IRow row, IObjectValue obj) {
    super.loadLineFields(table, row, obj);
    try {
      afterInsertMaterialInfo(row.getRowIndex());
    } catch (Exception e) {
      logger.error(e);
    }
  }

  public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception {
    if (!(entryInput())) {
      return;
    }
    super.actionInsertLine_actionPerformed(e);
  }

  protected void afterRemoveLine(KDTable table, IObjectValue lineData) {
    super.afterRemoveLine(table, lineData);
    if ((!(lineData instanceof DiscountSetEntryInfo)) || 
      (((DiscountSetEntryInfo)lineData).getId() == null)) return;
    this.entryids.add(((DiscountSetEntryInfo)lineData).getId().toString());
  }

  private boolean entryInput()
  {
    PriceCompositionInfo info = null;
    if ((this.currentNode != null) && (!(this.currentNode.equals(this.rootNode)))) {
      info = (PriceCompositionInfo)this.currentNode.getUserObject();
    }

    PriceCompDetailEnum tmp = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();

    if ((PriceCompDetailEnum.CUSTOMER.equals(tmp)) && (((info == null) || (!(PriceCompDetailEnum.CUSTOMER.equals(info.getCompType()))))))
    {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "sltcustomer"));
      return false;
    }
    if ((PriceCompDetailEnum.CUSTOMERGROUP.equals(tmp)) && (((info == null) || (!(PriceCompDetailEnum.CUSTOMERGROUP.equals(info.getCompType()))))))
    {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "sltCustomerGroup"));
      return false;
    }
    if ((PriceCompDetailEnum.MATERIAL.equals(tmp)) && (((info == null) || (!(PriceCompDetailEnum.MATERIAL.equals(info.getCompType()))))))
    {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "sltMaterial"));
      return false;
    }
    if ((PriceCompDetailEnum.MATERIALGROUP.equals(tmp)) && (((info == null) || (!(PriceCompDetailEnum.MATERIALGROUP.equals(info.getCompType()))))))
    {
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "sltMaterialGroup"));
      return false;
    }
    return true;
  }

  protected IObjectValue createNewDetailData(KDTable table)
  {
//    if (this.currentNode == this.rootNode)
//    {
//      MsgBox.showInfo(null, "不能选择根节点修改，请在左边的树中选择对应的节点。");
//      SysUtil.abort();
//    }
//    PriceCompositionInfo info = (PriceCompositionInfo)this.currentNode.getUserObject();

    DiscountSetEntryInfo entryInfo = null;
    try {
      entryInfo = DiscountSetEntryAgent.create();
    } catch (BOSException ex) {
      super.handleException(ex);
    }
    DiscountTypeEnum dtEnum = (DiscountTypeEnum)this.discountType.getSelectedItem();
	DiscountUnitTypeEnum unitTypeEnum = DiscountUnitTypeEnum.YUAN;
	if(DiscountTypeEnum.ShiWu.equals(dtEnum)){
		unitTypeEnum = DiscountUnitTypeEnum.BAO;
	}
	entryInfo.setLockedState(EntryState.UnLocked);
	
	entryInfo.setDiscountUnitType(unitTypeEnum);
	
    entryInfo.setDiscountCondition(DiscountConditionEnum.QUANTITY);

    entryInfo.setEffectiveDate(this.pkEffectiveDate.getSqlDate());

    entryInfo.setExpireDate(this.pkExpireDate.getSqlDate());
    entryInfo.setDiscountCondition(DiscountConditionEnum.AMOUNT);
//    entryInfo.setDiscount(DEFAULTNUM);

    CurrencyInfo currencyInfo = null;
    if (SysContext.getSysContext().getCurrentFIUnit() != null) {
      CompanyOrgUnitInfo ficompanyOrgInfo = SysContext.getSysContext().getCurrentFIUnit();
      if ((ficompanyOrgInfo != null) && (ficompanyOrgInfo.getBaseCurrency() != null))
        try
        {
          currencyInfo = CurrencyFactory.getRemoteInstance().getCurrencyInfo(new ObjectUuidPK(ficompanyOrgInfo.getBaseCurrency().getId()));
        }
        catch (EASBizException e)
        {
          e.printStackTrace();
        } catch (BOSException e) {
          e.printStackTrace();
        }
    }
    else
    {
      EntityViewInfo currencyView = new EntityViewInfo();
      currencyView.setFilter(new FilterInfo());
      currencyView.getFilter().getFilterItems().add(new FilterItemInfo("isoCode", "RMB"));
      try
      {
        CurrencyCollection currencyCollection = CurrencyFactory.getRemoteInstance().getCurrencyCollection(currencyView);
        if (currencyCollection.size() > 0)
          currencyInfo = currencyCollection.get(0);
      }
      catch (Exception e) {
        super.handUIException(e);
      }
    }
    entryInfo.setCurrency(currencyInfo);

//    entryInfo.put("PriceCompositionInfo", info);

//    if (PriceCompDetailEnum.CUSTOMER.equals(info.getCompType()))
//    {
//      CustomerInfo ci = new CustomerInfo();
//      ci.setId(BOSUuid.read(info.getId()));
//      ci.setName(info.getName());
//      ci.setNumber(info.getNumber());
//      entryInfo.setCustomer(ci);

//      CSSPGroupStandardInfo cgsInfo = (CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem();

//      entryInfo.setCustomerGroupStandard(cgsInfo);
//    } else if (PriceCompDetailEnum.CUSTOMERGROUP.equals(info.getCompType()))
//    {
//      CSSPGroupInfo ci = new CSSPGroupInfo();
//      ci.setId(BOSUuid.read(info.getId()));
//      ci.setName(info.getName());
//      ci.setNumber(info.getNumber());
//      ci.setLongNumber(info.getGroupLongnumber());
////      entryInfo.setCustomerGroup(ci);
//
//      CSSPGroupStandardInfo cgsInfo = (CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem();
//
////      entryInfo.setCustomerGroupStandard(cgsInfo);
//    } else if (PriceCompDetailEnum.MATERIAL.equals(info.getCompType()))
//    {
//      MaterialInfo ci = new MaterialInfo();
//      try
//      {
//        IMaterial material = MaterialFactory.getRemoteInstance();
//        IObjectPK op = new ObjectStringPK(info.getId().toString());
//        ci = material.getMaterialInfo(op);
//      }
//      catch (BOSException e) {
//        logger.error(e);
//      }
//      catch (EASBizException e) {
//        logger.error(e);
//      }
//      entryInfo.setMaterial(ci);
//    } 
//    else if (PriceCompDetailEnum.MATERIALGROUP.equals(info.getCompType()))
//    {
//      MaterialGroupInfo ci = new MaterialGroupInfo();
//      ci.setId(BOSUuid.read(info.getId()));
//      ci.setName(info.getName());
//      ci.setNumber(info.getNumber());
//      ci.setLongNumber(info.getGroupLongnumber());
////      entryInfo.setMaterialGroup(ci);
//    }
    return entryInfo;
  }

  protected void verifyInput(ActionEvent e)
    throws Exception
  {
	  // 不区分客户，则不校验客户是否选中
	  boolean isAllCustomer = this.chkisAllCustomer.isSelected();
	  
    if ((this.prmtSaleOrgUnit.isRequired()) && (isNull(this.editData.getSaleOrgUnit()))) {
      MsgBox.showInfo(this, SCMClientUtils.getResource("SALEORGNOTNULL"));

      SysUtil.abort();
    }

    if (isNull(this.editData.getNumber()))
    {
      this.txtNumber.requestFocus();
//      MsgBox.showInfo(this, SCMClientUtils.getResource("SALEORGNOTNULL"));
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "NUMBERISNULL"));
      SysUtil.abort();
//      throw new DiscountSetException(DiscountSetException.NUMBERISNULL);
    }
    
    if (isNull(this.editData.getName()))
    {
      this.txtName.requestFocus();
      MsgBox.showInfo(this, EASResource.getString(RESOURCE, "nameisnull"));
      SysUtil.abort();
//      throw new DiscountSetException(DiscountSetException.NAMEISNULL);
    }
    
    if (isNull(this.editData.getPriceCompDetailCustomer()))
    {
      this.comboPriceCompDetailCustomer.requestFocus();
      throw new DiscountSetException(DiscountSetException.CUSTOMERCOMISNULL);
    }

    if (isNull(this.editData.getPriceCompDetailmaterial()))
    {
      this.comboPriceCompDetailMaterial.requestFocus();
      throw new DiscountSetException(DiscountSetException.MATERIALCOMISNULL);
    }

    if (this.editData.getEffectiveDate().compareTo(this.editData.getExpireDate()) > 0) {
      DiscountSetException exception = new DiscountSetException(DiscountSetException.VERIFY_EXP_NOT_SMALLER_THAN_EFF);
      showMessageInfo(exception.getMessage());
    }
    // 累计 政策  累计开始时间和累计结束时间 校验
    if(this.editData.isByMonthQtyLimit()){
    	if(this.editData.getAccumulaBeginDate()  == null || this.editData.getAccumulaEnddate() == null){
    		MsgBox.showInfo(this, "累计销量的政策，【累计开始日期】和【累计结束日期】均不能为空");
    		pkaccumulaBeginDate.requestFocus();
    	    SysUtil.abort();
    	}else if(this.editData.getAccumulaBeginDate().compareTo(this.editData.getAccumulaEnddate()) > 0){
    		MsgBox.showInfo(this, "【累计开始日期】 不能大于 【累计结束日期】");
    		pkaccumulaBeginDate.requestFocus();
  	        SysUtil.abort();
    	}	
    }
    
    int nrow = this.kdtEntries.getRowCount();

    if (nrow <= 0)
    {
      return;
    }

    for (int row = 0; row < nrow; ++row)
    {
      IRow arow = this.kdtEntries.getRow(row);
      checkIsNeedShowMessage(row + 1, arow);
    }
    Map sameEntryMap = new HashMap();

    PriceCompDetailEnum customerEnum = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
    PriceCompDetailEnum materialEnum = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();
    for (int row = 0; row < nrow; ++row) {
      IRow arow = this.kdtEntries.getRow(row);
      Object customer = arow.getCell("customerNumber").getValue();
      Object material = arow.getCell("materialNumber").getValue();
      
      if(!isAllCustomer && customer == null){
    	  MsgBox.showInfo("明细行数据客户不能为空");
    	  SysUtil.abort();
      }
      if(material == null){
    	  MsgBox.showInfo("明细行数据物料不能为空");
    	  SysUtil.abort();
      }
      
      String tempEntryStr = null;
      String message = null;
//      // 区分客户
//      if ( customerEnum.equals(PriceCompDetailEnum.CUSTOMER)) {
//        
        if(customer != null){
	        tempEntryStr = ((CustomerInfo)customer).getId().toString();
	        message = "客户、";
        }
        if(material != null){
	        tempEntryStr = tempEntryStr + ((MaterialInfo)material).getId().toString();
	        message = message + "物料、";
	     } 
//      else if (customerEnum.equals(PriceCompDetailEnum.MATERIAL)) {
//       
//        tempEntryStr = ((MaterialInfo)material).getId().toString();
//        message = "物料、";
//        if (materialEnum.equals(PriceCompDetailEnum.CUSTOMER))
//        {
////          Object customer = arow.getCell("customerNumber").getValue();
//          if(customer != null){
//	          tempEntryStr = tempEntryStr + ((CustomerInfo)customer).getId().toString();
//	          message = message + "客户、";
//          }
//        } 
//      } else if (customerEnum.equals(PriceCompDetailEnum.MATERIALGROUP)) {}
//      if (arow.getCell("asistProperty").getValue() instanceof AsstAttrValueInfo) {
//        tempEntryStr = tempEntryStr + ((AsstAttrValueInfo)arow.getCell("asistProperty").getValue()).getId().toString();
//        message = message + "辅助属性、";
//      }
//      if (arow.getCell("discountCondition").getValue() instanceof DiscountConditionEnum) {
//        tempEntryStr = tempEntryStr + ((DiscountConditionEnum)arow.getCell("discountCondition").getValue()).getValue();
//        message = message + "折扣条件、";
//      }
//      if (arow.getCell("basicUnit").getValue() instanceof MeasureUnitInfo) {
//        tempEntryStr = tempEntryStr + ((MeasureUnitInfo)arow.getCell("basicUnit").getValue()).getId().toString();
//        message = message + "计量单位、";
//      }
//      if (arow.getCell("currency").getValue() instanceof CurrencyInfo) {
//        tempEntryStr = tempEntryStr + ((CurrencyInfo)arow.getCell("currency").getValue()).getId().toString();
//        message = message + "币别、";
//      }
     
      if(EntryState.Locked.equals(((EntryState)arow.getCell("lockedState").getValue()))){
    	  continue;
      }
      if (arow.getCell("lockedState").getValue() instanceof EntryState  && EntryState.UnLocked.equals(((EntryState)arow.getCell("lockedState").getValue()))) {
        tempEntryStr = tempEntryStr + EntryState.UnLocked.toString();
      }
      if (sameEntryMap.containsValue(tempEntryStr)) {
        message = message + "客户、物料、分录状态（启用）";
        MsgBox.showInfo("分录" + (row + 1) + "和分录" + getMapKey(sameEntryMap, tempEntryStr) + "\n" + message + "重复，请确认!");

        SysUtil.abort();
      } else {
        sameEntryMap.put(String.valueOf(row + 1), tempEntryStr);
      }
    }
    checkHasBasePrice(); }

  private String getMapKey(Map map, Object value) {
    Object[] keys = map.keySet().toArray();
    String key = null;
    int i = 0; for (int c = keys.length; i < c; ++i) {
      if (map.get(keys[i]).equals(value)) {
        key = keys[i].toString();
        break;
      }
    }
    return key;
  }

  private void checkHasBasePrice()
  {
    if ((!(this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.CM))) && (!(this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.CGM))) && (!(this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.MC))) && (!(this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.MCG)))) {
      return;
    }

    StringBuffer materialIds = new StringBuffer();
    int row = 0; for (int nrow = this.kdtEntries.getRowCount(); row < nrow; ++row) {
      IRow arow = this.kdtEntries.getRow(row);
      if (arow.getCell("materialNumber").getValue() instanceof MaterialInfo) {
        if (materialIds.length() > 0) {
          materialIds.append(",");
        }
        materialIds.append(((MaterialInfo)arow.getCell("materialNumber").getValue()).getId().toString());
      }
    }
    StringBuffer errMsg = new StringBuffer();
    String cuid = ((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getCU().getId().toString();
    try {
      if (!(this.isSubordinateAddnewable)) {
        IMaterialBasePrice iBasePrice = MaterialBasePriceFactory.getRemoteInstance();
        Map result = iBasePrice.existsBasePrice(materialIds.toString().split(","), cuid);
        int row2 = 0; for (int nrow = this.kdtEntries.getRowCount(); row2 < nrow; ++row2) {
          IRow arow = this.kdtEntries.getRow(row2);
          if (arow.getCell("materialNumber").getValue() instanceof MaterialInfo) {
            if (result.get(((MaterialInfo)arow.getCell("materialNumber").getValue()).getId().toString()) instanceof Boolean)
              continue;
            if (errMsg.length() > 0) {
              errMsg.append(",");
            }
            errMsg.append(row2 + 1);
          }
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    if (errMsg.length() > 0) {
      MsgBox.showInfo(EASResource.getString(RESOURCE, "ROWNO") + errMsg + EASResource.getString(RESOURCE, "HASNOBASEPRICE"));

      SysUtil.abort();
    }
  }

  private void checkIsNeedShowMessage(int rowindex, IRow arow)
  {
//    PriceCompDetailEnum customerEnum = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
//    PriceCompDetailEnum materialEnum = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();
//    DiscountSetException exception = null;
//    if (customerEnum.equals(PriceCompDetailEnum.CUSTOMER)) {
//      Object customer = arow.getCell("customerNumber").getValue();
//      
//      
//      if (materialEnum.equals(PriceCompDetailEnum.MATERIAL))
//      {
//        Object material = arow.getCell("materialNumber").getValue();
//        if (isNull(material)) {
//          exception = new DiscountSetException(DiscountSetException.MATERIALCODEISNULL);
//          showMessageInfo(EASResource.getString(RESOURCE, "ROWNO") + rowindex + EASResource.getString(RESOURCE, "COLNO") + "：" + ((CustomerInfo)customer).getName() + exception.getMessage());
//        }
//
//      }
//      else if (materialEnum.equals(PriceCompDetailEnum.MATERIALGROUP))
//      {}
//
//      checkCommonField(EASResource.getString(RESOURCE, "ROWNO") + rowindex + EASResource.getString(RESOURCE, "COLNO") + "：" + ((CustomerInfo)customer).getName(), arow);
//    }
//    else if (customerEnum.equals(PriceCompDetailEnum.CUSTOMERGROUP)) {}
//    else if (customerEnum.equals(PriceCompDetailEnum.MATERIAL)) {
//      Object tmp = arow.getCell("materialNumber").getValue();
//      if (materialEnum.equals(PriceCompDetailEnum.CUSTOMER))
//      {
//        Object material = arow.getCell("customerNumber").getValue();
//        if (isNull(material)) {
//          exception = new DiscountSetException(DiscountSetException.CUSTOMERCODEISNULL);
//          showMessageInfo(EASResource.getString(RESOURCE, "ROWNO") + rowindex + EASResource.getString(RESOURCE, "COLNO") + "：" + ((MaterialInfo)tmp).getName() + exception.getMessage());
//        }
//
//      }
//      else if (materialEnum.equals(PriceCompDetailEnum.CUSTOMERGROUP))
//      {}
//
//      checkCommonField(EASResource.getString(RESOURCE, "ROWNO") + rowindex + EASResource.getString(RESOURCE, "COLNO") + "：" + ((MaterialInfo)tmp).getName(), arow);
//    }
//    else if (customerEnum.equals(PriceCompDetailEnum.MATERIALGROUP)) {}
  }

  private void checkCommonField(String title, IRow arow)
  {
    DiscountSetException exception = null;

//    BigDecimal qtyMax = (BigDecimal)arow.getCell("qtyMax").getValue();
//    BigDecimal qtyMin = (BigDecimal)arow.getCell("qtyMin").getValue();
//    if ((qtyMax != null) && (qtyMin != null) && (qtyMax.longValue() < qtyMin.longValue())) {
//      exception = new DiscountSetException(DiscountSetException.QTYMAXISTOOSMALL);
//      showMessageInfo(title + exception.getMessage());
//    }

//    BigDecimal amtMax = (BigDecimal)arow.getCell("amtMax").getValue();
//    BigDecimal amtMin = (BigDecimal)arow.getCell("amtMin").getValue();
//    if ((amtMax != null) && (amtMin != null) && (amtMax.doubleValue() < amtMin.doubleValue())) {
//      exception = new DiscountSetException(DiscountSetException.AMTMAXISTOOSMALL);
//      showMessageInfo(title + exception.getMessage());
//    }

//    Object tmp = arow.getCell("currency").getValue();
//    if (isNull(tmp)) {
//      exception = new DiscountSetException(DiscountSetException.CURRENCYISNULL);
//      showMessageInfo(title + exception.getMessage());
//    }

//    tmp = arow.getCell("price").getValue();
//    if (isNull(tmp)) {
//      exception = new DiscountSetException(DiscountSetException.PRICEISNULL);
//      showMessageInfo(title + exception.getMessage());
//    }

//    BigDecimal price = (BigDecimal)arow.getCell("price").getValue();
//    tmp = arow.getCell("priceMin").getValue();
//    if (tmp != null) {
//      BigDecimal priceMin = (BigDecimal)tmp;
//      if (arow.getCell("discountMode").getValue().equals(DiscountModeEnum.PERCENT)) {
//        BigDecimal discount = (BigDecimal)arow.getCell("discount").getValue();
//        BigDecimal transferRate = HUNDREDNUM.subtract(discount).divide(HUNDREDNUM, this.precision, 4);
//        price = price.multiply(transferRate).setScale(this.precision, 4);
//      }
//      if (priceMin.doubleValue() > price.doubleValue()) {
//        exception = new DiscountSetException(DiscountSetException.PRICEMINTOOLARGE);
//        showMessageInfo(title + exception.getMessage());
//      }
//    }
//
//    tmp = arow.getCell("priceMax").getValue();
//    if (tmp != null) {
//      BigDecimal priceMax = (BigDecimal)tmp;
//      if ((priceMax.compareTo(DEFAULTNUM) != 0) && (priceMax.compareTo(price) == -1)) {
//        exception = new DiscountSetException(DiscountSetException.PRICEMINTOOSMALL);
//        showMessageInfo(title + exception.getMessage());
//      }
//    }
//
//    if ((arow.getCell("priceMax").getValue() != null) && (arow.getCell("priceMin").getValue() != null))
//    {
//      BigDecimal priceMax = (BigDecimal)arow.getCell("priceMax").getValue();
//      BigDecimal priceMin = (BigDecimal)arow.getCell("priceMin").getValue();
//      if ((priceMax.compareTo(DEFAULTNUM) != 0) && (priceMax.compareTo(priceMin) == -1)) {
//        exception = new DiscountSetException(DiscountSetException.PRICEMAXLESSMIN);
//        showMessageInfo(title + exception.getMessage());
//      }
//    }
//
//    if (arow.getCell("discountMode").getValue().equals(DiscountModeEnum.PERUNIT)) {
//      BigDecimal discount = (BigDecimal)arow.getCell("discount").getValue();
//      if ((price != null) && (discount != null) && (price.compareTo(discount) == -1)) {
//        exception = new DiscountSetException(DiscountSetException.PRICENOTLESSDISCOUNT);
//        showMessageInfo(title + exception.getMessage());
//      }
//
//    }
//
//    if ((arow.getCell("expireDate").getValue() != null) && (arow.getCell("effectiveDate").getValue() != null))
//    {
//      Date expDate = (Date)arow.getCell("expireDate").getValue();
//      Date effDate = (Date)arow.getCell("effectiveDate").getValue();
//      if (expDate.compareTo(effDate) < 0) {
//        exception = new DiscountSetException(DiscountSetException.VERIFY_EXP_NOT_SMALLER_THAN_EFF);
//        showMessageInfo(title + exception.getMessage());
//      }
//
//    }

//    PriceCompDetailEnum customer = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
//    PriceCompDetailEnum material = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();
//    if ((customer.getValue() != 1) || (material.getValue() != 3) || (arow.getCell("basicUnit").getValue() != null)) {
//      return;
//    }
//    exception = new DiscountSetException(DiscountSetException.VERIFY_UNIT_NOT_NULL);
//    showMessageInfo(title + exception.getMessage());
  }

  private void showMessageInfo(String msg)
  {
    MsgBox.showInfo(msg);
    SysUtil.abort();
  }

  private void isNullCode(IRow arow) throws Exception
  {
    PriceCompositionEnum pc = (PriceCompositionEnum)this.priceComposition.getSelectedItem();

    int pcValue = -1;
    if (pc == null)
    {
      PriceCompDetailEnum customerEnum = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();

      PriceCompDetailEnum materialEnum = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();

      pcValue = customerEnum.getValue() ^ materialEnum.getValue();
    }
    switch (pcValue)
    {
    case 2:
      Object tmp = arow.getCell("customerNumber").getValue();
      if (!(isNull(tmp)))
        return;
      throw new DiscountSetException(DiscountSetException.CUSTOMERCODEISNULL);
    case 1:
//      Object tmp5 = arow.getCell("customerGroupNumber").getValue();
//      if (isNull(tmp5))
//      {
//        throw new DiscountSetException(DiscountSetException.CUSTOMERGROUPISNULL);
//      }

//      tmp5 = arow.getCell("materialNumber").getValue();
//      if (!(isNull(tmp5)))
//        return;
//      throw new DiscountSetException(DiscountSetException.MATERIALCODEISNULL);
    case 5:
      Object tmp2 = arow.getCell("customerNumber").getValue();
      if (isNull(tmp2))
      {
        throw new DiscountSetException(DiscountSetException.CUSTOMERCODEISNULL);
      }

//      tmp2 = arow.getCell("materialGroupNumber").getValue();
//      if (!(isNull(tmp2)))
//        return;
//      throw new DiscountSetException(DiscountSetException.MATERIALGROUPCODEISNULL);
   
    case 3:
    case 4:
    }
  }

  private boolean isNull(Object o)
  {
    return ((o == null) || ((o.toString() != null) && (o.toString().equals(""))));
  }

  public void itemStateChanged(ItemEvent evt)
  {
    if (evt.getStateChange() != 1) {
      return;
    }
    removeEntryRows();
    if (evt.getSource() == this.comboPriceCompDetailCustomer)
    {
      comboPriceCompDetailCustomerChanged();
      setPriceComp();
      setpriceCanEdit();
    } else if (evt.getSource() == this.comboPriceCompDetailMaterial)
    {
      comboPriceCompDetailMaterialChanged();
      setPriceComp();
      setpriceCanEdit(); } else {
      if (evt.getSource() != this.comboCustomerGroupStandard)
        return;
      comboCustomerGroupStandardChanged();
    }
  }

  private void comboPriceCompDetailCustomerChanged()
  {
    PriceCompDetailEnum tmp = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
    if (tmp == null)
      return;
    int value = tmp.getValue();
    if (value == 2)
    {
      changeTree();
      columnVisible(PriceCompDetailEnum.CUSTOMERGROUP);
      this.kDLabelContainer4.setVisible(true);
    } else if (value == 1)
    {
      changeTree();
      columnVisible(PriceCompDetailEnum.CUSTOMER);
      this.kDLabelContainer4.setVisible(true);
    } else if (value == 3)
    {
      changeTree();
      columnVisible(PriceCompDetailEnum.MATERIAL);
      this.kDLabelContainer4.setVisible(false); } else {
      if (value != 4)
        return;
      changeTree();
      columnVisible(PriceCompDetailEnum.MATERIALGROUP);
      this.kDLabelContainer4.setVisible(false);
    }
  }

  private void comboPriceCompDetailMaterialChanged()
  {
    PriceCompDetailEnum tmp = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();
    if (tmp == null)
      return;
    int value = tmp.getValue();
    if (value == 4)
    {
      materialGroupVisible();
    }
    else if (value == 3)
    {
      materialVisible();
    }
    else if (value == 1)
    {
      customerVisible();
    } else {
      if (value != 2)
        return;
      customerGroupVisible();
    }
  }

  private void comboCustomerGroupStandardChanged()
  {
    this.treeMain.removeAllChildrenFromParent(this.rootNode);
    changeTree();
  }

  private void setpriceCanEdit()
  {
    PriceCompositionEnum pce = (PriceCompositionEnum)this.priceComposition.getSelectedItem();

    if (pce == null)
    {
      return;
    }

    if ((((pce.equals(PriceCompositionEnum.CGM)) || (pce.equals(PriceCompositionEnum.CM)))) && (this.isCanNotEditPrice))
    {
//      this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("priceMin").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("priceMax").getStyleAttributes().setLocked(true);
    } else {
//      this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("priceMin").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("priceMax").getStyleAttributes().setLocked(false);
    }
  }

  private void initCustomerGroupStandard()
  {
    try
    {
      ICSSPGroupStandard cs = CSSPGroupStandardFactory.getRemoteInstance();
      EntityViewInfo entityViewInfo = new EntityViewInfo();
      FilterInfo filterInfo = new FilterInfo();
//      filterInfo.getFilterItems().add(new FilterItemInfo("type", new Integer(0)));
      filterInfo.getFilterItems().add(new FilterItemInfo("type", new Integer(1)));
//      filterInfo.setMaskString(" #0 or #1 ");
      entityViewInfo.setFilter(filterInfo);
      CSSPGroupStandardCollection coll = cs.getCSSPGroupStandardCollection(entityViewInfo);
      int size = coll.size();
      if (size > 0);
      for (int i = 0; i < size; ++i)
      {
        this.comboCustomerGroupStandard.addItem(coll.get(i));
        if (!(coll.get(i).toString().trim().equals("客商分类标准")))
          continue;
        this.comboCustomerGroupStandard.setSelectedIndex(i);
      }

    }
    catch (BOSException e)
    {
      logger.error("获取客户分类标准时出现错误。 " + e);
    }
  }

  private void removeEntryRows()
  {
    this.kdtEntries.getUserObject();
    int rowCount = this.kdtEntries.getRowCount();

    for (int i = 0; i < rowCount; ++i)
    {
      IObjectValue detailData = (IObjectValue)this.kdtEntries.getRow(i).getUserObject();
      this.kdtEntries.removeRow(i);
      IObjectCollection collection = (IObjectCollection)this.kdtEntries.getUserObject();
      if (collection == null)
      {
        logger.error("collection not be binded to table");
      }
      else if (detailData != null)
      {
        collection.removeObject(detailData);
      }

      --i;
      --rowCount;
    }
  }

  private void setPriceComp()
  {
    PriceCompDetailEnum customerEnum = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
    PriceCompDetailEnum materialEnum = (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem();
    if ((customerEnum == null) || (materialEnum == null))
    {
      return;
    }

    int value = customerEnum.getValue() ^ materialEnum.getValue();
    switch (value)
    {
    case 2:
      this.priceComposition.setSelectedItem(PriceCompositionEnum.CM);
      break;
    case 1:
      this.priceComposition.setSelectedItem(PriceCompositionEnum.CGM);
      break;
    case 5:
      this.priceComposition.setSelectedItem(PriceCompositionEnum.CMG);
      break;
    case 6:
      this.priceComposition.setSelectedItem(PriceCompositionEnum.CGMG);
    case 3:
    case 4:
    }
  }

  private void columnVisible(PriceCompDetailEnum state)
  {
    if (state == null)
      return;
    Object oldSltItem = this.comboPriceCompDetailMaterial.getSelectedItem();
    switch (state.getValue())
    {
    case 1:
      this.comboPriceCompDetailMaterial.removeItemListener(this);
      this.comboPriceCompDetailMaterial.removeAllItems();
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.MATERIAL);
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.MATERIALGROUP);

      this.comboPriceCompDetailMaterial.setSelectedItem(oldSltItem);
      this.comboPriceCompDetailMaterial.addItemListener(this);
      customerVisible();
      break;
    case 2:
      this.comboPriceCompDetailMaterial.removeItemListener(this);
      this.comboPriceCompDetailMaterial.removeAllItems();
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.MATERIAL);
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.MATERIALGROUP);

      this.comboPriceCompDetailMaterial.setSelectedItem(oldSltItem);
      this.comboPriceCompDetailMaterial.addItemListener(this);
      customerGroupVisible();
      break;
    case 3:
      this.comboPriceCompDetailMaterial.removeItemListener(this);
      this.comboPriceCompDetailMaterial.removeAllItems();
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.CUSTOMER);
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.CUSTOMERGROUP);

      this.comboPriceCompDetailMaterial.setSelectedItem(oldSltItem);
      this.comboPriceCompDetailMaterial.addItemListener(this);
      materialVisible();
      break;
    case 4:
      this.comboPriceCompDetailMaterial.removeItemListener(this);
      this.comboPriceCompDetailMaterial.removeAllItems();
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.CUSTOMER);
      this.comboPriceCompDetailMaterial.addItem(PriceCompDetailEnum.CUSTOMERGROUP);

      this.comboPriceCompDetailMaterial.setSelectedItem(oldSltItem);
      this.comboPriceCompDetailMaterial.addItemListener(this);
      materialGroupVisible();
    }
  }

  private void customerVisible()
  {
//    this.kdtEntries.getColumn("customerGroupNumber").getStyleAttributes().setHided(true);
//    this.kdtEntries.getColumn("customerGroupName").getStyleAttributes().setHided(true);

    this.kdtEntries.getColumn("customerNumber").getStyleAttributes().setHided(false);
    this.kdtEntries.getColumn("customerName").getStyleAttributes().setHided(false);
  }

  private void customerGroupVisible()
  {
//    this.kdtEntries.getColumn("customerGroupNumber").getStyleAttributes().setHided(false);
//    this.kdtEntries.getColumn("customerGroupName").getStyleAttributes().setHided(false);

    this.kdtEntries.getColumn("customerNumber").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("customerName").getStyleAttributes().setHided(true);
  }

  private void materialVisible()
  {
//    this.kdtEntries.getColumn("materialGroupNumber").getStyleAttributes().setHided(true);
//    this.kdtEntries.getColumn("materialGroupName").getStyleAttributes().setHided(true);

    this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setHided(false);
    this.kdtEntries.getColumn("materialName").getStyleAttributes().setHided(false);
    this.kdtEntries.getColumn("materialModel").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("basicUnit").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("asistProperty").getStyleAttributes().setHided(true);
  }

  private void materialGroupVisible()
  {
//    this.kdtEntries.getColumn("materialGroupNumber").getStyleAttributes().setHided(false);
//    this.kdtEntries.getColumn("materialGroupName").getStyleAttributes().setHided(false);

    this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("materialName").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("materialModel").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("basicUnit").getStyleAttributes().setHided(true);
    this.kdtEntries.getColumn("asistProperty").getStyleAttributes().setHided(true);
  }
  
//  public SelectorItemCollection getSelectors()
//  {
//    SelectorItemCollection sic = new SelectorItemCollection();
//    sic.add(new SelectorItemInfo("name"));
//    sic.add(new SelectorItemInfo("number"));
//    sic.add(new SelectorItemInfo("entries.id"));
//    sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.*"));
////    sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.number"));
////    sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.name"));
//    sic.add(new SelectorItemInfo("entries.*"));
//    // 只 加载使用的 字段 TODO
//    sic.add(new SelectorItemInfo("priority"));
//    sic.add(new SelectorItemInfo("effectiveDate"));
//    sic.add(new SelectorItemInfo("expireDate"));
//    sic.add(new SelectorItemInfo("checkedStatus"));
//    sic.add(new SelectorItemInfo("blockedStatus"));
//    sic.add(new SelectorItemInfo("groupStandardCustomer.*"));
//    sic.add(new SelectorItemInfo("priceCompDetailCustomer"));
//    sic.add(new SelectorItemInfo("priceCompDetailMaterial"));
//    sic.add(new SelectorItemInfo("priceComposition"));
//    
//    sic.add(new SelectorItemInfo("saleOrgUnit.*"));
//    sic.add(new SelectorItemInfo("discountType"));
//    sic.add(new SelectorItemInfo("isEnableAim"));
//    sic.add(new SelectorItemInfo("isLimitMerge"));
//    sic.add(new SelectorItemInfo("dsNameType"));
//    sic.add(new SelectorItemInfo("byMonthQtyLimit"));
//    sic.add(new SelectorItemInfo("accumulaEnddate"));
//    sic.add(new SelectorItemInfo("accumulaBeginDate"));
//    return sic;
//  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getSource() == this.comboPriceCompDetailCustomer)
    {
      setpriceCanEdit();
    } else {
      if (evt.getSource() != this.comboPriceCompDetailMaterial)
      {
        return;
      }

      setpriceCanEdit();
    }
  }

  public void treeWillCollapse(TreeExpansionEvent event)
    throws ExpandVetoException
  {
  }

  public void treeWillExpand(TreeExpansionEvent event)
    throws ExpandVetoException
  {
    this.currentNode = ((DefaultKingdeeTreeNode)event.getPath().getLastPathComponent());
    expandOrChanged(this.currentNode);
  }

  public void valueChanged(TreeSelectionEvent e)
  {
    this.currentNode = ((DefaultKingdeeTreeNode)e.getPath().getLastPathComponent());
    if (((this.currentNode != null) && (this.currentNode.getUserObject() instanceof PriceCompositionInfo) && (this.lastTreeNode != null) && (this.lastTreeNode.getUserObject() instanceof PriceCompositionInfo) && ((((((PriceCompositionInfo)this.currentNode.getUserObject()).getId() == null) && (((PriceCompositionInfo)this.lastTreeNode.getUserObject()).getId() == null)) || ((((PriceCompositionInfo)this.currentNode.getUserObject()).getId() != null) && (((PriceCompositionInfo)this.lastTreeNode.getUserObject()).getId() != null) && (!(((PriceCompositionInfo)this.currentNode.getUserObject()).getId().equals(((PriceCompositionInfo)this.lastTreeNode.getUserObject()).getId())))) || ((((PriceCompositionInfo)this.currentNode.getUserObject()).getId() != null) && (((PriceCompositionInfo)this.lastTreeNode.getUserObject()).getId() == null))))) || ((this.lastTreeNode == null) && (this.currentNode != null)))
    {
      expandOrChanged(this.currentNode);

      setEntryDisplay(this.currentNode);
    }
    lockEditor();
    if ((this.editData.getCheckedStatus().equals(CheckedStatusEnum.AUDITED)) || (getOprtState().equals(OprtState.VIEW)))
    {
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(true);
    } else {
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(false);
//      if (this.isCanNotEditPrice)
//        this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(true);
//      else {
//        this.kdtEntries.getColumn("price").getStyleAttributes().setLocked(false);
//      }
    }
    if (this.currentNode != null)
      this.lastTreeNode = ((DefaultKingdeeTreeNode)this.currentNode.clone());
    else
      this.lastTreeNode = null;
  }

  /**
   * 显示下级
   * @param currentNode
   */
  protected void setEntryDisplay(DefaultKingdeeTreeNode currentNode)
  {
    PriceCompDetailEnum currentTreeNodeType = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
    if (!(currentNode.getUserObject() instanceof PriceCompositionInfo))
      return;
    try {
      IDiscountSet iprice = (IDiscountSet)getBizInterface();
      String groupStandardId = ((CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem()).getId().toString();
      Map params = new HashMap();
      params.put("customergroupStandardId", groupStandardId);
      params.put("isincluded", Boolean.valueOf(this.chkIncluded.isSelected()));
      params.put("saleorgid", (SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData());
      params.put("pricepolicyid", this.editData.getId());
      params.put("pricepolicy_customercomp", currentTreeNodeType);
      params.put("pricepolicy_materialcomp", (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem());
      if (!(this.isCopy)) {
        this.collection = iprice.getPriceEntrys(currentTreeNodeType, (PriceCompositionInfo)currentNode.getUserObject(), params);
      }

      getDetailTable().removeRows();
      this.dataBinder.bindDataToTable(getDetailTable(), this.collection);
      if (this.collection == null) {
        this.collection = new DiscountSetEntryCollection();
      }
      getDetailTable().setUserObject(this.collection);

      initEntry();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  /**
   * 显示下级
   * @param currentNode 根节点
   * @param customerInfo 
   */
  protected void setEntryCustomerDisplay(DefaultKingdeeTreeNode currentNode,CustomerInfo customerInfo)
  {
    PriceCompDetailEnum currentTreeNodeType = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();
    if (!(currentNode.getUserObject() instanceof PriceCompositionInfo))
      return;
    try {
      IDiscountSet iprice = (IDiscountSet)getBizInterface();
      String groupStandardId = ((CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem()).getId().toString();
      Map params = new HashMap();
      params.put("customergroupStandardId", groupStandardId);
      if(customerInfo != null){
    	  params.put("customerId", customerInfo.getId().toString());
      }
      params.put("isincluded", Boolean.valueOf(this.chkIncluded.isSelected()));
      params.put("saleorgid", (SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData());
      params.put("pricepolicyid", this.editData.getId());
      params.put("pricepolicy_customercomp", currentTreeNodeType);
      params.put("pricepolicy_materialcomp", (PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem());
      if (!(this.isCopy)) {
        this.collection = iprice.getPriceEntrys(currentTreeNodeType, (PriceCompositionInfo)currentNode.getUserObject(), params);
      }

      getDetailTable().removeRows();
      this.dataBinder.bindDataToTable(getDetailTable(), this.collection);
      if (this.collection == null) {
        this.collection = new DiscountSetEntryCollection();
      }
      getDetailTable().setUserObject(this.collection);

      initEntry();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  protected void initDataStatus()
  {
    super.initDataStatus();
    initBtnState();
  }

  public void onShow() throws Exception {
    if (getMainBizOrg() != null)
      if (getOprtState().equals(OprtState.ADDNEW))
        getMainBizOrg().setReadOnly(false);
      else
        getMainBizOrg().setReadOnly(true);
  }

  private void lockEditor()
  {
    PriceCompDetailEnum currentTreeNodeType = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();

    if (currentTreeNodeType == null) {
      return;
    }

    switch (currentTreeNodeType.getValue())
    {
    case 1:
      this.kdtEntries.getColumn("customerName").getStyleAttributes().setLocked(true);
      this.kdtEntries.getColumn("customerNumber").getStyleAttributes().setLocked(true);

//      this.kdtEntries.getColumn("materialGroupNumber").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("materialGroupName").getStyleAttributes().setLocked(true);
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(false);
      this.kdtEntries.getColumn("materialName").getStyleAttributes().setLocked(true);
      break;
    case 2:
//      this.kdtEntries.getColumn("customerGroupName").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("customerGroupNumber").getStyleAttributes().setLocked(true);

//      this.kdtEntries.getColumn("materialGroupNumber").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("materialGroupName").getStyleAttributes().setLocked(true);
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(false);
      this.kdtEntries.getColumn("materialName").getStyleAttributes().setLocked(true);
      break;
    case 3:
      this.kdtEntries.getColumn("materialNumber").getStyleAttributes().setLocked(true);
      this.kdtEntries.getColumn("materialName").getStyleAttributes().setLocked(true);

      this.kdtEntries.getColumn("customerNumber").getStyleAttributes().setLocked(false);
      this.kdtEntries.getColumn("customerName").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("customerGroupNumber").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("customerGroupName").getStyleAttributes().setLocked(true);
      break;
    case 4:
//      this.kdtEntries.getColumn("materialGroupNumber").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("materialGroupName").getStyleAttributes().setLocked(true);

      this.kdtEntries.getColumn("customerNumber").getStyleAttributes().setLocked(false);
      this.kdtEntries.getColumn("customerName").getStyleAttributes().setLocked(true);
//      this.kdtEntries.getColumn("customerGroupNumber").getStyleAttributes().setLocked(false);
//      this.kdtEntries.getColumn("customerGroupName").getStyleAttributes().setLocked(true);
    }
  }

  private void expandOrChanged(DefaultKingdeeTreeNode currentNode)
  {
    PriceCompositionInfo info = (PriceCompositionInfo)currentNode.getUserObject();

    PriceCompDetailEnum sltItem = (PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem();

    if (sltItem == null) {
      return;
    }
    int sltItemValue = sltItem.getValue();
    String id = info.getId();

    if (sltItemValue == 1)
    {
      expandCustomer(id, false);
    } else if (sltItemValue == 2)
    {
      expandCustomer(id, true);
    } else if (sltItemValue == 4)
    {
      expandMaterial(id, true); } else {
      if (sltItemValue != 3)
        return;
      expandMaterial(id, false);
    }
  }

  public void initUIToolBarLayout()
  {
    this.toolBar.add(this.btnAddNew);
    this.toolBar.add(this.btnEdit);
    this.toolBar.add(this.btnSave);

    this.toolBar.add(this.btnCopy);
    this.toolBar.add(this.btnCancelCancel);
    this.toolBar.add(this.btnRemove);
    this.toolBar.add(this.btnCancel);
    this.toolBar.add(this.btnPrint);
    this.toolBar.add(this.btnPrintPreview);
    this.toolBar.add(this.btnFirst);
    this.toolBar.add(this.btnPre);
    this.toolBar.add(this.btnNext);
    this.toolBar.add(this.btnLast);
    this.toolBar.add(this.btnBatchAddEntry);
    this.toolBar.add(this.btnAddLine);
    
    this.toolBar.add(this.btnInsertLine);

    this.toolBar.add(this.btnRemoveLine);
    this.toolBar.add(this.btnPageSetup);
  }

  public void actionSave_actionPerformed(ActionEvent e) throws Exception
  {
	  try{
		  checkBeforeSave();
		  super.actionSave_actionPerformed(e);
		  setSave(true);
		  setSaved(true);
		  
	  }catch(BOSException bose){
		  bose.printStackTrace();
		  MsgBox.showInfo(bose.getMessage());
	  }
   
  }
  /**
   * 保存前校验 单据数据是否合法
 * @throws BOSException 
 * @throws EASBizException 
 * @throws SQLException 
   */
  private void checkBeforeSave() throws EASBizException, BOSException, SQLException{
	  // 保存前校验 政策是否已经审核，如果已经审核，则不允许保存
	  if(this.editData != null && this.editData.getId() != null){
		  String checkSql = "select FCheckedStatus from CT_NDI_DiscountSet where fid ='" + this.editData.getId().toString() + "'";
		  IRowSet rs = ToolFacadeFactory.getRemoteInstance().executeQuery(checkSql);
		  if(rs.next()){
			  int checkState = rs.getInt("FCheckedStatus");
			  if(checkState == 2){
				  MsgBox.showInfo("政策已经被审核，不能保存，请退出编辑界面后刷新");
				  SysUtil.abort();
			  }
		  }
	  }
	  // 是否不区分客户
	  boolean isAllCustomer = this.chkisAllCustomer.isSelected();
	  boolean customerInOne = this.chkisLimitMerge.isSelected();
	  // 如果 合并计算的话  那么 分录中同一客户 的限制数量 都一致
	  if(customerInOne){
		  // 建一个hashmap缓存每个客户的第一个分录的数据
//		  HashMap<String,Map<String,BigDecimal>> customerSet = new HashMap<String,Map<String,BigDecimal>>();
		  HashMap customerSet = new HashMap();
		  for(int i = 0; i < this.kdtEntries.getRowCount(); i++){
			  CustomerInfo customerInfo = (CustomerInfo) this.kdtEntries.getRow(i).getCell("customerNumber").getValue();
			  EntryState entryState = (EntryState) this.kdtEntries.getRow(i).getCell("lockedState").getValue();
			  if(entryState.Locked.equals(entryState)){
				  continue;
			  }
			  
			  if(!isAllCustomer && customerInfo == null){
				  MsgBox.showInfo("分录中客户不能为空");
				  SysUtil.abort();
			  }else{
				 
				  BigDecimal qty1 = (BigDecimal) this.kdtEntries.getRow(i).getCell("qty1").getValue();
				  qty1 = (qty1 == null?new BigDecimal("0"):qty1);
				  if(qty1.compareTo(new BigDecimal("0")) < 0){
					  MsgBox.showInfo("数量一不能小于0");
					  SysUtil.abort();
				  }
				  
				  BigDecimal qty2 = (BigDecimal) this.kdtEntries.getRow(i).getCell("qty2").getValue();
				  qty2 = (qty2 == null?new BigDecimal("0"):qty2);
				  if(qty2.compareTo(new BigDecimal("0")) < 0){
					  MsgBox.showInfo("数量二不能小于0");
					  SysUtil.abort();
				  }
				  
				  BigDecimal saleQtyLimit = (BigDecimal) this.kdtEntries.getRow(i).getCell("qtyLimit").getValue();
				  saleQtyLimit = (saleQtyLimit == null?new BigDecimal("0"):saleQtyLimit);
				  if(saleQtyLimit.compareTo(new BigDecimal("0")) < 0){
					  MsgBox.showInfo("销量限制不能小于0");
					  SysUtil.abort();
				  }
				  BigDecimal saleAmountLimit = (BigDecimal) this.kdtEntries.getRow(i).getCell("saleAmountLimit").getValue();
				  saleAmountLimit = (saleAmountLimit == null?new BigDecimal("0"):saleAmountLimit);
				  if(saleAmountLimit.compareTo(new BigDecimal("0")) < 0){
					  MsgBox.showInfo("销量额限制不能小于0");
					  SysUtil.abort();
				  }
				  BigDecimal dsAmountLimit = (BigDecimal) this.kdtEntries.getRow(i).getCell("sdLimit").getValue();
				  dsAmountLimit = (dsAmountLimit == null?new BigDecimal("0"):dsAmountLimit);
				  if(dsAmountLimit.compareTo(new BigDecimal("0")) < 0){
					  MsgBox.showInfo("折扣额限制不能小于0");
					  SysUtil.abort();
				  }
				  // 如果内存中已经存在对应客户的信息  则比较一下 是否与当前的数据一致，如果不一致提示用户
				  if(customerSet.containsKey(customerInfo.getId().toString())){
					  Map customerLimitSet = (Map) customerSet.get(customerInfo.getId().toString());
					  BigDecimal saleQtyLimitSave = (BigDecimal) customerLimitSet.get("saleQtyLimit");
					  BigDecimal saleAmountLimitSave = (BigDecimal) customerLimitSet.get("saleAmountLimit");
					  BigDecimal dsAmountLimitSave = (BigDecimal) customerLimitSet.get("dsAmountLimit");
					  
					  if(saleQtyLimitSave.compareTo(saleQtyLimit) != 0 ||
							  saleAmountLimitSave.compareTo(saleAmountLimit) != 0||
							  dsAmountLimitSave.compareTo(dsAmountLimit) != 0){
						  MsgBox.showInfo("分录中相同客户的限制必须相等");
						  SysUtil.abort();
					  }
				  }else{
					  Map customerLimitSet  = new HashMap();
					  customerLimitSet.put("saleQtyLimit", saleQtyLimit);
					  customerLimitSet.put("saleAmountLimit", saleAmountLimit);
					  customerLimitSet.put("dsAmountLimit", dsAmountLimit);
					  
					  customerSet.put(customerInfo.getId().toString(), customerLimitSet);
				  }
				  
				  
				  // 校验一种政策类别、折让类别、客户、物料、生效时间 只能有一条记录
				  DiscountTypeEnum dtEnum = (DiscountTypeEnum) this.discountType.getSelectedItem();
				  DsNameTypeEnum nameTypeEnum = (DsNameTypeEnum) this.dsNameType.getSelectedItem();
				  MaterialInfo material = (MaterialInfo)this.kdtEntries.getRow(i).getCell("materialNumber").getValue();
//				  customerInfo
				  
				  
				  
			  }
		  }
	  }
	  
	  
  }
  /**
   * 同一个客户、物料对应的每个政策类别 折让类别只能有一条记录处于启用状态
   * @param customerInfo
   * @param materialInfo
   * @param dtEnum
   * @param nameTypeEnum
   */
  public void checkDSRepeat(CustomerInfo customerInfo ,MaterialInfo materialInfo,DiscountTypeEnum dtEnum, DsNameTypeEnum nameTypeEnum){
	  
  }
  
  
  public void actionPrint_actionPerformed(ActionEvent e)
    throws Exception
  {
    BDInvClientUtils.logUIOperation("LOG_PRINT", new DiscountSetInfo().getBOSType());
    super.actionPrint_actionPerformed(e);
  }

  public void onLoad()
    throws Exception
  {
    this.isfirstload = true;
    this.kdtEntries.checkParsed();
    this.kdtEntries.getSelectManager().setSelectMode(KDTSelectManager.MULTIPLE_ROW_SELECT);
    initNeedMainOrgF7s();

    super.onLoad();
    // 界面初始化
    MaterialGroupPromptBox groupBox = new MaterialGroupPromptBox(this);
    KDBizPromptBox bizMaterialGroupBox = new KDBizPromptBox();
    bizMaterialGroupBox.setEditFormat("$number$");
    bizMaterialGroupBox.setDisplayFormat("$name$");
    bizMaterialGroupBox.setCommitFormat("$number$");
    bizMaterialGroupBox.setSelector(groupBox);
    this.kdtEntries.getColumn("accumulaMaterialGroup").setEditor(new KDTDefaultCellEditor(bizMaterialGroupBox));
    

    ObjectValueRender avr = new ObjectValueRender();

    avr.setFormat(new BizDataFormat("$name$"));
    
    this.kdtEntries.getColumn("accumulaMaterialGroup").setRenderer(avr);
    
    this.actionAddLine.setVisible(false);
    this.actionInsertLine.setVisible(false);
    
//    initUI();
    this.kDSplitPane1.setDividerLocation(200);

    if (getMainBizOrg() != null) {
      setMainBizOrgF7(getMainBizOrg(), getMainBizOrgType());
    }
    this.isfirstload = false;
    
    if(!"ADDNEW".equals(this.getOprtState()) && !"EDIT".equals(this.getOprtState())){
    	this.btnCopyToEntries.setEnabled(false);
    	this.btnSetLimit.setEnabled(false);
    	this.btnSetQtyStandard.setEnabled(false);
    }else{
    	this.btnCopyToEntries.setEnabled(true);
    	this.btnSetLimit.setEnabled(true);
    	this.btnSetQtyStandard.setEnabled(true);
    }
    
    // 设置不可编辑
    comboPriceCompDetailCustomer.setSelectedItem(PriceCompDetailEnum.CUSTOMER);
    comboPriceCompDetailMaterial.setSelectedItem(PriceCompDetailEnum.MATERIAL);
    comboPriceCompDetailCustomer.setEditable(false);
    comboPriceCompDetailCustomer.setEditable(false);
    
    comboPriceCompDetailMaterial.setEditable(false);
    comboPriceCompDetailMaterial.setEditable(false);
    
    
    // 日期精确到时分秒
    this.pkEffectiveDate.setDatePattern("yyyy-MM-dd HH:mm:ss");
    pkEffectiveDate.setMilliSecondEnable(true);
    this.pkExpireDate.setDatePattern("yyyy-MM-dd HH:mm:ss");
    pkExpireDate.setMilliSecondEnable(true);
    pkExpireDate.getEditor().setDateTimePattern("yyyy-MM-dd HH:mm:ss");
//    pkExpireDate.getEditor().setDateTimeModel(arg0)
    
//    pkEffectiveDate.getEditor()
    // 设置分录折让标准 显示列
    DiscountTypeEnum dtEnum = (DiscountTypeEnum)this.discountType.getSelectedItem();
    if(dtEnum == null){
    	dtEnum = DiscountTypeEnum.LiZhe;
    	this.discountType.setSelectedItem(dtEnum);
    }
    // 设置分录的 隐藏状态
    setStandard(dtEnum);
    chkbyMonthQtyLimit_actionPerformed(null);
  }

  public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
    this.isCopy = false;
    super.actionAddNew_actionPerformed(e);
    this.kdtEntries.getStyleAttributes().setLocked(false);
  }

  private void setBizCustomerF7(KDBizPromptBox f7)
  {
    if (this.f7DisplayMode == 0)
      try {
        GeneralKDPromptSelectorAdaptor selectorLisenterCustomer = null;
        selectorLisenterCustomer = new GeneralKDPromptSelectorAdaptor(f7, "com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI", this, CSSPGroupInfo.getBosType(), "com.kingdee.eas.basedata.master.cssp.app.F7CustomerSaleQuery", "browseGroup.id", "com.kingdee.eas.basedata.master.cssp.app.F7CustomerSaleQueryWithDefaultStandard");

        f7.setSelector(selectorLisenterCustomer);
        selectorLisenterCustomer.setQueryProperty("mnemonicCode", "or");
        f7.addSelectorListener(selectorLisenterCustomer);
      } catch (Exception e) {
        super.handUIException(e);
      }
    else {
      f7.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerSaleQueryWithDefaultStandard");
    }
    f7.setCommitFormat("$number$;$mnemonicCode$");
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filter = new FilterInfo();
    filter.getFilterItems().add(new FilterItemInfo("usedStatus", "1", CompareType.EQUALS));
    viewInfo.setFilter(filter);
    f7.setEntityViewInfo(viewInfo);
  }

  private void setBizMaterialF7(KDBizPromptBox f7)
  {
    if (this.f7DisplayMode == 0) {
      GeneralKDPromptSelectorAdaptor selectorLisenter = null;
      try
      {
        selectorLisenter = new GeneralKDPromptSelectorAdaptor(f7, "com.kingdee.eas.basedata.master.material.client.F7MaterialTreeListUI", this, "com.kingdee.eas.basedata.master.material.app.F7MaterialSalesQuery", "BrowserGroup.id", "com.kingdee.eas.basedata.master.material.app.F7MaterialSalesNoGroupQuery");

        selectorLisenter.setIsMultiSelect(false);
      }
      catch (Exception e) {
        super.handUIException(e);
      }
//      selectorLisenter
      f7.setSelector(selectorLisenter);
      f7.addSelectorListener(selectorLisenter);
      selectorLisenter.setQueryProperty("helpCode", "or");
    } else {
      f7.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialSalesNoGroupQuery");
    }
    EntityViewInfo viewInfo = new EntityViewInfo();
    FilterInfo filter = new FilterInfo();
    filter.getFilterItems().add(new FilterItemInfo("status", "1", CompareType.EQUALS));
    viewInfo.setFilter(filter);
    f7.setEntityViewInfo(viewInfo);
    f7.setEnabledMultiSelection(false);
  }

  public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
    this.isCopy = true;
    super.actionCopy_actionPerformed(e);
    this.kdtEntries.getStyleAttributes().setLocked(false);
    initEntryStauts();
  }

  protected void setFieldsNull(AbstractObjectValue newData) {
    this.dataBinder.bindTableToData(this.kdtEntries, ((DiscountSetInfo)newData).getEntries());
    super.setFieldsNull(newData);
    ((DiscountSetInfo)newData).setCheckedStatus(CheckedStatusEnum.UNAUDITED);
    ((DiscountSetInfo)newData).setBlockedStatus(ForbidStatusEnum.UNFORBID);
    for (int i = 0; i < ((DiscountSetInfo)newData).getEntries().size(); ++i) {
      ((DiscountSetInfo)newData).getEntries().get(i).setId(null);
      ((DiscountSetInfo)newData).getEntries().get(i).setCheckedStatus(CheckedStatusEnum.UNAUDITED);
    }
    this.collection = ((DiscountSetInfo)newData).getEntries();
  }

  protected void initNeedMainOrgF7s()
  {
    this.bizMaterialBox = getBizMaterialF7(this.kdtEntries.getColumn("materialNumber"), null);
    this.prmtOrderCustomer = getBizCustomerF7(this.kdtEntries.getColumn("customerNumber"), null);

    ObjectValueRender avr = new ObjectValueRender();

    avr.setFormat(new BizDataFormat("$number$"));
    this.kdtEntries.getColumn("customerNumber").setRenderer(avr);
  }

  protected String getPermissionItem(String status)
  {
    if (status == "ADDNEW") {
      return "pricepolicy_addnew";
    }
    return null;
  }

  protected KDBizPromptBox getMainBizOrg()
  {
    return this.prmtSaleOrgUnit;
  }

  protected OrgType getMainBizOrgType()
  {
    return OrgType.Sale;
  }

  protected KDBizPromptBox[] getNeedSetOrgF7s()
  {
    return new KDBizPromptBox[] { this.prmtOrderCustomer, this.bizMaterialBox };
  }

  protected void setMainBizOrgF7(KDBizPromptBox bizOrgUnitBox, OrgType orgType)
  {
    OrgF7PromptDialog model = null;
    if (orgType.equals(OrgType.Sale)) {
      model = new SaleF7();
    }
    OrgUnitFilterInfoProducer iProducer = null;
    if (model != null)
      iProducer = (OrgUnitFilterInfoProducer)FilterInfoProducerFactory.getOrgUnitFilterInfoProducer(model);
    else {
      iProducer = (OrgUnitFilterInfoProducer)FilterInfoProducerFactory.getOrgUnitFilterInfoProducer(orgType);
    }

    String permissionItem = getPermissionItem(getOprtState());
    if (permissionItem != null) {
      iProducer.getModel().setPermissionItem(permissionItem);
    }
    bizOrgUnitBox.setFilterInfoProducer(iProducer);
  }

  protected final OrgUnitInfo getDefaultMainBizOrg()
  {
    OrgUnitInfo[] mainOrgs = null;
    try
    {
      FullOrgUnitCollection collection = SCMGroupClientUtils.getAuthOrgByPermItem(new ObjectStringPK(SysContext.getSysContext().getCurrentUserInfo().getId().toString()), getMainBizOrgType(), getPermissionItem("ADDNEW"));

      mainOrgs = SCMGroupClientUtils.getOrgUnitInfosByType(collection, getMainBizOrgType());

      if (mainOrgs == null) {
        mainOrgs = new OrgUnitInfo[0];
        return null;
      }
      if (mainOrgs.length > 0) {
        mainOrgs = (OrgUnitInfo[])SortUtil.sortDataByNumber(mainOrgs, true);
      }
    }
    catch (Exception e)
    {
      handUIException(e);
    }
    OrgUnitInfo currentMainOrg = SysContext.getSysContext().getCurrentOrgUnit(getMainBizOrgType());
    if ((currentMainOrg != null) && (mainOrgs != null) && (mainOrgs.length > 0)) {
      for (int i = 0; i < mainOrgs.length; ++i) {
        if (currentMainOrg.getId().toString().equals(mainOrgs[i].getId().toString())) {
          return currentMainOrg;
        }
      }
    }
    if ((mainOrgs != null) && (mainOrgs.length > 0)) {
      return mainOrgs[0];
    }
    return null;
  }

  private void changeF7Context()
  {
    this.f7Manager.changeF7Context(getUIContext());
  }

  protected void afterMainOrgChanged(String arg0, String arg1) {
    if (arg1 != null) {
      if ((arg0 == null) || ((arg0 != null) && (!(arg0.equals(arg1)))) || (this.isfirstload))
      {
        if (((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).isIsBizUnit()) {
          initNeedMainOrgF7s();
        }
        else {
          KDBizPromptBox bizCustomerF7Box = new KDBizPromptBox();
          bizCustomerF7Box.setEntityViewInfo(getCustomerDView(((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getCU().getId().toString()));
          setBaseDataF7WithVirtualOrg("customerNumber", bizCustomerF7Box, "com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI", "com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery", "browseGroup.id", CSSPGroupInfo.getBosType(), "com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery");

          KDBizPromptBox bizMaterialF7Box = new KDBizPromptBox();
          
          bizMaterialF7Box.setEntityViewInfo(getMaterialDView(((SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData()).getCU().getId().toString()));
          setBaseDataF7WithVirtualOrg("materialNumber", bizMaterialF7Box, "com.kingdee.eas.basedata.master.material.client.F7MaterialTreeListUI", "com.kingdee.eas.basedata.master.material.app.F7MaterialQuery", "BrowserGroup.id", MaterialGroupInfo.getBosType(), "com.kingdee.eas.basedata.master.material.app.F7MaterialQuery");
        }

        try
        {
          Map params = ((IDiscountSet)getBizInterface()).getPriceParam(arg1);
          this.isSubordinateAddnewable = ((Boolean)params.get("price_IsSubordinateAddnewable")).booleanValue();
          this.f7DisplayMode = ((Integer)params.get("price_f7DisplayMode")).intValue();
          this.discountRatePrecision = ((Integer)params.get("price_discountRatePrecision")).intValue();
          this.isCanNotEditPrice = ((Boolean)params.get("PricePa021")).booleanValue();
          changeF7Context();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      setpriceCanEdit();
      if ((arg0 == null) || (arg1 == null) || (arg0.equals(arg1))) {
        return;
      }
      if ((this.isCopy) && (((this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.CM)) || (this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.CGM)) || (this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.MC)) || (this.priceComposition.getSelectedItem().equals(PriceCompositionEnum.MCG)))))
      {
        clearUnNeedEntry(arg0, arg1);
      }

      TreePath treePath = this.treeMain.getLeadSelectionPath();
      while (treePath.getParentPath() != null) {
        treePath = treePath.getParentPath();
      }
      this.treeMain.collapsePath(treePath);
    }
  }

  private void clearUnNeedEntry(String oldorgid, String neworgid)
  {
    if ((!(((PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem()).equals(PriceCompDetailEnum.CUSTOMER))) && (!(((PriceCompDetailEnum)this.comboPriceCompDetailCustomer.getSelectedItem()).equals(PriceCompDetailEnum.MATERIAL))) && (!(((PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem()).equals(PriceCompDetailEnum.CUSTOMER))) && (!(((PriceCompDetailEnum)this.comboPriceCompDetailMaterial.getSelectedItem()).equals(PriceCompDetailEnum.MATERIAL)))) {
      return;
    }

    String[] materialids = new String[this.kdtEntries.getRowCount()];
    String[] customerids = new String[this.kdtEntries.getRowCount()];
    String[] saleorgids = { oldorgid, neworgid };
    int i = 0; for (int c = this.kdtEntries.getRowCount(); i < c; ++i) {
      if (this.kdtEntries.getRow(i).getCell("materialNumber").getValue() instanceof MaterialInfo)
        materialids[i] = ((MaterialInfo)this.kdtEntries.getRow(i).getCell("materialNumber").getValue()).getId().toString();
      else {
        materialids[i] = null;
      }
      if (this.kdtEntries.getRow(i).getCell("customerNumber").getValue() instanceof CustomerInfo)
        customerids[i] = ((CustomerInfo)this.kdtEntries.getRow(i).getCell("customerNumber").getValue()).getId().toString();
      else
        customerids[i] = null;
    }
//    try
//    {
//      IPriceProvider iProvider = PriceProviderFactory.getRemoteInstance();
//      Map result = iProvider.checkNeedPricePolicy(materialids, customerids, saleorgids);
//      IObjectCollection objectCollection = (IObjectCollection)this.kdtEntries.getUserObject();
//      if (result.isEmpty()) {
//        this.kdtEntries.removeRows();
//        objectCollection.clear();
//      } else {
//        String materialid = null;
//        String customerid = null;
//        int i1 = 0; for (int c = this.kdtEntries.getRowCount(); i1 < c; ++i1) {
//          IRow iRow = this.kdtEntries.getRow(i1);
//          if (this.kdtEntries.getRow(i1).getCell("materialNumber").getValue() instanceof MaterialInfo) {
//            materialid = ((MaterialInfo)this.kdtEntries.getRow(i1).getCell("materialNumber").getValue()).getId().toString();
//          }
//          if (this.kdtEntries.getRow(i1).getCell("customerNumber").getValue() instanceof CustomerInfo) {
//            customerid = ((CustomerInfo)this.kdtEntries.getRow(i1).getCell("customerNumber").getValue()).getId().toString();
//          }
//
//          if ((((materialid == null) || (!(result.get(materialid) instanceof Boolean)) || (customerid == null) || (result.get(customerid) instanceof Boolean))) && (((materialid == null) || (result.get(materialid) instanceof Boolean) || (customerid == null) || (!(result.get(customerid) instanceof Boolean)))) && (((materialid != null) || (customerid == null) || (result.get(customerid) instanceof Boolean))) && (((customerid != null) || (materialid == null) || (result.get(materialid) instanceof Boolean))))
//          {
//            continue;
//          }
//
//          this.kdtEntries.removeRow(i1);
//          IObjectValue detailData = (IObjectValue)iRow.getUserObject();
//          if (detailData != null) {
//            int index = getCollectionIndex(objectCollection, detailData);
//            if (index != -1)
//              objectCollection.removeObject(index);
//          }
//        }
//      }
//    }
//    catch (EASBizException e) {
//      e.printStackTrace();
//    } catch (BOSException e) {
//      e.printStackTrace();
//    }
  }

  private int getCollectionIndex(IObjectCollection collection, IObjectValue obj)
  {
    int index = -1;
    if (collection == null) {
      return index;
    }
    for (int i = collection.size() - 1; i >= 0; --i) {
      if (obj == collection.getObject(i)) {
        index = i;
        return index;
      }
    }
    return index;
  }

  protected KDBizPromptBox getBizMaterialF7(IColumn col, String queryInfo) {
    OrgUnitInfo orgInfo = null;
    this.bizMaterialBox = new KDBizPromptBox();
    if (getMainOrgContext() != null) {
      orgInfo = (OrgUnitInfo)getMainOrgContext().get(getMainBizOrgType());
    }
    this.f7Manager.registerBizMaterialF7(this.bizMaterialBox, col, queryInfo, orgInfo, false);
//    registerDealMultiMateiralInfo(this.bizMaterialBox, col.getKey());
    return this.bizMaterialBox; }

  protected KDBizPromptBox getBizCustomerF7(IColumn col, String queryInfo) {
    KDBizPromptBox bizCustomerBox = new KDBizPromptBox();

    setBizCustomerF7(bizCustomerBox, col, queryInfo);
    return bizCustomerBox;
  }

  protected void setBizCustomerF7(KDBizPromptBox bizCustomerBox, IColumn col, String queryInfo) {
    OrgUnitInfo orgInfo = null;
    if (getMainOrgContext() != null) {
      orgInfo = (OrgUnitInfo)getMainOrgContext().get(getMainBizOrgType());
    }
    this.f7Manager.registerBizCustomerF7(bizCustomerBox, col, queryInfo, orgInfo);
  }

  private EntityViewInfo getCustomerDView(String cuid) {
    EntityViewInfo view = new EntityViewInfo();
    FilterInfo filterInfo = null;
    try {
      ICustomer iCustomer = CustomerFactory.getRemoteInstance();
      ObjectUuidPK pk = null;
      pk = new ObjectUuidPK(BOSUuid.read(cuid));
      filterInfo = iCustomer.getDatabaseDFilter(pk, "id", "adminCU.id");
      view.setFilter(filterInfo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return view; }

  private EntityViewInfo getMaterialDView(String cuid) {
    EntityViewInfo view = new EntityViewInfo();
    FilterInfo filterInfo = null;
    try {
      IMaterial iMaterial = MaterialFactory.getRemoteInstance();
      ObjectUuidPK pk = null;
      pk = new ObjectUuidPK(BOSUuid.read(cuid));
      filterInfo = iMaterial.getDatabaseDFilter(pk, "id", "adminCU.id");
      view.setFilter(filterInfo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return view;
  }

  public boolean isModify() {
    try {
      ControlUtilities.checkFocusAndCommit();
    }
    catch (ParseException e) {
      handleControlException();
      abort();
    }
    if (OprtState.VIEW.equals(getOprtState())) {
      return false;
    }
    DiscountSetInfo info = (DiscountSetInfo)this.editData.clone();

    info.getEntries().addCollection(this.collection);
    try
    {
      storeFields();
    } catch (Exception exc) {
      return false;
    }
    return (!(ObjectValueForEditUIUtil.objectValueEquals(info, this.editData)));
  }

  public void actionFirst_actionPerformed(ActionEvent e) throws Exception {
    super.actionFirst_actionPerformed(e);
    this.isCopy = false;
    setEntryDisplay(this.currentNode);
  }

  public void actionLast_actionPerformed(ActionEvent e) throws Exception {
    super.actionLast_actionPerformed(e);
    this.isCopy = false;
    setEntryDisplay(this.currentNode);
  }

  public void actionNext_actionPerformed(ActionEvent e) throws Exception {
    super.actionNext_actionPerformed(e);
    this.isCopy = false;
    setEntryDisplay(this.currentNode);
  }

  public void actionPre_actionPerformed(ActionEvent e) throws Exception {
    super.actionPre_actionPerformed(e);
    this.isCopy = false;
    setEntryDisplay(this.currentNode);
  }

  public void actionPriorityQuery_actionPerformed(ActionEvent e) throws Exception {
    KDBizPromptBox f7 = new KDBizPromptBox();

    if ((this.prmtSaleOrgUnit.isRequired()) && (isNull(this.prmtSaleOrgUnit.getData()))) {
      MsgBox.showInfo(this, SCMClientUtils.getResource("SALEORGNOTNULL"));
      SysUtil.abort();
    }
    SaleOrgUnitInfo info = (SaleOrgUnitInfo)this.prmtSaleOrgUnit.getData();
    EntityViewInfo view = new EntityViewInfo();
    FilterInfo filterInfo = new FilterInfo();
    if (info != null)
      filterInfo.getFilterItems().add(new FilterItemInfo("saleOrgUnit.id", info.getId().toString(), CompareType.EQUALS));
    else {
      filterInfo.getFilterItems().add(new FilterItemInfo("saleOrgUnit.id", null, CompareType.EQUALS));
    }
    view.setFilter(filterInfo);
    f7.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7PricePolicyPriorityQuery");
    f7.setEntityViewInfo(view);
    f7.setDataBySelector();
  }

  /**
   * 重载单据内容
   * @throws Exception 
   * @throws BOSException 
   * @throws EASBizException 
   */
	private void reloadData() throws EASBizException, BOSException, Exception{
		if(this.editData != null && this.editData.getId() != null){
//			this.editData = ((IDiscountRecordBill)this.getBizInterface()).getDiscountRecordBillInfo(new ObjectUuidPK(this.editData.getId()));
//			this.status.setSelectedItem(this.editData.getStatus());
//			this.loadData();
//			this.setDataObject(this.editData);
//			loadFields();
//			this.ref
			IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
	        IObjectValue iObjectValue = getValue(iObjectPk);
	        setDataObject(iObjectValue);
	        loadFields();
	        setSave(true);
			
//			this.loadFields();
//			this.initOldData(this.editData);
//			this.status.setEnabled(false);
		}
	}
	
	
	/**
	 * 启用 分录
	 */
	public void actionEnableEntry_actionPerformed(ActionEvent e)
			throws Exception {
		List selectedRows = this.getSelectedRows();
		List  entryIDs = new ArrayList();
		for(int i = 0; i < selectedRows.size(); i++){
			BOSUuid id = (BOSUuid) this.getDetailTable().getRow(((Integer)selectedRows.get(i)).intValue()).getCell("id").getValue();
			if(id != null){
				entryIDs.add(id.toString());
			}
		}
		if(entryIDs.size() > 0){
			// 批量处理  分录状态
			DiscountFacadeFactory.getRemoteInstance().updateDSEntryState(entryIDs,"1");
			MsgBox.showInfo("启用分录完成");
			this.reloadData();
			
		}else{
			MsgBox.showInfo("没有选中符合条件的记录");
		}
	}

	/**
	 * 禁用分录
	 */
	public void actionForbiddenEntry_actionPerformed(ActionEvent e)
			throws Exception {
		List  selectedRows = this.getSelectedRows();
		List  entryIDs = new ArrayList();
		for(int i = 0; i < selectedRows.size(); i++){
			BOSUuid id = (BOSUuid) this.getDetailTable().getRow(((Integer)selectedRows.get(i)).intValue()).getCell("id").getValue();
			if(id != null){
				entryIDs.add(id.toString());
			}
		}
		if(entryIDs.size() > 0){
			// 批量处理  分录状态
			DiscountFacadeFactory.getRemoteInstance().updateDSEntryState(entryIDs,"2");
			MsgBox.showInfo("禁用分录完成");
			this.reloadData();
			
		}else{
			MsgBox.showInfo("没有选中符合条件的记录");
		}
	}

	/**
	 * 设置限制条件
	 */
	protected void btnSetLimit_actionPerformed(ActionEvent e) throws Exception {

		// 首先获得已经选中的分录行号，如果没有选中直接返回
		List selectedRows = this.getSelectedRows();
		if(selectedRows == null || selectedRows.size() == 0){
			MsgBox.showInfo("请先选中至少一条分录");
			return;
		}
		Map map = new UIContext(this); 
		
		IUIWindow uiWindow = null;
		
		
       try {
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.salediscount.client.SetDSLimit", map, null, OprtState.VIEW);
		} catch (UIException uie) {
			uie.printStackTrace();
		}
       uiWindow.show();
       // 获得 选中的 客户和物料
       Map entryS = uiWindow.getUIObject().getUIContext();
       DiscountSetEntryInfo entryInfo = (DiscountSetEntryInfo) entryS.get("entryInfo");
       for(int i = 0; entryInfo != null && selectedRows != null && i < selectedRows.size(); i++){
    	   Integer rowIndex = (Integer)selectedRows.get(i);
    	   
    	// 修改前加 校验，如果已经用过 则 不允许修改
		    BOSUuid entryID = (BOSUuid) kdtEntries.getRow(rowIndex.intValue()).getCell("id").getValue();
		    
		    if(entryID != null){
		    	try{
		    		boolean isExist = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed("", entryID.toString());
		    		if(isExist){
		    			continue;
//		    			MsgBox.showInfo("该分录已经被使用，不能修改");
//		    			SysUtil.abort();
		    		}
		    	}catch(Exception exp){
		    		this.handUIException(exp);
		    	}
		    }
		    
		 // 禁用的分录 也不能再赋值
		    EntryState entryState = (EntryState) this.kdtEntries.getCell(rowIndex.intValue(), "lockedState").getValue();
		    if(entryState.Locked.equals(entryState)){
				  continue;
			  }
    	   this.getDetailTable().getRow(rowIndex.intValue()).getCell("qtyLimit").setValue(entryInfo.getQtyLimit() == null?ZERO:entryInfo.getQtyLimit());
    	   this.getDetailTable().getRow(rowIndex.intValue()).getCell("sdLimit").setValue(entryInfo.getSdLimit() == null?ZERO:entryInfo.getSdLimit());
    	   this.getDetailTable().getRow(rowIndex.intValue()).getCell("saleAmountLimit").setValue(entryInfo.getSaleAmountLimit() == null?ZERO:entryInfo.getSaleAmountLimit());
	    }
       this.setSave(true);
	   this.setSaved(true);
	}
	
	/**
	 * 设置折让标准
	 */
	protected void btnSetQtyStandard_actionPerformed(ActionEvent e)
			throws Exception {
		
		// 首先获得已经选中的分录行号，如果没有选中直接返回
		List  selectedRows = this.getSelectedRows();
		if(selectedRows == null || selectedRows.size() == 0){
			MsgBox.showInfo("请先选中至少一条分录");
			return;
		}
		Map map = new UIContext(this); 
		
		IUIWindow uiWindow = null;
		
		
       try {
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.salediscount.client.SetQtyAndStandard", map, null, OprtState.VIEW);
		} catch (UIException uie) {
			uie.printStackTrace();
		}
       uiWindow.show();
       // 获得 选中的 客户和物料
       Map entryS = uiWindow.getUIObject().getUIContext();
       DiscountSetEntryInfo entryInfo = (DiscountSetEntryInfo) entryS.get("entryInfo");
       for(int i = 0; entryInfo != null && selectedRows != null && i < selectedRows.size(); i++){
    	   Integer rowIndex = (Integer) selectedRows.get(i);
    	   // xiugai前加 校验，如果已经用过 则 不允许修改
		    BOSUuid entryID = (BOSUuid) kdtEntries.getRow(rowIndex.intValue()).getCell("id").getValue();
		    
		    if(entryID != null){
		    	try{
		    		boolean isExist = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed("", entryID.toString());
		    		if(isExist){
		    			continue;
//		    			MsgBox.showInfo("该分录已经被使用，不能删除");
//		    			SysUtil.abort();
		    		}
		    	}catch(Exception exp){
		    		this.handUIException(exp);
		    	}
		    }
		 // 禁用的分录 也不能再赋值
		    EntryState entryState = (EntryState) this.kdtEntries.getCell(rowIndex.intValue(), "lockedState").getValue();
		    if(entryState.Locked.equals(entryState)){
				  continue;
			  }
    	   if(entryInfo.getQty1()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("qty1").setValue(entryInfo.getQty1());
    	   }
    	   if(entryInfo.getStandard1()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("standard1").setValue(entryInfo.getStandard1());
    	   }
    	   if(entryInfo.getQty2()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("qty2").setValue(entryInfo.getQty2());
    	   }
    	   if(entryInfo.getStandard2()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("standard2").setValue(entryInfo.getStandard2());
    	   }
    	   if(entryInfo.getSwQty1()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swQty1").setValue(entryInfo.getSwQty1());
    	   }
    	   if(entryInfo.getSwStandard1()!=-1){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swStandard1").setValue(new Integer(entryInfo.getSwStandard1()));
    	   }
    	   if(entryInfo.getSwQty2()!=null ){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swQty2").setValue(entryInfo.getSwQty2());
    	   }
    	   if(entryInfo.getSwStandard2()!=-1){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swStandard2").setValue(new Integer(entryInfo.getSwStandard2()));
    	   }
    	   // 数量3
    	   if(entryInfo.getQty3()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("qty3").setValue(entryInfo.getQty3());
    	   }
    	   if(entryInfo.getStandard3()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("standard3").setValue(entryInfo.getStandard3());
    	   }
    	   if(entryInfo.getSwQty3()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swQty3").setValue(entryInfo.getSwQty3());
    	   }
    	   if(entryInfo.getSwStandard3()!=-1){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swStandard3").setValue(new Integer(entryInfo.getSwStandard3()));
    	   }
    	   
    	   // 数量4
    	   if(entryInfo.getQty4()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("qty4").setValue(entryInfo.getQty4());
    	   }
    	   if(entryInfo.getStandard4()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("standard4").setValue(entryInfo.getStandard4());
    	   }
    	   if(entryInfo.getSwQty4()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swQty4").setValue(entryInfo.getSwQty4());
    	   }
    	   if(entryInfo.getSwStandard4()!=-1){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swStandard4").setValue(new Integer(entryInfo.getSwStandard4()));
    	   }
    	   
    	   // 数量5
    	   if(entryInfo.getQty5()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("qty5").setValue(entryInfo.getQty5());
    	   }
    	   if(entryInfo.getStandard5()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("standard5").setValue(entryInfo.getStandard5());
    	   }
    	   if(entryInfo.getSwQty5()!=null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swQty5").setValue(entryInfo.getSwQty5());
    	   }
    	   if(entryInfo.getSwStandard5()!=-1){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("swStandard5").setValue(new Integer(entryInfo.getSwStandard5()));
    	   }
    	   
    	   if(entryInfo.getAccumulaMaterialGroup() != null){
    		   this.getDetailTable().getRow(rowIndex.intValue()).getCell("accumulaMaterialGroup").setValue(entryInfo.getAccumulaMaterialGroup());
    	   }
    	   
	    }
       this.storeFields();
       this.setSave(true);
	   this.setSaved(true);
	}

	/**
	 * 批量添加 分录
	 * 
	 */
	public void actionBatchAddEntry_actionPerformed(ActionEvent e) throws Exception {
		
		Map map = new UIContext(this); 
		map.put("dsType", this.discountType.getSelectedItem());
		
		IUIWindow uiWindow = null;
       try {
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.salediscount.client.DSEntryBatchAddUI", map, null, OprtState.VIEW);
		} catch (UIException uie) {
			// TODO Auto-generated catch block
			uie.printStackTrace();
		}
       uiWindow.show();
       // 获得 选中的 客户和物料
       Map entryS = uiWindow.getUIObject().getUIContext();
       List  DSEntrys = (List) entryS.get("DSEntrys");
       for(int i = 0; DSEntrys != null && i < DSEntrys.size(); i++){
    	   DiscountSetEntryInfo entryInfo = (DiscountSetEntryInfo) DSEntrys.get(i);
    	   
    	   if(!checkEntryInfoExist(entryInfo)){
	    	   DiscountSetEntryInfo newEntryInfo = getNewEntryInfo(entryInfo);
	    	   
			   addLine(getDetailTable(), newEntryInfo);
    	   }
	    }
       
	}
	/**
	 * 校验分录中是否已经存在对应的分录
	 * @param entryInfo
	 * @return
	 */
	private boolean checkEntryInfoExist(DiscountSetEntryInfo entryInfo ){
		for(int i = 0; i < this.getDetailTable().getRowCount(); i++){
			IRow row = this.getDetailTable().getRow(i);
			MaterialInfo materialInfo = (MaterialInfo) row.getCell("materialNumber").getValue();
			CustomerInfo customerInfo = (CustomerInfo) row.getCell("customerNumber").getValue();
			EntryState state = (EntryState) row.getCell("lockedState").getValue();
			
			if(materialInfo != null && customerInfo != null){
				String miID = materialInfo.getId().toString();
				String ciID = customerInfo.getId().toString();
				
				String emiID = entryInfo.getMaterial().getId().toString();
				String eciID = entryInfo.getCustomer().getId().toString();
				EntryState entryState = entryInfo.getLockedState();
				if(miID.equals(emiID) && ciID.equals(eciID)){
					if( entryState.equals(EntryState.UnLocked) ){
						if(state.equals(entryState)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * 获得空分录
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private DiscountSetEntryInfo getNewEntryInfo(DiscountSetEntryInfo entryInfo) throws BOSException, EASBizException{
		DiscountSetEntryInfo newEntryInfo = DiscountSetEntryAgent.create();
		
//		DiscountSetEntryInfo newEntryInfo = (DiscountSetEntryInfo) createNewDetailData(getDetailTable());
		PriceCompositionInfo info = new PriceCompositionInfo();
		info.setIsLeaf(true);
		
		info.setCompType(PriceCompDetailEnum.CUSTOMER);
		if(entryInfo.getCustomer() != null){
			info.setId(entryInfo.getCustomer().getId().toString());
			info.setNumber(entryInfo.getCustomer().getNumber());
			info.setId(entryInfo.getCustomer().getName());
		}
		newEntryInfo.put("PriceCompositionInfo", info);
		newEntryInfo.setCustomer(entryInfo.getCustomer());
		newEntryInfo.setMaterial(entryInfo.getMaterial());
		MaterialInfo material = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId()));
		
		
//		newEntryInfo.setMeasureUnit(item)
		newEntryInfo.setMeasureUnit(material.getBaseUnit());
		newEntryInfo.setDiscountCondition(DiscountConditionEnum.AMOUNT);
		newEntryInfo.setEffectiveDate(this.pkEffectiveDate.getSqlDate());

		newEntryInfo.setExpireDate(this.pkExpireDate.getSqlDate());

//		newEntryInfo.setDiscount(DEFAULTNUM);

	    CurrencyInfo currencyInfo = null;
	    if (SysContext.getSysContext().getCurrentFIUnit() != null) {
	      CompanyOrgUnitInfo ficompanyOrgInfo = SysContext.getSysContext().getCurrentFIUnit();
	      if ((ficompanyOrgInfo != null) && (ficompanyOrgInfo.getBaseCurrency() != null))
	        try
	        {
	          currencyInfo = CurrencyFactory.getRemoteInstance().getCurrencyInfo(new ObjectUuidPK(ficompanyOrgInfo.getBaseCurrency().getId()));
	        }
	        catch (EASBizException e)
	        {
	          e.printStackTrace();
	        } catch (BOSException e) {
	          e.printStackTrace();
	        }
	    }
	    else
	    {
	      EntityViewInfo currencyView = new EntityViewInfo();
	      currencyView.setFilter(new FilterInfo());
	      currencyView.getFilter().getFilterItems().add(new FilterItemInfo("isoCode", "RMB"));
	      try
	      {
	        CurrencyCollection currencyCollection = CurrencyFactory.getRemoteInstance().getCurrencyCollection(currencyView);
	        if (currencyCollection.size() > 0)
	          currencyInfo = currencyCollection.get(0);
	      }
	      catch (Exception e) {
	        super.handUIException(e);
	      }
	    }
	    newEntryInfo.setCurrency(currencyInfo);

	    newEntryInfo.put("PriceCompositionInfo", info);
	    CSSPGroupStandardInfo cgsInfo = (CSSPGroupStandardInfo)this.comboCustomerGroupStandard.getSelectedItem();

//	    newEntryInfo.setCustomerGroupStandard(cgsInfo);
	   
	    DiscountTypeEnum dtEnum = (DiscountTypeEnum)this.discountType.getSelectedItem();
		DiscountUnitTypeEnum unitTypeEnum = DiscountUnitTypeEnum.YUAN;
		if(DiscountTypeEnum.ShiWu.equals(dtEnum)){
			unitTypeEnum = DiscountUnitTypeEnum.BAO;
		}
		newEntryInfo.setDiscountUnitType(unitTypeEnum);
		newEntryInfo.setQty1(entryInfo.getQty1()==null?ZERO :  entryInfo.getQty1());
		newEntryInfo.setQty2(entryInfo.getQty2()==null?ZERO :  entryInfo.getQty2());
		newEntryInfo.setStandard1(entryInfo.getStandard1()==null?ZERO :  entryInfo.getStandard1());
		newEntryInfo.setStandard2(entryInfo.getStandard2()==null?ZERO :  entryInfo.getStandard2());
		
		newEntryInfo.setSwQty1(entryInfo.getSwQty1()==null?ZERO :  entryInfo.getSwQty1());
		newEntryInfo.setSwQty2(entryInfo.getSwQty2()==null?ZERO :  entryInfo.getSwQty2());
		newEntryInfo.setSwStandard1(entryInfo.getSwStandard1());
		newEntryInfo.setSwStandard2(entryInfo.getSwStandard2());
		
		newEntryInfo.setQty3(entryInfo.getQty3()==null?ZERO :  entryInfo.getQty3());
		newEntryInfo.setStandard3(entryInfo.getStandard3()==null?ZERO :  entryInfo.getStandard3());
		newEntryInfo.setSwQty3(entryInfo.getSwQty3()==null?ZERO :  entryInfo.getSwQty3());
		newEntryInfo.setSwStandard3(entryInfo.getSwStandard3() );
		
		newEntryInfo.setQty4(entryInfo.getQty4()==null?ZERO :  entryInfo.getQty4());
		newEntryInfo.setStandard4(entryInfo.getStandard4()==null?ZERO :  entryInfo.getStandard4());
		newEntryInfo.setSwQty4(entryInfo.getSwQty4()==null?ZERO :  entryInfo.getSwQty4());
		newEntryInfo.setSwStandard4(entryInfo.getSwStandard4() );
		
		newEntryInfo.setQty5(entryInfo.getQty5()==null?ZERO :  entryInfo.getQty5());
		newEntryInfo.setStandard5(entryInfo.getStandard5()==null?ZERO :  entryInfo.getStandard5());
		newEntryInfo.setSwQty5(entryInfo.getSwQty5()==null?ZERO :  entryInfo.getSwQty5());
		newEntryInfo.setSwStandard5(entryInfo.getSwStandard5() );
		
		newEntryInfo.setQtyLimit(entryInfo.getQtyLimit()==null?ZERO :  entryInfo.getQtyLimit());
		newEntryInfo.setSdLimit(entryInfo.getSdLimit()==null?ZERO :  entryInfo.getSdLimit());
		newEntryInfo.setSaleAmountLimit(entryInfo.getSaleAmountLimit()==null?ZERO :  entryInfo.getSaleAmountLimit());
		
		newEntryInfo.setAccumulaMaterialGroup(entryInfo.getAccumulaMaterialGroup());

		newEntryInfo.setLockedState(EntryState.UnLocked);
		
		return newEntryInfo;
	}
//	/**
//	 * 将批量添加界面选中的 分录 添加到分录中
//	 * @param DSEntrys
//	 */
//	private void addEntrys(List<DiscountSetEntryInfo> DSEntrys){
//		for(int i = 0; i < DSEntrys.size(); i++){
//			DiscountSetEntryInfo entryInfo = DSEntrys.get(i);
////			addLine(getDetailTable(), entryInfo);
//			
//			
//			IRow row = getDetailTable().addRow();
//			getUILifeCycleHandler().fireOnAddNewLine(getDetailTable(), entryInfo);
//			loadLineFields(getDetailTable(), row, entryInfo);
//			afterAddLine(getDetailTable(), entryInfo);
//		}
//	}

	 /**
     * output chkisAllCustomer_actionPerformed method
     * 不区分客户 如果选中的话  则 设置分录客户字段不可见  否则可见
     * 
     */
    protected void chkisAllCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	boolean isAllCustomer = this.chkisAllCustomer.isSelected();
    	if(isAllCustomer){
			
			this.getDetailTable().getColumn("customerNumber").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("customerName").getStyleAttributes().setHided(true);
			
		}else{
			this.getDetailTable().getColumn("customerNumber").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("customerName").getStyleAttributes().setHided(false);
		}
    }
	/**
	 * 折让 单位类别
	 */
	protected void discountType_actionPerformed(ActionEvent e) throws Exception {
		DiscountTypeEnum dtEnum = (DiscountTypeEnum)this.discountType.getSelectedItem();
		DiscountUnitTypeEnum unitTypeEnum = DiscountUnitTypeEnum.YUAN;
		
		if(DiscountTypeEnum.ShiWu.equals(dtEnum)){
			unitTypeEnum = DiscountUnitTypeEnum.BAO;
		}
		
		// 设置值
		for(int i = 0; i < getDetailTable().getRowCount(); i++){
			getDetailTable().getRow(i).getCell("discountUnitType").setValue(unitTypeEnum);
		}
		// 更新分录标准的显示状态
		setStandard(dtEnum);
	}
	/**
	 * 根据折让类别 设置分录 标准的显示列 
	 * @param dte
	 */
	private void setStandard(DiscountTypeEnum dtEnum){
		if(DiscountTypeEnum.ShiWu.equals(dtEnum)){
			
			this.getDetailTable().getColumn("standard1").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("standard2").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("standard3").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("standard4").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("standard5").getStyleAttributes().setHided(true);
			
			this.getDetailTable().getColumn("swQty1").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swStandard1").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swQty2").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swStandard2").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swQty3").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swStandard3").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swQty4").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swStandard4").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swQty5").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("swStandard5").getStyleAttributes().setHided(false);
			
		}else{
			this.getDetailTable().getColumn("standard1").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("standard2").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("standard3").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("standard4").getStyleAttributes().setHided(false);
			this.getDetailTable().getColumn("standard5").getStyleAttributes().setHided(false);
			
			this.getDetailTable().getColumn("swQty1").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swStandard1").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swQty2").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swStandard2").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swQty3").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swStandard3").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swQty4").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swStandard4").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swQty5").getStyleAttributes().setHided(true);
			this.getDetailTable().getColumn("swStandard5").getStyleAttributes().setHided(true);
			
			
		}
		
	}
	
	
	/**
	 * 是否按月累计 
	 */
	@Override
	protected void chkbyMonthQtyLimit_actionPerformed(ActionEvent e)
			throws Exception {
		boolean byMonthLimit = this.chkbyMonthQtyLimit.isSelected();
		if(byMonthLimit){
			this.getDetailTable().getColumn("accumulaMaterialGroup").getStyleAttributes().setHided(false);
		}else{
			this.getDetailTable().getColumn("accumulaMaterialGroup").getStyleAttributes().setHided(true);
		}
	}

	/**
	 * 将当前行  数量 和标准 复制到其他行
	 */
	protected void btnCopyToEntries_actionPerformed(ActionEvent e)
			throws Exception {
		List  selectedRows = this.getSelectedRows();
		if(selectedRows == null || selectedRows.size() == 0){
			MsgBox.showInfo("请先选中一条分录");
			return;
		}else if(selectedRows.size() > 1){
			MsgBox.showInfo("只能选择一条分录");
			return;
		}
		if("ADDNEW".equals(this.getOprtState()) || "EDIT".equals(this.getOprtState())){
			ArrayList blocks = this.kdtEntries.getSelectManager().getBlocks();
			
			if(MsgBox.showConfirm2("确认复制当前选中行的数量和标准字段复制到整个表中？") != MsgBox.OK){
				return;
			}
			if(blocks != null){
				if(blocks.size() > 1){
					MsgBox.showInfo("选择多行无法完成复制");
				}else{
					KDTSelectBlock block = (KDTSelectBlock) blocks.get(0);
					if(block != null){
						if(block.getBeginRow() == block.getEndRow()){
							int focusRowIndex = block.getBeginRow();
							Object qty1 = this.kdtEntries.getCell(focusRowIndex, "qty1").getValue();
							Object standard1 = this.kdtEntries.getCell(focusRowIndex, "standard1").getValue();
							Object qty2 = this.kdtEntries.getCell(focusRowIndex, "qty2").getValue();
							Object standard2 = this.kdtEntries.getCell(focusRowIndex, "standard2").getValue();
							
							Object swQty1 = this.kdtEntries.getCell(focusRowIndex, "swQty1").getValue();
							Object swQty2 = this.kdtEntries.getCell(focusRowIndex, "swQty2").getValue();
							Object swStandard1 = this.kdtEntries.getCell(focusRowIndex, "swStandard1").getValue();
							Object swStandard2 = this.kdtEntries.getCell(focusRowIndex, "swStandard2").getValue();
							
							Object qtyLimit = this.kdtEntries.getCell(focusRowIndex, "qtyLimit").getValue();
							Object sdLimit = this.kdtEntries.getCell(focusRowIndex, "sdLimit").getValue();
							Object saleAmountLimit = this.kdtEntries.getCell(focusRowIndex, "saleAmountLimit").getValue();
							
							Object qty3 = this.kdtEntries.getCell(focusRowIndex, "qty3").getValue();
							Object standard3 = this.kdtEntries.getCell(focusRowIndex, "standard3").getValue();
							Object swQty3 = this.kdtEntries.getCell(focusRowIndex, "swQty3").getValue();
							Object swStandard3 = this.kdtEntries.getCell(focusRowIndex, "swStandard3").getValue();
							
							Object qty4 = this.kdtEntries.getCell(focusRowIndex, "qty4").getValue();
							Object standard4 = this.kdtEntries.getCell(focusRowIndex, "standard4").getValue();
							Object swQty4 = this.kdtEntries.getCell(focusRowIndex, "swQty4").getValue();
							Object swStandard4 = this.kdtEntries.getCell(focusRowIndex, "swStandard4").getValue();
							
							Object qty5 = this.kdtEntries.getCell(focusRowIndex, "qty5").getValue();
							Object standard5 = this.kdtEntries.getCell(focusRowIndex, "standard5").getValue();
							Object swQty5 = this.kdtEntries.getCell(focusRowIndex, "swQty5").getValue();
							Object swStandard5 = this.kdtEntries.getCell(focusRowIndex, "swStandard5").getValue();
							
							Object accumulaMaterialGroup = this.kdtEntries.getCell(focusRowIndex, "accumulaMaterialGroup").getValue();
							// 复制到整个table
							for(int i = 0; i < this.kdtEntries.getRowCount(); i++){
								
								
								
								 // 赋值前加 校验，如果已经用过 则 不允许删除
							    BOSUuid entryID = (BOSUuid) kdtEntries.getRow(i).getCell("id").getValue();
							    
							    if(entryID != null){
							    	try{
							    		boolean isExist = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed("", entryID.toString());
							    		if(isExist){
							    			continue;
//							    			MsgBox.showInfo("该分录已经被使用，不能删除");
//							    			SysUtil.abort();
							    		}
							    	}catch(Exception exp){
							    		this.handUIException(exp);
							    	}
							    }
								// 禁用的分录 也不能再赋值
							    EntryState entryState = (EntryState) this.kdtEntries.getCell(focusRowIndex, "lockedState").getValue();
							    if(entryState.Locked.equals(entryState)){
									  continue;
								  }
								this.kdtEntries.getCell(i, "qty1").setValue(qty1);
								this.kdtEntries.getCell(i, "standard1").setValue(standard1);
								this.kdtEntries.getCell(i, "qty2").setValue(qty2);
								this.kdtEntries.getCell(i, "standard2").setValue(standard2);
								this.kdtEntries.getCell(i, "swQty1").setValue(swQty1);
								this.kdtEntries.getCell(i, "swQty2").setValue(swQty2);
								this.kdtEntries.getCell(i, "swStandard1").setValue(swStandard1);
								this.kdtEntries.getCell(i, "swStandard2").setValue(swStandard2);
								
								this.kdtEntries.getCell(i, "qty3").setValue(qty3);
								this.kdtEntries.getCell(i, "standard3").setValue(standard3);
								this.kdtEntries.getCell(i, "swQty3").setValue(swQty3);
								this.kdtEntries.getCell(i, "swStandard3").setValue(swStandard3);
								
								this.kdtEntries.getCell(i, "qty4").setValue(qty4);
								this.kdtEntries.getCell(i, "standard4").setValue(standard4);
								this.kdtEntries.getCell(i, "swQty4").setValue(swQty4);
								this.kdtEntries.getCell(i, "swStandard4").setValue(swStandard4);
								
								this.kdtEntries.getCell(i, "qty5").setValue(qty5);
								this.kdtEntries.getCell(i, "standard5").setValue(standard5);
								this.kdtEntries.getCell(i, "swQty5").setValue(swQty5);
								this.kdtEntries.getCell(i, "swStandard5").setValue(swStandard5);
								
								this.kdtEntries.getCell(i, "accumulaMaterialGroup").setValue(accumulaMaterialGroup);
								
								
								this.kdtEntries.getCell(i, "qtyLimit").setValue(qtyLimit);
								this.kdtEntries.getCell(i, "sdLimit").setValue(sdLimit);
								this.kdtEntries.getCell(i, "saleAmountLimit").setValue(saleAmountLimit);
								
							}
						}
					}
					this.setSave(true);
					this.setSaved(true);
				}
			}
		}
		
	}
	
	// @Override
	public void actionRemove_actionPerformed(ActionEvent e)
	   throws Exception
	{
		if(this.editData.getId() != null){
			boolean isUsed = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed(this.editData.getId().toString(), "");
			if(isUsed){
				MsgBox.showInfo("该政策已经被使用，不能删除");
				SysUtil.abort();
			}else{
				super.actionRemove_actionPerformed(e);
			}
		}else{

			super.actionRemove_actionPerformed(e);
		}
		
	}
	/**
	 * 删除分录前校验是否已经 使用
	 */
	// @Override
	public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception{
		List selectedRows = this.getSelectedRows();
		 for(int i = 0; kdtEntries != null && selectedRows != null && i < selectedRows.size(); i++){
	    	   Integer rowIndex = (Integer) selectedRows.get(i);
	    	   // 删除前加 校验，如果已经用过 则 不允许删除
			    BOSUuid entryID = (BOSUuid) kdtEntries.getRow(rowIndex.intValue()).getCell("id").getValue();
			    
			    if(entryID != null){
			    	try{
			    		boolean isExist = DiscountFacadeFactory.getRemoteInstance().isDiscountUsed("", entryID.toString());
			    		if(isExist){
//			    			continue;
			    			MsgBox.showInfo("该分录已经被使用，不能删除");
			    			SysUtil.abort();
			    		}
			    	}catch(BOSException exp){
			    		this.handUIException(exp);
			    	}
			    }
		 }
		 // 没有中断 则 可以删除
		 super.actionRemoveLine_actionPerformed(e);
	}
//	/**
//	 * ????????У??
//	 */
//	protected void registerValidator() {
//    	getValidateHelper().setCustomValidator( getValidator() );
//		getValidateHelper().registerBindProperty("priceComposition", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("isEnableAim", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("isLimitMerge", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("byMonthQtyLimit", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("effectiveDate", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("expireDate", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("priceCompDetailCustomer", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("priceCompDetailmaterial", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("checkedStatus", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("blockedStatus", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("groupStandardCustomer", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.effectiveDate", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.expireDate", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.asistProperty", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.remark", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.saleLeadTime", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.checkedStatus", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.discountCondition", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.customer.name", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.material.name", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.customer", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.currency", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.id", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.material", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.measureUnit", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.material.model", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.qty1", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.standard1", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.qty2", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.standard2", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.discountUnitType", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.qtyLimit", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.sdLimit", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.saleAmountLimit", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swQty1", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swQty2", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swStandard2", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swStandard1", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.lockedState", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.qty3", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swQty3", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swStandard3", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.standard3", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.qty4", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swQty4", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swStandard4", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.standard4", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.qty5", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swQty5", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.swStandard5", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.Standard5", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.accumulaMaterialGroup.name", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("entries.accumulaMaterialGroup", ValidateHelper.ON_SAVE);   
//		getValidateHelper().registerBindProperty("saleOrgUnit", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("discountType", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("dsNameType", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("accumulaEnddate", ValidateHelper.ON_SAVE);    
//		getValidateHelper().registerBindProperty("accumulaBeginDate", ValidateHelper.ON_SAVE);    		
//	}
	/**
	 * 关闭前提示是否要保存
	 */
	public boolean checkBeforeWindowClosing()
	  {
	    try
	    {
	    	return super.checkBeforeWindowClosing();
//	      checkMustToSave();
	    } catch (Exception e) {
	        logger.error("", e);
	        SysUtil.abort();
	    }
	    return true;
	  }
}