/**
 * output package name
 */
package com.kingdee.eas.custom.farmpolling.client;

import java.awt.Toolkit;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDFrame;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.fileUtils.FileCommUtils;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class PollingRecordBillEditUI extends AbstractPollingRecordBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(PollingRecordBillEditUI.class);

	/**
	 * output class constructor
	 */
	public PollingRecordBillEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();

		if(editData.getId() != null)
			try {
				String attachments = FileCommUtils.getAttachments(null, editData.getString("id"));
				JSONArray array = JSONObject.fromObject(attachments).getJSONArray("data");
				JSONObject jsonElement = null;
				String type;
				String fileName;
				String simpleName;
				String fileSize;
				String fileContent;
				for(int i = 0;i<array.size();i++){
					jsonElement = (JSONObject)array.get(i);
					type = jsonElement.getString("type");
					fileName = jsonElement.getString("name");
					simpleName = jsonElement.getString("simpleName");
					fileSize = jsonElement.getString("size");
					fileContent = jsonElement.getString("content");
					if(StringUtils.isNotEmpty(simpleName)&& commUtils.arrayListContainsElement(simpleName, new String[]{"png","gif","jpeg","bmp","jpg"})){
						MsgBox.showInfo(type+"\n"+fileName+"\n"+simpleName+"\n"+fileSize+"\n"+fileContent+"\n");
						final KDFrame fram=new KDFrame();
						fram.setSize(400,250);
						int x = Toolkit.getDefaultToolkit().getScreenSize().width - 300;
						int y = Toolkit.getDefaultToolkit().getScreenSize().height - 300;
						fram.setLocation(x-100, y-7);


						//基本信息以textArea展示
						fram.setTitle("图片显示");
					}
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.farmpolling.PollingRecordBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo objectValue = new com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		pksignInTime.setTimeEnabled(true);
		pksignOutTime.setTimeEnabled(true);
		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		pkconfirmTime.setTimeEnabled(true);
	}

}