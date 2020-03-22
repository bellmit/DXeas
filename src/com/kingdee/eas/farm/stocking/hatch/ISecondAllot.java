package com.kingdee.eas.farm.stocking.hatch;

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

public interface ISecondAllot extends IDataBase
{
    public SecondAllotInfo getSecondAllotInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SecondAllotInfo getSecondAllotInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SecondAllotInfo getSecondAllotInfo(String oql) throws BOSException, EASBizException;
    public SecondAllotCollection getSecondAllotCollection() throws BOSException;
    public SecondAllotCollection getSecondAllotCollection(EntityViewInfo view) throws BOSException;
    public SecondAllotCollection getSecondAllotCollection(String oql) throws BOSException;
}