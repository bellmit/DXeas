package com.kingdee.eas.message;

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

public interface IBaseSettingTree extends ITreeBase
{
    public BaseSettingTreeInfo getBaseSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BaseSettingTreeInfo getBaseSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BaseSettingTreeInfo getBaseSettingTreeInfo(String oql) throws BOSException, EASBizException;
    public BaseSettingTreeCollection getBaseSettingTreeCollection() throws BOSException;
    public BaseSettingTreeCollection getBaseSettingTreeCollection(EntityViewInfo view) throws BOSException;
    public BaseSettingTreeCollection getBaseSettingTreeCollection(String oql) throws BOSException;
}