/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.codecc.defect.resources;

import com.tencent.bk.codecc.defect.api.UserOperHisRestResource;
import com.tencent.bk.codecc.defect.service.OperationHistoryService;
import com.tencent.bk.codecc.defect.vo.OperationHistoryVO;
import com.tencent.devops.common.api.pojo.Result;
import com.tencent.devops.common.auth.api.pojo.external.BkAuthExAction;
import com.tencent.devops.common.web.RestResource;
import com.tencent.devops.common.web.security.AuthMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 操作记录接口实现类
 *
 * @version V1.0
 * @date 2019/6/18
 */
@RestResource
public class UserOperHisRestResourceImpl implements UserOperHisRestResource
{
    @Autowired
    private OperationHistoryService operationHistoryService;

    @Override
    @AuthMethod(permission = {BkAuthExAction.TASK_MEMBER, BkAuthExAction.TASK_OWNER, BkAuthExAction.ADMIN_MEMBER})
    public Result<List<OperationHistoryVO>> getOperHisRecord(Long taskId, String toolName, List<String> funcId)
    {
        return new Result<>(operationHistoryService.getOperHisByTaskIdAndFuncId(taskId, toolName, funcId));
    }
}