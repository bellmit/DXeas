package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IHappyHolidayTree extends ITreeBase
{
    public HappyHolidayTreeInfo getHappyHolidayTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HappyHolidayTreeInfo getHappyHolidayTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HappyHolidayTreeInfo getHappyHolidayTreeInfo(String oql) throws BOSException, EASBizException;
    public HappyHolidayTreeCollection getHappyHolidayTreeCollection() throws BOSException;
    public HappyHolidayTreeCollection getHappyHolidayTreeCollection(EntityViewInfo view) throws BOSException;
    public HappyHolidayTreeCollection getHappyHolidayTreeCollection(String oql) throws BOSException;
}