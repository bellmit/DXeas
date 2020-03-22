/**
 * output package name
 */
package com.kingdee.eas.custom.wages.farm.client;

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
public abstract class AbstractBasicPostFarmEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBasicPostFarmEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPostSalary;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProductRatio;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contUnitMetering;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contposition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfromposition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasicwages;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEpidemicSub;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPostSalary;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtProductRatio;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox UnitMetering;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BaseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtposition;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostname;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfromposition;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasicwages;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtEpidemicSub;
    protected com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBasicPostFarmEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBasicPostFarmEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPostSalary = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contProductRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contUnitMetering = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contposition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfromposition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasicwages = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEpidemicSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtPostSalary = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtProductRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.UnitMetering = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.BaseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtposition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpostname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfromposition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbasicwages = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtEpidemicSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contPostSalary.setName("contPostSalary");
        this.contProductRatio.setName("contProductRatio");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contUnitMetering.setName("contUnitMetering");
        this.contBaseStatus.setName("contBaseStatus");
        this.contposition.setName("contposition");
        this.contpostname.setName("contpostname");
        this.contfromposition.setName("contfromposition");
        this.contbasicwages.setName("contbasicwages");
        this.contEpidemicSub.setName("contEpidemicSub");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtPostSalary.setName("txtPostSalary");
        this.txtProductRatio.setName("txtProductRatio");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntry.setName("kdtEntry");
        this.UnitMetering.setName("UnitMetering");
        this.BaseStatus.setName("BaseStatus");
        this.prmtposition.setName("prmtposition");
        this.txtpostname.setName("txtpostname");
        this.prmtfromposition.setName("prmtfromposition");
        this.txtbasicwages.setName("txtbasicwages");
        this.txtEpidemicSub.setName("txtEpidemicSub");
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
        // contPostSalary		
        this.contPostSalary.setBoundLabelText(resHelper.getString("contPostSalary.boundLabelText"));		
        this.contPostSalary.setBoundLabelLength(100);		
        this.contPostSalary.setBoundLabelUnderline(true);		
        this.contPostSalary.setVisible(true);
        // contProductRatio		
        this.contProductRatio.setBoundLabelText(resHelper.getString("contProductRatio.boundLabelText"));		
        this.contProductRatio.setBoundLabelLength(100);		
        this.contProductRatio.setBoundLabelUnderline(true);		
        this.contProductRatio.setVisible(true);
        // kDTabbedPane1
        // contUnitMetering		
        this.contUnitMetering.setBoundLabelText(resHelper.getString("contUnitMetering.boundLabelText"));		
        this.contUnitMetering.setBoundLabelLength(100);		
        this.contUnitMetering.setBoundLabelUnderline(true);		
        this.contUnitMetering.setVisible(true);
        // contBaseStatus		
        this.contBaseStatus.setBoundLabelText(resHelper.getString("contBaseStatus.boundLabelText"));		
        this.contBaseStatus.setBoundLabelLength(100);		
        this.contBaseStatus.setBoundLabelUnderline(true);		
        this.contBaseStatus.setVisible(true);
        // contposition		
        this.contposition.setBoundLabelText(resHelper.getString("contposition.boundLabelText"));		
        this.contposition.setBoundLabelLength(100);		
        this.contposition.setBoundLabelUnderline(true);		
        this.contposition.setVisible(true);
        // contpostname		
        this.contpostname.setBoundLabelText(resHelper.getString("contpostname.boundLabelText"));		
        this.contpostname.setBoundLabelLength(100);		
        this.contpostname.setBoundLabelUnderline(true);		
        this.contpostname.setVisible(true);
        // contfromposition		
        this.contfromposition.setBoundLabelText(resHelper.getString("contfromposition.boundLabelText"));		
        this.contfromposition.setBoundLabelLength(100);		
        this.contfromposition.setBoundLabelUnderline(true);		
        this.contfromposition.setVisible(true);
        // contbasicwages		
        this.contbasicwages.setBoundLabelText(resHelper.getString("contbasicwages.boundLabelText"));		
        this.contbasicwages.setBoundLabelLength(100);		
        this.contbasicwages.setBoundLabelUnderline(true);		
        this.contbasicwages.setVisible(true);
        // contEpidemicSub		
        this.contEpidemicSub.setBoundLabelText(resHelper.getString("contEpidemicSub.boundLabelText"));		
        this.contEpidemicSub.setBoundLabelLength(100);		
        this.contEpidemicSub.setBoundLabelUnderline(true);		
        this.contEpidemicSub.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtPostSalary		
        this.txtPostSalary.setVisible(true);		
        this.txtPostSalary.setHorizontalAlignment(2);		
        this.txtPostSalary.setDataType(1);		
        this.txtPostSalary.setSupportedEmpty(true);		
        this.txtPostSalary.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtPostSalary.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtPostSalary.setPrecision(2);		
        this.txtPostSalary.setRequired(false);
        // txtProductRatio		
        this.txtProductRatio.setVisible(true);		
        this.txtProductRatio.setHorizontalAlignment(2);		
        this.txtProductRatio.setDataType(1);		
        this.txtProductRatio.setSupportedEmpty(true);		
        this.txtProductRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtProductRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtProductRatio.setPrecision(4);		
        this.txtProductRatio.setRequired(false);
        // kDPanel1
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personnumber}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","person","personnumber"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_person_PromptBox = new KDBizPromptBox();
        kdtEntry_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntry_person_PromptBox.setVisible(true);
        kdtEntry_person_PromptBox.setEditable(true);
        kdtEntry_person_PromptBox.setDisplayFormat("$number$");
        kdtEntry_person_PromptBox.setEditFormat("$number$");
        kdtEntry_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_person_CellEditor = new KDTDefaultCellEditor(kdtEntry_person_PromptBox);
        this.kdtEntry.getColumn("person").setEditor(kdtEntry_person_CellEditor);
        ObjectValueRender kdtEntry_person_OVR = new ObjectValueRender();
        kdtEntry_person_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("person").setRenderer(kdtEntry_person_OVR);
        KDTextField kdtEntry_personnumber_TextField = new KDTextField();
        kdtEntry_personnumber_TextField.setName("kdtEntry_personnumber_TextField");
        kdtEntry_personnumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_personnumber_CellEditor = new KDTDefaultCellEditor(kdtEntry_personnumber_TextField);
        this.kdtEntry.getColumn("personnumber").setEditor(kdtEntry_personnumber_CellEditor);
        // UnitMetering		
        this.UnitMetering.setVisible(true);		
        this.UnitMetering.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.UnitOfMetering").toArray());		
        this.UnitMetering.setRequired(false);
        // BaseStatus		
        this.BaseStatus.setVisible(true);		
        this.BaseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.BasicStatus").toArray());		
        this.BaseStatus.setRequired(false);
        // prmtposition		
        this.prmtposition.setQueryInfo("com.kingdee.eas.basedata.org.app.PositionQuery");		
        this.prmtposition.setVisible(true);		
        this.prmtposition.setEditable(true);		
        this.prmtposition.setDisplayFormat("$name$");		
        this.prmtposition.setEditFormat("$number$");		
        this.prmtposition.setCommitFormat("$number$");		
        this.prmtposition.setRequired(false);
        // txtpostname		
        this.txtpostname.setVisible(true);		
        this.txtpostname.setHorizontalAlignment(2);		
        this.txtpostname.setMaxLength(100);		
        this.txtpostname.setRequired(false);
        // prmtfromposition		
        this.prmtfromposition.setQueryInfo("com.kingdee.eas.custom.wages.farm.app.WagesFarmOrganQuery");		
        this.prmtfromposition.setVisible(true);		
        this.prmtfromposition.setEditable(true);		
        this.prmtfromposition.setDisplayFormat("$name$");		
        this.prmtfromposition.setEditFormat("$number$");		
        this.prmtfromposition.setCommitFormat("$number$");		
        this.prmtfromposition.setRequired(false);
        		prmtfromposition.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.wages.farm.client.WagesFarmOrganListUI prmtfromposition_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfromposition_F7ListUI == null) {
					try {
						prmtfromposition_F7ListUI = new com.kingdee.eas.custom.wages.farm.client.WagesFarmOrganListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfromposition_F7ListUI));
					prmtfromposition_F7ListUI.setF7Use(true,ctx);
					prmtfromposition.setSelector(prmtfromposition_F7ListUI);
				}
			}
		});
					
        // txtbasicwages		
        this.txtbasicwages.setVisible(true);		
        this.txtbasicwages.setHorizontalAlignment(2);		
        this.txtbasicwages.setDataType(1);		
        this.txtbasicwages.setSupportedEmpty(true);		
        this.txtbasicwages.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasicwages.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasicwages.setPrecision(2);		
        this.txtbasicwages.setRequired(false);
        // txtEpidemicSub		
        this.txtEpidemicSub.setVisible(true);		
        this.txtEpidemicSub.setHorizontalAlignment(2);		
        this.txtEpidemicSub.setDataType(1);		
        this.txtEpidemicSub.setSupportedEmpty(true);		
        this.txtEpidemicSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtEpidemicSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtEpidemicSub.setPrecision(2);		
        this.txtEpidemicSub.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtProductRatio,txtPostSalary,txtSimpleName,txtDescription,txtNumber,txtName,UnitMetering,BaseStatus,prmtposition,txtpostname,prmtfromposition,txtbasicwages,txtEpidemicSub,kdtEntry}));
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
        this.setBounds(new Rectangle(0, 2, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 2, 1013, 629));
        kDLabelContainer1.setBounds(new Rectangle(30, 25, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(30, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(-342, 25, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(-342, 25, 270, 19, 0));
        kDLabelContainer3.setBounds(new Rectangle(694, -23, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(694, -23, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(695, 66, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(695, 66, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPostSalary.setBounds(new Rectangle(696, 115, 270, 19));
        this.add(contPostSalary, new KDLayout.Constraints(696, 115, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contProductRatio.setBounds(new Rectangle(-343, 68, 270, 19));
        this.add(contProductRatio, new KDLayout.Constraints(-343, 68, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(30, 163, 939, 432));
        this.add(kDTabbedPane1, new KDLayout.Constraints(30, 163, 939, 432, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contUnitMetering.setBounds(new Rectangle(-343, 113, 270, 19));
        this.add(contUnitMetering, new KDLayout.Constraints(-343, 113, 270, 19, 0));
        contBaseStatus.setBounds(new Rectangle(696, 23, 270, 19));
        this.add(contBaseStatus, new KDLayout.Constraints(696, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contposition.setBounds(new Rectangle(343, 24, 270, 19));
        this.add(contposition, new KDLayout.Constraints(343, 24, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpostname.setBounds(new Rectangle(30, 68, 270, 19));
        this.add(contpostname, new KDLayout.Constraints(30, 68, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfromposition.setBounds(new Rectangle(31, 114, 270, 19));
        this.add(contfromposition, new KDLayout.Constraints(31, 114, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbasicwages.setBounds(new Rectangle(343, 112, 270, 19));
        this.add(contbasicwages, new KDLayout.Constraints(343, 112, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contEpidemicSub.setBounds(new Rectangle(343, 67, 270, 19));
        this.add(contEpidemicSub, new KDLayout.Constraints(343, 67, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contPostSalary
        contPostSalary.setBoundEditor(txtPostSalary);
        //contProductRatio
        contProductRatio.setBoundEditor(txtProductRatio);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 938, 399));        kdtEntry.setBounds(new Rectangle(1, 1, 931, 401));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.wages.farm.BasicPostFarmEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, new KDLayout.Constraints(1, 1, 931, 401, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contUnitMetering
        contUnitMetering.setBoundEditor(UnitMetering);
        //contBaseStatus
        contBaseStatus.setBoundEditor(BaseStatus);
        //contposition
        contposition.setBoundEditor(prmtposition);
        //contpostname
        contpostname.setBoundEditor(txtpostname);
        //contfromposition
        contfromposition.setBoundEditor(prmtfromposition);
        //contbasicwages
        contbasicwages.setBoundEditor(txtbasicwages);
        //contEpidemicSub
        contEpidemicSub.setBoundEditor(txtEpidemicSub);

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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("PostSalary", java.math.BigDecimal.class, this.txtPostSalary, "value");
		dataBinder.registerBinding("ProductRatio", java.math.BigDecimal.class, this.txtProductRatio, "value");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.wages.farm.BasicPostFarmEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.person", java.lang.Object.class, this.kdtEntry, "person.text");
		dataBinder.registerBinding("Entry.personnumber", String.class, this.kdtEntry, "personnumber.text");
		dataBinder.registerBinding("UnitMetering", com.kingdee.eas.custom.wages.UnitOfMetering.class, this.UnitMetering, "selectedItem");
		dataBinder.registerBinding("BaseStatus", com.kingdee.eas.custom.wages.BasicStatus.class, this.BaseStatus, "selectedItem");
		dataBinder.registerBinding("position", com.kingdee.eas.basedata.org.PositionInfo.class, this.prmtposition, "data");
		dataBinder.registerBinding("postname", String.class, this.txtpostname, "text");
		dataBinder.registerBinding("fromposition", com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo.class, this.prmtfromposition, "data");
		dataBinder.registerBinding("basicwages", java.math.BigDecimal.class, this.txtbasicwages, "value");
		dataBinder.registerBinding("EpidemicSub", java.math.BigDecimal.class, this.txtEpidemicSub, "value");		
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
	    return "com.kingdee.eas.custom.wages.farm.app.BasicPostFarmEditUIHandler";
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
        this.txtProductRatio.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo)ov;
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
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PostSalary", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ProductRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.personnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("UnitMetering", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BaseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("position", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fromposition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basicwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EpidemicSub", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("person".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"personnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"person").getValue(),"number")));

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
        sic.add(new SelectorItemInfo("PostSalary"));
        sic.add(new SelectorItemInfo("ProductRatio"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.person.id"));
			sic.add(new SelectorItemInfo("Entry.person.name"));
        	sic.add(new SelectorItemInfo("Entry.person.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.personnumber"));
        sic.add(new SelectorItemInfo("UnitMetering"));
        sic.add(new SelectorItemInfo("BaseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("position.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("position.id"));
        	sic.add(new SelectorItemInfo("position.number"));
        	sic.add(new SelectorItemInfo("position.name"));
		}
        sic.add(new SelectorItemInfo("postname"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("fromposition.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("fromposition.id"));
        	sic.add(new SelectorItemInfo("fromposition.number"));
        	sic.add(new SelectorItemInfo("fromposition.name"));
		}
        sic.add(new SelectorItemInfo("basicwages"));
        sic.add(new SelectorItemInfo("EpidemicSub"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.farm.client", "BasicPostFarmEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.farm.client.BasicPostFarmEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.farm.BasicPostFarmFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo objectValue = new com.kingdee.eas.custom.wages.farm.BasicPostFarmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
				vo.put("PostSalary",new java.math.BigDecimal(0));
vo.put("UnitMetering","0");
vo.put("BaseStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}