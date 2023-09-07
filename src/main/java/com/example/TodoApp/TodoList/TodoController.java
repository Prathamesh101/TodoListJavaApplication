package com.example.TodoApp.TodoList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    private TodoRepository todoRepository;
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        model.addAttribute("todos",todoRepository.findByUsername(getLoggedInUsername()));
        return "TodoPage";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addTodo(ModelMap model){
        Todo todo = new Todo(0,getLoggedInUsername(),"",null,false);
        model.addAttribute("todo",todo);
        return "addTodoPage";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addDesc(ModelMap model, @Valid Todo todo, BindingResult result){
        String username = getLoggedInUsername();
        if(result.hasErrors()){
            return "addTodoPage";
        }
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String getUpdateMethod(ModelMap model,@RequestParam int id){
        Todo todo =todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "addTodoPage";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        String username = (String)model.get("name");
        if(result.hasErrors()){
            return "addTodoPage";
        }
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
    public String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
