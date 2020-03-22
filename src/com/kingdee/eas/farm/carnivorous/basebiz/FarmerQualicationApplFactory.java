package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerQualicationApplFactory
{
    private FarmerQualicationApplFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A2D3105D") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A2D3105D") ,com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A2D3105D"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IFarmerQualicationAppl)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A2D3105D"));
    }
}