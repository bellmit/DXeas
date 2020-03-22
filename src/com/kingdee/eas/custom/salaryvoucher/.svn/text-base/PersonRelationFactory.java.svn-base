package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonRelationFactory
{
    private PersonRelationFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.IPersonRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IPersonRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("700B7880") ,com.kingdee.eas.custom.salaryvoucher.IPersonRelation.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.IPersonRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IPersonRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("700B7880") ,com.kingdee.eas.custom.salaryvoucher.IPersonRelation.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.IPersonRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IPersonRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("700B7880"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.IPersonRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IPersonRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("700B7880"));
    }
}