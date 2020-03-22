package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBabyPig extends ICoreBillBase
{
    public BabyPigCollection getBabyPigCollection() throws BOSException;
    public BabyPigCollection getBabyPigCollection(EntityViewInfo view) throws BOSException;
    public BabyPigCollection getBabyPigCollection(String oql) throws BOSException;
    public BabyPigInfo getBabyPigInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BabyPigInfo getBabyPigInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BabyPigInfo getBabyPigInfo(String oql) throws BOSException, EASBizException;
}