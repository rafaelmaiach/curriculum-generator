import React, { Component, Fragment } from 'react';

import Word from './word/Word';
import Excel from './excel/Excel';

import '../index.scss';

/** This class wraps all our data and delegate the methods to the others */
class App extends Component {
  state = {}

  /**
   * @method App#render
   * @return {HTMLElement} - Main component
   */
  render() {
    return (
      <Fragment>
        <Word />
        <Excel />
      </Fragment>
    )
  }
}

export default App;
