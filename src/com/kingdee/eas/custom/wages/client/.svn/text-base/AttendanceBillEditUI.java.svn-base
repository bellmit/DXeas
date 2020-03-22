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
					//获取时间的字符串格式
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = (Date) pkBizDate.getValue();
					String dateString = formatter.format(date);
					//获取personID
					PersonInfo info = (PersonInfo) kdtEntry.getRow(row).getCell("personNum").getValue();
					
					String personID = info.getId().toString();
					int classint = classes.getSelectedIndex();
					//建立sql查询今天改员工是否以上岗  有问题 还需要修改
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
							MsgBox.showWarning(info.getName()+"员工已上岗,不允许重复上岗");
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
//				 	//分录F7添加过滤
//				 	//Post
				    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntry.getColumn("personPost").getEditor().getComponent(); // 人员F7  
				    EntityViewInfo view1 = new EntityViewInfo(); // 新定义视图  
				    FilterInfo filter1 = new FilterInfo(); // 设置过滤条件  
				    filter1.getFilterItems().add(new FilterItemInfo("company.id", company.getId().toString()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
				    String theGroupName = ((IPropertyContainer) prmttheGroup.getValue()).getString("Name");
				    if(theGroupName!=null){
				    	filter1.getFilterItems().add(new FilterItemInfo("theGroup.name", "%"+theGroupName+"%",CompareType.LIKE)); // 按照当前班组过滤  
				    	filter1.setMaskString("#0 and #1");
				    }
				    view1.setFilter(filter1); // 设置过滤条件  
				    prmtPost.setEntityViewInfo(view1); // 重新设定视图  
				    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
				}else{
					kdtEntry.removeRows();
				}
				
			}
			
		});
	}
  //object 转 bigdecimal
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
//	 	//表头F7添加过滤
//	 	//theGroup
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo view = new EntityViewInfo();  
	    FilterInfo filter = new FilterInfo(); //过滤条件  
	    filter.getFilterItems().add(new FilterItemInfo("Number", company.getNumber()+"%",CompareType.LIKE)); //条件1，#0  
	    view.setFilter(filter);  
	    prmttheGroup.setEntityViewInfo(view); //F7重新设定视图  

	    
//	 	//Person
	    KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntry.getColumn("personNum").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view2 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter2 = new FilterInfo(); // 设置过滤条件  
	    filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
	    view2.setFilter(filter2); // 设置过滤条件  
	    prmtPerson.setEntityViewInfo(view2); // 重新设定视图  
	    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
	    
	    if(prmttheGroup.getValue()!=null&&prmtcompany.getValue()!=null){
			String theGroupID = ((IPropertyContainer) prmttheGroup.getValue()).getString("id");
			String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("id");
//		 	//分录F7添加过滤
//		 	//Post
		    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntry.getColumn("personPost").getEditor().getComponent(); // 人员F7  
		    EntityViewInfo view1 = new EntityViewInfo(); // 新定义视图  
		    FilterInfo filter1 = new FilterInfo(); // 设置过滤条件  
		    filter1.getFilterItems().add(new FilterItemInfo("company.id", company.getId().toString()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
		    String theGroupName = ((IPropertyContainer) prmttheGroup.getValue()).getString("Name");
		    if(theGroupName!=null){
		    	filter1.getFilterItems().add(new FilterItemInfo("theGroup.name", "%"+theGroupName+"%",CompareType.LIKE)); // 按照当前班组过滤  
		    	filter1.setMaskString("#0 and #1");
		    }
		    view1.setFilter(filter1); // 设置过滤条件  
		    prmtPost.setEntityViewInfo(view1); // 重新设定视图  
		    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
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
    //获取所有用户
    private void getAllPersonID(String companyID,String theGroupID){
    	StringBuffer sb = new StringBuffer();
    	//获取时间的字符串格式
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
				//yumingxu 岗位重复性校验
				String personID = info.getId().toString();
				int classint = classes.getSelectedIndex();
				//建立sql查询今天改员工是否以上岗  有问题 还需要修改
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
						//MsgBox.showWarning(info.getName()+"员工已上岗,不允许重复上岗");
						System.out.println(info.getName()+"员工已上岗,不允许重复上岗");
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
	//获取员工基础岗位
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