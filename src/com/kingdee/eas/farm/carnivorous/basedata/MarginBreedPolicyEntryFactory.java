package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginBreedPolicyEntryFactory
{
    private MarginBreedPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C4AB7A3C") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C4AB7A3C") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C4AB7A3C"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBreedPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C4AB7A3C"));
    }
}