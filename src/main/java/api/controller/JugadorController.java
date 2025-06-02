package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.CreateJugadorDTO;
import api.dto.JugadorDTO;
import api.dto.UpdateJugadorDTO;
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

    @PatchMapping("/actualizarJugador/{id}")
    public JugadorDTO update(@PathVariable("id") Long id, @RequestBody UpdateJugadorDTO data) {
        return jugadorService.updateJugador(id, data);
    }

    @DeleteMapping("/eliminarJugador/{id}")
    public void deteteJugador(@PathVariable("id") Long id) {
        jugadorService.deleteJugador(id);
    }

    @PatchMapping("/gol/{id}")
    public JugadorDTO aumetarGol(@PathVariable("id") Long id) {
        return jugadorService.aumentarGol(id);
    }
}
