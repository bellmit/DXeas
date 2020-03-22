/**
 * output package name
 */
package com.kingdee.eas.custom.echickeninterface.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.WSInterface.WSInterfaceFacadeFactory;
import com.kingdee.eas.custom.echickeninterface.echickeninterfaceFacadeFactory;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class TestUI extends AbstractTestUI
{
    private static final Logger logger = CoreUIObject.getLogger(TestUI.class);
    
    /**
     * output class constructor
     */
    public TestUI() throws Exception
    {
        super();
        this.setUITitle("e����");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

	@Override
	protected void kDButton1_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//super.kDButton1_actionPerformed(e);
		
		//���ݵ���webservice����
		//�û�����
		//���ͣ�currentBatchBreedingStock ��ǰ���μ���������,orglist ��֯�б�,currentfeedlot ��ǰ��ֳ����,feedfactory��ֳ����feedlothead��ֳ���α�ͷ,feedlotentry��ֳ���η�¼��henhouse���ᣬfeedspecificationhead��ֳ�淶feedspecificationentry
		String username="user";
		String type="currentBatchBreedingStock";
		String params="at4AAAAWU50DZOcA,2016-02-24 15:4:32";
//		String params="-1,3";//7���䣬��Ʒ���淶
		String queryStr="{\"username\":\""+username+"\",\"type\":\""+type+"\",\"params\":\""+params+"\"}";
		String ss=echickeninterfaceFacadeFactory.getRemoteInstance().getBaseData(queryStr);
		System.out.println("��������"+ss);
		
		
		
		
		
		//��Ʒ���ձ�����"AUDITED", 4);
    	String BillType="CommecialChilkenDaily";
    	String BillJson="[{\"leavePersonQty\":0,\"lastUpdateUser\":{\"number\":\"�����\",\"id\":\"qBCgFtjmTYSdESqKWrSCmBO33n8\u003d\"},\"immuneEntrys\":[],\"outSideTFrom\":-6.5,\"isHenhouseEmpty\":false,\"entrys\":[{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030001\",\"id\":\"at4AAAABtp7vonYJ\"},\"id\":\"at4AAAAXN5UpSp2J\",\"seq\":1,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"1#����\",\"waterQty\":3300,\"dieselShare\":0,\"dailyQtyAll\":1726.36,\"coalShare\":833.33,\"standardFeedQty\":1726.36},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030002\",\"id\":\"at4AAAABtqHvonYJ\"},\"id\":\"at4AAAAXN5YpSp2J\",\"seq\":2,\"days\":13,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"2#����\",\"waterQty\":3600,\"dieselShare\":0,\"dailyQtyAll\":1871.23,\"coalShare\":833.33,\"standardFeedQty\":1871.23},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030003\",\"id\":\"at4AAAABtqPvonYJ\"},\"id\":\"at4AAAAXN5cpSp2J\",\"seq\":3,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"3#����\",\"waterQty\":3500,\"dieselShare\":0,\"dailyQtyAll\":1732.95,\"coalShare\":833.33,\"standardFeedQty\":1732.95},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030004\",\"id\":\"at4AAAABtqbvonYJ\"},\"id\":\"at4AAAAXN5gpSp2J\",\"seq\":4,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"4#����\",\"waterQty\":3500,\"dieselShare\":0,\"dailyQtyAll\":1739.6,\"coalShare\":833.33,\"standardFeedQty\":1739.6},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030005\",\"id\":\"at4AAAABtqnvonYJ\"},\"id\":\"at4AAAAXN5kpSp2J\",\"seq\":5,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"5#����\",\"waterQty\":3400,\"dieselShare\":0,\"dailyQtyAll\":1745.88,\"coalShare\":833.33,\"standardFeedQty\":1745.88},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030006\",\"id\":\"at4AAAABtqvvonYJ\"},\"id\":\"at4AAAAXN5opSp2J\",\"seq\":6,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"6#����\",\"waterQty\":3700,\"dieselShare\":0,\"dailyQtyAll\":1742.47,\"coalShare\":833.33,\"standardFeedQty\":1742.47},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030007\",\"id\":\"at4AAAABtq3vonYJ\"},\"id\":\"at4AAAAXN5spSp2J\",\"seq\":7,\"days\":10,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"7#����\",\"waterQty\":3300,\"dieselShare\":0,\"dailyQtyAll\":1417.2,\"coalShare\":833.33,\"standardFeedQty\":1417.2},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030008\",\"id\":\"at4AAAABtrTvonYJ\"},\"id\":\"at4AAAAXN5wpSp2J\",\"seq\":8,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"8#����\",\"waterQty\":3900,\"dieselShare\":0,\"dailyQtyAll\":1728.31,\"coalShare\":833.33,\"standardFeedQty\":1728.31},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030009\",\"id\":\"at4AAAABtrfvonYJ\"},\"id\":\"at4AAAAXN50pSp2J\",\"seq\":9,\"days\":10,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"9#����\",\"waterQty\":3200,\"dieselShare\":0,\"dailyQtyAll\":1415.5,\"coalShare\":833.33,\"standardFeedQty\":1415.5},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030010\",\"id\":\"at4AAAABtrjvonYJ\"},\"id\":\"at4AAAAXN54pSp2J\",\"seq\":10,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"10#����\",\"waterQty\":3400,\"dieselShare\":0,\"dailyQtyAll\":1724.29,\"coalShare\":833.33,\"standardFeedQty\":1724.29},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030011\",\"id\":\"at4AAAABtrrvonYJ\"},\"id\":\"at4AAAAXN58pSp2J\",\"seq\":11,\"days\":10,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"11#����\",\"waterQty\":2800,\"dieselShare\":0,\"dailyQtyAll\":1414.35,\"coalShare\":833.33,\"standardFeedQty\":1414.35},{\"materialName\":\"��С���������RJ-01\",\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"number\":\"SPJ-20151221-003\",\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"henhouse\":{\"number\":\"3041030012\",\"id\":\"at4AAAABtrvvonYJ\"},\"id\":\"at4AAAAXN6ApSp2J\",\"seq\":12,\"days\":12,\"material\":{\"number\":\"02-000001\",\"materialGroupDetails\":[],\"id\":\"at4AAAAApHFECefw\"},\"henhouseName\":\"12#����\",\"waterQty\":3600,\"dieselShare\":0,\"dailyQtyAll\":1726.97,\"coalShare\":833.37,\"standardFeedQty\":1726.97}],\"number\":\"SPJ-20151221-003\",\"fivouchered\":false,\"coalFual\":10000,\"stoOrg\":{\"number\":\"304103\",\"id\":\"at4AAAAAVkDM567U\"},\"auditor\":{\"number\":\"�����\",\"id\":\"qBCgFtjmTYSdESqKWrSCmBO33n8\u003d\"},\"bizDate\":\"2015-12-22 12:20:04\",\"cU\":{\"number\":\"3\",\"id\":\"at4AAAAAADrM567U\"},\"id\":\"at4AAAAXN5SFBtRp\",\"days\":0,\"outHumidityTo\":83,\"baseStatus\":{\"isenum\":true,\"alias\":\"����\",\"value\":1},\"entryPersonQty\":0,\"breedBatch\":{\"number\":\"20151209-001\",\"id\":\"at4AAAAWU50DZOcA\"},\"initPersonQty\":7,\"attendPersonQty\":7,\"costObject\":\"��Ʒ��20151208005\",\"creator\":{\"number\":\"�����\",\"id\":\"qBCgFtjmTYSdESqKWrSCmBO33n8\u003d\"},\"outSideTTo\":-15.8,\"weather\":\"��\",\"assEntrys\":[{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6GG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6KG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6OG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6SG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6WG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6aG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6eG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6iG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6mG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6qG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6uG2sX6\"},{\"parent\":{\"immuneEntrys\":[],\"entrys\":[],\"fodderPlanEntrys\":[],\"id\":\"at4AAAAXN5SFBtRp\",\"assEntrys\":[]},\"id\":\"at4AAAAXN6yG2sX6\"}],\"outHumidityFrom\":73,\"hasEffected\":false}]";
    	String BillJson2="[{\"bizdate\":\"2016-02-23 20:22:35\",\"dieselFual\":\"\",\"coalFual\":\"\",\"outSideTFrom\":\"\",\"outSideTTo\":\"\",\"outHumidityFrom\":\"\",\"outHumidityTo\":\"\",\"weather\":\"\",\"initPersonQty\":\"\",\"attendPersonQty\":\"\",\"breedLog\":\"ceshi3\",\"breedBatch\":{\"number\":\"20151209-001\"},\"costObject\":\"��Ʒ��20151208005\",\"stoOrg\":{\"number\":\"304103\"},\"cU\":{\"number\":\"3\"},\"creator\":{\"number\":\"user\"},\"baseStatus\":{\"isenum\":true,\"alias\":\"����\",\"value\":1},\"days\":0,\"leavePersonQty\":0,\"entryPersonQty\":0,\"isHenhouseEmpty\":false,\"hasEffected\":false,\"fivouchered\":false,\"entrys\":[{\"henhouse\":{\"number\":\"3041030001\"},\"henhouseName\":\"1#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"1\",\"waterQty\":\"1\",\"averageWeight\":\"1\",\"cullAndDeath\":\"1\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030002\"},\"henhouseName\":\"2#����\",\"days\":77,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"1\",\"waterQty\":\"1\",\"averageWeight\":\"1\",\"cullAndDeath\":\"1\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030003\"},\"henhouseName\":\"3#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030004\"},\"henhouseName\":\"4#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"1\",\"waterQty\":\"1\",\"averageWeight\":\"1\",\"cullAndDeath\":\"1\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030005\"},\"henhouseName\":\"5#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030006\"},\"henhouseName\":\"6#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030007\"},\"henhouseName\":\"7#����\",\"days\":74,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030008\"},\"henhouseName\":\"8#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030009\"},\"henhouseName\":\"9#����\",\"days\":74,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030010\"},\"henhouseName\":\"10#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030011\"},\"henhouseName\":\"11#����\",\"days\":74,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0},{\"henhouse\":{\"number\":\"3041030012\"},\"henhouseName\":\"12#����\",\"days\":76,\"materialName\":\"����������RJ-03\",\"material\":{\"number\":\"02-000003\",\"materialGroupDetails\":[]},\"standardFeedQty\":204,\"dailyQtyAll\":\"\",\"waterQty\":\"\",\"averageWeight\":\"\",\"cullAndDeath\":\"\",\"dieselShare\":0.00,\"coalShare\":0.0}],\"assEntrys\":[{\"henhouse\":{\"number\":\"3041030001\"},\"isMarketed\":false,\"cullAndDeath\":59,},{\"henhouse\":{\"number\":\"3041030002\"},\"isMarketed\":false,\"cullAndDeath\":75,},{\"henhouse\":{\"number\":\"3041030003\"},\"isMarketed\":false,\"cullAndDeath\":46,},{\"henhouse\":{\"number\":\"3041030004\"},\"isMarketed\":false,\"cullAndDeath\":49,},{\"henhouse\":{\"number\":\"3041030005\"},\"isMarketed\":false,\"cullAndDeath\":48,},{\"henhouse\":{\"number\":\"3041030006\"},\"isMarketed\":false,\"cullAndDeath\":45,},{\"henhouse\":{\"number\":\"3041030007\"},\"isMarketed\":false,\"cullAndDeath\":44,},{\"henhouse\":{\"number\":\"3041030008\"},\"isMarketed\":false,\"cullAndDeath\":108,},{\"henhouse\":{\"number\":\"3041030009\"},\"isMarketed\":false,\"cullAndDeath\":65,},{\"henhouse\":{\"number\":\"3041030010\"},\"isMarketed\":false,\"cullAndDeath\":48,},{\"henhouse\":{\"number\":\"3041030011\"},\"isMarketed\":false,\"cullAndDeath\":46,},{\"henhouse\":{\"number\":\"3041030012\"},\"isMarketed\":false,\"cullAndDeath\":83,}]}]";
    	int BillStatus=1;//1���棬2�ύ��3���
//    	String dr=echickeninterfaceFacadeFactory.getRemoteInstance().importBill(BillType, BillJson2, BillStatus);
//    	System.out.println("d:"+dr);
	}
	
	
	
	
	
	
	
	
}