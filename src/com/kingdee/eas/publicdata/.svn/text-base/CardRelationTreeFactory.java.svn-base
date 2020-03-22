package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CardRelationTreeFactory
{
    private CardRelationTreeFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICardRelationTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelationTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("73EAB4CD") ,com.kingdee.eas.publicdata.ICardRelationTree.class);
    }
    
    public static com.kingdee.eas.publicdata.ICardRelationTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelationTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("73EAB4CD") ,com.kingdee.eas.publicdata.ICardRelationTree.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICardRelationTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelationTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("73EAB4CD"));
    }
    public static com.kingdee.eas.publicdata.ICardRelationTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardRelationTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("73EAB4CD"));
    }
}