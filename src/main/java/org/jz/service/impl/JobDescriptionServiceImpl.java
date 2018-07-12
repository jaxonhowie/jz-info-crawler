package org.jz.service.impl;

import org.jz.dao.JobDescriptionDao;
import org.jz.model.JobDescription;
import org.jz.service.JobDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
@Service("jobDescriptionService")
public class JobDescriptionServiceImpl implements JobDescriptionService {

    @Autowired
    JobDescriptionDao jobDescriptionDao;

    @Override
    public void insert(JobDescription jobDescription) {
        jobDescriptionDao.insert(jobDescription);
    }
}
