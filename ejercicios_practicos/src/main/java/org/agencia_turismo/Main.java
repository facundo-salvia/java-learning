package org.agencia_turismo;

import org.agencia_turismo.entity.Cliente;
import org.agencia_turismo.entity.DetalleReserva;
import org.agencia_turismo.entity.Localizador;
import org.agencia_turismo.entity.Reservas;
import org.agencia_turismo.service.LocalizadorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalizadorService localizadorService = new LocalizadorService();
        Cliente cliente1 = new Cliente(35234234,"Facu","Salvia");
        Cliente cliente2 = new Cliente(34534534,"Agustin","Perez");
        Cliente cliente3 = new Cliente(32265665,"Marcos","Lopez");

        List<Reservas> reservasList1 = new ArrayList<>(
                Arrays.asList(
                        new Reservas(2, DetalleReserva.HOTEL,2),
                        new Reservas(3, DetalleReserva.BOLETO_VIAJE,2)
                )
        );
        List<Reservas> reservasList2 = new ArrayList<>(
                List.of(
                        new Reservas(1, DetalleReserva.PAQUETE_COMPLETO, 2)
                )
        );
        List<Reservas> reservasList3 = new ArrayList<>(
                Arrays.asList(
                        new Reservas(2, DetalleReserva.HOTEL,2),
                        new Reservas(3, DetalleReserva.BOLETO_VIAJE,2)
                )
        );
        List<Reservas> reservasList11 = new ArrayList<>(
                Arrays.asList(
                        new Reservas(2, DetalleReserva.HOTEL,1),
                        new Reservas(3, DetalleReserva.BOLETO_VIAJE,1)
                )
        );


        localizadorService.generateLocalizador(cliente1, reservasList1);
        localizadorService.generateLocalizador(cliente2, reservasList2);
        localizadorService.generateLocalizador(cliente3, reservasList3);
        localizadorService.generateLocalizador(cliente1, reservasList11);
        localizadorService.generateLocalizador(cliente1, reservasList11);
        System.out.println(localizadorService.getLocalizador());
    }
}