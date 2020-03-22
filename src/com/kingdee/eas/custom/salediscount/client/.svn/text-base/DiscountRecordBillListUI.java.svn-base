/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillFactory;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DiscountRecordBillListUI extends AbstractDiscountRecordBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DiscountRecordBillListUI.class);
    
    /**
     * output class constructor
     */
    public DiscountRecordBillListUI() throws Exception
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
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

   
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salediscount.DiscountRecordBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo objectValue = new com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo();
		
        return objectValue;
    }
    
    
    
//    @Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	try{

			// com.kingdee.eas.custom.qqctar.DiscountRecordBillInfo editData = (com.kingdee.eas.custom.qqctar.DiscountRecordBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
			
			
//			com.kingdee.eas.custom.qqctar.DiscountRecordBillFactory.getRemoteInstance().audit(editData);
    		ArrayList selectedID = super.getSelectedIdValues();
			if(selectedID != null && selectedID.size() > 0){
				
				
				String errorNumber = "";
				
				// 逐单审核
				for(int i = 0; i < selectedID.size(); i++){
					String id = (String)selectedID.get(i);
					if(id != null){
						String exeNum = "";
						try{
							DiscountRecordBillInfo editData = (DiscountRecordBillInfo)getBizInterface().getValue(new ObjectUuidPK(BOSUuid.read(id)));
							exeNum = editData.getNumber();
							DiscountRecordBillFactory.getRemoteInstance().audit(editData);
						}catch(Exception ex){
							ex.printStackTrace();
							
							MsgBox.showInfo(ex.getMessage());
							SysUtil.abort();
							
							errorNumber = errorNumber + exeNum + ";";
							continue;
						}
					}
				}
				
				// 打开下游单据
				
				if(StringUtils.isNotBlank(errorNumber)){
					MsgBox.showWarning("审核完成.出现异常的单据编码：" + errorNumber);
					this.refreshList();
				}else{
					MsgBox.showWarning("审核完成");
					this.refreshList();
				}
			}
			SysUtil.abort();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
			
		
	}
	  /**
	 * 获取选中的未导入销售出库单id
	 * <p>Title: getSelectedIds</p>
	 * <p>Description: </p>
	 * 
	 * @return
	 */
	private String[] getSelectedIds(){
		List selectIdList = new ArrayList();
		if(this.tblMain.getRowCount() <= 0){
			MsgBox.showInfo("列表中没有数据");
			SysUtil.abort();
		}else {
			int allSelectedCount = 0;
			boolean checked = false;
			ArrayList blocks = tblMain.getSelectManager().getBlocks();
			for (int i = 0; i < blocks.size(); i++){
				 KDTSelectBlock sb = (KDTSelectBlock)blocks.get(i);
				sb = tblMain.getSelectManager().get(i);
				if(sb != null ){
					
					int top = sb.getBeginRow();
					
					int bottom = sb.getEndRow();
					int left = sb.getLeft();
					int right = sb.getRight();
					
					String fieldName = this.tblMain.getColumn(left).getFieldName();
					
					
					
					for(int j = top; j <= bottom; j++){
						String fid = (String)this.tblMain.getCell(j, "id").getValue();
						selectIdList.add(fid);
					}
					
					
				}else{
					continue;
				}
			}
		}
		String[]  selectedIds = new String[selectIdList.size()];
		return (String[]) selectIdList.toArray(selectedIds);
	}
//	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			
			ArrayList selectedID = super.getSelectedIdValues();
			if(selectedID != null && selectedID.size() > 0){
				for(int i = 0; i < selectedID.size(); i++){
					String id = (String)selectedID.get(i);
					if(id != null){
						String exeNum = "";
						try{
							DiscountRecordBillInfo editData = (DiscountRecordBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(id)));
							exeNum = editData.getNumber();
							DiscountRecordBillFactory.getRemoteInstance().unAudit(editData);
						}catch(BOSException ex){
							ex.printStackTrace();
							
							MsgBox.showInfo(ex.getMessage());
							SysUtil.abort();
//							errorNumber = errorNumber + exeNum + ";";
							
						}
					}
				}
				
				MsgBox.showWarning("反审核完成");
				this.refreshList();
				
			
			}
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
		
	}


}