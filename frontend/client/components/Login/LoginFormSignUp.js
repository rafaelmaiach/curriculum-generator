/**
 * Login
Password
Name
Country
State
City
Cellphone
Email
GitHub
Linkedin
 */

import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

/**
 * @override
 * @class LoginFormSignUp
 */
class LoginFormSignUp extends Component {
  state = {
    account: {
      username: '',
      password: '',
      name: '',
      city: '',
      state: '',
      country: '',
      phone: '',
      email: '',
      gitHub: '',
      linkedin: '',
    },
    error: false,
  }

  handleInput = ({ target }) => {
    const returnObj = { ...this.state };
    returnObj.account[target.name] = target.value;

    this.setState(() => returnObj);
  }

  submitSignUp = () => {
    const { username, password } = this.state.account;
    console.log(this.state);
    const validUsername = username.length > 0;
    const validPassword = password.length > 0;

    if (validUsername && validPassword) {
      this.setState(() => ({ error: false }));
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
      'cellphone',
      'email',
      'gitHub',
      'linkedin',
    ];

    const form = fields.map(e => (
      <div key={e} className="form-input-container">
        <div className="form-input">
          {`${e[0].toUpperCase()}${e.substr(1)}`}
        </div>
        <input name={e} type="text" onChange={this.handleInput} />
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

