package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonTaxEntryFactory
{
    private PersonTaxEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IPersonTaxEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTaxEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("561EF404") ,com.kingdee.eas.custom.wages.IPersonTaxEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IPersonTaxEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTaxEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("561EF404") ,com.kingdee.eas.custom.wages.IPersonTaxEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IPersonTaxEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTaxEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("561EF404"));
    }
    public static com.kingdee.eas.custom.wages.IPersonTaxEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTaxEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("561EF404"));
    }
}