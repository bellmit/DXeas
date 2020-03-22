package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialStandardCostCostDetailEntryFactory
{
    private MaterialStandardCostCostDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F922C1EF") ,com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F922C1EF") ,com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F922C1EF"));
    }
    public static com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMaterialStandardCostCostDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F922C1EF"));
    }
}