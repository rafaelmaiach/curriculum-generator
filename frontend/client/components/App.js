import React, { Component, Fragment } from 'react';
import { Switch, Route } from 'react-router-dom';

import Toastr from '../components/Toastr/Toastr';
import LoginScreen from './Login/LoginScreen';
import CurriculumMenu from './Curriculum/CurriculumMenu';

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
          <Route path="/curriculum" component={CurriculumMenu} />
        </Switch>
      </Fragment>
    );
  }
}

export default App;
