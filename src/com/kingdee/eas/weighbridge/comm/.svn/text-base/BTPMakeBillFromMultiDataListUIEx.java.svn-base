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
		//过榜单判断所选物料是否一致
		CoreBillBaseCollection srcBillCollection = this.getSrcBillCollection();
		CoreBaseInfo ob, obEntry;
		String stdSCMObject="",SCMObject="", stdMaterialID="",materialID="",bosType="";
		String showtxt="";
		ICoreBase ise=null,is=null;
		if(srcBillCollection!=null&&srcBillCollection.size()>1) {//当选择的记录大于1条是再进行判断
//			MsgBox.showWarning("暂不支持多记录业务！");
//			return false;
		}
		if(srcBillCollection!=null&&srcBillCollection.size()>1) {//当选择的记录大于1条是再进行判断
			for(int i=0;i<srcBillCollection.size();i++) {
				ob = srcBillCollection.get(i);
				if(ob instanceof SCMBillBaseInfo) {//供应链基本单据
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
								showtxt="客户";
								SCMObject=ob.getObjectValue("customer").getString("id");
							}
							else if(ob instanceof PurOrderInfo) {
								showtxt="供应商";
								SCMObject=ob.getObjectValue("supplier").getString("id");
							}
							if(StringUtils.isBlank(stdSCMObject)) {
								stdSCMObject=SCMObject;
							}else {
								if(!SCMObject.equalsIgnoreCase(stdSCMObject)) {
									MsgBox.showWarning("所选单据"+showtxt+"不一致，请重新选择！");
									return false;
								}
							}
							obEntry=ise.getValue(new ObjectUuidPK(((IObjectCollection)ob.get("entries")).getObject(j).getString("id")));
							if(obEntry.getObjectValue("material")!=null) //物料肯定不为空
								materialID=obEntry.getObjectValue("material").getString("id");
							if(StringUtils.isBlank(stdMaterialID)) {
								stdMaterialID=materialID;
							}else {
								if(!materialID.equalsIgnoreCase(stdMaterialID)) {
									MsgBox.showWarning("所选单据物料不一致，请重新选择！");
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
