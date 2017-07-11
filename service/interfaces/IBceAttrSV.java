package huangwf5.service.interfaces;

import java.util.List;

import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpItemRelatBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpProductItemBean;

public interface IBceAttrSV {
  public BOUpProductItemBean[] getProductItemByCreaterAndItemType(String creater,String itemType);
  //根据属性查询服务
  public BOUpItemRelatBean[] getUpItemRelatByKindAndRelatProductItemIdAndDelFlag(String prodItemRelatKindId,String relatProductItemId,String delFlag) throws Exception;

  //根据类型，产品单元id，del_flag查询相应产品单元
  public BOUpItemRelatBean[] getUpItemRelatByKind$ProductItemId$DelFlag(String prodItemRelatKindId,String productItemId,String delFlag);
  
  //获取产品配置中所有产品的属性,增加此方法主要是解决部分属性不是现配，而是直接沿用之前的属性
  public BOUpProductItemBean[] getAllAttr(String offerId);
}
