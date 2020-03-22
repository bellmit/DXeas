package com.kingdee.eas.farm.rpt.app;

import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.rpt.CapitalDailyRptFacadeFactory;
import com.kingdee.eas.fi.gl.GLReportJournalFacadeFactory;
import com.kingdee.eas.fi.gl.IGLReport;
import com.kingdee.eas.rpts.ctrlsqldesign.param.AbstractJavaDataSet;
import com.kingdee.jdbc.rowset.IRowSet;
public class CapitalDailyRptDataSource extends AbstractJavaDataSet
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CapitalDailyRptDataSource");

    // 查询的公司
    private CompanyOrgUnitInfo currCommpany;
    // 查询开始日期
    private Date beginDate;
    // 查询结束日期
    private Date endDate;
    
    public void setCurrCommpany(CompanyOrgUnitInfo currCommpany) {
		this.currCommpany = currCommpany;
	}
	public CompanyOrgUnitInfo getCurrCommpany() {
		return currCommpany;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	/**
     * 返回rowset类型的结果
     */
	@Override
	public IRowSet[] getCustomRowSet(Window parent, String otherDataCenter)
			throws Exception {
		
		try {
			// 获取公司和 日期
//			if(filterParamMap != null){
				String companyID =  (String) filterParamMap.get("companyID");
				if(StringUtils.isNotBlank(companyID)){
					this.setCurrCommpany(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyID)));
				}else{
					// 默认食品厂
					this.setCurrCommpany(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK("at4AAAAAAHDM567U")));
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String beginDateStr = "";
				String beginDateStr = (String)filterParamMap.get("beginDate");
//				String endDateStr = "";
				String endDateStr = (String)filterParamMap.get("endDate");
				
				if(StringUtils.isNotBlank(endDateStr)){
					this.setEndDate(sdf.parse(endDateStr));
				}else{
					this.setEndDate(new Date());
				}
				if(StringUtils.isNotBlank(beginDateStr)){
					this.setBeginDate(sdf.parse(beginDateStr));
				}else{
					this.setBeginDate(new Date());
				}
				
				
				
				
//			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		// 结果集
		IRowSet[] rowsets = new IRowSet[1];
		
		
		IRowSet rowset = getGLRowset();
		
		
		rowsets[0] = rowset;
		return rowsets;
	}
	
	
	@Override
	public void setFilterParam(Map filterParamMap) {
		// TODO Auto-generated method stub
		super.setFilterParam(filterParamMap);
	}
	/**
	 * 返回sql类型的返回值
	 */
	@Override
	public String getCustomSQL(Window parent) throws Exception {

		try {
			// 获取公司和 日期
//			if(filterParamMap != null){
				String companyID =  "";
				if(StringUtils.isNotBlank(companyID)){
					
						this.setCurrCommpany(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyID)));
				
				}else{
					// 默认食品厂
					this.setCurrCommpany(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK("at4AAAAAAHDM567U")));
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String beginDateStr = "";//(String)filterParamMap.get("beginDate");
				String endDateStr = "";//(String)filterParamMap.get("endDate");
				
					if(StringUtils.isNotBlank(endDateStr)){
						this.setEndDate(sdf.parse(endDateStr));
					}else{
						this.setEndDate(new Date());
					}
					if(StringUtils.isNotBlank(beginDateStr)){
						this.setBeginDate(sdf.parse(beginDateStr));
					}else{
						this.setBeginDate(new Date());
					}
				
				
				
				
//			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		// 结果集
//		IRowSet[] rowsets = new IRowSet[1];
		
		
//		IRowSet rowset = getGLRowset();
		HashMap result = CapitalDailyRptFacadeFactory.getRemoteInstance().getCapitalDailyInfos(getBeginDate(), getEndDate(), this.getCurrCommpany().getId().toString());
		String  temptable = (String) result.get("temptable");
		return "select * from " + temptable;
		
//		rowsets[0] = rowset;
//		return rowsets;
	}
	/**
	 * 获取结果rowset
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private IRowSet getGLRowset() throws BOSException, EASBizException{
		
		HashMap result = CapitalDailyRptFacadeFactory.getRemoteInstance().getCapitalDailyInfos(getBeginDate(), getEndDate(), this.getCurrCommpany().getId().toString());
		IRowSet rs = (IRowSet) result.get("rowset");
		return rs;
		
		
	}
	/**
	 * 
	 */
	public boolean isUIType()
	{
		return false;
	}

	/**
	 * 获取 本地接口
	 * @return
	 * @throws BOSException
	 */
	protected IGLReport getRptLocalInstance(Context ctx) throws BOSException
	{
	     return GLReportJournalFacadeFactory.getLocalInstance(ctx);
	}
	
	/**
	 * 获取 远程接口
	 * @return
	 * @throws BOSException
	 */
	protected IGLReport getRptRemoteInstance() throws BOSException
	{
	     return GLReportJournalFacadeFactory.getRemoteInstance();
	}
    
}