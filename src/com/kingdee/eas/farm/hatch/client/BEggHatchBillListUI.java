/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.bot.BOTRelationInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.BEggCandlingBillCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.IBEggHatchBill;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo;
import com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

/**
 * output class name
 */
public class BEggHatchBillListUI extends AbstractBEggHatchBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BEggHatchBillListUI.class);

	/**
	 * output class constructor
	 */
	public BEggHatchBillListUI() throws Exception
	{
		super();
		this.setUITitle("�ֵ��Ϸ���");
		// Ĭ�� �ɲ�ѯ��ǰ��֯ ��������֯��  �Ϸ��� �Ϸ���
		this.setFilterForQuery(this.getFilterInfo());
		// ͼ������
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBEggHatchBill iBEggHatchBill = BEggHatchBillFactory.getRemoteInstance();

		BEggHatchBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggHatchBill.getBEggHatchBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\r"+"���ύ״̬�ĵ��ݽ�ֹ���"+"\n";
				num--;
				continue;
			}
			iBEggHatchBill.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("��˳ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("��˳ɹ�(����������:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("���ʧ��");
			else if(num==0)
				MsgBox.showInfo("���ʧ��,û�з�����������ĵ���");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ���������\n"+error));
			}
		}
		finally{
			refreshList();
		}

		//		super.actionAudit_actionPerformed(e);



	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBEggHatchBill iBEggHatchBill = BEggHatchBillFactory.getRemoteInstance();

		BEggHatchBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggHatchBill.getBEggHatchBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\r"+"�����״̬�ĵ��ݽ�ֹ�����"+"\n";
				num--;
				continue;
			}
			iBEggHatchBill.unAudit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("����˳ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("����˳ɹ�(����������:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("�����ʧ��");
			else if(num==0)
				MsgBox.showInfo("�����ʧ��,û�з��Ϸ���������ĵ���");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ��ӷ�������\n"+error));
			}
		}
		finally{
			refreshList();
		}

		//		super.actionAudit_actionPerformed(e);



	}
	@Override
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCreateTo_actionPerformed(e);
		String id = this.getSelectedKeyValue();
		BEggHatchBillInfo editData;
		if(StringUtils.isEmpty(id))
			return;
		else
			editData=BEggHatchBillFactory.getRemoteInstance().getBEggHatchBillInfo(new ObjectUuidPK(id));
		String sql="select * from T_BOT_Relation where FSrcObjectID='"+editData.getId().toString()+"' and FDestEntityID='D54999A2' order by FDate desc";
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(rs.size()>0){
			if(rs.next()){
				BEggCandlingBillCollection collBEggCanding = BEggCandlingBillFactory.getRemoteInstance().getBEggCandlingBillCollection("where id='"+rs.getString("FDestObjectID")+"'");
				if(collBEggCanding.size()>0){
					String str = "update CT_FM_BEggHatchBill set FIsHasBEggCanding=1";
					if(collBEggCanding.get(0).getBizDate()!=null)
						str+=",FBEggCandingDate={ts '"+sdf.format(collBEggCanding.get(0).getBizDate())+"'}";
					str+=" where  fid ='"+editData.getString("id")+"'";
					hatchFacadeFactory.getRemoteInstance().excuteSql(str);
				}
			}
		}
	}
	/**
	 * ����Ĭ�Ϲ�������
	 * @return
	 */
	public FilterInfo getFilterInfo(){
		FilterInfo filterInfo  = new FilterInfo();
		
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
		StorageOrgUnitInfo currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStoOrg ==null){
    		MsgBox.showInfo("��ǰ��¼��֯���ǿ����֯");
    		SysUtil.abort();
    	}
//		filterInfo.getFilterItems().add(new FilterItemInfo("StorageOrgUnit.longNumber",currStoOrg.getLongNumber(),CompareType.LIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",companyInfo.getId().toString(),CompareType.EQUALS));
		
		return filterInfo;
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
		return com.kingdee.eas.farm.hatch.BEggHatchBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BEggHatchBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggHatchBillInfo();

		return objectValue;
	}
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("��������ˣ���ֹ�༭��");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}


	/**
	 * (��д)�ı��б�����Զ����������
	 */
//	@Override
//	protected CommonQueryDialog initCommonQueryDialog() {
//		// TODO Auto-generated method stub
//		//		return super.initCommonQueryDialog();
//		CommonQueryDialog dialog = super.initCommonQueryDialog();
//		try 
//		{
//			dialog.addUserPanel(getUsierPanel());
//			dialog.setShowFilter(true);
//			dialog.setShowSorter(true);
//			dialog.setHeight(380);
//			dialog.setWidth(500);
//			dialog.setTitle("");
//		}
//		catch (Exception e) 
//		{
//			handUIException(e);
//		}
//		return dialog;
//	}




}