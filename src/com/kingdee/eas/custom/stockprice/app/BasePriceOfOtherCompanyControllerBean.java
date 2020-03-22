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
	 * ����
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(!billStatus.save.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","����״̬��������"));
		if(isExist(info,ctx))
			throw new EASBizException(new NumericExceptionSubItem("001","�Ѵ��ڵ�ǰ��˾�ڸ������µĻ����۸�"));
		if(info.getEntrys().size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","����û�з�¼"));
		info.setBillStatus(billStatus.save);
		return super._save(ctx, model);
	}

	/**
	 * �ύ
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","����״̬�������ύ"));
		if(isExist(info,ctx))
			throw new EASBizException(new NumericExceptionSubItem("001","�Ѵ��ڵ�ǰ��˾�ڸ������µĻ����۸�"));
		if(info.getEntrys().size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","����û�з�¼"));
		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}

	/**
	 * ��鵱ǰ��˾�µ��ڸ����ڵĵ����Ƿ��Ѵ���
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
	 * ɾ��
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		if(pk==null)
			return;
		BasePriceOfOtherCompanyInfo info = BasePriceOfOtherCompanyFactory.getLocalInstance(ctx).getBasePriceOfOtherCompanyInfo(pk);
		if(billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","����״̬������ɾ��"));
		super._delete(ctx, pk);
	}

	@Override
	protected void _impExcel(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}

	/**
	 * ���
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(!billStatus.submit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","ֻ��������ύ״̬�ĵ���"));
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		info.setAuditor(user);
		info.setAuditDate(date);
		info.setBillStatus(billStatus.audit);
		super._save(ctx,  info);
	}

	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasePriceOfOtherCompanyInfo info = (BasePriceOfOtherCompanyInfo)model;
		if(!billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","����״̬���������"));
		info.setBillStatus(billStatus.save);
		info.setAuditor(null);
		info.setAuditDate(null);
		super._save(ctx,  info);
	}
	
}