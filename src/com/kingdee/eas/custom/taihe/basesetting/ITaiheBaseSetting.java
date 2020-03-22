package com.kingdee.eas.custom.taihe.basesetting;

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

public interface ITaiheBaseSetting extends IWlhlDataBase
{
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(String oql) throws BOSException, EASBizException;
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection() throws BOSException;
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(EntityViewInfo view) throws BOSException;
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(String oql) throws BOSException;
}