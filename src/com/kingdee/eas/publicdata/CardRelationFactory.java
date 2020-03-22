package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CardRelationFactory
{
    private CardRelationFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICardRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E899AC8F") ,com.kingdee.eas.publicdata.ICardRelation.class);
    }
    
    public static com.kingdee.eas.publicdata.ICardRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E899AC8F") ,com.kingdee.eas.publicdata.ICardRelation.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICardRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E899AC8F"));
    }
    public static com.kingdee.eas.publicdata.ICardRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E899AC8F"));
    }
}