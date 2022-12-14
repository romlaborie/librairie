package com.epsiBibliProjet.librairie.service;


import com.epsiBibliProjet.librairie.model.*;
import com.epsiBibliProjet.librairie.repository.AccountRepository;
import com.epsiBibliProjet.librairie.repository.AppRoleRepository;
import com.epsiBibliProjet.librairie.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcountServiceImpl implements  AccountService{

    @Autowired
    private AccountRepository appUserRepository;

    @Autowired
   private  LibraryRepository libraryRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AcountServiceImpl(AccountRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    /**
     * Ici je met la logique d'encodage du mot de passe, car chaque fois
     * que j'ajoute un user, je passe par la méthode addNewUser
     * @param
     * @return
     */

    @Override
    public void addNewUser(Patron patronSave, String libraryName) {
        Library library = libraryRepository.findLibraryByName(libraryName);
        Patron patron = new Patron();
        patron.setUsername(patronSave.getUsername());
        patron.setName(patronSave.getName());
        patron.setAddress(patronSave.getAddress());
        patron.setLibrary(library);
        patron.setPassword(passwordEncoder.encode(patronSave.getPassword()));
         appUserRepository.save(patron);
    }

    @Override
    public void addNewLibrarian(Librarian librarianSaved, String libraryName) {
        Library library = libraryRepository.findLibraryByName(libraryName);
        Librarian librarian = new Librarian();
        librarian.setLibrary(library);
        librarian.setPassword(passwordEncoder.encode(librarianSaved.getPassword()));
        librarian.setAddress(librarianSaved.getAddress());
        librarian.setName(librarianSaved.getName());
        librarian.setUsername(librarianSaved.getUsername());
        librarian.setPosition(librarianSaved.getPosition());
        appUserRepository.save(librarian);
    }


    @Override
    public void addNewRole(AppRole appRole) {
        appRoleRepository.save(appRole);
    }

    @Override
    /**
     * Pour ajouter le role à l'utilisateur, je recupère le user correspondant ensuite, le role
     * depuis la BDD, je recupère la collection de role depuis l'entité User et j'ajoute le role
     */
    public void addRoleToUser(String username, String roleName) {

        Account appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public Account loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<Account> listUsers() {
        return appUserRepository.findAll();
    }
}
