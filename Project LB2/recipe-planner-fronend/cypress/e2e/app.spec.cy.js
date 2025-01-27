describe('Recipe Planner App', () => {

    beforeEach(() => {
        // Make sure the app is running before each test
        cy.visit('/');
    });

    it('should contain the necessary links in the navbar', () => {
        // Check if navbar contains the expected links
        cy.get('nav').contains('Browse');
        cy.get('nav').contains('Add Recipe');
    });

    it('should navigate to the Add Recipes page when clicking "Add Recipe"', () => {
        cy.contains('Add Recipe').click();
        cy.url().should('include', '/new-menues'); // Adjust to actual route if different
    });

    it('should filter recipes based on the search query', () => {
        // Ensure recipes are loaded
        cy.get('input[placeholder="Search recipes by name"]').type('Spaghetti');

        // Check if the filtered recipes contain "Spaghetti" in their name
        cy.get('.recipe').each(($recipe) => {
            cy.wrap($recipe).contains('Spaghetti');
        });
    });

});
