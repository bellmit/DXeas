package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillPreHouseEntryFactory
{
    private CKSettleBillPreHouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF79E5FE") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF79E5FE") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF79E5FE"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillPreHouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF79E5FE"));
    }
}