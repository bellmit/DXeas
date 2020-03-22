package com.kingdee.eas.farm.pig.breedingboar;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBoar extends IDataBase
{
    public BoarInfo getBoarInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BoarInfo getBoarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BoarInfo getBoarInfo(String oql) throws BOSException, EASBizException;
    public BoarCollection getBoarCollection() throws BOSException;
    public BoarCollection getBoarCollection(EntityViewInfo view) throws BOSException;
    public BoarCollection getBoarCollection(String oql) throws BOSException;
}