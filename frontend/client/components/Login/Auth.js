import { signIn } from '../../api';

const AuthObject = {
  userId: null,
  async authenticate(params) {
    const self = this;

    await signIn(params)
      .then((result) => {
        if (result !== null) {
          self.userId = result;
        }
      })
      .catch((error) => {
        self.userId = null;
        console.log(error.message);
      });

    return self.userId;
  },
};

module.exports = {
  AuthObject,
};
