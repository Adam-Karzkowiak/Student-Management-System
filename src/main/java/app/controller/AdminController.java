package app.controller;

import app.model.AppUser;
import app.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-home")
public class AdminController {
    AppUserService appUserService;

    @Autowired
    public AdminController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Account created!")
    public AppUser callCreateAccount(@Valid @RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> callDeleteAppUser(@RequestParam long id) {
        appUserService.deleteAppUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}
