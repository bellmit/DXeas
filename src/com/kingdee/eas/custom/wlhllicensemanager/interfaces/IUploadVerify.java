package com.kingdee.eas.custom.wlhllicensemanager.interfaces;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;

/**
 * У��ӿ�
 * @author dai_andong
 *
 */
public interface IUploadVerify {
	void verify(CoreBaseInfo info) throws BOSException,EASBizException;
}