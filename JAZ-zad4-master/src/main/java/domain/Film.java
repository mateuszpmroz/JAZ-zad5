package domain;

import java.lang.reflect.Type;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Film {
    private int id;
    private String name;
    private String description;
    private List<Rate> rates;
    private List<Comment> comments;
    private List<Actor> actors;
    private double rateAvg;

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public double getAvgRates() {
        for (Rate r : rates) {
           rateAvg += r.getRate();
        }
        rateAvg = rateAvg / rates.size();
        return rateAvg;
    }

}