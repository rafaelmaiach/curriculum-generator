import React from 'react';
import { Route, Redirect } from 'react-router-dom';

const AuthObject = {
  isAuthenticated: false,
  authenticate(cb) {
    this.isAuthenticated = true;
    setTimeout(cb, 100);
  },
  signout(cb) {
    this.isAuthenticated = false;
    setTimeout(cb, 100);
  },
};

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props => (
      AuthObject.isAuthenticated === true
        ? <Component {...props} />
        : <Redirect to={{
            pathname: '/',
            state: { from: props.location },
          }}
        />
      )
    }
  />
);

module.exports = {
  AuthObject,
  PrivateRoute,
};
