package com.unifaj.restaurant.backend.service;

import com.unifaj.restaurant.backend.model.Mesa;
import com.unifaj.restaurant.backend.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> buscarMesas() {
        return mesaRepository.findAll();
    }

    public Mesa obeterMesa(int id) throws Exception {
        return mesaRepository.findById(id).orElseThrow(() -> new Exception("Mesa não existente"));
    }

    public Mesa criarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa atualizarMesa(Mesa mesa, int id) throws Exception {
        Mesa mesaToUpdate = mesaRepository.findById(id).orElseThrow(() -> new Exception("Mesa não existente"));
        mesaToUpdate.setNumMesa(id);
        mesaToUpdate.setStatusMesa(mesa.getStatusMesa());
        mesaToUpdate.setQtdCadeira(mesa.getQtdCadeira());

        return mesaRepository.save(mesaToUpdate);
    }

    public void deletarMesa(int id) {
        mesaRepository.deleteById(id);
    }
}
