package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillOtherEntryFactory
{
    private CKSettleBillOtherEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA64BE19") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA64BE19") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA64BE19"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillOtherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA64BE19"));
    }
}