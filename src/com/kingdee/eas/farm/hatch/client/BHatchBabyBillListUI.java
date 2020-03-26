/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.IBEggHatchBill;
import com.kingdee.eas.farm.hatch.IBHatchBabyBill;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class BHatchBabyBillListUI extends AbstractBHatchBabyBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BHatchBabyBillListUI.class);

	/**
	 * output class constructor
	 */
	public BHatchBabyBillListUI() throws Exception
	{
		super();
		// Ĭ�� �ɲ�ѯ��ǰ��֯ ��������֯��  �Ϸ��� �Ϸ���
		//        this.setFilterForQuery(this.getFilterInfo());
		// ͼ������
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
	}
//	/**
//	 * ����Ĭ�Ϲ�������
//	 * @return
//	 */
//	public FilterInfo getFilterInfo(){
//		FilterInfo filterInfo  = new FilterInfo();
////		AdminOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentAdminUnit();
////
////		filterInfo.getFilterItems().add(new FilterItemInfo("adminOrg.longNumber",currAdminOrg.getLongNumber(),CompareType.LIKE));
//
//
//		return filterInfo;
//	}
//
//
//	/**
//	 * ��֯����
//	 */
//	@Override
//	protected FilterInfo getDefaultFilterForQuery() {
//		// TODO Auto-generated method stub
//		FilterInfo filter = super.getDefaultFilterForQuery();
//		String mskStr = filter.getMaskString();
//		int size = filter.getFilterItems().size();
//		if(SysContext.getSysContext().getCurrentStorageUnit()!=null){
//			//filter.getFilterItems().add(new FilterItemInfo("storageOrg.name",SysContext.getSysContext().getCurrentStorageUnit().getString("name"),CompareType.EQUALS));
//			//filter.setMaskString("("+mskStr+") and #"+size);
//		}
//		return filter;
//	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBHatchBabyBill iBHatchBabyBill = BHatchBabyBillFactory.getRemoteInstance();

		BHatchBabyBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBHatchBabyBill.getBHatchBabyBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"���ύ״̬�ĵ��ݽ�ֹ���"+"\n";
				num--;
				continue;
			}
			iBHatchBabyBill.audit(info);
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

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBHatchBabyBill iBHatchBabyBill = BHatchBabyBillFactory.getRemoteInstance();

		BHatchBabyBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBHatchBabyBill.getBHatchBabyBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"�����״̬�ĵ��ݽ�ֹ�����"+"\n";
				num--;
				continue;
			}
			iBHatchBabyBill.unAudit(info);
		}
		try{
			if(num==selIDs.length && num == 1)
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
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.hatch.BHatchBabyBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.BHatchBabyBillInfo objectValue = new com.kingdee.eas.farm.hatch.BHatchBabyBillInfo();

		return objectValue;
	}
	  /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("��������ˣ���ֹ�༭��");
			SysUtil.abort();
		}
        super.actionEdit_actionPerformed(e);
    }

}