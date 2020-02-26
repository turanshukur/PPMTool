import React from "react";
import logo from "./logo.svg";
import "./App.css";
import Dashboard from "./components/Dashboard";
import Layout from "./components/Layout/Layout";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
      <Layout />
      <Dashboard />
    </div>
  );
}

export default App;
