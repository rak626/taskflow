package com.rakesh.taskflow.repo;

import com.rakesh.taskflow.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepo extends JpaRepository<Label, String> {

}
