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
public class AllCompanyCapitalDailyRptDataSource extends AbstractJavaDataSet
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.AllCompanyCapitalDailyRptDataSource");

    // 查询的公司
    private CompanyOrgUnitInfo currCommpany;
    // 查询开始日期
    private Date beginDate;
    // 查询结束日期
    private Date endDate;
    // 是否按集团汇总
    private boolean isAllCompany;
    
    // 数据类别   1：余额  2：发生额
    private String capitalType;
    
    public String getCapitalType() {
		return capitalType;
	}
	public void setCapitalType(String capitalType) {
		this.capitalType = capitalType;
	}
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
	public boolean isAllCompany() {
		return isAllCompany;
	}
	public void setAllCompany(boolean isAllCompany) {
		this.isAllCompany = isAllCompany;
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
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String beginDateStr = "";
				String beginDateStr = (String)filterParamMap.get("beginDate");
//				String endDateStr = "";
				String endDateStr = (String)filterParamMap.get("endDate");
				
				String isAllCompanyStr = (String) filterParamMap.get("isAllCompany");
				
				String capitalType = (String) filterParamMap.get("capitalType");
				
				this.setCapitalType(capitalType);
				
				Boolean isAllCompany = Boolean.FALSE;
				if(StringUtils.isNotBlank(isAllCompanyStr)){
					isAllCompany = Boolean.valueOf(isAllCompanyStr);
				}
				
				if(isAllCompany != null){
					this.setAllCompany(isAllCompany);
				}
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
	 * 获取结果rowset
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private IRowSet getGLRowset() throws BOSException, EASBizException{
		
		int isAllCompany = 0;
		if(this.isAllCompany){
			isAllCompany = 1;
		}
		HashMap result = CapitalDailyRptFacadeFactory.getRemoteInstance().getAllCompanysCapitalDailyInfos(getBeginDate(), getEndDate(),isAllCompany,capitalType);
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