package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MotorcadePayrollFactory
{
    private MotorcadePayrollFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayroll getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayroll)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D0B3BB5B") ,com.kingdee.eas.custom.wages.farm.IMotorcadePayroll.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayroll getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayroll)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D0B3BB5B") ,com.kingdee.eas.custom.wages.farm.IMotorcadePayroll.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayroll getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayroll)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D0B3BB5B"));
    }
    public static com.kingdee.eas.custom.wages.farm.IMotorcadePayroll getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IMotorcadePayroll)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D0B3BB5B"));
    }
}