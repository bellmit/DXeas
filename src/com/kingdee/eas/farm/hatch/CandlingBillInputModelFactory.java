package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CandlingBillInputModelFactory
{
    private CandlingBillInputModelFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.ICandlingBillInputModel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ICandlingBillInputModel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("939A679E") ,com.kingdee.eas.farm.hatch.ICandlingBillInputModel.class);
    }
    
    public static com.kingdee.eas.farm.hatch.ICandlingBillInputModel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ICandlingBillInputModel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("939A679E") ,com.kingdee.eas.farm.hatch.ICandlingBillInputModel.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.ICandlingBillInputModel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ICandlingBillInputModel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("939A679E"));
    }
    public static com.kingdee.eas.farm.hatch.ICandlingBillInputModel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ICandlingBillInputModel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("939A679E"));
    }
}