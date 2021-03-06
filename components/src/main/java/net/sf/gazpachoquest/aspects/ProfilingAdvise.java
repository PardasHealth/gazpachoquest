/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

public class ProfilingAdvise {

    private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvise.class);

    public Object doProfiling(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String taskName = createTaskName(proceedingJoinPoint);
        StopWatch taskTimer = new StopWatch();
        try {
            taskTimer.start(taskName);
            return proceedingJoinPoint.proceed();
        } finally {
            taskTimer.stop();
            doLogging(taskTimer.getLastTaskInfo());
        }
    }

    private String createTaskName(final ProceedingJoinPoint proceedingJoinPoint) {
        return new StringBuffer(proceedingJoinPoint.getTarget().getClass().getSimpleName()).append(".")
                .append(proceedingJoinPoint.getSignature().getName()).toString();
    }

    private void doLogging(final TaskInfo lastTaskInfo) {
        logger.debug("Method : {} took {} ms", lastTaskInfo.getTaskName(), lastTaskInfo.getTimeMillis());
    }

}
