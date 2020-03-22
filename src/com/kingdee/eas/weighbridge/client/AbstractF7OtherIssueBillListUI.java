/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

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
public abstract class AbstractF7OtherIssueBillListUI extends com.kingdee.eas.scm.im.inv.client.InvBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractF7OtherIssueBillListUI.class);
    protected javax.swing.JToolBar.Separator separator10;
    protected javax.swing.JToolBar.Separator separator11;
    /**
     * output class constructor
     */
    public AbstractF7OtherIssueBillListUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractF7OtherIssueBillListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.scm.im.inv", "OtherIssueBillQuery");
        //actionAddNew
        String _tempStr = null;
        actionAddNew.setEnabled(true);
        actionAddNew.setDaemonRun(false);

        actionAddNew.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl N"));
        _tempStr = resHelper.getString("ActionAddNew.SHORT_DESCRIPTION");
        actionAddNew.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddNew.LONG_DESCRIPTION");
        actionAddNew.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddNew.NAME");
        actionAddNew.putValue(ItemAction.NAME, _tempStr);
        this.actionAddNew.setExtendProperty("Mutex", "Lock_SCMIM_CloseAccount,0");
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionEdit
        actionEdit.setEnabled(true);
        actionEdit.setDaemonRun(false);

        actionEdit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
        _tempStr = resHelper.getString("ActionEdit.SHORT_DESCRIPTION");
        actionEdit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionEdit.LONG_DESCRIPTION");
        actionEdit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionEdit.NAME");
        actionEdit.putValue(ItemAction.NAME, _tempStr);
        this.actionEdit.setExtendProperty("Mutex", "Lock_SCMIM_CloseAccount,0");
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionNextPerson
        actionNextPerson.setEnabled(true);
        actionNextPerson.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionNextPerson.SHORT_DESCRIPTION");
        actionNextPerson.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNextPerson.LONG_DESCRIPTION");
        actionNextPerson.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNextPerson.NAME");
        actionNextPerson.putValue(ItemAction.NAME, _tempStr);
         this.actionNextPerson.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAudit
        actionAudit.setEnabled(true);
        actionAudit.setDaemonRun(false);

        actionAudit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl F9"));
        _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
        actionAudit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
        actionAudit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAudit.NAME");
        actionAudit.putValue(ItemAction.NAME, _tempStr);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        this.separator10 = new javax.swing.JToolBar.Separator();
        this.separator11 = new javax.swing.JToolBar.Separator();
        this.separator10.setName("separator10");
        this.separator11.setName("separator11");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol41\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol42\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol45\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol49\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol50\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol51\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol52\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"0\" t:configured=\"false\" /><t:Column t:key=\"baseStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"1\" t:configured=\"false\" /><t:Column t:key=\"bizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"2\" t:configured=\"false\" /><t:Column t:key=\"transactionType.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"3\" t:configured=\"false\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"4\" t:configured=\"false\" /><t:Column t:key=\"storageOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"5\" t:configured=\"false\" /><t:Column t:key=\"department.name\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"6\" t:configured=\"false\" t:styleID=\"sCol6\" /><t:Column t:key=\"costCenterOrgUnit.name\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:configured=\"false\" t:styleID=\"sCol7\" /><t:Column t:key=\"isOffset\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:configured=\"false\" t:styleID=\"sCol8\" /><t:Column t:key=\"isVoucher\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:configured=\"false\" t:styleID=\"sCol9\" /><t:Column t:key=\"voucher.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:configured=\"false\" /><t:Column t:key=\"entry.seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:configured=\"false\" /><t:Column t:key=\"costObjectNumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:configured=\"false\" t:styleID=\"sCol12\" /><t:Column t:key=\"costObjectName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:configured=\"false\" t:styleID=\"sCol13\" /><t:Column t:key=\"invUpdateType\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:configured=\"false\" /><t:Column t:key=\"material.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:configured=\"false\" /><t:Column t:key=\"material.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:configured=\"false\" /><t:Column t:key=\"material.model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:configured=\"false\" /><t:Column t:key=\"assistantAttr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" t:configured=\"false\" /><t:Column t:key=\"entry.batch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:configured=\"false\" /><t:Column t:key=\"mfg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:configured=\"false\" /><t:Column t:key=\"exp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:configured=\"false\" /><t:Column t:key=\"unit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" t:configured=\"false\" /><t:Column t:key=\"entry.qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" t:configured=\"false\" t:styleID=\"sCol23\" /><t:Column t:key=\"baseUnit\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" t:configured=\"false\" t:styleID=\"sCol24\" /><t:Column t:key=\"baseQty\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" t:configured=\"false\" t:styleID=\"sCol25\" /><t:Column t:key=\"assistUnit\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" t:configured=\"false\" t:styleID=\"sCol26\" /><t:Column t:key=\"assistQty\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" t:configured=\"false\" t:styleID=\"sCol27\" /><t:Column t:key=\"warehouse.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"30\" t:configured=\"false\" /><t:Column t:key=\"stocker\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"31\" t:configured=\"false\" t:styleID=\"sCol29\" /><t:Column t:key=\"location.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"32\" t:configured=\"false\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"33\" t:configured=\"false\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"34\" t:configured=\"false\" /><t:Column t:key=\"ispresent\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"35\" t:configured=\"false\" t:styleID=\"sCol33\" /><t:Column t:key=\"unitStandardCost\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"36\" t:configured=\"false\" t:styleID=\"sCol34\" /><t:Column t:key=\"standCost\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"37\" t:configured=\"false\" t:styleID=\"sCol35\" /><t:Column t:key=\"unitFactCost\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"38\" t:configured=\"false\" t:styleID=\"sCol36\" /><t:Column t:key=\"factCost\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"39\" t:configured=\"false\" t:styleID=\"sCol37\" /><t:Column t:key=\"projectNumCol\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"40\" t:configured=\"false\" t:styleID=\"sCol38\" /><t:Column t:key=\"trackNumCol\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"41\" t:configured=\"false\" t:styleID=\"sCol39\" /><t:Column t:key=\"reserveQty\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"42\" t:configured=\"false\" t:styleID=\"sCol40\" /><t:Column t:key=\"remark\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"43\" t:configured=\"false\" t:styleID=\"sCol41\" /><t:Column t:key=\"creator.name\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"44\" t:configured=\"false\" t:styleID=\"sCol42\" /><t:Column t:key=\"creatorTime\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"45\" t:configured=\"false\" t:styleID=\"sCol43\" /><t:Column t:key=\"modifier.name\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"46\" t:configured=\"false\" t:styleID=\"sCol44\" /><t:Column t:key=\"modifyTime\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"47\" t:configured=\"false\" t:styleID=\"sCol45\" /><t:Column t:key=\"auditor.name\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"48\" t:configured=\"false\" t:styleID=\"sCol46\" /><t:Column t:key=\"auditorTime\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"49\" t:configured=\"false\" t:styleID=\"sCol47\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"50\" t:configured=\"false\" t:styleID=\"sCol48\" /><t:Column t:key=\"totalAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"51\" t:configured=\"false\" t:styleID=\"sCol49\" /><t:Column t:key=\"entry.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"52\" t:configured=\"false\" t:styleID=\"sCol50\" /><t:Column t:key=\"storageOrgUnit.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"53\" t:configured=\"false\" t:styleID=\"sCol51\" /><t:Column t:key=\"description\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"54\" t:configured=\"false\" t:styleID=\"sCol52\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:configured=\"false\"><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{baseStatus}</t:Cell><t:Cell>$Resource{bizType}</t:Cell><t:Cell>$Resource{transactionType.name}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{storageOrgUnit.name}</t:Cell><t:Cell>$Resource{department.name}</t:Cell><t:Cell>$Resource{costCenterOrgUnit.name}</t:Cell><t:Cell>$Resource{isOffset}</t:Cell><t:Cell>$Resource{isVoucher}</t:Cell><t:Cell>$Resource{voucher.number}</t:Cell><t:Cell>$Resource{entry.seq}</t:Cell><t:Cell>$Resource{costObjectNumber}</t:Cell><t:Cell>$Resource{costObjectName}</t:Cell><t:Cell>$Resource{invUpdateType}</t:Cell><t:Cell>$Resource{material.number}</t:Cell><t:Cell>$Resource{material.name}</t:Cell><t:Cell>$Resource{material.model}</t:Cell><t:Cell>$Resource{assistantAttr}</t:Cell><t:Cell>$Resource{entry.batch}</t:Cell><t:Cell>$Resource{mfg}</t:Cell><t:Cell>$Resource{exp}</t:Cell><t:Cell>$Resource{unit.name}</t:Cell><t:Cell>$Resource{entry.qty}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{assistQty}</t:Cell><t:Cell>$Resource{warehouse.name}</t:Cell><t:Cell>$Resource{stocker}</t:Cell><t:Cell>$Resource{location.name}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{ispresent}</t:Cell><t:Cell>$Resource{unitStandardCost}</t:Cell><t:Cell>$Resource{standCost}</t:Cell><t:Cell>$Resource{unitFactCost}</t:Cell><t:Cell>$Resource{factCost}</t:Cell><t:Cell>$Resource{projectNumCol}</t:Cell><t:Cell>$Resource{trackNumCol}</t:Cell><t:Cell>$Resource{reserveQty}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{creatorTime}</t:Cell><t:Cell>$Resource{modifier.name}</t:Cell><t:Cell>$Resource{modifyTime}</t:Cell><t:Cell>$Resource{auditor.name}</t:Cell><t:Cell>$Resource{auditorTime}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{totalAmount}</t:Cell><t:Cell>$Resource{entry.id}</t:Cell><t:Cell>$Resource{storageOrgUnit.id}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"number","baseStatus","bizType.name","transactionType.name","bizDate","storageOrgUnit.name","adminOrgUnit.name","costCenterOrgUnit.name","isReversed","fiVouchered","voucher.number","entry.seq","costObject.number","costObject.name","invUpdateType.name","material.number","material.name","material.model","assistProperty.name","entry.lot","entry.mfg","entry.exp","unit.name","entry.qty","baseUnit.name","entry.baseQty","assistUnit.name","entry.assistQty","warehouse.name","stocker.name","location.name","customer.name","supplier.name","entry.isPresent","entry.unitStandardCost","entry.standardCost","entry.unitActualCost","entry.actualCost","project.number","trackNumber.number","entry.reverseQty","entry.remark","creator.name","createTime","modifier.name","modificationTime","auditor.name","auditTime","id","totalAmount","entry.id","storageOrgUnit.id","description"});

		
        this.btnLocate.setVisible(false);		
        this.kDSeparator2.setVisible(true);		
        this.separatorFW2.setVisible(true);		
        this.separatorFW1.setEnabled(false);		
        this.separatorFW1.setVisible(false);		
        this.btnCopyTo.setVisible(false);		
        this.btnCopyTo.setEnabled(false);		
        this.separatorFW4.setEnabled(false);		
        this.separatorFW4.setVisible(false);		
        this.btnAuditResult.setVisible(true);		
        this.menuItemCopyTo.setEnabled(false);		
        this.menuItemVoucher.setVisible(true);		
        this.menuItemVoucher.setEnabled(true);		
        this.menuItemDelVoucher.setEnabled(true);		
        this.menuItemDelVoucher.setVisible(true);		
        this.menuItemMultiapprove.setEnabled(false);		
        this.menuItemMultiapprove.setVisible(false);		
        this.separator1.setOrientation(1);		
        this.btnMultiPrint.setVisible(true);		
        this.btnMultiPrintPreview.setVisible(true);		
        this.separator2.setOrientation(1);		
        this.separator4.setEnabled(false);		
        this.separator4.setVisible(false);		
        this.separator8.setEnabled(false);		
        this.separator8.setVisible(false);		
        this.menuItemAudit.setToolTipText(resHelper.getString("menuItemAudit.toolTipText"));		
        this.menuItemUnAudit.setToolTipText(resHelper.getString("menuItemUnAudit.toolTipText"));
        // separator10		
        this.separator10.setOrientation(1);		
        this.separator10.setVisible(false);
        // separator11		
        this.separator11.setOrientation(1);		
        this.separator11.setEnabled(false);		
        this.separator11.setVisible(false);
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
        tblMain.setBounds(new Rectangle(10, 10, 993, 609));
        this.add(tblMain, new KDLayout.Constraints(10, 10, 993, 609, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.menuBar.add(kdMenuVoucher);
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemImportData);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuItemExportData);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(separatorFile1);
        menuFile.add(separator4);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(menuItemMultiPrint);
        menuFile.add(separator5);
        menuFile.add(menuItemMultiPrintPreview);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(separator6);
        menuEdit.add(kDSeparator3);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyTo);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(separatorView1);
        menuView.add(menuItemQuery);
        menuView.add(menuItemRefresh);
        menuView.add(menuItemSwitchView);
        menuView.add(separator7);
        menuView.add(kDSeparator5);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(menuItemQueryScheme);
        menuView.add(kDSeparator6);
        menuView.add(separator8);
        menuView.add(kDMenuPercisionConfig);
        menuView.add(menuItemInventorySum);
        //kDMenuPercisionConfig
        kDMenuPercisionConfig.add(menuItemPercisionConfig);
        kDMenuPercisionConfig.add(boxMenuItemNoZero);
        kDMenuPercisionConfig.add(boxIsShowSumRow);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemBillReservationQuery);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkFlow
        menuWorkFlow.add(menuItemMultiapprove);
        menuWorkFlow.add(menuItemWorkFlowG);
        menuWorkFlow.add(menuItemNextPerson);
        menuWorkFlow.add(separatorWF1);
        menuWorkFlow.add(menuItemWorkFlowList);
        menuWorkFlow.add(menuItemAudit);
        menuWorkFlow.add(menuItemUnAudit);
        menuWorkFlow.add(menuItemAuditResult);
        menuWorkFlow.add(menuItemViewDoProccess);
        menuWorkFlow.add(kDSeparator7);
        menuWorkFlow.add(menuItemSendSmsMessage);
        //kdMenuVoucher
        kdMenuVoucher.add(separatorFW4);
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
        menuHelp.add(separator9);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(menuItemAbout);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);

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
        this.toolBar.add(separator1);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(btnMultiPrint);
        this.toolBar.add(btnMultiPrintPreview);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnQueryScheme);
        this.toolBar.add(separator10);
        this.toolBar.add(separator11);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnWorkFlowList);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnSignature);
        this.toolBar.add(separator2);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(separator3);
        this.toolBar.add(btnCopyTo);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnReservationQuery);
        this.toolBar.add(btnInventorySum);
        this.toolBar.add(btnDiscard);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.weighbridge.app.F7OtherIssueBillListUIHandler";
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Storage");
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
	 * ????????��??
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
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("transactionType.name"));
        sic.add(new SelectorItemInfo("storageOrgUnit.name"));
        sic.add(new SelectorItemInfo("entry.id"));
        sic.add(new SelectorItemInfo("entry.qty"));
        sic.add(new SelectorItemInfo("material.number"));
        sic.add(new SelectorItemInfo("material.name"));
        sic.add(new SelectorItemInfo("location.name"));
        sic.add(new SelectorItemInfo("warehouse.name"));
        sic.add(new SelectorItemInfo("unit.name"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("material.model"));
        sic.add(new SelectorItemInfo("entry.seq"));
        sic.add(new SelectorItemInfo("totalAmount"));
        sic.add(new SelectorItemInfo("adminOrgUnit.name"));
        sic.add(new SelectorItemInfo("entry.lot"));
        sic.add(new SelectorItemInfo("assistProperty.name"));
        sic.add(new SelectorItemInfo("isReversed"));
        sic.add(new SelectorItemInfo("entry.exp"));
        sic.add(new SelectorItemInfo("baseUnit.name"));
        sic.add(new SelectorItemInfo("entry.baseQty"));
        sic.add(new SelectorItemInfo("assistUnit.name"));
        sic.add(new SelectorItemInfo("entry.assistQty"));
        sic.add(new SelectorItemInfo("customer.name"));
        sic.add(new SelectorItemInfo("supplier.name"));
        sic.add(new SelectorItemInfo("entry.isPresent"));
        sic.add(new SelectorItemInfo("entry.unitStandardCost"));
        sic.add(new SelectorItemInfo("entry.standardCost"));
        sic.add(new SelectorItemInfo("entry.unitActualCost"));
        sic.add(new SelectorItemInfo("entry.actualCost"));
        sic.add(new SelectorItemInfo("entry.reverseQty"));
        sic.add(new SelectorItemInfo("entry.remark"));
        sic.add(new SelectorItemInfo("stocker.name"));
        sic.add(new SelectorItemInfo("fiVouchered"));
        sic.add(new SelectorItemInfo("voucher.number"));
        sic.add(new SelectorItemInfo("creator.name"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("modifier.name"));
        sic.add(new SelectorItemInfo("modificationTime"));
        sic.add(new SelectorItemInfo("auditor.name"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("entry.mfg"));
        sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        sic.add(new SelectorItemInfo("costObject.number"));
        sic.add(new SelectorItemInfo("costObject.name"));
        sic.add(new SelectorItemInfo("project.number"));
        sic.add(new SelectorItemInfo("trackNumber.number"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("costCenterOrgUnit.name"));
        sic.add(new SelectorItemInfo("bizType.name"));
        sic.add(new SelectorItemInfo("invUpdateType.name"));
        return sic;
    }        
    	

    /**
     * output actionAddNew_actionPerformed method
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }
    	

    /**
     * output actionEdit_actionPerformed method
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }
    	

    /**
     * output actionNextPerson_actionPerformed method
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }
	public RequestContext prepareActionAddNew(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAddNew(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddNew() {
    	return false;
    }
	public RequestContext prepareActionEdit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionEdit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionEdit() {
    	return false;
    }
	public RequestContext prepareActionNextPerson(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionNextPerson(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionNextPerson() {
    	return false;
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAudit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "F7OtherIssueBillListUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.scm.im.inv.client.OtherIssueBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.scm.im.inv.OtherIssueBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.scm.im.inv.OtherIssueBillInfo objectValue = new com.kingdee.eas.scm.im.inv.OtherIssueBillInfo();		
        return objectValue;
    }




}