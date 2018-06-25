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
  a.download = 'myFile.docx';
  // programatically click the link to trigger the download
  a.click();
  // release the reference to the file by revoking the Object URL
  window.URL.revokeObjectURL(url);
};

const download = (data) => {
  const params = { ...data };
  params.model = 1;
  delete params.user;

  const params1 = {
    "model": 1,
    "idCurriculum": 0,
    "name": "Seu Nome",
    "country": "Brasil",
    "state": "São Paulo",
    "city": "Santa Bárbara d'Oeste",
    "cellPhone": "(19) 9 98423-7308",
    "email": "brunoovedoveto@gmail.com",
    "github": "https://github.com/bleandro",
    "linkedin": null,
    "objective": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.",
    "summary": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum.",
    "abilities": [{
      "name": "Habilidade 1"
    }, {
      "name": "Habilidade 2"
    }, {
      "name": "Habilidade 3"
    }],
    "formations": [{
      "name": "Bacharelado em Ciências da Computação",
      "institution": "UNESP",
      "startDate": "2014",
      "finalDate": "Julho/2018",
      "location": "Rio Claro, São Paulo"
    }, {
      "name": "Técnico em Informática",
      "institution": "ETEC Deputado Ary de Camargo Pedroso",
      "startDate": "2012",
      "finalDate": "2013",
      "location": "Piracicaba, São Paulo"
    }],
    "languages": [{
      "name": "Inglês",
      "languageProeficiency": "ADVANCED"
    }, {
      "name": "Espanhol",
      "languageProeficiency": "FLUENT"
    }],
    "professionalExperiences": [{
      "job": "Estagiário Desenvolvimento Web",
      "startDate": "Janeiro 2017",
      "finalDate": "Atualmente",
      "company": "Empresa",
      "location": "Cidade, Estado",
      "jobDescription": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed luctus tempus dolor, non volutpat neque rutrum aliquam. Interdum et malesuada fames ac ante ipsum primis in faucibus."
    }, {
      "job": "Estagiário de Desenvolvimento",
      "startDate": "Agosto",
      "finalDate": "Dezembro 2016",
      "company": "Empresa",
      "location": "Cidade, São Paulo",
      "jobDescription": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed luctus tempus dolor, non volutpat neque rutrum aliquam. Interdum et malesuada fames ac ante ipsum primis in faucibus."
    }]
  }

  downloadCurriculum(params1)
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
