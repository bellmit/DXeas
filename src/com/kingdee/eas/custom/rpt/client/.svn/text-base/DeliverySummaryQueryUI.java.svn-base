/**
 * output package name
 */
package com.kingdee.eas.custom.rpt.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.TransportF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DeliverySummaryQueryUI extends AbstractDeliverySummaryQueryUI
{
    private static final Logger logger = CoreUIObject.getLogger(DeliverySummaryQueryUI.class);
    
    /**
     * output class constructor
     */
    public DeliverySummaryQueryUI() throws Exception
    {
        super();
        initControl();
    }
    /**
     *初始化控件
     */
	private void initControl() {
		TransportF7 f7=new TransportF7();
		if(!SysContext.getSysContext().getCurrentCtrlUnit().getString("id").equals("00000000-0000-0000-0000-000000000000CCE7AED4")) 
			f7.setIsCUFilter(true);
		this.prmtCompany.setSelector(f7);
		this.prmtCompany.setValue(SysContext.getSysContext().getCurrentTransportUnit());
		this.prmtCompany.setRequired(true);
		
		this.prmtSendLine.setQueryInfo("com.kingdee.eas.scm.im.dt.client.F7DeliveryLineQuery");
		this.prmtSendLine.setDisplayFormat("$name$");
		this.prmtSendLine.setCommitFormat("$number$");
		this.prmtSendLine.setEditFormat("$number$");
		
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		
	}

	@Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams params=new RptParams();
		String companyID=null,sendLineID=null,beginDate=null,endDate=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtSendLine.getValue()!=null) {
			sendLineID=((CoreBaseInfo) this.prmtSendLine.getValue()).getId().toString();
		}
		beginDate=this.dpBeginDate.getText();
		endDate=this.dpEndDate.getText();
		params.setString("companyID", companyID);
		params.setString("sendLineID", sendLineID);
		params.setString("beginDate",beginDate);
		params.setString("endDate",endDate);
		return params;
	}

	@Override
	public void onInit(RptParams params) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomCondition(RptParams arg0) {
		// TODO Auto-generated method stub
		
	}

}