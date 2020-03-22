/**
 * output package name
 */
package com.kingdee.eas.farm.pig.breedingboar.client;

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
public abstract class AbstractBoarEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBoarEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearGap;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearTag;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneTag;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstrain;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrandLevel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contleftNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrightNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparent;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmother;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornPigHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbornWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheredityProblem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthairFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthoofFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contskinFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearFeature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweaningDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweaningDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweaningWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contboraSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsourceBillNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtearGap;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtearTag;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtimmuneTag;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstrain;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox grandLevel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtleftNippleCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrightNippleCount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparent;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmother;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbornAddress;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbornDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbornFarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbornPigHouse;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbornWeight;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheredityProblem;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthairFeature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthoofFeature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtskinFeature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtearFeature;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkweaningDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweaningDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweaningWeight;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtboraSource;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsourceBillNumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.eas.farm.pig.breedingboar.BoarInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBoarEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBoarEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearGap = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearTag = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneTag = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstrain = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrandLevel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contleftNippleCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrightNippleCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contparent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmother = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornPigHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbornWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheredityProblem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthairFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthoofFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contskinFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearFeature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweaningDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweaningDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweaningWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contboraSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsourceBillNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtearGap = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtearTag = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtimmuneTag = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtstrain = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpigType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.grandLevel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtleftNippleCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrightNippleCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtparent = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtmother = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbornAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkbornDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtbornFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbornPigHouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbornWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtheredityProblem = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthairFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthoofFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtskinFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtearFeature = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkweaningDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtweaningDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweaningWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtboraSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsourceBillNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contfarm.setName("contfarm");
        this.contearGap.setName("contearGap");
        this.contearTag.setName("contearTag");
        this.contimmuneTag.setName("contimmuneTag");
        this.contstrain.setName("contstrain");
        this.contpigType.setName("contpigType");
        this.contgrandLevel.setName("contgrandLevel");
        this.contleftNippleCount.setName("contleftNippleCount");
        this.contrightNippleCount.setName("contrightNippleCount");
        this.contparent.setName("contparent");
        this.contmother.setName("contmother");
        this.contbornAddress.setName("contbornAddress");
        this.contbornDate.setName("contbornDate");
        this.contbornFarm.setName("contbornFarm");
        this.contbornPigHouse.setName("contbornPigHouse");
        this.contbornWeight.setName("contbornWeight");
        this.contheredityProblem.setName("contheredityProblem");
        this.conthairFeature.setName("conthairFeature");
        this.conthoofFeature.setName("conthoofFeature");
        this.contskinFeature.setName("contskinFeature");
        this.contearFeature.setName("contearFeature");
        this.contweaningDate.setName("contweaningDate");
        this.contweaningDays.setName("contweaningDays");
        this.contweaningWeight.setName("contweaningWeight");
        this.contboraSource.setName("contboraSource");
        this.contsourceBillNumber.setName("contsourceBillNumber");
        this.contstatus.setName("contstatus");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtfarm.setName("prmtfarm");
        this.txtearGap.setName("txtearGap");
        this.txtearTag.setName("txtearTag");
        this.txtimmuneTag.setName("txtimmuneTag");
        this.prmtstrain.setName("prmtstrain");
        this.prmtpigType.setName("prmtpigType");
        this.grandLevel.setName("grandLevel");
        this.txtleftNippleCount.setName("txtleftNippleCount");
        this.txtrightNippleCount.setName("txtrightNippleCount");
        this.prmtparent.setName("prmtparent");
        this.prmtmother.setName("prmtmother");
        this.txtbornAddress.setName("txtbornAddress");
        this.pkbornDate.setName("pkbornDate");
        this.prmtbornFarm.setName("prmtbornFarm");
        this.prmtbornPigHouse.setName("prmtbornPigHouse");
        this.txtbornWeight.setName("txtbornWeight");
        this.txtheredityProblem.setName("txtheredityProblem");
        this.txthairFeature.setName("txthairFeature");
        this.txthoofFeature.setName("txthoofFeature");
        this.txtskinFeature.setName("txtskinFeature");
        this.txtearFeature.setName("txtearFeature");
        this.pkweaningDate.setName("pkweaningDate");
        this.txtweaningDays.setName("txtweaningDays");
        this.txtweaningWeight.setName("txtweaningWeight");
        this.txtboraSource.setName("txtboraSource");
        this.txtsourceBillNumber.setName("txtsourceBillNumber");
        this.status.setName("status");
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
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contearGap		
        this.contearGap.setBoundLabelText(resHelper.getString("contearGap.boundLabelText"));		
        this.contearGap.setBoundLabelLength(100);		
        this.contearGap.setBoundLabelUnderline(true);		
        this.contearGap.setVisible(true);
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
        // contstrain		
        this.contstrain.setBoundLabelText(resHelper.getString("contstrain.boundLabelText"));		
        this.contstrain.setBoundLabelLength(100);		
        this.contstrain.setBoundLabelUnderline(true);		
        this.contstrain.setVisible(true);
        // contpigType		
        this.contpigType.setBoundLabelText(resHelper.getString("contpigType.boundLabelText"));		
        this.contpigType.setBoundLabelLength(100);		
        this.contpigType.setBoundLabelUnderline(true);		
        this.contpigType.setVisible(true);
        // contgrandLevel		
        this.contgrandLevel.setBoundLabelText(resHelper.getString("contgrandLevel.boundLabelText"));		
        this.contgrandLevel.setBoundLabelLength(100);		
        this.contgrandLevel.setBoundLabelUnderline(true);		
        this.contgrandLevel.setVisible(true);
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
        // contparent		
        this.contparent.setBoundLabelText(resHelper.getString("contparent.boundLabelText"));		
        this.contparent.setBoundLabelLength(100);		
        this.contparent.setBoundLabelUnderline(true);		
        this.contparent.setVisible(true);
        // contmother		
        this.contmother.setBoundLabelText(resHelper.getString("contmother.boundLabelText"));		
        this.contmother.setBoundLabelLength(100);		
        this.contmother.setBoundLabelUnderline(true);		
        this.contmother.setVisible(true);
        // contbornAddress		
        this.contbornAddress.setBoundLabelText(resHelper.getString("contbornAddress.boundLabelText"));		
        this.contbornAddress.setBoundLabelLength(100);		
        this.contbornAddress.setBoundLabelUnderline(true);		
        this.contbornAddress.setVisible(true);
        // contbornDate		
        this.contbornDate.setBoundLabelText(resHelper.getString("contbornDate.boundLabelText"));		
        this.contbornDate.setBoundLabelLength(100);		
        this.contbornDate.setBoundLabelUnderline(true);		
        this.contbornDate.setVisible(true);
        // contbornFarm		
        this.contbornFarm.setBoundLabelText(resHelper.getString("contbornFarm.boundLabelText"));		
        this.contbornFarm.setBoundLabelLength(100);		
        this.contbornFarm.setBoundLabelUnderline(true);		
        this.contbornFarm.setVisible(true);
        // contbornPigHouse		
        this.contbornPigHouse.setBoundLabelText(resHelper.getString("contbornPigHouse.boundLabelText"));		
        this.contbornPigHouse.setBoundLabelLength(100);		
        this.contbornPigHouse.setBoundLabelUnderline(true);		
        this.contbornPigHouse.setVisible(true);
        // contbornWeight		
        this.contbornWeight.setBoundLabelText(resHelper.getString("contbornWeight.boundLabelText"));		
        this.contbornWeight.setBoundLabelLength(100);		
        this.contbornWeight.setBoundLabelUnderline(true);		
        this.contbornWeight.setVisible(true);
        // contheredityProblem		
        this.contheredityProblem.setBoundLabelText(resHelper.getString("contheredityProblem.boundLabelText"));		
        this.contheredityProblem.setBoundLabelLength(100);		
        this.contheredityProblem.setBoundLabelUnderline(true);		
        this.contheredityProblem.setVisible(true);
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
        // contskinFeature		
        this.contskinFeature.setBoundLabelText(resHelper.getString("contskinFeature.boundLabelText"));		
        this.contskinFeature.setBoundLabelLength(100);		
        this.contskinFeature.setBoundLabelUnderline(true);		
        this.contskinFeature.setVisible(true);
        // contearFeature		
        this.contearFeature.setBoundLabelText(resHelper.getString("contearFeature.boundLabelText"));		
        this.contearFeature.setBoundLabelLength(100);		
        this.contearFeature.setBoundLabelUnderline(true);		
        this.contearFeature.setVisible(true);
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
        // contweaningWeight		
        this.contweaningWeight.setBoundLabelText(resHelper.getString("contweaningWeight.boundLabelText"));		
        this.contweaningWeight.setBoundLabelLength(100);		
        this.contweaningWeight.setBoundLabelUnderline(true);		
        this.contweaningWeight.setVisible(true);
        // contboraSource		
        this.contboraSource.setBoundLabelText(resHelper.getString("contboraSource.boundLabelText"));		
        this.contboraSource.setBoundLabelLength(100);		
        this.contboraSource.setBoundLabelUnderline(true);		
        this.contboraSource.setVisible(true);
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
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
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
					
        // txtearGap		
        this.txtearGap.setVisible(true);		
        this.txtearGap.setHorizontalAlignment(2);		
        this.txtearGap.setMaxLength(100);		
        this.txtearGap.setRequired(false);
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
					
        // grandLevel		
        this.grandLevel.setVisible(true);		
        this.grandLevel.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.GrandLevel").toArray());		
        this.grandLevel.setRequired(false);
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
					
        // prmtmother		
        this.prmtmother.setQueryInfo("com.kingdee.eas.farm.pig.breedingsow.app.SowQuery");		
        this.prmtmother.setVisible(true);		
        this.prmtmother.setEditable(true);		
        this.prmtmother.setDisplayFormat("$number$");		
        this.prmtmother.setEditFormat("$number$");		
        this.prmtmother.setCommitFormat("$number$");		
        this.prmtmother.setRequired(false);
        		prmtmother.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.breedingsow.client.SowListUI prmtmother_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtmother_F7ListUI == null) {
					try {
						prmtmother_F7ListUI = new com.kingdee.eas.farm.pig.breedingsow.client.SowListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtmother_F7ListUI));
					prmtmother_F7ListUI.setF7Use(true,ctx);
					prmtmother.setSelector(prmtmother_F7ListUI);
				}
			}
		});
					
        // txtbornAddress		
        this.txtbornAddress.setVisible(true);		
        this.txtbornAddress.setHorizontalAlignment(2);		
        this.txtbornAddress.setMaxLength(100);		
        this.txtbornAddress.setRequired(false);
        // pkbornDate		
        this.pkbornDate.setVisible(true);		
        this.pkbornDate.setRequired(false);
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
					
        // txtbornWeight		
        this.txtbornWeight.setVisible(true);		
        this.txtbornWeight.setHorizontalAlignment(2);		
        this.txtbornWeight.setDataType(1);		
        this.txtbornWeight.setSupportedEmpty(true);		
        this.txtbornWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbornWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbornWeight.setPrecision(10);		
        this.txtbornWeight.setRequired(false);
        // txtheredityProblem		
        this.txtheredityProblem.setVisible(true);		
        this.txtheredityProblem.setHorizontalAlignment(2);		
        this.txtheredityProblem.setMaxLength(100);		
        this.txtheredityProblem.setRequired(false);
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
        // txtskinFeature		
        this.txtskinFeature.setVisible(true);		
        this.txtskinFeature.setHorizontalAlignment(2);		
        this.txtskinFeature.setMaxLength(100);		
        this.txtskinFeature.setRequired(false);
        // txtearFeature		
        this.txtearFeature.setVisible(true);		
        this.txtearFeature.setHorizontalAlignment(2);		
        this.txtearFeature.setMaxLength(100);		
        this.txtearFeature.setRequired(false);
        // pkweaningDate		
        this.pkweaningDate.setVisible(true);		
        this.pkweaningDate.setRequired(false);
        // txtweaningDays		
        this.txtweaningDays.setVisible(true);		
        this.txtweaningDays.setHorizontalAlignment(2);		
        this.txtweaningDays.setDataType(0);		
        this.txtweaningDays.setSupportedEmpty(true);		
        this.txtweaningDays.setRequired(false);
        // txtweaningWeight		
        this.txtweaningWeight.setVisible(true);		
        this.txtweaningWeight.setHorizontalAlignment(2);		
        this.txtweaningWeight.setDataType(1);		
        this.txtweaningWeight.setSupportedEmpty(true);		
        this.txtweaningWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtweaningWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtweaningWeight.setPrecision(10);		
        this.txtweaningWeight.setRequired(false);
        // txtboraSource		
        this.txtboraSource.setVisible(true);		
        this.txtboraSource.setHorizontalAlignment(2);		
        this.txtboraSource.setMaxLength(100);		
        this.txtboraSource.setRequired(false);
        // txtsourceBillNumber		
        this.txtsourceBillNumber.setVisible(true);		
        this.txtsourceBillNumber.setHorizontalAlignment(2);		
        this.txtsourceBillNumber.setMaxLength(100);		
        this.txtsourceBillNumber.setRequired(false);
        // status		
        this.status.setVisible(true);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.BoarStatus").toArray());		
        this.status.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtfarm,txtearGap,txtearTag,txtimmuneTag,prmtstrain,prmtpigType,grandLevel,txtleftNippleCount,txtrightNippleCount,prmtparent,prmtmother,txtbornAddress,pkbornDate,prmtbornFarm,prmtbornPigHouse,txtbornWeight,txtheredityProblem,txthairFeature,txthoofFeature,txtskinFeature,txtearFeature,pkweaningDate,txtweaningDays,txtweaningWeight,txtboraSource,txtsourceBillNumber,status}));
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
        kDLabelContainer1.setBounds(new Rectangle(45, 47, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(367, 47, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(102, -118, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(102, -118, 270, 19));
        this.add(kDLabelContainer4, null);
        contfarm.setBounds(new Rectangle(687, 47, 270, 19));
        this.add(contfarm, null);
        contearGap.setBounds(new Rectangle(45, 80, 270, 19));
        this.add(contearGap, null);
        contearTag.setBounds(new Rectangle(367, 80, 270, 19));
        this.add(contearTag, null);
        contimmuneTag.setBounds(new Rectangle(687, 80, 270, 19));
        this.add(contimmuneTag, null);
        contstrain.setBounds(new Rectangle(45, 113, 270, 19));
        this.add(contstrain, null);
        contpigType.setBounds(new Rectangle(367, 113, 270, 19));
        this.add(contpigType, null);
        contgrandLevel.setBounds(new Rectangle(687, 113, 270, 19));
        this.add(contgrandLevel, null);
        contleftNippleCount.setBounds(new Rectangle(45, 146, 270, 19));
        this.add(contleftNippleCount, null);
        contrightNippleCount.setBounds(new Rectangle(367, 146, 270, 19));
        this.add(contrightNippleCount, null);
        contparent.setBounds(new Rectangle(45, 179, 270, 19));
        this.add(contparent, null);
        contmother.setBounds(new Rectangle(367, 179, 270, 19));
        this.add(contmother, null);
        contbornAddress.setBounds(new Rectangle(687, 179, 270, 19));
        this.add(contbornAddress, null);
        contbornDate.setBounds(new Rectangle(45, 212, 270, 19));
        this.add(contbornDate, null);
        contbornFarm.setBounds(new Rectangle(367, 212, 270, 19));
        this.add(contbornFarm, null);
        contbornPigHouse.setBounds(new Rectangle(687, 212, 270, 19));
        this.add(contbornPigHouse, null);
        contbornWeight.setBounds(new Rectangle(45, 245, 270, 19));
        this.add(contbornWeight, null);
        contheredityProblem.setBounds(new Rectangle(367, 245, 270, 19));
        this.add(contheredityProblem, null);
        conthairFeature.setBounds(new Rectangle(687, 245, 270, 19));
        this.add(conthairFeature, null);
        conthoofFeature.setBounds(new Rectangle(45, 278, 270, 19));
        this.add(conthoofFeature, null);
        contskinFeature.setBounds(new Rectangle(367, 278, 270, 19));
        this.add(contskinFeature, null);
        contearFeature.setBounds(new Rectangle(687, 278, 270, 19));
        this.add(contearFeature, null);
        contweaningDate.setBounds(new Rectangle(45, 311, 270, 19));
        this.add(contweaningDate, null);
        contweaningDays.setBounds(new Rectangle(367, 311, 270, 19));
        this.add(contweaningDays, null);
        contweaningWeight.setBounds(new Rectangle(687, 311, 270, 19));
        this.add(contweaningWeight, null);
        contboraSource.setBounds(new Rectangle(45, 346, 270, 19));
        this.add(contboraSource, null);
        contsourceBillNumber.setBounds(new Rectangle(367, 346, 270, 19));
        this.add(contsourceBillNumber, null);
        contstatus.setBounds(new Rectangle(45, 380, 270, 19));
        this.add(contstatus, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contearGap
        contearGap.setBoundEditor(txtearGap);
        //contearTag
        contearTag.setBoundEditor(txtearTag);
        //contimmuneTag
        contimmuneTag.setBoundEditor(txtimmuneTag);
        //contstrain
        contstrain.setBoundEditor(prmtstrain);
        //contpigType
        contpigType.setBoundEditor(prmtpigType);
        //contgrandLevel
        contgrandLevel.setBoundEditor(grandLevel);
        //contleftNippleCount
        contleftNippleCount.setBoundEditor(txtleftNippleCount);
        //contrightNippleCount
        contrightNippleCount.setBoundEditor(txtrightNippleCount);
        //contparent
        contparent.setBoundEditor(prmtparent);
        //contmother
        contmother.setBoundEditor(prmtmother);
        //contbornAddress
        contbornAddress.setBoundEditor(txtbornAddress);
        //contbornDate
        contbornDate.setBoundEditor(pkbornDate);
        //contbornFarm
        contbornFarm.setBoundEditor(prmtbornFarm);
        //contbornPigHouse
        contbornPigHouse.setBoundEditor(prmtbornPigHouse);
        //contbornWeight
        contbornWeight.setBoundEditor(txtbornWeight);
        //contheredityProblem
        contheredityProblem.setBoundEditor(txtheredityProblem);
        //conthairFeature
        conthairFeature.setBoundEditor(txthairFeature);
        //conthoofFeature
        conthoofFeature.setBoundEditor(txthoofFeature);
        //contskinFeature
        contskinFeature.setBoundEditor(txtskinFeature);
        //contearFeature
        contearFeature.setBoundEditor(txtearFeature);
        //contweaningDate
        contweaningDate.setBoundEditor(pkweaningDate);
        //contweaningDays
        contweaningDays.setBoundEditor(txtweaningDays);
        //contweaningWeight
        contweaningWeight.setBoundEditor(txtweaningWeight);
        //contboraSource
        contboraSource.setBoundEditor(txtboraSource);
        //contsourceBillNumber
        contsourceBillNumber.setBoundEditor(txtsourceBillNumber);
        //contstatus
        contstatus.setBoundEditor(status);

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
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("earGap", String.class, this.txtearGap, "text");
		dataBinder.registerBinding("earTag", String.class, this.txtearTag, "text");
		dataBinder.registerBinding("immuneTag", String.class, this.txtimmuneTag, "text");
		dataBinder.registerBinding("strain", com.kingdee.eas.farm.pig.StrainInfo.class, this.prmtstrain, "data");
		dataBinder.registerBinding("pigType", com.kingdee.eas.farm.pig.PigTypeInfo.class, this.prmtpigType, "data");
		dataBinder.registerBinding("grandLevel", com.kingdee.eas.farm.pig.GrandLevel.class, this.grandLevel, "selectedItem");
		dataBinder.registerBinding("leftNippleCount", int.class, this.txtleftNippleCount, "value");
		dataBinder.registerBinding("rightNippleCount", int.class, this.txtrightNippleCount, "value");
		dataBinder.registerBinding("parent", com.kingdee.eas.farm.pig.breedingboar.BoarInfo.class, this.prmtparent, "data");
		dataBinder.registerBinding("mother", com.kingdee.eas.farm.pig.breedingsow.SowInfo.class, this.prmtmother, "data");
		dataBinder.registerBinding("bornAddress", String.class, this.txtbornAddress, "text");
		dataBinder.registerBinding("bornDate", java.util.Date.class, this.pkbornDate, "value");
		dataBinder.registerBinding("bornFarm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtbornFarm, "data");
		dataBinder.registerBinding("bornPigHouse", com.kingdee.eas.farm.pig.PigHouseInfo.class, this.prmtbornPigHouse, "data");
		dataBinder.registerBinding("bornWeight", java.math.BigDecimal.class, this.txtbornWeight, "value");
		dataBinder.registerBinding("heredityProblem", String.class, this.txtheredityProblem, "text");
		dataBinder.registerBinding("hairFeature", String.class, this.txthairFeature, "text");
		dataBinder.registerBinding("hoofFeature", String.class, this.txthoofFeature, "text");
		dataBinder.registerBinding("skinFeature", String.class, this.txtskinFeature, "text");
		dataBinder.registerBinding("earFeature", String.class, this.txtearFeature, "text");
		dataBinder.registerBinding("weaningDate", java.util.Date.class, this.pkweaningDate, "value");
		dataBinder.registerBinding("weaningDays", int.class, this.txtweaningDays, "value");
		dataBinder.registerBinding("weaningWeight", java.math.BigDecimal.class, this.txtweaningWeight, "value");
		dataBinder.registerBinding("boraSource", String.class, this.txtboraSource, "text");
		dataBinder.registerBinding("sourceBillNumber", String.class, this.txtsourceBillNumber, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.farm.pig.BoarStatus.class, this.status, "selectedItem");		
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
	    return "com.kingdee.eas.farm.pig.breedingboar.app.BoarEditUIHandler";
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
        this.prmtfarm.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.breedingboar.BoarInfo)ov;
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
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earGap", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earTag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneTag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("strain", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grandLevel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("leftNippleCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rightNippleCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mother", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornPigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bornWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("heredityProblem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hairFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hoofFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("skinFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earFeature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weaningDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weaningDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weaningWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("boraSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sourceBillNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("earGap"));
        sic.add(new SelectorItemInfo("earTag"));
        sic.add(new SelectorItemInfo("immuneTag"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("strain.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("strain.id"));
        	sic.add(new SelectorItemInfo("strain.number"));
        	sic.add(new SelectorItemInfo("strain.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigType.id"));
        	sic.add(new SelectorItemInfo("pigType.number"));
        	sic.add(new SelectorItemInfo("pigType.name"));
		}
        sic.add(new SelectorItemInfo("grandLevel"));
        sic.add(new SelectorItemInfo("leftNippleCount"));
        sic.add(new SelectorItemInfo("rightNippleCount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parent.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parent.id"));
        	sic.add(new SelectorItemInfo("parent.number"));
        	sic.add(new SelectorItemInfo("parent.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("mother.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("mother.id"));
        	sic.add(new SelectorItemInfo("mother.number"));
        	sic.add(new SelectorItemInfo("mother.name"));
		}
        sic.add(new SelectorItemInfo("bornAddress"));
        sic.add(new SelectorItemInfo("bornDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bornFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bornFarm.id"));
        	sic.add(new SelectorItemInfo("bornFarm.number"));
        	sic.add(new SelectorItemInfo("bornFarm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bornPigHouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bornPigHouse.id"));
        	sic.add(new SelectorItemInfo("bornPigHouse.number"));
        	sic.add(new SelectorItemInfo("bornPigHouse.name"));
		}
        sic.add(new SelectorItemInfo("bornWeight"));
        sic.add(new SelectorItemInfo("heredityProblem"));
        sic.add(new SelectorItemInfo("hairFeature"));
        sic.add(new SelectorItemInfo("hoofFeature"));
        sic.add(new SelectorItemInfo("skinFeature"));
        sic.add(new SelectorItemInfo("earFeature"));
        sic.add(new SelectorItemInfo("weaningDate"));
        sic.add(new SelectorItemInfo("weaningDays"));
        sic.add(new SelectorItemInfo("weaningWeight"));
        sic.add(new SelectorItemInfo("boraSource"));
        sic.add(new SelectorItemInfo("sourceBillNumber"));
        sic.add(new SelectorItemInfo("status"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.breedingboar.client", "BoarEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.pig.breedingboar.client.BoarEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.breedingboar.BoarFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.breedingboar.BoarInfo objectValue = new com.kingdee.eas.farm.pig.breedingboar.BoarInfo();
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