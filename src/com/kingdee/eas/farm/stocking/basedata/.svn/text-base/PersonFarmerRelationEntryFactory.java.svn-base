package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonFarmerRelationEntryFactory
{
    private PersonFarmerRelationEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B776016D") ,com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B776016D") ,com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B776016D"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B776016D"));
    }
}