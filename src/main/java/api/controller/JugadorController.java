package api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.dto.CreateJugadorDTO;
import api.dto.JugadorDTO;
import api.dto.UpdateJugadorDTO;
import api.model.Jugador;
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
        List<String> historyTeams = data.getHistoryTeams(); 
        Jugador jugador = new Jugador(0, data.getName(), data.getPosition(), data.getTeam(),
                data.getCountry(), data.getAge(), data.getMatches(),
                data.getGoals(), historyTeams); 
        return jugadorService.save(jugador);
    }

    @GetMapping("/jugador/{id}")
    public JugadorDTO getJugadorById(@PathVariable("id") Long id) {
        return jugadorService.getJugadorById(id);
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

    @PatchMapping("/partido/{id}")
    public JugadorDTO aumentarPartido(@PathVariable("id") Long id) {
        return jugadorService.aumentarPartido(id);
    }

}