package rest;

import domain.Actor;
import domain.Comment;
import domain.Film;
import domain.Rate;
import domain.services.FilmService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/film")
public class FilmRest {
    private FilmService db = new FilmService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAll() {
        return db.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Film film) {
        db.add(film);
        return Response.ok(film.getId()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Film result = db.get(id);
        if (result == null)
            return Response.status(404).build();
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, String name, String description, Film f) {
        Film result = db.get(id);
        if (result == null)
            return Response.status(404).build();
        f.setId(id);
        f.setDescription(description);
        f.setName(name);
        db.update(f);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Film result = db.get(id);
        if (result == null)
            return Response.status(404).build();
        db.update(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{filmId}/comment")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getComments(@PathParam("filmId") int filmId) {
        Film result = db.get(filmId);
        if (result == null)
            return null;
        if (result.getComments() == null)
            result.setComments(new ArrayList<Comment>());
        return result.getComments();
    }

    @POST
    @Path("{id}/comment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(@PathParam("id") int filmId, Comment comment) {
        Film result = db.get(filmId);
        if (result == null)
            return null;
        if (result.getComments() == null)
            return null;
        result.getComments().add(comment);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}/comment")
    public Response deleteComment(@PathParam("id") int filmId, Comment comment) {
        Film result = db.get(filmId);
        if (result == null)
            return Response.status(404).build();
        db.update(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{filmId}/rate")
    @Produces(MediaType.APPLICATION_JSON)
    public double getRates(@PathParam("filmId") int filmId) {
        Film result = db.get(filmId);
        if (result == null)
            return 0
        if (result.getRates() == null)
            result.setRates(new ArrayList<Rate>());
        return result.getAvgRates();
    }

    @POST
    @Path("{id}/rate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRate(@PathParam("id") int filmId, Rate rate) {
        Film result = db.get(filmId);
        if (result == null)
            return null;
        if (result.getRates() == null)
            return null;
        result.getRates().add(rate);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}/rate")
    public Response deleteComment(@PathParam("id") int filmId, Rate rate) {
        Film result = db.get(filmId);
        if (result == null)
            return Response.status(404).build();
        db.update(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{filmId}/actor")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getActors(@PathParam("filmId") int filmId) {
        Film result = db.get(filmId);
        if (result == null)
            return null;
        if (result.getActors() == null)
            result.setActors(new ArrayList<Actor>());
        return result.getActors();
    }

    @POST
    @Path("{id}/actor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addActor(@PathParam("id") int filmId, Actor actor) {
        Film result = db.get(filmId);
        if (result == null)
            return null;
        if (result.getActors() == null)
            return null;
        result.getActors().add(actor);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}/actor")
    public Response deleteComment(@PathParam("id") int filmId, Actor actor) {
        Film result = db.get(filmId);
        if (result == null)
            return Response.status(404).build();
        db.update(result);
        return Response.ok().build();
    }
}
