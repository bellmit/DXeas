package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialStandardCostFactory
{
    private MaterialStandardCostFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCost getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCost)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B6F01FE5") ,com.kingdee.eas.custom.salepayment.IMaterialStandardCost.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCost getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCost)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B6F01FE5") ,com.kingdee.eas.custom.salepayment.IMaterialStandardCost.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCost getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCost)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B6F01FE5"));
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCost getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCost)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B6F01FE5"));
    }
}