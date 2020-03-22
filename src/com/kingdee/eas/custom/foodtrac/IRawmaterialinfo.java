package com.kingdee.eas.custom.foodtrac;

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

public interface IRawmaterialinfo extends ICoreBillBase
{
    public RawmaterialinfoCollection getRawmaterialinfoCollection() throws BOSException;
    public RawmaterialinfoCollection getRawmaterialinfoCollection(EntityViewInfo view) throws BOSException;
    public RawmaterialinfoCollection getRawmaterialinfoCollection(String oql) throws BOSException;
    public RawmaterialinfoInfo getRawmaterialinfoInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RawmaterialinfoInfo getRawmaterialinfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RawmaterialinfoInfo getRawmaterialinfoInfo(String oql) throws BOSException, EASBizException;
}