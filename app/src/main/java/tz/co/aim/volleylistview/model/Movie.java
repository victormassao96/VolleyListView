package tz.co.aim.volleylistview.model;

public class Movie {
    private String name;
    private String description;
    private String categories;
    private int episode;
    private String studio;
    private String ratings;
    private String image_url;


    public Movie(){

    }

    public Movie(String name, String description, String categories, int episode, String studio, String ratings, String image_url) {
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.episode = episode;
        this.studio = studio;
        this.ratings = ratings;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategories() {
        return categories;
    }

    public int getEpisode() {
        return episode;
    }

    public String getStudio() {
        return studio;
    }

    public String getRatings() {
        return ratings;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
