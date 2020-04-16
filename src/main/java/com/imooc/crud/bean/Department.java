package com.imooc.crud.bean;

import javax.persistence.*;

@Table(name = "dept")
public class Department {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    public Department(Integer Id, String deptName) {
        this.deptId=Id;
        this.deptName=deptName;
    }

    /**
     * @return dept_id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}