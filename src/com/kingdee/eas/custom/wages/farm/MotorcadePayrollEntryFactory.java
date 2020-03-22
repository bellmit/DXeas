package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MotorcadePayrollEntryFactory
{
    private MotorcadePayrollEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("60B23DD7") ,com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("60B23DD7") ,com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("60B23DD7"));
    }
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayrollEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("60B23DD7"));
    }
}