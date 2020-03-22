/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherFactory;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo;
import com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacade;
import com.kingdee.eas.fi.gl.Voucher;
import com.kingdee.eas.fi.gl.VoucherFactory;
import com.kingdee.eas.fi.gl.VoucherInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.portal.common.util.DateUtil;

/**
 * output class name
 */
public class SwitchToVoucher extends AbstractSwitchToVoucher
{
	private static final Logger logger = CoreUIObject.getLogger(SwitchToVoucher.class);

	//定义一个模板的info，保存来源界面的info
	SalaryVoucherInfo svInfo=null;

	String voucherCode="";
	
	String VoucherInfoID="";
	/**
	 * output class constructor
	 */
	public SwitchToVoucher() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		viewVoucher.setVisible(false);

		//获得来源单据的info
		if(this.getUIContext().get("srcBillID")!=null&&!this.getUIContext().get("srcBillID").equals("")){
			String srcBillID = (String) this.getUIContext().get("srcBillID");
			svInfo = SalaryVoucherFactory.getRemoteInstance().getSalaryVoucherInfo(new ObjectUuidPK(srcBillID));
		}

		//会计期间
		kDBizPromptBox1.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");
		kDBizPromptBox1.setEditable(true);		
		kDBizPromptBox1.setDisplayFormat("$name$");		
		kDBizPromptBox1.setEditFormat("$number$");		
		kDBizPromptBox1.setCommitFormat("$number$");		
		kDBizPromptBox1.setRequired(true);
	}

	@Override
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void toVoucher_actionPerforme(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kDBizPromptBox1.getValue()==null){
			MsgBox.showInfo("期间字段为空");
			SysUtil.abort();
		}
		PeriodInfo periodInfo = (PeriodInfo)kDBizPromptBox1.getValue();
		
		
		String[] con = getSHRDbConnection();
		
		String[] ss=com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().createSalaryVoucher(periodInfo, svInfo,con);
		
		voucherCode=ss[1];
		if(ss[0]!=null&&ss[0].indexOf("成功")>=0){
			MsgBox.showInfo(ss[0]+ss[1]);
			viewVoucher.setVisible(true);
			VoucherInfoID=getVoucherIDByNumber(voucherCode);
		}
		else{
			MsgBox.showInfo("未找到当前期间的薪酬发放数据,请检查薪酬数据是否存在或者对应关系设置是否正确");
		    return;
		}
		super.toVoucher_actionPerforme(e);
	}

private String[] getSHRDbConnection() {
		// TODO Auto-generated method stub
	String [] con=new String[5];
	String str="select * from T_SAL_ConnectServer where FStatus=3";
	IRowSet rs;
	try {
		rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
		if(rs.next()){
			con[0]=rs.getString("FIP");
			con[1]=rs.getString("FPort");
			con[2]=rs.getString("FDataBaseName");
			con[3]=rs.getString("FUserName");
			con[4]=rs.getString("FUserPassWord");
			if(!com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getConnection(con)){
				MsgBox.showInfo("数据库连接配置错误");
				SysUtil.abort();
			}
		}
	} catch (BOSException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		return con;
	}

//	private int[] getActPeriod(PeriodInfo periodInfo) {
//		// TODO Auto-generated method stub
//		
//		int[] actPeriod=new int [2];
//		
//				actPeriod[0] = periodInfo.getPeriodYear();
//				actPeriod[1] = periodInfo.getPeriodNumber();
//				
//				if(svInfo.getPeriodDeviationValue()!=0){
//					int value = svInfo.getPeriodDeviationValue();
//					if((value+actPeriod[1])>12)
//					{
//						actPeriod[0]+=1;
//						actPeriod[1]=(value+actPeriod[1])-12;
//					}
//					else if((value+actPeriod[1])<1){
//						actPeriod[0]-=1;
//						actPeriod[1]=12+(value+actPeriod[1]);
//					}
//					else
//						actPeriod[1]+=svInfo.getPeriodDeviationValue();
//						
//				}
//		return actPeriod;
//	}

	@Override
	protected void viewVoucher_actionPerforme(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub		

		
		String destBillEditUIClassName ="com.kingdee.eas.fi.gl.client.VoucherEditUI";
		Map map = new UIContext(this);
		map.put("ID",VoucherInfoID);
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(destBillEditUIClassName, map, null,OprtState.VIEW);
		//开始展现 UI
		uiWindow.show();
		super.viewVoucher_actionPerforme(e);
	}

	/**
	 * 根据凭证编码获得ID
	 */
	private String getVoucherIDByNumber(String number) {
		// TODO Auto-generated method stub
		String str = "select * from T_GL_Voucher where fnumber='"+number+"'";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.next()){
				return rs.getString("fid");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}