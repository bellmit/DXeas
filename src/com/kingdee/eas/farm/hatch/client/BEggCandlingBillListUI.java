/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.BEggCandlingBill;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.BEggTrayingBillCollection;
import com.kingdee.eas.farm.hatch.BEggTrayingBillFactory;
import com.kingdee.eas.farm.hatch.IBEggCandlingBill;
import com.kingdee.eas.farm.hatch.IBEggHatchBill;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

/**
 * output class name
 */
public class BEggCandlingBillListUI extends AbstractBEggCandlingBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BEggCandlingBillListUI.class);
    
    /**
     * output class constructor
     */
    public BEggCandlingBillListUI() throws Exception
    {
        super();
        this.setUITitle("照蛋记录单");
        // 默认 可查询当前组织 及下游组织的  上孵单 上孵单
        this.setFilterForQuery(this.getFilterInfo());
        // 图标设置
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
    }
    /**
     * 设置默认过滤条件
     * @return
     */
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	AdminOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentAdminUnit();
    	
//    	filterInfo.getFilterItems().add(new FilterItemInfo("adminOrg.longNumber",currAdminOrg.getLongNumber(),CompareType.LIKE));
    	
    	StorageOrgUnitInfo currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
    	if(currStoOrg ==null){
    		MsgBox.showInfo("当前登录组织不是库存组织");
    		SysUtil.abort();
    	}
		filterInfo.getFilterItems().add(new FilterItemInfo("hatchFactory1.id",currStoOrg.getId().toString(),CompareType.EQUALS));
    	
    	return filterInfo;
    }
    
    @Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
	
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
	
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBEggCandlingBill iBEggCandlingBill = BEggCandlingBillFactory.getRemoteInstance();
	
		BEggCandlingBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggCandlingBill.getBEggCandlingBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止审核"+"\n";
				num--;
				continue;
			}
			iBEggCandlingBill.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("审核失败,单据状态必须是提交状态的单子才能审核");
			else if(num==0)
				MsgBox.showInfo("审核失败,没有符合审核条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子审核完成\n"+error));
			}
		}
		finally{
			refreshList();
		}
	
		//		super.actionAudit_actionPerformed(e);
	
    
    
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		checkSelected();
	
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
	
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		IBEggCandlingBill iBEggCandlingBill = BEggCandlingBillFactory.getRemoteInstance();
	
		BEggCandlingBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBEggCandlingBill.getBEggCandlingBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"非审核状态的单据禁止反审核"+"\n";
				num--;
				continue;
			}
			iBEggCandlingBill.unAudit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("反审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("反审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("反审核失败");
			else if(num==0)
				MsgBox.showInfo("反审核失败,没有符合反审核条件的单子");
			else{
				throw new EASBizException(new NumericExceptionSubItem("","操作完成但存在异常，共有"+num+"张单子反审核完成\n"+error));
			}
		}
		finally{
			refreshList();
		}
	
		//		super.actionAudit_actionPerformed(e);
	
    
    
	}
	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

   

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
        String id = this.getSelectedKeyValue();
      //如果生成了落盘单据，则反写字段
        if(StringUtils.isEmpty(id))
        	return;

		String sql="select * from T_BOT_Relation where FSrcObjectID='"+id+"' and FDestEntityID='92957B02' order by FDate desc";
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(rs.size()>0){
			if(rs.next()){
				BEggTrayingBillCollection  collBEggTraying= BEggTrayingBillFactory.getRemoteInstance().getBEggTrayingBillCollection("where id='"+rs.getString("FDestObjectID")+"'");
				if(collBEggTraying.size()>0){
					String str = "update CT_FM_BEggCandlingBill set FIsTraying=1";
					if(collBEggTraying.get(0).getBizDate()!=null)
						str+=",FTrayingDate={ts '"+sdf.format(collBEggTraying.get(0).getBizDate())+"'}";
					str+=" where  fid ='"+id+"'";
					hatchFacadeFactory.getRemoteInstance().excuteSql(str);
				}
			}
		}
    }
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已审核，禁止编辑！");
			SysUtil.abort();
		}
        super.actionEdit_actionPerformed(e);
    }
   

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.BEggCandlingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.BEggCandlingBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggCandlingBillInfo();
		
        return objectValue;
    }
	@Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return false;
	}

}