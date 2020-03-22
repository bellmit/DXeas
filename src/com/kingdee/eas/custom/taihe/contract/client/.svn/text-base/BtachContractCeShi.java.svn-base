package com.kingdee.eas.custom.taihe.contract.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.settlebill.ISettleBillFacde;
import com.kingdee.eas.custom.settlebill.SettleBillFacdeFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.IBatchContract;
import com.kingdee.eas.custom.taihe.settle.SettleBillFactory;
import com.kingdee.eas.custom.taihe.settle.SettleBillInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class BtachContractCeShi {
	public void ceshi(){
		//StringBuffer sql = new StringBuffer();
		String sp = "\n";
		String sqla = "select FID from CT_SET_SettleBill";
		try {
			IRowSet rsa = SQLExecutorFactory.getRemoteInstance(sqla).executeSQL();
			while(rsa.next()){
				SettleBillInfo info = SettleBillFactory.getRemoteInstance().getSettleBillInfo(new ObjectUuidPK(rsa.getString("FID")));
				
				if(info.getBatchContract()!=null) {
					IBatchContract ibc = BatchContractFactory.getRemoteInstance();
					BatchContractInfo batchContract = ibc.getBatchContractInfo(new ObjectUuidPK(info.getBatchContract().getId()));
					BOSUuid batchcontractID = info.getBatchContract().getId();
					
					StringBuffer sqlb = new StringBuffer();
					sqlb.append("select sum(CFQty) QTY from ").append(sp);
					sqlb.append("CT_SET_SettleBill  ").append(sp);  
					sqlb.append("where CFbatchContractID ='").append(batchcontractID.toString()).append("'").append(sp);
					sqlb.append("and FBillStatus = '4'").append(sp);
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlb.toString()).executeSQL();
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
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
