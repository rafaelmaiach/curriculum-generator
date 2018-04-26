import React, { Component } from 'react';
import '../style.scss';

/** This class wraps all our data and delegate the methods to the others */
class App extends Component {
  /**
   * @constructor App#constructor
   */
  constructor() {
    super();

    this.state = {};
  }

  /**
   * @method App#render
   * @return {HTMLElement} - Main component
   */
  render() {
    return <h1>React Start Template!</h1>;
  }
}

export default App;
