package com.usydcapstone.allocation.entity;

import lombok.Data;

@Data
public class Project {
    private long id;
    private String title;
    private String type;
    private int numofgrps;
    private String units;
    private String skills;
    private int fullstatus;
}
