package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = LocalDateTime.now().plusMinutes(random.nextInt(200)+1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        // TODO implementar el metodo para calcular el importe a abonar segun el tipo de vehiculo
        // AUTO -> 100, SUV -> 130, PICKUP -> 180
        // el importe es por hora redondeando el tiempo hacia arriba,
        // por ejemplo si estuvo 45 minutos se le tarifa por 60, si estuvo 80 minutos se le tarifa por 120 minutos, etc...
        // retornar el importe final
        int precioFinal=0;
        cliente.agregarVehiculo(vehiculo);
        for (int i=0;i<cliente.getVehiculos().size();i++)
        {
            if (cliente.getVehiculos().get(i).getTipo().name().equals("AUTO")){
                if (calcularMinutos()<60){
                    precioFinal=100;
                    return precioFinal;
                }
                if (calcularMinutos()<120){
                    precioFinal=100*2;
                    return precioFinal;
                }
                if (calcularMinutos()>120){
                    precioFinal=100*(int)calcularMinutos();
                    return precioFinal;
                }
            }
            if (cliente.getVehiculos().get(i).getTipo().name().equals("SUV")){
                if (calcularMinutos()<60){
                    precioFinal=130;
                    return precioFinal;
                }
                if (calcularMinutos()<120){
                    precioFinal=130*2;
                    return precioFinal;
                }
                if (calcularMinutos()>120){
                    precioFinal=130*(int)calcularMinutos();
                    return precioFinal;
                }
            }
            if (cliente.getVehiculos().get(i).getTipo().name().equals("PICKUP")) {
                if (calcularMinutos() < 60) {
                    precioFinal = 180;
                    return precioFinal;
                }
                if (calcularMinutos() < 120) {
                    precioFinal = 180 * 2;
                    return precioFinal;
                }
                if (calcularMinutos() > 120) {
                    precioFinal = 180 * (int) calcularMinutos();
                    return precioFinal;
                }
            }
        }
        return precioFinal;
    }

}