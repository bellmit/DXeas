package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBabyPigEntry extends ICoreBillEntryBase
{
    public BabyPigEntryInfo getBabyPigEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BabyPigEntryInfo getBabyPigEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BabyPigEntryInfo getBabyPigEntryInfo(String oql) throws BOSException, EASBizException;
    public BabyPigEntryCollection getBabyPigEntryCollection() throws BOSException;
    public BabyPigEntryCollection getBabyPigEntryCollection(EntityViewInfo view) throws BOSException;
    public BabyPigEntryCollection getBabyPigEntryCollection(String oql) throws BOSException;
}