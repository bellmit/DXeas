/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractStatementsBillListUI extends com.kingdee.eas.framework.client.CoreBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractStatementsBillListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnMultiSubmit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCreateBill;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCalYC;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCarryover;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAllExeCal;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator6;
    protected ActionTDPrint actionTDPrint = null;
    protected ActionTDPrintPreview actionTDPrintPreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionBtnExeCal actionBtnExeCal = null;
    protected ActionMultiSubmit actionMultiSubmit = null;
    protected ActionBreateBill actionBreateBill = null;
    protected ActionCalYC actionCalYC = null;
    protected ActionCarryover actionCarryover = null;
    public final static String STATUS_VIEW = "VIEW";
    /**
     * output class constructor
     */
    public AbstractStatementsBillListUI() throws Exception
    {
        super();
        this.defaultObjectName = "mainQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractStatementsBillListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app", "StatementsBillQuery");
        //actionRemove
        String _tempStr = null;
        actionRemove.setEnabled(true);
        actionRemove.setDaemonRun(false);

        actionRemove.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
        _tempStr = resHelper.getString("ActionRemove.SHORT_DESCRIPTION");
        actionRemove.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.LONG_DESCRIPTION");
        actionRemove.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.NAME");
        actionRemove.putValue(ItemAction.NAME, _tempStr);
        this.actionRemove.setBindWorkFlow(true);
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionTDPrint
        this.actionTDPrint = new ActionTDPrint(this);
        getActionManager().registerAction("actionTDPrint", actionTDPrint);
         this.actionTDPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionTDPrintPreview
        this.actionTDPrintPreview = new ActionTDPrintPreview(this);
        getActionManager().registerAction("actionTDPrintPreview", actionTDPrintPreview);
         this.actionTDPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionBtnExeCal
        this.actionBtnExeCal = new ActionBtnExeCal(this);
        getActionManager().registerAction("actionBtnExeCal", actionBtnExeCal);
        this.actionBtnExeCal.setExtendProperty("canForewarn", "true");
        this.actionBtnExeCal.setExtendProperty("userDefined", "false");
        this.actionBtnExeCal.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBtnExeCal.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBtnExeCal.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionMultiSubmit
        this.actionMultiSubmit = new ActionMultiSubmit(this);
        getActionManager().registerAction("actionMultiSubmit", actionMultiSubmit);
        this.actionMultiSubmit.setBindWorkFlow(true);
        this.actionMultiSubmit.setExtendProperty("canForewarn", "true");
        this.actionMultiSubmit.setExtendProperty("userDefined", "false");
        this.actionMultiSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionMultiSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMultiSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionMultiSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionBreateBill
        this.actionBreateBill = new ActionBreateBill(this);
        getActionManager().registerAction("actionBreateBill", actionBreateBill);
        this.actionBreateBill.setExtendProperty("canForewarn", "true");
        this.actionBreateBill.setExtendProperty("userDefined", "true");
        this.actionBreateBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBreateBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBreateBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionCalYC
        this.actionCalYC = new ActionCalYC(this);
        getActionManager().registerAction("actionCalYC", actionCalYC);
        this.actionCalYC.setExtendProperty("canForewarn", "true");
        this.actionCalYC.setExtendProperty("userDefined", "false");
        this.actionCalYC.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCalYC.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCalYC.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionCarryover
        this.actionCarryover = new ActionCarryover(this);
        getActionManager().registerAction("actionCarryover", actionCarryover);
        this.actionCarryover.setExtendProperty("canForewarn", "true");
        this.actionCarryover.setExtendProperty("userDefined", "false");
        this.actionCarryover.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCarryover.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCarryover.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnMultiSubmit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCreateBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCalYC = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCarryover = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnAllExeCal = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnMultiSubmit.setName("btnMultiSubmit");
        this.btnCreateBill.setName("btnCreateBill");
        this.btnCalYC.setName("btnCalYC");
        this.btnCarryover.setName("btnCarryover");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.mBtnAllExeCal.setName("mBtnAllExeCal");
        this.newSeparator6.setName("newSeparator6");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol38\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol49\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol51\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol52\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol53\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol54\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol55\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol56\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol57\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol61\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol63\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol64\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol66\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol67\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol69\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol70\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol71\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol72\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol73\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol74\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol75\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"entrys.seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"company.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"storageOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"farmersTree.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"entrys.farm.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"farm.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"farmer.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"stockingBatch.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"breedStage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"settleType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"period.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" /><t:Column t:key=\"breedDataCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol16\" /><t:Column t:key=\"fodderCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:styleID=\"sCol17\" /><t:Column t:key=\"drugCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" t:styleID=\"sCol18\" /><t:Column t:key=\"otherMaterialCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol19\" /><t:Column t:key=\"arAmountOffset\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol20\" /><t:Column t:key=\"faFurCardCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:styleID=\"sCol21\" /><t:Column t:key=\"feeCostAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" t:styleID=\"sCol22\" /><t:Column t:key=\"occupyInterest\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" t:styleID=\"sCol23\" /><t:Column t:key=\"loanInterestDiff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" t:styleID=\"sCol24\" /><t:Column t:key=\"allActualCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" t:styleID=\"sCol25\" /><t:Column t:key=\"receiveQcEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" t:styleID=\"sCol26\" /><t:Column t:key=\"unitActualAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" t:styleID=\"sCol27\" /><t:Column t:key=\"beginDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"28\" t:styleID=\"sCol28\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"29\" t:styleID=\"sCol29\" /><t:Column t:key=\"entrys.price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"30\" t:styleID=\"sCol30\" /><t:Column t:key=\"entrys.amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"31\" t:styleID=\"sCol31\" /><t:Column t:key=\"entrys.settlementItem.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"32\" t:styleID=\"sCol32\" /><t:Column t:key=\"marginAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"33\" t:styleID=\"sCol33\" /><t:Column t:key=\"entrys.material.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"34\" t:styleID=\"sCol34\" /><t:Column t:key=\"entrys.materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"35\" t:styleID=\"sCol35\" /><t:Column t:key=\"entrys.model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"36\" t:styleID=\"sCol36\" /><t:Column t:key=\"entrys.unit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"37\" t:styleID=\"sCol37\" /><t:Column t:key=\"fertilizationRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"38\" t:styleID=\"sCol38\" /><t:Column t:key=\"layingRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"39\" t:styleID=\"sCol39\" /><t:Column t:key=\"allLastStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"40\" t:styleID=\"sCol40\" /><t:Column t:key=\"breedDataAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"41\" t:styleID=\"sCol41\" /><t:Column t:key=\"fodderAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"42\" t:styleID=\"sCol42\" /><t:Column t:key=\"drugAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"43\" t:styleID=\"sCol43\" /><t:Column t:key=\"otherMaterialAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"44\" t:styleID=\"sCol44\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"45\" t:styleID=\"sCol45\" /><t:Column t:key=\"allEggAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"46\" t:styleID=\"sCol46\" /><t:Column t:key=\"birdsAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"47\" t:styleID=\"sCol47\" /><t:Column t:key=\"alimony\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"48\" t:styleID=\"sCol48\" /><t:Column t:key=\"coProductAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"49\" t:styleID=\"sCol49\" /><t:Column t:key=\"awardsAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"50\" t:styleID=\"sCol50\" /><t:Column t:key=\"originalFarmerProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"51\" t:styleID=\"sCol51\" /><t:Column t:key=\"handAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"52\" t:styleID=\"sCol52\" /><t:Column t:key=\"farmerProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"53\" t:styleID=\"sCol53\" /><t:Column t:key=\"entrys.qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"54\" t:styleID=\"sCol54\" /><t:Column t:key=\"FCR\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"55\" t:styleID=\"sCol55\" /><t:Column t:key=\"survivalRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"56\" t:styleID=\"sCol56\" /><t:Column t:key=\"allQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"57\" t:styleID=\"sCol57\" /><t:Column t:key=\"avgWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"58\" t:styleID=\"sCol58\" /><t:Column t:key=\"birdsQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"59\" t:styleID=\"sCol59\" /><t:Column t:key=\"marginInterest\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"60\" t:styleID=\"sCol60\" /><t:Column t:key=\"loanInterest\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"61\" t:styleID=\"sCol61\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"62\" t:styleID=\"sCol62\" /><t:Column t:key=\"lastUpdateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"63\" t:styleID=\"sCol63\" /><t:Column t:key=\"auditor.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"64\" t:styleID=\"sCol64\" /><t:Column t:key=\"auditor.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"65\" /><t:Column t:key=\"auditTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"66\" t:styleID=\"sCol66\" /><t:Column t:key=\"creator.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"67\" t:styleID=\"sCol67\" /><t:Column t:key=\"creator.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"68\" /><t:Column t:key=\"lastUpdateUser.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"69\" t:styleID=\"sCol69\" /><t:Column t:key=\"lastUpdateUser.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"70\" t:styleID=\"sCol70\" /><t:Column t:key=\"entrys.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"71\" t:styleID=\"sCol71\" /><t:Column t:key=\"handler.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"72\" t:styleID=\"sCol72\" /><t:Column t:key=\"handler.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"73\" t:styleID=\"sCol73\" /><t:Column t:key=\"batchContract.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"74\" t:styleID=\"sCol74\" /><t:Column t:key=\"fertilizationRate2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"75\" t:styleID=\"sCol75\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{entrys.seq}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{company.name}</t:Cell><t:Cell>$Resource{storageOrgUnit.name}</t:Cell><t:Cell>$Resource{farmersTree.name}</t:Cell><t:Cell>$Resource{entrys.farm.name}</t:Cell><t:Cell>$Resource{farm.name}</t:Cell><t:Cell>$Resource{farmer.name}</t:Cell><t:Cell>$Resource{stockingBatch.name}</t:Cell><t:Cell>$Resource{breedStage}</t:Cell><t:Cell>$Resource{settleType}</t:Cell><t:Cell>$Resource{period.number}</t:Cell><t:Cell>$Resource{breedDataCost}</t:Cell><t:Cell>$Resource{fodderCost}</t:Cell><t:Cell>$Resource{drugCost}</t:Cell><t:Cell>$Resource{otherMaterialCost}</t:Cell><t:Cell>$Resource{arAmountOffset}</t:Cell><t:Cell>$Resource{faFurCardCost}</t:Cell><t:Cell>$Resource{feeCostAmount}</t:Cell><t:Cell>$Resource{occupyInterest}</t:Cell><t:Cell>$Resource{loanInterestDiff}</t:Cell><t:Cell>$Resource{allActualCost}</t:Cell><t:Cell>$Resource{receiveQcEggQty}</t:Cell><t:Cell>$Resource{unitActualAmount}</t:Cell><t:Cell>$Resource{beginDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{entrys.price}</t:Cell><t:Cell>$Resource{entrys.amount}</t:Cell><t:Cell>$Resource{entrys.settlementItem.name}</t:Cell><t:Cell>$Resource{marginAmount}</t:Cell><t:Cell>$Resource{entrys.material.number}</t:Cell><t:Cell>$Resource{entrys.materialName}</t:Cell><t:Cell>$Resource{entrys.model}</t:Cell><t:Cell>$Resource{entrys.unit.name}</t:Cell><t:Cell>$Resource{fertilizationRate}</t:Cell><t:Cell>$Resource{layingRate}</t:Cell><t:Cell>$Resource{allLastStock}</t:Cell><t:Cell>$Resource{breedDataAmount}</t:Cell><t:Cell>$Resource{fodderAmount}</t:Cell><t:Cell>$Resource{drugAmount}</t:Cell><t:Cell>$Resource{otherMaterialAmount}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{allEggAmount}</t:Cell><t:Cell>$Resource{birdsAmount}</t:Cell><t:Cell>$Resource{alimony}</t:Cell><t:Cell>$Resource{coProductAmount}</t:Cell><t:Cell>$Resource{awardsAmount}</t:Cell><t:Cell>$Resource{originalFarmerProfit}</t:Cell><t:Cell>$Resource{handAmount}</t:Cell><t:Cell>$Resource{farmerProfit}</t:Cell><t:Cell>$Resource{entrys.qty}</t:Cell><t:Cell>$Resource{FCR}</t:Cell><t:Cell>$Resource{survivalRate}</t:Cell><t:Cell>$Resource{allQty}</t:Cell><t:Cell>$Resource{avgWeight}</t:Cell><t:Cell>$Resource{birdsQty}</t:Cell><t:Cell>$Resource{marginInterest}</t:Cell><t:Cell>$Resource{loanInterest}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{lastUpdateTime}</t:Cell><t:Cell>$Resource{auditor.number}</t:Cell><t:Cell>$Resource{auditor.name}</t:Cell><t:Cell>$Resource{auditTime}</t:Cell><t:Cell>$Resource{creator.number}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{lastUpdateUser.number}</t:Cell><t:Cell>$Resource{lastUpdateUser.name}</t:Cell><t:Cell>$Resource{entrys.id}</t:Cell><t:Cell>$Resource{handler.number}</t:Cell><t:Cell>$Resource{handler.name}</t:Cell><t:Cell>$Resource{batchContract.number}</t:Cell><t:Cell>$Resource{fertilizationRate2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"id","number","bizDate","description","entrys.seq","billStatus","company.name","storageOrgUnit.name","farmersTree.name","entrys.farm.name","farm.name","farmer.name","stockingBatch.name","breedStage","settleType","period.number","breedDataCost","fodderCost","drugCost","otherMaterialCost","arAmountOffset","faFurCardCost","feeCostAmount","occupyInterest","loanInterestDiff","allActualCost","receiveQcEggQty","unitActualAmount","beginDate","endDate","entrys.price","entrys.amount","entrys.settlementItem.name","marginAmount","entrys.material.number","entrys.materialName","entrys.model","entrys.unit.name","fertilizationRate","layingRate","allLastStock","breedDataAmount","fodderAmount","drugAmount","otherMaterialAmount","eggQty","allEggAmount","birdsAmount","alimony","coProductAmount","awardsAmount","originalFarmerProfit","handAmount","farmerProfit","entrys.qty","FCR","survivalRate","allQty","avgWeight","birdsQty","marginInterest","loanInterest","createTime","lastUpdateTime","auditor.number","auditor.name","auditTime","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","entrys.id","handler.number","handler.name","batchContract.number","fertilizationRate2"});


        this.tblMain.checkParsed();
        this.tblMain.getGroupManager().setGroup(true);		
        this.separatorFW2.setVisible(true);		
        this.btnAuditResult.setVisible(false);		
        this.menuItemCopyTo.setVisible(false);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator6.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnMultiSubmit
        this.btnMultiSubmit.setAction((IItemAction)ActionProxyFactory.getProxy(actionMultiSubmit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnMultiSubmit.setText(resHelper.getString("btnMultiSubmit.text"));
        // btnCreateBill
        this.btnCreateBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionBreateBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCreateBill.setText(resHelper.getString("btnCreateBill.text"));
        // btnCalYC
        this.btnCalYC.setAction((IItemAction)ActionProxyFactory.getProxy(actionCalYC, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCalYC.setText(resHelper.getString("btnCalYC.text"));
        // btnCarryover
        this.btnCarryover.setAction((IItemAction)ActionProxyFactory.getProxy(actionCarryover, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCarryover.setText(resHelper.getString("btnCarryover.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // mBtnAllExeCal		
        this.mBtnAllExeCal.setText(resHelper.getString("mBtnAllExeCal.text"));
        // newSeparator6
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        tblMain.setBounds(new Rectangle(10, 10, 996, 580));
        this.add(tblMain, new KDLayout.Constraints(10, 10, 996, 580, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkFlow);
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemImportData);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemExportData);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(separatorFile1);
        menuFile.add(menuItemCloudShare);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator1);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator3);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyTo);
        menuEdit.add(kDSeparator4);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(kDSeparator5);
        menuView.add(menuItemQuery);
        menuView.add(menuItemRefresh);
        menuView.add(menuItemSwitchView);
        menuView.add(separatorView1);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(menuItemQueryScheme);
        menuView.add(kDSeparator6);
        //menuBiz
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(mBtnAllExeCal);
        menuBiz.add(newSeparator6);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkFlow
        menuWorkFlow.add(menuItemViewDoProccess);
        menuWorkFlow.add(menuItemMultiapprove);
        menuWorkFlow.add(menuItemWorkFlowG);
        menuWorkFlow.add(menuItemWorkFlowList);
        menuWorkFlow.add(separatorWF1);
        menuWorkFlow.add(menuItemNextPerson);
        menuWorkFlow.add(menuItemAuditResult);
        menuWorkFlow.add(kDSeparator7);
        menuWorkFlow.add(menuItemSendSmsMessage);
        //menuTools
        menuTools.add(menuMail);
        menuTools.add(menuItemStartWorkFlow);
        menuTools.add(menuItemPublishReport);
        //menuMail
        menuMail.add(menuItemToHTML);
        menuMail.add(menuItemCopyScreen);
        menuMail.add(menuItemToExcel);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnView);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnEdit);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnCopyTo);
        this.toolBar.add(btnQueryScheme);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnWorkFlowList);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnMultiSubmit);
        this.toolBar.add(btnCreateBill);
        this.toolBar.add(btnCalYC);
        this.toolBar.add(btnCarryover);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.StatementsBillListUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }



	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }
	protected void Remove() throws Exception {
    	IObjectValue editData = getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
    	super.Remove();
    	recycleNumberByOrg(editData,"",editData.getString("number"));
    }
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

	public SelectorItemCollection getBOTPSelectors() {
			SelectorItemCollection sic = new SelectorItemCollection();
			return sic;
	}

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("auditor.number"));
        sic.add(new SelectorItemInfo("auditor.name"));
        sic.add(new SelectorItemInfo("creator.number"));
        sic.add(new SelectorItemInfo("creator.name"));
        sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        sic.add(new SelectorItemInfo("lastUpdateUser.name"));
        sic.add(new SelectorItemInfo("entrys.id"));
        sic.add(new SelectorItemInfo("handler.number"));
        sic.add(new SelectorItemInfo("handler.name"));
        sic.add(new SelectorItemInfo("entrys.seq"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("company.name"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("farmer.name"));
        sic.add(new SelectorItemInfo("entrys.material.number"));
        sic.add(new SelectorItemInfo("entrys.materialName"));
        sic.add(new SelectorItemInfo("entrys.model"));
        sic.add(new SelectorItemInfo("entrys.unit.name"));
        sic.add(new SelectorItemInfo("entrys.qty"));
        sic.add(new SelectorItemInfo("farm.name"));
        sic.add(new SelectorItemInfo("FCR"));
        sic.add(new SelectorItemInfo("survivalRate"));
        sic.add(new SelectorItemInfo("allQty"));
        sic.add(new SelectorItemInfo("breedDataAmount"));
        sic.add(new SelectorItemInfo("fodderAmount"));
        sic.add(new SelectorItemInfo("drugAmount"));
        sic.add(new SelectorItemInfo("avgWeight"));
        sic.add(new SelectorItemInfo("eggQty"));
        sic.add(new SelectorItemInfo("birdsAmount"));
        sic.add(new SelectorItemInfo("birdsQty"));
        sic.add(new SelectorItemInfo("farmerProfit"));
        sic.add(new SelectorItemInfo("awardsAmount"));
        sic.add(new SelectorItemInfo("storageOrgUnit.name"));
        sic.add(new SelectorItemInfo("entrys.price"));
        sic.add(new SelectorItemInfo("entrys.amount"));
        sic.add(new SelectorItemInfo("entrys.farm.name"));
        sic.add(new SelectorItemInfo("entrys.settlementItem.name"));
        sic.add(new SelectorItemInfo("marginAmount"));
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("batchContract.number"));
        sic.add(new SelectorItemInfo("fertilizationRate"));
        sic.add(new SelectorItemInfo("layingRate"));
        sic.add(new SelectorItemInfo("allLastStock"));
        sic.add(new SelectorItemInfo("allEggAmount"));
        sic.add(new SelectorItemInfo("handAmount"));
        sic.add(new SelectorItemInfo("originalFarmerProfit"));
        sic.add(new SelectorItemInfo("marginInterest"));
        sic.add(new SelectorItemInfo("loanInterest"));
        sic.add(new SelectorItemInfo("alimony"));
        sic.add(new SelectorItemInfo("period.number"));
        sic.add(new SelectorItemInfo("breedDataCost"));
        sic.add(new SelectorItemInfo("fodderCost"));
        sic.add(new SelectorItemInfo("drugCost"));
        sic.add(new SelectorItemInfo("otherMaterialCost"));
        sic.add(new SelectorItemInfo("arAmountOffset"));
        sic.add(new SelectorItemInfo("faFurCardCost"));
        sic.add(new SelectorItemInfo("breedStage"));
        sic.add(new SelectorItemInfo("feeCostAmount"));
        sic.add(new SelectorItemInfo("allActualCost"));
        sic.add(new SelectorItemInfo("otherMaterialAmount"));
        sic.add(new SelectorItemInfo("unitActualAmount"));
        sic.add(new SelectorItemInfo("coProductAmount"));
        sic.add(new SelectorItemInfo("settleType"));
        sic.add(new SelectorItemInfo("occupyInterest"));
        sic.add(new SelectorItemInfo("loanInterestDiff"));
        sic.add(new SelectorItemInfo("receiveQcEggQty"));
        sic.add(new SelectorItemInfo("fertilizationRate2"));
        sic.add(new SelectorItemInfo("stockingBatch.name"));
        sic.add(new SelectorItemInfo("farmersTree.name"));
        return sic;
    }            protected java.util.List getQuerySorterFields() 
    { 
        java.util.List sorterFieldList = new ArrayList(); 
        sorterFieldList.add("number"); 
        return sorterFieldList; 
    } 
    protected java.util.List getQueryPKFields() 
    { 
        java.util.List pkList = new ArrayList(); 
        pkList.add("id"); 
        return pkList;
    }
    	

    /**
     * output actionRemove_actionPerformed method
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }
    	

    /**
     * output actionTDPrint_actionPerformed method
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        checkSelected();        
    	ArrayList idList =super.getSelectedIdValues();
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider data = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.DefaultNoteDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionTDPrintPreview_actionPerformed method
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        checkSelected();
    	ArrayList idList =super.getSelectedIdValues();
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider data = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.DefaultNoteDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionBtnExeCal_actionPerformed method
     */
    public void actionBtnExeCal_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().btnExeCal(editData);
    }
    	

    /**
     * output actionMultiSubmit_actionPerformed method
     */
    public void actionMultiSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().multiSubmit(editData);
    }
    	

    /**
     * output actionBreateBill_actionPerformed method
     */
    public void actionBreateBill_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().breateBill(editData);
    }
    	

    /**
     * output actionCalYC_actionPerformed method
     */
    public void actionCalYC_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().calYC(editData);
    }
    	

    /**
     * output actionCarryover_actionPerformed method
     */
    public void actionCarryover_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().carryover(editData);
    }
	public RequestContext prepareActionRemove(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionRemove(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemove() {
    	return false;
    }
	public RequestContext prepareActionTDPrint(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTDPrint() {
    	return false;
    }
	public RequestContext prepareActionTDPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTDPrintPreview() {
    	return false;
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }
	public RequestContext prepareActionBtnExeCal(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBtnExeCal() {
    	return false;
    }
	public RequestContext prepareActionMultiSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMultiSubmit() {
    	return false;
    }
	public RequestContext prepareActionBreateBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBreateBill() {
    	return false;
    }
	public RequestContext prepareActionCalYC(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCalYC() {
    	return false;
    }
	public RequestContext prepareActionCarryover(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCarryover() {
    	return false;
    }

    /**
     * output ActionTDPrint class
     */     
    protected class ActionTDPrint extends ItemAction {     
    
        public ActionTDPrint()
        {
            this(null);
        }

        public ActionTDPrint(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionTDPrint.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrint.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrint.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionTDPrint", "actionTDPrint_actionPerformed", e);
        }
    }

    /**
     * output ActionTDPrintPreview class
     */     
    protected class ActionTDPrintPreview extends ItemAction {     
    
        public ActionTDPrintPreview()
        {
            this(null);
        }

        public ActionTDPrintPreview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionTDPrintPreview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrintPreview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrintPreview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionTDPrintPreview", "actionTDPrintPreview_actionPerformed", e);
        }
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionBtnExeCal class
     */     
    protected class ActionBtnExeCal extends ItemAction {     
    
        public ActionBtnExeCal()
        {
            this(null);
        }

        public ActionBtnExeCal(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBtnExeCal.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBtnExeCal.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBtnExeCal.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionBtnExeCal", "actionBtnExeCal_actionPerformed", e);
        }
    }

    /**
     * output ActionMultiSubmit class
     */     
    protected class ActionMultiSubmit extends ItemAction {     
    
        public ActionMultiSubmit()
        {
            this(null);
        }

        public ActionMultiSubmit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMultiSubmit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMultiSubmit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMultiSubmit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionMultiSubmit", "actionMultiSubmit_actionPerformed", e);
        }
    }

    /**
     * output ActionBreateBill class
     */     
    protected class ActionBreateBill extends ItemAction {     
    
        public ActionBreateBill()
        {
            this(null);
        }

        public ActionBreateBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBreateBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBreateBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBreateBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionBreateBill", "actionBreateBill_actionPerformed", e);
        }
    }

    /**
     * output ActionCalYC class
     */     
    protected class ActionCalYC extends ItemAction {     
    
        public ActionCalYC()
        {
            this(null);
        }

        public ActionCalYC(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCalYC.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalYC.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalYC.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionCalYC", "actionCalYC_actionPerformed", e);
        }
    }

    /**
     * output ActionCarryover class
     */     
    protected class ActionCarryover extends ItemAction {     
    
        public ActionCarryover()
        {
            this(null);
        }

        public ActionCarryover(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCarryover.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCarryover.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCarryover.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillListUI.this, "ActionCarryover", "actionCarryover_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "StatementsBillListUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.processbizill.client.StatementsBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo();		
        return objectValue;
    }

    /**
     * output getMergeColumnKeys method
     */
    public String[] getMergeColumnKeys()
    {
        return new String[] {"id","number","bizDate","description","billStatus","company.name","storageOrgUnit.name","farmersTree.name","farm.name","farmer.name","stockingBatch.name","breedStage","settleType","period.number","breedDataCost","fodderCost","drugCost","otherMaterialCost","arAmountOffset","faFurCardCost","feeCostAmount","occupyInterest","loanInterestDiff","allActualCost","receiveQcEggQty","unitActualAmount","beginDate","endDate","marginAmount","fertilizationRate","layingRate","allLastStock","breedDataAmount","fodderAmount","drugAmount","otherMaterialAmount","eggQty","allEggAmount","birdsAmount","alimony","coProductAmount","awardsAmount","originalFarmerProfit","handAmount","farmerProfit","FCR","survivalRate","allQty","avgWeight","birdsQty","marginInterest","loanInterest","createTime","lastUpdateTime","auditor.number","auditor.name","auditTime","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","handler.number","handler.name","batchContract.number","fertilizationRate2"};
    }



	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/StatementsBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.StatementsBillQuery");
	}        
				protected boolean isFootVisible() {
			return true;
		}


}