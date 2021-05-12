package com.usydcapstone.allocation.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student implements Serializable {
    private static final long serialVersionUID =  -5144055068797033748L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String sid;
    private String name;
    private String email;
    private String password;
    private Long groupId;
}
