package org.agencia_turismo.service;



import org.agencia_turismo.entity.Cliente;
import org.agencia_turismo.entity.DetalleReserva;
import org.agencia_turismo.entity.Localizador;
import org.agencia_turismo.entity.Reservas;
import org.agencia_turismo.repository.ClienteRepository;
import org.agencia_turismo.repository.LocalizadorRepository;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorService {
    ClienteRepository clienteRepository = new ClienteRepository();
    LocalizadorRepository localizadorRepository = new LocalizadorRepository();
    int id = 1;

    public void generateLocalizador(Cliente cliente, List<Reservas> reservasList){
        Localizador localizador1 = new Localizador(id,cliente,
                reservasList, calcularTotal(reservasList, cliente) );
        localizadorRepository.addLocalizador(localizador1);
        ++id;
    }

    private boolean validateDiscount(Cliente cliente){
        int operacionesAnteriores = localizadorRepository.getLocalizadorList().stream().filter(localizador -> localizador.getCliente().equals(cliente)).toList().size();
        return operacionesAnteriores >= 2;
    }

    public Double calcularTotal(List<Reservas> reservasList, Cliente cliente){
        double discount;
        if(validateDiscount(cliente)){
            discount = 0.95;
        }else {
            discount = 1;
        };

        return reservasList.stream().mapToDouble(Reservas::getPrecio).sum()*discount;
    }

    public List<Localizador> getLocalizador(){
        return localizadorRepository.getLocalizadorList();
    }

    public void test(){
        System.out.println(localizadorRepository.getLocalizadorList());

    }
}
