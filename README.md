# mybatis-generator-core-fix
mybatis generator 生成数据库备注为注释 修整部分代码的样式

本工程为maven项目，可以直接打包使用

生成后的样式：

package com.imooc.seckill.model;

import java.util.Date;

/**
 * 秒杀
 * TbSeckill
 * 数据库表：tb_seckill
 */
public class TbSeckill {

    /**
     * 商品库存id
     * 表字段 : tb_seckill.id
     */
    private Long id;

    /**
     * 商品名称
     * 表字段 : tb_seckill.name
     */
    private String name;

    /**
     * 库存数量
     * 表字段 : tb_seckill.number
     */
    private Integer number;

    /**
     * 
     * 表字段 : tb_seckill.create_time
     */
    private Date createTime;

    /**
     * 
     * 表字段 : tb_seckill.start_time
     */
    private Date startTime;

    /**
     * 
     * 表字段 : tb_seckill.end_time
     */
    private Date endTime;

    /**
     * 获取 商品库存id 字段:tb_seckill.id
     *
     * @return tb_seckill.id, 商品库存id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 商品库存id 字段:tb_seckill.id
     *
     * @param id the value for tb_seckill.id, 商品库存id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 商品名称 字段:tb_seckill.name
     *
     * @return tb_seckill.name, 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 商品名称 字段:tb_seckill.name
     *
     * @param name the value for tb_seckill.name, 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 库存数量 字段:tb_seckill.number
     *
     * @return tb_seckill.number, 库存数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置 库存数量 字段:tb_seckill.number
     *
     * @param number the value for tb_seckill.number, 库存数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取  字段:tb_seckill.create_time
     *
     * @return tb_seckill.create_time, 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置  字段:tb_seckill.create_time
     *
     * @param createTime the value for tb_seckill.create_time, 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取  字段:tb_seckill.start_time
     *
     * @return tb_seckill.start_time, 
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置  字段:tb_seckill.start_time
     *
     * @param startTime the value for tb_seckill.start_time, 
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取  字段:tb_seckill.end_time
     *
     * @return tb_seckill.end_time, 
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置  字段:tb_seckill.end_time
     *
     * @param endTime the value for tb_seckill.end_time, 
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
