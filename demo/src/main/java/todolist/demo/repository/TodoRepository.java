package todolist.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todolist.demo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>   {
    
}
