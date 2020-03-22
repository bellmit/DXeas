package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IBrowerItemTree extends ITreeBase
{
    public BrowerItemTreeInfo getBrowerItemTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BrowerItemTreeInfo getBrowerItemTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BrowerItemTreeInfo getBrowerItemTreeInfo(String oql) throws BOSException, EASBizException;
    public BrowerItemTreeCollection getBrowerItemTreeCollection() throws BOSException;
    public BrowerItemTreeCollection getBrowerItemTreeCollection(EntityViewInfo view) throws BOSException;
    public BrowerItemTreeCollection getBrowerItemTreeCollection(String oql) throws BOSException;
}