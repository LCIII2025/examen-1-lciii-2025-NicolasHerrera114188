package org.example.parking;

import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {
        // TODO implementar la logica para registrar el ingreso de un nuevo vehiculo en el parking
        // la capacidad maxima del estacionamiento es de 50 vehiculos, si supera esta cap[acidad retornar FALSE
        // validar que no exista otro vehiculo con la misma patente, es un caso de error, retornar FALSE
        // validar si existe el cliente registrado, agregar el nuevo vehiculo en la lista del cliente existente, caso contrario crear un nuevo registro
        // si el proceso es exitoso retornar TRUE
        boolean registro=false;
        if(vehiculosEstacionados.size()<capacidadMaxima){
            Cliente ingresoCliente=new Cliente(dni,nombre);
            ingresoCliente.agregarVehiculo(vehiculo);
            clientesRegistrados.put(nombre,ingresoCliente);
            Ticket nuevoTicket= new Ticket(ingresoCliente,vehiculo);
            vehiculosEstacionados.put(nombre,nuevoTicket);
            registro=true;
        }
        return registro;
    }

    public Ticket retirarVehiculo(String patente) throws Exception {
        // TODO implementar la lógica para retirar un vehiculo del parking
        // validar que exista la patente, caso contrario arrojar la exception "Vehiculo no encontrado"
        // calcular y retornar el ticket del vehiculoEstacionado (ver Ticket.marcarSalida())
        String nombreCliente;
        for (int i=0;i< vehiculosEstacionados.size();i++){
            for (int j = 0; j < clientesRegistrados.size(); j++) {
                if (vehiculosEstacionados.get(clientesRegistrados.getClass().getName()).getVehiculo().getPatente().equals(patente)){
                    return vehiculosEstacionados.get(clientesRegistrados.getClass().getName());
                }
            }
        }
        return null;
    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
