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

public interface IPigField extends IDataBase
{
    public PigFieldInfo getPigFieldInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigFieldInfo getPigFieldInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigFieldInfo getPigFieldInfo(String oql) throws BOSException, EASBizException;
    public PigFieldCollection getPigFieldCollection() throws BOSException;
    public PigFieldCollection getPigFieldCollection(EntityViewInfo view) throws BOSException;
    public PigFieldCollection getPigFieldCollection(String oql) throws BOSException;
}