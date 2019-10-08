package herencia;

import java.util.ArrayList;

public class Sucursal {
 
    private String direccion;
    private Camion arregloDeCamiones[];
    private ArrayList <Automovil> coleccionDeAutos;

    public Sucursal() {
        this.direccion = "";
        this.arregloDeCamiones = new Camion[5];
        this.coleccionDeAutos = new ArrayList<>();
        
        this.inicializarArreglo();
    }

    public Sucursal(String direccion, Camion[] arregloDeCamiones, ArrayList<Automovil> coleccionDeAutos) {
        this.direccion = direccion;
        this.arregloDeCamiones = arregloDeCamiones;
        this.coleccionDeAutos = coleccionDeAutos;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Camion[] getArregloDeCamiones() {
        return arregloDeCamiones;
    }

    public void setArregloDeCamiones(Camion[] arregloDeCamiones) {
        this.arregloDeCamiones = arregloDeCamiones;
    }

    public ArrayList<Automovil> getColeccionDeAutos() {
        return coleccionDeAutos;
    }

    public void setColeccionDeAutos(ArrayList<Automovil> coleccionDeAutos) {
        this.coleccionDeAutos = coleccionDeAutos;
    }
    
    private void inicializarArreglo(){
          for (int i = 0; i<this.getArregloDeCamiones().length;i++) {
            this.getArregloDeCamiones()[i] = new Camion();
            
        }
    }
    
    public void almacenarCamion(Camion camion) {
        boolean validador = false;
        int indice = 0;
        for (int i = 0; i<this.getArregloDeCamiones().length;i++) {
            if (this.arregloDeCamiones[i].getNombre().equals("")){
                validador = true;
                indice = i;
                break;
            }
        }
        if (validador) {
            this.arregloDeCamiones[indice] = camion;
            System.out.println("Camion añadido en la posición "+(indice+1));
        }
        else {
            System.out.println("Arreglo de camiones lleno");
        }
    }
    
    public void almacenarAuto(Automovil automovil) {
        boolean validador = false;
        if (this.getColeccionDeAutos().contains(automovil)){
            validador = true;
        }
        if (!validador) {
            this.getColeccionDeAutos().add(automovil);
            System.out.println("Vehículo añadido");
        } else {System.out.println("Vehículo ya existe.");}
    }
    
    public void buscarAuto(String patente1) {
        boolean validador = false;
        Automovil auxiliar = new Automovil();
        if (this.getColeccionDeAutos().size() == 0) {
            System.out.println("Colección vacía.");
        }
        for (Automovil automovil : this.getColeccionDeAutos()) {
            if (automovil.getPatente().equals(patente1)) {
                auxiliar = automovil;
                validador = true;
            }
        }
        if (validador) {
            auxiliar.mostrarInformacionEspecifica();
        } else {
            System.out.println("Vehículo no encontrado");
        }
    }
}
