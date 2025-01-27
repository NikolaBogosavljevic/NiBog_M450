import React, { useEffect, useState } from "react";
import "./Browse.css";
import axios from "axios";
import Recipe from "../Recipe/Recipe";
import { Col, Row } from "react-bootstrap";

const baseURL = "http://localhost:8080/api/recipes";

const Browse = () => {
  const [post, setPost] = useState(null);
  const [searchQuery, setSearchQuery] = useState(""); // State to manage the search query

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      setPost(response.data);
    });
  }, []);

  if (!post) return null;

  // Filter the recipes based on the search query
  const filteredRecipes = post.filter((recipe) =>
    recipe.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <>
      {/* Search Input Field */}
      <div style={{ marginBottom: "20px" }}>
        <input
          type="text"
          placeholder="Search recipes by name"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)} // Update search query
          style={{ padding: "10px", width: "100%" }}
        />
      </div>

      {/* Display Filtered Recipes */}
      <Row>
        {filteredRecipes.length > 0 ? (
          filteredRecipes.map((d) => (
            <Col              sm={12} md={6} lg={4} xl={3} key={d.id}>
            <Recipe title={d.name} description={d.description} image={d.imageUrl} />
          </Col>
        ))
      ) : (
        <p>No recipes found.</p> // Message when no recipes match the search query
      )}
  </Row>
</>
);
};

Browse.propTypes = {};

Browse.defaultProps = {};

export default Browse;

