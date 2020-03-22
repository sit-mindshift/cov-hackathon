/* tslint:disable:no-console */
import httpClient from '@/utils/HttpClient';
import user from '@/store/models/user';

async function getQRCodes() {
  try {
    const userId = user.state.personalData.id;

    const response =
      await httpClient.get('/qr-api/', {
        params: {
          userId
        }});
    return response;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

const qrcodeRepository = {
  async getQRCodes() {
    return await getQRCodes();
  },
};

export default qrcodeRepository;
