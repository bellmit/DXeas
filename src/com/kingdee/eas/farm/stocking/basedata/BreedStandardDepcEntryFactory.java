package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardDepcEntryFactory
{
    private BreedStandardDepcEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7268D5DE") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7268D5DE") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7268D5DE"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDepcEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7268D5DE"));
    }
}