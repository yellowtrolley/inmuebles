package com.nacho.inmuebles.controller;

import com.nacho.inmuebles.persistence.entity.Usuario;
import com.nacho.inmuebles.service.UsuarioService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @GetMapping
    public String showUserList(Model model) {
        model.addAttribute("users", usuarioService.findAll());

        return "usuarios";
    }
    
    @GetMapping("/signup")
    public String showSignUpForm(Usuario user, Model model) {
        model.addAttribute("user", user);
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid Usuario user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        usuarioService.save(user);

        return "redirect:/usuarios";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Usuario user = usuarioService.findById(id);

        model.addAttribute("user", user);
        
        return "update-user";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Usuario user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);

            return "update-user";
        }
        
        usuarioService.save(user);

        return "redirect:/usuarios";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Usuario user = usuarioService.findById(id);

        usuarioService.delete(user);
        
        return "redirect:/usuarios";
    }
}
