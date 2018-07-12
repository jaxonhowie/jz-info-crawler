package org.jz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jz.model.JobDescription;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
@Mapper
public interface JobDescriptionDao {

    void insert(JobDescription jobDescription);
}
