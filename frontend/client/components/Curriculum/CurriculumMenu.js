import React, { Component } from 'react';

import CurriculumBox from './CurriculumBox';
import { listCurriculums } from '../../api';

/**
 * @override
 * @class CurriculumForm
 */
class CurriculumForm extends Component {
  state = {
    userId: null,
    curriculumsList: null,
    menu: 'list', // 'list' or 'form'
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

  setMenu = (type) => {
    this.setState(
      () => ({ menu: type }),
      () => {
        if (this.state.menu === 'list') {
          this.getCurriculums();
        }
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
    const { curriculumsList, menu } = this.state;

    return (
      <div className="curriculum-menu-container">
        <div className="curriculum-header-container">
          <button
            className="curriculum-header-container-button"
            onClick={() => this.setMenu('list')}
          >
            List Curriculums
          </button>
          <button
            className="curriculum-header-container-button"
            onClick={() => this.setMenu('form')}
          >
            New Curriculum
          </button>
        </div>
        <div className="curriculum-content-container">
          {
            menu === 'list' && curriculumsList ?
              this.createCurriculumBox() :
              null
          }
        </div>
      </div>
    );
  }
}

module.exports = CurriculumForm;
