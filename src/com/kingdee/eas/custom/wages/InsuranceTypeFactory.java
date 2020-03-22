package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsuranceTypeFactory
{
    private InsuranceTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IInsuranceType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F7051E2C") ,com.kingdee.eas.custom.wages.IInsuranceType.class);
    }
    
    public static com.kingdee.eas.custom.wages.IInsuranceType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F7051E2C") ,com.kingdee.eas.custom.wages.IInsuranceType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IInsuranceType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F7051E2C"));
    }
    public static com.kingdee.eas.custom.wages.IInsuranceType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F7051E2C"));
    }
}