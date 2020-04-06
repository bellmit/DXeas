/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractCKSettleBillListUI extends com.kingdee.eas.framework.client.CoreBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCKSettleBillListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdateSaled;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBatchSettle;
    protected ActionTDPrint actionTDPrint = null;
    protected ActionTDPrintPreview actionTDPrintPreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionClose actionClose = null;
    protected ActionUnClose actionUnClose = null;
    protected ActionUpdateActAmt actionUpdateActAmt = null;
    protected ActionUpdateSale actionUpdateSale = null;
    protected ActionHasPay actionHasPay = null;
    public final static String STATUS_VIEW = "VIEW";
    /**
     * output class constructor
     */
    public AbstractCKSettleBillListUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCKSettleBillListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app", "CKSettleBillListQuery");
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
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
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
        //actionUpdateActAmt
        this.actionUpdateActAmt = new ActionUpdateActAmt(this);
        getActionManager().registerAction("actionUpdateActAmt", actionUpdateActAmt);
        this.actionUpdateActAmt.setExtendProperty("canForewarn", "true");
        this.actionUpdateActAmt.setExtendProperty("userDefined", "true");
        this.actionUpdateActAmt.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateActAmt.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateActAmt.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUpdateSale
        this.actionUpdateSale = new ActionUpdateSale(this);
        getActionManager().registerAction("actionUpdateSale", actionUpdateSale);
        this.actionUpdateSale.setExtendProperty("canForewarn", "true");
        this.actionUpdateSale.setExtendProperty("userDefined", "true");
        this.actionUpdateSale.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateSale.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateSale.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionHasPay
        this.actionHasPay = new ActionHasPay(this);
        getActionManager().registerAction("actionHasPay", actionHasPay);
        this.actionHasPay.setExtendProperty("canForewarn", "true");
        this.actionHasPay.setExtendProperty("userDefined", "true");
        this.actionHasPay.setExtendProperty("isObjectUpdateLock", "false");
         this.actionHasPay.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionHasPay.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.btnUpdateSaled = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBatchSettle = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateSaled.setName("btnUpdateSaled");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnClose.setName("btnClose");
        this.btnUnClose.setName("btnUnClose");
        this.btnBatchSettle.setName("btnBatchSettle");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol58\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol59\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol61\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol62\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol64\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol71\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol72\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol73\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol75\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol77\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol78\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol80\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol81\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol82\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol83\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol84\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol85\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol86\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol87\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol88\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol92\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol98\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol99\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol100\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol101\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol102\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol109\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol110\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol111\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol117\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol118\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol119\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol120\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol121\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol122\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol123\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol124\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol125\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol126\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol127\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol128\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol129\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol130\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol131\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol132\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol133\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol134\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol139\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol140\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol141\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol142\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol145\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol146\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol147\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol148\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol150\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol152\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol153\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol154\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol159\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol160\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol161\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol162\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmer.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"settleWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmeronlyPro\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"farmerOnlyProOne\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"punishAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chickenRetunAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"dyFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"singleDyFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chickenAveWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"meatRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"survivalRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"singleDrugAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"oValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"drugAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"punishWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"singleFeedWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"actualPayAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beforeBatchAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"nowAccountBac\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastUpdateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditor.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"auditor.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"creator.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"creator.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lastUpdateUser.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"lastUpdateUser.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"handler.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"handler.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"Fivouchered\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"FICompany.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storageOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farm.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchContract.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batch.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breedData.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cFBeginDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cFEndDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"conFeedPolicy.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"conFeededNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bEBank.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bankNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bEBankAddress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"person.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol58\" /><t:Column t:key=\"preHouseWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol59\" /><t:Column t:key=\"mlyAllAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"marginAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol61\" /><t:Column t:key=\"adPayAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol62\" /><t:Column t:key=\"isHasPaymentBill\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isKouBZJ\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol64\" /><t:Column t:key=\"mRatePAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"actualMRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"standardMRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"drugLackPAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"singleActualDrug\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"singleStandardDrug\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"marginOccupyFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol71\" /><t:Column t:key=\"batchOccupyMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol72\" /><t:Column t:key=\"standardMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol73\" /><t:Column t:key=\"singleMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"conFeedSubsidies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol75\" /><t:Column t:key=\"kbConFeedPolicy.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"contractCKWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol77\" /><t:Column t:key=\"freightDiffSubsidies\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol78\" /><t:Column t:key=\"lFeedWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"freightPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol80\" /><t:Column t:key=\"freightSubsidiesStd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol81\" /><t:Column t:key=\"deductMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol82\" /><t:Column t:key=\"totalMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol83\" /><t:Column t:key=\"occupyMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol84\" /><t:Column t:key=\"enableMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol85\" /><t:Column t:key=\"deductAdPayAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol86\" /><t:Column t:key=\"loanRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol87\" /><t:Column t:key=\"kYFKOccupyFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol88\" /><t:Column t:key=\"auditTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"conFeedContract.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fmRatePunishStd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dyfBalance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol92\" /><t:Column t:key=\"kbItemAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"QCItemAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"viewItemAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"otherItemAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"tempItemAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"moneyOccupyDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol98\" /><t:Column t:key=\"conFeedPolicySub\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol99\" /><t:Column t:key=\"payOweMonery\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol100\" /><t:Column t:key=\"outSaleKbAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol101\" /><t:Column t:key=\"payOweMoneryB\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol102\" /><t:Column t:key=\"SeedCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fodderCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"drugCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allocateAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unLockedMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol109\" /><t:Column t:key=\"recSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol110\" /><t:Column t:key=\"adPayBalance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol111\" /><t:Column t:key=\"printTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"settlePolicy.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"QCKbDetail\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"otherKbDetail\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmsType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outSaleKbAmt2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol117\" /><t:Column t:key=\"immuneCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol118\" /><t:Column t:key=\"immuneCostOne\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol119\" /><t:Column t:key=\"cleanHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol120\" /><t:Column t:key=\"cleanHouseOne\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol121\" /><t:Column t:key=\"reserveRiskCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol122\" /><t:Column t:key=\"actualFoder\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol123\" /><t:Column t:key=\"standFodder\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol124\" /><t:Column t:key=\"oneMrgin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol125\" /><t:Column t:key=\"marginGAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol126\" /><t:Column t:key=\"longBorrowAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol127\" /><t:Column t:key=\"longBorrowReturn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol128\" /><t:Column t:key=\"marginProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol129\" /><t:Column t:key=\"borrowAmiunt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol130\" /><t:Column t:key=\"specialBorrowinst\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol131\" /><t:Column t:key=\"tranCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol132\" /><t:Column t:key=\"brokenCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol133\" /><t:Column t:key=\"coalCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol134\" /><t:Column t:key=\"idCodeCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmAddress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"noCalFodderPunish\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"noCalDrupPunish\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"equipmentReAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol139\" /><t:Column t:key=\"specialPermitAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol140\" /><t:Column t:key=\"getChickCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol141\" /><t:Column t:key=\"cleanHouseCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol142\" /><t:Column t:key=\"chickenSource\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"period.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"daiyFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol145\" /><t:Column t:key=\"companyProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol146\" /><t:Column t:key=\"cleanTowerCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol147\" /><t:Column t:key=\"assetsOccupy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol148\" /><t:Column t:key=\"costCenter.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entrys.isOrdinary\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol150\" /><t:Column t:key=\"isOrdinary\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"drugQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol152\" /><t:Column t:key=\"noPfoRetAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol153\" /><t:Column t:key=\"otherMatCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol154\" /><t:Column t:key=\"actualVoucher\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"preVoucher\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"transVoucher\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hasPay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"proDiv\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol159\" /><t:Column t:key=\"companyTC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol160\" /><t:Column t:key=\"diverCt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol161\" /><t:Column t:key=\"actfeedDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol162\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{farmer.name}</t:Cell><t:Cell>$Resource{recDate}</t:Cell><t:Cell>$Resource{recQty}</t:Cell><t:Cell>$Resource{settleWgt}</t:Cell><t:Cell>$Resource{farmeronlyPro}</t:Cell><t:Cell>$Resource{farmerOnlyProOne}</t:Cell><t:Cell>$Resource{punishAmt}</t:Cell><t:Cell>$Resource{chickenRetunAmt}</t:Cell><t:Cell>$Resource{dyFee}</t:Cell><t:Cell>$Resource{singleDyFee}</t:Cell><t:Cell>$Resource{chickenAveWgt}</t:Cell><t:Cell>$Resource{meatRate}</t:Cell><t:Cell>$Resource{survivalRate}</t:Cell><t:Cell>$Resource{singleDrugAmt}</t:Cell><t:Cell>$Resource{feedDays}</t:Cell><t:Cell>$Resource{oValue}</t:Cell><t:Cell>$Resource{recAmt}</t:Cell><t:Cell>$Resource{batchQty}</t:Cell><t:Cell>$Resource{batchAmt}</t:Cell><t:Cell>$Resource{feedWgt}</t:Cell><t:Cell>$Resource{feedAmt}</t:Cell><t:Cell>$Resource{drugAmt}</t:Cell><t:Cell>$Resource{punishWgt}</t:Cell><t:Cell>$Resource{singleFeedWgt}</t:Cell><t:Cell>$Resource{actualPayAmt}</t:Cell><t:Cell>$Resource{beforeBatchAmount}</t:Cell><t:Cell>$Resource{nowAccountBac}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{lastUpdateTime}</t:Cell><t:Cell>$Resource{auditor.number}</t:Cell><t:Cell>$Resource{auditor.name}</t:Cell><t:Cell>$Resource{creator.number}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{lastUpdateUser.number}</t:Cell><t:Cell>$Resource{lastUpdateUser.name}</t:Cell><t:Cell>$Resource{handler.number}</t:Cell><t:Cell>$Resource{handler.name}</t:Cell><t:Cell>$Resource{Fivouchered}</t:Cell><t:Cell>$Resource{FICompany.name}</t:Cell><t:Cell>$Resource{storageOrgUnit.name}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{farm.name}</t:Cell><t:Cell>$Resource{batchContract.number}</t:Cell><t:Cell>$Resource{batch.name}</t:Cell><t:Cell>$Resource{breedData.name}</t:Cell><t:Cell>$Resource{cFBeginDate}</t:Cell><t:Cell>$Resource{cFEndDate}</t:Cell><t:Cell>$Resource{conFeedPolicy.name}</t:Cell><t:Cell>$Resource{conFeededNum}</t:Cell><t:Cell>$Resource{bEBank.name}</t:Cell><t:Cell>$Resource{bankNum}</t:Cell><t:Cell>$Resource{bEBankAddress}</t:Cell><t:Cell>$Resource{person.name}</t:Cell><t:Cell>$Resource{inDate}</t:Cell><t:Cell>$Resource{feedQty}</t:Cell><t:Cell>$Resource{preHouseWgt}</t:Cell><t:Cell>$Resource{mlyAllAmt}</t:Cell><t:Cell>$Resource{marginAmt}</t:Cell><t:Cell>$Resource{adPayAmount}</t:Cell><t:Cell>$Resource{isHasPaymentBill}</t:Cell><t:Cell>$Resource{isKouBZJ}</t:Cell><t:Cell>$Resource{mRatePAmt}</t:Cell><t:Cell>$Resource{actualMRate}</t:Cell><t:Cell>$Resource{standardMRate}</t:Cell><t:Cell>$Resource{drugLackPAmt}</t:Cell><t:Cell>$Resource{singleActualDrug}</t:Cell><t:Cell>$Resource{singleStandardDrug}</t:Cell><t:Cell>$Resource{marginOccupyFee}</t:Cell><t:Cell>$Resource{batchOccupyMargin}</t:Cell><t:Cell>$Resource{standardMargin}</t:Cell><t:Cell>$Resource{singleMargin}</t:Cell><t:Cell>$Resource{conFeedSubsidies}</t:Cell><t:Cell>$Resource{kbConFeedPolicy.name}</t:Cell><t:Cell>$Resource{contractCKWgt}</t:Cell><t:Cell>$Resource{freightDiffSubsidies}</t:Cell><t:Cell>$Resource{lFeedWgt}</t:Cell><t:Cell>$Resource{freightPrice}</t:Cell><t:Cell>$Resource{freightSubsidiesStd}</t:Cell><t:Cell>$Resource{deductMargin}</t:Cell><t:Cell>$Resource{totalMargin}</t:Cell><t:Cell>$Resource{occupyMargin}</t:Cell><t:Cell>$Resource{enableMargin}</t:Cell><t:Cell>$Resource{deductAdPayAmt}</t:Cell><t:Cell>$Resource{loanRate}</t:Cell><t:Cell>$Resource{kYFKOccupyFee}</t:Cell><t:Cell>$Resource{auditTime}</t:Cell><t:Cell>$Resource{conFeedContract.number}</t:Cell><t:Cell>$Resource{fmRatePunishStd}</t:Cell><t:Cell>$Resource{dyfBalance}</t:Cell><t:Cell>$Resource{kbItemAmt}</t:Cell><t:Cell>$Resource{QCItemAmt}</t:Cell><t:Cell>$Resource{viewItemAmt}</t:Cell><t:Cell>$Resource{otherItemAmt}</t:Cell><t:Cell>$Resource{tempItemAmt}</t:Cell><t:Cell>$Resource{moneyOccupyDays}</t:Cell><t:Cell>$Resource{conFeedPolicySub}</t:Cell><t:Cell>$Resource{payOweMonery}</t:Cell><t:Cell>$Resource{outSaleKbAmt}</t:Cell><t:Cell>$Resource{payOweMoneryB}</t:Cell><t:Cell>$Resource{SeedCost}</t:Cell><t:Cell>$Resource{fodderCost}</t:Cell><t:Cell>$Resource{drugCost}</t:Cell><t:Cell>$Resource{allocateAmt}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{allCost}</t:Cell><t:Cell>$Resource{unLockedMargin}</t:Cell><t:Cell>$Resource{recSuttle}</t:Cell><t:Cell>$Resource{adPayBalance}</t:Cell><t:Cell>$Resource{printTime}</t:Cell><t:Cell>$Resource{settlePolicy.name}</t:Cell><t:Cell>$Resource{QCKbDetail}</t:Cell><t:Cell>$Resource{otherKbDetail}</t:Cell><t:Cell>$Resource{farmsType}</t:Cell><t:Cell>$Resource{outSaleKbAmt2}</t:Cell><t:Cell>$Resource{immuneCost}</t:Cell><t:Cell>$Resource{immuneCostOne}</t:Cell><t:Cell>$Resource{cleanHouse}</t:Cell><t:Cell>$Resource{cleanHouseOne}</t:Cell><t:Cell>$Resource{reserveRiskCost}</t:Cell><t:Cell>$Resource{actualFoder}</t:Cell><t:Cell>$Resource{standFodder}</t:Cell><t:Cell>$Resource{oneMrgin}</t:Cell><t:Cell>$Resource{marginGAmount}</t:Cell><t:Cell>$Resource{longBorrowAmount}</t:Cell><t:Cell>$Resource{longBorrowReturn}</t:Cell><t:Cell>$Resource{marginProfit}</t:Cell><t:Cell>$Resource{borrowAmiunt}</t:Cell><t:Cell>$Resource{specialBorrowinst}</t:Cell><t:Cell>$Resource{tranCost}</t:Cell><t:Cell>$Resource{brokenCost}</t:Cell><t:Cell>$Resource{coalCost}</t:Cell><t:Cell>$Resource{idCodeCode}</t:Cell><t:Cell>$Resource{farmAddress}</t:Cell><t:Cell>$Resource{noCalFodderPunish}</t:Cell><t:Cell>$Resource{noCalDrupPunish}</t:Cell><t:Cell>$Resource{equipmentReAmt}</t:Cell><t:Cell>$Resource{specialPermitAmt}</t:Cell><t:Cell>$Resource{getChickCost}</t:Cell><t:Cell>$Resource{cleanHouseCost}</t:Cell><t:Cell>$Resource{chickenSource}</t:Cell><t:Cell>$Resource{period.number}</t:Cell><t:Cell>$Resource{daiyFee}</t:Cell><t:Cell>$Resource{companyProfit}</t:Cell><t:Cell>$Resource{cleanTowerCost}</t:Cell><t:Cell>$Resource{assetsOccupy}</t:Cell><t:Cell>$Resource{costCenter.name}</t:Cell><t:Cell>$Resource{entrys.isOrdinary}</t:Cell><t:Cell>$Resource{isOrdinary}</t:Cell><t:Cell>$Resource{drugQty}</t:Cell><t:Cell>$Resource{noPfoRetAmt}</t:Cell><t:Cell>$Resource{otherMatCost}</t:Cell><t:Cell>$Resource{actualVoucher}</t:Cell><t:Cell>$Resource{preVoucher}</t:Cell><t:Cell>$Resource{transVoucher}</t:Cell><t:Cell>$Resource{hasPay}</t:Cell><t:Cell>$Resource{proDiv}</t:Cell><t:Cell>$Resource{companyTC}</t:Cell><t:Cell>$Resource{diverCt}</t:Cell><t:Cell>$Resource{actfeedDays}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"bizDate","farmer.name","recDate","recQty","settleWgt","farmeronlyPro","farmerOnlyProOne","punishAmt","chickenRetunAmt","dyFee","singleDyFee","chickenAveWgt","meatRate","survivalRate","singleDrugAmt","feedDays","oValue","recAmt","batchQty","batchAmt","feedWgt","feedAmt","drugAmt","punishWgt","singleFeedWgt","actualPayAmt","beforeBatchAmount","nowAccountBac","id","number","description","createTime","lastUpdateTime","auditor.number","auditor.name","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","handler.number","handler.name","Fivouchered","FICompany.name","storageOrgUnit.name","billStatus","farm.name","batchContract.number","batch.name","breedData.name","cFBeginDate","cFEndDate","conFeedPolicy.name","conFeededNum","bEBank.name","bankNum","bEBankAddress","person.name","inDate","feedQty","preHouseWgt","mlyAllAmt","marginAmt","adPayAmount","isHasPaymentBill","isKouBZJ","mRatePAmt","actualMRate","standardMRate","drugLackPAmt","singleActualDrug","singleStandardDrug","marginOccupyFee","batchOccupyMargin","standardMargin","singleMargin","conFeedSubsidies","kbConFeedPolicy.name","contractCKWgt","freightDiffSubsidies","lFeedWgt","freightPrice","freightSubsidiesStd","deductMargin","totalMargin","occupyMargin","enableMargin","deductAdPayAmt","loanRate","kYFKOccupyFee","auditTime","conFeedContract.number","fmRatePunishStd","dyfBalance","kbItemAmt","QCItemAmt","viewItemAmt","otherItemAmt","tempItemAmt","moneyOccupyDays","conFeedPolicySub","payOweMonery","outSaleKbAmt","payOweMoneryB","SeedCost","fodderCost","drugCost","allocateAmt","unitCost","allCost","unLockedMargin","recSuttle","adPayBalance","printTime","settlePolicy.name","QCKbDetail","otherKbDetail","farmsType","outSaleKbAmt2","immuneCost","immuneCostOne","cleanHouse","cleanHouseOne","reserveRiskCost","actualFoder","standFodder","oneMrgin","marginGAmount","longBorrowAmount","longBorrowReturn","marginProfit","borrowAmiunt","specialBorrowinst","tranCost","brokenCost","coalCost","idCodeCode","farmAddress","noCalFodderPunish","noCalDrupPunish","equipmentReAmt","specialPermitAmt","getChickCost","cleanHouseCost","chickenSource","period.number","daiyFee","companyProfit","cleanTowerCost","assetsOccupy","costCenter.name","","isOrdinary","drugQty","noPfoRetAmt","otherMatCost","actualVoucher","preVoucher","transVoucher","hasPay","proDiv","companyTC","diverCt","actfeedDays"});


        this.tblMain.checkParsed();
        this.tblMain.getGroupManager().setGroup(true);		
        this.separatorFW2.setVisible(true);		
        this.btnAuditResult.setVisible(false);		
        this.menuItemCopyTo.setVisible(false);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator6.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // btnUpdateSaled
        this.btnUpdateSaled.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateSale, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateSaled.setText(resHelper.getString("btnUpdateSaled.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnClose
        this.btnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnClose.setText(resHelper.getString("btnClose.text"));
        // btnUnClose
        this.btnUnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnClose.setText(resHelper.getString("btnUnClose.text"));
        // btnBatchSettle		
        this.btnBatchSettle.setText(resHelper.getString("btnBatchSettle.text"));		
        this.btnBatchSettle.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_settleaccounts"));
        this.btnBatchSettle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnBatchSettle_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
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
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemPCVoucher);
        menuBiz.add(menuItemDelPCVoucher);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnUpdateSaled);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnClose);
        this.toolBar.add(btnUnClose);
        this.toolBar.add(btnBatchSettle);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKSettleBillListUIHandler";
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
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

    /**
     * output btnBatchSettle_actionPerformed method
     */
    protected void btnBatchSettle_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

	public SelectorItemCollection getBOTPSelectors() {
			SelectorItemCollection sic = new SelectorItemCollection();
			return sic;
	}

	protected FilterInfo getDefaultFilterForQuery() {
			FilterInfo filter = super.getDefaultFilterForQuery();
			if (filter == null)
				filter = new FilterInfo();
			FilterInfo otherFilter = com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id",true);
			if (otherFilter != null) {
				for(int i=0,n=otherFilter.getFilterItems().size();i<n;i++){
					FilterItemInfo curFilterItem =otherFilter.getFilterItems().get(i);
					if(curFilterItem.getCompareValue()!=null && (curFilterItem.getCompareValue() instanceof String)){
						if("*".equalsIgnoreCase((String)(curFilterItem.getCompareValue()))){
							BOSUuid nullUuid=BOSUuid.create("nullnull");
							curFilterItem.setCompareValue(nullUuid.toString());
						}
					}
				}
				try {	
					if (com.kingdee.eas.framework.util.FilterUtility.hasFilterItem(filter))
						filter.mergeFilter(otherFilter, "AND");
					else
						filter = otherFilter;
				} catch (Exception e) {
					this.handUIException(e);
				}
			}
			return filter;
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
        sic.add(new SelectorItemInfo("handler.number"));
        sic.add(new SelectorItemInfo("handler.name"));
        sic.add(new SelectorItemInfo("Fivouchered"));
        sic.add(new SelectorItemInfo("FICompany.name"));
        sic.add(new SelectorItemInfo("storageOrgUnit.name"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("farmer.name"));
        sic.add(new SelectorItemInfo("farm.name"));
        sic.add(new SelectorItemInfo("batchContract.number"));
        sic.add(new SelectorItemInfo("batch.name"));
        sic.add(new SelectorItemInfo("breedData.name"));
        sic.add(new SelectorItemInfo("cFBeginDate"));
        sic.add(new SelectorItemInfo("cFEndDate"));
        sic.add(new SelectorItemInfo("conFeedPolicy.name"));
        sic.add(new SelectorItemInfo("conFeededNum"));
        sic.add(new SelectorItemInfo("bEBank.name"));
        sic.add(new SelectorItemInfo("bankNum"));
        sic.add(new SelectorItemInfo("bEBankAddress"));
        sic.add(new SelectorItemInfo("person.name"));
        sic.add(new SelectorItemInfo("inDate"));
        sic.add(new SelectorItemInfo("batchQty"));
        sic.add(new SelectorItemInfo("batchAmt"));
        sic.add(new SelectorItemInfo("feedWgt"));
        sic.add(new SelectorItemInfo("feedQty"));
        sic.add(new SelectorItemInfo("feedAmt"));
        sic.add(new SelectorItemInfo("drugAmt"));
        sic.add(new SelectorItemInfo("recDate"));
        sic.add(new SelectorItemInfo("recQty"));
        sic.add(new SelectorItemInfo("preHouseWgt"));
        sic.add(new SelectorItemInfo("punishWgt"));
        sic.add(new SelectorItemInfo("settleWgt"));
        sic.add(new SelectorItemInfo("meatRate"));
        sic.add(new SelectorItemInfo("survivalRate"));
        sic.add(new SelectorItemInfo("chickenAveWgt"));
        sic.add(new SelectorItemInfo("feedDays"));
        sic.add(new SelectorItemInfo("mlyAllAmt"));
        sic.add(new SelectorItemInfo("recAmt"));
        sic.add(new SelectorItemInfo("punishAmt"));
        sic.add(new SelectorItemInfo("marginAmt"));
        sic.add(new SelectorItemInfo("adPayAmount"));
        sic.add(new SelectorItemInfo("dyFee"));
        sic.add(new SelectorItemInfo("singleDyFee"));
        sic.add(new SelectorItemInfo("isHasPaymentBill"));
        sic.add(new SelectorItemInfo("isKouBZJ"));
        sic.add(new SelectorItemInfo("mRatePAmt"));
        sic.add(new SelectorItemInfo("actualMRate"));
        sic.add(new SelectorItemInfo("standardMRate"));
        sic.add(new SelectorItemInfo("drugLackPAmt"));
        sic.add(new SelectorItemInfo("singleActualDrug"));
        sic.add(new SelectorItemInfo("singleStandardDrug"));
        sic.add(new SelectorItemInfo("marginOccupyFee"));
        sic.add(new SelectorItemInfo("batchOccupyMargin"));
        sic.add(new SelectorItemInfo("standardMargin"));
        sic.add(new SelectorItemInfo("singleMargin"));
        sic.add(new SelectorItemInfo("conFeedSubsidies"));
        sic.add(new SelectorItemInfo("kbConFeedPolicy.name"));
        sic.add(new SelectorItemInfo("contractCKWgt"));
        sic.add(new SelectorItemInfo("freightDiffSubsidies"));
        sic.add(new SelectorItemInfo("lFeedWgt"));
        sic.add(new SelectorItemInfo("freightPrice"));
        sic.add(new SelectorItemInfo("freightSubsidiesStd"));
        sic.add(new SelectorItemInfo("deductMargin"));
        sic.add(new SelectorItemInfo("totalMargin"));
        sic.add(new SelectorItemInfo("occupyMargin"));
        sic.add(new SelectorItemInfo("enableMargin"));
        sic.add(new SelectorItemInfo("deductAdPayAmt"));
        sic.add(new SelectorItemInfo("loanRate"));
        sic.add(new SelectorItemInfo("kYFKOccupyFee"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("singleDrugAmt"));
        sic.add(new SelectorItemInfo("singleFeedWgt"));
        sic.add(new SelectorItemInfo("oValue"));
        sic.add(new SelectorItemInfo("conFeedContract.number"));
        sic.add(new SelectorItemInfo("fmRatePunishStd"));
        sic.add(new SelectorItemInfo("dyfBalance"));
        sic.add(new SelectorItemInfo("kbItemAmt"));
        sic.add(new SelectorItemInfo("QCItemAmt"));
        sic.add(new SelectorItemInfo("viewItemAmt"));
        sic.add(new SelectorItemInfo("otherItemAmt"));
        sic.add(new SelectorItemInfo("tempItemAmt"));
        sic.add(new SelectorItemInfo("moneyOccupyDays"));
        sic.add(new SelectorItemInfo("conFeedPolicySub"));
        sic.add(new SelectorItemInfo("payOweMonery"));
        sic.add(new SelectorItemInfo("outSaleKbAmt"));
        sic.add(new SelectorItemInfo("actualPayAmt"));
        sic.add(new SelectorItemInfo("payOweMoneryB"));
        sic.add(new SelectorItemInfo("SeedCost"));
        sic.add(new SelectorItemInfo("fodderCost"));
        sic.add(new SelectorItemInfo("drugCost"));
        sic.add(new SelectorItemInfo("allocateAmt"));
        sic.add(new SelectorItemInfo("unitCost"));
        sic.add(new SelectorItemInfo("allCost"));
        sic.add(new SelectorItemInfo("unLockedMargin"));
        sic.add(new SelectorItemInfo("recSuttle"));
        sic.add(new SelectorItemInfo("adPayBalance"));
        sic.add(new SelectorItemInfo("printTime"));
        sic.add(new SelectorItemInfo("settlePolicy.name"));
        sic.add(new SelectorItemInfo("QCKbDetail"));
        sic.add(new SelectorItemInfo("otherKbDetail"));
        sic.add(new SelectorItemInfo("farmsType"));
        sic.add(new SelectorItemInfo("outSaleKbAmt2"));
        sic.add(new SelectorItemInfo("immuneCost"));
        sic.add(new SelectorItemInfo("immuneCostOne"));
        sic.add(new SelectorItemInfo("cleanHouse"));
        sic.add(new SelectorItemInfo("cleanHouseOne"));
        sic.add(new SelectorItemInfo("reserveRiskCost"));
        sic.add(new SelectorItemInfo("actualFoder"));
        sic.add(new SelectorItemInfo("standFodder"));
        sic.add(new SelectorItemInfo("oneMrgin"));
        sic.add(new SelectorItemInfo("marginGAmount"));
        sic.add(new SelectorItemInfo("chickenRetunAmt"));
        sic.add(new SelectorItemInfo("longBorrowAmount"));
        sic.add(new SelectorItemInfo("longBorrowReturn"));
        sic.add(new SelectorItemInfo("marginProfit"));
        sic.add(new SelectorItemInfo("beforeBatchAmount"));
        sic.add(new SelectorItemInfo("borrowAmiunt"));
        sic.add(new SelectorItemInfo("specialBorrowinst"));
        sic.add(new SelectorItemInfo("tranCost"));
        sic.add(new SelectorItemInfo("brokenCost"));
        sic.add(new SelectorItemInfo("coalCost"));
        sic.add(new SelectorItemInfo("idCodeCode"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("noCalFodderPunish"));
        sic.add(new SelectorItemInfo("noCalDrupPunish"));
        sic.add(new SelectorItemInfo("equipmentReAmt"));
        sic.add(new SelectorItemInfo("specialPermitAmt"));
        sic.add(new SelectorItemInfo("getChickCost"));
        sic.add(new SelectorItemInfo("cleanHouseCost"));
        sic.add(new SelectorItemInfo("chickenSource"));
        sic.add(new SelectorItemInfo("period.number"));
        sic.add(new SelectorItemInfo("daiyFee"));
        sic.add(new SelectorItemInfo("cleanTowerCost"));
        sic.add(new SelectorItemInfo("nowAccountBac"));
        sic.add(new SelectorItemInfo("assetsOccupy"));
        sic.add(new SelectorItemInfo("costCenter.name"));
        sic.add(new SelectorItemInfo("isOrdinary"));
        sic.add(new SelectorItemInfo("drugQty"));
        sic.add(new SelectorItemInfo("noPfoRetAmt"));
        sic.add(new SelectorItemInfo("companyProfit"));
        sic.add(new SelectorItemInfo("farmeronlyPro"));
        sic.add(new SelectorItemInfo("farmerOnlyProOne"));
        sic.add(new SelectorItemInfo("otherMatCost"));
        sic.add(new SelectorItemInfo("actualVoucher"));
        sic.add(new SelectorItemInfo("preVoucher"));
        sic.add(new SelectorItemInfo("transVoucher"));
        sic.add(new SelectorItemInfo("hasPay"));
        sic.add(new SelectorItemInfo("proDiv"));
        sic.add(new SelectorItemInfo("companyTC"));
        sic.add(new SelectorItemInfo("diverCt"));
        sic.add(new SelectorItemInfo("actfeedDays"));
        return sic;
    }            protected java.util.List getQuerySorterFields() 
    { 
        java.util.List sorterFieldList = new ArrayList(); 
        sorterFieldList.add("number"); 
        sorterFieldList.add("rType"); 
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
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionClose_actionPerformed method
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().close(editData);
    }
    	

    /**
     * output actionUnClose_actionPerformed method
     */
    public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().unClose(editData);
    }
    	

    /**
     * output actionUpdateActAmt_actionPerformed method
     */
    public void actionUpdateActAmt_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().updateActAmt(editData);
    }
    	

    /**
     * output actionUpdateSale_actionPerformed method
     */
    public void actionUpdateSale_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().updateSale(editData);
    }
    	

    /**
     * output actionHasPay_actionPerformed method
     */
    public void actionHasPay_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().hasPay(editData);
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
	public RequestContext prepareActionUpdateActAmt(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateActAmt() {
    	return false;
    }
	public RequestContext prepareActionUpdateSale(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateSale() {
    	return false;
    }
	public RequestContext prepareActionHasPay(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionHasPay() {
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
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionTDPrint", "actionTDPrint_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionTDPrintPreview", "actionTDPrintPreview_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionClose", "actionClose_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionUnClose", "actionUnClose_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdateActAmt class
     */     
    protected class ActionUpdateActAmt extends ItemAction {     
    
        public ActionUpdateActAmt()
        {
            this(null);
        }

        public ActionUpdateActAmt(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdateActAmt.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateActAmt.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateActAmt.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionUpdateActAmt", "actionUpdateActAmt_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdateSale class
     */     
    protected class ActionUpdateSale extends ItemAction {     
    
        public ActionUpdateSale()
        {
            this(null);
        }

        public ActionUpdateSale(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdateSale.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateSale.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateSale.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionUpdateSale", "actionUpdateSale_actionPerformed", e);
        }
    }

    /**
     * output ActionHasPay class
     */     
    protected class ActionHasPay extends ItemAction {     
    
        public ActionHasPay()
        {
            this(null);
        }

        public ActionHasPay(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionHasPay.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionHasPay.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionHasPay.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKSettleBillListUI.this, "ActionHasPay", "actionHasPay_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CKSettleBillListUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.CKSettleBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo();		
        return objectValue;
    }

    /**
     * output getMergeColumnKeys method
     */
    public String[] getMergeColumnKeys()
    {
        return new String[] {"bizDate","farmer.name","recDate","recQty","settleWgt","farmeronlyPro","farmerOnlyProOne","punishAmt","chickenRetunAmt","dyFee","singleDyFee","chickenAveWgt","meatRate","survivalRate","singleDrugAmt","feedDays","oValue","recAmt","batchQty","batchAmt","feedWgt","feedAmt","drugAmt","punishWgt","singleFeedWgt","actualPayAmt","beforeBatchAmount","id","number","description","createTime","lastUpdateTime","auditor.number","auditor.name","creator.number","creator.name","lastUpdateUser.number","lastUpdateUser.name","handler.number","handler.name","Fivouchered","FICompany.name","storageOrgUnit.name","billStatus","farm.name","batchContract.number","batch.name","breedData.name","cFBeginDate","cFEndDate","conFeedPolicy.name","conFeededNum","bEBank.name","bankNum","bEBankAddress","person.name","inDate","feedQty","preHouseWgt","mlyAllAmt","marginAmt","adPayAmount","isHasPaymentBill","isKouBZJ","mRatePAmt","actualMRate","standardMRate","drugLackPAmt","singleActualDrug","singleStandardDrug","marginOccupyFee","batchOccupyMargin","standardMargin","singleMargin","conFeedSubsidies","kbConFeedPolicy.name","contractCKWgt","freightDiffSubsidies","lFeedWgt","freightPrice","freightSubsidiesStd","deductMargin","totalMargin","occupyMargin","enableMargin","deductAdPayAmt","loanRate","kYFKOccupyFee","auditTime","conFeedContract.number","fmRatePunishStd","dyfBalance","kbItemAmt","QCItemAmt","viewItemAmt","otherItemAmt","tempItemAmt","moneyOccupyDays","conFeedPolicySub","payOweMonery","outSaleKbAmt","payOweMoneryB","SeedCost","fodderCost","drugCost","allocateAmt","unitCost","allCost","unLockedMargin","recSuttle","adPayBalance","printTime","settlePolicy.name","QCKbDetail","otherKbDetail","farmsType","outSaleKbAmt2","immuneCost","immuneCostOne","cleanHouse","cleanHouseOne","reserveRiskCost","actualFoder","standFodder","oneMrgin","marginGAmount","longBorrowAmount","longBorrowReturn","marginProfit","borrowAmiunt","specialBorrowinst","tranCost","brokenCost","coalCost","idCodeCode","farmAddress","noCalFodderPunish","noCalDrupPunish","equipmentReAmt","specialPermitAmt","getChickCost","cleanHouseCost","chickenSource","period.number","companyProfit","costCenter.name","otherMatCost","actualVoucher","preVoucher","transVoucher","hasPay"};
    }



	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/CKSettleBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKSettleBillQuery");
	}        
				protected boolean isFootVisible() {
			return true;
		}


}