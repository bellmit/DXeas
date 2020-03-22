package com.kingdee.eas.custom.salediscount.rpt.client;

import java.util.Date;
import java.util.HashMap;

import com.kingdee.eas.basedata.master.auxacct.AsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeSysEnum;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.client.PersonF7UI;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.fi.arap.client.util.ArApBillUIUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
//��Ʒ������
public class AreaEmpCFilterUI extends AbstractAreaEmpCFilterUI {

	public AreaEmpCFilterUI() throws Exception {
		super();
		// TODO �Զ����ɹ��캯�����
	}
	public void onLoad() throws Exception {
		super.onLoad();
		this.SetPrmtF7();
		String FCUID;
		FCUID = SysContext.getSysContext().getCurrentFIUnit().getId()
				.toString();
		if (FCUID.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("��ǰ��˾Ϊ���壬������ʹ�øù��ܡ���ѡ��ʵ�幫˾��");
			SysUtil.abort();
		}
	}
    /**
     * ����F7
     */
    public void SetPrmtF7()throws Exception{
    	
    	//��˾
		CompanyF7 org = new CompanyF7(this);
		org.disablePerm();
		org.setIsCUFilter(true);
		this.prmtCompany.setSelector(org);
		this.prmtCompany.setData(SysContext.getSysContext().getCurrentCompany());
		
		//ҵ��Ա
		HashMap map = new HashMap();
		map.put(PersonF7UI.ALL_ADMIN, "YES");
		
		this.prmtBeginEmp.setSelector(new PersonPromptBox(this, map));
		prmtBeginEmp.setEditable(true);
		prmtBeginEmp.setDisplayFormat("$name$");
		prmtBeginEmp.setEditFormat("$number$");
		prmtBeginEmp.setCommitFormat("$number$");
		this.prmtEndEmp.setSelector(new PersonPromptBox(this, map));
		prmtEndEmp.setEditable(true);
		prmtEndEmp.setDisplayFormat("$name$");
		prmtEndEmp.setEditFormat("$number$");
		prmtEndEmp.setCommitFormat("$number$");
		
		//�ͻ�
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		AsstActTypeInfo	asstActTypeInfo= AsstActTypeFactory.getRemoteInstance().getAsstActType(AsstActTypeSysEnum.CUSTOMER);
		ArApBillUIUtil.setAsstActSelector(this,prmtBeginCustomer,asstActTypeInfo);
		this.prmtBeginCustomer.setCommitFormat("$name$");
		this.prmtBeginCustomer.setEnabledMultiSelection(false);
		
		ArApBillUIUtil.setAsstActSelector(this,prmtEndCustomer,asstActTypeInfo);
		this.prmtEndCustomer.setCommitFormat("$name$");
		this.prmtEndCustomer.setEnabledMultiSelection(false);
		
		this.cmbLevel.setVisible(true);
	    //this.cmbLevel.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.lhzr.Level").toArray());
	    //this.cmbLevel.setRequired(false);
	    //this.cmbLevel.setEnabled(true);
		this.cmbLevel.addItem("0");
	    this.cmbLevel.addItem("1");
	    this.cmbLevel.addItem("2");
	    this.cmbLevel.addItem("3");
	    this.cmbLevel.addItem("4");
	    this.cmbLevel.setForeground(new java.awt.Color(0,0,0));
		
	    this.cmbLevelA.addItem("3");
	    this.cmbLevelA.addItem("2");
	    this.cmbLevelA.addItem("1");	    
	    this.cmbLevelA.setRequired(false);
	    this.cmbLevelA.setEnabled(true);
	    this.cmbLevelA.setForeground(new java.awt.Color(0,0,0));
	    this.cmbLevelA.setVisible(false);
	    this.kDLabelContainer11.setVisible(false);
	    Date today = null;
		try {
			today = SCMClientUtils.getServerDate();
		} catch (Exception e) {
			super.handUIException(e);
			//e.printStackTrace();
		}
	    //	  ���¿�ʼ����
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setValue(today);
		
		//���½�ֹ����
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setValue(today);
	    
		this.rbtnSaleOrder.setSelected(true);
    }
	public boolean verify() {
		if(this.prmtCompany.getData()==null){
			MsgBox.showWarning("��ѡ��˾��");
			SysUtil.abort();
		}
		
		if(this.prmtBeginEmp.getData()==null){
			if(this.prmtEndEmp.getData()!=null){
				MsgBox.showWarning("��ѡ����ʼְԱ��");
				SysUtil.abort();
			}
		}else{
			if(this.prmtEndEmp.getData()==null){
				MsgBox.showWarning("��ѡ���ְֹԱ��");
				SysUtil.abort();
			}
		}
		
		if(this.prmtBeginCustomer.getData()==null){
			if(this.prmtEndCustomer.getData()!=null){
				MsgBox.showWarning("��ѡ����ʼ�ͻ���");
				SysUtil.abort();
			}
		}else{
			if(this.prmtEndCustomer.getData()==null){
				MsgBox.showWarning("��ѡ���ֹ�ͻ���");
				SysUtil.abort();
			}
		}
		if(this.chkisArea.getSelected()==16&&this.chkisEmp.getSelected()==16){
			if(this.chkisCustom.getSelected()==16){
					MsgBox.showWarning("������ѡ��һ����ʾ���");
					SysUtil.abort();
			}
		}
		return true;
	}
	public void onInit(RptParams arg0) throws Exception {
		//ktTitle.setText("��ʼ������:"+initParams.getString("title"));

	}

	public RptParams getCustomCondition() {
		RptParams pp = new RptParams();	
		String FCUID="";
		if(this.prmtCompany.getData()!=null){
			FCUID=((OrgUnitInfo)this.prmtCompany.getData()).getId().toString() ;
		}else{
			MsgBox.showWarning("��ѡ��˾��");
			SysUtil.abort();
		}
		
		pp.setString("FCUID",FCUID);
		
		pp.setInt("FisArea",this.chkisArea.getSelected());
		pp.setInt("FisEmp",this.chkisEmp.getSelected());
		pp.setInt("FisCustomer",this.chkisCustom.getSelected());
		
		//Ԥ����
		pp.setInt("Fisyhl",this.chkisyhl.getSelected());
		
		pp.setInt("FLevel",this.cmbLevel.getSelectedIndex());
		pp.setInt("FLevelA",Integer.parseInt(this.cmbLevelA.getSelectedItem().toString()));
		
		pp.setBoolean("FisSaleOrder",this.rbtnSaleOrder.isSelected());
		pp.setBoolean("FisSaleIssue",this.rbtnSaleIssue.isSelected());
		pp.setBoolean("FisOtherBill",this.rbtnOtherBill.isSelected());
		
		pp.setObject("FOrgUnitInfo",this.prmtCompany.getData());
		
		//ҵ��Ա
		pp.setObject("FBeginEmp",this.prmtBeginEmp.getData());
		pp.setObject("FEndEmp",this.prmtEndEmp.getData());
		//�ͻ�
		pp.setObject("FBeginCustomer",this.prmtBeginCustomer.getData());
		pp.setObject("FEndCustomer",this.prmtEndCustomer.getData());
		
		pp.setString("FdpBeginDate",this.dpBeginDate.getText().toString());
		pp.setString("FdpEndDate",this.dpEndDate.getText().toString());
		return pp;
	}

	public void setCustomCondition(RptParams params) {
		this.prmtCompany.setData(params.getObject("FOrgUnitInfo"));
		//ҵ��Ա
		this.prmtBeginEmp.setData(params.getObject("FBeginEmp"));
		this.prmtEndEmp.setData(params.getObject("FEndEmp"));
		//�ͻ�
		this.prmtBeginCustomer.setData(params.getObject("FBeginCustomer"));
		this.prmtEndCustomer.setData(params.getObject("FEndCustomer"));

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɷ������

	}
}
