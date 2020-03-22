/* tslint:disable:no-console */
import {Shop} from '@/store/models/shop';

import httpClient from '@/utils/HttpClient';
import user from '@/store/models/user';

async function getShops() {
  try {
    const response =
      await httpClient.get('/store-api/stores', {
        params: {
          longitude: user.state.longitude,
          latitude: user.state.latitude,
          span: 30000,
        }});

    const shops: Shop[] = [];

    // @ts-ignore
    for (const data of response.Store) {
      // @ts-ignore
      shops.push(new Shop(data.storeId, data.x, data.y,
        // @ts-ignore
        data.zipcode, data.city, data.street, data.oh));
    }

    return shops;
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
