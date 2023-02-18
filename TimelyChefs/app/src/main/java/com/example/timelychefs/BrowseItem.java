package com.example.timelychefs;

public class BrowseItem {
    String recipe;
    String author;
    int image;

    public BrowseItem(String recipe, String author, int image) {
        this.recipe = recipe;
        this.author = author;
        this.image = image;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
