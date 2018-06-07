import React, { Component, Fragment } from 'react';
import { Switch, Route } from 'react-router-dom';

import Toastr from '../components/Toastr/Toastr';
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
      <Fragment>
        <Toastr key="appToastr" />
        <Switch>
          <Route exact path="/" component={LoginScreen} />
          <PrivateRoute path="/curriculum" component={CurriculumForm} />
        </Switch>
      </Fragment>
    );
  }
}

export default App;
