package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialStandardCostTreeFactory
{
    private MaterialStandardCostTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("808B8D23") ,com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("808B8D23") ,com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("808B8D23"));
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("808B8D23"));
    }
}