package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonFarmerRangeEntryFactory
{
    private PersonFarmerRangeEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C0C5EA8F") ,com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C0C5EA8F") ,com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C0C5EA8F"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C0C5EA8F"));
    }
}