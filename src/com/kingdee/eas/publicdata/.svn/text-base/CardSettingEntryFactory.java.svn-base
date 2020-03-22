package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CardSettingEntryFactory
{
    private CardSettingEntryFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICardSettingEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSettingEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A0F1AD15") ,com.kingdee.eas.publicdata.ICardSettingEntry.class);
    }
    
    public static com.kingdee.eas.publicdata.ICardSettingEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSettingEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A0F1AD15") ,com.kingdee.eas.publicdata.ICardSettingEntry.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICardSettingEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSettingEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A0F1AD15"));
    }
    public static com.kingdee.eas.publicdata.ICardSettingEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSettingEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A0F1AD15"));
    }
}