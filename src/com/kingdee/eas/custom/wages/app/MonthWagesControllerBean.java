package com.kingdee.eas.custom.wages.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.custom.wages.MonthWagesEntryCollection;
import com.kingdee.eas.custom.wages.MonthWagesEntryInfo;
import com.kingdee.eas.custom.wages.MonthWagesInfo;
import com.kingdee.eas.custom.wages.MonthlysalarybillInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseControllerBean;
import com.kingdee.eas.custom.wages.MonthWagesCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthWagesControllerBean extends AbstractMonthWagesControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.app.MonthWagesControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		MonthWagesInfo info  = (MonthWagesInfo) model;
		//writeGWBZ(ctx,info.getId());
		super._audit(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MonthWagesInfo info  = (MonthWagesInfo) model;
		//unwriteGWBZ(ctx,info.getId());
		super._unAudit(ctx, model);
	}
    //…Û∫À∑¥–¥∏⁄Œª≤π÷˙ ΩÈ…‹∑—
	private void writeGWBZ(Context ctx, BOSUuid uuid){
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.append("select CFpersonID,CFIntroduceWages ΩÈ…‹∑—,CFpostWages ∏⁄Œª≤π÷˙ from CT_WAG_MonthWagesEntry ");
		sb.append("where FParentID = '").append(uuid.toString()).append("' and (CFIntroduceWages <> 0 or CFpostWages <> 0)");
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			while(rs.next()){
				if(!rs.getString("ΩÈ…‹∑—").equals("0")){
					StringBuffer postsb = new StringBuffer();
					postsb.append("update CT_WAG_MiddlemanFeeBillentry set CFAlreadyMonth  = CFAlreadyMonth+1,CFAlreadyMoney = (CFAlreadyMonth+1)*CFallMoney/CFAllMonth ");
					postsb.append("where  CFPersonID = '").append(rs.getString("CFpersonID")).append("'");
					DbUtil.execute(ctx, postsb.toString());
				}
				if(!rs.getString("∏⁄Œª≤π÷˙").equals("0")){
					StringBuffer introducesb = new StringBuffer();
					introducesb.append("update CT_WAG_PostSubsidyentry set CFAlreadyMonth  = CFAlreadyMonth+1,CFAlreadyMoney = (CFAlreadyMonth+1)*CFallMoney/CFAllMonth ");
					introducesb.append("where  CFPersonID = '").append(rs.getString("CFpersonID")).append("'");
					DbUtil.execute(ctx, introducesb.toString());
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //∑¥…Û∫À∑¥–¥∏⁄Œª≤π÷˙ ΩÈ…‹∑—
	private void unwriteGWBZ(Context ctx, BOSUuid uuid){
		StringBuffer sb = new StringBuffer();
		sb.append("");
		sb.append("select CFpersonID,CFIntroduceWages ΩÈ…‹∑—,CFpostWages ∏⁄Œª≤π÷˙ from CT_WAG_MonthWagesEntry ");
		sb.append("where FParentID = '").append(uuid.toString()).append("' and (CFIntroduceWages <> 0 or CFpostWages <> 0)");
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			while(rs.next()){
				if(!rs.getString("ΩÈ…‹∑—").equals("0")){
					StringBuffer postsb = new StringBuffer();
					postsb.append("update CT_WAG_MiddlemanFeeBillentry set CFAlreadyMonth  = CFAlreadyMonth-1,CFAlreadyMoney = (CFAlreadyMonth-1)*CFallMoney/CFAllMonth ");
					postsb.append("where  CFPersonID = '").append(rs.getString("CFpersonID")).append("'");
					DbUtil.execute(ctx, postsb.toString());
				}
				if(!rs.getString("∏⁄Œª≤π÷˙").equals("0")){
					StringBuffer introducesb = new StringBuffer();
					introducesb.append("update CT_WAG_PostSubsidyentry set CFAlreadyMonth  = CFAlreadyMonth-1,CFAlreadyMoney = (CFAlreadyMonth-1)*CFallMoney/CFAllMonth ");
					introducesb.append("where  CFPersonID = '").append(rs.getString("CFpersonID")).append("'");
					DbUtil.execute(ctx, introducesb.toString());
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Ã·Ωª
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MonthWagesInfo info  = (MonthWagesInfo) model;
//		BigDecimal sumWages = new BigDecimal("0");
//		MonthWagesEntryCollection infoec = info.getEntry();
//		for(int i=0;i<infoec.size();i++){
//			MonthWagesEntryInfo infoe = infoec.get(i);
//		}
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}
}