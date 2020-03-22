/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.complaintvisit.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.fi.ar.OtherBillInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class VisitBillEditUI extends AbstractVisitBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(VisitBillEditUI.class);
    
    /**
     * output class constructor
     */
    public VisitBillEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
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
		prmtreceivableNum.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				try {
					if(prmtreceivableNum.getValue()!=null){
						OtherBillInfo info = OtherBillFactory.getRemoteInstance().getOtherBillInfo(new ObjectUuidPK(((IPropertyContainer) prmtreceivableNum.getValue()).getString("id")));
						
						if(info.getPerson()!=null){
							PersonInfo personInfo  = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(info.getPerson().getId()));
							prmtsalesMan.setValue(personInfo);
						}else{
							prmtsalesMan.setValue(null);
						}
						
					}else{
						prmtsalesMan.setValue(null);
					}
					
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		prmtcunstomer.addChangeListener(new ChangeListener(){
			
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				try {
					if(prmtcompany.getValue()!=null){
						CustomerInfo customerinfo  = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(((IPropertyContainer) prmtcunstomer.getValue()).getString("id")));
						StringBuffer sql = new StringBuffer();
						sql.append("select t2.FCONTACTperson	personName,t2.FMobile	personNum  from ")
						.append("T_BD_CustomerSaleInfo				t1 ")
						.append("left join T_BD_CustomerLinkMan			t2	on	t2.FCustomerSaleID = t1.FID ")
						.append("where t1.FCustomerID = '")
						.append(customerinfo.getId())
						.append("'	and t1.FControlunitID = '")
						.append(((IPropertyContainer) prmtcompany.getValue()).getString("id"))		
						.append("'");
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
						if(rs.next()){
							txtcustomerContacts.setText(rs.getString("personName"));
							txtcustomerTelephone.setText(rs.getString("personNum"));
						}else{
							txtcustomerContacts.setText(null);
							txtcustomerTelephone.setText(null);
						}
					}else{
						prmtcunstomer.setValue(null);
						MsgBox.showInfo("请先选择回收公司！");
					}
					
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		prmtreceivableNum.setQueryInfo("com.kingdee.eas.fi.ar.app.F7OtherBillQuery");
		
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				prmtCompany_changed();
			}});
		prmtCompany_changed();
	}
    
    private void prmtCompany_changed() {
    	String companyID="123";
    	if(prmtcompany.getValue()!=null) {
    		companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
    	}
    	
    	EntityViewInfo ev=new EntityViewInfo();
    	FilterInfo filter=new FilterInfo();
    	filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		ev.setFilter(filter);
		prmtreceivableNum.setEntityViewInfo(ev);
    }
    
    
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.complaintvisit.VisitBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.complaintvisit.VisitBillInfo objectValue = new com.kingdee.eas.custom.taihe.complaintvisit.VisitBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}