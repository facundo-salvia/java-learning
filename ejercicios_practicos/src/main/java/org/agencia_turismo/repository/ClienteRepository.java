package org.agencia_turismo.repository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.agencia_turismo.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteRepository {
    List<Cliente> clienteList=new ArrayList<>();
    public boolean addCliente(Cliente cliente){
        return clienteList.add(cliente);
    }
    public boolean removeCliente(long dni){
        return clienteList.removeIf((cliente -> cliente.getDni()==dni));
    }
}
