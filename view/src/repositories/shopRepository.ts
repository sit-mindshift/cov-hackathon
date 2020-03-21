/* tslint:disable:no-console */
import {Shop} from '@/store/models/shop';

import httpClient from '@/utils/HttpClient';
import user from "@/store/models/user";

async function getShops() {
  try {
    const response =
      await httpClient.get('http://localhost:8080/store-api/stores', {
        params: {
          longitude: user.state.fakedlong,
          latitude: user.state.fakedlat,
          span: 5000,
        }});

    let shops: Shop[] = [];

    // @ts-ignore
    for(let data of response.Store) {
      // @ts-ignore
      shops.push(new Shop(data.storeId, data.x, data.y,
        // @ts-ignore
        data.zipcode, data.city, data.street, data.oh))
    }

    return shops;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

async function getAvaillableShopTimeSlots() {
  try {
    const response =
        await httpClient.get('http://localhost:8080/api/timeslots/', {
          params: {
            storeId: 1,
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
