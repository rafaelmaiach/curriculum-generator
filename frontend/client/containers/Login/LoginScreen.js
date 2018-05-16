import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';

import { AuthObject } from './Auth';

/**
 * @override
 * @class LoginScreen
 */
class LoginScreen extends Component {
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
    return (
      <div>
        <p>You must log in to view the page</p>
        <button onClick={this.loginAction}>
          Log in
        </button>
      </div>
    );
  }
}

module.exports = withRouter(LoginScreen);
