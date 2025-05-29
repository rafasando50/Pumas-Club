package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.CreateJugadorDTO;
import api.dto.JugadorDTO;
import api.service.JugadorService;
import jakarta.validation.Valid;

@RestController
public class JugadorController {
    
    @Autowired
    private JugadorService jugadorService;

    @RequestMapping("/jugadores")
    public List<JugadorDTO> getAll() {
        return jugadorService.getAll();
    }

    @RequestMapping("/crearJugador")
    public JugadorDTO save(@Valid @RequestBody CreateJugadorDTO data) {
        return jugadorService.save(data);
    }
}
