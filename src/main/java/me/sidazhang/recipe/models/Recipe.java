package me.sidazhang.recipe.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Document
public class Recipe {
    @Id
    private String id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String direction;
    private Difficulty difficulty;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Byte[] image;
    private Notes notes;
    @DBRef
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    //    public Recipe addCategory(Category category) {
//        category.getRecipes().add(this);
//        this.getCategories().add(category);
//        return this;
//    }
    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
//            notes.setRecipe(this);
        }
    }

    public Recipe addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

}
