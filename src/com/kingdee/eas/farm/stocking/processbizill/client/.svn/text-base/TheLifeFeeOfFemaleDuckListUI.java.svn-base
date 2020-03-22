/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.basedata.framework.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.breed.layegg.BillStatus;
import com.kingdee.eas.farm.breed.layegg.ILifeFee;
import com.kingdee.eas.farm.breed.layegg.LifeFeeFactory;
import com.kingdee.eas.farm.breed.layegg.LifeFeeInfo;
import com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckFactory;
import com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class TheLifeFeeOfFemaleDuckListUI extends AbstractTheLifeFeeOfFemaleDuckListUI
{
	private static final Logger logger = CoreUIObject.getLogger(TheLifeFeeOfFemaleDuckListUI.class);

	/**
	 * output class constructor
	 */
	public TheLifeFeeOfFemaleDuckListUI() throws Exception
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckFactory.getRemoteInstance();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//修改图标
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		ITheLifeFeeOfFemaleDuck iLifeFee = TheLifeFeeOfFemaleDuckFactory.getRemoteInstance();

		TheLifeFeeOfFemaleDuckInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iLifeFee.getTheLifeFeeOfFemaleDuckInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillStatus.submit)){
				error+=info.getString("number")+"\t"+"非提交状态的单据禁止审核"+"\n";
				num--;
				continue;
			}
			iLifeFee.audit(info);
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("审核成功");
			else if(num==selIDs.length)
				MsgBox.showInfo("审核成功(操作单子数:"+selIDs.length+")");
			else if(num==0&&selIDs.length==1)
				MsgBox.showInfo("审核失败");
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
		// TODO Auto-generated method stub

		checkSelected();

		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());

		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		SCMClientUtils.checkCurrentBillIsInActiveWorkFlow(selIDs);
		ITheLifeFeeOfFemaleDuck iLifeFee = TheLifeFeeOfFemaleDuckFactory.getRemoteInstance();

		TheLifeFeeOfFemaleDuckInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iLifeFee.getTheLifeFeeOfFemaleDuckInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillStatus.audit)){
				error+=info.getString("number")+"\t"+"非审核状态的单据禁止反审核"+"\n";
				num--;
				continue;
			}
			iLifeFee.unAudit(info);
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
		}finally{
			refreshList();
		}

		//		super.actionAudit_actionPerformed(e);
	}

	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,
			EntityViewInfo viewInfo) {
		// TODO Auto-generated method stub
		SorterItemCollection sic=viewInfo.getSorter();
		viewInfo.getSorter().clear();
		SorterItemInfo si =new SorterItemInfo("number");
		si.setSortType(SortType.DESCEND);
		sic.add(si);

		SorterItemInfo seq =new SorterItemInfo("entrys.seq");
		si.setSortType(SortType.ASCEND);
		sic.add(seq);

		viewInfo.setSorter(sic);
		return super.getQueryExecutor(queryPK, viewInfo);
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filterInfo = super.getDefaultFilterForQuery();
		System.out.println(filterInfo);
		return filterInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCreateTo_actionPerformed(e);
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckInfo();

		return objectValue;
	}

}