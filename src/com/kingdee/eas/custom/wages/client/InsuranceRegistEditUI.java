/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

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
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDButton;
import com.kingdee.bos.ctrl.swing.KDPanel;

/**
 * output class name
 */
public class InsuranceRegistEditUI extends AbstractInsuranceRegistEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(InsuranceRegistEditUI.class);
    
    /**
     * output class constructor
     */
    public InsuranceRegistEditUI() throws Exception
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
    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		intUI();
		importEx.setEnabled(true);
		addButtonToHMDEntry(kdtEntrys,importEx,5);
		
	}
	private void addButtonToHMDEntry(KDTable table, KDButton button,int width) {  
        if (table.getParent() == null || table.getParent().getParent() == null)  
         return;  
        // 隐藏按钮  
        Component c = table.getParent().getParent();  
        if (c instanceof DetailPanel) {  
         JPanel panel = (JPanel) c;  
         JPanel controlPanel = null;  
         // 获取controlPanel  
         Component[] components = panel.getComponents();  
         for (int i = 0; i < components.length; i++) {  
          Component component = components[i];  
          if ("controlPanel".equals(component.getName())) {  
           controlPanel = (KDPanel) component;  
          }  
         }  
         // 获取btn  
         if (controlPanel != null) {  
          Rectangle rect = table.getBounds();  
          int x = rect.width - (button.getWidth() +86+ width);  
          controlPanel.add(button, new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x, 3, button.getWidth(), 19, 9));  
         }  
        }  
          
       } 
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.client.AbstractAdjustmoneyEditUI#actionImportEx_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionImportEx_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionImportEx_actionPerformed(e);
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			kdtEntrys.removeRows();
			PersonInfo p = new PersonInfo();
			BasicPostInfo b = new BasicPostInfo();
			PositionInfo pt = new PositionInfo();
			CompanyOrgUnitInfo cp = new CompanyOrgUnitInfo();
			for(int i = 1; i <= excelValues.size(); i++){
				Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
				rowValues = excelValues.get(i);
				if(rowValues.values() == null) continue;
				IRow row = kdtEntrys.addRow();
				String personid = "";
				String ptid = "";
				String companyid = "";
				DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
				for (Integer in : rowValues.keySet()) {
					//map.keySet()返回的是所有key的值					
					Object obj = rowValues.get(in);//得到每个key对应value的值
					switch(in){
					case 1://员工编码
						if(obj != null){
							if(getPersonID(obj.toString())!=null){
								personid = getPersonID(obj.toString());
								p = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
								row.getCell(in).setValue(p);
								if(p.getId()!=null){
									row.getCell(in+1).setValue(p.getName());
									//row.getCell(in+5).setValue(p.getState());
								}

							}
						}
						break;
					case 2:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 3:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 4:
						if(obj != null){
							if(getCompanyID(obj.toString())!=null){
								companyid = getCompanyID(obj.toString()); 
								cp = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyid));
								row.getCell(in).setValue(cp);	
							}
						}
						break;
					case 5:
						if(obj != null){
							if(getPositionIDS(obj.toString())!=null){
								ptid = getPositionIDS(obj.toString());
								pt = PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(ptid));
								row.getCell(in).setValue(pt);
							}
						}
						break;
					case 6:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 7:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 8:
//						if(obj != null){
//							Date date = format1.parse(String.valueOf(obj));
//							row.getCell(in).setValue(date);
//						}
						break;
					case 9:
//						if(obj != null){
//							Date date = format1.parse(obj.toString());
//							row.getCell(in).setValue(date);
//						}
						break;
					
					}	
				}
			}
		}
	}

	//用户名获取用户id
	private String getPersonID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_BD_Person ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FNumber ='").append(personnumber).append("'").append(sp);
		//System.out.println("获取用户id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FID");
		}
		return personID;
	}
	
	//用户名获取用户id
	private String getPositionID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FPositionID from ").append(sp);
		sql.append("T_ORG_PositionMember ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FPersonID ='").append(personnumber).append("'").append(sp);
		System.out.println("获取职位id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FPositionID");
		}
		return personID;
	}
	
	//用户名获取用户id
	private String getPositionIDS(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_ORG_Position ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 like '%").append(personnumber).append("%'").append(sp);
		System.out.println("获取职位id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FID");
		}
		return personID;
	}
	
	
	//obj名获取公司id
	private String getCompanyID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select fid from ").append(sp);
		sql.append("T_ORG_Company ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取公司id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("fid");
		}
		return personID;
	}
	
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    private void intUI() {
		// TODO Auto-generated method stub	  
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
//	 	//Person
	    KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntrys.getColumn("person").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view2 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter2 = new FilterInfo(); // 设置过滤条件  
	    filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
	    view2.setFilter(filter2); // 设置过滤条件  
	    prmtPerson.setEntityViewInfo(view2); // 重新设定视图  
	    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
	    
	    final KDBizPromptBox kdtEntrys_position_PromptBox = new KDBizPromptBox();
        kdtEntrys_position_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.PositionQuery");
        kdtEntrys_position_PromptBox.setVisible(true);
        kdtEntrys_position_PromptBox.setEditable(true);
        kdtEntrys_position_PromptBox.setDisplayFormat("$name$");
        kdtEntrys_position_PromptBox.setEditFormat("$number$");
        kdtEntrys_position_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_position_CellEditor = new KDTDefaultCellEditor(kdtEntrys_position_PromptBox);
        this.kdtEntrys.getColumn("position").setEditor(kdtEntrys_position_CellEditor);
        ObjectValueRender kdtEntrys_position_OVR = new ObjectValueRender();
        kdtEntrys_position_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("position").setRenderer(kdtEntrys_position_OVR);
        
        kdtEntrys.addKDTEditListener(new KDTEditListener(){

			@Override
			public void editCanceled(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void editStarted(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void editStarting(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
				for(int i= arg0.getRowIndex();i<kdtEntrys.getRowCount();i++){
					if(kdtEntrys.getRow(i).getCell("beginDate").getValue()!=null){
						Date date = (Date) kdtEntrys.getRow(i).getCell("beginDate").getValue();
						for(int j= i+1;j<kdtEntrys.getRowCount();j++){
							kdtEntrys.getRow(j).getCell("beginDate").setValue(date);
						}
					}
					if(kdtEntrys.getRow(i).getCell("endDate").getValue()!=null){
						Date date = (Date) kdtEntrys.getRow(i).getCell("endDate").getValue();
						for(int j= i+1;j<kdtEntrys.getRowCount();j++){
							kdtEntrys.getRow(j).getCell("endDate").setValue(date);
						}
					}
					
				}		
			}

			@Override
			public void editStopping(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void editValueChanged(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
	    
	}
    
    @Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);	
		//kdtEntrys.getCell(rowIndex,"cuser").setValue(((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser())).getName());
		kdtEntrys.getCell(rowIndex,"company").setValue(this.prmtcompanyOrg.getValue());
		
		if(kdtEntrys.getCell(rowIndex,"person").getValue()!=null){
			String personid = getPositionID(((PersonInfo)(kdtEntrys.getCell(rowIndex,"person").getValue())).getId().toString());
			if(personid!=null){
				PositionInfo info = PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(personid));
				kdtEntrys.getCell(rowIndex,"position").setValue(info);
			}
		}
		
//		if(kdtEntrys.getCell(rowIndex,"beginDate").getValue()!=null){
//			Date date = (Date) kdtEntrys.getCell(rowIndex,"beginDate").getValue();
//		}
		
		

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
    		MsgBox.showWarning("单据已经审核，禁止刪除！");
    		SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }


    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
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

    /**
     * output actionUnaudit_actionPerformed
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
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
        com.kingdee.eas.custom.wages.InsuranceRegistInfo objectValue = new com.kingdee.eas.custom.wages.InsuranceRegistInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompanyOrg(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}