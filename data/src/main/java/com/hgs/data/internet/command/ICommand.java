package com.hgs.data.internet.command;

import com.hgs.data.internet.model.request.RequestModelCustom;
import com.hgs.data.internet.model.response.ResponseModelCustom;

public interface ICommand {
    ResponseModelCustom doWork(RequestModelCustom model);
    void doFinish(ResponseModelCustom model);
}
