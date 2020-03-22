package com.kingdee.eas.WSInterface.basedataFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.WSInterface.common.WsCommonUtil;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeCollection;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.ContextUtil;

public class GeneralAsstActTypeSupport extends WmBaseSupport {

    private GeneralAsstActTypeInfo info;
    private Context ctx;
    
	public GeneralAsstActTypeSupport()
    {
        info = null;
        ctx = getContext();
    }

    public Class getInfoClass()
    {
        return GeneralAsstActTypeCollection.class;//com/kingdee/eas/basedata/master/material/MaterialGroupCollection;
    }

    public ICoreBase getInterface()
        throws BOSException
    {
        return GeneralAsstActTypeFactory.getLocalInstance(ctx);
    }

    /*public void invokeServiceWs(AbstractObjectCollection col, boolean isSave, List results, SCMBillBaseInfo info)
    {
        super.invokeServiceWs(col, isSave, results, info);
    }*/

    public List operationBill(int billStatus, AbstractObjectCollection objCol, List billErrors)
        throws BOSException, EASBizException
    {
        ctx = getContext();
        ICoreBase iCoreBase = getInterface();
        for(int i = 0; i < objCol.size(); i++)
        {
            List errorMsg = new ArrayList();
            String id = "";
            BaseResultInfo billResult = new BaseResultInfo();
            billErrors.add(billResult);
            try
            {
                info = (GeneralAsstActTypeInfo)objCol.getObject(i);
                billResult.setNumber(info.get("number").toString());
                if(info.getId() != null)
                {
                    id = info.getId().toString();
                    billResult.setId(id);
                }
                CtrlUnitInfo ctrlUnitInfo = getCtrlUnitInfo();
                com.kingdee.bos.metadata.entity.EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx,info.getBOSType().toString());
                info = (GeneralAsstActTypeInfo)WsCommonUtil.validateBill(ctx, eo, billStatus, info.getNumber(), ctrlUnitInfo.getId().toString(), info);
                /*if(billStatus == 0 || 3 == billStatus || 4 == billStatus)
                {
                    String mustValidateHead[] = WsCommonTag.getMustValidateProsByMaterialGroupHead();
                    if(billStatus != 0)
                        WsCommonUtil.validateHeadProperty(mustValidateHead, info);
                }*/
                ctx.put("disablePermissionForKScript", Boolean.TRUE);
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
                if(1 == billStatus)
                {
                    /*IObjectPK iObjectPK = iCoreBase.addnew(info);
                    billResult.setId(iObjectPK.toString());*/
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
                    errorMsg.add("不存在操作状态");
                    billResult.setErrorMsgs(errorMsg);
                }
            }
            catch(EASBizException e)
            {
                billResult.setNumber(info.get("number").toString());
                if(info.getId() != null)
                    id = info.getId().toString();
                billResult.setId(id);
                errorMsg.add(e.getMessage());
                billResult.setErrorMsgs(errorMsg);
                billResult.setStatus(1);
            }
            catch(BOSException e)
            {
                billResult.setNumber(info.get("number").toString());
                billResult.setId(id);
                errorMsg.add(e.getMessage());
                billResult.setErrorMsgs(errorMsg);
                billResult.setStatus(1);
            }
            catch(Exception e)
            {
                billResult.setNumber(info.get("number").toString());
                billResult.setId(id);
                errorMsg.add(e.getMessage());
                billResult.setErrorMsgs(errorMsg);
                billResult.setStatus(1);
            }
            if(errorMsg.size() > 0)
                billResult.setStatus(1);
            else
                billResult.setStatus(0);
        }

        return billErrors;
    }

    private CtrlUnitInfo getCtrlUnitInfo()
        throws Exception
    {
        CtrlUnitInfo cuInfo = null;
        if(info.getCU() != null)
        {
            if(info.getCU().getNumber() != null)
            {
                cuInfo = WsCommonUtil.getCuInfo(ctx, info.getCU().getNumber());
                if(cuInfo == null)
                {
                    throw new Exception("不存在组织单元");//DataImportUtils.getResource("com.kingdee.eas.wmWs.app.WebSericeResource", "CUNOTFOUND", ctx));
                } else
                {
                    ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);
                    return cuInfo;
                }
            } else
            {
                throw new Exception("不存在组织单元");//DataImportUtils.getResource("com.kingdee.eas.wmWs.app.WebSericeResource", "CUNOTNULL", ctx));
            }
        } else
        {
            throw new Exception("不存在组织单元");//DataImportUtils.getResource("com.kingdee.eas.wmWs.app.WebSericeResource", "CUNOTFOUND", ctx));
        }
    }

}
