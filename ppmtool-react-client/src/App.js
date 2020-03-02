import React from "react";
import logo from "./logo.svg";
import "./App.css";
import Dashboard from "./components/Dashboard";
import Layout from "./components/Layout/Layout";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./components/Project/AddProject";
function App() {
  return (
    <Router>
      <div className="App">
        <Layout />
        <Route exact path="/Dashboard" component={Dashboard} />
        <Route exact path="/addProject" component={AddProject} />
      </div>
    </Router>
  );
}

export default App;
