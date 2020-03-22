package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CardReaderTreeFactory
{
    private CardReaderTreeFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICardReaderTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReaderTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("37C080D4") ,com.kingdee.eas.publicdata.ICardReaderTree.class);
    }
    
    public static com.kingdee.eas.publicdata.ICardReaderTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReaderTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("37C080D4") ,com.kingdee.eas.publicdata.ICardReaderTree.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICardReaderTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReaderTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("37C080D4"));
    }
    public static com.kingdee.eas.publicdata.ICardReaderTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReaderTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("37C080D4"));
    }
}