package mx.cuu.dev.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import mx.cuu.dev.security.model.ToDoItem;

/**
 * CRUD Service for {@link ToDoItem}
 *
 * @author Julio Cesar Bolaños Palacios.
 *
 */
@Service
public class ToDoService {

    private List<ToDoItem> toDoList;
    
    @PostConstruct
    public void initBean() {
        toDoList = new ArrayList<>();
        
    }
    
    public Integer getNextId() {         
        return toDoList.size() + 1 ;
    }

    /**
     * Save item.
     *
     * @param item
     * @return
     */
    public ToDoItem save(final ToDoItem item) {
        item.setRegisterDate(new Date());
        item.setId(getNextId());
        this.toDoList.add(item);
        return item;
    }

    /**
     * Retrieve all To Do items.
     *
     * @return
     */
    public List<ToDoItem> getAll() {
        return this.toDoList;
    }

    /**
     * Retrieve To Do item by identifier.
     *
     * @param id
     * @return
     */
    public ToDoItem getTodoItemById(Integer id) {
        Optional<ToDoItem> item = toDoList.stream().filter( i -> i.getId() == id ).findAny();
        if (item.isPresent())
            return item.get();
        return null;
    }

    /**
     * Update To Do item.
     *
     * @param item
     * @return
     */
    public ToDoItem completeTodoItem(Integer id) {
        Optional<ToDoItem> item = toDoList.stream().filter( i -> i.getId() == id ).findAny();        
        if(item.isPresent()) {
            item.get().setCompleted(true);
        }
        return null;
    }

    /**
     * Delete To Do item by identifier.
     * @param id
     */
    public void deleteToDoItemById(Integer id) {
        Optional<ToDoItem> item = toDoList.stream().filter( i -> i.getId() == id ).findAny();
        if (item.isPresent())
            toDoList.remove(item.get());
    }
}
