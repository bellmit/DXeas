package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerQualicationApplEntryFactory
{
    private FarmerQualicationApplEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1949BA15") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1949BA15") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1949BA15"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1949BA15"));
    }
}