package com.kingdee.eas.weighbridge.comm;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.event.ChangeEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.agent.IObjectValueAgent;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTGroupingCollection;
import com.kingdee.bos.metadata.bot.BOTGroupingInfo;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationEntryCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.BOTRelationInfo;
import com.kingdee.bos.metadata.bot.BOTRuleCollection;
import com.kingdee.bos.metadata.bot.BOTRuleInfo;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.bot.IBOTRelation;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterCollection;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.sql.ParserException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.workflow.biz.agent.DefaultMultiBillWorkAgent;
import com.kingdee.bos.workflow.biz.agent.IMultiBillWorkAgent;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.botp.util.BOTPTools;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.btp.client.AbstractBTPMakeBillFromMultiData;
import com.kingdee.eas.base.btp.client.BOTClientTools;
import com.kingdee.eas.base.btp.client.BTPRPCHelper;
import com.kingdee.eas.base.netctrl.MutexParameter;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.client.UIActionPostman;
import com.kingdee.eas.framework.client.CoreBillEditUI;
import com.kingdee.eas.framework.client.CoreBillListUI;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.framework.client.RealModeIDList;
import com.kingdee.eas.framework.client.mutex.DataObjectMutex;
import com.kingdee.eas.framework.client.mutex.IDataObjectMutex;
import com.kingdee.eas.util.StringUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.StringUtils;

public class BTPMakeBillFromMultiDataEx extends AbstractBTPMakeBillFromMultiData {
	private static final long serialVersionUID = -5436765384153802733L;
	private static final Logger logger;
	
	private CoreBillEditUI billEditUI = null;

	private boolean isSupportAppendEntry = true;

	private Map srcBillNameToObject = new HashMap();

	private boolean isInitCbx = true;
	private String currDestBosType;
	private String currSrcBosType;
	private BOTMappingCollection botMappingCollection = null;
	private String orgUnitPropertyInBill;
	private String srcBillListUIName;
	private OrgType orgType;
	private String srcBillQueryName;
	private EntityViewInfo botpFilter;
	private static final String TRANSMITCU = "TRANSMITCU";
	private HashMap srcBillTypes = null;

	private BOTRelationCollection srcRelations = null;

	private CoreBillBaseInfo oldDestBill = null;
	private static String handlerName;

	public BTPMakeBillFromMultiDataEx() throws Exception {
		super();
	}

	public RequestContext prepareAction(RequestContext request) throws Exception {
		RequestContext superRequest = (RequestContext) super.prepareInit().getRequestContext();

		request.putAll(superRequest);

		request.setReleasNet(true);
		request.setNetParam((MutexParameter) getUIContext().get("MUTEXPARA"));

		return request;
	}

	public IUIActionPostman prepareRPC(RequestContext request) {
		IUIActionPostman handler = UIActionPostman.getInstance(this);
		handler.setAvailabe(true);
		request.setClassName(handlerName);
		handler.setRequestContext(request);
		return handler;
	}

	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();

		RequestContext request = (RequestContext) clientHanlder.getRequestContext();

		this.billEditUI = ((CoreBillEditUI) getUIContext().get("billEdit"));
		OrgUnitInfo orgUnit = this.billEditUI.getMainOrgInfo();
		if (orgUnit != null) {
			orgUnit = orgUnit.getCU();
		}
		Map transmitCtx = new HashMap();
		transmitCtx.put("TRANSMITCU", orgUnit);

		this.currDestBosType = getUIContext().get("destBillBOSTypeString").toString();
		this.oldDestBill = ((CoreBillEditUI) getUIContext().get("billEdit")).getEditData();

		if (this.oldDestBill !=null&&this.oldDestBill.getId() != null) {
			request.put("BTPMakeBillFromMultiData_Init_oldDestBillId", this.oldDestBill.getId().toString());
		}

		request.put("BTPMakeBillFromMultiData_Init_destBosType", this.currDestBosType);
		request.put("BTPMakeBillFromMultiData_Init_transmitCtx", transmitCtx);

		return clientHanlder;
	}

	public boolean isPrepareInit() {
		return true;
	}

	public void onLoad() throws Exception {
		super.onLoad();
		this.txtDescription.setCustomBackgroundColor(new Color(192, 192, 192));
		this.btnOk.setEnabled(true);
		this.btnCancel.setEnabled(true);
		this.currDestBosType = getUIContext().get("destBillBOSTypeString").toString();

		this.billEditUI = ((CoreBillEditUI) getUIContext().get("billEdit"));

		fillSrcBosType();

		this.oldDestBill = this.billEditUI.getEditData();

		Map param = (Map) getUIContext().get("BTPEDITPARAMETER");
		if ((param != null) && (param.get("isSupportAppendEntry") != null)
				&& (Boolean.FALSE.equals(param.get("isSupportAppendEntry")))) {
			this.isSupportAppendEntry = false;
		}

		initButton();
	}

	private void initButton() throws BOSException, BTPException {
		this.typeStand.setEnabled(true);
		this.typeStand.setSelected(true);

		this.typeRePull.setSelected(false);
		this.typeRePull.setEnabled(false);

		this.typeAppendEntry.setSelected(false);
		this.typeAppendEntry.setEnabled(false);

		this.typeAppendEntry.setVisible(false);

		if ((this.oldDestBill == null) || (this.oldDestBill.getId() == null))
			return;
		IBOTRelation iBOTRelation = BOTRelationFactory.getRemoteInstance();
		EntityViewInfo srcViewInfo = new EntityViewInfo();

		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(
				new FilterItemInfo("destObjectID", this.oldDestBill.getId().toString(), CompareType.EQUALS));

		filter.getFilterItems().add(new FilterItemInfo("destEntityID", this.currDestBosType, CompareType.EQUALS));

		srcViewInfo.setFilter(filter);
		this.srcRelations = iBOTRelation.getCollection(srcViewInfo);

		Vector srcBillIDs = new Vector();
		if ((this.srcRelations == null) || (this.srcRelations.size() <= 0))
			return;
		this.typeStand.setEnabled(true);
		this.typeRePull.setEnabled(true);

		if (this.isSupportAppendEntry) {
			this.typeAppendEntry.setEnabled(true);
		}

		for (int i = 0; i < this.srcRelations.size(); ++i) {
			srcBillIDs.add(this.srcRelations.get(i).getSrcObjectID());
		}

		this.srcBillTypes = getRelatedBillType(srcBillIDs);

		if ((this.srcBillTypes != null) && (this.srcBillTypes.size() > 0) && (this.srcBillNameToObject != null)) {
			String tempSrcBosType = null;
			String tempSrcBosTypeAlias = null;
			Iterator itr = this.srcBillTypes.keySet().iterator();
			while (itr.hasNext()) {
				tempSrcBosType = (String) itr.next();

				Iterator itre = this.srcBillNameToObject.keySet().iterator();
				while (itre.hasNext()) {
					String alias = (String) itre.next();
					String type = (String) this.srcBillNameToObject.get(alias);
					if ((type != null) && (type.equalsIgnoreCase(tempSrcBosType))) {
						tempSrcBosTypeAlias = alias;
						break;
					}
				}
			}
			if (tempSrcBosTypeAlias == null) {
				this.typeRePull.setEnabled(false);
				this.typeAppendEntry.setEnabled(false);
			}
		} else {
			this.typeRePull.setEnabled(false);
			this.typeAppendEntry.setEnabled(false);
		}
		//******add by simple_dai
		this.typeStand.setEnabled(true);
		this.typeStand.setSelected(true);

		this.typeRePull.setSelected(false);
		this.typeRePull.setEnabled(false);
		this.typeRePull.setVisible(false);

		this.typeAppendEntry.setSelected(false);
		this.typeAppendEntry.setEnabled(false);
		this.typeAppendEntry.setVisible(false);
		//*************
	}

	private HashMap getRelatedBillType(Vector billCollection) throws BTPException {
		HashMap hashMap = new HashMap();

		if (billCollection != null) {
			for (int i = 0; i < billCollection.size(); ++i) {
				String BOSTypeString = BOSUuid.read((String) billCollection.get(i)).getType().toString();

				if (!(hashMap.containsKey(BOSTypeString))) {
					Vector vector = new Vector();
					vector.add(billCollection.get(i));
					hashMap.put(BOSTypeString, vector);
				} else {
					if (((Vector) hashMap.get(BOSTypeString)).contains(billCollection.get(i)))
						continue;
					((Vector) hashMap.get(BOSTypeString)).add(billCollection.get(i));
				}
			}

		} else {
			throw new BTPException(BTPException.BILLNORELATEDBILL);
		}

		return hashMap;
	}

	protected void initSrcBOSType() throws BOSException, EASBizException {
		String srcBillBosTypeAndAlias = BTPRPCHelper.getSrcBOSTypeAndAliasString(this.currDestBosType);

		String[] srcBillBosTypeAndAliasArray = StringUtil.split(srcBillBosTypeAndAlias, "|");

		assert (srcBillBosTypeAndAliasArray.length == 2);
		if (srcBillBosTypeAndAliasArray.length != 2) {
			MsgBox.showWarning((Component) getUIContext().get("Owner"), EASResource
					.getString("com.kingdee.eas.base.btp.btpResource.noDestBill"));

			SysUtil.abort();
		}
		String[] srcBillBosTypeArray = StringUtil.split(srcBillBosTypeAndAliasArray[0], ",");

		String[] srcBillAliasArray = StringUtil.split(srcBillBosTypeAndAliasArray[1], ",");

		assert (srcBillBosTypeArray.length == srcBillAliasArray.length);

		List srcBillBosTypeList = new ArrayList();
		int i = 0;
		for (int count = srcBillBosTypeArray.length; i < count; ++i) {
			srcBillBosTypeList.add(srcBillBosTypeArray[i]);
		}

		srcBillBosTypeList = this.billEditUI.getSrcBosTypeForBotp(srcBillBosTypeList);

		if ((srcBillBosTypeList == null) || (srcBillBosTypeList.size() == 0)) {
			MsgBox.showWarning((Component) getUIContext().get("Owner"), EASResource
					.getString("com.kingdee.eas.base.btp.btpResource.noDestBill"));

			SysUtil.abort();
		}

		this.srcBillNameToObject.clear();

		IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();

		for (int j = 0; j < srcBillBosTypeArray.length; ++j) {
			if (srcBillBosTypeList.contains(srcBillBosTypeArray[j])) {
				EntityObjectInfo tempObj = loader.getEntity(BOSObjectType.create(srcBillBosTypeArray[j]));

				this.srcBillNameToObject.put(srcBillAliasArray[j], srcBillBosTypeArray[j]);
				this.cmbSrcBosType.addItem(srcBillAliasArray[j]);
			}
		}
	}

	private void fillSrcBosType() throws Exception {
		this.isInitCbx = false;

		initSrcBOSType();

		if (this.cmbSrcBosType.getItemCount() > 0)
			this.cmbSrcBosType.setSelectedIndex(0);
	}

	public void loadFields() {
		super.loadFields();
	}

	public void storeFields() {
		super.storeFields();
	}

	public boolean isPrepareActionOk() {
		return false;
	}

	private List getSelectEntryIDs(CoreBillListUI billListUI, CoreBillBaseCollection srcBills) {
		List entryids = new ArrayList();
		if (billListUI == null) {
			return entryids;
		}
		String entryName = billListUI.getEntriesName();
		for (int i = 0; i < srcBills.size(); ++i) {
			CoreBillBaseInfo bills = srcBills.get(i);
			IObjectCollection entries = (IObjectCollection) bills.get(entryName);

			if (entries == null) {
				return entryids;
			}
			Iterator iters = entries.iterator();
			while (iters.hasNext()) {
				CoreBaseInfo cInfo = (CoreBaseInfo) iters.next();
				String ss = cInfo.getId().toString();
				entryids.add(ss);
			}
		}
		return entryids;
	}

	private String getBizListUIClassName(Object obj, String currDestBosType) {
		String methodName = "getBOTPCreateFromListUIClassName";
		Class[] clzs = { String.class };
		Object[] params = { currDestBosType };
		String uiClassName = "";
		try {
			uiClassName = (String) BOTPTools.invokeDynMethod(obj, methodName, clzs, params);
		} catch (BOSException e) {
			uiClassName = "";
			logger.error(e);
		}
		return uiClassName;
	}

	public void actionOk_actionPerformed(ActionEvent e) throws Exception {
		if ((this.botMappingCollection == null) || (this.cmbBotMapping.getSelectedIndex() < 0)) {
			throw new BOTPException(BOTPException.NOMAPPING);
		}
		BOTMappingInfo botMappingInfo = this.botMappingCollection.get(this.cmbBotMapping.getSelectedIndex());

		CoreBillListUI srcBillListUI = null;

		CoreBillEditUI billEditUI = (CoreBillEditUI) getUIContext().get("billEdit");

		this.currDestBosType = String.valueOf(botMappingInfo.getDestEntityName());

		String srcBIZListUIClassName = "";
		srcBIZListUIClassName = getBizListUIClassName(billEditUI, this.currDestBosType);

		IUIWindow uiWin = initSrcListUI(botMappingInfo);

		BTPMakeBillFromMultiDataListUIEx srcListUI = (BTPMakeBillFromMultiDataListUIEx) uiWin.getUIObject();

		String tempSrcBosType = this.srcBillNameToObject.get(this.cmbSrcBosType.getSelectedItem()).toString();

		srcListUI.setListUIClassName(srcBIZListUIClassName);
		srcListUI.setSrcBosType(tempSrcBosType);
		CoreBillBaseCollection srcBillCollection = null;

		uiWin.show();
		if (srcListUI.isCancel()) {
			return;
		}

		srcBillCollection = srcListUI.getSrcBillCollection();
		srcBillListUI = srcListUI.getCurrentBillListUI();
		if ((srcBillCollection == null) || (srcBillListUI == null)) {
			return;
		}

		if ((billEditUI != null) && (billEditUI.getDataObject() != null)
				&& (billEditUI.getDataObject().get("ID") != null)) {
			if (this.typeAppendEntry.isSelected())
				billEditUI.actionEdit_actionPerformed(null);
			else {
				billEditUI.actionAddNew_actionPerformed(null);
			}

		}

		srcBillListUI.beforeTransform(srcBillCollection, this.currDestBosType);

		String[] idList = new String[srcBillCollection.size()];
		for (int i = 0; i < srcBillCollection.size(); ++i) {
			idList[i] = srcBillCollection.get(i).getId().toString();
		}
		String[] entryNames = { srcBillListUI.getEntriesName() };

		List entriesKey = getSelectEntryIDs(srcBillListUI, srcBillCollection);

		String srcBillType = srcBillCollection.get(0).getBOSType().toString();

		SelectorItemCollection botpSelectors = null;

		IBTPManager iBTPManager = BTPManagerFactory.getRemoteInstanceWithObjectContext((Context) getUIContext().get(
				"Dest_MainOrgContext"));

		botpSelectors = null;
		if (botMappingInfo.getIsTempSave() == 2) {
			botpSelectors = BOTClientTools.getBillEditUISelector(this.currDestBosType);
		}
		BTPTransformResult btpResult = null;
		getUIContext().put("ifOk", "NO");
		billEditUI.setMakeRelations(null);

		BOTClientTools.reBuildControl(this, botMappingInfo, srcBillCollection, this.currDestBosType);

		if (this.typeStand.isSelected()) {
			btpResult = iBTPManager.transformForBotp(idList, entryNames, entriesKey, botpSelectors,
					this.currDestBosType, new ObjectUuidPK(botMappingInfo.getId().toString()), srcBillType);
		} else if (this.typeRePull.isSelected()) {
			String destID = this.oldDestBill.getId().toString();
			btpResult = iBTPManager.transformForBotpRepull(idList, entryNames, entriesKey, botpSelectors,
					this.currDestBosType, new ObjectUuidPK(botMappingInfo.getId().toString()), srcBillType, destID);
		} else {
			String destID = this.oldDestBill.getId().toString();
			btpResult = iBTPManager.transformForBotpAppend(idList, entryNames, entriesKey, botpSelectors,
					this.currDestBosType, new ObjectUuidPK(botMappingInfo.getId().toString()), srcBillType, destID);
		}

		getUIWindow().close();
		IObjectCollection destBillCols = null;
		BOTRelationCollection botRelationCols = null;
		this.billEditUI.getUIContext().put("srcBillID", getUIContext().get("srcBillID"));

		destBillCols = btpResult.getBills();
		this.billEditUI.getUIContext().put("destBillCols", destBillCols);//add by simple_dai 20150414
		botRelationCols = btpResult.getBOTRelationCollection();
		if ((destBillCols != null) && (destBillCols.size() == 0)) {
			throw new BTPException(BTPException.DESTBILLNULL);
		}
		/*if (this.typeRePull.isSelected()) {
			redoCreateFrom(this.oldDestBill, botMappingInfo, destBillCols, botRelationCols, iBTPManager);
		} else if (this.typeAppendEntry.isSelected()) {
			appendCreateFrom(destBillCols, botRelationCols, botMappingInfo, iBTPManager);
		} else
			doCreateFrom(botMappingInfo, destBillCols, botRelationCols, iBTPManager);*/
		this.billEditUI.setMakeRelations(botRelationCols);
	}

	private String getDestEntryName() {
		IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();

		String listui = null;
		try {
			EntityObjectInfo tempObj = loader.getEntity(BOSObjectType.create(this.currDestBosType));

			listui = (tempObj.getExtendedProperty("listUI") == null) ? null : tempObj.getExtendedProperty("listUI")
					.toString();
		} catch (Exception e) {
			logger.error("error when getExtendedProperty()");
			return "entries";
		}
		if (listui != null) {
			try {
				Class listUIClass = Class.forName(listui);
				Object uiObject = listUIClass.newInstance();
				if (uiObject instanceof CoreBillListUI)
					return ((CoreBillListUI) uiObject).getEntriesName();
			} catch (Exception e) {
				logger.error("error invoke method getEntriesName");
			}
		}
		return "entries";
	}

	private void appendCreateFrom(IObjectCollection destBillCols, BOTRelationCollection botRelationCols,
			BOTMappingInfo botMappingInfo, IBTPManager manager) throws EASBizException, Exception {
		IObjectValue oldValue = this.billEditUI.getEditData();
		if (oldValue instanceof IObjectValueAgent) {
			oldValue = (AbstractObjectValue) ((IObjectValueAgent) this.oldDestBill).getInfoInstance();
		}
		if ((oldValue.get("id") == null) || (!(oldValue instanceof CoreBillBaseInfo))) {
			return;
		}
		String entryName = getDestEntryName();
		String oldBillID = oldValue.get("id").toString();
		if ((destBillCols == null) || (destBillCols.size() <= 0)) {
			return;
		}
		for (int i = 0; i < destBillCols.size(); ++i) {
			IObjectValue destInfo = destBillCols.getObject(i);

			IObjectCollection destEntryColl = (IObjectCollection) destInfo.get(entryName);

			IObjectCollection oldEntryColl = (IObjectCollection) oldValue.get(entryName);

			if ((destEntryColl == null) || (oldEntryColl == null))
				continue;
			oldEntryColl.addObjectCollection(destEntryColl);
		}

		BOTRelationCollection oldRelationCol = BTPManagerFactory.getRemoteInstance().getRelationCollection(oldBillID);

		for (int i = 0; i < botRelationCols.size(); ++i) {
			BOTRelationInfo newRelation = botRelationCols.get(i);
			newRelation.setDestObjectID(oldBillID);
			BOTRelationEntryCollection newEntrys = newRelation.getRelationEntries();
			for (int k = 0; k < newEntrys.size(); ++k) {
				newEntrys.get(k).setDestObjectID(oldBillID);
			}

			boolean isFound = false;

			for (int k = 0; k < oldRelationCol.size(); ++k) {
				BOTRelationInfo oldRelation = oldRelationCol.get(k);
				if (!(newRelation.getSrcObjectID().equalsIgnoreCase(oldRelation.getSrcObjectID())))
					continue;
				oldRelation.getRelationEntries().addCollection(newEntrys);
				newRelation.getRelationEntries().clear();
				isFound = true;
			}

			if (!(isFound)) {
				oldRelationCol.add(newRelation);
			}
		}

		manager.saveRelations((CoreBillBaseInfo) oldValue, oldRelationCol);

		IIDList idListOne = RealModeIDList.getEmptyIDList();
		idListOne.add(((CoreBillBaseInfo) oldValue).getId().toString());
		idListOne.setCurrentIndex(0);

		this.billEditUI.getUIContext().remove("ID");
		this.billEditUI.getUIContext().remove("IDList");
		this.billEditUI.getUIContext().remove("InitDataObject");

		this.billEditUI.getUIContext().put("ID", idListOne.getCurrentID());

		this.billEditUI.getUIContext().put("IDList", idListOne);
		this.billEditUI.setOprtState("EDIT");
		this.billEditUI.getUIContext().put("BOTPViewStatus", new Integer(1));

		this.billEditUI.onLoad();
	}

	private IUIWindow initSrcListUI(BOTMappingInfo botMappingInfo) throws EASBizException, BOSException {
		IUIFactory uiFactory = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UINewFrameFactory");

		HashMap uiCtx = new HashMap();
		uiCtx.put("Owner", this);

		if (getUIContext().get("BTPEDITPARAMETER") != null) {
			uiCtx.put("BTPEDITPARAMETER", getUIContext().get("BTPEDITPARAMETER"));
		}

		uiCtx.put("BOTPFilter", this.botpFilter);
		uiCtx.put("BOTMappingInfo_ID", botMappingInfo.getId());

		uiCtx.put("needEntries", Boolean.valueOf(isNeedSaveEntries(botMappingInfo)));

		uiCtx.put("srcBillTypes", this.srcBillTypes);

		uiCtx.put("oldDestBill", this.oldDestBill);

		if (this.typeAppendEntry.isSelected()) {
			uiCtx.put("BOTP_CREATEFROM_TYPEFLAG", new Integer(2));
		} else if (this.typeStand.isSelected()) {
			uiCtx.put("BOTP_CREATEFROM_TYPEFLAG", new Integer(0));
		} else {
			uiCtx.put("BOTP_CREATEFROM_TYPEFLAG", new Integer(1));
		}
//modify by simple_dai 20150427
		//IUIWindow uiWin = uiFactory.create("com.kingdee.eas.base.btp.client.BTPMakeBillFromMultiDataListUIEx", uiCtx);
		IUIWindow uiWin = uiFactory.create("com.kingdee.eas.weighbridge.comm.BTPMakeBillFromMultiDataListUIEx", uiCtx);
		((UIModelDialog) uiWin).setResizable(true);

		return uiWin;
	}

	protected void redoCreateFrom(CoreBillBaseInfo destBillOld, BOTMappingInfo botMappingInfo,
			IObjectCollection destBillCols, BOTRelationCollection botRelationCols, IBTPManager iBTPManager)
			throws Exception {
		String number = destBillOld.getNumber();

		BOTRuleCollection col = botMappingInfo.getRules();
		for (int i = 0; i < col.size(); ++i) {
			BOTRuleInfo botRuleInfo = col.get(i);
			BOTGroupingCollection groups = botRuleInfo.getGroups();
			Iterator iter = groups.iterator();

			while (iter.hasNext()) {
				BOTGroupingInfo group = (BOTGroupingInfo) iter.next();

				String property = group.getGroupingProperty();
				Object value = destBillOld.get(property);
				if (value != null) {
					String valueString = value.toString();

					for (int j = 0; j < destBillCols.size(); ++j) {
						CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(i);

						Object obj = destBillInfo.get(property);
						if (obj != null) {
							String valueS = obj.toString();

							if (valueS.equalsIgnoreCase(valueString)) {
								destBillInfo.setNumber(number);
							}

						}

					}

				}

			}

		}

		if (destBillCols.size() > 1) {
			IIDList idList = RealModeIDList.getEmptyIDList();
			int showIndex = 0;

			int i = 0;
			for (int count = destBillCols.size(); i < count; ++i) {
				CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(i);

				IMultiBillWorkAgent agent = new DefaultMultiBillWorkAgent();
				agent.markBotpTransfer(destBillInfo, destBillInfo.getId().toString());

				idList.add(destBillInfo.getId().toString());
				String fNumber = destBillInfo.getNumber();
				if ((fNumber != null) && (fNumber.equalsIgnoreCase(number))) {
					showIndex = i;
				}

			}

			idList.setCurrentIndex(showIndex);

			this.billEditUI.getUIContext().remove("ID");
			this.billEditUI.getUIContext().remove("IDList");
			this.billEditUI.getUIContext().remove("InitDataObject");

			this.billEditUI.getUIContext().put("ID", idList.getID(showIndex));

			this.billEditUI.getUIContext().put("IDList", idList);
			this.billEditUI.setOprtState("EDIT");
			this.billEditUI.getUIContext().put("BOTPViewStatus", new Integer(1));

			this.billEditUI.onLoad();
		} else if (botMappingInfo.getIsTempSave() == 2) {
			IObjectValue destBillInfo = destBillCols.getObject(0);

			IMultiBillWorkAgent agent = new DefaultMultiBillWorkAgent();
			agent.markBotpTransfer(destBillInfo, destBillInfo.get("id").toString());

			this.billEditUI.setMakeRelations(botRelationCols);

			this.billEditUI.getUIContext().remove("ID");
			this.billEditUI.getUIContext().remove("IDList");
			this.billEditUI.getUIContext().remove("InitDataObject");

			this.billEditUI.getUIContext().put("InitDataObject", destBillInfo);

			this.billEditUI.setOprtState("ADDNEW");
			this.billEditUI.getUIContext().put("BOTPViewStatus", new Integer(1));

			this.billEditUI.onLoad();
		} else {
			CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(0);

			IMultiBillWorkAgent agent = new DefaultMultiBillWorkAgent();
			agent.markBotpTransfer(destBillInfo, destBillInfo.getId().toString());

			IIDList idListOne = RealModeIDList.getEmptyIDList();
			idListOne.add(destBillInfo.getId().toString());

			idListOne.setCurrentIndex(0);

			this.billEditUI.getUIContext().remove("ID");
			this.billEditUI.getUIContext().remove("IDList");
			this.billEditUI.getUIContext().remove("InitDataObject");

			this.billEditUI.getUIContext().put("ID", idListOne.getCurrentID());

			this.billEditUI.getUIContext().put("IDList", idListOne);
			this.billEditUI.setOprtState("EDIT");
			this.billEditUI.getUIContext().put("BOTPViewStatus", new Integer(1));

			this.billEditUI.onLoad();
		}
	}

	public void appendDestBillEntryByID(Context ctx, BOSObjectType destBosType, CoreBillBaseInfo oldDestBill,
			BTPTransformResult btpResult) throws BOSException, BTPException {
	}

	protected void doCreateFrom(BOTMappingInfo botMappingInfo, IObjectCollection destBillCols,
			BOTRelationCollection botRelationCols, IBTPManager iBTPManager) throws Exception {
		if (botMappingInfo.getIsShowEditUI() == 0) {
			MsgBox.showInfo(EASResource.getString("com.kingdee.eas.base.btp.btpResource.transSuccess"));

			return;
		}
		if ((botMappingInfo.getIsTempSave() != 2) || (destBillCols.size() > 1)) {
			IIDList idList = RealModeIDList.getEmptyIDList();
			int i = 0;
			for (int count = destBillCols.size(); i < count; ++i) {
				CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(i);

				IMultiBillWorkAgent agent = new DefaultMultiBillWorkAgent();
				agent.markBotpTransfer(destBillInfo, destBillInfo.getId().toString());

				idList.add(destBillInfo.getId().toString());
			}

			idList.setCurrentIndex(0);

			this.billEditUI.getUIContext().remove("ID");
			this.billEditUI.getUIContext().remove("IDList");
			this.billEditUI.getUIContext().remove("InitDataObject");

			this.billEditUI.getUIContext().put("ID", idList.getCurrentID());
			this.billEditUI.getUIContext().put("IDList", idList);
			this.billEditUI.setOprtState("EDIT");
			this.billEditUI.getUIContext().put("BOTPViewStatus", new Integer(1));

			this.billEditUI.prepareInit().callHandler();

			this.billEditUI.onLoad();
		} else {
			IObjectValue destBillInfo = destBillCols.getObject(0);

			IMultiBillWorkAgent agent = new DefaultMultiBillWorkAgent();
			agent.markBotpTransfer(destBillInfo, destBillInfo.get("id").toString());

			this.billEditUI.setMakeRelations(botRelationCols);

			this.billEditUI.getUIContext().remove("ID");
			this.billEditUI.getUIContext().remove("IDList");
			this.billEditUI.getUIContext().remove("InitDataObject");

			this.billEditUI.getUIContext().put("InitDataObject", destBillInfo);

			this.billEditUI.setOprtState("ADDNEW");
			this.billEditUI.getUIContext().put("BOTPViewStatus", new Integer(1));

			if (destBillCols.getObject(0).get("id") != null) {
				IDataObjectMutex mutextControl = new DataObjectMutex();
				try {
					mutextControl.requestDataObjectLock(destBillCols.getObject(0).get("id").toString());
				} catch (Throwable e) {
					logger.error("error occur when requestDataObjectLock!--------");
				}

			}

			this.billEditUI.prepareInit().callHandler();

			this.billEditUI.onLoad();
		}
	}

	private EntityViewInfo getQueryFilterFromBotMapping(BOTMappingInfo botMappingInfo) throws ParserException,
			BOSException {
		EntityViewInfo filter = null;
		if ((botMappingInfo.getExtRule().getFilter() != null) && (botMappingInfo.getExtRule().getFilter().length() > 0)) {
			filter = new EntityViewInfo(botMappingInfo.getExtRule().getFilter());
		}
		EntityViewInfo dataFilter = null;
		if ((botMappingInfo.getExtRule().getDataFilter() != null)
				&& (botMappingInfo.getExtRule().getDataFilter().length() > 0)) {
			dataFilter = new EntityViewInfo(botMappingInfo.getExtRule().getDataFilter());
		}

		EntityViewInfo botpFilter = mergeEntityFilterAndTransToQueryFilter(filter, dataFilter);
		return botpFilter;
	}

	private EntityViewInfo mergeEntityFilterAndTransToQueryFilter(EntityViewInfo filter, EntityViewInfo dataFilter)
			throws BOSException {
		EntityViewInfo botpFilter = new EntityViewInfo();
		if (filter == null) {
			botpFilter = dataFilter;
		} else if (dataFilter == null) {
			botpFilter = filter;
		} else {
			FilterInfo billFilter = null;
			if ((filter.getFilter() == null) || (filter.getFilter().getFilterItems().size() == 0)) {
				billFilter = dataFilter.getFilter();
			} else if ((dataFilter.getFilter() == null) || (dataFilter.getFilter().getFilterItems().size() == 0)) {
				billFilter = filter.getFilter();
			} else {
				billFilter = filter.getFilter();
				billFilter.mergeFilter(dataFilter.getFilter(), "and");
			}
			if (billFilter == null) {
				billFilter = new FilterInfo();
			}
			botpFilter.setFilter(billFilter);

			FilterCollection entryFilterCols = null;
			if ((filter.getEntryFilters() == null) && (filter.getEntryFilters().size() == 0)) {
				entryFilterCols = dataFilter.getEntryFilters();
			} else if ((dataFilter.getEntryFilters() == null) || (dataFilter.getEntryFilters().size() == 0)) {
				entryFilterCols = filter.getEntryFilters();
			} else {
				entryFilterCols = new FilterCollection();
				entryFilterCols.addObjectCollection(filter.getEntryFilters());
				entryFilterCols.addObjectCollection(dataFilter.getEntryFilters());
			}

			if ((entryFilterCols != null) && (entryFilterCols.size() > 0)) {
				botpFilter.getEntryFilters().addObjectCollection(entryFilterCols);
			}

		}

		if (botpFilter == null) {
			botpFilter = new EntityViewInfo();
		}
		if (botpFilter.getFilter() == null) {
			FilterInfo defaultFilter = new FilterInfo();
			botpFilter.setFilter(defaultFilter);
		}
		if ((botpFilter.getEntryFilters() != null) && (botpFilter.getEntryFilters().size() > 0)) {
			FilterCollection entryFilterCols = botpFilter.getEntryFilters();
			FilterInfo billFilter = botpFilter.getFilter();
			FilterInfo entryQueryFilter = new FilterInfo();
			if ((entryFilterCols != null) && (entryFilterCols.size() > 0)) {
				int i = 0;
				for (int size = entryFilterCols.size(); i < size; ++i) {
					FilterInfo entryFilterInfo = entryFilterCols.get(i);
					if ((entryFilterInfo == null) || (entryFilterInfo.getFilterItems().size() <= 0))
						continue;
					String entryName = entryFilterInfo.getEntryName();
					int j = 0;
					int count = entryFilterInfo.getFilterItems().size();
					for (; j < count; ++j) {
						entryQueryFilter.getFilterItems().add(
								new FilterItemInfo(entryName + '.'
										+ entryFilterInfo.getFilterItems().get(j).getPropertyName(), entryFilterInfo
										.getFilterItems().get(j).getCompareValue(), entryFilterInfo.getFilterItems()
										.get(j).getCompareType()));
					}

					if (i == 0) {
						entryQueryFilter.setMaskString(entryFilterInfo.getMaskString());
					} else {
						entryQueryFilter.setMaskString(entryQueryFilter.getMaskString() + " and "
								+ entryFilterInfo.getMaskString());
					}

				}

			}

			if (entryQueryFilter.getFilterItems().size() > 0) {
				if (billFilter.getFilterItems().size() > 0)
					billFilter.mergeFilter(entryQueryFilter, "and");
				else {
					billFilter = entryQueryFilter;
				}
			}
			botpFilter.getEntryFilters().clear();
			botpFilter.setFilter(billFilter);
		}
		return botpFilter;
	}

	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancel_actionPerformed(e);
		getUIWindow().close();
	}

	protected void cmbSrcBosType_itemStateChanged(ItemEvent e) throws Exception {
		this.btnOk.setEnabled(true);

		if (e.getStateChange() == 2) {
			if (this.cmbBotMapping.getItemCount() == 0) {
				this.btnOk.setEnabled(false);
			}
			return;
		}

		OrgUnitInfo orgUnit = this.billEditUI.getMainOrgInfo();
		if (orgUnit != null) {
			orgUnit = orgUnit.getCU();
		}
		Map transmitCtx = new HashMap();
		transmitCtx.put("TRANSMITCU", orgUnit);

		String tempSrcBosType = this.srcBillNameToObject.get(this.cmbSrcBosType.getSelectedItem()).toString();

		String destBosType = getUIContext().get("destBillBOSTypeString").toString();

		String orgTypeInSrcBill = BOTPTools.getEntityObjectInfoExtendProClient(tempSrcBosType, "OrgType");

		this.srcBillQueryName = BOTPTools.getEntityObjectInfoExtendProClient(tempSrcBosType, "defaultF7Query");

		this.srcBillListUIName = BOTPTools.getEntityObjectInfoExtendProClient(tempSrcBosType, "listUI");

		IBOTMapping botMapping = BOTMappingFactory.getRemoteInstance();
		try {
			this.botMappingCollection = botMapping.getMappingCollectionForSelectWithoutData(tempSrcBosType,
					destBosType, transmitCtx);
		} catch (BOTPException botE) {
			if (getUIWindow() != null) {
				logger.error(botE);
			} else {
				logger.error(botE);
			}

		}

		this.cmbBotMapping.removeAllItems();

		this.botMappingCollection = this.billEditUI.getRulesForBotp(tempSrcBosType, "CreateFrom",
				this.botMappingCollection);

		if ((this.botMappingCollection == null) || (this.botMappingCollection.size() == 0)) {
			this.btnOk.setEnabled(false);
		}

		if (this.botMappingCollection != null) {
			int count = this.botMappingCollection.size();
			for (int i = 0; i < count; ++i) {
				this.cmbBotMapping.addItem(this.botMappingCollection.get(i).getAlias(
						SysContext.getSysContext().getLocale()));
			}

			if ((count > 0) && (this.cmbBotMapping.getItemCount() > 0))
				this.cmbBotMapping.setSelectedIndex(0);
		}
	}

	protected void cmbBotMapping_itemStateChanged(ItemEvent e) throws Exception {
		if ((e.getStateChange() != 1) || (this.botMappingCollection == null) || (this.botMappingCollection.size() <= 0))
			return;
		BOTMappingInfo botMappingInfo = this.botMappingCollection.get(this.cmbBotMapping.getSelectedIndex());

		this.isSupportAppendEntry = false;

		this.botpFilter = getQueryFilterFromBotMapping(botMappingInfo);
		if (botMappingInfo != null)
			this.txtDescription.setText(botMappingInfo.getDescription());
	}

	protected void typeRePull_stateChanged(ChangeEvent e) throws Exception {
		if (this.typeRePull.isSelected())
			resetByCreateType();
	}

	protected void typeStand_stateChanged(ChangeEvent e) throws Exception {
		if (!(this.typeStand.isSelected()))
			return;
		this.cmbSrcBosType.setEnabled(true);
		this.cmbBotMapping.setEnabled(true);
		return;
	}

	protected void typeAppendEntry_stateChanged(ChangeEvent e) throws Exception {
		if (this.typeAppendEntry.isSelected())
			resetByCreateType();
	}

	private void resetByCreateType() throws Exception {
		if ((this.srcBillNameToObject == null) || (this.srcBillNameToObject.size() <= 0)) {
			return;
		}
		String tempSrcBosType = null;
		String tempSrcBosTypeAlias = null;
		Iterator itr = this.srcBillTypes.keySet().iterator();
		while (itr.hasNext()) {
			tempSrcBosType = (String) itr.next();

			Iterator itre = this.srcBillNameToObject.keySet().iterator();
			while (itre.hasNext()) {
				String alias = (String) itre.next();
				String type = (String) this.srcBillNameToObject.get(alias);
				if (type.equalsIgnoreCase(tempSrcBosType)) {
					tempSrcBosTypeAlias = alias;
					break;
				}
			}
		}

		if (StringUtils.isEmpty(tempSrcBosTypeAlias)) {
			return;
		}
		this.cmbSrcBosType.setSelectedItem(tempSrcBosTypeAlias);

		CoreBillEditUI billEditUI = (CoreBillEditUI) getUIContext().get("billEdit");

		OrgUnitInfo orgUnit = billEditUI.getMainOrgInfo();
		if (orgUnit != null) {
			orgUnit = orgUnit.getCU();
		}
		Map transmitCtx = new HashMap();
		transmitCtx.put("TRANSMITCU", orgUnit);

		String destBosType = getUIContext().get("destBillBOSTypeString").toString();

		this.srcBillQueryName = BOTPTools.getEntityObjectInfoExtendProClient(tempSrcBosType, "defaultF7Query");

		this.srcBillListUIName = BOTPTools.getEntityObjectInfoExtendProClient(tempSrcBosType, "listUI");

		IBOTMapping botMapping = BOTMappingFactory.getRemoteInstance();
		try {
			this.botMappingCollection = botMapping.getMappingCollectionForSelectWithoutData(tempSrcBosType,
					destBosType, transmitCtx);
		} catch (BOTPException botE) {
			if (getUIWindow() != null) {
				throw botE;
			}
			botE.printStackTrace();
		}

		this.cmbBotMapping.removeAllItems();
		if (this.botMappingCollection != null) {
			int count = this.botMappingCollection.size();
			for (int i = 0; i < count; ++i) {
				this.cmbBotMapping.addItem(this.botMappingCollection.get(i).getAlias(
						SysContext.getSysContext().getLocale()));
			}

			if ((count > 0) && (this.cmbBotMapping.getItemCount() > 0)) {
				this.cmbBotMapping.setSelectedIndex(0);
			}

		}

		if ((this.srcRelations != null) && (this.srcRelations.size() != 0)) {
			String mappingId = this.srcRelations.get(0).getBOTMappingID();
			String mappingAlias = null;

			if ((this.botMappingCollection != null) && (this.botMappingCollection.size() > 0)) {
				for (int i = 0; i < this.botMappingCollection.size(); ++i) {
					BOTMappingInfo botMappingInfo = this.botMappingCollection.get(i);

					if (!(botMappingInfo.getId().toString().equalsIgnoreCase(mappingId)))
						continue;
					mappingAlias = botMappingInfo.getAlias(SysContext.getSysContext().getLocale());

					this.botpFilter = getQueryFilterFromBotMapping(botMappingInfo);

					break;
				}

			}

			if (mappingAlias == null) {
				MsgBox.showWarning((Component) getUIContext().get("Owner"), EASResource
						.getString("com.kingdee.eas.base.btp.btpResource.noDestBill"));

				SysUtil.abort();
			} else {
				this.cmbBotMapping.setSelectedItem(mappingAlias);
			}

		}

		this.cmbSrcBosType.setEnabled(false);
		this.cmbBotMapping.setEnabled(false);
	}

	private boolean isNeedSaveEntries(BOTMappingInfo mappingInfo) throws EASBizException, BOSException {
		IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();

		EntityObjectInfo srcEntity = loader.getEntity(BOSObjectType.create(mappingInfo.getSrcEntityName()));

		EntityObjectInfo destEntity = loader.getEntity(BOSObjectType.create(mappingInfo.getDestEntityName()));

		return ((BOTPTools.getExtendPropertyBooleanValue(null, srcEntity, "IsSaveBotpEntryRelation", true)) || (BOTPTools
				.getExtendPropertyBooleanValue(null, destEntity, "IsSaveBotpEntryRelation", true)));
	}

	static {
		logger = CoreUIObject.getLogger(BTPMakeBillFromMultiDataEx.class);

		handlerName = "com.kingdee.eas.base.btp.app.BTPMakeBillFromMultiDataHandler";
	}
}
