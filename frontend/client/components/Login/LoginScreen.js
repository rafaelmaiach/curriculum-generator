import React, { Component } from 'react';

import LoginFormSignIn from './LoginFormSignIn';
import LoginFormSignUp from './LoginFormSignUp';

/**
 * @override
 * @class LoginScreen
 */
class LoginScreen extends Component {
  state = {
    signupStatus: false,
  }

  handleSignup = () => {
    this.setState(prevState => ({ signupStatus: !prevState.signupStatus }));
  }

  submitSignup = () => {
    console.log('submited');
  }

  /**
   * @method LoginScreen#render
   * @description Renders a component on screen
   * @returns {HTMLElement} LoginScreen component
   */
  render() {
    const { signupStatus } = this.state;

    const form = !signupStatus ?
      (<LoginFormSignIn
        submitLogin={this.submitLogin}
        handleSignup={this.handleSignup}
      />) :
      (<LoginFormSignUp
        submitSignup={this.submitSignup}
        handleSignup={this.handleSignup}
      />);

    return (
      <div className="login-screen-container">
        <div className="header-text"> CURRICULUM GENERATOR </div>
        {form}
      </div>
    );
  }
}

module.exports = LoginScreen;
