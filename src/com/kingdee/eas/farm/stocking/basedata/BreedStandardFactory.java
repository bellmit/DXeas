package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardFactory
{
    private BreedStandardFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandard getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandard)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6C5ED8A0") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandard.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandard getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandard)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6C5ED8A0") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandard.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandard getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandard)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6C5ED8A0"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandard getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandard)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6C5ED8A0"));
    }
}