import React from 'react';

const Toastr = () => (
  <div className="toastr">
    <div className="toastr__item" />
  </div>
);

export const closeToastr = () => {
  const toastr = document.querySelector('.toastr');
  const toastrItem = document.querySelector('.toastr__item');

  toastr.classList.remove('toastr--active');

  toastrItem.classList.remove('toastr__item--success');
  toastrItem.classList.remove('toastr__item--error');
  toastrItem.classList.remove('toastr__item--waiting');
};

export const showToastr = (msg, type, wait = false) => {
  const getColorByType = (toastrType) => {
    switch (toastrType) {
      case 'success':
        return 'toastr__item--success';
      case 'error':
        return 'toastr__item--error';
      case 'waiting':
        return 'toastr__item--waiting';
      default:
        break;
    }

    return null;
  };

  const toastr = document.querySelector('.toastr');
  if (!toastr.classList.contains('toastr--active')) {
    const toastrItem = document.querySelector('.toastr__item');

    const color = getColorByType(type);

    toastrItem.innerText = msg;
    toastrItem.classList.add(color);

    toastr.classList.add('toastr--active');
    if (!wait) {
      setTimeout(() => {
        toastr.classList.remove('toastr--active');
      }, 1500);

      setTimeout(() => {
        toastrItem.classList.remove('toastr__item--success');
        toastrItem.classList.remove('toastr__item--error');
        toastrItem.classList.remove('toastr__item--waiting');
        toastrItem.innerText = '';
      }, 1850);
    }
  }
};

export default Toastr;
