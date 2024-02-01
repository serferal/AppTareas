package Utils;

public class Rol extends com.ceica.Modelos.ModeloBase {



    private int idrol;
    private String description;
    public Rol(){
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected String getNombreTabla() {
        return null;
    }
    @Override
    protected Object createObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idrol=" + idrol +
                ", description='" + description + '\'' +
                '}';
    }
}

