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
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.AdjustCauseFactory;
import com.kingdee.eas.custom.wages.AdjustCauseInfo;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class QualityawardticketEditUI extends AbstractQualityawardticketEditUI
{
    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		setUITitle("日工资调整单");
		importPerson.addMouseListener(new MouseListener(){
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
		prmttheGroup.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				kdtEntrys.removeRows();
				if(prmttheGroup.getValue()!=null){
					String theGroupID = ((IPropertyContainer) prmttheGroup.getValue()).getString("id");
					//String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("id");
					getAllPersonID(theGroupID);
				}else{
					kdtEntrys.removeRows();
				}
				
			}
			
		});
		intUI();
		super.onLoad();
	}
	private void intUI() {
		// TODO Auto-generated method stub
	    CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo view = new EntityViewInfo();  
	    FilterInfo filter = new FilterInfo(); //过滤条件  
	    filter.getFilterItems().add(new FilterItemInfo("Number", company.getNumber()+"%",CompareType.LIKE)); //条件1，#0  
	    view.setFilter(filter);  
	    prmtcompany.setEntityViewInfo(view); //F7重新设定视图  
	    
//	 	//Person
	    final KDBizPromptBox kdtEntrys_person_PromptBox = new KDBizPromptBox();
        kdtEntrys_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_person_PromptBox.setVisible(true);
        kdtEntrys_person_PromptBox.setEditable(true);
        kdtEntrys_person_PromptBox.setDisplayFormat("$number$");
//        kdtEntrys_person_PromptBox.setEditFormat("$number$");
//        kdtEntrys_person_PromptBox.setCommitFormat("$number$");
        kdtEntrys_person_PromptBox.setEditFormat("$name$");
        kdtEntrys_person_PromptBox.setCommitFormat("$name$");
        KDTDefaultCellEditor kdtEntrys_person_CellEditor = new KDTDefaultCellEditor(kdtEntrys_person_PromptBox);
        this.kdtEntrys.getColumn("person").setEditor(kdtEntrys_person_CellEditor);
	    
	    KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntrys.getColumn("person").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view2 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter2 = new FilterInfo(); // 设置过滤条件  
	    filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
	    view2.setFilter(filter2); // 设置过滤条件  
	    prmtPerson.setEntityViewInfo(view2); // 重新设定视图  
	    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
	    
//	 	//theGroup
		//CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo view3 = new EntityViewInfo();  
	    FilterInfo filter3 = new FilterInfo(); //过滤条件  
	    filter3.getFilterItems().add(new FilterItemInfo("Number", company.getNumber()+"%",CompareType.LIKE)); //条件1，#0  
	    view3.setFilter(filter3);  
	    prmttheGroup.setEntityViewInfo(view3); //F7重新设定视图  
	    
	    
	    
	}
    //获取所有用户
    private void getAllPersonID(String theGroupID){
    	StringBuffer sb = new StringBuffer();
    	//获取时间的字符串格式
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = (Date) pkBizDate.getValue();
//		String dateString = formatter.format(date);
    	String sp = "\n";
    	sb.append("select t2.CFPersonid personID from  ").append(sp);
    	sb.append("CT_WAG_BasicPost 				t1").append(sp);
    	sb.append("inner join CT_WAG_BasicPostEntry 		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("where  t1.CFtheGroupID= '").append(theGroupID).append("'").append(sp);
    	sb.append("order by CFPostName");
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next()){
				
				PersonInfo info = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("personID")));
				
				String personID = info.getId().toString();
				
				//建立sql查询今天改员工是否以上岗  有问题 还需要修改
				IRow row = kdtEntrys.addRow();
				row.getCell("person").setValue(info);
				row.getCell("personnumber").setValue(info.getNumber());
//				BasicPostInfo bpInfo = getPersonPost(rs.getString("personID"));
//				if(bpInfo!=null){
//					row.getCell("personPost").setValue(bpInfo);
//					row.getCell("wagesType").setValue(bpInfo.getWagesType());
//				}
					
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
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_BasicPost 			t1").append(sp);
    	sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t2.CFPersonID = '").append(uuid).append("'").append(sp);
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
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.client.AbstractQualityawardticketEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
	}

	private static final Logger logger = CoreUIObject.getLogger(QualityawardticketEditUI.class);
    
    /**
     * output class constructor
     */
    public QualityawardticketEditUI() throws Exception
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
	 * @see com.kingdee.eas.custom.wages.client.AbstractQualityawardticketEditUI#actionAudit_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.client.AbstractQualityawardticketEditUI#actionUnaudit_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnaudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }


    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止删除！");
    		SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
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
        com.kingdee.eas.custom.wages.QualityawardticketInfo objectValue = new com.kingdee.eas.custom.wages.QualityawardticketInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        return objectValue;
    }
	//导入excel文件至单据分录
	private void getExcelMassage(){
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			PersonInfo p = new PersonInfo();
			//BasicPostInfo b = new BasicPostInfo();
			for(int i = 1; i <= excelValues.size(); i++){
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
						row = kdtEntrys.addRow();
						begin = false;
					}
					switch(in){
					case 1://员工姓名
						
						break;
					case 2:
						if(obj != null){
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
								row.getCell(in).setValue(obj);
							}	
						}
						break;
					case 3:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 4:
						if(obj != null){
							if(getR(obj.toString())!=null){
								AdjustCauseInfo reBPInfo = (AdjustCauseInfo) getR(obj.toString());
								row.getCell(in+1).setValue(reBPInfo);
								//row.getCell("pieceUnitPrice").setValue((getPersonPost(p.getId())).getProductRatio());
							}
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
	private Object getR(String string) {
		// TODO Auto-generated method stub
		AdjustCauseInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_AdjustCause 			t1").append(sp);
    	//sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t1.FName_l2 like '%").append(string).append("%'").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				reBPInfo = AdjustCauseFactory.getRemoteInstance().getAdjustCauseInfo(new ObjectUuidPK(rs.getString("FID")));
				
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
}