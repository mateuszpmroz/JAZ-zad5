package domain.services;

import domain.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmService {
    private static List<Film> db = new ArrayList<Film>();
    private static int currentId = 1;

    public List<Film> getAll() {
        return db;
    }

    public Film get(int id) {
        for (Film f : db) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public void add(Film f) {
        f.setId(++currentId);
        db.add(f);
    }

    public void update(Film film) {
        for (Film f : db) {
            if (f.getId() == film.getId()) {
                f.setName(f.getName());
                f.setDescription(f.getDescription());
            }
        }
    }

    public void delete(Film f) {
        db.remove(f);
    }
}
