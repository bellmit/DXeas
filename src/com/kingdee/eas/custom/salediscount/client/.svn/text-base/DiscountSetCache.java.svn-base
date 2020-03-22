/*     */ package com.kingdee.eas.custom.salediscount.client;
/*     */ 
/*     */ import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.SalePriceTO;
import com.kingdee.eas.basedata.scm.sd.sale.client.PriceSolve;
import com.kingdee.eas.scm.common.loadmass.SaleOrderDataVO;
/*     */ 
/*     */ public final class DiscountSetCache
/*     */ {
/*  30 */   private static DiscountSetCache cache = null;
/*     */ 
/*  32 */   Map cacheMap = null;
/*     */ 
/*  34 */   Map keyMap = null;
/*     */ 
/*     */   private DiscountSetCache() {
/*  37 */     this.keyMap = new HashMap();
/*  38 */     this.cacheMap = new HashMap();
/*     */   }
/*     */ 
/*     */   public static DiscountSetCache getInstance() {
/*  42 */     if (cache == null) {
/*  43 */       cache = new DiscountSetCache();
/*     */     }
/*     */ 
/*  46 */     return cache;
/*     */   }
/*     */ 
/*     */   public SalePriceTO getSalePrice(PriceCondition condition)
/*     */   {
/*  51 */     if ((condition.getCurrencyInfo() == null) || (condition.getMaterialInfo() == null) || (condition.getSaleOrg() == null))
/*     */     {
/*  54 */       return null;
/*     */     }
/*  56 */     String key = condition.getSaleOrg().getId().toString() + ((condition.getCustomerInfo() != null) ? condition.getCustomerInfo().getId().toString() : null) + condition.getMaterialInfo().getId().toString() + ((condition.getCurrencyInfo() != null) ? condition.getCurrencyInfo().getId().toString() : null) + ((condition.getAssisProperty() != null) ? condition.getAssisProperty().getId().toString() : null) + condition.getMeasureUnit();
/*     */ 
/*  66 */     int counts = 0;
/*  67 */     String symbol = null;
/*  68 */     if (this.keyMap.containsKey(key))
/*     */     {
/*  70 */       String value = (String)this.keyMap.get(key);
/*  71 */       symbol = value.substring(0, 1);
/*  72 */       counts = Integer.valueOf(value.substring(1)).intValue();
/*     */ 
/*  76 */       SalePriceTO price = findPrice(condition, key, counts);
/*  77 */       if ((price == null) && (symbol.equals("1")))
/*  78 */         condition.setPriceType("basePrice");
/*     */       else {
/*  80 */         return price;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 127 */     return fetchPrice(key, condition, counts);
/*     */   }
/*     */ 
/*     */   private SalePriceTO fetchPrice(String key, PriceCondition condition, int counts)
/*     */   {
/* 136 */     PriceSolve priceSolve = new PriceSolve();
/*     */ 
/* 138 */     Collection prices = priceSolve.fetchPriceInfos(condition);
/* 139 */     if (prices != null) {
/* 140 */       int idx = counts;
/* 141 */       counts += prices.size();
/*     */ 
/* 143 */       this.keyMap.put(key, "1" + counts);
/*     */ 
/* 146 */       Iterator iter = prices.iterator();
/* 147 */       while (iter.hasNext()) {
/* 148 */         this.cacheMap.put(key + (idx++), iter.next());
/*     */       }
/*     */ 
/* 151 */       SalePriceTO price = findPrice(condition, key, counts);
/* 152 */       if (price == null) {
/* 153 */         String value = (String)this.keyMap.get(key);
/* 154 */         String symbol = value.substring(0, 1);
/* 155 */         if ((!(condition.getPriceType().equals("basePrice"))) && (symbol.equals("1")))
/*     */         {
/* 159 */           condition.setPriceType("basePrice");
/* 160 */           return fetchPrice(key, condition, counts);
/*     */         }
/*     */       }
/* 163 */       return price;
/*     */     }
/*     */ 
/* 166 */     if (condition.getPriceType().equals("basePrice"))
/* 167 */       if (this.keyMap.containsKey(key)) {
/* 168 */         counts = Integer.valueOf(((String)this.keyMap.get(key)).substring(1)).intValue();
/*     */ 
/* 170 */         this.keyMap.put(key, "2" + counts);
/*     */       }
/*     */     else {
/* 173 */       this.keyMap.put(key, "00");
/*     */     }
/*     */ 
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */   public List putInCache(SaleOrderDataVO resultVO)
/*     */   {
/* 189 */     if (resultVO.getPriceList() == null) {
/* 190 */       return null;
/*     */     }
/* 192 */     int size = resultVO.getMaterialInfos().length;
/* 193 */     List priceList = new ArrayList(size);
/* 194 */     int idxOfPrice = 0;
/* 195 */     for (int idxOfMaterial = 0; idxOfMaterial < size; ++idxOfMaterial) {
/* 196 */       if (resultVO.getMaterialInfos()[idxOfMaterial] == null) {
/*     */         continue;
/*     */       }
/* 199 */       String key = resultVO.getMainOrg().getId().toString() + ((resultVO.getCustomerInfo() != null) ? resultVO.getCustomerInfo().getId().toString() : null) + resultVO.getMaterialInfos()[idxOfMaterial].getId().toString() + ((resultVO.getCurrencyInfo() != null) ? resultVO.getCurrencyInfo().getId().toString() : null) + ((resultVO.getAsstProperties() != null) ? null : (resultVO.getAsstProperties()[idxOfMaterial] != null) ? resultVO.getAsstProperties()[idxOfMaterial].getId().toString() : null) + ((resultVO.getMeasureUnitInfos()[idxOfMaterial] != null) ? resultVO.getMeasureUnitInfos()[idxOfMaterial].getId().toString() : null);
/*     */ 
/* 224 */       List prices = (List)resultVO.getPriceList().get(idxOfPrice++);
/* 225 */       if (!(this.keyMap.containsKey(key)))
/*     */       {
/* 227 */         int counts = 0;
/* 228 */         if ((prices != null) && (prices.size() > 0)) {
/* 229 */           int idx = counts;
/* 230 */           boolean isKey = false;
/* 231 */           boolean includeBase = false;
/* 232 */           int i = 0; for (int s = prices.size(); i < s; ++i) {
/* 233 */             SalePriceTO price = (SalePriceTO)prices.get(i);
/* 234 */             this.cacheMap.put(key + (idx++), price);
/* 235 */             if ((!(isKey)) && (price != null)) {
/* 236 */               ++counts;
/* 237 */               if (!(includeBase)) {
/* 238 */                 includeBase = price.priceType.equals("basePrice");
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/* 243 */           this.keyMap.put(key, "1" + counts);
/* 244 */           priceList.add(findPrice(resultVO, prices, idxOfMaterial));
/*     */         }
/*     */         else
/*     */         {
/* 254 */           this.keyMap.put(key, "00");
/*     */ 
/* 256 */           priceList.add(null);
/*     */         }
/*     */       } else {
/* 259 */         priceList.add(findPrice(resultVO, prices, idxOfMaterial));
/*     */       }
/*     */     }
/*     */ 
/* 263 */     return priceList;
/*     */   }
/*     */ 
/*     */   private SalePriceTO findPrice(SaleOrderDataVO resultVO, List prices, int idxOfMaterial)
/*     */   {
/* 268 */     if (prices == null) {
/* 269 */       return null;
/*     */     }
/* 271 */     boolean found = false;
/*     */ 
/* 274 */     if (resultVO.isDoContainsPriceOnUpperBill()) {
/* 275 */       int i = 0; for (int s = prices.size(); i < s; ++i) {
/* 276 */         SalePriceTO price = (SalePriceTO)prices.get(i);
/* 277 */         if ((price.priceType != null) && (price.priceType.equals("DiscountSet")))
/*     */         {
/* 280 */           if (resultVO.getServerDate() != null) {
/* 281 */             java.util.Date date1 = price.dateFrom;
/* 282 */             java.util.Date date2 = price.dateTo;
/* 283 */             java.util.Date serverDate = getServerDate(resultVO.getServerDate());
/*     */ 
/* 286 */             if ((serverDate.compareTo(date1) >= 0) && (((date2 == null) || (serverDate.compareTo(date2) <= 0))))
/*     */             {
/* 289 */               found = true;
/*     */             }
/*     */           }
/*     */ 
/* 293 */           if ((found) && (resultVO.getQuantities() != null)) {
/* 294 */             BigDecimal entryQty = new BigDecimal("0.00");
/* 295 */             BigDecimal qty1 = price.qtyFrom;
/* 296 */             BigDecimal qty2 = price.qtyTo;
/* 297 */             System.out.println(entryQty);
/* 298 */             System.out.println(qty1);
/* 299 */             System.out.println(qty2);
/* 300 */             if ((((qty1 == null) || (entryQty.compareTo(qty1) >= 0))) && (((qty2 == null) || (entryQty.compareTo(qty2) <= 0))))
/*     */             {
/* 303 */               return price;
/*     */             }
/*     */           }
/*     */         }
/*     */         else {
/* 308 */           return price;
/*     */         }
/*     */       }
/*     */     } else {
/* 312 */       return findPriceWhenUpperBillHasNoPrice(resultVO, prices, idxOfMaterial);
/*     */     }
/* 314 */     System.out.println("ddddd");
/* 315 */     return null;
/*     */   }
/*     */ 
/*     */   private SalePriceTO findPriceWhenUpperBillHasNoPrice(SaleOrderDataVO resultVO, List prices, int idxOfMaterial)
/*     */   {
/* 330 */     int i = 0; for (int s = prices.size(); i < s; ++i) {
/* 331 */       SalePriceTO price = (SalePriceTO)prices.get(i);
/*     */ 
/* 334 */       if ((price.priceType == null) || (!(price.priceType.equals("DiscountSet"))))
/*     */       {
/* 336 */         return price;
/*     */       }
/* 338 */       if ((resultVO.getServerDate() == null) || (resultVO.getQuantities() == null) || (resultVO.getQuantities()[idxOfMaterial] == null)) {
/*     */         continue;
/*     */       }
/* 341 */       java.util.Date date1 = price.dateFrom;
/* 342 */       java.util.Date date2 = price.dateTo;
/* 343 */       BigDecimal qty1 = price.qtyFrom;
/* 344 */       BigDecimal qty2 = price.qtyTo;
/* 345 */       java.util.Date serverDate = getServerDate(resultVO.getServerDate());
/*     */ 
/* 348 */       boolean satisfyDateConditions = (serverDate.compareTo(date1) >= 0) && (((date2 == null) || (serverDate.compareTo(date2) <= 0)));
/*     */ 
/* 352 */       boolean satisfyQtyConditions = (((qty1 == null) || (resultVO.getQuantities()[idxOfMaterial].compareTo(qty1) >= 0))) && (((qty2 == null) || (resultVO.getQuantities()[idxOfMaterial].compareTo(qty2) <= 0)));
/*     */ 
/* 357 */       if ((satisfyDateConditions) && (satisfyQtyConditions)) {
/* 358 */         return price;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 363 */     return null;
/*     */   }
/*     */ 
/*     */   private java.util.Date getServerDate(java.util.Date serverDate)
/*     */   {
/* 372 */     java.util.Date curDate = Calendar.getInstance().getTime();
/* 373 */     curDate.setYear(serverDate.getYear());
/* 374 */     curDate.setMonth(serverDate.getMonth());
/* 375 */     curDate.setDate(serverDate.getDate());
/*     */ 
/* 377 */     return new java.sql.Date(curDate.getTime());
/*     */   }
/*     */ 
/*     */   private SalePriceTO findPrice(PriceCondition condition, String key, int counts)
/*     */   {
/* 382 */     String subkey = null;
/* 383 */     boolean found = false;
/* 384 */     boolean isBasic = false;
/* 385 */     for (int i = 0; i < counts; ++i) {
/* 386 */       subkey = key + i;
/* 387 */       if (this.cacheMap.containsKey(subkey)) {
/* 388 */         found = true;
/*     */ 
/* 390 */         SalePriceTO price = (SalePriceTO)this.cacheMap.get(subkey);
/* 391 */         isBasic = (isBasic) ? true : price.priceType.equals("basePrice");
/*     */ 
/* 393 */         if ((price.priceType != null) && (price.priceType.equals("DiscountSet")))
/*     */         {
/* 396 */           if (condition.getCurDate() != null) {
/* 397 */             java.util.Date date1 = price.dateFrom;
/* 398 */             java.util.Date date2 = price.dateTo;
/* 399 */             java.util.Date curDate = getServerDate(condition.getCurDate());
/* 400 */             if ((curDate.compareTo(date1) >= 0) && (((date2 == null) || (curDate.compareTo(date2) <= 0))))
/*     */             {
/* 402 */               found = true;
/*     */             }
/*     */             else found = false;
/*     */ 
/*     */           }
/*     */ 
/* 408 */           if ((found) && (condition.getOrderQty() != null)) {
/* 409 */             BigDecimal qty = new BigDecimal(0.0D);
/* 410 */             BigDecimal qty1 = price.qtyFrom;
/* 411 */             BigDecimal qty2 = price.qtyTo;
/* 412 */             if ((null != qty1) && (condition.getOrderQty().compareTo(qty1) >= 0) && (null != qty2) && (condition.getOrderQty().compareTo(qty2) <= 0))
/*     */             {
/* 420 */               found = true;
/* 421 */               if (found) {
/*     */                 break;
/*     */               }
/*     */             }
/*     */ 
/* 426 */             if ((qty1 == null) && (condition.getOrderQty().compareTo(qty) >= 0) && (qty2 == null))
/*     */             {
/* 428 */               found = true;
/*     */             }
/*     */             else {
/* 431 */               found = false;
/*     */             }
/*     */           }
/*     */         }
/* 435 */         if (found) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/* 440 */     if ((!(condition.getPriceType().equals("basePrice"))) && (isBasic))
/*     */     {
/* 442 */       this.keyMap.put(key, "2" + counts);
/*     */     }
/* 444 */     if (found)
/*     */     {
/* 446 */       return ((SalePriceTO)this.cacheMap.get(subkey));
/*     */     }
/* 448 */     return null;
/*     */   }
/*     */ 
/*     */   public BigDecimal getPriceMin(PriceCondition condition)
/*     */   {
/* 453 */     SalePriceTO priceTO = getInstance().getSalePrice(condition);
/*     */ 
/* 455 */     if (priceTO != null) {
/* 456 */       return priceTO.priceMin;
/*     */     }
/* 458 */     return null;
/*     */   }
/*     */ 
/*     */   public static void clearCache()
/*     */   {
/* 470 */     if (cache != null) {
/* 471 */       cache.keyMap.clear();
/* 472 */       cache.cacheMap.clear();
/*     */     }
/*     */   }
/*     */ }
