package com.kingdee.eas.custom.wages;

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

public interface IMonthlysalarybillEntry extends ICoreBillEntryBase
{
    public MonthlysalarybillEntryInfo getMonthlysalarybillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MonthlysalarybillEntryInfo getMonthlysalarybillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MonthlysalarybillEntryInfo getMonthlysalarybillEntryInfo(String oql) throws BOSException, EASBizException;
    public MonthlysalarybillEntryCollection getMonthlysalarybillEntryCollection() throws BOSException;
    public MonthlysalarybillEntryCollection getMonthlysalarybillEntryCollection(EntityViewInfo view) throws BOSException;
    public MonthlysalarybillEntryCollection getMonthlysalarybillEntryCollection(String oql) throws BOSException;
}