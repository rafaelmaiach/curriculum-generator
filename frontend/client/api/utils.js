/**
 * @method getCustomFetchConfigUsing
 * @description Creates configuration for POST requests
 * @param {Object} options - POST options
 * @param {String} method - Default method setted to POST
 * @return {Object} POST configuration
 */
const getCustomFetchConfigUsing = (options, method = 'POST') => {
  const config = {
    method,
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(options),
  };

  return config;
};

/**
 * @method createUrlFrom
 * @description Creates API url
 * @param {String} path - API endpoint path
 * @returns {String} Final API url
 */
const createUrlFrom = (path) => {
  const baseUrl = 'http://localhost:8000';
  const url = `${baseUrl}${path}`;

  return url;
};

/**
 * @method createPromiseFor
 * @description Creates a promise for API request
 * @param {Object} param0 - Params containing the request's path and its params
 * @returns {Object} API response
 */
const createPromiseFor = ({ path, params, method }) => {
  const paramsCopy = params ? { ...params } : null;
  const defaultParams = {
    method: method || 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const url = createUrlFrom(path);

  return new Promise((resolve, reject) => {
    fetch(url, paramsCopy || defaultParams)
      .then((response) => {
        if (response.ok) {
          resolve(response.json());
        }
        reject(response);
      })
      .catch(error => reject(error));
  });
};

const createPromiseForDocument = ({ path, params, method }) => {
  const paramsCopy = params ? { ...params } : null;
  const defaultParams = {
    method: method || 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const url = createUrlFrom(path);

  return new Promise((resolve, reject) => {
    fetch(url, paramsCopy || defaultParams)
      .then((response) => {
        if (response.ok) {
          resolve(response.blob());
        }
        reject(response);
      })
      .catch(error => reject(error));
  });
};

module.exports = {
  getCustomFetchConfigUsing,
  createPromiseFor,
  createPromiseForDocument,
};
