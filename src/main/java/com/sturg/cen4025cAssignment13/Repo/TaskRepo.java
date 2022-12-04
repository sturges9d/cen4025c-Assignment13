package com.sturg.cen4025cAssignment13.Repo;

import com.sturg.cen4025cAssignment13.Models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Tasks, Integer> {
}
