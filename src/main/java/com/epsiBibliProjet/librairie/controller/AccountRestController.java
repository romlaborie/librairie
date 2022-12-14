package com.epsiBibliProjet.librairie.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.epsiBibliProjet.librairie.model.Account;
import com.epsiBibliProjet.librairie.model.AppRole;
import com.epsiBibliProjet.librairie.model.Librarian;
import com.epsiBibliProjet.librairie.model.Patron;
import com.epsiBibliProjet.librairie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/users")
    //@PostAuthorize("hasAuthority('USER')")
    public List<Account> appUsers(){
        return accountService.listUsers();
    }

    @PostMapping(path = "/patron/{libraryName}")
    //@PostAuthorize("hasAuthority('PATRON')")
    public void saveUser(@RequestBody Patron patron, @PathVariable String libraryName){
         accountService.addNewUser(patron, libraryName);

    }

    @PostMapping(path = "/librarian/{libraryName}")
    //@PostAuthorize("hasAuthority('LIBRA_RIAN')")
    public void saveLibrarian(@RequestBody Librarian librarian, @PathVariable String libraryName){
        accountService.addNewLibrarian(librarian, libraryName);

    }

    @PostMapping(path = "/roles")
   public void appRole(@RequestBody AppRole appRole){
         accountService.addNewRole(appRole);

    }


    @PostMapping(path = "/addRoleToUser")
   public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());

    }
    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response){
      String authToken = request.getHeader("Authorization");
      if(authToken !=null && authToken.startsWith("Bearer ")){
          try {
              String jwt = authToken.substring(7);
              Algorithm algorithm = Algorithm.HMAC256("mySecret1234");
              JWTVerifier jwtVerifier = JWT.require(algorithm).build();
              DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
              String username = decodedJWT.getSubject();
              Account appUser = accountService.loadUserByUsername(username);


          }catch (Exception e){
              response.setHeader("error-message", e.getMessage());
             // response.sendError(HttpServletResponse.SC_FORBIDDEN);
          }
      }
    }
}


// http://localhost:8080/login -> se connecter à l'api

