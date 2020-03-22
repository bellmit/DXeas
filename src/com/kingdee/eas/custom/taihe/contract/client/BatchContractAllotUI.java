/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class BatchContractAllotUI extends AbstractBatchContractAllotUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchContractAllotUI.class);
    private String billID;
    /**
     * output class constructor
     */
    public BatchContractAllotUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnOK_actionPerformed method
     */
    protected void btnOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	String companyID,companyIDs="";
    	StringBuffer sql=new StringBuffer();
    	String userID=SysContext.getSysContext().getCurrentUserInfo().getString("id");
    	String dateStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    	for(int rowIndex=0;rowIndex<kDTable1.getRowCount();rowIndex++) {
    		if(kDTable1.getCell(rowIndex, "company").getValue()!=null) {
    			companyID=((IPropertyContainer) kDTable1.getCell(rowIndex, "company").getValue()).getString("id"); 
    			sql.append(" insert into T_CON_BatchContractAllotEntry(fid,fparentid,fallotuserid,fallottime,fallotOrgid)")
    			.append(" values(")
    			.append(" newbosid('8D18A1BC'),'").append(billID).append("','").append(userID).append("',{ts '").append(dateStr).append("'},'").append(companyID).append("'")
    			.append(" );");
    			if(companyIDs.length()>0) {
    				companyIDs+=",";
    			}
    			companyIDs+="'"+companyID+"'";
    		}
    	}
    	if(companyIDs.length()>0) {
    		ToolFacadeFactory.getRemoteInstance().execute("delete from T_CON_BatchContractAllotEntry where fparentid='"+billID+"' and fallotOrgid not in ("+companyIDs+")");
    	}else {
    		ToolFacadeFactory.getRemoteInstance().execute("delete from T_CON_BatchContractAllotEntry where fparentid='"+billID+"'");
    	}
    	
    	if(sql.length()>0) {
    		ToolFacadeFactory.getRemoteInstance().execute(sql.toString());
    	}
    	MsgBox.showInfo("分配完成！");
    	destroyWindow();
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
       destroyWindow();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kDTable1.checkParsed();
		
		billID=getUIContext().get("billID").toString();
		
		KDBizPromptBox prmt=new KDBizPromptBox();
		CompanyF7 cf7=new CompanyF7();
		prmt.setSelector(cf7);
		prmt.setDisplayFormat("$name$");
		prmt.setEditFormat("$name$");
		prmt.setCommitFormat("$number$;$name$");
		KDTDefaultCellEditor ed=new KDTDefaultCellEditor(prmt);
		kDTable1.getColumn("company").setEditor(ed);
		
		ICompanyOrgUnit is = CompanyOrgUnitFactory.getRemoteInstance();
		IRowSet rs = SQLExecutorFactory.getRemoteInstance("select fid,FallotOrgID from T_CON_BatchContractAllotEntry where fparentid='"+billID+"'").executeSQL();
		while(rs.next()) {
			IRow row = kDTable1.addRow();
			row.getCell("id").setValue(rs.getString("fid"));
			row.getCell("company").setValue(is.getCompanyOrgUnitInfo(new ObjectUuidPK(rs.getString("FallotOrgID"))));
		}
    }

	/**
     * output btnAdd_actionPerformed method
     */
    protected void btnAdd_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	kDTable1.addRow();
    }

    /**
     * output btnDel_actionPerformed method
     */
    protected void btnDel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {

    	IRow row = KDTableUtil.getSelectedRow(kDTable1);
    	if(row==null||row.getRowIndex()<0) {
    		MsgBox.showWarning("请选择行！");
    		return;
    	}
    	kDTable1.removeRow(row.getRowIndex());
    }

}