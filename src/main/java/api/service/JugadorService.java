package api.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dto.JugadorDTO;
import api.model.Jugador;
import api.repository.JugadorRepository;

@Service
public class JugadorService {
    
    @Autowired
    private JugadorRepository jugadorRepository;

    public List<JugadorDTO> getAll() {
        List<Jugador> jugadores = jugadorRepository.getAll();

        List<JugadorDTO> data = new LinkedList<>();

        for (Jugador jugador : jugadores) {
            data.add(toDTO(jugador));
        }

        return data;
    }

    public Jugador toModel(JugadorDTO dto) {
        return new Jugador(
            dto.getId(),
            dto.getName(),
            dto.getPosition(),
            dto.getTeam(),
            dto.getCountry(),
            dto.getAge(),
            dto.getMatches(),
            dto.getGoals()
        );
    }

    public JugadorDTO toDTO(Jugador jugador) {
        return new JugadorDTO(
            jugador.getId(),
            jugador.getName(),
            jugador.getPosition(),
            jugador.getTeam(),
            jugador.getCountry(),
            jugador.getAge(),
            jugador.getMatches(),
            jugador.getGoals()
        );
    }
}
