/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.framework.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * output class name
 * 
 * 
 * 
 * 
 * 
 * warning   本单据只设置了10个阶段的分录，暂时不支持更多分录
 */
public class ContractChangeView extends AbstractContractChangeView
{
	private static final Logger logger = CoreUIObject.getLogger(ContractChangeView.class);

	/**
	 * output class constructor
	 */
	public ContractChangeView() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kDTable1.addHeadRow();
		
		
		
//		String srcBillID = (String) this.getUIContext().get("srcBillID");
//		loadUIData(srcBillID);
	}
	/**
	 * 加载界面
	 * 
	 * question   i+2  只是一个猜测值
	 * 经验证   该表格这样制作  没有表头行  而且 添加的标题行  均无效（因为没有列）
	 */
	public void loadUIData(String id)
	{
		//获得所有版本的id
		ArrayList<String> idsD=new ArrayList<String>();
		idsD.add(id);
		String preId=id;
		do
		{
			try {
				ContractInfo info = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(preId));
				if(info.getPerVersionID()!=null)
				{
					idsD.add(info.getPerVersionID().toString());
					preId=info.getPerVersionID().toString();
				}
				else
					preId=null;
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(preId!=null);

		//获得从前往后的id数组
		ArrayList<String> ids=new ArrayList<String>();
		for(int i=idsD.size()-1;i>=0;i--)
			ids.add(idsD.get(i));

		//获取所有的历史版本，依次取值
		for(int i=0;i<ids.size();i++)
		{
			kDTable1.addRow();
			ContractInfo info=null;
			try {
				info = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(ids.get(i)));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//版本号和合同金额
//			kDTable1.getRow(i).getCell("Field").setValue(info.getVersion());
			kDTable1.getRow(i).getCell(1).setValue(info.getAmountOriCurrency());
			kDTable1.getRow(i).getCell("BailAmt").setValue(info.getBailAmount());

			//循环遍历所有的分录，取出付款金额和可最大付款金额  赋值
			String temppayAmt=null;
			String tempoverAmt=null;
			for(int j=0;j<info.getPayment().size();i++)
			{
				//				if(info.getPayment().get(j).getPayAmount()==null)
				//					continue;
				temppayAmt="phase"+j+"payAmt";
				temppayAmt="phase"+j+"overAmt";
				
				//赋值   
				kDTable1.getRow(i+2).getCell(temppayAmt).setValue(info.getPayment().get(j).getPayAmount());
//				if(info.getPayment().get(j).getOverAmt()!=null)
//					kDTable1.getRow(i+2).getCell(tempoverAmt).setValue(info.getPayment().get(j).getOverAmt());
			}
		}

	}

}