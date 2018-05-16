import React from 'react';
import { render } from 'react-dom';
import { HashRouter } from 'react-router-dom';
import { AppContainer } from 'react-hot-loader'; //eslint-disable-line

import App from './containers/App';

const renderApp = Component =>
  render(
    <AppContainer>
      <HashRouter>
        <Component />
      </HashRouter>
    </AppContainer>,
    document.getElementById('app'),
  );

renderApp(App);

// Webpack Hot Module Replacement API
if (process.env.NODE_ENV === 'development' && module.hot) {
  module.hot.accept('./containers/App', () => {
    renderApp(App);
  });
}
