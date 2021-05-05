package com.usydcapstone.allocation.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Grps {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String groupNumber;
    private int pre1;
    private int pre2;
    private int pre3;

}
