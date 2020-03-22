package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBreedModelFactory
{
    private CCPigBreedModelFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("ADC1AD23") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("ADC1AD23") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("ADC1AD23"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("ADC1AD23"));
    }
}