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
import com.kingdee.eas.WSInterface.common.WsCommonUtil;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.ap.IOtherBill;
import com.kingdee.eas.fi.ap.OtherBillFactory;
import com.kingdee.eas.fi.ap.OtherBillInfo;
import com.kingdee.eas.fi.ap.OtherBillentryInfo;
import com.kingdee.eas.fi.ar.BillStatusEnum;
import com.kingdee.util.BaseException;
/**
 * 应付单
 * @author DAD
 *
 */
public class APOthertBillSupport implements IBillSupport {
	protected BigDecimal zero;
	private Context ctx;

	public APOthertBillSupport() {
		// TODO Auto-generated constructor stub
	}

	public Class getInfoClass() {
		return OtherBillInfo.class;
	}

	public List audit(List results) throws EASBizException, BOSException {
		BatchExecuteResult result = null;
		BatchExecuteParamsEntry paramEntries[] = new BatchExecuteParamsEntry[results.size()];
		BatchExecuteParamsEntry entry = null;
		for (int i = 0; i < results.size(); i++) {
			BillResultInfo resultInfo = (BillResultInfo) results.get(i);
			if (resultInfo != null && resultInfo.getStatus() == 0) {
				String billid = resultInfo.getId();
				entry = new BatchExecuteParamsEntry(new Class[] { com.kingdee.bos.dao.IObjectPK.class });
				entry.add(new ObjectUuidPK(billid));
				paramEntries[i] = entry;
			}
		}

		Class batchMethod[] = { com.kingdee.bos.dao.IObjectPK.class };
		String methodPK = "audit";
		try {
			result = getInterface().batchExecute(methodPK, batchMethod, paramEntries);
		} catch (BaseException e) {
			throw new BOSException(e);
		}
		Object objs[] = result.getReturnValues();
		int i = 0;
		for (int size = objs.length; i < size; i++) {
			List errorMsg = new ArrayList();
			BillResultInfo resultInfo = new BillResultInfo();
			if (result.getException(i) == null) {
				resultInfo.setId(result.getReturnValue(i).toString());
				resultInfo.setStatus(0);
			} else {
				errorMsg.add(result.getException(i).getMessage());
				resultInfo.setErrorMsgs(errorMsg);
				resultInfo.setStatus(1);
			}
			results.add(resultInfo);
		}

		return results;
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
		return saveOrSubmitData(col, true);
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
		return saveOrSubmitData(col, false);
	}

	private List saveOrSubmitData(AbstractObjectCollection col, boolean isSave) throws BOSException, EASBizException {
		List results = new ArrayList();
		OtherBillInfo info = null;
		int i = 0;
		
		for (int size = col.size(); i < size; i++) {
			info = (OtherBillInfo) col.getObject(i);
			List errorMsg = setData(ctx, info);
			if (errorMsg != null && errorMsg.size() > 0) {
				BillResultInfo result = new BillResultInfo();
				result.setErrorMsgs(errorMsg);
				result.setNumber(info.getNumber());
				result.setStatus(1);
				results.add(result);
				continue;
//				col.removeObject(i);
//				i--;
//				size--;
			}
			//**********
			BillResultInfo resultInfo = new BillResultInfo();
			resultInfo.setNumber(info.getNumber());
			try{
				
				IOrgSwitchFacade orgFacade=OrgSwitchFacadeFactory.getLocalInstance(ctx);
				orgFacade.orgSwitch(info.getCompany().getId().toString());//切换CU
				
				boolean exist = BaseBillImportUtils.checkBillNumberExist(ctx, info.getBOSType(), info.getNumber());
				// TODO
				if(exist){
					errorMsg.add("单据编号" + info.getNumber() +"已经存在不能重复导入");
					resultInfo.setErrorMsgs(errorMsg);
					resultInfo.setStatus(1);
				}else{
					String number = info.getNumber();
					IObjectPK pk = new ObjectUuidPK();
					com.kingdee.eas.fi.ar.BillStatusEnum status =  info.getBillStatus();
					
					// 校验期间
					Date billDate = info.getBizDate();
					if(billDate == null){
						throw new Exception("单据日期不能为空");
					}
//					PeriodInfo periodInfo = SystemStatusCtrolUtils.getCurrentPeriod(ctx, SystemEnum.ACCOUNTSPAYABLE, info.getCompany());
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
//					info.setBoolean("isAutoGenerate", Boolean.FALSE);
					
					
					info.put("isAutoGenerate", Boolean.FALSE);
					if(BillStatusEnum.SAVE.equals(status)){
						pk = OtherBillFactory.getLocalInstance(ctx).save(info);
						WsCommonUtil.updateBillNumber(ctx, "t_ap_otherbill", pk.toString(), number);
					}else if(BillStatusEnum.SUBMITED.equals(status)){
						pk = OtherBillFactory.getLocalInstance(ctx).submit(info);
						WsCommonUtil.updateBillNumber(ctx, "t_ap_otherbill", pk.toString(), number);
					}else if(BillStatusEnum.AUDITED.equals(status)){
						info.setBillStatus(BillStatusEnum.SUBMITED);
						pk =  OtherBillFactory.getLocalInstance(ctx).submit(info);
						
						WsCommonUtil.updateBillNumber(ctx, "t_ap_otherbill", pk.toString(), number);
						try{
							
							OtherBillInfo billInfo = OtherBillFactory.getLocalInstance(ctx).getOtherBillInfo(pk);
							if(BillStatusEnum.SUBMITED.equals(billInfo.getBillStatus())){
								// 审核
								OtherBillFactory.getLocalInstance(ctx).audit(pk);
							}
						}catch(Exception e){
							e.printStackTrace();
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
			}
			results.add(resultInfo);
			//**************
			
		}
		
		/*if (col != null && col.size() > 0) {
			BatchExecuteResult result = null;
			BatchExecuteParamsEntry paramEntries[] = new BatchExecuteParamsEntry[col.size()];
			BatchExecuteParamsEntry entry = null;
			int k = 0;
			for (int size = col.size(); k < size; k++) {
				entry = new BatchExecuteParamsEntry(new Class[] { com.kingdee.eas.framework.CoreBaseInfo.class });
				entry.add(col.getObject(k));
				paramEntries[k] = entry;
			}

			Class batchMethod[] = { com.kingdee.eas.framework.CoreBaseInfo.class };
			String methodPK = "submit";
			if (isSave)
				methodPK = "save";
			try {
				result = getInterface().batchExecute(methodPK, batchMethod, paramEntries);
			} catch (BaseException e) {
				throw new BOSException(e);
			}
			Object objs[] = result.getReturnValues();
			int j = 0;
			for (int size = objs.length; j < size; j++) {
				info = (OtherBillInfo) col.getObject(j);
				List errorMsg = new ArrayList();
				BillResultInfo resultInfo = new BillResultInfo();
				resultInfo.setNumber(info.getNumber());
				if (result.getException(j) == null) {
					resultInfo.setId(result.getReturnValue(j).toString());
					resultInfo.setStatus(0);
				} else {
					errorMsg.add(result.getException(j).getMessage());
					resultInfo.setErrorMsgs(errorMsg);
					resultInfo.setStatus(1);
				}
				results.add(resultInfo);
			}

		}*/
		return results;
	}

	public IOtherBill getInterface() throws BOSException {
		return OtherBillFactory.getLocalInstance(getContext());
	}
	
	private List setData(Context ctx, OtherBillInfo info) throws BOSException, EASBizException {
		List errorMsg = new ArrayList();
		dealWithData(ctx, info, errorMsg);
		setDefaultData(info, errorMsg);
		verifyData(info, errorMsg);
		return errorMsg;
	}
	protected void setDefaultData(OtherBillInfo model, List errorMsg) throws BOSException, EASBizException {
		setDefaultHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntry();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			OtherBillentryInfo entryInfo = (OtherBillentryInfo) entries.getObject(i);
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
	protected void setDefaultHeadData(OtherBillInfo info, List errorMsg) throws BOSException, EASBizException {
		if (info.getBizDate() == null)
			info.setBizDate(new Date());
	}

	/**
	 * 单据体默认值
	 * @param OtherBillentryInfo
	 * @param OtherBillInfo
	 * @param list
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected void setDefaultEntryData(OtherBillentryInfo entryInfo, OtherBillInfo OtherBillInfo,
			List errorMsg) throws BOSException, EASBizException {
		
		if(entryInfo.getMaterial() != null)
        {
            entryInfo.setBaseUnit(entryInfo.getMaterial().getBaseUnit());
            //setBaseQty(entryInfo, errorMsg);
            //setStandardCost(entryInfo, errorMsg);
        }
	}

	protected void dealWithData(Context ctx, OtherBillInfo model, List errorMsg) throws BOSException, EASBizException {
		dealWithHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntry();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			OtherBillentryInfo entryInfo = (OtherBillentryInfo) entries.getObject(i);
			dealWithEntryData(entryInfo, model, errorMsg);
		}
		BaseBillImportUtils.setInfoByNumber(ctx, model, errorMsg);
	}
	protected void dealWithHeadData(OtherBillInfo model, List list) throws BOSException, EASBizException {
//		OtherBillInfo info = (OtherBillInfo)model;
        /*if(info.getPurchaseGroup() != null)
        {
            ScmbillImportUtils.setDataBaseInfo(getContext(), info, errorMsg, "purchaseGroup", info.getPurchaseGroup());
            if(info.getPurchaseGroup() != null && info.getPurchasePerson() != null)
                setPurchasePersonByNumber(info, errorMsg);
        }
        info.setSupplierConfirm(false);*/
	}

	protected void dealWithEntryData(OtherBillentryInfo OtherBillentryInfo, OtherBillInfo OtherBillInfo,
			List list) throws BOSException, EASBizException {
	}

	protected void verifyData(OtherBillInfo model, List errorMsg) throws BOSException, EASBizException {
		verifyHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			OtherBillentryInfo entryInfo = (OtherBillentryInfo) entries.getObject(i);
			verifyEntryData(entryInfo, model, errorMsg);
		}

	}

	protected void verifyHeadData(OtherBillInfo OtherBillInfo, List list) throws BOSException, EASBizException {
	}

	protected void verifyEntryData(OtherBillentryInfo OtherBillentryInfo, OtherBillInfo OtherBillInfo, List list)
			throws BOSException, EASBizException {
	}
}
