package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CardReaderFactory
{
    private CardReaderFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICardReader getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReader)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("56CC9416") ,com.kingdee.eas.publicdata.ICardReader.class);
    }
    
    public static com.kingdee.eas.publicdata.ICardReader getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReader)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("56CC9416") ,com.kingdee.eas.publicdata.ICardReader.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICardReader getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReader)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("56CC9416"));
    }
    public static com.kingdee.eas.publicdata.ICardReader getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardReader)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("56CC9416"));
    }
}