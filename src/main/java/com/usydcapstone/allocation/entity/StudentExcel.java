package com.usydcapstone.allocation.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@HeadRowHeight(value = 40)
public class StudentExcel {
    @ExcelProperty(value = "SID", index = 0)
    @ColumnWidth(value = 15)
    private String sid;

    @ExcelProperty(value = "name", index = 1)
    @ColumnWidth(value = 15)
    private String name;

    @ExcelProperty(value = "email", index = 2)
    @ColumnWidth(value = 15)
    private String email;

    @ExcelProperty(value = "password", index = 3)
    @ColumnWidth(value = 15)
    private String password;


}