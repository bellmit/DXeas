package com.kingdee.eas.custom.eas2temp.comm;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fm.common.FMException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.IInvBillBase;
import com.kingdee.eas.scm.im.inv.InvBillBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * ����˷���
 * @author USER
 *
 */
public class AppCommon {
	protected Context ctx;
	/**
	 * �õ�ʵ��
	 * @return
	 */
	public static AppCommon getInstance(Context ctx) {
		return new AppCommon(ctx);
	}
	private AppCommon(Context ctx) {
		this.ctx=ctx;
	}
	/**
	 * ����ĳ����ָ���ֶ�ֵ
	 * @param ctx
	 * @param tableName
	 * @param fieldValue
	 * @param upValue
	 * @throws BOSException 
	 */
	public static void updateTableFieldValue(Context ctx,String tableName,String fid, String fieldValue, Object upValue) throws BOSException{
		StringBuffer sb = new StringBuffer();
		sb.append("update  ");
		sb.append(tableName);
		sb.append(" set ");
		sb.append(fieldValue);
		sb.append(" =? where fid =?");
		Object[] args = {upValue,fid};
		
		DbUtil.execute(ctx, sb.toString(),args);
	}
	
	/**
	 * 
	 * @Title: updateModelStatus 
	 * @Description: ���µ���״̬
	 * @param @param model
	 * @param @param status    
	 * @return void    �������� 
	 * @throws BOSException 
	 * @throws
	 */ 
	public static void updateModelStatus(Context ctx, String tableName, String fid,BillBaseStatusEnum status) throws BOSException{
		StringBuilder sb = new StringBuilder();
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set CFBaseStatus ='");
		sb.append(status.getValue());
		sb.append("' ");
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		if(status.equals(BillBaseStatusEnum.AUDITED)){
			sb.append(" , fauditorid = '");
			sb.append(ctx.getCaller().toString());
			sb.append("' , CFAuditTime={ts'");
			sb.append(sFormat.format(new Date()));
			sb.append("'} ");
		}else if(status.equals(BillBaseStatusEnum.TEMPORARILYSAVED)){
			sb.append(" , fauditorid = '");
			sb.append("' , cfaudittime=null ");
		}
		sb.append(" where fid='");
		sb.append(fid);
		sb.append("'");
		DbUtil.execute(ctx, sb.toString());
	}
	
	/**
	 * ��֤ĳ�������Ƿ�������ε���
	 * @param ctx
	 * @param srcBosType
	 * @param srcBillId
	 * @return
	 * @throws BOSException 
	 */
	public static boolean existDestBill(Context ctx,String srcBosType,String srcBillId) throws BOSException{
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bot_relation t where fsrcentityid='");
		sb.append(srcBosType);
		sb.append("' and fsrcobjectid='");
		sb.append(srcBillId);
		sb.append("'");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
		
		
		
		return false;
	}
	
	
	/**
	 * ���ݹ�Ӧ�����ƻ�ö�Ӧ��Ӧ�̶���
	 * @param unitName
	 * @return
	 */
	public static SupplierInfo getSupplierByName(Context ctx, String supplierName){
		StringBuilder sb = new StringBuilder();
		sb.append("select fid from t_bd_supplier t where t.fname_l2 = '");
		sb.append(supplierName);
		sb.append("'");
		SupplierInfo supplierInfo = null;
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isNotBlank(fid)){
					supplierInfo = SupplierFactory.getLocalInstance(ctx).getSupplierInfo(new ObjectUuidPK(fid));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return supplierInfo;
	}
	/**
	 * ������������ ��ѯ����
	 * @param ctx
	 * @param materialName
	 * @return
	 */
	public static MaterialInfo getMaterialByName(Context ctx,
			String materialName,String controlOrgUnitNumber) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bd_material t inner join t_org_ctrlunit tc on t.FCONTROLUNITID = tc.fid where t.fstatus=1 and t.fname_l2 = '");
		sb.append(materialName);
		sb.append("' and tc.fnumber='");
		sb.append(controlOrgUnitNumber);
		sb.append("' ");
		
		MaterialInfo materialInfo = null;
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isNotBlank(fid)){
					materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(fid));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return materialInfo;
	}
	
	/**
	 * ��֤ĳ�ű����Ƿ��Ѿ�����ָ����ŵĵ���  ������ڷ���true ���򷵻�false
	 * @param ctx
	 * @param billNumber
	 * @return
	 * @throws BOSException 
	 */
	public static boolean checkBillNumberExist(Context ctx, String tableName, String billNumber) {
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fnumber from ");
		sb.append(tableName);
		sb.append(" t where t.fnumber='");
		sb.append(billNumber);
		sb.append("' ");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				System.out.print("true");
				return true;
				
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param ctx
	 * @param srcBosType Դ���ݵ�BosType
	 * @param destBosType Ŀ�굥�ݵ�BosType
	 * @param srcBillCollection Դ���ݼ��ϣ���������ת��
	 * @param botpPK Ҫʹ�õ�BOTP��PK��
	 * @throws Exception
	 */
	public static IObjectCollection generateDestBill(Context ctx, 
			String srcBosType,
		String destBosType, 
		CoreBillBaseCollection srcBillCollection,
		DefineSysEnum defineEnum,
		IObjectPK botpPK) throws Exception 
	{

		IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);

		CoreBillBaseInfo billInfo = srcBillCollection.get(0);
		// ��֤botp�Ƿ����
		BOTMappingInfo botMappingInfo = botMapping.getMapping(billInfo,
				destBosType, defineEnum);

		if (botMappingInfo == null) {

			throw new FMException(FMException.NODESTBILL);

		}

		IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);

		BTPTransformResult btpResult = null;

		/*
		 * String[] ids = new String[srcBillCollection.size()];
		 * 
		 * for (int i = 0; i < srcBillCollection.size(); ++i) {
		 * 
		 * CoreBaseInfo info = srcBillCollection.get(i);
		 * 
		 * ids[i] = info.getId().toString();
		 * 
		 * }
		 */
		// ����botp
		btpResult = iBTPManager.transformForBotp(srcBillCollection,
				destBosType, botpPK);

		IObjectCollection destBillCols = btpResult.getBills();

		BOTRelationCollection botRelationCols = btpResult
				.getBOTRelationCollection();
		// �������
		for (int i = 0; i < destBillCols.size(); i++) {

			CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols
					.getObject(i);

			iBTPManager.submitRelations(destBillInfo, botRelationCols);

		}
		
		return destBillCols;

	}  
	
	
	
	/**
	 * ��ȡ ָ�����ݵ�botp ID�б�
	 * @param ctx
	 * @param srcBosType
	 * @param isEffected
	 * @return
	 * @throws BOSException 
	 */
	public static List<String> getBillBotMappings(Context ctx, String srcBosType,DefineSysEnum definesysEnum, boolean isEffected) throws BOSException{
		ArrayList<String> result = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where t.fdefinesys=");
		sb.append(definesysEnum.getValue());
		sb.append(" and t.fsrcentityname='");
		sb.append(srcBosType);
		sb.append("' and te.fiseffected=");
		if(isEffected){
			sb.append("1");
		}else{
			sb.append("0");
		}
		
		sb.append(" order by t.fname ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			while(rs.next()){
				String fid = rs.getString(1);
				result.add(fid);
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
		
		
		
		return result;
		
	}
	
	
	
	/**
	 * ɾ��BOTP�Ѿ����ɵĵ���
	 * @param ctx
	 * @param col
	 */
	public static  void deleteBTPBills(Context ctx,CoreBaseCollection col) {
		IInvBillBase iInstace = null;// ���ҵ�񵥾ݶ���ӿ�			
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
		InvBillBaseInfo info;
		ObjectUuidPK pk;
		for(int index=0;index<col.size();index++) {
			try{
				info=(InvBillBaseInfo) col.get(index);
				pk=new ObjectUuidPK(info.getId());
				EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(info.getBOSType().toString()));
				if (eo == null) {
					return;
				}
				Class cls = Class.forName(eo.getBusinessImplFactory());
				Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
				iInstace = (IInvBillBase) mtd.invoke(cls, new Object[] { ctx });
				info=iInstace.getInvBillBaseInfo(pk);
				if(info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
					iInstace.unAudit(pk);
				}
				iInstace.delete(pk);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * ɾ��BOTP�Ѿ����ɵĵ���
	 * @param ctx
	 * @param col
	 */
	public  void deleteBTPBills(Context ctx,InvBillBaseInfo destBillInfo) {
		IInvBillBase iInstace = null;// ���ҵ�񵥾ݶ���ӿ�			
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
		InvBillBaseInfo info;
		ObjectUuidPK pk;
		
			try{
				
				pk=new ObjectUuidPK(destBillInfo.getId());
				EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(destBillInfo.getBOSType().toString()));
				if (eo == null) {
					return;
				}
				Class cls = Class.forName(eo.getBusinessImplFactory());
				Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
				iInstace = (IInvBillBase) mtd.invoke(cls, new Object[] { ctx });
				info=iInstace.getInvBillBaseInfo(pk);
				if(info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
					iInstace.unAudit(pk);
				}
				iInstace.delete(pk);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	
	// �õ��Զ�����
	public String getAutoCode(Context ctx, IObjectValue objValue, String companyId) throws EASBizException,
			BOSException {
		if(!isCodeRuleEnable(ctx,objValue,companyId)) {
			SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			return format.format(new java.util.Date());
		}
		//IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
		//orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}

	// �Ƿ����ñ������
	public boolean isCodeRuleEnable(Context ctx, IObjectValue objValue, String companyId) throws EASBizException,
			BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}
	
	/**
	 * ����id�б� ȡ�� ��Χ�ִ�    ��'','',''��
	 * @param ids
	 * @return
	 */
	public static String getIDRangeStr(List<String> ids){
		StringBuilder sb = new StringBuilder("(");
		for(int i = 0; i < ids.size(); i++){
			if(i != 0) {
				sb.append(",");
			}
			sb.append("'");
			sb.append(ids.get(i));
			sb.append("'");
		}
		
		sb.append(")");
		
		return sb.toString();
	}
	
}
