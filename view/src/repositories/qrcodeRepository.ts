/* tslint:disable:no-console */
import httpClient from '@/utils/HttpClient';
import user from "@/store/models/user";

async function getQRCodes() {
  try {
    console.log("repo");
    const response =
      await httpClient.get('http://localhost:8080/qr-api/', {
        params: {
          value: "hehexd"
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
