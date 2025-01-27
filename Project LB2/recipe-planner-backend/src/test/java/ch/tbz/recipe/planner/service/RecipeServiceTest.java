package ch.tbz.recipe.planner.service;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import ch.tbz.recipe.planner.mapper.RecipeEntityMapper;
import ch.tbz.recipe.planner.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;  // Mock the RecipeRepository

    @Mock
    private RecipeEntityMapper recipeEntityMapper;  // Mock the RecipeEntityMapper

    @InjectMocks
    private RecipeService recipeService;  // Service under test

    private Recipe sampleRecipe;
    private RecipeEntity sampleRecipeEntity;

    @BeforeEach
    void setUp() {
        UUID recipeId = UUID.randomUUID();
        sampleRecipe = new Recipe(recipeId, "Pasta", "Delicious pasta", "http://imageurl.com", null);
        sampleRecipeEntity = new RecipeEntity(recipeId, "Pasta", "Delicious pasta", "http://imageurl.com", null);
    }

    @Test
    void getRecipes_shouldReturnAllRecipes() {
        // Arrange
        when(recipeRepository.findAll()).thenReturn(Collections.singletonList(sampleRecipeEntity));
        when(recipeEntityMapper.entityToDomain(sampleRecipeEntity)).thenReturn(sampleRecipe);

        // Act
        var recipes = recipeService.getRecipes();

        // Assert
        assertNotNull(recipes);
        assertEquals(1, recipes.size());
        assertEquals("Pasta", recipes.get(0).getName());
        verify(recipeRepository, times(1)).findAll();  // Verify repository interaction
        verify(recipeEntityMapper, times(1)).entityToDomain(sampleRecipeEntity);  // Verify mapper interaction
    }

    @Test
    void getRecipeById_shouldReturnRecipe_whenRecipeExists() {
        // Arrange
        UUID recipeId = sampleRecipe.getId();
        when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(sampleRecipeEntity));
        when(recipeEntityMapper.entityToDomain(sampleRecipeEntity)).thenReturn(sampleRecipe);

        // Act
        Recipe recipe = recipeService.getRecipeById(recipeId);

        // Assert
        assertNotNull(recipe);
        assertEquals("Pasta", recipe.getName());
        verify(recipeRepository, times(1)).findById(recipeId);  // Verify repository interaction
        verify(recipeEntityMapper, times(1)).entityToDomain(sampleRecipeEntity);  // Verify mapper interaction
    }

    @Test
    void getRecipeById_shouldReturnNull_whenRecipeDoesNotExist() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(recipeRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act
        Recipe recipe = recipeService.getRecipeById(nonExistentId);

        // Assert
        assertNull(recipe);
        verify(recipeRepository, times(1)).findById(nonExistentId);  // Verify repository interaction
    }

    @Test
    void addRecipe_shouldSaveAndReturnRecipe() {
        // Arrange
        when(recipeEntityMapper.domainToEntity(sampleRecipe)).thenReturn(sampleRecipeEntity);
        when(recipeRepository.save(sampleRecipeEntity)).thenReturn(sampleRecipeEntity);
        when(recipeEntityMapper.entityToDomain(sampleRecipeEntity)).thenReturn(sampleRecipe);

        // Act
        Recipe savedRecipe = recipeService.addRecipe(sampleRecipe);

        // Assert
        assertNotNull(savedRecipe);
        assertEquals("Pasta", savedRecipe.getName());
        verify(recipeEntityMapper, times(1)).domainToEntity(sampleRecipe);  // Verify mapping from domain to entity
        verify(recipeRepository, times(1)).save(sampleRecipeEntity);  // Verify saving to repository
        verify(recipeEntityMapper, times(1)).entityToDomain(sampleRecipeEntity);  // Verify mapping from entity back to domain
    }
}
