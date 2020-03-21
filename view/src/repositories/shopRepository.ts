/* tslint:disable:no-console */
import {Shop} from '@/store/models/shop';

import httpClient from '@/utils/HttpClient';

async function getShops() {
  try {
    const response =
      await httpClient.get('http://localhost:8080/store-api/', {
        params: {
          longitude: 4857204.52,
          latitude: 926664.12,
        }});

    // @ts-ignore
    return [new Shop(response.storeId, response.x, response.y, response.zipcode,
      // @ts-ignore
      response.city, response.street, response.oh)];
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

const shopRepository = {
  async getShops() {
    return await getShops();
  },
};

export default shopRepository;
