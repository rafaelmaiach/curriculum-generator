import React, { Component } from 'react';

import CurriculumPreviewBox from './CurriculumPreviewBox';
import CurriculumFormContainer from './CurriculumFormContainer';
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
      () => ({ userId: this.props.match.params.userId }),
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

  createCurriculumPreviewBox = () => this.state.curriculumsList.map(data =>
    <CurriculumPreviewBox key={data.idCurriculum} data={data} />);


  /**
   * @method CurriculumForm#render
   * @description React render method
   * @returns {HTML} CurriculumForm container
   */
  render() {
    const { curriculumsList, menu } = this.state;

    if (!curriculumsList) {
      return null;
    }

    return (
      <div className="curriculum-menu-container">
        <div className="curriculum-header-container">
          <button
            className={
              `
              curriculum-header-container-button
              ${menu === 'list' ? 'active' : ''}
              `
            }
            onClick={() => this.setMenu('list')}
          >
            List
          </button>
          <button
            className={
              `
              curriculum-header-container-button
              ${menu === 'form' ? 'active' : ''}
              `
            }
            onClick={() => this.setMenu('form')}
          >
            New
          </button>
        </div>
        <div className="curriculum-content-container">
          {
            menu === 'list' ?
              this.createCurriculumPreviewBox() :
              <CurriculumFormContainer idUser={this.state.userId} />
          }
        </div>
      </div>
    );
  }
}

module.exports = CurriculumForm;
