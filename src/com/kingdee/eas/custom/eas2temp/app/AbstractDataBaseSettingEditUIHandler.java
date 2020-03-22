/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDataBaseSettingEditUIHandler extends com.kingdee.eas.framework.app.EditUIHandler

{
	public void handleActionImportMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportMaterial(request,response,context);
	}
	protected void _handleActionImportMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionBakmaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBakmaterial(request,response,context);
	}
	protected void _handleActionBakmaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}