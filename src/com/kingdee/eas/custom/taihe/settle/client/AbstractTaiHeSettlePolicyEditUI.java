/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

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
public abstract class AbstractTaiHeSettlePolicyEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractTaiHeSettlePolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSzCoeff;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDAOImpl;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpolicyPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpolicyPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthedgingPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshareCoeff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfixedCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthedgingPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshareCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfixedCoeff;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtformulaTxt;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDTreeView kDTreeView1;
    protected com.kingdee.bos.ctrl.swing.KDTree kDTree1;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeffectDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSzCoeff;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDAOImpl;
    protected com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractTaiHeSettlePolicyEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractTaiHeSettlePolicyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.conteffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunEffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSzCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDAOImpl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contpolicyPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtpolicyPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contbasePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthedgingPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshareCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfixedCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtbasePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthedgingPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshareCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfixedCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtformulaTxt = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTreeView1 = new com.kingdee.bos.ctrl.swing.KDTreeView();
        this.kDTree1 = new com.kingdee.bos.ctrl.swing.KDTree();
        this.pkeffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkunEffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtchickenSzCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtDAOImpl = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.conteffectDate.setName("conteffectDate");
        this.contunEffectDate.setName("contunEffectDate");
        this.contchickenSzCoeff.setName("contchickenSzCoeff");
        this.kDSeparator5.setName("kDSeparator5");
        this.contcontractType.setName("contcontractType");
        this.contDAOImpl.setName("contDAOImpl");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.contpolicyPrice.setName("contpolicyPrice");
        this.contcontractPrice.setName("contcontractPrice");
        this.txtpolicyPrice.setName("txtpolicyPrice");
        this.txtcontractPrice.setName("txtcontractPrice");
        this.contbasePrice.setName("contbasePrice");
        this.conthedgingPrice.setName("conthedgingPrice");
        this.contshareCoeff.setName("contshareCoeff");
        this.contfixedCoeff.setName("contfixedCoeff");
        this.txtbasePrice.setName("txtbasePrice");
        this.txthedgingPrice.setName("txthedgingPrice");
        this.txtshareCoeff.setName("txtshareCoeff");
        this.txtfixedCoeff.setName("txtfixedCoeff");
        this.txtformulaTxt.setName("txtformulaTxt");
        this.kDTable1.setName("kDTable1");
        this.kDTreeView1.setName("kDTreeView1");
        this.kDTree1.setName("kDTree1");
        this.pkeffectDate.setName("pkeffectDate");
        this.pkunEffectDate.setName("pkunEffectDate");
        this.txtchickenSzCoeff.setName("txtchickenSzCoeff");
        this.prmtcontractType.setName("prmtcontractType");
        this.txtDAOImpl.setName("txtDAOImpl");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);		
        this.contapprover.setBoundLabelText(resHelper.getString("contapprover.boundLabelText"));		
        this.contapprover.setBoundLabelLength(100);		
        this.contapprover.setBoundLabelUnderline(true);		
        this.contapprover.setVisible(true);		
        this.contapproveTime.setBoundLabelText(resHelper.getString("contapproveTime.boundLabelText"));		
        this.contapproveTime.setBoundLabelLength(100);		
        this.contapproveTime.setBoundLabelUnderline(true);		
        this.contapproveTime.setVisible(true);		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);		
        this.contcreator.setBoundLabelText(resHelper.getString("contcreator.boundLabelText"));		
        this.contcreator.setBoundLabelLength(100);		
        this.contcreator.setBoundLabelUnderline(true);		
        this.contcreator.setVisible(true);		
        this.contcreateTime.setBoundLabelText(resHelper.getString("contcreateTime.boundLabelText"));		
        this.contcreateTime.setBoundLabelLength(100);		
        this.contcreateTime.setBoundLabelUnderline(true);		
        this.contcreateTime.setVisible(true);		
        this.txtNumber.setMaxLength(80);		
        this.txtName.setRequired(true);		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);		
        this.txtDescription.setVisible(false);		
        this.prmtapprover.setVisible(true);		
        this.prmtapprover.setEditable(true);		
        this.prmtapprover.setDisplayFormat("$number$");		
        this.prmtapprover.setEditFormat("$number$");		
        this.prmtapprover.setCommitFormat("$number$");		
        this.prmtapprover.setRequired(false);		
        this.prmtapprover.setEnabled(false);		
        this.pkapproveTime.setVisible(true);		
        this.pkapproveTime.setRequired(false);		
        this.pkapproveTime.setEnabled(false);		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.prmtcreator.setVisible(true);		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);		
        this.pkcreateTime.setVisible(true);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // conteffectDate		
        this.conteffectDate.setBoundLabelText(resHelper.getString("conteffectDate.boundLabelText"));		
        this.conteffectDate.setBoundLabelLength(100);		
        this.conteffectDate.setBoundLabelUnderline(true);		
        this.conteffectDate.setVisible(true);
        // contunEffectDate		
        this.contunEffectDate.setBoundLabelText(resHelper.getString("contunEffectDate.boundLabelText"));		
        this.contunEffectDate.setBoundLabelLength(100);		
        this.contunEffectDate.setBoundLabelUnderline(true);		
        this.contunEffectDate.setVisible(true);
        // contchickenSzCoeff		
        this.contchickenSzCoeff.setBoundLabelText(resHelper.getString("contchickenSzCoeff.boundLabelText"));		
        this.contchickenSzCoeff.setBoundLabelLength(100);		
        this.contchickenSzCoeff.setBoundLabelUnderline(true);		
        this.contchickenSzCoeff.setVisible(false);
        // kDSeparator5
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contDAOImpl		
        this.contDAOImpl.setBoundLabelText(resHelper.getString("contDAOImpl.boundLabelText"));		
        this.contDAOImpl.setBoundLabelLength(100);		
        this.contDAOImpl.setBoundLabelUnderline(true);		
        this.contDAOImpl.setVisible(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // kDPanel1
        // kDPanel3
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // kDPanel4		
        this.kDPanel4.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel4.border.title")));
        // contpolicyPrice		
        this.contpolicyPrice.setBoundLabelText(resHelper.getString("contpolicyPrice.boundLabelText"));		
        this.contpolicyPrice.setBoundLabelLength(100);		
        this.contpolicyPrice.setBoundLabelUnderline(true);		
        this.contpolicyPrice.setVisible(true);
        // contcontractPrice		
        this.contcontractPrice.setBoundLabelText(resHelper.getString("contcontractPrice.boundLabelText"));		
        this.contcontractPrice.setBoundLabelLength(100);		
        this.contcontractPrice.setBoundLabelUnderline(true);		
        this.contcontractPrice.setVisible(true);
        // txtpolicyPrice		
        this.txtpolicyPrice.setVisible(true);		
        this.txtpolicyPrice.setHorizontalAlignment(2);		
        this.txtpolicyPrice.setDataType(1);		
        this.txtpolicyPrice.setSupportedEmpty(true);		
        this.txtpolicyPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpolicyPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpolicyPrice.setPrecision(4);		
        this.txtpolicyPrice.setRequired(false);
        // txtcontractPrice		
        this.txtcontractPrice.setVisible(true);		
        this.txtcontractPrice.setHorizontalAlignment(2);		
        this.txtcontractPrice.setDataType(1);		
        this.txtcontractPrice.setSupportedEmpty(true);		
        this.txtcontractPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractPrice.setPrecision(4);		
        this.txtcontractPrice.setRequired(false);
        // contbasePrice		
        this.contbasePrice.setBoundLabelText(resHelper.getString("contbasePrice.boundLabelText"));		
        this.contbasePrice.setBoundLabelLength(100);		
        this.contbasePrice.setBoundLabelUnderline(true);		
        this.contbasePrice.setVisible(true);
        // conthedgingPrice		
        this.conthedgingPrice.setBoundLabelText(resHelper.getString("conthedgingPrice.boundLabelText"));		
        this.conthedgingPrice.setBoundLabelLength(100);		
        this.conthedgingPrice.setBoundLabelUnderline(true);		
        this.conthedgingPrice.setVisible(true);
        // contshareCoeff		
        this.contshareCoeff.setBoundLabelText(resHelper.getString("contshareCoeff.boundLabelText"));		
        this.contshareCoeff.setBoundLabelLength(100);		
        this.contshareCoeff.setBoundLabelUnderline(true);		
        this.contshareCoeff.setVisible(true);
        // contfixedCoeff		
        this.contfixedCoeff.setBoundLabelText(resHelper.getString("contfixedCoeff.boundLabelText"));		
        this.contfixedCoeff.setBoundLabelLength(100);		
        this.contfixedCoeff.setBoundLabelUnderline(true);		
        this.contfixedCoeff.setVisible(true);
        // txtbasePrice		
        this.txtbasePrice.setVisible(true);		
        this.txtbasePrice.setHorizontalAlignment(2);		
        this.txtbasePrice.setDataType(1);		
        this.txtbasePrice.setSupportedEmpty(true);		
        this.txtbasePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasePrice.setPrecision(4);		
        this.txtbasePrice.setRequired(false);
        // txthedgingPrice		
        this.txthedgingPrice.setVisible(true);		
        this.txthedgingPrice.setHorizontalAlignment(2);		
        this.txthedgingPrice.setDataType(1);		
        this.txthedgingPrice.setSupportedEmpty(true);		
        this.txthedgingPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthedgingPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthedgingPrice.setPrecision(4);		
        this.txthedgingPrice.setRequired(false);
        // txtshareCoeff		
        this.txtshareCoeff.setVisible(true);		
        this.txtshareCoeff.setHorizontalAlignment(2);		
        this.txtshareCoeff.setDataType(1);		
        this.txtshareCoeff.setSupportedEmpty(true);		
        this.txtshareCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtshareCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtshareCoeff.setPrecision(3);		
        this.txtshareCoeff.setRequired(false);
        // txtfixedCoeff		
        this.txtfixedCoeff.setVisible(true);		
        this.txtfixedCoeff.setHorizontalAlignment(2);		
        this.txtfixedCoeff.setDataType(1);		
        this.txtfixedCoeff.setSupportedEmpty(true);		
        this.txtfixedCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtfixedCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtfixedCoeff.setPrecision(3);		
        this.txtfixedCoeff.setRequired(false);
        // txtformulaTxt		
        this.txtformulaTxt.setVisible(true);		
        this.txtformulaTxt.setRequired(false);		
        this.txtformulaTxt.setMaxLength(1000);
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bosType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{bosType}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        this.kDTable1.checkParsed();
        // kDTreeView1
        // kDTree1
        // pkeffectDate		
        this.pkeffectDate.setVisible(true);		
        this.pkeffectDate.setRequired(true);
        // pkunEffectDate		
        this.pkunEffectDate.setVisible(true);		
        this.pkunEffectDate.setRequired(true);
        // txtchickenSzCoeff		
        this.txtchickenSzCoeff.setVisible(false);		
        this.txtchickenSzCoeff.setHorizontalAlignment(2);		
        this.txtchickenSzCoeff.setDataType(1);		
        this.txtchickenSzCoeff.setSupportedEmpty(true);		
        this.txtchickenSzCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtchickenSzCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtchickenSzCoeff.setPrecision(3);		
        this.txtchickenSzCoeff.setRequired(false);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setVisible(true);		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(true);
        // txtDAOImpl		
        this.txtDAOImpl.setVisible(true);		
        this.txtDAOImpl.setHorizontalAlignment(2);		
        this.txtDAOImpl.setMaxLength(200);		
        this.txtDAOImpl.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,pkeffectDate,pkunEffectDate,txtbasePrice,txthedgingPrice,txtfixedCoeff,txtshareCoeff,txtchickenSzCoeff,txtpolicyPrice,txtcontractPrice,txtformulaTxt,prmtcontractType,txtDAOImpl}));
        this.setFocusCycleRoot(true);
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
        this.setBounds(new Rectangle(0, 0, 941, 540));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 941, 540));
        kDLabelContainer1.setBounds(new Rectangle(18, 16, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(18, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(338, 16, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(338, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(992, 123, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(992, 123, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(340, 87, 581, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(340, 87, 581, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contapprover.setBounds(new Rectangle(335, 473, 270, 19));
        this.add(contapprover, new KDLayout.Constraints(335, 473, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contapproveTime.setBounds(new Rectangle(651, 473, 270, 19));
        this.add(contapproveTime, new KDLayout.Constraints(651, 473, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(651, 16, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(651, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcreator.setBounds(new Rectangle(20, 507, 270, 19));
        this.add(contcreator, new KDLayout.Constraints(20, 507, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcreateTime.setBounds(new Rectangle(20, 473, 270, 19));
        this.add(contcreateTime, new KDLayout.Constraints(20, 473, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(20, 51, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(12, 167, 910, 292));
        this.add(kDTabbedPane1, new KDLayout.Constraints(12, 167, 910, 292, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conteffectDate.setBounds(new Rectangle(338, 51, 270, 19));
        this.add(conteffectDate, new KDLayout.Constraints(338, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunEffectDate.setBounds(new Rectangle(651, 51, 270, 19));
        this.add(contunEffectDate, new KDLayout.Constraints(651, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchickenSzCoeff.setBounds(new Rectangle(637, 501, 270, 19));
        this.add(contchickenSzCoeff, new KDLayout.Constraints(637, 501, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator5.setBounds(new Rectangle(9, 121, 917, 10));
        this.add(kDSeparator5, new KDLayout.Constraints(9, 121, 917, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractType.setBounds(new Rectangle(20, 87, 270, 19));
        this.add(contcontractType, new KDLayout.Constraints(20, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDAOImpl.setBounds(new Rectangle(20, 138, 582, 19));
        this.add(contDAOImpl, new KDLayout.Constraints(20, 138, 582, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contapprover
        contapprover.setBoundEditor(prmtapprover);
        //contapproveTime
        contapproveTime.setBoundEditor(pkapproveTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 909, 259));        kDPanel2.setBounds(new Rectangle(9, 20, 883, 58));
        kDPanel1.add(kDPanel2, new KDLayout.Constraints(9, 20, 883, 58, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel4.setBounds(new Rectangle(9, 89, 882, 100));
        kDPanel1.add(kDPanel4, new KDLayout.Constraints(9, 89, 882, 100, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(9, 20, 883, 58));        contpolicyPrice.setBounds(new Rectangle(20, 16, 270, 19));
        kDPanel2.add(contpolicyPrice, new KDLayout.Constraints(20, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractPrice.setBounds(new Rectangle(319, 16, 270, 19));
        kDPanel2.add(contcontractPrice, new KDLayout.Constraints(319, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contpolicyPrice
        contpolicyPrice.setBoundEditor(txtpolicyPrice);
        //contcontractPrice
        contcontractPrice.setBoundEditor(txtcontractPrice);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(9, 89, 882, 100));        contbasePrice.setBounds(new Rectangle(21, 18, 270, 19));
        kDPanel4.add(contbasePrice, new KDLayout.Constraints(21, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthedgingPrice.setBounds(new Rectangle(323, 18, 270, 19));
        kDPanel4.add(conthedgingPrice, new KDLayout.Constraints(323, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contshareCoeff.setBounds(new Rectangle(323, 56, 270, 19));
        kDPanel4.add(contshareCoeff, new KDLayout.Constraints(323, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfixedCoeff.setBounds(new Rectangle(21, 56, 270, 19));
        kDPanel4.add(contfixedCoeff, new KDLayout.Constraints(21, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contbasePrice
        contbasePrice.setBoundEditor(txtbasePrice);
        //conthedgingPrice
        conthedgingPrice.setBoundEditor(txthedgingPrice);
        //contshareCoeff
        contshareCoeff.setBoundEditor(txtshareCoeff);
        //contfixedCoeff
        contfixedCoeff.setBoundEditor(txtfixedCoeff);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 909, 259));        txtformulaTxt.setBounds(new Rectangle(272, 1, 630, 257));
        kDPanel3.add(txtformulaTxt, new KDLayout.Constraints(272, 1, 630, 257, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTable1.setBounds(new Rectangle(1, 1, 270, 83));
        kDPanel3.add(kDTable1, new KDLayout.Constraints(1, 1, 270, 83, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTreeView1.setBounds(new Rectangle(1, 86, 270, 170));
        kDPanel3.add(kDTreeView1, new KDLayout.Constraints(1, 86, 270, 170, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDTreeView1
        kDTreeView1.setTree(kDTree1);
        //conteffectDate
        conteffectDate.setBoundEditor(pkeffectDate);
        //contunEffectDate
        contunEffectDate.setBoundEditor(pkunEffectDate);
        //contchickenSzCoeff
        contchickenSzCoeff.setBoundEditor(txtchickenSzCoeff);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contDAOImpl
        contDAOImpl.setBoundEditor(txtDAOImpl);

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
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        //menuBiz
        menuBiz.add(mBtnApprove);
        menuBiz.add(mBtnUnApprove);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnApprove);
        this.toolBar.add(tBtnUnApprove);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("approver", com.kingdee.eas.base.permission.UserInfo.class, this.prmtapprover, "data");
		dataBinder.registerBinding("approveTime", java.util.Date.class, this.pkapproveTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("policyPrice", java.math.BigDecimal.class, this.txtpolicyPrice, "value");
		dataBinder.registerBinding("contractPrice", java.math.BigDecimal.class, this.txtcontractPrice, "value");
		dataBinder.registerBinding("basePrice", java.math.BigDecimal.class, this.txtbasePrice, "value");
		dataBinder.registerBinding("hedgingPrice", java.math.BigDecimal.class, this.txthedgingPrice, "value");
		dataBinder.registerBinding("shareCoeff", java.math.BigDecimal.class, this.txtshareCoeff, "value");
		dataBinder.registerBinding("fixedCoeff", java.math.BigDecimal.class, this.txtfixedCoeff, "value");
		dataBinder.registerBinding("formulaTxt", String.class, this.txtformulaTxt, "text");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.pkeffectDate, "value");
		dataBinder.registerBinding("unEffectDate", java.util.Date.class, this.pkunEffectDate, "value");
		dataBinder.registerBinding("chickenSzCoeff", java.math.BigDecimal.class, this.txtchickenSzCoeff, "value");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("DAOImpl", String.class, this.txtDAOImpl, "text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.settle.app.TaiHeSettlePolicyEditUIHandler";
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
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.prmtcompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
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
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("policyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hedgingPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shareCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fixedCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("formulaTxt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unEffectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSzCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DAOImpl", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
        }
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("approver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("approver.id"));
        	sic.add(new SelectorItemInfo("approver.number"));
        	sic.add(new SelectorItemInfo("approver.name"));
		}
        sic.add(new SelectorItemInfo("approveTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("policyPrice"));
        sic.add(new SelectorItemInfo("contractPrice"));
        sic.add(new SelectorItemInfo("basePrice"));
        sic.add(new SelectorItemInfo("hedgingPrice"));
        sic.add(new SelectorItemInfo("shareCoeff"));
        sic.add(new SelectorItemInfo("fixedCoeff"));
        sic.add(new SelectorItemInfo("formulaTxt"));
        sic.add(new SelectorItemInfo("effectDate"));
        sic.add(new SelectorItemInfo("unEffectDate"));
        sic.add(new SelectorItemInfo("chickenSzCoeff"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
        sic.add(new SelectorItemInfo("DAOImpl"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.settle.client", "TaiHeSettlePolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.taihe.settle.client.TaiHeSettlePolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo objectValue = new com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkeffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkunEffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcontractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同类别"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kDTable1;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}