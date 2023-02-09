package com.todo.backend.repository;

import com.todo.backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Modifying
    @Transactional //these two annotations are needed to delete from the database otherwise an EntityManager error will occur
    void deleteTaskById(Long id);

}
