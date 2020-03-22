package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchStandardFactory
{
    private HatchStandardFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandard getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandard)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D7269FCF") ,com.kingdee.eas.farm.hatch.IHatchStandard.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchStandard getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandard)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D7269FCF") ,com.kingdee.eas.farm.hatch.IHatchStandard.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandard getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandard)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D7269FCF"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandard getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandard)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D7269FCF"));
    }
}