import React, { Component } from 'react';

/**
 * @class CurriculumBox
 */
class CurriculumBox extends Component {
  state = {
    data: null,
  }

  /**
   * @method CurriculumBox#componentDidMount
   */
  componentDidMount() {
    this.setCurriculumData();
  }

  setCurriculumData = () => {
    this.setState(() => ({
      data: this.props.data,
    }));
  }

  /**
   * @method CurriculumBox#render
   * @description React render method
   * @returns {HTML} CurriculumBox container
   */
  render() {
    return (
      <div className="curriculum-box-container">
        <h1>{this.props.data.name}</h1>
      </div>
    );
  }
}

module.exports = CurriculumBox;
