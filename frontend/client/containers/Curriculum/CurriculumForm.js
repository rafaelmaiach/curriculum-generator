import React, { Component } from 'react';

/**
 * @class Word
 */
class Word extends Component {
  state = {}

  /**
   * @method Word#render
   * @description React render method
   * @returns {HTML} Word container
   */
  render() {
    return (
      <div className="word-container">
        Word
      </div>
    );
  }
}

module.exports = Word;
