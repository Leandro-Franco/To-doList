package todolist.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todolist.demo.entity.Todo;
import todolist.demo.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

    //injection via constructor
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @PostMapping("/create")
    List<Todo> createList(@RequestBody Todo todo){
        return todoService.createList(todo);
    }

    @GetMapping("/read")
    List<Todo> readList(){
        return todoService.readList();
    }
    
    @PostMapping("/update")
    List<Todo> updateList(@RequestBody Todo todo){
        return todoService.updateList(todo);
    }

    @DeleteMapping("/delete/{id}")
    List<Todo> deleteList(@PathVariable("id") Long id){
        return todoService.deleteList(id);
    }
}
