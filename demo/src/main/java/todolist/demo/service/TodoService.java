package todolist.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import todolist.demo.entity.Todo;
import todolist.demo.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    //injeção via construtor
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> createList(Todo todo){
        todoRepository.save(todo);
        return readList();
    }

    public List<Todo> readList(){
        Sort sort = Sort.by("priority").descending()
        .and(Sort.by("name").ascending());

        return todoRepository.findAll(sort);
    }

    public List<Todo> updateList(Todo todo){
        todoRepository.save(todo);
        return readList();
    }

    public List<Todo> deleteList(Long id){
        todoRepository.deleteById(id);
        return readList();
    }


}
