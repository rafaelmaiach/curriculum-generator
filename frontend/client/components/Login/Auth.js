import { signIn } from '../../api';

/**
 * @class Auth
 */
class Auth {
  userId = null;

  getUserId = () => this.userId;

  /**
   * @method Auth#login
   * @param {object} params - Contains username and password
   */
  async login(params) {
    const self = this;

    await signIn(params)
      .then((result) => {
        if (result !== null) {
          self.userId = result.idUser;
        }
      })
      .catch((error) => {
        self.userId = null;
        console.log(error.message);
      });
  }
}

module.exports = Auth;
