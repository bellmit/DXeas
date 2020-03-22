package com.kingdee.eas.publicdata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CardSettingFactory
{
    private CardSettingFactory()
    {
    }
    public static com.kingdee.eas.publicdata.ICardSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B8BF3D5D") ,com.kingdee.eas.publicdata.ICardSetting.class);
    }
    
    public static com.kingdee.eas.publicdata.ICardSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B8BF3D5D") ,com.kingdee.eas.publicdata.ICardSetting.class, objectCtx);
    }
    public static com.kingdee.eas.publicdata.ICardSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B8BF3D5D"));
    }
    public static com.kingdee.eas.publicdata.ICardSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.publicdata.ICardSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B8BF3D5D"));
    }
}