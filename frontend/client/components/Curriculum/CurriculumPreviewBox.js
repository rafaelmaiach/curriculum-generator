import React from 'react';

import { downloadCurriculum } from '../../api';

const getDocument = (result) => {
  // Create a link element, hide it, direct it towards the blob, and then 'click' it programatically
  const a = document.createElement('a');
  a.style = 'display: none';
  document.body.appendChild(a);
  // Create a DOMString representing the blob and point the link element towards it
  const url = window.URL.createObjectURL(result);
  a.href = url;
  a.download = 'curriculum.docx';
  // programatically click the link to trigger the download
  a.click();
  // release the reference to the file by revoking the Object URL
  window.URL.revokeObjectURL(url);
};

const download = (data) => {
  const params = { ...data };
  params.model = 1;
  delete params.user;

  downloadCurriculum(params)
    .then(result => getDocument(result))
    .catch(error => console.log(error.message));
};

const CurriculumBox = props => (
  <div className="curriculum-box-container">
    <div className="curriculum-box-info">
      <div className="curriculum-box-info-title">
        Objective
      </div>
      <div className="curriculum-box-info-text">
        <p> {props.data.objective} </p>
      </div>
    </div>
    <button
      className="curriculum-box-download"
      onClick={() => download(props.data)}
    >
      Download
    </button>
  </div>
);

module.exports = CurriculumBox;
