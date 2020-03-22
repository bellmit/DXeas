/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

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
public abstract class AbstractFodderReceptionListUI extends com.kingdee.eas.framework.client.CoreBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFodderReceptionListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBatchSubmit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator6;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem ChkVoucherFlag;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem btnChkVoucherAll;
    protected ActionTDPrint actionTDPrint = null;
    protected ActionTDPrintPreview actionTDPrintPreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionViewStdUse actionViewStdUse = null;
    protected ActionChkVoucherFlag actionChkVoucherFlag = null;
    protected ActionChkVoucherAll actionChkVoucherAll = null;
    protected ActionBatchSubmit actionBatchSubmit = null;
    protected ActionClose actionClose = null;
    protected ActionUnClose actionUnClose = null;
    public final static String STATUS_VIEW = "VIEW";
    /**
     * output class constructor
     */
    public AbstractFodderReceptionListUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFodderReceptionListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app", "FodderReceptionQuery");
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
        //actionViewStdUse
        this.actionViewStdUse = new ActionViewStdUse(this);
        getActionManager().registerAction("actionViewStdUse", actionViewStdUse);
        this.actionViewStdUse.setExtendProperty("canForewarn", "true");
        this.actionViewStdUse.setExtendProperty("userDefined", "false");
        this.actionViewStdUse.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewStdUse.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewStdUse.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionChkVoucherFlag
        this.actionChkVoucherFlag = new ActionChkVoucherFlag(this);
        getActionManager().registerAction("actionChkVoucherFlag", actionChkVoucherFlag);
        this.actionChkVoucherFlag.setExtendProperty("canForewarn", "true");
        this.actionChkVoucherFlag.setExtendProperty("userDefined", "false");
        this.actionChkVoucherFlag.setExtendProperty("isObjectUpdateLock", "false");
         this.actionChkVoucherFlag.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionChkVoucherFlag.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionChkVoucherAll
        this.actionChkVoucherAll = new ActionChkVoucherAll(this);
        getActionManager().registerAction("actionChkVoucherAll", actionChkVoucherAll);
        this.actionChkVoucherAll.setExtendProperty("canForewarn", "true");
        this.actionChkVoucherAll.setExtendProperty("userDefined", "false");
        this.actionChkVoucherAll.setExtendProperty("isObjectUpdateLock", "false");
         this.actionChkVoucherAll.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionChkVoucherAll.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionBatchSubmit
        this.actionBatchSubmit = new ActionBatchSubmit(this);
        getActionManager().registerAction("actionBatchSubmit", actionBatchSubmit);
        this.actionBatchSubmit.setBindWorkFlow(true);
        this.actionBatchSubmit.setExtendProperty("canForewarn", "true");
        this.actionBatchSubmit.setExtendProperty("userDefined", "false");
        this.actionBatchSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionClose
        this.actionClose = new ActionClose(this);
        getActionManager().registerAction("actionClose", actionClose);
        this.actionClose.setBindWorkFlow(true);
        this.actionClose.setExtendProperty("canForewarn", "true");
        this.actionClose.setExtendProperty("userDefined", "true");
        this.actionClose.setExtendProperty("isObjectUpdateLock", "false");
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnClose
        this.actionUnClose = new ActionUnClose(this);
        getActionManager().registerAction("actionUnClose", actionUnClose);
        this.actionUnClose.setBindWorkFlow(true);
        this.actionUnClose.setExtendProperty("canForewarn", "true");
        this.actionUnClose.setExtendProperty("userDefined", "true");
        this.actionUnClose.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnClose.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnClose.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnClose.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBatchSubmit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.ChkVoucherFlag = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.btnChkVoucherAll = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnClose.setName("btnClose");
        this.btnUnClose.setName("btnUnClose");
        this.btnBatchSubmit.setName("btnBatchSubmit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator6.setName("newSeparator6");
        this.ChkVoucherFlag.setName("ChkVoucherFlag");
        this.btnChkVoucherAll.setName("btnChkVoucherAll");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol55\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol56\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol57\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol60\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol68\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol71\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol72\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol73\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol76\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol77\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol78\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol79\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol80\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol81\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol82\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol83\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol84\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol85\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol86\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol87\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol88\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol89\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol90\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol91\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol92\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmer.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.farmer.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol2\" /><t:Column t:key=\"entrys.materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"entrys.receiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"32\" t:styleID=\"sCol4\" /><t:Column t:key=\"entrys.receivePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol5\" /><t:Column t:key=\"entrys.amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol6\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"storageOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.warehouse.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /><t:Column t:key=\"farm.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchContract.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.bagQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol13\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"company.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.confirmQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol16\" /><t:Column t:key=\"entrys.farm.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol17\" /><t:Column t:key=\"entrys.batch.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol18\" /><t:Column t:key=\"entrys.batchContract.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol19\" /><t:Column t:key=\"entrys.unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol20\" /><t:Column t:key=\"entrys.actualCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol21\" /><t:Column t:key=\"entrys.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:styleID=\"sCol22\" /><t:Column t:key=\"entrys.seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" t:styleID=\"sCol23\" /><t:Column t:key=\"entrys.unitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol24\" /><t:Column t:key=\"isInit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:styleID=\"sCol25\" /><t:Column t:key=\"entrys.weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" t:styleID=\"sCol26\" /><t:Column t:key=\"entrys.driver.drivername\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" t:styleID=\"sCol27\" /><t:Column t:key=\"driver.drivername\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" /><t:Column t:key=\"carNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" t:styleID=\"sCol29\" /><t:Column t:key=\"linkCell\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" /><t:Column t:key=\"bizPerson.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" t:styleID=\"sCol31\" /><t:Column t:key=\"person.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"28\" /><t:Column t:key=\"entrys.model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"29\" /><t:Column t:key=\"entrys.unit.name\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"30\" /><t:Column t:key=\"entrys.basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"31\" t:styleID=\"sCol35\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"33\" /><t:Column t:key=\"auditor.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"34\" /><t:Column t:key=\"auditTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"35\" t:styleID=\"sCol38\" /><t:Column t:key=\"entrys.person.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"entrys.bizPerson.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"billType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Fivouchered\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"voucherNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"isHasMaterialReq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"returnCompany.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.confirmTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"entrys.feedStandard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"entrys.totalReceivedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /><t:Column t:key=\"fodderSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isHasSaleOrder\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol50\" /><t:Column t:key=\"isHasSaleReturn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol51\" /><t:Column t:key=\"entrys.remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batch.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"settlePolicy.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"weekDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol55\" /><t:Column t:key=\"indate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol56\" /><t:Column t:key=\"batchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol57\" /><t:Column t:key=\"supplier.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"car.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isTiLiao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol60\" /><t:Column t:key=\"isOtherIssue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isHasSaleIssue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"isFromTiaoLiao\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isSanZhuang\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmerPhone\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmAddress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"prntTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol68\" /><t:Column t:key=\"bunker\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"returnOpinion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.productionDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol71\" /><t:Column t:key=\"entrys.shift\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol72\" /><t:Column t:key=\"entrys.hjFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol73\" /><t:Column t:key=\"costCenter.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breedData.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedInstance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol76\" /><t:Column t:key=\"earlyStand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol77\" /><t:Column t:key=\"earlyVou\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol78\" /><t:Column t:key=\"earlyAudit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol79\" /><t:Column t:key=\"earlyUnAudit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol80\" /><t:Column t:key=\"earlyAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol81\" /><t:Column t:key=\"midStand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol82\" /><t:Column t:key=\"midVouch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol83\" /><t:Column t:key=\"midAudit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol84\" /><t:Column t:key=\"midUnAudit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol85\" /><t:Column t:key=\"midAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol86\" /><t:Column t:key=\"lateStand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol87\" /><t:Column t:key=\"lateVoucher\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol88\" /><t:Column t:key=\"lateAudit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol89\" /><t:Column t:key=\"lateUnAudit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol90\" /><t:Column t:key=\"lateAllow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol91\" /><t:Column t:key=\"contractQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol92\" /><t:Column t:key=\"allowProcess\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{farmer.name}</t:Cell><t:Cell>$Resource{entrys.farmer.name}</t:Cell><t:Cell>$Resource{entrys.materialName}</t:Cell><t:Cell>$Resource{entrys.receiveQty}</t:Cell><t:Cell>$Resource{entrys.receivePrice}</t:Cell><t:Cell>$Resource{entrys.amount}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{storageOrgUnit.name}</t:Cell><t:Cell>$Resource{entrys.warehouse.name}</t:Cell><t:Cell>$Resource{farm.name}</t:Cell><t:Cell>$Resource{batchContract.number}</t:Cell><t:Cell>$Resource{entrys.bagQty}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{company.name}</t:Cell><t:Cell>$Resource{entrys.confirmQty}</t:Cell><t:Cell>$Resource{entrys.farm.name}</t:Cell><t:Cell>$Resource{entrys.batch.number}</t:Cell><t:Cell>$Resource{entrys.batchContract.number}</t:Cell><t:Cell>$Resource{entrys.unitCost}</t:Cell><t:Cell>$Resource{entrys.actualCost}</t:Cell><t:Cell>$Resource{entrys.id}</t:Cell><t:Cell>$Resource{entrys.seq}</t:Cell><t:Cell>$Resource{entrys.unitQty}</t:Cell><t:Cell>$Resource{isInit}</t:Cell><t:Cell>$Resource{entrys.weekAge}</t:Cell><t:Cell>$Resource{entrys.driver.drivername}</t:Cell><t:Cell>$Resource{driver.drivername}</t:Cell><t:Cell>$Resource{carNo}</t:Cell><t:Cell>$Resource{linkCell}</t:Cell><t:Cell>$Resource{bizPerson.name}</t:Cell><t:Cell>$Resource{person.name}</t:Cell><t:Cell>$Resource{entrys.model}</t:Cell><t:Cell>$Resource{entrys.unit.name}</t:Cell><t:Cell>$Resource{entrys.basePrice}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{auditor.name}</t:Cell><t:Cell>$Resource{auditTime}</t:Cell><t:Cell>$Resource{entrys.person.name}</t:Cell><t:Cell>$Resource{entrys.bizPerson.name}</t:Cell><t:Cell>$Resource{billType}</t:Cell><t:Cell>$Resource{Fivouchered}</t:Cell><t:Cell>$Resource{voucherNum}</t:Cell><t:Cell>$Resource{isHasMaterialReq}</t:Cell><t:Cell>$Resource{returnCompany.name}</t:Cell><t:Cell>$Resource{entrys.confirmTime}</t:Cell><t:Cell>$Resource{entrys.feedStandard}</t:Cell><t:Cell>$Resource{entrys.totalReceivedQty}</t:Cell><t:Cell>$Resource{fodderSourceType}</t:Cell><t:Cell>$Resource{isHasSaleOrder}</t:Cell><t:Cell>$Resource{isHasSaleReturn}</t:Cell><t:Cell>$Resource{entrys.remark}</t:Cell><t:Cell>$Resource{batch.name}</t:Cell><t:Cell>$Resource{settlePolicy.name}</t:Cell><t:Cell>$Resource{weekDay}</t:Cell><t:Cell>$Resource{indate}</t:Cell><t:Cell>$Resource{batchQty}</t:Cell><t:Cell>$Resource{supplier.name}</t:Cell><t:Cell>$Resource{car.number}</t:Cell><t:Cell>$Resource{isTiLiao}</t:Cell><t:Cell>$Resource{isOtherIssue}</t:Cell><t:Cell>$Resource{isHasSaleIssue}</t:Cell><t:Cell>$Resource{isFromTiaoLiao}</t:Cell><t:Cell>$Resource{isSanZhuang}</t:Cell><t:Cell>$Resource{farmerPhone}</t:Cell><t:Cell>$Resource{farmAddress}</t:Cell><t:Cell>$Resource{isWeight}</t:Cell><t:Cell>$Resource{prntTime}</t:Cell><t:Cell>$Resource{bunker}</t:Cell><t:Cell>$Resource{returnOpinion}</t:Cell><t:Cell>$Resource{entrys.productionDate}</t:Cell><t:Cell>$Resource{entrys.shift}</t:Cell><t:Cell>$Resource{entrys.hjFee}</t:Cell><t:Cell>$Resource{costCenter.name}</t:Cell><t:Cell>$Resource{breedData.name}</t:Cell><t:Cell>$Resource{feedInstance}</t:Cell><t:Cell>$Resource{earlyStand}</t:Cell><t:Cell>$Resource{earlyVou}</t:Cell><t:Cell>$Resource{earlyAudit}</t:Cell><t:Cell>$Resource{earlyUnAudit}</t:Cell><t:Cell>$Resource{earlyAllow}</t:Cell><t:Cell>$Resource{midStand}</t:Cell><t:Cell>$Resource{midVouch}</t:Cell><t:Cell>$Resource{midAudit}</t:Cell><t:Cell>$Resource{midUnAudit}</t:Cell><t:Cell>$Resource{midAllow}</t:Cell><t:Cell>$Resource{lateStand}</t:Cell><t:Cell>$Resource{lateVoucher}</t:Cell><t:Cell>$Resource{lateAudit}</t:Cell><t:Cell>$Resource{lateUnAudit}</t:Cell><t:Cell>$Resource{lateAllow}</t:Cell><t:Cell>$Resource{contractQty}</t:Cell><t:Cell>$Resource{allowProcess}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"bizDate","farmer.name","entrys.farmer.name","entrys.materialName","entrys.receiveQty","entrys.receivePrice","entrys.amount","number","billStatus","storageOrgUnit.name","warehouse.name","farm.name","batchContract.number","entrys.bagQty","id","company.name","entrys.confirmQty","entrys.farm.name","entrys.batch.number","entrys.batchContract.number","entrys.unitCost","entrys.actualCost","entrys.id","entrys.seq","entrys.unitQty","isInit","entrys.weekAge","entrys.driver.drivername","driver.drivername","carNo","linkCell","bizPerson.name","person.name","entrys.model","unit.name","entrys.basePrice","description","auditor.name","auditTime","entrys.person.name","entrys.bizPerson.name","billType","Fivouchered","voucherNum","isHasMaterialReq","returnCompany.name","entrys.confirmTime","entrys.feedStandard","entrys.totalReceivedQty","fodderSourceType","isHasSaleOrder","isHasSaleReturn","entrys.remark","batch.name","settlePolicy.name","weekDay","indate","batchQty","supplier.name","car.number","isTiLiao","isOtherIssue","isHasSaleIssue","isFromTiaoLiao","isSanZhuang","farmerPhone","farmAddress","isWeight","prntTime","bunker","returnOpinion","entrys.productionDate","entrys.shift","entrys.hjFee","costCenter.name","breedData.name","feedInstance","earlyStand","earlyVou","earlyAudit","earlyUnAudit","earlyAllow","midStand","midVouch","midAudit","midUnAudit","midAllow","lateStand","lateVoucher","lateAudit","lateUnAudit","lateAllow","contractQty","allowProcess"});


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
        // btnClose
        this.btnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnClose.setText(resHelper.getString("btnClose.text"));		
        this.btnClose.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_close"));
        // btnUnClose
        this.btnUnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnClose.setText(resHelper.getString("btnUnClose.text"));		
        this.btnUnClose.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTable_success"));
        // btnBatchSubmit
        this.btnBatchSubmit.setAction((IItemAction)ActionProxyFactory.getProxy(actionBatchSubmit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBatchSubmit.setText(resHelper.getString("btnBatchSubmit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator6
        // ChkVoucherFlag
        this.ChkVoucherFlag.setAction((IItemAction)ActionProxyFactory.getProxy(actionChkVoucherFlag, new Class[] { IItemAction.class }, getServiceContext()));		
        this.ChkVoucherFlag.setText(resHelper.getString("ChkVoucherFlag.text"));
        // btnChkVoucherAll
        this.btnChkVoucherAll.setAction((IItemAction)ActionProxyFactory.getProxy(actionChkVoucherAll, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnChkVoucherAll.setText(resHelper.getString("btnChkVoucherAll.text"));
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
        menuBiz.add(newSeparator6);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemPCVoucher);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(ChkVoucherFlag);
        menuBiz.add(btnChkVoucherAll);
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
        this.toolBar.add(btnClose);
        this.toolBar.add(btnUnClose);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnBatchSubmit);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderReceptionListUIHandler";
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
        sic.add(new SelectorItemInfo("storageOrgUnit.name"));
        sic.add(new SelectorItemInfo("entrys.material.number"));
        sic.add(new SelectorItemInfo("entrys.materialName"));
        sic.add(new SelectorItemInfo("entrys.model"));
        sic.add(new SelectorItemInfo("warehouse.name"));
        sic.add(new SelectorItemInfo("entrys.receiveQty"));
        sic.add(new SelectorItemInfo("entrys.confirmQty"));
        sic.add(new SelectorItemInfo("entrys.receivePrice"));
        sic.add(new SelectorItemInfo("unit.name"));
        sic.add(new SelectorItemInfo("entrys.amount"));
        sic.add(new SelectorItemInfo("entrys.basePrice"));
        sic.add(new SelectorItemInfo("entrys.unitQty"));
        sic.add(new SelectorItemInfo("entrys.bagQty"));
        sic.add(new SelectorItemInfo("entrys.farmer.name"));
        sic.add(new SelectorItemInfo("entrys.farm.name"));
        sic.add(new SelectorItemInfo("stockingBatch.name"));
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("entrys.weekAge"));
        sic.add(new SelectorItemInfo("entrys.driver.drivername"));
        sic.add(new SelectorItemInfo("entrys.batch.number"));
        sic.add(new SelectorItemInfo("entrys.batchContract.number"));
        sic.add(new SelectorItemInfo("entrys.unitCost"));
        sic.add(new SelectorItemInfo("entrys.actualCost"));
        sic.add(new SelectorItemInfo("driver.drivername"));
        sic.add(new SelectorItemInfo("carNo"));
        sic.add(new SelectorItemInfo("linkCell"));
        sic.add(new SelectorItemInfo("bizPerson.name"));
        sic.add(new SelectorItemInfo("person.name"));
        sic.add(new SelectorItemInfo("entrys.person.name"));
        sic.add(new SelectorItemInfo("entrys.bizPerson.name"));
        sic.add(new SelectorItemInfo("billType"));
        sic.add(new SelectorItemInfo("voucherNum"));
        sic.add(new SelectorItemInfo("Fivouchered"));
        sic.add(new SelectorItemInfo("isHasMaterialReq"));
        sic.add(new SelectorItemInfo("returnCompany.name"));
        sic.add(new SelectorItemInfo("entrys.confirmTime"));
        sic.add(new SelectorItemInfo("entrys.feedStandard"));
        sic.add(new SelectorItemInfo("entrys.totalReceivedQty"));
        sic.add(new SelectorItemInfo("fodderSourceType"));
        sic.add(new SelectorItemInfo("isHasSaleOrder"));
        sic.add(new SelectorItemInfo("isHasSaleReturn"));
        sic.add(new SelectorItemInfo("entrys.remark"));
        sic.add(new SelectorItemInfo("farmer.name"));
        sic.add(new SelectorItemInfo("farm.name"));
        sic.add(new SelectorItemInfo("batchContract.number"));
        sic.add(new SelectorItemInfo("batch.name"));
        sic.add(new SelectorItemInfo("settlePolicy.name"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("indate"));
        sic.add(new SelectorItemInfo("batchQty"));
        sic.add(new SelectorItemInfo("supplier.name"));
        sic.add(new SelectorItemInfo("car.number"));
        sic.add(new SelectorItemInfo("isTiLiao"));
        sic.add(new SelectorItemInfo("isOtherIssue"));
        sic.add(new SelectorItemInfo("isHasSaleIssue"));
        sic.add(new SelectorItemInfo("isFromTiaoLiao"));
        sic.add(new SelectorItemInfo("isSanZhuang"));
        sic.add(new SelectorItemInfo("farmerPhone"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("isWeight"));
        sic.add(new SelectorItemInfo("prntTime"));
        sic.add(new SelectorItemInfo("bunker"));
        sic.add(new SelectorItemInfo("returnOpinion"));
        sic.add(new SelectorItemInfo("entrys.productionDate"));
        sic.add(new SelectorItemInfo("entrys.shift"));
        sic.add(new SelectorItemInfo("entrys.hjFee"));
        sic.add(new SelectorItemInfo("costCenter.name"));
        sic.add(new SelectorItemInfo("breedData.name"));
        sic.add(new SelectorItemInfo("feedInstance"));
        sic.add(new SelectorItemInfo("earlyStand"));
        sic.add(new SelectorItemInfo("earlyVou"));
        sic.add(new SelectorItemInfo("earlyAudit"));
        sic.add(new SelectorItemInfo("earlyUnAudit"));
        sic.add(new SelectorItemInfo("earlyAllow"));
        sic.add(new SelectorItemInfo("midStand"));
        sic.add(new SelectorItemInfo("midVouch"));
        sic.add(new SelectorItemInfo("midAudit"));
        sic.add(new SelectorItemInfo("midUnAudit"));
        sic.add(new SelectorItemInfo("midAllow"));
        sic.add(new SelectorItemInfo("lateStand"));
        sic.add(new SelectorItemInfo("lateVoucher"));
        sic.add(new SelectorItemInfo("lateAudit"));
        sic.add(new SelectorItemInfo("lateUnAudit"));
        sic.add(new SelectorItemInfo("lateAllow"));
        sic.add(new SelectorItemInfo("contractQty"));
        sic.add(new SelectorItemInfo("allowProcess"));
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
        pkList.add("entrys.id"); 
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
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionViewStdUse_actionPerformed method
     */
    public void actionViewStdUse_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().viewStdUse(editData);
    }
    	

    /**
     * output actionChkVoucherFlag_actionPerformed method
     */
    public void actionChkVoucherFlag_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().chkVoucherFlag(editData);
    }
    	

    /**
     * output actionChkVoucherAll_actionPerformed method
     */
    public void actionChkVoucherAll_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().chkVoucherAll(editData);
    }
    	

    /**
     * output actionBatchSubmit_actionPerformed method
     */
    public void actionBatchSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().batchSubmit(editData);
    }
    	

    /**
     * output actionClose_actionPerformed method
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().close(editData);
    }
    	

    /**
     * output actionUnClose_actionPerformed method
     */
    public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().unClose(editData);
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
	public RequestContext prepareActionViewStdUse(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewStdUse() {
    	return false;
    }
	public RequestContext prepareActionChkVoucherFlag(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChkVoucherFlag() {
    	return false;
    }
	public RequestContext prepareActionChkVoucherAll(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChkVoucherAll() {
    	return false;
    }
	public RequestContext prepareActionBatchSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBatchSubmit() {
    	return false;
    }
	public RequestContext prepareActionClose(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionClose() {
    	return false;
    }
	public RequestContext prepareActionUnClose(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnClose() {
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
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionTDPrint", "actionTDPrint_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionTDPrintPreview", "actionTDPrintPreview_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionViewStdUse class
     */     
    protected class ActionViewStdUse extends ItemAction {     
    
        public ActionViewStdUse()
        {
            this(null);
        }

        public ActionViewStdUse(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewStdUse.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewStdUse.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewStdUse.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionViewStdUse", "actionViewStdUse_actionPerformed", e);
        }
    }

    /**
     * output ActionChkVoucherFlag class
     */     
    protected class ActionChkVoucherFlag extends ItemAction {     
    
        public ActionChkVoucherFlag()
        {
            this(null);
        }

        public ActionChkVoucherFlag(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChkVoucherFlag.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherFlag.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherFlag.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionChkVoucherFlag", "actionChkVoucherFlag_actionPerformed", e);
        }
    }

    /**
     * output ActionChkVoucherAll class
     */     
    protected class ActionChkVoucherAll extends ItemAction {     
    
        public ActionChkVoucherAll()
        {
            this(null);
        }

        public ActionChkVoucherAll(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChkVoucherAll.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherAll.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherAll.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionChkVoucherAll", "actionChkVoucherAll_actionPerformed", e);
        }
    }

    /**
     * output ActionBatchSubmit class
     */     
    protected class ActionBatchSubmit extends ItemAction {     
    
        public ActionBatchSubmit()
        {
            this(null);
        }

        public ActionBatchSubmit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBatchSubmit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchSubmit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchSubmit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionBatchSubmit", "actionBatchSubmit_actionPerformed", e);
        }
    }

    /**
     * output ActionClose class
     */     
    protected class ActionClose extends ItemAction {     
    
        public ActionClose()
        {
            this(null);
        }

        public ActionClose(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionClose.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionClose.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionClose.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionClose", "actionClose_actionPerformed", e);
        }
    }

    /**
     * output ActionUnClose class
     */     
    protected class ActionUnClose extends ItemAction {     
    
        public ActionUnClose()
        {
            this(null);
        }

        public ActionUnClose(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnClose.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnClose.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnClose.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionListUI.this, "ActionUnClose", "actionUnClose_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "FodderReceptionListUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.FodderReceptionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo();		
        return objectValue;
    }

    /**
     * output getMergeColumnKeys method
     */
    public String[] getMergeColumnKeys()
    {
        return new String[] {"bizDate","farmer.name","number","billStatus","storageOrgUnit.name","entrys.warehouse.name","farm.name","batchContract.number","id","company.name","isInit","driver.drivername","carNo","linkCell","person.name","entrys.unit.name","description","auditor.name","auditTime","billType","Fivouchered","voucherNum","isHasMaterialReq","returnCompany.name","fodderSourceType","isHasSaleOrder","isHasSaleReturn","batch.name","settlePolicy.name","weekDay","indate","batchQty","supplier.name","car.number","isTiLiao","isOtherIssue","isHasSaleIssue","isFromTiaoLiao","isSanZhuang","farmerPhone","farmAddress","isWeight","prntTime","bunker","returnOpinion","costCenter.name","breedData.name","feedInstance","earlyStand","earlyVou","earlyAudit","earlyUnAudit","earlyAllow","midStand","midVouch","midAudit","midUnAudit","midAllow","lateStand","lateVoucher","lateAudit","lateUnAudit","lateAllow","contractQty","allowProcess"};
    }



	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/FodderReception";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderReceptionQuery");
	}        
				protected boolean isFootVisible() {
			return true;
		}


}