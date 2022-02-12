package ua.may.filmapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import ua.may.filmapp.models.Film;

import javax.validation.Valid;
import java.util.List;

//клас FilmDAO відповідає за з'єднання з базою даних
@Component
public class FilmDAO {

    //створення об'єкту JDBCTemplate
    private final JdbcTemplate jdbcTemplate;
    // до конструктура DAO прив'язуєм JDBCTemplate
    @Autowired
    public FilmDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Film> list() {
        return jdbcTemplate.query("SELECT * FROM Film", new BeanPropertyRowMapper<>(Film.class));
    }
    public Film show(int id) {
        return jdbcTemplate.query("SELECT * FROM Film WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Film.class)).stream().findAny().orElse(null);
    }

    public void addFilm(Film film) {
        jdbcTemplate.update("INSERT INTO Film VALUES (?, ?, ?, ?, ?, ?)",
                film.getId(), film.getName(), film.getYear(), film.getGenre(), film.getDirector(), film.getMainActor());
    }

    public void update(int id, Film updatedFilm) {
        jdbcTemplate.update("UPDATE Film SET name=?, year=?, genre=?, director=?, mainActor=? WHERE id=?",
                updatedFilm.getName(), updatedFilm.getYear(),updatedFilm.getGenre(),updatedFilm.getMainActor(), updatedFilm.getDirector(),
                 updatedFilm.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Film WHERE id=?", id);
    }
}
