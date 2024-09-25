package Controllers;

import Core.Repository;

public class Controller {
    protected Repository repository;
    protected Controller() {
        this.repository = Repository.repository();
    }
}
