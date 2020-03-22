package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CSlaughterBillQCEntryFactory
{
    private CSlaughterBillQCEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("14DD3EAC") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("14DD3EAC") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("14DD3EAC"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBillQCEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("14DD3EAC"));
    }
}