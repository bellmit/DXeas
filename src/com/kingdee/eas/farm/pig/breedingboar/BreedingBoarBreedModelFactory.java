package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedingBoarBreedModelFactory
{
    private BreedingBoarBreedModelFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1DDF403D") ,com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1DDF403D") ,com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1DDF403D"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBreedingBoarBreedModel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1DDF403D"));
    }
}