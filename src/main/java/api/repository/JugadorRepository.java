package api.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
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

    public Jugador update(Jugador data) {
        for (int i = 0; i < jugadores.size(); i++) {
            if(jugadores.get(i).getId() == data.getId()) {
                jugadores.set(i, data);
                return data;
            }
        }
        throw new NoSuchElementException("Jugador no encontrado");
    }
}
