/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.Color;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.ChannelTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.SaleF7;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CustomerProfitRptFilterUI extends AbstractCustomerProfitRptFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(CustomerProfitRptFilterUI.class);
    
    /**
     * output class constructor
     */
    public CustomerProfitRptFilterUI() throws Exception
    {
        super();
        this.setUITitle("�ͻ����������");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    


    @Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams pp = new RptParams();	
		String cuId=null;
		String saleGroupID = null;
		String salePersonID = null;
		String customerId=null;
		String channelTypeID = null;
		
		if(this.prmtCompany.getValue()!=null){
			cuId=((SaleOrgUnitInfo)this.prmtCompany.getValue()).getId().toString();
		}else{
//			MsgBox.showWarning("��ѡ��������֯��");
//			SysUtil.abort();
		}
		
		if(this.prmtSaleGroup.getValue() != null){
			saleGroupID = ((SaleGroupInfo)this.prmtSaleGroup.getValue()).getId().toString();
		}
		
		if(this.prmtSalePerson.getValue() != null){
			salePersonID = ((PersonInfo)this.prmtSalePerson.getValue()).getId().toString();
		}
		
		if(this.prmtCustomer.getValue()!=null) {
			customerId=((CustomerInfo)this.prmtCustomer.getValue()).getId().toString();
		}
		
		if(this.prmtChannelType.getValue() != null){
			channelTypeID=((ChannelTypeInfo)this.prmtChannelType.getValue()).getId().toString();
		}
//		pp.setObject("companyID",this.prmtCompany.getValue());
		pp.setString("customerID", customerId);
		pp.setString("companyID",cuId);
		pp.setString("saleGroupID", saleGroupID);
		pp.setString("salePersonID", salePersonID);
		pp.setString("channelTypeID", channelTypeID);
		Date beginDate = dpBeginDate.getSqlDate() ;
		Date endDate = dpEndDate.getSqlDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(beginDate != null){
			pp.setString("beginDate", sdf.format(beginDate));
		}else{
			MsgBox.showWarning("��ѡ��ʼ���ڣ�");
			SysUtil.abort();
		}
		
		if(endDate != null){
			pp.setString("endDate", sdf.format(endDate));
		}else{
			MsgBox.showWarning("��ѡ��ʼ���ڣ�");
			SysUtil.abort();
		}
		
		
		return pp;
	}

	@Override
	public void onInit(RptParams arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomCondition(RptParams params) {
		// TODO Auto-generated method stub
//		this.prmtCompany.setData(params.getObject("CU"));
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setF7();
	}
	public void setF7() throws Exception {
//		CompanyF7 org = new CompanyF7(this);
//		org.disablePerm();
//		org.setIsCUFilter(false);
//		this.prmtCompany.setSelector(org);
//		this.prmtCompany.setData(SysContext.getSysContext().getCurrentCompany());
		String cuId=SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
        this.prmtCompany.setVisible(true);		
        this.prmtCompany.setEditable(true);		
        this.prmtCompany.setEnabled(true);	
        this.prmtCompany.setDisplayFormat("$name$");		
        this.prmtCompany.setEditFormat("$number$");		
        this.prmtCompany.setCommitFormat("$number$");		
        this.prmtCompany.setRequired(false);
		SaleOrgUnitInfo saleOrgInfo = SysContext.getSysContext().getCurrentSaleUnit(); 
		
		SaleF7 sf7=new SaleF7();
		this.prmtCompany.setSelector(sf7);
		
		this.prmtCompany.setValue(saleOrgInfo);
		 // ������֯�����Ժ�  ���������� ��Ӧ��ѯ������
	     DataChangeListener prmtsaleOrgUnitListener = new DataChangeListener() {
	       public void dataChanged(DataChangeEvent e) {
	         try {
	        	 setSaleGroupF7();
	         } catch (Exception exc) {
	          exc.printStackTrace();
	         }
	         finally
	         {
	         }
	       }
	     };
	     prmtCompany.addDataChangeListener(prmtsaleOrgUnitListener);
        // ������   ����Ա 
        
        this.prmtSaleGroup.setVisible(true);		
        this.prmtSaleGroup.setEditable(true);		
        this.prmtSaleGroup.setDisplayFormat("$name$");		
        this.prmtSaleGroup.setEditFormat("$number$");		
        this.prmtSaleGroup.setCommitFormat("$number$");		
        
        this.prmtSaleGroup.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SaleGroupQuery");
	     this.prmtSaleGroup.setEditable(true);
	     this.prmtSaleGroup.setDisplayFormat("$name$");
	     this.prmtSaleGroup.setEditFormat("$number$");
	     this.prmtSaleGroup.setCommitFormat("$number$");
	    
	     
	     this.prmtSaleGroup.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SaleGroupQuery");
	     this.prmtSaleGroup.setEditable(true);
	     this.prmtSaleGroup.setDisplayFormat("$name$");
	     this.prmtSaleGroup.setEditFormat("$number$");
	     this.prmtSaleGroup.setCommitFormat("$number$");
	     
	     
	     this.prmtSalePerson.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7PersonQuery");		
        //this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
        this.prmtSalePerson.setCommitFormat("$number$");		
        this.prmtSalePerson.setEditFormat("$number$");		
        this.prmtSalePerson.setDisplayFormat("$name$");		
        this.prmtSalePerson.setEditable(true);		
        this.prmtSalePerson.setRequired(false);
	       
		
        this.prmtChannelType.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ChannelTypeQuery");		
        this.prmtChannelType.setEditable(true);		
        this.prmtChannelType.setDisplayFormat("$name$");		
        this.prmtChannelType.setEditFormat("$number$");		
        this.prmtChannelType.setCommitFormat("$number$");		
        this.prmtChannelType.setRequired(false);
        
        
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		// ��Ӳ�����֯����
		filterInfo.getFilterItems().add(new FilterItemInfo("saleOrgUnit.id", saleOrgInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
	    // ����F7��ѯԪ����
		String queryInfo = QueryInfoConstants.CUSTOMER_SALE_STANDARD;
		// ������ҵ����֯
	    prmtCustomer.setCurrentMainBizOrgUnit(saleOrgInfo, OrgType.Sale);
		// ���ÿͻ�F7�Ĺ�������
	    prmtCustomer.setEntityViewInfo(evi);
	    prmtCustomer.setCommitFormat("$number$");// �ύ��ʽ
	    prmtCustomer.setDisplayFormat("$number$");//��ʾ��ʽ
	    prmtCustomer.setEditFormat("$number$");//�༭��ʽ
	    prmtCustomer.setEnabledMultiSelection(false);
		// ���ÿͻ�F7չ����ʽΪ�����ұ�
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtCustomer,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"saleOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(false);
		prmtCustomer.setSelector(selectorAdaptor);
		prmtCustomer.addSelectorListener(selectorAdaptor);
		
		
		Date nowDate = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DATE, 1);
		
		dpBeginDate.setValue(cal.getTime());
		dpBeginDate.setRequired(true);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		dpEndDate.setValue(cal.getTime());
		dpEndDate.setRequired(true);
		
		setSaleGroupF7();
	}
	
	
	 /**
     * �������µ�������֯  ����������ĺ�ѡ��
     */
    public void setSaleGroupF7()
    {
      SaleOrgUnitInfo saleOrgUnitInfo = (SaleOrgUnitInfo)this.prmtCompany.getValue();
      if (saleOrgUnitInfo != null)
      {
        EntityViewInfo viewInfo = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("saleOrg.id", saleOrgUnitInfo.getId().toString(), CompareType.EQUALS));
        viewInfo.setFilter(filter);
        this.prmtSaleGroup.setEntityViewInfo(viewInfo);
        this.prmtSaleGroup.setEnabled(true);
        
        EntityViewInfo ev = new EntityViewInfo();
        FilterInfo filter1 = new FilterInfo();
        filter1.getFilterItems().add(new FilterItemInfo("SaleOrgUnit.id", saleOrgUnitInfo.getId().toString(), CompareType.EQUALS));
        ev.setFilter(filter1);
        this.prmtSalePerson.setEntityViewInfo(ev);
        this.prmtSalePerson.setEnabled(true);
        
      } else {
    	  this.prmtSalePerson.setEnabled(false);
        this.prmtSaleGroup.setEnabled(false);
      }
    }
}