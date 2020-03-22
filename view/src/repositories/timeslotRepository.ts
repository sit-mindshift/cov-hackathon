/* tslint:disable:no-console */

import httpClient from '@/utils/HttpClient';
import {Timeslot} from '@/store/models/timeslot';

async function getTimeslots() {
  try {
    const response =
      await httpClient.get('http://localhost:8080/api/timeslots/1');

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

async function reserveTimelot(userId: string, storeId: string, timeslotId: string) {
  try {
    const response =
        await httpClient.post(`http://localhost:8080/api/timeslot/reserve/${userId}/${storeId}/${timeslotId}`);

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
};

export default timeslotsRepository;
