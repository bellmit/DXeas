/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.complaintvisit.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;

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
import com.kingdee.bos.dao.xml.impl.AbstractMDValue;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.org.PositionMemberFactory;
import com.kingdee.eas.basedata.org.PositionMemberInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class ComplainBillEditUI extends AbstractComplainBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ComplainBillEditUI.class);
    
    /**
     * output class constructor
     */
    public ComplainBillEditUI() throws Exception
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
		/*prmtcustomer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtcustomer.getValue()!=null){
					EntityViewInfo ev2=new EntityViewInfo();
					FilterInfo filter2=new FilterInfo();
					String customerID =  ((IPropertyContainer) prmtcustomer.getValue()).getString("id");
					String sql = "select FID from T_SD_SaleOrder where FOrderCustomerID = '"+customerID+"'";
					filter2.getFilterItems().add(new FilterItemInfo("complainNumber.id",sql,CompareType.INNER));
					ev2.setFilter(filter2);
					prmtcomplainNumber.setEntityViewInfo(ev2);
				}else{
					EntityViewInfo ev2=new EntityViewInfo();
					FilterInfo filter2=new FilterInfo();
					filter2.getFilterItems().add(new FilterItemInfo("complainNumber.id","5haha",CompareType.INNER));
					ev2.setFilter(filter2);
					prmtcomplainNumber.setEntityViewInfo(ev2);
				}
			}
			
		});*/
		
		
		
		
		
		
		kdtEntry.addKDTEditListener(new KDTEditListener(){
			public void editCanceled(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void editStarted(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void editStarting(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				dataChange();
			}
			public void editStopping(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void editValueChanged(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		prmtcomplainNumber.setQueryInfo("com.kingdee.eas.custom.taihe.complaintvisit.app.F7SaleOrderForQuery");
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
    	filter.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id",companyID,CompareType.EQUALS));
		ev.setFilter(filter);
		prmtcomplainNumber.setEntityViewInfo(ev);
    }
    
    
    private void dataChange(){
    	for(int i=0;i<kdtEntry.getRowCount();i++){
    		if(kdtEntry.getRow(i).getCell("liabilityPerson").getValue()!=null){
    			String personid = ((IPropertyContainer) kdtEntry.getRow(i).getCell("liabilityPerson").getValue()).getString("id");
    			try {
					PersonInfo info = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
					StringBuffer sql = new StringBuffer();
					sql.append("select t2.FID FID from ") 
					.append("		T_ORG_PositionMember 			t1 ") 
					.append("		inner join T_ORG_Position			t2	on t2.FID = t1.FPositionID ") 
					.append("		where t1.FPersonID = '")
					.append(personid).append("'");
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
					if(rs.next()){
						PositionInfo pmInfo = PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(rs.getString("FID")));
						kdtEntry.getRow(i).getCell("Department").setValue(pmInfo);
					}else{
						kdtEntry.getRow(i).getCell("Department").setValue(null);
					}
					
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }
	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo objectValue = new com.kingdee.eas.custom.taihe.complaintvisit.ComplainBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}