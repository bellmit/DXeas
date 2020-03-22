/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractTransportationrecordListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

{
	public void handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrint(request,response,context);
	}
	protected void _handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrintPreview(request,response,context);
	}
	protected void _handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAuditback(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAuditback(request,response,context);
	}
	protected void _handleActionAuditback(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionSendend(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionSendend(request,response,context);
	}
	protected void _handleActionSendend(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionCalfright(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionCalfright(request,response,context);
	}
	protected void _handleActionCalfright(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUpdateMileage(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUpdateMileage(request,response,context);
	}
	protected void _handleActionUpdateMileage(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAppointPerson(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAppointPerson(request,response,context);
	}
	protected void _handleActionAppointPerson(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionViewUpdateMileage(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionViewUpdateMileage(request,response,context);
	}
	protected void _handleActionViewUpdateMileage(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}