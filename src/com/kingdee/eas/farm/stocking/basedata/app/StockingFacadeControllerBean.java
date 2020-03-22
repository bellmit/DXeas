package com.kingdee.eas.farm.stocking.basedata.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.master.cssp.ISupplier;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.IParentBreedBatch;
import com.kingdee.eas.farm.breed.ParentBreedBatchFactory;
import com.kingdee.eas.farm.breed.layegg.ILayEggDaily;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.IBreedData;
import com.kingdee.eas.farm.stocking.basedata.IFarm;
import com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.IFarmers;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class StockingFacadeControllerBean extends AbstractStockingFacadeControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.StockingFacadeControllerBean");

	@Override
	protected String _CreateCostObject(Context ctx, Object param) throws BOSException {
		// TODO Auto-generated method stub
		
		
		
			String companyID = param.toString();
			StringBuffer sql = new StringBuffer();
			sql.append("select FID,FCostItemID,FEggCostItemID from T_FM_StockingBatch ");
			sql.append(" where FCostItemID is null or FCostItemID='' or FEggCostItemID is null or FEggCostItemID=''");
			sql.append(" and FCompanyID='").append(companyID).append("'");

			IRowSet rs;
			try {
				rs = SQLExecutorFactory.getLocalInstance(ctx,sql.toString()).executeSQL();
				System.out.print("rs�ǣ�" + rs);
					
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("material.*"));
				slor.add(new SelectorItemInfo("bridMaterial.*"));
				slor.add(new SelectorItemInfo("Entry.*"));
				slor.add(new SelectorItemInfo("Entry.material.*"));
				BreedDataInfo bInfo = null;
				BaseSysSettingInfo sysSetting = null;

				
				SelectorItemCollection slor1 = new SelectorItemCollection();
				slor1.add(new SelectorItemInfo("*"));
				slor1.add(new SelectorItemInfo("company.*"));
				IStockingBatch is = StockingBatchFactory.getLocalInstance(ctx);
				IBreedData ibs = BreedDataFactory.getLocalInstance(ctx);
				
				// �����ֵ��ɱ�����
				CreateCreatCostObject cCostObject = new CreateCreatCostObject();
				

				 sysSetting = StockingComm.getSysSetting(ctx,companyID);
			
				while (rs.next()) {
				
					StockingBatchInfo info = is.getStockingBatchInfo(new ObjectUuidPK(rs.getString("FID")),slor1);
					System.out.print("StockingFacadeControllerBean"+info);
					
					if ((rs.getString("FCostItemID") == null||rs.getString("FEggCostItemID") == null)
							&& (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable))) {
						 bInfo=ibs.getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId()), slor);
							
						cCostObject.create(bInfo, info, sysSetting, ctx);
						is.update(new ObjectUuidPK(info.getId()),info);

					}

				}

			} catch (Exception e) {
				throw new BOSException(e);
			}
	

		return null;

	}

	@Override
	protected void _Internal2StockingDaily(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		String companyID = param;
		
		
		
//		try {
//			updateAllQty(ctx,companyID);
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String sql1 = "Drop  TABLE  t_fm_internal2stokcingRecord";
//		DbUtil.execute(ctx, sql1);

		
//		String sql1 = "create table t_fm_internal2stokcingRecord (finternalDailyID varchar(255) not null,FStockingDailyID varchar(255) not null,fdatetime datetime not null,FopUserID varchar(255) not null)";
//		DbUtil.execute(ctx, sql1);
//		String sql2 = "insert into t_fm_internal2stokcingRecord (finternalDailyID,FStockingDailyID,fdatetime,FopUserID) values('1','1',to_date('2011/09/07 12:00:00','YYYY/MM/DD HH24:MI:SS'),'1')";
//		DbUtil.execute(ctx, sql2);
		
		
		// ��ѯ���е������ձ�
		

		StringBuffer sql = new StringBuffer();
		sql.append(" select tdaily.fid FID,tb.fid batchID,tdaily.FBizDate bizDate, tpb.fnumber parentBatchNumber,tb.ffarmid farmID,tb.FFarmerID FarmerID,tdaily.cffarmid LayEggFarmID,tdaily.CFIsTransBrood CFIsTransBrood,tdaily.CFHadFixed CFHadFixed").append(" from CT_FM_LayEggDaily tdaily")
		.append(" inner join CT_FM_ParentBreedBatch tpb on tpb.fid=tdaily.CFParentBatchID")
		.append(" inner join CT_FM_BreedStoorgSet tfb on tdaily.CFFarmID=tfb.fid")
		.append(" inner join t_fm_stockingbatch tb on tb.fnumber=tpb.fnumber")// �����������κ����
		.append(" Where tfb.CFCompanyID=")
		.append("'")
		.append(companyID)
		.append("'")
		
		//��ʱ����
		.append("  and tdaily.CFFarmID = 'lwwAAAAJrrsDkxtS'");
		
		
		
		
//		// ��δִ��ת����
//		.append(" and tdaily.fid not in (")
//		.append(" select finternalDailyID ")
//		.append(" from t_fm_internal2stokcingRecord ")
//		.append(")");

		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
//		
//
		try {
			LayEggDailyInfo fromInfo;
			ILayEggDaily ifs = LayEggDailyFactory.getLocalInstance(ctx);
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add("*");
			slor.add("LayEggEntrys.*");
			slor.add("CullDeathEntrys.*");
			slor.add("ImmuneEntrys.*");
			slor.add("TransHenhouseEntrys.*");
			slor.add("SendEggEntry.*");

			SelectorItemCollection StockingBatchSlor = new SelectorItemCollection();
			StockingBatchSlor.add("*");
			
			SelectorItemCollection parentBatchSlor = new SelectorItemCollection();
			parentBatchSlor.add("*");

			SelectorItemCollection framSlor = new SelectorItemCollection();
			framSlor.add("*");

			SelectorItemCollection henHouseSlor = new SelectorItemCollection();
			henHouseSlor.add("*");

			StockingBreedDailyInfo toInfo;
			IStockingBreedDaily iss = StockingBreedDailyFactory.getLocalInstance(ctx);// �����ձ�
			IStockingBatch isb = StockingBatchFactory.getLocalInstance(ctx);// ����
			IFarm ifarm = FarmFactory.getLocalInstance(ctx);// ��ֳ��
			IFarmers ifarmer = FarmersFactory.getLocalInstance(ctx);// ��ֳ��
			IFarmHouseEntry iFramHouseEntry = FarmHouseEntryFactory.getLocalInstance(ctx);// ����
			IParentBreedBatch iparentBreedbatch=ParentBreedBatchFactory.getLocalInstance(ctx);
			IMeasureUnit imeasureUnit=MeasureUnitFactory.getLocalInstance(ctx);
			IMaterial imaterial=MaterialFactory.getLocalInstance(ctx);
			ICompanyOrgUnit icompanyOrgUnit = CompanyOrgUnitFactory.getLocalInstance(ctx);
	

			String insertStr = "/*dialect*/ insert into t_fm_internal2stokcingRecord (finternalDailyID,FStockingDailyID,fdatetime,FopUserID) values(?,?,?,?)";
			Date nowDate = new java.util.Date();
			DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String strBeginDate = dateTimeformat.format(nowDate);
		
			
			java.sql.Date sqlDate = null;
			try {
				sqlDate = new java.sql.Date(dateTimeformat.parse(strBeginDate).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String opUserID = ContextUtil.getCurrentUserInfo(ctx).getString("id");

			while (rs.next()) {
				fromInfo = ifs.getLayEggDailyInfo(new ObjectUuidPK(rs.getString("fid")), slor);

				toInfo = new StockingBreedDailyInfo();
				BOSUuid toID = BOSUuid.create(toInfo.getBOSType());
				toInfo.setId(toID);
				toInfo.setNumber(fromInfo.getNumber());// ���ݱ��
				String StockingBatchNumber = rs.getString("parentBatchNumber");// ���α���
				
				System.out.println(fromInfo.getNumber());
				sql.setLength(0);
				sql.append(" select fid").append(" from t_fm_stockingbatch").append(" where fnumber = ").append("'").append(
						StockingBatchNumber).append("'");
				IRowSet rs1 = DbUtil.executeQuery(ctx, sql.toString());
				rs1.next();
				//System.out.println("rs1:"+rs1.getString("fid"));

				toInfo.setStockingBatch(isb.getStockingBatchInfo(new ObjectUuidPK(rs1.getString("fid")), StockingBatchSlor));// ����

				System.out.println("rs2:"+rs.getString("farmID"));
 				toInfo.setFarm(ifarm.getFarmInfo(new ObjectUuidPK(rs.getString("farmID")), framSlor));// ��ֳ��
 				toInfo.setCompany(icompanyOrgUnit.getCompanyOrgUnitInfo(new ObjectUuidPK(companyID), StockingBatchSlor));//������֯
 				toInfo.setFarmer(ifarmer.getFarmersInfo(new ObjectUuidPK(rs.getString("FarmerID")), framSlor));//��ֳ��
 				toInfo.setIsBreed(rs.getBoolean("CFIsTransBrood"));//ת����
 				toInfo.setIsMature(rs.getBoolean("CFHadFixed"));//��Ⱥ

				toInfo.setBaseStatus(fromInfo.getBaseStatus());// ״̬
				toInfo.setBizDate(fromInfo.getBizDate());// ҵ��ʱ��
				toInfo.setWeek(fromInfo.getWeek());// ��
				toInfo.setWeekDay(fromInfo.getWeekDay());// ��
				toInfo.setCreator(fromInfo.getCreator());// ������
				toInfo.setCreateTime(fromInfo.getCreateTime());// ����ʱ��
				toInfo.setAuditor(fromInfo.getAuditor());// �����
				toInfo.setAuditTime(fromInfo.getAuditTime());// ���ʱ��

				// ������Ϣ��¼

//				LayEggDailyLayEggEntryCollection layEggEntrys = fromInfo.getLayEggEntrys();
//				sql.setLength(0);
				String tdailyID = rs.getString("fid");
//				sql.append(" select tfh.FNumber HenhouseNumber,isnull(CFAllEggs,0) CFAllEggs,isnull(CFQualifiedEggs,0) CFQualifiedEggs,isnull(CFFreakEggs,0) CFFreakEggs,isnull(CFDoubleYolkEggs,0) CFDoubleYolkEggs,isnull(CFBrokenEggs,0) CFBrokenEggs")
//				.append(" from CT_FM_LayEggDailyLayEggEntrys tled")
//				.append(" inner join CT_FM_Henhouse tfh on tled.cfhenhouseid=tfh.fid")
//				.append(" inner join CT_FM_LayEggDaily tdaily on tdaily.fid=tled.fparentid ")
//				.append(" where tled.FParentID = ")
//				.append("'")
//				.append(tdailyID)
//				.append("'")
//				.append(" and tdaily.CFFarmID=")
//				.append("'")
//				.append(rs.getString("LayEggFarmID"))
//				.append("'");
//				IRowSet rs3 = DbUtil.executeQuery(ctx, sql.toString());
				
//				System.out.println("������Ϣrs3:"+rs3.getString("HenhouseNumber"));

//				for (int i = 0; i < layEggEntrys.size(); i++) {
					
//				while(rs3.next()){
////					LayEggDailyLayEggEntryInfo layEggEntryInfo = layEggEntrys.get(i);
//
//					StockingBreedDailyEggEntryInfo toInfoEggEntry = new StockingBreedDailyEggEntryInfo();
//
//					String henHouseNumber = rs3.getString("HenhouseNumber");// �������
//					sql.setLength(0);
//					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
//					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
//					.append(" where tfhe.cfnumber= ").append("'").append(
//							henHouseNumber).append("'")
//							.append(" and tff.fid=")
//							.append("'")
//							.append(rs.getString("farmID"))
//							.append("'");
//					IRowSet rschanDan = DbUtil.executeQuery(ctx, sql.toString());
//					rschanDan.next();
//					toInfoEggEntry.setHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rschanDan.getString("fid")),
//							henHouseSlor));// ����
//
//					toInfoEggEntry.setAllQty(new BigDecimal(rs3.getString("CFAllEggs")));// �ܵ���
//					
////					toInfoEggEntry.setUnit(imeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(), framSlor));//
//					toInfoEggEntry.setQcQty(rs3.getInt("CFQualifiedEggs"));// �ϸ���
//					toInfoEggEntry.setMutantQty(rs3.getInt("CFFreakEggs"));// ���ε���
//					toInfoEggEntry.setDoubleQty(rs3.getInt("CFDoubleYolkEggs"));// ˫�Ƶ���
//					toInfoEggEntry.setBrokenQty(rs3.getInt("CFBrokenEggs"));// �Ƶ���
//					// StockingEggEntrys.add(toInfoEggEntry);
//					toInfo.getEggEntry().add(toInfoEggEntry);
//				}
				//

				// ��Ʒ���� ��¼
//				LayEggDailySendEggEntryCollection sendEggEntrys = fromInfo.getSendEggEntry();
				// StockingBreedDailySendEggEntryCollection
				// StockingSendEggEntrys = new
				// StockingBreedDailySendEggEntryCollection();
//				sql.setLength(0);
//				sql.append(" select tfh.FNumber HenhouseNumber,isnull(CFAllQty,0) CFAllQty,isnull(CFQcQty,0) CFQcQty,isnull(CFMutantQty,0) CFMutantQty,isnull(CFBrokenQty,0) CFBrokenQty,isnull(CFDoubleQty,0) CFDoubleQty,isnull(CFAllReceiveQty,0) CFAllReceiveQty,isnull(CFReceiveQcQty,0) CFReceiveQcQty,isnull(CFReceiveMutantQty,0) CFReceiveMutantQty,isnull(CFReceiveBrokenQty,0) CFReceiveBrokenQty,isnull(CFReceiveDoubleQty,0) CFReceiveDoubleQty,isnull(CFReceiveOtherQty,0) CFReceiveOtherQty")
//				.append(" from CT_FM_LayEggDailySendEggEntry tled")
//				.append(" inner join CT_FM_Henhouse tfh on tled.cfhouseid=tfh.fid")
//				.append(" inner join CT_FM_LayEggDaily tdaily on tdaily.fid=tled.fparentid ")
//				.append(" where tled.FParentID = ")
//				.append("'")
//				.append(tdailyID)
//				.append("'")
//				.append(" and tdaily.CFFarmID=")
//				.append("'")
//				.append(rs.getString("LayEggFarmID"))
//				.append("'");
//				IRowSet rsdanPin = DbUtil.executeQuery(ctx, sql.toString());
//				
//				
////				for (int i = 0; i < sendEggEntrys.size(); i++) {
////					LayEggDailySendEggEntryInfo sendEggEntryInfo = sendEggEntrys.get(i);
//				while(rsdanPin.next()){
//					StockingBreedDailySendEggEntryInfo toInfoSendEggEntry = new StockingBreedDailySendEggEntryInfo();
//
//					String henHouseNumber = rsdanPin.getString("HenhouseNumber");// �������
//					sql.setLength(0);
//					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
//					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
//					.append(" where tfhe.cfnumber= ").append("'").append(
//							henHouseNumber).append("'")
//							.append(" and tff.fid=")
//							.append("'")
//							.append(rs.getString("farmID"))
//							.append("'");
//					IRowSet rs4 = DbUtil.executeQuery(ctx, sql.toString());
//					rs4.next();
//
//					toInfoSendEggEntry.setHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rs4.getString("fid")),
//							StockingBatchSlor));// ����
//					toInfoSendEggEntry.setAllQty(rsdanPin.getInt("CFAllQty"));// ������
//					toInfoSendEggEntry.setQcQty(rsdanPin.getInt("CFQcQty"));// �ϸ�
//					toInfoSendEggEntry.setMutantQty(rsdanPin.getInt("CFMutantQty"));// ���ε�
//					toInfoSendEggEntry.setBrokenQty(rsdanPin.getInt("CFBrokenQty"));// �Ƶ�
//					toInfoSendEggEntry.setDoubleQty(rsdanPin.getInt("CFDoubleQty"));
//					toInfoSendEggEntry.setAllReceiveQty(rsdanPin.getInt("CFAllReceiveQty"));// �ܽ�������
//					toInfoSendEggEntry.setReceiveQcQty(rsdanPin.getInt("CFReceiveQcQty"));// ���պϸ�
//					toInfoSendEggEntry.setReceiveMutantQty(rsdanPin.getInt("CFReceiveMutantQty"));// ���ջ��ε�
//					toInfoSendEggEntry.setReceiveBrokenQty(rsdanPin.getInt("CFReceiveBrokenQty"));// �����Ƶ�
//					toInfoSendEggEntry.setReceiveDoubleQty(rsdanPin.getInt("CFReceiveDoubleQty"));// ����˫�Ƶ�
//					toInfoSendEggEntry.setReceiveOtherQty(rsdanPin.getInt("CFReceiveOtherQty"));// ��������
//
//					// StockingSendEggEntrys.add(toInfoSendEggEntry);
//					toInfo.getSendEggEntry().add(toInfoSendEggEntry);
//
//				}

				// ������Ϣ��¼
//				LayEggDailyImmuneEntryCollection immuneEntrys = fromInfo.getImmuneEntrys();
				// StockingBreedDailyImmuneEntryCollection StockingImmuneEntrys
				// = new StockingBreedDailyImmuneEntryCollection();
//				IMaterial imaterial=MaterialFactory.getLocalInstance(ctx);
//				sql.setLength(0);
//				sql.append(" select tfh.FNumber HenhouseNumber,CFVaccineMaterialI,CFVaccineUnit,isnull(CFVaccineGetQty,0) CFVaccineGetQty,isnull(CFVaccineUsedQty,0) CFVaccineUsedQty")
//				.append(" from CT_FM_LayEggDailyImmuneEntrys tled")
//				.append(" inner join CT_FM_Henhouse tfh on tled.CFHenhouseID=tfh.fid")
//				.append(" inner join CT_FM_LayEggDaily tdaily on tdaily.fid=tled.fparentid ")
//				.append(" where tled.FParentID = ")
//				.append("'")
//				.append(tdailyID)
//				.append("'")
//				.append(" and tdaily.CFFarmID=")
//				.append("'")
//				.append(rs.getString("LayEggFarmID"))
//				.append("'");
//				IRowSet rsMianyi = DbUtil.executeQuery(ctx, sql.toString());
//				for (int i = 0; i < immuneEntrys.size(); i++) {
//				while(rsMianyi.next()){
////					LayEggDailyImmuneEntryInfo ImmuneEntryInfo = immuneEntrys.get(i);
//					StockingBreedDailyImmuneEntryInfo toInfoImmuneEntry = new StockingBreedDailyImmuneEntryInfo();
//
//					String henHouseNumber = rsMianyi.getString("HenhouseNumber");// �������
//					sql.setLength(0);
//					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
//					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
//					.append(" where tfhe.cfnumber= ").append("'").append(
//							henHouseNumber).append("'")
//							.append(" and tff.fid=")
//							.append("'")
//							.append(rs.getString("farmID"))
//							.append("'");
//					IRowSet rs4 = DbUtil.executeQuery(ctx, sql.toString());
//					rs4.next();
//
//					toInfoImmuneEntry.setHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rs4.getString("fid")),
//							StockingBatchSlor));// ����
//					toInfoImmuneEntry.setVaccineMaterial(imaterial.getMaterialInfo(new ObjectUuidPK(rsMianyi.getString("CFVaccineMaterialI"))));// ����
//					toInfoImmuneEntry.setVaccineUnit(rsMianyi.getString("CFVaccineUnit"));// ������λ
//					toInfoImmuneEntry.setVaccineGetQty(new BigDecimal(rsMianyi.getString("CFVaccineGetQty")));// ;
//																							// ������
//					toInfoImmuneEntry.setVaccineUsedQty(new BigDecimal(rsMianyi.getString("CFVaccineUsedQty")));// ʹ����
//
//					// StockingImmuneEntrys.add(toInfoImmuneEntry);
//					toInfo.getImmuneEntrys().add(toInfoImmuneEntry);
//				}

				// ������Ϣ��¼--��ֳ��Ϣ��¼
//				LayEggDailyCullDeathEntryCollection CullDeathEntrys = fromInfo.getCullDeathEntrys();
				
				
				// StockingBreedDailyAssEntryCollection StockingAssEntrys =new
				// StockingBreedDailyAssEntryCollection();
				sql.setLength(0);
				sql.append(" select tfh.FNumber HenhouseNumber,isnull(CFCockDeath,0) CFCockDeath,isnull(CFHenDeath,0) CFHenDeath,isnull(CFCockCull,0) CFCockCull,isnull(CFHenCull,0) CFHenCull,isnull(CFCockBreekingStock,0) CFCockBreekingStock,isnull(CFHenhouseBreekingStock,0) CFHenhouseBreekingStock")
				.append(" from CT_FM_LayEDCDE tled")
				.append(" inner join CT_FM_Henhouse tfh on tled.CFHenhouseID=tfh.fid")
				.append(" inner join CT_FM_LayEggDaily tdaily on tdaily.fid=tled.fparentid ")
				.append(" where tled.FParentID = ")
				.append("'")
				.append(tdailyID)
				.append("'")
				.append(" and tdaily.CFFarmID=")
				.append("'")
				.append(rs.getString("LayEggFarmID"))
				.append("'");
				IRowSet rsSiTao = DbUtil.executeQuery(ctx, sql.toString());
				
//				for (int i = 0; i < CullDeathEntrys.size(); i++) {
				while(rsSiTao.next()){
//					LayEggDailyCullDeathEntryInfo CullDeathEntryInfo = CullDeathEntrys.get(i);
					StockingBreedDailyAssEntryInfo toInfoAssEntry = new StockingBreedDailyAssEntryInfo();

					String henHouseNumber = rsSiTao.getString("HenhouseNumber");// �������
					sql.setLength(0);
					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
					.append(" where tfhe.cfnumber= ").append("'").append(
							henHouseNumber).append("'")
							.append(" and tff.fid=")
							.append("'")
							.append(rs.getString("farmID"))
							.append("'");
					IRowSet rs4 = DbUtil.executeQuery(ctx, sql.toString());
					rs4.next();

					toInfoAssEntry.setHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rs4.getString("fid")),
							StockingBatchSlor));// ����
					toInfoAssEntry.setDeathQty(rsSiTao.getInt("CFCockDeath"));// ����������
					toInfoAssEntry.setFemaleDeathQty(new BigDecimal(rsSiTao.getInt("CFHenDeath")));// ĸ��������
					toInfoAssEntry.setCullQty(rsSiTao.getInt("CFCockCull"));// ������̭��
					toInfoAssEntry.setFemaleCullQty(new BigDecimal(rsSiTao.getInt("CFHenCull")));// ĸ����̭��
					toInfoAssEntry.setBreekingStock(rsSiTao.getInt("CFCockBreekingStock"));// ���ݴ�����
					toInfoAssEntry.setFemaleBreedkingStock(new BigDecimal(rsSiTao.getInt("CFHenhouseBreekingStock")));// ĸ�ݴ�����
					
					sql.setLength(0);
					sql.append(" select to_char(tentry.FInData,'yyyy-MM-dd') FDate,isnull(tentry.FQty,0) FQty,isnull(tentry.FFemaleQty,0) FFemaleQty")
					.append(" from T_FM_StockingBatch tmain ")
					.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid")
					.append(" where tmain.fid='").append(rs.getString("batchID")).append("'")
					.append(" and tentry.fhouseid='").append(rs4.getString("fid")).append("'");
					
					Date inDate=null;
					IRowSet rs7 = DbUtil.executeQuery(ctx, sql.toString());
					if(rs7.next()) {
						inDate=rs7.getDate("FDate");
					}
					
					if(inDate!=null) {
						
						int[] weekAndDays= StockingComm.getBreedWeekAndDay(rs.getDate("bizDate"), inDate);
						toInfoAssEntry.setWeek(weekAndDays[0]);//����
						toInfoAssEntry.setWeekDays(new BigDecimal(weekAndDays[1]));//����
					
					}
					
					

					// StockingAssEntrys.add(toInfoAssEntry);
					toInfo.getAssEntrys().add(toInfoAssEntry);

				}

				// ת����Ϣ��¼
//				LayEggDailyTransHenhouseEntryCollection TransHenhouseEntrys = fromInfo.getTransHenhouseEntrys();
				// StockingBreedDailyTransEntryCollection StockingTransEntrys =
				// new StockingBreedDailyTransEntryCollection();
				
				ISupplier isupplier=SupplierFactory.getLocalInstance(ctx);
				sql.setLength(0);
				sql.append(" select tfh.FNumber toHenhouseNumber,tfpb.FNumber batchNumber,tfh1.FNumber fromHenhouseNumber,isnull(CFTransCockQty,0) CFTransCockQty,isnull(CFTransHenQty,0) CFTransHenQty,CFSupplierID")
				.append(" from CT_FM_LayEDTHE tled")
				.append(" inner join CT_FM_Henhouse tfh on tled.CFToHenhouseID=tfh.fid")
				.append(" inner join CT_FM_Henhouse tfh1 on tfh1.fid=tled.CFFromHenhouseID")
				.append(" inner join CT_FM_LayEggDaily tdaily on tdaily.fid=tled.fparentid ")
				.append(" inner join CT_FM_ParentBreedBatch tfpb on tfpb.fid=tled.CFFromBatchID")
				.append(" where tled.FParentID = ")
				.append("'")
				.append(tdailyID)
				.append("'")
				.append(" and tdaily.CFFarmID=")
				.append("'")
				.append(rs.getString("LayEggFarmID"))
				.append("'");
				IRowSet rszhuanLan = DbUtil.executeQuery(ctx, sql.toString());
				
//				for (int i = 0; i < TransHenhouseEntrys.size(); i++) {
				while(rszhuanLan.next()){
//					LayEggDailyTransHenhouseEntryInfo TransHenhouseEntryInfo = TransHenhouseEntrys.get(i);
					StockingBreedDailyTransEntryInfo toInfoTransEntry = new StockingBreedDailyTransEntryInfo();
					String henHouseNumber = rszhuanLan.getString("toHenhouseNumber");// ת���������
					sql.setLength(0);
					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
					.append(" where tfhe.cfnumber= ").append("'").append(
							henHouseNumber).append("'")
							.append(" and tff.fid=")
							.append("'")
							.append(rs.getString("farmID"))
							.append("'");
					IRowSet rs4 = DbUtil.executeQuery(ctx, sql.toString());
				    rs4.next();
					toInfoTransEntry.setHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rs4.getString("fid")),
							StockingBatchSlor));// ת������
					toInfoTransEntry.setTransQty(rszhuanLan.getInt("CFTransCockQty"));// ת������
																							// (
																							// ��
																							// )
					toInfoTransEntry.setTransFemaleQty(rszhuanLan.getInt("CFTransHenQty"));// ת������
																								// (
																								// ĸ
																								// )

					String batchNumber = rszhuanLan.getString("batchNumber");
					sql.setLength(0);
					sql.append(" select fid,FFarmID,FFarmerID").append(" from t_fm_stockingbatch").append(" where fnumber = ").append("'").append(batchNumber).append("'");
					IRowSet rs6 = DbUtil.executeQuery(ctx, sql.toString());
					rs6.next();
					toInfoTransEntry.setFromStockingBatch(isb.getStockingBatchInfo(new ObjectUuidPK(rs6.getString("fid")),
							StockingBatchSlor));// ת������
					toInfoTransEntry.setFromFarm(ifarm.getFarmInfo(new ObjectUuidPK(rs6.getString("FFarmID")), framSlor));//ת����ֳ��
					toInfoTransEntry.setFromFarmers(ifarmer.getFarmersInfo(new ObjectUuidPK(rs6.getString("FFarmerID")), framSlor));//ת����ֳ��

					String fromhenHouseNumber = rszhuanLan.getString("fromHenhouseNumber");// ת���������
					sql.setLength(0);
					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
					.append(" where tfhe.cfnumber= ").append("'").append(
							fromhenHouseNumber).append("'")
							.append(" and tff.fid=")
							.append("'")
							.append(rs6.getString("FFarmID"))
							.append("'");
					IRowSet rs5 = DbUtil.executeQuery(ctx, sql.toString());
					rs5.next();
					toInfoTransEntry.setFromHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rs5.getString("fid")),
							StockingBatchSlor));// ת������
//					toInfoTransEntry.setSupplier(isupplier.getSupplierInfo(new ObjectUuidPK(rszhuanLan.getString("CFSupplierID"))));//��Ӧ��

					// StockingTransEntrys.add(toInfoTransEntry);
					toInfo.getTransEntry().add(toInfoTransEntry);

				}

				// ��ι��Ϣ��¼
//				LayEggDailyEntryCollection entrys = fromInfo.getEntrys();
				// StockingBreedDailyEntryCollection toInfoEntrys = new
				// StockingBreedDailyEntryCollection();
				sql.setLength(0);
				sql.append(" select tfh.FNumber HenhouseNumber,tbm.fid MaterialID,CFHenMaterialName HenMaterialName,tbm.FBaseUnit baseUnit,isnull(CFCockQty,0) CFCockQty,isnull(CFHenQty,0) CFHenQty,isnull(CFWaterQty,0) CFWaterQty")
				.append(" from CT_FM_LayEggDailyEntry tled")
				.append(" inner join CT_FM_Henhouse tfh on tled.CFHenhouseID=tfh.fid")
				.append(" inner join CT_FM_LayEggDaily tdaily on tdaily.fid=tled.fparentid ")
				.append(" inner join T_BD_Material tbm on tled.CFHenMaterialID=tbm.fid")
				.append(" where tled.FParentID = ")
				.append("'")
				.append(tdailyID)
				.append("'")
				.append(" and tdaily.CFFarmID=")
				.append("'")
				.append(rs.getString("LayEggFarmID"))
				.append("'");
				IRowSet rssiwei = DbUtil.executeQuery(ctx, sql.toString());
//				for (int i = 0; i < entrys.size(); i++) {
				while(rssiwei.next()){
//					LayEggDailyEntryInfo entryInfo = entrys.get(i);
					StockingBreedDailyEntryInfo toInfoEntry = new StockingBreedDailyEntryInfo();

					String henHouseNumber = rssiwei.getString("HenhouseNumber");// �������
					sql.setLength(0);
					sql.append(" select tfhe.fid fid").append(" from CT_FM_FarmHouseEntry tfhe")
					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
					.append(" where tfhe.cfnumber= ").append("'").append(
							henHouseNumber).append("'")
							.append(" and tff.fid=")
							.append("'")
							.append(rs.getString("farmID"))
							.append("'");
					IRowSet rs4 = DbUtil.executeQuery(ctx, sql.toString());
					rs4.next();

					toInfoEntry.setHouse(iFramHouseEntry.getFarmHouseEntryInfo(new ObjectUuidPK(rs4.getString("fid")),
							StockingBatchSlor));// ����
					
					String MaterialNumber = rssiwei.getString("MaterialID");// ���ϱ���
//					sql.setLength(0);
//					sql.append(" select tfhe.fid fid").append(" from T_BD_Material tfhe")
//					.append(" inner join T_FM_Farm tff on tff.fid=tfhe.fparentid")
//					.append(" where tfhe.cfnumber= ").append("'").append(
//							henHouseNumber).append("'")
//							.append(" and tff.fid=")
//							.append("'")
//							.append(rs.getString("farmID"))
//							.append("'");
//					IRowSet rs4 = DbUtil.executeQuery(ctx, sql.toString());
//					rs4.next();
//					
					toInfoEntry.setMaterial(imaterial.getMaterialInfo(new ObjectUuidPK(rssiwei.getString("MaterialID"))));//���ϱ���
					toInfoEntry.setMaterialName(rssiwei.getString("HenMaterialName"));//��������
					toInfoEntry.setUnit(imeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(rssiwei.getString("baseUnit"))));//��λ
					
					toInfoEntry.setDailyQtyAll(rssiwei.getBigDecimal("CFCockQty"));// ����������
					toInfoEntry.setFemaleDailyQty(rssiwei.getBigDecimal("CFHenQty"));// ĸ��������
					toInfoEntry.setWaterQty(rssiwei.getBigDecimal("CFWaterQty"));// ��ˮ��

					// toInfoEntrys.add(toInfoEntry);
					toInfo.getEntrys().add(toInfoEntry);
					
				}
				

				iss.addnew(toInfo);//to_date('2011/09/07 12:00:00','YYYY/MM/DD HH24:MI:SS')new Timestamp(date.getTime())nowDate
				// �����¼
//				StringBuffer insertStr = "/*dialect*/ insert into t_fm_internal2stokcingRecord (finternalDailyID,FStockingDailyID,fdatetime,FopUserID) values(?,?,?,?)";
				sql.setLength(0);
				sql.append(" /*dialect*/")
				.append(" insert into t_fm_internal2stokcingRecord")
				.append(" (finternalDailyID,FStockingDailyID,fdatetime,FopUserID)")
				.append(" values(")
				.append("'")
				.append(fromInfo.getString("id").toString())
				.append("'")
				.append(",")
				.append("'")
				.append(toID.toString())
				.append("'")
				.append(",")
				.append(" to_date(")
				.append("'")
				.append(sqlDate)
				.append("'")
				.append(",'YYYY/MM/DD HH24:MI:SS')")
				.append(",")
				.append("'")
				.append(opUserID.toString())
				.append("'")
				.append(")");
 				//DbUtil.execute(ctx, sql.toString());
//				break;
 				
			}

		} catch (SQLException e) {
			throw new BOSException(e);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * �ܵ���Ϊnull����ֳ�ձ����������¼���
	 * @param ctx
	 * @param companyID
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */

	private void updateAllQty(Context ctx, String companyID) throws BOSException, SQLException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		
//		  select  distinct 
//			tmain.fid
//
//
////			tbe.CFMutantQty+
////			tbe.CFQcQty+
////			tbe.CFBrokenQty+
////			tbe.CFDoubleQty 
//			from T_FM_StockingBreeddaily tmain 
//			inner join T_FM_StockingBDEE tbe 
//			on tbe.fparentid = tmain.fid
//			where tbe.fallQty is null
		
		sql.append(" select distinct tmain.fid fid ")
		.append(" from T_FM_StockingBreeddaily tmain ")
		.append(" inner join T_FM_StockingBDEE tbe ")
		.append(" on tbe.fparentid = tmain.fid ")
		.append(" where tbe.fallQty is null ");
		if (StringUtils.isNotEmpty(companyID)) {
			sql.append(" and tmain.FCompanyID='").append(companyID).append("'");
		}
		
		SelectorItemCollection slor = new SelectorItemCollection();
		slor.add(new SelectorItemInfo("*"));
		slor.add(new SelectorItemInfo("EggEntry.*"));

		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		while(rs.next()){
			String fid = rs.getString("fid");
			StockingBreedDailyInfo info = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(fid),slor);
			for(int i =0;i<info.getEggEntry().size();i++){
				StockingBreedDailyEggEntryInfo  bInfo = info.getEggEntry().get(i);
//				int mutantQty = bInfo.getMutantQty();
//				int QcQty = bInfo.getQcQty();
//				int BrokenQty = bInfo.getBrokenQty();
//				int doubleQty = bInfo.getDoubleQty();
				
//				int AllQty = mutantQty+QcQty+BrokenQty+doubleQty;
//				
//				bInfo.setAllQty(new BigDecimal(AllQty));
				
				StockingBreedDailyEggEntryFactory.getLocalInstance(ctx).update(new ObjectUuidPK(bInfo.getId()), bInfo);
			}
			
		}
		
		
	}



	private Date TO_DATE(String beginDateStr) {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		Date date = null;
		try {
			date = sdf.parse(beginDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
}