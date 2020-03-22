/* tslint:disable:no-console */
import httpClient from '@/utils/HttpClient';
import user from "@/store/models/user";
import timeslot from "@/store/models/timeslot";

async function getQRCodes() {
  try {
    let userId = user.state.personalData.id;

    const response =
      await httpClient.get('/qr-api/', {
        params: {
          userId: userId
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
