/**
 * output package name
 */
package com.kingdee.eas.farm.pig.breedingsow.client;

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
public abstract class AbstractSowEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSowEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstrain;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearTag;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneTag;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearGap;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornPigHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrandLevel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweaningWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweaningDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweaningDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonther;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheredityProblem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contleftNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrightNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsowSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsourceBillNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contskinFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthairFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthoofFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparent;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstrain;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtearTag;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtimmuneTag;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtearGap;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbornFarm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbornAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbornPigHouse;
    protected com.kingdee.bos.ctrl.swing.KDComboBox grandLevel;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbornDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbornWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweaningWeight;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkweaningDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweaningDays;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmonther;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheredityProblem;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtleftNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrightNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsowSource;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsourceBillNumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtearFeature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtskinFeature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthairFeature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthoofFeature;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparent;
    protected com.kingdee.eas.farm.pig.breedingsow.SowInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSowEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSowEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstrain = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearTag = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneTag = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearGap = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornPigHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrandLevel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweaningWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweaningDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweaningDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonther = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheredityProblem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contleftNippleCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrightNippleCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsowSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsourceBillNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contskinFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthairFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthoofFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contparent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtpigType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstrain = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtearTag = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtimmuneTag = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtearGap = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbornFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbornAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbornPigHouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.grandLevel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkbornDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbornWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweaningWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkweaningDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtweaningDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtmonther = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtheredityProblem = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtleftNippleCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrightNippleCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsowSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsourceBillNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtearFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtskinFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthairFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthoofFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtparent = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contpigType.setName("contpigType");
        this.contstrain.setName("contstrain");
        this.contearTag.setName("contearTag");
        this.contimmuneTag.setName("contimmuneTag");
        this.contearGap.setName("contearGap");
        this.contfarm.setName("contfarm");
        this.contbornFarm.setName("contbornFarm");
        this.contbornAddress.setName("contbornAddress");
        this.contbornPigHouse.setName("contbornPigHouse");
        this.contgrandLevel.setName("contgrandLevel");
        this.contbornDate.setName("contbornDate");
        this.contbornWeight.setName("contbornWeight");
        this.contweaningWeight.setName("contweaningWeight");
        this.contweaningDate.setName("contweaningDate");
        this.contweaningDays.setName("contweaningDays");
        this.contmonther.setName("contmonther");
        this.contheredityProblem.setName("contheredityProblem");
        this.contleftNippleCount.setName("contleftNippleCount");
        this.contrightNippleCount.setName("contrightNippleCount");
        this.contsowSource.setName("contsowSource");
        this.contsourceBillNumber.setName("contsourceBillNumber");
        this.contstatus.setName("contstatus");
        this.contearFeature.setName("contearFeature");
        this.contskinFeature.setName("contskinFeature");
        this.conthairFeature.setName("conthairFeature");
        this.conthoofFeature.setName("conthoofFeature");
        this.contparent.setName("contparent");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtpigType.setName("prmtpigType");
        this.prmtstrain.setName("prmtstrain");
        this.txtearTag.setName("txtearTag");
        this.txtimmuneTag.setName("txtimmuneTag");
        this.txtearGap.setName("txtearGap");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbornFarm.setName("prmtbornFarm");
        this.txtbornAddress.setName("txtbornAddress");
        this.prmtbornPigHouse.setName("prmtbornPigHouse");
        this.grandLevel.setName("grandLevel");
        this.pkbornDate.setName("pkbornDate");
        this.txtbornWeight.setName("txtbornWeight");
        this.txtweaningWeight.setName("txtweaningWeight");
        this.pkweaningDate.setName("pkweaningDate");
        this.txtweaningDays.setName("txtweaningDays");
        this.prmtmonther.setName("prmtmonther");
        this.txtheredityProblem.setName("txtheredityProblem");
        this.txtleftNippleCount.setName("txtleftNippleCount");
        this.txtrightNippleCount.setName("txtrightNippleCount");
        this.txtsowSource.setName("txtsowSource");
        this.txtsourceBillNumber.setName("txtsourceBillNumber");
        this.status.setName("status");
        this.txtearFeature.setName("txtearFeature");
        this.txtskinFeature.setName("txtskinFeature");
        this.txthairFeature.setName("txthairFeature");
        this.txthoofFeature.setName("txthoofFeature");
        this.prmtparent.setName("prmtparent");
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
        // contpigType		
        this.contpigType.setBoundLabelText(resHelper.getString("contpigType.boundLabelText"));		
        this.contpigType.setBoundLabelLength(100);		
        this.contpigType.setBoundLabelUnderline(true);		
        this.contpigType.setVisible(true);
        // contstrain		
        this.contstrain.setBoundLabelText(resHelper.getString("contstrain.boundLabelText"));		
        this.contstrain.setBoundLabelLength(100);		
        this.contstrain.setBoundLabelUnderline(true);		
        this.contstrain.setVisible(true);
        // contearTag		
        this.contearTag.setBoundLabelText(resHelper.getString("contearTag.boundLabelText"));		
        this.contearTag.setBoundLabelLength(100);		
        this.contearTag.setBoundLabelUnderline(true);		
        this.contearTag.setVisible(true);
        // contimmuneTag		
        this.contimmuneTag.setBoundLabelText(resHelper.getString("contimmuneTag.boundLabelText"));		
        this.contimmuneTag.setBoundLabelLength(100);		
        this.contimmuneTag.setBoundLabelUnderline(true);		
        this.contimmuneTag.setVisible(true);
        // contearGap		
        this.contearGap.setBoundLabelText(resHelper.getString("contearGap.boundLabelText"));		
        this.contearGap.setBoundLabelLength(100);		
        this.contearGap.setBoundLabelUnderline(true);		
        this.contearGap.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contbornFarm		
        this.contbornFarm.setBoundLabelText(resHelper.getString("contbornFarm.boundLabelText"));		
        this.contbornFarm.setBoundLabelLength(100);		
        this.contbornFarm.setBoundLabelUnderline(true);		
        this.contbornFarm.setVisible(true);
        // contbornAddress		
        this.contbornAddress.setBoundLabelText(resHelper.getString("contbornAddress.boundLabelText"));		
        this.contbornAddress.setBoundLabelLength(100);		
        this.contbornAddress.setBoundLabelUnderline(true);		
        this.contbornAddress.setVisible(true);
        // contbornPigHouse		
        this.contbornPigHouse.setBoundLabelText(resHelper.getString("contbornPigHouse.boundLabelText"));		
        this.contbornPigHouse.setBoundLabelLength(100);		
        this.contbornPigHouse.setBoundLabelUnderline(true);		
        this.contbornPigHouse.setVisible(true);
        // contgrandLevel		
        this.contgrandLevel.setBoundLabelText(resHelper.getString("contgrandLevel.boundLabelText"));		
        this.contgrandLevel.setBoundLabelLength(100);		
        this.contgrandLevel.setBoundLabelUnderline(true);		
        this.contgrandLevel.setVisible(true);
        // contbornDate		
        this.contbornDate.setBoundLabelText(resHelper.getString("contbornDate.boundLabelText"));		
        this.contbornDate.setBoundLabelLength(100);		
        this.contbornDate.setBoundLabelUnderline(true);		
        this.contbornDate.setVisible(true);
        // contbornWeight		
        this.contbornWeight.setBoundLabelText(resHelper.getString("contbornWeight.boundLabelText"));		
        this.contbornWeight.setBoundLabelLength(100);		
        this.contbornWeight.setBoundLabelUnderline(true);		
        this.contbornWeight.setVisible(true);
        // contweaningWeight		
        this.contweaningWeight.setBoundLabelText(resHelper.getString("contweaningWeight.boundLabelText"));		
        this.contweaningWeight.setBoundLabelLength(100);		
        this.contweaningWeight.setBoundLabelUnderline(true);		
        this.contweaningWeight.setVisible(true);
        // contweaningDate		
        this.contweaningDate.setBoundLabelText(resHelper.getString("contweaningDate.boundLabelText"));		
        this.contweaningDate.setBoundLabelLength(100);		
        this.contweaningDate.setBoundLabelUnderline(true);		
        this.contweaningDate.setVisible(true);
        // contweaningDays		
        this.contweaningDays.setBoundLabelText(resHelper.getString("contweaningDays.boundLabelText"));		
        this.contweaningDays.setBoundLabelLength(100);		
        this.contweaningDays.setBoundLabelUnderline(true);		
        this.contweaningDays.setVisible(true);
        // contmonther		
        this.contmonther.setBoundLabelText(resHelper.getString("contmonther.boundLabelText"));		
        this.contmonther.setBoundLabelLength(100);		
        this.contmonther.setBoundLabelUnderline(true);		
        this.contmonther.setVisible(true);
        // contheredityProblem		
        this.contheredityProblem.setBoundLabelText(resHelper.getString("contheredityProblem.boundLabelText"));		
        this.contheredityProblem.setBoundLabelLength(100);		
        this.contheredityProblem.setBoundLabelUnderline(true);		
        this.contheredityProblem.setVisible(true);
        // contleftNippleCount		
        this.contleftNippleCount.setBoundLabelText(resHelper.getString("contleftNippleCount.boundLabelText"));		
        this.contleftNippleCount.setBoundLabelLength(100);		
        this.contleftNippleCount.setBoundLabelUnderline(true);		
        this.contleftNippleCount.setVisible(true);
        // contrightNippleCount		
        this.contrightNippleCount.setBoundLabelText(resHelper.getString("contrightNippleCount.boundLabelText"));		
        this.contrightNippleCount.setBoundLabelLength(100);		
        this.contrightNippleCount.setBoundLabelUnderline(true);		
        this.contrightNippleCount.setVisible(true);
        // contsowSource		
        this.contsowSource.setBoundLabelText(resHelper.getString("contsowSource.boundLabelText"));		
        this.contsowSource.setBoundLabelLength(100);		
        this.contsowSource.setBoundLabelUnderline(true);		
        this.contsowSource.setVisible(true);
        // contsourceBillNumber		
        this.contsourceBillNumber.setBoundLabelText(resHelper.getString("contsourceBillNumber.boundLabelText"));		
        this.contsourceBillNumber.setBoundLabelLength(100);		
        this.contsourceBillNumber.setBoundLabelUnderline(true);		
        this.contsourceBillNumber.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // contearFeature		
        this.contearFeature.setBoundLabelText(resHelper.getString("contearFeature.boundLabelText"));		
        this.contearFeature.setBoundLabelLength(100);		
        this.contearFeature.setBoundLabelUnderline(true);		
        this.contearFeature.setVisible(true);
        // contskinFeature		
        this.contskinFeature.setBoundLabelText(resHelper.getString("contskinFeature.boundLabelText"));		
        this.contskinFeature.setBoundLabelLength(100);		
        this.contskinFeature.setBoundLabelUnderline(true);		
        this.contskinFeature.setVisible(true);
        // conthairFeature		
        this.conthairFeature.setBoundLabelText(resHelper.getString("conthairFeature.boundLabelText"));		
        this.conthairFeature.setBoundLabelLength(100);		
        this.conthairFeature.setBoundLabelUnderline(true);		
        this.conthairFeature.setVisible(true);
        // conthoofFeature		
        this.conthoofFeature.setBoundLabelText(resHelper.getString("conthoofFeature.boundLabelText"));		
        this.conthoofFeature.setBoundLabelLength(100);		
        this.conthoofFeature.setBoundLabelUnderline(true);		
        this.conthoofFeature.setVisible(true);
        // contparent		
        this.contparent.setBoundLabelText(resHelper.getString("contparent.boundLabelText"));		
        this.contparent.setBoundLabelLength(100);		
        this.contparent.setBoundLabelUnderline(true);		
        this.contparent.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtpigType		
        this.prmtpigType.setQueryInfo("com.kingdee.eas.farm.pig.app.PigTypeQuery");		
        this.prmtpigType.setVisible(true);		
        this.prmtpigType.setEditable(true);		
        this.prmtpigType.setDisplayFormat("$name$");		
        this.prmtpigType.setEditFormat("$number$");		
        this.prmtpigType.setCommitFormat("$number$");		
        this.prmtpigType.setRequired(false);
        		prmtpigType.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigTypeListUI prmtpigType_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtpigType_F7ListUI == null) {
					try {
						prmtpigType_F7ListUI = new com.kingdee.eas.farm.pig.client.PigTypeListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtpigType_F7ListUI));
					prmtpigType_F7ListUI.setF7Use(true,ctx);
					prmtpigType.setSelector(prmtpigType_F7ListUI);
				}
			}
		});
					
        // prmtstrain		
        this.prmtstrain.setQueryInfo("com.kingdee.eas.farm.pig.app.StrainQuery");		
        this.prmtstrain.setVisible(true);		
        this.prmtstrain.setEditable(true);		
        this.prmtstrain.setDisplayFormat("$name$");		
        this.prmtstrain.setEditFormat("$number$");		
        this.prmtstrain.setCommitFormat("$number$");		
        this.prmtstrain.setRequired(false);
        		prmtstrain.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.StrainListUI prmtstrain_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstrain_F7ListUI == null) {
					try {
						prmtstrain_F7ListUI = new com.kingdee.eas.farm.pig.client.StrainListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstrain_F7ListUI));
					prmtstrain_F7ListUI.setF7Use(true,ctx);
					prmtstrain.setSelector(prmtstrain_F7ListUI);
				}
			}
		});
					
        // txtearTag		
        this.txtearTag.setVisible(true);		
        this.txtearTag.setHorizontalAlignment(2);		
        this.txtearTag.setMaxLength(100);		
        this.txtearTag.setRequired(false);
        // txtimmuneTag		
        this.txtimmuneTag.setVisible(true);		
        this.txtimmuneTag.setHorizontalAlignment(2);		
        this.txtimmuneTag.setMaxLength(100);		
        this.txtimmuneTag.setRequired(false);
        // txtearGap		
        this.txtearGap.setVisible(true);		
        this.txtearGap.setHorizontalAlignment(2);		
        this.txtearGap.setMaxLength(100);		
        this.txtearGap.setRequired(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.pig.app.PigFarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigFarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.pig.client.PigFarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
					
        // prmtbornFarm		
        this.prmtbornFarm.setQueryInfo("com.kingdee.eas.farm.pig.app.PigFarmQuery");		
        this.prmtbornFarm.setVisible(true);		
        this.prmtbornFarm.setEditable(true);		
        this.prmtbornFarm.setDisplayFormat("$name$");		
        this.prmtbornFarm.setEditFormat("$number$");		
        this.prmtbornFarm.setCommitFormat("$number$");		
        this.prmtbornFarm.setRequired(false);
        		prmtbornFarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigFarmListUI prmtbornFarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbornFarm_F7ListUI == null) {
					try {
						prmtbornFarm_F7ListUI = new com.kingdee.eas.farm.pig.client.PigFarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbornFarm_F7ListUI));
					prmtbornFarm_F7ListUI.setF7Use(true,ctx);
					prmtbornFarm.setSelector(prmtbornFarm_F7ListUI);
				}
			}
		});
					
        // txtbornAddress		
        this.txtbornAddress.setVisible(true);		
        this.txtbornAddress.setHorizontalAlignment(2);		
        this.txtbornAddress.setMaxLength(200);		
        this.txtbornAddress.setRequired(false);
        // prmtbornPigHouse		
        this.prmtbornPigHouse.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseQuery");		
        this.prmtbornPigHouse.setVisible(true);		
        this.prmtbornPigHouse.setEditable(true);		
        this.prmtbornPigHouse.setDisplayFormat("$name$");		
        this.prmtbornPigHouse.setEditFormat("$number$");		
        this.prmtbornPigHouse.setCommitFormat("$number$");		
        this.prmtbornPigHouse.setRequired(false);
        		prmtbornPigHouse.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI prmtbornPigHouse_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbornPigHouse_F7ListUI == null) {
					try {
						prmtbornPigHouse_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbornPigHouse_F7ListUI));
					prmtbornPigHouse_F7ListUI.setF7Use(true,ctx);
					prmtbornPigHouse.setSelector(prmtbornPigHouse_F7ListUI);
				}
			}
		});
					
        // grandLevel		
        this.grandLevel.setVisible(true);		
        this.grandLevel.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.GrandLevel").toArray());		
        this.grandLevel.setRequired(false);
        // pkbornDate		
        this.pkbornDate.setVisible(true);		
        this.pkbornDate.setRequired(false);
        // txtbornWeight		
        this.txtbornWeight.setVisible(true);		
        this.txtbornWeight.setHorizontalAlignment(2);		
        this.txtbornWeight.setDataType(1);		
        this.txtbornWeight.setSupportedEmpty(true);		
        this.txtbornWeight.setMinimumValue( new java.math.BigDecimal("-1.0E20"));		
        this.txtbornWeight.setMaximumValue( new java.math.BigDecimal("1.0E20"));		
        this.txtbornWeight.setPrecision(8);		
        this.txtbornWeight.setRequired(false);
        // txtweaningWeight		
        this.txtweaningWeight.setVisible(true);		
        this.txtweaningWeight.setHorizontalAlignment(2);		
        this.txtweaningWeight.setDataType(1);		
        this.txtweaningWeight.setSupportedEmpty(true);		
        this.txtweaningWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtweaningWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtweaningWeight.setPrecision(10);		
        this.txtweaningWeight.setRequired(false);
        // pkweaningDate		
        this.pkweaningDate.setVisible(true);		
        this.pkweaningDate.setRequired(false);
        // txtweaningDays		
        this.txtweaningDays.setVisible(true);		
        this.txtweaningDays.setHorizontalAlignment(2);		
        this.txtweaningDays.setDataType(0);		
        this.txtweaningDays.setSupportedEmpty(true);		
        this.txtweaningDays.setRequired(false);
        // prmtmonther		
        this.prmtmonther.setQueryInfo("com.kingdee.eas.farm.pig.breedingsow.app.SowQuery");		
        this.prmtmonther.setVisible(true);		
        this.prmtmonther.setEditable(true);		
        this.prmtmonther.setDisplayFormat("$number$");		
        this.prmtmonther.setEditFormat("$number$");		
        this.prmtmonther.setCommitFormat("$number$");		
        this.prmtmonther.setRequired(false);
        		prmtmonther.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.breedingsow.client.SowListUI prmtmonther_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtmonther_F7ListUI == null) {
					try {
						prmtmonther_F7ListUI = new com.kingdee.eas.farm.pig.breedingsow.client.SowListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtmonther_F7ListUI));
					prmtmonther_F7ListUI.setF7Use(true,ctx);
					prmtmonther.setSelector(prmtmonther_F7ListUI);
				}
			}
		});
					
        // txtheredityProblem		
        this.txtheredityProblem.setVisible(true);		
        this.txtheredityProblem.setHorizontalAlignment(2);		
        this.txtheredityProblem.setMaxLength(100);		
        this.txtheredityProblem.setRequired(false);
        // txtleftNippleCount		
        this.txtleftNippleCount.setVisible(true);		
        this.txtleftNippleCount.setHorizontalAlignment(2);		
        this.txtleftNippleCount.setDataType(0);		
        this.txtleftNippleCount.setSupportedEmpty(true);		
        this.txtleftNippleCount.setRequired(false);
        // txtrightNippleCount		
        this.txtrightNippleCount.setVisible(true);		
        this.txtrightNippleCount.setHorizontalAlignment(2);		
        this.txtrightNippleCount.setDataType(0);		
        this.txtrightNippleCount.setSupportedEmpty(true);		
        this.txtrightNippleCount.setRequired(false);
        // txtsowSource		
        this.txtsowSource.setVisible(true);		
        this.txtsowSource.setHorizontalAlignment(2);		
        this.txtsowSource.setMaxLength(100);		
        this.txtsowSource.setRequired(false);
        // txtsourceBillNumber		
        this.txtsourceBillNumber.setVisible(true);		
        this.txtsourceBillNumber.setHorizontalAlignment(2);		
        this.txtsourceBillNumber.setMaxLength(100);		
        this.txtsourceBillNumber.setRequired(false);
        // status		
        this.status.setVisible(true);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.SowStatus").toArray());		
        this.status.setRequired(false);
        // txtearFeature		
        this.txtearFeature.setVisible(true);		
        this.txtearFeature.setHorizontalAlignment(2);		
        this.txtearFeature.setMaxLength(100);		
        this.txtearFeature.setRequired(false);
        // txtskinFeature		
        this.txtskinFeature.setVisible(true);		
        this.txtskinFeature.setHorizontalAlignment(2);		
        this.txtskinFeature.setMaxLength(100);		
        this.txtskinFeature.setRequired(false);
        // txthairFeature		
        this.txthairFeature.setVisible(true);		
        this.txthairFeature.setHorizontalAlignment(2);		
        this.txthairFeature.setMaxLength(100);		
        this.txthairFeature.setRequired(false);
        // txthoofFeature		
        this.txthoofFeature.setVisible(true);		
        this.txthoofFeature.setHorizontalAlignment(2);		
        this.txthoofFeature.setMaxLength(100);		
        this.txthoofFeature.setRequired(false);
        // prmtparent		
        this.prmtparent.setQueryInfo("com.kingdee.eas.farm.pig.breedingboar.app.BoarQuery");		
        this.prmtparent.setVisible(true);		
        this.prmtparent.setEditable(true);		
        this.prmtparent.setDisplayFormat("$number$");		
        this.prmtparent.setEditFormat("$number$");		
        this.prmtparent.setCommitFormat("$number$");		
        this.prmtparent.setRequired(false);
        		prmtparent.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.breedingboar.client.BoarListUI prmtparent_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtparent_F7ListUI == null) {
					try {
						prmtparent_F7ListUI = new com.kingdee.eas.farm.pig.breedingboar.client.BoarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtparent_F7ListUI));
					prmtparent_F7ListUI.setF7Use(true,ctx);
					prmtparent.setSelector(prmtparent_F7ListUI);
				}
			}
		});
					
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtpigType,prmtstrain,txtearTag,txtimmuneTag,txtearGap,prmtfarm,prmtbornFarm,txtbornAddress,prmtbornPigHouse,grandLevel,pkbornDate,txtbornWeight,txtweaningWeight,pkweaningDate,txtweaningDays,txtSimpleName,txtDescription,txtNumber,txtName,prmtmonther,txtheredityProblem,txtleftNippleCount,txtrightNippleCount,txtsowSource,txtsourceBillNumber,status,txthoofFeature,txtearFeature,txtskinFeature,txthairFeature,prmtparent}));
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
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(55, 45, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(381, 45, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(712, -338, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(723, -381, 270, 19));
        this.add(kDLabelContainer4, null);
        contpigType.setBounds(new Rectangle(381, 115, 270, 19));
        this.add(contpigType, null);
        contstrain.setBounds(new Rectangle(55, 115, 270, 19));
        this.add(contstrain, null);
        contearTag.setBounds(new Rectangle(381, 80, 270, 19));
        this.add(contearTag, null);
        contimmuneTag.setBounds(new Rectangle(707, 80, 270, 19));
        this.add(contimmuneTag, null);
        contearGap.setBounds(new Rectangle(55, 80, 270, 19));
        this.add(contearGap, null);
        contfarm.setBounds(new Rectangle(707, 45, 270, 19));
        this.add(contfarm, null);
        contbornFarm.setBounds(new Rectangle(381, 220, 270, 19));
        this.add(contbornFarm, null);
        contbornAddress.setBounds(new Rectangle(707, 185, 270, 19));
        this.add(contbornAddress, null);
        contbornPigHouse.setBounds(new Rectangle(707, 220, 270, 19));
        this.add(contbornPigHouse, null);
        contgrandLevel.setBounds(new Rectangle(707, 115, 270, 19));
        this.add(contgrandLevel, null);
        contbornDate.setBounds(new Rectangle(55, 220, 270, 19));
        this.add(contbornDate, null);
        contbornWeight.setBounds(new Rectangle(55, 255, 270, 19));
        this.add(contbornWeight, null);
        contweaningWeight.setBounds(new Rectangle(707, 325, 270, 19));
        this.add(contweaningWeight, null);
        contweaningDate.setBounds(new Rectangle(55, 325, 270, 19));
        this.add(contweaningDate, null);
        contweaningDays.setBounds(new Rectangle(381, 325, 270, 19));
        this.add(contweaningDays, null);
        contmonther.setBounds(new Rectangle(381, 185, 270, 19));
        this.add(contmonther, null);
        contheredityProblem.setBounds(new Rectangle(381, 255, 270, 19));
        this.add(contheredityProblem, null);
        contleftNippleCount.setBounds(new Rectangle(55, 150, 270, 19));
        this.add(contleftNippleCount, null);
        contrightNippleCount.setBounds(new Rectangle(381, 150, 270, 19));
        this.add(contrightNippleCount, null);
        contsowSource.setBounds(new Rectangle(55, 360, 270, 19));
        this.add(contsowSource, null);
        contsourceBillNumber.setBounds(new Rectangle(381, 360, 270, 19));
        this.add(contsourceBillNumber, null);
        contstatus.setBounds(new Rectangle(55, 399, 270, 19));
        this.add(contstatus, null);
        contearFeature.setBounds(new Rectangle(707, 290, 270, 19));
        this.add(contearFeature, null);
        contskinFeature.setBounds(new Rectangle(381, 290, 270, 19));
        this.add(contskinFeature, null);
        conthairFeature.setBounds(new Rectangle(707, 255, 270, 19));
        this.add(conthairFeature, null);
        conthoofFeature.setBounds(new Rectangle(55, 290, 270, 19));
        this.add(conthoofFeature, null);
        contparent.setBounds(new Rectangle(55, 185, 270, 19));
        this.add(contparent, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contpigType
        contpigType.setBoundEditor(prmtpigType);
        //contstrain
        contstrain.setBoundEditor(prmtstrain);
        //contearTag
        contearTag.setBoundEditor(txtearTag);
        //contimmuneTag
        contimmuneTag.setBoundEditor(txtimmuneTag);
        //contearGap
        contearGap.setBoundEditor(txtearGap);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbornFarm
        contbornFarm.setBoundEditor(prmtbornFarm);
        //contbornAddress
        contbornAddress.setBoundEditor(txtbornAddress);
        //contbornPigHouse
        contbornPigHouse.setBoundEditor(prmtbornPigHouse);
        //contgrandLevel
        contgrandLevel.setBoundEditor(grandLevel);
        //contbornDate
        contbornDate.setBoundEditor(pkbornDate);
        //contbornWeight
        contbornWeight.setBoundEditor(txtbornWeight);
        //contweaningWeight
        contweaningWeight.setBoundEditor(txtweaningWeight);
        //contweaningDate
        contweaningDate.setBoundEditor(pkweaningDate);
        //contweaningDays
        contweaningDays.setBoundEditor(txtweaningDays);
        //contmonther
        contmonther.setBoundEditor(prmtmonther);
        //contheredityProblem
        contheredityProblem.setBoundEditor(txtheredityProblem);
        //contleftNippleCount
        contleftNippleCount.setBoundEditor(txtleftNippleCount);
        //contrightNippleCount
        contrightNippleCount.setBoundEditor(txtrightNippleCount);
        //contsowSource
        contsowSource.setBoundEditor(txtsowSource);
        //contsourceBillNumber
        contsourceBillNumber.setBoundEditor(txtsourceBillNumber);
        //contstatus
        contstatus.setBoundEditor(status);
        //contearFeature
        contearFeature.setBoundEditor(txtearFeature);
        //contskinFeature
        contskinFeature.setBoundEditor(txtskinFeature);
        //conthairFeature
        conthairFeature.setBoundEditor(txthairFeature);
        //conthoofFeature
        conthoofFeature.setBoundEditor(txthoofFeature);
        //contparent
        contparent.setBoundEditor(prmtparent);

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
		dataBinder.registerBinding("pigType", com.kingdee.eas.farm.pig.PigTypeInfo.class, this.prmtpigType, "data");
		dataBinder.registerBinding("strain", com.kingdee.eas.farm.pig.StrainInfo.class, this.prmtstrain, "data");
		dataBinder.registerBinding("earTag", String.class, this.txtearTag, "text");
		dataBinder.registerBinding("immuneTag", String.class, this.txtimmuneTag, "text");
		dataBinder.registerBinding("earGap", String.class, this.txtearGap, "text");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("bornFarm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtbornFarm, "data");
		dataBinder.registerBinding("bornAddress", String.class, this.txtbornAddress, "text");
		dataBinder.registerBinding("bornPigHouse", com.kingdee.eas.farm.pig.PigHouseInfo.class, this.prmtbornPigHouse, "data");
		dataBinder.registerBinding("grandLevel", com.kingdee.eas.farm.pig.GrandLevel.class, this.grandLevel, "selectedItem");
		dataBinder.registerBinding("bornDate", java.util.Date.class, this.pkbornDate, "value");
		dataBinder.registerBinding("bornWeight", java.math.BigDecimal.class, this.txtbornWeight, "value");
		dataBinder.registerBinding("weaningWeight", java.math.BigDecimal.class, this.txtweaningWeight, "value");
		dataBinder.registerBinding("weaningDate", java.util.Date.class, this.pkweaningDate, "value");
		dataBinder.registerBinding("weaningDays", int.class, this.txtweaningDays, "value");
		dataBinder.registerBinding("monther", com.kingdee.eas.farm.pig.breedingsow.SowInfo.class, this.prmtmonther, "data");
		dataBinder.registerBinding("heredityProblem", String.class, this.txtheredityProblem, "text");
		dataBinder.registerBinding("leftNippleCount", int.class, this.txtleftNippleCount, "value");
		dataBinder.registerBinding("rightNippleCount", int.class, this.txtrightNippleCount, "value");
		dataBinder.registerBinding("sowSource", String.class, this.txtsowSource, "text");
		dataBinder.registerBinding("sourceBillNumber", String.class, this.txtsourceBillNumber, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.farm.pig.SowStatus.class, this.status, "selectedItem");
		dataBinder.registerBinding("earFeature", String.class, this.txtearFeature, "text");
		dataBinder.registerBinding("skinFeature", String.class, this.txtskinFeature, "text");
		dataBinder.registerBinding("hairFeature", String.class, this.txthairFeature, "text");
		dataBinder.registerBinding("hoofFeature", String.class, this.txthoofFeature, "text");
		dataBinder.registerBinding("parent", com.kingdee.eas.farm.pig.breedingboar.BoarInfo.class, this.prmtparent, "data");		
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
	    return "com.kingdee.eas.farm.pig.breedingsow.app.SowEditUIHandler";
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
        this.prmtpigType.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.breedingsow.SowInfo)ov;
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
		getValidateHelper().registerBindProperty("pigType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("strain", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earTag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneTag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earGap", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornPigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grandLevel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weaningWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weaningDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weaningDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monther", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("heredityProblem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("leftNippleCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rightNippleCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sowSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sourceBillNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("skinFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hairFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hoofFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parent", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("pigType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigType.id"));
        	sic.add(new SelectorItemInfo("pigType.number"));
        	sic.add(new SelectorItemInfo("pigType.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("strain.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("strain.id"));
        	sic.add(new SelectorItemInfo("strain.number"));
        	sic.add(new SelectorItemInfo("strain.name"));
		}
        sic.add(new SelectorItemInfo("earTag"));
        sic.add(new SelectorItemInfo("immuneTag"));
        sic.add(new SelectorItemInfo("earGap"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bornFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bornFarm.id"));
        	sic.add(new SelectorItemInfo("bornFarm.number"));
        	sic.add(new SelectorItemInfo("bornFarm.name"));
		}
        sic.add(new SelectorItemInfo("bornAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bornPigHouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bornPigHouse.id"));
        	sic.add(new SelectorItemInfo("bornPigHouse.number"));
        	sic.add(new SelectorItemInfo("bornPigHouse.name"));
		}
        sic.add(new SelectorItemInfo("grandLevel"));
        sic.add(new SelectorItemInfo("bornDate"));
        sic.add(new SelectorItemInfo("bornWeight"));
        sic.add(new SelectorItemInfo("weaningWeight"));
        sic.add(new SelectorItemInfo("weaningDate"));
        sic.add(new SelectorItemInfo("weaningDays"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("monther.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("monther.id"));
        	sic.add(new SelectorItemInfo("monther.number"));
        	sic.add(new SelectorItemInfo("monther.name"));
		}
        sic.add(new SelectorItemInfo("heredityProblem"));
        sic.add(new SelectorItemInfo("leftNippleCount"));
        sic.add(new SelectorItemInfo("rightNippleCount"));
        sic.add(new SelectorItemInfo("sowSource"));
        sic.add(new SelectorItemInfo("sourceBillNumber"));
        sic.add(new SelectorItemInfo("status"));
        sic.add(new SelectorItemInfo("earFeature"));
        sic.add(new SelectorItemInfo("skinFeature"));
        sic.add(new SelectorItemInfo("hairFeature"));
        sic.add(new SelectorItemInfo("hoofFeature"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parent.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parent.id"));
        	sic.add(new SelectorItemInfo("parent.number"));
        	sic.add(new SelectorItemInfo("parent.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.breedingsow.client", "SowEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.pig.breedingsow.client.SowEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.breedingsow.SowFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.breedingsow.SowInfo objectValue = new com.kingdee.eas.farm.pig.breedingsow.SowInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("grandLevel","1");
vo.put("status","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}