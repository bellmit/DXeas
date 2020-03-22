package com.kingdee.eas.farm.breed.layegg;

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

public interface IEggConveyor extends IDataBase
{
    public EggConveyorInfo getEggConveyorInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggConveyorInfo getEggConveyorInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggConveyorInfo getEggConveyorInfo(String oql) throws BOSException, EASBizException;
    public EggConveyorCollection getEggConveyorCollection() throws BOSException;
    public EggConveyorCollection getEggConveyorCollection(EntityViewInfo view) throws BOSException;
    public EggConveyorCollection getEggConveyorCollection(String oql) throws BOSException;
}