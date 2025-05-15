package com.rakesh.taskflow.service.impl;

import com.rakesh.taskflow.entity.Label;
import com.rakesh.taskflow.entity.User;
import com.rakesh.taskflow.exception.NoDataFoundException;
import com.rakesh.taskflow.model.LabelReq;
import com.rakesh.taskflow.repo.LabelRepo;
import com.rakesh.taskflow.service.LabelService;
import com.rakesh.taskflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {
    private final LabelRepo labelRepo;
    private final UserService userService;


    @Override
    public Label createLabel(LabelReq req) {
        validateLabelReq(req);
        User user = Optional.ofNullable(req.getUserId()).map(userService::getUserById).orElse(null);

        Label label = Label.builder().name(req.getName())
                .color(req.getColor())
                .user(user).build();
        return labelRepo.save(label);
    }

    @Override
    public Label getLabelById(String labelId) {
        return labelRepo.findById(labelId)
                .orElseThrow(() -> new NoDataFoundException("Label not found"));
    }

    private void validateLabelReq(LabelReq req) {

    }
}
