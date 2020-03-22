package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerQualicationApplFarmEntryFactory
{
    private FarmerQualicationApplFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("63DC19FF") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("63DC19FF") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("63DC19FF"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationApplFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("63DC19FF"));
    }
}