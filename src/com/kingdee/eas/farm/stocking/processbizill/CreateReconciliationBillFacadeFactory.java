package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CreateReconciliationBillFacadeFactory
{
    private CreateReconciliationBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F4409C85") ,com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F4409C85") ,com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F4409C85"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ICreateReconciliationBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F4409C85"));
    }
}