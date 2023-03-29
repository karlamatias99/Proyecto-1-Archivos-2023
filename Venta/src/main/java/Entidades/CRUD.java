package Entidades;

import java.util.List;

//Creare una clase interface para colocar los metodos que estere utilizando en la mayoria de las clases DAO
public interface CRUD {
    public List listaCentral();
    public List listaSur();
    public List listaNorte();
    public List listaBodega();
    public boolean agregar(Object[] o);
    public boolean actualizar(Object[] o);
    public void eliminar(int id);
}
