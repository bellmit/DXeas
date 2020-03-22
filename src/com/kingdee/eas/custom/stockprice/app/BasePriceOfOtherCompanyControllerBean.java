package com.kingdee.eas.custom.stockprice.app;

import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectValue;

import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyFactory;
import com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo;
import com.kingdee.eas.custom.stockprice.billStatus;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BasePriceOfOtherCompanyControllerBean extends AbstractBasePriceOfOtherCompanyControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.stockprice.app.BasePriceOfOtherCompanyControllerBean");

	@Override
	protected void _getAllMaterial(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void _expModel(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}
	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(!billStatus.save.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		if(isExist(info,ctx))
			throw new EASBizException(new NumericExceptionSubItem("001","已存在当前公司在该日期下的基本价格单"));
		if(info.getEntrys().size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","单据没有分录"));
		info.setBillStatus(billStatus.save);
		return super._save(ctx, model);
	}

	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		if(isExist(info,ctx))
			throw new EASBizException(new NumericExceptionSubItem("001","已存在当前公司在该日期下的基本价格单"));
		if(info.getEntrys().size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","单据没有分录"));
		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}

	/**
	 * 检查当前公司下的在该日期的单据是否已存在
	 * @param info
	 * @return
	 * @throws BOSException 
	 */
	private boolean isExist(BasePriceOfOtherCompanyInfo info,Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		String str="select * from T_STO_BasePriceOfOtherCompany where fcompany=? and to_char(feffectDate,'yyyy-MM-dd')=?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String [] args={info.getCompany(),sdf.format(info.getBizDate())};
		IRowSet rs = DbUtil.executeQuery(ctx, str,args);
		try {
			if(rs.next())
				if(info.getId()==null)
					return true;
				else if(!rs.getString("fid").equals(info.getId().toString()))
					return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		if(pk==null)
			return;
		BasePriceOfOtherCompanyInfo info = BasePriceOfOtherCompanyFactory.getLocalInstance(ctx).getBasePriceOfOtherCompanyInfo(pk);
		if(billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许删除"));
		super._delete(ctx, pk);
	}

	@Override
	protected void _impExcel(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}

	/**
	 * 审核
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(!billStatus.submit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许审核提交状态的单据"));
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		info.setAuditor(user);
		info.setAuditDate(date);
		info.setBillStatus(billStatus.audit);
		super._save(ctx,  info);
	}

	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(!billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许反审核"));
		info.setBillStatus(billStatus.save);
		info.setAuditor(null);
		info.setAuditDate(null);
		super._save(ctx,  info);
	}
	
}