package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillFactory
{
    private CKSettleBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2A2E0777") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2A2E0777") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2A2E0777"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2A2E0777"));
    }
}