package com.tour.repository;

import com.tour.enums.UserRole;
import com.tour.model.Group;
import com.tour.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long>, BaseUserMethods<Guide> {

    List<Guide> findByGroups(Group group);
}
