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
  }

  handleUsername = ({ target }) => {
    this.setState(() => ({ username: target.value }));
  }

  handlePassword = ({ target }) => {
    this.setState(() => ({ password: target.value }));
  }

  loginAction = () => {
    AuthObject.authenticate(() => {
      this.props.history.push('/curriculum');
    });
  }

  /**
   * @method LoginScreen#render
   * @description Renders a component on screen
   * @returns {HTMLElement} LoginScreen component
   */
  render() {
    console.log(this.state);

    return (
      <div className="login-screen-container">
        <LoginForm
          handleUsername={this.handleUsername}
          handlePassword={this.handlePassword}
        />
      </div>
    );
  }
}

module.exports = withRouter(LoginScreen);
