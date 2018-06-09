package mx.cuu.dev.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.cuu.dev.security.model.ToDoItem;
import mx.cuu.dev.security.service.ToDoService;

@RestController
@RequestMapping(value = "/rest/todo")
public class ToDoController {
    
    @Autowired
    private ToDoService toDoService;
    
    @GetMapping(produces = "application/json; charset=UTF-8")
    public List<ToDoItem> findAllItems(){        
        return toDoService.getAll();
    }
    
    @GetMapping(path = "/{id}", produces = "application/json; charset=UTF-8")
    public ToDoItem findToDoItemById(@PathVariable Integer id){        
        return toDoService.getTodoItemById(id);
    }
    
    @PostMapping(consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public ToDoItem saveToDoItem(@RequestBody ToDoItem item) {
        return toDoService.save(item);
    }
    
    @PutMapping(path = "/{id}", produces = "application/json; charset=UTF-8")
    public ToDoItem completeTodoItem(@PathVariable Integer id) {
        return toDoService.completeTodoItem(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteToDoItem(@PathVariable Integer id) {
        toDoService.deleteToDoItemById(id);
    }
}
