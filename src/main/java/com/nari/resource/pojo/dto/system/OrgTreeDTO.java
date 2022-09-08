package com.nari.resource.pojo.dto.system;

import java.util.List;

/**
 * @title OrgTreeDTO
 * @description 单位信息
 * @author G_F
 * @date 2021/1/7 10:34
 */
public class OrgTreeDTO {
    /**
     * 单位名称
     */
    private String orgName;
    /**
     * 单位编号
     */
    private String orgNo;
    /**
     * 供电单位类型编码
     */
    private String orgType;
    /**
     * 供电单位类型编码
     */
    private String pOrgNo;
    /**
     * 供电单位类型编码
     */
    private List<OrgTreeDTO> children;
}
