/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
/*      */ package com.kingdee.eas.mm.basedata.client;
/*      */ 
/*      */ import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.KeyStroke;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.extendcontrols.util.ParamHelper;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.KDTableHelper;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.editor.ICellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDCheckBoxMenuItem;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDPromptSelector;
import com.kingdee.bos.ctrl.swing.KDRadioButtonMenuItem;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.StringUtils;
import com.kingdee.bos.ctrl.swing.event.CommitEvent;
import com.kingdee.bos.ctrl.swing.event.CommitListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.PreChangeEvent;
import com.kingdee.bos.ctrl.swing.event.PreChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.ctrl.swing.util.CtrlFormatUtilities;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.BOSUIContext;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.btp.client.BTPBillEditImpl;
import com.kingdee.eas.base.codingrule.CodingRuleException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.IsolatedRuleEnum;
import com.kingdee.eas.basedata.master.material.ManufactureStrategyInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.master.material.MaterialIssueModeEnum;
import com.kingdee.eas.basedata.master.material.MaterialPlanFactory;
import com.kingdee.eas.basedata.master.material.MaterialPlanInfo;
import com.kingdee.eas.basedata.master.material.MaterialProductEnum;
import com.kingdee.eas.basedata.master.material.MaterialProvideTypeEnum;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitCollection;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitCollection;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.IStorageOrgUnit;
import com.kingdee.eas.basedata.org.NewOrgViewHelper;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitCollection;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.IWarehouse;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchaction.ActionLevelEnum;
import com.kingdee.eas.framework.batchaction.BatchActionEnum;
import com.kingdee.eas.framework.batchaction.BatchSelectionEntries;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.framework.client.RealModeIDList;
import com.kingdee.eas.framework.client.tree.KDTreeNode;
import com.kingdee.eas.framework.config.ColumnItemData;
import com.kingdee.eas.framework.config.UserCustomConfigItemData;
import com.kingdee.eas.framework.config.client.ConfigServiceUtils;
import com.kingdee.eas.mm.basedata.BOMAssignFacadeFactory;
import com.kingdee.eas.mm.basedata.BOMExtendSearchFilterCondition;
import com.kingdee.eas.mm.basedata.BOMPTCollection;
import com.kingdee.eas.mm.basedata.BOMPTInfo;
import com.kingdee.eas.mm.basedata.BOMTypeEnum;
import com.kingdee.eas.mm.basedata.BOMUsageEnum;
import com.kingdee.eas.mm.basedata.BomCollection;
import com.kingdee.eas.mm.basedata.BomEntryCollection;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomGroupstandardInfo;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.BomTreeBatchProcessFacadeFactory;
import com.kingdee.eas.mm.basedata.BomTreeCondition;
import com.kingdee.eas.mm.basedata.BomTreeInfo;
import com.kingdee.eas.mm.basedata.BomViewOptionEnum;
import com.kingdee.eas.mm.basedata.ConfigOptionEnum;
import com.kingdee.eas.mm.basedata.ConsumeTypeEnum;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.mm.basedata.IBomTreeBatchProcessFacade;
import com.kingdee.eas.mm.basedata.IMaterialReplace;
import com.kingdee.eas.mm.basedata.ManufactureStrategyGroup;
import com.kingdee.eas.mm.basedata.MaterialReplaceFactory;
import com.kingdee.eas.mm.basedata.OrderBOMPTCollection;
import com.kingdee.eas.mm.basedata.OrderBOMPTFactory;
import com.kingdee.eas.mm.basedata.OrderBOMPTInfo;
import com.kingdee.eas.mm.basedata.StandardRootingFactory;
import com.kingdee.eas.mm.basedata.TrackNumberCollection;
import com.kingdee.eas.mm.basedata.TrackNumberInfo;
import com.kingdee.eas.mm.common.client.KDPromptSelectorAdaptor;
import com.kingdee.eas.mm.common.client.KDTableUtils;
import com.kingdee.eas.mm.common.client.UIHelper;
import com.kingdee.eas.mm.common.util.BotpHelper;
import com.kingdee.eas.mm.common.util.EditTableUtil;
import com.kingdee.eas.mm.common.util.MMConstant;
import com.kingdee.eas.mm.common.util.ResourceUtils;
import com.kingdee.eas.mm.project.ProjectInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.client.SCMGroupClientUtils;
import com.kingdee.eas.scm.common.client.helper.FormattedEditorFactory;
import com.kingdee.eas.scm.common.loadmass.SCMEntryDataVO;
import com.kingdee.eas.scm.common.service.SCMServiceFactory;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
/*      */ 
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ public class BomEditUI extends AbstractBomEditUI
/*      */ {
/*  292 */   private boolean isUseSchedulePart = false;
			 private IObserver iObserver;
/*      */
/*      */
/*      */
/*  296 */   private static final String[] KDT_DATES = { "effectiveDate", "disableDate" };
/*      */
/*      */
/*      */
/*      */
/*      */   public BomEditUI()
/*      */     throws Exception
/*      */   {
/*  304 */     Map colMap = new HashMap();
/*  305 */     this.param = new HashMap();
/*  306 */     colMap.put("MATERIAL", "materialNumber");
/*  307 */     colMap.put("TB_BASEUNIT", "baseUnit");
/*  308 */     colMap.put("TB_BASEQTY", "consumeFixBaseQty");
/*  309 */     colMap.put("TB_UNIT", "unit");
/*  310 */     colMap.put("QTY", "consumeFixQty");
/*  311 */     colMap.put("TB_MATERIALSIZE", "materialModel");
/*      */ 
/*  313 */     colMap.put("QTYPRECISIONFROMUNITTAB", this.QTYPRECISIONFROMUNITTAB);
/*      */
/*      */ 
/*  316 */     colMap.put("QTYPRECISIONFROMBASEUNITTAB", this.QTYPRECISIONFROMBASEUNITTAB);
/*      */
/*      */ 
/*  319 */     this.uiHelper.setConfigMap(colMap);
/*      */ 
/*  321 */     this.uiHelper.setKdtEntries(this.kdtEntrys);
/*      */ 
/*  323 */     String queryInfo = "com.kingdee.eas.basedata.scm.im.inv.app.F7LocationQuery";
/*  324 */     KDBizPromptBox kdtEntrys_location_PromptBox = createKDBizPromptBox(queryInfo);
/*  325 */     kdtEntrys_location_PromptBox.setVisible(true);
/*  326 */     kdtEntrys_location_PromptBox.setDisplayFormat("$number$");
/*  327 */     this.kdtEntrys.getColumn("location").setEditor(new KDTDefaultCellEditor(kdtEntrys_location_PromptBox));
/*      */ 
/*  329 */     ObjectValueRender kdtEntrys_location_OVR = new ObjectValueRender();
/*  330 */     kdtEntrys_location_OVR.setFormat(new BizDataFormat("$number$"));
/*  331 */     this.kdtEntrys.getColumn("location").setRenderer(kdtEntrys_location_OVR);
/*      */
/*      */
/*      */ 
/*  335 */     this.actionCancel.putValue("AcceleratorKey", KeyStroke.getKeyStroke("shift F8"));
/*      */ 
/*  337 */     this.menuItemCancel.setAccelerator(KeyStroke.getKeyStroke("shift F8"));
/*      */ 
/*  339 */     this.actionCancelCancel.putValue("AcceleratorKey", KeyStroke.getKeyStroke("shift F9"));
/*      */ 
/*  341 */     this.menuItemCancelCancel.setAccelerator(KeyStroke.getKeyStroke("shift F9"));
/*      */
/*      */ 
/*  344 */     this.actionAudit.putValue("AcceleratorKey", KeyStroke.getKeyStroke("ctrl U"));
/*      */ 
/*  346 */     this.menuItemAudit.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
/*      */ 
/*  348 */     this.actionUnAudit.putValue("AcceleratorKey", KeyStroke.getKeyStroke("ctrl shift U"));
/*      */ 
/*  350 */     this.menuItemUnAudit.setAccelerator(KeyStroke.getKeyStroke("ctrl shift U"));
/*      */
/*      */ 
/*  353 */     this.MenuItemAttachment.setVisible(true);
/*  354 */     this.MenuItemAttachment.setEnabled(true);
/*  355 */     this.actionAttachment.setEnabled(true);
/*  356 */     this.btnAttachment.setVisible(true);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   public void onLoad()
/*      */     throws Exception
/*      */   {
/*  365 */     cleanBtnText();
/*  366 */     KDTDefaultCellEditor editor = FormattedEditorFactory.getBigDecimalCellEditor(8, false);
/*      */ 
/*  368 */     this.kdtEntrys.getColumn("netWeight").setEditor(editor);
/*  369 */     this.kdtEntrys.getColumn("netWeight").getStyleAttributes().setNumberFormat(CtrlFormatUtilities.getDecimalFormatString());
/*      */ 
/*  371 */     String strParam = (String)getUIContext().get("UIClassParam");
/*  372 */     String newOrderBom = (String)getUIContext().get("addNewOrderBom");
/*  373 */     String isFromTreeUI = (String)getUIContext().get("fromTreeUI");
/*  374 */     if ((isFromTreeUI != null) && (isFromTreeUI.equals("true"))) {
/*  375 */       this.actionFirst.setVisible(false);
/*  376 */       this.actionPre.setVisible(false);
/*  377 */       this.actionNext.setVisible(false);
/*  378 */       this.actionLast.setVisible(false);
/*      */     }
/*  380 */     if ((strParam != null) || (this.isOrderBomTree))
/*      */     {
/*  382 */       if (("1".equals(strParam)) || (this.isOrderBomTree)) {
/*  383 */         setUITitle(getResource("orderBom_addNew"));
/*  384 */         this.isAddOrderBom = true;
/*      */       } else {
/*  386 */         this.cmbType.removeItem(BOMTypeEnum.OrderBOM);
/*      */       }
/*      */     } else {
/*  389 */       BOMTypeEnum bomType = (BOMTypeEnum)getUIContext().get("bomType");
/*  390 */       if ((null == bomType) || (!(bomType.equals(BOMTypeEnum.OrderBOM)))) {
/*  391 */         this.cmbType.removeItem(BOMTypeEnum.OrderBOM);
/*      */       }
/*      */     }
/*  394 */     super.onLoad();
/*      */ 
/*  396 */     initPickingModeValue();
/*  397 */     this.cmbCfgOption.setEnabled(false);
/*  398 */     if ((null != this.editData.getMaterial()) && (this.editData.getBomType().equals(BOMTypeEnum.OrderBOM)))
/*      */     {
/*  400 */       setBomTypeStatus(false);
/*      */     }
/*  402 */     this.cmbCfgOption.setEnabled(false);
/*      */ 
/*  404 */     this.cmbType.removeItem(BOMTypeEnum.NULL);
/*      */ 
/*  406 */     this.cmbCfgOption.setVisible(true);
/*      */
/*      */ 
/*  409 */     this.cmbUsage.removeItem(BOMUsageEnum.NULL);
/*  410 */     this.actionReplaceMaterial.setEnabled(false);
/*  411 */     this.actionStandardRooting.setEnabled(false);
/*  412 */     this.kdtEntrys.getActionMap().remove("Paste");
/*  413 */     this.kdtEntrys.getActionMap().remove("Cut");
/*      */
/*      */ 
/*  416 */     KDComboBox comboxOutPutType = (KDComboBox)this.kdtEntrys.getColumn("outputType").getEditor().getComponent();
/*      */ 
/*  418 */     comboxOutPutType.removeItem(MaterialProductEnum.MASTERPRODUCT);
/*      */
/*      */ 
/*  421 */     KDComboBox comboxProvideType = (KDComboBox)this.kdtEntrys.getColumn("provideType").getEditor().getComponent();
/*      */ 
/*  423 */     comboxProvideType.removeItem(MaterialProvideTypeEnum.NONE);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/*  439 */     for (int i = 0; i < this.kdtEntrys.getRowCount(); ++i)
/*      */     {
/*  441 */       ConsumeTypeEnum consumeType = (ConsumeTypeEnum)this.kdtEntrys.getCell(i, "consumeType").getValue();
/*      */
/*      */ 
/*  444 */       if (consumeType == null)
/*      */         continue;
/*  446 */       if (ConsumeTypeEnum.Proportion.equals(consumeType)) {
/*  447 */         if (((Boolean)this.kdtEntrys.getCell(i, "isAssigned").getValue()).equals(Boolean.FALSE))
/*      */
/*      */         {
/*  450 */           this.kdtEntrys.getCell(i, "proportion").getStyleAttributes().setLocked(false);
/*      */
/*      */         }
/*      */ 
/*  454 */         this.kdtEntrys.getCell(i, "consumeFixQty").getStyleAttributes().setLocked(true);
/*      */
/*      */ 
/*  457 */         this.kdtEntrys.getCell(i, "consumeFixQty").setValue(MMConstant.BIGDECIMAL_ZERO);
/*      */
/*      */
/*      */       }
/*      */       else
/*      */       {
/*  463 */         this.kdtEntrys.getCell(i, "proportion").getStyleAttributes().setLocked(true);
/*      */
/*      */ 
/*  466 */         this.kdtEntrys.getCell(i, "proportion").setValue(MMConstant.BIGDECIMAL_ZERO);
/*      */ 
/*  468 */         if (!(((Boolean)this.kdtEntrys.getCell(i, "isAssigned").getValue()).equals(Boolean.FALSE))) {
/*      */           continue;
/*      */         }
/*  471 */         this.kdtEntrys.getCell(i, "consumeFixQty").getStyleAttributes().setLocked(false);
/*      */
/*      */
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  478 */     String colPrecision = "%{0.00}d";
/*  479 */     KDFormattedTextField colTxtField = new KDFormattedTextField();
/*  480 */     colTxtField.setDataType(1);
/*  481 */     colTxtField.setPrecision(2);
/*  482 */     colTxtField.setMaximumValue(new BigDecimal("100.00"));
/*  483 */     colTxtField.setMinimumValue(MMConstant.BIGDECIMAL_ZERO);
/*  484 */     colTxtField.setRemoveingZeroInDispaly(false);
/*  485 */     colTxtField.setSupportedEmpty(false);
/*  486 */     colTxtField.setNegatived(false);
/*      */ 
/*  488 */     KDFormattedTextField colTxtField1 = new KDFormattedTextField();
/*  489 */     colTxtField1.setDataType(1);
/*  490 */     colTxtField1.setPrecision(2);
/*  491 */     colTxtField1.setMaximumValue(new BigDecimal("1.0E13"));
/*  492 */     colTxtField1.setMinimumValue(MMConstant.BIGDECIMAL_ZERO);
/*  493 */     colTxtField1.setRemoveingZeroInDispaly(false);
/*  494 */     colTxtField1.setSupportedEmpty(false);
/*  495 */     colTxtField1.setNegatived(false);
/*      */
/*      */ 
/*  498 */     this.kdtEntrys.getColumn("proportion").setEditor(new KDTDefaultCellEditor(colTxtField1));
/*      */ 
/*  500 */     this.kdtEntrys.getColumn("proportion").getStyleAttributes().setNumberFormat(colPrecision);
/*      */
/*      */ 
/*  503 */     this.kdtEntrys.getColumn("scrapRatio").setEditor(new KDTDefaultCellEditor(colTxtField));
/*      */ 
/*  505 */     this.kdtEntrys.getColumn("scrapRatio").getStyleAttributes().setNumberFormat(colPrecision);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/*  513 */     this.txtYield.setDataType(1);
/*  514 */     this.txtYield.setPrecision(2);
/*  515 */     this.txtYield.setRemoveingZeroInDispaly(false);
/*  516 */     this.txtYield.setMaximumValue(new BigDecimal("100.00"));
/*  517 */     this.txtYield.setMinimumValue(MMConstant.BIGDECIMAL_ZERO);
/*      */
/*      */ 
/*  520 */     this.txtYield.setNegatived(false);
/*  521 */     this.txtYield.setHorizontalAlignment(4);
/*      */ 
/*  523 */     this.txtproductQty.setSupportedEmpty(false);
/*      */ 
/*  525 */     this.txtproductQty.setHorizontalAlignment(4);
/*      */
/*      */ 
/*  528 */     if (null == this.editData.getId()) {
/*  529 */       dealWithSupplyOrgUnit(null, false);
/*  530 */       dealWithDefaultWarehouse(null, false);
/*      */
/*      */ 
/*  533 */       dealWithTransferOrgUnit(null, false);
/*  534 */       dealWithTransferWarehouse(null, false);
/*      */     }
/*      */ 
/*  537 */     ICellEditor cellEditor = null;
/*      */ 
/*  539 */     cellEditor = this.kdtEntrys.getColumn("supplyOrgUnit").getEditor();
/*  540 */     KDBizPromptBox supplyOrgUnit = (KDBizPromptBox)cellEditor.getComponent();
/*      */ 
/*  542 */     EntityViewInfo viewInfo = new EntityViewInfo();
/*  543 */     supplyOrgUnit.setEntityViewInfo(viewInfo);
/*  544 */     FilterInfo filterInfo = supplyOrgUnit.getEntityViewInfo().getFilter();
/*  545 */     filterInfo.getFilterItems().add(new FilterItemInfo("isBizUnit", Boolean.TRUE, CompareType.EQUALS));
/*      */
/*      */ 
/*  548 */     viewInfo.setFilter(filterInfo);
/*  549 */     supplyOrgUnit.setEntityViewInfo(viewInfo);
/*      */
/*      */ 
/*  552 */     cellEditor = this.kdtEntrys.getColumn("transferOrgUnit").getEditor();
/*  553 */     KDBizPromptBox transferOrgUnit = (KDBizPromptBox)cellEditor.getComponent();
/*      */ 
/*  555 */     viewInfo = new EntityViewInfo();
/*  556 */     transferOrgUnit.setEntityViewInfo(viewInfo);
/*  557 */     filterInfo = transferOrgUnit.getEntityViewInfo().getFilter();
/*  558 */     filterInfo.getFilterItems().add(new FilterItemInfo("isBizUnit", Boolean.TRUE, CompareType.EQUALS));
/*      */
/*      */ 
/*  561 */     viewInfo.setFilter(filterInfo);
/*  562 */     transferOrgUnit.setEntityViewInfo(viewInfo);
/*      */ 
/*  564 */     this.btnProjectChangeQuery.setEnabled(true);
/*  565 */     this.menuItemProjectChangeQuery.setEnabled(true);
/*      */
/*      */ 
/*  568 */     initEntryKeyListener();
/*      */ 
/*  570 */     this.txtName.setMaxLength(80);
/*      */
/*      */
/*      */
/*      */
/*      */ 
/*  576 */     if (isFirstOnload()) {
/*  577 */       initBomGroupF7();
/*      */     }
/*  579 */     if (!(BillBaseStatusEnum.ADD.equals(this.cmbBillStatus.getSelectedItem())))
/*  580 */       this.actionStandardRooting.setEnabled(true);
/*      */     else {
/*  582 */       this.actionStandardRooting.setEnabled(false);
/*      */     }
/*      */ 
/*  585 */     MaterialInfo materialInfo = (MaterialInfo)getUIContext().get("materialfromStandardRooting");
/*      */ 
/*  587 */     if (materialInfo != null) {
/*  588 */       this.prmtmaterial.setValue(materialInfo);
/*  589 */       getUIContext().remove("materialfromStandardRooting");
/*      */     }
/*  591 */     StorageOrgUnitInfo storageOrgUnitInfo = (StorageOrgUnitInfo)getUIContext().get("storagefromStandardRooting");
/*      */ 
/*  593 */     if (storageOrgUnitInfo != null) {
/*  594 */       this.prmtstorageOrgUnit.setValue(storageOrgUnitInfo);
/*  595 */       getUIContext().remove("storagefromStandardRooting");
/*      */     }
/*      */ 
/*  598 */     setTrackNumberAndProject(strParam, newOrderBom);
/*      */ 
/*  600 */     this.prmtBomGroup.setQueryInfo("com.kingdee.eas.mm.basedata.app.BomGroupstandardQuery");
/*      */
/*      */
/*      */ 
/*  604 */     KDFormattedTextField colTxtField2 = new KDFormattedTextField();
/*  605 */     colTxtField2.setDataType(0);
/*  606 */     colTxtField2.setRemoveingZeroInDispaly(true);
/*  607 */     colTxtField2.setSupportedEmpty(true);
/*  608 */     colTxtField2.setNegatived(false);
/*  609 */     colTxtField2.setDataVerifierType(12);
/*      */
/*      */ 
/*  612 */     this.kdtEntrys.getColumn("operationNo").setEditor(new KDTDefaultCellEditor(colTxtField2));
/*      */ 
/*  614 */     this.kdtEntrys.getColumn("operationNo").getStyleAttributes().setNumberFormat(SCMClientUtils.getFormatPattern(0, true));
/*      */ 
/*  616 */     EditTableUtil.formatColDate(this.kdtEntrys, KDT_DATES);
/*      */ 
/*  618 */     super.setReservationVisible(false);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void loadFields()
/*      */   {
/*  629 */     removeListener();
/*  630 */     super.loadFields();
/*      */
/*      */     try
/*      */     {
/*  634 */       setMaterialPrecision();
/*      */     } catch (EASBizException e) {
/*  636 */       handUIException(e);
/*      */     } catch (BOSException e) {
/*  638 */       handUIException(e);
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/*  645 */     BillBaseStatusEnum status = this.editData.getBaseStatus();
/*  646 */     String optState = getOprtState();
/*  647 */     if ((BillBaseStatusEnum.AUDITED.equals(status)) && ("EDIT".equals(optState)))
/*      */     {
/*  649 */       this.oprtState = "VIEW";
/*  650 */       initDataStatus();
/*      */     }
/*      */     try {
/*  653 */       initOtherF7();
/*      */     } catch (Exception e) {
/*  655 */       handleException(e);
/*      */     }
/*  657 */     this.actionPushDown.setEnabled(true);
/*  658 */     BOMTypeEnum bomType = this.editData.getBomType();
/*      */ 
/*  660 */     if (BOMTypeEnum.OrderBOM.equals(bomType)) {
/*  661 */       setBomTypeStatus(false);
/*  662 */       this.kDLabelContainer14.setVisible(true);
/*  663 */       this.cmbCfgOption.setVisible(true);
/*      */
/*      */ 
/*  666 */       this.contSourceCfgBom.setVisible(true);
/*      */     } else {
/*  668 */       this.contSourceCfgBom.setVisible(false);
/*      */     }
/*      */ 
/*  671 */     if (BOMTypeEnum.CfgBOM.equals(bomType)) {
/*  672 */       this.actionPushDown.setEnabled(false);
/*      */ 
/*  674 */       this.btnToBom.setEnabled(false);
/*  675 */       this.menuPBom.setEnabled(false);
/*      */     } else {
/*  677 */       this.btnToBom.setEnabled(true);
/*  678 */       this.menuPBom.setEnabled(true);
/*      */     }
/*      */ 
/*  681 */     dealWithSupplyOrgUnit(null, true);
/*  682 */     dealWithDefaultWarehouse(null, true);
/*  683 */     dealWithStockTransfer(null, true);
/*  684 */     dealWithTransferOrgUnit(null, true);
/*  685 */     dealWithTransferWarehouse(null, true);
/*  686 */     dealWithBackFlush(null, true);
/*  687 */     dealWithPickingMode(null, true);
/*      */ 
/*  689 */     this.actionCopyLine.setEnabled(this.actionAddLine.isEnabled());
/*  690 */     if ((this.editData != null) && (this.editData.getBomType().equals(BOMTypeEnum.CfgBOM)))
/*      */     {
/*  692 */       this.cmbUsage.setEnabled(false);
/*      */     }
/*      */     try
/*      */     {
/*  696 */       setAssignBomStatus();
/*      */     } catch (CodingRuleException e) {
/*  698 */       handUIException(e);
/*      */     } catch (EASBizException e) {
/*  700 */       handUIException(e);
/*      */     } catch (BOSException e) {
/*  702 */       handUIException(e);
/*      */     }
/*      */ 
/*  705 */     setChkIsProjectManuSelected(this.editData.isIsProjectManu());
/*      */ 
/*  707 */     if ((null != this.editData.getMaterial()) && (this.editData.getMaterialPlan() != null))
/*      */     {
/*  709 */       initEntrysMaterialF7s(this.editData.getMaterialPlan());
/*      */     }
/*  711 */     initOldData(this.editData);
/*      */     try
/*      */     {
/*  714 */       if ((this.iObserver != null) && (((this.isUpdate) || (this.isDel)))) {
/*  715 */         this.iObserver.initTree(this.editData, this.isAddNew, this.isUpdate, this.isDel);
/*  716 */         resetFlag();
/*  717 */         this.iObserver.reset(true);
/*      */       }
/*      */     } catch (Exception e) {
/*  720 */       handUIException(e);
/*      */
/*      */     }
/*      */ 
/*  724 */     if ("EDIT".equals(optState)) {
/*      */       try
/*      */       {
/*  727 */         checkToolButtonState();
/*      */       } catch (EASBizException e1) {
/*  729 */         handUIException(e1);
/*      */       } catch (BOSException e1) {
/*  731 */         handUIException(e1);
/*      */       }
/*      */     }
/*  734 */     initEntryKeyListener();
/*      */     try {
/*  736 */       loadfields_cfgBom();
/*  737 */       loadfields_orderBom();
/*      */     } catch (EASBizException e) {
/*  739 */       handUIException(e);
/*      */     } catch (BOSException e) {
/*  741 */       handUIException(e);
/*      */     }
/*      */ 
/*  744 */     initDialogFace();
/*  745 */     if (!(BillBaseStatusEnum.ADD.equals(this.cmbBillStatus.getSelectedItem())))
/*  746 */       this.actionStandardRooting.setEnabled(true);
/*      */     else {
/*  748 */       this.actionStandardRooting.setEnabled(false);
/*      */     }
/*  750 */     addListeners();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void doBeforeSubmit(ActionEvent e)
/*      */     throws Exception
/*      */   {
/*  766 */     super.doBeforeSubmit(e);
/*      */
/*      */ 
/*  769 */     storeTrackNumber();
/*  770 */     setBomName();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void doBeforeSave(ActionEvent e)
/*      */     throws Exception
/*      */   {
/*  786 */     super.doBeforeSave(e);
/*      */
/*      */ 
/*  789 */     storeTrackNumber();
/*  790 */     setBomName();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void initWorkButton()
/*      */   {
/*  805 */     super.initWorkButton();
/*  806 */     this.btnPushDown.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_zoomdown"));
/*  807 */     this.menuPushDown.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_zoomdown"));
/*  808 */     this.btnReplaceMaterial.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_displacemateriel"));
/*      */ 
/*  810 */     this.menuReplaceMaterial.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_displacemateriel"));
/*      */ 
/*  812 */     this.actionCancel.setEnabled(true);
/*  813 */     this.actionCancelCancel.setEnabled(true);
/*      */ 
/*  815 */     this.btnCancel.setEnabled(true);
/*  816 */     this.btnCancel.setVisible(true);
/*  817 */     this.menuItemCancel.setEnabled(true);
/*  818 */     this.menuItemCancel.setVisible(true);
/*  819 */     this.menuItemCancelCancel.setEnabled(true);
/*  820 */     this.menuItemCancelCancel.setVisible(true);
/*  821 */     this.btnCancelCancel.setEnabled(true);
/*  822 */     this.btnCancelCancel.setVisible(true);
/*  823 */     this.btnCancel.setText(getResource("btnCancelText"));
/*  824 */     this.btnCancelCancel.setText(getResource("btnCancelCancelText"));
/*      */ 
/*  826 */     this.btnCancel.setIsControlByParent(false);
/*  827 */     this.btnCancel.setTextIconDisStyle((short) 3);
/*      */ 
/*  829 */     this.btnCancelCancel.setIsControlByParent(false);
/*  830 */     this.btnCancelCancel.setTextIconDisStyle((short) 3);
/*      */
/*      */ 
/*  833 */     this.actionCopyLine.setEnabled(true);
/*      */
/*      */ 
/*  836 */     this.menuItemCopyLine.setVisible(true);
/*      */ 
/*  838 */     this.menuItemCopyLine.setIcon(EASResource.getIcon("imgTbtn_copyline"));
/*  839 */     this.menuBizProcess.setVisible(true);
/*  840 */     this.menuProjectChange.setVisible(true);
/*      */ 
/*  842 */     this.btnAssign.setIcon(EASResource.getIcon("imgTbtn_distributebatch"));
/*  843 */     this.btnAssignLook.setIcon(EASResource.getIcon("imgTbtn_seeallot"));
/*  844 */     this.btnAssignLog.setIcon(EASResource.getIcon("imgTbtn_distributelog"));
/*  845 */     this.menuItemAssign.setIcon(EASResource.getIcon("imgTbtn_distributebatch"));
/*      */ 
/*  847 */     this.menuItemAssignLog.setIcon(EASResource.getIcon("imgTbtn_distributelog"));
/*      */ 
/*  849 */     this.menuItemAssignLook.setIcon(EASResource.getIcon("imgTbtn_seeallot"));
/*      */
/*      */
/*      */ 
/*  853 */     this.btnProjectChangeQuery.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_sourcebillfilter"));
/*      */ 
/*  855 */     this.menuItemProjectChangeQuery.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_sourcebillfilter"));
/*      */
/*      */ 
/*  858 */     this.btnToBom.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_distribute"));
/*      */ 
/*  860 */     this.menuPBom.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_distribute"));
/*      */ 
/*  862 */     this.btnBOMExtendSearch.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_report"));
/*  863 */     this.menuItemBOMExtendSearch.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_report"));
/*      */
/*      */ 
/*  866 */     this.btnBOMExtendBackSearch.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_reportbatch"));
/*      */ 
/*  868 */     this.menuItemBOMExtendBackSearch.setIcon(com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_reportbatch"));
/*      */   }
/*      */
/*      */
/*      */   public void initListener()
/*      */   {
/*  874 */     super.initListener();
/*      */ 
/*  876 */     if (getDetailTable() != null) {
/*  877 */       MMSortManagerByNumber sortManager = new MMSortManagerByNumber(getDetailTable());
/*      */ 
/*  879 */       sortManager.setSortAuto(true);
/*  880 */       for (int i = 0; i < getDetailTable().getColumnCount(); ++i) {
/*  881 */         getDetailTable().getColumn(i).setSortable(true);
/*      */       }
/*      */     }
/*      */ 
/*  885 */     this.prmtmaterial.addSelectorListener(new SelectorListener()
/*      */     {
/*      */       public void willShow(SelectorEvent e) {
/*  888 */         BomEditUI.this.handleMaterailFilterInfo();
/*      */       }
/*      */     });
/*  891 */     this.prmtmaterial.addCommitListener(new CommitListener()
/*      */     {
/*      */       public void willCommit(CommitEvent paramCommitEvent) {
/*  894 */         BomEditUI.this.handleMaterailFilterInfo();
/*      */       }
/*      */     });
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public ICoreBase getBizInterface()
/*      */     throws Exception
/*      */   {
/*  918 */     return BomFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   public KDTable getDetailTable()
/*      */   {
/*  926 */     return this.kdtEntrys;
/*      */   }
/*      */
/*      */
/*      */
/*      */   public IObjectValue createNewDetailData(KDTable table)
/*      */   {
/*  933 */     BomEntryInfo entry = new BomEntryInfo();
/*  934 */     entry.setConsumeType(ConsumeTypeEnum.VariableAmount);
/*  935 */     entry.setSupplyOrgUnit((StorageOrgUnitInfo)getDefaultMainBizOrg());
/*      */ 
/*  937 */     entry.setProvideType(MaterialProvideTypeEnum.CURRENTORGPROVIDE);
/*      */     try {
/*  939 */       Calendar effectiveDate = Calendar.getInstance();
/*      */
/*      */ 
/*  942 */       effectiveDate.set(1900, 0, 1);
/*  943 */       effectiveDate.set(11, 0);
/*  944 */       effectiveDate.set(12, 0);
/*  945 */       effectiveDate.set(13, 0);
/*  946 */       effectiveDate.set(14, 0);
/*      */ 
/*  948 */       Calendar disableDate = Calendar.getInstance();
/*  949 */       disableDate.set(2099, 11, 31);
/*  950 */       disableDate.set(11, 0);
/*  951 */       disableDate.set(12, 0);
/*  952 */       disableDate.set(13, 0);
/*  953 */       disableDate.set(14, 0);
/*  954 */       entry.setEffectiveDate(effectiveDate.getTime());
/*  955 */       entry.setDisableDate(disableDate.getTime());
/*      */ 
/*  957 */       entry.setProportion(MMConstant.BIGDECIMAL_ZERO);
/*  958 */       entry.setNetWeight(MMConstant.BIGDECIMAL_ZERO);
/*  959 */       entry.setIsBackFlush(false);
/*  960 */       entry.setIsStockTransfer(false);
/*  961 */       entry.setFirstCfg(false);
/*  962 */       entry.setFeture(false);
/*  963 */       entry.setIsAssigned(false);
/*      */
/*      */ 
/*  966 */       BigDecimal oneBigDecimal = new BigDecimal("1.00");
/*  967 */       entry.setBaseRate(oneBigDecimal);
/*  968 */       entry.setBaseProductRate(oneBigDecimal);
/*      */     } catch (Exception e) {
/*  970 */       handUIException(e);
/*      */     }
/*  972 */     return entry;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public IObjectValue createNewData()
/*      */   {
/*  982 */     StorageOrgUnitInfo _ = (StorageOrgUnitInfo)getDefaultMainBizOrg();
/*  983 */     if (_ == null) {
/*  984 */       MsgBox.showError(EASResource.getString("com.kingdee.eas.mm.basedata.BASEDATAAutoGenerateResource", "48_BomEditUI"));
/*  985 */       SysUtil.abort();
/*      */     }
/*  987 */     BomInfo objectValue = null;
/*      */     try
/*      */     {
/*  990 */       objectValue = (BomInfo)((IBom)getBizInterface()).createNewData(isUseAgent());
/*      */ 
/*  992 */       String strParam = (String)getUIContext().get("UIClassParam");
/*  993 */       String OrderBomTree = (String)getUIContext().get("OrderBomTree");
/*      */ 
/*  995 */       if (OrderBomTree != null) {
/*  996 */         this.isOrderBomTree = true;
/*      */       }
/*  998 */       if ((strParam != null) || (this.isOrderBomTree))
/*  999 */         if (((("1".equals(strParam)) || (this.isOrderBomTree))) && (this.isAddOrderBom)) {
/* 1000 */           objectValue.setBomType(BOMTypeEnum.OrderBOM);
/* 1001 */           objectValue.setCfgOption(ConfigOptionEnum.INDIRECT_OPTION);
/*      */         } else {
/* 1003 */           objectValue.setBomType(BOMTypeEnum.MfgBOM);
/*      */         }
/*      */       else {
/* 1006 */         objectValue.setBomType(BOMTypeEnum.MfgBOM);
/*      */
/*      */
/*      */
/*      */       }
/*      */ 
/* 1012 */       StorageOrgUnitInfo storageTemp = null;
/* 1013 */       if (getUIContext().get("createOrg") != null) {
/* 1014 */         StorageOrgUnitInfo storage = (StorageOrgUnitInfo)getUIContext().get("createOrg");
/*      */ 
/* 1016 */         OrgUnitInfo[] orgUnits = SCMServiceFactory.getPermissionService().getAuthorizedBizOrgUnits(new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId().toString()), getMainBizOrgType(), getPermissionItem("ADDNEW"));
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 1023 */         for (int i = 0; (orgUnits != null) && (i < orgUnits.length); ++i) {
/* 1024 */           OrgUnitInfo orgUnit = orgUnits[i];
/* 1025 */           if (!(orgUnit.getId().toString().equals(storage.getId().toString())))
/*      */             continue;
/* 1027 */           storageTemp = storage;
/* 1028 */           break;
/*      */         }
/*      */       }
/*      */ 
/* 1032 */       if (storageTemp == null) {
/* 1033 */         OrgUnitInfo orgUnitInfo = getDefaultMainBizOrg();
/* 1034 */         if (orgUnitInfo instanceof StorageOrgUnitInfo) {
/* 1035 */           storageTemp = (StorageOrgUnitInfo)orgUnitInfo;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1040 */       if (getUIContext().get("bomGroupid") != null) {
/* 1041 */         String bomGroupid = getUIContext().get("bomGroupid").toString();
/* 1042 */         BomGroupstandardInfo bomgroupInfo = new BomGroupstandardInfo();
/* 1043 */         bomgroupInfo.setId(BOSUuid.read(bomGroupid));
/* 1044 */         bomgroupInfo.setName((String)getUIContext().get("bomGroupname"));
/*      */ 
/* 1046 */         bomgroupInfo.setNumber((String)getUIContext().get("bomGroupnumber"));
/*      */ 
/* 1048 */         objectValue.setBomGroup(bomgroupInfo);
/*      */       }
/* 1050 */       objectValue.setStorageOrgUnit(storageTemp);
/* 1051 */       objectValue.setUsageType(BOMUsageEnum.Master);
/* 1052 */       objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
/* 1053 */       objectValue.setProductQty(new BigDecimal("1"));
/* 1054 */       objectValue.setCreator(SysContext.getSysContext().getCurrentUserInfo());
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 1062 */       BomEntryInfo info = objectValue.getEntrys().get(0);
/* 1063 */       info.setConsumeType(ConsumeTypeEnum.VariableAmount);
/* 1064 */       info.setSupplyOrgUnit(objectValue.getStorageOrgUnit());
/*      */ 
/* 1066 */       info.setProvideType(MaterialProvideTypeEnum.CURRENTORGPROVIDE);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1085 */       handleException(e);
/*      */     }
/* 1087 */     return objectValue;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean checkBeforeWindowClosing()
/*      */   {
/* 1105 */     return super.checkBeforeWindowClosing();
/*      */   }
/*      */
/*      */   public String getOprtState()
/*      */   {
/* 1110 */     if (this.oprtState == null)
/* 1111 */       this.oprtState = "ADDNEW";
/* 1112 */     return this.oprtState;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean isSupportedBatchActions()
/*      */   {
/* 1128 */     return true;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   public void initBatchActions()
/*      */     throws BOSException
/*      */   {
/* 1137 */     this.actionManager.setClzIBizFactory(ActionLevelEnum.HEAD, BomFactory.class);
/*      */ 
/* 1139 */     getTableSelectionHelper().setTableProperty(this, getDetailTable(), "id", this.txtNumber, null);
/*      */ 
/* 1141 */     super.initBatchActions();
/*      */   }
/*      */
/*      */
/*      */
/*      */   public KDTextField getNumTextField()
/*      */   {
/* 1148 */     return this.txtNumber;
/*      */   }
/*      */
/*      */
/*      */
/*      */   public KDBizPromptBox getMainBizOrg()
/*      */   {
/* 1155 */     return this.prmtstorageOrgUnit;
/*      */   }
/*      */
/*      */   public KDBizPromptBox getMainOrgUnit() {
/* 1159 */     return this.prmtstorageOrgUnit;
/*      */   }
/*      */
/*      */
/*      */
/*      */   public OrgType getMainBizOrgType()
/*      */   {
/* 1166 */     return OrgType.Storage;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void initNeedMainOrgF7s()
/*      */   {
/* 1179 */     OrgUnitInfo orgInfo = null;
/* 1180 */     if (getMainOrgContext() != null) {
/* 1181 */       orgInfo = (OrgUnitInfo)getMainOrgContext().get(getMainBizOrgType());
/*      */
/*      */     }
/*      */ 
/* 1185 */     String materialPlanQuery = BOMUIHelper.getMaterialPlanForBOMQuery(this.f7Manager.getF7DisplayMode());
/*      */ 
/* 1187 */     this.prmtmaterial.setQueryInfo(materialPlanQuery);
/*      */ 
/* 1189 */     this.f7Manager.registerBizMaterialF7(this.prmtmaterial, null, materialPlanQuery, orgInfo, OrgType.Storage, false, true);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 1197 */     KDBizPromptBox bizEntryMaterialBox = getBizMaterialF7(this.kdtEntrys.getColumn("materialNumber"), materialPlanQuery);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 1206 */     this.f7Manager.registerMeasureUnitF7(this.kdtEntrys, "materialNumber", "unit");
/*      */
/*      */ 
/* 1209 */     setNeedMainOrgF7s(new KDBizPromptBox[] { this.prmtmaterial, bizEntryMaterialBox });
/*      */
/*      */ 
/* 1212 */     UIHelper.registerProjectF7ForEdit(this.prmtstorageOrgUnit, this.prmtstorageOrgUnit, this.prmtProject);
/*      */
/*      */
/*      */ 
/* 1216 */     HashSet status = new HashSet();
/* 1217 */     status.add(new Integer(10));
/*      */ 
/* 1219 */     UIHelper.registerTrackNumberF7New(this, this.prmtstorageOrgUnit, this.kdtEntrys, this.prmtProject, "trackNum", status);
/*      */
/*      */
/*      */ 
/* 1223 */     UIHelper.registerTrackNumberF7New(this, this.prmtstorageOrgUnit, this.prmtProject, this.prmtTrack, status);
/*      */
/*      */
/*      */ 
/* 1227 */     this.f7Manager.registerWarehouseF7(this.kdtEntrys, "supplyOrgUnit", "defaultWarehouse");
/*      */
/*      */ 
/* 1230 */     UIHelper.registerLocationF7(this.kdtEntrys, "defaultWarehouse", "location");
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   public String getPermissionItem(String status)
/*      */   {
/* 1238 */     String strPermItem = null;
/* 1239 */     if ("ADDNEW".equals(status))
/* 1240 */       strPermItem = "mm_bom_addnew";
/* 1241 */     else if ("VIEW".equals(status))
/* 1242 */       strPermItem = "mm_bom_view";
/* 1243 */     else if ("EDIT".equals(status)) {
/* 1244 */       strPermItem = "mm_bom_update";
/*      */     }
/*      */ 
/* 1247 */     return strPermItem;
/*      */   }
/*      */
/*      */   public String getOnloadPermItemName()
/*      */   {
/* 1252 */     String strPermItem = null;
/* 1253 */     if (getOprtState().equals("ADDNEW"))
/* 1254 */       strPermItem = "mm_bom_addnew";
/* 1255 */     else if (getOprtState().equals("VIEW"))
/* 1256 */       strPermItem = "mm_bom_view";
/* 1257 */     else if (getOprtState().equals("EDIT")) {
/* 1258 */       strPermItem = "mm_bom_update";
/*      */     }
/*      */ 
/* 1261 */     return strPermItem;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public MaterialInfo[] verifyMaterials(MaterialInfo[] materials, int rowIdx, Map dataMap, String materialFieldname)
/*      */     throws Exception
/*      */   {
/* 1278 */     return materials;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void afterInsertMaterials(int rowIdx, MaterialInfo[] materialInfos, Map dataMap)
/*      */     throws Exception
/*      */   {
/* 1295 */     super.afterInsertMaterials(rowIdx, materialInfos, dataMap);
/* 1296 */     StorageOrgUnitInfo org = (StorageOrgUnitInfo)getMainBizOrg().getData();
/*      */ 
/* 1298 */     SelectorItemCollection selector = getMaterialPlanSelectors();
/* 1299 */     SCMEntryDataVO dataVO = new SCMEntryDataVO();
/*      */ 
/* 1301 */     dataVO.setMaterialPlanSelectors(selector);
/*      */ 
/* 1303 */     SCMEntryDataVO voResult = UIHelper.getDataVO(org, materialInfos, dataVO);
/*      */ 
/* 1305 */     Set orgUnitIds = new HashSet();
/* 1306 */     Set warehouseIds = new HashSet();
/*      */
/*      */ 
/* 1309 */     MaterialInfo material = (MaterialInfo)this.prmtmaterial.getValue();
/* 1310 */     HashSet departmenIDS = new HashSet();
/* 1311 */     String headMterialId = material.getId().toString();
/* 1312 */     String childMterialId = null;
/* 1313 */     BigDecimal tmp = null;
/* 1314 */     IRow optRow = null;
/* 1315 */     for (int i = 0; i < materialInfos.length; ++i) {
/* 1316 */       optRow = this.kdtEntrys.getRow(rowIdx + i);
/* 1317 */       if (material != null) {
/* 1318 */         childMterialId = materialInfos[i].getId().toString();
///* 1319 */         if (headMterialId.equals(childMterialId))
///*      */
///*      */
///*      */         {
///* 1323 */           MsgBox.showError(getResource("fatherAndChildMaterialIsEqual"));
///* 1324 */           optRow.getCell("materialNumber").setValue(null);
///* 1325 */           optRow.getCell("materialName").setValue("");
///* 1326 */           optRow.getCell("materialModel").setValue("");
///* 1327 */           optRow.getCell("unit").setValue(null);
///* 1328 */           optRow.getCell("baseUnit").setValue(null);
///* 1329 */           optRow.getCell("materialInventory").setValue(null);
///*      */ 
///* 1331 */           optRow.getCell("materialProp").setValue(null);
///* 1332 */           optRow.getCell("materialChara").setValue(MaterialCharEnum.NONE);
///*      */ 
///* 1334 */           optRow.getCell("pickingMode").setValue(MaterialIssueModeEnum.NOTISSMODE);
///*      */ 
///* 1336 */           optRow.getCell("scrapRatio").setValue(MMConstant.BIGDECIMAL_ZERO);
///*      */ 
///* 1338 */           optRow.getCell("outputType").setValue(MaterialProductEnum.OTHER);
///*      */ 
///* 1340 */           optRow.getCell("provideType").setValue(MaterialProvideTypeEnum.CURRENTORGPROVIDE);
///*      */
///*      */
///*      */ 
///* 1344 */           optRow.getCell("supplyOrgUnit").setValue(null);
///* 1345 */           optRow.getCell("defaultWarehouse").setValue(null);
///*      */ 
///* 1347 */           optRow.getCell("transferOrgUnit").setValue(null);
///* 1348 */           optRow.getCell("transferWarehouse").setValue(null);
///*      */         }
///*      */       }
///*      */       else
///*      */       {
/* 1353 */         String key = materialInfos[i].getId().toString() + org.getId().toString();
/*      */ 
/* 1355 */         MaterialPlanInfo materialPlan = (MaterialPlanInfo)voResult.getMaterialPlanInfos().get(key);
/*      */ 
/* 1357 */         if (materialPlan == null) {
/*      */           continue;
/*      */         }
/* 1360 */         optRow.getCell("materialName").setValue(materialInfos[i].getName());
/*      */ 
/* 1362 */         optRow.getCell("materialModel").setValue(materialInfos[i].getModel());
/*      */
/*      */ 
/* 1365 */         optRow.getCell("unit").setValue(materialPlan.getProductUnit());
/* 1366 */         optRow.getCell("baseUnit").setValue(voResult.getBaseMeasureUnitInfos()[i]);
/*      */ 
/* 1368 */         if (materialInfos[i].getNetWeight() == null)
/* 1369 */           tmp = MMConstant.BIGDECIMAL_ZERO;
/*      */         else {
/* 1371 */           tmp = materialInfos[i].getNetWeight();
/*      */         }
/* 1373 */         optRow.getCell("netWeight").setValue(tmp);
/*      */ 
/* 1375 */         AdminOrgUnitInfo orgUnitInfo = materialPlan.getDutyDepartment();
/* 1376 */         if (orgUnitInfo != null) {
/* 1377 */           departmenIDS.add(orgUnitInfo.getId().toString());
/*      */
/*      */         }
/*      */ 
/* 1381 */         optRow.getCell("usedUnit").setValue(orgUnitInfo);
/* 1382 */         optRow.getCell("materialInventory").setValue(materialPlan);
/*      */ 
/* 1384 */         optRow.getCell("materialProp").setValue(materialPlan.getMaterialAttr());
/*      */
/*      */ 
/* 1387 */         optRow.getCell("materialChara").setValue(materialPlan.getMaterialChar());
/*      */
/*      */ 
/* 1390 */         optRow.getCell("pickingMode").setValue(materialPlan.getIssMode());
/*      */
/*      */ 
/* 1393 */         if (MaterialProductEnum.MASTERPRODUCT.equals(materialPlan.getOutputType()))
/*      */         {
/* 1395 */           optRow.getCell("outputType").setValue(MaterialProductEnum.OTHER);
/*      */         }
/*      */         else {
/* 1398 */           optRow.getCell("outputType").setValue(materialPlan.getOutputType());
/*      */
/*      */
/*      */         }
/*      */ 
/* 1403 */         optRow.getCell("scrapRatio").setValue(materialPlan.getScrapRate());
/*      */ 
/* 1405 */         optRow.getCell("provideType").setValue(materialPlan.getProvideType());
/*      */
/*      */
/*      */ 
/* 1409 */         optRow.getCell("isBackFlush").setValue(new Boolean(materialPlan.isIsBackFlush()));
/*      */
/*      */
/*      */ 
/* 1413 */         optRow.getCell("supplyOrgUnit").setValue(materialPlan.getSupplyOrgUnit());
/*      */ 
/* 1415 */         optRow.getCell("isStockTransfer").setValue(new Boolean(materialPlan.isIsStockAllot()));
/*      */ 
/* 1417 */         optRow.getCell("transferOrgUnit").setValue(materialPlan.getFromInvOrg());
/*      */ 
/* 1419 */         optRow.getCell("transferWarehouse").setValue(materialPlan.getFromWarehouse());
/*      */
/*      */ 
/* 1422 */         if (null != materialPlan.getSupplyOrgUnit()) {
/* 1423 */           orgUnitIds.add(materialPlan.getSupplyOrgUnit().getId().toString());
/*      */         }
/*      */ 
/* 1426 */         if (null != materialPlan.getFromInvOrg()) {
/* 1427 */           orgUnitIds.add(materialPlan.getFromInvOrg().getId().toString());
/*      */         }
/* 1429 */         if (null != materialPlan.getFromWarehouse()) {
/* 1430 */           warehouseIds.add(materialPlan.getFromWarehouse().getId().toString());
/*      */
/*      */
/*      */         }
/*      */ 
/* 1435 */         if ((materialPlan.getSupplyOrgUnit() != null) && (!(materialPlan.getSupplyOrgUnit().getId().toString().equalsIgnoreCase(org.getId().toString()))))
/*      */
/*      */
/*      */         {
/* 1439 */           EntityViewInfo view = new EntityViewInfo();
/* 1440 */           FilterInfo filter = new FilterInfo();
/*      */ 
/* 1442 */           MaterialProvideTypeEnum provideType = materialPlan.getProvideType();
/*      */ 
/* 1444 */           String orgUnitId = null;
/*      */ 
/* 1446 */           if (provideType.equals(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE))
/*      */           {
/* 1448 */             orgUnitId = org.getId().toString();
/*      */           }
/*      */           else
/*      */           {
/* 1452 */             orgUnitId = materialPlan.getSupplyOrgUnit().getId().toString();
/*      */           }
/*      */ 
/* 1455 */           filter.getFilterItems().add(new FilterItemInfo("OrgUnit", orgUnitId));
/*      */ 
/* 1457 */           filter.getFilterItems().add(new FilterItemInfo("material", materialInfos[i].getId().toString()));
/*      */
/*      */ 
/* 1460 */           Integer status = new Integer(1);
/* 1461 */           filter.getFilterItems().add(new FilterItemInfo("Status", status));
/*      */ 
/* 1463 */           view.setFilter(filter);
/* 1464 */           SelectorItemCollection sic = new SelectorItemCollection();
/* 1465 */           sic.add(new SelectorItemInfo("id"));
/* 1466 */           sic.add(new SelectorItemInfo("defaultWarehouse.id"));
/*      */ 
/* 1468 */           sic.add(new SelectorItemInfo("defaultWarehouse.number"));
/* 1469 */           sic.add(new SelectorItemInfo("defaultWarehouse.name"));
/* 1470 */           sic.add(new SelectorItemInfo("defaultWarehouse.hasLocation"));
/* 1471 */           view.setSelector(sic);
/*      */ 
/* 1473 */           MaterialInventoryCollection mii = MaterialInventoryFactory.getRemoteInstance().getMaterialInventoryCollection(view);
/*      */
/*      */ 
/* 1476 */           if ((mii != null) && (mii.get(0) != null)) {
/* 1477 */             WarehouseInfo wh = mii.get(0).getDefaultWarehouse();
/*      */ 
/* 1479 */             if ((wh != null) && (wh.getId() != null) && (!(StringUtils.isEmpty(wh.getId().toString()))))
/*      */
/*      */
/*      */             {
/* 1483 */               optRow.getCell("defaultWarehouse").setValue(wh);
/* 1484 */               if (wh.isHasLocation()) {
/* 1485 */                 optRow.getCell("location").getStyleAttributes().setLocked(false);
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1492 */           MaterialInventoryInfo miInfo = (MaterialInventoryInfo)voResult.getMaterialInventoryInfos().get(key);
/*      */
/*      */ 
/* 1495 */           if (miInfo != null)
/*      */           {
/* 1497 */             optRow.getCell("defaultWarehouse").setValue(miInfo.getDefaultWarehouse());
/*      */ 
/* 1499 */             if (null != miInfo.getDefaultWarehouse()) {
/* 1500 */               warehouseIds.add(miInfo.getDefaultWarehouse().getId().toString());
/*      */ 
/* 1502 */               if (miInfo.getDefaultWarehouse().isHasLocation()) {
/* 1503 */                 optRow.getCell("location").getStyleAttributes().setLocked(false);
/*      */               }
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 1511 */         SCMClientUtils.changeTableColPrecision(voResult.getMmuPrecisions(), materialInfos[i], voResult.getMeasureUnitInfos()[i], this.kdtEntrys, this.QTYPRECISIONFROMUNITTAB, rowIdx + i);
/*      */
/*      */
/*      */ 
/* 1515 */         SCMClientUtils.changeTableColPrecision(voResult.getMmuPrecisions(), materialInfos[i], voResult.getBaseMeasureUnitInfos()[i], this.kdtEntrys, this.QTYPRECISIONFROMBASEUNITTAB, rowIdx + i);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1520 */     Map map = new HashMap();
/* 1521 */     EntityViewInfo view = new EntityViewInfo();
/* 1522 */     FilterInfo filter = new FilterInfo();
/* 1523 */     view.setFilter(filter);
/*      */
/*      */
/*      */ 
/* 1527 */     SelectorItemCollection sic = new SelectorItemCollection();
/* 1528 */     sic.add(new SelectorItemInfo("number"));
/* 1529 */     sic.add(new SelectorItemInfo("name"));
/* 1530 */     view.setSelector(sic);
/* 1531 */     if (!(orgUnitIds.isEmpty())) {
/* 1532 */       filter.getFilterItems().clear();
/* 1533 */       filter.getFilterItems().add(new FilterItemInfo("id", orgUnitIds, CompareType.INCLUDE));
/*      */ 
/* 1535 */       IStorageOrgUnit factory = StorageOrgUnitFactory.getRemoteInstance();
/* 1536 */       StorageOrgUnitCollection coll = factory.getStorageOrgUnitCollection(view);
/*      */ 
/* 1538 */       StorageOrgUnitInfo info = null;
/* 1539 */       for (int i = 0; i < coll.size(); ++i) {
/* 1540 */         info = coll.get(i);
/* 1541 */         map.put(info.getId().toString(), new String[] { info.getNumber(), info.getName() });
/*      */       }
/*      */     }
/*      */ 
/* 1545 */     if (!(warehouseIds.isEmpty())) {
/* 1546 */       filter.getFilterItems().clear();
/* 1547 */       filter.getFilterItems().add(new FilterItemInfo("id", warehouseIds, CompareType.INCLUDE));
/*      */
/*      */ 
/* 1550 */       IWarehouse factory = WarehouseFactory.getRemoteInstance();
/* 1551 */       WarehouseCollection coll = factory.getWarehouseCollection(view);
/* 1552 */       WarehouseInfo info = null;
/* 1553 */       for (int i = 0; i < coll.size(); ++i) {
/* 1554 */         info = coll.get(i);
/* 1555 */         map.put(info.getId().toString(), new String[] { info.getNumber(), info.getName() });
/*      */       }
/*      */     }
/*      */ 
/* 1559 */     if (!(departmenIDS.isEmpty())) {
/* 1560 */       filter.getFilterItems().clear();
/* 1561 */       filter.getFilterItems().add(new FilterItemInfo("id", departmenIDS, CompareType.INCLUDE));
/*      */
/*      */ 
/* 1564 */       AdminOrgUnitCollection coll = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitCollection(view);
/*      */ 
/* 1566 */       AdminOrgUnitInfo info = null;
/* 1567 */       for (int i = 0; i < coll.size(); ++i) {
/* 1568 */         info = coll.get(i);
/* 1569 */         map.put(info.getId().toString(), new String[] { info.getNumber(), info.getName() });
/*      */       }
/*      */     }
/*      */ 
/* 1573 */     String tmpId = null;
/* 1574 */     String[] arrs = null;
/* 1575 */     IRow optRow2 = null;
/* 1576 */     for (int i = 0; i < materialInfos.length; ++i) {
/* 1577 */       optRow2 = this.kdtEntrys.getRow(rowIdx + i);
/* 1578 */       if (null != optRow2.getCell("materialNumber").getValue()) {
/* 1579 */         if (null != optRow2.getCell("supplyOrgUnit").getValue()) {
/* 1580 */           tmpId = ((StorageOrgUnitInfo)optRow2.getCell("supplyOrgUnit").getValue()).getId().toString();
/*      */ 
/* 1582 */           if (map.containsKey(tmpId)) {
/* 1583 */             arrs = (String[])(String[])map.get(tmpId);
/* 1584 */             ((StorageOrgUnitInfo)optRow2.getCell("supplyOrgUnit").getValue()).setNumber(arrs[0]);
/*      */ 
/* 1586 */             ((StorageOrgUnitInfo)optRow2.getCell("supplyOrgUnit").getValue()).setName(arrs[1]);
/*      */           }
/*      */         }
/*      */ 
/* 1590 */         if (null != optRow2.getCell("defaultWarehouse").getValue()) {
/* 1591 */           tmpId = ((WarehouseInfo)optRow2.getCell("defaultWarehouse").getValue()).getId().toString();
/*      */ 
/* 1593 */           if (map.containsKey(tmpId)) {
/* 1594 */             arrs = (String[])(String[])map.get(tmpId);
/* 1595 */             ((WarehouseInfo)optRow2.getCell("defaultWarehouse").getValue()).setNumber(arrs[0]);
/*      */ 
/* 1597 */             ((WarehouseInfo)optRow2.getCell("defaultWarehouse").getValue()).setName(arrs[1]);
/*      */           }
/*      */         }
/*      */ 
/* 1601 */         if (null != optRow2.getCell("transferOrgUnit").getValue()) {
/* 1602 */           tmpId = ((StorageOrgUnitInfo)optRow2.getCell("transferOrgUnit").getValue()).getId().toString();
/*      */ 
/* 1604 */           if (map.containsKey(tmpId)) {
/* 1605 */             arrs = (String[])(String[])map.get(tmpId);
/* 1606 */             ((StorageOrgUnitInfo)optRow2.getCell("transferOrgUnit").getValue()).setNumber(arrs[0]);
/*      */
/*      */ 
/* 1609 */             ((StorageOrgUnitInfo)optRow2.getCell("transferOrgUnit").getValue()).setName(arrs[1]);
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 1614 */         if (null != optRow2.getCell("transferWarehouse").getValue()) {
/* 1615 */           tmpId = ((WarehouseInfo)optRow2.getCell("transferWarehouse").getValue()).getId().toString();
/*      */
/*      */ 
/* 1618 */           if (map.containsKey(tmpId)) {
/* 1619 */             arrs = (String[])(String[])map.get(tmpId);
/* 1620 */             ((WarehouseInfo)optRow2.getCell("transferWarehouse").getValue()).setNumber(arrs[0]);
/*      */ 
/* 1622 */             ((WarehouseInfo)optRow2.getCell("transferWarehouse").getValue()).setName(arrs[1]);
/*      */           }
/*      */         }
/*      */ 
/* 1626 */         if (null != optRow2.getCell("usedUnit").getValue()) {
/* 1627 */           tmpId = ((AdminOrgUnitInfo)optRow2.getCell("usedUnit").getValue()).getId().toString();
/*      */ 
/* 1629 */           if (map.containsKey(tmpId)) {
/* 1630 */             arrs = (String[])(String[])map.get(tmpId);
/* 1631 */             ((AdminOrgUnitInfo)optRow2.getCell("usedUnit").getValue()).setNumber(arrs[0]);
/*      */ 
/* 1633 */             ((AdminOrgUnitInfo)optRow2.getCell("usedUnit").getValue()).setName(arrs[1]);
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1642 */     dealWithPickingMode(null, true);
/* 1643 */     dealWithDefaultWarehouse(null, true);
/* 1644 */     dealWithSupplyOrgUnit(null, true);
/* 1645 */     dealWithBackFlush(null, true);
/* 1646 */     dealWithStockTransfer(null, true);
/* 1647 */     dealWithTransferOrgUnit(null, true);
/* 1648 */     dealWithTransferWarehouse(null, true);
/*      */   }
/*      */
/*      */
/*      */
/*      */   public SelectorItemCollection getSelectors()
/*      */   {
/* 1655 */     SelectorItemCollection sic = new SelectorItemCollection();
/*      */ 
/* 1657 */     sic.add(new SelectorItemInfo("project.id"));
/* 1658 */     sic.add(new SelectorItemInfo("project.name"));
/* 1659 */     sic.add(new SelectorItemInfo("project.number"));
/*      */ 
/* 1661 */     sic.add(new SelectorItemInfo("storageOrgUnit.id"));
/* 1662 */     sic.add(new SelectorItemInfo("storageOrgUnit.name"));
/* 1663 */     sic.add(new SelectorItemInfo("storageOrgUnit.number"));
/*      */ 
/* 1665 */     sic.add(new SelectorItemInfo("unit.id"));
/* 1666 */     sic.add(new SelectorItemInfo("unit.name"));
/* 1667 */     sic.add(new SelectorItemInfo("unit.number"));
/*      */ 
/* 1669 */     sic.add(new SelectorItemInfo("baseUnit.id"));
/* 1670 */     sic.add(new SelectorItemInfo("baseUnit.name"));
/* 1671 */     sic.add(new SelectorItemInfo("baseUnit.number"));
/*      */ 
/* 1673 */     sic.add(new SelectorItemInfo("material.id"));
/* 1674 */     sic.add(new SelectorItemInfo("material.name"));
/* 1675 */     sic.add(new SelectorItemInfo("material.number"));
/*      */
/*      */
/*      */
/*      */ 
/* 1680 */     sic.add(new SelectorItemInfo("material.baseUnit.id"));
/* 1681 */     sic.add(new SelectorItemInfo("material.unit.id"));
/*      */ 
/* 1683 */     sic.add("materialPlan.id");
/* 1684 */     sic.add("materialPlan.isConfigable");
/* 1685 */     sic.add("materialPlan.manufactureStrategy.id");
/*      */ 
/* 1687 */     sic.add(new SelectorItemInfo("creator.id"));
/* 1688 */     sic.add(new SelectorItemInfo("creator.name"));
/* 1689 */     sic.add(new SelectorItemInfo("creator.number"));
/*      */
/*      */ 
/* 1692 */     sic.add(new SelectorItemInfo("lastUpdateUser.id"));
/* 1693 */     sic.add(new SelectorItemInfo("lastUpdateUser.name"));
/* 1694 */     sic.add(new SelectorItemInfo("lastUpdateUser.number"));
/*      */ 
/* 1696 */     sic.add(new SelectorItemInfo("auditor.id"));
/* 1697 */     sic.add(new SelectorItemInfo("auditor.name"));
/* 1698 */     sic.add(new SelectorItemInfo("auditor.number"));
/*      */ 
/* 1700 */     sic.add(new SelectorItemInfo("isProjectManu"));
/* 1701 */     sic.add(new SelectorItemInfo("number"));
/* 1702 */     sic.add(new SelectorItemInfo("modificationTime"));
/* 1703 */     sic.add(new SelectorItemInfo("createTime"));
/* 1704 */     sic.add(new SelectorItemInfo("bomType"));
/* 1705 */     sic.add(new SelectorItemInfo("modifier.id"));
/* 1706 */     sic.add(new SelectorItemInfo("modifier.name"));
/* 1707 */     sic.add(new SelectorItemInfo("modifier.number"));
/* 1708 */     sic.add(new SelectorItemInfo("name"));
/* 1709 */     sic.add(new SelectorItemInfo("bizDate"));
/* 1710 */     sic.add(new SelectorItemInfo("productQty"));
/*      */ 
/* 1712 */     sic.add(new SelectorItemInfo("auditTime"));
/* 1713 */     sic.add(new SelectorItemInfo("usageType"));
/* 1714 */     sic.add(new SelectorItemInfo("baseStatus"));
/* 1715 */     sic.add(new SelectorItemInfo("productBaseQty"));
/* 1716 */     sic.add(new SelectorItemInfo("material.model"));
/* 1717 */     sic.add(new SelectorItemInfo("yield"));
/* 1718 */     sic.add(new SelectorItemInfo("sourceSOU.id"));
/* 1719 */     sic.add(new SelectorItemInfo("sourceSOU.name"));
/* 1720 */     sic.add(new SelectorItemInfo("sourceSOU.number"));
/* 1721 */     sic.add(new SelectorItemInfo("sourceBomNumber"));
/* 1722 */     sic.add(new SelectorItemInfo("assigner.id"));
/* 1723 */     sic.add(new SelectorItemInfo("assigner.name"));
/* 1724 */     sic.add(new SelectorItemInfo("assigner.number"));
/* 1725 */     sic.add(new SelectorItemInfo("assignTime"));
/* 1726 */     sic.add(new SelectorItemInfo("cfgOption"));
/* 1727 */     sic.add(new SelectorItemInfo("material.pictureNumber"));
/* 1728 */     sic.add(new SelectorItemInfo("sourceCfgBomNumber"));
/* 1729 */     sic.add(new SelectorItemInfo("bomGroup.id"));
/* 1730 */     sic.add(new SelectorItemInfo("bomGroup.name"));
/* 1731 */     sic.add(new SelectorItemInfo("bomGroup.number"));
/*      */
/*      */ 
/* 1734 */     sic.add(new SelectorItemInfo("isAssigned"));
/*      */ 
/* 1736 */     sic.add(new SelectorItemInfo("sourceBomId"));
/* 1737 */     sic.add(new SelectorItemInfo("sourceBomNumber"));
/*      */
/*      */
/*      */ 
/* 1741 */     sic.add(new SelectorItemInfo("entrys.proportion"));
/* 1742 */     sic.add(new SelectorItemInfo("entrys.scrapRatio"));
/* 1743 */     sic.add(new SelectorItemInfo("entrys.leadtime"));
/* 1744 */     sic.add(new SelectorItemInfo("entrys.effectiveDate"));
/* 1745 */     sic.add(new SelectorItemInfo("entrys.disableDate"));
/* 1746 */     sic.add(new SelectorItemInfo("entrys.consumeType"));
/* 1747 */     sic.add(new SelectorItemInfo("entrys.material.*"));
/* 1748 */     sic.add(new SelectorItemInfo("entrys.material.name"));
/* 1749 */     sic.add(new SelectorItemInfo("entrys.material.model"));
/* 1750 */     sic.add(new SelectorItemInfo("entrys.consumeFixBaseQty"));
/* 1751 */     sic.add(new SelectorItemInfo("entrys.materialInventory.*"));
/* 1752 */     sic.add(new SelectorItemInfo("entrys.consumeFixQty"));
/* 1753 */     sic.add(new SelectorItemInfo("entrys.supplyOrgUnit.id"));
/* 1754 */     sic.add(new SelectorItemInfo("entrys.supplyOrgUnit.name"));
/* 1755 */     sic.add(new SelectorItemInfo("entrys.supplyOrgUnit.number"));
/* 1756 */     sic.add(new SelectorItemInfo("entrys.outputType"));
/* 1757 */     sic.add(new SelectorItemInfo("entrys.provideType"));
/* 1758 */     sic.add(new SelectorItemInfo("entrys.issMode"));
/* 1759 */     sic.add(new SelectorItemInfo("entrys.defaultWarehouse.id"));
/* 1760 */     sic.add(new SelectorItemInfo("entrys.defaultWarehouse.name"));
/* 1761 */     sic.add(new SelectorItemInfo("entrys.defaultWarehouse.number"));
/*      */ 
/* 1763 */     sic.add(new SelectorItemInfo("entrys.defaultWarehouse.hasLocation"));
/* 1764 */     sic.add(new SelectorItemInfo("entrys.productRate"));
/* 1765 */     sic.add(new SelectorItemInfo("entrys.materialChar"));
/* 1766 */     sic.add(new SelectorItemInfo("entrys.baseRate"));
/* 1767 */     sic.add(new SelectorItemInfo("entrys.baseProductRate"));
/* 1768 */     sic.add(new SelectorItemInfo("entrys.blueprint"));
/* 1769 */     sic.add(new SelectorItemInfo("entrys.isAssigned"));
/* 1770 */     sic.add(new SelectorItemInfo("entrys.blkSize"));
/* 1771 */     sic.add(new SelectorItemInfo("entrys.specifiedLength"));
/* 1772 */     sic.add(new SelectorItemInfo("entrys.usedUnit.id"));
/* 1773 */     sic.add(new SelectorItemInfo("entrys.usedUnit.name"));
/* 1774 */     sic.add(new SelectorItemInfo("entrys.usedUnit.number"));
/* 1775 */     sic.add(new SelectorItemInfo("entrys.designUnit.id"));
/* 1776 */     sic.add(new SelectorItemInfo("entrys.designUnit.name"));
/* 1777 */     sic.add(new SelectorItemInfo("entrys.designUnit.number"));
/* 1778 */     sic.add(new SelectorItemInfo("entrys.designRemark"));
/* 1779 */     sic.add(new SelectorItemInfo("entrys.feture"));
/* 1780 */     sic.add(new SelectorItemInfo("entrys.firstCfg"));
/* 1781 */     sic.add(new SelectorItemInfo("entrys.canSelected"));
/* 1782 */     sic.add(new SelectorItemInfo("entrys.materialProp"));
/* 1783 */     sic.add(new SelectorItemInfo("entrys.netWeight"));
/* 1784 */     sic.add(new SelectorItemInfo("entrys.location.id"));
/* 1785 */     sic.add(new SelectorItemInfo("entrys.location.name"));
/* 1786 */     sic.add(new SelectorItemInfo("entrys.location.number"));
/*      */ 
/* 1788 */     sic.add(new SelectorItemInfo("entrys.isStockTransfer"));
/* 1789 */     sic.add(new SelectorItemInfo("entrys.transferOrgUnit.id"));
/* 1790 */     sic.add(new SelectorItemInfo("entrys.transferOrgUnit.name"));
/* 1791 */     sic.add(new SelectorItemInfo("entrys.transferOrgUnit.number"));
/* 1792 */     sic.add(new SelectorItemInfo("entrys.transferWarehouse.id"));
/* 1793 */     sic.add(new SelectorItemInfo("entrys.transferWarehouse.name"));
/* 1794 */     sic.add(new SelectorItemInfo("entrys.transferWarehouse.number"));
/* 1795 */     sic.add(new SelectorItemInfo("entrys.isBackFlush"));
/* 1796 */     sic.add(new SelectorItemInfo("entrys.operationNo"));
/*      */
/*      */ 
/* 1799 */     sic.add(new SelectorItemInfo("entrys.material.id"));
/* 1800 */     sic.add(new SelectorItemInfo("entrys.material.name"));
/* 1801 */     sic.add(new SelectorItemInfo("entrys.material.number"));
/* 1802 */     sic.add(new SelectorItemInfo("entrys.material.model"));
/* 1803 */     sic.add(new SelectorItemInfo("entrys.material.pricePrecision"));
/* 1804 */     sic.add(new SelectorItemInfo("entrys.material.baseUnit"));
/* 1805 */     sic.add(new SelectorItemInfo("entrys.material.assistUnit"));
/*      */ 
/* 1807 */     sic.add(new SelectorItemInfo("entrys.unit.id"));
/* 1808 */     sic.add(new SelectorItemInfo("entrys.unit.name"));
/* 1809 */     sic.add(new SelectorItemInfo("entrys.unit.number"));
/*      */ 
/* 1811 */     sic.add(new SelectorItemInfo("entrys.baseUnit.id"));
/* 1812 */     sic.add(new SelectorItemInfo("entrys.baseUnit.name"));
/* 1813 */     sic.add(new SelectorItemInfo("entrys.baseUnit.number"));
/*      */ 
/* 1815 */     sic.add(new SelectorItemInfo("entrys.materialInventory.id"));
/* 1816 */     sic.add(new SelectorItemInfo("entrys.materialInventory.materialAttribute"));
/*      */ 
/* 1818 */     sic.add(new SelectorItemInfo("entrys.materialInventory.issueMode"));
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 1838 */     return sic;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public IObjectValue getValue(IObjectPK pk)
/*      */     throws Exception
/*      */   {
/* 1848 */     return getBizInterface().getValue(pk, getMergedSelector(), getSortter());
/*      */   }
/*      */
/*      */   public void initDataStatus()
/*      */   {
/* 1853 */     super.initDataStatus();
/* 1854 */     this.toolBar.remove(this.btnAttachment);
/* 1855 */     this.toolBar.remove(this.btnAuditResult);
/* 1856 */     this.actionCancel.setEnabled(true);
/* 1857 */     this.actionCancelCancel.setEnabled(true);
/*      */
/*      */ 
/* 1860 */     this.btnCancel.setEnabled(true);
/* 1861 */     this.btnCancel.setVisible(true);
/* 1862 */     this.btnCancelCancel.setEnabled(true);
/* 1863 */     this.btnCancelCancel.setVisible(true);
/* 1864 */     this.menuItemCancel.setEnabled(true);
/* 1865 */     this.menuItemCancel.setVisible(true);
/* 1866 */     this.menuItemCancelCancel.setEnabled(true);
/* 1867 */     this.menuItemCancelCancel.setVisible(true);
/* 1868 */     this.kDSeparator5.setEnabled(false);
/* 1869 */     this.kDSeparator5.setVisible(false);
/*      */ 
/* 1871 */     this.actionBOMExtendBackSearch.setEnabled(false);
/* 1872 */     this.actionBOMExtendSearch.setEnabled(false);
/* 1873 */     this.actionBOMExtendBackSearch.setVisible(false);
/* 1874 */     this.actionBOMExtendSearch.setVisible(false);
/*      */ 
/* 1876 */     if ((getUIContext().get("isUICache") != null) && (getUIContext().get("isUICache").equals("true")))
/*      */     {
/* 1878 */       this.actionBOMExtendBackSearch.setEnabled(true);
/* 1879 */       this.actionBOMExtendSearch.setEnabled(true);
/* 1880 */       this.actionBOMExtendBackSearch.setVisible(true);
/* 1881 */       this.actionBOMExtendSearch.setVisible(true);
/*      */
/*      */ 
/* 1884 */       setBatchMenuStatus(true);
/*      */     }
/*      */ 
/* 1887 */     if ((getUIContext().get("isUICache") != null) && (getQueryDate() != null)) {
/* 1888 */       this.chkMenuItemQueryDate.setEnabled(true);
/* 1889 */       this.chkMenuItemQueryDate.setVisible(true);
/* 1890 */       this.chkMenuItemQueryDate.setSelected(true);
/*      */     } else {
/* 1892 */       this.chkMenuItemQueryDate.setEnabled(false);
/* 1893 */       this.chkMenuItemQueryDate.setVisible(false);
/*      */ 
/* 1895 */       setViewOptionValue();
/*      */     }
/*      */ 
/* 1898 */     if ((null != getUIContext().get("IsOrderBomTree")) && (getUIContext().get("isUICache") != null) && (getUIContext().get("isUICache").equals("true")) && (getUIContext().get("UIClassParam") != null) && (getUIContext().get("UIClassParam").equals("1")))
/*      */
/*      */
/*      */
/*      */     {
/* 1903 */       setOrderBomAssignStatus(true);
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */     else setOrderBomAssignStatus(false);
/*      */ 
/* 1911 */     if ((getUIContext().get("UIClassParam") != null) && (getUIContext().get("UIClassParam").equals("1")) && (this.isAddOrderBom))
/*      */
/*      */
/*      */     {
/* 1915 */       this.conAssginer.setBoundLabelText(getResource(BOM_ASSIGN_RESOURCE, "ORDERBOM_ASSIGNLOG_ASSIGNER"));
/*      */ 
/* 1917 */       this.contDateAssign.setBoundLabelText(getResource(BOM_ASSIGN_RESOURCE, "ORDERBOM_ASSIGNLOG_ASSIGNDATE"));
/*      */     }
/*      */     else {
/* 1920 */       this.conAssginer.setBoundLabelText(this.resHelper.getString("conAssginer.boundLabelText"));
/*      */ 
/* 1922 */       this.contDateAssign.setBoundLabelText(this.resHelper.getString("contDateAssign.boundLabelText"));
/*      */
/*      */     }
/*      */ 
/* 1926 */     if ((getUIContext().get("isUICache") != null) && (getUIContext().get("isUICache").equals("true")))
/*      */     {
/* 1928 */       setPushDownStatus(false);
/*      */
/*      */
/*      */     }
/*      */     else setPushDownStatus(true);
/*      */ 
/* 1934 */     BomInfo info = (BomInfo)this.dataBinder.getValueObject();
/* 1935 */     BillBaseStatusEnum status = info.getBaseStatus();
/*      */ 
/* 1937 */     if ("ADDNEW".equals(getOprtState())) {
/* 1938 */       this.actionCancel.setEnabled(false);
/* 1939 */       this.actionCancelCancel.setEnabled(false);
/*      */
/*      */     }
/* 1942 */     else if (("VIEW".equals(getOprtState())) || ("FINDVIEW".equals(getOprtState())))
/*      */     {
/* 1944 */       this.actionEdit.setEnabled(true);
/* 1945 */       if ((status != null) && (status.equals(BillBaseStatusEnum.AUDITED))) {
/* 1946 */         this.actionCancel.setEnabled(true);
/* 1947 */         this.actionCancelCancel.setEnabled(false);
/* 1948 */         this.actionEdit.setEnabled(false);
/* 1949 */       } else if ((status != null) && (status.equals(BillBaseStatusEnum.DELETED)))
/*      */       {
/* 1951 */         this.actionCancel.setEnabled(false);
/* 1952 */         this.actionCancelCancel.setEnabled(true);
/* 1953 */         this.actionEdit.setEnabled(false);
/*      */       } else {
/* 1955 */         this.actionCancel.setEnabled(false);
/* 1956 */         this.actionCancelCancel.setEnabled(false);
/*      */
/*      */       }
/*      */ 
/* 1960 */       if ((status != null) && (status.equals(BillBaseStatusEnum.SUBMITED))) {
/* 1961 */         this.actionAudit.setEnabled(true);
/* 1962 */         this.actionUnAudit.setEnabled(false);
/*      */
/*      */       }
/* 1965 */       else if ((status != null) && (status.equals(BillBaseStatusEnum.AUDITED)))
/*      */       {
/* 1967 */         this.actionAudit.setEnabled(false);
/* 1968 */         this.actionUnAudit.setEnabled(true);
/*      */       }
/*      */       else
/*      */       {
/* 1972 */         this.actionAudit.setEnabled(false);
/* 1973 */         this.actionUnAudit.setEnabled(false);
/*      */       }
/*      */ 
/*      */     }
/* 1977 */     else if ("EDIT".equals(getOprtState()))
/*      */     {
/* 1979 */       this.actionEdit.setEnabled(false);
/*      */ 
/* 1981 */       if ((status != null) && (status.equals(BillBaseStatusEnum.AUDITED))) {
/* 1982 */         this.actionCancel.setEnabled(true);
/* 1983 */         this.actionCancelCancel.setEnabled(false);
/*      */
/*      */       }
/* 1986 */       else if ((status != null) && (status.equals(BillBaseStatusEnum.DELETED)))
/*      */       {
/* 1988 */         this.actionCancel.setEnabled(false);
/* 1989 */         this.actionCancelCancel.setEnabled(true);
/*      */       }
/*      */       else
/*      */       {
/* 1993 */         this.actionCancel.setEnabled(false);
/* 1994 */         this.actionCancelCancel.setEnabled(false);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2011 */     initEntryKeyListener();
/*      */   }
/*      */
/*      */   public void setAddLineStatus(boolean status) {
/* 2015 */     super.setAddLineStatus(status);
/* 2016 */     this.actionCopyLine.setEnabled(status);
/* 2017 */     this.menuItemCopyLine.setEnabled(status);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void afterInsertLine(KDTable table, IObjectValue lineData)
/*      */   {
/* 2029 */     KDTEditEvent event = createKDTEditEvent(false);
/*      */ 
/* 2031 */     dealWithSupplyOrgUnit(event, false);
/* 2032 */     dealWithDefaultWarehouse(event, false);
/*      */ 
/* 2034 */     dealWithStockTransfer(event, false);
/* 2035 */     dealWithTransferOrgUnit(event, false);
/* 2036 */     dealWithTransferWarehouse(event, false);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void afterAddLine(KDTable table, IObjectValue lineData)
/*      */   {
/* 2047 */     KDTEditEvent event = createKDTEditEvent(true);
/*      */ 
/* 2049 */     dealWithSupplyOrgUnit(event, false);
/* 2050 */     dealWithDefaultWarehouse(event, false);
/*      */ 
/* 2052 */     dealWithStockTransfer(event, false);
/* 2053 */     dealWithTransferOrgUnit(event, false);
/* 2054 */     dealWithTransferWarehouse(event, false);
/*      */   }
/*      */
/*      */   public void afterSubmitEdit(IObjectPK pk) {
/* 2058 */     setOprtState(OprtState.EDIT);
/*      */     try {
/* 2060 */       if (isSubmitLoad()) {
/* 2061 */         if ((IObjectValue)getUIContext().get("InitDataObject") != null)
/*      */         {
/* 2063 */           BomInfo info = (BomInfo)getUIContext().get("InitDataObject");
/*      */ 
/* 2065 */           if ((BillBaseStatusEnum.AUDITED.equals(info.getBaseStatus())) && (this.editData.getId() != null))
/*      */           {
/* 2067 */             if (this.editData.getId() != null)
/*      */
/*      */             {
/* 2070 */               setOprtState("RELEASEALL");
/*      */               try {
/* 2072 */                 pubFireVOChangeListener(this.editData.getId().toString());
/*      */               }
/*      */               catch (Throwable t) {
/* 2075 */                 handUIException(t);
/*      */               }
/*      */             }
/* 2078 */             setOprtState(OprtState.VIEW);
/*      */           }
/* 2080 */           setDataObject((IObjectValue)getUIContext().get("InitDataObject"));
/*      */         }
/*      */         else {
/* 2083 */           setDataObject(getValue(pk));
/*      */         }
/* 2085 */         loadFields();
/* 2086 */         initOldData(this.editData);
/*      */       }
/*      */     } catch (Exception e) {
/* 2089 */       handUIExceptionAndAbort(e);
/*      */     }
/*      */   }
/*      */
/*      */   public void setTableToSumField() {
/* 2094 */     if ((getDetailTable() != null) && (getSumColNames() != null))
/* 2095 */       setTableToSumField(getDetailTable(), getSumColNames());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public IMetaDataPK getTDQueryPK()
/*      */   {
/* 2112 */     return MetaDataPK.create("com.kingdee.eas.mm.basedata.app.Bom4PrintWithReplaceMaterialQuery");
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public String getTDFileName()
/*      */   {
/* 2129 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/* 2130 */     if (BOMTypeEnum.MfgBOM.equals(bomType))
/* 2131 */       return "/MM/basedata/BOM/MfgBom";
/* 2132 */     if (BOMTypeEnum.OrderBOM.equals(bomType))
/* 2133 */       return "/MM/basedata/BOM/OrderBom";
/* 2134 */     if (BOMTypeEnum.CfgBOM.equals(bomType)) {
/* 2135 */       return "/MM/basedata/BOM/CfgBom";
/*      */     }
/* 2137 */     return "/MM/basedata/BOM";
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean isModifySave()
/*      */   {
/* 2151 */     return super.isModifySave();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void setCustomerDataProvider(MultiDataSourceDataProviderProxy data, List idList)
/*      */   {
/* 2168 */     SCMCommonDataProvider mainQueryData = new BomPrintDataProvider(idList, MetaDataPK.create("com.kingdee.eas.mm.basedata.app.Bom4PrintWithReplaceMaterialQuery"));
/*      */
/*      */
/*      */ 
/* 2172 */     SCMCommonDataProvider mainQueryData1 = new BomPrintDataProvider(idList, MetaDataPK.create("com.kingdee.eas.mm.basedata.app.Bom4PrintWithoutReplaceMaterialQuery"));
/*      */
/*      */
/*      */
/*      */ 
/* 2177 */     SCMCommonDataProvider mainQueryDataOrderBOM = new OrderBomPrintDataProvider(idList, MetaDataPK.create("com.kingdee.eas.mm.basedata.app.OrderBomPrintQuery"));
/*      */
/*      */
/*      */ 
/* 2181 */     data.put("Bom4PrintWithReplaceMaterialQuery", mainQueryData);
/* 2182 */     data.put("Bom4PrintWithoutReplaceMaterialQuery", mainQueryData1);
/* 2183 */     data.put("OrderBomPrintQuery", mainQueryDataOrderBOM);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean checkValid()
/*      */   {
/* 2194 */     return true;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void createToBill(Map map)
/*      */     throws Exception
/*      */   {
/* 2204 */     if ((this.editData.getBomType().equals(BOMTypeEnum.OrderBOM)) && (!(this.editData.getBaseStatus().equals(BillBaseStatusEnum.ADD))))
/*      */     {
/* 2206 */       BTPBillEditImpl billEdit = new BTPBillEditImpl(this);
/* 2207 */       billEdit.init();
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 2213 */       String projectId = null;
/*      */ 
/* 2215 */       if (this.prmtProject.getValue() != null) {
/* 2216 */         projectId = ((ProjectInfo)this.prmtProject.getValue()).getId().toString();
/*      */       }
/*      */ 
/* 2219 */       Set trackNumberIds = new HashSet();
/* 2220 */       TrackNumberInfo[] tnis = getTrackNumberOfOrderBom();
/* 2221 */       if (tnis != null) {
/* 2222 */         TrackNumberInfo tni = null;
/* 2223 */         for (int i = 0; i < tnis.length; ++i) {
/* 2224 */           tni = tnis[i];
/* 2225 */           trackNumberIds.add(tni.getId().toString());
/*      */         }
/*      */       }
/* 2228 */       OrderBOMPTCollection col = new OrderBOMPTCollection();
/* 2229 */       EntityViewInfo entityViewInfo = new EntityViewInfo();
/* 2230 */       FilterInfo filterInfo = new FilterInfo();
/*      */ 
/* 2232 */       filterInfo.getFilterItems().add(new FilterItemInfo("projectId", projectId, CompareType.EQUALS));
/*      */
/*      */ 
/* 2235 */       filterInfo.getFilterItems().add(new FilterItemInfo("trackId", trackNumberIds, CompareType.INCLUDE));
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 2241 */       filterInfo.getFilterItems().add(new FilterItemInfo("orderId.id", this.editData.getId().toString(), CompareType.EQUALS));
/*      */
/*      */ 
/* 2244 */       entityViewInfo.setFilter(filterInfo);
/* 2245 */       col = OrderBOMPTFactory.getRemoteInstance().getOrderBOMPTCollection(entityViewInfo);
/*      */ 
/* 2247 */       this.editData.setOrderBomPT(col);
/* 2248 */       String destBillBosType = (String)map.get("DESCBILL_BOSTYPE");
/*      */ 
/* 2250 */       checkForCreateToBill();
/*      */ 
/* 2252 */       if ((this.editData.getId() == null) || (destBillBosType == null)) {
/* 2253 */         return;
/*      */       }
/*      */ 
/* 2256 */       if (getBillEdit() != null)
/*      */       {
/* 2258 */         Map btpNavCtx = (Map)getUIContext().get("BTPNAVCTX");
/* 2259 */         if (btpNavCtx == null) {
/* 2260 */           btpNavCtx = new HashMap();
/* 2261 */           getUIContext().put("BTPNAVCTX", btpNavCtx);
/*      */         }
/* 2263 */         if (isSubContractBill()) {
/* 2264 */           btpNavCtx.put("isSubContract", Boolean.TRUE);
/*      */
/*      */
/*      */         }
/*      */ 
/* 2269 */         BotpHelper.CreateTo(this.editData, destBillBosType, this);
/*      */       }
/*      */     }
/*      */     else {
/* 2273 */       super.createToBill(map);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void addCommonMenusToTable(KDTable table)
/*      */   {
/* 2290 */     if (isAllowCommonMenu())
/* 2291 */       super.addCommonMenusToTable(this.kdtEntrys);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean isAllowCommonMenu()
/*      */   {
/* 2309 */     return true;
/*      */   }
/*      */
/*      */
/*      */
/*      */   public void kdtEntrys_tableSelectChanged(KDTSelectEvent e)
/*      */     throws Exception
/*      */   {
/* 2317 */     boolean pushDownFlag = true;
/* 2318 */     int[] selectRows = KDTableUtil.getSelectedRows(getDetailTable());
/*      */ 
/* 2320 */     if (selectRows.length == 1) {
/* 2321 */       int selectIndex = selectRows[0];
/* 2322 */       if (selectIndex == -1) {
/* 2323 */         return;
/*      */       }
/* 2325 */       IRow row = this.kdtEntrys.getRow(selectIndex);
/*      */ 
/* 2327 */       ICell cell = row.getCell("materialNumber");
/* 2328 */       MaterialInfo mi = null;
/* 2329 */       if (cell.getValue() instanceof Object[]) {
/* 2330 */         Object[] objVal = (Object[])(Object[])cell.getValue();
/* 2331 */         mi = (MaterialInfo)objVal[0];
/* 2332 */       } else if (cell.getValue() instanceof Object) {
/* 2333 */         mi = (MaterialInfo)cell.getValue();
/*      */       }
/*      */ 
/* 2336 */       cell = row.getCell("materialInventory");
/* 2337 */       if (null == mi)
/*      */       {
/* 2339 */         pushDownFlag = false;
/*      */       }
/* 2341 */       BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/* 2342 */       if ((null != bomType) && (bomType != BOMTypeEnum.CfgBOM)) {
/* 2343 */         this.actionPushDown.setEnabled(pushDownFlag);
/* 2344 */         this.actionReplaceMaterial.setEnabled(true);
/*      */       }
/*      */       else
/*      */       {
/* 2348 */         this.actionPushDown.setEnabled(false);
/* 2349 */         this.actionReplaceMaterial.setEnabled(false);
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 2355 */       this.actionPushDown.setEnabled(false);
/* 2356 */       this.actionReplaceMaterial.setEnabled(false);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void entryUnitChange(int rowIndex, MeasureUnitInfo curUnitOldValue, boolean isPrice)
/*      */   {
/* 2373 */     MeasureUnitInfo measureUnitInfo = (MeasureUnitInfo)getDetailTable().getRow(rowIndex).getCell("unit").getValue();
/*      */ 
/* 2375 */     MaterialInfo materialInfo = (MaterialInfo)getDetailTable().getCell(rowIndex, "materialNumber").getValue();
/*      */ 
/* 2377 */     if ((measureUnitInfo == null) || (materialInfo == null))
/* 2378 */       return;
/*      */     try
/*      */     {
/* 2381 */       IRow changeRow = getDetailTable().getRow(rowIndex);
/* 2382 */       BigDecimal qty = (BigDecimal)changeRow.getCell("consumeFixQty").getValue();
/*      */ 
/* 2384 */       if (qty == null) {
/* 2385 */         return;
/*      */       }
/* 2387 */       SCMClientUtils.changeTableColPrecisionByMaterial(materialInfo, measureUnitInfo, getDetailTable(), this.QTYPRECISIONFROMUNITTAB, new int[] { rowIndex });
/*      */
/*      */ 
/* 2390 */       if ((curUnitOldValue != null) && (!(curUnitOldValue.equals(measureUnitInfo))))
/*      */       {
/* 2392 */         int qtyScale = (getDetailTable().getColumn("consumeFixQty").getEditor() == null) ? 2 : ((KDFormattedTextField)getDetailTable().getCell(rowIndex, "consumeFixQty").getEditor().getComponent()).getPrecision();
/*      */
/*      */
/*      */
/*      */ 
/* 2397 */         qty = qty.setScale(10, 4);
/* 2398 */         BigDecimal newQtyFrom = SCMClientUtils.getBaseUnitQtyFromData(measureUnitInfo, curUnitOldValue, materialInfo, qty);
/*      */ 
/* 2400 */         if (newQtyFrom != null) {
/* 2401 */           newQtyFrom = newQtyFrom.setScale(qtyScale, 4);
/*      */ 
/* 2403 */           changeRow.getCell("consumeFixQty").setValue(newQtyFrom);
/*      */         }
/* 2405 */         this.uiHelper.calEntryBaseQty(rowIndex, 0);
/*      */       }
/*      */     } catch (Exception ex) {
/* 2408 */       handUIException(ex);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean beforeAction(BatchActionEnum bizAction, BatchSelectionEntries selectionEntries, ActionEvent event)
/*      */   {
/* 2427 */     boolean ret = super.beforeAction(bizAction, selectionEntries, event);
/*      */ 
/* 2429 */     if (BatchActionEnum.SAVE.equals(bizAction)) {
/* 2430 */       if ((this.cmbType.getSelectedItem().equals(BOMTypeEnum.CfgBOM)) || (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM)))
/*      */       {
/* 2432 */         int row = this.kdtEntrys.getRowCount();
/* 2433 */         this.editData.setCfgOption(ConfigOptionEnum.INDIRECT_OPTION);
/* 2434 */         this.cmbCfgOption.setSelectedItem(ConfigOptionEnum.INDIRECT_OPTION);
/*      */ 
/* 2436 */         for (int i = 0; i < row; ++i) {
/* 2437 */           String isConfig = this.kdtEntrys.getRow(i).getCell("feture").getValue().toString();
/*      */ 
/* 2439 */           String canSelected = this.kdtEntrys.getRow(i).getCell("canSelected").getValue().toString();
/*      */ 
/* 2441 */           if (("true".equals(isConfig)) || ("true".equals(canSelected))) {
/* 2442 */             this.cmbCfgOption.setSelectedItem(ConfigOptionEnum.DIRECT_OPTION);
/*      */ 
/* 2444 */             this.editData.setCfgOption(ConfigOptionEnum.DIRECT_OPTION);
/* 2445 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 2450 */       if (!(this.editData.isValueChange())) {
/* 2451 */         initOldData(this.editData);
/*      */       }
/*      */ 
/* 2454 */       this.isUpdate = true;
/* 2455 */     } else if (BatchActionEnum.SUBMIT.equals(bizAction)) {
/*      */       try {
/* 2457 */         fillBeforeSubmit();
/*      */       } catch (BOSException e) {
/* 2459 */         handUIException(e);
/*      */       }
/*      */ 
/* 2462 */       if ((this.cmbType.getSelectedItem().equals(BOMTypeEnum.CfgBOM)) || (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM)))
/*      */       {
/* 2464 */         int row = this.kdtEntrys.getRowCount();
/* 2465 */         this.editData.setCfgOption(ConfigOptionEnum.INDIRECT_OPTION);
/* 2466 */         this.cmbCfgOption.setSelectedItem(ConfigOptionEnum.INDIRECT_OPTION);
/*      */ 
/* 2468 */         Object obj = null;
/* 2469 */         String isConfig = null;
/* 2470 */         String canSelected = null;
/* 2471 */         for (int i = 0; i < row; ++i) {
/* 2472 */           obj = this.kdtEntrys.getRow(i).getCell("feture").getValue();
/* 2473 */           if (obj != null) {
/* 2474 */             isConfig = obj.toString();
/*      */           }
/* 2476 */           obj = this.kdtEntrys.getRow(i).getCell("canSelected").getValue();
/*      */ 
/* 2478 */           if (obj != null) {
/* 2479 */             canSelected = obj.toString();
/*      */           }
/* 2481 */           if (("true".equals(isConfig)) || ("true".equals(canSelected))) {
/* 2482 */             this.cmbCfgOption.setSelectedItem(ConfigOptionEnum.DIRECT_OPTION);
/*      */ 
/* 2484 */             this.editData.setCfgOption(ConfigOptionEnum.DIRECT_OPTION);
/* 2485 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 2490 */       if (BillBaseStatusEnum.AUDITED.equals(this.editData.getBaseStatus()))
/* 2491 */         this.actionCancel.setEnabled(true);
/* 2492 */       else if (BillBaseStatusEnum.ADD.equals(this.editData.getBaseStatus())) {
/* 2493 */         this.isAddNew = true;
/*      */       }
/*      */ 
/* 2496 */       getMainContext().put("MODIFY", new Boolean(false));
/*      */
/*      */ 
/* 2499 */       if ((this.chkMenuItemSubmitAndAddNew.isSelected()) && (this.chkMenuItemSubmitAndAddNew.isVisible()) && (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM)))
/*      */
/*      */       {
/* 2502 */         this.prmtProject.setValue(null);
/* 2503 */         this.prmtTrack.setValue(null);
/*      */       }
/*      */ 
/* 2506 */       if (!(this.editData.isValueChange())) {
/* 2507 */         initOldData(this.editData);
/*      */       }
/*      */ 
/* 2510 */       this.isUpdate = true;
/* 2511 */     } else if (!(BatchActionEnum.AUDIT.equals(bizAction)));
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/* 2531 */     return ret;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void afterAction(BatchActionEnum bizAction, BatchSelectionEntries selectionEntries, int countSuccess)
/*      */   {
/* 2549 */     super.afterAction(bizAction, selectionEntries, countSuccess);
/* 2550 */     if (countSuccess > 0) {
/* 2551 */       this.actionCopyLine.setEnabled(this.actionAddLine.isEnabled());
/*      */ 
/* 2553 */       if (BatchActionEnum.AUDIT.equals(bizAction))
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */       {
/*      */         return;
/*      */       }
/*      */ 
/* 2567 */       if (!(BatchActionEnum.UNAUDIT.equals(bizAction)))
/*      */       {
/*      */         return;
/*      */       }
/*      */ 
/* 2572 */       BillBaseStatusEnum status = (BillBaseStatusEnum)this.cmbBillStatus.getSelectedItem();
/*      */ 
/* 2574 */       if (status.equals(BillBaseStatusEnum.AUDITED))
/* 2575 */         this.btnCancel.setEnabled(true);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */   public void actionAddNew_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2583 */     if (e != null) {
/* 2584 */       this.isAddOrderBom = true;
/*      */     }
/*      */ 
/* 2587 */     this.hasOrderBomFormCfgBom = false;
/* 2588 */     this.txtSourceCfgBom.setText(null);
/* 2589 */     this.editData.setSourceCfgBomId(null);
/* 2590 */     this.editData.setSourceCfgBomNumber(null);
/* 2591 */     if (this.editData.getBomType().equals(BOMTypeEnum.CfgBOM)) {
/* 2592 */       setButtonAndFieldsEnabled(true);
/*      */     }
/*      */ 
/* 2595 */     this.isAddNew = true;
/* 2596 */     super.actionAddNew_actionPerformed(e);
/* 2597 */     this.prmtProject.setValue(null);
/* 2598 */     this.prmtTrack.setValue(null);
/* 2599 */     String strParam = (String)getUIContext().get("UIClassParam");
/* 2600 */     if ((strParam != null) && 
/* 2601 */       (strParam.equals("1")) && (this.isAddOrderBom)) {
/* 2602 */       this.cmbType.setSelectedItem(BOMTypeEnum.OrderBOM);
/*      */ 
/* 2604 */       setBomTypeStatus(false);
/*      */
/*      */ 
/* 2607 */       this.kDLabelContainer14.setVisible(true);
/* 2608 */       this.cmbCfgOption.setVisible(true);
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 2614 */     if (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM)) {
/* 2615 */       this.kDLabelContainer14.setVisible(true);
/* 2616 */       this.cmbCfgOption.setVisible(true);
/*      */
/*      */
/*      */     }
/*      */ 
/* 2621 */     this.cmbUsage.setEnabled(true);
/* 2622 */     this.cmbUsage.setAccessAuthority(0);
/*      */ 
/* 2624 */     setF7Enabled(this.prmtProject, true);
/* 2625 */     this.prmtTrack.setAccessAuthority(0);
/* 2626 */     this.prmtmaterial.setAccessAuthority(0);
/*      */ 
/* 2628 */     this.txtYield.setEditable(true);
/* 2629 */     this.txtproductQty.setEditable(true);
/* 2630 */     this.cmbUsage.setEnabled(true);
/* 2631 */     this.txtName.setAccessAuthority(0);
/* 2632 */     setBomTypeStatus(true);
/* 2633 */     initDialogFace();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionEdit_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2645 */     super.actionEdit_actionPerformed(e);
/* 2646 */     this.actionCopyLine.setEnabled(true);
/* 2647 */     BomInfo info1 = (BomInfo)this.dataBinder.getValueObject();
/* 2648 */     if (info1.isIsAssigned())
/*      */     {
/* 2650 */       String paraNumber = "mm_canModifuAssignedBom";
/* 2651 */       String strOrgRange = ParamHelper.getMatchType("0000", paraNumber);
/* 2652 */       boolean flag = Boolean.valueOf(strOrgRange).booleanValue();
/*      */ 
/* 2654 */       if (StringUtils.isEmpty(info1.getNumber())) {
/* 2655 */         String newNumber = "";
/* 2656 */         ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getRemoteInstance();
/*      */ 
/* 2658 */         if (iCodingRuleManager.isExist(this.editData, getMainOrgInfo().getId().toString()))
/*      */         {
/* 2660 */           newNumber = getNewNumber(getMainOrgInfo().getId().toString());
/*      */         }
/*      */ 
/* 2663 */         this.editData.setNumber(newNumber);
/* 2664 */         this.txtNumber.setText(this.editData.getNumber());
/*      */       }
/*      */ 
/* 2667 */       this.prmtstorageOrgUnit.setAccessAuthority(1);
/*      */ 
/* 2669 */       this.txtName.setAccessAuthority(1);
/*      */ 
/* 2671 */       setBomTypeStatus(false);
/* 2672 */       this.cmbUsage.setEnabled(false);
/* 2673 */       this.prmtmaterial.setAccessAuthority(1);
/*      */
/*      */
/*      */ 
/* 2677 */       this.txtYield.setEditable(false);
/* 2678 */       this.txtproductQty.setEditable(false);
/* 2679 */       setF7Enabled(this.prmtProject, false);
/* 2680 */       this.prmtTrack.setAccessAuthority(1);
/*      */
/*      */
/*      */ 
/* 2684 */       setTableFieldLockState(flag);
/*      */     } else {
/* 2686 */       this.txtYield.setEditable(true);
/* 2687 */       this.txtproductQty.setEditable(true);
/* 2688 */       this.cmbUsage.setEnabled(true);
/* 2689 */       setBomTypeStatus(true);
/* 2690 */       this.prmtTrack.setAccessAuthority(0);
/* 2691 */       this.prmtstorageOrgUnit.setAccessAuthority(0);
/*      */ 
/* 2693 */       this.prmtmaterial.setAccessAuthority(0);
/*      */ 
/* 2695 */       this.txtName.setAccessAuthority(0);
/*      */     }
/* 2697 */     showItems();
/*      */
/*      */     try
/*      */     {
/* 2701 */       checkToolButtonState();
/*      */     } catch (EASBizException e1) {
/* 2703 */       handUIException(e1);
/*      */     } catch (BOSException e1) {
/* 2705 */       handUIException(e1);
/*      */     }
/* 2707 */     initDialogFace();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionCopy_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2722 */     this.hasOrderBomFormCfgBom = false;
/*      */
/*      */
/*      */ 
/* 2726 */     if (this.editData.getBomType().equals(BOMTypeEnum.CfgBOM)) {
/* 2727 */       setButtonAndFieldsEnabled(true);
/*      */ 
/* 2729 */       this.cmbUsage.setEnabled(false);
/* 2730 */       this.cmbUsage.setAccessAuthority(1);
/*      */     }
/*      */     else {
/* 2733 */       this.cmbUsage.setEnabled(true);
/* 2734 */       this.cmbUsage.setAccessAuthority(0);
/*      */
/*      */     }
/*      */ 
/* 2738 */     Object obj = this.prmtProject.getValue();
/* 2739 */     if (obj != null) {
/* 2740 */       this.projectInfo = ((ProjectInfo)obj);
/*      */     }
/* 2742 */     if (this.kdtEntrys.getRowCount() > 0) {
/* 2743 */       this.trackMap = new HashMap();
/* 2744 */       if (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM)) {
/* 2745 */         obj = this.prmtTrack.getValue();
/* 2746 */         if (com.kingdee.eas.mm.common.client.MMUtils.isNotNull(obj)) {
/* 2747 */           this.trackMap = new HashMap();
/* 2748 */           this.trackMap.put("_bomCopy", obj);
/*      */         }
/* 2750 */       } else if ((this.cmbType.getSelectedItem().equals(BOMTypeEnum.CfgBOM)) && 
/*      */
/* 2752 */         (hasTrackNumber())) {
/* 2753 */         this.trackMap = new HashMap();
/* 2754 */         for (int i = 0; i < this.kdtEntrys.getRowCount(); ++i) {
/* 2755 */           obj = this.kdtEntrys.getCell(i, "trackNum").getValue();
/* 2756 */           this.trackMap.put(String.valueOf(i), obj);
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2762 */     super.actionCopy_actionPerformed(e);
/*      */
/*      */ 
/* 2765 */     this.editData.setSyncOldValue(false);
/* 2766 */     this.editData.setId(BOSUuid.create("8F409A89"));
/*      */ 
/* 2768 */     this.txtSourceCfgBom.setText(null);
/* 2769 */     this.editData.setSourceCfgBomId(null);
/* 2770 */     this.editData.setSourceCfgBomNumber(null);
/*      */ 
/* 2772 */     if (this.editData.isIsAssigned()) {
/* 2773 */       setNullWhenCopyBOM();
/* 2774 */       loadFields();
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 2780 */     this.prmtTrack.setAccessAuthority(0);
/* 2781 */     this.prmtmaterial.setAccessAuthority(0);
/*      */ 
/* 2783 */     this.isAddNew = true;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionRemove_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2794 */     this.isDel = true;
/*      */     try {
/* 2796 */       super.actionRemove_actionPerformed(e);
/*      */     }
/*      */     finally
/*      */     {
/* 2800 */       this.isDel = false;
/*      */
/*      */ 
/* 2803 */       if ("ADDNEW".equals(getOprtState())) {
/* 2804 */         actionAddNew_actionPerformed(e);
/*      */       }
/*      */ 
/* 2807 */       if (BillBaseStatusEnum.AUDITED.equals(this.editData.getBaseStatus()))
/* 2808 */         this.actionCancel.setEnabled(true);
/*      */       else
/* 2810 */         this.actionCancel.setEnabled(false);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */   public void actionCancel_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2818 */     String id = null;
/* 2819 */     if (this.editData.getId() == null) {
/* 2820 */       MsgBox.showError(SaleUtil.getUIResource("ORDER_ADDNEWCANNOT_OPERATOR"));
/*      */ 
/* 2822 */       return;
/*      */     }
/* 2824 */     id = this.editData.getId().toString();
/* 2825 */     boolean isSuccess = false;
/* 2826 */     String str = "";
/* 2827 */     String cancelMsg = getResource("res_93");
/*      */ 
/* 2829 */     if ((this.editData.getBomType().equals(BOMTypeEnum.MfgBOM)) && 
/* 2830 */       (!(MsgBox.isYes(MsgBox.showConfirm2(this, cancelMsg))))) {
/* 2831 */       return;
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 2836 */       pubFireVOChangeListener(id);
/*      */     } catch (EASBizException ex) {
/* 2838 */       handleException(ex);
/* 2839 */       return;
/*      */     } catch (Throwable t) {
/* 2841 */       handUIException(t);
/* 2842 */       return;
/*      */     }
/*      */     try
/*      */     {
/* 2846 */       str = BOMAssignFacadeFactory.getRemoteInstance().cancel(new String[] { id });
/*      */ 
/* 2848 */       if (str.trim().length() == 0)
/* 2849 */         isSuccess = true;
/*      */     }
/*      */     catch (EASBizException t) {
/* 2852 */       handleException(t);
/*      */     } catch (Throwable t) {
/* 2854 */       handUIException(t);
/*      */     }
/*      */     finally {
/*      */       try {
/* 2858 */         pubFireVOChangeListener(id);
/*      */       } catch (Throwable t) {
/* 2860 */         handUIException(t);
/*      */       }
/*      */     }
/*      */ 
/* 2864 */     if (isSuccess) {
/* 2865 */       showSuccessMsg(getResource("res_94"));
/* 2866 */       setOprtState(OprtState.VIEW);
/* 2867 */       refreshCurPage();
/*      */     } else {
/* 2869 */       MsgBox.showError(str);
/*      */     }
/*      */   }
/*      */
/*      */   public void actionCancelCancel_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2876 */     String id = null;
/* 2877 */     if (this.editData.getId() == null) {
/* 2878 */       MsgBox.showError(SaleUtil.getUIResource("ORDER_ADDNEWCANNOT_OPERATOR"));
/*      */ 
/* 2880 */       return;
/*      */     }
/* 2882 */     id = this.editData.getId().toString();
/* 2883 */     boolean isSuccess = false;
/* 2884 */     String str = "";
/*      */     try
/*      */     {
/* 2887 */       pubFireVOChangeListener(id);
/*      */     } catch (EASBizException ex) {
/* 2889 */       handleException(ex);
/* 2890 */       return;
/*      */     } catch (Throwable t) {
/* 2892 */       handUIException(t);
/* 2893 */       return;
/*      */     }
/*      */     try
/*      */     {
/* 2897 */       str = BOMAssignFacadeFactory.getRemoteInstance().cancelcancel(new String[] { id });
/*      */ 
/* 2899 */       if (str.trim().length() == 0)
/* 2900 */         isSuccess = true;
/*      */     }
/*      */     catch (EASBizException t) {
/* 2903 */       handleException(t);
/*      */     } catch (Throwable t) {
/* 2905 */       handUIException(t);
/*      */     }
/*      */     finally {
/*      */       try {
/* 2909 */         pubFireVOChangeListener(id);
/*      */       } catch (Throwable t) {
/* 2911 */         handUIException(t);
/*      */       }
/*      */     }
/*      */ 
/* 2915 */     if (isSuccess)
/*      */
/*      */
/*      */     {
/* 2919 */       showSuccessMsg(getResource("res_95"));
/* 2920 */       setOprtState(OprtState.VIEW);
/* 2921 */       refreshCurPage();
/*      */     } else {
/* 2923 */       MsgBox.showError(str);
/*      */     }
/*      */   }
/*      */
/*      */   public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
/*      */   {
/* 2929 */     KDTSelectManager selectManager = this.kdtEntrys.getSelectManager();
/* 2930 */     int size = selectManager.size();
/* 2931 */     KDTSelectBlock selectBlock = null;
/* 2932 */     Set indexSet = new HashSet();
/* 2933 */     for (int blockIndex = 0; blockIndex < size; ++blockIndex) {
/* 2934 */       selectBlock = selectManager.get(blockIndex);
/* 2935 */       int top = selectBlock.getBeginRow();
/* 2936 */       int bottom = selectBlock.getEndRow();
/* 2937 */       if (this.kdtEntrys.getRow(top) == null) {
/* 2938 */         MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
/*      */
/*      */
/*      */ 
/* 2942 */         return;
/*      */       }
/* 2944 */       for (int i = top; i <= bottom; ++i) {
/* 2945 */         indexSet.add(new Integer(i));
/*      */       }
/*      */     }
/* 2948 */     Integer[] indexArr = new Integer[indexSet.size()];
/* 2949 */     Object[] indexObj = indexSet.toArray();
/* 2950 */     System.arraycopy(indexObj, 0, indexArr, 0, indexArr.length);
/* 2951 */     Arrays.sort(indexArr);
/* 2952 */     List excludeRow = new ArrayList();
/* 2953 */     for (int i = indexArr.length - 1; i >= 0; --i) {
/* 2954 */       int rowIndex = Integer.parseInt(String.valueOf(indexArr[i]));
/* 2955 */       Boolean assign = (Boolean)this.kdtEntrys.getRow(rowIndex).getCell("isAssigned").getValue();
/*      */ 
/* 2957 */       if (Boolean.TRUE.equals(assign)) {
/* 2958 */         excludeRow.add(new Integer(indexArr[i].intValue() + 1));
/*      */       }
/*      */     }
/* 2961 */     if (0 == excludeRow.size()) {
/* 2962 */       super.actionRemoveLine_actionPerformed(e);
/*      */     } else {
/* 2964 */       Collections.sort(excludeRow);
/* 2965 */       MsgBox.showWarning(getResource("res_96", new String[] { excludeRow.toString() }));
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionCopyLine_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 2976 */     IRow selectedRow = KDTableUtil.getSelectedRow(this.kdtEntrys);
/* 2977 */     if (null == selectedRow) {
/* 2978 */       MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneRow"));
/*      */
/*      */
/*      */ 
/* 2982 */       return;
/*      */     }
/*      */ 
/* 2985 */     super.actionCopyLine_actionPerformed(e);
/*      */ 
/* 2987 */     int copyToRowIndex = KDTableUtil.getLastVisibleRowIndex(this.kdtEntrys);
/*      */ 
/* 2989 */     if (copyToRowIndex < 0) {
/* 2990 */       return;
/*      */     }
/* 2992 */     IRow copyToRow = this.kdtEntrys.getRow(copyToRowIndex);
/*      */ 
/* 2994 */     copyToRow.getCell("isAssigned").setValue(Boolean.FALSE);
/*      */ 
/* 2996 */     StorageOrgUnitInfo org = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 2998 */     MaterialInfo materialInfo = (MaterialInfo)copyToRow.getCell("materialNumber").getValue();
/*      */ 
/* 3000 */     if ((materialInfo != null) && (org != null)) {
/* 3001 */       SCMEntryDataVO voResult = UIHelper.getDataVO(org, new MaterialInfo[] { materialInfo });
/*      */ 
/* 3003 */       SCMClientUtils.changeTableColPrecision(voResult.getMmuPrecisions(), materialInfo, voResult.getMeasureUnitInfos()[0], this.kdtEntrys, this.QTYPRECISIONFROMUNITTAB, copyToRowIndex);
/*      */
/*      */ 
/* 3006 */       SCMClientUtils.changeTableColPrecision(voResult.getMmuPrecisions(), materialInfo, voResult.getBaseMeasureUnitInfos()[0], this.kdtEntrys, this.QTYPRECISIONFROMBASEUNITTAB, copyToRowIndex);
/*      */     }
/*      */   }
/*      */
/*      */   public void actionPrint_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3013 */     super.actionPrint_actionPerformed(e);
/*      */ 
/* 3015 */     invokePrintFunction(true);
/*      */   }
/*      */
/*      */   public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
/*      */   {
/* 3020 */     super.actionPrintPreview_actionPerformed(e);
/*      */ 
/* 3022 */     invokePrintFunction(false);
/*      */   }
/*      */
/*      */   public void actionAssign_actionPerformed(ActionEvent e) throws Exception
/*      */   {
/* 3027 */     checkIsModify();
/*      */
/*      */ 
/* 3030 */     BomTreeUI treeUI = (BomTreeUI)getIObserver();
/* 3031 */     KDTreeNode rootNode = (KDTreeNode)treeUI.kDTreeBOM.getModel().getRoot();
/*      */ 
/* 3033 */     if (rootNode.getChildCount() >= 0) {
/* 3034 */       List list = treeUI.getCheckedTreeNodes(rootNode);
/* 3035 */       if (!(list.isEmpty())) {
/* 3036 */         StorageOrgUnitInfo sourceSou = ((BomTreeInfo)list.get(0)).getStorageOrgUnitInfo();
/*      */
/*      */ 
/* 3039 */         list = getSelectedRootNodes(list, this.chkMenuItemBatchAssign.isSelected());
/*      */
/*      */
/*      */ 
/* 3043 */         UIContext uiContext = new UIContext(this.ui);
/* 3044 */         uiContext.put("sou", sourceSou);
/* 3045 */         uiContext.put("batchAssign", Boolean.valueOf(treeUI.isBatchAssign()));
/*      */ 
/* 3047 */         IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UIModelDialogFactory").create("com.kingdee.eas.mm.basedata.client.BomAssign4TreeOptionUI", uiContext, null, OprtState.ADDNEW);
/*      */
/*      */
/*      */ 
/* 3051 */         uiWindow.show();
/*      */ 
/* 3053 */         BomAssign4TreeOptionUI optionUI = (BomAssign4TreeOptionUI)uiWindow.getUIObject();
/*      */ 
/* 3055 */         if (!(optionUI.isCanceled())) {
/* 3056 */           Object[] objs = optionUI.getOptions();
/* 3057 */           boolean isSingleLevel = true;
/* 3058 */           boolean isAssignBySupplyOrg = true;
/* 3059 */           StorageOrgUnitInfo assignOrgUnit = null;
/* 3060 */           EntityViewInfo view = null;
/* 3061 */           if (objs[0].equals(String.valueOf(20)))
/*      */
/*      */           {
/* 3064 */             isSingleLevel = false;
/*      */           }
/* 3066 */           if (objs[1].equals("2"))
/*      */           {
/* 3068 */             isAssignBySupplyOrg = false;
/*      */           }
/* 3070 */           if (!(isAssignBySupplyOrg)) {
/* 3071 */             assignOrgUnit = (StorageOrgUnitInfo)objs[2];
/*      */           }
/* 3073 */           view = optionUI.getEntityViewInfoForSOU();
/*      */ 
/* 3075 */           String storageOrgUnitId = sourceSou.getId().toString();
/* 3076 */           BomTreeCondition condition = getBomTreeCondition(storageOrgUnitId, treeUI);
/*      */
/*      */
/*      */ 
/* 3080 */           BomCollection bs = BOMAssignFacadeFactory.getRemoteInstance().prepareData(list, sourceSou.getId().toString(), isSingleLevel, isAssignBySupplyOrg, assignOrgUnit, condition);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 3087 */           uiContext = new UIContext(this.ui);
/* 3088 */           uiContext.put("bomCollection", bs);
/* 3089 */           uiContext.put("souid", sourceSou.getId().toString());
/* 3090 */           uiContext.put("sou", sourceSou);
/* 3091 */           uiContext.put("view", view);
/*      */
/*      */ 
/* 3094 */           uiContext.put("bomTreeInfoList", list);
/* 3095 */           uiContext.put("bomTreeCondition", condition);
/* 3096 */           uiContext.put("sourceSou", sourceSou.getId().toString());
/* 3097 */           uiContext.put("isSingleLevel", Boolean.valueOf(isSingleLevel));
/*      */ 
/* 3099 */           uiContext.put("isAssignBySupplyOrg", Boolean.valueOf(isAssignBySupplyOrg));
/*      */ 
/* 3101 */           uiContext.put("assignOrgUnit", assignOrgUnit);
/* 3102 */           uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewTabFactory").create("com.kingdee.eas.mm.basedata.client.BomAssign4TreeUI", uiContext, null, OprtState.VIEW);
/*      */
/*      */
/*      */ 
/* 3106 */           if (null != uiWindow.getUIObject().getUIContext().get("open"))
/*      */           {
/* 3108 */             uiWindow.getUIObject().getUIContext().putAll(uiContext);
/* 3109 */             uiWindow.getUIObject().onLoad();
/*      */           }
/* 3111 */           uiWindow.show();
/*      */         }
/*      */       }
/*      */     }
/*      */     else {
/* 3116 */       MsgBox.showInfo(getResource(BOM_ASSIGN_RESOURCE, "ORDERBOM_Assign_Condition"));
/*      */     }
/*      */   }
/*      */
/*      */   public void actionAssignLog_actionPerformed(ActionEvent e) throws Exception
/*      */   {
/* 3122 */     Set pkSet = new HashSet();
/* 3123 */     pkSet.add(this.editData.getId().toString());
/* 3124 */     super.actionAssignLog_actionPerformed(e);
/* 3125 */     UIContext uiContext = new UIContext(this);
/* 3126 */     uiContext.put("bomIDs", pkSet);
/* 3127 */     uiContext.put("ID", null);
/* 3128 */     uiContext.put("orderBomTitle", getResource(BOM_ASSIGN_RESOURCE, "ORDERBOM_ASSIGNLOG"));
/*      */ 
/* 3130 */     IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UIModelDialogFactory").create("com.kingdee.eas.mm.basedata.client.BOMAssignLogUI", uiContext, null, OprtState.VIEW);
/*      */
/*      */ 
/* 3133 */     uiWindow.show();
/*      */   }
/*      */
/*      */   public void actionAssignLook_actionPerformed(ActionEvent e) throws Exception
/*      */   {
/* 3138 */     String bomId = (null == this.editData.getId()) ? null : this.editData.getId().toString();
/*      */ 
/* 3140 */     if (null == bomId) {
/* 3141 */       return;
/*      */     }
/* 3143 */     UIContext uiContext = new UIContext(this);
/* 3144 */     uiContext.put("ID", null);
/* 3145 */     uiContext.put("bomID", bomId);
/*      */ 
/* 3147 */     uiContext.put("orderBomTitle", getResource(BOM_ASSIGN_RESOURCE, "ORDERBOM_ASSIGNLOOK"));
/*      */ 
/* 3149 */     String uiPath = "com.kingdee.eas.mm.basedata.client.BOMAssignLookUI";
/* 3150 */     IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UIModelDialogFactory").create(uiPath, uiContext, null, OprtState.VIEW);
/*      */ 
/* 3152 */     uiWindow.show();
/*      */   }
/*      */
/*      */
/*      */
/*      */   public void actionPBom_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3160 */     if (this.editData.getBaseStatus().toString().equals(BillBaseStatusEnum.AUDITED.toString()))
/*      */     {
/* 3162 */       if ((this.editData.getBomType().equals(BOMTypeEnum.MfgBOM)) || (this.editData.getBomType().equals(BOMTypeEnum.OrderBOM)))
/*      */       {
/* 3164 */         if (this.editData.getUsageType().equals(BOMUsageEnum.Master)) {
/* 3165 */           this.editData.put("orderProject", this.prmtProject.getValue());
/* 3166 */           this.editData.put("orderTrack", this.prmtTrack.getValue());
/* 3167 */           PBOMEditUI.openPBOMByBom(this.editData, this); return;
/*      */         }
/* 3169 */         MsgBox.showInfo(getResource("not_master_bom"));
/* 3170 */         return;
/*      */       }
/*      */ 
/* 3173 */       MsgBox.showInfo(getResource("Bom_NOT_OrderAndMfg", new String[] { this.editData.getNumber() }));
/*      */ 
/* 3175 */       return;
/*      */     }
/*      */ 
/* 3178 */     MsgBox.showInfo(getResource("Bom_To_Audit"));
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionProjectChangeQuery_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3191 */     if (this.editData.getBaseStatus().equals(BillBaseStatusEnum.ADD)) {
/* 3192 */       MsgBox.showInfo(getResource("OrderBom_ProjectLook"));
/* 3193 */       return;
/*      */     }
/* 3195 */     IIDList billID = new RealModeIDList();
/* 3196 */     billID.add(this.editData.getId().toString());
/* 3197 */     if (billID == null) {
/* 3198 */       return;
/*      */     }
/* 3200 */     String projectPathString = "com.kingdee.eas.mm.basedata.client.ProjectChangeListUI";
/* 3201 */     Map map = new UIContext(this);
/* 3202 */     map.put("bomID", billID);
/*      */ 
/* 3204 */     IUIWindow uiWindow = null;
/* 3205 */     uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewFrameFactory").create(projectPathString, map, null, OprtState.VIEW);
/*      */
/*      */ 
/* 3208 */     uiWindow.show();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionBOMExtendSearch_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3225 */     BomInfo bomInfo = (BomInfo)getEditData();
/* 3226 */     Object obj = this.prmtProject.getValue();
/* 3227 */     if (obj != null) {
/* 3228 */       ProjectInfo pjInfo = (ProjectInfo)obj;
/* 3229 */       bomInfo.setProject(pjInfo);
/*      */     }
/* 3231 */     if (!(bomInfo.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))) {
/* 3232 */       MsgBox.showInfo(getResource("Bom_To_Audit"));
/* 3233 */       SysUtil.abort();
/*      */     }
/* 3235 */     StorageOrgUnitInfo orgInfo = (StorageOrgUnitInfo)getMainOrgInfo();
/*      */ 
/* 3237 */     BOMExtendSearchFilterCondition bomESFC = new BOMExtendSearchFilterCondition();
/* 3238 */     bomESFC.setBomInfo(bomInfo);
/* 3239 */     bomESFC.setOrgInfo(orgInfo);
/* 3240 */     bomESFC.setBomUsage(bomInfo.getUsageType());
/* 3241 */     UIContext uiContext = new UIContext(this);
/* 3242 */     uiContext.put("IsFromTree", Boolean.TRUE);
/*      */
/*      */
/*      */ 
/* 3246 */     if ((this.isOrderBomTree) || (this.editData.getBomType().equals(BOMTypeEnum.OrderBOM)))
/*      */
/*      */     {
/* 3249 */       if (this.prmtProject.getValue() != null) {
/* 3250 */         ProjectInfo projectInfo = (ProjectInfo)this.prmtProject.getValue();
/*      */ 
/* 3252 */         bomESFC.setProjectInfo(projectInfo);
/*      */       }
/* 3254 */       Object trackNumsObj = this.prmtTrack.getValue();
/* 3255 */       if (trackNumsObj != null) {
/* 3256 */         Object[] arrayTraceNum = (Object[])(Object[])trackNumsObj;
/* 3257 */         bomESFC.setTrackNumberInfo((TrackNumberInfo)arrayTraceNum[0]);
/*      */       }
/* 3259 */       uiContext.put("BOMExtendSearchFilterCondition", bomESFC);
/* 3260 */       uiContext.put("UIClassParam", "1");
/*      */
/*      */ 
/* 3263 */       this.orderBomExtendSearchUI = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewTabFactory").create(OrderBomExtendSearchListUI.class.getName(), uiContext, null, OprtState.VIEW);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 3270 */       if (!(bomESFC.equals(this.orderBomExtendSearchUI.getUIObject().getUIContext().get("BOMExtendSearchFilterCondition"))))
/*      */
/*      */       {
/* 3273 */         this.orderBomExtendSearchUI.getUIObject().getUIContext().remove("BOMExtendSearchFilterCondition");
/*      */
/*      */ 
/* 3276 */         this.orderBomExtendSearchUI.getUIObject().getUIContext().put("BOMExtendSearchFilterCondition", bomESFC);
/*      */ 
/* 3278 */         this.orderBomExtendSearchUI.getUIObject().getUIContext().remove("IsFromTree");
/*      */ 
/* 3280 */         this.orderBomExtendSearchUI.getUIObject().getUIContext().put("IsFromTree", Boolean.TRUE);
/*      */
/*      */ 
/* 3283 */         ((OrderBomExtendSearchListUI)this.orderBomExtendSearchUI.getUIObject()).showQueryDialog();
/*      */
/*      */       }
/*      */ 
/* 3287 */       this.orderBomExtendSearchUI.show();
/*      */     } else {
/* 3289 */       uiContext.put("BOMExtendSearchFilterCondition", bomESFC);
/*      */
/*      */ 
/* 3292 */       this.bomExtendSearchUI = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewTabFactory").create(BomExtendSearchListUI.class.getName(), uiContext, null, OprtState.VIEW);
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 3298 */       if (!(bomESFC.equals(this.bomExtendSearchUI.getUIObject().getUIContext().get("BOMExtendSearchFilterCondition"))))
/*      */
/*      */       {
/* 3301 */         this.bomExtendSearchUI.getUIObject().getUIContext().remove("BOMExtendSearchFilterCondition");
/*      */
/*      */ 
/* 3304 */         this.bomExtendSearchUI.getUIObject().getUIContext().put("BOMExtendSearchFilterCondition", bomESFC);
/*      */ 
/* 3306 */         this.bomExtendSearchUI.getUIObject().getUIContext().remove("IsFromTree");
/*      */ 
/* 3308 */         this.bomExtendSearchUI.getUIObject().getUIContext().put("IsFromTree", Boolean.TRUE);
/*      */
/*      */ 
/* 3311 */         ((BomExtendSearchListUI)this.bomExtendSearchUI.getUIObject()).showQueryDialog();
/*      */
/*      */       }
/*      */ 
/* 3315 */       this.bomExtendSearchUI.show();
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionBOMExtendBackSearch_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3332 */     BomInfo bomInfo = (BomInfo)getEditData();
/* 3333 */     Object obj = this.prmtProject.getValue();
/* 3334 */     if (obj != null) {
/* 3335 */       ProjectInfo pjInfo = (ProjectInfo)obj;
/* 3336 */       bomInfo.setProject(pjInfo);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 3346 */     StorageOrgUnitInfo orgInfo = (StorageOrgUnitInfo)getMainOrgInfo();
/*      */ 
/* 3348 */     BOMExtendSearchFilterCondition bomESFC = new BOMExtendSearchFilterCondition();
/* 3349 */     bomESFC.setBomInfo(bomInfo);
/* 3350 */     bomESFC.setOrgInfo(orgInfo);
/* 3351 */     bomESFC.setBomUsage(bomInfo.getUsageType());
/* 3352 */     UIContext uiContext = new UIContext(this);
/* 3353 */     uiContext.put("IsFromTree", Boolean.TRUE);
/*      */
/*      */
/*      */ 
/* 3357 */     if ((this.isOrderBomTree) || (this.editData.getBomType().equals(BOMTypeEnum.OrderBOM)))
/*      */
/*      */     {
/* 3360 */       if (this.prmtProject.getValue() != null) {
/* 3361 */         ProjectInfo projectInfo = (ProjectInfo)this.prmtProject.getValue();
/*      */ 
/* 3363 */         bomESFC.setProjectInfo(projectInfo);
/*      */       }
/* 3365 */       Object trackNumsObj = this.prmtTrack.getValue();
/* 3366 */       if (trackNumsObj != null) {
/* 3367 */         Object[] arrayTraceNum = (Object[])(Object[])trackNumsObj;
/* 3368 */         bomESFC.setTrackNumberInfo((TrackNumberInfo)arrayTraceNum[0]);
/*      */       }
/* 3370 */       uiContext.put("BOMExtendSearchFilterCondition", bomESFC);
/* 3371 */       uiContext.put("UIClassParam", "1");
/*      */
/*      */ 
/* 3374 */       this.orderBomExtendBackSearchUI = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewTabFactory").create(OrderBomExtendSearchBackListUI.class.getName(), uiContext, null, OprtState.VIEW);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 3381 */       if (!(bomESFC.equals(this.orderBomExtendBackSearchUI.getUIObject().getUIContext().get("BOMExtendSearchFilterCondition"))))
/*      */
/*      */       {
/* 3384 */         this.orderBomExtendBackSearchUI.getUIObject().getUIContext().remove("BOMExtendSearchFilterCondition");
/*      */
/*      */ 
/* 3387 */         this.orderBomExtendBackSearchUI.getUIObject().getUIContext().put("BOMExtendSearchFilterCondition", bomESFC);
/*      */ 
/* 3389 */         this.orderBomExtendBackSearchUI.getUIObject().getUIContext().remove("IsFromTree");
/*      */ 
/* 3391 */         this.orderBomExtendBackSearchUI.getUIObject().getUIContext().put("IsFromTree", Boolean.TRUE);
/*      */
/*      */ 
/* 3394 */         ((OrderBomExtendSearchBackListUI)this.orderBomExtendBackSearchUI.getUIObject()).showQueryDialog();
/*      */
/*      */       }
/*      */ 
/* 3398 */       this.orderBomExtendBackSearchUI.show();
/*      */     } else {
/* 3400 */       uiContext.put("BOMExtendSearchFilterCondition", bomESFC);
/*      */
/*      */ 
/* 3403 */       this.bomExtendBackSearchUI = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewTabFactory").create(BomExtendSearchBackListUI.class.getName(), uiContext, null, OprtState.VIEW);
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 3410 */       if (!(bomESFC.equals(this.bomExtendBackSearchUI.getUIObject().getUIContext().get("BOMExtendSearchFilterCondition"))))
/*      */
/*      */       {
/* 3413 */         this.bomExtendBackSearchUI.getUIObject().getUIContext().remove("BOMExtendSearchFilterCondition");
/*      */
/*      */ 
/* 3416 */         this.bomExtendBackSearchUI.getUIObject().getUIContext().put("BOMExtendSearchFilterCondition", bomESFC);
/*      */ 
/* 3418 */         this.bomExtendBackSearchUI.getUIObject().getUIContext().remove("IsFromTree");
/*      */ 
/* 3420 */         this.bomExtendBackSearchUI.getUIObject().getUIContext().put("IsFromTree", Boolean.TRUE);
/*      */
/*      */ 
/* 3423 */         ((BomExtendSearchBackListUI)this.bomExtendBackSearchUI.getUIObject()).showQueryDialog();
/*      */
/*      */       }
/*      */ 
/* 3427 */       this.bomExtendBackSearchUI.show();
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */   public void actionExitCurrent_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3436 */     if (this.isFromTree)
/* 3437 */       this.iObserver.actionExitCurrent(e);
/*      */     else
/* 3439 */       super.actionExitCurrent_actionPerformed(e);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionViewTrackNumber_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3451 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/*      */ 
/* 3453 */     BillBaseStatusEnum status = this.editData.getBaseStatus();
/* 3454 */     if (status.equals(BillBaseStatusEnum.ADD)) {
/* 3455 */       MsgBox.showInfo(this, getResource("BOM_ISNEW"));
/* 3456 */       return;
/*      */     }
/* 3458 */     if (this.editData.getId() == null) {
/* 3459 */       MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.mm.basedata.BasedataResource", "BOM_ISNULL"));
/*      */
/*      */ 
/* 3462 */       return;
/*      */     }
/*      */ 
/* 3465 */     Map uiContext = null;
/* 3466 */     if (this.iObserver != null)
/* 3467 */       uiContext = ((BomTreeUI)this.iObserver).getUIContext();
/*      */     else {
/* 3469 */       uiContext = getUIContext();
/*      */     }
/*      */ 
/* 3472 */     if (bomType.equals(BOMTypeEnum.CfgBOM)) {
/* 3473 */       if (this.kdtEntrys.getSelectManager().size() == 0) {
/* 3474 */         MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
/*      */
/*      */
/*      */ 
/* 3478 */         return;
/*      */       }
/* 3480 */       List list = this.kdtEntrys.getSelectManager().getBlocks();
/* 3481 */       if ((list == null) || (list.size() == 0)) {
/* 3482 */         MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
/*      */
/*      */
/*      */ 
/* 3486 */         return;
/*      */       }
/*      */ 
/* 3489 */       KDTSelectBlock block = (KDTSelectBlock)list.get(0);
/* 3490 */       int rowIndex = block.getTop();
/* 3491 */       if (rowIndex < 0) {
/* 3492 */         MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
/*      */
/*      */
/*      */ 
/* 3496 */         return;
/*      */       }
/* 3498 */       Object bomEntryId = this.kdtEntrys.getCell(rowIndex, "id").getValue();
/*      */ 
/* 3500 */       if (!(com.kingdee.eas.mm.common.client.MMUtils.isNull(bomEntryId))) {
/* 3501 */         UIHelper.openTrackNumberListUIforBomEntry(bomEntryId.toString(), uiContext);
/*      */       }
/*      */     }
/* 3504 */     else if (bomType.equals(BOMTypeEnum.OrderBOM)) {
/* 3505 */       if (!(bomType.equals(BOMTypeEnum.OrderBOM))) {
/* 3506 */         MsgBox.showInfo(this, getResource("BOM_CONNOT_VIEW_TRACK"));
/* 3507 */         return;
/*      */       }
/* 3509 */       UIHelper.openTrackNumberListUIforBom(this.editData.getId().toString(), uiContext);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionPushDown_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3527 */     if (getOprtState().equals("ADDNEW")) {
/* 3528 */       MsgBox.showWarning(this, getResource("com.kingdee.eas.mm.basedata.BASEDATAAutoGenerateResource", "32_BomEditUI"));
/*      */ 
/* 3530 */       return;
/*      */     }
/* 3532 */     if ((this.kdtEntrys.getRowCount() == 0) || (this.kdtEntrys.getSelectManager().size() == 0))
/*      */     {
/* 3534 */       MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
/*      */
/*      */
/*      */ 
/* 3538 */       return;
/*      */     }
/* 3540 */     int[] selectRows = KDTableUtil.getSelectedRows(this.kdtEntrys);
/* 3541 */     int selectIndex = -1;
/* 3542 */     if (selectRows.length > 0) {
/* 3543 */       selectIndex = selectRows[0];
/*      */     }
/* 3545 */     IRow row = this.kdtEntrys.getRow(selectIndex);
/* 3546 */     ICell cell = row.getCell("materialNumber");
/* 3547 */     MaterialInfo mi = (MaterialInfo)cell.getValue();
/* 3548 */     if (null == mi)
/*      */     {
/* 3550 */       MsgBox.showInfo(this, getResource("pushdown.material.notnull"));
/* 3551 */       return;
/*      */     }
/*      */ 
/* 3554 */     MaterialPlanInfo materialPlan = getMaterialPlanInfo(mi);
/* 3555 */     ManufactureStrategyInfo strategyInfo = materialPlan.getManufactureStrategy();
/*      */ 
/* 3557 */     if ((strategyInfo == null) || (strategyInfo.getId() == null)) {
/* 3558 */       MsgBox.showInfo(this, getResource("pushdown.material.hasNot.strategy"));
/*      */ 
/* 3560 */       return;
/*      */     }
/* 3562 */     String strategyId = strategyInfo.getId().toString();
/* 3563 */     Object projectObj = null;
/* 3564 */     Object trackObj = null;
/*      */ 
/* 3566 */     if (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM))
/*      */     {
/* 3568 */       Set noOrderBomStrategyIdSet = ManufactureStrategyGroup.getNoOrderBomStrategyIdSet();
/*      */ 
/* 3570 */       if (noOrderBomStrategyIdSet.contains(strategyId))
/*      */       {
/* 3572 */         String strategyNumber = ManufactureStrategyGroup.getStrategyNumber(strategyId);
/*      */ 
/* 3574 */         MsgBox.showInfo(this, getResource("pushdown.material.hasWrong.strategy", new String[] { strategyNumber }));
/*      */
/*      */
/*      */ 
/* 3578 */         return;
/*      */       }
/* 3580 */       Set proTrackOrderBomSet = ManufactureStrategyGroup.getProjectTrackOrderBomStrategyIdSet();
/*      */ 
/* 3582 */       Set trackOrderBomSet = ManufactureStrategyGroup.getTrackOrderBomStrategyIdSet();
/*      */ 
/* 3584 */       if (proTrackOrderBomSet.contains(strategyId))
/*      */
/*      */       {
/* 3587 */         trackObj = this.prmtTrack.getValue();
/* 3588 */         projectObj = this.prmtProject.getValue();
/* 3589 */       } else if (trackOrderBomSet.contains(strategyId)) {
/* 3590 */         trackObj = this.prmtTrack.getValue();
/*      */       }
/*      */     }
/* 3593 */     PushDownVO vo = new PushDownVO();
/* 3594 */     vo.setMi(mi);
/* 3595 */     vo.setBomType((BOMTypeEnum)this.cmbType.getSelectedItem());
/* 3596 */     vo.setBomUsage((BOMUsageEnum)this.cmbUsage.getSelectedItem());
/* 3597 */     vo.setSoui((StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue());
/* 3598 */     super.actionAddNew_actionPerformed(null);
/* 3599 */     if (null != vo.getMi()) {
/* 3600 */       this.prmtmaterial.setValue(vo.getMi());
/*      */     }
/* 3602 */     if (null != vo.getBomType()) {
/* 3603 */       this.cmbType.setSelectedItem(vo.getBomType());
/*      */     }
/* 3605 */     if (null != vo.getBomUsage()) {
/* 3606 */       this.cmbUsage.setSelectedItem(vo.getBomUsage());
/*      */     }
/* 3608 */     if (null != vo.getSoui()) {
/* 3609 */       this.prmtstorageOrgUnit.setValue(vo.getSoui());
/*      */     }
/*      */ 
/* 3612 */     this.prmtProject.setValue(projectObj);
/* 3613 */     this.prmtTrack.setValue(trackObj);
/*      */
/*      */ 
/* 3616 */     vo.clear();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionReplaceMaterial_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3631 */     if ((this.kdtEntrys.getRowCount() == 0) || (this.kdtEntrys.getSelectManager().size() == 0))
/*      */     {
/* 3633 */       MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
/*      */
/*      */
/*      */ 
/* 3637 */       return;
/*      */     }
/*      */ 
/* 3640 */     int[] selectRows = KDTableUtil.getSelectedRows(this.kdtEntrys);
/* 3641 */     int selectIndex = -1;
/* 3642 */     if (selectRows.length > 0) {
/* 3643 */       selectIndex = selectRows[0];
/*      */     }
/* 3645 */     IRow row = this.kdtEntrys.getRow(selectIndex);
/* 3646 */     ICell cell = row.getCell("materialNumber");
/* 3647 */     MaterialInfo mi = (MaterialInfo)cell.getValue();
/* 3648 */     if (mi == null) {
/* 3649 */       MsgBox.showWarning(this, getResource("replacematerial.material.notnull"));
/*      */ 
/* 3651 */       return;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 3660 */     if (BillBaseStatusEnum.ADD.equals(this.editData.getBaseStatus())) {
/* 3661 */       MsgBox.showWarning(this, getResource("com.kingdee.eas.mm.basedata.BASEDATAAutoGenerateResource", "32_BomEditUI"));
/*      */ 
/* 3663 */       return;
/*      */     }
/* 3665 */     IMaterialReplace imr = MaterialReplaceFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
/*      */ 
/* 3667 */     String mrId = imr.getMRIDbyBOMIDAndMaterialID(this.editData.getId().toString(), mi.getId().toString(), ((StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue()).getId().toString());
/*      */
/*      */
/*      */ 
/* 3671 */     UIContext uiContext = new UIContext(this);
/* 3672 */     if (StringUtils.isEmpty(mrId)) {
/* 3673 */       if (!(BillBaseStatusEnum.AUDITED.equals(this.editData.getBaseStatus()))) {
/* 3674 */         MsgBox.showInfo(getResource("bomIsNotAudit"));
/* 3675 */         return;
/*      */       }
/*      */ 
/* 3678 */       uiContext.put("ID", null);
/* 3679 */       IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewFrameFactory").create(MaterialReplaceEditUI.class.getName(), uiContext, null, OprtState.ADDNEW);
/*      */
/*      */
/*      */ 
/* 3683 */       MaterialReplaceEditUI mrEditUI = (MaterialReplaceEditUI)uiWindow.getUIObject();
/*      */ 
/* 3685 */       mrEditUI.rdoAppointBom.setSelected(true);
/*      */
/*      */ 
/* 3688 */       Object storage = this.prmtstorageOrgUnit.getValue();
/* 3689 */       mrEditUI.prmtstorageOrgUnit.setValue(storage);
/*      */ 
/* 3691 */       mrEditUI.prmtmaterial.setValue(mi);
/* 3692 */       mrEditUI.txtmaterialName.setText(mi.getName(getLocale()));
/* 3693 */       mrEditUI.txtmaterialModel.setText(mi.getModel());
/* 3694 */       mrEditUI.prmtmeasureUnit.setValue(row.getCell("unit").getValue());
/* 3695 */       MaterialInfo material = null;
/*      */ 
/* 3697 */       mrEditUI.kdtBomEntry.getRow(0).getCell("storageOrg").setValue(storage);
/*      */
/*      */
/*      */ 
/* 3701 */       mrEditUI.kdtBomEntry.getRow(0).getCell("bomId").setValue(this.editData);
/* 3702 */       mrEditUI.kdtBomEntry.getRow(0).getCell("bomName").setValue(this.editData.getName(getLocale()));
/*      */ 
/* 3704 */       material = this.editData.getMaterial();
/*      */ 
/* 3706 */       mrEditUI.kdtBomEntry.getRow(0).getCell("parentMaterialId").setValue(material.getNumber());
/*      */ 
/* 3708 */       mrEditUI.kdtBomEntry.getRow(0).getCell("parentMaterialName").setValue(material.getName(getLocale()));
/*      */ 
/* 3710 */       mrEditUI.kdtBomEntry.getRow(0).getCell("parentMaterialModel").setValue(material.getModel());
/*      */ 
/* 3712 */       MeasureUnitInfo unit = this.editData.getUnit();
/* 3713 */       if (unit != null) {
/* 3714 */         mrEditUI.kdtBomEntry.getRow(0).getCell("parentMaterialUnit").setValue(unit.getName());
/*      */       }
/*      */ 
/* 3717 */       mrEditUI.kdtBomEntry.getRow(0).getCell("parentQty").setValue(this.editData.getProductQty());
/*      */ 
/* 3719 */       mrEditUI.kdtBomEntry.getRow(0).getCell("yield").setValue(this.editData.getYield());
/*      */
/*      */ 
/* 3722 */       uiWindow.show();
/*      */     }
/*      */     else {
/* 3725 */       uiContext.put("ID", mrId);
/* 3726 */       IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewFrameFactory").create(MaterialReplaceEditUI.class.getName(), uiContext, null, OprtState.VIEW);
/*      */
/*      */
/*      */ 
/* 3730 */       uiWindow.show();
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionBatchSubmit_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3741 */     checkIsModify();
/* 3742 */     if (!(hasPermission("mm_bom_batchSubmit"))) {
/* 3743 */       MsgBox.showInfo(getResource("no_batchSubmit_permission"));
/* 3744 */       return;
/*      */     }
/* 3746 */     BomTreeUI treeUI = (BomTreeUI)getIObserver();
/* 3747 */     KDTreeNode rootNode = (KDTreeNode)treeUI.kDTreeBOM.getModel().getRoot();
/*      */
/*      */ 
/* 3750 */     if (rootNode.getChildCount() <= 0)
/*      */       return;
/* 3752 */     List list = treeUI.getCheckedTreeNodes(rootNode);
/*      */ 
/* 3754 */     if (list.isEmpty()) {
/* 3755 */       MsgBox.showInfo(getResource("not_select_treenode"));
/* 3756 */       SysUtil.abort();
/*      */     }
/*      */ 
/* 3759 */     IBomTreeBatchProcessFacade facade = BomTreeBatchProcessFacadeFactory.getRemoteInstance();
/*      */ 
/* 3761 */     StorageOrgUnitInfo storageOrgUnit = ((BomTreeInfo)list.get(0)).getStorageOrgUnitInfo();
/*      */
/*      */ 
/* 3764 */     String storageOrgUnitId = storageOrgUnit.getId().toString();
/* 3765 */     BomTreeCondition condition = getBomTreeCondition(storageOrgUnitId, treeUI);
/*      */
/*      */ 
/* 3768 */     list = getSelectedRootNodes(list, this.chkMenuItemBatchSubmit.isSelected());
/*      */ 
/* 3770 */     Map map = facade.batchSubmitBom(list, this.chkMenuItemBatchSubmit.isSelected(), condition);
/*      */
/*      */ 
/* 3773 */     if (map == null) {
/* 3774 */       MsgBox.showInfo(getResource("no_matched_bom"));
/*      */     }
/*      */     else {
/* 3777 */       int totalNum = Integer.parseInt(map.get("totalNum").toString());
/*      */ 
/* 3779 */       List errorList = (List)map.get("failDetailInfo");
/* 3780 */       int successNum = 0;
/* 3781 */       int failNum = 0;
/* 3782 */       if ((errorList != null) && (errorList.size() > 0)) {
/* 3783 */         failNum = errorList.size();
/*      */       }
/*      */ 
/* 3786 */       successNum = totalNum - failNum;
/* 3787 */       StringBuffer buff = new StringBuffer();
/*      */ 
/* 3789 */       buff.append(getResource("success")).append(getResource("submit"));
/*      */ 
/* 3791 */       buff.append(successNum).append(getResource("numberUnit"));
/* 3792 */       buff.append(getResource("fail")).append(failNum).append(getResource("numberUnit"));
/*      */ 
/* 3794 */       if (failNum == 0) {
/* 3795 */         MsgBox.showInfo(buff.toString());
/*      */       } else {
/* 3797 */         Object[] objs = null;
/* 3798 */         StringBuffer msg = new StringBuffer();
/*      */ 
/* 3800 */         for (int i = 0; i < errorList.size(); ++i) {
/* 3801 */           objs = (Object[])(Object[])errorList.get(i);
/*      */ 
/* 3803 */           msg.append(objs[1]).append(" £º ");
/*      */ 
/* 3805 */           msg.append(trimString(objs[2].toString())).append("\n");
/*      */         }
/* 3807 */         MsgBox.showDetailAndOK(this, buff.toString(), msg.toString(), 8188);
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionBatchAudit_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3821 */     checkIsModify();
/* 3822 */     if (!(hasPermission("mm_bom_audit"))) {
/* 3823 */       MsgBox.showInfo(getResource("no_audit_permission"));
/* 3824 */       return;
/*      */     }
/* 3826 */     BomTreeUI treeUI = (BomTreeUI)getIObserver();
/* 3827 */     KDTreeNode rootNode = (KDTreeNode)treeUI.kDTreeBOM.getModel().getRoot();
/*      */ 
/* 3829 */     if (rootNode.getChildCount() > 0) {
/* 3830 */       List list = treeUI.getCheckedTreeNodes(rootNode);
/* 3831 */       if (list.isEmpty()) {
/* 3832 */         MsgBox.showInfo(getResource("not_select_treenode"));
/*      */       } else {
/* 3834 */         IBomTreeBatchProcessFacade facade = BomTreeBatchProcessFacadeFactory.getRemoteInstance();
/*      */ 
/* 3836 */         StorageOrgUnitInfo storageOrgUnit = ((BomTreeInfo)list.get(0)).getStorageOrgUnitInfo();
/*      */
/*      */ 
/* 3839 */         String storageOrgUnitId = storageOrgUnit.getId().toString();
/* 3840 */         BomTreeCondition condition = getBomTreeCondition(storageOrgUnitId, treeUI);
/*      */
/*      */ 
/* 3843 */         list = getSelectedRootNodes(list, this.chkMenuItemBatchAudit.isSelected());
/*      */ 
/* 3845 */         Map map = facade.batchAuditBom(list, this.chkMenuItemBatchAudit.isSelected(), condition);
/*      */ 
/* 3847 */         if (map == null) {
/* 3848 */           MsgBox.showInfo(getResource("no_matched_bom"));
/*      */         }
/*      */         else {
/* 3851 */           int totalNum = Integer.parseInt(map.get("totalNum").toString());
/*      */
/*      */ 
/* 3854 */           List errorList = (List)map.get("failDetailInfo");
/* 3855 */           int successNum = 0;
/* 3856 */           int failNum = 0;
/* 3857 */           if ((errorList != null) && (errorList.size() > 0)) {
/* 3858 */             failNum = errorList.size();
/*      */           }
/*      */ 
/* 3861 */           successNum = totalNum - failNum;
/* 3862 */           StringBuffer buff = new StringBuffer();
/*      */ 
/* 3864 */           buff.append(getResource("success")).append(getResource("audit"));
/*      */ 
/* 3866 */           buff.append(successNum).append(getResource("numberUnit"));
/* 3867 */           buff.append(getResource("fail")).append(failNum).append(getResource("numberUnit"));
/*      */ 
/* 3869 */           if (failNum == 0) {
/* 3870 */             MsgBox.showInfo(buff.toString());
/*      */           } else {
/* 3872 */             Object[] objs = null;
/* 3873 */             StringBuffer msg = new StringBuffer();
/*      */ 
/* 3875 */             for (int i = 0; i < errorList.size(); ++i) {
/* 3876 */               objs = (Object[])(Object[])errorList.get(i);
/*      */ 
/* 3878 */               msg.append(objs[1]).append(" £º ");
/*      */ 
/* 3880 */               msg.append(trimString(objs[2].toString())).append("\n");
/*      */             }
/*      */ 
/* 3883 */             MsgBox.showDetailAndOK(this, buff.toString(), msg.toString(), 8188);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionViewOption_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 3902 */     KDRadioButtonMenuItem selectedMenuItem = (KDRadioButtonMenuItem)e.getSource();
/*      */ 
/* 3904 */     if (selectedMenuItem.getName().equals("chkMenuItemQueryDate")) {
/* 3905 */       return;
/*      */     }
/* 3907 */     Set menuItemSet = new HashSet();
/* 3908 */     menuItemSet.add(this.chkMenuItemAllMaterial);
/* 3909 */     menuItemSet.add(this.chkMenuItemCurrentMaterial);
/* 3910 */     menuItemSet.add(this.chkMenuItemDisableMaterial);
/* 3911 */     menuItemSet.add(this.chkMenuItemWillMaterial);
/* 3912 */     Iterator it = menuItemSet.iterator();
/* 3913 */     KDRadioButtonMenuItem menuItem = null;
/* 3914 */     String value = null;
/* 3915 */     while (it.hasNext()) {
/* 3916 */       menuItem = (KDRadioButtonMenuItem)it.next();
/* 3917 */       value = Boolean.FALSE.toString();
/* 3918 */       if (menuItem.equals(selectedMenuItem)) {
/* 3919 */         value = Boolean.TRUE.toString();
/*      */       }
/* 3921 */       ConfigServiceUtils.saveUserConfigData(menuItem.getName() + getOptionKeySuffix(), this, value);
/*      */
/*      */     }
/*      */ 
/* 3925 */     filterSubMaterial();
/*      */ 
/* 3927 */     if ((getUIContext().get("isUICache") == null) || (!(getUIContext().get("isUICache").equals("true"))))
/*      */       return;
/* 3929 */     BomTreeUI treeUI = (BomTreeUI)getIObserver();
/* 3930 */     this.queryDate = null;
/* 3931 */     treeUI.setFromMenuItem(true);
/* 3932 */     treeUI.initTree();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean isPrepareInit()
/*      */   {
/* 3941 */     return true;
/*      */   }
/*      */
/*      */   public void prepareInit(RequestContext request) {
/* 3945 */     super.prepareInit(request);
/* 3946 */     OrgType orgType = OrgType.Storage;
/* 3947 */     ObjectUuidPK treePK = new ObjectUuidPK(NewOrgViewHelper.convert2TreeId(orgType));
/*      */ 
/* 3949 */     IObjectPK userPK = new ObjectUuidPK(BOSUuid.read(SysContext.getSysContext().getCurrentUserInfo().getId().toString()));
/*      */ 
/* 3951 */     IObjectPK ctrlPK = new ObjectUuidPK(BOSUuid.read(SysContext.getSysContext().getCurrentCtrlUnit().getId().toString()));
/*      */
/*      */ 
/* 3954 */     String str = getPermissionItem(getOprtState());
/*      */
/*      */
/*      */ 
/* 3958 */     request.put("BOMPERMITEM", str);
/* 3959 */     request.put("BOMDEALWITHORG_USERPK", userPK);
/* 3960 */     request.put("BOMDEALWITHORG_CTRLPK", ctrlPK);
/* 3961 */     request.put("BOMDEALWITHORG_TREEPK", treePK);
/* 3962 */     request.put("BOMDEALWITHORG_ORGTYPE", orgType);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean isPrepareActionEdit()
/*      */   {
/* 3980 */     return false;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionAddNew() {
/* 3984 */     return true;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionCreateTo() {
/* 3988 */     return true;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionFirst() {
/* 3992 */     return false;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionPre() {
/* 3996 */     return false;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionNext() {
/* 4000 */     return false;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionLast() {
/* 4004 */     return false;
/*      */   }
/*      */
/*      */   public RequestContext prepareActionPre(IItemAction itemAction) throws Exception
/*      */   {
/* 4009 */     RequestContext request = super.prepareActionPre(itemAction);
/* 4010 */     request.put("viewNav", "viewNav");
/* 4011 */     return request;
/*      */   }
/*      */
/*      */   public RequestContext prepareActionNext(IItemAction itemAction) throws Exception
/*      */   {
/* 4016 */     RequestContext request = super.prepareActionNext(itemAction);
/* 4017 */     request.put("viewNav", "viewNav");
/* 4018 */     return request;
/*      */   }
/*      */
/*      */   public RequestContext prepareActionLast(IItemAction itemAction) throws Exception
/*      */   {
/* 4023 */     RequestContext request = super.prepareActionLast(itemAction);
/* 4024 */     request.put("viewNav", "viewNav");
/* 4025 */     return request;
/*      */   }
/*      */
/*      */   public RequestContext prepareActionFirst(IItemAction itemAction) throws Exception
/*      */   {
/* 4030 */     RequestContext request = super.prepareActionFirst(itemAction);
/* 4031 */     request.put("viewNav", "viewNav");
/* 4032 */     return request;
/*      */   }
/*      */
/*      */   public RequestContext prepareActionEdit(IItemAction itemAction) throws Exception
/*      */   {
/* 4037 */     RequestContext request = super.prepareActionEdit(itemAction);
/* 4038 */     return request;
/*      */   }
/*      */
/*      */   public void fillBeforeSubmit()
/*      */     throws BOSException
/*      */   {
/* 4044 */     Set materialIdSet = new HashSet();
/* 4045 */     if (null != this.prmtmaterial.getValue()) {
/* 4046 */       materialIdSet.add(((MaterialInfo)this.prmtmaterial.getValue()).getId().toString());
/*      */     }
/*      */     else {
/* 4049 */       MsgBox.showWarning(this, getResource("fatherMaterial_Required"));
/* 4050 */       SysUtil.abort();
/*      */     }
/*      */ 
/* 4053 */     MaterialInfo cmi = null;
/* 4054 */     int k = 0; for (int entryCount = this.kdtEntrys.getRowCount(); k < entryCount; ++k)
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     {
/* 4061 */       cmi = (MaterialInfo)this.kdtEntrys.getCell(k, "materialNumber").getValue();
/* 4062 */       if (null == cmi) {
/*      */         continue;
/*      */       }
/* 4065 */       materialIdSet.add(cmi.getId().toString());
/*      */     }
/*      */ 
/* 4068 */     if ((materialIdSet.isEmpty()) || (null == (StorageOrgUnitInfo)getMainBizOrg().getData()))
/*      */       return;
/* 4070 */     IMultiMeasureUnit multiUnit = MultiMeasureUnitFactory.getRemoteInstance();
/*      */ 
/* 4072 */     EntityViewInfo view = new EntityViewInfo();
/* 4073 */     SelectorItemCollection sic = new SelectorItemCollection();
/*      */ 
/* 4075 */     sic.add(new SelectorItemInfo("measureUnit.id"));
/* 4076 */     sic.add(new SelectorItemInfo("material.id"));
/* 4077 */     view.setSelector(sic);
/* 4078 */     FilterInfo fi = new FilterInfo();
/* 4079 */     fi.getFilterItems().add(new FilterItemInfo("material.id", materialIdSet, CompareType.INCLUDE));
/*      */
/*      */ 
/* 4082 */     fi.getFilterItems().add(new FilterItemInfo("isBasicUnit", Boolean.TRUE, CompareType.EQUALS));
/*      */
/*      */ 
/* 4085 */     view.setFilter(fi);
/* 4086 */     MultiMeasureUnitCollection multiUnits = multiUnit.getMultiMeasureUnitCollection(view);
/*      */ 
/* 4088 */     Map map = new HashMap();
/* 4089 */     int j = 0; for (int count = multiUnits.size(); j < count; ++j) {
/* 4090 */       map.put(multiUnits.get(j).getMaterial().getId().toString(), multiUnits.get(j).getMeasureUnit());
/*      */     }
/*      */ 
/* 4093 */     if ((null != this.prmtmaterial.getValue()) && 
/* 4094 */       (map.containsKey(((MaterialInfo)this.prmtmaterial.getValue()).getId().toString())))
/*      */     {
/* 4096 */       this.prmtBaseUnit.setValue(map.get(((MaterialInfo)this.prmtmaterial.getValue()).getId().toString()));
/*      */
/*      */
/*      */     }
/*      */ 
/* 4101 */     j = 0; for (int entryCount = this.kdtEntrys.getRowCount(); j < entryCount; ++j) {
/* 4102 */       cmi = (MaterialInfo)this.kdtEntrys.getCell(j, "materialNumber").getValue();
/*      */ 
/* 4104 */       if ((null != cmi) && (map.containsKey(cmi.getId().toString())))
/* 4105 */         this.kdtEntrys.getCell(j, "baseUnit").setValue(map.get(cmi.getId().toString()));
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public IObjectValue getBOMInfoByID(IObjectPK bomID)
/*      */     throws Exception
/*      */   {
/* 4120 */     return getValue(bomID);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void loadBomInfoForTree(IObjectValue objValue, MaterialInfo material, BOMUsageEnum usageType, ProjectInfo project, TrackNumberCollection trackNumberColl, boolean isOrderBom)
/*      */     throws Exception
/*      */   {
/* 4137 */     if (!(this.isFromTree)) {
/* 4138 */       return;
/*      */     }
/* 4140 */     this.isAddOrderBom = isOrderBom;
/*      */
/*      */ 
/* 4143 */     this.btnFirst.setVisible(false);
/* 4144 */     this.btnPre.setVisible(false);
/* 4145 */     this.btnNext.setVisible(false);
/* 4146 */     this.btnLast.setVisible(false);
/* 4147 */     this.menuItemFirst.setVisible(false);
/* 4148 */     this.menuItemPre.setVisible(false);
/* 4149 */     this.menuItemNext.setVisible(false);
/* 4150 */     this.menuItemLast.setVisible(false);
/* 4151 */     this.chkMenuItemSubmitAndAddNew.setSelected(false);
/* 4152 */     this.chkMenuItemSubmitAndAddNew.setVisible(false);
/* 4153 */     this.menuSubmitOption.setVisible(false);
/*      */ 
/* 4155 */     if (getOprtState().equals("VIEW")) {
/* 4156 */       if (!(this.cmbUsage.isEnabled())) {
/* 4157 */         this.cmbUsage.setEnabled(true);
/*      */       }
/* 4159 */       setDataObject(objValue);
/* 4160 */       loadFields();
/* 4161 */       showMessageForStatus();
/*      */ 
/* 4163 */       resetFlag();
/*      */     } else {
/* 4165 */       addNewFromTree(material, usageType, project, trackNumberColl, isOrderBom);
/*      */     }
/*      */ 
/* 4168 */     initOldData(this.editData);
/*      */   }
/*      */
/*      */   public void resetFlag() {
/* 4172 */     this.isAddNew = false;
/* 4173 */     this.isUpdate = false;
/* 4174 */     this.isDel = false;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void setActionEnabled()
/*      */   {
/* 4184 */     if (this.editData == null) {
/* 4185 */       return;
/*      */     }
/* 4187 */     BillBaseStatusEnum status = this.editData.getBaseStatus();
/* 4188 */     if (status == null) {
/* 4189 */       this.actionRemove.setEnabled(false);
/* 4190 */       this.actionAudit.setEnabled(false);
/* 4191 */       this.actionUnAudit.setEnabled(false);
/* 4192 */       return;
/*      */     }
/*      */ 
/* 4195 */     if (status.equals(BillBaseStatusEnum.ADD))
/* 4196 */       this.actionRemove.setEnabled(false);
/*      */     else {
/* 4198 */       this.actionRemove.setEnabled(true);
/*      */     }
/*      */ 
/* 4201 */     if (status.equals(BillBaseStatusEnum.AUDITED))
/* 4202 */       this.actionUnAudit.setEnabled(true);
/*      */     else {
/* 4204 */       this.actionRemove.setEnabled(false);
/*      */     }
/*      */ 
/* 4207 */     if (status.equals(BillBaseStatusEnum.SUBMITED))
/* 4208 */       this.actionAudit.setEnabled(true);
/*      */     else
/* 4210 */       this.actionAudit.setEnabled(false);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   public ProjectInfo getProjectInfo()
/*      */   {
/* 4218 */     return ((this.prmtProject.getValue() != null) ? (ProjectInfo)this.prmtProject.getValue() : null);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */   public TrackNumberInfo getTrackNumberInfo()
/*      */   {
/* 4226 */     return ((this.prmtTrack.getValue() != null) ? (TrackNumberInfo)this.prmtTrack.getValue() : null);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public TrackNumberCollection getTrackNumberCollection()
/*      */   {
/* 4241 */     TrackNumberCollection rst = new TrackNumberCollection();
/* 4242 */     TrackNumberInfo[] tnis = getTrackNumberOfOrderBom();
/* 4243 */     if (com.kingdee.eas.mm.common.client.MMUtils.isNull(tnis)) {
/* 4244 */       return null;
/*      */     }
/* 4246 */     for (int i = 0; i < tnis.length; ++i) {
/* 4247 */       rst.add(tnis[i]);
/*      */     }
/*      */ 
/* 4250 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public TrackNumberInfo[] getTrackNumberOfOrderBom()
/*      */   {
/* 4264 */     Object trackNumObj = this.prmtTrack.getValue();
/* 4265 */     if (com.kingdee.eas.mm.common.client.MMUtils.isNull(trackNumObj)) {
/* 4266 */       return null;
/*      */     }
/* 4268 */     TrackNumberInfo[] tnis = null;
/* 4269 */     if (trackNumObj instanceof TrackNumberInfo) {
/* 4270 */       tnis = new TrackNumberInfo[] { (TrackNumberInfo)trackNumObj };
/* 4271 */     } else if (trackNumObj instanceof TrackNumberInfo[]) {
/* 4272 */       tnis = (TrackNumberInfo[])(TrackNumberInfo[])trackNumObj;
/* 4273 */     } else if (trackNumObj instanceof Object[]) {
/* 4274 */       Object[] objs = (Object[])(Object[])trackNumObj;
/* 4275 */       tnis = new TrackNumberInfo[objs.length];
/* 4276 */       System.arraycopy(objs, 0, tnis, 0, objs.length);
/*      */     }
/* 4278 */     return tnis;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public boolean isBatchAssign()
/*      */   {
/* 4290 */     return this.chkMenuItemBatchAssign.isSelected();
/*      */   }
/*      */
/*      */   public void setIObserver(IObserver observer) {
/* 4294 */     this.iObserver = observer;
/*      */   }
/*      */
/*      */   public IObserver getIObserver()
/*      */   {
/* 4299 */     return this.iObserver;
/*      */   }
/*      */
/*      */   public boolean isOrderBomTree() {
/* 4303 */     return this.isOrderBomTree;
/*      */   }
/*      */
/*      */   public void setOrderBomTree(boolean isOrderBomTree) {
/* 4307 */     this.isOrderBomTree = isOrderBomTree;
/*      */   }
/*      */
/*      */   public void setFromTree(boolean isFromTree) {
/* 4311 */     this.isFromTree = isFromTree;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public BomTreeCondition getBomTreeCondition(String storageOrgUnitId, BomTreeUI treeUI)
/*      */   {
/* 4327 */     BomTreeCondition condition = new BomTreeCondition();
/* 4328 */     FilterInfo filter = treeUI.getDefaultFilterForTree();
/* 4329 */     FilterItemCollection coll = filter.getFilterItems();
/* 4330 */     FilterItemInfo item = null;
/* 4331 */     String propertyName = null;
/*      */
/*      */ 
/* 4334 */     condition.setStorageOrgUnitID(storageOrgUnitId);
/* 4335 */     Object propertyValue = null;
/* 4336 */     for (int i = 0; i < coll.size(); ++i) {
/* 4337 */       item = coll.get(i);
/* 4338 */       propertyName = item.getPropertyName();
/* 4339 */       propertyValue = item.getCompareValue();
/*      */ 
/* 4341 */       if ("project.number".equalsIgnoreCase(propertyName))
/*      */       {
/* 4343 */         if (item.getCompareType().equals(CompareType.EQUALS)) {
/* 4344 */           condition.setProjectNumID(propertyValue.toString());
/*      */
/*      */         }
/* 4347 */         else if (item.getCompareType().equals(CompareType.INCLUDE)) {
/* 4348 */           condition.setProjectNumIDs(toSqlString((Set)propertyValue));
/*      */
/*      */ 
/* 4351 */           condition.setProjectIdSet((Set)propertyValue);
/*      */         }
/*      */ 
/*      */       }
/* 4355 */       else if ("trackNumber.number".equalsIgnoreCase(propertyName))
/*      */       {
/* 4357 */         if (item.getCompareType().equals(CompareType.GREATER_EQUALS)) {
/* 4358 */           condition.setTrackFromNumID(propertyValue.toString()); } else {
/* 4359 */           if (!(item.getCompareType().equals(CompareType.LESS_EQUALS)))
/*      */             continue;
/* 4361 */           condition.setTrackToNumID(propertyValue.toString());
/*      */         }
/*      */ 
/*      */       }
/* 4365 */       else if ("bomType".equalsIgnoreCase(propertyName))
/*      */
/*      */
/*      */
/*      */
/*      */       {
/* 4371 */         Integer bomTypeValue = new Integer(propertyValue.toString());
/* 4372 */         BOMTypeEnum bomType = BOMTypeEnum.getEnum(bomTypeValue.intValue());
/*      */ 
/* 4374 */         condition.setBomtype(bomType);
/*      */
/*      */       }
/* 4377 */       else if ("usageType".equalsIgnoreCase(propertyName)) {
/* 4378 */         Integer usageValue = new Integer(propertyValue.toString());
/* 4379 */         BOMUsageEnum usage = BOMUsageEnum.getEnum(usageValue.intValue());
/*      */ 
/* 4381 */         condition.setBomUsage(usage);
/*      */       }
/*      */     }
/* 4384 */     return condition;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionRefresh() {
/* 4388 */     return true;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionQuery() {
/* 4392 */     return true;
/*      */   }
/*      */
/*      */   public boolean isPrepareActionView() {
/* 4396 */     return true;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initEntryKeyListener()
/*      */   {
/* 4412 */     String state = getOprtState();
/* 4413 */     if ("VIEW".equals(state)) {
/* 4414 */       KDTableHelper.downArrowAutoAddRow(this.kdtEntrys, false, null);
/* 4415 */       KDTableHelper.updateEnterWithTab(this.kdtEntrys, false, null);
/* 4416 */       return;
/*      */     }
/* 4418 */     Action entryAction = new AbstractAction() {
/*      */       private static final long serialVersionUID = 1L;
/*      */ 
/*      */       public void actionPerformed(ActionEvent e) {
/* 4422 */         String state = BomEditUI.this.getOprtState();
/*      */ 
/* 4424 */         BomEditUI.this.kdtEntrys.removeRow(BomEditUI.this.kdtEntrys.getRowCount() - 1);
/*      */ 
/* 4426 */         if ((!(state.equals(OprtState.ADDNEW))) && (!(state.equals(OprtState.EDIT))))
/*      */           return;
/* 4428 */         BomEditUI.this.addLine(BomEditUI.this.kdtEntrys);
/*      */
/*      */       }
/*      */     };
/* 4432 */     boolean addNew = !(this.hasOrderBomFormCfgBom);
/* 4433 */     KDTableHelper.downArrowAutoAddRow(this.kdtEntrys, addNew, entryAction);
/* 4434 */     KDTableHelper.updateEnterWithTab(this.kdtEntrys, addNew, entryAction);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initEntrysMaterialF7s(MaterialPlanInfo planInfo)
/*      */   {
/* 4447 */     if (planInfo.isIsConfigable()) {
/* 4448 */       this.cmbCfgOption.setVisible(true);
/* 4449 */       this.kDLabelContainer14.setVisible(true);
/* 4450 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(false);
/*      */ 
/* 4452 */       this.kdtEntrys.getColumn("firstCfg").getStyleAttributes().setHided(false);
/*      */ 
/* 4454 */       this.kdtEntrys.getColumn("feture").getStyleAttributes().setHided(false);
/*      */     } else {
/* 4456 */       this.cmbCfgOption.setVisible(false);
/* 4457 */       this.kDLabelContainer14.setVisible(false);
/* 4458 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(true);
/*      */ 
/* 4460 */       this.kdtEntrys.getColumn("firstCfg").getStyleAttributes().setHided(true);
/*      */ 
/* 4462 */       this.kdtEntrys.getColumn("feture").getStyleAttributes().setHided(true);
/*      */     }
/* 4464 */     StorageOrgUnitInfo orgInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 4466 */     Component componet = this.kdtEntrys.getColumn("materialNumber").getEditor().getComponent();
/*      */
/*      */ 
/* 4469 */     KDBizPromptBox bizEntryMaterialBox = (KDBizPromptBox)componet;
/*      */ 
/* 4471 */     EntityViewInfo tmpView = new EntityViewInfo();
/* 4472 */     FilterInfo filter = new FilterInfo();
/* 4473 */     filter.getFilterItems().add(new FilterItemInfo("status", new Integer(1), CompareType.EQUALS));
/*      */
/*      */ 
/* 4476 */     filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", orgInfo.getId().toString(), CompareType.EQUALS));
/*      */
/*      */ 
/* 4479 */     filter.getFilterItems().add(new FilterItemInfo("Inventory.status", new Integer(1), CompareType.EQUALS));
/*      */
/*      */ 
/* 4482 */     Integer materialAttr = new Integer(10020);
/*      */ 
/* 4484 */     filter.getFilterItems().add(new FilterItemInfo("plan.materialAttr", materialAttr, CompareType.EQUALS));
/*      */
/*      */ 
/* 4487 */     String sMask = "#0 and #1 and (#2 or #3)";
/* 4488 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/*      */ 
/* 4490 */     if (BOMTypeEnum.MfgBOM.equals(bomType)) {
/* 4491 */       filter.getFilterItems().add(new FilterItemInfo("plan.isConfigable", new Boolean(false), CompareType.EQUALS));
/*      */
/*      */ 
/* 4494 */       sMask = "#0 and #1 and(#2 or #3) and #4";
/* 4495 */     } else if ((BOMTypeEnum.OrderBOM.equals(bomType)) && 
/*      */
/* 4497 */       (this.prmtmaterial.getValue() != null) && 
/* 4498 */       (!(planInfo.isIsConfigable()))) {
/* 4499 */       filter.getFilterItems().add(new FilterItemInfo("plan.isConfigable", new Boolean(false), CompareType.EQUALS));
/*      */
/*      */ 
/* 4502 */       sMask = "#0 and #1 and(#2 or #3) and #4";
/*      */
/*      */     }
/*      */ 
/* 4506 */     filter.setMaskString(sMask);
/* 4507 */     tmpView.setFilter(filter);
/* 4508 */     bizEntryMaterialBox.setEntityViewInfo(tmpView);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean isDefaultLockedColumn(String columnKey)
/*      */   {
/* 4521 */     String[] columnKeys = { "materialName", "materialModel", "unit", "isAssigned", "materialProp" };
/*      */ 
/* 4523 */     for (int i = 0; i < columnKeys.length; ++i) {
/* 4524 */       if (columnKeys[i].equals(columnKey)) {
/* 4525 */         return true;
/*      */       }
/*      */     }
/* 4528 */     return false;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setCellLocked(int rowIndex, String columnKey, boolean isLocked)
/*      */   {
/* 4546 */     ICell cell = this.kdtEntrys.getCell(rowIndex, columnKey);
/* 4547 */     setCellLocked(cell, isLocked);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setCellLocked(IRow row, String columnKey, boolean isLocked)
/*      */   {
/* 4565 */     ICell cell = row.getCell(columnKey);
/* 4566 */     setCellLocked(cell, isLocked);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setCellLocked(ICell cell, boolean isLocked)
/*      */   {
/* 4582 */     cell.getStyleAttributes().setLocked(isLocked);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setColumnLocked(String columnKey, boolean isLocked)
/*      */   {
/* 4598 */     this.kdtEntrys.getColumn(columnKey).getStyleAttributes().setLocked(isLocked);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void setViewOptionValue()
/*      */   {
/* 4612 */     this.chkMenuItemCurrentMaterial.setSelected(true);
/* 4613 */     Set menuItemSet = new HashSet();
/* 4614 */     menuItemSet.add(this.chkMenuItemAllMaterial);
/* 4615 */     menuItemSet.add(this.chkMenuItemCurrentMaterial);
/* 4616 */     menuItemSet.add(this.chkMenuItemDisableMaterial);
/* 4617 */     menuItemSet.add(this.chkMenuItemWillMaterial);
/* 4618 */     Iterator it = menuItemSet.iterator();
/* 4619 */     KDRadioButtonMenuItem radioButtion = null;
/* 4620 */     String value = null;
/*      */     do { if (!(it.hasNext())) return;
/* 4622 */       radioButtion = (KDRadioButtonMenuItem)it.next();
/* 4623 */       value = ConfigServiceUtils.getUserConfigData(radioButtion.getName() + getOptionKeySuffix(), this);
/*      */     }
/* 4625 */     while (!(Boolean.TRUE.toString().equalsIgnoreCase(value)));
/* 4626 */     radioButtion.setSelected(true);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getOptionKeySuffix()
/*      */   {
/* 4642 */     String suffixStr = "";
/* 4643 */     if ((getUIContext().get("isUICache") != null) && (getUIContext().get("isUICache").toString().equals("true")))
/*      */
/*      */     {
/* 4646 */       suffixStr = "bomTree";
/* 4647 */       if ((getUIContext().get("UIClassParam") != null) && (getUIContext().get("UIClassParam").toString().equals("1")))
/*      */
/*      */
/*      */       {
/* 4651 */         suffixStr = "orderBomTree";
/*      */       }
/*      */     }
/* 4654 */     return suffixStr;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void addListeners()
/*      */   {
/* 4668 */     if (this.entryTableChange == null) {
/* 4669 */       this.entryTableChange = new KDTEditAdapter()
/*      */       {
/*      */         public void editStopped(KDTEditEvent e) {
/*      */           try {
/* 4673 */             BomEditUI.this.kdtEntries_Changed(e);
/*      */           } catch (Exception exc) {
/* 4675 */             BomEditUI.this.handUIException(exc);
/*      */           }
/*      */         }
/*      */ 
/*      */         public void editStarting(KDTEditEvent e) {
/*      */           try {
/* 4681 */             BomEditUI.this.kdtEntries_Changed(e);
/*      */           } catch (Exception ex) {
/* 4683 */             BomEditUI.this.handUIException(ex);
/*      */           }
/*      */         }
/*      */ 
/*      */         public void editValueChanged(KDTEditEvent e) {
/*      */           try {
/* 4689 */             BomEditUI.this.kdtEntries_EditValueChanged(e);
/*      */           } catch (Exception exc) {
/* 4691 */             BomEditUI.this.handUIException(exc);
/*      */           }
/*      */         }
/*      */       };
/*      */     }
/* 4696 */     this.kdtEntrys.addKDTEditListener(this.entryTableChange);
/*      */
/*      */ 
/* 4699 */     if (this.activeCellListener == null)
/* 4700 */       this.activeCellListener = new KDTActiveCellListener()
/*      */       {
/*      */         public void activeCellChanged(KDTActiveCellEvent e) {
/*      */           try {
/* 4704 */             BomEditUI.this.tableCellActived(e);
/*      */           } catch (Exception exc) {
/* 4706 */             BomEditUI.this.handUIException(exc);
/*      */           }
/*      */           finally {
/*      */           }
/*      */         }
/*      */       };
/* 4712 */     this.kdtEntrys.addKDTActiveCellListener(this.activeCellListener);
/*      */ 
/* 4714 */     if (this.prmtMaterialListener == null) {
/* 4715 */       this.prmtMaterialListener = new DataChangeListener()
/*      */       {
/*      */         public void dataChanged(DataChangeEvent e)
/*      */         {
/*      */           try {
/* 4720 */             BomEditUI.this.headMaterialChanged(e);
/*      */           } catch (EASBizException e1) {
/* 4722 */             BomEditUI.this.handUIException(e1);
/*      */           } catch (BOSException e1) {
/* 4724 */             BomEditUI.this.handUIException(e1);
/*      */           }
/*      */         }
/*      */       };
/*      */     }
/* 4729 */     this.prmtmaterial.addDataChangeListener(this.prmtMaterialListener);
/* 4730 */     if (this.prmtStorageListener == null) {
/* 4731 */       this.prmtStorageListener = new DataChangeListener()
/*      */       {
/*      */         public void dataChanged(DataChangeEvent e)
/*      */         {
/*      */           try {
/* 4736 */             BomEditUI.this.headStorageChanged(e);
/*      */           } catch (ParseException e1) {
/* 4738 */             BomEditUI.this.handUIException(e1);
/*      */           }
/*      */         }
/*      */       };
/*      */     }
/* 4743 */     this.prmtstorageOrgUnit.addDataChangeListener(this.prmtStorageListener);
/*      */ 
/* 4745 */     if (this.bizPreChangeListener == null) {
/* 4746 */       this.bizPreChangeListener = new PreChangeListener()
/*      */       {
/*      */         public void preChange(PreChangeEvent e) {
/* 4749 */           BomEditUI.this.prmtstorageOrgUnit_preChange(e);
/*      */         }
/*      */       };
/*      */     }
/* 4753 */     this.prmtstorageOrgUnit.addPreChangeListener(this.bizPreChangeListener);
/* 4754 */     if (this.qtyChangeLister == null) {
/* 4755 */       this.qtyChangeLister = new DataChangeListener()
/*      */       {
/*      */         public void dataChanged(DataChangeEvent e)
/*      */         {
/* 4759 */           BomEditUI.this.qtyChanged(e);
/*      */         }
/*      */       };
/*      */     }
/* 4763 */     this.txtproductQty.addDataChangeListener(this.qtyChangeLister);
/*      */ 
/* 4765 */     if (this.combBillFromListener == null)
/* 4766 */       this.combBillFromListener = new ItemListener()
/*      */       {
/*      */         public void itemStateChanged(ItemEvent e) {
/*      */           try {
/* 4770 */             BomEditUI.this.cmbType_itemStateChanged(e);
/*      */           } catch (Exception exc) {
/* 4772 */             BomEditUI.this.handUIException(exc);
/*      */           }
/*      */           finally {
/*      */           }
/*      */         }
/*      */       };
/* 4778 */     this.cmbType.addItemListener(this.combBillFromListener);
/*      */ 
/* 4780 */     if (this.prmtProjListener == null) {
/* 4781 */       this.prmtProjListener = new DataChangeListener()
/*      */       {
/*      */         public void dataChanged(DataChangeEvent e)
/*      */         {
/*      */           try {
/* 4786 */             BomEditUI.this.selectProjNumber(e);
/*      */           } catch (Exception e1) {
/* 4788 */             BomEditUI.this.handUIException(e1);
/*      */           }
/*      */         }
/*      */       };
/*      */     }
/* 4793 */     this.prmtProject.addDataChangeListener(this.prmtProjListener);
/*      */
/*      */ 
/* 4796 */     this.chkIsProjectManuListener = new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent e) {
/* 4799 */         BomEditUI.this.productManuChanged(e);
/*      */       }
/*      */     };
/* 4802 */     this.chkIsProjectManu.addActionListener(this.chkIsProjectManuListener);
/*      */
/*      */
/*      */ 
/* 4806 */     if (this.batchSubmitActionListener == null) {
/* 4807 */       this.batchSubmitActionListener = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/* 4810 */           boolean bool = ((KDCheckBoxMenuItem)e.getSource()).isSelected();
/*      */ 
/* 4812 */           String param = "MMBomTreeBatchSubmit";
/*      */ 
/* 4814 */           if (BomEditUI.this.isAddOrderBom) {
/* 4815 */             param = "MMOrderBomTreeBatchSubmit";
/*      */           }
/* 4817 */           ConfigServiceUtils.saveUserConfigData(param, BomEditUI.this, Boolean.toString(bool));
/*      */         }
/*      */       };
/*      */     }
/*      */ 
/* 4822 */     this.chkMenuItemBatchSubmit.addActionListener(this.batchSubmitActionListener);
/*      */ 
/* 4824 */     if (this.batchAuditActionListener == null) {
/* 4825 */       this.batchAuditActionListener = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/* 4828 */           boolean bool = ((KDCheckBoxMenuItem)e.getSource()).isSelected();
/*      */ 
/* 4830 */           String param = "MMBomTreeBatchAudit";
/*      */ 
/* 4832 */           if (BomEditUI.this.isAddOrderBom) {
/* 4833 */             param = "MMOrderBomTreeBatchAudit";
/*      */           }
/* 4835 */           ConfigServiceUtils.saveUserConfigData(param, BomEditUI.this, Boolean.toString(bool));
/*      */         }
/*      */       };
/*      */     }
/*      */ 
/* 4840 */     this.chkMenuItemBatchAudit.addActionListener(this.batchAuditActionListener);
/*      */ 
/* 4842 */     if (this.batchAssignActionListener == null) {
/* 4843 */       this.batchAssignActionListener = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/* 4846 */           boolean bool = ((KDCheckBoxMenuItem)e.getSource()).isSelected();
/*      */ 
/* 4848 */           String param = "MMOrderBomTreeBatchAssign";
/* 4849 */           ConfigServiceUtils.saveUserConfigData(param, BomEditUI.this, Boolean.toString(bool));
/*      */         }
/*      */       };
/*      */     }
/*      */ 
/* 4854 */     this.chkMenuItemBatchAssign.addActionListener(this.batchAssignActionListener);
/*      */   }
/*      */
/*      */   private void removeListener() {
/* 4858 */     if (this.entryTableChange != null)
/* 4859 */       this.kdtEntrys.removeKDTEditListener(this.entryTableChange);
/* 4860 */     if (this.prmtMaterialListener != null)
/* 4861 */       this.prmtmaterial.removeDataChangeListener(this.prmtMaterialListener);
/* 4862 */     if (this.qtyChangeLister != null) {
/* 4863 */       this.txtproductQty.removeDataChangeListener(this.qtyChangeLister);
/*      */     }
/* 4865 */     if (this.combBillFromListener != null)
/* 4866 */       this.cmbType.removeItemListener(this.combBillFromListener);
/* 4867 */     if (this.prmtStorageListener != null)
/* 4868 */       this.prmtstorageOrgUnit.removeDataChangeListener(this.prmtStorageListener);
/* 4869 */     if (null != this.activeCellListener) {
/* 4870 */       this.kdtEntrys.removeKDTActiveCellListener(this.activeCellListener);
/*      */     }
/* 4872 */     if (this.prmtProjListener != null) {
/* 4873 */       this.prmtProject.removeDataChangeListener(this.prmtProjListener);
/*      */     }
/*      */ 
/* 4876 */     if (this.chkIsProjectManuListener != null) {
/* 4877 */       this.chkIsProjectManu.removeActionListener(this.chkIsProjectManuListener);
/*      */
/*      */     }
/*      */ 
/* 4881 */     if (this.batchSubmitActionListener != null) {
/* 4882 */       this.chkMenuItemBatchSubmit.removeActionListener(this.batchSubmitActionListener);
/*      */     }
/*      */ 
/* 4885 */     if (this.batchAuditActionListener != null) {
/* 4886 */       this.chkMenuItemBatchAudit.removeActionListener(this.batchAuditActionListener);
/*      */     }
/*      */ 
/* 4889 */     if (this.batchAssignActionListener != null) {
/* 4890 */       this.chkMenuItemBatchAssign.removeActionListener(this.batchAssignActionListener);
/*      */     }
/*      */ 
/* 4893 */     if (this.bizPreChangeListener != null)
/* 4894 */       this.prmtstorageOrgUnit.removePreChangeListener(this.bizPreChangeListener);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void storeTrackNumber()
/*      */   {
/* 4910 */     if (this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM))
/* 4911 */       setPrjTrackOfOrderBom();
/* 4912 */     else if (this.cmbType.getSelectedItem().equals(BOMTypeEnum.CfgBOM))
/* 4913 */       setPrjTrackOfCfgBom();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setBomName()
/*      */   {
/* 4929 */     if (this.editData != null) {
/* 4930 */       String name = this.editData.getName();
/* 4931 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(name)) {
/* 4932 */         return;
/*      */       }
/* 4934 */       MaterialInfo material = this.editData.getMaterial();
/* 4935 */       if (material != null)
/* 4936 */         this.editData.setName(material.getNumber());
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void cmbType_itemStateChanged(ItemEvent e)
/*      */   {
/* 4952 */     Object selectedItem = this.cmbType.getSelectedItem();
/* 4953 */     if (selectedItem == null)
/* 4954 */       return;
/* 4955 */     if (selectedItem.equals(BOMTypeEnum.MfgBOM)) {
/* 4956 */       this.cmbUsage.setSelectedItem(BOMUsageEnum.Master);
/* 4957 */       this.cmbUsage.setEnabled(true);
/* 4958 */       this.actionPushDown.setEnabled(true);
/* 4959 */     } else if (selectedItem.equals(BOMTypeEnum.CfgBOM)) {
/* 4960 */       this.cmbUsage.setSelectedItem(BOMUsageEnum.Master);
/* 4961 */       this.cmbUsage.setEnabled(false);
/* 4962 */       this.actionPushDown.setEnabled(false);
/*      */     }
/*      */ 
/* 4965 */     String strParam = (String)getUIContext().get("UIClassParam");
/* 4966 */     if (null == strParam) {
/* 4967 */       this.prmtmaterial.setValue(null);
/* 4968 */       this.txtModel.setText(null);
/*      */     }
/* 4970 */     initDialogFace();
/* 4971 */     this.txtproductQty.setEnabled(true);
/* 4972 */     if (selectedItem.equals(BOMTypeEnum.CfgBOM)) {
/* 4973 */       this.btnToBom.setEnabled(false);
/* 4974 */       this.menuPBom.setEnabled(false);
/*      */     } else {
/* 4976 */       this.btnToBom.setEnabled(true);
/* 4977 */       this.menuPBom.setEnabled(true);
/*      */     }
/* 4979 */     hideTrackNumColumn();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void kdtEntries_EditValueChanged(KDTEditEvent e)
/*      */   {
/* 4992 */     int colIndex = e.getColIndex();
/* 4993 */     String fieldName = this.kdtEntrys.getColumnKey(colIndex);
/*      */ 
/* 4995 */     if ("isStockTransfer".equalsIgnoreCase(fieldName))
/*      */     {
/* 4997 */       dealWithStockTransfer(e, false);
/*      */
/*      */     }
/* 5000 */     else if ("isBackFlush".equalsIgnoreCase(fieldName))
/* 5001 */       dealWithBackFlush(e, false);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void kdtEntries_Changed(KDTEditEvent e)
/*      */     throws Exception
/*      */   {
/* 5011 */     Object oldValue = e.getOldValue();
/* 5012 */     Object newValue = e.getValue();
/* 5013 */     if ((newValue == null) && (oldValue == null)) {
/* 5014 */       return;
/*      */     }
/* 5016 */     if ((oldValue instanceof BigDecimal) && (newValue instanceof BigDecimal)) {
/* 5017 */       BigDecimal oldBigValue = (BigDecimal)oldValue;
/* 5018 */       BigDecimal newBigValue = (BigDecimal)newValue;
/* 5019 */       oldBigValue = oldBigValue.setScale(newBigValue.scale(), 4);
/*      */ 
/* 5021 */       if (oldBigValue.compareTo(newBigValue) == 0) {
/* 5022 */         return;
/*      */       }
/*      */     }
/* 5025 */     boolean isDiffrent = SCMGroupClientUtils.isDiffrent(newValue, oldValue);
/* 5026 */     if (!(isDiffrent)) {
/* 5027 */       return;
/*      */     }
/* 5029 */     int rowIndex = e.getRowIndex();
/* 5030 */     int colIndex = e.getColIndex();
/* 5031 */     IRow curRow = this.kdtEntrys.getRow(rowIndex);
/* 5032 */     String fieldName = this.kdtEntrys.getColumnKey(colIndex);
/* 5033 */     Set checkboxNameSet = getCheckboxColumnNameSet();
/* 5034 */     if (checkboxNameSet.contains(fieldName)) {
/* 5035 */       return;
/*      */     }
/*      */ 
/* 5038 */     if ("consumeFixQty".equalsIgnoreCase(fieldName)) {
/* 5039 */       if (curRow.getCell(fieldName).getValue() == null) {
/* 5040 */         curRow.getCell("consumeFixQty").setValue(MMConstant.BIGDECIMAL_ZERO);
/*      */       }
/*      */ 
/* 5043 */       if ((curRow.getCell("unit").getValue() == null) || (!(curRow.getCell("unit").getValue() instanceof MeasureUnitInfo))) {
/*      */         return;
/*      */       }
/* 5046 */       MeasureUnitInfo measureUnitInfo = (MeasureUnitInfo)getDetailTable().getRow(rowIndex).getCell("baseUnit").getValue();
/*      */ 
/* 5048 */       MaterialInfo materialInfo = (MaterialInfo)getDetailTable().getCell(rowIndex, "materialNumber").getValue();
/*      */
/*      */ 
/* 5051 */       if ((measureUnitInfo == null) || (materialInfo == null)) {
/* 5052 */         return;
/*      */       }
/* 5054 */       SCMClientUtils.changeTableColPrecisionByMaterial(materialInfo, measureUnitInfo, getDetailTable(), this.QTYPRECISIONFROMBASEUNITTAB, new int[] { rowIndex });
/*      */
/*      */ 
/* 5057 */       this.uiHelper.calEntryBaseQty(rowIndex, colIndex);
/*      */
/*      */
/*      */     }
/* 5061 */     else if ("unit".equalsIgnoreCase(fieldName)) {
/* 5062 */       entryUnitChange(rowIndex, (MeasureUnitInfo)oldValue, false);
/*      */
/*      */     }
/* 5065 */     else if ("consumeType".equalsIgnoreCase(fieldName)) {
/* 5066 */       ConsumeTypeEnum consumeType = (ConsumeTypeEnum)curRow.getCell("consumeType").getValue();
/*      */ 
/* 5068 */       if (consumeType != null) {
/* 5069 */         if (ConsumeTypeEnum.Proportion.equals(consumeType)) {
/* 5070 */           curRow.getCell("proportion").getStyleAttributes().setLocked(false);
/*      */ 
/* 5072 */           curRow.getCell("consumeFixQty").getStyleAttributes().setLocked(true);
/*      */ 
/* 5074 */           curRow.getCell("consumeFixQty").setValue(MMConstant.BIGDECIMAL_ZERO);
/*      */         }
/*      */         else {
/* 5077 */           curRow.getCell("proportion").getStyleAttributes().setLocked(true);
/*      */ 
/* 5079 */           curRow.getCell("proportion").setValue(MMConstant.BIGDECIMAL_ZERO);
/*      */ 
/* 5081 */           curRow.getCell("consumeFixQty").getStyleAttributes().setLocked(false);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/* 5087 */     else if ("provideType".equalsIgnoreCase(fieldName)) {
/* 5088 */       dealWithProvideType(e, curRow);
/*      */
/*      */     }
/* 5091 */     else if ("supplyOrgUnit".equalsIgnoreCase(fieldName)) {
/* 5092 */       curRow.getCell("defaultWarehouse").setValue(null);
/* 5093 */       curRow.getCell("location").setValue(null);
/* 5094 */       dealWithDefaultWarehouse(e, false);
/* 5095 */       dealWithTransferWarehouse(e, false);
/*      */
/*      */     }
/* 5098 */     else if ("transferOrgUnit".equalsIgnoreCase(fieldName))
/*      */     {
/* 5100 */       curRow.getCell("transferWarehouse").setValue(null);
/* 5101 */       dealWithTransferWarehouse(e, false);
/*      */
/*      */     }
/* 5104 */     else if ("outputType".equalsIgnoreCase(fieldName)) {
/* 5105 */       MaterialProductEnum productType = (MaterialProductEnum)curRow.getCell("outputType").getValue();
/*      */
/*      */
/*      */ 
/* 5109 */       if ((productType.equals(MaterialProductEnum.RELATEDPRODUCT)) || (productType.equals(MaterialProductEnum.BYPRODUCT)))
/*      */
/*      */       {
/* 5112 */         curRow.getCell("isBackFlush").setValue(Boolean.FALSE);
/* 5113 */         curRow.getCell("isStockTransfer").setValue(Boolean.FALSE);
/* 5114 */         curRow.getCell("transferOrgUnit").setValue(null);
/* 5115 */         curRow.getCell("transferWarehouse").setValue(null);
/*      */
/*      */       }
/*      */ 
/* 5119 */       dealWithPickingMode(e, false);
/*      */
/*      */     }
/* 5122 */     else if ("materialNumber".equalsIgnoreCase(fieldName)) {
/* 5123 */       if (curRow.getCell("materialNumber").getValue() == null) {
/* 5124 */         curRow.getCell("materialName").setValue(null);
/* 5125 */         curRow.getCell("materialModel").setValue(null);
/* 5126 */         curRow.getCell("unit").setValue(null);
/* 5127 */         curRow.getCell("defaultWarehouse").setValue(null);
/* 5128 */         curRow.getCell("isStockTransfer").setValue(Boolean.FALSE);
/* 5129 */         curRow.getCell("isBackFlush").setValue(Boolean.FALSE);
/* 5130 */         curRow.getCell("transferOrgUnit").setValue(null);
/* 5131 */         curRow.getCell("transferWarehouse").setValue(null);
/*      */
/*      */
/*      */
/*      */ 
/* 5136 */         curRow.getCell("provideType").setValue(MaterialProvideTypeEnum.CURRENTORGPROVIDE);
/*      */ 
/* 5138 */         curRow.getCell("supplyOrgUnit").setValue(this.prmtstorageOrgUnit.getValue());
/*      */
/*      */       }
/*      */ 
/*      */     }
/* 5143 */     else if ("defaultWarehouse".equalsIgnoreCase(fieldName))
/*      */     {
/* 5145 */       dealWithDefaultWarehouse(e, false);
/* 5146 */       curRow.getCell("location").setValue(null);
/* 5147 */       dealWithTransferWarehouse(e, false);
/*      */     }
/*      */     else {
/* 5150 */       if (!("pickingMode".equalsIgnoreCase(fieldName)))
/*      */         return;
/* 5152 */       dealWithPickingMode(e, false);
/*      */ 
/* 5154 */       dealWithBackFlush(e, false);
/* 5155 */       dealWithStockTransfer(e, false);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void tableCellActived(KDTActiveCellEvent e)
/*      */   {
/* 5168 */     if (this.hasOrderBomFormCfgBom) {
/* 5169 */       return;
/*      */     }
/* 5171 */     int currRowIndex = e.getRowIndex();
/* 5172 */     int currColIndex = e.getColumnIndex();
/* 5173 */     IRow changeRow = this.kdtEntrys.getRow(currRowIndex);
/*      */ 
/* 5175 */     if (changeRow == null) {
/* 5176 */       return;
/*      */     }
/* 5178 */     String fieldName = this.kdtEntrys.getColumnKey(currColIndex);
/*      */ 
/* 5180 */     if (isDefaultLockedColumn(fieldName)) {
/* 5181 */       setCellLocked(currRowIndex, fieldName, true);
/* 5182 */       return;
/*      */     }
/* 5184 */     IRow curRow = this.kdtEntrys.getRow(currRowIndex);
/* 5185 */     Boolean isAssigned = (Boolean)curRow.getCell("isAssigned").getValue();
/*      */
/*      */ 
/* 5188 */     if (isAssigned.booleanValue()) {
/* 5189 */       boolean isLocked = true;
/*      */ 
/* 5191 */       if (("pickingMode".equalsIgnoreCase(fieldName)) || ("leadtime".equalsIgnoreCase(fieldName)) || ("supplyOrgUnit".equalsIgnoreCase(fieldName)) || ("provideType".equalsIgnoreCase(fieldName)) || ("defaultWarehouse".equalsIgnoreCase(fieldName)) || ("bluePrint".equalsIgnoreCase(fieldName)))
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */       {
/* 5198 */         isLocked = false;
/*      */       }
/* 5200 */       setCellLocked(currRowIndex, fieldName, isLocked);
/*      */
/*      */ 
/* 5203 */       dealWithPickingMode(null, true);
/* 5204 */       dealWithSupplyOrgUnit(null, true);
/* 5205 */       dealWithDefaultWarehouse(null, true);
/* 5206 */       return;
/*      */
/*      */     }
/*      */ 
/* 5210 */     if ("materialNumber".equalsIgnoreCase(fieldName)) {
/* 5211 */       if (this.prmtmaterial.getValue() == null) {
/* 5212 */         MsgBox.showWarning(this, getResource("fatherMaterial_Required"));
/* 5213 */         this.prmtmaterial.requestFocusInWindow();
/* 5214 */         this.kdtEntrys.getSelectManager().removeAll(false);
/*      */ 
/* 5216 */         setColumnLocked("materialNumber", true);
/* 5217 */         return;
/*      */       }
/* 5219 */       boolean isLocked = false;
/* 5220 */       if (this.hasOrderBomFormCfgBom) {
/* 5221 */         isLocked = true;
/*      */       }
/* 5223 */       setColumnLocked("materialNumber", isLocked);
/*      */
/*      */
/*      */     }
/* 5227 */     else if ("consumeFixQty".equalsIgnoreCase(fieldName))
/*      */     {
/* 5229 */       Object obj = curRow.getCell("consumeType").getValue();
/* 5230 */       if (obj == null)
/*      */       {
/* 5232 */         setCellLocked(curRow, "consumeFixQty", true);
/* 5233 */         return;
/*      */       }
/* 5235 */       ConsumeTypeEnum consumeType = (ConsumeTypeEnum)obj;
/* 5236 */       if (consumeType.equals(ConsumeTypeEnum.VariableAmount))
/*      */
/*      */       {
/* 5239 */         if (Boolean.FALSE.equals(isAssigned))
/*      */
/*      */         {
/* 5242 */           setCellLocked(curRow, "consumeFixQty", false);
/*      */         }
/*      */ 
/*      */       }
/*      */       else {
/* 5247 */         setCellLocked(curRow, "consumeFixQty", true);
/*      */       }
/*      */ 
/*      */     }
/* 5251 */     else if ("proportion".equalsIgnoreCase(fieldName))
/*      */     {
/* 5253 */       ConsumeTypeEnum consumeType = (ConsumeTypeEnum)curRow.getCell("consumeType").getValue();
/*      */ 
/* 5255 */       if ((consumeType == null) || (consumeType.equals(ConsumeTypeEnum.VariableAmount)))
/*      */
/*      */
/*      */       {
/* 5259 */         setCellLocked(curRow, "proportion", true);
/*      */
/*      */
/*      */       }
/* 5263 */       else if (Boolean.FALSE.equals(isAssigned))
/*      */
/*      */       {
/* 5266 */         setCellLocked(curRow, "proportion", false);
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 5271 */       if ((!("isBackFlush".equals(fieldName))) && (!("isStockTransfer".equals(fieldName))))
/*      */         return;
/* 5273 */       setBackFlushOrStockTransferLocked(curRow, fieldName);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private KDTEditEvent createKDTEditEvent(boolean isAddLine)
/*      */   {
/* 5289 */     KDTEditEvent event = null;
/* 5290 */     int index = -1;
/*      */ 
/* 5292 */     if (isAddLine) {
/* 5293 */       index = this.kdtEntrys.getRowCount() - 1;
/*      */     }
/*      */     else
/*      */     {
/* 5297 */       int[] rowIndexs = KDTableUtil.getSelectedRows(this.kdtEntrys);
/*      */ 
/* 5299 */       if ((rowIndexs == null) || (rowIndexs.length == 0)) {
/* 5300 */         index = this.kdtEntrys.getRowCount() - 1;
/*      */       }
/*      */       else
/*      */       {
/* 5304 */         index = rowIndexs[0];
/*      */       }
/*      */     }
/*      */ 
/* 5308 */     event = new KDTEditEvent(this.kdtEntrys, null, null, index, -1, false, 1);
/*      */ 
/* 5310 */     return event;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void selectProjNumber(DataChangeEvent e)
/*      */     throws Exception
/*      */   {
/* 5321 */     boolean isDiffrent = SCMGroupClientUtils.isDiffrent(e.getNewValue(), e.getOldValue());
/*      */ 
/* 5323 */     if (isDiffrent) {
/* 5324 */       this.prmtTrack.setValue(null);
/* 5325 */       int count = this.kdtEntrys.getRowCount();
/* 5326 */       for (int i = 0; i < count; ++i)
/* 5327 */         this.kdtEntrys.getCell(i, "trackNum").setValue(null);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void headStorageChanged(DataChangeEvent e)
/*      */     throws ParseException
/*      */   {
/* 5343 */     boolean isDiffrent = SCMGroupClientUtils.isDiffrent(e.getNewValue(), e.getOldValue());
/*      */
/*      */ 
/* 5346 */     if (isDiffrent) {
/* 5347 */       if (this.kdtEntrys.getRowCount() > 0) {
/* 5348 */         this.kdtEntrys.removeRows();
/*      */       }
/* 5350 */       if (this.editData.getEntrys() != null) {
/* 5351 */         this.editData.getEntrys().clear();
/*      */       }
/* 5353 */       this.prmtmaterial.setValue(null);
/*      */ 
/* 5355 */       this.prmtProject.setValue(null);
/*      */     }
/* 5357 */     if ((isDiffrent) && (e.getNewValue() != null)) {
/* 5358 */       this.prmtmaterial.setAccessAuthority(0);
/*      */ 
/* 5360 */       this.kdtEntrys.getColumn("defaultWarehouse").getStyleAttributes().setLocked(false);
/*      */ 
/* 5362 */       this.kdtEntrys.getColumn("materialNumber").getStyleAttributes().setLocked(false);
/*      */
/*      */ 
/* 5365 */       dealWithSupplyOrgUnit(null, false);
/* 5366 */       dealWithDefaultWarehouse(null, false);
/* 5367 */       dealWithStockTransfer(null, false);
/* 5368 */       dealWithTransferOrgUnit(null, false);
/* 5369 */       dealWithTransferWarehouse(null, false);
/*      */
/*      */ 
/* 5372 */       this.prmtBomGroup.setValue(null);
/* 5373 */       EntityViewInfo view = new EntityViewInfo();
/* 5374 */       FilterInfo filterInfo = new FilterInfo();
/* 5375 */       filterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", ((StorageOrgUnitInfo)e.getNewValue()).getId().toString(), CompareType.EQUALS));
/*      */
/*      */
/*      */ 
/* 5379 */       view.setFilter(filterInfo);
/* 5380 */       getUIContext().put("createOrg", e.getNewValue());
/* 5381 */       this.prmtBomGroup.setEntityViewInfo(view);
/*      */     }
/* 5383 */     this.prmtstorageOrgUnit.commitEdit();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithSupplyOrgUnit(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5398 */     StorageOrgUnitInfo storageOrgUnitInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 5400 */     if (null == storageOrgUnitInfo) {
/* 5401 */       return;
/*      */     }
/*      */ 
/* 5404 */     int startIndex = -1;
/* 5405 */     int endIndex = -1;
/* 5406 */     if (null == e) {
/* 5407 */       startIndex = 0;
/* 5408 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5410 */       startIndex = e.getRowIndex();
/* 5411 */       if (startIndex == -1) {
/* 5412 */         startIndex = 0;
/*      */       }
/* 5414 */       endIndex = startIndex + 1;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 5423 */     MaterialProvideTypeEnum provideType = MaterialProvideTypeEnum.NONE;
/* 5424 */     FilterInfo filter = null;
/* 5425 */     String orgUnitId = storageOrgUnitInfo.getId().toString();
/*      */ 
/* 5427 */     IRow curRow = null;
/*      */ 
/* 5429 */     boolean isLocked = true;
/* 5430 */     String queryInfo = "com.kingdee.eas.basedata.org.app.StorageItemQuery";
/* 5431 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5432 */       curRow = this.kdtEntrys.getRow(i);
/* 5433 */       provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */
/*      */ 
/* 5436 */       if (provideType.equals(MaterialProvideTypeEnum.CURRENTORGPROVIDE)) {
/* 5437 */         isLocked = true;
/*      */
/*      */       }
/* 5440 */       else if (provideType.equals(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE))
/*      */       {
/* 5442 */         KDBizPromptBox sou = createKDBizPromptBox(queryInfo);
/* 5443 */         filter = new FilterInfo();
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */ 
/* 5460 */         filter.getFilterItems().add(new FilterItemInfo("id", orgUnitId, CompareType.NOTEQUALS));
/*      */
/*      */ 
/* 5463 */         filter.getFilterItems().add(new FilterItemInfo("isBizUnit", new Integer(1), CompareType.EQUALS));
/*      */
/*      */
/*      */ 
/* 5467 */         EntityViewInfo viewInfo = new EntityViewInfo();
/* 5468 */         viewInfo.setFilter(filter);
/* 5469 */         sou.setEntityViewInfo(viewInfo);
/* 5470 */         curRow.getCell("supplyOrgUnit").setEditor(new KDTDefaultCellEditor(sou));
/*      */
/*      */ 
/* 5473 */         isLocked = false;
/*      */
/*      */       }
/* 5476 */       else if ((provideType.equals(MaterialProvideTypeEnum.SPANORGPROVIDE)) || (provideType.equals(MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE)))
/*      */
/*      */       {
/* 5479 */         KDBizPromptBox sou = createKDBizPromptBox(queryInfo);
/* 5480 */         filter = new FilterInfo();
/* 5481 */         filter.getFilterItems().add(new FilterItemInfo("id", orgUnitId, CompareType.NOTEQUALS));
/*      */
/*      */ 
/* 5484 */         filter.getFilterItems().add(new FilterItemInfo("isBizUnit", new Integer(1), CompareType.EQUALS));
/*      */
/*      */ 
/* 5487 */         EntityViewInfo viewInfo = new EntityViewInfo();
/* 5488 */         viewInfo.setFilter(filter);
/* 5489 */         sou.setEntityViewInfo(viewInfo);
/* 5490 */         curRow.getCell("supplyOrgUnit").setEditor(new KDTDefaultCellEditor(sou));
/*      */
/*      */ 
/* 5493 */         isLocked = false;
/*      */       }
/* 5495 */       setCellLocked(curRow, "supplyOrgUnit", isLocked);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithDefaultWarehouse(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5511 */     int startIndex = -1;
/* 5512 */     int endIndex = -1;
/* 5513 */     if (null == e) {
/* 5514 */       startIndex = 0;
/* 5515 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5517 */       startIndex = e.getRowIndex();
/* 5518 */       if (startIndex == -1) {
/* 5519 */         startIndex = 0;
/*      */       }
/* 5521 */       endIndex = startIndex + 1;
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 5528 */     MaterialProvideTypeEnum provideType = MaterialProvideTypeEnum.NONE;
/* 5529 */     IRow curRow = null;
/* 5530 */     StorageOrgUnitInfo storageOrgUnitInfo = null;
/* 5531 */     KDBizPromptBox wareF7 = null;
/* 5532 */     boolean isLocked = true;
/* 5533 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5534 */       curRow = this.kdtEntrys.getRow(i);
/* 5535 */       provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */
/*      */ 
/* 5538 */       if ((provideType.equals(MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE)) || (provideType.equals(MaterialProvideTypeEnum.SPANORGPROVIDE)))
/*      */
/*      */
/*      */       {
/* 5542 */         storageOrgUnitInfo = (StorageOrgUnitInfo)curRow.getCell("supplyOrgUnit").getValue();
/*      */ 
/* 5544 */         wareF7 = createDefaultWarehouseKDBizPromptBox(storageOrgUnitInfo);
/* 5545 */         curRow.getCell("defaultWarehouse").setEditor(new KDTDefaultCellEditor(wareF7));
/*      */
/*      */
/*      */ 
/* 5549 */         if (curRow.getCell("supplyOrgUnit").getValue() != null) {
/* 5550 */           isLocked = false;
/*      */         }
/*      */ 
/*      */       }
/* 5554 */       else if ((provideType.equals(MaterialProvideTypeEnum.CURRENTORGPROVIDE)) || (provideType.equals(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE)))
/*      */
/*      */
/*      */       {
/* 5558 */         storageOrgUnitInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 5560 */         wareF7 = createDefaultWarehouseKDBizPromptBox(storageOrgUnitInfo);
/* 5561 */         curRow.getCell("defaultWarehouse").setEditor(new KDTDefaultCellEditor(wareF7));
/*      */ 
/* 5563 */         isLocked = false;
/*      */       }
/* 5565 */       setCellLocked(curRow, "defaultWarehouse", isLocked);
/*      */ 
/* 5567 */       setLocationLockStatus(curRow);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithStockTransfer(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5584 */     int colIndex = 0;
/* 5585 */     int startIndex = -1;
/* 5586 */     int endIndex = -1;
/* 5587 */     if (null == e) {
/* 5588 */       startIndex = 0;
/* 5589 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5591 */       startIndex = e.getRowIndex();
/* 5592 */       if (startIndex == -1) {
/* 5593 */         startIndex = 0;
/*      */       }
/* 5595 */       endIndex = startIndex + 1;
/* 5596 */       colIndex = e.getColIndex();
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 5605 */     IRow curRow = null;
/* 5606 */     String fieldName = this.kdtEntrys.getColumnKey(colIndex);
/* 5607 */     boolean isStockTransferColumn = "isStockTransfer".equals(fieldName);
/* 5608 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5609 */       curRow = this.kdtEntrys.getRow(i);
/*      */ 
/* 5611 */       setBackFlushOrStockTransferLocked(curRow, "isStockTransfer");
/* 5612 */       if (!(isLoadFields))
/*      */
/*      */       {
/* 5615 */         setBackFlushOrStockTransferNotChecked(curRow, "isStockTransfer");
/*      */ 
/* 5617 */         Boolean isChecked = null;
/* 5618 */         if (isStockTransferColumn) {
/* 5619 */           isChecked = (Boolean)e.getValue();
/* 5620 */           curRow.getCell("isStockTransfer").setValue(isChecked);
/*      */         } else {
/* 5622 */           isChecked = (Boolean)curRow.getCell("isStockTransfer").getValue();
/*      */
/*      */         }
/*      */ 
/* 5626 */         if (isChecked.booleanValue()) {
/* 5627 */           curRow.getCell("transferOrgUnit").setValue(this.prmtstorageOrgUnit.getValue());
/*      */
/*      */ 
/* 5630 */           setCellLocked(curRow, "transferOrgUnit", false);
/*      */         }
/*      */         else
/*      */         {
/* 5634 */           curRow.getCell("transferOrgUnit").setValue(null);
/*      */ 
/* 5636 */           setCellLocked(curRow, "transferOrgUnit", true);
/*      */         }
/*      */ 
/* 5639 */         dealWithTransferWarehouse(e, false);
/* 5640 */         curRow.getCell("transferWarehouse").setValue(null);
/*      */       }
/*      */       else
/*      */       {
/* 5644 */         Boolean isChecked = (Boolean)curRow.getCell("isStockTransfer").getValue();
/*      */ 
/* 5646 */         boolean isLocked = true;
/* 5647 */         if (isChecked.booleanValue()) {
/* 5648 */           isLocked = false;
/*      */         }
/* 5650 */         setCellLocked(curRow, "transferOrgUnit", isLocked);
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithTransferOrgUnit(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5667 */     int startIndex = -1;
/* 5668 */     int endIndex = -1;
/* 5669 */     if (null == e) {
/* 5670 */       startIndex = 0;
/* 5671 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5673 */       startIndex = e.getRowIndex();
/* 5674 */       if (startIndex == -1) {
/* 5675 */         startIndex = 0;
/*      */       }
/* 5677 */       endIndex = startIndex + 1;
/*      */     }
/*      */ 
/* 5680 */     IRow curRow = null;
/* 5681 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5682 */       curRow = this.kdtEntrys.getRow(i);
/* 5683 */       if (isLoadFields)
/*      */         continue;
/* 5685 */       curRow.getCell("transferOrgUnit").setValue(null);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithTransferWarehouse(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5703 */     int startIndex = -1;
/* 5704 */     int endIndex = -1;
/* 5705 */     if (null == e) {
/* 5706 */       startIndex = 0;
/* 5707 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5709 */       startIndex = e.getRowIndex();
/* 5710 */       if (startIndex == -1) {
/* 5711 */         startIndex = 0;
/*      */       }
/* 5713 */       endIndex = startIndex + 1;
/*      */     }
/*      */ 
/* 5716 */     MaterialProvideTypeEnum provideType = MaterialProvideTypeEnum.NONE;
/* 5717 */     boolean isStockTransfer = false;
/* 5718 */     StorageOrgUnitInfo transferOrgUnit = null;
/* 5719 */     StorageOrgUnitInfo currOrgUnit = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 5721 */     WarehouseInfo excludeWarehouse = null;
/* 5722 */     IRow curRow = null;
/* 5723 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5724 */       curRow = this.kdtEntrys.getRow(i);
/* 5725 */       provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */ 
/* 5727 */       if ((((MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE.equals(provideType)) || (MaterialProvideTypeEnum.CURRENTORGPROVIDE.equals(provideType)))) && 
/*      */
/*      */
/*      */
/* 5731 */         (curRow.getCell("transferWarehouse").getValue() != null) && (curRow.getCell("defaultWarehouse").getValue() != null))
/*      */       {
/* 5733 */         String wareHouse1 = ((WarehouseInfo)this.kdtEntrys.getCell(i, "transferWarehouse").getValue()).getId().toString();
/*      */
/*      */ 
/* 5736 */         String wareHouse2 = ((WarehouseInfo)this.kdtEntrys.getCell(i, "defaultWarehouse").getValue()).getId().toString();
/*      */ 
/* 5738 */         if ((wareHouse1.equals(wareHouse2)) && 
/* 5739 */           (!(isLoadFields))) {
/* 5740 */           curRow.getCell("transferWarehouse").setValue(null);
/*      */
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 5746 */       if (curRow.getCell("isStockTransfer").getValue() != null) {
/* 5747 */         isStockTransfer = ((Boolean)this.kdtEntrys.getCell(i, "isStockTransfer").getValue()).booleanValue();
/*      */
/*      */       }
/*      */ 
/* 5751 */       if (!(isStockTransfer)) {
/* 5752 */         if (!(isLoadFields)) {
/* 5753 */           curRow.getCell("transferWarehouse").setValue(null);
/*      */         }
/*      */ 
/* 5756 */         curRow.getCell("transferWarehouse").getStyleAttributes().setLocked(true);
/*      */       }
/*      */       else {
/* 5759 */         curRow.getCell("transferWarehouse").getStyleAttributes().setLocked(false);
/*      */
/*      */ 
/* 5762 */         transferOrgUnit = (StorageOrgUnitInfo)this.kdtEntrys.getCell(i, "transferOrgUnit").getValue();
/*      */ 
/* 5764 */         if ((transferOrgUnit != null) && (currOrgUnit != null) && 
/* 5765 */           (transferOrgUnit.getId().toString().equals(currOrgUnit.getId().toString())))
/*      */
/*      */         {
/* 5768 */           excludeWarehouse = (WarehouseInfo)this.kdtEntrys.getCell(i, "defaultWarehouse").getValue();
/*      */
/*      */
/*      */         }
/*      */ 
/* 5773 */         if (transferOrgUnit == null) {
/* 5774 */           if (!(isLoadFields)) {
/* 5775 */             curRow.getCell("transferWarehouse").setValue(null);
/*      */           }
/*      */ 
/* 5778 */           curRow.getCell("transferWarehouse").getStyleAttributes().setLocked(true);
/*      */         }
/*      */         else
/*      */         {
/* 5782 */           KDBizPromptBox warehouse = new KDBizPromptBox();
/* 5783 */           warehouse.setEditable(true);
/* 5784 */           warehouse.setDisplayFormat("$name$");
/* 5785 */           warehouse.setEditFormat("$number$");
/* 5786 */           warehouse.setCommitFormat("$number$");
/* 5787 */           warehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7WarehouseQuery");
/* 5788 */           curRow.getCell("transferWarehouse").setEditor(new KDTDefaultCellEditor(warehouse));
/*      */ 
/* 5790 */           EntityViewInfo viewInfo = new EntityViewInfo();
/* 5791 */           FilterInfo filterInfo = new FilterInfo();
/* 5792 */           viewInfo.setFilter(filterInfo);
/* 5793 */           filterInfo.getFilterItems().add(new FilterItemInfo("STORAGEORGUNIT.ID", transferOrgUnit.getId().toString(), CompareType.EQUALS));
/*      */
/*      */
/*      */ 
/* 5797 */           if (excludeWarehouse != null) {
/* 5798 */             filterInfo.getFilterItems().add(new FilterItemInfo("id", excludeWarehouse.getId().toString(), CompareType.NOTEQUALS));
/*      */
/*      */
/*      */           }
/*      */ 
/* 5803 */           viewInfo.setFilter(filterInfo);
/* 5804 */           warehouse.setEntityViewInfo(viewInfo);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithBackFlush(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5823 */     int startIndex = -1;
/* 5824 */     int endIndex = -1;
/* 5825 */     if (null == e) {
/* 5826 */       startIndex = 0;
/* 5827 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5829 */       startIndex = e.getRowIndex();
/* 5830 */       if (startIndex == -1) {
/* 5831 */         startIndex = 0;
/*      */       }
/* 5833 */       endIndex = startIndex + 1;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 5841 */     IRow curRow = null;
/* 5842 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5843 */       curRow = this.kdtEntrys.getRow(i);
/* 5844 */       setBackFlushOrStockTransferLocked(curRow, "isBackFlush");
/* 5845 */       if (!(isLoadFields))
/* 5846 */         setBackFlushOrStockTransferNotChecked(curRow, "isBackFlush");
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithPickingMode(KDTEditEvent e, boolean isLoadFields)
/*      */   {
/* 5865 */     int startIndex = -1;
/* 5866 */     int endIndex = -1;
/* 5867 */     if (null == e) {
/* 5868 */       startIndex = 0;
/* 5869 */       endIndex = this.kdtEntrys.getRowCount();
/*      */     } else {
/* 5871 */       startIndex = e.getRowIndex();
/* 5872 */       if (startIndex == -1) {
/* 5873 */         startIndex = 0;
/*      */       }
/* 5875 */       endIndex = startIndex + 1;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 5884 */     MaterialProvideTypeEnum provideType = null;
/*      */ 
/* 5886 */     MaterialProductEnum outputType = null;
/* 5887 */     MaterialIssueModeEnum issueMode = null;
/* 5888 */     IRow curRow = null;
/* 5889 */     boolean isLocked = false;
/* 5890 */     for (int i = startIndex; i < endIndex; ++i) {
/* 5891 */       curRow = this.kdtEntrys.getRow(i);
/* 5892 */       provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */ 
/* 5894 */       if (curRow.getCell("outputType").getValue() != null) {
/* 5895 */         outputType = (MaterialProductEnum)curRow.getCell("outputType").getValue();
/*      */
/*      */       }
/*      */ 
/* 5899 */       if ((MaterialProductEnum.RELATEDPRODUCT.equals(outputType)) || (MaterialProductEnum.BYPRODUCT.equals(outputType)))
/*      */
/*      */       {
/* 5902 */         issueMode = MaterialIssueModeEnum.NOTISSMODE;
/* 5903 */         isLocked = true;
/*      */
/*      */       }
/* 5906 */       else if (MaterialProductEnum.OTHER.equals(outputType))
/*      */       {
/* 5908 */         if ((provideType.equals(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE)) || (provideType.equals(MaterialProvideTypeEnum.SPANORGPROVIDE)))
/*      */
/*      */
/*      */         {
/* 5912 */           issueMode = MaterialIssueModeEnum.PRODUCEISSMODE;
/* 5913 */           isLocked = true;
/*      */
/*      */         }
/* 5916 */         else if (MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE.equals(provideType))
/*      */         {
/* 5918 */           issueMode = MaterialIssueModeEnum.STRAIGHT;
/* 5919 */           isLocked = true;
/*      */
/*      */         }
/* 5922 */         else if (MaterialProvideTypeEnum.CURRENTORGPROVIDE.equals(provideType))
/*      */         {
/* 5924 */           issueMode = (MaterialIssueModeEnum)curRow.getCell("pickingMode").getValue();
/*      */ 
/* 5926 */           isLocked = false;
/*      */         }
/*      */       }
/* 5929 */       if (!(isLoadFields)) {
/* 5930 */         curRow.getCell("pickingMode").setValue(issueMode);
/*      */       }
/* 5932 */       setCellLocked(curRow, "pickingMode", isLocked);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void headMaterialChanged(DataChangeEvent e)
/*      */     throws EASBizException, BOSException
/*      */   {
/* 5949 */     boolean isDiffrent = SCMGroupClientUtils.isDiffrent(e.getNewValue(), e.getOldValue());
/*      */
/*      */ 
/* 5952 */     if (!(isDiffrent)) {
/* 5953 */       return;
/*      */     }
/* 5955 */     this.projectInfo = null;
/* 5956 */     this.trackMap = null;
/* 5957 */     MaterialInfo material = (MaterialInfo)e.getNewValue();
/* 5958 */     if (e.getNewValue() != null)
/*      */     {
/* 5960 */       this.txtPictureNumber.setText(material.getPictureNumber());
/*      */ 
/* 5962 */       this.materialName.setText(material.getName());
/* 5963 */       this.kdtEntrys.getColumn("materialNumber").getStyleAttributes().setLocked(false);
/*      */ 
/* 5965 */       this.txtproductQty.setEditable(true);
/* 5966 */       String headMterialId = material.getId().toString();
/* 5967 */       MaterialInfo childMaterialInfo = null;
/* 5968 */       IRow optRow = null;
/* 5969 */       Object obj = null;
/* 5970 */       Object[] objVal = null;
/* 5971 */       for (int i = 0; i < this.kdtEntrys.getRowCount(); ++i) {
/* 5972 */         optRow = this.kdtEntrys.getRow(i);
/* 5973 */         obj = optRow.getCell("materialNumber").getValue();
/* 5974 */         if (obj instanceof Object[]) {
/* 5975 */           objVal = (Object[])(Object[])obj;
/* 5976 */           childMaterialInfo = (MaterialInfo)objVal[0];
/* 5977 */         } else if (obj instanceof Object) {
/* 5978 */           childMaterialInfo = (MaterialInfo)obj;
/*      */         }
/* 5980 */         if (childMaterialInfo != null) {
/* 5981 */           String childMterialId = childMaterialInfo.getId().toString();
/*      */ 
/* 5983 */           if (!(headMterialId.equals(childMterialId))) {
/*      */             continue;
/*      */           }
/*      */ 
/* 5987 */           this.kdtEntrys.removeRow(i);
/* 5988 */           break;
/*      */         }
/*      */       }
/*      */       try
/*      */       {
/* 5993 */         StorageOrgUnitInfo storageOrgInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 5995 */         MaterialInfo[] materialInfos = { material };
/* 5996 */         StorageOrgUnitInfo org = (StorageOrgUnitInfo)getMainBizOrg().getData();
/*      */ 
/* 5998 */         if ((null == storageOrgInfo) || (null == org)) {
/* 5999 */           return;
/*      */         }
/* 6001 */         SCMEntryDataVO voResult = UIHelper.getDataVO(org, materialInfos);
/*      */ 
/* 6003 */         material = voResult.getMaterialInfos()[0];
/* 6004 */         String key1 = material.getId().toString() + org.getId().toString();
/*      */ 
/* 6006 */         MaterialPlanInfo materialPlan = (MaterialPlanInfo)voResult.getMaterialPlanInfos().get(key1);
/*      */
/*      */ 
/* 6009 */         this.prmtMaterialPlan.setValue(materialPlan);
/*      */ 
/* 6011 */         if (materialPlan != null) {
/* 6012 */           initEntrysMaterialF7s(materialPlan);
/*      */ 
/* 6014 */           this.param.put(key1, materialPlan);
/*      */         }
/*      */         else {
/* 6017 */           MsgBox.showInfo(getResource("fatherMaterial_MaterialPlanNone"));
/* 6018 */           SysUtil.abort();
/*      */
/*      */         }
/*      */ 
/* 6022 */         MeasureUnitInfo prodUnit = voResult.getMeasureUnitInfos()[0];
/* 6023 */         this.prmtunit.setValue(prodUnit);
/* 6024 */         this.prmtBaseUnit.setValue(voResult.getBaseMeasureUnitInfos()[0]);
/* 6025 */         this.txtModel.setText(material.getModel());
/* 6026 */         BigDecimal yield = materialPlan.getYield();
/* 6027 */         if (yield == null) {
/* 6028 */           yield = new BigDecimal(100);
/*      */         }
/* 6030 */         this.txtYield.setValue(yield);
/* 6031 */         String key = material.getId().toString() + prodUnit.getId().toString();
/*      */ 
/* 6033 */         int unitPrec = 4;
/* 6034 */         if (voResult.getMmuPrecisions().get(key) != null) {
/* 6035 */           unitPrec = ((Integer)voResult.getMmuPrecisions().get(key)).intValue();
/*      */         }
/* 6037 */         this.txtproductQty.setPrecision(unitPrec);
/* 6038 */         key = material.getId().toString() + material.getBaseUnit().getId().toString();
/*      */ 
/* 6040 */         unitPrec = ((Integer)voResult.getMmuPrecisions().get(key)).intValue();
/*      */ 
/* 6042 */         this.txtBaseQty.setPrecision(unitPrec);
/*      */ 
/* 6044 */         if (this.cmbType.getSelectedItem() == BOMTypeEnum.OrderBOM) {
/* 6045 */           setProjectTrackStatus();
/*      */
/*      */         }
/* 6048 */         else if (this.cmbType.getSelectedItem() == BOMTypeEnum.CfgBOM) {
/* 6049 */           if (materialPlan.getManufactureStrategy() == null) {
/* 6050 */             return;
/*      */           }
/*      */ 
/* 6053 */           String id = materialPlan.getManufactureStrategy().getId().toString();
/*      */ 
/* 6055 */           this.chkIsProjectManu.setVisible(true);
/* 6056 */           this.contProject.setVisible(true);
/* 6057 */           Set projectTrackStrategySet = ManufactureStrategyGroup.getProjectTrackOrderBomStrategyIdSet();
/*      */ 
/* 6059 */           boolean isETO = projectTrackStrategySet.contains(id);
/* 6060 */           setChkIsProjectManuSelected(isETO);
/*      */ 
/* 6062 */           setChkIsProjectManuEnabled(true);
/*      */ 
/* 6064 */           productManuChanged(null);
/*      */
/*      */         }
/*      */ 
/* 6068 */         this.kdtEntrys.getColumn("materialNumber").getStyleAttributes().setLocked(false);
/*      */       }
/*      */       catch (Exception e1) {
/* 6071 */         handleException(e1);
/*      */       }
/*      */ 
/* 6074 */       this.prmtProject.setValue(null); } else {
/* 6075 */       if (e.getNewValue() != null)
/*      */         return;
/* 6077 */       this.txtModel.setText(null);
/* 6078 */       this.prmtunit.setValue(null);
/*      */ 
/* 6080 */       this.materialName.setText(null);
/*      */ 
/* 6082 */       this.txtYield.setValue(MMConstant.BIGDECIMAL_ZERO);
/* 6083 */       this.txtproductQty.setPrecision(this.precision);
/* 6084 */       this.txtproductQty.setValue(this.oneBigDecimal);
/*      */ 
/* 6086 */       this.prmtMaterialPlan.setValue(null);
/*      */ 
/* 6088 */       this.kdtEntrys.removeRows();
/*      */       try
/*      */       {
/* 6091 */         actionAddLine_actionPerformed(null);
/*      */       } catch (Exception e1) {
/* 6093 */         handUIException(e1);
/*      */       }
/*      */ 
/* 6096 */       refreshFootROw(this.kdtEntrys);
/* 6097 */       this.kdtEntrys.getColumn("materialNumber").getStyleAttributes().setLocked(true);
/*      */     }
/*      */   }
/*      */
/*      */   private void qtyChanged(DataChangeEvent e)
/*      */   {
/* 6103 */     StorageOrgUnitInfo org = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 6105 */     MaterialInfo material = (MaterialInfo)this.prmtmaterial.getValue();
/* 6106 */     MeasureUnitInfo unit = (MeasureUnitInfo)this.prmtunit.getValue();
/* 6107 */     MaterialInfo[] materialInfos = { material };
/* 6108 */     SCMEntryDataVO voResult = null;
/* 6109 */     if ((null == org) || (null == material))
/* 6110 */       return;
/*      */     try
/*      */     {
/* 6113 */       voResult = UIHelper.getDataVO(org, materialInfos);
/*      */     } catch (Exception e1) {
/* 6115 */       handleException(e1);
/*      */     }
/* 6117 */     if ((e.getNewValue() == null) || (material == null) || (unit == null) || (voResult == null))
/*      */       return;
/* 6119 */     String key = material.getId().toString() + unit.getId().toString();
/* 6120 */     if (voResult.getMmuConvsRate().get(key) != null) {
/* 6121 */       this.oneBigDecimal = ((BigDecimal)voResult.getMmuConvsRate().get(key));
/*      */     }
/*      */ 
/* 6124 */     BigDecimal qty = this.txtproductQty.getBigDecimalValue();
/*      */ 
/* 6126 */     BigDecimal baseQty = qty.multiply(this.oneBigDecimal);
/* 6127 */     this.txtBaseQty.setValue(baseQty);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setBomTypeStatus(boolean enabled)
/*      */   {
/* 6157 */     this.cmbType.setAccessAuthority(0);
/*      */ 
/* 6159 */     this.cmbType.setEnabled(enabled);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void initUserConfig()
/*      */   {
/* 6175 */     super.initUserConfig();
/* 6176 */     hideTrackNumColumn();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initDialogFace()
/*      */   {
/* 6189 */     filterSubMaterial();
/*      */ 
/* 6191 */     if ((this.cmbType.getSelectedItem() == BOMTypeEnum.MfgBOM) || (this.cmbType.getSelectedItem() == BOMTypeEnum.ScheduleBOM) || (this.cmbType.getSelectedItem() == BOMTypeEnum.BudgetBOM))
/*      */
/*      */
/*      */     {
/* 6195 */       this.prmtTrack.setVisible(false);
/* 6196 */       this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setHided(true);
/*      */ 
/* 6198 */       this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setLocked(true);
/*      */ 
/* 6200 */       this.conttrackNum_p.setVisible(false);
/* 6201 */       this.kdtEntrys.getColumn("firstCfg").getStyleAttributes().setHided(true);
/*      */ 
/* 6203 */       this.kdtEntrys.getColumn("feture").getStyleAttributes().setHided(true);
/*      */ 
/* 6205 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(true);
/*      */ 
/* 6207 */       this.kDLabelContainer14.setVisible(true);
/* 6208 */       this.cmbCfgOption.setVisible(true);
/* 6209 */       this.cmbCfgOption.setEnabled(false);
/* 6210 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(true);
/*      */ 
/* 6212 */       this.kDLabelContainer14.setVisible(false);
/* 6213 */       this.cmbUsage.setEnabled(true);
/*      */ 
/* 6215 */       this.prmtProject.setValue(null);
/* 6216 */       this.contProject.setVisible(false);
/* 6217 */       this.chkIsProjectManu.setVisible(false);
/* 6218 */       this.chkIsProjectManu.setSelected(false);
/*      */ 
/* 6220 */       this.btnViewTrackNumber.setVisible(false);
/* 6221 */       this.menuViewTrackNumber.setVisible(false);
/*      */
/*      */     }
/* 6224 */     else if (this.cmbType.getSelectedItem() == BOMTypeEnum.CfgBOM) {
/* 6225 */       this.prmtTrack.setVisible(false);
/* 6226 */       this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setHided(false);
/*      */ 
/* 6228 */       this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setLocked(false);
/*      */ 
/* 6230 */       this.conttrackNum_p.setVisible(false);
/* 6231 */       this.kdtEntrys.getColumn("firstCfg").getStyleAttributes().setHided(false);
/*      */ 
/* 6233 */       this.kdtEntrys.getColumn("feture").getStyleAttributes().setHided(false);
/*      */ 
/* 6235 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(false);
/*      */ 
/* 6237 */       this.kDLabelContainer14.setVisible(true);
/* 6238 */       this.cmbCfgOption.setVisible(true);
/* 6239 */       this.cmbCfgOption.setEnabled(false);
/* 6240 */       this.kDLabelContainer14.setVisible(true);
/* 6241 */       this.cmbCfgOption.setVisible(true);
/* 6242 */       this.cmbUsage.setAccessAuthority(0);
/* 6243 */       this.cmbUsage.setEnabled(false);
/*      */
/*      */ 
/* 6246 */       this.chkIsProjectManu.setVisible(true);
/* 6247 */       this.contProject.setVisible(true);
/*      */
/*      */
/*      */ 
/* 6251 */       this.btnViewTrackNumber.setVisible(true);
/* 6252 */       this.menuViewTrackNumber.setVisible(true);
/* 6253 */       Icon viewTrackNumberIcon = com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_integralitycheck");
/*      */ 
/* 6255 */       this.btnViewTrackNumber.setIcon(viewTrackNumberIcon);
/* 6256 */       this.menuViewTrackNumber.setIcon(viewTrackNumberIcon);
/*      */     }
/*      */     else
/*      */     {
/* 6260 */       this.contProject.setVisible(true);
/* 6261 */       this.prmtTrack.setVisible(true);
/* 6262 */       this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setHided(true);
/*      */ 
/* 6264 */       this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setLocked(true);
/*      */ 
/* 6266 */       this.conttrackNum_p.setVisible(true);
/*      */ 
/* 6268 */       this.cmbType.setEditable(false);
/* 6269 */       this.cmbType.setEnabled(false);
/* 6270 */       if (("EDIT".equals(getOprtState())) || ("VIEW".equals(getOprtState())))
/*      */       {
/* 6272 */         showItems();
/*      */       }
/*      */       else this.kDLabelContainer14.setVisible(true);
/*      */ 
/* 6276 */       this.cmbCfgOption.setVisible(true);
/*      */ 
/* 6278 */       this.btnViewTrackNumber.setVisible(true);
/* 6279 */       this.menuViewTrackNumber.setVisible(true);
/* 6280 */       Icon viewTrackNumberIcon = com.kingdee.eas.mm.common.client.MMUtils.getNewIcon("imgTbtn_integralitycheck");
/*      */ 
/* 6282 */       this.btnViewTrackNumber.setIcon(viewTrackNumberIcon);
/* 6283 */       this.menuViewTrackNumber.setIcon(viewTrackNumberIcon);
/*      */ 
/* 6285 */       setUITitle(getResource("orderBom_addNew"));
/*      */       try {
/* 6287 */         setProjectTrackStatus();
/*      */       } catch (EASBizException e) {
/* 6289 */         handUIException(e);
/*      */       } catch (BOSException e) {
/* 6291 */         handUIException(e);
/*      */       }
/*      */     }
/* 6294 */     productManuChanged(null);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initOtherF7()
/*      */     throws Exception
/*      */   {
/* 6309 */     if ((isFirstOnload()) && 
/* 6310 */       (this.prmtBomGroup.getSelectorListeners() != null)) {
/* 6311 */       for (int i = 0; i < this.prmtBomGroup.getSelectorListeners().length; ++i) {
/* 6312 */         this.prmtBomGroup.removeSelectorListener(this.prmtBomGroup.getSelectorListeners()[i]);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 6317 */     this.prmtBomGroup.setQueryInfo("com.kingdee.eas.mm.basedata.app.BomGroupstandardQuery");
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void showSuccessMsg(String msgResource)
/*      */   {
/* 6346 */     setMessageText(msgResource);
/* 6347 */     showMessage();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void prmtstorageOrgUnit_preChange(PreChangeEvent e)
/*      */   {
/* 6360 */     Object newData = e.getData();
/* 6361 */     if (newData != null) {
/* 6362 */       return;
/*      */     }
/* 6364 */     MsgBox.showInfo(getResource("storageOrgUnit_Required"));
/* 6365 */     Object oldOrg = e.getOldData();
/*      */ 
/* 6367 */     this.editData.setStorageOrgUnit((StorageOrgUnitInfo)oldOrg);
/* 6368 */     this.prmtstorageOrgUnit.setValue(oldOrg);
/* 6369 */     this.prmtBomGroup.requestFocus(true);
/* 6370 */     if (getUIContext().get(getMainBizOrgType()) == null) {
/* 6371 */       getUIContext().put(getMainBizOrgType(), (StorageOrgUnitInfo)oldOrg);
/*      */     }
/*      */ 
/* 6374 */     e.setResult(0);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void showItems()
/*      */   {
/* 6387 */     MaterialInfo material = this.editData.getMaterial();
/* 6388 */     if ((material == null) || (this.editData.getStorageOrgUnit() == null)) {
/* 6389 */       return;
/*      */     }
/* 6391 */     MaterialPlanInfo planInfo = this.editData.getMaterialPlan();
/* 6392 */     if ((planInfo != null) && (planInfo.isIsConfigable())) {
/* 6393 */       this.cmbCfgOption.setVisible(true);
/* 6394 */       this.kDLabelContainer14.setVisible(true);
/* 6395 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(false);
/*      */ 
/* 6397 */       this.kdtEntrys.getColumn("firstCfg").getStyleAttributes().setHided(false);
/*      */ 
/* 6399 */       this.kdtEntrys.getColumn("feture").getStyleAttributes().setHided(false);
/*      */     }
/*      */     else {
/* 6402 */       this.cmbCfgOption.setVisible(false);
/* 6403 */       this.kDLabelContainer14.setVisible(false);
/* 6404 */       this.kdtEntrys.getColumn("canSelected").getStyleAttributes().setHided(true);
/*      */ 
/* 6406 */       this.kdtEntrys.getColumn("firstCfg").getStyleAttributes().setHided(true);
/*      */ 
/* 6408 */       this.kdtEntrys.getColumn("feture").getStyleAttributes().setHided(true);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String toSqlString(Set set)
/*      */   {
/* 6425 */     StringBuffer sb = new StringBuffer();
/* 6426 */     Iterator it = set.iterator();
/* 6427 */     while (it.hasNext()) {
/* 6428 */       sb.append("'").append(it.next().toString()).append("',");
/*      */     }
/* 6430 */     return sb.substring(0, sb.length() - 1);
/*      */   }
/*      */
/*      */   private String[] getSumColNames()
/*      */   {
/* 6435 */     return new String[] { "proportion", "consumeFixQty" };
/*      */   }
/*      */
/*      */
/*      */
/*      */   private void setNullWhenCopyBOM()
/*      */   {
/* 6442 */     this.editData.setIsAssigned(false);
/* 6443 */     this.editData.setAssigner(null);
/* 6444 */     this.editData.setAssignTime(null);
/* 6445 */     this.editData.setSourceBomId(null);
/* 6446 */     this.editData.setSourceBomNumber(null);
/* 6447 */     this.editData.setSourceSOU(null);
/* 6448 */     if ((this.editData.getEntrys() != null) && (this.editData.getEntrys().size() > 0))
/*      */     {
/* 6450 */       int i = 0; for (int length = this.editData.getEntrys().size(); i < length; ++i) {
/* 6451 */         this.editData.getEntrys().get(i).setIsAssigned(false);
/*      */       }
/*      */     }
/* 6454 */     this.prmtstorageOrgUnit.setAccessAuthority(0);
/*      */ 
/* 6456 */     this.txtName.setAccessAuthority(0);
/* 6457 */     this.cmbType.setAccessAuthority(0);
/* 6458 */     this.cmbUsage.setAccessAuthority(0);
/* 6459 */     this.prmtmaterial.setAccessAuthority(0);
/*      */
/*      */ 
/* 6462 */     this.txtYield.setEditable(true);
/* 6463 */     this.txtproductQty.setEditable(true);
/*      */   }
/*      */
/*      */   public boolean isModify()
/*      */   {
/* 6468 */     Boolean isNewFromTree = (Boolean)getUIContext().get("isNewFromTree");
/* 6469 */     if (Boolean.TRUE.equals(isNewFromTree)) {
/* 6470 */       this.isUpdate = false;
/* 6471 */       return false;
/*      */     }
/* 6473 */     return super.isModify();
/*      */   }
/*      */
/*      */
/*      */   private void addNewFromTree(MaterialInfo material, BOMUsageEnum usageType, ProjectInfo project, TrackNumberCollection trackNumberColl, boolean isOrderBom)
/*      */     throws Exception
/*      */   {
/* 6480 */     this.prmtProject.setValue(null);
/* 6481 */     this.prmtTrack.setValue(null);
/* 6482 */     this.editData = null;
/*      */ 
/* 6484 */     getUIContext().put("isNewFromTree", Boolean.TRUE);
/* 6485 */     super.actionAddNew_actionPerformed(null);
/* 6486 */     getUIContext().put("isNewFromTree", Boolean.FALSE);
/*      */ 
/* 6488 */     String strParam = (String)getUIContext().get("UIClassParam");
/* 6489 */     if (strParam != null) {
/* 6490 */       if ((strParam.equals("1")) && (isOrderBom)) {
/* 6491 */         this.cmbType.setSelectedItem(BOMTypeEnum.OrderBOM);
/* 6492 */         setBomTypeStatus(false);
/* 6493 */         this.prmtProject.setValue(null);
/* 6494 */         this.prmtTrack.setValue(null);
/* 6495 */         this.kDLabelContainer14.setVisible(true);
/* 6496 */         this.cmbCfgOption.setVisible(true);
/* 6497 */       } else if (!(isOrderBom)) {
/* 6498 */         this.cmbType.setSelectedItem(BOMTypeEnum.MfgBOM);
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 6504 */       MaterialPlanInfo planInfo = getMaterialPlanInfo(material);
/* 6505 */       if ((planInfo != null) && (planInfo.isIsConfigable()))
/* 6506 */         this.cmbType.setSelectedItem(BOMTypeEnum.CfgBOM);
/*      */       else {
/* 6508 */         this.cmbType.setSelectedItem(BOMTypeEnum.MfgBOM);
/*      */       }
/*      */     }
/*      */ 
/* 6512 */     if (this.cmbType.getSelectedItem() == BOMTypeEnum.OrderBOM) {
/* 6513 */       this.kDLabelContainer14.setVisible(true);
/* 6514 */       this.cmbCfgOption.setVisible(true);
/*      */     }
/* 6516 */     if (this.cmbType.getSelectedItem() == BOMTypeEnum.MfgBOM) {
/* 6517 */       this.cmbUsage.setEnabled(true);
/*      */     }
/* 6519 */     initDialogFace();
/*      */
/*      */ 
/* 6522 */     if (material != null) {
/* 6523 */       this.prmtmaterial.setValue(material);
/* 6524 */       this.prmtmaterial.setAccessAuthority(1);
/*      */     }
/*      */     else {
/* 6527 */       this.prmtmaterial.setAccessAuthority(0);
/*      */
/*      */
/*      */     }
/*      */ 
/* 6532 */     if (usageType != null) {
/* 6533 */       this.cmbUsage.setSelectedItem(usageType);
/* 6534 */       this.cmbUsage.setEnabled(false);
/*      */     } else {
/* 6536 */       this.cmbUsage.setEnabled(true);
/*      */
/*      */     }
/*      */ 
/* 6540 */     if (project != null) {
/* 6541 */       this.prmtProject.setValue(project);
/*      */     }
/* 6543 */     if (trackNumberColl != null)
/* 6544 */       this.prmtTrack.setValue(trackNumberColl.toArray());
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void handleMaterailFilterInfo()
/*      */   {
/* 6568 */     StorageOrgUnitInfo orgInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 6570 */     if (orgInfo == null) {
/* 6571 */       return;
/*      */     }
/* 6573 */     FilterInfo filter = new FilterInfo();
/* 6574 */     filter.getFilterItems().add(new FilterItemInfo("status", new Integer(1), CompareType.EQUALS));
/*      */
/*      */ 
/* 6577 */     filter.getFilterItems().add(new FilterItemInfo("StorageOrgUnit.id", orgInfo.getId().toString(), CompareType.EQUALS));
/*      */
/*      */ 
/* 6580 */     filter.getFilterItems().add(new FilterItemInfo("Inventory.status", new Integer(1), CompareType.EQUALS));
/*      */
/*      */ 
/* 6583 */     Integer materialAttr = new Integer(10020);
/*      */ 
/* 6585 */     filter.getFilterItems().add(new FilterItemInfo("plan.materialAttr", materialAttr, CompareType.EQUALS));
/*      */
/*      */ 
/* 6588 */     String sMask = "#0 and #1 and (#2 or #3)";
/*      */ 
/* 6590 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/* 6591 */     if (bomType == null) {
/* 6592 */       bomType = BOMTypeEnum.MfgBOM;
/*      */     }
/*      */ 
/* 6595 */     if (BOMTypeEnum.CfgBOM.equals(bomType)) {
/* 6596 */       filter.getFilterItems().add(new FilterItemInfo("plan.isConfigable", new Boolean(true), CompareType.EQUALS));
/*      */
/*      */ 
/* 6599 */       sMask = sMask + " and #4";
/*      */
/*      */     }
/* 6602 */     else if (BOMTypeEnum.MfgBOM.equals(bomType)) {
/* 6603 */       filter.getFilterItems().add(new FilterItemInfo("plan.isConfigable", new Boolean(false), CompareType.EQUALS));
/*      */
/*      */ 
/* 6606 */       sMask = sMask + " and #4";
/*      */
/*      */     }
/* 6609 */     else if (BOMTypeEnum.OrderBOM.equals(bomType))
/*      */     {
/* 6611 */       Set orderBomStrategyIdSet = ManufactureStrategyGroup.getOrderBomStrategyIdSet();
/*      */ 
/* 6613 */       filter.getFilterItems().add(new FilterItemInfo("manufactureStrategy.id", orderBomStrategyIdSet, CompareType.INCLUDE));
/*      */
/*      */ 
/* 6616 */       sMask = sMask + " and #4";
/*      */     }
/* 6618 */     filter.setMaskString(sMask);
/* 6619 */     EntityViewInfo view = new EntityViewInfo();
/* 6620 */     view.setFilter(filter);
/* 6621 */     this.prmtmaterial.setEntityViewInfo(view);
/* 6622 */     this.prmtmaterial.getQueryAgent().resetRuntimeEntityView();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private SorterItemCollection getSortter()
/*      */   {
/* 6634 */     SorterItemCollection sic = new SorterItemCollection();
/*      */ 
/* 6636 */     String strParam = (String)getUIContext().get("UIClassParam");
/* 6637 */     if (("1".equals(strParam)) || (this.isOrderBomTree)) {
/* 6638 */       sic.add(new SorterItemInfo("orderBomTP.projectId"));
/* 6639 */       sic.add(new SorterItemInfo("orderBomTP.trackId"));
/*      */ 
/* 6641 */       sic.add(new SorterItemInfo("entrys.seq"));
/*      */     }
/* 6643 */     return sic;
/*      */   }
/*      */
/*      */   private void setOrderBomAssignStatus(boolean flag) {
/* 6647 */     this.actionAssign.setEnabled(flag);
/* 6648 */     this.actionAssignLog.setEnabled(false);
/* 6649 */     this.btnAssign.setEnabled(flag);
/* 6650 */     this.btnAssign.setVisible(flag);
/* 6651 */     this.btnAssignLog.setEnabled(false);
/* 6652 */     this.btnAssignLog.setVisible(false);
/* 6653 */     this.menuItemAssign.setEnabled(flag);
/* 6654 */     this.menuItemAssign.setVisible(flag);
/* 6655 */     this.menuItemAssignLog.setEnabled(false);
/* 6656 */     this.menuItemAssignLog.setVisible(false);
/* 6657 */     this.actionAssignLook.setEnabled(flag);
/* 6658 */     this.btnAssignLook.setEnabled(flag);
/* 6659 */     this.btnAssignLook.setVisible(flag);
/* 6660 */     this.menuItemAssignLook.setEnabled(flag);
/* 6661 */     this.menuItemAssignLook.setVisible(flag);
/*      */
/*      */ 
/* 6664 */     this.chkMenuItemBatchAssign.setEnabled(flag);
/* 6665 */     this.chkMenuItemBatchAssign.setVisible(flag);
/*      */   }
/*      */
/*      */   private void setPushDownStatus(boolean flag) {
/* 6669 */     this.actionPushDown.setEnabled(flag);
/* 6670 */     this.btnPushDown.setEnabled(flag);
/* 6671 */     this.btnPushDown.setVisible(flag);
/* 6672 */     this.menuPushDown.setEnabled(flag);
/* 6673 */     this.menuPushDown.setVisible(flag);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setButtonAndFieldsEnabled(boolean isEnabled)
/*      */   {
/* 6695 */     this.actionAddLine.setEnabled(isEnabled);
/* 6696 */     this.actionInsertLine.setEnabled(isEnabled);
/* 6697 */     this.actionRemoveLine.setEnabled(isEnabled);
/* 6698 */     this.actionCopyLine.setEnabled(isEnabled);
/*      */ 
/* 6700 */     this.txtYield.setEnabled(isEnabled);
/*      */
/*      */ 
/* 6703 */     String manufactureStrategyId = "NUnM+gEcEADgAA3cwKgL09g0uEU=";
/* 6704 */     MaterialInfo mi = (MaterialInfo)this.prmtmaterial.getValue();
/* 6705 */     if (mi != null) {
/* 6706 */       StorageOrgUnitInfo storageInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 6708 */       String materialId = mi.getId().toString();
/* 6709 */       String orgId = storageInfo.getId().toString();
/* 6710 */       String key = materialId + orgId;
/* 6711 */       MaterialPlanInfo materialPlan = null;
/* 6712 */       if (this.materialPlanMap.containsKey(key))
/* 6713 */         materialPlan = (MaterialPlanInfo)this.materialPlanMap.get(key);
/*      */       else {
/* 6715 */         materialPlan = getMaterialPlanInfo(mi);
/*      */       }
/* 6717 */       if ((materialPlan != null) && (materialPlan.getManufactureStrategy() != null))
/*      */       {
/* 6719 */         manufactureStrategyId = materialPlan.getManufactureStrategy().getId().toString();
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 6724 */     setPrmtProjectEnabledByStrategy(manufactureStrategyId);
/*      */ 
/* 6726 */     this.kdtEntrys.getColumn("trackNum").getStyleAttributes().setLocked(!(isEnabled));
/*      */ 
/* 6728 */     this.kdtEntrys.getColumn("materialNumber").getStyleAttributes().setLocked(!(isEnabled));
/*      */ 
/* 6730 */     this.kdtEntrys.getColumn("consumeType").getStyleAttributes().setLocked(!(isEnabled));
/*      */ 
/* 6732 */     this.kdtEntrys.getColumn("consumeFixQty").getStyleAttributes().setLocked(!(isEnabled));
/*      */ 
/* 6734 */     this.kdtEntrys.getColumn("proportion").getStyleAttributes().setLocked(!(isEnabled));
/*      */ 
/* 6736 */     this.kdtEntrys.getColumn("effectiveDate").getStyleAttributes().setLocked(!(isEnabled));
/*      */ 
/* 6738 */     this.kdtEntrys.getColumn("disableDate").getStyleAttributes().setLocked(!(isEnabled));
/*      */
/*      */ 
/* 6741 */     if (!(isEnabled)) {
/* 6742 */       KDTableHelper.downArrowAutoAddRow(this.kdtEntrys, false, null);
/* 6743 */       KDTableHelper.updateEnterWithTab(this.kdtEntrys, false, null);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkToolButtonState()
/*      */     throws BOSException, EASBizException
/*      */   {
/* 6759 */     BillBaseStatusEnum status = this.editData.getBaseStatus();
/*      */ 
/* 6761 */     if (((!(BillBaseStatusEnum.TEMPORARILYSAVED.equals(status))) && (!(BillBaseStatusEnum.SUBMITED.equals(status)))) || 
/*      */
/*      */
/* 6764 */       (!(this.cmbType.getSelectedItem().equals(BOMTypeEnum.CfgBOM))))
/*      */       return;
/* 6766 */     Boolean saleBom = (Boolean)this.param.get("CONFIGBOM_SALEBOM");
/* 6767 */     if (saleBom == null) {
/* 6768 */       saleBom = Boolean.FALSE;
/*      */     }
/* 6770 */     this.hasOrderBomFormCfgBom = saleBom.booleanValue();
/*      */ 
/* 6772 */     if (this.hasOrderBomFormCfgBom) {
/* 6773 */       Boolean isCreateOrderBom = (Boolean)this.param.get("CFGBOM_CREATE_ORDERBOM");
/*      */ 
/* 6775 */       if (isCreateOrderBom == null) {
/* 6776 */         isCreateOrderBom = Boolean.FALSE;
/*      */       }
/*      */ 
/* 6779 */       this.hasOrderBomFormCfgBom = isCreateOrderBom.booleanValue();
/*      */     }
/*      */ 
/* 6782 */     if (this.hasOrderBomFormCfgBom) {
/* 6783 */       setButtonAndFieldsEnabled(false);
/*      */ 
/* 6785 */       this.chkIsProjectManu.setEnabled(false);
/*      */     } else {
/* 6787 */       setButtonAndFieldsEnabled(true);
/*      */ 
/* 6789 */       if (!(this.editData.isIsAssigned()))
/* 6790 */         this.chkIsProjectManu.setEnabled(true);
/*      */       else
/* 6792 */         this.chkIsProjectManu.setEnabled(false);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void productManuChanged(ActionEvent e)
/*      */   {
/* 6811 */     boolean enabled = isPrmtProjectEnabled();
/*      */ 
/* 6813 */     setF7Enabled(this.prmtProject, enabled);
/*      */
/*      */ 
/* 6816 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/* 6817 */     if (bomType.equals(BOMTypeEnum.CfgBOM))
/* 6818 */       if (this.chkIsProjectManu.isSelected()) {
/* 6819 */         this.prmtProject.setRequired(true);
/*      */       } else {
/* 6821 */         this.prmtProject.setValue(null);
/* 6822 */         this.prmtProject.setRequired(false);
/* 6823 */         this.projectInfo = null;
/* 6824 */         this.trackMap = null;
/*      */       }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void loadfields_cfgBom()
/*      */     throws BOSException, EASBizException
/*      */   {
/* 6840 */     BOMTypeEnum bomType = this.editData.getBomType();
/*      */ 
/* 6842 */     if (!(bomType.equals(BOMTypeEnum.CfgBOM))) {
/* 6843 */       return;
/*      */     }
/*      */ 
/* 6846 */     if (this.editData.getId() == null) {
/* 6847 */       this.prmtProject.setValue(this.projectInfo);
/* 6848 */       Object trackObj = null;
/* 6849 */       for (int j = 0; j < this.kdtEntrys.getRowCount(); ++j) {
/* 6850 */         trackObj = null;
/* 6851 */         if (this.trackMap != null) {
/* 6852 */           trackObj = this.trackMap.get(String.valueOf(j));
/*      */         }
/* 6854 */         this.kdtEntrys.getCell(j, "trackNum").setValue(trackObj);
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 6859 */       ProjectInfo pjInfo = this.editData.getProject();
/*      */ 
/* 6861 */       if ((pjInfo != null) && (!(this.chkIsProjectManu.isSelected()))) {
/* 6862 */         this.chkIsProjectManu.setSelected(true);
/*      */       }
/* 6864 */       this.prmtProject.setValue(pjInfo);
/*      */ 
/* 6866 */       int rowNum = this.kdtEntrys.getRowCount();
/* 6867 */       Map entryIdTrackMap = (Map)this.param.get("CFGBOMPT_TRACK");
/* 6868 */       if ((entryIdTrackMap == null) || (entryIdTrackMap.size() == 0)) {
/* 6869 */         return;
/*      */       }
/* 6871 */       IRow row = null;
/* 6872 */       String entryId = null;
/* 6873 */       List trackList = null;
/* 6874 */       BOSUuid uuid = null;
/*      */ 
/* 6876 */       for (int i = 0; i < rowNum; ++i) {
/* 6877 */         row = this.kdtEntrys.getRow(i);
/*      */ 
/* 6879 */         row.getCell("trackNum").setValue(null);
/* 6880 */         row = this.kdtEntrys.getRow(i);
/* 6881 */         uuid = (BOSUuid)row.getCell("id").getValue();
/* 6882 */         if (uuid == null) {
/*      */           continue;
/*      */         }
/* 6885 */         entryId = uuid.toString();
/* 6886 */         if (entryIdTrackMap.containsKey(entryId)) {
/* 6887 */           trackList = (List)entryIdTrackMap.get(entryId);
/* 6888 */           row.getCell("trackNum").setValue(trackList.toArray());
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void loadfields_orderBom()
/*      */     throws BOSException, EASBizException
/*      */   {
/* 6908 */     BOMTypeEnum bomType = this.editData.getBomType();
/* 6909 */     if (!(bomType.equals(BOMTypeEnum.OrderBOM))) {
/* 6910 */       return;
/*      */     }
/*      */ 
/* 6913 */     if (this.editData.getId() == null) {
/* 6914 */       this.prmtProject.setValue(this.projectInfo);
/* 6915 */       Object trackObj = null;
/* 6916 */       if (this.trackMap != null) {
/* 6917 */         trackObj = this.trackMap.get("_bomCopy");
/*      */       }
/* 6919 */       this.prmtTrack.setValue(trackObj);
/*      */     }
/*      */     else
/*      */     {
/* 6923 */       ProjectInfo pjInfo = (ProjectInfo)this.param.get("ORDERBOMPT_PROJECT");
/*      */ 
/* 6925 */       this.prmtProject.setValue(pjInfo);
/* 6926 */       List trackList = (List)this.param.get("ORDERBOMPT_TRACK");
/* 6927 */       if ((trackList == null) || (trackList.size() == 0))
/* 6928 */         this.prmtTrack.setValue(null);
/*      */       else
/* 6930 */         this.prmtTrack.setValue(trackList.toArray());
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setPrjTrackOfOrderBom()
/*      */   {
/* 6947 */     Object prjObj = this.prmtProject.getValue();
/* 6948 */     String prjId = null;
/* 6949 */     if (prjObj != null) {
/* 6950 */       ProjectInfo pjInfo = (ProjectInfo)prjObj;
/* 6951 */       prjId = pjInfo.getId().toString();
/*      */     }
/* 6953 */     OrderBOMPTCollection bomPt = new OrderBOMPTCollection();
/*      */
/*      */ 
/* 6956 */     TrackNumberInfo[] tnis = getTrackNumberOfOrderBom();
/* 6957 */     OrderBOMPTInfo ptInfo = null;
/*      */ 
/* 6959 */     if ((com.kingdee.eas.mm.common.client.MMUtils.isNull(prjId)) && (com.kingdee.eas.mm.common.client.MMUtils.isNull(tnis)))
/*      */     {
/* 6961 */       bomPt = null;
/*      */
/*      */     }
/* 6964 */     else if (com.kingdee.eas.mm.common.client.MMUtils.isNull(tnis)) {
/* 6965 */       ptInfo = new OrderBOMPTInfo();
/* 6966 */       ptInfo.setProjectId(prjId);
/* 6967 */       ptInfo.setTrackId(null);
/* 6968 */       bomPt.add(ptInfo);
/*      */     }
/*      */     else
/*      */     {
/* 6972 */       TrackNumberInfo tni = null;
/* 6973 */       for (int i = 0; i < tnis.length; ++i) {
/* 6974 */         tni = tnis[i];
/* 6975 */         ptInfo = new OrderBOMPTInfo();
/* 6976 */         ptInfo.setProjectId(prjId);
/* 6977 */         ptInfo.setTrackId(tni.getId().toString());
/* 6978 */         bomPt.add(ptInfo);
/*      */       }
/*      */     }
/* 6981 */     if (this.editData != null) {
/* 6982 */       this.editData.put("orderBomTP", bomPt);
/* 6983 */       this.editData.setIsProjectManu(false);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setPrjTrackOfCfgBom()
/*      */   {
/* 6999 */     Object prjObj = this.prmtProject.getValue();
/* 7000 */     String defaultValue = "999999999";
/* 7001 */     String prjId = null;
/* 7002 */     ProjectInfo pjInfo = null;
/* 7003 */     if (prjObj != null) {
/* 7004 */       pjInfo = (ProjectInfo)prjObj;
/* 7005 */       prjId = pjInfo.getId().toString();
/*      */     } else {
/* 7007 */       prjId = defaultValue;
/*      */     }
/* 7009 */     this.editData.setProject(pjInfo);
/* 7010 */     BomEntryCollection entry = this.editData.getEntrys();
/* 7011 */     BOMPTCollection collection = null;
/* 7012 */     BOMPTInfo ptInfo = null;
/* 7013 */     BomEntryInfo entryInfo = null;
/* 7014 */     TrackNumberInfo[] tnis = null;
/* 7015 */     for (int i = 0; i < entry.size(); ++i) {
/* 7016 */       collection = null;
/* 7017 */       entryInfo = entry.get(i);
/* 7018 */       tnis = getEntryTrackNumberOfCfgBom(i);
/*      */ 
/* 7020 */       if (com.kingdee.eas.mm.common.client.MMUtils.isNotNull(tnis)) {
/* 7021 */         collection = new BOMPTCollection();
/* 7022 */         for (int j = 0; j < tnis.length; ++j) {
/* 7023 */           ptInfo = new BOMPTInfo();
/* 7024 */           ptInfo.setFProjectID(prjId);
/* 7025 */           ptInfo.setFTrackID(tnis[j].getId().toString());
/* 7026 */           collection.add(ptInfo);
/*      */         }
/*      */ 
/* 7029 */         entryInfo.put("trackNumbers", collection);
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private TrackNumberInfo[] getEntryTrackNumberOfCfgBom(int rowIndex)
/*      */   {
/* 7048 */     TrackNumberInfo[] tnis = null;
/* 7049 */     Object trackNumObj = this.kdtEntrys.getCell(rowIndex, "trackNum").getValue();
/*      */ 
/* 7051 */     if (com.kingdee.eas.mm.common.client.MMUtils.isNull(trackNumObj)) {
/* 7052 */       return null;
/*      */     }
/* 7054 */     if (trackNumObj instanceof TrackNumberInfo) {
/* 7055 */       tnis = new TrackNumberInfo[] { (TrackNumberInfo)trackNumObj };
/* 7056 */     } else if (trackNumObj instanceof TrackNumberInfo[]) {
/* 7057 */       tnis = (TrackNumberInfo[])(TrackNumberInfo[])trackNumObj;
/* 7058 */     } else if (trackNumObj instanceof Object[]) {
/* 7059 */       Object[] objs = (Object[])(Object[])trackNumObj;
/* 7060 */       tnis = new TrackNumberInfo[objs.length];
/* 7061 */       System.arraycopy(objs, 0, tnis, 0, objs.length);
/*      */     }
/*      */ 
/* 7064 */     return tnis;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean hasTrackNumber()
/*      */   {
/* 7083 */     int rowNum = this.kdtEntrys.getRowCount();
/* 7084 */     if (rowNum == 0) {
/* 7085 */       return false;
/*      */     }
/* 7087 */     boolean rst = false;
/* 7088 */     Object trackObj = null;
/* 7089 */     for (int j = 0; j < rowNum; ++j) {
/* 7090 */       trackObj = this.kdtEntrys.getCell(j, "trackNum").getValue();
/* 7091 */       if (com.kingdee.eas.mm.common.client.MMUtils.isNotNull(trackObj)) {
/* 7092 */         rst = true;
/* 7093 */         break;
/*      */       }
/*      */     }
/*      */ 
/* 7097 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setProjectTrackStatus()
/*      */     throws EASBizException, BOSException
/*      */   {
/* 7113 */     if (!(this.cmbType.getSelectedItem().equals(BOMTypeEnum.OrderBOM))) {
/* 7114 */       return;
/*      */     }
/* 7116 */     if (this.prmtmaterial.getValue() == null) {
/* 7117 */       return;
/*      */     }
/* 7119 */     MaterialInfo mi = (MaterialInfo)this.prmtmaterial.getValue();
/* 7120 */     StorageOrgUnitInfo orgUnitInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 7122 */     String materialId = mi.getId().toString();
/* 7123 */     String orgId = orgUnitInfo.getId().toString();
/* 7124 */     String key = materialId + orgId;
/* 7125 */     MaterialPlanInfo materialPlan = null;
/* 7126 */     if (this.materialPlanMap.containsKey(key))
/* 7127 */       materialPlan = (MaterialPlanInfo)this.materialPlanMap.get(key);
/*      */     else {
/* 7129 */       materialPlan = getMaterialPlanInfo(mi);
/*      */     }
/*      */ 
/* 7132 */     if ((materialPlan.getManufactureStrategy() == null) || (materialPlan.getManufactureStrategy().getId() == null))
/*      */     {
/* 7134 */       MsgBox.showInfo(getResource("material_manufacture_is_null"));
/* 7135 */       SysUtil.abort();
/*      */     }
/*      */ 
/* 7138 */     String strategyId = materialPlan.getManufactureStrategy().getId().toString();
/*      */ 
/* 7140 */     Set projectTrackStrategyIdSet = ManufactureStrategyGroup.getProjectTrackOrderBomStrategyIdSet();
/*      */ 
/* 7142 */     Set trackStrategyIdSet = ManufactureStrategyGroup.getTrackOrderBomStrategyIdSet();
/*      */ 
/* 7144 */     boolean projectEnabled = true;
/* 7145 */     boolean trackEnabled = true;
/* 7146 */     this.prmtProject.setRequired(false);
/* 7147 */     this.prmtTrack.setRequired(false);
/* 7148 */     if (projectTrackStrategyIdSet.contains(strategyId))
/*      */     {
/* 7150 */       IsolatedRuleEnum isolateRule = materialPlan.getIsolatedRule();
/* 7151 */       if (IsolatedRuleEnum.ITEM_TRACKNO.equals(isolateRule))
/*      */       {
/* 7153 */         this.prmtTrack.setRequired(true);
/*      */       }
/* 7155 */     } else if (trackStrategyIdSet.contains(strategyId))
/*      */     {
/* 7157 */       projectEnabled = false;
/* 7158 */       this.prmtTrack.setRequired(true);
/*      */     }
/* 7160 */     setF7Enabled(this.prmtProject, projectEnabled);
/* 7161 */     this.prmtProject.setRequired(projectEnabled);
/* 7162 */     setF7Enabled(this.prmtTrack, trackEnabled);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private MaterialPlanInfo getMaterialPlanInfo(MaterialInfo material)
/*      */   {
/* 7175 */     StorageOrgUnitInfo storage = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */
/*      */ 
/* 7178 */     if ((storage == null) || (material == null) || (material.getId() == null)) {
/* 7179 */       return null;
/*      */     }
/* 7181 */     String orgUnit = storage.getId().toString();
/* 7182 */     String materialId = material.getId().toString();
/* 7183 */     MaterialPlanInfo planInfo = null;
/*      */     try {
/* 7185 */       String key = materialId + orgUnit;
/* 7186 */       if (this.materialPlanMap.containsKey(key)) {
/* 7187 */         planInfo = (MaterialPlanInfo)this.materialPlanMap.get(key);
/*      */       } else {
/* 7189 */         planInfo = MaterialPlanFactory.getRemoteInstance().getPlanInfo(materialId, orgUnit);
/*      */ 
/* 7191 */         this.materialPlanMap.put(key, planInfo);
/*      */       }
/*      */     } catch (EASBizException e) {
/* 7194 */       handUIException(e);
/*      */     } catch (BOSException e) {
/* 7196 */       handUIException(e);
/*      */     }
/* 7198 */     return planInfo;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setBatchMenuStatus(boolean isEnabled)
/*      */   {
/* 7211 */     this.menuBatch.setEnabled(isEnabled);
/* 7212 */     this.menuBatch.setVisible(isEnabled);
/*      */ 
/* 7214 */     this.MenuItemBatchSubmit.setEnabled(isEnabled);
/* 7215 */     this.MenuItemBatchSubmit.setVisible(isEnabled);
/*      */ 
/* 7217 */     this.MenuItemBatchAudit.setEnabled(isEnabled);
/* 7218 */     this.MenuItemBatchAudit.setVisible(isEnabled);
/*      */ 
/* 7220 */     this.MenuItemBatchSet.setEnabled(isEnabled);
/* 7221 */     this.MenuItemBatchSet.setVisible(isEnabled);
/*      */
/*      */ 
/* 7224 */     if (isEnabled)
/* 7225 */       initBatchOption();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getResource(String resPath, String key)
/*      */   {
/* 7242 */     return ResourceUtils.getMessageForClient(resPath, key);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getResource(String key)
/*      */   {
/* 7255 */     return ResourceUtils.getMessageForClient("com.kingdee.eas.mm.basedata.BOMResource", key);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String getResource(String key, String[] params)
/*      */   {
/* 7268 */     return ResourceUtils.getMessageForClient("com.kingdee.eas.mm.basedata.BOMResource", key, params);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private String trimString(String str)
/*      */   {
/* 7281 */     String rst = null;
/*      */ 
/* 7283 */     Pattern pattern = Pattern.compile("\\s");
/* 7284 */     Matcher matcher = pattern.matcher(str);
/* 7285 */     rst = matcher.replaceAll("");
/*      */ 
/* 7287 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initBatchOption()
/*      */   {
/* 7299 */     boolean isSelected = true;
/* 7300 */     String value = null;
/*      */ 
/* 7302 */     if (this.isAddOrderBom)
/*      */     {
/* 7304 */       value = ConfigServiceUtils.getUserConfigData("MMOrderBomTreeBatchSubmit", this);
/*      */ 
/* 7306 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(value)) {
/* 7307 */         isSelected = Boolean.valueOf(value).booleanValue();
/*      */       }
/* 7309 */       this.chkMenuItemBatchSubmit.setSelected(isSelected);
/*      */ 
/* 7311 */       isSelected = true;
/*      */ 
/* 7313 */       value = ConfigServiceUtils.getUserConfigData("MMOrderBomTreeBatchAudit", this);
/*      */ 
/* 7315 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(value)) {
/* 7316 */         isSelected = Boolean.valueOf(value).booleanValue();
/*      */       }
/* 7318 */       this.chkMenuItemBatchAudit.setSelected(isSelected);
/*      */ 
/* 7320 */       isSelected = true;
/*      */ 
/* 7322 */       value = ConfigServiceUtils.getUserConfigData("MMOrderBomTreeBatchAssign", this);
/*      */ 
/* 7324 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(value)) {
/* 7325 */         isSelected = Boolean.valueOf(value).booleanValue();
/*      */       }
/* 7327 */       this.chkMenuItemBatchAssign.setSelected(isSelected);
/*      */
/*      */     }
/*      */     else
/*      */     {
/* 7332 */       value = ConfigServiceUtils.getUserConfigData("MMBomTreeBatchSubmit", this);
/*      */ 
/* 7334 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(value)) {
/* 7335 */         isSelected = Boolean.valueOf(value).booleanValue();
/*      */       }
/* 7337 */       this.chkMenuItemBatchSubmit.setSelected(isSelected);
/*      */ 
/* 7339 */       isSelected = true;
/*      */ 
/* 7341 */       value = ConfigServiceUtils.getUserConfigData("MMBomTreeBatchAudit", this);
/*      */ 
/* 7343 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(value)) {
/* 7344 */         isSelected = Boolean.valueOf(value).booleanValue();
/*      */       }
/* 7346 */       this.chkMenuItemBatchAudit.setSelected(isSelected);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean hasPermission(String permItemName)
/*      */   {
/* 7360 */     StorageOrgUnitInfo storageOrgInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 7362 */     if (storageOrgInfo == null)
/*      */     {
/* 7364 */       storageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
/*      */     }
/* 7366 */     IObjectPK orgPK = new ObjectUuidPK(storageOrgInfo.getId().toString());
/*      */ 
/* 7368 */     IObjectPK userPK = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
/*      */ 
/* 7370 */     boolean rst = false;
/*      */     try
/*      */     {
/* 7373 */       rst = PermissionFactory.getRemoteInstance().hasFunctionPermission(userPK, orgPK, permItemName);
/*      */     }
/*      */     catch (EASBizException e) {
/* 7376 */       handUIException(e);
/*      */     } catch (BOSException e) {
/* 7378 */       handUIException(e);
/*      */     }
/* 7380 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void hideTrackNumColumn()
/*      */   {
/* 7393 */     String path = "com.kingdee.eas.mm.basedata.client.BomEditUI.kdtEntrys";
/* 7394 */     UserCustomConfigItemData user = this.tHelper.getUserDataFromUI().getTableCurrentSetting(path);
/*      */ 
/* 7396 */     if (user == null) {
/* 7397 */       return;
/*      */     }
/* 7399 */     Map map = user.getColumnData();
/* 7400 */     if (map.containsKey("trackNum")) {
/* 7401 */       ColumnItemData data = (ColumnItemData)map.get("trackNum");
/* 7402 */       BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/*      */ 
/* 7404 */       if (!(BOMTypeEnum.CfgBOM.equals(bomType))) {
/* 7405 */         this.freezeColIndex = 4;
/* 7406 */         data.setHidden(true);
/*      */ 
/* 7408 */         this.tHelper.applyConfigFromData(this.kdtEntrys, user);
/*      */       } else {
/* 7410 */         this.freezeColIndex = 5;
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setTableFieldLockState(boolean flag)
/*      */   {
/* 7425 */     Boolean assign = null;
/* 7426 */     IRow row = null;
/*      */ 
/* 7428 */     int i = 0; for (int count = this.kdtEntrys.getRowCount(); i < count; ++i) {
/* 7429 */       row = this.kdtEntrys.getRow(i);
/* 7430 */       row.getStyleAttributes().setLocked(true);
/* 7431 */       assign = (Boolean)row.getCell("isAssigned").getValue();
/* 7432 */       if (Boolean.TRUE.equals(assign)) {
/* 7433 */         if (!(flag))
/*      */           continue;
/* 7435 */         row.getCell("netWeight").getStyleAttributes().setLocked(true);
/*      */ 
/* 7437 */         row.getCell("blkSize").getStyleAttributes().setLocked(true);
/*      */ 
/* 7439 */         row.getCell("specifiedLength").getStyleAttributes().setLocked(true);
/*      */ 
/* 7441 */         row.getCell("usedUnit").getStyleAttributes().setLocked(true);
/*      */ 
/* 7443 */         row.getCell("designUnit").getStyleAttributes().setLocked(true);
/*      */ 
/* 7445 */         row.getCell("designRemark").getStyleAttributes().setLocked(true);
/*      */ 
/* 7447 */         row.getCell("feture").getStyleAttributes().setLocked(true);
/* 7448 */         row.getCell("canSelected").getStyleAttributes().setLocked(true);
/*      */ 
/* 7450 */         row.getCell("firstCfg").getStyleAttributes().setLocked(true);
/*      */       }
/*      */       else
/*      */       {
/* 7454 */         row.getStyleAttributes().setLocked(false);
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void checkIsModify()
/*      */   {
/* 7469 */     boolean isModify = isModify();
/* 7470 */     if (isModify) {
/* 7471 */       MsgBox.showInfo(getResource("dataIsModified"));
/* 7472 */       SysUtil.abort();
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void filterSubMaterial()
/*      */   {
/* 7486 */     int entryCount = this.kdtEntrys.getRowCount();
/* 7487 */     if (entryCount < 1) {
/* 7488 */       return;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */     }
/*      */ 
/* 7497 */     IRow row = null;
/*      */ 
/* 7499 */     Date effectiveDate = null;
/*      */ 
/* 7501 */     Date disableDate = null;
/*      */ 
/* 7503 */     BomViewOptionEnum viewOption = getBomViewOptionEnum();
/* 7504 */     Date compareDate = getCurrentDate();
/* 7505 */     if (BomViewOptionEnum.QUERY_DATE_MATERIAL.equals(viewOption)) {
/* 7506 */       compareDate = getQueryDate();
/*      */     }
/* 7508 */     for (int i = 0; i < entryCount; ++i) {
/* 7509 */       row = this.kdtEntrys.getRow(i);
/* 7510 */       effectiveDate = (Date)row.getCell("effectiveDate").getValue();
/* 7511 */       disableDate = (Date)row.getCell("disableDate").getValue();
/* 7512 */       if (effectiveDate == null) {
/* 7513 */         Calendar effectiveCalendar = Calendar.getInstance();
/* 7514 */         effectiveCalendar.set(1900, 1, 1);
/* 7515 */         effectiveCalendar.set(11, 0);
/* 7516 */         effectiveCalendar.set(12, 0);
/* 7517 */         effectiveCalendar.set(13, 0);
/* 7518 */         effectiveCalendar.set(14, 0);
/* 7519 */         effectiveDate = effectiveCalendar.getTime();
/*      */       }
/* 7521 */       if (disableDate == null) {
/* 7522 */         Calendar disableCalendar = Calendar.getInstance();
/*      */ 
/* 7524 */         disableCalendar.set(2099, 11, 31);
/* 7525 */         disableCalendar.set(11, 0);
/* 7526 */         disableCalendar.set(12, 0);
/* 7527 */         disableCalendar.set(13, 0);
/* 7528 */         disableCalendar.set(14, 0);
/* 7529 */         disableDate = disableCalendar.getTime();
/*      */       }
/* 7531 */       boolean isHide = com.kingdee.eas.mm.common.util.MMUtils.isHideMaterial(viewOption, compareDate, effectiveDate, disableDate);
/*      */
/*      */ 
/* 7534 */       row.getStyleAttributes().setHided(isHide);
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private BomViewOptionEnum getBomViewOptionEnum()
/*      */   {
/* 7548 */     if (this.chkMenuItemCurrentMaterial.isSelected()) {
/* 7549 */       return BomViewOptionEnum.CURRENT_MATERIAL;
/*      */     }
/* 7551 */     if (this.chkMenuItemDisableMaterial.isSelected()) {
/* 7552 */       return BomViewOptionEnum.DISABLE_MATERIAL;
/*      */     }
/* 7554 */     if (this.chkMenuItemWillMaterial.isSelected()) {
/* 7555 */       return BomViewOptionEnum.WILL_MATERIAL;
/*      */     }
/* 7557 */     if (this.chkMenuItemQueryDate.isSelected()) {
/* 7558 */       return BomViewOptionEnum.QUERY_DATE_MATERIAL;
/*      */     }
/* 7560 */     return BomViewOptionEnum.ALL_MATERIAL;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private Date getCurrentDate()
/*      */   {
/* 7573 */     Date currentDate = (Date)this.param.get("CURRENT_DATE");
/* 7574 */     if (currentDate == null) {
/*      */       try {
/* 7576 */         currentDate = SCMClientUtils.getServerDate();
/* 7577 */         this.param.put("CURRENT_DATE", currentDate);
/*      */       } catch (Exception e) {
/* 7579 */         handUIException(e);
/*      */       }
/*      */     }
/* 7582 */     return currentDate;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/* 7608 */   private static String BOM_ASSIGN_RESOURCE = "com.kingdee.eas.mm.basedata.BOMAssignResource";
/*      */
/*      */
/*      */
/*      */
/* 7613 */   private String[] QTYPRECISIONFROMUNITTAB = { "consumeFixQty" };
/*      */
/*      */
/*      */
/*      */
/* 7618 */   private String[] QTYPRECISIONFROMBASEUNITTAB = { "consumeFixBaseQty" };
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/* 7625 */   private boolean hasOrderBomFormCfgBom = false;
/*      */
/*      */
/*      */
/*      */
/* 7630 */   private ActionListener chkIsProjectManuListener = null;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/* 7639 */   private KDTEditAdapter entryTableChange = null;
/*      */
/*      */
/* 7642 */   private DataChangeListener prmtMaterialListener = null;
/*      */
/*      */
/* 7645 */   private DataChangeListener qtyChangeLister = null;
/*      */
/*      */
/* 7648 */   private ItemListener combBillFromListener = null;
/*      */
/*      */
/* 7651 */   private DataChangeListener prmtStorageListener = null;
/*      */
/*      */
/*      */
/*      */
/* 7656 */   private PreChangeListener bizPreChangeListener = null;
/*      */
/*      */
/* 7659 */   private KDTActiveCellListener activeCellListener = null;
/*      */
/*      */
/* 7662 */   private Map param = null;
/*      */
/*      */
/* 7665 */   private boolean isOrderBomTree = false;
/*      */
/*      */
/* 7668 */   private boolean isAddOrderBom = false;
/*      */
/*      */
/* 7671 */   private boolean isAddNew = false;
/*      */
/*      */
/* 7674 */   private boolean isUpdate = false;
/*      */
/*      */
/* 7677 */   private boolean isDel = false;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/* 7684 */   private Date queryDate = null;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void setQueryDate(Date queryDate)
/*      */   {
/* 7696 */     this.queryDate = queryDate;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public Date getQueryDate()
/*      */   {
/* 7709 */     Map context = getUIContext();
/* 7710 */     String key = "queryDate";
/* 7711 */     Date queDate = (Date)context.get(key);
/*      */ 
/* 7713 */     if (queDate != null) {
/* 7714 */       context.remove(key);
/* 7715 */       this.queryDate = queDate;
/* 7716 */       return queDate;
/*      */     }
/* 7718 */     return this.queryDate;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/* 7724 */   private ProjectInfo projectInfo = null;
/*      */
/*      */
/*      */
/*      */
/* 7729 */   private int precision = 6;
/*      */
/*      */
/*      */
/*      */
/* 7734 */   private BigDecimal oneBigDecimal = new BigDecimal("1.00");
/*      */
/*      */
/*      */
/*      */
/* 7739 */   private Map trackMap = null;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/* 7746 */   private Map materialPlanMap = new HashMap();
/*      */
/* 7748 */   private boolean isFromTree = false;
/*      */
/*      */
/*      */
/*      */
/* 7753 */   private IUIWindow bomExtendSearchUI = null;
/*      */
/*      */
/*      */
/*      */
/* 7758 */   private IUIWindow bomExtendBackSearchUI = null;
/*      */
/*      */
/*      */
/*      */
/* 7763 */   private IUIWindow orderBomExtendSearchUI = null;
/*      */
/*      */
/*      */
/*      */
/* 7768 */   private IUIWindow orderBomExtendBackSearchUI = null;
/*      */
/*      */
/* 7771 */   private DataChangeListener prmtProjListener = null;
/*      */
/* 7773 */   boolean isMaterialConfig = false;
/*      */
/*      */
/*      */
/*      */
/* 7778 */   private ActionListener batchSubmitActionListener = null;
/*      */
/*      */
/*      */
/*      */
/* 7783 */   private ActionListener batchAuditActionListener = null;
/*      */
/*      */
/*      */
/*      */
/* 7788 */   private ActionListener batchAssignActionListener = null;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private class PushDownVO
/*      */   {
/*      */     public void clear()
/*      */     {
/* 8011 */       this.mi = null;
/* 8012 */       this.soui = null;
/* 8013 */       this.bomType = null;
/* 8014 */       this.bomUsage = null;
/*      */     }
/*      */
/*      */
/* 8018 */     private MaterialInfo mi = null;
/*      */
/*      */
/* 8021 */     private StorageOrgUnitInfo soui = null;
/*      */
/*      */
/* 8024 */     private BOMTypeEnum bomType = null;
/*      */
/*      */
/* 8027 */     private BOMUsageEnum bomUsage = null;
/*      */
/*      */
/*      */
/*      */     public MaterialInfo getMi()
/*      */     {
/* 8033 */       return this.mi;
/*      */     }
/*      */
/*      */
/*      */
/*      */
/*      */     public void setMi(MaterialInfo mi)
/*      */     {
/* 8041 */       this.mi = mi;
/*      */     }
/*      */
/*      */
/*      */
/*      */     public StorageOrgUnitInfo getSoui()
/*      */     {
/* 8048 */       return this.soui;
/*      */     }
/*      */
/*      */
/*      */
/*      */
/*      */     public void setSoui(StorageOrgUnitInfo soui)
/*      */     {
/* 8056 */       this.soui = soui;
/*      */     }
/*      */
/*      */
/*      */
/*      */     public BOMTypeEnum getBomType()
/*      */     {
/* 8063 */       return this.bomType;
/*      */     }
/*      */
/*      */
/*      */
/*      */
/*      */     public void setBomType(BOMTypeEnum bomType)
/*      */     {
/* 8071 */       this.bomType = bomType;
/*      */     }
/*      */
/*      */
/*      */
/*      */     public BOMUsageEnum getBomUsage()
/*      */     {
/* 8078 */       return this.bomUsage;
/*      */     }
/*      */
/*      */
/*      */
/*      */
/*      */     public void setBomUsage(BOMUsageEnum bomUsage)
/*      */     {
/* 8086 */       this.bomUsage = bomUsage;
/*      */     }
/*      */   }
/*      */
/*      */   protected void removeByPK(IObjectPK pk)
/*      */     throws Exception
/*      */   {
/* 8093 */     int oldIndex = this.idList.getCurrentIndex();
/* 8094 */     int newIndex = oldIndex + 1;
/* 8095 */     String id = null;
/* 8096 */     IObjectValue objValue = null;
/*      */     do { if (newIndex >= this.idList.size()) break;
/* 8098 */       id = this.idList.getID(newIndex);
/* 8099 */       if (id == null)
/* 8100 */         this.idList.remove(id, false);
/*      */       else
/*      */         try {
/* 8103 */           IObjectPK pkNext = new ObjectUuidPK(id);
/* 8104 */           objValue = getValue(pkNext);
/*      */         } catch (Exception ee) {
/* 8106 */           this.idList.remove(id, false);
/*      */         }
/*      */     }
/* 8109 */     while (objValue == null);
/*      */
/*      */
/*      */
/*      */ 
/* 8114 */     super.removeByPK(pk);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setChkIsProjectManuEnabled(boolean enabled)
/*      */   {
/* 8148 */     this.chkIsProjectManu.setEditable(enabled);
/* 8149 */     this.chkIsProjectManu.setEnabled(enabled);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setChkIsProjectManuSelected(boolean isSelected)
/*      */   {
/* 8165 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/*      */ 
/* 8167 */     if (BOMTypeEnum.CfgBOM.equals(bomType))
/* 8168 */       this.chkIsProjectManu.setSelected(isSelected);
/*      */     else
/* 8170 */       this.chkIsProjectManu.setSelected(false);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setF7Enabled(KDBizPromptBox prmtBox, boolean enabled)
/*      */   {
/* 8195 */     prmtBox.setEnabled(enabled);
/* 8196 */     prmtBox.setEditable(enabled);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setPrmtProjectEnabledByStrategy(String strategyId)
/*      */   {
/* 8210 */     Set projectTrackStrategySet = ManufactureStrategyGroup.getProjectTrackOrderBomStrategyIdSet();
/*      */ 
/* 8212 */     boolean enabled = projectTrackStrategySet.contains(strategyId);
/* 8213 */     setF7Enabled(this.prmtProject, enabled);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean isPrmtProjectEnabled()
/*      */   {
/* 8227 */     if (getOprtState() == "VIEW") {
/* 8228 */       return false;
/*      */     }
/* 8230 */     BOMTypeEnum bomType = (BOMTypeEnum)this.cmbType.getSelectedItem();
/*      */ 
/* 8232 */     if (bomType.equals(BOMTypeEnum.MfgBOM)) {
/* 8233 */       return false;
/*      */     }
/*      */ 
/* 8236 */     if (bomType.equals(BOMTypeEnum.CfgBOM))
/*      */     {
/* 8238 */       String sourceBomId = this.editData.getSourceBomId();
/* 8239 */       if (com.kingdee.eas.mm.common.util.MMUtils.isNotEmptyString(sourceBomId))
/*      */       {
/* 8241 */         return false;
/*      */       }
/*      */ 
/* 8244 */       if (!(this.chkIsProjectManu.isSelected())) {
/* 8245 */         return false;
/*      */       }
/*      */ 
/* 8248 */       if (this.hasOrderBomFormCfgBom) {
/* 8249 */         return false;
/*      */
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 8256 */       MaterialInfo materialInfo = this.editData.getMaterial();
/* 8257 */       MaterialPlanInfo plan = getMaterialPlanInfo(materialInfo);
/* 8258 */       if ((plan != null) && (plan.getManufactureStrategy() != null)) {
/* 8259 */         String strategy = plan.getManufactureStrategy().getId().toString();
/*      */ 
/* 8261 */         Set proTrackStrategy = ManufactureStrategyGroup.getProjectTrackOrderBomStrategyIdSet();
/*      */ 
/* 8263 */         return proTrackStrategy.contains(strategy);
/*      */       }
/*      */     }
/* 8266 */     return true;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initBomGroupF7()
/*      */   {
/* 8277 */     this.prmtBomGroup.addSelectorListener(new SelectorListener() {
/*      */       public void willShow(SelectorEvent e) {
/* 8279 */         BomEditUI.this.registerBomGroupF7();
/*      */       }
/*      */     });
/* 8282 */     this.prmtBomGroup.addCommitListener(new CommitListener() {
/*      */       public void willCommit(CommitEvent e) {
/* 8284 */         BomEditUI.this.registerBomGroupF7();
/*      */       }
/*      */     });
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void registerBomGroupF7()
/*      */   {
/* 8297 */     getUIContext().put("storageOrgUnitInfo", this.prmtstorageOrgUnit.getValue());
/* 8298 */     getUIContext().put(getMainBizOrgType(), this.prmtstorageOrgUnit.getValue());
/* 8299 */     getUIContext().put("createOrg", this.prmtstorageOrgUnit.getValue());
/* 8300 */     KDPromptSelector selector = new KDPromptSelectorAdaptor(this.prmtBomGroup, F7BomGroupTreeListUI.class, getUIContext(), this);
/*      */ 
/* 8302 */     this.prmtBomGroup.setSelector(selector);
/* 8303 */     this.prmtBomGroup.setEntityViewInfo(getBomGroupGroupViewInfo());
/* 8304 */     this.prmtBomGroup.getQueryAgent().resetRuntimeEntityView();
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private EntityViewInfo getBomGroupGroupViewInfo()
/*      */   {
/* 8315 */     EntityViewInfo view = new EntityViewInfo();
/* 8316 */     FilterInfo filterInfo = new FilterInfo();
/* 8317 */     StorageOrgUnitInfo storage = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 8319 */     if (null != storage) {
/* 8320 */       filterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storage.getId().toString(), CompareType.EQUALS));
/*      */     }
/*      */     else
/*      */     {
/* 8324 */       filterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", "-1", CompareType.EQUALS));
/*      */
/*      */
/*      */     }
/*      */ 
/* 8329 */     view.setFilter(filterInfo);
/* 8330 */     return view;
/*      */   }
/*      */
/*      */   protected boolean isShowAttachmentAction() {
/* 8334 */     return true;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void initPickingModeValue()
/*      */   {
/* 8347 */     ICellEditor editor = this.kdtEntrys.getColumn("pickingMode").getEditor();
/* 8348 */     if (editor == null) {
/* 8349 */       return;
/*      */     }
/* 8351 */     KDComboBox cboxPickingMode = (KDComboBox)editor.getComponent();
/*      */ 
/* 8353 */     UIHelper.setIssueModeSelect(cboxPickingMode);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private KDBizPromptBox createKDBizPromptBox(String queryInfo)
/*      */   {
/* 8399 */     KDBizPromptBox bizBox = new KDBizPromptBox();
/* 8400 */     bizBox.setEditable(true);
/* 8401 */     bizBox.setDisplayFormat("$name$");
/* 8402 */     bizBox.setEditFormat("$number$");
/* 8403 */     bizBox.setCommitFormat("$number$");
/* 8404 */     bizBox.setQueryInfo(queryInfo);
/* 8405 */     return bizBox;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private KDBizPromptBox createDefaultWarehouseKDBizPromptBox(StorageOrgUnitInfo storageOrgUnit)
/*      */   {
/* 8449 */     KDBizPromptBox warehouse = createKDBizPromptBox("com.kingdee.eas.basedata.scm.im.inv.app.F7WarehouseQuery");
/*      */ 
/* 8451 */     EntityViewInfo viewInfo = new EntityViewInfo();
/* 8452 */     FilterInfo filterInfo = new FilterInfo();
/* 8453 */     if (storageOrgUnit != null) {
/* 8454 */       String storageOrgUnitId = storageOrgUnit.getId().toString();
/* 8455 */       FilterItemInfo filterItem = new FilterItemInfo("STORAGEORGUNIT.ID", storageOrgUnitId, CompareType.EQUALS);
/*      */ 
/* 8457 */       filterInfo.getFilterItems().add(filterItem);
/*      */     }
/*      */ 
/* 8460 */     viewInfo.setFilter(filterInfo);
/* 8461 */     warehouse.setEntityViewInfo(viewInfo);
/* 8462 */     return warehouse;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setLocationLockStatus(IRow row)
/*      */   {
/* 8475 */     boolean isLocked = true;
/* 8476 */     WarehouseInfo warehouseInfo = (WarehouseInfo)row.getCell("defaultWarehouse").getValue();
/*      */ 
/* 8478 */     if (warehouseInfo != null) {
/* 8479 */       boolean hasLocation = warehouseInfo.isHasLocation();
/* 8480 */       if (hasLocation)
/*      */       {
/* 8482 */         isLocked = false;
/*      */       }
/*      */     }
/* 8485 */     setCellLocked(row, "location", isLocked);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private Set getCheckboxColumnNameSet()
/*      */   {
/* 8498 */     Set nameSet = new HashSet();
/*      */ 
/* 8500 */     nameSet.add("isBackFlush");
/*      */ 
/* 8502 */     nameSet.add("isStockTransfer");
/*      */ 
/* 8504 */     nameSet.add("isAssigned");
/* 8505 */     return nameSet;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setBackFlushOrStockTransferLocked(IRow curRow, String columnName)
/*      */   {
/* 8524 */     MaterialProvideTypeEnum provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */ 
/* 8526 */     boolean isLocked = true;
/*      */ 
/* 8528 */     if ((provideType.equals(MaterialProvideTypeEnum.CURRENTORGPROVIDE)) || (provideType.equals(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE)))
/*      */
/*      */     {
/* 8531 */       MaterialIssueModeEnum issueMode = (MaterialIssueModeEnum)curRow.getCell("pickingMode").getValue();
/*      */ 
/* 8533 */       if (MaterialIssueModeEnum.PRODUCEISSMODE.equals(issueMode))
/* 8534 */         isLocked = false;
/*      */       else {
/* 8536 */         isLocked = true;
/*      */       }
/*      */ 
/*      */     }
/* 8540 */     else if ((provideType.equals(MaterialProvideTypeEnum.SPANORGPROVIDE)) || (provideType.equals(MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE)))
/*      */
/*      */     {
/* 8543 */       isLocked = true;
/*      */     }
/* 8545 */     setCellLocked(curRow, columnName, isLocked);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setBackFlushOrStockTransferNotChecked(IRow curRow, String columnName)
/*      */   {
/* 8563 */     Set provideTypeSet = new HashSet();
/* 8564 */     provideTypeSet.add(MaterialProvideTypeEnum.CURRENTORGPROVIDE);
/* 8565 */     provideTypeSet.add(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE);
/* 8566 */     MaterialProvideTypeEnum provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */ 
/* 8568 */     MaterialIssueModeEnum issueMode = (MaterialIssueModeEnum)curRow.getCell("pickingMode").getValue();
/*      */
/*      */ 
/* 8571 */     if ((provideTypeSet.contains(provideType)) && (MaterialIssueModeEnum.PRODUCEISSMODE.equals(issueMode)))
/*      */       return;
/* 8573 */     curRow.getCell(columnName).setValue(Boolean.FALSE);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void dealWithProvideType(KDTEditEvent e, IRow curRow)
/*      */   {
/* 8588 */     MaterialProvideTypeEnum provideType = (MaterialProvideTypeEnum)curRow.getCell("provideType").getValue();
/*      */ 
/* 8590 */     MaterialProductEnum outputType = (MaterialProductEnum)curRow.getCell("outputType").getValue();
/*      */
/*      */ 
/* 8593 */     if (provideType.equals(MaterialProvideTypeEnum.CURRENTORGPROVIDE)) {
/* 8594 */       curRow.getCell("supplyOrgUnit").setValue(this.prmtstorageOrgUnit.getValue());
/*      */
/*      */
/*      */     }
/* 8598 */     else if (provideType.equals(MaterialProvideTypeEnum.SPANORGATTEMPERPROVIDE))
/*      */     {
/* 8600 */       curRow.getCell("supplyOrgUnit").setValue(null);
/*      */ 
/* 8602 */       if (MaterialProductEnum.OTHER.equals(outputType)) {
/* 8603 */         curRow.getCell("pickingMode").setValue(MaterialIssueModeEnum.PRODUCEISSMODE);
/*      */
/*      */       }
/*      */ 
/*      */     }
/* 8608 */     else if (provideType.equals(MaterialProvideTypeEnum.SPANORGPROVIDE))
/*      */     {
/* 8610 */       curRow.getCell("supplyOrgUnit").setValue(null);
/*      */ 
/* 8612 */       if (MaterialProductEnum.OTHER.equals(outputType)) {
/* 8613 */         curRow.getCell("pickingMode").setValue(MaterialIssueModeEnum.PRODUCEISSMODE);
/*      */
/*      */       }
/*      */ 
/* 8617 */       curRow.getCell("isStockTransfer").setValue(Boolean.FALSE);
/* 8618 */       curRow.getCell("isBackFlush").setValue(Boolean.FALSE);
/*      */
/*      */     }
/* 8621 */     else if (provideType.equals(MaterialProvideTypeEnum.SPANORGDIRECTPROVIDE))
/*      */     {
/* 8623 */       curRow.getCell("supplyOrgUnit").setValue(null);
/*      */ 
/* 8625 */       if (MaterialProductEnum.OTHER.equals(outputType)) {
/* 8626 */         curRow.getCell("pickingMode").setValue(MaterialIssueModeEnum.STRAIGHT);
/*      */
/*      */       }
/*      */ 
/* 8630 */       curRow.getCell("isStockTransfer").setValue(Boolean.FALSE);
/* 8631 */       curRow.getCell("isBackFlush").setValue(Boolean.FALSE);
/*      */     }
/*      */ 
/* 8634 */     curRow.getCell("transferOrgUnit").setValue(null);
/* 8635 */     curRow.getCell("transferWarehouse").setValue(null);
/* 8636 */     curRow.getCell("defaultWarehouse").setValue(null);
/* 8637 */     curRow.getCell("location").setValue(null);
/*      */
/*      */ 
/* 8640 */     dealWithSupplyOrgUnit(e, false);
/*      */ 
/* 8642 */     dealWithDefaultWarehouse(e, false);
/*      */ 
/* 8644 */     dealWithPickingMode(e, false);
/*      */ 
/* 8646 */     dealWithStockTransfer(e, false);
/*      */ 
/* 8648 */     dealWithTransferOrgUnit(e, false);
/*      */ 
/* 8650 */     dealWithTransferWarehouse(e, false);
/*      */ 
/* 8652 */     dealWithBackFlush(e, false);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private List getSelectedRootNodes(List treeNodeList, boolean isDoChild)
/*      */   {
/* 8668 */     if (!(isDoChild)) {
/* 8669 */       return treeNodeList;
/*      */     }
/* 8671 */     Set longNumberSet = new HashSet();
/* 8672 */     List rst = new ArrayList();
/* 8673 */     BomTreeInfo treeInfo = null;
/* 8674 */     String longNumber = null;
/*      */ 
/* 8676 */     for (int i = 0; i < treeNodeList.size(); ++i) {
/* 8677 */       treeInfo = (BomTreeInfo)treeNodeList.get(i);
/* 8678 */       longNumber = treeInfo.getLongNumber();
/*      */ 
/* 8680 */       if (isChildNode(longNumberSet, longNumber)) {
/*      */         continue;
/*      */       }
/* 8683 */       longNumberSet.add(longNumber);
/* 8684 */       rst.add(treeInfo);
/*      */     }
/* 8686 */     return rst;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private boolean isChildNode(Set longNumberSet, String longNumber)
/*      */   {
/* 8699 */     boolean isChildNode = false;
/* 8700 */     Iterator it = longNumberSet.iterator();
/* 8701 */     String parentLongNumber = null;
/*      */    /* do { if (!(it.hasNext())) break label49;
 8703        parentLongNumber = (String)it.next(); }
 8704      while (!(longNumber.startsWith(parentLongNumber)));
 8705      isChildNode = true;*/
/*      */		while(it.hasNext()) {
					parentLongNumber = (String)it.next(); 
					if(longNumber.startsWith(parentLongNumber)) {
						isChildNode=true;
						break;
					}
				}
/*      */		return isChildNode;
/*      */ 
///* 8709 */     label49: return isChildNode;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private SelectorItemCollection getMaterialPlanSelectors()
/*      */   {
/* 8722 */     SelectorItemCollection coll = new SelectorItemCollection();
/* 8723 */     coll.add("id");
/*      */ 
/* 8725 */     coll.add("materialAttr");
/*      */ 
/* 8727 */     coll.add("materialChar");
/*      */ 
/* 8729 */     coll.add("issMode");
/*      */ 
/* 8731 */     coll.add("issueLeadTime");
/*      */ 
/* 8733 */     coll.add("isBackFlush");
/*      */ 
/* 8735 */     coll.add("provideType");
/*      */ 
/* 8737 */     coll.add("fromInvOrg.id");
/* 8738 */     coll.add("fromInvOrg.name");
/*      */ 
/* 8740 */     coll.add("fromWarehouse.id");
/* 8741 */     coll.add("fromWarehouse.name");
/* 8742 */     coll.add("fromWarehouse.number");
/*      */ 
/* 8744 */     coll.add("outputType");
/*      */ 
/* 8746 */     coll.add("isStockAllot");
/*      */ 
/* 8748 */     coll.add("dutyDepartment.id");
/* 8749 */     coll.add("dutyDepartment.name");
/* 8750 */     coll.add("dutyDepartment.number");
/*      */ 
/* 8752 */     coll.add("scrapRate");
/*      */ 
/* 8754 */     coll.add("supplyOrgUnit.id");
/* 8755 */     coll.add("supplyOrgUnit.name");
/* 8756 */     coll.add("supplyOrgUnit.number");
/*      */ 
/* 8758 */     coll.add("productUnit.id");
/* 8759 */     coll.add("productUnit.name");
/* 8760 */     coll.add("productUnit.number");
/* 8761 */     return coll;
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setMaterialPrecision()
/*      */     throws EASBizException, BOSException
/*      */   {
/* 8777 */     this.uiHelper.initInLoadFields(null);
/* 8778 */     if ((this.editData == null) || (this.editData.getId() == null) || (this.editData.getMaterial() == null))
/*      */     {
/* 8780 */       this.txtproductQty.setPrecision(this.precision);
/* 8781 */       this.txtBaseQty.setPrecision(this.precision);
/* 8782 */       return;
/*      */     }
/* 8784 */     String unitId = this.editData.getUnit().getId().toString();
/* 8785 */     String baseUnitId = this.editData.getBaseUnit().getId().toString();
/* 8786 */     this.param = BomFactory.getRemoteInstanceWithObjectContext(getMainOrgContext()).getBizParam(this.editData);
/*      */ 
/* 8788 */     MultiMeasureUnitCollection mmuc = (MultiMeasureUnitCollection)this.param.get("MULTIUNIT");
/*      */ 
/* 8790 */     MultiMeasureUnitInfo mmui = null;
/* 8791 */     String measureUnitId = null;
/* 8792 */     for (Iterator i = mmuc.iterator(); i.hasNext(); ) {
/* 8793 */       mmui = (MultiMeasureUnitInfo)i.next();
/* 8794 */       measureUnitId = mmui.getMeasureUnit().getId().toString();
/* 8795 */       if (measureUnitId.equals(baseUnitId)) {
/* 8796 */         this.txtBaseQty.setPrecision(mmui.getQtyPrecision());
/*      */       }
/* 8798 */       if (measureUnitId.equals(unitId));
/* 8799 */       this.txtproductQty.setPrecision(mmui.getQtyPrecision());
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void setAssignBomStatus()
/*      */     throws CodingRuleException, EASBizException, BOSException
/*      */   {
/* 8819 */     String optState = getOprtState();
/* 8820 */     if ((!("VIEW".equals(optState))) && (!("EDIT".equals(optState))))
/*      */       return;
/* 8822 */     if (!(this.editData.isIsAssigned())) {
/* 8823 */       this.txtYield.setEditable(true);
/* 8824 */       this.txtproductQty.setEditable(true);
/* 8825 */       this.cmbUsage.setEnabled(true);
/* 8826 */       setBomTypeStatus(true);
/* 8827 */       this.prmtmaterial.setAccessAuthority(0);
/*      */ 
/* 8829 */       this.txtName.setAccessAuthority(0);
/* 8830 */       return;
/*      */
/*      */
/*      */     }
/*      */ 
/* 8835 */     if (("EDIT".equals(optState)) && (StringUtils.isEmpty(this.editData.getNumber())))
/*      */     {
/* 8837 */       String newNumber = getNewNumber(getMainOrgInfo().getId().toString());
/*      */ 
/* 8839 */       this.editData.setNumber(newNumber);
/* 8840 */       this.txtNumber.setText(this.editData.getNumber());
/*      */     }
/* 8842 */     this.prmtstorageOrgUnit.setAccessAuthority(1);
/*      */ 
/* 8844 */     this.txtName.setAccessAuthority(1);
/* 8845 */     this.cmbType.setAccessAuthority(1);
/* 8846 */     this.cmbUsage.setAccessAuthority(1);
/* 8847 */     this.prmtmaterial.setAccessAuthority(1);
/*      */ 
/* 8849 */     this.txtYield.setEditable(false);
/* 8850 */     this.txtproductQty.setEditable(false);
/* 8851 */     this.prmtTrack.setAccessAuthority(1);
/*      */ 
/* 8853 */     this.prmtTrack.setEnabled(false);
/* 8854 */     this.prmtTrack.setEditable(false);
/* 8855 */     setF7Enabled(this.prmtProject, false);
/*      */
/*      */ 
/* 8858 */     String paraNumber = "mm_canModifuAssignedBom";
/* 8859 */     String strOrgRange = ParamHelper.getMatchType("0000", paraNumber);
/* 8860 */     boolean flag = Boolean.valueOf(strOrgRange).booleanValue();
/*      */ 
/* 8862 */     setTableFieldLockState(flag);
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   private void cleanBtnText()
/*      */   {
/* 8876 */     this.btnAddLineNew.setText("");
/* 8877 */     this.btnInsertLineNew.setText("");
/* 8878 */     this.btnRemoveLineNew.setText("");
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void actionStandardRooting_actionPerformed(ActionEvent e)
/*      */     throws Exception
/*      */   {
/* 8895 */     super.actionStandardRooting_actionPerformed(e);
/* 8896 */     String uiClassName = null;
/* 8897 */     Map uiContext = new BOSUIContext();
/*      */ 
/* 8899 */     StorageOrgUnitInfo storageOrgUnitInfo = (StorageOrgUnitInfo)this.prmtstorageOrgUnit.getValue();
/*      */ 
/* 8901 */     String userInfoID = SysContext.getSysContext().getCurrentUserInfo().getId().toString();
/*      */
/*      */
/*      */ 
/* 8905 */     MaterialInfo materialInfo = (MaterialInfo)this.prmtmaterial.getValue();
/* 8906 */     if (materialInfo == null) {
/* 8907 */       MsgBox.showWarning(this, getResource("standardrooting.material.notnull"));
/*      */ 
/* 8909 */       return;
/*      */     }
/* 8911 */     String materialNumber = materialInfo.getNumber();
/* 8912 */     EntityViewInfo view = new EntityViewInfo();
/* 8913 */     FilterInfo filter = new FilterInfo();
/* 8914 */     filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgUnitInfo.getId().toString()));
/*      */
/*      */ 
/* 8917 */     filter.getFilterItems().add(new FilterItemInfo("material.number", materialNumber));
/*      */ 
/* 8919 */     SelectorItemCollection coll = new SelectorItemCollection();
/* 8920 */     coll.add(new SelectorItemInfo("material.id"));
/* 8921 */     coll.add(new SelectorItemInfo("id"));
/* 8922 */     coll.add(new SelectorItemInfo("name"));
/* 8923 */     coll.add(new SelectorItemInfo("number"));
/* 8924 */     coll.add(new SelectorItemInfo("isMainRooting"));
/* 8925 */     coll.add(new SelectorItemInfo("isChildRooting"));
/* 8926 */     coll.add(new SelectorItemInfo("rootingType"));
/* 8927 */     coll.add(new SelectorItemInfo("material.name"));
/* 8928 */     coll.add(new SelectorItemInfo("storageOrgUnit.name"));
/* 8929 */     coll.add(new SelectorItemInfo("storageOrgUnit.name"));
/* 8930 */     coll.add(new SelectorItemInfo("materialRooting.firstWP"));
/* 8931 */     coll.add(new SelectorItemInfo("materialRooting.lastWP"));
/* 8932 */     coll.add(new SelectorItemInfo("status"));
/* 8933 */     coll.add(new SelectorItemInfo("storageOrgUnit.id"));
/* 8934 */     view.setSelector(coll);
/* 8935 */     view.setFilter(filter);
/* 8936 */     CoreBaseCollection invents = null;
/*      */     try {
/* 8938 */       invents = StandardRootingFactory.getRemoteInstance().getCollection(view);
/*      */     }
/*      */     catch (BOSException e1) {
/* 8941 */       handleException(e1);
/*      */     }
/* 8943 */     if (invents.size() > 0) {
/* 8944 */       boolean ispermission = PermissionFactory.getRemoteInstance().hasFunctionPermission(new ObjectUuidPK(userInfoID), new ObjectUuidPK(storageOrgUnitInfo.getId().toString()), "mm_standardRooting_view");
/*      */
/*      */
/*      */
/*      */ 
/* 8949 */       if (ispermission)
/*      */       {
/* 8951 */         uiContext.put("StandardRooting", invents);
/* 8952 */         uiContext.put("material.number", materialNumber);
/* 8953 */         uiContext.put("storageOrgUnit.id", storageOrgUnitInfo.getId().toString());
/*      */ 
/* 8955 */         uiClassName = "com.kingdee.eas.mm.basedata.client.StandardRootingForBomQueryUI";
/* 8956 */         IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewFrameFactory").create(uiClassName, uiContext, null, OprtState.ADDNEW);
/*      */
/*      */ 
/* 8959 */         uiWindow.show();
/*      */       } else {
/* 8961 */         MsgBox.showWarning(this, getResource("Has_Not_View_Permission", new String[] { storageOrgUnitInfo.getNumber() }));
/*      */
/*      */
/*      */ 
/* 8965 */         return;
/*      */       }
/*      */     } else {
/* 8968 */       boolean ispermission = PermissionFactory.getRemoteInstance().hasFunctionPermission(new ObjectUuidPK(userInfoID), new ObjectUuidPK(storageOrgUnitInfo.getId().toString()), "mm_standardRooting_addnew");
/*      */
/*      */
/*      */
/*      */ 
/* 8973 */       if (ispermission) {
/* 8974 */         uiContext.put("materialfrombom", materialInfo);
/* 8975 */         uiContext.put("storageOrgUnitfrombom", storageOrgUnitInfo);
/* 8976 */         uiClassName = "com.kingdee.eas.mm.basedata.client.StandardRootingEditUI";
/* 8977 */         IUIWindow uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewFrameFactory").create(uiClassName, uiContext, null, OprtState.ADDNEW);
/*      */
/*      */ 
/* 8980 */         uiWindow.show();
/*      */       } else {
/* 8982 */         MsgBox.showWarning(this, getResource("Has_Not_AddNew_Permission", new String[] { storageOrgUnitInfo.getNumber() }));
/*      */
/*      */
/*      */ 
/* 8986 */         return;
/*      */       }
/*      */     }
/*      */   }
/*      */
/*      */   private void setTrackNumberAndProject(String orderBom, String newOrderBom) {
/* 8992 */     if ((orderBom != null) && ("1".equals(orderBom)) && (newOrderBom != null)) {
/* 8993 */       if (getUIContext().get("projectInfo") != null) {
/* 8994 */         this.prmtProject.setValue(getUIContext().get("projectInfo"));
/*      */       }
/* 8996 */       if (getUIContext().get("trackInfos") != null)
/* 8997 */         this.prmtTrack.setValue(getUIContext().get("trackInfos"));
/*      */     }
/*      */   }
/*      */
/*      */
/*      */
/*      */
/*      */
/* 9005 */   private int freezeColIndex = 4;
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */   public void onShow()
/*      */     throws Exception
/*      */   {
/* 9019 */     super.onShow();
/* 9020 */     KDTableUtils.setDefaultFreezeCol(this.kdtEntrys, this.freezeColIndex);
/*      */   }
/*      */
/*      */   private boolean isUseSchedulePart() {
/* 9024 */     boolean result = false;
/*      */     try {
/* 9026 */       result = MaterialPlanFactory.getRemoteInstance().isUseSchedulePart();
/*      */     }
/*      */     catch (BOSException e) {
/* 9029 */       handUIException(e);
/*      */     }
/* 9031 */     return result;
/*      */   }
/*      */ }
