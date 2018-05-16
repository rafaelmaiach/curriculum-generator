import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

import { AuthObject } from './Auth';
import LoginForm from './LoginForm';

/**
 * @override
 * @class LoginScreen
 */
class LoginScreen extends Component {
  state = {
    username: '',
    password: '',
    signup: false,
  }

  handleUsername = ({ target }) => {
    this.setState(() => ({ username: target.value }));
  }

  handlePassword = ({ target }) => {
    this.setState(() => ({ password: target.value }));
  }

  handleSignup = () => {
    this.setState(() => ({ signup: true }));
  }

  submitLogin = () => {
    AuthObject.authenticate(() => {
      this.props.history.push('/curriculum');
    });
  }

  submitSignup = () => {
    console.log('submited');
  }

  cancelSignup = () => {
    this.setState(() => ({
      username: '',
      password: '',
      signup: false,
    }));
  }

  /**
   * @method LoginScreen#render
   * @description Renders a component on screen
   * @returns {HTMLElement} LoginScreen component
   */
  render() {
    const { signup } = this.state;
    return (
      <div className="login-screen-container">
        <div className="header-text"> CURRICULUM GENERATOR </div>
        <LoginForm
          handleUsername={this.handleUsername}
          handlePassword={this.handlePassword}
          handleSignup={this.handleSignup}
          submitLogin={this.submitLogin}
          submitSignup={this.submitSignup}
          cancelSignup={this.cancelSignup}
          signupStatus={signup}
        />
      </div>
    );
  }
}

module.exports = withRouter(LoginScreen);
