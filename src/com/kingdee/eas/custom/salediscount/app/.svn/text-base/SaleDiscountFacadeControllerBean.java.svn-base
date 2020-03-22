package com.kingdee.eas.custom.salediscount.app;

import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
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
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.custom.salediscount.CustomerBalanceInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.jdbc.rowset.IRowSet;


public class SaleDiscountFacadeControllerBean extends AbstractSaleDiscountFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.app.SaleDiscountFacadeControllerBean");

    /**
     * 获取客户的折让余额信息
     */
	@Override
	protected CustomerBalanceInfo _getCustomerBalanceInfo(Context ctx,
			String companyID, String customerID) throws BOSException {
		String sql = "select fid,CFInitBalance,CFNowBalance  from CT_NDI_CustomerBalance where CFCompanyID =? and CFCustomerID =? ";
		String[] args = {companyID,customerID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		if(rs.size() > 1){
			throw new BOSException("当前公司对应客户存在多条折让余额数据，请联系管理员处理");
		}else{
			try{
				if(rs.next()){
					
					String fid = rs.getString("fid");
					BigDecimal nowBalance = rs.getBigDecimal("CFNowBalance");
					BigDecimal initBalance = rs.getBigDecimal("CFInitBalance");
					CustomerBalanceInfo balanceInfo = new CustomerBalanceInfo();
					balanceInfo.setId(BOSUuid.read(fid));
					balanceInfo.setNowBalance(nowBalance);
					balanceInfo.setInitBalance(initBalance);
					CompanyOrgUnitInfo companyInfo = new CompanyOrgUnitInfo();
					companyInfo.setId(BOSUuid.read(companyID));
					balanceInfo.setCompany(companyInfo);
					
					CustomerInfo customerInfo = new CustomerInfo();
					customerInfo.setId(BOSUuid.read(customerID));
					balanceInfo.setCustomer(customerInfo);
					
					
					return balanceInfo;
				}else{
					return null;
				}
				
			}catch(SQLException sqle){
				throw new BOSException(sqle);
			}
		}
	}

	/**
	 * 更新客户余额
	 */
	@Override
	protected ResultInfo<String> _updateCustomerBalance(Context ctx, String companyID,
			String customerID, BigDecimal substractAmount, BigDecimal addAmount)
			throws BOSException {
		ResultInfo<String> upResult = new ResultInfo<String>();
		StringBuilder sb = new StringBuilder();
		sb.append("update CT_NDI_CustomerBalance set CFNowBalance = CFNowBalance ");
		if(substractAmount != null){
			sb.append("-");
			sb.append(substractAmount.toPlainString());
			
		}else if(addAmount != null){
			sb.append("+");
			sb.append(addAmount.toPlainString());
		}else{
			return upResult;
		}
		
		sb.append(" where CFCompanyID ='");
		sb.append(companyID);
		sb.append("' and CFCustomerID='");
		sb.append(customerID);
		sb.append("'");
		
		DbUtil.execute(ctx, sb.toString());
		
		upResult.setSuccess(true);
		upResult.setMessage("更新完成");
		return upResult;
	}

	/**
	 * 重算客户余额
	 */
	@Override
	protected ResultInfo<String> _recountCustomerBalance(Context ctx, String companyID,
			String customerID) throws BOSException {
		ResultInfo<String> upResult = new ResultInfo<String>();
		StringBuilder sb = new StringBuilder();
		
		
		return upResult;
	}
	
	
	
}