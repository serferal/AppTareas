package bbdd;

import Utils.Tasks;
import Utils.User;

import java.awt.*;
import java.util.ArrayList;

public class Controller {
    private List<User>usuarioList;
    private List<Pass>passwordList;
    private List<Tasks>tasksList;

    public Controller() {

        usuarioList = new ArrayList<>();
        tasksList = new ArrayList<>();



        public boolean nuevoUsuario (String usuario, String password, String rol ){
            User user = new User(usuario);
            if (user.insertar("usuario")) {
            } else {
                return false;
            }
        }
    }
    public boolean borrarUsuario(String usuario) {

        User user = new User(usuario);
        if(usuario.borrar("cif=?",usuario)){

           usuario.getProveedores();
            return true;
        }else{
            return false;
        }

    }
}