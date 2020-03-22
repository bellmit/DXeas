/**
 * output package name
 */
package com.kingdee.eas.custom.wages.farm.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class HatchAssessEditUI extends AbstractHatchAssessEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(HatchAssessEditUI.class);
    
    /**
     * output class constructor
     */
    public HatchAssessEditUI() throws Exception
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
		initUI();
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.farm.client.AbstractHatchAssessEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
	}
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取核算期间内的员工及其数据
	 */
    private IRowSet getExeQueryRowSet() throws BOSException {
    	String begindate= this.pkbegindate.getText();
    	String enddate= this.pkenddate.getText();
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select t3.FID FID,").append(sp);
		sql.append("t3.FName_l2 Name,").append(sp);
		sql.append("t3.FNumber FNumber,").append(sp);
		sql.append("t1.FName_l2,").append(sp);
		sql.append("t1.FID postid,").append(sp);
		sql.append("t1.FNumber,").append(sp);
		sql.append("t4.FName_l2,").append(sp);
		sql.append("t4.FNumber,").append(sp);
		sql.append("(case when t1.FNumber in ('3095','3081','3074','3082','3232','3032','3073','3072','3075','3101','3096') then 0 else t5.Qty end) jjjs,").append(sp);
		sql.append("nvl(t6.CFPersonqty,0) bzrs,").append(sp);
		sql.append("nvl(t6.CFRateindex,0) blsx,").append(sp);
		sql.append("100 bjdw").append(sp);
		sql.append("from T_ORG_Position t1").append(sp);
		sql.append("inner join T_ORG_PositionMember t2 on t2.FPositionID = t1.FID").append(sp);
		sql.append("inner join T_BD_Person t3 on t3.FID = t2.FPersonID").append(sp);
		sql.append("inner join T_ORG_Admin t4 on t4.FID = t1.FAdminOrgUnitID").append(sp);
		sql.append("left join (").append(sp);
		sql.append("select ").append(sp);
		sql.append("sum(t2.FQty) Qty").append(sp);
		sql.append("from ").append(sp);
		sql.append("T_IM_ManufactureRecBill t1").append(sp);
		sql.append("inner join T_IM_ManufactureRecBillEntry t2 on t1.FID = t2.FParentID").append(sp);
		sql.append("inner join T_ORG_Storage t3 on t3.FID = t1.FStorageOrgUnitID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.Fbizdate,'yyyy-MM-dd') >= '"+begindate+"'").append(sp);
		sql.append("and to_char(t1.Fbizdate,'yyyy-MM-dd') <= '"+enddate+"'").append(sp);
		sql.append("and t3.FNumber = '303'").append(sp);
		sql.append(") t5 on 1=1").append(sp);
		sql.append("left join (").append(sp);
		sql.append("select ").append(sp);
		sql.append("t2.CFPositionID,").append(sp);
		sql.append("t2.CFPersonqty,").append(sp);
		sql.append("t2.CFRateindex").append(sp);
		sql.append("from").append(sp);
		sql.append("CT_FAR_FarmPostStand t1 ").append(sp);
		sql.append("inner join CT_FAR_FarmPostStandEntry t2 on t1.FID = t2.FParentID").append(sp);
		sql.append(") t6 on t6.CFPositionID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("t4.FNumber in ('303','3031','3032')").append(sp);
		sql.append("order by t1.FNumber").append(sp);
		System.out.println("获取孵化场员工"+sql.toString());
    	IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
    }
    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 查询标准是否存在且唯一
	 */
    private IRowSet getIndexQuery() throws BOSException {
    	String begindate= this.pkbegindate.getText();
    	String enddate= this.pkenddate.getText();
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID").append(sp);
		sql.append("from CT_FAR_FarmPostStand").append(sp);
    	IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
    }
    private void initUI() {
    	this.getPserson.setEnabled(true);
    	this.getPserson.addMouseListener(new MouseListener(){

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				if(pkbegindate.getValue()==null||pkenddate.getValue()==null){
					MsgBox.showWarning("请先确定核算期间");
					SysUtil.abort();
				}
					IRowSet rs = getExeQueryRowSet();
					kdtEntrys.removeRows();
					PersonInfo p = new PersonInfo();
					PositionInfo pt = new PositionInfo();
					while(rs.next()){
						kdtEntrys.addRow();
						String name = rs.getString("FID"); //ID 
						IObjectPK pk = new ObjectStringPK(name); //主键 
						p = PersonFactory.getRemoteInstance().getPersonInfo(pk);
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "person").setValue(p);
						String postid = rs.getString("postid"); //ID  
						pt = PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(postid));
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "position").setValue(pt);
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "jjjs").setValue(rs.getBigDecimal("jjjs"));
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "bzrs").setValue(rs.getBigDecimal("bzrs"));
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "blsx").setValue(rs.getBigDecimal("blsx"));
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "bjdw").setValue(rs.getBigDecimal("bjdw"));
					}
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (EASBizException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}	
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
    }
    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
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
	 * output actionSubmit_actionPerformed
	 * 刷新操作
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	} 

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.farm.HatchAssessFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.wages.farm.HatchAssessInfo objectValue = new com.kingdee.eas.custom.wages.farm.HatchAssessInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        IRowSet rs = null;
		try {
			rs = getIndexQuery();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(rs.size()==0){
        	MsgBox.showWarning("未设置综合考核指标或没有启用的综合考核指标，不能录入绩效考核单！");
    		SysUtil.abort();
        }
        return objectValue;
    }

}