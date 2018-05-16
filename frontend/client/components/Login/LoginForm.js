import React from 'react';

const LoginForm = ({ handleUsername, handlePassword }) => (
  <div className="login-form__container">
    <div className="login-form__username-container">
      <div className="login-form__input">Username:</div>
      <input type="text" onChange={handleUsername} />
    </div>
    <div className="login-form__password-container">
      <div className="login-form__input">Password:</div>
      <input type="password" onChange={handlePassword} />
    </div>
  </div>
);

module.exports = LoginForm;
