package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Account;
import com.epsiBibliProjet.librairie.model.AppRole;
import com.epsiBibliProjet.librairie.model.Librarian;
import com.epsiBibliProjet.librairie.model.Patron;

import java.util.List;

public interface AccountService {
    void addNewUser(Patron patron, String libraryName);
    // Je lui donne en parametre un objet de type appRole et il va l'ajouté

    void addNewLibrarian(Librarian librarian, String libraryName);
    void addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    Account loadUserByUsername(String username);
    List<Account> listUsers();
}
