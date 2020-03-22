/* tslint:disable:no-console */

import httpClient from '@/utils/HttpClient';
import {Timeslot} from '@/store/models/timeslot';

async function getTimeslots() {
  try {
    const response =
      await httpClient.get('/api/timeslots/1');

    let timeslots: Timeslot[] = [];

    // @ts-ignore
    for(let data of response) {
      // @ts-ignore
      timeslots.push(new Timeslot(data.id, data.date, data.from, data.til))
    }

    return timeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

async function getUserTimelots(userId: string) {
  try {
    const response =
        await httpClient.get(`/api/timeslot/${userId}`);

    let userTimeslots: Timeslot[] = [];

    // @ts-ignore
    for(let data of response.timeSlots) {
      // @ts-ignore
      userTimeslots.push(new Timeslot(data.id, data.date, data.from, data.til))
    }

    console.log('RESPONSE');
    console.log(userTimeslots);
    return userTimeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}
  


async function reserveTimelot(userId: string, storeId: string, timeslotId: string) {
  try {
    const response =
        await httpClient.post(`/api/timeslot/reserve/${userId}/${storeId}/${timeslotId}`);

    let timeslots: Timeslot[] = [];

    // @ts-ignore
    for(let data of response.timeSlots) {
      // @ts-ignore
      timeslots.push(new Timeslot(data.id, data.date, data.from, data.til))
    }

    return timeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}




const timeslotsRepository = {
  async getTimeslots() {
    return await getTimeslots();
  },
  async reserveTimelot(userId: string, storeId: string, timeslotId: string ) {
    return await reserveTimelot(userId, storeId, timeslotId);
  },
  async getUserTimeslots(userId: string) {
    return await getUserTimelots(userId);    
  }
};

export default timeslotsRepository;
