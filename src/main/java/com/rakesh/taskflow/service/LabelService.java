package com.rakesh.taskflow.service;

import com.rakesh.taskflow.entity.Label;
import com.rakesh.taskflow.model.LabelReq;

public interface LabelService {
    Label createLabel(LabelReq req);

    Label getLabelById(String labelId);
}
