package com.xinlizz.oh.rock;

import com.xinlizz.oh.rock.enums.JobStatusEnum;
import com.xinlizz.oh.rock.enums.RockErrorMsgEnum;
import com.xinlizz.oh.rock.exception.RockException;
import com.xinlizz.oh.rock.job.JobDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * RockHandler 任务处理者
 *
 * @Author: xinlizz
 * @Date: 2018/8/3
 */
@Component
public class RockHandler {

    private static final Logger logger = LoggerFactory.getLogger(RockHandler.class);

    private List<JobDefinition> jobDefinitionList;

    @PostConstruct
    public void initAndStart() {
        jobDefinitionList = new ArrayList<>();
        ListenJobs();
    }

    /**
     * 新增新的异步任务
     *
     * @return void
     *
     * @author xinlizz
     * @Date 2018/8/3
     * @Param [job]
     */
    public void addJob(JobDefinition job) {
        cleanJobList();
        jobDefinitionList.add(job);
    }

    /**
     * 将失败次数大于3次的进行清除
     *
     * @return void
     *
     * @author xinlizz
     * @Date 2018/8/3
     * @Param []
     */
    private void cleanJobList() {
        Iterator<JobDefinition> it = jobDefinitionList.iterator();
        JobDefinition job;
        while (it.hasNext()) {
            job = it.next();
            // 如果任务状态是FAILURE且失败次数大于等于3次则清除
            if (job.getFailNum() >= 3 && job.getStatus() == JobStatusEnum.FAILURE)
                it.remove();
        }
    }

    /**
     * 监听任务队列并解析执行job
     *
     * @author xinlizz
     * @Date 2018/8/4
     * @Param []
     * @return void
     */
    private void ListenJobs() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("The RockHandler thread sleep error!");
            }

            if (CollectionUtils.isEmpty(jobDefinitionList)) {
                continue;
            }

            Iterator<JobDefinition> it = jobDefinitionList.iterator();
            JobDefinition job;
            while (it.hasNext()) {
                job = it.next();
                // 如果job状态是RUNNING或者时SUCCESS就跳过
                if (job.getStatus() == JobStatusEnum.RUNNING || job.getStatus() == JobStatusEnum.SUCCESS) {
                    continue;
                }

                // 如果job状态时失败状态且失败次数大于等于3次跳过
                if (job.getFailNum() >= 3 && job.getStatus() == JobStatusEnum.FAILURE) {
                    continue;
                }

                try {
                    parseAndExecuteJob(job);
                } catch (RockException e) {
                    logger.error(e.getMessage(), e);
                }
            }

            // 清理任务队列中的任务
            cleanJobList();
        }
    }

    /**
     * 解析job并执行
     *
     * @author xinlizz
     * @Date 2018/8/4
     * @Param [job]
     * @return void
     */
    private void parseAndExecuteJob(JobDefinition job) throws RockException {
        job.setStatus(JobStatusEnum.RUNNING);
        String className, methodName;
        if (StringUtils.isEmpty(className = job.getClassName())) {
            job.setStatus(JobStatusEnum.FAILURE);
            job.setFailNum(job.getFailNum() + 1);
            throw new RockException(RockErrorMsgEnum.ERR_CLASS_NAME_EMPTY.getMessage());
        }

        if (StringUtils.isEmpty(methodName = job.getMethodName())) {
            job.setStatus(JobStatusEnum.FAILURE);
            job.setFailNum(job.getFailNum() + 1);
            throw new RockException(RockErrorMsgEnum.ERR_METHOD_NAME_EMPTY.getMessage());
        }

        try {
            Class<?> cls = Class.forName(className);
            Method[] methods = cls.getDeclaredMethods();
            Method jobMethod = null;
            // 寻找jobDefinition定义的执行方法
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    jobMethod = method;
                }
            }
            if (null == jobMethod) {
                throw new RockException(RockErrorMsgEnum.ERR_METHOD_NOT_FOUND.getMessage());
            }
            jobMethod.invoke(cls.newInstance(), job.getParams());
            job.setStatus(JobStatusEnum.SUCCESS);
        } catch (Exception e) {
            job.setStatus(JobStatusEnum.FAILURE);
            job.setFailNum(job.getFailNum() + 1);
            throw new RockException(RockErrorMsgEnum.ERR_PARSE_AND_EXECUTE_JOB.getMessage());
        }
    }
}
