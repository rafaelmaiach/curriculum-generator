import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

import Auth from './Auth';

/**
 * @override
 * @class LoginFormSignIn
 */
class LoginFormSignIn extends Component {
  state = {
    username: '',
    password: '',
    error: false,
  }

  handleInput = ({ target }) => {
    this.setState(() => ({ [target.name]: target.value }));
  }

  submitLogin = async () => {
    const { username, password } = this.state;
    const validUsername = (username.trim()).length > 0;
    const validPassword = (password.trim()).length > 0;

    if (validUsername && validPassword) {
      this.setState(() => ({ error: false }));
      const params = {
        login: username,
        password,
      };

      const authInstance = new Auth();

      await authInstance.login(params);

      const userId = authInstance.getUserId();

      if (userId) {
        window.userId = userId;
        this.props.history.push('/curriculum');
      } else {
        this.setState(() => ({ error: true }));
      }

      return;
    }

    this.setState(() => ({ error: true }));
  }

  /**
  * @method LoginFormSignIn#render
  * @description Renders a component on screen
  * @returns {HTMLElement} LoginFormSignIn component
  */
  render() {
    const { error } = this.state;
    return (
      <div className="login-form__container">
        <div className="form-input-container">
          <div className="form-input">Username</div>
          <input name="username" type="text" onChange={this.handleInput} />
        </div>
        <div className="form-input-container">
          <div className="form-input">Password</div>
          <input name="password" type="password" onChange={this.handleInput} />
        </div>
        {
          error ?
            <div className="login-credentials-error">
              *Username or password invalid
            </div> :
            null
        }
        <div className="form-buttons-container">
          <button className="form-button" onClick={this.submitLogin}>
            Sign in
          </button>
          <button className="form-button" onClick={this.props.handleSignup}>
            Sign up
          </button>
        </div>
      </div>
    );
  }
}

module.exports = withRouter(LoginFormSignIn);
