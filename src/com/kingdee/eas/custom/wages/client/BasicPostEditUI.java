/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.Person;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.BasicStatus;
import com.kingdee.eas.custom.wages.byThePieceUnit;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class BasicPostEditUI extends AbstractBasicPostEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BasicPostEditUI.class);
    
    /**
     * output class constructor
     */
    public BasicPostEditUI() throws Exception
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

    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.EditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.kdtEntry_detailPanel.getInsertLineButton().setVisible(true);
		initUI();
		if(this.editData.getBaseStatus() == BasicStatus.open) {
			this.btnCancel.setEnabled(true);
			this.btnCancelCancel.setEnabled(false);
    	}else{
    		this.btnCancelCancel.setEnabled(true);
    		this.btnCancel.setEnabled(false);
    	}
	}
	private void initUI() {
		// TODO Auto-generated method stub
		//this.txtPostSalary.setText("0");
		// prmtposition		
        this.prmtposition.setQueryInfo("com.kingdee.eas.custom.wages.app.PositionF7Query");		
        this.prmtposition.setVisible(true);		
        this.prmtposition.setEditable(true);		
        this.prmtposition.setDisplayFormat("$name$");		
        this.prmtposition.setEditFormat("$number$");		
        this.prmtposition.setCommitFormat("$number$");		
        this.prmtposition.setRequired(false);
	 prmtposition.addDataChangeListener(new DataChangeListener() {
     		public void dataChanged(DataChangeEvent e) {
     			try {
     				prmtposition_Changed();
     			}
     			catch (Exception exc) {
     				handUIException(exc);
     			}
     		}
     	});
	 importExcel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				getExcelMassage();
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});	
	 kdtEntry.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
//	 	//F7添加过滤
//	 	//Position
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo view = new EntityViewInfo();  
	    FilterInfo filter = new FilterInfo(); //过滤条件  
	    filter.getFilterItems().add(new FilterItemInfo("Number", company.getNumber()+"%",CompareType.LIKE)); //条件1，#0  
	    view.setFilter(filter);  
	    prmtposition.setEntityViewInfo(view); //F7重新设定视图  
	    
		EntityViewInfo view1 = new EntityViewInfo();  
	    FilterInfo filter1 = new FilterInfo(); //过滤条件  
	    filter1.getFilterItems().add(new FilterItemInfo("Number", company.getNumber()+"%",CompareType.LIKE)); //条件1，#0  
	    view1.setFilter(filter1);  
	    prmtCoefficientRate.setEntityViewInfo(view1); //F7重新设定视图  
	    
	    
	}
	/**
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
	@Override
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("person".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
            	if(kdtEntry.getRow(rowIndex).getCell("person").getValue()!=null){
            		PersonInfo info = (PersonInfo) kdtEntry.getRow(rowIndex).getCell("person").getValue();
            		IRowSet rss = getPersonRow(info.getId().toString());
                	kdtEntry.getCell(rowIndex,"personnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"person").getValue(),"number")));
            		IRowSet rs = getPersonQueryRowSet(info.getId().toString());
            		if(rss.size()<1){
            			while(rs.next()){
                			kdtEntry.getCell(rowIndex,"idcard").setValue(rs.getString("IDCard"));
                			kdtEntry.getCell(rowIndex,"phonenumber").setValue(rs.getString("cell"));
                		}
            		}else{
            			while(rss.next()){
            				MsgBox.showWarning("该员工已在"+rss.getString("Postname")+"岗存在,请检查！");
//            				kdtEntry.getCell(rowIndex,"personnumber").setValue(null);
//            				kdtEntry.getCell(rowIndex,"person").setValue(null);
            			}
            		}
            	}
            }
}
	//导入excel文件至单据分录
	private void getExcelMassage(){
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			PersonInfo p = new PersonInfo();
			//BasicPostInfo b = new BasicPostInfo();
			for(int i = 2; i <= excelValues.size(); i++){
				Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
				rowValues = excelValues.get(i);
				if(rowValues.values() == null) continue;
				IRow row = null;
				String personid = "";
				boolean begin = true;
				for (Integer in : rowValues.keySet()) {
					//map.keySet()返回的是所有key的值					
					Object obj = rowValues.get(in);//得到每个key对应value的值
					if(begin&&rowValues.get(1)!=null){
						row = kdtEntry.addRow();
						begin = false;
					}
					switch(in){
					case 1://员工姓名
						break;
					case 2:
						if(obj != null){
							row.getCell(in).setValue(obj);
							personid = getPersonID(obj.toString());
							if(StringUtils.isEmpty(personid)){
								break;
							}else{
								try {
									p = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
								} catch (EASBizException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (BOSException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								row.getCell(in-1).setValue(p);
								break;
							}
						}
					case 3:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 4:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 5:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					}	
				}
			}
		}
	
		
	}
	//用户名获取用户id
	private String getPersonID(String personnumber) {
		String personID = null ;
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_BD_Person ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FNumber ='").append(personnumber).append("'").append(sp);
		System.out.println("获取用户id"+sql.toString());
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			
			while(rs.next()){
				personID = rs.getString("FID");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personID;
	}
	 public void prmtposition_Changed() throws Exception{
	    	txtpostname.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtposition.getData(),"name")));
	    	if(prmtposition.getValue()==null){
	    		System.out.println("你为啥走这里");
	    		kdtEntry.removeRows();
	    	}else{
	    	PositionInfo position = (PositionInfo) prmtposition.getValue();
	    	IRowSet rs = getExeQueryRowSet(position.getId().toString());
	    	kdtEntry.removeRows();
			PersonInfo p = new PersonInfo();
			while(rs.next()){
				kdtEntry.addRow();
				String id = rs.getString("FID"); //ID  
				IObjectPK pk = new ObjectStringPK(id); //主键 
				p = PersonFactory.getRemoteInstance().getPersonInfo(pk);
				kdtEntry.getCell(kdtEntry.getRowCount()-1, "person").setValue(p);
				kdtEntry.getCell(kdtEntry.getRowCount()-1, "personnumber").setValue(rs.getString("FNumber"));
				kdtEntry.getCell(kdtEntry.getRowCount()-1, "idcard").setValue(rs.getString("IDCard"));
				kdtEntry.getCell(kdtEntry.getRowCount()-1, "phonenumber").setValue(rs.getString("cell"));
				kdtEntry.getCell(kdtEntry.getRowCount()-1, "bankcar").setValue(rs.getString("bankcard"));
				
			}
	    	}
	    }
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取职位对应员工
	 */
 private IRowSet getExeQueryRowSet(String id) throws BOSException {
 	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select t3.FID FID,t3.FName_l2 Name,t3.FNumber FNumber,t3.FCell cell,t3.FIdCardNo IDCard,t4.CFBankaccount bankcard from T_ORG_Position t1").append(sp);
		sql.append("inner join T_ORG_PositionMember t2 on t2.FPositionID = t1.FID").append(sp);
		sql.append("inner join T_BD_Person t3 on t3.FID = t2.FPersonID").append(sp);
		sql.append("inner join T_HR_EmpEnrollBizBillEntry t4 on t3.FID = t4.FPersonID").append(sp);
		
		sql.append("where t1.FID = '"+id+"'").append(sp);
 	IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
 	System.out.println(sql.toString());
		return rs;
 }
 /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取员工数据
	 */
private IRowSet getPersonQueryRowSet(String id) throws BOSException {
	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select FID FID,FName_l2 Name,FNumber FNumber,FCell cell,FIdCardNo IDCard from T_BD_Person ").append(sp);
		sql.append("where FID = '"+id+"'").append(sp);
		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		//System.out.println(sql.toString());
		return rs;
}
/**
 *<p>Custom: 北三峡</p>
 *<p>Company: 青岛未来互连</p>
 * @author 于明旭
 * 获取员工在岗数据
 */
private IRowSet getPersonRow(String id) throws BOSException {
StringBuffer sql = new StringBuffer();
	String sp = "\n";
	sql.append("/*dialect*/").append(sp);
	sql.append("select t1.CFPostname Postname from CT_WAG_BasicPost t1 ").append(sp);
	sql.append("inner join CT_WAG_BasicPostEntry t2 on t2.FParentID = t1.FID ").append(sp);
	sql.append("where t2.CFPersonID  = '"+id+"'").append(sp);
	sql.append("and FNumber != '"+txtNumber.getText()+"'").append(sp);
	IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
	System.out.println(sql.toString());
	return rs;
}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.client.AbstractBasicPostEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
	}

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.BasicPostFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.BasicPostInfo objectValue = new com.kingdee.eas.custom.wages.BasicPostInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setPostSalary(new BigDecimal("0"));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}