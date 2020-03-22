/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.PersonUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.signwasthetable.SignBDFactory;
import com.kingdee.eas.custom.signwasthetable.SignBDInfo;
import com.kingdee.eas.custom.signwasthetable.billStates;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.scm.common.client.SCMClientHelper;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;




/**
 * output class name
 */
// public void onLoad() throws Exception{
// }
public class SignWasTheTableEditUI extends AbstractSignWasTheTableEditUI {
	private static final Logger logger = CoreUIObject.getLogger(SignWasTheTableEditUI.class);
	String [] str={};
	/**
	 * output class constructor
	 */
	public SignWasTheTableEditUI() throws Exception {
		super();

		this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
		this.prmtsalePerson.setVisible(true);		
		this.prmtsalePerson.setEditable(true);		
		this.prmtsalePerson.setDisplayFormat("$name$");		
		this.prmtsalePerson.setEditFormat("$number$");		
		this.prmtsalePerson.setCommitFormat("$number$");		
		this.prmtsalePerson.setRequired(false);

		/*  1321 */     this.prmtsalePerson.setCommitFormat("$person.number$;$person.idNum$;$person.name$");
		/*  1322 */     this.prmtsalePerson.setDisplayFormat("$name$");
	}

	/**
	 * output loadFields method	 */
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.signwasthetable.client.AbstractSignWasTheTableEditUI#loadFields()
	 */
	public void loadFields() {
		DataChangeListener[] dcls = prmtpresentedPerson.getListeners(DataChangeListener.class);
		for(int i = 0; dcls.length > 0 && i<dcls.length; i++){
			prmtpresentedPerson.removeDataChangeListener(dcls[i]);
		}
		super.loadFields();
		for(int i = 0; dcls.length > 0 && i<dcls.length; i++){
			prmtpresentedPerson.addDataChangeListener(dcls[i]);
		}

		this.kDLabel4.setText(editData.getOrgSupp());
		this.billStatus.setVisible(true);
		this.prmtbillType.setVisible(true);
		this.billStatus.setEnabled(false);
		this.prmtadminOrgUnit.setEnabled(true);
		this.prmtAuditors.setEnabled(false);
		this.kDLabel4.setEnabled(true);
		this.contAuditors.setEnabled(false);
		this.contAuditTime.setEnabled(false);




		this.Audit.setIcon(EASResource.getIcon("imgTbtn_auditing"));
		this.unAudit.setIcon(EASResource.getIcon("imgTbtn_fauditing"));
		this.contAuditors.setVisible(false);
		this.contAuditTime.setVisible(false);

		if (this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.save)) {
			this.actionSubmit.setEnabled(true);
			this.actionCheck.setEnabled(false);
			this.actionUnAudit.setEnabled(false);			
			this.prmtbillType.setEnabled(true);
		}
		if (this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.submit)) {
			this.actionSubmit.setEnabled(true);
			this.actionCheck.setVisible(true);
			this.actionCheck.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
			this.prmtbillType.setEnabled(true);
		}
		if(this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit))
		{
			this.actionSubmit.setEnabled(false);
			this.contAuditors.setVisible(false);
			this.contAuditTime.setVisible(false);
			this.prmtbillType.setEnabled(false);
			this.btnRemove.setEnabled(false);
			this.btnEdit.setEnabled(false);
			this.actionCheck.setEnabled(false);
			this.actionUnAudit.setVisible(true);
			this.actionUnAudit.setEnabled(true);
			this.btnSubmit.setEnabled(false);
		}


		txtNumber.setEnabled(false);

		if(this.prmtbillType.getValue()!=null){
			if(isInArray(((SignBDInfo)this.prmtbillType.getValue()).getNumber(), str))
				contsalePerson.setVisible(true);
			else
				contsalePerson.setVisible(false);
		}else
			contsalePerson.setVisible(false);


	}

	@Override
	public void actionBtnRefresh_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		refreshCurPage();
		super.actionBtnRefresh_actionPerformed(e);
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();	
	}
	public void checknull(){
		if (this.txtKeyWord.getText().equals(null)) {
			MsgBox.showInfo("主旨不能为空，请检查");
			SysUtil.abort();
		}
		if(txtpredictAmt.getStringValue()==null){
			MsgBox.showInfo("预计金额不能为空");
			SysUtil.abort();
		}
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception// 保存
	{
		if(this.prmtbillType.getValue()!=null)
			if(isInArray(((SignBDInfo)this.prmtbillType.getValue()).getNumber(), str))
				if(prmtsalePerson.getValue()==null)
					commUtils.giveUserTipsAndRetire("销售员不能为空");

		if(!editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.save))
		{
			MsgBox.showInfo("只有新增或者保存状态的单据才可以重新保存");
			abort();
		}
		checknull();
		if(txtreason.getStringValue()==null||"".equals(txtreason.getStringValue()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"说明"});
		if(txtreason.getStringValue().length()>1320){
			MsgBox.showInfo("输入的说明字符长度超过字数限制");
			abort();
		}
		super.actionSave_actionPerformed(e);
		refreshCurPage();
	}

	/**
	 * 字段合法性校验
	 */
	protected void verifyInput(ActionEvent e) throws Exception {
		super.verifyInput(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}
	/*
	 * 提交操作
	 * @see com.kingdee.eas.custom.signwasthetable.client.AbstractSignWasTheTableEditUI#actionSubmit_actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception// 提交
	{

		if(this.prmtbillType.getValue()!=null)
			if(isInArray(((SignBDInfo)this.prmtbillType.getValue()).getNumber(), str))
				if(prmtsalePerson.getValue()==null)
					commUtils.giveUserTipsAndRetire("销售员不能为空");
		checknull();
		if(txtreason.getStringValue()==null||"".equals(txtreason.getStringValue()))
			throw new EASBizException(EASBizException.CHECKBLANK,new Object[]{"说明"});

		if(txtreason.getStringValue().length()>1320){
			MsgBox.showInfo("输入的说明字符长度超过字数限制");
			abort();
		}
		if(UIRuleUtil.isNull(txtpredictAmt.getStringValue()))
			commUtils.giveUserTipsAndRetire("预计金额不能为空(可以为0)");
		super.actionSubmit_actionPerformed(e);
		refreshCurPage();
	}

	/**
	 *  output actionEdit_actionPerformed
	 * 编辑操作
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit)) {
			MsgBox.showInfo("已审核的签呈不允许修改");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * 删除
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit)) {
			MsgBox.showInfo("已审核的签呈不允许删除");
			SysUtil.abort();
		}
		//提交后的单据已经走工作流，此时单据禁止手工删除
		if(editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.submit))
		{
			MsgBox.showWarning("已提交的单据禁止删除");
			abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception {
		return com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table) {
		return null;
	}

	@Override
	public void actionCheck_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (!this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.submit)) {
			MsgBox.showInfo("当前状态下无法审核");
			SysUtil.abort();
		}
		Boolean bool = ClientUtils.checkBillInWorkflow(this, editData.getId().toString());
		if(bool)
			return;
		super.actionCheck_actionPerformed(e);
		refreshCurPage();
		MsgBox.showInfo("签呈审核通过");
	}

	@Override
	public void onLoad() throws Exception {
		super.onLoad();	


		txtpredictAmt.setHorizontalAlignment(SwingConstants.RIGHT);
		//设置居中显示的当前公司的文本居中显示
		this.kDLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
		//建立一个F7控件的过滤条件，仅选择启用了的合同类型
		EntityViewInfo entityViewInfo = new EntityViewInfo();  
		FilterInfo filterInfo = new FilterInfo(); 
		filterInfo.getFilterItems().add(new FilterItemInfo("billStatus",true,CompareType.EQUALS));  
		entityViewInfo.setFilter(filterInfo);  
		prmtbillType.setEntityViewInfo(entityViewInfo);


		//设置按钮的可见性
		this.btnAddLine.setVisible(false);
		this.btnRemoveLine.setVisible(false);
		this.btnInsertLine.setVisible(false);
		this.btnCreateFrom.setVisible(false);
		this.txtNumber.setVisible(true);
		this.btnTraceUp.setVisible(false);
		this.btnCreateTo.setVisible(true);
		//设施中刷新按钮的图标和文字的可见性
		this.btnRefresh.setIcon(EASResource.getIcon("imgTbtn_refresh"));
		this.btnRefresh.setHideActionText(true);

		//设置前后左右四个按钮可用
		this.btnFirst.setEnabled(true);
		this.btnPre.setEnabled(true);
		this.btnNext.setEnabled(true);
		this.btnLast.setEnabled(true);


		kdtEntry.getColumn("Price").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntry.getColumn("Quantity").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntry.getColumn("Amount").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);

		kdtEntry.getColumn("Project").setWidth(140);
		kdtEntry.getColumn("Price").setWidth(80);
		kdtEntry.getColumn("Quantity").setWidth(80);
		kdtEntry.getColumn("Amount").setWidth(80);
		kdtEntry.getColumn("Unit").setWidth(80);
		kdtEntry.getColumn("Statement").setWidth(140);
		kdtEntry.setAutoResize(true);

		//合计行
		String []array={"Amount"};
		apendFootRow(kdtEntry,array);
		KDTPropertyChangeListener kdtEntryListener=new KDTPropertyChangeListener()//合计行
		{
			public void propertyChange(KDTPropertyChangeEvent arg0) 
			{

				String []array={"Amount"};
				apendFootRow(kdtEntry,array);//合计行 

				calPredictedAmt();
			}
		};
		kdtEntry.addKDTPropertyChangeListener(kdtEntryListener);



		//编码规则若启动，则不可用，否则可用，且设置为必录项
		if(this.txtNumber.getStringValue()==null)
		{
			this.txtNumber.setEnabled(true);
			this.txtNumber.setRequired(true);
		}
		else
			this.txtNumber.setEnabled(false);

		//审核状态下的的单据，反审核按钮和推式生成按钮可用
		if(editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit))
		{
			this.unAudit.setEnabled(true);
			this.btnCreateTo.setEnabled(true);
		}		
		//鉴于非全屏下不好看，所以打开时默认全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	//合计行
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
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() {
		com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo objectValue = new com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext
				.getSysContext().getCurrentUserInfo()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		UserInfo currentUser = SysContext.getSysContext().getCurrentUserInfo();
		objectValue.setOrgSupp(SysContext.getSysContext().getCurrentFIUnit().getName());
		//签呈表默认初始类型：购买
		try {
			objectValue.setBillType(SignBDFactory.getRemoteInstance().getSignBDInfo(new ObjectUuidPK("at4AAAAH19Zdb7ZJ")));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objectValue.setPresentedPerson(currentUser.getPerson());

		if(currentUser.getPerson()!=null&&currentUser.getPerson().getId()!=null){
			objectValue.setAdminOrgUnit(getAdminOrgUnitInfo(currentUser.getPerson().getId().toString()));
			objectValue.setPosition(PersonUtil.getPersonPositionByPerson(null, currentUser.getPerson().getId().toString()));
			objectValue.setUpperPosition(PersonUtil.getDirectUpperPositionByPerson(null, currentUser.getPerson().getId().toString()));
		}

		objectValue.setBillStatus(com.kingdee.eas.custom.signwasthetable.billStatus.save);
		objectValue.setBizDate(new java.util.Date());
		objectValue.setPredictAmt(BigDecimal.ZERO);
		return objectValue;
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	private AdminOrgUnitInfo getAdminOrgUnitInfo(String ID) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select a.fid,a.FName_L2 from T_BD_Person pe ");
		sql.append(" inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID ");
		sql.append(" inner join T_ORG_Position po on po.FID=pm.FPositionID ");
		sql.append("inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID ");
		sql.append("where pe.FID='").append(ID).append("'");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if (rs.next()) {
				String orgID = rs.getString("fid");
				AdminOrgUnitInfo adminOrgInfo = AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(orgID));
				if(adminOrgInfo!=null)
					return adminOrgInfo;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void prmtpresentedPerson_dataChanged(DataChangeEvent e) throws Exception {

		if(this.prmtpresentedPerson.getValue()==null)
			SysUtil.abort();
		if(checkPersonAndAdmin())
			abort();
		String personID = ((PersonInfo) this.prmtpresentedPerson.getValue()).getId().toString();// 当前界面人员字段的id
		setAdminOrgUnit(personID);
		prmtposition.setValue(PersonUtil.getPersonPositionByPerson(null, personID));
		prmtupperPosition.setValue(PersonUtil.getDirectUpperPositionByPerson(null, personID));
	}
	//根据呈送者的id设置呈送部门
	protected void setAdminOrgUnit(String personid)
	{

		AdminOrgUnitInfo adminOrgInfo = getAdminOrgUnitInfo(personid);
		this.prmtadminOrgUnit.setValue(adminOrgInfo);
		this.editData.setAdminOrgUnit(adminOrgInfo);

	}


	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if (!this.editData.getBillStatus().equals(com.kingdee.eas.custom.signwasthetable.billStatus.Audit)) {
			SysUtil.abort();
		}
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
		MsgBox.showInfo("签呈已被反审核");
	}	
	@Override
	protected void prmtadminOrgUnit_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		checkPersonAndAdmin();
		//		if (this.prmtadminOrgUnit.getValue()==null) 
		//			SysUtil.abort();
		//		if(this.prmtpresentedPerson.getValue()==null)
		//			SysUtil.abort();
		//		String department = ((AdminOrgUnitInfo)this.prmtadminOrgUnit.getValue()).getId().toString();
		//		String personID = ((PersonInfo) this.prmtpresentedPerson.getValue()).getId().toString();// 当前界面人员字段的id
		//		StringBuffer sql = new StringBuffer();
		//		sql.append("select a.fid,a.FName_L2 from T_BD_Person pe ");
		//		sql.append(" inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID ");
		//		sql.append(" inner join T_ORG_Position po on po.FID=pm.FPositionID ");
		//		sql.append("inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID ");
		//		sql.append("where pe.FID='").append(personID).append("'");
		//		sql.append(" and a.Fid='").append(department).append("'");
		//		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		//		if (rs.next()) {
		//			SysUtil.abort();
		//		}
		//		MsgBox.showInfo("当前呈送者不存在于这个部门");
		//		setAdminOrgUnit(personID);
	}

	/**
	 *检查当前呈送者是否存在于当前部门
	 */
	private Boolean checkPersonAndAdmin() {
		// TODO Auto-generated method stub
		if (this.prmtadminOrgUnit.getValue()==null) 
			return false;
		if(this.prmtpresentedPerson.getValue()==null)
			return false;
		String department = ((AdminOrgUnitInfo)this.prmtadminOrgUnit.getValue()).getId().toString();
		String personID = ((PersonInfo) this.prmtpresentedPerson.getValue()).getId().toString();// 当前界面人员字段的id
		StringBuffer sql = new StringBuffer();
		sql.append("select a.fid,a.FName_L2 from T_BD_Person pe ");
		sql.append(" inner join T_ORG_PositionMember pm on pe.FID=pm.FPersonID ");
		sql.append(" inner join T_ORG_Position po on po.FID=pm.FPositionID ");
		sql.append("inner join T_ORG_Admin a on a.FID= po.FAdminOrgUnitID ");
		sql.append("where pe.FID='").append(personID).append("'");
		sql.append(" and a.Fid='").append(department).append("'");
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if (rs.next()) {
				return true;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 销售合同类型设置销售员字段可见且必录
	 */
	@Override
	protected void prmtbillType_dataChang(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(prmtbillType.getValue()!=null){
			SignBDInfo billType = (SignBDInfo) prmtbillType.getValue();

			if(billType.getNumber()!=null&&!billType.getNumber().equals("")){
				if(isInArray(billType.getNumber(),str)){
					contsalePerson.setVisible(true);
					prmtsalePerson.setVisible(true);
					prmtsalePerson.setRequired(true);
				}
				else{
					contsalePerson.setVisible(false);
					prmtsalePerson.setVisible(false);
					prmtsalePerson.setRequired(false);
					prmtsalePerson.setValue(null);
				}
			}else{
				contsalePerson.setVisible(false);
				prmtsalePerson.setVisible(false);
				prmtsalePerson.setValue(null);
			}
		}
		super.prmtbillType_dataChang(e);
	}

	/**
	 * 判断某个元素是否存在数组中
	 * @param number
	 * @param str
	 * @return
	 */
	private boolean isInArray(Object number, Object[] str) {
		// TODO Auto-generated method stub
		for(int i=0;i<str.length;i++)
			if(number.equals(str[i]))
				return true;
		return false;
	}

	@Override
	protected void prmtsalePerson_dataChanged(DataChangeEvent e)
	throws Exception {
		super.prmtsalePerson_dataChanged(e);
		SCMClientHelper scmHelper = new SCMClientHelper(this);
		scmHelper.initSalePersonDisplay((KDBizPromptBox)e.getSource());
	}

	/**
	 * 
	 */
	private void calPredictedAmt(){
		BigDecimal amt=BigDecimal.ZERO;
		for(int i=0;i<kdtEntry.getRowCount();i++)
			if(kdtEntry.getCell(i, "Amount").getValue()!=null){
				amt=amt.add((BigDecimal) kdtEntry.getCell(i, "Amount").getValue());
			}
		txtpredictAmt.setValue(amt);
	}

}
