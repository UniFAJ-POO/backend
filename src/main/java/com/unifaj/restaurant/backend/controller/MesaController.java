package com.unifaj.restaurant.backend.controller;

import com.unifaj.restaurant.backend.model.Mesa;
import com.unifaj.restaurant.backend.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> buscarMesas() {
        return mesaService.buscarMesas();
    }

    @GetMapping("/{id}")
    public Mesa obterMesa(@PathVariable int id) throws Exception {
        return mesaService.obeterMesa(id);
    }

    @PostMapping("/")
    public Mesa criarMesa(@RequestBody Mesa mesa) {
        return mesaService.criarMesa(mesa);
    }

    @PutMapping("/{id}")
    public Mesa atualizarMesa(@RequestBody Mesa mesa, @PathVariable int id) throws Exception {
        return mesaService.atualizarMesa(mesa, id);
    }

    @DeleteMapping("/{id}")
    public void deletarMesa(@PathVariable int id) {
        mesaService.deletarMesa(id);
    }
}
