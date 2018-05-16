import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';

import LoginScreen from './Login/LoginScreen';
import CurriculumForm from './Curriculum/CurriculumForm';

import { PrivateRoute } from './Login/Auth';

import '../index.scss';

/** This class wraps all our data and delegate the methods to the others */
class App extends Component {
  state = {}

  /**
   * @method App#render
   * @return {HTMLElement} - Main component
   */
  render() {
    return (
      <Switch>
        <Route exact path="/" component={LoginScreen} />
        <PrivateRoute path="/curriculum" component={CurriculumForm} />
      </Switch>
    );
  }
}

export default App;
