/**
 * output package name
 */
package com.kingdee.eas.custom.rpt.client;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.client.AddressF7UI;
import com.kingdee.eas.basedata.org.client.f7.TransportF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DeliveryAnalyzeQueryUI extends AbstractDeliveryAnalyzeQueryUI
{
    private static final Logger logger = CoreUIObject.getLogger(DeliveryAnalyzeQueryUI.class);
    
    /**
     * output class constructor
     */
    public DeliveryAnalyzeQueryUI() throws Exception
    {
        super();
        initControl();
    }

    /**
     *初始化控件
     * @throws Exception 
     */
	private void initControl() throws Exception {
		TransportF7 f7=new TransportF7();
		f7.setIsCUFilter(true);
		this.prmtCompany.setSelector(f7);
		this.prmtCompany.setValue(SysContext.getSysContext().getCurrentTransportUnit());
		this.prmtCompany.setRequired(true);
		
		this.prmtBeginStation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AddressQuery");
		this.prmtBeginStation.setDisplayFormat("$name$");
		this.prmtBeginStation.setEditFormat("$number$");
		this.prmtBeginStation.setCommitFormat("$id$");
		
		this.prmtEndStation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AddressQuery");
		this.prmtEndStation.setDisplayFormat("$name$");
		this.prmtEndStation.setEditFormat("$number$");
		this.prmtEndStation.setCommitFormat("$id$");
		
	}

	@Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams params=new RptParams();
		String companyID=null,beginStationID=null,endStationID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtBeginStation.getValue()!=null) {
			beginStationID=((CoreBaseInfo) this.prmtBeginStation.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("起点不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtEndStation.getValue()!=null) {
			endStationID=((CoreBaseInfo) this.prmtEndStation.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("终点不能为空！ ");
			SysUtil.abort();
		}
		params.setString("companyID", companyID);
		params.setString("beginStationID", beginStationID);
		params.setString("endStationID", endStationID);
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