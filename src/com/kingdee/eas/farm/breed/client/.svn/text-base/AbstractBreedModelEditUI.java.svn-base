/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

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
public abstract class AbstractBreedModelEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBreedModelEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouseType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeletedStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlimitBreedDays;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisDefault;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisMoulting;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contVarietie;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtLayEggEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtLayEggEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox houseType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox deletedStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbreedDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlimitBreedDays;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtVarietie;
    protected com.kingdee.eas.farm.breed.BreedModelInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBreedModelEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBreedModelEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthouseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeletedStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlimitBreedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisDefault = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisMoulting = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contVarietie = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtLayEggEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.houseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.deletedStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbreedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlimitBreedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtVarietie = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.conthouseType.setName("conthouseType");
        this.contdeletedStatus.setName("contdeletedStatus");
        this.contbreedDays.setName("contbreedDays");
        this.contlimitBreedDays.setName("contlimitBreedDays");
        this.chkisDefault.setName("chkisDefault");
        this.chkisMoulting.setName("chkisMoulting");
        this.contcompany.setName("contcompany");
        this.contVarietie.setName("contVarietie");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtCreator.setName("prmtCreator");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtLayEggEntrys.setName("kdtLayEggEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.houseType.setName("houseType");
        this.deletedStatus.setName("deletedStatus");
        this.txtbreedDays.setName("txtbreedDays");
        this.txtlimitBreedDays.setName("txtlimitBreedDays");
        this.prmtcompany.setName("prmtcompany");
        this.prmtVarietie.setName("prmtVarietie");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(100);
        // kDTabbedPane1
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contauditor		
        this.contauditor.setBoundLabelText(resHelper.getString("contauditor.boundLabelText"));		
        this.contauditor.setBoundLabelLength(100);		
        this.contauditor.setBoundLabelUnderline(true);		
        this.contauditor.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // conthouseType		
        this.conthouseType.setBoundLabelText(resHelper.getString("conthouseType.boundLabelText"));		
        this.conthouseType.setBoundLabelLength(100);		
        this.conthouseType.setBoundLabelUnderline(true);		
        this.conthouseType.setVisible(true);
        // contdeletedStatus		
        this.contdeletedStatus.setBoundLabelText(resHelper.getString("contdeletedStatus.boundLabelText"));		
        this.contdeletedStatus.setBoundLabelLength(100);		
        this.contdeletedStatus.setBoundLabelUnderline(true);		
        this.contdeletedStatus.setVisible(true);
        // contbreedDays		
        this.contbreedDays.setBoundLabelText(resHelper.getString("contbreedDays.boundLabelText"));		
        this.contbreedDays.setBoundLabelLength(100);		
        this.contbreedDays.setBoundLabelUnderline(true);		
        this.contbreedDays.setVisible(true);
        // contlimitBreedDays		
        this.contlimitBreedDays.setBoundLabelText(resHelper.getString("contlimitBreedDays.boundLabelText"));		
        this.contlimitBreedDays.setBoundLabelLength(100);		
        this.contlimitBreedDays.setBoundLabelUnderline(true);		
        this.contlimitBreedDays.setVisible(true);
        // chkisDefault		
        this.chkisDefault.setText(resHelper.getString("chkisDefault.text"));		
        this.chkisDefault.setHorizontalAlignment(2);
        // chkisMoulting		
        this.chkisMoulting.setText(resHelper.getString("chkisMoulting.text"));		
        this.chkisMoulting.setHorizontalAlignment(2);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contVarietie		
        this.contVarietie.setBoundLabelText(resHelper.getString("contVarietie.boundLabelText"));		
        this.contVarietie.setBoundLabelLength(100);		
        this.contVarietie.setBoundLabelUnderline(true);		
        this.contVarietie.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qtyPerday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"dailyDCRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"standardWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"dynamiting\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"henMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henQtyPerday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"cockMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cockQtyPerday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{qtyPerday}</t:Cell><t:Cell>$Resource{dailyDCRate}</t:Cell><t:Cell>$Resource{standardWeight}</t:Cell><t:Cell>$Resource{dynamiting}</t:Cell><t:Cell>$Resource{henMaterial}</t:Cell><t:Cell>$Resource{henQtyPerday}</t:Cell><t:Cell>$Resource{cockMaterial}</t:Cell><t:Cell>$Resource{cockQtyPerday}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"seq","week","days","material","qtyPerday","dailyDCRate","standardWeight","dynamiting","henMaterial","henQtyPerday","cockMaterial","cockQtyPerday","waterQty","breedTime","lightingTime","temperatureTo","temperatureFrom","humidityFrom","humidityTo"});


        this.kdtEntrys.checkParsed();
        KDFormattedTextField kdtEntrys_seq_TextField = new KDFormattedTextField();
        kdtEntrys_seq_TextField.setName("kdtEntrys_seq_TextField");
        kdtEntrys_seq_TextField.setVisible(true);
        kdtEntrys_seq_TextField.setEditable(true);
        kdtEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seq_TextField);
        this.kdtEntrys.getColumn("seq").setEditor(kdtEntrys_seq_CellEditor);
        KDFormattedTextField kdtEntrys_week_TextField = new KDFormattedTextField();
        kdtEntrys_week_TextField.setName("kdtEntrys_week_TextField");
        kdtEntrys_week_TextField.setVisible(true);
        kdtEntrys_week_TextField.setEditable(true);
        kdtEntrys_week_TextField.setHorizontalAlignment(2);
        kdtEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtEntrys_week_TextField);
        this.kdtEntrys.getColumn("week").setEditor(kdtEntrys_week_CellEditor);
        KDFormattedTextField kdtEntrys_days_TextField = new KDFormattedTextField();
        kdtEntrys_days_TextField.setName("kdtEntrys_days_TextField");
        kdtEntrys_days_TextField.setVisible(true);
        kdtEntrys_days_TextField.setEditable(true);
        kdtEntrys_days_TextField.setHorizontalAlignment(2);
        kdtEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtEntrys_days_TextField);
        this.kdtEntrys.getColumn("days").setEditor(kdtEntrys_days_CellEditor);
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDFormattedTextField kdtEntrys_qtyPerday_TextField = new KDFormattedTextField();
        kdtEntrys_qtyPerday_TextField.setName("kdtEntrys_qtyPerday_TextField");
        kdtEntrys_qtyPerday_TextField.setVisible(true);
        kdtEntrys_qtyPerday_TextField.setEditable(true);
        kdtEntrys_qtyPerday_TextField.setHorizontalAlignment(2);
        kdtEntrys_qtyPerday_TextField.setDataType(1);
        	kdtEntrys_qtyPerday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_qtyPerday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_qtyPerday_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_qtyPerday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qtyPerday_TextField);
        this.kdtEntrys.getColumn("qtyPerday").setEditor(kdtEntrys_qtyPerday_CellEditor);
        KDFormattedTextField kdtEntrys_dailyDCRate_TextField = new KDFormattedTextField();
        kdtEntrys_dailyDCRate_TextField.setName("kdtEntrys_dailyDCRate_TextField");
        kdtEntrys_dailyDCRate_TextField.setVisible(true);
        kdtEntrys_dailyDCRate_TextField.setEditable(true);
        kdtEntrys_dailyDCRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_dailyDCRate_TextField.setDataType(1);
        	kdtEntrys_dailyDCRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dailyDCRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dailyDCRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dailyDCRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dailyDCRate_TextField);
        this.kdtEntrys.getColumn("dailyDCRate").setEditor(kdtEntrys_dailyDCRate_CellEditor);
        KDFormattedTextField kdtEntrys_standardWeight_TextField = new KDFormattedTextField();
        kdtEntrys_standardWeight_TextField.setName("kdtEntrys_standardWeight_TextField");
        kdtEntrys_standardWeight_TextField.setVisible(true);
        kdtEntrys_standardWeight_TextField.setEditable(true);
        kdtEntrys_standardWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_standardWeight_TextField.setDataType(1);
        	kdtEntrys_standardWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_standardWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_standardWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_standardWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_standardWeight_TextField);
        this.kdtEntrys.getColumn("standardWeight").setEditor(kdtEntrys_standardWeight_CellEditor);
        KDFormattedTextField kdtEntrys_dynamiting_TextField = new KDFormattedTextField();
        kdtEntrys_dynamiting_TextField.setName("kdtEntrys_dynamiting_TextField");
        kdtEntrys_dynamiting_TextField.setVisible(true);
        kdtEntrys_dynamiting_TextField.setEditable(true);
        kdtEntrys_dynamiting_TextField.setHorizontalAlignment(2);
        kdtEntrys_dynamiting_TextField.setDataType(1);
        	kdtEntrys_dynamiting_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dynamiting_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dynamiting_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dynamiting_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dynamiting_TextField);
        this.kdtEntrys.getColumn("dynamiting").setEditor(kdtEntrys_dynamiting_CellEditor);
        final KDBizPromptBox kdtEntrys_henMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_henMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_henMaterial_PromptBox.setVisible(true);
        kdtEntrys_henMaterial_PromptBox.setEditable(true);
        kdtEntrys_henMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_henMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henMaterial_PromptBox);
        this.kdtEntrys.getColumn("henMaterial").setEditor(kdtEntrys_henMaterial_CellEditor);
        ObjectValueRender kdtEntrys_henMaterial_OVR = new ObjectValueRender();
        kdtEntrys_henMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("henMaterial").setRenderer(kdtEntrys_henMaterial_OVR);
        KDFormattedTextField kdtEntrys_henQtyPerday_TextField = new KDFormattedTextField();
        kdtEntrys_henQtyPerday_TextField.setName("kdtEntrys_henQtyPerday_TextField");
        kdtEntrys_henQtyPerday_TextField.setVisible(true);
        kdtEntrys_henQtyPerday_TextField.setEditable(true);
        kdtEntrys_henQtyPerday_TextField.setHorizontalAlignment(2);
        kdtEntrys_henQtyPerday_TextField.setDataType(1);
        	kdtEntrys_henQtyPerday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_henQtyPerday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_henQtyPerday_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_henQtyPerday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henQtyPerday_TextField);
        this.kdtEntrys.getColumn("henQtyPerday").setEditor(kdtEntrys_henQtyPerday_CellEditor);
        final KDBizPromptBox kdtEntrys_cockMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_cockMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_cockMaterial_PromptBox.setVisible(true);
        kdtEntrys_cockMaterial_PromptBox.setEditable(true);
        kdtEntrys_cockMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_cockMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_cockMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_cockMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockMaterial_PromptBox);
        this.kdtEntrys.getColumn("cockMaterial").setEditor(kdtEntrys_cockMaterial_CellEditor);
        ObjectValueRender kdtEntrys_cockMaterial_OVR = new ObjectValueRender();
        kdtEntrys_cockMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("cockMaterial").setRenderer(kdtEntrys_cockMaterial_OVR);
        KDFormattedTextField kdtEntrys_cockQtyPerday_TextField = new KDFormattedTextField();
        kdtEntrys_cockQtyPerday_TextField.setName("kdtEntrys_cockQtyPerday_TextField");
        kdtEntrys_cockQtyPerday_TextField.setVisible(true);
        kdtEntrys_cockQtyPerday_TextField.setEditable(true);
        kdtEntrys_cockQtyPerday_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockQtyPerday_TextField.setDataType(1);
        	kdtEntrys_cockQtyPerday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_cockQtyPerday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_cockQtyPerday_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_cockQtyPerday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockQtyPerday_TextField);
        this.kdtEntrys.getColumn("cockQtyPerday").setEditor(kdtEntrys_cockQtyPerday_CellEditor);
        KDFormattedTextField kdtEntrys_waterQty_TextField = new KDFormattedTextField();
        kdtEntrys_waterQty_TextField.setName("kdtEntrys_waterQty_TextField");
        kdtEntrys_waterQty_TextField.setVisible(true);
        kdtEntrys_waterQty_TextField.setEditable(true);
        kdtEntrys_waterQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_waterQty_TextField.setDataType(1);
        	kdtEntrys_waterQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_waterQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_waterQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_waterQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_waterQty_TextField);
        this.kdtEntrys.getColumn("waterQty").setEditor(kdtEntrys_waterQty_CellEditor);
        KDFormattedTextField kdtEntrys_breedTime_TextField = new KDFormattedTextField();
        kdtEntrys_breedTime_TextField.setName("kdtEntrys_breedTime_TextField");
        kdtEntrys_breedTime_TextField.setVisible(true);
        kdtEntrys_breedTime_TextField.setEditable(true);
        kdtEntrys_breedTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_breedTime_TextField.setDataType(1);
        	kdtEntrys_breedTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_breedTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_breedTime_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_breedTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breedTime_TextField);
        this.kdtEntrys.getColumn("breedTime").setEditor(kdtEntrys_breedTime_CellEditor);
        KDFormattedTextField kdtEntrys_lightingTime_TextField = new KDFormattedTextField();
        kdtEntrys_lightingTime_TextField.setName("kdtEntrys_lightingTime_TextField");
        kdtEntrys_lightingTime_TextField.setVisible(true);
        kdtEntrys_lightingTime_TextField.setEditable(true);
        kdtEntrys_lightingTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_lightingTime_TextField.setDataType(1);
        	kdtEntrys_lightingTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_lightingTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_lightingTime_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_lightingTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lightingTime_TextField);
        this.kdtEntrys.getColumn("lightingTime").setEditor(kdtEntrys_lightingTime_CellEditor);
        KDFormattedTextField kdtEntrys_temperatureTo_TextField = new KDFormattedTextField();
        kdtEntrys_temperatureTo_TextField.setName("kdtEntrys_temperatureTo_TextField");
        kdtEntrys_temperatureTo_TextField.setVisible(true);
        kdtEntrys_temperatureTo_TextField.setEditable(true);
        kdtEntrys_temperatureTo_TextField.setHorizontalAlignment(2);
        kdtEntrys_temperatureTo_TextField.setDataType(1);
        	kdtEntrys_temperatureTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_temperatureTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_temperatureTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_temperatureTo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_temperatureTo_TextField);
        this.kdtEntrys.getColumn("temperatureTo").setEditor(kdtEntrys_temperatureTo_CellEditor);
        KDFormattedTextField kdtEntrys_temperatureFrom_TextField = new KDFormattedTextField();
        kdtEntrys_temperatureFrom_TextField.setName("kdtEntrys_temperatureFrom_TextField");
        kdtEntrys_temperatureFrom_TextField.setVisible(true);
        kdtEntrys_temperatureFrom_TextField.setEditable(true);
        kdtEntrys_temperatureFrom_TextField.setHorizontalAlignment(2);
        kdtEntrys_temperatureFrom_TextField.setDataType(1);
        	kdtEntrys_temperatureFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_temperatureFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_temperatureFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_temperatureFrom_CellEditor = new KDTDefaultCellEditor(kdtEntrys_temperatureFrom_TextField);
        this.kdtEntrys.getColumn("temperatureFrom").setEditor(kdtEntrys_temperatureFrom_CellEditor);
        KDFormattedTextField kdtEntrys_humidityFrom_TextField = new KDFormattedTextField();
        kdtEntrys_humidityFrom_TextField.setName("kdtEntrys_humidityFrom_TextField");
        kdtEntrys_humidityFrom_TextField.setVisible(true);
        kdtEntrys_humidityFrom_TextField.setEditable(true);
        kdtEntrys_humidityFrom_TextField.setHorizontalAlignment(2);
        kdtEntrys_humidityFrom_TextField.setDataType(1);
        	kdtEntrys_humidityFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_humidityFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_humidityFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_humidityFrom_CellEditor = new KDTDefaultCellEditor(kdtEntrys_humidityFrom_TextField);
        this.kdtEntrys.getColumn("humidityFrom").setEditor(kdtEntrys_humidityFrom_CellEditor);
        KDFormattedTextField kdtEntrys_humidityTo_TextField = new KDFormattedTextField();
        kdtEntrys_humidityTo_TextField.setName("kdtEntrys_humidityTo_TextField");
        kdtEntrys_humidityTo_TextField.setVisible(true);
        kdtEntrys_humidityTo_TextField.setEditable(true);
        kdtEntrys_humidityTo_TextField.setHorizontalAlignment(2);
        kdtEntrys_humidityTo_TextField.setDataType(1);
        	kdtEntrys_humidityTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_humidityTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_humidityTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_humidityTo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_humidityTo_TextField);
        this.kdtEntrys.getColumn("humidityTo").setEditor(kdtEntrys_humidityTo_CellEditor);
        // kdtLayEggEntrys
		String kdtLayEggEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"eggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"upEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"freakRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"doubleYolkRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"brokenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{eggRate}</t:Cell><t:Cell>$Resource{upEggRate}</t:Cell><t:Cell>$Resource{freakRate}</t:Cell><t:Cell>$Resource{doubleYolkRate}</t:Cell><t:Cell>$Resource{brokenRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtLayEggEntrys.setFormatXml(resHelper.translateString("kdtLayEggEntrys",kdtLayEggEntrysStrXML));

                this.kdtLayEggEntrys.putBindContents("editData",new String[] {"seq","week","days","eggRate","upEggRate","freakRate","doubleYolkRate","brokenRate"});


        this.kdtLayEggEntrys.checkParsed();
        KDFormattedTextField kdtLayEggEntrys_seq_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_seq_TextField.setName("kdtLayEggEntrys_seq_TextField");
        kdtLayEggEntrys_seq_TextField.setVisible(true);
        kdtLayEggEntrys_seq_TextField.setEditable(true);
        kdtLayEggEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_seq_TextField);
        this.kdtLayEggEntrys.getColumn("seq").setEditor(kdtLayEggEntrys_seq_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_week_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_week_TextField.setName("kdtLayEggEntrys_week_TextField");
        kdtLayEggEntrys_week_TextField.setVisible(true);
        kdtLayEggEntrys_week_TextField.setEditable(true);
        kdtLayEggEntrys_week_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_week_TextField);
        this.kdtLayEggEntrys.getColumn("week").setEditor(kdtLayEggEntrys_week_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_days_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_days_TextField.setName("kdtLayEggEntrys_days_TextField");
        kdtLayEggEntrys_days_TextField.setVisible(true);
        kdtLayEggEntrys_days_TextField.setEditable(true);
        kdtLayEggEntrys_days_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_days_TextField);
        this.kdtLayEggEntrys.getColumn("days").setEditor(kdtLayEggEntrys_days_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_eggRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_eggRate_TextField.setName("kdtLayEggEntrys_eggRate_TextField");
        kdtLayEggEntrys_eggRate_TextField.setVisible(true);
        kdtLayEggEntrys_eggRate_TextField.setEditable(true);
        kdtLayEggEntrys_eggRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_eggRate_TextField.setDataType(1);
        	kdtLayEggEntrys_eggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_eggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_eggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_eggRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_eggRate_TextField);
        this.kdtLayEggEntrys.getColumn("eggRate").setEditor(kdtLayEggEntrys_eggRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_upEggRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_upEggRate_TextField.setName("kdtLayEggEntrys_upEggRate_TextField");
        kdtLayEggEntrys_upEggRate_TextField.setVisible(true);
        kdtLayEggEntrys_upEggRate_TextField.setEditable(true);
        kdtLayEggEntrys_upEggRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_upEggRate_TextField.setDataType(1);
        	kdtLayEggEntrys_upEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_upEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_upEggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_upEggRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_upEggRate_TextField);
        this.kdtLayEggEntrys.getColumn("upEggRate").setEditor(kdtLayEggEntrys_upEggRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_freakRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_freakRate_TextField.setName("kdtLayEggEntrys_freakRate_TextField");
        kdtLayEggEntrys_freakRate_TextField.setVisible(true);
        kdtLayEggEntrys_freakRate_TextField.setEditable(true);
        kdtLayEggEntrys_freakRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_freakRate_TextField.setDataType(1);
        	kdtLayEggEntrys_freakRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_freakRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_freakRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_freakRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_freakRate_TextField);
        this.kdtLayEggEntrys.getColumn("freakRate").setEditor(kdtLayEggEntrys_freakRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_doubleYolkRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_doubleYolkRate_TextField.setName("kdtLayEggEntrys_doubleYolkRate_TextField");
        kdtLayEggEntrys_doubleYolkRate_TextField.setVisible(true);
        kdtLayEggEntrys_doubleYolkRate_TextField.setEditable(true);
        kdtLayEggEntrys_doubleYolkRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_doubleYolkRate_TextField.setDataType(1);
        	kdtLayEggEntrys_doubleYolkRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_doubleYolkRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_doubleYolkRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_doubleYolkRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_doubleYolkRate_TextField);
        this.kdtLayEggEntrys.getColumn("doubleYolkRate").setEditor(kdtLayEggEntrys_doubleYolkRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_brokenRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_brokenRate_TextField.setName("kdtLayEggEntrys_brokenRate_TextField");
        kdtLayEggEntrys_brokenRate_TextField.setVisible(true);
        kdtLayEggEntrys_brokenRate_TextField.setEditable(true);
        kdtLayEggEntrys_brokenRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_brokenRate_TextField.setDataType(1);
        	kdtLayEggEntrys_brokenRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_brokenRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_brokenRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_brokenRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_brokenRate_TextField);
        this.kdtLayEggEntrys.getColumn("brokenRate").setEditor(kdtLayEggEntrys_brokenRate_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"immuneMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"perQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"isMust\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{immuneMaterial}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{perQty}</t:Cell><t:Cell>$Resource{isMust}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtImmuneEntrys.setFormatXml(resHelper.translateString("kdtImmuneEntrys",kdtImmuneEntrysStrXML));

                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","week","days","immuneMaterial","unit","perQty","isMust"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_week_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_week_TextField.setName("kdtImmuneEntrys_week_TextField");
        kdtImmuneEntrys_week_TextField.setVisible(true);
        kdtImmuneEntrys_week_TextField.setEditable(true);
        kdtImmuneEntrys_week_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_week_TextField);
        this.kdtImmuneEntrys.getColumn("week").setEditor(kdtImmuneEntrys_week_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_days_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_days_TextField.setName("kdtImmuneEntrys_days_TextField");
        kdtImmuneEntrys_days_TextField.setVisible(true);
        kdtImmuneEntrys_days_TextField.setEditable(true);
        kdtImmuneEntrys_days_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_days_TextField);
        this.kdtImmuneEntrys.getColumn("days").setEditor(kdtImmuneEntrys_days_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_immuneMaterial_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_immuneMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setVisible(true);
        kdtImmuneEntrys_immuneMaterial_PromptBox.setEditable(true);
        kdtImmuneEntrys_immuneMaterial_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_immuneMaterial_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_immuneMaterial_PromptBox);
        this.kdtImmuneEntrys.getColumn("immuneMaterial").setEditor(kdtImmuneEntrys_immuneMaterial_CellEditor);
        ObjectValueRender kdtImmuneEntrys_immuneMaterial_OVR = new ObjectValueRender();
        kdtImmuneEntrys_immuneMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("immuneMaterial").setRenderer(kdtImmuneEntrys_immuneMaterial_OVR);
        final KDBizPromptBox kdtImmuneEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtImmuneEntrys_unit_PromptBox.setVisible(true);
        kdtImmuneEntrys_unit_PromptBox.setEditable(true);
        kdtImmuneEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_unit_PromptBox);
        this.kdtImmuneEntrys.getColumn("unit").setEditor(kdtImmuneEntrys_unit_CellEditor);
        ObjectValueRender kdtImmuneEntrys_unit_OVR = new ObjectValueRender();
        kdtImmuneEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("unit").setRenderer(kdtImmuneEntrys_unit_OVR);
        KDFormattedTextField kdtImmuneEntrys_perQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_perQty_TextField.setName("kdtImmuneEntrys_perQty_TextField");
        kdtImmuneEntrys_perQty_TextField.setVisible(true);
        kdtImmuneEntrys_perQty_TextField.setEditable(true);
        kdtImmuneEntrys_perQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_perQty_TextField.setDataType(1);
        	kdtImmuneEntrys_perQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtImmuneEntrys_perQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtImmuneEntrys_perQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtImmuneEntrys_perQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_perQty_TextField);
        this.kdtImmuneEntrys.getColumn("perQty").setEditor(kdtImmuneEntrys_perQty_CellEditor);
        KDCheckBox kdtImmuneEntrys_isMust_CheckBox = new KDCheckBox();
        kdtImmuneEntrys_isMust_CheckBox.setName("kdtImmuneEntrys_isMust_CheckBox");
        KDTDefaultCellEditor kdtImmuneEntrys_isMust_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_isMust_CheckBox);
        this.kdtImmuneEntrys.getColumn("isMust").setEditor(kdtImmuneEntrys_isMust_CellEditor);
        // pkbeginDate		
        this.pkbeginDate.setRequired(false);		
        this.pkbeginDate.setEnabled(false);
        // pkendDate		
        this.pkendDate.setRequired(false);		
        this.pkendDate.setEnabled(false);
        // prmtauditor		
        this.prmtauditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtauditor.setEditable(true);		
        this.prmtauditor.setDisplayFormat("$number$");		
        this.prmtauditor.setEditFormat("$number$");		
        this.prmtauditor.setCommitFormat("$number$");		
        this.prmtauditor.setRequired(false);		
        this.prmtauditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // houseType		
        this.houseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.breed.HenhouseType").toArray());		
        this.houseType.setRequired(true);
        this.houseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    houseType_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // deletedStatus		
        this.deletedStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.breed.DisableState").toArray());		
        this.deletedStatus.setRequired(false);		
        this.deletedStatus.setEnabled(false);
        // txtbreedDays		
        this.txtbreedDays.setHorizontalAlignment(2);		
        this.txtbreedDays.setDataType(0);		
        this.txtbreedDays.setSupportedEmpty(true);		
        this.txtbreedDays.setRequired(false);
        // txtlimitBreedDays		
        this.txtlimitBreedDays.setHorizontalAlignment(2);		
        this.txtlimitBreedDays.setDataType(0);		
        this.txtlimitBreedDays.setSupportedEmpty(true);		
        this.txtlimitBreedDays.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtVarietie		
        this.prmtVarietie.setQueryInfo("com.kingdee.eas.farm.breed.app.VarietieQuery");		
        this.prmtVarietie.setVisible(true);		
        this.prmtVarietie.setEditable(true);		
        this.prmtVarietie.setDisplayFormat("$name$");		
        this.prmtVarietie.setEditFormat("$number$");		
        this.prmtVarietie.setCommitFormat("$number$");		
        this.prmtVarietie.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,txtName,prmtcompany,houseType,chkisMoulting,chkisDefault,deletedStatus,txtbreedDays,txtlimitBreedDays,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,pkauditTime,prmtauditor,pkbeginDate,pkendDate,txtSimpleName,txtDescription,kdtEntrys,kdtLayEggEntrys,kdtImmuneEntrys,prmtVarietie}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        kDLabelContainer1.setBounds(new Rectangle(33, 23, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(33, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(378, 23, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(378, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(33, -75, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(33, -75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(378, 104, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(378, 104, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(36, 575, 270, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(36, 575, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(379, 575, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(379, 575, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(36, 598, 270, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(36, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer9.setBounds(new Rectangle(379, 598, 270, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(379, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(26, 136, 972, 427));
        this.add(kDTabbedPane1, new KDLayout.Constraints(26, 136, 972, 427, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbeginDate.setBounds(new Rectangle(378, 51, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(378, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(715, 51, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(715, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditor.setBounds(new Rectangle(726, 575, 270, 19));
        this.add(contauditor, new KDLayout.Constraints(726, 575, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(726, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(726, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthouseType.setBounds(new Rectangle(33, 77, 270, 19));
        this.add(conthouseType, new KDLayout.Constraints(33, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeletedStatus.setBounds(new Rectangle(715, 23, 270, 19));
        this.add(contdeletedStatus, new KDLayout.Constraints(715, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedDays.setBounds(new Rectangle(378, 77, 270, 19));
        this.add(contbreedDays, new KDLayout.Constraints(378, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlimitBreedDays.setBounds(new Rectangle(715, 77, 270, 19));
        this.add(contlimitBreedDays, new KDLayout.Constraints(715, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisDefault.setBounds(new Rectangle(175, 104, 123, 19));
        this.add(chkisDefault, new KDLayout.Constraints(175, 104, 123, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisMoulting.setBounds(new Rectangle(33, 104, 108, 19));
        this.add(chkisMoulting, new KDLayout.Constraints(33, 104, 108, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(33, 51, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(33, 51, 270, 19, 0));
        contVarietie.setBounds(new Rectangle(716, 102, 270, 19));
        this.add(contVarietie, new KDLayout.Constraints(716, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(prmtCreator);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(prmtLastUpdateUser);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(kDDateCreateTime);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(kDDateLastUpdateTime);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 394));        kdtEntrys.setBounds(new Rectangle(1, 1, 963, 405));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.BreedModelEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 963, 405, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 394));        kdtLayEggEntrys.setBounds(new Rectangle(2, 1, 962, 421));
        kdtLayEggEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtLayEggEntrys,new com.kingdee.eas.farm.breed.BreedModelLayEggEntryInfo(),null,false);
        kDPanel2.add(kdtLayEggEntrys_detailPanel, new KDLayout.Constraints(2, 1, 962, 421, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 394));        kdtImmuneEntrys.setBounds(new Rectangle(1, 0, 962, 419));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.breed.BreedModelImmuneEntryInfo(),null,false);
        kDPanel3.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(1, 0, 962, 419, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //conthouseType
        conthouseType.setBoundEditor(houseType);
        //contdeletedStatus
        contdeletedStatus.setBoundEditor(deletedStatus);
        //contbreedDays
        contbreedDays.setBoundEditor(txtbreedDays);
        //contlimitBreedDays
        contlimitBreedDays.setBoundEditor(txtlimitBreedDays);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contVarietie
        contVarietie.setBoundEditor(prmtVarietie);

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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isDefault", boolean.class, this.chkisDefault, "selected");
		dataBinder.registerBinding("isMoulting", boolean.class, this.chkisMoulting, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.farm.breed.BreedModelEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.week", int.class, this.kdtEntrys, "week.text");
		dataBinder.registerBinding("Entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("Entrys.qtyPerday", java.math.BigDecimal.class, this.kdtEntrys, "qtyPerday.text");
		dataBinder.registerBinding("Entrys.henMaterial", java.lang.Object.class, this.kdtEntrys, "henMaterial.text");
		dataBinder.registerBinding("Entrys.henQtyPerday", java.math.BigDecimal.class, this.kdtEntrys, "henQtyPerday.text");
		dataBinder.registerBinding("Entrys.cockMaterial", java.lang.Object.class, this.kdtEntrys, "cockMaterial.text");
		dataBinder.registerBinding("Entrys.cockQtyPerday", java.math.BigDecimal.class, this.kdtEntrys, "cockQtyPerday.text");
		dataBinder.registerBinding("Entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("Entrys.breedTime", java.math.BigDecimal.class, this.kdtEntrys, "breedTime.text");
		dataBinder.registerBinding("Entrys.lightingTime", java.math.BigDecimal.class, this.kdtEntrys, "lightingTime.text");
		dataBinder.registerBinding("Entrys.temperatureTo", java.math.BigDecimal.class, this.kdtEntrys, "temperatureTo.text");
		dataBinder.registerBinding("Entrys.temperatureFrom", java.math.BigDecimal.class, this.kdtEntrys, "temperatureFrom.text");
		dataBinder.registerBinding("Entrys.humidityFrom", java.math.BigDecimal.class, this.kdtEntrys, "humidityFrom.text");
		dataBinder.registerBinding("Entrys.humidityTo", java.math.BigDecimal.class, this.kdtEntrys, "humidityTo.text");
		dataBinder.registerBinding("Entrys.days", int.class, this.kdtEntrys, "days.text");
		dataBinder.registerBinding("Entrys.standardWeight", java.math.BigDecimal.class, this.kdtEntrys, "standardWeight.text");
		dataBinder.registerBinding("Entrys.dynamiting", java.math.BigDecimal.class, this.kdtEntrys, "dynamiting.text");
		dataBinder.registerBinding("Entrys.dailyDCRate", java.math.BigDecimal.class, this.kdtEntrys, "dailyDCRate.text");
		dataBinder.registerBinding("LayEggEntrys.seq", int.class, this.kdtLayEggEntrys, "seq.text");
		dataBinder.registerBinding("LayEggEntrys", com.kingdee.eas.farm.breed.BreedModelLayEggEntryInfo.class, this.kdtLayEggEntrys, "userObject");
		dataBinder.registerBinding("LayEggEntrys.week", int.class, this.kdtLayEggEntrys, "week.text");
		dataBinder.registerBinding("LayEggEntrys.days", int.class, this.kdtLayEggEntrys, "days.text");
		dataBinder.registerBinding("LayEggEntrys.eggRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "eggRate.text");
		dataBinder.registerBinding("LayEggEntrys.upEggRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "upEggRate.text");
		dataBinder.registerBinding("LayEggEntrys.freakRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "freakRate.text");
		dataBinder.registerBinding("LayEggEntrys.doubleYolkRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "doubleYolkRate.text");
		dataBinder.registerBinding("LayEggEntrys.brokenRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "brokenRate.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.breed.BreedModelImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.week", int.class, this.kdtImmuneEntrys, "week.text");
		dataBinder.registerBinding("ImmuneEntrys.days", int.class, this.kdtImmuneEntrys, "days.text");
		dataBinder.registerBinding("ImmuneEntrys.immuneMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "immuneMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.perQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "perQty.text");
		dataBinder.registerBinding("ImmuneEntrys.unit", java.lang.Object.class, this.kdtImmuneEntrys, "unit.text");
		dataBinder.registerBinding("ImmuneEntrys.isMust", boolean.class, this.kdtImmuneEntrys, "isMust.text");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("houseType", com.kingdee.eas.farm.breed.HenhouseType.class, this.houseType, "selectedItem");
		dataBinder.registerBinding("deletedStatus", com.kingdee.eas.farm.breed.DisableState.class, this.deletedStatus, "selectedItem");
		dataBinder.registerBinding("breedDays", int.class, this.txtbreedDays, "value");
		dataBinder.registerBinding("limitBreedDays", int.class, this.txtlimitBreedDays, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("Varietie", com.kingdee.eas.farm.breed.VarietieInfo.class, this.prmtVarietie, "data");		
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
	    return "com.kingdee.eas.farm.breed.app.BreedModelEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.BreedModelInfo)ov;
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
	 * ????????ßµ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isDefault", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isMoulting", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.qtyPerday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.henMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.henQtyPerday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.cockMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.cockQtyPerday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.standardWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.dynamiting", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.dailyDCRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.eggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.upEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.freakRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.doubleYolkRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.brokenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.immuneMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.perQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.isMust", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("houseType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deletedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("limitBreedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Varietie", ValidateHelper.ON_SAVE);    		
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
     * output houseType_actionPerformed method
     */
    protected void houseType_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
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
        sic.add(new SelectorItemInfo("isDefault"));
        sic.add(new SelectorItemInfo("isMoulting"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entrys.week"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.material.id"));
			sic.add(new SelectorItemInfo("Entrys.material.name"));
        	sic.add(new SelectorItemInfo("Entrys.material.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.qtyPerday"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.henMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.henMaterial.id"));
			sic.add(new SelectorItemInfo("Entrys.henMaterial.name"));
        	sic.add(new SelectorItemInfo("Entrys.henMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.henQtyPerday"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.cockMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.cockMaterial.id"));
			sic.add(new SelectorItemInfo("Entrys.cockMaterial.name"));
        	sic.add(new SelectorItemInfo("Entrys.cockMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.cockQtyPerday"));
    	sic.add(new SelectorItemInfo("Entrys.waterQty"));
    	sic.add(new SelectorItemInfo("Entrys.breedTime"));
    	sic.add(new SelectorItemInfo("Entrys.lightingTime"));
    	sic.add(new SelectorItemInfo("Entrys.temperatureTo"));
    	sic.add(new SelectorItemInfo("Entrys.temperatureFrom"));
    	sic.add(new SelectorItemInfo("Entrys.humidityFrom"));
    	sic.add(new SelectorItemInfo("Entrys.humidityTo"));
    	sic.add(new SelectorItemInfo("Entrys.days"));
    	sic.add(new SelectorItemInfo("Entrys.standardWeight"));
    	sic.add(new SelectorItemInfo("Entrys.dynamiting"));
    	sic.add(new SelectorItemInfo("Entrys.dailyDCRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LayEggEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("LayEggEntrys.week"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.days"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.eggRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.upEggRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.freakRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.doubleYolkRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.brokenRate"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.week"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.days"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.perQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.unit.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.unit.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.isMust"));
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("houseType"));
        sic.add(new SelectorItemInfo("deletedStatus"));
        sic.add(new SelectorItemInfo("breedDays"));
        sic.add(new SelectorItemInfo("limitBreedDays"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Varietie.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("Varietie.id"));
        	sic.add(new SelectorItemInfo("Varietie.number"));
        	sic.add(new SelectorItemInfo("Varietie.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.client", "BreedModelEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.breed.client.BreedModelEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.BreedModelFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.BreedModelInfo objectValue = new com.kingdee.eas.farm.breed.BreedModelInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(houseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"º¶…·¿‡±"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("houseType","0");
vo.put("deletedStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}