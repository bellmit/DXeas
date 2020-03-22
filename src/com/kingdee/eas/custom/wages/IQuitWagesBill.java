package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
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

public interface IQuitWagesBill extends IWlhlDataBase
{
    public QuitWagesBillInfo getQuitWagesBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QuitWagesBillInfo getQuitWagesBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QuitWagesBillInfo getQuitWagesBillInfo(String oql) throws BOSException, EASBizException;
    public QuitWagesBillCollection getQuitWagesBillCollection() throws BOSException;
    public QuitWagesBillCollection getQuitWagesBillCollection(EntityViewInfo view) throws BOSException;
    public QuitWagesBillCollection getQuitWagesBillCollection(String oql) throws BOSException;
}