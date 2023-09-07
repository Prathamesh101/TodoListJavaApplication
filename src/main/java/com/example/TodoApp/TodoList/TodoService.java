package com.example.TodoApp.TodoList;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount =0;
    static {
        todos.add(new Todo(++todoCount,"user1","abc", LocalDate.now(),true));
        todos.add(new Todo(++todoCount,"user2","abc1", LocalDate.now().plusYears(todoCount),true));
        todos.add(new Todo(++todoCount,"user3","abc2", LocalDate.now().plusYears(todoCount),false));
    }
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate= todo -> todo.getUsername().equalsIgnoreCase(username);
              return todos.stream().filter(predicate).toList();
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
            Todo todo = new Todo(++todoCount,username,description,targetDate.plusYears(todoCount),done);
            todos.add(todo);
    }
    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo =todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void updateTodo(Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

}
