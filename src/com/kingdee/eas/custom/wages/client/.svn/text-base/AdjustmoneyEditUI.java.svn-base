/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
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
import com.kingdee.eas.custom.wages.AdjustCauseFactory;
import com.kingdee.eas.custom.wages.AdjustCauseInfo;
import com.kingdee.eas.custom.wages.AdjustCauseMonthFactory;
import com.kingdee.eas.custom.wages.AdjustCauseMonthInfo;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.custom.wages.UnitOfMetering;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.KDButton;
import com.kingdee.bos.ctrl.swing.KDPanel;

/**
 * output class name
 */
public class AdjustmoneyEditUI extends AbstractAdjustmoneyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AdjustmoneyEditUI.class);
    
    /**
     * output class constructor
     */
    public AdjustmoneyEditUI() throws Exception
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
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		intUI();
		kdtEntrys.addKDTEditListener(new KDTEditListener(){
			public void editCanceled(KDTEditEvent paramKDTEditEvent) {
			}
			public void editStarted(KDTEditEvent paramKDTEditEvent) {
			}
			public void editStarting(KDTEditEvent paramKDTEditEvent) {
			}
			public void editStopped(KDTEditEvent paramKDTEditEvent) {
				for(int i= 0;i<kdtEntrys.getRowCount();i++){
					
					if(kdtEntrys.getRow(i).getCell("person").getValue()!=null){
						PersonInfo info = (PersonInfo) kdtEntrys.getRow(i).getCell("person").getValue();
						BasicPostInfo BPinfo = getPersonPost(info.getId().toString());
						if(BPinfo!=null){
							kdtEntrys.getRow(i).getCell("personPost").setValue(BPinfo);
							
						}else{
							kdtEntrys.getRow(i).getCell("personPost").setValue(null);
						}
					}
				}
			}
			public void editStopping(KDTEditEvent paramKDTEditEvent) {
			}
			public void editValueChanged(KDTEditEvent paramKDTEditEvent) {
			}
			
		});
		importEx.setEnabled(true);
		addButtonToHMDEntry(kdtEntrys,importEx,5);  
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
			for(int i = 2; i <= excelValues.size(); i++){
				Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
				rowValues = excelValues.get(i);
				if(rowValues.values() == null) continue;
				IRow row = kdtEntrys.addRow();
				String personid = "";
				for (Integer in : rowValues.keySet()) {
					//map.keySet()返回的是所有key的值					
					Object obj = rowValues.get(in);//得到每个key对应value的值
					switch(in){
					case 1://员工编码
						if(obj != null){
							personid = getPersonID(obj.toString());
							p = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
							row.getCell(in).setValue(p);
							if(getPersonPost(p.getId())!=null){
								row.getCell(in+2).setValue(getPersonPost(p.getId()));
								row.getCell(in+5).setValue((getPersonPost(p.getId())).getProductRatio());
							}
						}
						break;
					case 2:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 3:
//						if(obj != null){
//							row.getCell(in).setValue(obj);
//						}
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
					case 6:
//						if(obj != null){
//							if(getR(obj.toString())!=null){
//								row.getCell(in).setValue(getR(obj.toString()));
//								//row.getCell("pieceUnitPrice").setValue((getPersonPost(p.getId())).getProductRatio());
//							}
//						}
						break;
					case 7:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 8:
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
		AdjustCauseMonthInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_AdjustCauseMonth 			t1").append(sp);
    	//sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t1.FName_l2 like '%").append(string).append("%'").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				reBPInfo = AdjustCauseMonthFactory.getRemoteInstance().getAdjustCauseMonthInfo(new ObjectUuidPK(rs.getString("FID")));
				
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
	//获取员工基础岗位
    private BasicPostInfo getPersonPost(BOSUuid uuid) {
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
	//用户名获取组织id
	private String getPostID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select t1.FID from ").append(sp);
		sql.append("CT_WAG_BasicPost  t1").append(sp);
		sql.append("inner join CT_WAG_BasicPostEntry  t2  on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_Person  t3  on t3.FID = t2.CFPersonID").append(sp);
		sql.append("where t3.Fid ='").append(personnumber).append("'").append(sp);
		System.out.println("获取组织id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FID");
		}
		return personID;
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.food.client.AbstractMonthFoodBillEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.AdjustmoneyFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    //获取员工基础岗位
    private BasicPostInfo getPersonPost(String string) {
    	BasicPostInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_BasicPost 			t1").append(sp);
    	sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t2.CFPersonID = '").append(string).append("'").append(sp);
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
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.AdjustmoneyInfo objectValue = new com.kingdee.eas.custom.wages.AdjustmoneyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompanyOrg(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}