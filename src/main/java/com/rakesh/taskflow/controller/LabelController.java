package com.rakesh.taskflow.controller;

import com.rakesh.taskflow.entity.Label;
import com.rakesh.taskflow.model.LabelReq;
import com.rakesh.taskflow.model.Response;
import com.rakesh.taskflow.service.LabelService;
import com.rakesh.taskflow.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/label")
@RequiredArgsConstructor
public class LabelController {
    private final LabelService labelService;

    @PostMapping("/create")
    public ResponseEntity<Response<Label>> createLabel(@RequestBody LabelReq req) {
        return ResponseUtil.prepareResponse(labelService.createLabel(req));
    }
}
