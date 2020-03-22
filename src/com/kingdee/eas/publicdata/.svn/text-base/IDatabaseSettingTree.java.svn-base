package com.kingdee.eas.publicdata;

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

public interface IDatabaseSettingTree extends ITreeBase
{
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(String oql) throws BOSException, EASBizException;
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection() throws BOSException;
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(EntityViewInfo view) throws BOSException;
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(String oql) throws BOSException;
}