const { defineConfig } = require("cypress");

module.exports = {
    e2e: {
        baseUrl: 'http://localhost:3000', // Replace with the correct URL if different
        specPattern: 'cypress/e2e/**/*.cy.js',
    },
};

