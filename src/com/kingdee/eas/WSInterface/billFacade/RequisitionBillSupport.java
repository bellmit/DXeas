package com.kingdee.eas.WSInterface.billFacade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.framework.batch.BatchExecuteParamsEntry;
import com.kingdee.bos.framework.batch.BatchExecuteResult;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fi.gl.cslacct.IRequisition;
import com.kingdee.eas.fi.gl.cslacct.RequisitionCollection;
import com.kingdee.eas.fi.gl.cslacct.RequisitionEntryInfo;
import com.kingdee.eas.fi.gl.cslacct.RequisitionFactory;
import com.kingdee.eas.fi.gl.cslacct.RequisitionInfo;
import com.kingdee.util.BaseException;

public class RequisitionBillSupport implements IBillSupport {
	protected BigDecimal zero;
	private Context ctx;

	public RequisitionBillSupport() {
		// TODO Auto-generated constructor stub
	}

	public Class getInfoClass() {
		return RequisitionCollection.class;
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
		RequisitionInfo info = null;
		int i = 0;
		for (int size = col.size(); i < size; i++) {
			info = (RequisitionInfo) col.getObject(i);
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
				info = (RequisitionInfo) col.getObject(j);
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

	public IRequisition getInterface() throws BOSException {
		return RequisitionFactory.getLocalInstance(getContext());
	}
	
	private List setData(Context ctx, RequisitionInfo info) throws BOSException, EASBizException {
		List errorMsg = new ArrayList();
		dealWithData(ctx, info, errorMsg);
		setDefaultData(info, errorMsg);
		verifyData(info, errorMsg);
		return errorMsg;
	}
	protected void setDefaultData(RequisitionInfo model, List errorMsg) throws BOSException, EASBizException {
		setDefaultHeadData(model, errorMsg);
		IObjectCollection entries = model.getRequisitionEntry();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			RequisitionEntryInfo entryInfo = (RequisitionEntryInfo) entries.getObject(i);
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
	protected void setDefaultHeadData(RequisitionInfo info, List errorMsg) throws BOSException, EASBizException {
		if (info.getBizDate() == null)
			info.setBizDate(new Date());
	}

	/**
	 * 单据体默认值
	 * @param RequisitionEntryInfo
	 * @param RequisitionInfo
	 * @param list
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected void setDefaultEntryData(RequisitionEntryInfo RequisitionEntryInfo, RequisitionInfo RequisitionInfo,
			List list) throws BOSException, EASBizException {
		
	}

	protected void dealWithData(Context ctx, RequisitionInfo model, List errorMsg) throws BOSException, EASBizException {
		dealWithHeadData(model, errorMsg);
		IObjectCollection entries = model.getRequisitionEntry();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			RequisitionEntryInfo entryInfo = (RequisitionEntryInfo) entries.getObject(i);
			dealWithEntryData(entryInfo, model, errorMsg);
		}
		BaseBillImportUtils.setInfoByNumber(ctx, model, errorMsg);
	}
	protected void dealWithHeadData(RequisitionInfo model, List list) throws BOSException, EASBizException {
		RequisitionInfo info = (RequisitionInfo)model;
        /*if(info.getPurchaseGroup() != null)
        {
            ScmbillImportUtils.setDataBaseInfo(getContext(), info, errorMsg, "purchaseGroup", info.getPurchaseGroup());
            if(info.getPurchaseGroup() != null && info.getPurchasePerson() != null)
                setPurchasePersonByNumber(info, errorMsg);
        }
        info.setSupplierConfirm(false);*/
	}

	protected void dealWithEntryData(RequisitionEntryInfo RequisitionEntryInfo, RequisitionInfo RequisitionInfo,
			List list) throws BOSException, EASBizException {
	}

	protected void verifyData(RequisitionInfo model, List errorMsg) throws BOSException, EASBizException {
		verifyHeadData(model, errorMsg);
		IObjectCollection entries = model.getRequisitionEntry();
		int i = 0;
		for (int size = entries.size(); i < size; i++) {
			RequisitionEntryInfo entryInfo = (RequisitionEntryInfo) entries.getObject(i);
			verifyEntryData(entryInfo, model, errorMsg);
		}

	}

	protected void verifyHeadData(RequisitionInfo RequisitionInfo, List list) throws BOSException, EASBizException {
	}

	protected void verifyEntryData(RequisitionEntryInfo RequisitionEntryInfo, RequisitionInfo RequisitionInfo, List list)
			throws BOSException, EASBizException {
	}
}
