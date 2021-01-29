package app.controller;

import app.model.AppUser;
import app.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/admin-home")
public class AdminController {
    AppUserService appUserService;

    @Autowired
    public AdminController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @PostMapping("/")
    ResponseEntity<AppUser> createAppUser(@RequestBody @Valid AppUser appUser) {
        AppUser savedAppUser = appUserService.createAppUser(appUser);
        return ResponseEntity.created(URI.create("/" + savedAppUser.getId())).body(savedAppUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> callDeleteAppUser(@RequestParam int id) {
        appUserService.deleteAppUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}
