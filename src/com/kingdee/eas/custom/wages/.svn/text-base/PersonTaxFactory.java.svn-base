package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonTaxFactory
{
    private PersonTaxFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IPersonTax getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTax)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B7AF1D0E") ,com.kingdee.eas.custom.wages.IPersonTax.class);
    }
    
    public static com.kingdee.eas.custom.wages.IPersonTax getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTax)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B7AF1D0E") ,com.kingdee.eas.custom.wages.IPersonTax.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IPersonTax getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTax)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B7AF1D0E"));
    }
    public static com.kingdee.eas.custom.wages.IPersonTax getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IPersonTax)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B7AF1D0E"));
    }
}