package org.example.parking;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO test

        assertNotNull(true);
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO test
        Cliente cliente=new Cliente("123","nico");
        Vehiculo vehiculo=new Vehiculo("78wer","vw", Vehiculo.Tipo.AUTO);
        Ticket ticket=new Ticket(cliente,vehiculo);
        double precio=ticket.calcularPrecio();
        assertNotNull(precio);
        
    }

}