/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Date;
import java.util.EventListener;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.BOTRelationInfo;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.feedfactory.QCResult;
import com.kingdee.eas.farm.feedfactory.QualityCheckBillEntryInfo;
import com.kingdee.eas.farm.feedfactory.QualityCheckFacadeFactory;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.qm.basedata.QCStandardInfo;
import com.kingdee.eas.qm.basedata.QCStandardItemEntryCollection;
import com.kingdee.eas.qm.basedata.QCStandardItemEntryFactory;
import com.kingdee.eas.qm.basedata.QCStandardItemEntryInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sm.pur.PurOrder;
import com.kingdee.eas.scm.sm.pur.PurOrderCollection;
import com.kingdee.eas.scm.sm.pur.PurOrderEntry;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryCollection;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderFactory;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.InStorageBillEntryCollection;
import com.kingdee.eas.weighbridge.InStorageBillEntryFactory;
import com.kingdee.eas.weighbridge.InStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.InStorageBillFactory;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * 质检单编辑界面，
 * 单据头选中检验员后，新增分录时系统自动将检验员带入
 * output class name
 */
public class QualityCheckBillEditUI extends AbstractQualityCheckBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(QualityCheckBillEditUI.class);

	// 检验员
	private PersonInfo qcPerson;
	/**
	 * output class constructor
	 */
	public QualityCheckBillEditUI() throws Exception
	{
		super();


		this.baseStatus.setEnabled(false);
		this.baseStatus.setEditable(false);
		this.pkauditTime.setEditable(false);
		this.pkauditTime.setEnabled(false);

	}


	/**
	 * output loadFields method
	 */
	public void loadFields()
	{

		// 先移除监听  load完了后再加上
		removeListener();
		super.loadFields();
		addDataChangeListener();
		this.baseStatus.setEnabled(false);
		this.baseStatus.setEditable(false);
		this.pkauditTime.setEditable(false);
		this.pkauditTime.setEnabled(false);

	}
	protected void showView(){
		super.showView();
	}
	/**
	 * 移除监听
	 */
	public void removeListener(){
		// 入库过磅单
		DataChangeListener[] dl = this.prmtweightBill.getListeners(DataChangeListener.class);
		for(int i = 0; dl != null && dl.length > 0 && i < dl.length; i++){
			this.prmtweightBill.removeDataChangeListener(dl[i]);
		}

		// 质检员
		DataChangeListener[] pdl = this.prmtperson.getListeners(DataChangeListener.class);
		for(int i = 0; pdl != null && pdl.length > 0 && i < pdl.length; i++){
			this.prmtperson.removeDataChangeListener(pdl[i]);
		}

		// 物料
		DataChangeListener[] mdl = this.prmtmaterial.getListeners(DataChangeListener.class);
		for(int i = 0; mdl != null && mdl.length > 0 && i < mdl.length; i++){
			this.prmtmaterial.removeDataChangeListener(mdl[i]);
		}

		ListenerUtil.F7RemoveDateChangeListener(prmtpurOrder);
	}
	/**
	 * 添加监听
	 */
	public void addDataChangeListener(){
		// 入库过磅单
		this.prmtweightBill.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
			public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
				try {
					prmtweightBill_dataChanged(e);
				} catch (Exception exc) {
					handUIException(exc);
				} finally {
				}
			}
		});

		// 质检员
		this.prmtperson.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
			public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
				try {
					prmtperson_dataChanged(e);
				} catch (Exception exc) {
					handUIException(exc);
				} finally {
				}
			}
		});

		// 物料
		this.prmtmaterial.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
			public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
				try {
					prmtMaterial_dataChanged(e);
				} catch (Exception exc) {
					handUIException(exc);
				} finally {
				}
			}
		});
		this.txttakeOffPrice.addFocusListener(new FocusListener(){  
			public void focusLost(FocusEvent e) {  
				try{  
					txttakeOffPrice_actionPerformed(null);
				}catch(Exception ex){  
					handUIException(ex);  
				}  
			};  
			public void focusGained(FocusEvent arg0) {  
				// TODO 自动生成方法存根  

			}  
		}); 
		this.txttakeOffBasePrice.addFocusListener(new FocusListener(){  
			public void focusLost(FocusEvent e) {  
				try{  
					txttakeOffBasePrice_actionPerformed(null);
				}catch(Exception ex){  
					handUIException(ex);  
				}  
			};  
			public void focusGained(FocusEvent arg0) {  
				// TODO 自动生成方法存根  

			}  
		}); 
		this.txtrealAmount.addFocusListener(new FocusListener(){  
			public void focusLost(FocusEvent e) {  
				try{  
					txtrealAmount_actionPerformed(null);
				}catch(Exception ex){  
					handUIException(ex);  
				}  
			};  
			public void focusGained(FocusEvent arg0) {  
				// TODO 自动生成方法存根  

			}  
		}); 
		// 如果分录没有数据 则触发一次  物料更新
		if(this.getOprtState().equals("EDIT") && this.kdtEntrys.getRowCount() <= 0 ){
			try {
				prmtMaterial_dataChanged(null);
			} catch (Exception exc) {
				handUIException(exc);
			} finally {
			}
		}
		prmtpurOrder.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtpurOrder_dataChanged(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
	}



	/**
	 * 订单修改
	 */
	@Override
	protected void prmtpurOrder_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
	{
		// TODO
		if(prmtpurOrder.getValue()==null)
			txtcontractItem.setStringValue(null);
		else{
			String purOrderID = ((IPropertyContainer)prmtpurOrder.getValue()).getString("id");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance("/*dialect*/select replace(wm_concat(to_char(FTermContent)),',',chr(10)) text from T_SM_PurContract t1 inner join T_BOT_Relation t2 on t1.FID=t2.FSrcObjectID inner join T_SM_PurOrder t3 on t3.FID=t2.FDestObjectID inner join T_SM_PurContractTerm t4 on t1.FID=t4.FParentID where t3.FID='"+purOrderID+"'").executeSQL();
			if(rs.next()){
				txtcontractItem.setStringValue(rs.getString("text"));
			}
		}
	}

	/**
	 * 保存前校验
	 */
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		super.beforeStoreFields(arg0);
		// 校验 扣价后 单价不能小于0
		//    	String text = this.txt
		BigDecimal priceAfterTakeoff =this.txtpriceAfterTakeOff.getBigDecimalValue();

		if(priceAfterTakeoff != null && priceAfterTakeoff.compareTo(new BigDecimal("0")) <= 0){

			MsgBox.showInfo("扣价后单价不能小于0");
			txttakeOffPrice.requestFocus();
			SysUtil.abort();

		}
	}
	/**
	 * 吨单价更新后 关联更新 基本单价 
	 */
	@Override
	protected void txttakeOffPrice_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		BigDecimal takeOffPrice = null;
		String takeOffPriceText = this.txttakeOffPrice.getText();
		if(StringUtils.isNotBlank(takeOffPriceText)){
			try{
				takeOffPrice = new BigDecimal(takeOffPriceText);
			}catch(Exception ex){
				ex.printStackTrace();
				MsgBox.showInfo("扣价只能输入数字");
				this.txttakeOffPrice.requestFocus();
			}
		}
		//    	MsgBox.showInfo(takeOffPriceText);


		if(takeOffPrice == null){
			takeOffPrice = new BigDecimal("0");
		}
		// 计算基本 扣价
		BigDecimal takeOffBasePrice = takeOffPrice.divide(new BigDecimal("1000"),6, RoundingMode.HALF_UP);
		this.txttakeOffBasePrice.setValue(takeOffBasePrice);
		// 计算扣价后 基本价格
		BigDecimal priceBeforeTakeOff = this.txtpriceBeforeTakeOff.getBigDecimalValue();
		if(priceBeforeTakeOff != null){
			BigDecimal priceAfterTakeoff = priceBeforeTakeOff.subtract(takeOffBasePrice);
			this.txtpriceAfterTakeOff.setValue(priceAfterTakeoff);
			if(priceAfterTakeoff.compareTo(new BigDecimal("0")) <= 0){

				MsgBox.showInfo("扣价后单价不能小于0");
				txttakeOffPrice.requestFocus();
			}
		}
	}
	/**
	 * 扣单价更新后 关联更新 基本单价 
	 */
	protected void txttakeOffBasePrice_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		BigDecimal takeOffPrice = null;
		String takeOffPriceText = this.txttakeOffBasePrice.getText();
		if(StringUtils.isNotBlank(takeOffPriceText)){
			try{
				takeOffPrice = new BigDecimal(takeOffPriceText);
			}catch(Exception ex){
				ex.printStackTrace();
				MsgBox.showInfo("扣价只能输入数字");
				this.txttakeOffPrice.requestFocus();
			}
		}
		//    	MsgBox.showInfo(takeOffPriceText);


		if(takeOffPrice == null){
			takeOffPrice = new BigDecimal("0");
		}
		// 计算基本 扣价
		BigDecimal priceBeforeTakeOff = new BigDecimal(this.txtpriceBeforeTakeOff.getText());
		BigDecimal priceAfterTakeOff = priceBeforeTakeOff.subtract(takeOffPrice);
		
		this.txtpriceAfterTakeOff.setValue(priceAfterTakeOff);
		// 计算应扣金额
		if(StringUtils.isNotBlank(this.txtsumweight.getText())){
			BigDecimal sumweight = this.txtsumweight.getBigDecimalValue();
			BigDecimal buckamount = takeOffPrice.multiply(sumweight);
			this.txtBuckAmount.setValue(buckamount);
			this.txtrealAmount.setValue(buckamount);
			
		}
		
	}
	//根据公式和单价计算扣款单价和金额
	private void setDeduct(KDTEditEvent e, BigDecimal diff) {
		// TODO Auto-generated method stub
		if(kdtEntrys.getCell(e.getRowIndex(), "gs").getValue()!=null){
			String Deduct = getDeduct(kdtEntrys.getCell(e.getRowIndex(), "gs").getValue().toString(),diff,(BigDecimal) kdtEntrys.getCell(e.getRowIndex(), "upper").getValue());
			if(Deduct!=null){
				BigDecimal depr = new BigDecimal(Deduct);
				kdtEntrys.getCell(e.getRowIndex(), "DeductWgt").setValue(depr);			
				this.txtrealAmount.setValue(depr);
				this.txtBuckAmount.setValue(depr);
			}
		}	
	}
	/**
	 * 实际扣款更新后 关联更新 扣后单价 
	 */
	protected void txtrealAmount_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		BigDecimal realAmount = null;
		String txtrealAmount = this.txtrealAmount.getText();
		if(StringUtils.isNotBlank(txtrealAmount)){
			try{
				realAmount = new BigDecimal(txtrealAmount);
			}catch(Exception ex){
				ex.printStackTrace();
				MsgBox.showInfo("扣价只能输入数字");
				this.txtrealAmount.requestFocus();
			}
		}
		//    	MsgBox.showInfo(takeOffPriceText);

		BigDecimal sumweight;
		String txtsumweight = this.txtsumweight.getText();
		if(StringUtils.isNotBlank(txtsumweight)){
			sumweight = new BigDecimal(this.txtsumweight.getBigIntegerValue());
			BigDecimal priceAfterTakeOff = realAmount.divide(sumweight, 3, BigDecimal.ROUND_HALF_UP);
			this.txtpriceAfterTakeOff.setValue(priceAfterTakeOff);
		}else{
			sumweight = new BigDecimal("0");
		}
		// 计算基本 扣价
		//BigDecimal priceBeforeTakeOff = new BigDecimal(this.txtpriceBeforeTakeOff.getText());
		
		
		
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();

	}


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	public IObjectValue createNewDetailData(KDTable table)
	{
		QualityCheckBillEntryInfo newEntryInfo = new QualityCheckBillEntryInfo();
		newEntryInfo.setParent(this.editData);
		// 默认检验员为单据头检验员
		newEntryInfo.setQcPerson((PersonInfo) this.prmtperson.getValue());

		return newEntryInfo;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo objectValue = new com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
		Date nowDate = new Date();
		        objectValue.setBizDate(nowDate);
		//        objectValue.setSendDate(nowDate);
		        objectValue.setArriveDate(nowDate);
		objectValue.setCU(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setBuckAmount(BigDecimal.ZERO);
		objectValue.setRealAmount(BigDecimal.ZERO);
		return objectValue;
	}
	/**
	 * 编辑前校验单据是否在创建组织；
	 */
	@Override
	public void actionEdit_actionPerformed(ActionEvent e)throws Exception{
		checkCanEdit();
		super.actionEdit_actionPerformed(e);
		this.baseStatus.setEnabled(false);
		this.baseStatus.setEditable(false);
		this.pkauditTime.setEditable(false);
		this.pkauditTime.setEnabled(false);
		// 分录为空时自动添加校验项目
		// 如果分录没有数据 则触发一次  物料更新
		if(this.getOprtState().equals("EDIT") && this.kdtEntrys.getRowCount() <= 0){
			try {
				prmtMaterial_dataChanged(null);
			} catch (Exception exc) {
				handUIException(exc);
			} finally {
			}
		}


		lockWFBillUI();

		//	   	lockUIComps();
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			if(StringUtils.isBlank((String) this.kdtEntrys.getCell(rowIndex, "qcresult").getValue())) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，结算结果不能为空！");
				SysUtil.abort();
			}
			if(this.kdtEntrys.getCell(rowIndex, "qcConclusion").getValue()==null) {
				MsgBox.showWarning("第"+(rowIndex+1)+"行分录，检测结论不能为空！");
				SysUtil.abort();
			}
		}


		String purOrderID = null;
		if(editData.getPurOrder()!=null){
			purOrderID=editData.getPurOrder().getString("id");
		}
		super.actionSubmit_actionPerformed(e);
//		doAfterSave(new ObjectUuidPK(editData.getId().toString()));
//		setOprtState("EDIT");
//		unLockUI();

		if(StringUtils.isNotEmpty(purOrderID)){
			checkPurOrderBill(purOrderID);
		}

		if(editData.getPurOrder()!=null){
			purOrderID=editData.getPurOrder().getString("id");
			checkPurOrderBill(purOrderID);
		}
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String purOrderID = null;
		if(editData.getPurOrder()!=null){
			purOrderID=editData.getPurOrder().getString("id");
		}
		super.actionSave_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(editData.getId().toString()));
		setOprtState("EDIT");
		unLockUI();

		if(StringUtils.isNotEmpty(purOrderID)){
			checkPurOrderBill(purOrderID);
		}

		if(editData.getPurOrder()!=null){
			purOrderID=editData.getPurOrder().getString("id");
			checkPurOrderBill(purOrderID);
		}
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		String purOrderID = null;
		if(editData.getPurOrder()!=null){
			purOrderID=editData.getPurOrder().getString("id");
		}
		super.actionRemove_actionPerformed(arg0);

		if(StringUtils.isNotEmpty(purOrderID)){
			checkPurOrderBill(purOrderID);
		}
	}


	/**
	 * 
	 * @param purOrderID
	 */
	private void checkPurOrderBill(String purOrderID) {
		// TODO Auto-generated method stub
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance("select t1.CFIsHasQCBill,t2.FID from T_SM_PurOrder t1 left join CT_FM_QualityCheckBill t2 on t1.FID=t2.CFPurOrderID where t1.FID='"+purOrderID+"' order by t1.CFIsHasQCBill desc ,t2.FID desc").executeSQL();
			if(rs.next()){
				//没有时清除标志
				if(rs.getBoolean("CFIsHasQCBill")&&StringUtils.isEmpty(rs.getString("FID"))){
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_SM_PurOrder set CFIsHasQCBill=0 where FID='"+purOrderID+"'");
				}else if(!rs.getBoolean("CFIsHasQCBill")&&StringUtils.isNotEmpty(rs.getString("FID"))){
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_SM_PurOrder set CFIsHasQCBill=1 where FID='"+purOrderID+"'");
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * output applyDefaultValue method
	 */
	protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));

	}
	/**
	 * 界面初始化 
	 */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));


		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);

		}else {
			if(this.getOprtState().equals("EDIT")){
				checkCanEdit();

			}

		}

		// 设置默认当前库存组织所有鸡舍信息
		StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStorageOrgInfo == null){
			MsgBox.showInfo("当前未在任何库存组织中，不能进行新增质检单操作");
			SysUtil.abort();
		}

		// 
		this.baseStatus.setEnabled(false);
		this.baseStatus.setEditable(false);
		this.pkauditTime.setEditable(false);
		this.pkauditTime.setEnabled(false);


		// 初始界面控件
		initUI();


		lockWFBillUI();
		kdtEntrys.getColumn("qcConclusion").getStyleAttributes().setLocked(true);
//		if(this.pkBizDate.getValue()==null){
//			this.pkBizDate.setValue(this.pkarriveDate.getValue());
//		}
		
		//判断下游单据，并赋值
		if(editData.getPurOrderNumber()!=null){
			PurOrderInfo pinfo = PurOrderFactory.getRemoteInstance().getPurOrderInfo(new ObjectUuidPK(editData.getPurOrderNumber()));
			if(this.prmtpurOrder.getValue()==null){
				this.prmtpurOrder.setValue(pinfo);
				PurOrderEntryCollection pinfoe = pinfo.getEntries();
				if(pinfoe != null && pinfoe.size() > 0){
					PurOrderEntryInfo entryInfo = pinfoe.get(0);
					if(entryInfo.getMaterial() != null){
						this.prmtmaterial.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())));
					}
				}
			}
			if(hasDownriver(editData.getPurOrderNumber(), "52D6BAC2")){
				String inwid = getDownBillId(editData.getPurOrderNumber(), "52D6BAC2");
				InStorageBillInfo info = InStorageBillFactory.getRemoteInstance().getInStorageBillInfo(new ObjectUuidPK(inwid));
//				PurOrderInfo pinfo = PurOrderFactory.getRemoteInstance().getPurOrderInfo(new ObjectUuidPK(editData.getPurOrderNumber()));
				if(this.prmtweightBill.getValue()==null){
					this.editData.setWeightBill(info);
					this.prmtweightBill.setValue(info);
				}
			}
		}
	}
	/** 
	 * 获取单据通过BOTP生成指定下游单据ID 
	 * @param billId 源单ID 
	 * @param bosType 下游单据类型 
	 *  
	 */  
	public static String getDownBillId(String billId, String bosType) throws BOSException {  
	      
	    String destObjectId = null;  
	    EntityViewInfo view = new EntityViewInfo();  
	    FilterInfo filter = new FilterInfo();  
	    filter.getFilterItems().add(new FilterItemInfo("srcObjectID", billId)); //源单ID  
	    filter.getFilterItems().add(new FilterItemInfo("destEntityID", bosType)); //目标单据类型  
	    view.setFilter(filter);  
	    BOTRelationCollection coll = BOTRelationFactory.getRemoteInstance().getCollection(view);  
	    if(coll != null && coll.size() > 0){  
	        BOTRelationInfo relation = coll.get(0);  
	        destObjectId = relation.getDestObjectID();  
	    }  
	      
	    return destObjectId;  
	      
	} 
	/** 
	 * 业务单据是否已经通过BOTP生成指定下游单据 
	 * 如果已生成下游单据，返回true 
	 * @param billId 源单ID 
	 * @param bosType 下游单据类型 
	 *  
	 */  
	public static boolean hasDownriver(String billId, String bosType) throws BOSException {  
	      
	    boolean flag = false;  
	    EntityViewInfo view = new EntityViewInfo();  
	    FilterInfo filter = new FilterInfo();  
	    filter.getFilterItems().add(new FilterItemInfo("srcObjectID", billId)); //源单ID  
	    filter.getFilterItems().add(new FilterItemInfo("destEntityID", bosType)); //目标单据类型  
	    view.setFilter(filter);  
	    BOTRelationCollection coll = BOTRelationFactory.getRemoteInstance().getCollection(view);  
	    if(coll != null && coll.size() > 0){  
	        flag = true;  
	    }  
	      
	    return flag;  
	      
	}  
	public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionViewSignature_actionPerformed(e);

	}
	protected void initDataStatus(){
		super.initDataStatus();

		try {
			lockWFBillUI();
		} catch (BOSException e) {

			e.printStackTrace();
			this.handleException(e);
		}
	}
	/**
	 * 锁定界面内  除 口价外其他字段
	 */
	public void  lockUIComps(){
		this.actionSave.setVisible(false);
		this.actionSubmit.setVisible(false);

		this.kdtEntrys.getStyleAttributes().setLocked(false);
		this.prmtmaterial.setEnabled(false);
		this.contmaterial.setEnabled(false);
		//	    this.contmaterial.setedi
		this.prmtmaterial.setEditable(false);
		//	    this.prmtmaterial.repaint();
		this.prmtsupplier.setEnabled(false);
		this.prmtsupplier.setEditable(false);
		this.prmtpurOrder.setEnabled(false);
		this.prmtpurOrder.setEditable(false);
		this.txtconclusion.setEnabled(false);
		this.txtconclusion.setEditable(false);

		this.prmtperson.setEnabled(false);
		this.prmtperson.setEditable(false);

		this.pkarriveDate.setEnabled(false);
		this.pkarriveDate.setEditable(false);

		this.pksendDate.setEnabled(false);
		this.pksendDate.setEditable(false);

		this.txttruckNumber.setEnabled(false);
		this.txttruckNumber.setEditable(false);

		this.pkBizDate.setEnabled(false);
		this.pkBizDate.setEditable(false);

		this.txtsampleNumber.setEnabled(false);
		this.txtsampleNumber.setEditable(false);

		this.prmtweightBill.setEnabled(false);
		this.prmtweightBill.setEditable(false);

		this.txtNumber.setEnabled(false);
		this.txtunloadArea.setEnabled(false);
		this.txtproductFactory.setEnabled(false);
		this.txtsendPerson.setEnabled(false);
		this.txtDescription.setEnabled(false);

		this.kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
		this.kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		this.kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
	}
	/**
	 * output onShow method
	 */
	public void onShow() throws Exception
	{
		super.onShow();
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getRow(i).getCell("qcItem").getValue()!=null&&((IPropertyContainer)kdtEntrys.getRow(i).getCell("qcItem").getValue()).getString("id").equalsIgnoreCase("75QAAAAAUg6gNGE4")){
				kdtEntrys.getRow(i).getCell("qcConclusion").getStyleAttributes().setLocked(false);
			}

		}
		lockWFBillUI();
	}

	protected void updateButtonStatus(){
		super.updateButtonStatus();
	}
	/**
	 * 锁定在工作流中的单据 界面控件
	 * @throws BOSException
	 */
	private void lockWFBillUI() throws BOSException{
		// 提交 并且 在流程中的单据 锁定 除了扣价 其他字段不可修改
		if(this.editData != null &&
				this.editData.getId() != null &&
				BillBaseStatusEnum.SUBMITED.equals(this.editData.getBaseStatus())){
			// 判断单据是否在工作流中 
			IEnactmentService service = EnactmentServiceFactory.createRemoteEnactService();
			ProcessInstInfo instInfo = null;
			ProcessInstInfo[] procInsts = service.getProcessInstanceByHoldedObjectId(this.editData.getId().toString());

			for (int j = 0;  j < procInsts.length; ++j) {
				if ("open.running".equals(procInsts[j].getState())) {
					instInfo = procInsts[j];
				}
			}
			// 如果在工作流中，则 设置单据除 扣价外其他 不可编辑
			if (instInfo != null) {
				String userID = SysContext.getSysContext().getCurrentUserInfo().getId().toString();

				//				userID = "nPIyW9poS5OFh+UqujNzphO33n8=";
				String billCreatorID = this.editData.getCreator().getId().toString();
				if(userID.equals(billCreatorID)){
					String procInstID = instInfo.getProcInstId();

					String billID = this.editData.getId().toString();

					StringBuilder  sql = new StringBuilder();
					sql.append("select fstate from  T_WFR_Assign where FPERSONUSERID='");
					sql.append(userID);
					sql.append("' and FPROCINSTID='");
					sql.append(procInstID);
					sql.append("' and fbizobjid='");
					sql.append(billID);
					sql.append("' and FBIZFUNCTION ='QualityCheckBillEditUIFunction' and FBIZOPERATION ='ActionSubmit' ");

					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
					if(rs.size() > 0){
						return;
					}
				}
				// 在工作流  且不是发起节点 
				lockUIComps();


			}
		}
	}
	/**
	 * 初始化界面组件信息
	 */
	private void initUI(){

		prmtCreator.setDisplayFormat("$name$");
		prmtAuditor.setDisplayFormat("$name$");

		// prmtperson		
		this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
		this.prmtperson.setVisible(true);		
		this.prmtperson.setEditable(true);		
		this.prmtperson.setDisplayFormat("$name$");		
		this.prmtperson.setEditFormat("$number$");		
		this.prmtperson.setCommitFormat("$number$");		
		this.prmtperson.setRequired(true);
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();


		//        filter.getFilterItems().add(new FilterItemInfo("AdminOrgUnit.displayName","%养殖有限公司%",CompareType.LIKE));

		filter.getFilterItems().add(new FilterItemInfo("AdminOrgUnit.displayName","%"+SysContext.getSysContext().getCurrentFIUnit().getName()+"%",CompareType.LIKE));

		evi.setFilter(filter);
		this.prmtperson.setEntityViewInfo(evi);

		//        F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, this.prmtmaterial);
		this.prmtmaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
		//        this.prmtmaterial.setEditable(true);		
		this.prmtmaterial.setDisplayFormat("$name$");		
		this.prmtmaterial.setEditFormat("$number$");		
		this.prmtmaterial.setCommitFormat("$number$");		
		this.prmtmaterial.setRequired(true);
		//        EntityViewInfo material = new EntityViewInfo();
		//        FilterInfo materialFI = new FilterInfo();
		//        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020102%",CompareType.LIKE));
		//        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","01!0101!%",CompareType.LIKE));
		// 设置物料过滤条件
		//        evi.setFilter(materialFI);
		//		this.prmtmaterial.setEntityViewInfo(evi);


		this.prmtweightBill.setQueryInfo("com.kingdee.eas.farm.feedfactory.app.F7InStorageBillQuery");	


		evi = new EntityViewInfo();
		filter = new FilterInfo();
		// 库存组织是饲料厂的 过磅单
		StorageOrgUnitInfo currStoOrgUnitInfo = SysContext.getSysContext().getCurrentStorageUnit();
		filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",currStoOrgUnitInfo.getId().toString(),CompareType.EQUALS));
		//        CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		filter.getFilterItems().add(new FilterItemInfo("bizType","2",CompareType.EQUALS));
		//        // 设置默认当前库存组织所有鸡舍信息
		//        StorageOrgUnitInfo currStorageOrgInfo = SysContext.getSysContext().getCurrentStorageUnit();
		//        filter.getFilterItems().add(new FilterItemInfo("stoOrg.id",currStorageOrgInfo.getId().toString(),CompareType.EQUALS));
		evi.setFilter(filter);
		SorterItemCollection sorter = new SorterItemCollection();
		SorterItemInfo sortItem = new SorterItemInfo("bizDate");
		sortItem.setSortType(SortType.DESCEND);
		sorter.add(sortItem);
		evi.setSorter(sorter);
		prmtweightBill.setEntityViewInfo(evi);



		// 设置 计量单位只能选择  质检组
		final KDBizPromptBox kdtEntrys_qcUnit_PromptBox = new KDBizPromptBox();
		kdtEntrys_qcUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
		kdtEntrys_qcUnit_PromptBox.setVisible(true);
		kdtEntrys_qcUnit_PromptBox.setEditable(true);
		kdtEntrys_qcUnit_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_qcUnit_PromptBox.setEditFormat("$number$");
		kdtEntrys_qcUnit_PromptBox.setCommitFormat("$number$");
		evi = new EntityViewInfo();
		filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("measureUnitGroup.id","at4AAAAMVwAcKsho",CompareType.EQUALS));
		evi.setFilter(filter);
		kdtEntrys_qcUnit_PromptBox.setEntityViewInfo(evi);
		KDTDefaultCellEditor kdtEntrys_qcUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcUnit_PromptBox);
		this.kdtEntrys.getColumn("qcUnit").setEditor(kdtEntrys_qcUnit_CellEditor);
		ObjectValueRender kdtEntrys_qcUnit_OVR = new ObjectValueRender();
		kdtEntrys_qcUnit_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("qcUnit").setRenderer(kdtEntrys_qcUnit_OVR);




		kdtEntrys_detailPanel.addAddListener(  
				new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {  
					public void beforeEvent(  
							com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event)  
					throws Exception {  
						QualityCheckBillEntryInfo vo = (QualityCheckBillEntryInfo) event.getObjectValue();  
						vo.setQcPerson((PersonInfo) prmtperson.getValue());
						vo.setQcConclusion(QCResult.Pass);
					}  
					public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event)   
					throws Exception {  
					}  
				}); 

		kdtEntrys_detailPanel.addInsertListener(  
				new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {  
					public void beforeEvent(  
							com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event)  
					throws Exception {  
						QualityCheckBillEntryInfo vo = (QualityCheckBillEntryInfo) event.getObjectValue();  
						vo.setQcPerson((PersonInfo) prmtperson.getValue());
						vo.setQcConclusion(QCResult.Pass);
					}  
					public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event)   
					throws Exception {  
					}  
				}); 

		//        // 添加或者插入分录时  设置默认值
		//        this.kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener()
		//        {
		//            public void actionPerformed(ActionEvent e)
		//            {
		//              try
		//              {
		//                afterAddOrInsertLine(e);
		//              }
		//              catch (Exception e1)
		//              {
		//                e1.printStackTrace();
		//               
		//              }
		//            }
		//
		//			
		//          });
		//         
		//        
		//        this.kdtEntrys_detailPanel.getInsertLineButton().addActionListener(new ActionListener()
		//        {
		//            public void actionPerformed(ActionEvent e)
		//            {
		//              try
		//              {
		//                afterAddOrInsertLine(e);
		//              }
		//              catch (Exception e1)
		//              {
		//                e1.printStackTrace();
		//               
		//              }
		//            }
		//            
		//          });


		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){

			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);
			}

			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				kdtEntry_EditStoped(e);
			}});
	}
	/**
	 * 分录编辑事件
	 * @param e
	 */
	protected void kdtEntry_EditStoped(KDTEditEvent e) {
		// TODO Auto-generated method stub
		//感官项目检验揭露您可以编辑
		if(kdtEntrys.getColumnKey(e.getColIndex()).equalsIgnoreCase("qcItem")){
			if(kdtEntrys.getCell(e.getRowIndex(), "qcItem").getValue()!=null&&((IPropertyContainer)kdtEntrys.getCell(e.getRowIndex(), "qcItem").getValue()).getString("id").equalsIgnoreCase("75QAAAAAUg6gNGE4")){
				kdtEntrys.getCell(e.getRowIndex(), "qcConclusion").getStyleAttributes().setLocked(false);
			}else
				kdtEntrys.getCell(e.getRowIndex(), "qcConclusion").getStyleAttributes().setLocked(true);
		}

		if("qcresult".equalsIgnoreCase(kdtEntrys.getColumnKey(e.getColIndex()))){
			if(e.getValue()!=null){
				if(UIRuleUtil.getBigDecimal(e.getValue()).compareTo(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(), "lower").getValue()))>=0&&UIRuleUtil.getBigDecimal(e.getValue()).compareTo(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(), "upper").getValue()==null?new BigDecimal(1000000000):kdtEntrys.getCell(e.getRowIndex(), "upper").getValue()))<=0){
					kdtEntrys.getCell(e.getRowIndex(), "qcConclusion").setValue(QCResult.Pass);
				}else{
					kdtEntrys.getCell(e.getRowIndex(), "qcConclusion").setValue(QCResult.UnPass);
					setDeduct(e,UIRuleUtil.getBigDecimal(e.getValue()));
					
				}					
			}else
				kdtEntrys.getCell(e.getRowIndex(), "qcConclusion").setValue(QCResult.UnKnown);
		}
	}


	/**
	 * 设置默认值
	 * @param e
	 * @throws InterruptedException 
	 */
	public void afterAddOrInsertLine(ActionEvent e) throws InterruptedException {
		//    	Thread.sleep(1000);
		for(int i = 0; i < this.kdtEntrys.getRowCount(); i++){
			if(this.kdtEntrys.getCell(i, "qcPerson").getValue() == null){
				this.kdtEntrys.getCell(i, "qcPerson").setValue(this.prmtperson.getValue());
			}
		}

	}
	//计算单价
	private String getDeduct(String value, BigDecimal bigDecimalValue,BigDecimal bigDecimalValue1) {
		// TODO Auto-generated method stub
		 ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
	        Compilable compilable = (Compilable) engine;
	        Bindings bindings = engine.createBindings(); //Local级别的Binding
	        String script = value; //定义函数并调用
	        CompiledScript JSFunction = null; //解析编译脚本函数
	        try {
	            JSFunction = compilable.compile(script);
	            int result1 = script.indexOf("x");
	            if(result1!=-1){
	            	 bindings.put("x", bigDecimalValue1);  
	            }
	            bindings.put("y", bigDecimalValue); 
	            Object result = JSFunction.eval(bindings);
	            System.out.println(result); //调用缓存着的脚本函数对象，Bindings作为参数容器传入
	            return String.valueOf(result);
	        } catch (ScriptException e) {
	            e.printStackTrace();
	        }
		
		return null;
	}
	/**
	 * 校验当前组织是否是单据创建组织，如果不是，提示消息中断操作
	 * @throws BOSException 
	 */
	private void checkCanEdit() throws BOSException{
		StorageOrgUnitInfo cu = SysContext.getSysContext().getCurrentStorageUnit();
		CtrlUnitInfo billCU = this.editData.getCU();

		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("当前组织不是单据创建组织，不能修改单据");

				lockUIComps();
				SysUtil.abort();
			}
		}

		//		// 工作流中不能修改
		//		if(this.editData != null &&
		//				this.editData.getId() != null &&
		//				BillBaseStatusEnum.SUBMITED.equals(this.editData.getBaseStatus())){
		//			// 判断单据是否在工作流中 
		//			IEnactmentService service = EnactmentServiceFactory.createRemoteEnactService();
		//			ProcessInstInfo instInfo = null;
		//			ProcessInstInfo[] procInsts = service.getProcessInstanceByHoldedObjectId(this.editData.getId().toString());
		//			
		//			for (int j = 0;  j < procInsts.length; ++j) {
		//			      if ("open.running".equals(procInsts[j].getState())) {
		//			          instInfo = procInsts[j];
		//				  }
		//			}
		//			// 如果在工作流中，则 设置单据除 扣价外其他 不可编辑
		//			if (instInfo != null) {
		//				lockUIComps();
		////				MsgBox.showWarning("单据在工作流中，不能编辑");
		//				
		//				
		//				
		//				SysUtil.abort();
		//			}
		//		}
	}



	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}

	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();



	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的批次");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("反审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}


	/**
	 * 物料更新
	 * output prmtMaterial_dataChanged method
	 */
	protected void prmtMaterial_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
	{
		MaterialInfo oldMaterialInfo = null;
		if(e != null){
			oldMaterialInfo = (MaterialInfo) e.getOldValue();
		}
		MaterialInfo materialInfo = (MaterialInfo) this.prmtmaterial.getValue();
		StorageOrgUnitInfo stoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		
		if(stoOrg == null){
			MsgBox.showWarning("当前未在任何库存组织,不能录入质检单");
			SysUtil.abort();
		}
		if(materialInfo != null){
			setCustomer(materialInfo,stoOrg);
			
			// 先清理然后 重新加载
			this.kdtEntrys.removeRows();

			QCStandardInfo qcInfo = QualityCheckFacadeFactory.getRemoteInstance().getMaterialCheckStandard(stoOrg.getId().toString(), materialInfo.getId().toString());

			if(qcInfo != null){
				//    			qcInfo = (QCStandardInfo) QCStandardFactory.getRemoteInstance().getValue(new ObjectUuidPK(qcInfo.getId()));
				QCStandardItemEntryCollection itemColl = qcInfo.getItemEntries();
				//添加排序
				itemColl.sort("seq");
				
				// 检验项目
				//    			QCStandardItemExtendAttrCollection extendItemColl = qcInfo.getItemExtendAttr();
				PersonInfo personInfo = (PersonInfo) this.prmtperson.getValue();
				if(itemColl != null && itemColl.size() > 0){
					for(int i = 0; i < itemColl.size(); i++){
						//    					QCStandardItemExtendAttrInfo itemExtendInfo = extendItemColl.get(i);
						QCStandardItemEntryInfo itemInfo = itemColl.get(i);
						if(itemInfo.getQCItem() == null){
							itemInfo = QCStandardItemEntryFactory.getRemoteInstance().getQCStandardItemEntryInfo(new ObjectUuidPK(itemInfo.getId()));

						}
						// 检验项目插入到分录中
						IRow newRow = this.kdtEntrys.addRow();
						newRow.getCell("qcItem").setValue(itemInfo.getQCItem());
						newRow.getCell("qcItem").getStyleAttributes().setLocked(true);
						if(itemInfo.getQCItem()!=null&&itemInfo.getQCItem().getString("id").equalsIgnoreCase("75QAAAAAUg6gNGE4")){
							newRow.getCell("qcConclusion").getStyleAttributes().setLocked(false);
						}

						newRow.getCell("qcUnit").setValue(itemInfo.getUnit());
						newRow.getCell("qcUnit").getStyleAttributes().setLocked(true);

						newRow.getCell("lower").setValue(itemInfo.getLower());
						newRow.getCell("lower").getStyleAttributes().setLocked(true);

						newRow.getCell("upper").setValue(itemInfo.getUpper());
						newRow.getCell("upper").getStyleAttributes().setLocked(true);

						newRow.getCell("standardValue").setValue(itemInfo.getDefaultValue());
						newRow.getCell("standardValue").getStyleAttributes().setLocked(true);
						newRow.getCell("gs").setValue(itemInfo.getRemark());
						newRow.getCell( "qcPerson").setValue(personInfo);

					}
				}
			}
		}
	}
	//获取本地供应商
	private void setCustomer(MaterialInfo materialInfo,
			StorageOrgUnitInfo stoOrg) {
		// TODO Auto-generated method stub
		StringBuilder  sql = new StringBuilder();
		sql.append("select t2.CFSupplierID,t2.CFPrice from  CT_FM_LocalPurMATPrice t1 inner join CT_FM_LocalPurMATPriceEntry t2 on t2.FParentID = t1.FID  where t2.CFMaterialID='");
		sql.append(materialInfo.getId().toString());
		sql.append("' and t1.CFCompanyID='");
		sql.append(stoOrg.getId().toString());
		sql.append("'  ");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				String SuppID = rs.getString("CFSupplierID");
				if(!StringUtils.isEmpty(SuppID)){
					SupplierInfo sinfo = SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(SuppID));
					this.prmtsupplier.setValue(sinfo);
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	/**
	 * 物料更新2
	 * output prmtMaterial_dataChanged method
	 */
	protected void prmtMaterial_dataChanged() throws Exception
	{
		MaterialInfo oldMaterialInfo = null;
		
		MaterialInfo materialInfo = (MaterialInfo) this.prmtmaterial.getValue();
		StorageOrgUnitInfo stoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		
		if(stoOrg == null){
			MsgBox.showWarning("当前未在任何库存组织,不能录入质检单");
			SysUtil.abort();
		}
		if(materialInfo != null){
			//    		if(oldMaterialInfo != null){
			//    			// 如果之前选中过物料
			//    			if(!oldMaterialInfo.getId().toString().equals(materialInfo.getId().toString())){
			//    				
			//    			}
			//    		}
			if(this.kdtEntrys.getRowCount() > 0){
				if(MsgBox.showConfirm2("重新加载检验项目？") != MsgBox.OK){
					SysUtil.abort();
				}
			}
			// 先清理然后 重新加载
			this.kdtEntrys.removeRows();

			QCStandardInfo qcInfo = QualityCheckFacadeFactory.getRemoteInstance().getMaterialCheckStandard(stoOrg.getId().toString(), materialInfo.getId().toString());

			if(qcInfo != null){
				//    			qcInfo = (QCStandardInfo) QCStandardFactory.getRemoteInstance().getValue(new ObjectUuidPK(qcInfo.getId()));
				QCStandardItemEntryCollection itemColl = qcInfo.getItemEntries();
				// 检验项目
				//    			QCStandardItemExtendAttrCollection extendItemColl = qcInfo.getItemExtendAttr();
				PersonInfo personInfo = (PersonInfo) this.prmtperson.getValue();
				if(itemColl != null && itemColl.size() > 0){
					for(int i = 0; i < itemColl.size(); i++){
						//    					QCStandardItemExtendAttrInfo itemExtendInfo = extendItemColl.get(i);
						QCStandardItemEntryInfo itemInfo = itemColl.get(i);
						if(itemInfo.getQCItem() == null){
							itemInfo = QCStandardItemEntryFactory.getRemoteInstance().getQCStandardItemEntryInfo(new ObjectUuidPK(itemInfo.getId()));

						}
						// 检验项目插入到分录中
						IRow newRow = this.kdtEntrys.addRow();
						newRow.getCell("qcItem").setValue(itemInfo.getQCItem());
						newRow.getCell("qcItem").getStyleAttributes().setLocked(true);
						if(itemInfo.getQCItem()!=null&&itemInfo.getQCItem().getString("id").equalsIgnoreCase("75QAAAAAUg6gNGE4")){
							newRow.getCell("qcConclusion").getStyleAttributes().setLocked(false);
						}

						newRow.getCell("qcUnit").setValue(itemInfo.getUnit());
						newRow.getCell("qcUnit").getStyleAttributes().setLocked(true);

						newRow.getCell("lower").setValue(itemInfo.getLower());
						newRow.getCell("lower").getStyleAttributes().setLocked(true);

						newRow.getCell("upper").setValue(itemInfo.getUpper());
						newRow.getCell("upper").getStyleAttributes().setLocked(true);

						newRow.getCell("standardValue").setValue(itemInfo.getDefaultValue());
						newRow.getCell("standardValue").getStyleAttributes().setLocked(true);
						newRow.getCell("gs").setValue(itemInfo.getRemark());
						newRow.getCell( "qcPerson").setValue(personInfo);

					}
				}
			}
		}
	}
	/**
	 * 质检员更新
	 * output prmtweightBill_dataChanged method
	 */
	protected void prmtperson_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
	{

		PersonInfo personInfo = (PersonInfo) this.prmtperson.getValue();
		if(personInfo != null){
			for(int i = 0; i < this.kdtEntrys.getRowCount(); i++){
				if(this.kdtEntrys.getCell(i, "qcPerson").getValue() == null){
					this.kdtEntrys.getCell(i, "qcPerson").setValue(personInfo);
				}
			}
		}
	}

	/**
	 * 入库过磅单更新
	 * output prmtweightBill_dataChanged method
	 */
	protected void prmtweightBill_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
	{

		InStorageBillInfo inStoBillInfo = (InStorageBillInfo) prmtweightBill.getValue();
		if(inStoBillInfo != null ){
			inStoBillInfo = InStorageBillFactory.getRemoteInstance().getInStorageBillInfo(new ObjectUuidPK(inStoBillInfo.getId()));

			// 原料、供应商、车号、到货日期 
			// 原料取如果单第一行分录 物料
			InStorageBillEntryCollection entryCol = inStoBillInfo.getEntrys();
			if(entryCol != null && entryCol.size() > 0){
				InStorageBillEntryInfo entryInfo = entryCol.get(0);
				entryInfo = InStorageBillEntryFactory.getRemoteInstance().getInStorageBillEntryInfo(new ObjectUuidPK(entryInfo.getId()));
				if(entryInfo.getMaterial() != null){
					this.prmtmaterial.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId())));
				}
			}
			//        	inStoBillInfo.get TODO
			// 供应商
			if(inStoBillInfo.getSupplier() != null){
				this.prmtsupplier.setValue(SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(inStoBillInfo.getSupplier().getId())));
			}
			// 车号
			CarInfo car = inStoBillInfo.getCar();
			String carNumber = "";
			if(car != null){
				if(StringUtils.isBlank(car.getNumber())){
					car = CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(car.getId()));

				}
				carNumber = car.getNumber();
			}

			//this.txttruckNumber.setText(carNumber);
			this.txttruckNumber.setText(inStoBillInfo.getCarNum());
//			// 到货日期
//			if(pkarriveDate.getValue() == null){
//				this.pkarriveDate.setValue(inStoBillInfo.getBizDate());
//			}
//			if(pkBizDate.getValue() == null){
//				this.pkBizDate.setValue(inStoBillInfo.getBizDate());
//			}
//			if(pksendDate.getValue() == null){
//				this.pksendDate.setValue(inStoBillInfo.getBizDate());
//			}
		}
	}
	@Override
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAddLine_actionPerformed(e);
	}
	@Override
	public void actionInsertLine_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionInsertLine_actionPerformed(e);
	}
	@Override
	protected void afterAddLine(KDTable table, IObjectValue lineData) {

		super.afterAddLine(table, lineData);
	}
	@Override
	protected void afterInsertLine(KDTable table, IObjectValue lineData) {
		// TODO Auto-generated method stub
		super.afterInsertLine(table, lineData);
	}


	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus() != BillBaseStatusEnum.AUDITED){
			MsgBox.showWarning("只能打印审核状态的单据");
			SysUtil.abort();
		}
		super.actionPrint_actionPerformed(e);
	}


	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus() != BillBaseStatusEnum.AUDITED){
			MsgBox.showWarning("只能打印浏览审核状态的单据");
			SysUtil.abort();
		}
		super.actionPrintPreview_actionPerformed(e);
	}



}