/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDiscountSetListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

{
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionBlock(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBlock(request,response,context);
	}
	protected void _handleActionBlock(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnBlock(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnBlock(request,response,context);
	}
	protected void _handleActionUnBlock(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImportCustomerMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportCustomerMaterial(request,response,context);
	}
	protected void _handleActionImportCustomerMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImportCustomerMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportCustomerMaterialGroup(request,response,context);
	}
	protected void _handleActionImportCustomerMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImportCustomerGroupMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportCustomerGroupMaterial(request,response,context);
	}
	protected void _handleActionImportCustomerGroupMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionImportCustomerGroupMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionImportCustomerGroupMaterialGroup(request,response,context);
	}
	protected void _handleActionImportCustomerGroupMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExportCustomerMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExportCustomerMaterial(request,response,context);
	}
	protected void _handleActionExportCustomerMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExportCustomerMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExportCustomerMaterialGroup(request,response,context);
	}
	protected void _handleActionExportCustomerMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExportCustomerGroupMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExportCustomerGroupMaterial(request,response,context);
	}
	protected void _handleActionExportCustomerGroupMaterial(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionExportCustomerGroupMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionExportCustomerGroupMaterialGroup(request,response,context);
	}
	protected void _handleActionExportCustomerGroupMaterialGroup(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}