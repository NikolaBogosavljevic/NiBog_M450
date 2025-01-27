package ch.tbz.recipe.planner.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.RecipeEntity;

import java.util.UUID;

class RecipeEntityMapperTest {

    private RecipeEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(RecipeEntityMapper.class);
    }

    @Test
    void testEntityToDomain() {
        // Arrange
        UUID id = UUID.randomUUID();
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(id);
        recipeEntity.setName("Lasagna");
        recipeEntity.setDescription("Delicious layers of pasta and cheese");

        // Act
        Recipe recipe = mapper.entityToDomain(recipeEntity);

        // Assert
        assertNotNull(recipe);
        assertEquals(recipeEntity.getId(), recipe.getId());
        assertEquals(recipeEntity.getName(), recipe.getName());
        assertEquals(recipeEntity.getDescription(), recipe.getDescription());
    }

    @Test
    void testDomainToEntity() {
        // Arrange
        UUID id = UUID.randomUUID();
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName("Tacos");
        recipe.setDescription("Mexican street food with fresh ingredients");

        // Act
        RecipeEntity recipeEntity = mapper.domainToEntity(recipe);

        // Assert
        assertNotNull(recipeEntity);
        assertEquals(recipe.getId(), recipeEntity.getId());
        assertEquals(recipe.getName(), recipeEntity.getName());
        assertEquals(recipe.getDescription(), recipeEntity.getDescription());
    }

    @Test
    void testNullEntityToDomain() {
        // Act
        Recipe recipe = mapper.entityToDomain(null);

        // Assert
        assertNull(recipe);
    }

    @Test
    void testNullDomainToEntity() {
        // Act
        RecipeEntity recipeEntity = mapper.domainToEntity(null);

        // Assert
        assertNull(recipeEntity);
    }
}
