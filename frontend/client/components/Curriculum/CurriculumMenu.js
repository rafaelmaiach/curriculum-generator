import React, { Component } from 'react';

import CurriculumBox from './CurriculumBox';
import { listCurriculums } from '../../api';

/**
 * @class CurriculumForm
 */
class CurriculumForm extends Component {
  state = {
    userId: null,
    curriculumsList: null,
  }

  /**
   * @method CurriculumForm#componentDidMount
   */
  componentDidMount() {
    this.getCurriculums();
  }

  getCurriculums = () => {
    this.setState(
      () => ({ userId: window.userId }),
      () => {
        listCurriculums(this.state.userId)
          .then(result => this.setState(() => ({ curriculumsList: result })))
          .catch(error => console.log(error.message));
      },
    );
  }

  createCurriculumBox = () => this.state.curriculumsList.map(data =>
    <CurriculumBox key={data.idCurriculum} data={data} />);


  /**
   * @method CurriculumForm#render
   * @description React render method
   * @returns {HTML} CurriculumForm container
   */
  render() {
    const { curriculumsList } = this.state;
    return (
      <div className="curriculum-form-container">
        {curriculumsList ? this.createCurriculumBox() : null}
      </div>
    );
  }
}

module.exports = CurriculumForm;
