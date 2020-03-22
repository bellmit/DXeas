package com.kingdee.eas.custom.taihe.settle.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormat;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.IBatchContract;
import com.kingdee.eas.custom.taihe.settle.SettleBillCollection;
import com.kingdee.eas.custom.taihe.settle.SettleBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleBillControllerBean extends AbstractSettleBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.settle.app.SettleBillControllerBean");

    
	


	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._unAudit(ctx, model);
		SettleBillInfo info = (SettleBillInfo) model;
		if(info.getBatchContract()!=null) {
			IBatchContract ibc = BatchContractFactory.getLocalInstance(ctx);
			BatchContractInfo batchContract = ibc.getBatchContractInfo(new ObjectUuidPK(info.getBatchContract().getId()));
			BOSUuid batchcontractID = info.getBatchContract().getId();
			
			StringBuffer sql = new StringBuffer();
			String sp = "\n";
			sql.append("select sum(CFQty) QTY from ").append(sp);
			sql.append("CT_SET_SettleBill  ").append(sp);  
			sql.append("where CFbatchContractID ='").append(batchcontractID.toString()).append("'").append(sp);
			sql.append("and FBillStatus = '4'").append(sp);
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			String allQTY = null ;
			try {
				if(rs.next()){
					allQTY = rs.getString("QTY");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(info.isBuyComplete()){
				batchContract.setWhetherClose(true);
			}
			Double DallQTY  = null;
			
				if(batchContract.getInitialCumulativeQty()!=null){
					//初始数量加现在只数
					if(allQTY!=null){
						DallQTY = Double.valueOf(allQTY)+batchContract.getInitialCumulativeQty().doubleValue();
					}else{
						DallQTY = batchContract.getInitialCumulativeQty().doubleValue();
					}
					
				}else{
					if(allQTY==null){
						DallQTY = Double.valueOf("0");
					}else{
						DallQTY = Double.valueOf(allQTY);
					}
					
				}
				double shangmiaoQTY= 0;
				if(batchContract.getInQty()!=null){
					shangmiaoQTY  = batchContract.getInQty().doubleValue();
				}
				
				if(DallQTY==0){
					batchContract.setRecoveredQty(new BigDecimal(0));
					batchContract.setNonRecoveryQty(new BigDecimal(shangmiaoQTY));
					batchContract.setRecoveryRate("0.00%");
					
				}
				
				//以上苗数量
				batchContract.setRecoveredQty(new BigDecimal(DallQTY));
				
				//未上苗数量
				batchContract.setNonRecoveryQty(new BigDecimal(shangmiaoQTY-Double.valueOf(DallQTY)));
				
				if(DallQTY>shangmiaoQTY){
					DecimalFormat df = new DecimalFormat("0.0000");  
					double ccc = DallQTY/shangmiaoQTY;
					String recoveryRateStrat =  df.format(ccc);
						double ratio =  Double.valueOf(recoveryRateStrat)*100;
						BigDecimal now = new BigDecimal(ratio).setScale(2, RoundingMode.HALF_UP);
						String end = now.toString();
						batchContract.setRecoveryRate(end.substring(0,5)+"%");
						
						
				}else{
					DecimalFormat df = new DecimalFormat("0.0000");  
					double ccc = DallQTY/shangmiaoQTY;
					String recoveryRateStrat =  df.format(ccc);
					if(recoveryRateStrat.equals("1.0000")){
						batchContract.setRecoveryRate("100.00%");
					}else{
						String recoveryRateEnd = recoveryRateStrat.substring(recoveryRateStrat.lastIndexOf(".")+1,6);
						String before = null;
						if(recoveryRateEnd.substring(0, 1).equals("0")){
							before = recoveryRateEnd.substring(1, 2)+".";
						}else{
							before = recoveryRateEnd.substring(0, 2)+".";
						}
						
						String after = recoveryRateEnd.substring(2, 4)+"%";
						String now = before+after;
						batchContract.setRecoveryRate(now);
					}
				}
			ibc.save(batchContract);
		}
	}





	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		super._audit(ctx, model);
		SettleBillInfo info = (SettleBillInfo) model;
		if(info.getBatchContract()!=null) {
			IBatchContract ibc = BatchContractFactory.getLocalInstance(ctx);
			BatchContractInfo batchContract = ibc.getBatchContractInfo(new ObjectUuidPK(info.getBatchContract().getId()));
			BOSUuid batchcontractID = info.getBatchContract().getId();
			
			StringBuffer sql = new StringBuffer();
			String sp = "\n";
			sql.append("select sum(CFQty) QTY from ").append(sp);
			sql.append("CT_SET_SettleBill  ").append(sp);  
			sql.append("where CFbatchContractID ='").append(batchcontractID.toString()).append("'").append(sp);
			sql.append("and FBillStatus = '4'").append(sp);
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			String allQTY = null ;
			try {
				if(rs.next()){
					allQTY = rs.getString("QTY");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(info.isBuyComplete()){
				batchContract.setWhetherClose(true);
			}
			
			
			Double DallQTY  = null;
			
				if(batchContract.getInitialCumulativeQty()!=null){
					//初始数量加现在只数
					if(allQTY!=null){
						DallQTY = Double.valueOf(allQTY)+batchContract.getInitialCumulativeQty().doubleValue();
					}else{
						DallQTY = batchContract.getInitialCumulativeQty().doubleValue();
					}
				}else{
					DallQTY = Double.valueOf(allQTY);
				}
				double shangmiaoQTY= 0;
				if(batchContract.getInQty()!=null){
					shangmiaoQTY  = batchContract.getInQty().doubleValue();
				}
				if(DallQTY==0){
					batchContract.setRecoveredQty(new BigDecimal(0));
					batchContract.setNonRecoveryQty(new BigDecimal(shangmiaoQTY));
					batchContract.setRecoveryRate("0.00%");
					
				}
				//以上苗数量
				batchContract.setRecoveredQty(new BigDecimal(DallQTY));
				
				//未上苗数量
				batchContract.setNonRecoveryQty(new BigDecimal(shangmiaoQTY-Double.valueOf(DallQTY)));
				
				if(DallQTY>shangmiaoQTY){
					DecimalFormat df = new DecimalFormat("0.0000");  
					double ccc = DallQTY/shangmiaoQTY;
					String recoveryRateStrat =  df.format(ccc);
						double ratio =  Double.valueOf(recoveryRateStrat)*100;
						BigDecimal now = new BigDecimal(ratio).setScale(2, RoundingMode.HALF_UP);
						String end = now.toString();
						batchContract.setRecoveryRate(end.substring(0,5)+"%");
						
						
				}else{
					DecimalFormat df = new DecimalFormat("0.0000");  
					double ccc = DallQTY/shangmiaoQTY;
					String recoveryRateStrat =  df.format(ccc);
					if(recoveryRateStrat.equals("1.0000")){
						batchContract.setRecoveryRate("100.00%");
					}else{
						String recoveryRateEnd = recoveryRateStrat.substring(recoveryRateStrat.lastIndexOf(".")+1,6);
						String before = null;
						if(recoveryRateEnd.substring(0, 1).equals("0")){
							before = recoveryRateEnd.substring(1, 2)+".";
						}else{
							before = recoveryRateEnd.substring(0, 2)+".";
						}
						
						String after = recoveryRateEnd.substring(2, 4)+"%";
						String now = before+after;
						batchContract.setRecoveryRate(now);
					}
				}
			ibc.save(batchContract);
		}
	}
    
}