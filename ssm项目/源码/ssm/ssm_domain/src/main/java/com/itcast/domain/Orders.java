package com.itcast.domain;

import com.itcast.utils.OrderStatusUtils;
import com.itcast.utils.PayTypeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {
    private String id; //无意义、主键uuid
    private String orderNum;//订单编号 不为空 唯一
    private Date orderTime;// 下单时间
    private String orderTimeStr;// 时间与字符串的转化结果
    private int orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private int peopleCount;//出行人数
    private Product product;//
    private List<Traveller> travellers;//
    private Member member;//
    private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;//
    private String orderDesc;//订单描述(其它信息)
    private String productid;//产品id 外键
    private String memberid; //会员(联系人）id 外键

    public String getOrderStatusStr() {
        if (orderStatus == 0) {
            orderStatusStr = OrderStatusUtils.NOYPAY;
        } else if (orderStatus == 1) {
            orderStatusStr = OrderStatusUtils.PAY;

        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr=" + orderStatusStr +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", productid=" + productid +
                ", memberid=" + memberid +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            orderTimeStr = simpleDateFormat.format(orderTime);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if(payType == 0){
            payTypeStr = PayTypeUtils.PAYTYPEZERO;
        }else
        if(payType == 1){
            payTypeStr = PayTypeUtils.PAYTYPEONE;
        }else if(payType == 2){
            payTypeStr = PayTypeUtils.PAYTYPETWO;
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }
}