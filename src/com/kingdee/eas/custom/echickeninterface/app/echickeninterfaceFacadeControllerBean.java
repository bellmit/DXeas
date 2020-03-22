package com.kingdee.eas.custom.echickeninterface.app;



import java.sql.SQLException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

import com.kingdee.eas.custom.echickeninterface.billFacade.IImportBill;
import com.kingdee.eas.custom.echickeninterface.billFacade.IImportBillImpl;
import com.kingdee.eas.custom.echickeninterface.common.BaseQueryBean;
import com.kingdee.eas.custom.echickeninterface.common.CommonExportUtils;

public class echickeninterfaceFacadeControllerBean extends AbstractechickeninterfaceFacadeControllerBean
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7776973766438844016L;
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.echickeninterface.app.echickeninterfaceFacadeControllerBean");



 


	@Override
	protected String _importBill(Context ctx, String BosType, String BillJson,
			int BillStatus) throws BOSException {
		System.out.println();
		System.out.println(ctx.toString());
		System.out.println("传入BillType：" + BosType);
		System.out.println("传入jason------------------------------");
		System.out.println(BillJson);
		System.out.println("传入jason------------------------------");
		logger.info("开始导入业务单据，单据类型是：" + BosType);

		IImportBill importBill = getImporter(ctx);
//		if(BillStatus==1)
//			return "ddd";
		try {
			return importBill.importing(ctx, BosType, BillJson, BillStatus);
		} catch (EASBizException e) {
			throw new BOSException(e.getMessage());
		}
	}

	// 获得接口实现对象
	private IImportBill getImporter(Context ctx) {

		return new IImportBillImpl();
	}





	/**
     * 获取基础资料
     * querystr中包含username，type：养殖场，鸡舍，养殖批次，养殖规范
     */
	@Override
	protected String _getBaseData(Context ctx, String queryStr)
			throws BOSException {
		// TODO Auto-generated method stub
		logger.info("---------开始调用接口------");
		System.out.println(queryStr);
		logger.info("传入dataJson="+queryStr.toString());
		
		//将json字符串转换为java对象
		JSONObject obj=new JSONObject().fromObject(queryStr);
		BaseQueryBean jb=(BaseQueryBean) JSONObject.toBean(obj, BaseQueryBean.class);
		
		//获取传入参数
		String username=jb.getUsername();
		String type=jb.getType();
		String params=jb.getParams();
		
		
		
		//将java对象转换为json字符串
		StringBuffer jsonBuffer=new StringBuffer();
		jsonBuffer.append("[");
		String json="";
		try {
			json=(String) CommonExportUtils.getBaseData( ctx, username, type,params);
			
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonBuffer.append(json);
		
		logger.info("导出jsonbuffer===="+jsonBuffer);
		logger.info("-----------------接口调用成功------------------------------");
		logger.info("---------------结束调用接口-------------");
		
		jsonBuffer.append("]");
		
		
		return jsonBuffer.toString();
	}
}