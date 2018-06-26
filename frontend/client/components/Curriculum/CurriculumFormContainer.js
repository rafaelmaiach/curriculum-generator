import React, { Component } from 'react';

/**
 * @override
 * @class
 */
class CurriculumFormContainer extends Component {
  state = {
    name: '',
    country: '',
    state: '',
    city: '',
    cellPhone: '',
    email: '',
    github: '',
    linkedin: '',
    objective: '',
    summary: '',
    user: {
      idUser: null,
    },
    abilities: [],
    formations: {
      name: '',
      institution: '',
      startDate: '',
      finalDate: '',
      location: '',
    },
    languages: [],
    professionalExperiences: {
      job: '',
      startDate: '',
      finalDate: '',
      company: '',
      location: '',
      jobDescription: '',
    },
  }

  handleInput = ({ target }) => {
    this.setState(() => ({ [target.name]: target.value }));
  }

  handleFormation = ({ target }) => {
    const formations = Object.assign({}, this.state.formations);
    formations[target.name] = target.value;
    this.setState(() => ({ formations }));
  }

  createSimpleInput = ({ text, name }) => (
    <div key={name} className="form-input-container">
      <div className="form-input">{text}</div>
      <input name={name} type="text" onChange={this.handleInput} />
    </div>
  );

  createFormationInput = ({ text, name }) => (
    <div key={name} className="form-input-container">
      <div className="form-input">{text}</div>
      <input name={name} type="text" onChange={this.handleFormation} />
    </div>
  );

  /**
  * @method CurriculumFormContainer#render
  * @description Renders a component on screen
  * @returns {HTMLElement} CurriculumFormContainer component
  */
  render() {
    const simpleInputsInfosLeft = [
      { name: 'name', text: 'Name' },
      { name: 'city', text: 'City' },
      { name: 'state', text: 'State' },
      { name: 'country', text: 'Country' },
    ];

    const simpleInputsInfosRight = [
      { name: 'cellPhone', text: 'Phone' },
      { name: 'github', text: 'GitHub' },
      { name: 'linkedin', text: 'LinkedIn' },
    ];

    const inputsFormationInfo = [
      { name: 'name', text: 'Name' },
      { name: 'institution', text: 'Institution' },
      { name: 'startDate', text: 'Start Date' },
      { name: 'finalDate', text: 'End Date' },
      { name: 'location', text: 'Location' },
    ];

    const inputsLeft = simpleInputsInfosLeft.map(this.createSimpleInput);
    const inputsRight = simpleInputsInfosRight.map(this.createSimpleInput);
    const inputsFormation = inputsFormationInfo.map(this.createFormationInput);

    console.log(this.state.formations);

    return (
      <div className="curriculum-form__container">
        <div className="curriculum-top-container">
          <div className="curriculum-form-box">
            {inputsLeft}
          </div>
          <div className="curriculum-form-box">
            {inputsRight}
          </div>
        </div>
        <div className="curriculum-bottom-container">
          <div className="form-input-container">
            <div className="form-input">Objective</div>
            <input name="objective" type="text" onChange={this.handleInput} />
          </div>
          <div className="form-input-container">
            <div className="form-input">Summary</div>
            <textarea
              name="summary"
              value={this.state.summary}
              onChange={this.handleInput}
            />
          </div>
          <div className="form-input-container">
            <div className="form-input">Abilities</div>
            <input name="abilities" type="text" onChange={this.handleInput} />
          </div>
          <div className="form-input-container">
            <div className="form-input">Languages</div>
            <input name="languages" type="text" onChange={this.handleInput} />
          </div>
          <div className="form-input-formation">
            <div className="formation-text">
              FORMATION
            </div>
            <div className="formation-fields">
              {inputsFormation}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CurriculumFormContainer;
