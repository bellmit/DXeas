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
		System.out.println("����BillType��" + BosType);
		System.out.println("����jason------------------------------");
		System.out.println(BillJson);
		System.out.println("����jason------------------------------");
		logger.info("��ʼ����ҵ�񵥾ݣ����������ǣ�" + BosType);

		IImportBill importBill = getImporter(ctx);
//		if(BillStatus==1)
//			return "ddd";
		try {
			return importBill.importing(ctx, BosType, BillJson, BillStatus);
		} catch (EASBizException e) {
			throw new BOSException(e.getMessage());
		}
	}

	// ��ýӿ�ʵ�ֶ���
	private IImportBill getImporter(Context ctx) {

		return new IImportBillImpl();
	}





	/**
     * ��ȡ��������
     * querystr�а���username��type����ֳ�������ᣬ��ֳ���Σ���ֳ�淶
     */
	@Override
	protected String _getBaseData(Context ctx, String queryStr)
			throws BOSException {
		// TODO Auto-generated method stub
		logger.info("---------��ʼ���ýӿ�------");
		System.out.println(queryStr);
		logger.info("����dataJson="+queryStr.toString());
		
		//��json�ַ���ת��Ϊjava����
		JSONObject obj=new JSONObject().fromObject(queryStr);
		BaseQueryBean jb=(BaseQueryBean) JSONObject.toBean(obj, BaseQueryBean.class);
		
		//��ȡ�������
		String username=jb.getUsername();
		String type=jb.getType();
		String params=jb.getParams();
		
		
		
		//��java����ת��Ϊjson�ַ���
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
		
		logger.info("����jsonbuffer===="+jsonBuffer);
		logger.info("-----------------�ӿڵ��óɹ�------------------------------");
		logger.info("---------------�������ýӿ�-------------");
		
		jsonBuffer.append("]");
		
		
		return jsonBuffer.toString();
	}
}