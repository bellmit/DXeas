package com.kingdee.eas.WSInterface.billFacade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.batch.BatchExecuteParamsEntry;
import com.kingdee.bos.framework.batch.BatchExecuteResult;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.master.account.AccountViewFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.cas.BillStatusEnum;

import com.kingdee.eas.fi.cas.IReceivingBill;
import com.kingdee.eas.fi.cas.ReceivingBillCollection;
import com.kingdee.eas.fi.cas.ReceivingBillEntryInfo;
import com.kingdee.eas.fi.cas.ReceivingBillFactory;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillTypeFactory;
import com.kingdee.eas.fi.cas.SourceTypeEnum;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.util.BaseException;

public class ReceiveBillSupport implements IBillSupport {
	protected BigDecimal zero;
	private Context ctx;

	public ReceiveBillSupport() {
		// TODO Auto-generated constructor stub
	}

	public Class getInfoClass() {
		return ReceivingBillInfo.class;
	}

	public List audit(List list) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSupportAudit() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSupportSubmit() {
		// TODO Auto-generated method stub
		return true;
	}

	public List save(AbstractObjectCollection col) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		return saveOrSubmitData(col, false);
	}

	public void setContext(Context ctx) {
		// TODO Auto-generated method stub
		this.ctx = ctx;
	}

	public Context getContext() {
		return ctx;
	}

	public List submit(AbstractObjectCollection col) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		return saveOrSubmitData(col, true);
	}

	private List saveOrSubmitData(AbstractObjectCollection col, boolean isSave) throws BOSException, EASBizException {
		List results = new ArrayList();
		ReceivingBillInfo info = null;
		int i = 0;
		for (int size = col.size(); i < size; i++) {
			info = (ReceivingBillInfo) col.getObject(i);
			List errorMsg = setData(ctx, info);
			if (errorMsg != null && errorMsg.size() > 0) {
				BillResultInfo result = new BillResultInfo();
				result.setErrorMsgs(errorMsg);
				result.setNumber(info.getNumber());
				result.setStatus(1);
				results.add(result);
				continue;
			}
			//**********
			BillResultInfo resultInfo = new BillResultInfo();
			resultInfo.setNumber(info.getNumber());
			try{
				IObjectPK pk = new ObjectUuidPK();
				
				IOrgSwitchFacade orgFacade=OrgSwitchFacadeFactory.getLocalInstance(ctx);
				orgFacade.orgSwitch(info.getCompany().getId().toString());//切换CU
//		info.setCompany(CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(info.getCU().getId())));
				
				info.setSourceType(com.kingdee.eas.fi.cas.SourceTypeEnum.AR);
				info.setSourceSysType(com.kingdee.eas.fi.cas.SourceTypeEnum.AR);
				boolean exist = BaseBillImportUtils.checkBillNumberExist(ctx, info.getBOSType(), info.getNumber());
				if(exist){
					errorMsg.add("单据编号" + info.getNumber() +"已经存在不能重复导入");
					resultInfo.setErrorMsgs(errorMsg);
					resultInfo.setStatus(1);
				}else{
					
					BillStatusEnum status = info.getBillStatus();
					info.setSourceType(SourceTypeEnum.AR);
					info.setSourceSysType(SourceTypeEnum.AR);
					
					if(info.getRecBillType() != null && info.getRecBillType().getId() != null){
						info.setRecBillType(ReceivingBillTypeFactory.getLocalInstance(ctx).getReceivingBillTypeInfo(new ObjectUuidPK(info.getRecBillType().getId())));
					}
//					// 科目
					if(info.getPayeeAccount() != null){
						AccountViewInfo avInfo = AccountViewFactory.getLocalInstance(ctx).getAccountViewInfo("select id,companyid where number='" + info.getPayeeAccount().getNumber() + "' and companyid='" + info.getCompany().getId().toString() + "'");
						info.setPayeeAccount(avInfo);
					}
					
					// 校验期间
					Date billDate = info.getBizDate();
					if(billDate == null){
						throw new Exception("单据日期不能为空");
					}
//					PeriodInfo periodInfo = SystemStatusCtrolUtils.getCurrentPeriod(ctx, SystemEnum.ACCOUNTSRECEIVABLE, info.getCompany());
//					if(periodInfo != null){
//						Date beginDate = periodInfo.getBeginDate();
//						Date endDate = periodInfo.getEndDate();
//						// 单据日期在 期间范围外 抛出异常
//						if(billDate.before(beginDate) || billDate.after(endDate)){
//							throw new Exception("当前单据日期" + billDate.toString() + "在单据公司当前期间范围外，不允许导入");
//						}
//					}else{
//						throw new Exception("未取得当前单据对应公司的 应付期间");
//					}
					
					
					if(BillStatusEnum.SAVE.equals(status)){
						
						pk=getInterface().save(info);//(CoreBaseInfo) col.getObject(i)
					}else if(BillStatusEnum.SUBMIT.equals(status)){
						pk=getInterface().submit(info);//(CoreBaseInfo) col.getObject(i)
					}else if(BillStatusEnum.AUDITED.equals(status)){
						info.setBillStatus(BillStatusEnum.SUBMIT);
						pk=getInterface().submit(info);//(CoreBaseInfo) col.getObject(i)
						try{
							// 审核
							getInterface().audit4WF(pk);
						}catch(Exception e){
							getInterface().delete(pk);
							pk = null;
							throw new Exception("审核时报错" + e.getMessage());
						}
					}else{
						errorMsg.add("单据状态只能传入保存、提交、审核三种");
						resultInfo.setErrorMsgs(errorMsg);
						resultInfo.setId("");
						resultInfo.setStatus(1);
					}
					if(pk != null){
						//resultInfo.setErrorMsgs("SUCCESS");
						resultInfo.setId(pk.toString());
						resultInfo.setStatus(0);
					}
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				errorMsg.add(e.getMessage());
				resultInfo.setErrorMsgs(errorMsg);
				resultInfo.setStatus(1);
				//results.add(resultInfo);
			}
			results.add(resultInfo);
			//**************
		}
		return results;
	}

	public IReceivingBill getInterface() throws BOSException {
		return ReceivingBillFactory.getLocalInstance(getContext());
	}
	
	private List setData(Context ctx, ReceivingBillInfo info) throws BOSException, EASBizException {
		List errorMsg = new ArrayList();
		dealWithData(ctx, info, errorMsg);
		setDefaultData(info, errorMsg);
		verifyData(info, errorMsg);
		return errorMsg;
	}
	protected void setDefaultData(ReceivingBillInfo model, List errorMsg) throws BOSException, EASBizException {
		setDefaultHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			ReceivingBillEntryInfo entryInfo = (ReceivingBillEntryInfo) entries.getObject(i);
			setDefaultEntryData(entryInfo, model, errorMsg);
		}

	}

	/**
	 * 单据头默认值
	 * @param info
	 * @param errorMsg
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected void setDefaultHeadData(ReceivingBillInfo info, List errorMsg) throws BOSException, EASBizException {
		if (info.getBizDate() == null)
			info.setBizDate(new Date());
	}

	/**
	 * 单据体默认值
	 * @param ReceivingBillEntryInfo
	 * @param ReceivingBillInfo
	 * @param list
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected void setDefaultEntryData(ReceivingBillEntryInfo ReceivingBillEntryInfo, ReceivingBillInfo ReceivingBillInfo,
			List list) throws BOSException, EASBizException {
		
	}

	protected void dealWithData(Context ctx, ReceivingBillInfo model, List errorMsg) throws BOSException, EASBizException {
		dealWithHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			ReceivingBillEntryInfo entryInfo = (ReceivingBillEntryInfo) entries.getObject(i);
			dealWithEntryData(entryInfo, model, errorMsg);
		}
		BaseBillImportUtils.setInfoByNumber(ctx, model, errorMsg);
	}
	protected void dealWithHeadData(ReceivingBillInfo model, List list) throws BOSException, EASBizException {
		ReceivingBillInfo info = (ReceivingBillInfo)model;
        /*if(info.getPurchaseGroup() != null)
        {
            ScmbillImportUtils.setDataBaseInfo(getContext(), info, errorMsg, "purchaseGroup", info.getPurchaseGroup());
            if(info.getPurchaseGroup() != null && info.getPurchasePerson() != null)
                setPurchasePersonByNumber(info, errorMsg);
        }
        info.setSupplierConfirm(false);*/
	}

	protected void dealWithEntryData(ReceivingBillEntryInfo ReceivingBillEntryInfo, ReceivingBillInfo ReceivingBillInfo,
			List list) throws BOSException, EASBizException {
	}

	protected void verifyData(ReceivingBillInfo model, List errorMsg) throws BOSException, EASBizException {
		verifyHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			ReceivingBillEntryInfo entryInfo = (ReceivingBillEntryInfo) entries.getObject(i);
			verifyEntryData(entryInfo, model, errorMsg);
		}

	}

	protected void verifyHeadData(ReceivingBillInfo ReceivingBillInfo, List list) throws BOSException, EASBizException {
	}

	protected void verifyEntryData(ReceivingBillEntryInfo ReceivingBillEntryInfo, ReceivingBillInfo ReceivingBillInfo, List list)
			throws BOSException, EASBizException {
	}
}
