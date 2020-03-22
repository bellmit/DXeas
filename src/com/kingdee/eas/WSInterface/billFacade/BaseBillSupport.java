package com.kingdee.eas.WSInterface.billFacade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.batch.BatchExecuteParamsEntry;
import com.kingdee.bos.framework.batch.BatchExecuteResult;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.common.ISCMBillBase;
import com.kingdee.eas.scm.common.SCMBillBaseInfo;
import com.kingdee.eas.scm.common.SCMBillEntryBaseInfo;
import com.kingdee.util.BaseException;

public abstract class BaseBillSupport implements IBillSupport {

	public BaseBillSupport() {
		// TODO Auto-generated constructor stub
		zero = new BigDecimal("0.00");
	}

	public boolean isSupportSubmit() {
		return true;
	}

	public boolean isSupportAudit() {
		return true;
	}

	public void setContext(Context ctx) {
		this.ctx = ctx;
	}

	public Context getContext() {
		return ctx;
	}

	public Class getInfoClass() {
		return null;
	}

	private List setData(Context ctx, SCMBillBaseInfo info) throws BOSException, EASBizException {
		List errorMsg = new ArrayList();
		dealWithData(ctx, info, errorMsg);
		setDefaultData(info, errorMsg);
		verifyData(info, errorMsg);
		return errorMsg;
	}

	protected void setDefaultData(SCMBillBaseInfo model, List errorMsg) throws BOSException, EASBizException {
		setDefaultHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			SCMBillEntryBaseInfo entryInfo = (SCMBillEntryBaseInfo) entries.getObject(i);
			setDefaultEntryData(entryInfo, model, errorMsg);
		}

	}

	protected void setDefaultHeadData(SCMBillBaseInfo info, List errorMsg) throws BOSException, EASBizException {
		if (info.getBizDate() == null)
			info.setBizDate(new Date());
	}

	protected void setDefaultEntryData(SCMBillEntryBaseInfo scmbillentrybaseinfo, SCMBillBaseInfo scmbillbaseinfo,
			List list) throws BOSException, EASBizException {
	}

	protected void dealWithData(Context ctx, SCMBillBaseInfo model, List errorMsg) throws BOSException, EASBizException {
		dealWithHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			SCMBillEntryBaseInfo entryInfo = (SCMBillEntryBaseInfo) entries.getObject(i);
			dealWithEntryData(entryInfo, model, errorMsg);
		}

		BaseBillImportUtils.setInfoByNumber(ctx, model, errorMsg);
	}

	protected void dealWithHeadData(SCMBillBaseInfo scmbillbaseinfo, List list) throws BOSException, EASBizException {
	}

	protected void dealWithEntryData(SCMBillEntryBaseInfo scmbillentrybaseinfo, SCMBillBaseInfo scmbillbaseinfo,
			List list) throws BOSException, EASBizException {
	}

	protected void verifyData(SCMBillBaseInfo model, List errorMsg) throws BOSException, EASBizException {
		verifyHeadData(model, errorMsg);
		IObjectCollection entries = model.getEntries();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			SCMBillEntryBaseInfo entryInfo = (SCMBillEntryBaseInfo) entries.getObject(i);
			verifyEntryData(entryInfo, model, errorMsg);
		}

	}

	protected void verifyHeadData(SCMBillBaseInfo scmbillbaseinfo, List list) throws BOSException, EASBizException {
	}

	protected void verifyEntryData(SCMBillEntryBaseInfo scmbillentrybaseinfo, SCMBillBaseInfo scmbillbaseinfo, List list)
			throws BOSException, EASBizException {
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

	public List save(AbstractObjectCollection col) throws EASBizException, BOSException {
		List results = saveOrSubmitData(col, true);
		return results;
	}

	public List submit(AbstractObjectCollection col) throws EASBizException, BOSException {
		List results = saveOrSubmitData(col, false);
		return results;
	}

	private List saveOrSubmitData(AbstractObjectCollection col, boolean isSave) throws BOSException, EASBizException {
		List results = new ArrayList();
		SCMBillBaseInfo info = null;
		int i = 0;
		for (int size = col.size(); i < size; i++) {
			info = (SCMBillBaseInfo) col.getObject(i);
			List errorMsg = setData(ctx, info);
			if (errorMsg != null && errorMsg.size() > 0) {
				BillResultInfo result = new BillResultInfo();
				result.setErrorMsgs(errorMsg);
				result.setNumber(info.getNumber());
				result.setStatus(1);
				results.add(result);
				col.removeObject(i);
				i--;
				size--;
			}
		}

		if (col != null && col.size() > 0) {
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
				info = (SCMBillBaseInfo) col.getObject(j);
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

		}
		return results;
	}

	public void invokeServiceWs(AbstractObjectCollection abstractobjectcollection, boolean flag, List list,
			SCMBillBaseInfo scmbillbaseinfo) {
	}

	public abstract ISCMBillBase getInterface() throws BOSException;

	protected BigDecimal zero;
	private Context ctx;
}
