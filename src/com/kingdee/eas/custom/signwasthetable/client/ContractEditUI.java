/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import java_cup.internal_error;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDToolBar;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTMapping;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.AdminF7;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.BotpUtils;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo;
import com.kingdee.eas.custom.signwasthetable.ContractTypeInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.fi.ap.PayRequestBillFactory;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.gl.GlUtils;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.scm.util.string.StringUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class ContractEditUI extends AbstractContractEditUI
{


	@SuppressWarnings("unused")
	private static final Logger logger = CoreUIObject.getLogger(ContractEditUI.class);

	// hisEditData  初始化合同变更时产生的历史版本
	private ContractInfo hisEditData=null;
	final String []arrayOri={"payAmount","requiredPayAmount","unRequiredAmt","payedAmount","payingAmount"};
	final String []arrayRate={"paymentRate"};	
	final String []arrayLocal={"payAmountLocal","reqPayAmountLocal","unReqAmtLocal","payedAmountLocal","payingAmountLocal"};

	final String []array={"paymentRate","orgRate","payAmountLocal","reqPayAmountLocal","unReqAmtLocal","payedAmountLocal","payingAmountLocal","payAmount","requiredPayAmount","unRequiredAmt","payedAmount","payingAmount"};

	String botRelationName=null;
	private boolean isInit=true; 

	/**
	 * 刷新按钮
	 */
	@Override
	public void actionRefresh_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		refreshCurPage();
		super.actionRefresh_actionPerformed(e);
	}

	/**
	 * output class constructor
	 */
	public ContractEditUI() throws Exception
	{
		super();
	}

	public void loadFields()
	{		   

		//初始时，合同编码起效是采用合同编码，失效时允许手工填写
		if(this.txtNumber.getStringValue()!=null)
			this.txtNumber.setEnabled(false);
		else
			this.txtNumber.setEnabled(true);

		/*-------------------删除dataChangeListener事件开始-------------------*/
		ArrayList<DataChangeListener[]> dataChangeListener=new ArrayList<DataChangeListener[]>();
		Object[] comp={txtbailRate,prmtassureDept,txtbailAmount,prmtassurer,prmtcurrency,prmtpartyA,txtAmountOriCurrency,txtexchangeRate};
		for(int i=0;i<comp.length;i++){
			if(comp[i] instanceof KDFormattedTextField ){
				dataChangeListener.add(((KDFormattedTextField)comp[i]).getListeners(DataChangeListener.class));
				for(int j=0;j<((KDFormattedTextField)comp[i]).getListeners(DataChangeListener.class).length;j++)
					((KDFormattedTextField)comp[i]).removeDataChangeListener((((KDFormattedTextField)comp[i]).getListeners(DataChangeListener.class))[j]);
			}
			else if( comp[i] instanceof KDBizPromptBox){
				dataChangeListener.add(((KDBizPromptBox )comp[i]).getListeners(DataChangeListener.class));
				for(int j=0;j<((KDBizPromptBox)comp[i]).getListeners(DataChangeListener.class).length;j++)
					((KDBizPromptBox)comp[i]).removeDataChangeListener((((KDBizPromptBox)comp[i]).getListeners(DataChangeListener.class))[j]);
			}
		}
		/*-------------------删除dataChangeListener事件结束-------------------*/
		ActionListener[] dclsAddBtn= kdtPayment_detailPanel.getAddNewLineButton().getActionListeners();
		for(int i = 0; dclsAddBtn.length > 0 && i<dclsAddBtn.length; i++)
			kdtPayment_detailPanel.getAddNewLineButton().removeActionListener(dclsAddBtn[i]);
		ActionListener[] dclsInsertBtn= kdtPayment_detailPanel.getInsertLineButton().getActionListeners();
		for(int i = 0; dclsInsertBtn.length > 0 && i<dclsInsertBtn.length; i++)
			kdtPayment_detailPanel.getInsertLineButton().removeActionListener(dclsInsertBtn[i]);



		super.loadFields();


		/*-------------------重新添加dataChangeListener事件开始-------------------*/
		for(int i=0;i<comp.length;i++){
			if(comp[i] instanceof KDFormattedTextField )
				for(int j=0;j<dataChangeListener.get(i).length;j++)
					((KDFormattedTextField )comp[i]).addDataChangeListener(dataChangeListener.get(i)[j]);
			else if( comp[i] instanceof KDBizPromptBox)
				for(int j=0;j<dataChangeListener.get(i).length;j++)
					((KDBizPromptBox )comp[i]).addDataChangeListener(dataChangeListener.get(i)[j]);
		}
		/*-------------------重新添加dataChangeListener事件结束-------------------*/



		for(int i = 0; dclsAddBtn.length > 0 && i<dclsAddBtn.length; i++)
			kdtPayment_detailPanel.getAddNewLineButton().addActionListener(dclsAddBtn[i]);
		for(int i = 0; dclsInsertBtn.length > 0 && i<dclsInsertBtn.length; i++)
			kdtPayment_detailPanel.getInsertLineButton().addActionListener(dclsInsertBtn[i]);

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
		return com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance();
	}
	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{		
		return null;
	}
	/**
	 * output createNewData method
	 */
	@SuppressWarnings("deprecation")
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.signwasthetable.ContractInfo objectValue = new com.kingdee.eas.custom.signwasthetable.ContractInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setFIUnit(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new java.util.Date());
		objectValue.setSignDate(new java.util.Date());
		objectValue.setPartyA(SysContext.getSysContext().getCurrentFIUnit());


		objectValue.setBailRate(new BigDecimal("5"));//初始保证金比例 ：5%
		objectValue.setExchangeRate(BigDecimal.ONE);//初始汇率：1
		objectValue.setIsHistory(0);
		objectValue.setPaymentRemove(0);


		objectValue.setIsLastOverflow(0);

		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		objectValue.setVersion("01-"+sdf.format(new java.util.Date()));//初始版本号：01-年月日

		UserInfo currentUser=SysContext.getSysContext().getCurrentUserInfo();
		objectValue.setAssurer(currentUser.getPerson());//初始化责任人为职员身份的当前用户

		try {
			if(currentUser.getPerson()!=null)
				objectValue.setAssureDept(commUtils.getAdminOrgUnit(currentUser.getPerson().getId().toString()));
			objectValue.setCurrency(CurrencyFactory.getRemoteInstance().getCurrencyInfo(new ObjectUuidPK("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC")));
		} catch (Exception e) {
			e.printStackTrace();
		}//初始化币种  根据人民币的id设置为人民币
		return objectValue;
	}	
	@Override
	/**
	 * 保存操作
	 * 如果合同发生过变更，则将变更之前的内容赋id并保存
	 * 	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception 
	{
		if(editData.getContractStatus().equals(billStatus.submit))
			commUtils.giveUserTipsAndRetire("已提交的单据不需要保存");

		checkBeforeSave();
		setHisEditData();
		super.actionSave_actionPerformed(e);
		hisEditData=null;
	}
	/**
	 * 如果发生过合同变更，则赋给历史版本id和分录id
	 */
	private void setHisEditData() throws EASBizException, BOSException, Exception {

		if(this.hisEditData!=null) {
			//产生一个合同签呈类型的id，并将历史版本的id设置为这个值
			BOSUuid oldID=BOSUuid.create(this.editData.getBOSType().toString());
			hisEditData.setId(oldID);
			//历史版本标记
			hisEditData.setIsHistory(1);
			//遍历所有的分录，每条分录设置一个id
			for(int index=0;index<hisEditData.getPayment().size();index++) {
				hisEditData.getPayment().get(index).setId(BOSUuid.create(this.editData.getPayment().get(0).getBOSType().toString()));
				//遍历所有的分录的分录，并分别设置一个id
				for(int j=0;j<hisEditData.getPayment().get(index).getPayInfo().size();j++){
					hisEditData.getPayment().get(index).getPayInfo().get(j).setId(BOSUuid.create(this.editData.getPayment().get(0).getPayInfo().get(0).getBOSType().toString()));
				}
			}
			//调用接口保存
			this.getBizInterface().save(hisEditData);
			//在当前版本保存历史版本的id
			this.txtperVersionID.setStringValue(oldID.toString());

		}
	}
	/**
	 * 合同变更
	 * 合同变更时，取当前版本作为新版本，创建一个新的版本hisEditData作为历史版本（历史版本的id和分录id均未赋值）
	 * @see com.kingdee.eas.custom.signwasthetable.client.AbstractContractEditUI#actionCmChange_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionCmChange_actionPerformed(ActionEvent e) throws Exception {

		if(!this.editData.getContractStatus().equals(billStatus.Audit))
			commUtils.giveUserTipsAndRetire("只允许变更已审核的合同!");

		if (!(UtilRequest.isPrepare("ActionCopy", this))) 
		{
			checkModified();
		}
		hisEditData=(ContractInfo) this.editData.clone();
		setDataObject(this.editData);
		this.loadData();
		setSave(false);
		setSaved(false);
		setOprtState("VIEW");




		//		修改新版本的相关信息（版本号，单据状态，上一版本Id，变更日期等）
		String str=this.txtversion.getStringValue();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String ver=str.substring(0, 2);
		int vers=Integer.parseInt(ver)+1;
		if(vers>0&&vers<10)
			this.txtversion.setStringValue("0"+Integer.toString(vers)+"-"+sdf.format(new java.util.Date()));
		else
			this.txtversion.setStringValue(Integer.toString(vers)+"-"+sdf.format(new java.util.Date()));
		this.contractStatus.setSelectedItem(billStatus.save);
		/*
		 * 修改单据编号（修改规则：取'-'之前的字符串末尾加一位，初始设置为0，以后逐步增加，步长为1）
		 * ‘-’后面的字符串保持不变
		 * 将字符串编码设置为不可修改
		 */
		SimpleDateFormat sdft=new SimpleDateFormat("yyyyMMddHH");
		if(this.txtNumber.getStringValue()==null)
			this.txtNumber.setStringValue(sdft.format(new Date())+"-HTQC-"+"00000"+vers);
		else{
			int position=this.txtversion.getStringValue().indexOf('-');
			String version=this.txtversion.getStringValue().substring(0, position);
			if(this.txtNumber.getStringValue().lastIndexOf('-')==this.txtNumber.getStringValue().indexOf('-'))
				this.txtNumber.setStringValue(this.txtNumber.getStringValue()+"-"+version);	
			else
				this.txtNumber.setStringValue(this.txtNumber.getStringValue().subSequence(0, 18)+version);
		}


		//版本号设置

		editData.setChangeDate(new java.util.Date());
		editData.setIsHistory(0);
		super.actionEdit_actionPerformed(e);
		this.txtNumber.setEnabled(false);
		//合同变更的时候初始化按钮不可用
		this.chkinitial.setEnabled(false);
		kdtPayment.getColumn("requiredPayAmount").getStyleAttributes().setLocked(true);
		kdtPayment.getColumn("payedAmount").getStyleAttributes().setLocked(true);


		MsgBox.showInfo("新版本已生成，请继续修改");

	}
	//提交
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {

		//设定历史版本的id
		checkBeforeSave();
		setHisEditData();
		super.actionSubmit_actionPerformed(arg0);
		hisEditData=null;

	}

	/**
	 * 编辑
	 */
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getContractStatus().equals(billStatus.Audit))
			commUtils.giveUserTipsAndRetire("单据已经审核，禁止编辑");
		super.actionEdit_actionPerformed(arg0);
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null&&ClientUtils.checkBillInWorkflow(this, editData.getId().toString()))
			commUtils.giveUserTipsAndRetire("单据正处于工作流中");
		super.actionRemove_actionPerformed(arg0);
	}

	//审核操作
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {	
		if(editData.getId()==null)
			commUtils.giveUserTipsAndRetire("单据尚未保存");
		else if(ClientUtils.checkBillInWorkflow(this, editData.getId().toString()))
			commUtils.giveUserTipsAndRetire("单据正处于工作流中");

		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核通过！");		
		refreshCurPage();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {

		if(!this.editData.getContractStatus().equals(billStatus.Audit))
			commUtils.giveUserTipsAndRetire("只允许反审核已审核的单据！");

		StringBuffer buffer=new StringBuffer();
		buffer.append("select t3.fparentid from T_SIG_ContractPayment t3 ");
		buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
		buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
		buffer.append("where t3.fparentid='").append(editData.getId().toString()).append("'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
		if(rs.size()>0)
			commUtils.giveUserTipsAndRetire("有下游单据的单据禁止反审核");
		super.actionUnAudit_actionPerformed(e);


		MsgBox.showInfo("反审核通过！");		
		refreshCurPage();
	}

	/**
	 * 合同金额的监听事件
	 * 分录字段的自动填写
	 * 保证金金额的自动填写
	 * 本位币及大写字段的自动填写
	 */
	@Override
	protected void txtAmountOriCurrency_dataChange(DataChangeEvent e) throws Exception {


		//如果合同存在已申请付款金额，则  合同金额在变更时  存在一个下限
		if(this.txtAmountOriCurrency.getBigDecimalValue()==null||this.txtAmountOriCurrency.getBigDecimalValue().compareTo(BigDecimal.ZERO)<0)
			commUtils.giveUserTipsAndRetire("合同金额不能为空");

		//校验一
		BigDecimal totalReqAmt = BigDecimal.ZERO;
		for(int i=0;i<kdtPayment.getRowCount();i++)
			if(kdtPayment.getCell(i, "requiredPayAmount").getValue()!=null)
				totalReqAmt.add((BigDecimal) kdtPayment.getCell(i, "requiredPayAmount").getValue());
		if(totalReqAmt.compareTo(txtAmountOriCurrency.getBigDecimalValue())>0){
			txtAmountOriCurrency.setValue(e.getOldValue());
			commUtils.giveUserTipsAndRetire("合同金额不能小于已申请付款金额之和");
		}





		//本位币大写
		this.txtCapitaloriCurrency.setStringValue(GlUtils.getChineseFormat(this.txtAmountOriCurrency.getBigDecimalValue(), true,Locale.CHINESE));

		//保证金比例不为空时，自动填写保证金金额
		if(this.txtbailRate.getBigDecimalValue()!=null){
			BigDecimal actualValue=this.txtbailRate.getBigDecimalValue().divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_EVEN);
			this.txtbailAmount.setValue(this.txtAmountOriCurrency.getBigDecimalValue().multiply(actualValue));//保证金金额
		}
		//根据汇率自动填写合同金额本位币字段
		if(this.txtAmountOriCurrency.getBigDecimalValue()!=null&&this.txtexchangeRate.getBigDecimalValue()!=null) {
			BigDecimal AmountLocalCurren=this.txtAmountOriCurrency.getBigDecimalValue().multiply(this.txtexchangeRate.getBigDecimalValue());
			this.txtAmountLocalCurrency.setValue(AmountLocalCurren);
			this.txtCapitalLocalCurrency.setStringValue(GlUtils.getChineseFormat(this.txtAmountLocalCurrency.getBigDecimalValue(), true,Locale.CHINESE));
		}
		

		if(txtAmountOriCurrency.getBigDecimalValue().compareTo(BigDecimal.ZERO)!=0){
			kdtPayment.getColumn("paymentRate").setRequired(true);
			kdtPayment.getColumn("payAmount").setRequired(true);
			kdtPayment.getColumn("payAmount").getStyleAttributes().setLocked(false);
			kdtPayment.getColumn("paymentRate").getStyleAttributes().setLocked(false);
		}else{
			kdtPayment.getColumn("payAmount").getStyleAttributes().setLocked(true);
			kdtPayment.getColumn("paymentRate").getStyleAttributes().setLocked(true);
			kdtPayment.getColumn("paymentRate").setRequired(false);
			kdtPayment.getColumn("payAmount").setRequired(false);
		}
		
		for(int i=0;i<kdtPayment.getRowCount();i++){
			if(txtAmountOriCurrency.getBigDecimalValue().compareTo(BigDecimal.ZERO)==0){
				kdtPayment.getCell(i, "paymentRate").setValue(BigDecimal.ZERO);
				kdtPayment.getCell(i, "payAmount").setValue(BigDecimal.ZERO);
				continue;
			}
			if(kdtPayment.getCell(i, "payAmount").getValue()!=null&&((BigDecimal)kdtPayment.getCell(i, "payAmount").getValue()).compareTo(BigDecimal.ZERO)!=0)
				kdtPayment.getCell(i, "paymentRate").setValue(((BigDecimal)kdtPayment.getCell(i, "payAmount").getValue()).multiply(new BigDecimal("100")).divide(txtAmountOriCurrency.getBigDecimalValue(),3,BigDecimal.ROUND_HALF_EVEN));
		}		
	}

	/**
	 * 质保金金额变更监听事件
	 */
	@Override
	protected void txtbailAmount_dataChange(DataChangeEvent e) throws Exception {


		if(this.txtAmountOriCurrency.getBigDecimalValue()==null)
			commUtils.giveUserTipsAndRetire("请先填写合同金额");

		//质保金金额为0
		if(StringUtil.isEmpty(this.txtbailAmount.getStringValue())||txtbailAmount.getStringValue().equals("0")){
			this.txtbailAmount.setValue(BigDecimal.ZERO);
			this.txtbailRate.setValue(BigDecimal.ZERO);
			kdtPayment.getColumn("isBailAmt").getStyleAttributes().setLocked(true);
			for(int i=0;i<kdtPayment.getRowCount();i++)
				kdtPayment.getRow(i).getCell("isBailAmt").setValue(false);
			return;
		}


		kdtPayment.getColumn("isBailAmt").getStyleAttributes().setLocked(false);


		//质保金范围的校验
		if(((this.txtbailAmount.getBigDecimalValue()).compareTo(BigDecimal.ZERO)==-1)||((this.txtbailAmount.getBigDecimalValue()).compareTo(txtAmountOriCurrency.getBigDecimalValue())>0)){
			MsgBox.showInfo("保证金必须必须大于等于0且小于合同金额金额");
			this.txtbailRate.setValue(new BigDecimal("5"));
			this.txtbailAmount.setValue((this.txtAmountOriCurrency.getBigDecimalValue()).multiply(this.txtbailRate.getBigDecimalValue()).multiply(new BigDecimal("0.01")));
			return;
		}


		//根据保证金金额自动计算出保证金比例
		if((txtAmountOriCurrency.getBigDecimalValue()).compareTo(BigDecimal.ZERO)!=0)
			this.txtbailRate.setValue(txtbailAmount.getBigDecimalValue().divide(txtAmountOriCurrency.getBigDecimalValue(),6,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal("100")));
	}

	/**
	 * 质保金比例变化监听事件
	 */
	@Override
	protected void txtbailRate_dataChange(DataChangeEvent e) throws Exception {

		if(this.txtAmountOriCurrency.getBigDecimalValue()==null)
			commUtils.giveUserTipsAndRetire("请先填写合同金额");

		//质保金比率为0
		if(StringUtil.isEmpty(this.txtbailRate.getStringValue())){
			this.txtbailAmount.setValue(BigDecimal.ZERO);
			this.txtbailRate.setValue(BigDecimal.ZERO);
			kdtPayment.getColumn("isBailAmt").getStyleAttributes().setLocked(true);
			for(int i=0;i<kdtPayment.getRowCount();i++)
				kdtPayment.getRow(i).getCell("isBailAmt").setValue(false);
			return;
		}


		kdtPayment.getColumn("isBailAmt").getStyleAttributes().setLocked(false);


		//质保金范围的校验
		if(((this.txtbailRate.getBigDecimalValue()).compareTo(BigDecimal.ZERO)==-1)||((this.txtbailRate.getBigDecimalValue()).compareTo(new BigDecimal("100"))==1)){
			MsgBox.showInfo("保证金比例必须介于0-100%之间");
			this.txtbailRate.setValue(new BigDecimal("5"));
			return;
		}


		//根据保证金比率自动计算出保证金金额并填写保证金金额字段
		this.txtbailAmount.setValue((this.txtAmountOriCurrency.getBigDecimalValue()).multiply(this.txtbailRate.getBigDecimalValue()).multiply(new BigDecimal("0.01")));
	}	


	/**
	 * 责任部门的监听事件
	 */
	protected void prmtassureDept_dataChange(DataChangeEvent e) throws Exception {
		if(!this.oprtState.equals("EDIT"))//新增单据时，可能会因为空值 报一次提示，在此避免
			abort();
		if(this.prmtassureDept.getValue()==null||this.prmtassurer.getValue()==null)
			SysUtil.abort();


		String dept=this.prmtassureDept.getText();
		StringBuffer sql=new StringBuffer();
		String personId=((PersonInfo)this.prmtassurer.getValue()).getId().toString();
		sql.append("select a.fid,a.FName_L2 from T_BD_Person pe ");
		sql.append(" inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID ");
		sql.append(" inner join T_ORG_Position po on po.FID=pm.FPositionID ");
		sql.append("inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID ");
		sql.append("where pe.FID='").append(personId).append("'");
		sql.append("and a.Fname_l2='").append(dept).append("'");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		if (rs.next()) {
			return;
		}
		MsgBox.showInfo("当前责任人不存在于当前责任部门");
		this.prmtassureDept.setValue(null);		
	}
	/**
	 * 由当前责任人自动带出他所在的部门	
	 */
	@Override
	protected void prmtassurer_dataChange(DataChangeEvent e) throws Exception {
		if(this.prmtassurer.getValue()==null)
			SysUtil.abort();		
		StringBuffer sql=new StringBuffer();
		String person=((PersonInfo)this.prmtassurer.getValue()).getId().toString();
		sql.append("select a.fid,a.FName_L2 from T_BD_Person pe ");
		sql.append(" inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID ");
		sql.append(" inner join T_ORG_Position po on po.FID=pm.FPositionID ");
		sql.append("inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID ");
		sql.append("where pe.FID='").append(person).append("'");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		if (rs.next()) {
			String orgID = rs.getString("fid");
			AdminOrgUnitInfo adminOrgInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(orgID));
			this.prmtassureDept.setValue(adminOrgInfo);
		}
	}
	/**
	 * 由币种带出汇率
	 */
	protected void prmtcurrency_dataChange(DataChangeEvent e) throws Exception {

		if(this.prmtcurrency.getValue()==null)
			commUtils.giveUserTipsAndRetire("");{
				MsgBox.showInfo("请先输入币别");
				SysUtil.abort();
			}			
			if(this.prmtcurrency.getText().equals("人民币")){
				this.txtexchangeRate.setValue((new BigDecimal("1")));

			}else{
				StringBuffer sql=new StringBuffer();
				String currency=this.prmtcurrency.getText();
				sql.append("select tr.FConvertRate from T_BD_ExchangeRate tr"); 
				sql.append(" where tr.FExchangeAuxID=").append("(select te.fid from T_BD_ExchangeAux te");
				sql.append(" where FSourceCurrencyID=").append("(select  tc.fid from T_BD_Currency tc ");
				sql.append(" where tc.Fname_l2='").append(currency).append("')");
				sql.append(" and FTargetCurrencyID='dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC')");//兑换为人民币
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				if(rs.next()){
					String str=rs.getString("fconvertrate");
					this.txtexchangeRate.setValue(new BigDecimal(str));
					SysUtil.abort();
				}	
				this.txtexchangeRate.setValue(BigDecimal.ONE);
			}
	}

	/**
	 * 动态的实现对F7供应商的过滤，实现该组织下只能看到自己的供应商
	 * 通过对甲方字段的监听事件实现动态，即只选择甲方的供应商
	 */
	@Override
	protected void prmtpartyA_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		setPartyBFilter();
		super.prmtpartyA_dataChange(e);
	}

	private void setPartyBFilter(){
		// TODO Auto-generated method stub
		String companyID = "";		
		if(this.prmtpartyA.getValue()!=null)
			companyID=((CompanyOrgUnitInfo)this.prmtpartyA.getValue()).getId().toString();

		this.prmtpartyB.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.SupplierCompanyQuery");		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();
		fi.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id",companyID,CompareType.EQUALS));
		evi.setFilter(fi);
		this.prmtpartyB.setEntityViewInfo(evi);
	}

	/**
	 * 设置分录行政组织只是当前行政组织子行政组织
	 */
	private void setAdminOrgFilter(){
		// TODO Auto-generated method stub
		//		KDBizPromptBox prmtAdmin = (KDBizPromptBox)kdtPayment.getColumn("AdminOrg").getEditor().getComponent();
		//		AdminF7 adminF7=new AdminF7();
		//		adminF7.setIsCUFilter(false);
		//		adminF7.set
		//		prmtAdmin.setSelector(adminF7);
	}

	/**
	 * 汇率发生变化时，修改字段
	 */
	protected void txtexchangeRate_dataChange(DataChangeEvent e) throws Exception {

	}


	/**
	 * 合同性质的监听事件
	 * 两方合同下第三方置空
	 * 三方合同下  第三方设置为必录
	 * 根据合同的性质修改背景颜色
	 */
	protected void contractNature_actionPerforme(ActionEvent e) throws Exception {
		if(this.contractNature.getSelectedItem()==null)
			return;
		if(this.contractNature.getSelectedItem().equals(com.kingdee.eas.custom.signwasthetable.contractNature.ThripartiteContract)){
			txtpartyC.setBackground(Color.yellow);
			txtpartyC.setRequired(true);
		}
		else{
			txtpartyC.setRequired(false);
			txtpartyC.setBackground(Color.white);
			txtpartyC.setStringValue(null);
		}
	}

	/**
	 * 是否初始化单据设置  字段的可用性
	 */
	@Override
	protected void chkinitial_mouseClicke(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(chkinitial.isSelected()){
			kdtPayment.getColumn("requiredPayAmount").getStyleAttributes().setLocked(false);
			kdtPayment.getColumn("payedAmount").getStyleAttributes().setLocked(false);
		}else{
			kdtPayment.getColumn("requiredPayAmount").getStyleAttributes().setLocked(false);
			kdtPayment.getColumn("payedAmount").getStyleAttributes().setLocked(false);
		}
		super.chkinitial_mouseClicke(e);
	}

	/**
	 * 上一版本查看
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionUpVersion_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(this.txtperVersionID.getStringValue()))
			commUtils.giveUserTipsAndRetire("该合同没有发生过变更");

		if(this.editData.getId()==null)
			commUtils.giveUserTipsAndRetire("若要查看历史版本，请先保存");

		String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.CmChangeEditUI";
		Map map = new UIContext(this);
		map.put("srcBillID",editData.getId().toString());
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
		//开始展现 UI
		uiWindow.show();
		super.actionUpVersion_actionPerformed(e);
	}
	/**
	 * 保证金天数和完工日期设置
	 */
	@Override
	public void actionSetBailDays_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if(!editData.getContractStatus().equals(billStatus.Audit)){
			commUtils.giveUserTipsAndRetire("只有审核状态的合同才能设置保证金天数");
		}


		String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.BailDays";
		Map map = new UIContext(this);
		map.put("ID",editData.getId().toString());
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.EDIT);
		//开始展现 UI
		uiWindow.show();
		//		super.actionSetBailDays_actionPerformed(e);
	}

	/**
	 * 查看历史版本的列表
	 */
	@Override
	public void actionViewHistory_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		ContractInfo info=(ContractInfo)editData;
		if(info.getPerVersionID()==null)
			commUtils.giveUserTipsAndRetire("该单据没有发生过合同变更！");
		makecmChangeViewUI(info);
		super.actionViewHistory_actionPerformed(e);
	}
	@Override
	/**
	 * 生成付款申请单
	 */
	public void actionToPayReq_actionPerformed(ActionEvent e) throws Exception {

		//校验一
		if(!editData.getContractStatus().equals(billStatus.Audit))
			commUtils.giveUserTipsAndRetire("只有审核状态下的单据才能生成付款申请单");

		//校验二         获取分录选择的行
		int [] rows=KDTableUtil.getSelectedRows(kdtPayment);
		if(rows.length==0)
			commUtils.giveUserTipsAndRetire("您至少要选择一条分录行");

		//筛选出有效的分录行
		ContractInfo contracInfo = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(editData.getId().toString()));
		ContractPaymentCollection entrys = contracInfo.getPayment();

		for(int i=editData.getPayment().size()-1;i>=0;i--)//先删除
			editData.getPayment().remove(editData.getPayment().get(i));

		for(int i=0;i<rows.length;i++){
			ContractPaymentInfo entryInfo = entrys.get(rows[i]);
			if(entryInfo.getUnRequiredAmt().compareTo(BigDecimal.ZERO)>0)
				editData.getPayment().add(entryInfo);
		}

		//校验三
		if(editData.getPayment().size()==0)	{
			MsgBox.showInfo("您至少要选择一条有效的分录行");
			refreshCurPage();
			abort();
		}
		PayRequestBillInfo payreq=new PayRequestBillInfo();
		BOTMappingInfo botMappingInfo=null;
		CoreBaseCollection coll = BotpUtils.getBOTMappingInfosByBillInfo(null, editData, payreq);
		if(coll.size()>0)
			botMappingInfo=(BOTMappingInfo) coll.get(0);


		CoreBillBaseCollection coreBillBaseColl = new CoreBillBaseCollection();
		coreBillBaseColl.add((CoreBillBaseInfo)editData);
		BTPTransformResult transResult = BTPManagerFactory.getRemoteInstance().transform(coreBillBaseColl, botMappingInfo);
		IObjectCollection destBillColl = transResult.getBills();
		if(destBillColl.size()>0){
			payreq=(PayRequestBillInfo) destBillColl.getObject(0);
			PayRequestBillFactory.getRemoteInstance().save(payreq);
			BTPManagerFactory.getRemoteInstance().submitRelations(transResult.getBOTRelationCollection());
			refreshCurPage();
			showPayreqBill(payreq);
		}else
			commUtils.giveUserTipsAndRetire("生成失败");





		//		//生成付款申请单
		//		IObjectValue subBillInfo = com.kingdee.eas.custom.signwasthetable.createToPayFactory.getRemoteInstance().createPayReq(editData);
		//		refreshCurPage();
		//		PayRequestBillInfo payreq=(PayRequestBillInfo) subBillInfo;
		//		if(payreq != null && payreq.size() > 0){
		//			refreshCurPage();
		//			showPayreqBill(payreq);
		//		}
		super.actionToPayReq_actionPerformed(e);
	}

	@Override
	protected void prmtcontractType_dataChange(DataChangeEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		if(this.prmtcontractType.getValue()==null)
			return;
		if(((ContractTypeInfo)prmtcontractType.getValue()).getNumber().equals("001")){
			prmtsignTable.setBackground(Color.yellow);
			prmtsignTable.setRequired(true);
		}
		else{
			prmtsignTable.setRequired(false);
			prmtsignTable.setBackground(Color.white);
		}

		if(((ContractTypeInfo)prmtcontractType.getValue()).getNumber().equals("003")){
			for(int i=0;i<kdtPayment.getRowCount();i++){
				kdtPayment.getCell(i, "generalAssActType").setValue(null);
			}
			kdtPayment.getColumn("generalAssActType").getStyleAttributes().setHided(true);
		}else{
			kdtPayment.getColumn("generalAssActType").getStyleAttributes().setHided(false);
		}

		super.prmtcontractType_dataChange(e);
	}

	/*
	 * 弹出历史版本的序时簿界面
	 * 展现另一个界面的一般步骤：
	 * 1.String获取要弹出界面的全路径
	 * 2.定义一个map，出入参数
	 * 3.定义一个windows，弹出界面
	 */
	@SuppressWarnings("unchecked")
	private void makecmChangeViewUI(ContractInfo srcBillInfo) throws EASBizException, UIException,BOSException, Exception 
	{
		String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.ContractListUI";
		Map map = new UIContext(this);
		map.put("srcBillID",srcBillInfo.getId().toString());
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.NEWTAB).create(destBillEditUIClassName, map, null,OprtState.VIEW);
		//开始展现 UI
		uiWindow.show();
	}

	@Override	
	public void onLoad() throws Exception {	

		super.onLoad();

		//增加分录之前必须填写合同金额
		kdtPayment_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(StringUtils.isBlank(txtAmountOriCurrency.getStringValue()))
					commUtils.giveUserTipsAndRetire("请先填写合同金额");
			}});

		//增加分录之前必须填写合同金额
		kdtPayment_detailPanel.getInsertLineButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(StringUtils.isBlank(txtAmountOriCurrency.getStringValue()))
					commUtils.giveUserTipsAndRetire("请先填写合同金额");
			}});

		//增加分录之前必须填写合同金额
		kdtPayment_detailPanel.getRemoveLinesButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(kdtPayment.getCell(KDTableUtil.getSelectedRow(kdtPayment).getRowIndex(),"payedAmount").getValue()!=null
						&&((BigDecimal)kdtPayment.getCell(KDTableUtil.getSelectedRow(kdtPayment).getRowIndex(),"payedAmount").getValue()).compareTo(BigDecimal.ZERO)>0)
					commUtils.giveUserTipsAndRetire("已付款的阶段禁止删除");
			}});



		apendFootRow(kdtPayment,arrayOri);//合计行
		apendFootRow(kdtPayment,arrayRate);//比例合计行
		apendFootRow(kdtPayment,arrayLocal);//本位币字段合计行
		kdtPayment.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				apendFootRow(kdtPayment,arrayOri);//合计行
				apendFootRow(kdtPayment,arrayRate);//比例合计行
				apendFootRow(kdtPayment,arrayLocal);//本位币字段合计行
				if(kdtPayment.getColumn(arg0.getColIndex()).getKey().equals("PhaseCoding"))
					if(((Integer)kdtPayment.getCell(arg0.getRowIndex(),arg0.getColIndex()).getValue())==0){
						if(arg0.getRowIndex()==0)
							kdtPayment.getCell(arg0.getRowIndex(), "PhaseCoding").setValue(1);
						else
							kdtPayment.getCell(arg0.getRowIndex(), "PhaseCoding").setValue((Integer)kdtPayment.getCell(arg0.getRowIndex()-1, "PhaseCoding").getValue());
					}
			}

		});



		//界面调整
		setUIFormat();
		setFilter();
	}
	private void setFilter() {
		// TODO Auto-generated method stub
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("billStatus",true,CompareType.EQUALS));


		filterInfo.setMaskString("#0");
		evi.setFilter(filterInfo);
		prmtcontractType.setEntityViewInfo(evi);//仅可以选择已启用的合同类别


		setPartyBFilter();//供应商


		setAdminOrgFilter();
	}

	private void setUIFormat() {
		// TODO Auto-generated method stub
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		for(int i=0;i<array.length;i++)
			kdtPayment.getColumn(array[i]).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		for(int i=0;i<arrayLocal.length;i++)
			kdtPayment.getColumn(arrayLocal[i]).getStyleAttributes().setHided(true);
		for(int i=0;i<arrayOri.length;i++)
			kdtPayment.getColumn(arrayOri[i]).setWidth(120);

		kdtPayment.getColumn("payCondition").setWidth(180);
		kdtPayment.getColumn("engneerProject").setWidth(180);
		kdtPayment.getColumn("AdminOrg").setWidth(180);

		prmtsignTable.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.Copy_SignWasTheTableQuery");


		kdtPayment.getColumn("orgRate").getStyleAttributes().setNumberFormat("0.###");
		Audit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		UnAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
		btnRefresh.setIcon(EASResource.getIcon("imgTbtn_refresh"));
		viewChange.setIcon(EASResource.getIcon("imgTbtn_archive"));
		upVersion.setIcon(EASResource.getIcon("imgTbtn_archivesloan"));
		cmChange.setIcon(EASResource.getIcon("imgTbtn_editbatch"));
		btnsetBailDays.setIcon(EASResource.getIcon("imTbtn_atrributeset"));

		if(txtisHistory.getIntegerValue()==1){
			menuBar.setVisible(false);
			this.toolBar.setVisible(false);
		}

		CtrlUnitInfo CU = SysContext.getSysContext().getCurrentCtrlUnit();


		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("CU.id",CU.getId().toString(),CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("group.name","工程项目",CompareType.EQUALS));
		evi.setFilter(filter);

		final KDBizPromptBox kdtCmpItem_otherReceivableItem_PromptBox = new KDBizPromptBox();
		kdtCmpItem_otherReceivableItem_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.F7GeneralAsstActTypeQuery");
		kdtCmpItem_otherReceivableItem_PromptBox.setVisible(true);
		kdtCmpItem_otherReceivableItem_PromptBox.setEditable(true);
		kdtCmpItem_otherReceivableItem_PromptBox.setDisplayFormat("$number$");
		kdtCmpItem_otherReceivableItem_PromptBox.setEditFormat("$number$");
		kdtCmpItem_otherReceivableItem_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtCmpItem_otherReceivableItem_CellEditor = new KDTDefaultCellEditor(kdtCmpItem_otherReceivableItem_PromptBox);
		this.kdtPayment.getColumn("generalAssActType").setEditor(kdtCmpItem_otherReceivableItem_CellEditor);
		ObjectValueRender kdtCmpItem_otherReceivableItem_OVR = new ObjectValueRender();
		kdtCmpItem_otherReceivableItem_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtPayment.getColumn("generalAssActType").setRenderer(kdtCmpItem_otherReceivableItem_OVR);

		((KDBizPromptBox)kdtPayment.getColumn("generalAssActType").getEditor().getComponent()).setEntityViewInfo(evi);


		//		 this.prmtgeneralAssActType.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.GeneralAsstActTypeQuery");		


		if(prmtcontractType.getValue()!=null){
			if(((ContractTypeInfo)prmtcontractType.getValue()).getNumber().equals("003"))
				kdtPayment.getColumn("generalAssActType").getStyleAttributes().setHided(true);
		}
	}



	/** 
	 * 功能：添加合计行 
	 */  	
	@SuppressWarnings("unchecked")
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount();  
		if(count == 0){
			count = table.getRowCount1();
		}
		if(count == 0){
			count = table.getRowCount3();
		}
		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0.00"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);  
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = com.kingdee.eas.util.client.EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}  

	@SuppressWarnings("unchecked")
	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		com.kingdee.bos.ctrl.kdf.table.ICell cell =row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}
	/**
	 * 刷新界面
	 * 刷新操作时，保留原来的修改时间（现在貌似没效果，在合同变更时，刷新后单据处于保存状态）
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception //刷新
	{
		Date date=null;

		String perVersionID=null;
		String number=null;
		String version=null;
		int state=0;
		if(oprtState.equals("EDIT")&&!this.contractStatus.getSelectedItem().equals(billStatus.Audit)&&this.pkchangeDate.getValue()!=null)
		{
			state=1;
			date=(Date) this.pkchangeDate.getValue();
			if(this.txtperVersionID.getStringValue()!=null)
				perVersionID=this.txtperVersionID.getStringValue();
			number=this.txtNumber.getStringValue();
			version=this.txtversion.getStringValue();
		}


		if (editData.getId() != null) 
		{
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);

			if(date!=null)
				editData.setChangeDate(date);


			if(state==1)
			{
				setOprtState("EDIT");
				this.contractStatus.setSelectedItem(billStatus.save);
				this.txtperVersionID.setText(perVersionID);
				this.txtversion.setText(version);
			}

		}

	}	
	/**
	 * 保存或提交时校验单据内数据合法性
	 * @return 合法  返回 true  否则提示消息 中断操作
	 * @throws UIException
	 */
	protected void checkBeforeSave() throws UIException{

		//分录不为空的校验
		if(kdtPayment.getRowCount()==0)
			commUtils.giveUserTipsAndRetire("至少需要存在一条分录行");


		//两方合同和三方合同的校验
		if(this.contractNature.getSelectedItem().equals(com.kingdee.eas.custom.signwasthetable.contractNature.TwoPartyContract))
			if(!StringUtil.isEmpty(txtpartyC.getStringValue()))
				commUtils.giveUserTipsAndRetire("两方合同下不存在第三方！");
		if(this.contractNature.getSelectedItem().equals(com.kingdee.eas.custom.signwasthetable.contractNature.ThripartiteContract))
			if(StringUtils.isEmpty(this.txtpartyC.getStringValue())){
				MsgBox.showInfo("三方合同下第三方（丙方）不允许为空");
				SysUtil.abort();
			}//判定三方合同时丙方不允许为空

		if(this.prmtcontractType.getValue()!=null&&((ContractTypeInfo)prmtcontractType.getValue()).getNumber().equals("001")){
			if(prmtsignTable.getValue()==null)
				commUtils.giveUserTipsAndRetire("行政签呈不能为空");
		}

		BigDecimal totalAmt = BigDecimal.ZERO;
		BigDecimal totalBailAmt=BigDecimal.ZERO;
		for(int i=0;i<kdtPayment.getRowCount();i++){

			if(txtAmountOriCurrency.getBigDecimalValue()!=null&&txtAmountOriCurrency.getBigDecimalValue().compareTo(BigDecimal.ZERO)>0){
				if(kdtPayment.getCell(i, "payAmount").getValue()==null||((BigDecimal)kdtPayment.getCell(i, "payAmount").getValue()).compareTo(BigDecimal.ZERO)==0)
					commUtils.giveUserTipsAndRetire("分录付款金额不能为空");
				if(kdtPayment.getCell(i, "paymentRate").getValue()==null||((BigDecimal)kdtPayment.getCell(i, "paymentRate").getValue()).compareTo(BigDecimal.ZERO)==0)
					commUtils.giveUserTipsAndRetire("分录付款比例不能为空");
			}

			if(kdtPayment.getCell(i, "payAmount").getValue()!=null)
				totalAmt=totalAmt.add((BigDecimal) kdtPayment.getCell(i, "payAmount").getValue());
			if(kdtPayment.getCell(i, "payAmount").getValue()!=null&&kdtPayment.getCell(i, "isBailAmt").getValue().equals(true))
				totalBailAmt=totalBailAmt.add((BigDecimal) kdtPayment.getCell(i, "payAmount").getValue());
		}
		if(txtAmountOriCurrency.getBigDecimalValue()!=null&&totalAmt.compareTo(txtAmountOriCurrency.getBigDecimalValue())<0)
			if(0==MsgBox.showConfirm2("分录付款金额总和小于合同金额，确定保存么？")){

			}else
				SysUtil.abort();

		if(txtbailAmount.getBigDecimalValue()!=null&&totalBailAmt.compareTo(txtbailAmount.getBigDecimalValue())<0)
			if(0==MsgBox.showConfirm2("分录质保金金额总和小于合同质保金金额，确定保存么？")){

			}else
				SysUtil.abort();
		checkIsRepeat();
		if(contractStatus.getSelectedItem().equals(billStatus.Audit))
			commUtils.giveUserTipsAndRetire("单据状态不允许此操作");
	}
	// 校验单据的分录是否存在重复情况
	private void checkIsRepeat() {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtPayment.getRowCount()-1;i++)
			for(int j=i+1;j<kdtPayment.getRowCount();j++){
				if(kdtPayment.getCell(i, "PhaseCoding").getValue()!=null&&kdtPayment.getCell(j, "PhaseCoding").getValue()!=null){
					if(!(((Integer)kdtPayment.getCell(i, "PhaseCoding").getValue()).equals(((Integer)kdtPayment.getCell(j, "PhaseCoding").getValue()))))
						continue;
				}else
					continue;
				if(kdtPayment.getCell(i, "generalAssActType").getValue()!=null&&kdtPayment.getCell(j, "generalAssActType").getValue()!=null){
					if(!((GeneralAsstActTypeInfo)kdtPayment.getCell(i, "generalAssActType").getValue()).equals(((GeneralAsstActTypeInfo)kdtPayment.getCell(j, "generalAssActType").getValue())))
						continue;
				}
				else
					continue;
				if(kdtPayment.getCell(i, "AdminOrg").getValue()!=null&&kdtPayment.getCell(j, "AdminOrg").getValue()!=null){
					if(!((AdminOrgUnitInfo)kdtPayment.getCell(i, "AdminOrg").getValue()).equals(((AdminOrgUnitInfo)kdtPayment.getCell(j, "AdminOrg").getValue())))
						continue;
				}else
					continue;
				commUtils.giveUserTipsAndRetire("分录第"+(i+1)+"行与第"+(j+1)+"行的（阶段+工程项目+行政组织）重复");
			}
	}

	/**
	 * 付款申请单界面展示
	 */
	@SuppressWarnings("unchecked")
	public void showPayreqBill(PayRequestBillInfo info) {

		String destBillEditUIClassName ="com.kingdee.eas.fi.ap.client.PayRequestBillEditUI";
		Map map = new UIContext(this);
		map.put("ID",info.getId().toString());
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		try {
			uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.EDIT);
			uiWindow.show();
		} catch (UIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置分录 保证金天数和验收日期字段的可见性
	 */
	public boolean  setLastEntry()
	{
		//设置分录的倒数第二阶段的保证金天数和验收日期
		BigDecimal payedAmt=BigDecimal.ZERO;//设置一个累计已付款金额的变量
		for(int i=0;i<kdtPayment.getRowCount()-1;i++)//获得除最后一个阶段（保证金字段）以外其他阶段的已付款金额之和
		{
			if(kdtPayment.getRow(i).getCell("payedAmount").getValue()!=null)
				payedAmt=payedAmt.add((BigDecimal)kdtPayment.getRow(i).getCell("payedAmount").getValue());
		}
		if(this.txtAmountOriCurrency.getBigDecimalValue()!=null&&this.txtbailAmount.getBigDecimalValue()!=null)
		{
			BigDecimal unpayAmt = this.txtAmountOriCurrency.getBigDecimalValue().subtract(payedAmt);//合同金额-已付款金额之和=总的未付款金额
			if(this.txtbailAmount.getBigDecimalValue().compareTo(unpayAmt)!=-1)//若总的未付款金额=保证金，即只有保证金未付款或者保证金存在付款的时候
			{
				//				this.kdtPayment.getColumn("checkBeforeAcceptanceDate").getStyleAttributes().setHided(false);//则隐藏保证金天数和验收日期
				//				this.kdtPayment.getColumn("assureAmtDays").getStyleAttributes().setHided(false);
				//				this.kdtPayment.getColumn("checkBeforeAcceptanceDate").getStyleAttributes().setLocked(true);//锁定其他分录的保证金天数和验收日期不可用
				//				this.kdtPayment.getColumn("assureAmtDays").getStyleAttributes().setLocked(true);
				//				kdtPayment.getRow(kdtPayment.getRowCount()-2).getCell("checkBeforeAcceptanceDate").getStyleAttributes().setLocked(false);//倒数第二个阶段的保证金天数和验收日期可用
				//				kdtPayment.getRow(kdtPayment.getRowCount()-2).getCell("assureAmtDays").getStyleAttributes().setLocked(false);
				this.contbailAmtDays.setVisible(true);
				this.contcheckBeforeAcceptance.setVisible(true);
				this.contbailAmtDays.setEnabled(true);
				this.contcheckBeforeAcceptance.setEnabled(true);
				this.txtbailAmtDays.setEditable(true);
				this.pkcheckBeforeAcceptance.setEditable(true);
				this.btnSave.setEnabled(true);
				return true;
			}
			else
			{
				//如果只有保证金没付  或者保证金已付  则两个字段可见，保存按钮可用
				this.contbailAmtDays.setVisible(false);
				this.contcheckBeforeAcceptance.setVisible(false);
				return false;
			}
		}
		else
		{
			//如果只有保证金没付  或者保证金已付  则两个字段可见，保存按钮可用
			this.contbailAmtDays.setVisible(false);
			this.contcheckBeforeAcceptance.setVisible(false);
			return false;
			//			this.pkcheckBeforeAcceptance.setEnabled(true);
			//			this.pkcheckBeforeAcceptance.setEditable(true);
			//			this.txtbailAmtDays.setEnabled(true);
			//			this.txtbailAmtDays.setEditable(true);
			//			this.btnSave.setEnabled(true);
		}
	}

	/**
	 * 分录值变化事件
	 */
	@Override
	protected void kdtPayment_editStop(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kdtPayment_editStop(e);
		BigDecimal reqAmt=BigDecimal.ZERO;
		BigDecimal payAmt=BigDecimal.ZERO;
		BigDecimal payedAmt=BigDecimal.ZERO;



		if(StringUtil.isEmpty(txtAmountOriCurrency.getStringValue())
				||(txtAmountOriCurrency.getBigDecimalValue().compareTo(BigDecimal.ZERO)<0)){
			kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
			commUtils.giveUserTipsAndRetire("合同金额不能为空且必须大于等于0");
		}

		if(e.getOldValue()==null&&e.getValue()==null)
			return;

		/*----------------------付款比例----------------------------*/
		if("paymentRate".equals(kdtPayment.getColumn(e.getColIndex()).getKey())){
			payAmt= (BigDecimal) kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).getValue();

			//校验一
			if(payAmt.compareTo(BigDecimal.ZERO)<0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("阶段付款比例必须大于等于0");
			}

			BigDecimal totalRate=BigDecimal.ZERO;
			//校验二
			for(int i=0;i<kdtPayment.getRowCount();i++)
				if(kdtPayment.getCell(i, e.getColIndex()).getValue()!=null)
					totalRate=totalRate.add((BigDecimal) kdtPayment.getCell(i, e.getColIndex()).getValue());
			if(totalRate.compareTo(new BigDecimal("100"))>0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("阶段付款比例累计必须小于等于100");
			}

			//校验三
			payAmt=getPayAmountByPayRate(e.getRowIndex(),e.getColIndex());
			if(kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue()!=null&&
					!StringUtil.isEmpty(kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue().toString()))
				reqAmt = (BigDecimal)kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue();
			if(payAmt.compareTo(reqAmt)<0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("由比例生成的付款金额不能小于已申请付款金额");
			}

			//校验四
			BigDecimal totalPayRate = BigDecimal.ZERO;
			if(kdtPayment.getCell(e.getRowIndex(), "isBailAmt").getValue().equals(true))
				for(int i=0;i<kdtPayment.getRowCount();i++)
					if(kdtPayment.getCell(i, "paymentRate").getValue()!=null&&kdtPayment.getCell(i, "isBailAmt").getValue().equals(true))
						totalPayRate=totalPayRate.add((BigDecimal) kdtPayment.getCell(i, "paymentRate").getValue());
			if(txtbailAmount.getBigDecimalValue()!=null&&totalPayRate.compareTo(txtbailRate.getBigDecimalValue())>0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("质保金累计金额超出");
			}

			kdtPayment.getCell(e.getRowIndex(), "payAmount").setValue(payAmt);
			kdtPayment.getCell(e.getRowIndex(), "unRequiredAmt").setValue(payAmt.subtract(reqAmt));
			this.calOrgRate();
		}

		/*----------------------付款比例----------------------------*/



		/*-------------------------------付款金额--------------------------------*/
		if("payAmount".equals(kdtPayment.getColumn(e.getColIndex()).getKey())){
			payAmt = (BigDecimal) kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).getValue();

			//校验一
			if(payAmt.compareTo(BigDecimal.ZERO)<0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("阶段付款金额必须大于等于0");
			}

			BigDecimal totalAmount=BigDecimal.ZERO;
			//校验二
			for(int i=0;i<kdtPayment.getRowCount();i++)
				if(kdtPayment.getCell(i, e.getColIndex()).getValue()!=null)
					totalAmount=totalAmount.add((BigDecimal) kdtPayment.getCell(i, e.getColIndex()).getValue());
			if(totalAmount.compareTo(txtAmountOriCurrency.getBigDecimalValue())>0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("阶段付款金额累计必须小于等于合同金额");
			}

			//校验三
			if(kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue()!=null&&
					!StringUtil.isEmpty(kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue().toString()))
				reqAmt = (BigDecimal)kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue();
			if(payAmt.compareTo(reqAmt)<0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("付款金额不能小于已申请付款金额");
			}

			//校验四
			BigDecimal totalPayAmt = BigDecimal.ZERO;
			if(kdtPayment.getCell(e.getRowIndex(), "isBailAmt").getValue().equals(true))
				for(int i=0;i<kdtPayment.getRowCount();i++)
					if(kdtPayment.getCell(i, "payAmount").getValue()!=null&&kdtPayment.getCell(i, "isBailAmt").getValue().equals(true))
						totalPayAmt=totalPayAmt.add((BigDecimal) kdtPayment.getCell(i, "payAmount").getValue());
			if(txtbailAmount.getBigDecimalValue()!=null&&totalPayAmt.compareTo(txtbailAmount.getBigDecimalValue())>0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("质保金累计金额超出");
			}

			kdtPayment.getCell(e.getRowIndex(), "paymentRate").setValue(getPayRateByPayAmount(e.getRowIndex(),e.getColIndex()));
			kdtPayment.getCell(e.getRowIndex(), "unRequiredAmt").setValue(payAmt.subtract(reqAmt));
			this.calOrgRate();
		}
		/*-------------------------------付款金额--------------------------------*/


		/*-------------------------------已申请付款金额--------------------------------*/
		if("requiredPayAmount".equals(kdtPayment.getColumn(e.getColIndex()).getKey())){
			reqAmt=(BigDecimal) kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue();


			//校验一
			if(kdtPayment.getCell(e.getRowIndex(), "payAmount").getValue()!=null&&
					!StringUtil.isEmpty(kdtPayment.getCell(e.getRowIndex(), "payAmount").getValue().toString()))
				payAmt = (BigDecimal) kdtPayment.getCell(e.getRowIndex(),"payAmount" ).getValue();
			if(reqAmt.compareTo(payAmt)>0){
				kdtPayment.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("已申请付款金额不得大于当前阶段的付款金额");
			}

			//校验二
			if(kdtPayment.getCell(e.getRowIndex(), "payedAmount").getValue()!=null&&
					!StringUtil.isEmpty(kdtPayment.getCell(e.getRowIndex(), "payedAmount").getValue().toString()))
				payedAmt = (BigDecimal) kdtPayment.getCell(e.getRowIndex(),"payedAmount" ).getValue();
			if(payedAmt.compareTo(reqAmt)>0){
				kdtPayment.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("已申请付款金额不得小于当前阶段的已付款金额");
			}

			kdtPayment.getCell(e.getRowIndex(), "unRequiredAmt").setValue(payAmt.subtract(reqAmt));
			kdtPayment.getCell(e.getRowIndex(), "payingAmount").setValue(reqAmt.subtract(payedAmt));
		}
		/*-------------------------------已申请付款金额--------------------------------*/


		/*-------------------------------已付款金额--------------------------------*/
		if("payedAmount".equals(kdtPayment.getColumn(e.getColIndex()).getKey())){
			payedAmt=(BigDecimal) kdtPayment.getCell(e.getRowIndex(), e.getColIndex()).getValue();
			//校验一
			if(kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue()!=null&&
					!StringUtil.isEmpty(kdtPayment.getCell(e.getRowIndex(), "requiredPayAmount").getValue().toString()))
				reqAmt = (BigDecimal) kdtPayment.getCell(e.getRowIndex(),"requiredPayAmount" ).getValue();
			if(payedAmt.compareTo(reqAmt)>0){
				kdtPayment.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("已付款金额不得小于当前阶段的已申请付款金额");
			}

			kdtPayment.getCell(e.getRowIndex(), "payingAmount").setValue(reqAmt.subtract(payedAmt));			
		}
		/*-------------------------------已付款金额--------------------------------*/


		/*-------------------------------行政组织--------------------------------*/
		if("AdminOrg".equals(kdtPayment.getColumn(e.getColIndex()).getKey())){
			this.calOrgRate();
		}
		/*-------------------------------行政组织--------------------------------*/


		/*-------------------------------是否质保金--------------------------------*/
		if("isBailAmt".equals(kdtPayment.getColumn(e.getColIndex()).getKey())){
			//校验一
			BigDecimal totalPayAmt = BigDecimal.ZERO;
			if(kdtPayment.getCell(e.getRowIndex(), "isBailAmt").getValue().equals(true))
				for(int i=0;i<kdtPayment.getRowCount();i++)
					if(kdtPayment.getCell(i, "payAmount").getValue()!=null&&kdtPayment.getCell(i, "isBailAmt").getValue().equals(true))
						totalPayAmt=totalPayAmt.add((BigDecimal) kdtPayment.getCell(i, "payAmount").getValue());
			if(txtbailAmount.getBigDecimalValue()!=null&&totalPayAmt.compareTo(txtbailAmount.getBigDecimalValue())>0){
				kdtPayment.getCell(e.getRowIndex(),e.getColIndex() ).setValue(e.getOldValue());
				commUtils.giveUserTipsAndRetire("质保金累计金额超出");
			}
		}
		/*-------------------------------是否质保金--------------------------------*/


		setLocalAmount(e.getRowIndex());
	}

	/**
	 * 计算各场的阶段比例
	 */
	private void calOrgRate() {
		// TODO Auto-generated method stub
		ArrayList<AdminOrgUnitInfo> admin=new ArrayList<AdminOrgUnitInfo>();
		BigDecimal totalAmt = BigDecimal.ZERO;
		BigDecimal payAmt = BigDecimal.ZERO;
		for(int i=0;i<kdtPayment.getRowCount();i++){//循环遍历分录
			if(kdtPayment.getCell(i, "AdminOrg").getValue()==null||admin.contains(kdtPayment.getCell(i, "AdminOrg").getValue()))
				continue;
			else
				admin.add((AdminOrgUnitInfo) kdtPayment.getCell(i, "AdminOrg").getValue());

			for(int j=i;j<kdtPayment.getRowCount();j++){//求当前场的总计
				if(kdtPayment.getCell(j, "payAmount").getValue()!=null
						&&kdtPayment.getCell(j, "AdminOrg").getValue()!=null
						&&(kdtPayment.getCell(j, "AdminOrg").getValue()).equals(kdtPayment.getCell(i, "AdminOrg").getValue()))
					totalAmt=totalAmt.add((BigDecimal) kdtPayment.getCell(j, "payAmount").getValue());
			}

			if(totalAmt.compareTo(BigDecimal.ZERO)>0)//根据总计计算各阶段的比例
				for(int j=i;j<kdtPayment.getRowCount();j++){
					if(kdtPayment.getCell(j, "payAmount").getValue()!=null
							&&kdtPayment.getCell(j, "AdminOrg").getValue()!=null
							&&((AdminOrgUnitInfo)kdtPayment.getCell(j, "AdminOrg").getValue()).equals((AdminOrgUnitInfo) kdtPayment.getCell(i, "AdminOrg").getValue())){
						payAmt=((BigDecimal) kdtPayment.getCell(j, "payAmount").getValue());
						kdtPayment.getCell(j, "orgRate").setValue(payAmt.multiply(new BigDecimal("100")).divide(totalAmt,6,BigDecimal.ROUND_HALF_EVEN));
					}
				}

			//总值清零
			totalAmt=BigDecimal.ZERO;
		}
	}

	/**
	 * 分录根据付款金额计算付款比例
	 * @param rowIndex
	 * @param colIndex
	 */
	private Object getPayRateByPayAmount(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		BigDecimal payAmount = (BigDecimal)kdtPayment.getCell(rowIndex, colIndex).getValue();
		return		payAmount.divide(txtAmountOriCurrency.getBigDecimalValue(),6,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal("100"));
	}

	/**
	 * 分录根据付款比例计算付款金额
	 * @param rowIndex
	 * @param colIndex
	 */
	private BigDecimal getPayAmountByPayRate(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		BigDecimal paymentRate = (BigDecimal)kdtPayment.getCell(rowIndex, colIndex).getValue();
		return		txtAmountOriCurrency.getBigDecimalValue().multiply(new BigDecimal("0.01")).multiply(paymentRate);
	}

	/**
	 * 若金额字段为空则设置为0
	 * 设置某一行的本位币字段
	 * @param rowIndex
	 */
	private void setLocalAmount(int rowIndex) {
		// TODO Auto-generated method stub
		for(int i=0;i<arrayOri.length;i++)
			if(kdtPayment.getCell(rowIndex, arrayOri[i]).getValue()==null)
				kdtPayment.getCell(rowIndex, arrayOri[i]).setValue(BigDecimal.ZERO);
		if(txtexchangeRate.getBigDecimalValue()!=null)
			for(int i=0;i<arrayOri.length;i++){
				kdtPayment.getCell(rowIndex, arrayLocal[i]).setValue(
						((BigDecimal)kdtPayment.getCell(rowIndex, arrayOri[i]).getValue()).multiply(txtexchangeRate.getBigDecimalValue()));
			}
	}
}
