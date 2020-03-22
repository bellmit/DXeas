package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKDressingPercentFactory
{
    private CKDressingPercentFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23BB4CB0") ,com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23BB4CB0") ,com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23BB4CB0"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICKDressingPercent)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23BB4CB0"));
    }
}