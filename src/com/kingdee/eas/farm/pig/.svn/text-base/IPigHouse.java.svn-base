package com.kingdee.eas.farm.pig;

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

public interface IPigHouse extends IDataBase
{
    public PigHouseInfo getPigHouseInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigHouseInfo getPigHouseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigHouseInfo getPigHouseInfo(String oql) throws BOSException, EASBizException;
    public PigHouseCollection getPigHouseCollection() throws BOSException;
    public PigHouseCollection getPigHouseCollection(EntityViewInfo view) throws BOSException;
    public PigHouseCollection getPigHouseCollection(String oql) throws BOSException;
}