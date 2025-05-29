package api.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import api.model.Jugador;

@Repository
public class JugadorRepository {
    
    private long currentId;
    private List<Jugador> jugadores;


    public JugadorRepository() {
        currentId = 0;
        jugadores = new LinkedList<>();
    }

    public List<Jugador> getAll() {
        return jugadores;
    }

    public Jugador save(Jugador data) {
        data.setId(++currentId);
        jugadores.add(data);
        return data;
    }

    public Optional<Jugador> getById(long id) {

        for(Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return Optional.of(jugador);
            }
        }

        return Optional.empty();
    }

    public void update(long id, Jugador data) {
        Optional<Jugador> entry = getById(id);

        if(entry.isPresent()) {
            return;
        }

        Jugador jugador = entry.get();

        if(data.getName() != null) {
            jugador.setName(data.getName());
        }

        if(data.getPosition() != null) {
            jugador.setPosition(data.getPosition());
        }

        if(data.getTeam() != null) {
            jugador.setTeam(data.getTeam());
        }
    }
}
