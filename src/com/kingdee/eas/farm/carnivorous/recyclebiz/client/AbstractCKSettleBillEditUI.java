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
public abstract class AbstractCKSettleBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCKSettleBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabel kblBatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel13;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel17;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkFivouchered;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleDyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmeatRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbEBankAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeedPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeededNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpunishWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginAmt;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasPaymentBill;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisKouBZJ;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadPayAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmlyAllAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenAveWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbEBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcFBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcFEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleDrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleFeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoValue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeedContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkbItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQCItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contviewItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttempItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayOweMoneryB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmsType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSaleKbAmt2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel14;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel16;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenRetunAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeforeBatchAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidCodeCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoneMrgin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmeronlyPro;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerOnlyProOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproDiv;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleDyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmeatRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchAmt;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbEBankAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtconFeedPolicy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtconFeededNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpunishWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtadPayAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmlyAllAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenAveWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbEBank;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcFBeginDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcFEndDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleDrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleFeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoValue;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtconFeedContract;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkbItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQCItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtviewItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttempItemAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpayOweMoneryB;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecSuttle;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDComboBox farmsType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSaleKbAmt2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPreHouseEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPreHouseEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSeedSourceEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSeedSourceEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenRetunAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbeforeBatchAmount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidCodeCode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtchickenSource;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoneMrgin;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfarmeronlyPro;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfarmerOnlyProOne;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtproDiv;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccupyMargin;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOrdinary;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmRatePAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualMRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardMRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugLackPAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleActualDrug;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleStandardDrug;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginOccupyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchOccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeedSubsidies;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkbConFeedPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractCKWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreightDiffSubsidies;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlFeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreightPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreightSubsidiesStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeductMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeductAdPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contloanRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkYFKOccupyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfmRatePunishStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdyfBalance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmoneyOccupyDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeedPolicySub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayOweMonery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSaleKbAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunLockedMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadPayBalance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQCKbDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherKbDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneCostOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcleanHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcleanHouseOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualFoder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandFodder;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chknoCalFodderPunish;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chknoCalDrupPunish;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmRatePAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualMRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardMRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugLackPAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleActualDrug;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleStandardDrug;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginOccupyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchOccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtconFeedSubsidies;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtkbConFeedPolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractCKWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreightDiffSubsidies;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlFeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreightPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreightSubsidiesStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeductMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeductAdPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtloanRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkYFKOccupyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfmRatePunishStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdyfBalance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmoneyOccupyDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtconFeedPolicySub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpayOweMonery;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSaleKbAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunLockedMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtadPayBalance;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneQCKbDetail;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtQCKbDetail;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneotherKbDetail;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtotherKbDetail;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimmuneCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimmuneCostOne;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcleanHouse;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcleanHouseOne;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualFoder;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandFodder;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtQCEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtQCEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtViewReqEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtViewReqEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOtherEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOtherEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTempPolicyEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTempPolicyEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSeedCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallocateAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdaiyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherMatCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSeedCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfodderCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallocateAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdaiyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherMatCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreserveRiskCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbrokenCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlongBorrowReturn;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttranCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contspecialPermitAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contspecialBorrowinst;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlongBorrowAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contequipmentReAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contborrowAmiunt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginGAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoalCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgetChickCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcleanHouseCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcleanTowerCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnowAccountBac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassetsOccupy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnoPfoRetAmt;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkactualVoucher;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkpreVoucher;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chktransVoucher;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasPay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyTC;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiverCt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreserveRiskCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbrokenCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlongBorrowReturn;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttranCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtspecialPermitAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtspecialBorrowinst;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlongBorrowAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtequipmentReAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtborrowAmiunt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginGAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoalCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgetChickCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcleanHouseCost;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcleanTowerCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnowAccountBac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtassetsOccupy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnoPfoRetAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyTC;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiverCt;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel8;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel9;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel10;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel11;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel12;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSeedEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSeedEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFodderEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFodderEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDrugEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDrugEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSlaughterEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSlaughterEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSaleEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSaleEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnExecSettle;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdateSaleData;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnupdateActAmt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton hasPay;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnClose;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionClose actionClose = null;
    protected ActionUnClose actionUnClose = null;
    protected ActionExecSettle actionExecSettle = null;
    protected ActionUpdateSaleData actionUpdateSaleData = null;
    protected ActionUpdateActAmt actionUpdateActAmt = null;
    protected ActionHasPay actionHasPay = null;
    /**
     * output class constructor
     */
    public AbstractCKSettleBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCKSettleBillEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
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
        //actionExecSettle
        this.actionExecSettle = new ActionExecSettle(this);
        getActionManager().registerAction("actionExecSettle", actionExecSettle);
        this.actionExecSettle.setBindWorkFlow(true);
        this.actionExecSettle.setExtendProperty("canForewarn", "true");
        this.actionExecSettle.setExtendProperty("userDefined", "true");
        this.actionExecSettle.setExtendProperty("isObjectUpdateLock", "false");
         this.actionExecSettle.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionExecSettle.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionExecSettle.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUpdateSaleData
        this.actionUpdateSaleData = new ActionUpdateSaleData(this);
        getActionManager().registerAction("actionUpdateSaleData", actionUpdateSaleData);
        this.actionUpdateSaleData.setBindWorkFlow(true);
        this.actionUpdateSaleData.setExtendProperty("canForewarn", "true");
        this.actionUpdateSaleData.setExtendProperty("userDefined", "true");
        this.actionUpdateSaleData.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateSaleData.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateSaleData.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUpdateSaleData.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUpdateActAmt
        this.actionUpdateActAmt = new ActionUpdateActAmt(this);
        getActionManager().registerAction("actionUpdateActAmt", actionUpdateActAmt);
        this.actionUpdateActAmt.setExtendProperty("canForewarn", "true");
        this.actionUpdateActAmt.setExtendProperty("userDefined", "true");
        this.actionUpdateActAmt.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateActAmt.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateActAmt.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionHasPay
        this.actionHasPay = new ActionHasPay(this);
        getActionManager().registerAction("actionHasPay", actionHasPay);
        this.actionHasPay.setExtendProperty("canForewarn", "true");
        this.actionHasPay.setExtendProperty("userDefined", "true");
        this.actionHasPay.setExtendProperty("isObjectUpdateLock", "false");
         this.actionHasPay.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionHasPay.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDTabbedPane3 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kblBatchContract = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel13 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel17 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.chkFivouchered = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contsingleDyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpunishAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmeatRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbEBankAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeedPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeededNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpunishWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsurvivalRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasPaymentBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisKouBZJ = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contadPayAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmlyAllAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenAveWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbEBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcFBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcFEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleDrugAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleFeedWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoValue = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeedContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkbItemAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQCItemAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contviewItemAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherItemAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttempItemAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayOweMoneryB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmsType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSaleKbAmt2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel14 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel16 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contchickenRetunAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeforeBatchAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contidCodeCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoneMrgin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmeronlyPro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerOnlyProOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproDiv = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccupyMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtsingleDyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpunishAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmeatRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbatchAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbEBankAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtconFeedPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtconFeededNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfeedWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkrecDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtpunishWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsurvivalRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarginAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtadPayAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmlyAllAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenAveWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtbEBank = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcFBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcFEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbankNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleDrugAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleFeedWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoValue = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtconFeedContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtkbItemAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtQCItemAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtviewItemAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherItemAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttempItemAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpayOweMoneryB = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.farmsType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtoutSaleKbAmt2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtPreHouseEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSeedSourceEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtchickenRetunAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbeforeBatchAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtidCodeCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtchickenSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtoneMrgin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdrugQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmeronlyPro = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmerOnlyProOne = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtproDiv = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccupyMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.chkisOrdinary = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel15 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contmRatePAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualMRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardMRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugLackPAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleActualDrug = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleStandardDrug = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginOccupyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchOccupyMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeedSubsidies = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkbConFeedPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractCKWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreightDiffSubsidies = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlFeedWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreightPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreightSubsidiesStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeductMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenableMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeductAdPayAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contloanRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkYFKOccupyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfmRatePunishStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdyfBalance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmoneyOccupyDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeedPolicySub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayOweMonery = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSaleKbAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunLockedMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadPayBalance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQCKbDetail = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherKbDetail = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneCostOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcleanHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcleanHouseOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualFoder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandFodder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chknoCalFodderPunish = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chknoCalDrupPunish = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtmRatePAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualMRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardMRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugLackPAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleActualDrug = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleStandardDrug = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarginOccupyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbatchOccupyMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtconFeedSubsidies = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtkbConFeedPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcontractCKWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreightDiffSubsidies = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlFeedWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreightPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreightSubsidiesStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeductMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtenableMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeductAdPayAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtloanRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkYFKOccupyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfmRatePunishStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdyfBalance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmoneyOccupyDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtconFeedPolicySub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpayOweMonery = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutSaleKbAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunLockedMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtadPayBalance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.scrollPaneQCKbDetail = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtQCKbDetail = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.scrollPaneotherKbDetail = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtotherKbDetail = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtimmuneCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimmuneCostOne = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcleanHouse = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcleanHouseOne = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualFoder = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandFodder = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtQCEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtViewReqEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOtherEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtTempPolicyEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contSeedCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallocateAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdaiyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherMatCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtSeedCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfodderCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallocateAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdaiyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherMatCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contreserveRiskCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbrokenCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlongBorrowReturn = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttranCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualPayAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contspecialPermitAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contspecialBorrowinst = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlongBorrowAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contequipmentReAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contborrowAmiunt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginGAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoalCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgetChickCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcleanHouseCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcleanTowerCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnowAccountBac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassetsOccupy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnoPfoRetAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkactualVoucher = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkpreVoucher = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chktransVoucher = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkhasPay = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcompanyTC = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiverCt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtreserveRiskCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbrokenCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlongBorrowReturn = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttranCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualPayAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtspecialPermitAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtspecialBorrowinst = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlongBorrowAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtequipmentReAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtborrowAmiunt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarginGAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoalCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarginProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgetChickCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcleanHouseCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcleanTowerCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnowAccountBac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtassetsOccupy = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnoPfoRetAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyTC = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdiverCt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel8 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel9 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel10 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel11 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel12 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtSeedEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFodderEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDrugEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSlaughterEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSaleEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.btnExecSettle = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateSaleData = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnupdateActAmt = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.hasPay = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contAuditor.setName("contAuditor");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDTabbedPane3.setName("kDTabbedPane3");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kblBatchContract.setName("kblBatchContract");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.prmtAuditor.setName("prmtAuditor");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel13.setName("kDPanel13");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel17.setName("kDPanel17");
        this.chkFivouchered.setName("chkFivouchered");
        this.contsingleDyFee.setName("contsingleDyFee");
        this.contpunishAmt.setName("contpunishAmt");
        this.contmeatRate.setName("contmeatRate");
        this.contpreHouseWgt.setName("contpreHouseWgt");
        this.contdrugAmt.setName("contdrugAmt");
        this.contbatchAmt.setName("contbatchAmt");
        this.contbEBankAddress.setName("contbEBankAddress");
        this.contconFeedPolicy.setName("contconFeedPolicy");
        this.contbatch.setName("contbatch");
        this.contbillStatus.setName("contbillStatus");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contfarmer.setName("contfarmer");
        this.contbreedData.setName("contbreedData");
        this.contconFeededNum.setName("contconFeededNum");
        this.contperson.setName("contperson");
        this.contfeedWgt.setName("contfeedWgt");
        this.contrecDate.setName("contrecDate");
        this.contpunishWgt.setName("contpunishWgt");
        this.contsurvivalRate.setName("contsurvivalRate");
        this.contmarginAmt.setName("contmarginAmt");
        this.chkisHasPaymentBill.setName("chkisHasPaymentBill");
        this.chkisKouBZJ.setName("chkisKouBZJ");
        this.contadPayAmount.setName("contadPayAmount");
        this.contmlyAllAmt.setName("contmlyAllAmt");
        this.contchickenAveWgt.setName("contchickenAveWgt");
        this.contsettleWgt.setName("contsettleWgt");
        this.contrecQty.setName("contrecQty");
        this.contfeedQty.setName("contfeedQty");
        this.continDate.setName("continDate");
        this.contbEBank.setName("contbEBank");
        this.contcFBeginDate.setName("contcFBeginDate");
        this.contfarm.setName("contfarm");
        this.contFICompany.setName("contFICompany");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contbatchContract.setName("contbatchContract");
        this.contcFEndDate.setName("contcFEndDate");
        this.contbankNum.setName("contbankNum");
        this.contbatchQty.setName("contbatchQty");
        this.contfeedAmt.setName("contfeedAmt");
        this.contfeedDays.setName("contfeedDays");
        this.contrecAmt.setName("contrecAmt");
        this.contdyFee.setName("contdyFee");
        this.contsingleDrugAmt.setName("contsingleDrugAmt");
        this.contsingleFeedWgt.setName("contsingleFeedWgt");
        this.contoValue.setName("contoValue");
        this.contconFeedContract.setName("contconFeedContract");
        this.contkbItemAmt.setName("contkbItemAmt");
        this.contQCItemAmt.setName("contQCItemAmt");
        this.contviewItemAmt.setName("contviewItemAmt");
        this.contotherItemAmt.setName("contotherItemAmt");
        this.conttempItemAmt.setName("conttempItemAmt");
        this.contpayOweMoneryB.setName("contpayOweMoneryB");
        this.contrecSuttle.setName("contrecSuttle");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contfarmsType.setName("contfarmsType");
        this.contoutSaleKbAmt2.setName("contoutSaleKbAmt2");
        this.kDPanel14.setName("kDPanel14");
        this.kDPanel16.setName("kDPanel16");
        this.contchickenRetunAmt.setName("contchickenRetunAmt");
        this.contbeforeBatchAmount.setName("contbeforeBatchAmount");
        this.contidCodeCode.setName("contidCodeCode");
        this.contfarmAddress.setName("contfarmAddress");
        this.contchickenSource.setName("contchickenSource");
        this.contperiod.setName("contperiod");
        this.contoneMrgin.setName("contoneMrgin");
        this.contcostCenter.setName("contcostCenter");
        this.contdrugQty.setName("contdrugQty");
        this.contfarmeronlyPro.setName("contfarmeronlyPro");
        this.contfarmerOnlyProOne.setName("contfarmerOnlyProOne");
        this.contproDiv.setName("contproDiv");
        this.contoccupyMargin.setName("contoccupyMargin");
        this.txtsingleDyFee.setName("txtsingleDyFee");
        this.txtpunishAmt.setName("txtpunishAmt");
        this.txtmeatRate.setName("txtmeatRate");
        this.txtpreHouseWgt.setName("txtpreHouseWgt");
        this.txtdrugAmt.setName("txtdrugAmt");
        this.txtbatchAmt.setName("txtbatchAmt");
        this.txtbEBankAddress.setName("txtbEBankAddress");
        this.prmtconFeedPolicy.setName("prmtconFeedPolicy");
        this.prmtbatch.setName("prmtbatch");
        this.billStatus.setName("billStatus");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtconFeededNum.setName("txtconFeededNum");
        this.prmtperson.setName("prmtperson");
        this.txtfeedWgt.setName("txtfeedWgt");
        this.pkrecDate.setName("pkrecDate");
        this.txtpunishWgt.setName("txtpunishWgt");
        this.txtsurvivalRate.setName("txtsurvivalRate");
        this.txtmarginAmt.setName("txtmarginAmt");
        this.txtadPayAmount.setName("txtadPayAmount");
        this.txtmlyAllAmt.setName("txtmlyAllAmt");
        this.txtchickenAveWgt.setName("txtchickenAveWgt");
        this.txtsettleWgt.setName("txtsettleWgt");
        this.txtrecQty.setName("txtrecQty");
        this.txtfeedQty.setName("txtfeedQty");
        this.pkinDate.setName("pkinDate");
        this.prmtbEBank.setName("prmtbEBank");
        this.pkcFBeginDate.setName("pkcFBeginDate");
        this.prmtfarm.setName("prmtfarm");
        this.prmtFICompany.setName("prmtFICompany");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.pkcFEndDate.setName("pkcFEndDate");
        this.txtbankNum.setName("txtbankNum");
        this.txtbatchQty.setName("txtbatchQty");
        this.txtfeedAmt.setName("txtfeedAmt");
        this.txtfeedDays.setName("txtfeedDays");
        this.txtrecAmt.setName("txtrecAmt");
        this.txtdyFee.setName("txtdyFee");
        this.txtsingleDrugAmt.setName("txtsingleDrugAmt");
        this.txtsingleFeedWgt.setName("txtsingleFeedWgt");
        this.txtoValue.setName("txtoValue");
        this.prmtconFeedContract.setName("prmtconFeedContract");
        this.txtkbItemAmt.setName("txtkbItemAmt");
        this.txtQCItemAmt.setName("txtQCItemAmt");
        this.txtviewItemAmt.setName("txtviewItemAmt");
        this.txtotherItemAmt.setName("txtotherItemAmt");
        this.txttempItemAmt.setName("txttempItemAmt");
        this.txtpayOweMoneryB.setName("txtpayOweMoneryB");
        this.txtrecSuttle.setName("txtrecSuttle");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.farmsType.setName("farmsType");
        this.txtoutSaleKbAmt2.setName("txtoutSaleKbAmt2");
        this.kdtPreHouseEntrys.setName("kdtPreHouseEntrys");
        this.kdtSeedSourceEntrys.setName("kdtSeedSourceEntrys");
        this.txtchickenRetunAmt.setName("txtchickenRetunAmt");
        this.txtbeforeBatchAmount.setName("txtbeforeBatchAmount");
        this.txtidCodeCode.setName("txtidCodeCode");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.txtchickenSource.setName("txtchickenSource");
        this.prmtperiod.setName("prmtperiod");
        this.txtoneMrgin.setName("txtoneMrgin");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.txtdrugQty.setName("txtdrugQty");
        this.txtfarmeronlyPro.setName("txtfarmeronlyPro");
        this.txtfarmerOnlyProOne.setName("txtfarmerOnlyProOne");
        this.txtproDiv.setName("txtproDiv");
        this.txtoccupyMargin.setName("txtoccupyMargin");
        this.kdtEntrys.setName("kdtEntrys");
        this.chkisOrdinary.setName("chkisOrdinary");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel7.setName("kDPanel7");
        this.kDPanel15.setName("kDPanel15");
        this.contmRatePAmt.setName("contmRatePAmt");
        this.contactualMRate.setName("contactualMRate");
        this.contstandardMRate.setName("contstandardMRate");
        this.contdrugLackPAmt.setName("contdrugLackPAmt");
        this.contsingleActualDrug.setName("contsingleActualDrug");
        this.contsingleStandardDrug.setName("contsingleStandardDrug");
        this.contmarginOccupyFee.setName("contmarginOccupyFee");
        this.contbatchOccupyMargin.setName("contbatchOccupyMargin");
        this.contstandardMargin.setName("contstandardMargin");
        this.contsingleMargin.setName("contsingleMargin");
        this.contconFeedSubsidies.setName("contconFeedSubsidies");
        this.contkbConFeedPolicy.setName("contkbConFeedPolicy");
        this.contcontractCKWgt.setName("contcontractCKWgt");
        this.contfreightDiffSubsidies.setName("contfreightDiffSubsidies");
        this.contlFeedWgt.setName("contlFeedWgt");
        this.contfreightPrice.setName("contfreightPrice");
        this.contfreightSubsidiesStd.setName("contfreightSubsidiesStd");
        this.contdeductMargin.setName("contdeductMargin");
        this.conttotalMargin.setName("conttotalMargin");
        this.contenableMargin.setName("contenableMargin");
        this.contdeductAdPayAmt.setName("contdeductAdPayAmt");
        this.contloanRate.setName("contloanRate");
        this.contkYFKOccupyFee.setName("contkYFKOccupyFee");
        this.contfmRatePunishStd.setName("contfmRatePunishStd");
        this.contdyfBalance.setName("contdyfBalance");
        this.contmoneyOccupyDays.setName("contmoneyOccupyDays");
        this.contconFeedPolicySub.setName("contconFeedPolicySub");
        this.contpayOweMonery.setName("contpayOweMonery");
        this.contoutSaleKbAmt.setName("contoutSaleKbAmt");
        this.contunLockedMargin.setName("contunLockedMargin");
        this.contadPayBalance.setName("contadPayBalance");
        this.contQCKbDetail.setName("contQCKbDetail");
        this.contotherKbDetail.setName("contotherKbDetail");
        this.contimmuneCost.setName("contimmuneCost");
        this.contimmuneCostOne.setName("contimmuneCostOne");
        this.contcleanHouse.setName("contcleanHouse");
        this.contcleanHouseOne.setName("contcleanHouseOne");
        this.contactualFoder.setName("contactualFoder");
        this.contstandFodder.setName("contstandFodder");
        this.chknoCalFodderPunish.setName("chknoCalFodderPunish");
        this.chknoCalDrupPunish.setName("chknoCalDrupPunish");
        this.txtmRatePAmt.setName("txtmRatePAmt");
        this.txtactualMRate.setName("txtactualMRate");
        this.txtstandardMRate.setName("txtstandardMRate");
        this.txtdrugLackPAmt.setName("txtdrugLackPAmt");
        this.txtsingleActualDrug.setName("txtsingleActualDrug");
        this.txtsingleStandardDrug.setName("txtsingleStandardDrug");
        this.txtmarginOccupyFee.setName("txtmarginOccupyFee");
        this.txtbatchOccupyMargin.setName("txtbatchOccupyMargin");
        this.txtstandardMargin.setName("txtstandardMargin");
        this.txtsingleMargin.setName("txtsingleMargin");
        this.txtconFeedSubsidies.setName("txtconFeedSubsidies");
        this.prmtkbConFeedPolicy.setName("prmtkbConFeedPolicy");
        this.txtcontractCKWgt.setName("txtcontractCKWgt");
        this.txtfreightDiffSubsidies.setName("txtfreightDiffSubsidies");
        this.txtlFeedWgt.setName("txtlFeedWgt");
        this.txtfreightPrice.setName("txtfreightPrice");
        this.txtfreightSubsidiesStd.setName("txtfreightSubsidiesStd");
        this.txtdeductMargin.setName("txtdeductMargin");
        this.txttotalMargin.setName("txttotalMargin");
        this.txtenableMargin.setName("txtenableMargin");
        this.txtdeductAdPayAmt.setName("txtdeductAdPayAmt");
        this.txtloanRate.setName("txtloanRate");
        this.txtkYFKOccupyFee.setName("txtkYFKOccupyFee");
        this.txtfmRatePunishStd.setName("txtfmRatePunishStd");
        this.txtdyfBalance.setName("txtdyfBalance");
        this.txtmoneyOccupyDays.setName("txtmoneyOccupyDays");
        this.txtconFeedPolicySub.setName("txtconFeedPolicySub");
        this.txtpayOweMonery.setName("txtpayOweMonery");
        this.txtoutSaleKbAmt.setName("txtoutSaleKbAmt");
        this.txtunLockedMargin.setName("txtunLockedMargin");
        this.txtadPayBalance.setName("txtadPayBalance");
        this.scrollPaneQCKbDetail.setName("scrollPaneQCKbDetail");
        this.txtQCKbDetail.setName("txtQCKbDetail");
        this.scrollPaneotherKbDetail.setName("scrollPaneotherKbDetail");
        this.txtotherKbDetail.setName("txtotherKbDetail");
        this.txtimmuneCost.setName("txtimmuneCost");
        this.txtimmuneCostOne.setName("txtimmuneCostOne");
        this.txtcleanHouse.setName("txtcleanHouse");
        this.txtcleanHouseOne.setName("txtcleanHouseOne");
        this.txtactualFoder.setName("txtactualFoder");
        this.txtstandFodder.setName("txtstandFodder");
        this.kdtQCEntrys.setName("kdtQCEntrys");
        this.kdtViewReqEntrys.setName("kdtViewReqEntrys");
        this.kdtOtherEntrys.setName("kdtOtherEntrys");
        this.kdtTempPolicyEntrys.setName("kdtTempPolicyEntrys");
        this.contSeedCost.setName("contSeedCost");
        this.contfodderCost.setName("contfodderCost");
        this.contdrugCost.setName("contdrugCost");
        this.contallocateAmt.setName("contallocateAmt");
        this.contunitCost.setName("contunitCost");
        this.contallCost.setName("contallCost");
        this.contdaiyFee.setName("contdaiyFee");
        this.contcompanyProfit.setName("contcompanyProfit");
        this.contotherMatCost.setName("contotherMatCost");
        this.txtSeedCost.setName("txtSeedCost");
        this.txtfodderCost.setName("txtfodderCost");
        this.txtdrugCost.setName("txtdrugCost");
        this.txtallocateAmt.setName("txtallocateAmt");
        this.txtunitCost.setName("txtunitCost");
        this.txtallCost.setName("txtallCost");
        this.txtdaiyFee.setName("txtdaiyFee");
        this.txtcompanyProfit.setName("txtcompanyProfit");
        this.txtotherMatCost.setName("txtotherMatCost");
        this.contreserveRiskCost.setName("contreserveRiskCost");
        this.contbrokenCost.setName("contbrokenCost");
        this.contlongBorrowReturn.setName("contlongBorrowReturn");
        this.conttranCost.setName("conttranCost");
        this.contactualPayAmt.setName("contactualPayAmt");
        this.contspecialPermitAmt.setName("contspecialPermitAmt");
        this.contspecialBorrowinst.setName("contspecialBorrowinst");
        this.contlongBorrowAmount.setName("contlongBorrowAmount");
        this.contequipmentReAmt.setName("contequipmentReAmt");
        this.contborrowAmiunt.setName("contborrowAmiunt");
        this.contmarginGAmount.setName("contmarginGAmount");
        this.contcoalCost.setName("contcoalCost");
        this.contmarginProfit.setName("contmarginProfit");
        this.contgetChickCost.setName("contgetChickCost");
        this.contcleanHouseCost.setName("contcleanHouseCost");
        this.contDescription.setName("contDescription");
        this.contcleanTowerCost.setName("contcleanTowerCost");
        this.contnowAccountBac.setName("contnowAccountBac");
        this.contassetsOccupy.setName("contassetsOccupy");
        this.contnoPfoRetAmt.setName("contnoPfoRetAmt");
        this.chkactualVoucher.setName("chkactualVoucher");
        this.chkpreVoucher.setName("chkpreVoucher");
        this.chktransVoucher.setName("chktransVoucher");
        this.chkhasPay.setName("chkhasPay");
        this.contcompanyTC.setName("contcompanyTC");
        this.contdiverCt.setName("contdiverCt");
        this.txtreserveRiskCost.setName("txtreserveRiskCost");
        this.txtbrokenCost.setName("txtbrokenCost");
        this.txtlongBorrowReturn.setName("txtlongBorrowReturn");
        this.txttranCost.setName("txttranCost");
        this.txtactualPayAmt.setName("txtactualPayAmt");
        this.txtspecialPermitAmt.setName("txtspecialPermitAmt");
        this.txtspecialBorrowinst.setName("txtspecialBorrowinst");
        this.txtlongBorrowAmount.setName("txtlongBorrowAmount");
        this.txtequipmentReAmt.setName("txtequipmentReAmt");
        this.txtborrowAmiunt.setName("txtborrowAmiunt");
        this.txtmarginGAmount.setName("txtmarginGAmount");
        this.txtcoalCost.setName("txtcoalCost");
        this.txtmarginProfit.setName("txtmarginProfit");
        this.txtgetChickCost.setName("txtgetChickCost");
        this.txtcleanHouseCost.setName("txtcleanHouseCost");
        this.txtDescription.setName("txtDescription");
        this.txtcleanTowerCost.setName("txtcleanTowerCost");
        this.txtnowAccountBac.setName("txtnowAccountBac");
        this.txtassetsOccupy.setName("txtassetsOccupy");
        this.txtnoPfoRetAmt.setName("txtnoPfoRetAmt");
        this.txtcompanyTC.setName("txtcompanyTC");
        this.txtdiverCt.setName("txtdiverCt");
        this.kDPanel8.setName("kDPanel8");
        this.kDPanel9.setName("kDPanel9");
        this.kDPanel10.setName("kDPanel10");
        this.kDPanel11.setName("kDPanel11");
        this.kDPanel12.setName("kDPanel12");
        this.kdtSeedEntrys.setName("kdtSeedEntrys");
        this.kdtFodderEntrys.setName("kdtFodderEntrys");
        this.kdtDrugEntrys.setName("kdtDrugEntrys");
        this.kdtSlaughterEntrys.setName("kdtSlaughterEntrys");
        this.kdtSaleEntrys.setName("kdtSaleEntrys");
        this.pkauditTime.setName("pkauditTime");
        this.btnExecSettle.setName("btnExecSettle");
        this.btnUpdateSaleData.setName("btnUpdateSaleData");
        this.btnupdateActAmt.setName("btnupdateActAmt");
        this.hasPay.setName("hasPay");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnClose.setName("btnClose");
        this.btnUnClose.setName("btnUnClose");
        // CoreUI		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kDTabbedPane1
        // kDTabbedPane3
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kDSeparator8
        // kblBatchContract		
        this.kblBatchContract.setText(resHelper.getString("kblBatchContract.text"));
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // kDPanel1
        // kDPanel13
        // kDPanel2
        // kDPanel3
        // kDPanel17
        // chkFivouchered		
        this.chkFivouchered.setHorizontalAlignment(2);		
        this.chkFivouchered.setText(resHelper.getString("chkFivouchered.text"));		
        this.chkFivouchered.setEnabled(false);
        // contsingleDyFee		
        this.contsingleDyFee.setBoundLabelText(resHelper.getString("contsingleDyFee.boundLabelText"));		
        this.contsingleDyFee.setBoundLabelLength(100);		
        this.contsingleDyFee.setBoundLabelUnderline(true);		
        this.contsingleDyFee.setVisible(true);
        // contpunishAmt		
        this.contpunishAmt.setBoundLabelText(resHelper.getString("contpunishAmt.boundLabelText"));		
        this.contpunishAmt.setBoundLabelLength(100);		
        this.contpunishAmt.setBoundLabelUnderline(true);		
        this.contpunishAmt.setVisible(true);
        // contmeatRate		
        this.contmeatRate.setBoundLabelText(resHelper.getString("contmeatRate.boundLabelText"));		
        this.contmeatRate.setBoundLabelLength(100);		
        this.contmeatRate.setBoundLabelUnderline(true);		
        this.contmeatRate.setVisible(true);
        // contpreHouseWgt		
        this.contpreHouseWgt.setBoundLabelText(resHelper.getString("contpreHouseWgt.boundLabelText"));		
        this.contpreHouseWgt.setBoundLabelLength(100);		
        this.contpreHouseWgt.setBoundLabelUnderline(true);		
        this.contpreHouseWgt.setVisible(true);
        // contdrugAmt		
        this.contdrugAmt.setBoundLabelText(resHelper.getString("contdrugAmt.boundLabelText"));		
        this.contdrugAmt.setBoundLabelLength(100);		
        this.contdrugAmt.setBoundLabelUnderline(true);		
        this.contdrugAmt.setVisible(true);
        // contbatchAmt		
        this.contbatchAmt.setBoundLabelText(resHelper.getString("contbatchAmt.boundLabelText"));		
        this.contbatchAmt.setBoundLabelLength(100);		
        this.contbatchAmt.setBoundLabelUnderline(true);		
        this.contbatchAmt.setVisible(true);
        // contbEBankAddress		
        this.contbEBankAddress.setBoundLabelText(resHelper.getString("contbEBankAddress.boundLabelText"));		
        this.contbEBankAddress.setBoundLabelLength(100);		
        this.contbEBankAddress.setBoundLabelUnderline(true);		
        this.contbEBankAddress.setVisible(true);
        // contconFeedPolicy		
        this.contconFeedPolicy.setBoundLabelText(resHelper.getString("contconFeedPolicy.boundLabelText"));		
        this.contconFeedPolicy.setBoundLabelLength(100);		
        this.contconFeedPolicy.setBoundLabelUnderline(true);		
        this.contconFeedPolicy.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contconFeededNum		
        this.contconFeededNum.setBoundLabelText(resHelper.getString("contconFeededNum.boundLabelText"));		
        this.contconFeededNum.setBoundLabelLength(100);		
        this.contconFeededNum.setBoundLabelUnderline(true);		
        this.contconFeededNum.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contfeedWgt		
        this.contfeedWgt.setBoundLabelText(resHelper.getString("contfeedWgt.boundLabelText"));		
        this.contfeedWgt.setBoundLabelLength(100);		
        this.contfeedWgt.setBoundLabelUnderline(true);		
        this.contfeedWgt.setVisible(true);
        // contrecDate		
        this.contrecDate.setBoundLabelText(resHelper.getString("contrecDate.boundLabelText"));		
        this.contrecDate.setBoundLabelLength(100);		
        this.contrecDate.setBoundLabelUnderline(true);		
        this.contrecDate.setVisible(true);
        // contpunishWgt		
        this.contpunishWgt.setBoundLabelText(resHelper.getString("contpunishWgt.boundLabelText"));		
        this.contpunishWgt.setBoundLabelLength(100);		
        this.contpunishWgt.setBoundLabelUnderline(true);		
        this.contpunishWgt.setVisible(true);
        // contsurvivalRate		
        this.contsurvivalRate.setBoundLabelText(resHelper.getString("contsurvivalRate.boundLabelText"));		
        this.contsurvivalRate.setBoundLabelLength(100);		
        this.contsurvivalRate.setBoundLabelUnderline(true);		
        this.contsurvivalRate.setVisible(true);
        // contmarginAmt		
        this.contmarginAmt.setBoundLabelText(resHelper.getString("contmarginAmt.boundLabelText"));		
        this.contmarginAmt.setBoundLabelLength(100);		
        this.contmarginAmt.setBoundLabelUnderline(true);		
        this.contmarginAmt.setVisible(true);
        // chkisHasPaymentBill		
        this.chkisHasPaymentBill.setText(resHelper.getString("chkisHasPaymentBill.text"));		
        this.chkisHasPaymentBill.setHorizontalAlignment(2);		
        this.chkisHasPaymentBill.setEnabled(false);
        // chkisKouBZJ		
        this.chkisKouBZJ.setText(resHelper.getString("chkisKouBZJ.text"));		
        this.chkisKouBZJ.setHorizontalAlignment(2);		
        this.chkisKouBZJ.setEnabled(false);
        // contadPayAmount		
        this.contadPayAmount.setBoundLabelText(resHelper.getString("contadPayAmount.boundLabelText"));		
        this.contadPayAmount.setBoundLabelLength(100);		
        this.contadPayAmount.setBoundLabelUnderline(true);		
        this.contadPayAmount.setVisible(true);
        // contmlyAllAmt		
        this.contmlyAllAmt.setBoundLabelText(resHelper.getString("contmlyAllAmt.boundLabelText"));		
        this.contmlyAllAmt.setBoundLabelLength(100);		
        this.contmlyAllAmt.setBoundLabelUnderline(true);		
        this.contmlyAllAmt.setVisible(true);
        // contchickenAveWgt		
        this.contchickenAveWgt.setBoundLabelText(resHelper.getString("contchickenAveWgt.boundLabelText"));		
        this.contchickenAveWgt.setBoundLabelLength(100);		
        this.contchickenAveWgt.setBoundLabelUnderline(true);		
        this.contchickenAveWgt.setVisible(true);
        // contsettleWgt		
        this.contsettleWgt.setBoundLabelText(resHelper.getString("contsettleWgt.boundLabelText"));		
        this.contsettleWgt.setBoundLabelLength(100);		
        this.contsettleWgt.setBoundLabelUnderline(true);		
        this.contsettleWgt.setVisible(true);
        // contrecQty		
        this.contrecQty.setBoundLabelText(resHelper.getString("contrecQty.boundLabelText"));		
        this.contrecQty.setBoundLabelLength(100);		
        this.contrecQty.setBoundLabelUnderline(true);		
        this.contrecQty.setVisible(true);
        // contfeedQty		
        this.contfeedQty.setBoundLabelText(resHelper.getString("contfeedQty.boundLabelText"));		
        this.contfeedQty.setBoundLabelLength(100);		
        this.contfeedQty.setBoundLabelUnderline(true);		
        this.contfeedQty.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contbEBank		
        this.contbEBank.setBoundLabelText(resHelper.getString("contbEBank.boundLabelText"));		
        this.contbEBank.setBoundLabelLength(100);		
        this.contbEBank.setBoundLabelUnderline(true);		
        this.contbEBank.setVisible(true);
        // contcFBeginDate		
        this.contcFBeginDate.setBoundLabelText(resHelper.getString("contcFBeginDate.boundLabelText"));		
        this.contcFBeginDate.setBoundLabelLength(100);		
        this.contcFBeginDate.setBoundLabelUnderline(true);		
        this.contcFBeginDate.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contcFEndDate		
        this.contcFEndDate.setBoundLabelText(resHelper.getString("contcFEndDate.boundLabelText"));		
        this.contcFEndDate.setBoundLabelLength(100);		
        this.contcFEndDate.setBoundLabelUnderline(true);		
        this.contcFEndDate.setVisible(true);
        // contbankNum		
        this.contbankNum.setBoundLabelText(resHelper.getString("contbankNum.boundLabelText"));		
        this.contbankNum.setBoundLabelLength(100);		
        this.contbankNum.setBoundLabelUnderline(true);		
        this.contbankNum.setVisible(true);
        // contbatchQty		
        this.contbatchQty.setBoundLabelText(resHelper.getString("contbatchQty.boundLabelText"));		
        this.contbatchQty.setBoundLabelLength(100);		
        this.contbatchQty.setBoundLabelUnderline(true);		
        this.contbatchQty.setVisible(true);
        // contfeedAmt		
        this.contfeedAmt.setBoundLabelText(resHelper.getString("contfeedAmt.boundLabelText"));		
        this.contfeedAmt.setBoundLabelLength(100);		
        this.contfeedAmt.setBoundLabelUnderline(true);		
        this.contfeedAmt.setVisible(true);
        // contfeedDays		
        this.contfeedDays.setBoundLabelText(resHelper.getString("contfeedDays.boundLabelText"));		
        this.contfeedDays.setBoundLabelLength(100);		
        this.contfeedDays.setBoundLabelUnderline(true);		
        this.contfeedDays.setVisible(true);
        // contrecAmt		
        this.contrecAmt.setBoundLabelText(resHelper.getString("contrecAmt.boundLabelText"));		
        this.contrecAmt.setBoundLabelLength(100);		
        this.contrecAmt.setBoundLabelUnderline(true);		
        this.contrecAmt.setVisible(true);
        // contdyFee		
        this.contdyFee.setBoundLabelText(resHelper.getString("contdyFee.boundLabelText"));		
        this.contdyFee.setBoundLabelLength(100);		
        this.contdyFee.setBoundLabelUnderline(true);		
        this.contdyFee.setVisible(true);
        // contsingleDrugAmt		
        this.contsingleDrugAmt.setBoundLabelText(resHelper.getString("contsingleDrugAmt.boundLabelText"));		
        this.contsingleDrugAmt.setBoundLabelLength(100);		
        this.contsingleDrugAmt.setBoundLabelUnderline(true);		
        this.contsingleDrugAmt.setVisible(true);
        // contsingleFeedWgt		
        this.contsingleFeedWgt.setBoundLabelText(resHelper.getString("contsingleFeedWgt.boundLabelText"));		
        this.contsingleFeedWgt.setBoundLabelLength(100);		
        this.contsingleFeedWgt.setBoundLabelUnderline(true);		
        this.contsingleFeedWgt.setVisible(true);
        // contoValue		
        this.contoValue.setBoundLabelText(resHelper.getString("contoValue.boundLabelText"));		
        this.contoValue.setBoundLabelLength(100);		
        this.contoValue.setBoundLabelUnderline(true);		
        this.contoValue.setVisible(true);
        // contconFeedContract		
        this.contconFeedContract.setBoundLabelText(resHelper.getString("contconFeedContract.boundLabelText"));		
        this.contconFeedContract.setBoundLabelLength(100);		
        this.contconFeedContract.setBoundLabelUnderline(true);		
        this.contconFeedContract.setVisible(true);
        // contkbItemAmt		
        this.contkbItemAmt.setBoundLabelText(resHelper.getString("contkbItemAmt.boundLabelText"));		
        this.contkbItemAmt.setBoundLabelLength(100);		
        this.contkbItemAmt.setBoundLabelUnderline(true);		
        this.contkbItemAmt.setVisible(true);
        // contQCItemAmt		
        this.contQCItemAmt.setBoundLabelText(resHelper.getString("contQCItemAmt.boundLabelText"));		
        this.contQCItemAmt.setBoundLabelLength(100);		
        this.contQCItemAmt.setBoundLabelUnderline(true);		
        this.contQCItemAmt.setVisible(true);
        // contviewItemAmt		
        this.contviewItemAmt.setBoundLabelText(resHelper.getString("contviewItemAmt.boundLabelText"));		
        this.contviewItemAmt.setBoundLabelLength(100);		
        this.contviewItemAmt.setBoundLabelUnderline(true);		
        this.contviewItemAmt.setVisible(true);
        // contotherItemAmt		
        this.contotherItemAmt.setBoundLabelText(resHelper.getString("contotherItemAmt.boundLabelText"));		
        this.contotherItemAmt.setBoundLabelLength(100);		
        this.contotherItemAmt.setBoundLabelUnderline(true);		
        this.contotherItemAmt.setVisible(true);
        // conttempItemAmt		
        this.conttempItemAmt.setBoundLabelText(resHelper.getString("conttempItemAmt.boundLabelText"));		
        this.conttempItemAmt.setBoundLabelLength(100);		
        this.conttempItemAmt.setBoundLabelUnderline(true);		
        this.conttempItemAmt.setVisible(true);
        // contpayOweMoneryB		
        this.contpayOweMoneryB.setBoundLabelText(resHelper.getString("contpayOweMoneryB.boundLabelText"));		
        this.contpayOweMoneryB.setBoundLabelLength(100);		
        this.contpayOweMoneryB.setBoundLabelUnderline(true);		
        this.contpayOweMoneryB.setVisible(true);
        // contrecSuttle		
        this.contrecSuttle.setBoundLabelText(resHelper.getString("contrecSuttle.boundLabelText"));		
        this.contrecSuttle.setBoundLabelLength(100);		
        this.contrecSuttle.setBoundLabelUnderline(true);		
        this.contrecSuttle.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contfarmsType		
        this.contfarmsType.setBoundLabelText(resHelper.getString("contfarmsType.boundLabelText"));		
        this.contfarmsType.setBoundLabelLength(100);		
        this.contfarmsType.setBoundLabelUnderline(true);		
        this.contfarmsType.setVisible(true);
        // contoutSaleKbAmt2		
        this.contoutSaleKbAmt2.setBoundLabelText(resHelper.getString("contoutSaleKbAmt2.boundLabelText"));		
        this.contoutSaleKbAmt2.setBoundLabelLength(100);		
        this.contoutSaleKbAmt2.setBoundLabelUnderline(true);		
        this.contoutSaleKbAmt2.setVisible(true);
        // kDPanel14
        // kDPanel16
        // contchickenRetunAmt		
        this.contchickenRetunAmt.setBoundLabelText(resHelper.getString("contchickenRetunAmt.boundLabelText"));		
        this.contchickenRetunAmt.setBoundLabelLength(100);		
        this.contchickenRetunAmt.setBoundLabelUnderline(true);		
        this.contchickenRetunAmt.setVisible(true);
        // contbeforeBatchAmount		
        this.contbeforeBatchAmount.setBoundLabelText(resHelper.getString("contbeforeBatchAmount.boundLabelText"));		
        this.contbeforeBatchAmount.setBoundLabelLength(100);		
        this.contbeforeBatchAmount.setBoundLabelUnderline(true);		
        this.contbeforeBatchAmount.setVisible(true);
        // contidCodeCode		
        this.contidCodeCode.setBoundLabelText(resHelper.getString("contidCodeCode.boundLabelText"));		
        this.contidCodeCode.setBoundLabelLength(100);		
        this.contidCodeCode.setBoundLabelUnderline(true);		
        this.contidCodeCode.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // contchickenSource		
        this.contchickenSource.setBoundLabelText(resHelper.getString("contchickenSource.boundLabelText"));		
        this.contchickenSource.setBoundLabelLength(100);		
        this.contchickenSource.setBoundLabelUnderline(true);		
        this.contchickenSource.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contoneMrgin		
        this.contoneMrgin.setBoundLabelText(resHelper.getString("contoneMrgin.boundLabelText"));		
        this.contoneMrgin.setBoundLabelLength(100);		
        this.contoneMrgin.setBoundLabelUnderline(true);		
        this.contoneMrgin.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // contdrugQty		
        this.contdrugQty.setBoundLabelText(resHelper.getString("contdrugQty.boundLabelText"));		
        this.contdrugQty.setBoundLabelLength(100);		
        this.contdrugQty.setBoundLabelUnderline(true);		
        this.contdrugQty.setVisible(true);
        // contfarmeronlyPro		
        this.contfarmeronlyPro.setBoundLabelText(resHelper.getString("contfarmeronlyPro.boundLabelText"));		
        this.contfarmeronlyPro.setBoundLabelLength(100);		
        this.contfarmeronlyPro.setBoundLabelUnderline(true);		
        this.contfarmeronlyPro.setVisible(true);
        // contfarmerOnlyProOne		
        this.contfarmerOnlyProOne.setBoundLabelText(resHelper.getString("contfarmerOnlyProOne.boundLabelText"));		
        this.contfarmerOnlyProOne.setBoundLabelLength(100);		
        this.contfarmerOnlyProOne.setBoundLabelUnderline(true);		
        this.contfarmerOnlyProOne.setVisible(true);
        // contproDiv		
        this.contproDiv.setBoundLabelText(resHelper.getString("contproDiv.boundLabelText"));		
        this.contproDiv.setBoundLabelLength(100);		
        this.contproDiv.setBoundLabelUnderline(true);		
        this.contproDiv.setVisible(true);
        // contoccupyMargin		
        this.contoccupyMargin.setBoundLabelText(resHelper.getString("contoccupyMargin.boundLabelText"));		
        this.contoccupyMargin.setBoundLabelLength(120);		
        this.contoccupyMargin.setBoundLabelUnderline(true);		
        this.contoccupyMargin.setVisible(true);
        // txtsingleDyFee		
        this.txtsingleDyFee.setHorizontalAlignment(2);		
        this.txtsingleDyFee.setDataType(1);		
        this.txtsingleDyFee.setSupportedEmpty(true);		
        this.txtsingleDyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleDyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleDyFee.setPrecision(2);		
        this.txtsingleDyFee.setRequired(false);		
        this.txtsingleDyFee.setEnabled(false);
        // txtpunishAmt		
        this.txtpunishAmt.setHorizontalAlignment(2);		
        this.txtpunishAmt.setDataType(1);		
        this.txtpunishAmt.setSupportedEmpty(true);		
        this.txtpunishAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpunishAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpunishAmt.setRequired(false);		
        this.txtpunishAmt.setEnabled(false);
        // txtmeatRate		
        this.txtmeatRate.setHorizontalAlignment(2);		
        this.txtmeatRate.setDataType(1);		
        this.txtmeatRate.setSupportedEmpty(true);		
        this.txtmeatRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmeatRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmeatRate.setPrecision(4);		
        this.txtmeatRate.setRequired(false);		
        this.txtmeatRate.setEnabled(false);
        // txtpreHouseWgt		
        this.txtpreHouseWgt.setHorizontalAlignment(2);		
        this.txtpreHouseWgt.setDataType(1);		
        this.txtpreHouseWgt.setSupportedEmpty(true);		
        this.txtpreHouseWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpreHouseWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpreHouseWgt.setPrecision(4);		
        this.txtpreHouseWgt.setRequired(false);		
        this.txtpreHouseWgt.setEnabled(false);
        // txtdrugAmt		
        this.txtdrugAmt.setHorizontalAlignment(2);		
        this.txtdrugAmt.setDataType(1);		
        this.txtdrugAmt.setSupportedEmpty(true);		
        this.txtdrugAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugAmt.setPrecision(2);		
        this.txtdrugAmt.setRequired(false);		
        this.txtdrugAmt.setEnabled(false);
        // txtbatchAmt		
        this.txtbatchAmt.setHorizontalAlignment(2);		
        this.txtbatchAmt.setDataType(1);		
        this.txtbatchAmt.setSupportedEmpty(true);		
        this.txtbatchAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchAmt.setPrecision(2);		
        this.txtbatchAmt.setRequired(false);		
        this.txtbatchAmt.setEnabled(false);
        // txtbEBankAddress		
        this.txtbEBankAddress.setHorizontalAlignment(2);		
        this.txtbEBankAddress.setMaxLength(100);		
        this.txtbEBankAddress.setRequired(false);		
        this.txtbEBankAddress.setEnabled(false);
        // prmtconFeedPolicy		
        this.prmtconFeedPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.ConFeedPolicyQuery");		
        this.prmtconFeedPolicy.setEditable(true);		
        this.prmtconFeedPolicy.setDisplayFormat("$name$");		
        this.prmtconFeedPolicy.setEditFormat("$number$");		
        this.prmtconFeedPolicy.setCommitFormat("$number$");		
        this.prmtconFeedPolicy.setRequired(false);		
        this.prmtconFeedPolicy.setEnabled(false);
        		EntityViewInfo eviprmtconFeedPolicy = new EntityViewInfo ();
		eviprmtconFeedPolicy.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtconFeedPolicy.setEntityViewInfo(eviprmtconFeedPolicy);
					
        		prmtconFeedPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI prmtconFeedPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtconFeedPolicy_F7ListUI == null) {
					try {
						prmtconFeedPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtconFeedPolicy_F7ListUI));
					prmtconFeedPolicy_F7ListUI.setF7Use(true,ctx);
					prmtconFeedPolicy.setSelector(prmtconFeedPolicy_F7ListUI);
				}
			}
		});
					
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$name$");		
        this.prmtbatch.setEditFormat("$number$");		
        this.prmtbatch.setCommitFormat("$number$");		
        this.prmtbatch.setRequired(false);		
        this.prmtbatch.setEnabled(false);
        		prmtbatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtbatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbatch_F7ListUI == null) {
					try {
						prmtbatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbatch_F7ListUI));
					prmtbatch_F7ListUI.setF7Use(true,ctx);
					prmtbatch.setSelector(prmtbatch_F7ListUI);
				}
			}
		});
					
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(true);		
        this.prmtfarmer.setEnabled(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
					
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(false);		
        this.prmtbreedData.setEnabled(false);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // txtconFeededNum		
        this.txtconFeededNum.setHorizontalAlignment(2);		
        this.txtconFeededNum.setDataType(0);		
        this.txtconFeededNum.setSupportedEmpty(true);		
        this.txtconFeededNum.setRequired(false);		
        this.txtconFeededNum.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // txtfeedWgt		
        this.txtfeedWgt.setHorizontalAlignment(2);		
        this.txtfeedWgt.setDataType(1);		
        this.txtfeedWgt.setSupportedEmpty(true);		
        this.txtfeedWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedWgt.setPrecision(4);		
        this.txtfeedWgt.setRequired(false);		
        this.txtfeedWgt.setEnabled(false);
        // pkrecDate		
        this.pkrecDate.setRequired(false);
        // txtpunishWgt		
        this.txtpunishWgt.setHorizontalAlignment(2);		
        this.txtpunishWgt.setDataType(1);		
        this.txtpunishWgt.setSupportedEmpty(true);		
        this.txtpunishWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpunishWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpunishWgt.setPrecision(4);		
        this.txtpunishWgt.setRequired(false);
        // txtsurvivalRate		
        this.txtsurvivalRate.setHorizontalAlignment(2);		
        this.txtsurvivalRate.setDataType(1);		
        this.txtsurvivalRate.setSupportedEmpty(true);		
        this.txtsurvivalRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsurvivalRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsurvivalRate.setPrecision(4);		
        this.txtsurvivalRate.setRequired(false);		
        this.txtsurvivalRate.setEnabled(false);
        // txtmarginAmt		
        this.txtmarginAmt.setHorizontalAlignment(2);		
        this.txtmarginAmt.setDataType(1);		
        this.txtmarginAmt.setSupportedEmpty(true);		
        this.txtmarginAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginAmt.setPrecision(2);		
        this.txtmarginAmt.setRequired(false);		
        this.txtmarginAmt.setEnabled(false);
        // txtadPayAmount		
        this.txtadPayAmount.setHorizontalAlignment(2);		
        this.txtadPayAmount.setDataType(1);		
        this.txtadPayAmount.setSupportedEmpty(true);		
        this.txtadPayAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtadPayAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtadPayAmount.setPrecision(2);		
        this.txtadPayAmount.setRequired(false);		
        this.txtadPayAmount.setEnabled(false);
        // txtmlyAllAmt		
        this.txtmlyAllAmt.setHorizontalAlignment(2);		
        this.txtmlyAllAmt.setDataType(1);		
        this.txtmlyAllAmt.setSupportedEmpty(true);		
        this.txtmlyAllAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmlyAllAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmlyAllAmt.setPrecision(2);		
        this.txtmlyAllAmt.setRequired(false);		
        this.txtmlyAllAmt.setEnabled(false);
        // txtchickenAveWgt		
        this.txtchickenAveWgt.setHorizontalAlignment(2);		
        this.txtchickenAveWgt.setDataType(1);		
        this.txtchickenAveWgt.setSupportedEmpty(true);		
        this.txtchickenAveWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenAveWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenAveWgt.setPrecision(4);		
        this.txtchickenAveWgt.setRequired(false);		
        this.txtchickenAveWgt.setEnabled(false);
        // txtsettleWgt		
        this.txtsettleWgt.setHorizontalAlignment(2);		
        this.txtsettleWgt.setDataType(1);		
        this.txtsettleWgt.setSupportedEmpty(true);		
        this.txtsettleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsettleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsettleWgt.setPrecision(4);		
        this.txtsettleWgt.setRequired(false);		
        this.txtsettleWgt.setEnabled(false);
        // txtrecQty		
        this.txtrecQty.setHorizontalAlignment(2);		
        this.txtrecQty.setDataType(0);		
        this.txtrecQty.setSupportedEmpty(true);		
        this.txtrecQty.setRequired(false);		
        this.txtrecQty.setEnabled(false);
        // txtfeedQty		
        this.txtfeedQty.setHorizontalAlignment(2);		
        this.txtfeedQty.setDataType(0);		
        this.txtfeedQty.setSupportedEmpty(true);		
        this.txtfeedQty.setRequired(false);		
        this.txtfeedQty.setEnabled(false);
        // pkinDate		
        this.pkinDate.setRequired(false);		
        this.pkinDate.setEnabled(false);
        // prmtbEBank		
        this.prmtbEBank.setQueryInfo("com.kingdee.eas.fm.be.app.BEBankQuery");		
        this.prmtbEBank.setEditable(true);		
        this.prmtbEBank.setDisplayFormat("$name$");		
        this.prmtbEBank.setEditFormat("$number$");		
        this.prmtbEBank.setCommitFormat("$number$");		
        this.prmtbEBank.setRequired(false);		
        this.prmtbEBank.setEnabled(false);
        // pkcFBeginDate		
        this.pkcFBeginDate.setRequired(false);		
        this.pkcFBeginDate.setEnabled(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);		
        this.prmtfarm.setEnabled(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
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
					
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(true);		
        this.prmtbatchContract.setEnabled(false);
        // pkcFEndDate		
        this.pkcFEndDate.setRequired(false);		
        this.pkcFEndDate.setEnabled(false);
        // txtbankNum		
        this.txtbankNum.setHorizontalAlignment(2);		
        this.txtbankNum.setMaxLength(100);		
        this.txtbankNum.setRequired(false);		
        this.txtbankNum.setEnabled(false);
        // txtbatchQty		
        this.txtbatchQty.setHorizontalAlignment(2);		
        this.txtbatchQty.setDataType(1);		
        this.txtbatchQty.setSupportedEmpty(true);		
        this.txtbatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchQty.setPrecision(4);		
        this.txtbatchQty.setRequired(false);		
        this.txtbatchQty.setEnabled(false);
        // txtfeedAmt		
        this.txtfeedAmt.setHorizontalAlignment(2);		
        this.txtfeedAmt.setDataType(1);		
        this.txtfeedAmt.setSupportedEmpty(true);		
        this.txtfeedAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedAmt.setPrecision(2);		
        this.txtfeedAmt.setRequired(false);		
        this.txtfeedAmt.setEnabled(false);
        // txtfeedDays		
        this.txtfeedDays.setHorizontalAlignment(2);		
        this.txtfeedDays.setDataType(0);		
        this.txtfeedDays.setSupportedEmpty(true);		
        this.txtfeedDays.setRequired(false);		
        this.txtfeedDays.setEnabled(false);
        // txtrecAmt		
        this.txtrecAmt.setHorizontalAlignment(2);		
        this.txtrecAmt.setDataType(1);		
        this.txtrecAmt.setSupportedEmpty(true);		
        this.txtrecAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrecAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrecAmt.setPrecision(2);		
        this.txtrecAmt.setRequired(false);		
        this.txtrecAmt.setEnabled(false);
        // txtdyFee		
        this.txtdyFee.setHorizontalAlignment(2);		
        this.txtdyFee.setDataType(1);		
        this.txtdyFee.setSupportedEmpty(true);		
        this.txtdyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdyFee.setPrecision(2);		
        this.txtdyFee.setRequired(false);		
        this.txtdyFee.setEnabled(false);
        // txtsingleDrugAmt		
        this.txtsingleDrugAmt.setHorizontalAlignment(2);		
        this.txtsingleDrugAmt.setDataType(1);		
        this.txtsingleDrugAmt.setSupportedEmpty(true);		
        this.txtsingleDrugAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleDrugAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleDrugAmt.setPrecision(2);		
        this.txtsingleDrugAmt.setRequired(false);		
        this.txtsingleDrugAmt.setEnabled(false);
        // txtsingleFeedWgt		
        this.txtsingleFeedWgt.setHorizontalAlignment(2);		
        this.txtsingleFeedWgt.setDataType(1);		
        this.txtsingleFeedWgt.setSupportedEmpty(true);		
        this.txtsingleFeedWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleFeedWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleFeedWgt.setPrecision(4);		
        this.txtsingleFeedWgt.setRequired(false);		
        this.txtsingleFeedWgt.setEnabled(false);
        // txtoValue		
        this.txtoValue.setHorizontalAlignment(2);		
        this.txtoValue.setDataType(1);		
        this.txtoValue.setSupportedEmpty(true);		
        this.txtoValue.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoValue.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoValue.setPrecision(4);		
        this.txtoValue.setRequired(false);		
        this.txtoValue.setEnabled(false);
        // prmtconFeedContract		
        this.prmtconFeedContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.ConFeedContractQuery");		
        this.prmtconFeedContract.setEditable(true);		
        this.prmtconFeedContract.setDisplayFormat("$number$");		
        this.prmtconFeedContract.setEditFormat("$number$");		
        this.prmtconFeedContract.setCommitFormat("$number$");		
        this.prmtconFeedContract.setRequired(false);		
        this.prmtconFeedContract.setEnabled(false);
        // txtkbItemAmt		
        this.txtkbItemAmt.setHorizontalAlignment(2);		
        this.txtkbItemAmt.setDataType(1);		
        this.txtkbItemAmt.setSupportedEmpty(true);		
        this.txtkbItemAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkbItemAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkbItemAmt.setPrecision(2);		
        this.txtkbItemAmt.setRequired(false);
        // txtQCItemAmt		
        this.txtQCItemAmt.setHorizontalAlignment(2);		
        this.txtQCItemAmt.setDataType(1);		
        this.txtQCItemAmt.setSupportedEmpty(true);		
        this.txtQCItemAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQCItemAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQCItemAmt.setPrecision(2);		
        this.txtQCItemAmt.setRequired(false);
        // txtviewItemAmt		
        this.txtviewItemAmt.setHorizontalAlignment(2);		
        this.txtviewItemAmt.setDataType(1);		
        this.txtviewItemAmt.setSupportedEmpty(true);		
        this.txtviewItemAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtviewItemAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtviewItemAmt.setRequired(false);		
        this.txtviewItemAmt.setEnabled(false);
        // txtotherItemAmt		
        this.txtotherItemAmt.setHorizontalAlignment(2);		
        this.txtotherItemAmt.setDataType(1);		
        this.txtotherItemAmt.setSupportedEmpty(true);		
        this.txtotherItemAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherItemAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherItemAmt.setPrecision(2);		
        this.txtotherItemAmt.setRequired(false);		
        this.txtotherItemAmt.setEnabled(false);
        // txttempItemAmt		
        this.txttempItemAmt.setHorizontalAlignment(2);		
        this.txttempItemAmt.setDataType(1);		
        this.txttempItemAmt.setSupportedEmpty(true);		
        this.txttempItemAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttempItemAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttempItemAmt.setPrecision(2);		
        this.txttempItemAmt.setRequired(false);		
        this.txttempItemAmt.setEnabled(false);
        // txtpayOweMoneryB		
        this.txtpayOweMoneryB.setHorizontalAlignment(2);		
        this.txtpayOweMoneryB.setDataType(1);		
        this.txtpayOweMoneryB.setSupportedEmpty(true);		
        this.txtpayOweMoneryB.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpayOweMoneryB.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpayOweMoneryB.setPrecision(2);		
        this.txtpayOweMoneryB.setRequired(false);		
        this.txtpayOweMoneryB.setEnabled(false);
        // txtrecSuttle		
        this.txtrecSuttle.setHorizontalAlignment(2);		
        this.txtrecSuttle.setDataType(1);		
        this.txtrecSuttle.setSupportedEmpty(true);		
        this.txtrecSuttle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrecSuttle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrecSuttle.setPrecision(4);		
        this.txtrecSuttle.setRequired(false);		
        this.txtrecSuttle.setEnabled(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(false);		
        this.prmtsettlePolicy.setEnabled(false);
        		prmtsettlePolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI prmtsettlePolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlePolicy_F7ListUI == null) {
					try {
						prmtsettlePolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlePolicy_F7ListUI));
					prmtsettlePolicy_F7ListUI.setF7Use(true,ctx);
					prmtsettlePolicy.setSelector(prmtsettlePolicy_F7ListUI);
				}
			}
		});
					
        // farmsType		
        this.farmsType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());		
        this.farmsType.setRequired(false);		
        this.farmsType.setEnabled(false);
        // txtoutSaleKbAmt2		
        this.txtoutSaleKbAmt2.setHorizontalAlignment(2);		
        this.txtoutSaleKbAmt2.setDataType(1);		
        this.txtoutSaleKbAmt2.setSupportedEmpty(true);		
        this.txtoutSaleKbAmt2.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoutSaleKbAmt2.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoutSaleKbAmt2.setPrecision(2);		
        this.txtoutSaleKbAmt2.setRequired(false);
        // kdtPreHouseEntrys
		String kdtPreHouseEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"preHouseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"preHouseTare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"preHouseGross\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"preHouseSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"recQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"settleWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"recSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{preHouseQty}</t:Cell><t:Cell>$Resource{preHouseTare}</t:Cell><t:Cell>$Resource{preHouseGross}</t:Cell><t:Cell>$Resource{preHouseSuttle}</t:Cell><t:Cell>$Resource{recQty}</t:Cell><t:Cell>$Resource{settleWgt}</t:Cell><t:Cell>$Resource{recSuttle}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPreHouseEntrys.setFormatXml(resHelper.translateString("kdtPreHouseEntrys",kdtPreHouseEntrysStrXML));

                this.kdtPreHouseEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","preHouseQty","preHouseTare","preHouseGross","preHouseSuttle","recQty","settleWgt","recSuttle"});


        this.kdtPreHouseEntrys.checkParsed();
        KDFormattedTextField kdtPreHouseEntrys_seq_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_seq_TextField.setName("kdtPreHouseEntrys_seq_TextField");
        kdtPreHouseEntrys_seq_TextField.setVisible(true);
        kdtPreHouseEntrys_seq_TextField.setEditable(true);
        kdtPreHouseEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPreHouseEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_seq_TextField);
        this.kdtPreHouseEntrys.getColumn("seq").setEditor(kdtPreHouseEntrys_seq_CellEditor);
        KDDatePicker kdtPreHouseEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtPreHouseEntrys_bizDate_DatePicker.setName("kdtPreHouseEntrys_bizDate_DatePicker");
        kdtPreHouseEntrys_bizDate_DatePicker.setVisible(true);
        kdtPreHouseEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtPreHouseEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_bizDate_DatePicker);
        this.kdtPreHouseEntrys.getColumn("bizDate").setEditor(kdtPreHouseEntrys_bizDate_CellEditor);
        KDTextField kdtPreHouseEntrys_billNumber_TextField = new KDTextField();
        kdtPreHouseEntrys_billNumber_TextField.setName("kdtPreHouseEntrys_billNumber_TextField");
        kdtPreHouseEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPreHouseEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_billNumber_TextField);
        this.kdtPreHouseEntrys.getColumn("billNumber").setEditor(kdtPreHouseEntrys_billNumber_CellEditor);
        KDComboBox kdtPreHouseEntrys_billStatus_ComboBox = new KDComboBox();
        kdtPreHouseEntrys_billStatus_ComboBox.setName("kdtPreHouseEntrys_billStatus_ComboBox");
        kdtPreHouseEntrys_billStatus_ComboBox.setVisible(true);
        kdtPreHouseEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtPreHouseEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_billStatus_ComboBox);
        this.kdtPreHouseEntrys.getColumn("billStatus").setEditor(kdtPreHouseEntrys_billStatus_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_preHouseQty_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_preHouseQty_TextField.setName("kdtPreHouseEntrys_preHouseQty_TextField");
        kdtPreHouseEntrys_preHouseQty_TextField.setVisible(true);
        kdtPreHouseEntrys_preHouseQty_TextField.setEditable(true);
        kdtPreHouseEntrys_preHouseQty_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_preHouseQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPreHouseEntrys_preHouseQty_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_preHouseQty_TextField);
        this.kdtPreHouseEntrys.getColumn("preHouseQty").setEditor(kdtPreHouseEntrys_preHouseQty_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_preHouseTare_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_preHouseTare_TextField.setName("kdtPreHouseEntrys_preHouseTare_TextField");
        kdtPreHouseEntrys_preHouseTare_TextField.setVisible(true);
        kdtPreHouseEntrys_preHouseTare_TextField.setEditable(true);
        kdtPreHouseEntrys_preHouseTare_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_preHouseTare_TextField.setDataType(1);
        	kdtPreHouseEntrys_preHouseTare_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPreHouseEntrys_preHouseTare_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPreHouseEntrys_preHouseTare_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPreHouseEntrys_preHouseTare_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_preHouseTare_TextField);
        this.kdtPreHouseEntrys.getColumn("preHouseTare").setEditor(kdtPreHouseEntrys_preHouseTare_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_preHouseGross_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_preHouseGross_TextField.setName("kdtPreHouseEntrys_preHouseGross_TextField");
        kdtPreHouseEntrys_preHouseGross_TextField.setVisible(true);
        kdtPreHouseEntrys_preHouseGross_TextField.setEditable(true);
        kdtPreHouseEntrys_preHouseGross_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_preHouseGross_TextField.setDataType(1);
        	kdtPreHouseEntrys_preHouseGross_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPreHouseEntrys_preHouseGross_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPreHouseEntrys_preHouseGross_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPreHouseEntrys_preHouseGross_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_preHouseGross_TextField);
        this.kdtPreHouseEntrys.getColumn("preHouseGross").setEditor(kdtPreHouseEntrys_preHouseGross_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_preHouseSuttle_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_preHouseSuttle_TextField.setName("kdtPreHouseEntrys_preHouseSuttle_TextField");
        kdtPreHouseEntrys_preHouseSuttle_TextField.setVisible(true);
        kdtPreHouseEntrys_preHouseSuttle_TextField.setEditable(true);
        kdtPreHouseEntrys_preHouseSuttle_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_preHouseSuttle_TextField.setDataType(1);
        	kdtPreHouseEntrys_preHouseSuttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPreHouseEntrys_preHouseSuttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPreHouseEntrys_preHouseSuttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPreHouseEntrys_preHouseSuttle_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_preHouseSuttle_TextField);
        this.kdtPreHouseEntrys.getColumn("preHouseSuttle").setEditor(kdtPreHouseEntrys_preHouseSuttle_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_recQty_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_recQty_TextField.setName("kdtPreHouseEntrys_recQty_TextField");
        kdtPreHouseEntrys_recQty_TextField.setVisible(true);
        kdtPreHouseEntrys_recQty_TextField.setEditable(true);
        kdtPreHouseEntrys_recQty_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_recQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPreHouseEntrys_recQty_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_recQty_TextField);
        this.kdtPreHouseEntrys.getColumn("recQty").setEditor(kdtPreHouseEntrys_recQty_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_settleWgt_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_settleWgt_TextField.setName("kdtPreHouseEntrys_settleWgt_TextField");
        kdtPreHouseEntrys_settleWgt_TextField.setVisible(true);
        kdtPreHouseEntrys_settleWgt_TextField.setEditable(true);
        kdtPreHouseEntrys_settleWgt_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_settleWgt_TextField.setDataType(1);
        	kdtPreHouseEntrys_settleWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPreHouseEntrys_settleWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPreHouseEntrys_settleWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPreHouseEntrys_settleWgt_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_settleWgt_TextField);
        this.kdtPreHouseEntrys.getColumn("settleWgt").setEditor(kdtPreHouseEntrys_settleWgt_CellEditor);
        KDFormattedTextField kdtPreHouseEntrys_recSuttle_TextField = new KDFormattedTextField();
        kdtPreHouseEntrys_recSuttle_TextField.setName("kdtPreHouseEntrys_recSuttle_TextField");
        kdtPreHouseEntrys_recSuttle_TextField.setVisible(true);
        kdtPreHouseEntrys_recSuttle_TextField.setEditable(true);
        kdtPreHouseEntrys_recSuttle_TextField.setHorizontalAlignment(2);
        kdtPreHouseEntrys_recSuttle_TextField.setDataType(1);
        	kdtPreHouseEntrys_recSuttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPreHouseEntrys_recSuttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPreHouseEntrys_recSuttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPreHouseEntrys_recSuttle_CellEditor = new KDTDefaultCellEditor(kdtPreHouseEntrys_recSuttle_TextField);
        this.kdtPreHouseEntrys.getColumn("recSuttle").setEditor(kdtPreHouseEntrys_recSuttle_CellEditor);
        // kdtSeedSourceEntrys
		String kdtSeedSourceEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{lot}</t:Cell><t:Cell>$Resource{qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSeedSourceEntrys.setFormatXml(resHelper.translateString("kdtSeedSourceEntrys",kdtSeedSourceEntrysStrXML));

                this.kdtSeedSourceEntrys.putBindContents("editData",new String[] {"seq","storageOrgUnit","lot","qty"});


        this.kdtSeedSourceEntrys.checkParsed();
        KDFormattedTextField kdtSeedSourceEntrys_seq_TextField = new KDFormattedTextField();
        kdtSeedSourceEntrys_seq_TextField.setName("kdtSeedSourceEntrys_seq_TextField");
        kdtSeedSourceEntrys_seq_TextField.setVisible(true);
        kdtSeedSourceEntrys_seq_TextField.setEditable(true);
        kdtSeedSourceEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtSeedSourceEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSeedSourceEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtSeedSourceEntrys_seq_TextField);
        this.kdtSeedSourceEntrys.getColumn("seq").setEditor(kdtSeedSourceEntrys_seq_CellEditor);
        final KDBizPromptBox kdtSeedSourceEntrys_storageOrgUnit_PromptBox = new KDBizPromptBox();
        kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setVisible(true);
        kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setEditable(true);
        kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setEditFormat("$number$");
        kdtSeedSourceEntrys_storageOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSeedSourceEntrys_storageOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtSeedSourceEntrys_storageOrgUnit_PromptBox);
        this.kdtSeedSourceEntrys.getColumn("storageOrgUnit").setEditor(kdtSeedSourceEntrys_storageOrgUnit_CellEditor);
        ObjectValueRender kdtSeedSourceEntrys_storageOrgUnit_OVR = new ObjectValueRender();
        kdtSeedSourceEntrys_storageOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSeedSourceEntrys.getColumn("storageOrgUnit").setRenderer(kdtSeedSourceEntrys_storageOrgUnit_OVR);
        KDTextField kdtSeedSourceEntrys_lot_TextField = new KDTextField();
        kdtSeedSourceEntrys_lot_TextField.setName("kdtSeedSourceEntrys_lot_TextField");
        kdtSeedSourceEntrys_lot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSeedSourceEntrys_lot_CellEditor = new KDTDefaultCellEditor(kdtSeedSourceEntrys_lot_TextField);
        this.kdtSeedSourceEntrys.getColumn("lot").setEditor(kdtSeedSourceEntrys_lot_CellEditor);
        KDFormattedTextField kdtSeedSourceEntrys_qty_TextField = new KDFormattedTextField();
        kdtSeedSourceEntrys_qty_TextField.setName("kdtSeedSourceEntrys_qty_TextField");
        kdtSeedSourceEntrys_qty_TextField.setVisible(true);
        kdtSeedSourceEntrys_qty_TextField.setEditable(true);
        kdtSeedSourceEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtSeedSourceEntrys_qty_TextField.setDataType(1);
        	kdtSeedSourceEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedSourceEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedSourceEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedSourceEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtSeedSourceEntrys_qty_TextField);
        this.kdtSeedSourceEntrys.getColumn("qty").setEditor(kdtSeedSourceEntrys_qty_CellEditor);
        // txtchickenRetunAmt		
        this.txtchickenRetunAmt.setHorizontalAlignment(2);		
        this.txtchickenRetunAmt.setDataType(1);		
        this.txtchickenRetunAmt.setSupportedEmpty(true);		
        this.txtchickenRetunAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenRetunAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenRetunAmt.setPrecision(2);		
        this.txtchickenRetunAmt.setRequired(false);
        // txtbeforeBatchAmount		
        this.txtbeforeBatchAmount.setHorizontalAlignment(2);		
        this.txtbeforeBatchAmount.setDataType(1);		
        this.txtbeforeBatchAmount.setSupportedEmpty(true);		
        this.txtbeforeBatchAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbeforeBatchAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbeforeBatchAmount.setPrecision(2);		
        this.txtbeforeBatchAmount.setRequired(false);
        // txtidCodeCode		
        this.txtidCodeCode.setHorizontalAlignment(2);		
        this.txtidCodeCode.setMaxLength(100);		
        this.txtidCodeCode.setRequired(false);
        // txtfarmAddress		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(100);		
        this.txtfarmAddress.setRequired(false);
        // txtchickenSource		
        this.txtchickenSource.setHorizontalAlignment(2);		
        this.txtchickenSource.setMaxLength(200);		
        this.txtchickenSource.setRequired(false);		
        this.txtchickenSource.setEnabled(false);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(false);
        // txtoneMrgin		
        this.txtoneMrgin.setHorizontalAlignment(2);		
        this.txtoneMrgin.setDataType(1);		
        this.txtoneMrgin.setSupportedEmpty(true);		
        this.txtoneMrgin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoneMrgin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoneMrgin.setPrecision(10);		
        this.txtoneMrgin.setRequired(false);		
        this.txtoneMrgin.setEnabled(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);		
        this.prmtcostCenter.setEnabled(false);
        // txtdrugQty		
        this.txtdrugQty.setHorizontalAlignment(2);		
        this.txtdrugQty.setDataType(1);		
        this.txtdrugQty.setSupportedEmpty(true);		
        this.txtdrugQty.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtdrugQty.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtdrugQty.setPrecision(5);		
        this.txtdrugQty.setRequired(false);
        // txtfarmeronlyPro		
        this.txtfarmeronlyPro.setHorizontalAlignment(2);		
        this.txtfarmeronlyPro.setDataType(1);		
        this.txtfarmeronlyPro.setSupportedEmpty(true);		
        this.txtfarmeronlyPro.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfarmeronlyPro.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfarmeronlyPro.setPrecision(2);		
        this.txtfarmeronlyPro.setRequired(false);		
        this.txtfarmeronlyPro.setEnabled(false);
        // txtfarmerOnlyProOne		
        this.txtfarmerOnlyProOne.setHorizontalAlignment(2);		
        this.txtfarmerOnlyProOne.setDataType(1);		
        this.txtfarmerOnlyProOne.setSupportedEmpty(true);		
        this.txtfarmerOnlyProOne.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfarmerOnlyProOne.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfarmerOnlyProOne.setPrecision(2);		
        this.txtfarmerOnlyProOne.setRequired(false);		
        this.txtfarmerOnlyProOne.setEnabled(false);
        // txtproDiv		
        this.txtproDiv.setVisible(true);		
        this.txtproDiv.setHorizontalAlignment(2);		
        this.txtproDiv.setDataType(1);		
        this.txtproDiv.setSupportedEmpty(true);		
        this.txtproDiv.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtproDiv.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtproDiv.setPrecision(2);		
        this.txtproDiv.setRequired(false);
        // txtoccupyMargin		
        this.txtoccupyMargin.setHorizontalAlignment(2);		
        this.txtoccupyMargin.setDataType(1);		
        this.txtoccupyMargin.setSupportedEmpty(true);		
        this.txtoccupyMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoccupyMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoccupyMargin.setPrecision(2);		
        this.txtoccupyMargin.setRequired(false);		
        this.txtoccupyMargin.setEnabled(false);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"recType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"averageWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{recType}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{averageWgt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","recType","qty","weight","price","amount","averageWgt"});


        this.kdtEntrys.checkParsed();
        KDComboBox kdtEntrys_recType_ComboBox = new KDComboBox();
        kdtEntrys_recType_ComboBox.setName("kdtEntrys_recType_ComboBox");
        kdtEntrys_recType_ComboBox.setVisible(true);
        kdtEntrys_recType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.recyclebiz.RecType").toArray());
        KDTDefaultCellEditor kdtEntrys_recType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recType_ComboBox);
        this.kdtEntrys.getColumn("recType").setEditor(kdtEntrys_recType_CellEditor);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        KDFormattedTextField kdtEntrys_weight_TextField = new KDFormattedTextField();
        kdtEntrys_weight_TextField.setName("kdtEntrys_weight_TextField");
        kdtEntrys_weight_TextField.setVisible(true);
        kdtEntrys_weight_TextField.setEditable(true);
        kdtEntrys_weight_TextField.setHorizontalAlignment(2);
        kdtEntrys_weight_TextField.setDataType(1);
        	kdtEntrys_weight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_weight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_weight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_weight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weight_TextField);
        this.kdtEntrys.getColumn("weight").setEditor(kdtEntrys_weight_CellEditor);
        KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
        kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
        kdtEntrys_price_TextField.setVisible(true);
        kdtEntrys_price_TextField.setEditable(true);
        kdtEntrys_price_TextField.setHorizontalAlignment(2);
        kdtEntrys_price_TextField.setDataType(1);
        	kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        KDFormattedTextField kdtEntrys_averageWgt_TextField = new KDFormattedTextField();
        kdtEntrys_averageWgt_TextField.setName("kdtEntrys_averageWgt_TextField");
        kdtEntrys_averageWgt_TextField.setVisible(true);
        kdtEntrys_averageWgt_TextField.setEditable(true);
        kdtEntrys_averageWgt_TextField.setHorizontalAlignment(2);
        kdtEntrys_averageWgt_TextField.setDataType(1);
        	kdtEntrys_averageWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_averageWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_averageWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_averageWgt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_averageWgt_TextField);
        this.kdtEntrys.getColumn("averageWgt").setEditor(kdtEntrys_averageWgt_CellEditor);
        // chkisOrdinary		
        this.chkisOrdinary.setText(resHelper.getString("chkisOrdinary.text"));		
        this.chkisOrdinary.setHorizontalAlignment(2);
        // kDTabbedPane2
        // kDPanel4
        // kDPanel5
        // kDPanel6
        // kDPanel7
        // kDPanel15
        // contmRatePAmt		
        this.contmRatePAmt.setBoundLabelText(resHelper.getString("contmRatePAmt.boundLabelText"));		
        this.contmRatePAmt.setBoundLabelLength(120);		
        this.contmRatePAmt.setBoundLabelUnderline(true);		
        this.contmRatePAmt.setVisible(true);
        // contactualMRate		
        this.contactualMRate.setBoundLabelText(resHelper.getString("contactualMRate.boundLabelText"));		
        this.contactualMRate.setBoundLabelLength(120);		
        this.contactualMRate.setBoundLabelUnderline(true);		
        this.contactualMRate.setVisible(true);
        // contstandardMRate		
        this.contstandardMRate.setBoundLabelText(resHelper.getString("contstandardMRate.boundLabelText"));		
        this.contstandardMRate.setBoundLabelLength(120);		
        this.contstandardMRate.setBoundLabelUnderline(true);		
        this.contstandardMRate.setVisible(true);
        // contdrugLackPAmt		
        this.contdrugLackPAmt.setBoundLabelText(resHelper.getString("contdrugLackPAmt.boundLabelText"));		
        this.contdrugLackPAmt.setBoundLabelLength(120);		
        this.contdrugLackPAmt.setBoundLabelUnderline(true);		
        this.contdrugLackPAmt.setVisible(true);
        // contsingleActualDrug		
        this.contsingleActualDrug.setBoundLabelText(resHelper.getString("contsingleActualDrug.boundLabelText"));		
        this.contsingleActualDrug.setBoundLabelLength(120);		
        this.contsingleActualDrug.setBoundLabelUnderline(true);		
        this.contsingleActualDrug.setVisible(true);
        // contsingleStandardDrug		
        this.contsingleStandardDrug.setBoundLabelText(resHelper.getString("contsingleStandardDrug.boundLabelText"));		
        this.contsingleStandardDrug.setBoundLabelLength(120);		
        this.contsingleStandardDrug.setBoundLabelUnderline(true);		
        this.contsingleStandardDrug.setVisible(true);
        // contmarginOccupyFee		
        this.contmarginOccupyFee.setBoundLabelText(resHelper.getString("contmarginOccupyFee.boundLabelText"));		
        this.contmarginOccupyFee.setBoundLabelLength(120);		
        this.contmarginOccupyFee.setBoundLabelUnderline(true);		
        this.contmarginOccupyFee.setVisible(true);
        // contbatchOccupyMargin		
        this.contbatchOccupyMargin.setBoundLabelText(resHelper.getString("contbatchOccupyMargin.boundLabelText"));		
        this.contbatchOccupyMargin.setBoundLabelLength(120);		
        this.contbatchOccupyMargin.setBoundLabelUnderline(true);		
        this.contbatchOccupyMargin.setVisible(true);
        // contstandardMargin		
        this.contstandardMargin.setBoundLabelText(resHelper.getString("contstandardMargin.boundLabelText"));		
        this.contstandardMargin.setBoundLabelLength(120);		
        this.contstandardMargin.setBoundLabelUnderline(true);		
        this.contstandardMargin.setVisible(true);
        // contsingleMargin		
        this.contsingleMargin.setBoundLabelText(resHelper.getString("contsingleMargin.boundLabelText"));		
        this.contsingleMargin.setBoundLabelLength(120);		
        this.contsingleMargin.setBoundLabelUnderline(true);		
        this.contsingleMargin.setVisible(true);
        // contconFeedSubsidies		
        this.contconFeedSubsidies.setBoundLabelText(resHelper.getString("contconFeedSubsidies.boundLabelText"));		
        this.contconFeedSubsidies.setBoundLabelLength(120);		
        this.contconFeedSubsidies.setBoundLabelUnderline(true);		
        this.contconFeedSubsidies.setVisible(true);
        // contkbConFeedPolicy		
        this.contkbConFeedPolicy.setBoundLabelText(resHelper.getString("contkbConFeedPolicy.boundLabelText"));		
        this.contkbConFeedPolicy.setBoundLabelLength(120);		
        this.contkbConFeedPolicy.setBoundLabelUnderline(true);		
        this.contkbConFeedPolicy.setVisible(true);
        // contcontractCKWgt		
        this.contcontractCKWgt.setBoundLabelText(resHelper.getString("contcontractCKWgt.boundLabelText"));		
        this.contcontractCKWgt.setBoundLabelLength(120);		
        this.contcontractCKWgt.setBoundLabelUnderline(true);		
        this.contcontractCKWgt.setVisible(true);
        // contfreightDiffSubsidies		
        this.contfreightDiffSubsidies.setBoundLabelText(resHelper.getString("contfreightDiffSubsidies.boundLabelText"));		
        this.contfreightDiffSubsidies.setBoundLabelLength(120);		
        this.contfreightDiffSubsidies.setBoundLabelUnderline(true);		
        this.contfreightDiffSubsidies.setVisible(true);
        // contlFeedWgt		
        this.contlFeedWgt.setBoundLabelText(resHelper.getString("contlFeedWgt.boundLabelText"));		
        this.contlFeedWgt.setBoundLabelLength(120);		
        this.contlFeedWgt.setBoundLabelUnderline(true);		
        this.contlFeedWgt.setVisible(true);
        // contfreightPrice		
        this.contfreightPrice.setBoundLabelText(resHelper.getString("contfreightPrice.boundLabelText"));		
        this.contfreightPrice.setBoundLabelLength(120);		
        this.contfreightPrice.setBoundLabelUnderline(true);		
        this.contfreightPrice.setVisible(true);
        // contfreightSubsidiesStd		
        this.contfreightSubsidiesStd.setBoundLabelText(resHelper.getString("contfreightSubsidiesStd.boundLabelText"));		
        this.contfreightSubsidiesStd.setBoundLabelLength(120);		
        this.contfreightSubsidiesStd.setBoundLabelUnderline(true);		
        this.contfreightSubsidiesStd.setVisible(true);
        // contdeductMargin		
        this.contdeductMargin.setBoundLabelText(resHelper.getString("contdeductMargin.boundLabelText"));		
        this.contdeductMargin.setBoundLabelLength(120);		
        this.contdeductMargin.setBoundLabelUnderline(true);		
        this.contdeductMargin.setVisible(true);
        // conttotalMargin		
        this.conttotalMargin.setBoundLabelText(resHelper.getString("conttotalMargin.boundLabelText"));		
        this.conttotalMargin.setBoundLabelLength(120);		
        this.conttotalMargin.setBoundLabelUnderline(true);		
        this.conttotalMargin.setVisible(true);
        // contenableMargin		
        this.contenableMargin.setBoundLabelText(resHelper.getString("contenableMargin.boundLabelText"));		
        this.contenableMargin.setBoundLabelLength(120);		
        this.contenableMargin.setBoundLabelUnderline(true);		
        this.contenableMargin.setVisible(true);
        // contdeductAdPayAmt		
        this.contdeductAdPayAmt.setBoundLabelText(resHelper.getString("contdeductAdPayAmt.boundLabelText"));		
        this.contdeductAdPayAmt.setBoundLabelLength(120);		
        this.contdeductAdPayAmt.setBoundLabelUnderline(true);		
        this.contdeductAdPayAmt.setVisible(true);
        // contloanRate		
        this.contloanRate.setBoundLabelText(resHelper.getString("contloanRate.boundLabelText"));		
        this.contloanRate.setBoundLabelLength(130);		
        this.contloanRate.setBoundLabelUnderline(true);		
        this.contloanRate.setVisible(true);
        // contkYFKOccupyFee		
        this.contkYFKOccupyFee.setBoundLabelText(resHelper.getString("contkYFKOccupyFee.boundLabelText"));		
        this.contkYFKOccupyFee.setBoundLabelLength(120);		
        this.contkYFKOccupyFee.setBoundLabelUnderline(true);		
        this.contkYFKOccupyFee.setVisible(true);
        // contfmRatePunishStd		
        this.contfmRatePunishStd.setBoundLabelText(resHelper.getString("contfmRatePunishStd.boundLabelText"));		
        this.contfmRatePunishStd.setBoundLabelLength(120);		
        this.contfmRatePunishStd.setBoundLabelUnderline(true);		
        this.contfmRatePunishStd.setVisible(true);
        // contdyfBalance		
        this.contdyfBalance.setBoundLabelText(resHelper.getString("contdyfBalance.boundLabelText"));		
        this.contdyfBalance.setBoundLabelLength(120);		
        this.contdyfBalance.setBoundLabelUnderline(true);		
        this.contdyfBalance.setVisible(true);
        // contmoneyOccupyDays		
        this.contmoneyOccupyDays.setBoundLabelText(resHelper.getString("contmoneyOccupyDays.boundLabelText"));		
        this.contmoneyOccupyDays.setBoundLabelLength(120);		
        this.contmoneyOccupyDays.setBoundLabelUnderline(true);		
        this.contmoneyOccupyDays.setVisible(true);
        // contconFeedPolicySub		
        this.contconFeedPolicySub.setBoundLabelText(resHelper.getString("contconFeedPolicySub.boundLabelText"));		
        this.contconFeedPolicySub.setBoundLabelLength(120);		
        this.contconFeedPolicySub.setBoundLabelUnderline(true);		
        this.contconFeedPolicySub.setVisible(true);
        // contpayOweMonery		
        this.contpayOweMonery.setBoundLabelText(resHelper.getString("contpayOweMonery.boundLabelText"));		
        this.contpayOweMonery.setBoundLabelLength(120);		
        this.contpayOweMonery.setBoundLabelUnderline(true);		
        this.contpayOweMonery.setVisible(true);
        // contoutSaleKbAmt		
        this.contoutSaleKbAmt.setBoundLabelText(resHelper.getString("contoutSaleKbAmt.boundLabelText"));		
        this.contoutSaleKbAmt.setBoundLabelLength(120);		
        this.contoutSaleKbAmt.setBoundLabelUnderline(true);		
        this.contoutSaleKbAmt.setVisible(true);
        // contunLockedMargin		
        this.contunLockedMargin.setBoundLabelText(resHelper.getString("contunLockedMargin.boundLabelText"));		
        this.contunLockedMargin.setBoundLabelLength(120);		
        this.contunLockedMargin.setBoundLabelUnderline(true);		
        this.contunLockedMargin.setVisible(true);
        // contadPayBalance		
        this.contadPayBalance.setBoundLabelText(resHelper.getString("contadPayBalance.boundLabelText"));		
        this.contadPayBalance.setBoundLabelLength(120);		
        this.contadPayBalance.setBoundLabelUnderline(true);		
        this.contadPayBalance.setVisible(true);
        // contQCKbDetail		
        this.contQCKbDetail.setBoundLabelText(resHelper.getString("contQCKbDetail.boundLabelText"));		
        this.contQCKbDetail.setBoundLabelLength(100);		
        this.contQCKbDetail.setBoundLabelUnderline(true);		
        this.contQCKbDetail.setVisible(true);
        // contotherKbDetail		
        this.contotherKbDetail.setBoundLabelText(resHelper.getString("contotherKbDetail.boundLabelText"));		
        this.contotherKbDetail.setBoundLabelLength(100);		
        this.contotherKbDetail.setBoundLabelUnderline(true);		
        this.contotherKbDetail.setVisible(true);
        // contimmuneCost		
        this.contimmuneCost.setBoundLabelText(resHelper.getString("contimmuneCost.boundLabelText"));		
        this.contimmuneCost.setBoundLabelLength(120);		
        this.contimmuneCost.setBoundLabelUnderline(true);		
        this.contimmuneCost.setVisible(true);
        // contimmuneCostOne		
        this.contimmuneCostOne.setBoundLabelText(resHelper.getString("contimmuneCostOne.boundLabelText"));		
        this.contimmuneCostOne.setBoundLabelLength(120);		
        this.contimmuneCostOne.setBoundLabelUnderline(true);		
        this.contimmuneCostOne.setVisible(true);
        // contcleanHouse		
        this.contcleanHouse.setBoundLabelText(resHelper.getString("contcleanHouse.boundLabelText"));		
        this.contcleanHouse.setBoundLabelLength(120);		
        this.contcleanHouse.setBoundLabelUnderline(true);		
        this.contcleanHouse.setVisible(false);
        // contcleanHouseOne		
        this.contcleanHouseOne.setBoundLabelText(resHelper.getString("contcleanHouseOne.boundLabelText"));		
        this.contcleanHouseOne.setBoundLabelLength(120);		
        this.contcleanHouseOne.setBoundLabelUnderline(true);		
        this.contcleanHouseOne.setVisible(false);
        // contactualFoder		
        this.contactualFoder.setBoundLabelText(resHelper.getString("contactualFoder.boundLabelText"));		
        this.contactualFoder.setBoundLabelLength(120);		
        this.contactualFoder.setBoundLabelUnderline(true);		
        this.contactualFoder.setVisible(true);
        // contstandFodder		
        this.contstandFodder.setBoundLabelText(resHelper.getString("contstandFodder.boundLabelText"));		
        this.contstandFodder.setBoundLabelLength(120);		
        this.contstandFodder.setBoundLabelUnderline(true);		
        this.contstandFodder.setVisible(true);
        // chknoCalFodderPunish		
        this.chknoCalFodderPunish.setText(resHelper.getString("chknoCalFodderPunish.text"));		
        this.chknoCalFodderPunish.setHorizontalAlignment(2);
        // chknoCalDrupPunish		
        this.chknoCalDrupPunish.setText(resHelper.getString("chknoCalDrupPunish.text"));		
        this.chknoCalDrupPunish.setHorizontalAlignment(2);
        // txtmRatePAmt		
        this.txtmRatePAmt.setHorizontalAlignment(2);		
        this.txtmRatePAmt.setDataType(1);		
        this.txtmRatePAmt.setSupportedEmpty(true);		
        this.txtmRatePAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmRatePAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmRatePAmt.setPrecision(2);		
        this.txtmRatePAmt.setRequired(false);		
        this.txtmRatePAmt.setEnabled(false);
        // txtactualMRate		
        this.txtactualMRate.setHorizontalAlignment(2);		
        this.txtactualMRate.setDataType(1);		
        this.txtactualMRate.setSupportedEmpty(true);		
        this.txtactualMRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualMRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualMRate.setPrecision(4);		
        this.txtactualMRate.setRequired(false);		
        this.txtactualMRate.setEnabled(false);
        // txtstandardMRate		
        this.txtstandardMRate.setHorizontalAlignment(2);		
        this.txtstandardMRate.setDataType(1);		
        this.txtstandardMRate.setSupportedEmpty(true);		
        this.txtstandardMRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardMRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardMRate.setPrecision(4);		
        this.txtstandardMRate.setRequired(false);		
        this.txtstandardMRate.setEnabled(false);
        // txtdrugLackPAmt		
        this.txtdrugLackPAmt.setHorizontalAlignment(2);		
        this.txtdrugLackPAmt.setDataType(1);		
        this.txtdrugLackPAmt.setSupportedEmpty(true);		
        this.txtdrugLackPAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugLackPAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugLackPAmt.setPrecision(2);		
        this.txtdrugLackPAmt.setRequired(false);		
        this.txtdrugLackPAmt.setEnabled(false);
        // txtsingleActualDrug		
        this.txtsingleActualDrug.setHorizontalAlignment(2);		
        this.txtsingleActualDrug.setDataType(1);		
        this.txtsingleActualDrug.setSupportedEmpty(true);		
        this.txtsingleActualDrug.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleActualDrug.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleActualDrug.setPrecision(4);		
        this.txtsingleActualDrug.setRequired(false);		
        this.txtsingleActualDrug.setEnabled(false);
        // txtsingleStandardDrug		
        this.txtsingleStandardDrug.setHorizontalAlignment(2);		
        this.txtsingleStandardDrug.setDataType(1);		
        this.txtsingleStandardDrug.setSupportedEmpty(true);		
        this.txtsingleStandardDrug.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleStandardDrug.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleStandardDrug.setPrecision(4);		
        this.txtsingleStandardDrug.setRequired(false);		
        this.txtsingleStandardDrug.setEnabled(false);
        // txtmarginOccupyFee		
        this.txtmarginOccupyFee.setHorizontalAlignment(2);		
        this.txtmarginOccupyFee.setDataType(1);		
        this.txtmarginOccupyFee.setSupportedEmpty(true);		
        this.txtmarginOccupyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginOccupyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginOccupyFee.setPrecision(2);		
        this.txtmarginOccupyFee.setRequired(false);		
        this.txtmarginOccupyFee.setEnabled(false);
        // txtbatchOccupyMargin		
        this.txtbatchOccupyMargin.setHorizontalAlignment(2);		
        this.txtbatchOccupyMargin.setDataType(1);		
        this.txtbatchOccupyMargin.setSupportedEmpty(true);		
        this.txtbatchOccupyMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchOccupyMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchOccupyMargin.setPrecision(2);		
        this.txtbatchOccupyMargin.setRequired(false);		
        this.txtbatchOccupyMargin.setEnabled(false);
        // txtstandardMargin		
        this.txtstandardMargin.setHorizontalAlignment(2);		
        this.txtstandardMargin.setDataType(1);		
        this.txtstandardMargin.setSupportedEmpty(true);		
        this.txtstandardMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardMargin.setPrecision(2);		
        this.txtstandardMargin.setRequired(false);		
        this.txtstandardMargin.setEnabled(false);
        // txtsingleMargin		
        this.txtsingleMargin.setHorizontalAlignment(2);		
        this.txtsingleMargin.setDataType(1);		
        this.txtsingleMargin.setSupportedEmpty(true);		
        this.txtsingleMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleMargin.setPrecision(2);		
        this.txtsingleMargin.setRequired(false);		
        this.txtsingleMargin.setEnabled(false);
        // txtconFeedSubsidies		
        this.txtconFeedSubsidies.setHorizontalAlignment(2);		
        this.txtconFeedSubsidies.setDataType(1);		
        this.txtconFeedSubsidies.setSupportedEmpty(true);		
        this.txtconFeedSubsidies.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtconFeedSubsidies.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtconFeedSubsidies.setPrecision(2);		
        this.txtconFeedSubsidies.setRequired(false);		
        this.txtconFeedSubsidies.setEnabled(false);
        // prmtkbConFeedPolicy		
        this.prmtkbConFeedPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.ConFeedPolicyQuery");		
        this.prmtkbConFeedPolicy.setEditable(true);		
        this.prmtkbConFeedPolicy.setDisplayFormat("$name$");		
        this.prmtkbConFeedPolicy.setEditFormat("$number$");		
        this.prmtkbConFeedPolicy.setCommitFormat("$number$");		
        this.prmtkbConFeedPolicy.setRequired(false);
        		EntityViewInfo eviprmtkbConFeedPolicy = new EntityViewInfo ();
		eviprmtkbConFeedPolicy.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtkbConFeedPolicy.setEntityViewInfo(eviprmtkbConFeedPolicy);
					
        		prmtkbConFeedPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI prmtkbConFeedPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtkbConFeedPolicy_F7ListUI == null) {
					try {
						prmtkbConFeedPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtkbConFeedPolicy_F7ListUI));
					prmtkbConFeedPolicy_F7ListUI.setF7Use(true,ctx);
					prmtkbConFeedPolicy.setSelector(prmtkbConFeedPolicy_F7ListUI);
				}
			}
		});
					
        prmtkbConFeedPolicy.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtkbConFeedPolicy_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtcontractCKWgt		
        this.txtcontractCKWgt.setHorizontalAlignment(2);		
        this.txtcontractCKWgt.setDataType(1);		
        this.txtcontractCKWgt.setSupportedEmpty(true);		
        this.txtcontractCKWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractCKWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractCKWgt.setPrecision(4);		
        this.txtcontractCKWgt.setRequired(false);		
        this.txtcontractCKWgt.setEnabled(false);
        // txtfreightDiffSubsidies		
        this.txtfreightDiffSubsidies.setHorizontalAlignment(2);		
        this.txtfreightDiffSubsidies.setDataType(1);		
        this.txtfreightDiffSubsidies.setSupportedEmpty(true);		
        this.txtfreightDiffSubsidies.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreightDiffSubsidies.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreightDiffSubsidies.setPrecision(2);		
        this.txtfreightDiffSubsidies.setRequired(false);		
        this.txtfreightDiffSubsidies.setEnabled(false);
        // txtlFeedWgt		
        this.txtlFeedWgt.setHorizontalAlignment(2);		
        this.txtlFeedWgt.setDataType(1);		
        this.txtlFeedWgt.setSupportedEmpty(true);		
        this.txtlFeedWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlFeedWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlFeedWgt.setPrecision(4);		
        this.txtlFeedWgt.setRequired(false);		
        this.txtlFeedWgt.setEnabled(false);
        // txtfreightPrice		
        this.txtfreightPrice.setHorizontalAlignment(2);		
        this.txtfreightPrice.setDataType(1);		
        this.txtfreightPrice.setSupportedEmpty(true);		
        this.txtfreightPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreightPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreightPrice.setPrecision(4);		
        this.txtfreightPrice.setRequired(false);
        // txtfreightSubsidiesStd		
        this.txtfreightSubsidiesStd.setHorizontalAlignment(2);		
        this.txtfreightSubsidiesStd.setDataType(1);		
        this.txtfreightSubsidiesStd.setSupportedEmpty(true);		
        this.txtfreightSubsidiesStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreightSubsidiesStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreightSubsidiesStd.setPrecision(2);		
        this.txtfreightSubsidiesStd.setRequired(false);		
        this.txtfreightSubsidiesStd.setEnabled(false);
        // txtdeductMargin		
        this.txtdeductMargin.setHorizontalAlignment(2);		
        this.txtdeductMargin.setDataType(1);		
        this.txtdeductMargin.setSupportedEmpty(true);		
        this.txtdeductMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdeductMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdeductMargin.setPrecision(2);		
        this.txtdeductMargin.setRequired(false);
        // txttotalMargin		
        this.txttotalMargin.setHorizontalAlignment(2);		
        this.txttotalMargin.setDataType(1);		
        this.txttotalMargin.setSupportedEmpty(true);		
        this.txttotalMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalMargin.setPrecision(2);		
        this.txttotalMargin.setRequired(false);		
        this.txttotalMargin.setEnabled(false);
        // txtenableMargin		
        this.txtenableMargin.setHorizontalAlignment(2);		
        this.txtenableMargin.setDataType(1);		
        this.txtenableMargin.setSupportedEmpty(true);		
        this.txtenableMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtenableMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtenableMargin.setPrecision(2);		
        this.txtenableMargin.setRequired(false);		
        this.txtenableMargin.setEnabled(false);
        // txtdeductAdPayAmt		
        this.txtdeductAdPayAmt.setHorizontalAlignment(2);		
        this.txtdeductAdPayAmt.setDataType(1);		
        this.txtdeductAdPayAmt.setSupportedEmpty(true);		
        this.txtdeductAdPayAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdeductAdPayAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdeductAdPayAmt.setPrecision(2);		
        this.txtdeductAdPayAmt.setRequired(false);
        // txtloanRate		
        this.txtloanRate.setHorizontalAlignment(2);		
        this.txtloanRate.setDataType(1);		
        this.txtloanRate.setSupportedEmpty(true);		
        this.txtloanRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtloanRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtloanRate.setPrecision(4);		
        this.txtloanRate.setRequired(false);		
        this.txtloanRate.setEnabled(false);
        // txtkYFKOccupyFee		
        this.txtkYFKOccupyFee.setHorizontalAlignment(2);		
        this.txtkYFKOccupyFee.setDataType(1);		
        this.txtkYFKOccupyFee.setSupportedEmpty(true);		
        this.txtkYFKOccupyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkYFKOccupyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkYFKOccupyFee.setPrecision(2);		
        this.txtkYFKOccupyFee.setRequired(false);		
        this.txtkYFKOccupyFee.setEnabled(false);
        // txtfmRatePunishStd		
        this.txtfmRatePunishStd.setHorizontalAlignment(2);		
        this.txtfmRatePunishStd.setDataType(1);		
        this.txtfmRatePunishStd.setSupportedEmpty(true);		
        this.txtfmRatePunishStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfmRatePunishStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfmRatePunishStd.setPrecision(2);		
        this.txtfmRatePunishStd.setRequired(false);		
        this.txtfmRatePunishStd.setEnabled(false);
        // txtdyfBalance		
        this.txtdyfBalance.setHorizontalAlignment(2);		
        this.txtdyfBalance.setDataType(1);		
        this.txtdyfBalance.setSupportedEmpty(true);		
        this.txtdyfBalance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdyfBalance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdyfBalance.setPrecision(2);		
        this.txtdyfBalance.setRequired(false);
        // txtmoneyOccupyDays		
        this.txtmoneyOccupyDays.setHorizontalAlignment(2);		
        this.txtmoneyOccupyDays.setDataType(0);		
        this.txtmoneyOccupyDays.setSupportedEmpty(true);		
        this.txtmoneyOccupyDays.setRequired(false);
        // txtconFeedPolicySub		
        this.txtconFeedPolicySub.setHorizontalAlignment(2);		
        this.txtconFeedPolicySub.setDataType(1);		
        this.txtconFeedPolicySub.setSupportedEmpty(true);		
        this.txtconFeedPolicySub.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtconFeedPolicySub.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtconFeedPolicySub.setPrecision(4);		
        this.txtconFeedPolicySub.setRequired(false);		
        this.txtconFeedPolicySub.setEnabled(false);
        // txtpayOweMonery		
        this.txtpayOweMonery.setHorizontalAlignment(2);		
        this.txtpayOweMonery.setDataType(1);		
        this.txtpayOweMonery.setSupportedEmpty(true);		
        this.txtpayOweMonery.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpayOweMonery.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpayOweMonery.setPrecision(2);		
        this.txtpayOweMonery.setRequired(false);
        // txtoutSaleKbAmt		
        this.txtoutSaleKbAmt.setHorizontalAlignment(2);		
        this.txtoutSaleKbAmt.setDataType(1);		
        this.txtoutSaleKbAmt.setSupportedEmpty(true);		
        this.txtoutSaleKbAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoutSaleKbAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoutSaleKbAmt.setPrecision(2);		
        this.txtoutSaleKbAmt.setRequired(false);
        // txtunLockedMargin		
        this.txtunLockedMargin.setHorizontalAlignment(2);		
        this.txtunLockedMargin.setDataType(1);		
        this.txtunLockedMargin.setSupportedEmpty(true);		
        this.txtunLockedMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunLockedMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunLockedMargin.setPrecision(2);		
        this.txtunLockedMargin.setRequired(false);		
        this.txtunLockedMargin.setEnabled(false);
        // txtadPayBalance		
        this.txtadPayBalance.setHorizontalAlignment(2);		
        this.txtadPayBalance.setDataType(1);		
        this.txtadPayBalance.setSupportedEmpty(true);		
        this.txtadPayBalance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtadPayBalance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtadPayBalance.setPrecision(2);		
        this.txtadPayBalance.setRequired(false);
        // scrollPaneQCKbDetail
        // txtQCKbDetail		
        this.txtQCKbDetail.setRequired(false);		
        this.txtQCKbDetail.setMaxLength(255);		
        this.txtQCKbDetail.setEnabled(false);
        // scrollPaneotherKbDetail
        // txtotherKbDetail		
        this.txtotherKbDetail.setRequired(false);		
        this.txtotherKbDetail.setMaxLength(255);		
        this.txtotherKbDetail.setEnabled(false);
        // txtimmuneCost		
        this.txtimmuneCost.setHorizontalAlignment(2);		
        this.txtimmuneCost.setDataType(1);		
        this.txtimmuneCost.setSupportedEmpty(true);		
        this.txtimmuneCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimmuneCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimmuneCost.setPrecision(10);		
        this.txtimmuneCost.setRequired(false);		
        this.txtimmuneCost.setEnabled(false);
        // txtimmuneCostOne		
        this.txtimmuneCostOne.setHorizontalAlignment(2);		
        this.txtimmuneCostOne.setDataType(1);		
        this.txtimmuneCostOne.setSupportedEmpty(true);		
        this.txtimmuneCostOne.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimmuneCostOne.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimmuneCostOne.setPrecision(10);		
        this.txtimmuneCostOne.setRequired(false);		
        this.txtimmuneCostOne.setEnabled(false);
        // txtcleanHouse		
        this.txtcleanHouse.setHorizontalAlignment(2);		
        this.txtcleanHouse.setDataType(1);		
        this.txtcleanHouse.setSupportedEmpty(true);		
        this.txtcleanHouse.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcleanHouse.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcleanHouse.setPrecision(10);		
        this.txtcleanHouse.setRequired(false);		
        this.txtcleanHouse.setEnabled(false);		
        this.txtcleanHouse.setVisible(false);
        // txtcleanHouseOne		
        this.txtcleanHouseOne.setHorizontalAlignment(2);		
        this.txtcleanHouseOne.setDataType(1);		
        this.txtcleanHouseOne.setSupportedEmpty(true);		
        this.txtcleanHouseOne.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcleanHouseOne.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcleanHouseOne.setPrecision(10);		
        this.txtcleanHouseOne.setRequired(false);		
        this.txtcleanHouseOne.setEnabled(false);		
        this.txtcleanHouseOne.setVisible(false);
        // txtactualFoder		
        this.txtactualFoder.setHorizontalAlignment(2);		
        this.txtactualFoder.setDataType(1);		
        this.txtactualFoder.setSupportedEmpty(true);		
        this.txtactualFoder.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualFoder.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualFoder.setPrecision(10);		
        this.txtactualFoder.setRequired(false);		
        this.txtactualFoder.setEnabled(false);
        // txtstandFodder		
        this.txtstandFodder.setHorizontalAlignment(2);		
        this.txtstandFodder.setDataType(1);		
        this.txtstandFodder.setSupportedEmpty(true);		
        this.txtstandFodder.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandFodder.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandFodder.setPrecision(10);		
        this.txtstandFodder.setRequired(false);		
        this.txtstandFodder.setEnabled(false);
        // kdtQCEntrys
		String kdtQCEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"QCItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"randPType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"actualRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"punishAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"actualWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"punishWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{QCItem}</t:Cell><t:Cell>$Resource{randPType}</t:Cell><t:Cell>$Resource{actualRate}</t:Cell><t:Cell>$Resource{punishAmt}</t:Cell><t:Cell>$Resource{actualWgt}</t:Cell><t:Cell>$Resource{punishWgt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtQCEntrys.setFormatXml(resHelper.translateString("kdtQCEntrys",kdtQCEntrysStrXML));

                this.kdtQCEntrys.putBindContents("editData",new String[] {"seq","billNumber","QCItem","randPType","actualRate","punishAmt","actualWgt","punishWgt"});


        this.kdtQCEntrys.checkParsed();
        KDFormattedTextField kdtQCEntrys_seq_TextField = new KDFormattedTextField();
        kdtQCEntrys_seq_TextField.setName("kdtQCEntrys_seq_TextField");
        kdtQCEntrys_seq_TextField.setVisible(true);
        kdtQCEntrys_seq_TextField.setEditable(true);
        kdtQCEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtQCEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_seq_TextField);
        this.kdtQCEntrys.getColumn("seq").setEditor(kdtQCEntrys_seq_CellEditor);
        KDTextField kdtQCEntrys_billNumber_TextField = new KDTextField();
        kdtQCEntrys_billNumber_TextField.setName("kdtQCEntrys_billNumber_TextField");
        kdtQCEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtQCEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_billNumber_TextField);
        this.kdtQCEntrys.getColumn("billNumber").setEditor(kdtQCEntrys_billNumber_CellEditor);
        final KDBizPromptBox kdtQCEntrys_QCItem_PromptBox = new KDBizPromptBox();
        kdtQCEntrys_QCItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.RewardAndPunishItemQuery");
        kdtQCEntrys_QCItem_PromptBox.setVisible(true);
        kdtQCEntrys_QCItem_PromptBox.setEditable(true);
        kdtQCEntrys_QCItem_PromptBox.setDisplayFormat("$number$");
        kdtQCEntrys_QCItem_PromptBox.setEditFormat("$number$");
        kdtQCEntrys_QCItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtQCEntrys_QCItem_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_QCItem_PromptBox);
        this.kdtQCEntrys.getColumn("QCItem").setEditor(kdtQCEntrys_QCItem_CellEditor);
        ObjectValueRender kdtQCEntrys_QCItem_OVR = new ObjectValueRender();
        kdtQCEntrys_QCItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtQCEntrys.getColumn("QCItem").setRenderer(kdtQCEntrys_QCItem_OVR);
        			EntityViewInfo evikdtQCEntrys_QCItem_PromptBox = new EntityViewInfo ();
		evikdtQCEntrys_QCItem_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtQCEntrys_QCItem_PromptBox.setEntityViewInfo(evikdtQCEntrys_QCItem_PromptBox);
					
        KDComboBox kdtQCEntrys_randPType_ComboBox = new KDComboBox();
        kdtQCEntrys_randPType_ComboBox.setName("kdtQCEntrys_randPType_ComboBox");
        kdtQCEntrys_randPType_ComboBox.setVisible(true);
        kdtQCEntrys_randPType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.PunishType").toArray());
        KDTDefaultCellEditor kdtQCEntrys_randPType_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_randPType_ComboBox);
        this.kdtQCEntrys.getColumn("randPType").setEditor(kdtQCEntrys_randPType_CellEditor);
        KDFormattedTextField kdtQCEntrys_actualRate_TextField = new KDFormattedTextField();
        kdtQCEntrys_actualRate_TextField.setName("kdtQCEntrys_actualRate_TextField");
        kdtQCEntrys_actualRate_TextField.setVisible(true);
        kdtQCEntrys_actualRate_TextField.setEditable(true);
        kdtQCEntrys_actualRate_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_actualRate_TextField.setDataType(1);
        	kdtQCEntrys_actualRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_actualRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_actualRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_actualRate_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_actualRate_TextField);
        this.kdtQCEntrys.getColumn("actualRate").setEditor(kdtQCEntrys_actualRate_CellEditor);
        KDFormattedTextField kdtQCEntrys_punishAmt_TextField = new KDFormattedTextField();
        kdtQCEntrys_punishAmt_TextField.setName("kdtQCEntrys_punishAmt_TextField");
        kdtQCEntrys_punishAmt_TextField.setVisible(true);
        kdtQCEntrys_punishAmt_TextField.setEditable(true);
        kdtQCEntrys_punishAmt_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_punishAmt_TextField.setDataType(1);
        	kdtQCEntrys_punishAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_punishAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_punishAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_punishAmt_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_punishAmt_TextField);
        this.kdtQCEntrys.getColumn("punishAmt").setEditor(kdtQCEntrys_punishAmt_CellEditor);
        KDFormattedTextField kdtQCEntrys_actualWgt_TextField = new KDFormattedTextField();
        kdtQCEntrys_actualWgt_TextField.setName("kdtQCEntrys_actualWgt_TextField");
        kdtQCEntrys_actualWgt_TextField.setVisible(true);
        kdtQCEntrys_actualWgt_TextField.setEditable(true);
        kdtQCEntrys_actualWgt_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_actualWgt_TextField.setDataType(1);
        	kdtQCEntrys_actualWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_actualWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_actualWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_actualWgt_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_actualWgt_TextField);
        this.kdtQCEntrys.getColumn("actualWgt").setEditor(kdtQCEntrys_actualWgt_CellEditor);
        KDFormattedTextField kdtQCEntrys_punishWgt_TextField = new KDFormattedTextField();
        kdtQCEntrys_punishWgt_TextField.setName("kdtQCEntrys_punishWgt_TextField");
        kdtQCEntrys_punishWgt_TextField.setVisible(true);
        kdtQCEntrys_punishWgt_TextField.setEditable(true);
        kdtQCEntrys_punishWgt_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_punishWgt_TextField.setDataType(1);
        	kdtQCEntrys_punishWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_punishWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_punishWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_punishWgt_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_punishWgt_TextField);
        this.kdtQCEntrys.getColumn("punishWgt").setEditor(kdtQCEntrys_punishWgt_CellEditor);
        // kdtViewReqEntrys
		String kdtViewReqEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"viewType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"auditAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{viewType}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{auditAmt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtViewReqEntrys.setFormatXml(resHelper.translateString("kdtViewReqEntrys",kdtViewReqEntrysStrXML));

                this.kdtViewReqEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","viewType","amount","auditAmt"});


        this.kdtViewReqEntrys.checkParsed();
        KDFormattedTextField kdtViewReqEntrys_seq_TextField = new KDFormattedTextField();
        kdtViewReqEntrys_seq_TextField.setName("kdtViewReqEntrys_seq_TextField");
        kdtViewReqEntrys_seq_TextField.setVisible(true);
        kdtViewReqEntrys_seq_TextField.setEditable(true);
        kdtViewReqEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtViewReqEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtViewReqEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_seq_TextField);
        this.kdtViewReqEntrys.getColumn("seq").setEditor(kdtViewReqEntrys_seq_CellEditor);
        KDDatePicker kdtViewReqEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtViewReqEntrys_bizDate_DatePicker.setName("kdtViewReqEntrys_bizDate_DatePicker");
        kdtViewReqEntrys_bizDate_DatePicker.setVisible(true);
        kdtViewReqEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtViewReqEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_bizDate_DatePicker);
        this.kdtViewReqEntrys.getColumn("bizDate").setEditor(kdtViewReqEntrys_bizDate_CellEditor);
        KDTextField kdtViewReqEntrys_billNumber_TextField = new KDTextField();
        kdtViewReqEntrys_billNumber_TextField.setName("kdtViewReqEntrys_billNumber_TextField");
        kdtViewReqEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtViewReqEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_billNumber_TextField);
        this.kdtViewReqEntrys.getColumn("billNumber").setEditor(kdtViewReqEntrys_billNumber_CellEditor);
        KDComboBox kdtViewReqEntrys_billStatus_ComboBox = new KDComboBox();
        kdtViewReqEntrys_billStatus_ComboBox.setName("kdtViewReqEntrys_billStatus_ComboBox");
        kdtViewReqEntrys_billStatus_ComboBox.setVisible(true);
        kdtViewReqEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtViewReqEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_billStatus_ComboBox);
        this.kdtViewReqEntrys.getColumn("billStatus").setEditor(kdtViewReqEntrys_billStatus_CellEditor);
        final KDBizPromptBox kdtViewReqEntrys_viewType_PromptBox = new KDBizPromptBox();
        kdtViewReqEntrys_viewType_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.CustomerViewTypeQuery");
        kdtViewReqEntrys_viewType_PromptBox.setVisible(true);
        kdtViewReqEntrys_viewType_PromptBox.setEditable(true);
        kdtViewReqEntrys_viewType_PromptBox.setDisplayFormat("$number$");
        kdtViewReqEntrys_viewType_PromptBox.setEditFormat("$number$");
        kdtViewReqEntrys_viewType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtViewReqEntrys_viewType_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_viewType_PromptBox);
        this.kdtViewReqEntrys.getColumn("viewType").setEditor(kdtViewReqEntrys_viewType_CellEditor);
        ObjectValueRender kdtViewReqEntrys_viewType_OVR = new ObjectValueRender();
        kdtViewReqEntrys_viewType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtViewReqEntrys.getColumn("viewType").setRenderer(kdtViewReqEntrys_viewType_OVR);
        			EntityViewInfo evikdtViewReqEntrys_viewType_PromptBox = new EntityViewInfo ();
		evikdtViewReqEntrys_viewType_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtViewReqEntrys_viewType_PromptBox.setEntityViewInfo(evikdtViewReqEntrys_viewType_PromptBox);
					
        KDFormattedTextField kdtViewReqEntrys_amount_TextField = new KDFormattedTextField();
        kdtViewReqEntrys_amount_TextField.setName("kdtViewReqEntrys_amount_TextField");
        kdtViewReqEntrys_amount_TextField.setVisible(true);
        kdtViewReqEntrys_amount_TextField.setEditable(true);
        kdtViewReqEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtViewReqEntrys_amount_TextField.setDataType(1);
        	kdtViewReqEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtViewReqEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtViewReqEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtViewReqEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_amount_TextField);
        this.kdtViewReqEntrys.getColumn("amount").setEditor(kdtViewReqEntrys_amount_CellEditor);
        KDFormattedTextField kdtViewReqEntrys_auditAmt_TextField = new KDFormattedTextField();
        kdtViewReqEntrys_auditAmt_TextField.setName("kdtViewReqEntrys_auditAmt_TextField");
        kdtViewReqEntrys_auditAmt_TextField.setVisible(true);
        kdtViewReqEntrys_auditAmt_TextField.setEditable(true);
        kdtViewReqEntrys_auditAmt_TextField.setHorizontalAlignment(2);
        kdtViewReqEntrys_auditAmt_TextField.setDataType(1);
        	kdtViewReqEntrys_auditAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtViewReqEntrys_auditAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtViewReqEntrys_auditAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtViewReqEntrys_auditAmt_CellEditor = new KDTDefaultCellEditor(kdtViewReqEntrys_auditAmt_TextField);
        this.kdtViewReqEntrys.getColumn("auditAmt").setEditor(kdtViewReqEntrys_auditAmt_CellEditor);
        // kdtOtherEntrys
		String kdtOtherEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"suType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"rpType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{suType}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{rpType}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOtherEntrys.setFormatXml(resHelper.translateString("kdtOtherEntrys",kdtOtherEntrysStrXML));

                this.kdtOtherEntrys.putBindContents("editData",new String[] {"seq","suType","amount","rpType"});


        this.kdtOtherEntrys.checkParsed();
        KDFormattedTextField kdtOtherEntrys_seq_TextField = new KDFormattedTextField();
        kdtOtherEntrys_seq_TextField.setName("kdtOtherEntrys_seq_TextField");
        kdtOtherEntrys_seq_TextField.setVisible(true);
        kdtOtherEntrys_seq_TextField.setEditable(true);
        kdtOtherEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOtherEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_seq_TextField);
        this.kdtOtherEntrys.getColumn("seq").setEditor(kdtOtherEntrys_seq_CellEditor);
        final KDBizPromptBox kdtOtherEntrys_suType_PromptBox = new KDBizPromptBox();
        kdtOtherEntrys_suType_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SubsidyPolicyQuery");
        kdtOtherEntrys_suType_PromptBox.setVisible(true);
        kdtOtherEntrys_suType_PromptBox.setEditable(true);
        kdtOtherEntrys_suType_PromptBox.setDisplayFormat("$number$");
        kdtOtherEntrys_suType_PromptBox.setEditFormat("$number$");
        kdtOtherEntrys_suType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOtherEntrys_suType_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_suType_PromptBox);
        this.kdtOtherEntrys.getColumn("suType").setEditor(kdtOtherEntrys_suType_CellEditor);
        ObjectValueRender kdtOtherEntrys_suType_OVR = new ObjectValueRender();
        kdtOtherEntrys_suType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtOtherEntrys.getColumn("suType").setRenderer(kdtOtherEntrys_suType_OVR);
        			EntityViewInfo evikdtOtherEntrys_suType_PromptBox = new EntityViewInfo ();
		evikdtOtherEntrys_suType_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtOtherEntrys_suType_PromptBox.setEntityViewInfo(evikdtOtherEntrys_suType_PromptBox);
					
        			kdtOtherEntrys_suType_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SubsidyPolicyListUI kdtOtherEntrys_suType_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtOtherEntrys_suType_PromptBox_F7ListUI == null) {
					try {
						kdtOtherEntrys_suType_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SubsidyPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtOtherEntrys_suType_PromptBox_F7ListUI));
					kdtOtherEntrys_suType_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtOtherEntrys_suType_PromptBox.setSelector(kdtOtherEntrys_suType_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtOtherEntrys_amount_TextField = new KDFormattedTextField();
        kdtOtherEntrys_amount_TextField.setName("kdtOtherEntrys_amount_TextField");
        kdtOtherEntrys_amount_TextField.setVisible(true);
        kdtOtherEntrys_amount_TextField.setEditable(true);
        kdtOtherEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_amount_TextField.setDataType(1);
        	kdtOtherEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_amount_TextField);
        this.kdtOtherEntrys.getColumn("amount").setEditor(kdtOtherEntrys_amount_CellEditor);
        KDTextField kdtOtherEntrys_rpType_TextField = new KDTextField();
        kdtOtherEntrys_rpType_TextField.setName("kdtOtherEntrys_rpType_TextField");
        kdtOtherEntrys_rpType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOtherEntrys_rpType_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_rpType_TextField);
        this.kdtOtherEntrys.getColumn("rpType").setEditor(kdtOtherEntrys_rpType_CellEditor);
        // kdtTempPolicyEntrys
		String kdtTempPolicyEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"tempPolicy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dateRelate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"calUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"kbPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"kbAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{tempPolicy}</t:Cell><t:Cell>$Resource{materialType}</t:Cell><t:Cell>$Resource{dateRelate}</t:Cell><t:Cell>$Resource{beginDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{calUnit}</t:Cell><t:Cell>$Resource{kbPrice}</t:Cell><t:Cell>$Resource{kbAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTempPolicyEntrys.setFormatXml(resHelper.translateString("kdtTempPolicyEntrys",kdtTempPolicyEntrysStrXML));

                this.kdtTempPolicyEntrys.putBindContents("editData",new String[] {"seq","tempPolicy","materialType","dateRelate","beginDate","endDate","calUnit","kbPrice","kbAmount"});


        this.kdtTempPolicyEntrys.checkParsed();
        KDFormattedTextField kdtTempPolicyEntrys_seq_TextField = new KDFormattedTextField();
        kdtTempPolicyEntrys_seq_TextField.setName("kdtTempPolicyEntrys_seq_TextField");
        kdtTempPolicyEntrys_seq_TextField.setVisible(true);
        kdtTempPolicyEntrys_seq_TextField.setEditable(true);
        kdtTempPolicyEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtTempPolicyEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTempPolicyEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_seq_TextField);
        this.kdtTempPolicyEntrys.getColumn("seq").setEditor(kdtTempPolicyEntrys_seq_CellEditor);
        final KDBizPromptBox kdtTempPolicyEntrys_tempPolicy_PromptBox = new KDBizPromptBox();
        kdtTempPolicyEntrys_tempPolicy_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.TempPolicyQuery");
        kdtTempPolicyEntrys_tempPolicy_PromptBox.setVisible(true);
        kdtTempPolicyEntrys_tempPolicy_PromptBox.setEditable(true);
        kdtTempPolicyEntrys_tempPolicy_PromptBox.setDisplayFormat("$number$");
        kdtTempPolicyEntrys_tempPolicy_PromptBox.setEditFormat("$number$");
        kdtTempPolicyEntrys_tempPolicy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTempPolicyEntrys_tempPolicy_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_tempPolicy_PromptBox);
        this.kdtTempPolicyEntrys.getColumn("tempPolicy").setEditor(kdtTempPolicyEntrys_tempPolicy_CellEditor);
        ObjectValueRender kdtTempPolicyEntrys_tempPolicy_OVR = new ObjectValueRender();
        kdtTempPolicyEntrys_tempPolicy_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTempPolicyEntrys.getColumn("tempPolicy").setRenderer(kdtTempPolicyEntrys_tempPolicy_OVR);
        			EntityViewInfo evikdtTempPolicyEntrys_tempPolicy_PromptBox = new EntityViewInfo ();
		evikdtTempPolicyEntrys_tempPolicy_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtTempPolicyEntrys_tempPolicy_PromptBox.setEntityViewInfo(evikdtTempPolicyEntrys_tempPolicy_PromptBox);
					
        KDComboBox kdtTempPolicyEntrys_materialType_ComboBox = new KDComboBox();
        kdtTempPolicyEntrys_materialType_ComboBox.setName("kdtTempPolicyEntrys_materialType_ComboBox");
        kdtTempPolicyEntrys_materialType_ComboBox.setVisible(true);
        kdtTempPolicyEntrys_materialType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.MaterialType").toArray());
        KDTDefaultCellEditor kdtTempPolicyEntrys_materialType_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_materialType_ComboBox);
        this.kdtTempPolicyEntrys.getColumn("materialType").setEditor(kdtTempPolicyEntrys_materialType_CellEditor);
        KDComboBox kdtTempPolicyEntrys_dateRelate_ComboBox = new KDComboBox();
        kdtTempPolicyEntrys_dateRelate_ComboBox.setName("kdtTempPolicyEntrys_dateRelate_ComboBox");
        kdtTempPolicyEntrys_dateRelate_ComboBox.setVisible(true);
        kdtTempPolicyEntrys_dateRelate_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.DateRelate").toArray());
        KDTDefaultCellEditor kdtTempPolicyEntrys_dateRelate_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_dateRelate_ComboBox);
        this.kdtTempPolicyEntrys.getColumn("dateRelate").setEditor(kdtTempPolicyEntrys_dateRelate_CellEditor);
        KDDatePicker kdtTempPolicyEntrys_beginDate_DatePicker = new KDDatePicker();
        kdtTempPolicyEntrys_beginDate_DatePicker.setName("kdtTempPolicyEntrys_beginDate_DatePicker");
        kdtTempPolicyEntrys_beginDate_DatePicker.setVisible(true);
        kdtTempPolicyEntrys_beginDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtTempPolicyEntrys_beginDate_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_beginDate_DatePicker);
        this.kdtTempPolicyEntrys.getColumn("beginDate").setEditor(kdtTempPolicyEntrys_beginDate_CellEditor);
        KDDatePicker kdtTempPolicyEntrys_endDate_DatePicker = new KDDatePicker();
        kdtTempPolicyEntrys_endDate_DatePicker.setName("kdtTempPolicyEntrys_endDate_DatePicker");
        kdtTempPolicyEntrys_endDate_DatePicker.setVisible(true);
        kdtTempPolicyEntrys_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtTempPolicyEntrys_endDate_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_endDate_DatePicker);
        this.kdtTempPolicyEntrys.getColumn("endDate").setEditor(kdtTempPolicyEntrys_endDate_CellEditor);
        KDComboBox kdtTempPolicyEntrys_calUnit_ComboBox = new KDComboBox();
        kdtTempPolicyEntrys_calUnit_ComboBox.setName("kdtTempPolicyEntrys_calUnit_ComboBox");
        kdtTempPolicyEntrys_calUnit_ComboBox.setVisible(true);
        kdtTempPolicyEntrys_calUnit_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.CalUnit").toArray());
        KDTDefaultCellEditor kdtTempPolicyEntrys_calUnit_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_calUnit_ComboBox);
        this.kdtTempPolicyEntrys.getColumn("calUnit").setEditor(kdtTempPolicyEntrys_calUnit_CellEditor);
        KDFormattedTextField kdtTempPolicyEntrys_kbPrice_TextField = new KDFormattedTextField();
        kdtTempPolicyEntrys_kbPrice_TextField.setName("kdtTempPolicyEntrys_kbPrice_TextField");
        kdtTempPolicyEntrys_kbPrice_TextField.setVisible(true);
        kdtTempPolicyEntrys_kbPrice_TextField.setEditable(true);
        kdtTempPolicyEntrys_kbPrice_TextField.setHorizontalAlignment(2);
        kdtTempPolicyEntrys_kbPrice_TextField.setDataType(1);
        	kdtTempPolicyEntrys_kbPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtTempPolicyEntrys_kbPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtTempPolicyEntrys_kbPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtTempPolicyEntrys_kbPrice_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_kbPrice_TextField);
        this.kdtTempPolicyEntrys.getColumn("kbPrice").setEditor(kdtTempPolicyEntrys_kbPrice_CellEditor);
        KDFormattedTextField kdtTempPolicyEntrys_kbAmount_TextField = new KDFormattedTextField();
        kdtTempPolicyEntrys_kbAmount_TextField.setName("kdtTempPolicyEntrys_kbAmount_TextField");
        kdtTempPolicyEntrys_kbAmount_TextField.setVisible(true);
        kdtTempPolicyEntrys_kbAmount_TextField.setEditable(true);
        kdtTempPolicyEntrys_kbAmount_TextField.setHorizontalAlignment(2);
        kdtTempPolicyEntrys_kbAmount_TextField.setDataType(1);
        	kdtTempPolicyEntrys_kbAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtTempPolicyEntrys_kbAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtTempPolicyEntrys_kbAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtTempPolicyEntrys_kbAmount_CellEditor = new KDTDefaultCellEditor(kdtTempPolicyEntrys_kbAmount_TextField);
        this.kdtTempPolicyEntrys.getColumn("kbAmount").setEditor(kdtTempPolicyEntrys_kbAmount_CellEditor);
        // contSeedCost		
        this.contSeedCost.setBoundLabelText(resHelper.getString("contSeedCost.boundLabelText"));		
        this.contSeedCost.setBoundLabelLength(100);		
        this.contSeedCost.setBoundLabelUnderline(true);		
        this.contSeedCost.setVisible(true);
        // contfodderCost		
        this.contfodderCost.setBoundLabelText(resHelper.getString("contfodderCost.boundLabelText"));		
        this.contfodderCost.setBoundLabelLength(100);		
        this.contfodderCost.setBoundLabelUnderline(true);		
        this.contfodderCost.setVisible(true);
        // contdrugCost		
        this.contdrugCost.setBoundLabelText(resHelper.getString("contdrugCost.boundLabelText"));		
        this.contdrugCost.setBoundLabelLength(100);		
        this.contdrugCost.setBoundLabelUnderline(true);		
        this.contdrugCost.setVisible(true);		
        this.contdrugCost.setForeground(new java.awt.Color(0,0,0));
        // contallocateAmt		
        this.contallocateAmt.setBoundLabelText(resHelper.getString("contallocateAmt.boundLabelText"));		
        this.contallocateAmt.setBoundLabelLength(100);		
        this.contallocateAmt.setBoundLabelUnderline(true);		
        this.contallocateAmt.setVisible(true);
        // contunitCost		
        this.contunitCost.setBoundLabelText(resHelper.getString("contunitCost.boundLabelText"));		
        this.contunitCost.setBoundLabelLength(100);		
        this.contunitCost.setBoundLabelUnderline(true);		
        this.contunitCost.setVisible(true);
        // contallCost		
        this.contallCost.setBoundLabelText(resHelper.getString("contallCost.boundLabelText"));		
        this.contallCost.setBoundLabelLength(100);		
        this.contallCost.setBoundLabelUnderline(true);		
        this.contallCost.setVisible(true);		
        this.contallCost.setForeground(new java.awt.Color(0,0,0));
        // contdaiyFee		
        this.contdaiyFee.setBoundLabelText(resHelper.getString("contdaiyFee.boundLabelText"));		
        this.contdaiyFee.setBoundLabelLength(100);		
        this.contdaiyFee.setBoundLabelUnderline(true);		
        this.contdaiyFee.setVisible(true);
        // contcompanyProfit		
        this.contcompanyProfit.setBoundLabelText(resHelper.getString("contcompanyProfit.boundLabelText"));		
        this.contcompanyProfit.setBoundLabelLength(100);		
        this.contcompanyProfit.setBoundLabelUnderline(true);		
        this.contcompanyProfit.setVisible(true);
        // contotherMatCost		
        this.contotherMatCost.setBoundLabelText(resHelper.getString("contotherMatCost.boundLabelText"));		
        this.contotherMatCost.setBoundLabelLength(100);		
        this.contotherMatCost.setBoundLabelUnderline(true);		
        this.contotherMatCost.setVisible(true);
        // txtSeedCost		
        this.txtSeedCost.setHorizontalAlignment(2);		
        this.txtSeedCost.setDataType(1);		
        this.txtSeedCost.setSupportedEmpty(true);		
        this.txtSeedCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSeedCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSeedCost.setPrecision(2);		
        this.txtSeedCost.setRequired(false);		
        this.txtSeedCost.setEnabled(false);
        // txtfodderCost		
        this.txtfodderCost.setHorizontalAlignment(2);		
        this.txtfodderCost.setDataType(1);		
        this.txtfodderCost.setSupportedEmpty(true);		
        this.txtfodderCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfodderCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfodderCost.setPrecision(2);		
        this.txtfodderCost.setRequired(false);		
        this.txtfodderCost.setEnabled(false);
        // txtdrugCost		
        this.txtdrugCost.setHorizontalAlignment(2);		
        this.txtdrugCost.setDataType(1);		
        this.txtdrugCost.setSupportedEmpty(true);		
        this.txtdrugCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugCost.setPrecision(2);		
        this.txtdrugCost.setRequired(false);		
        this.txtdrugCost.setEnabled(false);
        // txtallocateAmt		
        this.txtallocateAmt.setHorizontalAlignment(2);		
        this.txtallocateAmt.setDataType(1);		
        this.txtallocateAmt.setSupportedEmpty(true);		
        this.txtallocateAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallocateAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallocateAmt.setPrecision(2);		
        this.txtallocateAmt.setRequired(false);		
        this.txtallocateAmt.setEnabled(false);
        // txtunitCost		
        this.txtunitCost.setHorizontalAlignment(2);		
        this.txtunitCost.setDataType(1);		
        this.txtunitCost.setSupportedEmpty(true);		
        this.txtunitCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitCost.setPrecision(2);		
        this.txtunitCost.setRequired(false);		
        this.txtunitCost.setEnabled(false);
        // txtallCost		
        this.txtallCost.setHorizontalAlignment(2);		
        this.txtallCost.setDataType(1);		
        this.txtallCost.setSupportedEmpty(true);		
        this.txtallCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallCost.setPrecision(2);		
        this.txtallCost.setRequired(false);		
        this.txtallCost.setEnabled(false);
        // txtdaiyFee		
        this.txtdaiyFee.setHorizontalAlignment(2);		
        this.txtdaiyFee.setDataType(1);		
        this.txtdaiyFee.setSupportedEmpty(true);		
        this.txtdaiyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdaiyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdaiyFee.setPrecision(2);		
        this.txtdaiyFee.setRequired(false);		
        this.txtdaiyFee.setEnabled(false);
        // txtcompanyProfit		
        this.txtcompanyProfit.setHorizontalAlignment(2);		
        this.txtcompanyProfit.setDataType(1);		
        this.txtcompanyProfit.setSupportedEmpty(true);		
        this.txtcompanyProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyProfit.setPrecision(2);		
        this.txtcompanyProfit.setRequired(false);		
        this.txtcompanyProfit.setEnabled(false);
        // txtotherMatCost		
        this.txtotherMatCost.setHorizontalAlignment(2);		
        this.txtotherMatCost.setDataType(1);		
        this.txtotherMatCost.setSupportedEmpty(true);		
        this.txtotherMatCost.setMinimumValue( new java.math.BigDecimal("-1.0E25"));		
        this.txtotherMatCost.setMaximumValue( new java.math.BigDecimal("1.0E25"));		
        this.txtotherMatCost.setPrecision(3);		
        this.txtotherMatCost.setRequired(false);		
        this.txtotherMatCost.setEnabled(false);
        // contreserveRiskCost		
        this.contreserveRiskCost.setBoundLabelText(resHelper.getString("contreserveRiskCost.boundLabelText"));		
        this.contreserveRiskCost.setBoundLabelLength(100);		
        this.contreserveRiskCost.setBoundLabelUnderline(true);		
        this.contreserveRiskCost.setVisible(true);
        // contbrokenCost		
        this.contbrokenCost.setBoundLabelText(resHelper.getString("contbrokenCost.boundLabelText"));		
        this.contbrokenCost.setBoundLabelLength(100);		
        this.contbrokenCost.setBoundLabelUnderline(true);		
        this.contbrokenCost.setVisible(true);
        // contlongBorrowReturn		
        this.contlongBorrowReturn.setBoundLabelText(resHelper.getString("contlongBorrowReturn.boundLabelText"));		
        this.contlongBorrowReturn.setBoundLabelLength(100);		
        this.contlongBorrowReturn.setBoundLabelUnderline(true);		
        this.contlongBorrowReturn.setVisible(true);
        // conttranCost		
        this.conttranCost.setBoundLabelText(resHelper.getString("conttranCost.boundLabelText"));		
        this.conttranCost.setBoundLabelLength(100);		
        this.conttranCost.setBoundLabelUnderline(true);		
        this.conttranCost.setVisible(true);
        // contactualPayAmt		
        this.contactualPayAmt.setBoundLabelText(resHelper.getString("contactualPayAmt.boundLabelText"));		
        this.contactualPayAmt.setBoundLabelLength(100);		
        this.contactualPayAmt.setBoundLabelUnderline(true);		
        this.contactualPayAmt.setVisible(true);
        // contspecialPermitAmt		
        this.contspecialPermitAmt.setBoundLabelText(resHelper.getString("contspecialPermitAmt.boundLabelText"));		
        this.contspecialPermitAmt.setBoundLabelLength(100);		
        this.contspecialPermitAmt.setBoundLabelUnderline(true);		
        this.contspecialPermitAmt.setVisible(true);
        // contspecialBorrowinst		
        this.contspecialBorrowinst.setBoundLabelText(resHelper.getString("contspecialBorrowinst.boundLabelText"));		
        this.contspecialBorrowinst.setBoundLabelLength(100);		
        this.contspecialBorrowinst.setBoundLabelUnderline(true);		
        this.contspecialBorrowinst.setVisible(true);
        // contlongBorrowAmount		
        this.contlongBorrowAmount.setBoundLabelText(resHelper.getString("contlongBorrowAmount.boundLabelText"));		
        this.contlongBorrowAmount.setBoundLabelLength(100);		
        this.contlongBorrowAmount.setBoundLabelUnderline(true);		
        this.contlongBorrowAmount.setVisible(true);
        // contequipmentReAmt		
        this.contequipmentReAmt.setBoundLabelText(resHelper.getString("contequipmentReAmt.boundLabelText"));		
        this.contequipmentReAmt.setBoundLabelLength(120);		
        this.contequipmentReAmt.setBoundLabelUnderline(true);		
        this.contequipmentReAmt.setVisible(true);
        // contborrowAmiunt		
        this.contborrowAmiunt.setBoundLabelText(resHelper.getString("contborrowAmiunt.boundLabelText"));		
        this.contborrowAmiunt.setBoundLabelLength(100);		
        this.contborrowAmiunt.setBoundLabelUnderline(true);		
        this.contborrowAmiunt.setVisible(true);
        // contmarginGAmount		
        this.contmarginGAmount.setBoundLabelText(resHelper.getString("contmarginGAmount.boundLabelText"));		
        this.contmarginGAmount.setBoundLabelLength(100);		
        this.contmarginGAmount.setBoundLabelUnderline(true);		
        this.contmarginGAmount.setVisible(true);
        // contcoalCost		
        this.contcoalCost.setBoundLabelText(resHelper.getString("contcoalCost.boundLabelText"));		
        this.contcoalCost.setBoundLabelLength(100);		
        this.contcoalCost.setBoundLabelUnderline(true);		
        this.contcoalCost.setVisible(true);
        // contmarginProfit		
        this.contmarginProfit.setBoundLabelText(resHelper.getString("contmarginProfit.boundLabelText"));		
        this.contmarginProfit.setBoundLabelLength(100);		
        this.contmarginProfit.setBoundLabelUnderline(true);		
        this.contmarginProfit.setVisible(true);
        // contgetChickCost		
        this.contgetChickCost.setBoundLabelText(resHelper.getString("contgetChickCost.boundLabelText"));		
        this.contgetChickCost.setBoundLabelLength(100);		
        this.contgetChickCost.setBoundLabelUnderline(true);		
        this.contgetChickCost.setVisible(true);
        // contcleanHouseCost		
        this.contcleanHouseCost.setBoundLabelText(resHelper.getString("contcleanHouseCost.boundLabelText"));		
        this.contcleanHouseCost.setBoundLabelLength(100);		
        this.contcleanHouseCost.setBoundLabelUnderline(true);		
        this.contcleanHouseCost.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));
        // contcleanTowerCost		
        this.contcleanTowerCost.setBoundLabelText(resHelper.getString("contcleanTowerCost.boundLabelText"));		
        this.contcleanTowerCost.setBoundLabelLength(100);		
        this.contcleanTowerCost.setBoundLabelUnderline(true);		
        this.contcleanTowerCost.setVisible(true);
        // contnowAccountBac		
        this.contnowAccountBac.setBoundLabelText(resHelper.getString("contnowAccountBac.boundLabelText"));		
        this.contnowAccountBac.setBoundLabelLength(100);		
        this.contnowAccountBac.setBoundLabelUnderline(true);		
        this.contnowAccountBac.setVisible(true);
        // contassetsOccupy		
        this.contassetsOccupy.setBoundLabelText(resHelper.getString("contassetsOccupy.boundLabelText"));		
        this.contassetsOccupy.setBoundLabelLength(100);		
        this.contassetsOccupy.setBoundLabelUnderline(true);		
        this.contassetsOccupy.setVisible(true);
        // contnoPfoRetAmt		
        this.contnoPfoRetAmt.setBoundLabelText(resHelper.getString("contnoPfoRetAmt.boundLabelText"));		
        this.contnoPfoRetAmt.setBoundLabelLength(100);		
        this.contnoPfoRetAmt.setBoundLabelUnderline(true);		
        this.contnoPfoRetAmt.setVisible(true);
        // chkactualVoucher		
        this.chkactualVoucher.setText(resHelper.getString("chkactualVoucher.text"));		
        this.chkactualVoucher.setHorizontalAlignment(2);		
        this.chkactualVoucher.setEnabled(false);
        // chkpreVoucher		
        this.chkpreVoucher.setText(resHelper.getString("chkpreVoucher.text"));		
        this.chkpreVoucher.setHorizontalAlignment(2);		
        this.chkpreVoucher.setEnabled(false);
        // chktransVoucher		
        this.chktransVoucher.setText(resHelper.getString("chktransVoucher.text"));		
        this.chktransVoucher.setHorizontalAlignment(2);		
        this.chktransVoucher.setEnabled(false);
        // chkhasPay		
        this.chkhasPay.setText(resHelper.getString("chkhasPay.text"));		
        this.chkhasPay.setHorizontalAlignment(2);		
        this.chkhasPay.setEnabled(false);
        // contcompanyTC		
        this.contcompanyTC.setBoundLabelText(resHelper.getString("contcompanyTC.boundLabelText"));		
        this.contcompanyTC.setBoundLabelLength(100);		
        this.contcompanyTC.setBoundLabelUnderline(true);		
        this.contcompanyTC.setVisible(true);
        // contdiverCt		
        this.contdiverCt.setBoundLabelText(resHelper.getString("contdiverCt.boundLabelText"));		
        this.contdiverCt.setBoundLabelLength(100);		
        this.contdiverCt.setBoundLabelUnderline(true);		
        this.contdiverCt.setVisible(true);
        // txtreserveRiskCost		
        this.txtreserveRiskCost.setHorizontalAlignment(2);		
        this.txtreserveRiskCost.setDataType(1);		
        this.txtreserveRiskCost.setSupportedEmpty(true);		
        this.txtreserveRiskCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreserveRiskCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreserveRiskCost.setPrecision(10);		
        this.txtreserveRiskCost.setRequired(false);
        // txtbrokenCost		
        this.txtbrokenCost.setHorizontalAlignment(2);		
        this.txtbrokenCost.setDataType(1);		
        this.txtbrokenCost.setSupportedEmpty(true);		
        this.txtbrokenCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbrokenCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbrokenCost.setPrecision(2);		
        this.txtbrokenCost.setRequired(false);
        // txtlongBorrowReturn		
        this.txtlongBorrowReturn.setHorizontalAlignment(2);		
        this.txtlongBorrowReturn.setDataType(1);		
        this.txtlongBorrowReturn.setSupportedEmpty(true);		
        this.txtlongBorrowReturn.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlongBorrowReturn.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlongBorrowReturn.setPrecision(2);		
        this.txtlongBorrowReturn.setRequired(false);
        // txttranCost		
        this.txttranCost.setHorizontalAlignment(2);		
        this.txttranCost.setDataType(1);		
        this.txttranCost.setSupportedEmpty(true);		
        this.txttranCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttranCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttranCost.setPrecision(2);		
        this.txttranCost.setRequired(false);
        // txtactualPayAmt		
        this.txtactualPayAmt.setHorizontalAlignment(2);		
        this.txtactualPayAmt.setDataType(1);		
        this.txtactualPayAmt.setSupportedEmpty(true);		
        this.txtactualPayAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualPayAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualPayAmt.setPrecision(2);		
        this.txtactualPayAmt.setRequired(false);
        // txtspecialPermitAmt		
        this.txtspecialPermitAmt.setHorizontalAlignment(2);		
        this.txtspecialPermitAmt.setDataType(1);		
        this.txtspecialPermitAmt.setSupportedEmpty(true);		
        this.txtspecialPermitAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtspecialPermitAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtspecialPermitAmt.setPrecision(2);		
        this.txtspecialPermitAmt.setRequired(false);
        // txtspecialBorrowinst		
        this.txtspecialBorrowinst.setHorizontalAlignment(2);		
        this.txtspecialBorrowinst.setDataType(1);		
        this.txtspecialBorrowinst.setSupportedEmpty(true);		
        this.txtspecialBorrowinst.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtspecialBorrowinst.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtspecialBorrowinst.setPrecision(2);		
        this.txtspecialBorrowinst.setRequired(false);
        // txtlongBorrowAmount		
        this.txtlongBorrowAmount.setHorizontalAlignment(2);		
        this.txtlongBorrowAmount.setDataType(1);		
        this.txtlongBorrowAmount.setSupportedEmpty(true);		
        this.txtlongBorrowAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlongBorrowAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlongBorrowAmount.setPrecision(2);		
        this.txtlongBorrowAmount.setRequired(false);		
        this.txtlongBorrowAmount.setEnabled(false);
        // txtequipmentReAmt		
        this.txtequipmentReAmt.setHorizontalAlignment(2);		
        this.txtequipmentReAmt.setDataType(1);		
        this.txtequipmentReAmt.setSupportedEmpty(true);		
        this.txtequipmentReAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtequipmentReAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtequipmentReAmt.setPrecision(2);		
        this.txtequipmentReAmt.setRequired(false);
        // txtborrowAmiunt		
        this.txtborrowAmiunt.setHorizontalAlignment(2);		
        this.txtborrowAmiunt.setDataType(1);		
        this.txtborrowAmiunt.setSupportedEmpty(true);		
        this.txtborrowAmiunt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtborrowAmiunt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtborrowAmiunt.setPrecision(2);		
        this.txtborrowAmiunt.setRequired(false);
        // txtmarginGAmount		
        this.txtmarginGAmount.setHorizontalAlignment(2);		
        this.txtmarginGAmount.setDataType(1);		
        this.txtmarginGAmount.setSupportedEmpty(true);		
        this.txtmarginGAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginGAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginGAmount.setPrecision(2);		
        this.txtmarginGAmount.setRequired(false);
        // txtcoalCost		
        this.txtcoalCost.setHorizontalAlignment(2);		
        this.txtcoalCost.setDataType(1);		
        this.txtcoalCost.setSupportedEmpty(true);		
        this.txtcoalCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcoalCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcoalCost.setPrecision(2);		
        this.txtcoalCost.setRequired(false);
        // txtmarginProfit		
        this.txtmarginProfit.setHorizontalAlignment(2);		
        this.txtmarginProfit.setDataType(1);		
        this.txtmarginProfit.setSupportedEmpty(true);		
        this.txtmarginProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginProfit.setPrecision(2);		
        this.txtmarginProfit.setRequired(false);
        // txtgetChickCost		
        this.txtgetChickCost.setHorizontalAlignment(2);		
        this.txtgetChickCost.setDataType(1);		
        this.txtgetChickCost.setSupportedEmpty(true);		
        this.txtgetChickCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgetChickCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgetChickCost.setPrecision(2);		
        this.txtgetChickCost.setRequired(false);
        // txtcleanHouseCost		
        this.txtcleanHouseCost.setHorizontalAlignment(2);		
        this.txtcleanHouseCost.setDataType(1);		
        this.txtcleanHouseCost.setSupportedEmpty(true);		
        this.txtcleanHouseCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcleanHouseCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcleanHouseCost.setPrecision(2);		
        this.txtcleanHouseCost.setRequired(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // txtcleanTowerCost		
        this.txtcleanTowerCost.setHorizontalAlignment(2);		
        this.txtcleanTowerCost.setDataType(1);		
        this.txtcleanTowerCost.setSupportedEmpty(true);		
        this.txtcleanTowerCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcleanTowerCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcleanTowerCost.setPrecision(2);		
        this.txtcleanTowerCost.setRequired(false);
        // txtnowAccountBac		
        this.txtnowAccountBac.setHorizontalAlignment(2);		
        this.txtnowAccountBac.setDataType(1);		
        this.txtnowAccountBac.setSupportedEmpty(true);		
        this.txtnowAccountBac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnowAccountBac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnowAccountBac.setPrecision(2);		
        this.txtnowAccountBac.setRequired(false);
        // txtassetsOccupy		
        this.txtassetsOccupy.setHorizontalAlignment(2);		
        this.txtassetsOccupy.setDataType(1);		
        this.txtassetsOccupy.setSupportedEmpty(true);		
        this.txtassetsOccupy.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtassetsOccupy.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtassetsOccupy.setPrecision(2);		
        this.txtassetsOccupy.setRequired(false);
        // txtnoPfoRetAmt		
        this.txtnoPfoRetAmt.setHorizontalAlignment(2);		
        this.txtnoPfoRetAmt.setDataType(1);		
        this.txtnoPfoRetAmt.setSupportedEmpty(true);		
        this.txtnoPfoRetAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnoPfoRetAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnoPfoRetAmt.setPrecision(2);		
        this.txtnoPfoRetAmt.setRequired(false);
        // txtcompanyTC		
        this.txtcompanyTC.setVisible(true);		
        this.txtcompanyTC.setHorizontalAlignment(2);		
        this.txtcompanyTC.setDataType(1);		
        this.txtcompanyTC.setSupportedEmpty(true);		
        this.txtcompanyTC.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyTC.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyTC.setPrecision(2);		
        this.txtcompanyTC.setRequired(false);
        // txtdiverCt		
        this.txtdiverCt.setVisible(true);		
        this.txtdiverCt.setHorizontalAlignment(2);		
        this.txtdiverCt.setDataType(1);		
        this.txtdiverCt.setSupportedEmpty(true);		
        this.txtdiverCt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdiverCt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdiverCt.setPrecision(2);		
        this.txtdiverCt.setRequired(false);
        // kDPanel8
        // kDPanel9
        // kDPanel10
        // kDPanel11
        // kDPanel12
        // kdtSeedEntrys
		String kdtSeedEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"policyPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"cost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"contPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"contAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"actPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"actAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{bizType}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{policyPrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{cost}</t:Cell><t:Cell>$Resource{contPrice}</t:Cell><t:Cell>$Resource{contAmount}</t:Cell><t:Cell>$Resource{actPrice}</t:Cell><t:Cell>$Resource{actAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSeedEntrys.setFormatXml(resHelper.translateString("kdtSeedEntrys",kdtSeedEntrysStrXML));

                this.kdtSeedEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","bizType","material","materialName","qty","policyPrice","amount","unitCost","cost","contPrice","contAmount","actPrice","actAmount"});


        this.kdtSeedEntrys.checkParsed();
        KDFormattedTextField kdtSeedEntrys_seq_TextField = new KDFormattedTextField();
        kdtSeedEntrys_seq_TextField.setName("kdtSeedEntrys_seq_TextField");
        kdtSeedEntrys_seq_TextField.setVisible(true);
        kdtSeedEntrys_seq_TextField.setEditable(true);
        kdtSeedEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSeedEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_seq_TextField);
        this.kdtSeedEntrys.getColumn("seq").setEditor(kdtSeedEntrys_seq_CellEditor);
        KDDatePicker kdtSeedEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtSeedEntrys_bizDate_DatePicker.setName("kdtSeedEntrys_bizDate_DatePicker");
        kdtSeedEntrys_bizDate_DatePicker.setVisible(true);
        kdtSeedEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtSeedEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_bizDate_DatePicker);
        this.kdtSeedEntrys.getColumn("bizDate").setEditor(kdtSeedEntrys_bizDate_CellEditor);
        KDTextField kdtSeedEntrys_billNumber_TextField = new KDTextField();
        kdtSeedEntrys_billNumber_TextField.setName("kdtSeedEntrys_billNumber_TextField");
        kdtSeedEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSeedEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_billNumber_TextField);
        this.kdtSeedEntrys.getColumn("billNumber").setEditor(kdtSeedEntrys_billNumber_CellEditor);
        KDComboBox kdtSeedEntrys_billStatus_ComboBox = new KDComboBox();
        kdtSeedEntrys_billStatus_ComboBox.setName("kdtSeedEntrys_billStatus_ComboBox");
        kdtSeedEntrys_billStatus_ComboBox.setVisible(true);
        kdtSeedEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtSeedEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_billStatus_ComboBox);
        this.kdtSeedEntrys.getColumn("billStatus").setEditor(kdtSeedEntrys_billStatus_CellEditor);
        KDComboBox kdtSeedEntrys_bizType_ComboBox = new KDComboBox();
        kdtSeedEntrys_bizType_ComboBox.setName("kdtSeedEntrys_bizType_ComboBox");
        kdtSeedEntrys_bizType_ComboBox.setVisible(true);
        kdtSeedEntrys_bizType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum").toArray());
        KDTDefaultCellEditor kdtSeedEntrys_bizType_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_bizType_ComboBox);
        this.kdtSeedEntrys.getColumn("bizType").setEditor(kdtSeedEntrys_bizType_CellEditor);
        final KDBizPromptBox kdtSeedEntrys_material_PromptBox = new KDBizPromptBox();
        kdtSeedEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtSeedEntrys_material_PromptBox.setVisible(true);
        kdtSeedEntrys_material_PromptBox.setEditable(true);
        kdtSeedEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtSeedEntrys_material_PromptBox.setEditFormat("$number$");
        kdtSeedEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSeedEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_material_PromptBox);
        this.kdtSeedEntrys.getColumn("material").setEditor(kdtSeedEntrys_material_CellEditor);
        ObjectValueRender kdtSeedEntrys_material_OVR = new ObjectValueRender();
        kdtSeedEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtSeedEntrys.getColumn("material").setRenderer(kdtSeedEntrys_material_OVR);
        KDTextField kdtSeedEntrys_materialName_TextField = new KDTextField();
        kdtSeedEntrys_materialName_TextField.setName("kdtSeedEntrys_materialName_TextField");
        kdtSeedEntrys_materialName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSeedEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_materialName_TextField);
        this.kdtSeedEntrys.getColumn("materialName").setEditor(kdtSeedEntrys_materialName_CellEditor);
        KDFormattedTextField kdtSeedEntrys_qty_TextField = new KDFormattedTextField();
        kdtSeedEntrys_qty_TextField.setName("kdtSeedEntrys_qty_TextField");
        kdtSeedEntrys_qty_TextField.setVisible(true);
        kdtSeedEntrys_qty_TextField.setEditable(true);
        kdtSeedEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_qty_TextField.setDataType(1);
        	kdtSeedEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_qty_TextField);
        this.kdtSeedEntrys.getColumn("qty").setEditor(kdtSeedEntrys_qty_CellEditor);
        KDFormattedTextField kdtSeedEntrys_policyPrice_TextField = new KDFormattedTextField();
        kdtSeedEntrys_policyPrice_TextField.setName("kdtSeedEntrys_policyPrice_TextField");
        kdtSeedEntrys_policyPrice_TextField.setVisible(true);
        kdtSeedEntrys_policyPrice_TextField.setEditable(true);
        kdtSeedEntrys_policyPrice_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_policyPrice_TextField.setDataType(1);
        	kdtSeedEntrys_policyPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_policyPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_policyPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_policyPrice_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_policyPrice_TextField);
        this.kdtSeedEntrys.getColumn("policyPrice").setEditor(kdtSeedEntrys_policyPrice_CellEditor);
        KDFormattedTextField kdtSeedEntrys_amount_TextField = new KDFormattedTextField();
        kdtSeedEntrys_amount_TextField.setName("kdtSeedEntrys_amount_TextField");
        kdtSeedEntrys_amount_TextField.setVisible(true);
        kdtSeedEntrys_amount_TextField.setEditable(true);
        kdtSeedEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_amount_TextField.setDataType(1);
        	kdtSeedEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_amount_TextField);
        this.kdtSeedEntrys.getColumn("amount").setEditor(kdtSeedEntrys_amount_CellEditor);
        KDFormattedTextField kdtSeedEntrys_unitCost_TextField = new KDFormattedTextField();
        kdtSeedEntrys_unitCost_TextField.setName("kdtSeedEntrys_unitCost_TextField");
        kdtSeedEntrys_unitCost_TextField.setVisible(true);
        kdtSeedEntrys_unitCost_TextField.setEditable(true);
        kdtSeedEntrys_unitCost_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_unitCost_TextField.setDataType(1);
        	kdtSeedEntrys_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_unitCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_unitCost_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_unitCost_TextField);
        this.kdtSeedEntrys.getColumn("unitCost").setEditor(kdtSeedEntrys_unitCost_CellEditor);
        KDFormattedTextField kdtSeedEntrys_cost_TextField = new KDFormattedTextField();
        kdtSeedEntrys_cost_TextField.setName("kdtSeedEntrys_cost_TextField");
        kdtSeedEntrys_cost_TextField.setVisible(true);
        kdtSeedEntrys_cost_TextField.setEditable(true);
        kdtSeedEntrys_cost_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_cost_TextField.setDataType(1);
        	kdtSeedEntrys_cost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_cost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_cost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_cost_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_cost_TextField);
        this.kdtSeedEntrys.getColumn("cost").setEditor(kdtSeedEntrys_cost_CellEditor);
        KDFormattedTextField kdtSeedEntrys_contPrice_TextField = new KDFormattedTextField();
        kdtSeedEntrys_contPrice_TextField.setName("kdtSeedEntrys_contPrice_TextField");
        kdtSeedEntrys_contPrice_TextField.setVisible(true);
        kdtSeedEntrys_contPrice_TextField.setEditable(true);
        kdtSeedEntrys_contPrice_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_contPrice_TextField.setDataType(1);
        	kdtSeedEntrys_contPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_contPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_contPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_contPrice_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_contPrice_TextField);
        this.kdtSeedEntrys.getColumn("contPrice").setEditor(kdtSeedEntrys_contPrice_CellEditor);
        KDFormattedTextField kdtSeedEntrys_contAmount_TextField = new KDFormattedTextField();
        kdtSeedEntrys_contAmount_TextField.setName("kdtSeedEntrys_contAmount_TextField");
        kdtSeedEntrys_contAmount_TextField.setVisible(true);
        kdtSeedEntrys_contAmount_TextField.setEditable(true);
        kdtSeedEntrys_contAmount_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_contAmount_TextField.setDataType(1);
        	kdtSeedEntrys_contAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_contAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_contAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_contAmount_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_contAmount_TextField);
        this.kdtSeedEntrys.getColumn("contAmount").setEditor(kdtSeedEntrys_contAmount_CellEditor);
        KDFormattedTextField kdtSeedEntrys_actPrice_TextField = new KDFormattedTextField();
        kdtSeedEntrys_actPrice_TextField.setName("kdtSeedEntrys_actPrice_TextField");
        kdtSeedEntrys_actPrice_TextField.setVisible(true);
        kdtSeedEntrys_actPrice_TextField.setEditable(true);
        kdtSeedEntrys_actPrice_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_actPrice_TextField.setDataType(1);
        	kdtSeedEntrys_actPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_actPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_actPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_actPrice_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_actPrice_TextField);
        this.kdtSeedEntrys.getColumn("actPrice").setEditor(kdtSeedEntrys_actPrice_CellEditor);
        KDFormattedTextField kdtSeedEntrys_actAmount_TextField = new KDFormattedTextField();
        kdtSeedEntrys_actAmount_TextField.setName("kdtSeedEntrys_actAmount_TextField");
        kdtSeedEntrys_actAmount_TextField.setVisible(true);
        kdtSeedEntrys_actAmount_TextField.setEditable(true);
        kdtSeedEntrys_actAmount_TextField.setHorizontalAlignment(2);
        kdtSeedEntrys_actAmount_TextField.setDataType(1);
        	kdtSeedEntrys_actAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSeedEntrys_actAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSeedEntrys_actAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSeedEntrys_actAmount_CellEditor = new KDTDefaultCellEditor(kdtSeedEntrys_actAmount_TextField);
        this.kdtSeedEntrys.getColumn("actAmount").setEditor(kdtSeedEntrys_actAmount_CellEditor);
        // kdtFodderEntrys
		String kdtFodderEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"bagQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"policyPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"hjFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"cost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{bizType}</t:Cell><t:Cell>$Resource{Car}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{unitQty}</t:Cell><t:Cell>$Resource{bagQty}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{policyPrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{hjFee}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{cost}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFodderEntrys.setFormatXml(resHelper.translateString("kdtFodderEntrys",kdtFodderEntrysStrXML));

                this.kdtFodderEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","bizType","Car","driver","material","materialName","unitQty","bagQty","qty","policyPrice","amount","hjFee","unitCost","cost"});


        this.kdtFodderEntrys.checkParsed();
        KDFormattedTextField kdtFodderEntrys_seq_TextField = new KDFormattedTextField();
        kdtFodderEntrys_seq_TextField.setName("kdtFodderEntrys_seq_TextField");
        kdtFodderEntrys_seq_TextField.setVisible(true);
        kdtFodderEntrys_seq_TextField.setEditable(true);
        kdtFodderEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFodderEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_seq_TextField);
        this.kdtFodderEntrys.getColumn("seq").setEditor(kdtFodderEntrys_seq_CellEditor);
        KDDatePicker kdtFodderEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtFodderEntrys_bizDate_DatePicker.setName("kdtFodderEntrys_bizDate_DatePicker");
        kdtFodderEntrys_bizDate_DatePicker.setVisible(true);
        kdtFodderEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtFodderEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_bizDate_DatePicker);
        this.kdtFodderEntrys.getColumn("bizDate").setEditor(kdtFodderEntrys_bizDate_CellEditor);
        KDTextField kdtFodderEntrys_billNumber_TextField = new KDTextField();
        kdtFodderEntrys_billNumber_TextField.setName("kdtFodderEntrys_billNumber_TextField");
        kdtFodderEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtFodderEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_billNumber_TextField);
        this.kdtFodderEntrys.getColumn("billNumber").setEditor(kdtFodderEntrys_billNumber_CellEditor);
        KDComboBox kdtFodderEntrys_billStatus_ComboBox = new KDComboBox();
        kdtFodderEntrys_billStatus_ComboBox.setName("kdtFodderEntrys_billStatus_ComboBox");
        kdtFodderEntrys_billStatus_ComboBox.setVisible(true);
        kdtFodderEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtFodderEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_billStatus_ComboBox);
        this.kdtFodderEntrys.getColumn("billStatus").setEditor(kdtFodderEntrys_billStatus_CellEditor);
        KDComboBox kdtFodderEntrys_bizType_ComboBox = new KDComboBox();
        kdtFodderEntrys_bizType_ComboBox.setName("kdtFodderEntrys_bizType_ComboBox");
        kdtFodderEntrys_bizType_ComboBox.setVisible(true);
        kdtFodderEntrys_bizType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType").toArray());
        KDTDefaultCellEditor kdtFodderEntrys_bizType_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_bizType_ComboBox);
        this.kdtFodderEntrys.getColumn("bizType").setEditor(kdtFodderEntrys_bizType_CellEditor);
        final KDBizPromptBox kdtFodderEntrys_Car_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_Car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtFodderEntrys_Car_PromptBox.setVisible(true);
        kdtFodderEntrys_Car_PromptBox.setEditable(true);
        kdtFodderEntrys_Car_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_Car_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_Car_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_Car_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_Car_PromptBox);
        this.kdtFodderEntrys.getColumn("Car").setEditor(kdtFodderEntrys_Car_CellEditor);
        ObjectValueRender kdtFodderEntrys_Car_OVR = new ObjectValueRender();
        kdtFodderEntrys_Car_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderEntrys.getColumn("Car").setRenderer(kdtFodderEntrys_Car_OVR);
        			kdtFodderEntrys_Car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtFodderEntrys_Car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFodderEntrys_Car_PromptBox_F7ListUI == null) {
					try {
						kdtFodderEntrys_Car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFodderEntrys_Car_PromptBox_F7ListUI));
					kdtFodderEntrys_Car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFodderEntrys_Car_PromptBox.setSelector(kdtFodderEntrys_Car_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtFodderEntrys_driver_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtFodderEntrys_driver_PromptBox.setVisible(true);
        kdtFodderEntrys_driver_PromptBox.setEditable(true);
        kdtFodderEntrys_driver_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_driver_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_driver_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_driver_PromptBox);
        this.kdtFodderEntrys.getColumn("driver").setEditor(kdtFodderEntrys_driver_CellEditor);
        ObjectValueRender kdtFodderEntrys_driver_OVR = new ObjectValueRender();
        kdtFodderEntrys_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtFodderEntrys.getColumn("driver").setRenderer(kdtFodderEntrys_driver_OVR);
        			kdtFodderEntrys_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtFodderEntrys_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFodderEntrys_driver_PromptBox_F7ListUI == null) {
					try {
						kdtFodderEntrys_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFodderEntrys_driver_PromptBox_F7ListUI));
					kdtFodderEntrys_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFodderEntrys_driver_PromptBox.setSelector(kdtFodderEntrys_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtFodderEntrys_material_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtFodderEntrys_material_PromptBox.setVisible(true);
        kdtFodderEntrys_material_PromptBox.setEditable(true);
        kdtFodderEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_material_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_material_PromptBox);
        this.kdtFodderEntrys.getColumn("material").setEditor(kdtFodderEntrys_material_CellEditor);
        ObjectValueRender kdtFodderEntrys_material_OVR = new ObjectValueRender();
        kdtFodderEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderEntrys.getColumn("material").setRenderer(kdtFodderEntrys_material_OVR);
        KDTextField kdtFodderEntrys_materialName_TextField = new KDTextField();
        kdtFodderEntrys_materialName_TextField.setName("kdtFodderEntrys_materialName_TextField");
        kdtFodderEntrys_materialName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtFodderEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_materialName_TextField);
        this.kdtFodderEntrys.getColumn("materialName").setEditor(kdtFodderEntrys_materialName_CellEditor);
        KDFormattedTextField kdtFodderEntrys_unitQty_TextField = new KDFormattedTextField();
        kdtFodderEntrys_unitQty_TextField.setName("kdtFodderEntrys_unitQty_TextField");
        kdtFodderEntrys_unitQty_TextField.setVisible(true);
        kdtFodderEntrys_unitQty_TextField.setEditable(true);
        kdtFodderEntrys_unitQty_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_unitQty_TextField.setDataType(1);
        	kdtFodderEntrys_unitQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_unitQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_unitQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_unitQty_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_unitQty_TextField);
        this.kdtFodderEntrys.getColumn("unitQty").setEditor(kdtFodderEntrys_unitQty_CellEditor);
        KDFormattedTextField kdtFodderEntrys_bagQty_TextField = new KDFormattedTextField();
        kdtFodderEntrys_bagQty_TextField.setName("kdtFodderEntrys_bagQty_TextField");
        kdtFodderEntrys_bagQty_TextField.setVisible(true);
        kdtFodderEntrys_bagQty_TextField.setEditable(true);
        kdtFodderEntrys_bagQty_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_bagQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFodderEntrys_bagQty_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_bagQty_TextField);
        this.kdtFodderEntrys.getColumn("bagQty").setEditor(kdtFodderEntrys_bagQty_CellEditor);
        KDFormattedTextField kdtFodderEntrys_qty_TextField = new KDFormattedTextField();
        kdtFodderEntrys_qty_TextField.setName("kdtFodderEntrys_qty_TextField");
        kdtFodderEntrys_qty_TextField.setVisible(true);
        kdtFodderEntrys_qty_TextField.setEditable(true);
        kdtFodderEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_qty_TextField.setDataType(1);
        	kdtFodderEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_qty_TextField);
        this.kdtFodderEntrys.getColumn("qty").setEditor(kdtFodderEntrys_qty_CellEditor);
        KDFormattedTextField kdtFodderEntrys_policyPrice_TextField = new KDFormattedTextField();
        kdtFodderEntrys_policyPrice_TextField.setName("kdtFodderEntrys_policyPrice_TextField");
        kdtFodderEntrys_policyPrice_TextField.setVisible(true);
        kdtFodderEntrys_policyPrice_TextField.setEditable(true);
        kdtFodderEntrys_policyPrice_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_policyPrice_TextField.setDataType(1);
        	kdtFodderEntrys_policyPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_policyPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_policyPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_policyPrice_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_policyPrice_TextField);
        this.kdtFodderEntrys.getColumn("policyPrice").setEditor(kdtFodderEntrys_policyPrice_CellEditor);
        KDFormattedTextField kdtFodderEntrys_amount_TextField = new KDFormattedTextField();
        kdtFodderEntrys_amount_TextField.setName("kdtFodderEntrys_amount_TextField");
        kdtFodderEntrys_amount_TextField.setVisible(true);
        kdtFodderEntrys_amount_TextField.setEditable(true);
        kdtFodderEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_amount_TextField.setDataType(1);
        	kdtFodderEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_amount_TextField);
        this.kdtFodderEntrys.getColumn("amount").setEditor(kdtFodderEntrys_amount_CellEditor);
        KDFormattedTextField kdtFodderEntrys_hjFee_TextField = new KDFormattedTextField();
        kdtFodderEntrys_hjFee_TextField.setName("kdtFodderEntrys_hjFee_TextField");
        kdtFodderEntrys_hjFee_TextField.setVisible(true);
        kdtFodderEntrys_hjFee_TextField.setEditable(true);
        kdtFodderEntrys_hjFee_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_hjFee_TextField.setDataType(1);
        	kdtFodderEntrys_hjFee_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_hjFee_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_hjFee_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_hjFee_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_hjFee_TextField);
        this.kdtFodderEntrys.getColumn("hjFee").setEditor(kdtFodderEntrys_hjFee_CellEditor);
        KDFormattedTextField kdtFodderEntrys_unitCost_TextField = new KDFormattedTextField();
        kdtFodderEntrys_unitCost_TextField.setName("kdtFodderEntrys_unitCost_TextField");
        kdtFodderEntrys_unitCost_TextField.setVisible(true);
        kdtFodderEntrys_unitCost_TextField.setEditable(true);
        kdtFodderEntrys_unitCost_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_unitCost_TextField.setDataType(1);
        	kdtFodderEntrys_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_unitCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_unitCost_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_unitCost_TextField);
        this.kdtFodderEntrys.getColumn("unitCost").setEditor(kdtFodderEntrys_unitCost_CellEditor);
        KDFormattedTextField kdtFodderEntrys_cost_TextField = new KDFormattedTextField();
        kdtFodderEntrys_cost_TextField.setName("kdtFodderEntrys_cost_TextField");
        kdtFodderEntrys_cost_TextField.setVisible(true);
        kdtFodderEntrys_cost_TextField.setEditable(true);
        kdtFodderEntrys_cost_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_cost_TextField.setDataType(1);
        	kdtFodderEntrys_cost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFodderEntrys_cost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFodderEntrys_cost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFodderEntrys_cost_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_cost_TextField);
        this.kdtFodderEntrys.getColumn("cost").setEditor(kdtFodderEntrys_cost_CellEditor);
        // kdtDrugEntrys
		String kdtDrugEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"policyPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"cost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{bizType}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{policyPrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{cost}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDrugEntrys.setFormatXml(resHelper.translateString("kdtDrugEntrys",kdtDrugEntrysStrXML));

                this.kdtDrugEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","bizType","material","materialName","qty","policyPrice","amount","unitCost","cost"});


        this.kdtDrugEntrys.checkParsed();
        KDFormattedTextField kdtDrugEntrys_seq_TextField = new KDFormattedTextField();
        kdtDrugEntrys_seq_TextField.setName("kdtDrugEntrys_seq_TextField");
        kdtDrugEntrys_seq_TextField.setVisible(true);
        kdtDrugEntrys_seq_TextField.setEditable(true);
        kdtDrugEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDrugEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_seq_TextField);
        this.kdtDrugEntrys.getColumn("seq").setEditor(kdtDrugEntrys_seq_CellEditor);
        KDDatePicker kdtDrugEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtDrugEntrys_bizDate_DatePicker.setName("kdtDrugEntrys_bizDate_DatePicker");
        kdtDrugEntrys_bizDate_DatePicker.setVisible(true);
        kdtDrugEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtDrugEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_bizDate_DatePicker);
        this.kdtDrugEntrys.getColumn("bizDate").setEditor(kdtDrugEntrys_bizDate_CellEditor);
        KDTextField kdtDrugEntrys_billNumber_TextField = new KDTextField();
        kdtDrugEntrys_billNumber_TextField.setName("kdtDrugEntrys_billNumber_TextField");
        kdtDrugEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_billNumber_TextField);
        this.kdtDrugEntrys.getColumn("billNumber").setEditor(kdtDrugEntrys_billNumber_CellEditor);
        KDComboBox kdtDrugEntrys_billStatus_ComboBox = new KDComboBox();
        kdtDrugEntrys_billStatus_ComboBox.setName("kdtDrugEntrys_billStatus_ComboBox");
        kdtDrugEntrys_billStatus_ComboBox.setVisible(true);
        kdtDrugEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtDrugEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_billStatus_ComboBox);
        this.kdtDrugEntrys.getColumn("billStatus").setEditor(kdtDrugEntrys_billStatus_CellEditor);
        KDComboBox kdtDrugEntrys_bizType_ComboBox = new KDComboBox();
        kdtDrugEntrys_bizType_ComboBox.setName("kdtDrugEntrys_bizType_ComboBox");
        kdtDrugEntrys_bizType_ComboBox.setVisible(true);
        kdtDrugEntrys_bizType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType").toArray());
        KDTDefaultCellEditor kdtDrugEntrys_bizType_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_bizType_ComboBox);
        this.kdtDrugEntrys.getColumn("bizType").setEditor(kdtDrugEntrys_bizType_CellEditor);
        final KDBizPromptBox kdtDrugEntrys_material_PromptBox = new KDBizPromptBox();
        kdtDrugEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtDrugEntrys_material_PromptBox.setVisible(true);
        kdtDrugEntrys_material_PromptBox.setEditable(true);
        kdtDrugEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtDrugEntrys_material_PromptBox.setEditFormat("$number$");
        kdtDrugEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDrugEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_material_PromptBox);
        this.kdtDrugEntrys.getColumn("material").setEditor(kdtDrugEntrys_material_CellEditor);
        ObjectValueRender kdtDrugEntrys_material_OVR = new ObjectValueRender();
        kdtDrugEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtDrugEntrys.getColumn("material").setRenderer(kdtDrugEntrys_material_OVR);
        KDTextField kdtDrugEntrys_materialName_TextField = new KDTextField();
        kdtDrugEntrys_materialName_TextField.setName("kdtDrugEntrys_materialName_TextField");
        kdtDrugEntrys_materialName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_materialName_TextField);
        this.kdtDrugEntrys.getColumn("materialName").setEditor(kdtDrugEntrys_materialName_CellEditor);
        KDFormattedTextField kdtDrugEntrys_qty_TextField = new KDFormattedTextField();
        kdtDrugEntrys_qty_TextField.setName("kdtDrugEntrys_qty_TextField");
        kdtDrugEntrys_qty_TextField.setVisible(true);
        kdtDrugEntrys_qty_TextField.setEditable(true);
        kdtDrugEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_qty_TextField.setDataType(1);
        	kdtDrugEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_qty_TextField);
        this.kdtDrugEntrys.getColumn("qty").setEditor(kdtDrugEntrys_qty_CellEditor);
        KDFormattedTextField kdtDrugEntrys_policyPrice_TextField = new KDFormattedTextField();
        kdtDrugEntrys_policyPrice_TextField.setName("kdtDrugEntrys_policyPrice_TextField");
        kdtDrugEntrys_policyPrice_TextField.setVisible(true);
        kdtDrugEntrys_policyPrice_TextField.setEditable(true);
        kdtDrugEntrys_policyPrice_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_policyPrice_TextField.setDataType(1);
        	kdtDrugEntrys_policyPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_policyPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_policyPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_policyPrice_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_policyPrice_TextField);
        this.kdtDrugEntrys.getColumn("policyPrice").setEditor(kdtDrugEntrys_policyPrice_CellEditor);
        KDFormattedTextField kdtDrugEntrys_amount_TextField = new KDFormattedTextField();
        kdtDrugEntrys_amount_TextField.setName("kdtDrugEntrys_amount_TextField");
        kdtDrugEntrys_amount_TextField.setVisible(true);
        kdtDrugEntrys_amount_TextField.setEditable(true);
        kdtDrugEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_amount_TextField.setDataType(1);
        	kdtDrugEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_amount_TextField);
        this.kdtDrugEntrys.getColumn("amount").setEditor(kdtDrugEntrys_amount_CellEditor);
        KDFormattedTextField kdtDrugEntrys_unitCost_TextField = new KDFormattedTextField();
        kdtDrugEntrys_unitCost_TextField.setName("kdtDrugEntrys_unitCost_TextField");
        kdtDrugEntrys_unitCost_TextField.setVisible(true);
        kdtDrugEntrys_unitCost_TextField.setEditable(true);
        kdtDrugEntrys_unitCost_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_unitCost_TextField.setDataType(1);
        	kdtDrugEntrys_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_unitCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_unitCost_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_unitCost_TextField);
        this.kdtDrugEntrys.getColumn("unitCost").setEditor(kdtDrugEntrys_unitCost_CellEditor);
        KDFormattedTextField kdtDrugEntrys_cost_TextField = new KDFormattedTextField();
        kdtDrugEntrys_cost_TextField.setName("kdtDrugEntrys_cost_TextField");
        kdtDrugEntrys_cost_TextField.setVisible(true);
        kdtDrugEntrys_cost_TextField.setEditable(true);
        kdtDrugEntrys_cost_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_cost_TextField.setDataType(1);
        	kdtDrugEntrys_cost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_cost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_cost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_cost_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_cost_TextField);
        this.kdtDrugEntrys.getColumn("cost").setEditor(kdtDrugEntrys_cost_CellEditor);
        // kdtSlaughterEntrys
		String kdtSlaughterEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"carcassQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"carcassWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"AWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"preHouseSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"inCompleteWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"inCompleteQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"punishAllWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"settlementAllWig\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{recQty}</t:Cell><t:Cell>$Resource{carcassQty}</t:Cell><t:Cell>$Resource{carcassWgt}</t:Cell><t:Cell>$Resource{AWeight}</t:Cell><t:Cell>$Resource{preHouseSuttle}</t:Cell><t:Cell>$Resource{inCompleteWgt}</t:Cell><t:Cell>$Resource{inCompleteQty}</t:Cell><t:Cell>$Resource{punishAllWeight}</t:Cell><t:Cell>$Resource{settlementAllWig}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSlaughterEntrys.setFormatXml(resHelper.translateString("kdtSlaughterEntrys",kdtSlaughterEntrysStrXML));

                this.kdtSlaughterEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","recQty","carcassQty","carcassWgt","AWeight","preHouseSuttle","inCompleteWgt","inCompleteQty","punishAllWeight","settlementAllWig"});


        this.kdtSlaughterEntrys.checkParsed();
        KDFormattedTextField kdtSlaughterEntrys_seq_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_seq_TextField.setName("kdtSlaughterEntrys_seq_TextField");
        kdtSlaughterEntrys_seq_TextField.setVisible(true);
        kdtSlaughterEntrys_seq_TextField.setEditable(true);
        kdtSlaughterEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSlaughterEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_seq_TextField);
        this.kdtSlaughterEntrys.getColumn("seq").setEditor(kdtSlaughterEntrys_seq_CellEditor);
        KDDatePicker kdtSlaughterEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtSlaughterEntrys_bizDate_DatePicker.setName("kdtSlaughterEntrys_bizDate_DatePicker");
        kdtSlaughterEntrys_bizDate_DatePicker.setVisible(true);
        kdtSlaughterEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtSlaughterEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_bizDate_DatePicker);
        this.kdtSlaughterEntrys.getColumn("bizDate").setEditor(kdtSlaughterEntrys_bizDate_CellEditor);
        KDTextField kdtSlaughterEntrys_billNumber_TextField = new KDTextField();
        kdtSlaughterEntrys_billNumber_TextField.setName("kdtSlaughterEntrys_billNumber_TextField");
        kdtSlaughterEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSlaughterEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_billNumber_TextField);
        this.kdtSlaughterEntrys.getColumn("billNumber").setEditor(kdtSlaughterEntrys_billNumber_CellEditor);
        KDComboBox kdtSlaughterEntrys_billStatus_ComboBox = new KDComboBox();
        kdtSlaughterEntrys_billStatus_ComboBox.setName("kdtSlaughterEntrys_billStatus_ComboBox");
        kdtSlaughterEntrys_billStatus_ComboBox.setVisible(true);
        kdtSlaughterEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtSlaughterEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_billStatus_ComboBox);
        this.kdtSlaughterEntrys.getColumn("billStatus").setEditor(kdtSlaughterEntrys_billStatus_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_recQty_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_recQty_TextField.setName("kdtSlaughterEntrys_recQty_TextField");
        kdtSlaughterEntrys_recQty_TextField.setVisible(true);
        kdtSlaughterEntrys_recQty_TextField.setEditable(true);
        kdtSlaughterEntrys_recQty_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_recQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSlaughterEntrys_recQty_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_recQty_TextField);
        this.kdtSlaughterEntrys.getColumn("recQty").setEditor(kdtSlaughterEntrys_recQty_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_carcassQty_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_carcassQty_TextField.setName("kdtSlaughterEntrys_carcassQty_TextField");
        kdtSlaughterEntrys_carcassQty_TextField.setVisible(true);
        kdtSlaughterEntrys_carcassQty_TextField.setEditable(true);
        kdtSlaughterEntrys_carcassQty_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_carcassQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSlaughterEntrys_carcassQty_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_carcassQty_TextField);
        this.kdtSlaughterEntrys.getColumn("carcassQty").setEditor(kdtSlaughterEntrys_carcassQty_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_carcassWgt_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_carcassWgt_TextField.setName("kdtSlaughterEntrys_carcassWgt_TextField");
        kdtSlaughterEntrys_carcassWgt_TextField.setVisible(true);
        kdtSlaughterEntrys_carcassWgt_TextField.setEditable(true);
        kdtSlaughterEntrys_carcassWgt_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_carcassWgt_TextField.setDataType(1);
        	kdtSlaughterEntrys_carcassWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSlaughterEntrys_carcassWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSlaughterEntrys_carcassWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSlaughterEntrys_carcassWgt_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_carcassWgt_TextField);
        this.kdtSlaughterEntrys.getColumn("carcassWgt").setEditor(kdtSlaughterEntrys_carcassWgt_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_AWeight_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_AWeight_TextField.setName("kdtSlaughterEntrys_AWeight_TextField");
        kdtSlaughterEntrys_AWeight_TextField.setVisible(true);
        kdtSlaughterEntrys_AWeight_TextField.setEditable(true);
        kdtSlaughterEntrys_AWeight_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_AWeight_TextField.setDataType(1);
        	kdtSlaughterEntrys_AWeight_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999999E22"));
        	kdtSlaughterEntrys_AWeight_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999999E22"));
        kdtSlaughterEntrys_AWeight_TextField.setPrecision(5);
        KDTDefaultCellEditor kdtSlaughterEntrys_AWeight_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_AWeight_TextField);
        this.kdtSlaughterEntrys.getColumn("AWeight").setEditor(kdtSlaughterEntrys_AWeight_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_preHouseSuttle_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_preHouseSuttle_TextField.setName("kdtSlaughterEntrys_preHouseSuttle_TextField");
        kdtSlaughterEntrys_preHouseSuttle_TextField.setVisible(true);
        kdtSlaughterEntrys_preHouseSuttle_TextField.setEditable(true);
        kdtSlaughterEntrys_preHouseSuttle_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_preHouseSuttle_TextField.setDataType(1);
        	kdtSlaughterEntrys_preHouseSuttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSlaughterEntrys_preHouseSuttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSlaughterEntrys_preHouseSuttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSlaughterEntrys_preHouseSuttle_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_preHouseSuttle_TextField);
        this.kdtSlaughterEntrys.getColumn("preHouseSuttle").setEditor(kdtSlaughterEntrys_preHouseSuttle_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_inCompleteWgt_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_inCompleteWgt_TextField.setName("kdtSlaughterEntrys_inCompleteWgt_TextField");
        kdtSlaughterEntrys_inCompleteWgt_TextField.setVisible(true);
        kdtSlaughterEntrys_inCompleteWgt_TextField.setEditable(true);
        kdtSlaughterEntrys_inCompleteWgt_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_inCompleteWgt_TextField.setDataType(1);
        	kdtSlaughterEntrys_inCompleteWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSlaughterEntrys_inCompleteWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSlaughterEntrys_inCompleteWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSlaughterEntrys_inCompleteWgt_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_inCompleteWgt_TextField);
        this.kdtSlaughterEntrys.getColumn("inCompleteWgt").setEditor(kdtSlaughterEntrys_inCompleteWgt_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_inCompleteQty_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_inCompleteQty_TextField.setName("kdtSlaughterEntrys_inCompleteQty_TextField");
        kdtSlaughterEntrys_inCompleteQty_TextField.setVisible(true);
        kdtSlaughterEntrys_inCompleteQty_TextField.setEditable(true);
        kdtSlaughterEntrys_inCompleteQty_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_inCompleteQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSlaughterEntrys_inCompleteQty_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_inCompleteQty_TextField);
        this.kdtSlaughterEntrys.getColumn("inCompleteQty").setEditor(kdtSlaughterEntrys_inCompleteQty_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_punishAllWeight_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_punishAllWeight_TextField.setName("kdtSlaughterEntrys_punishAllWeight_TextField");
        kdtSlaughterEntrys_punishAllWeight_TextField.setVisible(true);
        kdtSlaughterEntrys_punishAllWeight_TextField.setEditable(true);
        kdtSlaughterEntrys_punishAllWeight_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_punishAllWeight_TextField.setDataType(1);
        	kdtSlaughterEntrys_punishAllWeight_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999999E22"));
        	kdtSlaughterEntrys_punishAllWeight_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999999E22"));
        kdtSlaughterEntrys_punishAllWeight_TextField.setPrecision(5);
        KDTDefaultCellEditor kdtSlaughterEntrys_punishAllWeight_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_punishAllWeight_TextField);
        this.kdtSlaughterEntrys.getColumn("punishAllWeight").setEditor(kdtSlaughterEntrys_punishAllWeight_CellEditor);
        KDFormattedTextField kdtSlaughterEntrys_settlementAllWig_TextField = new KDFormattedTextField();
        kdtSlaughterEntrys_settlementAllWig_TextField.setName("kdtSlaughterEntrys_settlementAllWig_TextField");
        kdtSlaughterEntrys_settlementAllWig_TextField.setVisible(true);
        kdtSlaughterEntrys_settlementAllWig_TextField.setEditable(true);
        kdtSlaughterEntrys_settlementAllWig_TextField.setHorizontalAlignment(2);
        kdtSlaughterEntrys_settlementAllWig_TextField.setDataType(1);
        	kdtSlaughterEntrys_settlementAllWig_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999999E22"));
        	kdtSlaughterEntrys_settlementAllWig_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999999E22"));
        kdtSlaughterEntrys_settlementAllWig_TextField.setPrecision(5);
        KDTDefaultCellEditor kdtSlaughterEntrys_settlementAllWig_CellEditor = new KDTDefaultCellEditor(kdtSlaughterEntrys_settlementAllWig_TextField);
        this.kdtSlaughterEntrys.getColumn("settlementAllWig").setEditor(kdtSlaughterEntrys_settlementAllWig_CellEditor);
        // kdtSaleEntrys
		String kdtSaleEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"baseStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"saleType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"outSalePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"outSaleAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{baseStatus}</t:Cell><t:Cell>$Resource{saleType}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{recSuttle}</t:Cell><t:Cell>$Resource{outSalePrice}</t:Cell><t:Cell>$Resource{outSaleAmt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSaleEntrys.setFormatXml(resHelper.translateString("kdtSaleEntrys",kdtSaleEntrysStrXML));

                this.kdtSaleEntrys.putBindContents("editData",new String[] {"seq","bizDate","billNumber","billStatus","baseStatus","saleType","customer","recSuttle","outSalePrice","outSaleAmt"});


        this.kdtSaleEntrys.checkParsed();
        KDFormattedTextField kdtSaleEntrys_seq_TextField = new KDFormattedTextField();
        kdtSaleEntrys_seq_TextField.setName("kdtSaleEntrys_seq_TextField");
        kdtSaleEntrys_seq_TextField.setVisible(true);
        kdtSaleEntrys_seq_TextField.setEditable(true);
        kdtSaleEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtSaleEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSaleEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_seq_TextField);
        this.kdtSaleEntrys.getColumn("seq").setEditor(kdtSaleEntrys_seq_CellEditor);
        KDDatePicker kdtSaleEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtSaleEntrys_bizDate_DatePicker.setName("kdtSaleEntrys_bizDate_DatePicker");
        kdtSaleEntrys_bizDate_DatePicker.setVisible(true);
        kdtSaleEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtSaleEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_bizDate_DatePicker);
        this.kdtSaleEntrys.getColumn("bizDate").setEditor(kdtSaleEntrys_bizDate_CellEditor);
        KDTextField kdtSaleEntrys_billNumber_TextField = new KDTextField();
        kdtSaleEntrys_billNumber_TextField.setName("kdtSaleEntrys_billNumber_TextField");
        kdtSaleEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSaleEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_billNumber_TextField);
        this.kdtSaleEntrys.getColumn("billNumber").setEditor(kdtSaleEntrys_billNumber_CellEditor);
        KDComboBox kdtSaleEntrys_billStatus_ComboBox = new KDComboBox();
        kdtSaleEntrys_billStatus_ComboBox.setName("kdtSaleEntrys_billStatus_ComboBox");
        kdtSaleEntrys_billStatus_ComboBox.setVisible(true);
        kdtSaleEntrys_billStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtSaleEntrys_billStatus_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_billStatus_ComboBox);
        this.kdtSaleEntrys.getColumn("billStatus").setEditor(kdtSaleEntrys_billStatus_CellEditor);
        KDComboBox kdtSaleEntrys_baseStatus_ComboBox = new KDComboBox();
        kdtSaleEntrys_baseStatus_ComboBox.setName("kdtSaleEntrys_baseStatus_ComboBox");
        kdtSaleEntrys_baseStatus_ComboBox.setVisible(true);
        kdtSaleEntrys_baseStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());
        KDTDefaultCellEditor kdtSaleEntrys_baseStatus_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_baseStatus_ComboBox);
        this.kdtSaleEntrys.getColumn("baseStatus").setEditor(kdtSaleEntrys_baseStatus_CellEditor);
        KDComboBox kdtSaleEntrys_saleType_ComboBox = new KDComboBox();
        kdtSaleEntrys_saleType_ComboBox.setName("kdtSaleEntrys_saleType_ComboBox");
        kdtSaleEntrys_saleType_ComboBox.setVisible(true);
        kdtSaleEntrys_saleType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType").toArray());
        KDTDefaultCellEditor kdtSaleEntrys_saleType_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_saleType_ComboBox);
        this.kdtSaleEntrys.getColumn("saleType").setEditor(kdtSaleEntrys_saleType_CellEditor);
        final KDBizPromptBox kdtSaleEntrys_customer_PromptBox = new KDBizPromptBox();
        kdtSaleEntrys_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtSaleEntrys_customer_PromptBox.setVisible(true);
        kdtSaleEntrys_customer_PromptBox.setEditable(true);
        kdtSaleEntrys_customer_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntrys_customer_PromptBox.setEditFormat("$number$");
        kdtSaleEntrys_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntrys_customer_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_customer_PromptBox);
        this.kdtSaleEntrys.getColumn("customer").setEditor(kdtSaleEntrys_customer_CellEditor);
        ObjectValueRender kdtSaleEntrys_customer_OVR = new ObjectValueRender();
        kdtSaleEntrys_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSaleEntrys.getColumn("customer").setRenderer(kdtSaleEntrys_customer_OVR);
        KDFormattedTextField kdtSaleEntrys_recSuttle_TextField = new KDFormattedTextField();
        kdtSaleEntrys_recSuttle_TextField.setName("kdtSaleEntrys_recSuttle_TextField");
        kdtSaleEntrys_recSuttle_TextField.setVisible(true);
        kdtSaleEntrys_recSuttle_TextField.setEditable(true);
        kdtSaleEntrys_recSuttle_TextField.setHorizontalAlignment(2);
        kdtSaleEntrys_recSuttle_TextField.setDataType(1);
        	kdtSaleEntrys_recSuttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSaleEntrys_recSuttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSaleEntrys_recSuttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSaleEntrys_recSuttle_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_recSuttle_TextField);
        this.kdtSaleEntrys.getColumn("recSuttle").setEditor(kdtSaleEntrys_recSuttle_CellEditor);
        KDFormattedTextField kdtSaleEntrys_outSalePrice_TextField = new KDFormattedTextField();
        kdtSaleEntrys_outSalePrice_TextField.setName("kdtSaleEntrys_outSalePrice_TextField");
        kdtSaleEntrys_outSalePrice_TextField.setVisible(true);
        kdtSaleEntrys_outSalePrice_TextField.setEditable(true);
        kdtSaleEntrys_outSalePrice_TextField.setHorizontalAlignment(2);
        kdtSaleEntrys_outSalePrice_TextField.setDataType(1);
        	kdtSaleEntrys_outSalePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSaleEntrys_outSalePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSaleEntrys_outSalePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSaleEntrys_outSalePrice_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_outSalePrice_TextField);
        this.kdtSaleEntrys.getColumn("outSalePrice").setEditor(kdtSaleEntrys_outSalePrice_CellEditor);
        KDFormattedTextField kdtSaleEntrys_outSaleAmt_TextField = new KDFormattedTextField();
        kdtSaleEntrys_outSaleAmt_TextField.setName("kdtSaleEntrys_outSaleAmt_TextField");
        kdtSaleEntrys_outSaleAmt_TextField.setVisible(true);
        kdtSaleEntrys_outSaleAmt_TextField.setEditable(true);
        kdtSaleEntrys_outSaleAmt_TextField.setHorizontalAlignment(2);
        kdtSaleEntrys_outSaleAmt_TextField.setDataType(1);
        	kdtSaleEntrys_outSaleAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSaleEntrys_outSaleAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSaleEntrys_outSaleAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSaleEntrys_outSaleAmt_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_outSaleAmt_TextField);
        this.kdtSaleEntrys.getColumn("outSaleAmt").setEditor(kdtSaleEntrys_outSaleAmt_CellEditor);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // btnExecSettle
        this.btnExecSettle.setAction((IItemAction)ActionProxyFactory.getProxy(actionExecSettle, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnExecSettle.setText(resHelper.getString("btnExecSettle.text"));		
        this.btnExecSettle.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_settleaccounts"));
        // btnUpdateSaleData
        this.btnUpdateSaleData.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateSaleData, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateSaleData.setText(resHelper.getString("btnUpdateSaleData.text"));		
        this.btnUpdateSaleData.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_applyworkcalendar"));
        // btnupdateActAmt
        this.btnupdateActAmt.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateActAmt, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnupdateActAmt.setText(resHelper.getString("btnupdateActAmt.text"));
        // hasPay
        this.hasPay.setAction((IItemAction)ActionProxyFactory.getProxy(actionHasPay, new Class[] { IItemAction.class }, getServiceContext()));		
        this.hasPay.setText(resHelper.getString("hasPay.text"));
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkFivouchered,prmtFICompany,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtstorageOrgUnit,billStatus,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,prmtbreedData,pkcFBeginDate,pkcFEndDate,prmtconFeedPolicy,txtconFeededNum,prmtbEBank,txtbankNum,txtbEBankAddress,prmtperson,pkinDate,txtbatchQty,txtbatchAmt,txtfeedWgt,txtfeedQty,txtfeedAmt,txtdrugAmt,pkrecDate,txtrecQty,txtpreHouseWgt,txtpunishWgt,txtsettleWgt,txtmeatRate,txtsurvivalRate,txtchickenAveWgt,txtfeedDays,txtmlyAllAmt,txtrecAmt,txtpunishAmt,txtmarginAmt,txtadPayAmount,txtdyFee,txtsingleDyFee,chkisHasPaymentBill,chkisKouBZJ,txtmRatePAmt,txtactualMRate,txtstandardMRate,txtdrugLackPAmt,txtsingleActualDrug,txtsingleStandardDrug,txtmarginOccupyFee,txtbatchOccupyMargin,txtstandardMargin,txtsingleMargin,txtconFeedSubsidies,prmtkbConFeedPolicy,txtcontractCKWgt,txtfreightDiffSubsidies,txtlFeedWgt,txtfreightPrice,txtfreightSubsidiesStd,txtdeductMargin,txttotalMargin,txtoccupyMargin,txtenableMargin,txtdeductAdPayAmt,txtloanRate,txtkYFKOccupyFee,pkauditTime,txtsingleDrugAmt,txtsingleFeedWgt,txtoValue,prmtconFeedContract,txtfmRatePunishStd,txtdyfBalance,txtkbItemAmt,txtQCItemAmt,txtviewItemAmt,txtotherItemAmt,txttempItemAmt,txtmoneyOccupyDays,txtconFeedPolicySub,txtpayOweMonery,txtoutSaleKbAmt,txtactualPayAmt,txtpayOweMoneryB,txtSeedCost,txtfodderCost,txtdrugCost,txtallocateAmt,txtunitCost,txtallCost,txtunLockedMargin,txtrecSuttle,txtadPayBalance,prmtsettlePolicy,txtQCKbDetail,txtotherKbDetail,farmsType,txtoutSaleKbAmt2,txtimmuneCost,txtimmuneCostOne,txtcleanHouse,txtcleanHouseOne,txtreserveRiskCost,txtactualFoder,txtstandFodder,txtoneMrgin,txtmarginGAmount,txtchickenRetunAmt,txtlongBorrowAmount,txtlongBorrowReturn,txtmarginProfit,txtbeforeBatchAmount,txtborrowAmiunt,txtspecialBorrowinst,txttranCost,txtbrokenCost,txtcoalCost,txtidCodeCode,txtfarmAddress,chknoCalFodderPunish,chknoCalDrupPunish,txtequipmentReAmt,txtspecialPermitAmt,txtgetChickCost,txtcleanHouseCost,txtchickenSource,kdtQCEntrys,prmtperiod,txtdaiyFee,txtcompanyProfit,txtcleanTowerCost,kdtEntrys,txtnowAccountBac,txtassetsOccupy,prmtcostCenter,chkisOrdinary,kdtViewReqEntrys,txtdrugQty,txtnoPfoRetAmt,txtfarmeronlyPro,txtfarmerOnlyProOne,kdtOtherEntrys,txtotherMatCost,chkactualVoucher,chkpreVoucher,chktransVoucher,kdtSeedEntrys,chkhasPay,kdtFodderEntrys,kdtDrugEntrys,kdtSlaughterEntrys,kdtSaleEntrys,kdtPreHouseEntrys,kdtSeedSourceEntrys,kdtTempPolicyEntrys,txtproDiv,txtcompanyTC,txtdiverCt}));
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
        this.setBounds(new Rectangle(0, 0, 1189, 974));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1189, 974));
        contCreator.setBounds(new Rectangle(408, 926, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(408, 926, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(870, 926, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(870, 926, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(408, 947, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(408, 947, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(870, 947, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(870, 947, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(23, 926, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(23, 926, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(8, 10, 1171, 571));
        this.add(kDTabbedPane1, new KDLayout.Constraints(8, 10, 1171, 571, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane3.setBounds(new Rectangle(9, 602, 1164, 318));
        this.add(kDTabbedPane3, new KDLayout.Constraints(9, 602, 1164, 318, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(21, 947, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(21, 947, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(-11, 593, 1237, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-11, 593, 1237, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kblBatchContract.setBounds(new Rectangle(1182, 900, 239, 19));
        this.add(kblBatchContract, new KDLayout.Constraints(1182, 900, 239, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel13, resHelper.getString("kDPanel13.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel17, resHelper.getString("kDPanel17.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1170, 538));        chkFivouchered.setBounds(new Rectangle(20, 522, 119, 19));
        kDPanel1.add(chkFivouchered, new KDLayout.Constraints(20, 522, 119, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleDyFee.setBounds(new Rectangle(300, 251, 270, 19));
        kDPanel1.add(contsingleDyFee, new KDLayout.Constraints(300, 251, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpunishAmt.setBounds(new Rectangle(300, 224, 270, 19));
        kDPanel1.add(contpunishAmt, new KDLayout.Constraints(300, 224, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmeatRate.setBounds(new Rectangle(300, 170, 270, 19));
        kDPanel1.add(contmeatRate, new KDLayout.Constraints(300, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseWgt.setBounds(new Rectangle(528, 497, 270, 19));
        kDPanel1.add(contpreHouseWgt, new KDLayout.Constraints(528, 497, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugAmt.setBounds(new Rectangle(579, 143, 270, 19));
        kDPanel1.add(contdrugAmt, new KDLayout.Constraints(579, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchAmt.setBounds(new Rectangle(15, 143, 270, 19));
        kDPanel1.add(contbatchAmt, new KDLayout.Constraints(15, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbEBankAddress.setBounds(new Rectangle(299, 330, 270, 19));
        kDPanel1.add(contbEBankAddress, new KDLayout.Constraints(299, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconFeedPolicy.setBounds(new Rectangle(578, 357, 270, 19));
        kDPanel1.add(contconFeedPolicy, new KDLayout.Constraints(578, 357, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(579, 384, 270, 19));
        kDPanel1.add(contbatch, new KDLayout.Constraints(579, 384, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(858, 8, 270, 19));
        kDPanel1.add(contbillStatus, new KDLayout.Constraints(858, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(15, 8, 270, 19));
        kDPanel1.add(contNumber, new KDLayout.Constraints(15, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(300, 8, 270, 19));
        kDPanel1.add(contBizDate, new KDLayout.Constraints(300, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(15, 35, 270, 19));
        kDPanel1.add(contfarmer, new KDLayout.Constraints(15, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(859, 330, 270, 19));
        kDPanel1.add(contbreedData, new KDLayout.Constraints(859, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contconFeededNum.setBounds(new Rectangle(15, 410, 270, 19));
        kDPanel1.add(contconFeededNum, new KDLayout.Constraints(15, 410, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(579, 276, 270, 19));
        kDPanel1.add(contperson, new KDLayout.Constraints(579, 276, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedWgt.setBounds(new Rectangle(300, 116, 270, 19));
        kDPanel1.add(contfeedWgt, new KDLayout.Constraints(300, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecDate.setBounds(new Rectangle(858, 62, 270, 19));
        kDPanel1.add(contrecDate, new KDLayout.Constraints(858, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpunishWgt.setBounds(new Rectangle(858, 170, 270, 19));
        kDPanel1.add(contpunishWgt, new KDLayout.Constraints(858, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsurvivalRate.setBounds(new Rectangle(300, 89, 270, 19));
        kDPanel1.add(contsurvivalRate, new KDLayout.Constraints(300, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarginAmt.setBounds(new Rectangle(15, 303, 270, 19));
        kDPanel1.add(contmarginAmt, new KDLayout.Constraints(15, 303, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasPaymentBill.setBounds(new Rectangle(299, 522, 126, 19));
        kDPanel1.add(chkisHasPaymentBill, new KDLayout.Constraints(299, 522, 126, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisKouBZJ.setBounds(new Rectangle(163, 522, 122, 19));
        kDPanel1.add(chkisKouBZJ, new KDLayout.Constraints(163, 522, 122, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadPayAmount.setBounds(new Rectangle(967, 516, 270, 19));
        kDPanel1.add(contadPayAmount, new KDLayout.Constraints(967, 516, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmlyAllAmt.setBounds(new Rectangle(858, 143, 270, 19));
        kDPanel1.add(contmlyAllAmt, new KDLayout.Constraints(858, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchickenAveWgt.setBounds(new Rectangle(579, 89, 270, 19));
        kDPanel1.add(contchickenAveWgt, new KDLayout.Constraints(579, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettleWgt.setBounds(new Rectangle(15, 170, 270, 19));
        kDPanel1.add(contsettleWgt, new KDLayout.Constraints(15, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecQty.setBounds(new Rectangle(15, 89, 270, 19));
        kDPanel1.add(contrecQty, new KDLayout.Constraints(15, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedQty.setBounds(new Rectangle(789, -31, 270, 19));
        kDPanel1.add(contfeedQty, new KDLayout.Constraints(789, -31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continDate.setBounds(new Rectangle(579, 62, 270, 19));
        kDPanel1.add(continDate, new KDLayout.Constraints(579, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbEBank.setBounds(new Rectangle(15, 384, 270, 19));
        kDPanel1.add(contbEBank, new KDLayout.Constraints(15, 384, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcFBeginDate.setBounds(new Rectangle(578, 303, 270, 19));
        kDPanel1.add(contcFBeginDate, new KDLayout.Constraints(578, 303, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(579, 35, 270, 19));
        kDPanel1.add(contfarm, new KDLayout.Constraints(579, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(579, 8, 270, 19));
        kDPanel1.add(contFICompany, new KDLayout.Constraints(579, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstorageOrgUnit.setBounds(new Rectangle(859, 384, 270, 19));
        kDPanel1.add(contstorageOrgUnit, new KDLayout.Constraints(859, 384, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatchContract.setBounds(new Rectangle(15, 62, 270, 19));
        kDPanel1.add(contbatchContract, new KDLayout.Constraints(15, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcFEndDate.setBounds(new Rectangle(859, 357, 270, 19));
        kDPanel1.add(contcFEndDate, new KDLayout.Constraints(859, 357, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbankNum.setBounds(new Rectangle(578, 330, 270, 19));
        kDPanel1.add(contbankNum, new KDLayout.Constraints(578, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(15, 116, 270, 19));
        kDPanel1.add(contbatchQty, new KDLayout.Constraints(15, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedAmt.setBounds(new Rectangle(300, 143, 270, 19));
        kDPanel1.add(contfeedAmt, new KDLayout.Constraints(300, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedDays.setBounds(new Rectangle(858, 89, 270, 19));
        kDPanel1.add(contfeedDays, new KDLayout.Constraints(858, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecAmt.setBounds(new Rectangle(859, 250, 270, 19));
        kDPanel1.add(contrecAmt, new KDLayout.Constraints(859, 250, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdyFee.setBounds(new Rectangle(15, 251, 270, 19));
        kDPanel1.add(contdyFee, new KDLayout.Constraints(15, 251, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleDrugAmt.setBounds(new Rectangle(858, 116, 270, 19));
        kDPanel1.add(contsingleDrugAmt, new KDLayout.Constraints(858, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsingleFeedWgt.setBounds(new Rectangle(579, 116, 270, 19));
        kDPanel1.add(contsingleFeedWgt, new KDLayout.Constraints(579, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoValue.setBounds(new Rectangle(579, 170, 270, 19));
        kDPanel1.add(contoValue, new KDLayout.Constraints(579, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconFeedContract.setBounds(new Rectangle(579, 410, 270, 19));
        kDPanel1.add(contconFeedContract, new KDLayout.Constraints(579, 410, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkbItemAmt.setBounds(new Rectangle(15, 197, 270, 19));
        kDPanel1.add(contkbItemAmt, new KDLayout.Constraints(15, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contQCItemAmt.setBounds(new Rectangle(300, 197, 270, 19));
        kDPanel1.add(contQCItemAmt, new KDLayout.Constraints(300, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contviewItemAmt.setBounds(new Rectangle(579, 197, 270, 19));
        kDPanel1.add(contviewItemAmt, new KDLayout.Constraints(579, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherItemAmt.setBounds(new Rectangle(858, 197, 270, 19));
        kDPanel1.add(contotherItemAmt, new KDLayout.Constraints(858, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttempItemAmt.setBounds(new Rectangle(15, 224, 270, 19));
        kDPanel1.add(conttempItemAmt, new KDLayout.Constraints(15, 224, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpayOweMoneryB.setBounds(new Rectangle(223, 493, 270, 19));
        kDPanel1.add(contpayOweMoneryB, new KDLayout.Constraints(223, 493, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecSuttle.setBounds(new Rectangle(501, 493, 270, 19));
        kDPanel1.add(contrecSuttle, new KDLayout.Constraints(501, 493, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(298, 384, 270, 19));
        kDPanel1.add(contsettlePolicy, new KDLayout.Constraints(298, 384, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmsType.setBounds(new Rectangle(299, 357, 270, 19));
        kDPanel1.add(contfarmsType, new KDLayout.Constraints(299, 357, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSaleKbAmt2.setBounds(new Rectangle(858, 224, 270, 19));
        kDPanel1.add(contoutSaleKbAmt2, new KDLayout.Constraints(858, 224, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel14.setBounds(new Rectangle(1076, 504, 78, 26));
        kDPanel1.add(kDPanel14, new KDLayout.Constraints(1076, 504, 78, 26, 0));
        kDPanel16.setBounds(new Rectangle(940, 505, 57, 30));
        kDPanel1.add(kDPanel16, new KDLayout.Constraints(940, 505, 57, 30, 0));
        contchickenRetunAmt.setBounds(new Rectangle(579, 224, 270, 19));
        kDPanel1.add(contchickenRetunAmt, new KDLayout.Constraints(579, 224, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeforeBatchAmount.setBounds(new Rectangle(300, 62, 270, 19));
        kDPanel1.add(contbeforeBatchAmount, new KDLayout.Constraints(300, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contidCodeCode.setBounds(new Rectangle(300, 35, 270, 19));
        kDPanel1.add(contidCodeCode, new KDLayout.Constraints(300, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(858, 35, 270, 19));
        kDPanel1.add(contfarmAddress, new KDLayout.Constraints(858, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchickenSource.setBounds(new Rectangle(859, 301, 272, 19));
        kDPanel1.add(contchickenSource, new KDLayout.Constraints(859, 301, 272, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(579, 251, 270, 19));
        kDPanel1.add(contperiod, new KDLayout.Constraints(579, 251, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoneMrgin.setBounds(new Rectangle(15, 357, 270, 19));
        kDPanel1.add(contoneMrgin, new KDLayout.Constraints(15, 357, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostCenter.setBounds(new Rectangle(299, 303, 270, 19));
        kDPanel1.add(contcostCenter, new KDLayout.Constraints(299, 303, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugQty.setBounds(new Rectangle(298, 410, 270, 19));
        kDPanel1.add(contdrugQty, new KDLayout.Constraints(298, 410, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmeronlyPro.setBounds(new Rectangle(18, 455, 270, 19));
        kDPanel1.add(contfarmeronlyPro, new KDLayout.Constraints(18, 455, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerOnlyProOne.setBounds(new Rectangle(303, 455, 270, 19));
        kDPanel1.add(contfarmerOnlyProOne, new KDLayout.Constraints(303, 455, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contproDiv.setBounds(new Rectangle(859, 276, 270, 19));
        kDPanel1.add(contproDiv, new KDLayout.Constraints(859, 276, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoccupyMargin.setBounds(new Rectangle(15, 330, 270, 19));
        kDPanel1.add(contoccupyMargin, new KDLayout.Constraints(15, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contsingleDyFee
        contsingleDyFee.setBoundEditor(txtsingleDyFee);
        //contpunishAmt
        contpunishAmt.setBoundEditor(txtpunishAmt);
        //contmeatRate
        contmeatRate.setBoundEditor(txtmeatRate);
        //contpreHouseWgt
        contpreHouseWgt.setBoundEditor(txtpreHouseWgt);
        //contdrugAmt
        contdrugAmt.setBoundEditor(txtdrugAmt);
        //contbatchAmt
        contbatchAmt.setBoundEditor(txtbatchAmt);
        //contbEBankAddress
        contbEBankAddress.setBoundEditor(txtbEBankAddress);
        //contconFeedPolicy
        contconFeedPolicy.setBoundEditor(prmtconFeedPolicy);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contconFeededNum
        contconFeededNum.setBoundEditor(txtconFeededNum);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contfeedWgt
        contfeedWgt.setBoundEditor(txtfeedWgt);
        //contrecDate
        contrecDate.setBoundEditor(pkrecDate);
        //contpunishWgt
        contpunishWgt.setBoundEditor(txtpunishWgt);
        //contsurvivalRate
        contsurvivalRate.setBoundEditor(txtsurvivalRate);
        //contmarginAmt
        contmarginAmt.setBoundEditor(txtmarginAmt);
        //contadPayAmount
        contadPayAmount.setBoundEditor(txtadPayAmount);
        //contmlyAllAmt
        contmlyAllAmt.setBoundEditor(txtmlyAllAmt);
        //contchickenAveWgt
        contchickenAveWgt.setBoundEditor(txtchickenAveWgt);
        //contsettleWgt
        contsettleWgt.setBoundEditor(txtsettleWgt);
        //contrecQty
        contrecQty.setBoundEditor(txtrecQty);
        //contfeedQty
        contfeedQty.setBoundEditor(txtfeedQty);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contbEBank
        contbEBank.setBoundEditor(prmtbEBank);
        //contcFBeginDate
        contcFBeginDate.setBoundEditor(pkcFBeginDate);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contcFEndDate
        contcFEndDate.setBoundEditor(pkcFEndDate);
        //contbankNum
        contbankNum.setBoundEditor(txtbankNum);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //contfeedAmt
        contfeedAmt.setBoundEditor(txtfeedAmt);
        //contfeedDays
        contfeedDays.setBoundEditor(txtfeedDays);
        //contrecAmt
        contrecAmt.setBoundEditor(txtrecAmt);
        //contdyFee
        contdyFee.setBoundEditor(txtdyFee);
        //contsingleDrugAmt
        contsingleDrugAmt.setBoundEditor(txtsingleDrugAmt);
        //contsingleFeedWgt
        contsingleFeedWgt.setBoundEditor(txtsingleFeedWgt);
        //contoValue
        contoValue.setBoundEditor(txtoValue);
        //contconFeedContract
        contconFeedContract.setBoundEditor(prmtconFeedContract);
        //contkbItemAmt
        contkbItemAmt.setBoundEditor(txtkbItemAmt);
        //contQCItemAmt
        contQCItemAmt.setBoundEditor(txtQCItemAmt);
        //contviewItemAmt
        contviewItemAmt.setBoundEditor(txtviewItemAmt);
        //contotherItemAmt
        contotherItemAmt.setBoundEditor(txtotherItemAmt);
        //conttempItemAmt
        conttempItemAmt.setBoundEditor(txttempItemAmt);
        //contpayOweMoneryB
        contpayOweMoneryB.setBoundEditor(txtpayOweMoneryB);
        //contrecSuttle
        contrecSuttle.setBoundEditor(txtrecSuttle);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contfarmsType
        contfarmsType.setBoundEditor(farmsType);
        //contoutSaleKbAmt2
        contoutSaleKbAmt2.setBoundEditor(txtoutSaleKbAmt2);
        //kDPanel14
        kDPanel14.setLayout(new KDLayout());
        kDPanel14.putClientProperty("OriginalBounds", new Rectangle(1076, 504, 78, 26));        kdtPreHouseEntrys.setBounds(new Rectangle(28, 20, 1133, 230));
        kdtPreHouseEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPreHouseEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryInfo(),null,false);
        kDPanel14.add(kdtPreHouseEntrys_detailPanel, new KDLayout.Constraints(28, 20, 1133, 230, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtPreHouseEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel16
        kDPanel16.setLayout(new KDLayout());
        kDPanel16.putClientProperty("OriginalBounds", new Rectangle(940, 505, 57, 30));        kdtSeedSourceEntrys.setBounds(new Rectangle(32, 14, 1127, 235));
        kdtSeedSourceEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSeedSourceEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryInfo(),null,false);
        kDPanel16.add(kdtSeedSourceEntrys_detailPanel, new KDLayout.Constraints(32, 14, 1127, 235, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contchickenRetunAmt
        contchickenRetunAmt.setBoundEditor(txtchickenRetunAmt);
        //contbeforeBatchAmount
        contbeforeBatchAmount.setBoundEditor(txtbeforeBatchAmount);
        //contidCodeCode
        contidCodeCode.setBoundEditor(txtidCodeCode);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contchickenSource
        contchickenSource.setBoundEditor(txtchickenSource);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contoneMrgin
        contoneMrgin.setBoundEditor(txtoneMrgin);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contdrugQty
        contdrugQty.setBoundEditor(txtdrugQty);
        //contfarmeronlyPro
        contfarmeronlyPro.setBoundEditor(txtfarmeronlyPro);
        //contfarmerOnlyProOne
        contfarmerOnlyProOne.setBoundEditor(txtfarmerOnlyProOne);
        //contproDiv
        contproDiv.setBoundEditor(txtproDiv);
        //contoccupyMargin
        contoccupyMargin.setBoundEditor(txtoccupyMargin);
        //kDPanel13
        kDPanel13.setLayout(new KDLayout());
        kDPanel13.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1170, 538));        kdtEntrys.setBounds(new Rectangle(7, 39, 1153, 489));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryInfo(),null,false);
        kDPanel13.add(kdtEntrys_detailPanel, new KDLayout.Constraints(7, 39, 1153, 489, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("recType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        chkisOrdinary.setBounds(new Rectangle(11, 8, 270, 19));
        kDPanel13.add(chkisOrdinary, new KDLayout.Constraints(11, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1170, 538));        kDTabbedPane2.setBounds(new Rectangle(7, 11, 1150, 516));
        kDPanel2.add(kDTabbedPane2, new KDLayout.Constraints(7, 11, 1150, 516, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane2.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        kDTabbedPane2.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        kDTabbedPane2.add(kDPanel7, resHelper.getString("kDPanel7.constraints"));
        kDTabbedPane2.add(kDPanel15, resHelper.getString("kDPanel15.constraints"));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1149, 483));        contmRatePAmt.setBounds(new Rectangle(13, 22, 270, 19));
        kDPanel4.add(contmRatePAmt, new KDLayout.Constraints(13, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualMRate.setBounds(new Rectangle(295, 22, 270, 19));
        kDPanel4.add(contactualMRate, new KDLayout.Constraints(295, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandardMRate.setBounds(new Rectangle(577, 22, 270, 19));
        kDPanel4.add(contstandardMRate, new KDLayout.Constraints(577, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugLackPAmt.setBounds(new Rectangle(13, 83, 270, 19));
        kDPanel4.add(contdrugLackPAmt, new KDLayout.Constraints(13, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleActualDrug.setBounds(new Rectangle(295, 84, 270, 19));
        kDPanel4.add(contsingleActualDrug, new KDLayout.Constraints(295, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleStandardDrug.setBounds(new Rectangle(577, 84, 270, 19));
        kDPanel4.add(contsingleStandardDrug, new KDLayout.Constraints(577, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarginOccupyFee.setBounds(new Rectangle(13, 335, 270, 19));
        kDPanel4.add(contmarginOccupyFee, new KDLayout.Constraints(13, 335, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchOccupyMargin.setBounds(new Rectangle(583, 335, 270, 19));
        kDPanel4.add(contbatchOccupyMargin, new KDLayout.Constraints(583, 335, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandardMargin.setBounds(new Rectangle(299, 219, 270, 19));
        kDPanel4.add(contstandardMargin, new KDLayout.Constraints(299, 219, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleMargin.setBounds(new Rectangle(295, 112, 270, 19));
        kDPanel4.add(contsingleMargin, new KDLayout.Constraints(295, 112, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconFeedSubsidies.setBounds(new Rectangle(583, 306, 270, 19));
        kDPanel4.add(contconFeedSubsidies, new KDLayout.Constraints(583, 306, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkbConFeedPolicy.setBounds(new Rectangle(860, 306, 270, 19));
        kDPanel4.add(contkbConFeedPolicy, new KDLayout.Constraints(860, 306, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractCKWgt.setBounds(new Rectangle(583, 364, 270, 19));
        kDPanel4.add(contcontractCKWgt, new KDLayout.Constraints(583, 364, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfreightDiffSubsidies.setBounds(new Rectangle(13, 219, 270, 19));
        kDPanel4.add(contfreightDiffSubsidies, new KDLayout.Constraints(13, 219, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlFeedWgt.setBounds(new Rectangle(299, 248, 270, 19));
        kDPanel4.add(contlFeedWgt, new KDLayout.Constraints(299, 248, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfreightPrice.setBounds(new Rectangle(583, 396, 270, 19));
        kDPanel4.add(contfreightPrice, new KDLayout.Constraints(583, 396, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfreightSubsidiesStd.setBounds(new Rectangle(860, 364, 270, 19));
        kDPanel4.add(contfreightSubsidiesStd, new KDLayout.Constraints(860, 364, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdeductMargin.setBounds(new Rectangle(13, 248, 270, 19));
        kDPanel4.add(contdeductMargin, new KDLayout.Constraints(13, 248, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalMargin.setBounds(new Rectangle(299, 277, 270, 19));
        kDPanel4.add(conttotalMargin, new KDLayout.Constraints(299, 277, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenableMargin.setBounds(new Rectangle(860, 219, 270, 19));
        kDPanel4.add(contenableMargin, new KDLayout.Constraints(860, 219, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdeductAdPayAmt.setBounds(new Rectangle(299, 306, 270, 19));
        kDPanel4.add(contdeductAdPayAmt, new KDLayout.Constraints(299, 306, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contloanRate.setBounds(new Rectangle(583, 277, 270, 19));
        kDPanel4.add(contloanRate, new KDLayout.Constraints(583, 277, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkYFKOccupyFee.setBounds(new Rectangle(860, 277, 270, 19));
        kDPanel4.add(contkYFKOccupyFee, new KDLayout.Constraints(860, 277, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfmRatePunishStd.setBounds(new Rectangle(860, 22, 270, 19));
        kDPanel4.add(contfmRatePunishStd, new KDLayout.Constraints(860, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdyfBalance.setBounds(new Rectangle(860, 248, 270, 19));
        kDPanel4.add(contdyfBalance, new KDLayout.Constraints(860, 248, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmoneyOccupyDays.setBounds(new Rectangle(299, 335, 270, 19));
        kDPanel4.add(contmoneyOccupyDays, new KDLayout.Constraints(299, 335, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconFeedPolicySub.setBounds(new Rectangle(860, 335, 270, 19));
        kDPanel4.add(contconFeedPolicySub, new KDLayout.Constraints(860, 335, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpayOweMonery.setBounds(new Rectangle(13, 277, 270, 19));
        kDPanel4.add(contpayOweMonery, new KDLayout.Constraints(13, 277, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSaleKbAmt.setBounds(new Rectangle(583, 248, 270, 19));
        kDPanel4.add(contoutSaleKbAmt, new KDLayout.Constraints(583, 248, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunLockedMargin.setBounds(new Rectangle(13, 111, 270, 19));
        kDPanel4.add(contunLockedMargin, new KDLayout.Constraints(13, 111, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadPayBalance.setBounds(new Rectangle(13, 306, 270, 19));
        kDPanel4.add(contadPayBalance, new KDLayout.Constraints(13, 306, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contQCKbDetail.setBounds(new Rectangle(13, 364, 273, 22));
        kDPanel4.add(contQCKbDetail, new KDLayout.Constraints(13, 364, 273, 22, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contotherKbDetail.setBounds(new Rectangle(299, 364, 272, 24));
        kDPanel4.add(contotherKbDetail, new KDLayout.Constraints(299, 364, 272, 24, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contimmuneCost.setBounds(new Rectangle(860, 396, 270, 19));
        kDPanel4.add(contimmuneCost, new KDLayout.Constraints(860, 396, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contimmuneCostOne.setBounds(new Rectangle(583, 219, 270, 19));
        kDPanel4.add(contimmuneCostOne, new KDLayout.Constraints(583, 219, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcleanHouse.setBounds(new Rectangle(13, 396, 270, 19));
        kDPanel4.add(contcleanHouse, new KDLayout.Constraints(13, 396, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcleanHouseOne.setBounds(new Rectangle(299, 396, 270, 19));
        kDPanel4.add(contcleanHouseOne, new KDLayout.Constraints(299, 396, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualFoder.setBounds(new Rectangle(295, 53, 270, 19));
        kDPanel4.add(contactualFoder, new KDLayout.Constraints(295, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandFodder.setBounds(new Rectangle(577, 53, 270, 19));
        kDPanel4.add(contstandFodder, new KDLayout.Constraints(577, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chknoCalFodderPunish.setBounds(new Rectangle(13, 138, 270, 19));
        kDPanel4.add(chknoCalFodderPunish, new KDLayout.Constraints(13, 138, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chknoCalDrupPunish.setBounds(new Rectangle(13, 162, 270, 19));
        kDPanel4.add(chknoCalDrupPunish, new KDLayout.Constraints(13, 162, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contmRatePAmt
        contmRatePAmt.setBoundEditor(txtmRatePAmt);
        //contactualMRate
        contactualMRate.setBoundEditor(txtactualMRate);
        //contstandardMRate
        contstandardMRate.setBoundEditor(txtstandardMRate);
        //contdrugLackPAmt
        contdrugLackPAmt.setBoundEditor(txtdrugLackPAmt);
        //contsingleActualDrug
        contsingleActualDrug.setBoundEditor(txtsingleActualDrug);
        //contsingleStandardDrug
        contsingleStandardDrug.setBoundEditor(txtsingleStandardDrug);
        //contmarginOccupyFee
        contmarginOccupyFee.setBoundEditor(txtmarginOccupyFee);
        //contbatchOccupyMargin
        contbatchOccupyMargin.setBoundEditor(txtbatchOccupyMargin);
        //contstandardMargin
        contstandardMargin.setBoundEditor(txtstandardMargin);
        //contsingleMargin
        contsingleMargin.setBoundEditor(txtsingleMargin);
        //contconFeedSubsidies
        contconFeedSubsidies.setBoundEditor(txtconFeedSubsidies);
        //contkbConFeedPolicy
        contkbConFeedPolicy.setBoundEditor(prmtkbConFeedPolicy);
        //contcontractCKWgt
        contcontractCKWgt.setBoundEditor(txtcontractCKWgt);
        //contfreightDiffSubsidies
        contfreightDiffSubsidies.setBoundEditor(txtfreightDiffSubsidies);
        //contlFeedWgt
        contlFeedWgt.setBoundEditor(txtlFeedWgt);
        //contfreightPrice
        contfreightPrice.setBoundEditor(txtfreightPrice);
        //contfreightSubsidiesStd
        contfreightSubsidiesStd.setBoundEditor(txtfreightSubsidiesStd);
        //contdeductMargin
        contdeductMargin.setBoundEditor(txtdeductMargin);
        //conttotalMargin
        conttotalMargin.setBoundEditor(txttotalMargin);
        //contenableMargin
        contenableMargin.setBoundEditor(txtenableMargin);
        //contdeductAdPayAmt
        contdeductAdPayAmt.setBoundEditor(txtdeductAdPayAmt);
        //contloanRate
        contloanRate.setBoundEditor(txtloanRate);
        //contkYFKOccupyFee
        contkYFKOccupyFee.setBoundEditor(txtkYFKOccupyFee);
        //contfmRatePunishStd
        contfmRatePunishStd.setBoundEditor(txtfmRatePunishStd);
        //contdyfBalance
        contdyfBalance.setBoundEditor(txtdyfBalance);
        //contmoneyOccupyDays
        contmoneyOccupyDays.setBoundEditor(txtmoneyOccupyDays);
        //contconFeedPolicySub
        contconFeedPolicySub.setBoundEditor(txtconFeedPolicySub);
        //contpayOweMonery
        contpayOweMonery.setBoundEditor(txtpayOweMonery);
        //contoutSaleKbAmt
        contoutSaleKbAmt.setBoundEditor(txtoutSaleKbAmt);
        //contunLockedMargin
        contunLockedMargin.setBoundEditor(txtunLockedMargin);
        //contadPayBalance
        contadPayBalance.setBoundEditor(txtadPayBalance);
        //contQCKbDetail
        contQCKbDetail.setBoundEditor(scrollPaneQCKbDetail);
        //scrollPaneQCKbDetail
        scrollPaneQCKbDetail.getViewport().add(txtQCKbDetail, null);
        //contotherKbDetail
        contotherKbDetail.setBoundEditor(scrollPaneotherKbDetail);
        //scrollPaneotherKbDetail
        scrollPaneotherKbDetail.getViewport().add(txtotherKbDetail, null);
        //contimmuneCost
        contimmuneCost.setBoundEditor(txtimmuneCost);
        //contimmuneCostOne
        contimmuneCostOne.setBoundEditor(txtimmuneCostOne);
        //contcleanHouse
        contcleanHouse.setBoundEditor(txtcleanHouse);
        //contcleanHouseOne
        contcleanHouseOne.setBoundEditor(txtcleanHouseOne);
        //contactualFoder
        contactualFoder.setBoundEditor(txtactualFoder);
        //contstandFodder
        contstandFodder.setBoundEditor(txtstandFodder);
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1149, 483));        kdtQCEntrys.setBounds(new Rectangle(6, 4, 1134, 473));
        kdtQCEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtQCEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillQCEntryInfo(),null,false);
        kDPanel5.add(kdtQCEntrys_detailPanel, new KDLayout.Constraints(6, 4, 1134, 473, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtQCEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("randPType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel6
        kDPanel6.setLayout(new KDLayout());
        kDPanel6.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1149, 483));        kdtViewReqEntrys.setBounds(new Rectangle(5, 4, 1134, 470));
        kdtViewReqEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtViewReqEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillViewReqEntryInfo(),null,false);
        kDPanel6.add(kdtViewReqEntrys_detailPanel, new KDLayout.Constraints(5, 4, 1134, 470, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtViewReqEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel7
        kDPanel7.setLayout(new KDLayout());
        kDPanel7.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1149, 483));        kdtOtherEntrys.setBounds(new Rectangle(2, 5, 1137, 468));
        kdtOtherEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOtherEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillOtherEntryInfo(),null,false);
        kDPanel7.add(kdtOtherEntrys_detailPanel, new KDLayout.Constraints(2, 5, 1137, 468, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel15
        kDPanel15.setLayout(new KDLayout());
        kDPanel15.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1149, 483));        kdtTempPolicyEntrys.setBounds(new Rectangle(3, 2, 1138, 478));
        kdtTempPolicyEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTempPolicyEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillTempPolicyEntryInfo(),null,false);
        kDPanel15.add(kdtTempPolicyEntrys_detailPanel, new KDLayout.Constraints(3, 2, 1138, 478, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtTempPolicyEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("materialType","0");
vo.put("dateRelate","0");
vo.put("calUnit","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1170, 538));        contSeedCost.setBounds(new Rectangle(21, 8, 270, 19));
        kDPanel3.add(contSeedCost, new KDLayout.Constraints(21, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfodderCost.setBounds(new Rectangle(337, 8, 270, 19));
        kDPanel3.add(contfodderCost, new KDLayout.Constraints(337, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugCost.setBounds(new Rectangle(654, 8, 270, 19));
        kDPanel3.add(contdrugCost, new KDLayout.Constraints(654, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallocateAmt.setBounds(new Rectangle(21, 37, 270, 19));
        kDPanel3.add(contallocateAmt, new KDLayout.Constraints(21, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunitCost.setBounds(new Rectangle(21, 65, 270, 19));
        kDPanel3.add(contunitCost, new KDLayout.Constraints(21, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallCost.setBounds(new Rectangle(337, 65, 270, 19));
        kDPanel3.add(contallCost, new KDLayout.Constraints(337, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdaiyFee.setBounds(new Rectangle(337, 37, 270, 19));
        kDPanel3.add(contdaiyFee, new KDLayout.Constraints(337, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyProfit.setBounds(new Rectangle(654, 65, 270, 19));
        kDPanel3.add(contcompanyProfit, new KDLayout.Constraints(654, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contotherMatCost.setBounds(new Rectangle(654, 37, 270, 19));
        kDPanel3.add(contotherMatCost, new KDLayout.Constraints(654, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contSeedCost
        contSeedCost.setBoundEditor(txtSeedCost);
        //contfodderCost
        contfodderCost.setBoundEditor(txtfodderCost);
        //contdrugCost
        contdrugCost.setBoundEditor(txtdrugCost);
        //contallocateAmt
        contallocateAmt.setBoundEditor(txtallocateAmt);
        //contunitCost
        contunitCost.setBoundEditor(txtunitCost);
        //contallCost
        contallCost.setBoundEditor(txtallCost);
        //contdaiyFee
        contdaiyFee.setBoundEditor(txtdaiyFee);
        //contcompanyProfit
        contcompanyProfit.setBoundEditor(txtcompanyProfit);
        //contotherMatCost
        contotherMatCost.setBoundEditor(txtotherMatCost);
        //kDPanel17
        kDPanel17.setLayout(new KDLayout());
        kDPanel17.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1170, 538));        contreserveRiskCost.setBounds(new Rectangle(10, 330, 270, 19));
        kDPanel17.add(contreserveRiskCost, new KDLayout.Constraints(10, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbrokenCost.setBounds(new Rectangle(289, 330, 270, 19));
        kDPanel17.add(contbrokenCost, new KDLayout.Constraints(289, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlongBorrowReturn.setBounds(new Rectangle(314, 49, 270, 19));
        kDPanel17.add(contlongBorrowReturn, new KDLayout.Constraints(314, 49, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttranCost.setBounds(new Rectangle(15, 13, 270, 19));
        kDPanel17.add(conttranCost, new KDLayout.Constraints(15, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualPayAmt.setBounds(new Rectangle(15, 85, 270, 19));
        kDPanel17.add(contactualPayAmt, new KDLayout.Constraints(15, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contspecialPermitAmt.setBounds(new Rectangle(335, 280, 270, 19));
        kDPanel17.add(contspecialPermitAmt, new KDLayout.Constraints(335, 280, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contspecialBorrowinst.setBounds(new Rectangle(573, 358, 270, 19));
        kDPanel17.add(contspecialBorrowinst, new KDLayout.Constraints(573, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlongBorrowAmount.setBounds(new Rectangle(575, 330, 270, 19));
        kDPanel17.add(contlongBorrowAmount, new KDLayout.Constraints(575, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contequipmentReAmt.setBounds(new Rectangle(10, 386, 270, 19));
        kDPanel17.add(contequipmentReAmt, new KDLayout.Constraints(10, 386, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contborrowAmiunt.setBounds(new Rectangle(289, 358, 270, 19));
        kDPanel17.add(contborrowAmiunt, new KDLayout.Constraints(289, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarginGAmount.setBounds(new Rectangle(15, 49, 270, 19));
        kDPanel17.add(contmarginGAmount, new KDLayout.Constraints(15, 49, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoalCost.setBounds(new Rectangle(860, 330, 270, 19));
        kDPanel17.add(contcoalCost, new KDLayout.Constraints(860, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmarginProfit.setBounds(new Rectangle(10, 358, 270, 19));
        kDPanel17.add(contmarginProfit, new KDLayout.Constraints(10, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgetChickCost.setBounds(new Rectangle(10, 416, 270, 19));
        kDPanel17.add(contgetChickCost, new KDLayout.Constraints(10, 416, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcleanHouseCost.setBounds(new Rectangle(289, 416, 270, 19));
        kDPanel17.add(contcleanHouseCost, new KDLayout.Constraints(289, 416, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(314, 85, 556, 19));
        kDPanel17.add(contDescription, new KDLayout.Constraints(314, 85, 556, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcleanTowerCost.setBounds(new Rectangle(573, 416, 270, 19));
        kDPanel17.add(contcleanTowerCost, new KDLayout.Constraints(573, 416, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnowAccountBac.setBounds(new Rectangle(863, 358, 270, 19));
        kDPanel17.add(contnowAccountBac, new KDLayout.Constraints(863, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contassetsOccupy.setBounds(new Rectangle(860, 416, 270, 19));
        kDPanel17.add(contassetsOccupy, new KDLayout.Constraints(860, 416, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contnoPfoRetAmt.setBounds(new Rectangle(13, 280, 270, 19));
        kDPanel17.add(contnoPfoRetAmt, new KDLayout.Constraints(13, 280, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkactualVoucher.setBounds(new Rectangle(15, 121, 270, 19));
        kDPanel17.add(chkactualVoucher, new KDLayout.Constraints(15, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkpreVoucher.setBounds(new Rectangle(575, 386, 270, 19));
        kDPanel17.add(chkpreVoucher, new KDLayout.Constraints(575, 386, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chktransVoucher.setBounds(new Rectangle(15, 151, 270, 19));
        kDPanel17.add(chktransVoucher, new KDLayout.Constraints(15, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhasPay.setBounds(new Rectangle(857, 386, 270, 19));
        kDPanel17.add(chkhasPay, new KDLayout.Constraints(857, 386, 270, 19, 0));
        contcompanyTC.setBounds(new Rectangle(312, 13, 270, 19));
        kDPanel17.add(contcompanyTC, new KDLayout.Constraints(312, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdiverCt.setBounds(new Rectangle(600, 13, 270, 19));
        kDPanel17.add(contdiverCt, new KDLayout.Constraints(600, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contreserveRiskCost
        contreserveRiskCost.setBoundEditor(txtreserveRiskCost);
        //contbrokenCost
        contbrokenCost.setBoundEditor(txtbrokenCost);
        //contlongBorrowReturn
        contlongBorrowReturn.setBoundEditor(txtlongBorrowReturn);
        //conttranCost
        conttranCost.setBoundEditor(txttranCost);
        //contactualPayAmt
        contactualPayAmt.setBoundEditor(txtactualPayAmt);
        //contspecialPermitAmt
        contspecialPermitAmt.setBoundEditor(txtspecialPermitAmt);
        //contspecialBorrowinst
        contspecialBorrowinst.setBoundEditor(txtspecialBorrowinst);
        //contlongBorrowAmount
        contlongBorrowAmount.setBoundEditor(txtlongBorrowAmount);
        //contequipmentReAmt
        contequipmentReAmt.setBoundEditor(txtequipmentReAmt);
        //contborrowAmiunt
        contborrowAmiunt.setBoundEditor(txtborrowAmiunt);
        //contmarginGAmount
        contmarginGAmount.setBoundEditor(txtmarginGAmount);
        //contcoalCost
        contcoalCost.setBoundEditor(txtcoalCost);
        //contmarginProfit
        contmarginProfit.setBoundEditor(txtmarginProfit);
        //contgetChickCost
        contgetChickCost.setBoundEditor(txtgetChickCost);
        //contcleanHouseCost
        contcleanHouseCost.setBoundEditor(txtcleanHouseCost);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contcleanTowerCost
        contcleanTowerCost.setBoundEditor(txtcleanTowerCost);
        //contnowAccountBac
        contnowAccountBac.setBoundEditor(txtnowAccountBac);
        //contassetsOccupy
        contassetsOccupy.setBoundEditor(txtassetsOccupy);
        //contnoPfoRetAmt
        contnoPfoRetAmt.setBoundEditor(txtnoPfoRetAmt);
        //contcompanyTC
        contcompanyTC.setBoundEditor(txtcompanyTC);
        //contdiverCt
        contdiverCt.setBoundEditor(txtdiverCt);
        //kDTabbedPane3
        kDTabbedPane3.add(kDPanel8, resHelper.getString("kDPanel8.constraints"));
        kDTabbedPane3.add(kDPanel9, resHelper.getString("kDPanel9.constraints"));
        kDTabbedPane3.add(kDPanel10, resHelper.getString("kDPanel10.constraints"));
        kDTabbedPane3.add(kDPanel11, resHelper.getString("kDPanel11.constraints"));
        kDTabbedPane3.add(kDPanel12, resHelper.getString("kDPanel12.constraints"));
        //kDPanel8
        kDPanel8.setLayout(new KDLayout());
        kDPanel8.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1163, 285));        kdtSeedEntrys.setBounds(new Rectangle(1, 2, 1160, 275));
        kdtSeedEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSeedEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryInfo(),null,false);
        kDPanel8.add(kdtSeedEntrys_detailPanel, new KDLayout.Constraints(1, 2, 1160, 275, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtSeedEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
vo.put("bizType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel9
        kDPanel9.setLayout(new KDLayout());
        kDPanel9.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1163, 285));        kdtFodderEntrys.setBounds(new Rectangle(2, 2, 1159, 276));
        kdtFodderEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFodderEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryInfo(),null,false);
        kDPanel9.add(kdtFodderEntrys_detailPanel, new KDLayout.Constraints(2, 2, 1159, 276, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtFodderEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
vo.put("bizType","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel10
        kDPanel10.setLayout(new KDLayout());
        kDPanel10.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1163, 285));        kdtDrugEntrys.setBounds(new Rectangle(1, 2, 1160, 278));
        kdtDrugEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDrugEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryInfo(),null,false);
        kDPanel10.add(kdtDrugEntrys_detailPanel, new KDLayout.Constraints(1, 2, 1160, 278, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtDrugEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
vo.put("bizType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel11
        kDPanel11.setLayout(new KDLayout());
        kDPanel11.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1163, 285));        kdtSlaughterEntrys.setBounds(new Rectangle(2, 1, 1159, 273));
        kdtSlaughterEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSlaughterEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSlaughterEntryInfo(),null,false);
        kDPanel11.add(kdtSlaughterEntrys_detailPanel, new KDLayout.Constraints(2, 1, 1159, 273, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtSlaughterEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel12
        kDPanel12.setLayout(null);        kdtSaleEntrys.setBounds(new Rectangle(2, 2, 1142, 277));
        kdtSaleEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSaleEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryInfo(),null,false);
        kDPanel12.add(kdtSaleEntrys_detailPanel, null);
		kdtSaleEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("billStatus",new Integer(-1));
vo.put("baseStatus",new Integer(-1));
vo.put("saleType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);

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
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
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
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
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
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
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
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
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
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnExecSettle);
        this.toolBar.add(btnUpdateSaleData);
        this.toolBar.add(btnupdateActAmt);
        this.toolBar.add(hasPay);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnClose);
        this.toolBar.add(btnUnClose);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
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
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("Fivouchered", boolean.class, this.chkFivouchered, "selected");
		dataBinder.registerBinding("isHasPaymentBill", boolean.class, this.chkisHasPaymentBill, "selected");
		dataBinder.registerBinding("isKouBZJ", boolean.class, this.chkisKouBZJ, "selected");
		dataBinder.registerBinding("singleDyFee", java.math.BigDecimal.class, this.txtsingleDyFee, "value");
		dataBinder.registerBinding("punishAmt", java.math.BigDecimal.class, this.txtpunishAmt, "value");
		dataBinder.registerBinding("meatRate", java.math.BigDecimal.class, this.txtmeatRate, "value");
		dataBinder.registerBinding("preHouseWgt", java.math.BigDecimal.class, this.txtpreHouseWgt, "value");
		dataBinder.registerBinding("drugAmt", java.math.BigDecimal.class, this.txtdrugAmt, "value");
		dataBinder.registerBinding("batchAmt", java.math.BigDecimal.class, this.txtbatchAmt, "value");
		dataBinder.registerBinding("bEBankAddress", String.class, this.txtbEBankAddress, "text");
		dataBinder.registerBinding("conFeedPolicy", com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo.class, this.prmtconFeedPolicy, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("conFeededNum", int.class, this.txtconFeededNum, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("feedWgt", java.math.BigDecimal.class, this.txtfeedWgt, "value");
		dataBinder.registerBinding("recDate", java.util.Date.class, this.pkrecDate, "value");
		dataBinder.registerBinding("punishWgt", java.math.BigDecimal.class, this.txtpunishWgt, "value");
		dataBinder.registerBinding("survivalRate", java.math.BigDecimal.class, this.txtsurvivalRate, "value");
		dataBinder.registerBinding("marginAmt", java.math.BigDecimal.class, this.txtmarginAmt, "value");
		dataBinder.registerBinding("adPayAmount", java.math.BigDecimal.class, this.txtadPayAmount, "value");
		dataBinder.registerBinding("mlyAllAmt", java.math.BigDecimal.class, this.txtmlyAllAmt, "value");
		dataBinder.registerBinding("chickenAveWgt", java.math.BigDecimal.class, this.txtchickenAveWgt, "value");
		dataBinder.registerBinding("settleWgt", java.math.BigDecimal.class, this.txtsettleWgt, "value");
		dataBinder.registerBinding("recQty", int.class, this.txtrecQty, "value");
		dataBinder.registerBinding("feedQty", int.class, this.txtfeedQty, "value");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("bEBank", com.kingdee.eas.fm.be.BEBankInfo.class, this.prmtbEBank, "data");
		dataBinder.registerBinding("cFBeginDate", java.util.Date.class, this.pkcFBeginDate, "value");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("cFEndDate", java.util.Date.class, this.pkcFEndDate, "value");
		dataBinder.registerBinding("bankNum", String.class, this.txtbankNum, "text");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("feedAmt", java.math.BigDecimal.class, this.txtfeedAmt, "value");
		dataBinder.registerBinding("feedDays", int.class, this.txtfeedDays, "value");
		dataBinder.registerBinding("recAmt", java.math.BigDecimal.class, this.txtrecAmt, "value");
		dataBinder.registerBinding("dyFee", java.math.BigDecimal.class, this.txtdyFee, "value");
		dataBinder.registerBinding("singleDrugAmt", java.math.BigDecimal.class, this.txtsingleDrugAmt, "value");
		dataBinder.registerBinding("singleFeedWgt", java.math.BigDecimal.class, this.txtsingleFeedWgt, "value");
		dataBinder.registerBinding("oValue", java.math.BigDecimal.class, this.txtoValue, "value");
		dataBinder.registerBinding("conFeedContract", com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo.class, this.prmtconFeedContract, "data");
		dataBinder.registerBinding("kbItemAmt", java.math.BigDecimal.class, this.txtkbItemAmt, "value");
		dataBinder.registerBinding("QCItemAmt", java.math.BigDecimal.class, this.txtQCItemAmt, "value");
		dataBinder.registerBinding("viewItemAmt", java.math.BigDecimal.class, this.txtviewItemAmt, "value");
		dataBinder.registerBinding("otherItemAmt", java.math.BigDecimal.class, this.txtotherItemAmt, "value");
		dataBinder.registerBinding("tempItemAmt", java.math.BigDecimal.class, this.txttempItemAmt, "value");
		dataBinder.registerBinding("payOweMoneryB", java.math.BigDecimal.class, this.txtpayOweMoneryB, "value");
		dataBinder.registerBinding("recSuttle", java.math.BigDecimal.class, this.txtrecSuttle, "value");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("farmsType", com.kingdee.eas.farm.stocking.basedata.FarmsType.class, this.farmsType, "selectedItem");
		dataBinder.registerBinding("outSaleKbAmt2", java.math.BigDecimal.class, this.txtoutSaleKbAmt2, "value");
		dataBinder.registerBinding("PreHouseEntrys.seq", int.class, this.kdtPreHouseEntrys, "seq.text");
		dataBinder.registerBinding("PreHouseEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryInfo.class, this.kdtPreHouseEntrys, "userObject");
		dataBinder.registerBinding("PreHouseEntrys.bizDate", java.util.Date.class, this.kdtPreHouseEntrys, "bizDate.text");
		dataBinder.registerBinding("PreHouseEntrys.billNumber", String.class, this.kdtPreHouseEntrys, "billNumber.text");
		dataBinder.registerBinding("PreHouseEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtPreHouseEntrys, "billStatus.text");
		dataBinder.registerBinding("PreHouseEntrys.preHouseQty", int.class, this.kdtPreHouseEntrys, "preHouseQty.text");
		dataBinder.registerBinding("PreHouseEntrys.preHouseTare", java.math.BigDecimal.class, this.kdtPreHouseEntrys, "preHouseTare.text");
		dataBinder.registerBinding("PreHouseEntrys.preHouseGross", java.math.BigDecimal.class, this.kdtPreHouseEntrys, "preHouseGross.text");
		dataBinder.registerBinding("PreHouseEntrys.preHouseSuttle", java.math.BigDecimal.class, this.kdtPreHouseEntrys, "preHouseSuttle.text");
		dataBinder.registerBinding("PreHouseEntrys.recQty", int.class, this.kdtPreHouseEntrys, "recQty.text");
		dataBinder.registerBinding("PreHouseEntrys.settleWgt", java.math.BigDecimal.class, this.kdtPreHouseEntrys, "settleWgt.text");
		dataBinder.registerBinding("PreHouseEntrys.recSuttle", java.math.BigDecimal.class, this.kdtPreHouseEntrys, "recSuttle.text");
		dataBinder.registerBinding("SeedSourceEntrys.seq", int.class, this.kdtSeedSourceEntrys, "seq.text");
		dataBinder.registerBinding("SeedSourceEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryInfo.class, this.kdtSeedSourceEntrys, "userObject");
		dataBinder.registerBinding("SeedSourceEntrys.storageOrgUnit", java.lang.Object.class, this.kdtSeedSourceEntrys, "storageOrgUnit.text");
		dataBinder.registerBinding("SeedSourceEntrys.lot", String.class, this.kdtSeedSourceEntrys, "lot.text");
		dataBinder.registerBinding("SeedSourceEntrys.qty", java.math.BigDecimal.class, this.kdtSeedSourceEntrys, "qty.text");
		dataBinder.registerBinding("chickenRetunAmt", java.math.BigDecimal.class, this.txtchickenRetunAmt, "value");
		dataBinder.registerBinding("beforeBatchAmount", java.math.BigDecimal.class, this.txtbeforeBatchAmount, "value");
		dataBinder.registerBinding("idCodeCode", String.class, this.txtidCodeCode, "text");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("chickenSource", String.class, this.txtchickenSource, "text");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("oneMrgin", java.math.BigDecimal.class, this.txtoneMrgin, "value");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("drugQty", java.math.BigDecimal.class, this.txtdrugQty, "value");
		dataBinder.registerBinding("farmeronlyPro", java.math.BigDecimal.class, this.txtfarmeronlyPro, "value");
		dataBinder.registerBinding("farmerOnlyProOne", java.math.BigDecimal.class, this.txtfarmerOnlyProOne, "value");
		dataBinder.registerBinding("proDiv", java.math.BigDecimal.class, this.txtproDiv, "value");
		dataBinder.registerBinding("occupyMargin", java.math.BigDecimal.class, this.txtoccupyMargin, "value");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.recType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "recType.text");
		dataBinder.registerBinding("entrys.qty", int.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.weight", java.math.BigDecimal.class, this.kdtEntrys, "weight.text");
		dataBinder.registerBinding("entrys.price", java.math.BigDecimal.class, this.kdtEntrys, "price.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.averageWgt", java.math.BigDecimal.class, this.kdtEntrys, "averageWgt.text");
		dataBinder.registerBinding("isOrdinary", boolean.class, this.chkisOrdinary, "selected");
		dataBinder.registerBinding("noCalFodderPunish", boolean.class, this.chknoCalFodderPunish, "selected");
		dataBinder.registerBinding("noCalDrupPunish", boolean.class, this.chknoCalDrupPunish, "selected");
		dataBinder.registerBinding("mRatePAmt", java.math.BigDecimal.class, this.txtmRatePAmt, "value");
		dataBinder.registerBinding("actualMRate", java.math.BigDecimal.class, this.txtactualMRate, "value");
		dataBinder.registerBinding("standardMRate", java.math.BigDecimal.class, this.txtstandardMRate, "value");
		dataBinder.registerBinding("drugLackPAmt", java.math.BigDecimal.class, this.txtdrugLackPAmt, "value");
		dataBinder.registerBinding("singleActualDrug", java.math.BigDecimal.class, this.txtsingleActualDrug, "value");
		dataBinder.registerBinding("singleStandardDrug", java.math.BigDecimal.class, this.txtsingleStandardDrug, "value");
		dataBinder.registerBinding("marginOccupyFee", java.math.BigDecimal.class, this.txtmarginOccupyFee, "value");
		dataBinder.registerBinding("batchOccupyMargin", java.math.BigDecimal.class, this.txtbatchOccupyMargin, "value");
		dataBinder.registerBinding("standardMargin", java.math.BigDecimal.class, this.txtstandardMargin, "value");
		dataBinder.registerBinding("singleMargin", java.math.BigDecimal.class, this.txtsingleMargin, "value");
		dataBinder.registerBinding("conFeedSubsidies", java.math.BigDecimal.class, this.txtconFeedSubsidies, "value");
		dataBinder.registerBinding("kbConFeedPolicy", com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo.class, this.prmtkbConFeedPolicy, "data");
		dataBinder.registerBinding("contractCKWgt", java.math.BigDecimal.class, this.txtcontractCKWgt, "value");
		dataBinder.registerBinding("freightDiffSubsidies", java.math.BigDecimal.class, this.txtfreightDiffSubsidies, "value");
		dataBinder.registerBinding("lFeedWgt", java.math.BigDecimal.class, this.txtlFeedWgt, "value");
		dataBinder.registerBinding("freightPrice", java.math.BigDecimal.class, this.txtfreightPrice, "value");
		dataBinder.registerBinding("freightSubsidiesStd", java.math.BigDecimal.class, this.txtfreightSubsidiesStd, "value");
		dataBinder.registerBinding("deductMargin", java.math.BigDecimal.class, this.txtdeductMargin, "value");
		dataBinder.registerBinding("totalMargin", java.math.BigDecimal.class, this.txttotalMargin, "value");
		dataBinder.registerBinding("enableMargin", java.math.BigDecimal.class, this.txtenableMargin, "value");
		dataBinder.registerBinding("deductAdPayAmt", java.math.BigDecimal.class, this.txtdeductAdPayAmt, "value");
		dataBinder.registerBinding("loanRate", java.math.BigDecimal.class, this.txtloanRate, "value");
		dataBinder.registerBinding("kYFKOccupyFee", java.math.BigDecimal.class, this.txtkYFKOccupyFee, "value");
		dataBinder.registerBinding("fmRatePunishStd", java.math.BigDecimal.class, this.txtfmRatePunishStd, "value");
		dataBinder.registerBinding("dyfBalance", java.math.BigDecimal.class, this.txtdyfBalance, "value");
		dataBinder.registerBinding("moneyOccupyDays", int.class, this.txtmoneyOccupyDays, "value");
		dataBinder.registerBinding("conFeedPolicySub", java.math.BigDecimal.class, this.txtconFeedPolicySub, "value");
		dataBinder.registerBinding("payOweMonery", java.math.BigDecimal.class, this.txtpayOweMonery, "value");
		dataBinder.registerBinding("outSaleKbAmt", java.math.BigDecimal.class, this.txtoutSaleKbAmt, "value");
		dataBinder.registerBinding("unLockedMargin", java.math.BigDecimal.class, this.txtunLockedMargin, "value");
		dataBinder.registerBinding("adPayBalance", java.math.BigDecimal.class, this.txtadPayBalance, "value");
		dataBinder.registerBinding("QCKbDetail", String.class, this.txtQCKbDetail, "text");
		dataBinder.registerBinding("otherKbDetail", String.class, this.txtotherKbDetail, "text");
		dataBinder.registerBinding("immuneCost", java.math.BigDecimal.class, this.txtimmuneCost, "value");
		dataBinder.registerBinding("immuneCostOne", java.math.BigDecimal.class, this.txtimmuneCostOne, "value");
		dataBinder.registerBinding("cleanHouse", java.math.BigDecimal.class, this.txtcleanHouse, "value");
		dataBinder.registerBinding("cleanHouseOne", java.math.BigDecimal.class, this.txtcleanHouseOne, "value");
		dataBinder.registerBinding("actualFoder", java.math.BigDecimal.class, this.txtactualFoder, "value");
		dataBinder.registerBinding("standFodder", java.math.BigDecimal.class, this.txtstandFodder, "value");
		dataBinder.registerBinding("QCEntrys.seq", int.class, this.kdtQCEntrys, "seq.text");
		dataBinder.registerBinding("QCEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillQCEntryInfo.class, this.kdtQCEntrys, "userObject");
		dataBinder.registerBinding("QCEntrys.QCItem", java.lang.Object.class, this.kdtQCEntrys, "QCItem.text");
		dataBinder.registerBinding("QCEntrys.randPType", com.kingdee.util.enums.Enum.class, this.kdtQCEntrys, "randPType.text");
		dataBinder.registerBinding("QCEntrys.actualRate", java.math.BigDecimal.class, this.kdtQCEntrys, "actualRate.text");
		dataBinder.registerBinding("QCEntrys.punishAmt", java.math.BigDecimal.class, this.kdtQCEntrys, "punishAmt.text");
		dataBinder.registerBinding("QCEntrys.actualWgt", java.math.BigDecimal.class, this.kdtQCEntrys, "actualWgt.text");
		dataBinder.registerBinding("QCEntrys.punishWgt", java.math.BigDecimal.class, this.kdtQCEntrys, "punishWgt.text");
		dataBinder.registerBinding("QCEntrys.billNumber", String.class, this.kdtQCEntrys, "billNumber.text");
		dataBinder.registerBinding("ViewReqEntrys.seq", int.class, this.kdtViewReqEntrys, "seq.text");
		dataBinder.registerBinding("ViewReqEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillViewReqEntryInfo.class, this.kdtViewReqEntrys, "userObject");
		dataBinder.registerBinding("ViewReqEntrys.viewType", java.lang.Object.class, this.kdtViewReqEntrys, "viewType.text");
		dataBinder.registerBinding("ViewReqEntrys.amount", java.math.BigDecimal.class, this.kdtViewReqEntrys, "amount.text");
		dataBinder.registerBinding("ViewReqEntrys.bizDate", java.util.Date.class, this.kdtViewReqEntrys, "bizDate.text");
		dataBinder.registerBinding("ViewReqEntrys.billNumber", String.class, this.kdtViewReqEntrys, "billNumber.text");
		dataBinder.registerBinding("ViewReqEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtViewReqEntrys, "billStatus.text");
		dataBinder.registerBinding("ViewReqEntrys.auditAmt", java.math.BigDecimal.class, this.kdtViewReqEntrys, "auditAmt.text");
		dataBinder.registerBinding("OtherEntrys.seq", int.class, this.kdtOtherEntrys, "seq.text");
		dataBinder.registerBinding("OtherEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillOtherEntryInfo.class, this.kdtOtherEntrys, "userObject");
		dataBinder.registerBinding("OtherEntrys.rpType", String.class, this.kdtOtherEntrys, "rpType.text");
		dataBinder.registerBinding("OtherEntrys.amount", java.math.BigDecimal.class, this.kdtOtherEntrys, "amount.text");
		dataBinder.registerBinding("OtherEntrys.suType", java.lang.Object.class, this.kdtOtherEntrys, "suType.text");
		dataBinder.registerBinding("TempPolicyEntrys.seq", int.class, this.kdtTempPolicyEntrys, "seq.text");
		dataBinder.registerBinding("TempPolicyEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillTempPolicyEntryInfo.class, this.kdtTempPolicyEntrys, "userObject");
		dataBinder.registerBinding("TempPolicyEntrys.tempPolicy", java.lang.Object.class, this.kdtTempPolicyEntrys, "tempPolicy.text");
		dataBinder.registerBinding("TempPolicyEntrys.kbPrice", java.math.BigDecimal.class, this.kdtTempPolicyEntrys, "kbPrice.text");
		dataBinder.registerBinding("TempPolicyEntrys.materialType", com.kingdee.util.enums.Enum.class, this.kdtTempPolicyEntrys, "materialType.text");
		dataBinder.registerBinding("TempPolicyEntrys.calUnit", com.kingdee.util.enums.Enum.class, this.kdtTempPolicyEntrys, "calUnit.text");
		dataBinder.registerBinding("TempPolicyEntrys.kbAmount", java.math.BigDecimal.class, this.kdtTempPolicyEntrys, "kbAmount.text");
		dataBinder.registerBinding("TempPolicyEntrys.dateRelate", com.kingdee.util.enums.Enum.class, this.kdtTempPolicyEntrys, "dateRelate.text");
		dataBinder.registerBinding("TempPolicyEntrys.beginDate", java.util.Date.class, this.kdtTempPolicyEntrys, "beginDate.text");
		dataBinder.registerBinding("TempPolicyEntrys.endDate", java.util.Date.class, this.kdtTempPolicyEntrys, "endDate.text");
		dataBinder.registerBinding("SeedCost", java.math.BigDecimal.class, this.txtSeedCost, "value");
		dataBinder.registerBinding("fodderCost", java.math.BigDecimal.class, this.txtfodderCost, "value");
		dataBinder.registerBinding("drugCost", java.math.BigDecimal.class, this.txtdrugCost, "value");
		dataBinder.registerBinding("allocateAmt", java.math.BigDecimal.class, this.txtallocateAmt, "value");
		dataBinder.registerBinding("unitCost", java.math.BigDecimal.class, this.txtunitCost, "value");
		dataBinder.registerBinding("allCost", java.math.BigDecimal.class, this.txtallCost, "value");
		dataBinder.registerBinding("daiyFee", java.math.BigDecimal.class, this.txtdaiyFee, "value");
		dataBinder.registerBinding("companyProfit", java.math.BigDecimal.class, this.txtcompanyProfit, "value");
		dataBinder.registerBinding("otherMatCost", java.math.BigDecimal.class, this.txtotherMatCost, "value");
		dataBinder.registerBinding("actualVoucher", boolean.class, this.chkactualVoucher, "selected");
		dataBinder.registerBinding("preVoucher", boolean.class, this.chkpreVoucher, "selected");
		dataBinder.registerBinding("transVoucher", boolean.class, this.chktransVoucher, "selected");
		dataBinder.registerBinding("hasPay", boolean.class, this.chkhasPay, "selected");
		dataBinder.registerBinding("reserveRiskCost", java.math.BigDecimal.class, this.txtreserveRiskCost, "value");
		dataBinder.registerBinding("brokenCost", java.math.BigDecimal.class, this.txtbrokenCost, "value");
		dataBinder.registerBinding("longBorrowReturn", java.math.BigDecimal.class, this.txtlongBorrowReturn, "value");
		dataBinder.registerBinding("tranCost", java.math.BigDecimal.class, this.txttranCost, "value");
		dataBinder.registerBinding("actualPayAmt", java.math.BigDecimal.class, this.txtactualPayAmt, "value");
		dataBinder.registerBinding("specialPermitAmt", java.math.BigDecimal.class, this.txtspecialPermitAmt, "value");
		dataBinder.registerBinding("specialBorrowinst", java.math.BigDecimal.class, this.txtspecialBorrowinst, "value");
		dataBinder.registerBinding("longBorrowAmount", java.math.BigDecimal.class, this.txtlongBorrowAmount, "value");
		dataBinder.registerBinding("equipmentReAmt", java.math.BigDecimal.class, this.txtequipmentReAmt, "value");
		dataBinder.registerBinding("borrowAmiunt", java.math.BigDecimal.class, this.txtborrowAmiunt, "value");
		dataBinder.registerBinding("marginGAmount", java.math.BigDecimal.class, this.txtmarginGAmount, "value");
		dataBinder.registerBinding("coalCost", java.math.BigDecimal.class, this.txtcoalCost, "value");
		dataBinder.registerBinding("marginProfit", java.math.BigDecimal.class, this.txtmarginProfit, "value");
		dataBinder.registerBinding("getChickCost", java.math.BigDecimal.class, this.txtgetChickCost, "value");
		dataBinder.registerBinding("cleanHouseCost", java.math.BigDecimal.class, this.txtcleanHouseCost, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("cleanTowerCost", java.math.BigDecimal.class, this.txtcleanTowerCost, "value");
		dataBinder.registerBinding("nowAccountBac", java.math.BigDecimal.class, this.txtnowAccountBac, "value");
		dataBinder.registerBinding("assetsOccupy", java.math.BigDecimal.class, this.txtassetsOccupy, "value");
		dataBinder.registerBinding("noPfoRetAmt", java.math.BigDecimal.class, this.txtnoPfoRetAmt, "value");
		dataBinder.registerBinding("companyTC", java.math.BigDecimal.class, this.txtcompanyTC, "value");
		dataBinder.registerBinding("diverCt", java.math.BigDecimal.class, this.txtdiverCt, "value");
		dataBinder.registerBinding("SeedEntrys.seq", int.class, this.kdtSeedEntrys, "seq.text");
		dataBinder.registerBinding("SeedEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryInfo.class, this.kdtSeedEntrys, "userObject");
		dataBinder.registerBinding("SeedEntrys.bizDate", java.util.Date.class, this.kdtSeedEntrys, "bizDate.text");
		dataBinder.registerBinding("SeedEntrys.billNumber", String.class, this.kdtSeedEntrys, "billNumber.text");
		dataBinder.registerBinding("SeedEntrys.bizType", com.kingdee.util.enums.Enum.class, this.kdtSeedEntrys, "bizType.text");
		dataBinder.registerBinding("SeedEntrys.material", java.lang.Object.class, this.kdtSeedEntrys, "material.text");
		dataBinder.registerBinding("SeedEntrys.materialName", String.class, this.kdtSeedEntrys, "materialName.text");
		dataBinder.registerBinding("SeedEntrys.qty", java.math.BigDecimal.class, this.kdtSeedEntrys, "qty.text");
		dataBinder.registerBinding("SeedEntrys.policyPrice", java.math.BigDecimal.class, this.kdtSeedEntrys, "policyPrice.text");
		dataBinder.registerBinding("SeedEntrys.amount", java.math.BigDecimal.class, this.kdtSeedEntrys, "amount.text");
		dataBinder.registerBinding("SeedEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtSeedEntrys, "billStatus.text");
		dataBinder.registerBinding("SeedEntrys.unitCost", java.math.BigDecimal.class, this.kdtSeedEntrys, "unitCost.text");
		dataBinder.registerBinding("SeedEntrys.cost", java.math.BigDecimal.class, this.kdtSeedEntrys, "cost.text");
		dataBinder.registerBinding("SeedEntrys.contPrice", java.math.BigDecimal.class, this.kdtSeedEntrys, "contPrice.text");
		dataBinder.registerBinding("SeedEntrys.contAmount", java.math.BigDecimal.class, this.kdtSeedEntrys, "contAmount.text");
		dataBinder.registerBinding("SeedEntrys.actPrice", java.math.BigDecimal.class, this.kdtSeedEntrys, "actPrice.text");
		dataBinder.registerBinding("SeedEntrys.actAmount", java.math.BigDecimal.class, this.kdtSeedEntrys, "actAmount.text");
		dataBinder.registerBinding("FodderEntrys.seq", int.class, this.kdtFodderEntrys, "seq.text");
		dataBinder.registerBinding("FodderEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryInfo.class, this.kdtFodderEntrys, "userObject");
		dataBinder.registerBinding("FodderEntrys.bizDate", java.util.Date.class, this.kdtFodderEntrys, "bizDate.text");
		dataBinder.registerBinding("FodderEntrys.billNumber", String.class, this.kdtFodderEntrys, "billNumber.text");
		dataBinder.registerBinding("FodderEntrys.bizType", com.kingdee.util.enums.Enum.class, this.kdtFodderEntrys, "bizType.text");
		dataBinder.registerBinding("FodderEntrys.material", java.lang.Object.class, this.kdtFodderEntrys, "material.text");
		dataBinder.registerBinding("FodderEntrys.materialName", String.class, this.kdtFodderEntrys, "materialName.text");
		dataBinder.registerBinding("FodderEntrys.unitQty", java.math.BigDecimal.class, this.kdtFodderEntrys, "unitQty.text");
		dataBinder.registerBinding("FodderEntrys.bagQty", int.class, this.kdtFodderEntrys, "bagQty.text");
		dataBinder.registerBinding("FodderEntrys.qty", java.math.BigDecimal.class, this.kdtFodderEntrys, "qty.text");
		dataBinder.registerBinding("FodderEntrys.policyPrice", java.math.BigDecimal.class, this.kdtFodderEntrys, "policyPrice.text");
		dataBinder.registerBinding("FodderEntrys.amount", java.math.BigDecimal.class, this.kdtFodderEntrys, "amount.text");
		dataBinder.registerBinding("FodderEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtFodderEntrys, "billStatus.text");
		dataBinder.registerBinding("FodderEntrys.Car", java.lang.Object.class, this.kdtFodderEntrys, "Car.text");
		dataBinder.registerBinding("FodderEntrys.driver", java.lang.Object.class, this.kdtFodderEntrys, "driver.text");
		dataBinder.registerBinding("FodderEntrys.unitCost", java.math.BigDecimal.class, this.kdtFodderEntrys, "unitCost.text");
		dataBinder.registerBinding("FodderEntrys.cost", java.math.BigDecimal.class, this.kdtFodderEntrys, "cost.text");
		dataBinder.registerBinding("FodderEntrys.hjFee", java.math.BigDecimal.class, this.kdtFodderEntrys, "hjFee.text");
		dataBinder.registerBinding("DrugEntrys.seq", int.class, this.kdtDrugEntrys, "seq.text");
		dataBinder.registerBinding("DrugEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryInfo.class, this.kdtDrugEntrys, "userObject");
		dataBinder.registerBinding("DrugEntrys.bizDate", java.util.Date.class, this.kdtDrugEntrys, "bizDate.text");
		dataBinder.registerBinding("DrugEntrys.billNumber", String.class, this.kdtDrugEntrys, "billNumber.text");
		dataBinder.registerBinding("DrugEntrys.bizType", com.kingdee.util.enums.Enum.class, this.kdtDrugEntrys, "bizType.text");
		dataBinder.registerBinding("DrugEntrys.material", java.lang.Object.class, this.kdtDrugEntrys, "material.text");
		dataBinder.registerBinding("DrugEntrys.materialName", String.class, this.kdtDrugEntrys, "materialName.text");
		dataBinder.registerBinding("DrugEntrys.qty", java.math.BigDecimal.class, this.kdtDrugEntrys, "qty.text");
		dataBinder.registerBinding("DrugEntrys.policyPrice", java.math.BigDecimal.class, this.kdtDrugEntrys, "policyPrice.text");
		dataBinder.registerBinding("DrugEntrys.amount", java.math.BigDecimal.class, this.kdtDrugEntrys, "amount.text");
		dataBinder.registerBinding("DrugEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtDrugEntrys, "billStatus.text");
		dataBinder.registerBinding("DrugEntrys.unitCost", java.math.BigDecimal.class, this.kdtDrugEntrys, "unitCost.text");
		dataBinder.registerBinding("DrugEntrys.cost", java.math.BigDecimal.class, this.kdtDrugEntrys, "cost.text");
		dataBinder.registerBinding("SlaughterEntrys.seq", int.class, this.kdtSlaughterEntrys, "seq.text");
		dataBinder.registerBinding("SlaughterEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSlaughterEntryInfo.class, this.kdtSlaughterEntrys, "userObject");
		dataBinder.registerBinding("SlaughterEntrys.bizDate", java.util.Date.class, this.kdtSlaughterEntrys, "bizDate.text");
		dataBinder.registerBinding("SlaughterEntrys.billNumber", String.class, this.kdtSlaughterEntrys, "billNumber.text");
		dataBinder.registerBinding("SlaughterEntrys.preHouseSuttle", java.math.BigDecimal.class, this.kdtSlaughterEntrys, "preHouseSuttle.text");
		dataBinder.registerBinding("SlaughterEntrys.recQty", int.class, this.kdtSlaughterEntrys, "recQty.text");
		dataBinder.registerBinding("SlaughterEntrys.carcassQty", int.class, this.kdtSlaughterEntrys, "carcassQty.text");
		dataBinder.registerBinding("SlaughterEntrys.carcassWgt", java.math.BigDecimal.class, this.kdtSlaughterEntrys, "carcassWgt.text");
		dataBinder.registerBinding("SlaughterEntrys.inCompleteQty", int.class, this.kdtSlaughterEntrys, "inCompleteQty.text");
		dataBinder.registerBinding("SlaughterEntrys.inCompleteWgt", java.math.BigDecimal.class, this.kdtSlaughterEntrys, "inCompleteWgt.text");
		dataBinder.registerBinding("SlaughterEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtSlaughterEntrys, "billStatus.text");
		dataBinder.registerBinding("SlaughterEntrys.AWeight", java.math.BigDecimal.class, this.kdtSlaughterEntrys, "AWeight.text");
		dataBinder.registerBinding("SlaughterEntrys.punishAllWeight", java.math.BigDecimal.class, this.kdtSlaughterEntrys, "punishAllWeight.text");
		dataBinder.registerBinding("SlaughterEntrys.settlementAllWig", java.math.BigDecimal.class, this.kdtSlaughterEntrys, "settlementAllWig.text");
		dataBinder.registerBinding("SaleEntrys.seq", int.class, this.kdtSaleEntrys, "seq.text");
		dataBinder.registerBinding("SaleEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryInfo.class, this.kdtSaleEntrys, "userObject");
		dataBinder.registerBinding("SaleEntrys.saleType", com.kingdee.util.enums.Enum.class, this.kdtSaleEntrys, "saleType.text");
		dataBinder.registerBinding("SaleEntrys.customer", java.lang.Object.class, this.kdtSaleEntrys, "customer.text");
		dataBinder.registerBinding("SaleEntrys.outSalePrice", java.math.BigDecimal.class, this.kdtSaleEntrys, "outSalePrice.text");
		dataBinder.registerBinding("SaleEntrys.outSaleAmt", java.math.BigDecimal.class, this.kdtSaleEntrys, "outSaleAmt.text");
		dataBinder.registerBinding("SaleEntrys.bizDate", java.util.Date.class, this.kdtSaleEntrys, "bizDate.text");
		dataBinder.registerBinding("SaleEntrys.billNumber", String.class, this.kdtSaleEntrys, "billNumber.text");
		dataBinder.registerBinding("SaleEntrys.billStatus", com.kingdee.util.enums.Enum.class, this.kdtSaleEntrys, "billStatus.text");
		dataBinder.registerBinding("SaleEntrys.recSuttle", java.math.BigDecimal.class, this.kdtSaleEntrys, "recSuttle.text");
		dataBinder.registerBinding("SaleEntrys.baseStatus", com.kingdee.util.enums.Enum.class, this.kdtSaleEntrys, "baseStatus.text");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKSettleBillEditUIHandler";
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
        this.chkFivouchered.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Company",editData.getString("number"));
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtFICompany;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Company");
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Fivouchered", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasPaymentBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isKouBZJ", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleDyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("punishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("meatRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bEBankAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeedPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeededNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("punishWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("survivalRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adPayAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mlyAllAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenAveWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bEBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cFBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cFEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleDrugAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleFeedWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeedContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kbItemAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCItemAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("viewItemAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherItemAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tempItemAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payOweMoneryB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmsType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSaleKbAmt2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.preHouseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.preHouseTare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.preHouseGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.preHouseSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.settleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PreHouseEntrys.recSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedSourceEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedSourceEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedSourceEntrys.storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedSourceEntrys.lot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedSourceEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenRetunAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beforeBatchAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("idCodeCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oneMrgin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmeronlyPro", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerOnlyProOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proDiv", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.averageWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOrdinary", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("noCalFodderPunish", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("noCalDrupPunish", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mRatePAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualMRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardMRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugLackPAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleActualDrug", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleStandardDrug", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginOccupyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchOccupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeedSubsidies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kbConFeedPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractCKWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freightDiffSubsidies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lFeedWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freightPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freightSubsidiesStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deductMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enableMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deductAdPayAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("loanRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kYFKOccupyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fmRatePunishStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dyfBalance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("moneyOccupyDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeedPolicySub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payOweMonery", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSaleKbAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unLockedMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adPayBalance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCKbDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherKbDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneCostOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cleanHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cleanHouseOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualFoder", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standFodder", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.QCItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.randPType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.actualRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.punishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.actualWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.punishWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.viewType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ViewReqEntrys.auditAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.rpType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.suType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.tempPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.kbPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.materialType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.calUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.kbAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.dateRelate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TempPolicyEntrys.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allocateAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("daiyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherMatCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualVoucher", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preVoucher", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transVoucher", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasPay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reserveRiskCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("brokenCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("longBorrowReturn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tranCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualPayAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("specialPermitAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("specialBorrowinst", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("longBorrowAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("equipmentReAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("borrowAmiunt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginGAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coalCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("getChickCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cleanHouseCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cleanTowerCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nowAccountBac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assetsOccupy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("noPfoRetAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyTC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diverCt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.bizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.policyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.cost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.contPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.contAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.actPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntrys.actAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.bizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.unitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.bagQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.policyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.Car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.cost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.hjFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.bizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.policyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.cost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.preHouseSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.carcassQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.carcassWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.inCompleteQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.inCompleteWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.AWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.punishAllWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SlaughterEntrys.settlementAllWig", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.saleType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.outSalePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.outSaleAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.recSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }


    /**
     * output prmtkbConFeedPolicy_Changed() method
     */
    public void prmtkbConFeedPolicy_Changed() throws Exception
    {
        System.out.println("prmtkbConFeedPolicy_Changed() Function is executed!");
            txtconFeedPolicySub.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtkbConFeedPolicy.getData(),"subsidy")));


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
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("Fivouchered"));
        sic.add(new SelectorItemInfo("isHasPaymentBill"));
        sic.add(new SelectorItemInfo("isKouBZJ"));
        sic.add(new SelectorItemInfo("singleDyFee"));
        sic.add(new SelectorItemInfo("punishAmt"));
        sic.add(new SelectorItemInfo("meatRate"));
        sic.add(new SelectorItemInfo("preHouseWgt"));
        sic.add(new SelectorItemInfo("drugAmt"));
        sic.add(new SelectorItemInfo("batchAmt"));
        sic.add(new SelectorItemInfo("bEBankAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("conFeedPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("conFeedPolicy.id"));
        	sic.add(new SelectorItemInfo("conFeedPolicy.number"));
        	sic.add(new SelectorItemInfo("conFeedPolicy.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
        	sic.add(new SelectorItemInfo("batch.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("conFeededNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("feedWgt"));
        sic.add(new SelectorItemInfo("recDate"));
        sic.add(new SelectorItemInfo("punishWgt"));
        sic.add(new SelectorItemInfo("survivalRate"));
        sic.add(new SelectorItemInfo("marginAmt"));
        sic.add(new SelectorItemInfo("adPayAmount"));
        sic.add(new SelectorItemInfo("mlyAllAmt"));
        sic.add(new SelectorItemInfo("chickenAveWgt"));
        sic.add(new SelectorItemInfo("settleWgt"));
        sic.add(new SelectorItemInfo("recQty"));
        sic.add(new SelectorItemInfo("feedQty"));
        sic.add(new SelectorItemInfo("inDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bEBank.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bEBank.id"));
        	sic.add(new SelectorItemInfo("bEBank.number"));
        	sic.add(new SelectorItemInfo("bEBank.name"));
		}
        sic.add(new SelectorItemInfo("cFBeginDate"));
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
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
        sic.add(new SelectorItemInfo("cFEndDate"));
        sic.add(new SelectorItemInfo("bankNum"));
        sic.add(new SelectorItemInfo("batchQty"));
        sic.add(new SelectorItemInfo("feedAmt"));
        sic.add(new SelectorItemInfo("feedDays"));
        sic.add(new SelectorItemInfo("recAmt"));
        sic.add(new SelectorItemInfo("dyFee"));
        sic.add(new SelectorItemInfo("singleDrugAmt"));
        sic.add(new SelectorItemInfo("singleFeedWgt"));
        sic.add(new SelectorItemInfo("oValue"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("conFeedContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("conFeedContract.id"));
        	sic.add(new SelectorItemInfo("conFeedContract.number"));
		}
        sic.add(new SelectorItemInfo("kbItemAmt"));
        sic.add(new SelectorItemInfo("QCItemAmt"));
        sic.add(new SelectorItemInfo("viewItemAmt"));
        sic.add(new SelectorItemInfo("otherItemAmt"));
        sic.add(new SelectorItemInfo("tempItemAmt"));
        sic.add(new SelectorItemInfo("payOweMoneryB"));
        sic.add(new SelectorItemInfo("recSuttle"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("farmsType"));
        sic.add(new SelectorItemInfo("outSaleKbAmt2"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PreHouseEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("PreHouseEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.billStatus"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.preHouseQty"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.preHouseTare"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.preHouseGross"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.preHouseSuttle"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.recQty"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.settleWgt"));
    	sic.add(new SelectorItemInfo("PreHouseEntrys.recSuttle"));
    	sic.add(new SelectorItemInfo("SeedSourceEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SeedSourceEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SeedSourceEntrys.storageOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SeedSourceEntrys.storageOrgUnit.id"));
			sic.add(new SelectorItemInfo("SeedSourceEntrys.storageOrgUnit.name"));
        	sic.add(new SelectorItemInfo("SeedSourceEntrys.storageOrgUnit.number"));
		}
    	sic.add(new SelectorItemInfo("SeedSourceEntrys.lot"));
    	sic.add(new SelectorItemInfo("SeedSourceEntrys.qty"));
        sic.add(new SelectorItemInfo("chickenRetunAmt"));
        sic.add(new SelectorItemInfo("beforeBatchAmount"));
        sic.add(new SelectorItemInfo("idCodeCode"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("chickenSource"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("oneMrgin"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
		}
        sic.add(new SelectorItemInfo("drugQty"));
        sic.add(new SelectorItemInfo("farmeronlyPro"));
        sic.add(new SelectorItemInfo("farmerOnlyProOne"));
        sic.add(new SelectorItemInfo("proDiv"));
        sic.add(new SelectorItemInfo("occupyMargin"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.recType"));
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.weight"));
    	sic.add(new SelectorItemInfo("entrys.price"));
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.averageWgt"));
        sic.add(new SelectorItemInfo("isOrdinary"));
        sic.add(new SelectorItemInfo("noCalFodderPunish"));
        sic.add(new SelectorItemInfo("noCalDrupPunish"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("kbConFeedPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("kbConFeedPolicy.id"));
        	sic.add(new SelectorItemInfo("kbConFeedPolicy.number"));
        	sic.add(new SelectorItemInfo("kbConFeedPolicy.name"));
		}
        sic.add(new SelectorItemInfo("contractCKWgt"));
        sic.add(new SelectorItemInfo("freightDiffSubsidies"));
        sic.add(new SelectorItemInfo("lFeedWgt"));
        sic.add(new SelectorItemInfo("freightPrice"));
        sic.add(new SelectorItemInfo("freightSubsidiesStd"));
        sic.add(new SelectorItemInfo("deductMargin"));
        sic.add(new SelectorItemInfo("totalMargin"));
        sic.add(new SelectorItemInfo("enableMargin"));
        sic.add(new SelectorItemInfo("deductAdPayAmt"));
        sic.add(new SelectorItemInfo("loanRate"));
        sic.add(new SelectorItemInfo("kYFKOccupyFee"));
        sic.add(new SelectorItemInfo("fmRatePunishStd"));
        sic.add(new SelectorItemInfo("dyfBalance"));
        sic.add(new SelectorItemInfo("moneyOccupyDays"));
        sic.add(new SelectorItemInfo("conFeedPolicySub"));
        sic.add(new SelectorItemInfo("payOweMonery"));
        sic.add(new SelectorItemInfo("outSaleKbAmt"));
        sic.add(new SelectorItemInfo("unLockedMargin"));
        sic.add(new SelectorItemInfo("adPayBalance"));
        sic.add(new SelectorItemInfo("QCKbDetail"));
        sic.add(new SelectorItemInfo("otherKbDetail"));
        sic.add(new SelectorItemInfo("immuneCost"));
        sic.add(new SelectorItemInfo("immuneCostOne"));
        sic.add(new SelectorItemInfo("cleanHouse"));
        sic.add(new SelectorItemInfo("cleanHouseOne"));
        sic.add(new SelectorItemInfo("actualFoder"));
        sic.add(new SelectorItemInfo("standFodder"));
    	sic.add(new SelectorItemInfo("QCEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("QCEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("QCEntrys.QCItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("QCEntrys.QCItem.id"));
			sic.add(new SelectorItemInfo("QCEntrys.QCItem.name"));
        	sic.add(new SelectorItemInfo("QCEntrys.QCItem.number"));
		}
    	sic.add(new SelectorItemInfo("QCEntrys.randPType"));
    	sic.add(new SelectorItemInfo("QCEntrys.actualRate"));
    	sic.add(new SelectorItemInfo("QCEntrys.punishAmt"));
    	sic.add(new SelectorItemInfo("QCEntrys.actualWgt"));
    	sic.add(new SelectorItemInfo("QCEntrys.punishWgt"));
    	sic.add(new SelectorItemInfo("QCEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("ViewReqEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ViewReqEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ViewReqEntrys.viewType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ViewReqEntrys.viewType.id"));
			sic.add(new SelectorItemInfo("ViewReqEntrys.viewType.name"));
        	sic.add(new SelectorItemInfo("ViewReqEntrys.viewType.number"));
		}
    	sic.add(new SelectorItemInfo("ViewReqEntrys.amount"));
    	sic.add(new SelectorItemInfo("ViewReqEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("ViewReqEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("ViewReqEntrys.billStatus"));
    	sic.add(new SelectorItemInfo("ViewReqEntrys.auditAmt"));
    	sic.add(new SelectorItemInfo("OtherEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OtherEntrys.rpType"));
    	sic.add(new SelectorItemInfo("OtherEntrys.amount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntrys.suType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OtherEntrys.suType.id"));
			sic.add(new SelectorItemInfo("OtherEntrys.suType.name"));
        	sic.add(new SelectorItemInfo("OtherEntrys.suType.number"));
		}
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TempPolicyEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TempPolicyEntrys.tempPolicy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TempPolicyEntrys.tempPolicy.id"));
			sic.add(new SelectorItemInfo("TempPolicyEntrys.tempPolicy.name"));
        	sic.add(new SelectorItemInfo("TempPolicyEntrys.tempPolicy.number"));
		}
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.kbPrice"));
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.materialType"));
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.calUnit"));
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.kbAmount"));
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.dateRelate"));
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.beginDate"));
    	sic.add(new SelectorItemInfo("TempPolicyEntrys.endDate"));
        sic.add(new SelectorItemInfo("SeedCost"));
        sic.add(new SelectorItemInfo("fodderCost"));
        sic.add(new SelectorItemInfo("drugCost"));
        sic.add(new SelectorItemInfo("allocateAmt"));
        sic.add(new SelectorItemInfo("unitCost"));
        sic.add(new SelectorItemInfo("allCost"));
        sic.add(new SelectorItemInfo("daiyFee"));
        sic.add(new SelectorItemInfo("companyProfit"));
        sic.add(new SelectorItemInfo("otherMatCost"));
        sic.add(new SelectorItemInfo("actualVoucher"));
        sic.add(new SelectorItemInfo("preVoucher"));
        sic.add(new SelectorItemInfo("transVoucher"));
        sic.add(new SelectorItemInfo("hasPay"));
        sic.add(new SelectorItemInfo("reserveRiskCost"));
        sic.add(new SelectorItemInfo("brokenCost"));
        sic.add(new SelectorItemInfo("longBorrowReturn"));
        sic.add(new SelectorItemInfo("tranCost"));
        sic.add(new SelectorItemInfo("actualPayAmt"));
        sic.add(new SelectorItemInfo("specialPermitAmt"));
        sic.add(new SelectorItemInfo("specialBorrowinst"));
        sic.add(new SelectorItemInfo("longBorrowAmount"));
        sic.add(new SelectorItemInfo("equipmentReAmt"));
        sic.add(new SelectorItemInfo("borrowAmiunt"));
        sic.add(new SelectorItemInfo("marginGAmount"));
        sic.add(new SelectorItemInfo("coalCost"));
        sic.add(new SelectorItemInfo("marginProfit"));
        sic.add(new SelectorItemInfo("getChickCost"));
        sic.add(new SelectorItemInfo("cleanHouseCost"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("cleanTowerCost"));
        sic.add(new SelectorItemInfo("nowAccountBac"));
        sic.add(new SelectorItemInfo("assetsOccupy"));
        sic.add(new SelectorItemInfo("noPfoRetAmt"));
        sic.add(new SelectorItemInfo("companyTC"));
        sic.add(new SelectorItemInfo("diverCt"));
    	sic.add(new SelectorItemInfo("SeedEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SeedEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("SeedEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("SeedEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("SeedEntrys.bizType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SeedEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SeedEntrys.material.id"));
			sic.add(new SelectorItemInfo("SeedEntrys.material.number"));
			sic.add(new SelectorItemInfo("SeedEntrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("SeedEntrys.materialName"));
    	sic.add(new SelectorItemInfo("SeedEntrys.qty"));
    	sic.add(new SelectorItemInfo("SeedEntrys.policyPrice"));
    	sic.add(new SelectorItemInfo("SeedEntrys.amount"));
    	sic.add(new SelectorItemInfo("SeedEntrys.billStatus"));
    	sic.add(new SelectorItemInfo("SeedEntrys.unitCost"));
    	sic.add(new SelectorItemInfo("SeedEntrys.cost"));
    	sic.add(new SelectorItemInfo("SeedEntrys.contPrice"));
    	sic.add(new SelectorItemInfo("SeedEntrys.contAmount"));
    	sic.add(new SelectorItemInfo("SeedEntrys.actPrice"));
    	sic.add(new SelectorItemInfo("SeedEntrys.actAmount"));
    	sic.add(new SelectorItemInfo("FodderEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("FodderEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("FodderEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("FodderEntrys.bizType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.material.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.material.number"));
			sic.add(new SelectorItemInfo("FodderEntrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("FodderEntrys.materialName"));
    	sic.add(new SelectorItemInfo("FodderEntrys.unitQty"));
    	sic.add(new SelectorItemInfo("FodderEntrys.bagQty"));
    	sic.add(new SelectorItemInfo("FodderEntrys.qty"));
    	sic.add(new SelectorItemInfo("FodderEntrys.policyPrice"));
    	sic.add(new SelectorItemInfo("FodderEntrys.amount"));
    	sic.add(new SelectorItemInfo("FodderEntrys.billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.Car.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.Car.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.Car.number"));
			sic.add(new SelectorItemInfo("FodderEntrys.Car.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.driver.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.driver.drivername"));
			sic.add(new SelectorItemInfo("FodderEntrys.driver.name"));
        	sic.add(new SelectorItemInfo("FodderEntrys.driver.number"));
		}
    	sic.add(new SelectorItemInfo("FodderEntrys.unitCost"));
    	sic.add(new SelectorItemInfo("FodderEntrys.cost"));
    	sic.add(new SelectorItemInfo("FodderEntrys.hjFee"));
    	sic.add(new SelectorItemInfo("DrugEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("DrugEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("DrugEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("DrugEntrys.bizType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DrugEntrys.material.id"));
			sic.add(new SelectorItemInfo("DrugEntrys.material.number"));
			sic.add(new SelectorItemInfo("DrugEntrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("DrugEntrys.materialName"));
    	sic.add(new SelectorItemInfo("DrugEntrys.qty"));
    	sic.add(new SelectorItemInfo("DrugEntrys.policyPrice"));
    	sic.add(new SelectorItemInfo("DrugEntrys.amount"));
    	sic.add(new SelectorItemInfo("DrugEntrys.billStatus"));
    	sic.add(new SelectorItemInfo("DrugEntrys.unitCost"));
    	sic.add(new SelectorItemInfo("DrugEntrys.cost"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SlaughterEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("SlaughterEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.preHouseSuttle"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.recQty"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.carcassQty"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.carcassWgt"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.inCompleteQty"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.inCompleteWgt"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.billStatus"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.AWeight"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.punishAllWeight"));
    	sic.add(new SelectorItemInfo("SlaughterEntrys.settlementAllWig"));
    	sic.add(new SelectorItemInfo("SaleEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("SaleEntrys.saleType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntrys.customer.id"));
			sic.add(new SelectorItemInfo("SaleEntrys.customer.name"));
        	sic.add(new SelectorItemInfo("SaleEntrys.customer.number"));
		}
    	sic.add(new SelectorItemInfo("SaleEntrys.outSalePrice"));
    	sic.add(new SelectorItemInfo("SaleEntrys.outSaleAmt"));
    	sic.add(new SelectorItemInfo("SaleEntrys.bizDate"));
    	sic.add(new SelectorItemInfo("SaleEntrys.billNumber"));
    	sic.add(new SelectorItemInfo("SaleEntrys.billStatus"));
    	sic.add(new SelectorItemInfo("SaleEntrys.recSuttle"));
    	sic.add(new SelectorItemInfo("SaleEntrys.baseStatus"));
        sic.add(new SelectorItemInfo("auditTime"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionClose_actionPerformed method
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().close(editData);
    }
    	

    /**
     * output actionUnClose_actionPerformed method
     */
    public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().unClose(editData);
    }
    	

    /**
     * output actionExecSettle_actionPerformed method
     */
    public void actionExecSettle_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().execSettle(editData);
    }
    	

    /**
     * output actionUpdateSaleData_actionPerformed method
     */
    public void actionUpdateSaleData_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().updateSaleData(editData);
    }
    	

    /**
     * output actionUpdateActAmt_actionPerformed method
     */
    public void actionUpdateActAmt_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().updateActAmt(editData);
    }
    	

    /**
     * output actionHasPay_actionPerformed method
     */
    public void actionHasPay_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory.getRemoteInstance().hasPay(editData);
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
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
	public RequestContext prepareActionExecSettle(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExecSettle() {
    	return false;
    }
	public RequestContext prepareActionUpdateSaleData(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateSaleData() {
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
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionClose", "actionClose_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionUnClose", "actionUnClose_actionPerformed", e);
        }
    }

    /**
     * output ActionExecSettle class
     */     
    protected class ActionExecSettle extends ItemAction {     
    
        public ActionExecSettle()
        {
            this(null);
        }

        public ActionExecSettle(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExecSettle.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExecSettle.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExecSettle.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionExecSettle", "actionExecSettle_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdateSaleData class
     */     
    protected class ActionUpdateSaleData extends ItemAction {     
    
        public ActionUpdateSaleData()
        {
            this(null);
        }

        public ActionUpdateSaleData(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdateSaleData.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateSaleData.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateSaleData.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionUpdateSaleData", "actionUpdateSaleData_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionUpdateActAmt", "actionUpdateActAmt_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKSettleBillEditUI.this, "ActionHasPay", "actionHasPay_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CKSettleBillEditUI");
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
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/CKSettleBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKSettleBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbatchContract.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次合同"});
		}
		for (int i=0,n=kdtOtherEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtOtherEntrys.getCell(i,"amount").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"金额"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPreHouseEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("farmsType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtSlaughterEntrys,new String[] {"AWeight","punishAllWeight","settlementAllWig"});
		}


}