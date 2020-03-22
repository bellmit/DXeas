package com.kingdee.eas.WSInterface.basedataFacade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.batch.BatchExecuteParamsEntry;
import com.kingdee.bos.framework.batch.BatchExecuteResult;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.scm.common.SCMBillBaseInfo;
import com.kingdee.eas.scm.common.SCMBillEntryBaseInfo;
import com.kingdee.util.BaseException;

// Referenced classes of package com.kingdee.eas.wmWs.app.basedata:
//            IBaseSupport, WmBaselImportUtils, BaseResultInfo

public abstract class WmBaseSupport
    implements IBaseSupport
{

    public WmBaseSupport()
    {
        zero = new BigDecimal("0.00");
    }

    public boolean isSupportSubmit()
    {
        return true;
    }

    public boolean isSupportAudit()
    {
        return true;
    }

    public void setContext(Context ctx)
    {
        this.ctx = ctx;
    }

    public Context getContext()
    {
        return ctx;
    }

    public Class getInfoClass()
    {
        return null;
    }

    private List setData(Context ctx, SCMBillBaseInfo info)
        throws BOSException, EASBizException
    {
        List errorMsg = new ArrayList();
        dealWithData(ctx, info, errorMsg);
        setDefaultData(info, errorMsg);
        verifyData(info, errorMsg);
        return errorMsg;
    }

    protected void setDefaultData(SCMBillBaseInfo model, List errorMsg)
        throws BOSException, EASBizException
    {
        setDefaultHeadData(model, errorMsg);
        IObjectCollection entries = model.getEntries();
        int i = 0;
        for(int size = entries.size(); i < size; i++)
        {
            SCMBillEntryBaseInfo entryInfo = (SCMBillEntryBaseInfo)entries.getObject(i);
            setDefaultEntryData(entryInfo, model, errorMsg);
        }

    }

    protected void setDefaultHeadData(SCMBillBaseInfo info, List errorMsg)
        throws BOSException, EASBizException
    {
        if(info.getBizDate() == null)
            info.setBizDate(new Date());
    }

    protected void setDefaultEntryData(SCMBillEntryBaseInfo scmbillentrybaseinfo, SCMBillBaseInfo scmbillbaseinfo, List list)
        throws BOSException, EASBizException
    {
    }

    protected void dealWithData(Context ctx, SCMBillBaseInfo model, List errorMsg)
        throws BOSException, EASBizException
    {
        dealWithHeadData(model, errorMsg);
        IObjectCollection entries = model.getEntries();
        int i = 0;
        for(int size = entries.size(); i < size; i++)
        {
            SCMBillEntryBaseInfo entryInfo = (SCMBillEntryBaseInfo)entries.getObject(i);
            dealWithEntryData(entryInfo, model, errorMsg);
        }

        WmBaselImportUtils.setInfoByNumber(ctx, model, errorMsg);
    }

    protected void dealWithHeadData(SCMBillBaseInfo scmbillbaseinfo, List list)
        throws BOSException, EASBizException
    {
    }

    protected void dealWithEntryData(SCMBillEntryBaseInfo scmbillentrybaseinfo, SCMBillBaseInfo scmbillbaseinfo, List list)
        throws BOSException, EASBizException
    {
    }

    protected void verifyData(SCMBillBaseInfo model, List errorMsg)
        throws BOSException, EASBizException
    {
        verifyHeadData(model, errorMsg);
        IObjectCollection entries = model.getEntries();
        int i = 0;
        for(int size = entries.size(); i < size; i++)
        {
            SCMBillEntryBaseInfo entryInfo = (SCMBillEntryBaseInfo)entries.getObject(i);
            verifyEntryData(entryInfo, model, errorMsg);
        }

    }

    protected void verifyHeadData(SCMBillBaseInfo scmbillbaseinfo, List list)
        throws BOSException, EASBizException
    {
    }

    protected void verifyEntryData(SCMBillEntryBaseInfo scmbillentrybaseinfo, SCMBillBaseInfo scmbillbaseinfo, List list)
        throws BOSException, EASBizException
    {
    }

    public List audit(List results) throws EASBizException, BOSException {
		BatchExecuteResult result = null;
		BatchExecuteParamsEntry paramEntries[] = new BatchExecuteParamsEntry[results.size()];
		BatchExecuteParamsEntry entry = null;
		for (int i = 0; i < results.size(); i++) {
			BaseResultInfo resultInfo = (BaseResultInfo) results.get(i);
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
			BaseResultInfo resultInfo = new BaseResultInfo();
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

    public List save(AbstractObjectCollection col)
        throws EASBizException, BOSException
    {
        List results = saveOrSubmitData(col, true);
        return results;
    }

    public List submit(AbstractObjectCollection col)
        throws EASBizException, BOSException
    {
        List results = saveOrSubmitData(col, false);
        return results;
    }

    private List saveOrSubmitData(AbstractObjectCollection col, boolean isSave)
        throws BOSException, EASBizException
    {
        List results = new ArrayList();
        SCMBillBaseInfo info = null;
        int i = 0;
        for(int size = col.size(); i < size; i++)
        {
            info = (SCMBillBaseInfo)col.getObject(i);
            List errorMsg = setData(ctx, info);
            if(errorMsg != null && errorMsg.size() > 0)
            {
                BaseResultInfo result = new BaseResultInfo();
                result.setErrorMsgs(errorMsg);
                result.setNumber(info.getNumber());
                result.setStatus(1);
                results.add(result);
                col.removeObject(i);
                i--;
                size--;
            }
        }

        invokeServiceWs(col, isSave, results, info);
        return results;
    }

    public List operationBill(int billStatus, AbstractObjectCollection objCol, List billErrors)
        throws BOSException, EASBizException
    {
        ICoreBase iCoreBase = getInterface();
        List errorMsg = new ArrayList();
        for(int i = 0; i < objCol.size(); i++)
        {
            String id = "";
            BaseResultInfo billResult = new BaseResultInfo();
            CoreBaseInfo info = null;
            try
            {
                info = (CoreBaseInfo)objCol.getObject(i);
                billResult.setNumber(info.get("number").toString());
                if(info.getId() != null)
                {
                    id = info.getId().toString();
                    billResult.setId(id);
                }
                if(billStatus == 0 || 1 == billStatus || 2 == billStatus || 5 == billStatus)
                {
                    SelectorItemCollection selector = new SelectorItemCollection();
                    if(info.get("name") != null && !"".equals(info.get("name")))
                    {
                        String name = info.get("name").toString().replaceAll("(^[ |\u3000]*|[ |\u3000]*$)", "");
                        info.put("name", name);
                    }
                    info.put("name", info.get("name"));
                    info.put("name", info.get("name", new Locale("L1", "")), new Locale("L1", ""));
                    info.put("name", info.get("name", new Locale("L2", "")), new Locale("L2", ""));
                    info.put("name", info.get("name", new Locale("L3", "")), new Locale("L3", ""));
                    if(billStatus == 0)
                    {
                        iCoreBase.update(new ObjectUuidPK(info.getId()), info);
                        billResult.setId(info.getId().toString());
                    } else
                    {
                        selector.add(new SelectorItemInfo("deletedStatus"));
                        iCoreBase.updatePartial(info, selector);
                    }
                } else
                if(3 == billStatus)
                {
                    IObjectPK iObjectPK = iCoreBase.save(info);
                    billResult.setId(iObjectPK.toString());
                } else
                if(4 == billStatus)
                {
                    IObjectPK iObjectPK = iCoreBase.submit(info);
                    billResult.setId(iObjectPK.toString());
                } else
                {
                    billResult.setId(id);
                    errorMsg.add("\u72B6\u6001\u53C2\u6570\u9519\u8BEF");
                    billResult.setErrorMsgs(errorMsg);
                }
                if(errorMsg.size() > 0)
                    billResult.setStatus(1);
                else
                    billResult.setStatus(0);
                billErrors.add(billResult);
            }
            catch(EASBizException e)
            {
                billResult.setNumber(info.get("number").toString());
                if(info.getId() != null)
                    id = info.getId().toString();
                billResult.setId(id);
                errorMsg.add(e.getMessage());
                billResult.setErrorMsgs(errorMsg);
            }
            catch(BOSException e)
            {
                billResult.setNumber(info.get("number").toString());
                billResult.setId(id);
                errorMsg.add(e.getMessage());
                billResult.setErrorMsgs(errorMsg);
            }
        }

        return errorMsg;
    }

    public void invokeServiceWs(AbstractObjectCollection abstractobjectcollection, boolean flag, List list, SCMBillBaseInfo scmbillbaseinfo)
    {
    }

    public ICoreBase getInterface()
        throws BOSException
    {
        return null;
    }

    protected BigDecimal zero;
    private Context ctx;
}
