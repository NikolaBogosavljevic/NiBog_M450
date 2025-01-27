package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RecipeService recipeService;

    @Mock
    private RecipeEntityMapper recipeEntityMapper;

    @InjectMocks
    private RecipeController recipeController;

    private Recipe sampleRecipe;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        sampleRecipe = new Recipe(UUID.randomUUID(), "Pasta", "Delicious pasta recipe", "http://imageurl.com", Collections.singletonList(new Ingredient(UUID.randomUUID(), "Tomato", "Fresh tomatoes", null, 3)));
    }

    @Test
    void getRecipes_shouldReturnListOfRecipes() throws Exception {
        when(recipeService.getRecipes()).thenReturn(Collections.singletonList(sampleRecipe));

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pasta"))
                .andExpect(jsonPath("$[0].description").value("Delicious pasta recipe"));

        verify(recipeService, times(1)).getRecipes();
    }

    @Test
    void getRecipe_shouldReturnRecipeById() throws Exception {
        UUID recipeId = UUID.randomUUID();
        when(recipeService.getRecipeById(recipeId)).thenReturn(sampleRecipe);

        mockMvc.perform(get("/api/recipes/recipe/{recipeId}", recipeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pasta"))
                .andExpect(jsonPath("$.description").value("Delicious pasta recipe"));

        verify(recipeService, times(1)).getRecipeById(recipeId);
    }

    @Test
    void addRecipe_shouldReturnCreatedRecipe() throws Exception {
        when(recipeService.addRecipe(any(Recipe.class))).thenReturn(sampleRecipe);

        mockMvc.perform(post("/api/recipes")
                        .contentType("application/json")
                        .content("{\"name\": \"Pasta\", \"description\": \"Delicious pasta recipe\", \"imageUrl\": \"http://imageurl.com\", \"ingredients\": []}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pasta"))
                .andExpect(jsonPath("$.description").value("Delicious pasta recipe"));

        verify(recipeService, times(1)).addRecipe(any(Recipe.class));
    }
}
