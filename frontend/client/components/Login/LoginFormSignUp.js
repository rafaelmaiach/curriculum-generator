import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

import { registerUser } from '../../api';
import { showToastr } from '../Toastr/Toastr';

/**
 * @override
 * @class LoginFormSignUp
 */
class LoginFormSignUp extends Component {
  state = {
    account: {
      name: '',
      city: '',
      state: '',
      country: '',
      username: '',
      password: '',
      phone: '',
      email: '',
      github: '',
      linkedin: '',
    },
    error: false,
  }

  mapRegisterInfo = () => {
    const {
      name,
      city,
      state,
      country,
      username,
      password,
      phone,
      email,
      github,
      linkedin,
    } = this.state.account;

    return {
      name,
      city,
      state,
      country,
      access: {
        login: username,
        password,
      },
      contact: {
        cellPhone: phone,
        email,
        github,
        linkedin,
      },
    };
  }

  handleInput = ({ target }) => {
    const returnObj = { ...this.state };
    returnObj.account[target.name] = target.value;

    this.setState(() => returnObj);
  }

  handleSignUp = (error, result = null, message = null) => {
    if (result === -1) {
      showToastr('USER ALREADY REGISTERED', 'error');
      console.log('Error on registerUser: User already registered');
    } else if (error) {
      showToastr('ERROR REGISTER!', 'error');
      console.log(`Error on registerUser: ${message}`);
    } else {
      showToastr('SUCCESS REGISTER!', 'success');
    }

    this.setState(() => ({
      account: {
        username: '',
        password: '',
        name: '',
        city: '',
        state: '',
        country: '',
        phone: '',
        email: '',
        github: '',
        linkedin: '',
      },
      error,
    }));
  }

  submitSignUp = () => {
    const { username, password } = this.state.account;
    const validUsername = username.length > 0;
    const validPassword = password.length > 0;

    if (validUsername && validPassword) {
      this.setState(() => ({ error: false }));

      const registerInfo = this.mapRegisterInfo();

      registerUser(registerInfo)
        .then(result => this.handleSignUp(false, result))
        .catch(error => this.handleSignUp(true, null, error.message));
    } else {
      this.setState(() => ({ error: true }));
    }
  }

  /**
  * @method LoginFormSignUp#render
  * @description Renders a component on screen
  * @returns {HTMLElement} LoginFormSignUp component
  */
  render() {
    const fields = [
      'username',
      'password',
      'name',
      'city',
      'state',
      'country',
      'phone',
      'email',
      'github',
      'linkedin',
    ];

    const form = fields.map(e => (
      <div key={e} className="form-input-container">
        <div className="form-input">
          {`${e[0].toUpperCase()}${e.substr(1)}`}
        </div>
        <input
          name={e}
          type={e === 'password' ? 'password' : 'text'}
          value={this.state.account[e]}
          onChange={this.handleInput}
        />
      </div>
    ));

    return (
      <div className="login-form__container signup-container">
        {form}
        {
          this.state.error ?
            <div className="login-credentials-error">
              *Username or password invalid
            </div> :
            null
        }
        <div className="form-buttons-container">
          <button className="form-button" onClick={this.submitSignUp}>
            Sign up
          </button>
          <button className="form-button" onClick={this.props.handleSignup}>
            Cancel
          </button>
        </div>
      </div>
    );
  }
}

module.exports = withRouter(LoginFormSignUp);

