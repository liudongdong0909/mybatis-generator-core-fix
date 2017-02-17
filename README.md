# mybatis-generator-core-fix
## branches-swagger-tkmapper 整合分支 
本工程为maven项目，可以直接打包使用
此分支整合了swagger 和 通用mapper 以及hibernate validators 的校验
最终的代码样式：
### mapper接口样式：
```
package com.ecps.ssm.mapper;

import com.ecps.ssm.pojo.TbOrder;
import tk.mybatis.mapper.common.Mapper;

public interface TbOrderMapper extends Mapper<TbOrder> {
}
```
### mapper.xml样式：
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ecps.ssm.mapper.TbOrderMapper">
    <resultMap id="BaseResultMap" type="com.ecps.ssm.pojo.TbOrder">
        <!--@mbggenerated-->
        <id column="order_id" jdbcType="VARCHAR" property="orderId" />
        <result column="payment" jdbcType="VARCHAR" property="payment" />
        <result column="payment_type" jdbcType="INTEGER" property="paymentType" />
        <result column="post_fee" jdbcType="VARCHAR" property="postFee" />
        <result column="status" jdbcType="INTEGER" property="status" />
        <result column="create_time" jdbcType="TIMESTAMP" property="createTime" />
        <result column="update_time" jdbcType="TIMESTAMP" property="updateTime" />
        <result column="payment_time" jdbcType="TIMESTAMP" property="paymentTime" />
        <result column="consign_time" jdbcType="TIMESTAMP" property="consignTime" />
        <result column="end_time" jdbcType="TIMESTAMP" property="endTime" />
        <result column="close_time" jdbcType="TIMESTAMP" property="closeTime" />
        <result column="shipping_name" jdbcType="VARCHAR" property="shippingName" />
        <result column="shipping_code" jdbcType="VARCHAR" property="shippingCode" />
        <result column="user_id" jdbcType="BIGINT" property="userId" />
        <result column="buyer_message" jdbcType="VARCHAR" property="buyerMessage" />
        <result column="buyer_nick" jdbcType="VARCHAR" property="buyerNick" />
        <result column="buyer_rate" jdbcType="INTEGER" property="buyerRate" />
    </resultMap>
    <sql id="Base_Column_List">
        <!--@mbggenerated-->
        order_id, payment, payment_type, post_fee, status, create_time, update_time, payment_time, 
        consign_time, end_time, close_time, shipping_name, shipping_code, user_id, buyer_message, 
        buyer_nick, buyer_rate
    </sql>
</mapper>
```
### model的样式：
```
package com.ecps.ssm.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@ApiModel(value="订单表",description="数据库表：tb_order")@Table(name = "tb_order")//swagger model注解
public class TbOrder {

    @ApiModelProperty(value="订单id",name="orderId", required=true)//swagger 属性 字段 注解
    @NotEmpty  //此处是hibernate validator的注解
    @Id //此处是通用mapper的注解
    @Column(name = "order_id") //此处是通用mapper的注解 如果数据库标准的下划线，则不用此注解也是可以的
    private String orderId;

    @ApiModelProperty(value="实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分",name="payment")
    @Column(name = "payment")
    private String payment;

    @ApiModelProperty(value="支付类型，1、在线支付，2、货到付款",name="paymentType")
    @Column(name = "payment_type")
    private Integer paymentType;


    /**
     * 获取 订单id 字段:tb_order.order_id
     *
     * @return tb_order.order_id, 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置 订单id 字段:tb_order.order_id
     *
     * @param orderId the value for tb_order.order_id, 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分 字段:tb_order.payment
     *
     * @return tb_order.payment, 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public String getPayment() {
        return payment;
    }

    /**
     * 设置 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分 字段:tb_order.payment
     *
     * @param payment the value for tb_order.payment, 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    /**
     * 获取 支付类型，1、在线支付，2、货到付款 字段:tb_order.payment_type
     *
     * @return tb_order.payment_type, 支付类型，1、在线支付，2、货到付款
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 设置 支付类型，1、在线支付，2、货到付款 字段:tb_order.payment_type
     *
     * @param paymentType the value for tb_order.payment_type, 支付类型，1、在线支付，2、货到付款
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

}
```



