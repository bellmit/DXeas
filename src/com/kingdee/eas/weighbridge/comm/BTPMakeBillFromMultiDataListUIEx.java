package com.kingdee.eas.weighbridge.comm;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.btp.client.BTPMakeBillFromMultiDataListUI;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.scm.common.SCMBillBaseInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.client.MsgBox;

public class BTPMakeBillFromMultiDataListUIEx extends BTPMakeBillFromMultiDataListUI {

	public BTPMakeBillFromMultiDataListUIEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean destroyWindow() {
		//�����ж���ѡ�����Ƿ�һ��
		CoreBillBaseCollection srcBillCollection = this.getSrcBillCollection();
		CoreBaseInfo ob, obEntry;
		String stdSCMObject="",SCMObject="", stdMaterialID="",materialID="",bosType="";
		String showtxt="";
		ICoreBase ise=null,is=null;
		if(srcBillCollection!=null&&srcBillCollection.size()>1) {//��ѡ��ļ�¼����1�����ٽ����ж�
//			MsgBox.showWarning("�ݲ�֧�ֶ��¼ҵ��");
//			return false;
		}
		if(srcBillCollection!=null&&srcBillCollection.size()>1) {//��ѡ��ļ�¼����1�����ٽ����ж�
			for(int i=0;i<srcBillCollection.size();i++) {
				ob = srcBillCollection.get(i);
				if(ob instanceof SCMBillBaseInfo) {//��Ӧ����������
					for(int j=0;j<((IObjectCollection)ob.get("entries")).size();j++) {
						try{
							if(j==0) {
//								bosType=ob.getBOSType().toString();
//								is=WeighbridgeCommUtils.getBizInstance(null, bosType);
								bosType=((IObjectCollection)ob.get("entries")).getObject(j).getBOSType().toString();
								ise = WeighbridgeCommUtils.getBizInstance(null, bosType);
							}
							//ob=is.getValue(new ObjectUuidPK(ob.getId()));
							if(ob instanceof SaleOrderInfo) {
								showtxt="�ͻ�";
								SCMObject=ob.getObjectValue("customer").getString("id");
							}
							else if(ob instanceof PurOrderInfo) {
								showtxt="��Ӧ��";
								SCMObject=ob.getObjectValue("supplier").getString("id");
							}
							if(StringUtils.isBlank(stdSCMObject)) {
								stdSCMObject=SCMObject;
							}else {
								if(!SCMObject.equalsIgnoreCase(stdSCMObject)) {
									MsgBox.showWarning("��ѡ����"+showtxt+"��һ�£�������ѡ��");
									return false;
								}
							}
							obEntry=ise.getValue(new ObjectUuidPK(((IObjectCollection)ob.get("entries")).getObject(j).getString("id")));
							if(obEntry.getObjectValue("material")!=null) //���Ͽ϶���Ϊ��
								materialID=obEntry.getObjectValue("material").getString("id");
							if(StringUtils.isBlank(stdMaterialID)) {
								stdMaterialID=materialID;
							}else {
								if(!materialID.equalsIgnoreCase(stdMaterialID)) {
									MsgBox.showWarning("��ѡ�������ϲ�һ�£�������ѡ��");
									return false;
								}
							}
						}catch(Exception e){}
					}
				}
			}
		}
		return super.destroyWindow();
	}
	
}
