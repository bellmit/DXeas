/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.EntryFilterType;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class AttendanceBillEditUI extends AbstractAttendanceBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AttendanceBillEditUI.class);
    
    /**
     * output class constructor
     */
    public AttendanceBillEditUI() throws Exception
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

    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		initUI();
		kdtEntry.addKDTEditListener(new KDTEditListener(){
			public void editCanceled(KDTEditEvent arg0) {
			}
			public void editStarted(KDTEditEvent arg0) {
			}
			public void editStarting(KDTEditEvent arg0) {
			}
			public void editStopped(KDTEditEvent arg0) {
				int row  = arg0.getRowIndex();
				for(int i= 0;i<kdtEntry.getRowCount();i++){
					if(kdtEntry.getRow(i).getCell("personRatio").getValue()!=null){
						BigDecimal a= getBigDecimal(kdtEntry.getRow(i).getCell("personRatio").getValue());
						if(a.compareTo(new BigDecimal(1))>0){
							kdtEntry.getRow(i).getCell("personRatio").setValue("1");
						}
					}
				}
				if(kdtEntry.getRow(row).getCell("personNum").getValue()!=null){
					//��ȡʱ����ַ�����ʽ
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = (Date) pkBizDate.getValue();
					String dateString = formatter.format(date);
					//��ȡpersonID
					PersonInfo info = (PersonInfo) kdtEntry.getRow(row).getCell("personNum").getValue();
					
					String personID = info.getId().toString();
					int classint = classes.getSelectedIndex();
					//����sql��ѯ�����Ա���Ƿ����ϸ�  ������ ����Ҫ�޸�
					StringBuffer sb = new StringBuffer();
					String sp = "\n";
					sb.append("/*dialect*/").append(sp);
					sb.append("select t2.* from ").append(sp);
					sb.append("CT_WAG_AttendanceBill 		t1").append(sp);
					sb.append("inner join CT_WAG_AttendanceBillentry	t2	on t2.FParentID = t1.FID").append(sp);
					sb.append("where to_char(t1.fBizDate,'yyyy-MM-dd') = '").append(dateString).append("' and CFClassES = '").append(classint).append("'  and t2.CFPersonNumID = '").append(personID).append("'").append(sp);
					IRowSet rs;
					try {
						rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
						if(rs.next()){
							MsgBox.showWarning(info.getName()+"Ա�����ϸ�,�������ظ��ϸ�");
						}
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			public void editStopping(KDTEditEvent arg0) {
			}
			public void editValueChanged(KDTEditEvent arg0) {
			}
		});
		prmttheGroup.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit();
				kdtEntry.removeRows();
				if(prmttheGroup.getValue()!=null&&prmtcompany.getValue()!=null){
					String theGroupID = ((IPropertyContainer) prmttheGroup.getValue()).getString("id");
					String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("id");
					getAllPersonID(companyID,theGroupID);
//				 	//��¼F7��ӹ���
//				 	//Post
				    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntry.getColumn("personPost").getEditor().getComponent(); // ��ԱF7  
				    EntityViewInfo view1 = new EntityViewInfo(); // �¶�����ͼ  
				    FilterInfo filter1 = new FilterInfo(); // ���ù�������  
				    filter1.getFilterItems().add(new FilterItemInfo("company.id", company.getId().toString()+"%",CompareType.LIKE)); // ���յ�ǰ��λ�Ǽǹ���  
				    String theGroupName = ((IPropertyContainer) prmttheGroup.getValue()).getString("Name");
				    if(theGroupName!=null){
				    	filter1.getFilterItems().add(new FilterItemInfo("theGroup.name", "%"+theGroupName+"%",CompareType.LIKE)); // ���յ�ǰ�������  
				    	filter1.setMaskString("#0 and #1");
				    }
				    view1.setFilter(filter1); // ���ù�������  
				    prmtPost.setEntityViewInfo(view1); // �����趨��ͼ  
				    //prmtHfPerson.setEnabledMultiSelection(true); //F7��ѡ  
				}else{
					kdtEntry.removeRows();
				}
				
			}
			
		});
	}
  //object ת bigdecimal
	public static BigDecimal getBigDecimal( Object value ) {  
        BigDecimal ret = null;  
        if( value != null ) {  
            if( value instanceof BigDecimal ) {  
                ret = (BigDecimal) value;  
            } else if( value instanceof String ) {  
                ret = new BigDecimal( (String) value );  
            } else if( value instanceof BigInteger ) {  
                ret = new BigDecimal( (BigInteger) value );  
            } else if( value instanceof Number ) {  
                ret = new BigDecimal( ((Number)value).doubleValue() );  
            } else {  
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");  
            }  
        }  
        return ret;  
    }  
    private void initUI() {
//	 	//��ͷF7��ӹ���
//	 	//theGroup
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo view = new EntityViewInfo();  
	    FilterInfo filter = new FilterInfo(); //��������  
	    filter.getFilterItems().add(new FilterItemInfo("Number", company.getNumber()+"%",CompareType.LIKE)); //����1��#0  
	    view.setFilter(filter);  
	    prmttheGroup.setEntityViewInfo(view); //F7�����趨��ͼ  

	    
//	 	//Person
	    KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntry.getColumn("personNum").getEditor().getComponent(); // ��ԱF7  
	    EntityViewInfo view2 = new EntityViewInfo(); // �¶�����ͼ  
	    FilterInfo filter2 = new FilterInfo(); // ���ù�������  
	    filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // ���յ�ǰ��λ�Ǽǹ���  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // �������״̬ɸѡ����  
	    view2.setFilter(filter2); // ���ù�������  
	    prmtPerson.setEntityViewInfo(view2); // �����趨��ͼ  
	    //prmtHfPerson.setEnabledMultiSelection(true); //F7��ѡ  
	    
	    if(prmttheGroup.getValue()!=null&&prmtcompany.getValue()!=null){
			String theGroupID = ((IPropertyContainer) prmttheGroup.getValue()).getString("id");
			String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("id");
//		 	//��¼F7��ӹ���
//		 	//Post
		    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntry.getColumn("personPost").getEditor().getComponent(); // ��ԱF7  
		    EntityViewInfo view1 = new EntityViewInfo(); // �¶�����ͼ  
		    FilterInfo filter1 = new FilterInfo(); // ���ù�������  
		    filter1.getFilterItems().add(new FilterItemInfo("company.id", company.getId().toString()+"%",CompareType.LIKE)); // ���յ�ǰ��λ�Ǽǹ���  
		    String theGroupName = ((IPropertyContainer) prmttheGroup.getValue()).getString("Name");
		    if(theGroupName!=null){
		    	filter1.getFilterItems().add(new FilterItemInfo("theGroup.name", "%"+theGroupName+"%",CompareType.LIKE)); // ���յ�ǰ�������  
		    	filter1.setMaskString("#0 and #1");
		    }
		    view1.setFilter(filter1); // ���ù�������  
		    prmtPost.setEntityViewInfo(view1); // �����趨��ͼ  
		    //prmtHfPerson.setEnabledMultiSelection(true); //F7��ѡ  
		}
	    
	    
    }
	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.AttendanceBillFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.wages.AttendanceBillInfo objectValue = new com.kingdee.eas.custom.wages.AttendanceBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizDate(new Date());
        return objectValue;
    }
    //��ȡ�����û�
    private void getAllPersonID(String companyID,String theGroupID){
    	StringBuffer sb = new StringBuffer();
    	//��ȡʱ����ַ�����ʽ
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) pkBizDate.getValue();
		String dateString = formatter.format(date);
    	String sp = "\n";
    	sb.append("select t2.CFPersonid personID from  ").append(sp);
    	sb.append("CT_WAG_BasicPost 				t1").append(sp);
    	sb.append("inner join CT_WAG_BasicPostEntry 		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("where t1.CFCompanyID = '").append(companyID).append("' and t1.CFtheGroupID= '").append(theGroupID).append("'  and (t2.CFIsQuit is null or  t2.CFIsQuit = 0)").append(sp);
    	sb.append("order by CFPostName");
    	try {
    		System.out.println(sb);
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next()){
				
				PersonInfo info = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("personID")));
				//yumingxu ��λ�ظ���У��
				String personID = info.getId().toString();
				int classint = classes.getSelectedIndex();
				//����sql��ѯ�����Ա���Ƿ����ϸ�  ������ ����Ҫ�޸�
				StringBuffer sql = new StringBuffer();
				sql.append("/*dialect*/").append(sp);
				sql.append("select t2.* from ").append(sp);
				sql.append("CT_WAG_AttendanceBill 		t1").append(sp);
				sql.append("inner join CT_WAG_AttendanceBillentry	t2	on t2.FParentID = t1.FID").append(sp);
				sql.append("where to_char(t1.fBizDate,'yyyy-MM-dd') = '").append(dateString).append("' and CFClassES = '").append(classint).append("'  and t2.CFPersonNumID = '").append(personID).append("'").append(sp);
				IRowSet rss;
				//try {
					rss = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
					if(rss.next()){
						//MsgBox.showWarning(info.getName()+"Ա�����ϸ�,�������ظ��ϸ�");
						System.out.println(info.getName()+"Ա�����ϸ�,�������ظ��ϸ�");
					}else{
						IRow row = kdtEntry.addRow();
						row.getCell("personNum").setValue(info);
						row.getCell("personName").setValue(info.getName());
						BasicPostInfo bpInfo = getPersonPost(rs.getString("personID"));
						if(bpInfo!=null){
							row.getCell("personPost").setValue(bpInfo);
							row.getCell("wagesType").setValue(bpInfo.getWagesType());
						}
						row.getCell("personRatio").setValue(new BigDecimal("1"));
					}
//				} catch (BOSException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				
				
//				IRow row = kdtEntry.addRow();
//				row.getCell("personNum").setValue(info);
//				row.getCell("personName").setValue(info.getName());
//				BasicPostInfo bpInfo = getPersonPost(rs.getString("personID"));
//				if(bpInfo!=null){
//					row.getCell("personPost").setValue(bpInfo);
//					row.getCell("wagesType").setValue(bpInfo.getWagesType());
//				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	//��ȡԱ��������λ
    private BasicPostInfo getPersonPost(String uuid) {
    	BasicPostInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_BasicPost 			t1").append(sp);
    	sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t2.CFPersonID = '").append(uuid).append("'").append(sp);
    	sb.append(" and (t2.CFIsQuit is null or  t2.CFIsQuit = 0)").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				reBPInfo = BasicPostFactory.getRemoteInstance().getBasicPostInfo(new ObjectUuidPK(rs.getString("FID")));
				
			}else{
				return reBPInfo;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return reBPInfo;
    }
}