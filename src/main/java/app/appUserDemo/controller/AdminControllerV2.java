package app.appUserDemo.controller;

import app.appUserDemo.model.AppUser;
import app.appUserDemo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-home")
public class AdminControllerV2 {
    AppUserService appUserService;

    @Autowired
    public AdminControllerV2(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Account created!")
    public AppUser callCreateAccount(@RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> callDeleteAppUser(@RequestParam long id) {
        appUserService.deleteAppUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}
