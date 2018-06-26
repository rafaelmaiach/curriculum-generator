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
    abilities: '',
    formations: {
      name: '',
      institution: '',
      startDate: '',
      finalDate: '',
      location: '',
    },
    languages: '',
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

  handleProfessional = ({ target }) => {
    const professionalExperiences =
      Object.assign({}, this.state.professionalExperiences);
    professionalExperiences[target.name] = target.value;
    this.setState(() => ({ professionalExperiences }));
  }

  createSimpleInput = ({ text, name }) => (
    <div key={name} className="form-input-container">
      <div className="form-input">{text}</div>
      <input
        name={name}
        type="text"
        onChange={this.handleInput}
        value={this.state[name]}
      />
    </div>
  );

  createFormationInput = ({ text, name }) => (
    <div key={name} className="form-input-container">
      <div className="form-input">{text}</div>
      <input
        name={name}
        type="text"
        onChange={this.handleFormation}
        value={this.state.formations[name]}
      />
    </div>
  );

  createProfessionalInput = ({ text, name }) => (
    <div key={name} className="form-input-container">
      <div className="form-input">{text}</div>
      {
        name !== 'jobDescription' ?
          <input
            name={name}
            type="text"
            onChange={this.handleProfessional}
            value={this.state.professionalExperiences[name]}
          /> :
          <textarea
            name={name}
            value={this.state.professionalExperiences[name]}
            onChange={this.handleProfessional}
          />
      }
    </div>
  );

  saveForm = () => {

  }

  completeForm = () => {
    const completeForm = {
      name: 'Default Name',
      country: 'Default Country',
      state: 'Default State',
      city: 'Default City',
      cellPhone: '(11) 11111-1111',
      email: 'default@email.com',
      github: 'http://github.com/defaultuser',
      linkedin: 'http://linkedin.com/in/defaultuser',
      objective: 'Lorem, ipsum dolor sit amet consectetur adipisicing elit.',
      summary: 'Lorem, ipsum dolor sit amet consectetur adipisicing elit.',
      user: {
        idUser: null,
      },
      abilities: 'Skill 1; Skill 2; Skill 3',
      formations: {
        name: 'Default Course',
        institution: 'Default Institution',
        startDate: '01/03/2014',
        finalDate: '01/12/2017',
        location: 'Default Location',
      },
      // eslint-disable-next-line
      languages: 'Spanish: BASIC; French: INTERMEDIARY; English: ADVANCED; Portuguese: FLUENT',
      professionalExperiences: {
        job: 'Default Job',
        startDate: '01/03/2014',
        finalDate: 'Currently',
        company: 'Default Company',
        location: 'Default Location',
        // eslint-disable-next-line
        jobDescription: 'Lorem, ipsum dolor sit amet consectetur adipisicing elit.',
      },
    };

    this.setState(() => (completeForm));
  }

  clearForm = () => {
    const clearedForm = {
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
      abilities: '',
      formations: {
        name: '',
        institution: '',
        startDate: '',
        finalDate: '',
        location: '',
      },
      languages: '',
      professionalExperiences: {
        job: '',
        startDate: '',
        finalDate: '',
        company: '',
        location: '',
        jobDescription: '',
      },
    };

    this.setState(() => (clearedForm));
  }

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

    const formationInfo = [
      { name: 'name', text: 'Name' },
      { name: 'institution', text: 'Institution' },
      { name: 'startDate', text: 'Start Date' },
      { name: 'finalDate', text: 'End Date' },
      { name: 'location', text: 'Location' },
    ];

    const jobsInfo = [
      { name: 'job', text: 'Job' },
      { name: 'startDate', text: 'Start Date' },
      { name: 'finalDate', text: 'End Date' },
      { name: 'company', text: 'Company' },
      { name: 'location', text: 'Location' },
      { name: 'jobDescription', text: 'Job Description' },
    ];

    const inputsLeft = simpleInputsInfosLeft.map(this.createSimpleInput);
    const inputsRight = simpleInputsInfosRight.map(this.createSimpleInput);
    const inputsFormation = formationInfo.map(this.createFormationInput);
    const inputsProfessional = jobsInfo.map(this.createProfessionalInput);

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
            <input
              name="objective"
              type="text"
              onChange={this.handleInput}
              value={this.state.objective}
            />
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
            <div className="form-input">Skills</div>
            <input
              name="abilities"
              type="text"
              onChange={this.handleInput}
              value={this.state.abilities}
            />
          </div>
          <div className="form-input-container">
            <div className="form-input">Languages</div>
            <input
              name="languages"
              type="text"
              onChange={this.handleInput}
              value={this.state.languages}
            />
          </div>
          <div className="form-education-professional">
            <div className="form-input-formation">
              <div className="formation-text">
                EDUCATION
              </div>
              <div className="formation-fields">
                {inputsFormation}
              </div>
            </div>
            <div className="form-input-formation">
              <div className="formation-text">
                PROFESSIONAL EXPERIENCE
              </div>
              <div className="formation-fields">
                {inputsProfessional}
              </div>
            </div>
          </div>
          <footer>
            <button
              className="save-curriculum-button"
              onClick={this.saveForm}
            >
              SAVE
            </button>
            <button
              className="save-curriculum-button"
              onClick={this.completeForm}
            >
              AUTO COMPLETE
            </button>
            <button
              className="save-curriculum-button"
              onClick={this.clearForm}
            >
              CLEAR
            </button>
          </footer>
        </div>
      </div>
    );
  }
}

export default CurriculumFormContainer;
