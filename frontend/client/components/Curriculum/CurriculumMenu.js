import React, { Component } from 'react';

/**
 * @class CurriculumForm
 */
class CurriculumForm extends Component {
  state = {
    userId: null,
  }

  /**
   * @method CurriculumForm#componentDidMount
   */
  componentDidMount() {
    this.setUserId();
  }

  setUserId = () => {
    this.setState(() => ({ userId: window.userId }));
  }

  /**
   * @method CurriculumForm#render
   * @description React render method
   * @returns {HTML} CurriculumForm container
   */
  render() {
    return (
      <div className="curriculum-form-container">
        CurriculumForm
      </div>
    );
  }
}

module.exports = CurriculumForm;
