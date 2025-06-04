package api.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dto.CreateJugadorDTO;
import api.dto.JugadorDTO;
import api.dto.UpdateJugadorDTO;
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

    public JugadorDTO save(Jugador jugador) {
        return toDTO(jugadorRepository.save(jugador));
    }

    public JugadorDTO getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Jugador no encontrado"));

        return toDTO(jugador);
    }

    public JugadorDTO updateJugador(Long id, UpdateJugadorDTO data) {
        Jugador jugador = jugadorRepository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("jugador no encontrado"));

        if (data.getName() != null) {
            jugador.setName(data.getName());
        }

        if (data.getPosition() != null) {
            jugador.setPosition(data.getPosition());
        }

        if (data.getTeam() != null) {
            jugador.setTeam(data.getTeam());
        }

        if (data.getCountry() != null) {
            jugador.setCountry(data.getCountry());
        }

        if (data.getAge() != null) {
            jugador.setAge(data.getAge());
        }

        if (data.getMatches() != null) {
            jugador.setMatches(data.getMatches());
        }

        if (data.getGoals() != null) {
            jugador.setGoals(data.getGoals());
        }

        if (data.getHistoryTeams() != null) {
            jugador.setHistoryTeams(data.getHistoryTeams());
        }

        jugador = jugadorRepository.update(jugador);

        return new JugadorDTO(
                jugador.getId(),
                jugador.getName(),
                jugador.getPosition(),
                jugador.getTeam(),
                jugador.getCountry(),
                jugador.getAge(),
                jugador.getMatches(),
                jugador.getGoals(),
                jugador.getHistoryTeams());
    }

    public void deleteJugador(Long id) {
        Jugador jugador = jugadorRepository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("jugador no encontrado"));

        jugadorRepository.delete(jugador);
    }

    public JugadorDTO aumentarPartido(Long id) {
        Jugador jugador = jugadorRepository.getById(id)
        .orElseThrow(() -> new NoSuchElementException("Jugador no encontrado"));

        if (jugador.getId() == 0) {
            throw new IllegalStateException("Jugador tiene un id inválido.");
        }

        jugador.setMatches(jugador.getMatches() + 1);

        jugadorRepository.save(jugador);

        return new JugadorDTO(
                jugador.getId(),
                jugador.getName(),
                jugador.getPosition(),
                jugador.getTeam(),
                jugador.getCountry(),
                jugador.getAge(),
                jugador.getMatches(),
                jugador.getGoals(),
                jugador.getHistoryTeams());
    }

    public JugadorDTO aumentarGol(Long id) {
        Jugador jugador = jugadorRepository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("jugador no encontrado"));

        jugador.setGoals(jugador.getGoals() + 1);
        jugador = jugadorRepository.update(jugador);

        return toDTO(jugador);
    }

    public Jugador toModel(CreateJugadorDTO dto) {
        return new Jugador(
                0,
                dto.getName(),
                dto.getPosition(),
                dto.getTeam(),
                dto.getCountry(),
                dto.getAge(),
                dto.getMatches(),
                dto.getGoals(),
                dto.getHistoryTeams());
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
                jugador.getGoals(),
                jugador.getHistoryTeams());
    }
}
