import React from 'react';

const LoginForm = props => (
  <div className="login-form__container">
    <div className="form-input-container">
      <div className="form-input">Username</div>
      <input type="text" onChange={props.handleUsername} />
    </div>
    <div className="form-input-container">
      <div className="form-input">Password</div>
      <input type="password" onChange={props.handlePassword} />
    </div>
    {!props.signupStatus ?
      (
        <div className="form-buttons-container">
          <button className="form-button" onClick={props.submitLogin}>
            Sign in
          </button>
          <button className="form-button" onClick={props.handleSignup}>
            Sign up
          </button>
        </div>
      ) :
      (
        <div className="form-buttons-container">
          <button className="form-button" onClick={props.submitSignup}>
            Submit
          </button>
          <button className="form-button" onClick={props.cancelSignup}>
            Cancel
          </button>
        </div>
      )
    }
  </div>
);

module.exports = LoginForm;
