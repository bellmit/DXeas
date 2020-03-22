/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractLayEggDailyListUIHandler extends com.kingdee.eas.framework.app.CoreBillListUIHandler

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
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionGenNextBill(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionGenNextBill(request,response,context);
	}
	protected void _handleActionGenNextBill(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionReShareInfos(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionReShareInfos(request,response,context);
	}
	protected void _handleActionReShareInfos(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionRefreshInventory(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionRefreshInventory(request,response,context);
	}
	protected void _handleActionRefreshInventory(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionToStockDaily(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionToStockDaily(request,response,context);
	}
	protected void _handleActionToStockDaily(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}