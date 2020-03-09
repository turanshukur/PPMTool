package com.turanshukur.ppmtool.repositories;

import com.turanshukur.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    Iterable<Project> findAll();

    Project findByProjectIdentifier(String projectId);
    Project deleteByProjectIdentifier(String projectId);
}
