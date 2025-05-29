package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.JugadorDTO;
import api.service.JugadorService;

@RestController
public class JugadorController {
    
    @Autowired
    private JugadorService jugadorService;

    @RequestMapping("/jugadores")
    public List<JugadorDTO> getAll() {
        return jugadorService.getAll();
    }
}
