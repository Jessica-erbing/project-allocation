package com.usydcapstone.allocation.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocationException extends RuntimeException {
    private Integer code;
    private String msg;
}