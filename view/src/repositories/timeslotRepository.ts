import { store } from '@/store/store';
/* tslint:disable:no-console */

import httpClient from '@/utils/HttpClient';
import {Timeslot} from '@/store/models/timeslot';
import user from '../store/models/user';

async function getTimeslots() {
  try {
    const response =
      await httpClient.get('/api/timeslots/1');

    const timeslots: Timeslot[] = [];

    // @ts-ignore
    for(const data of response) {
      // @ts-ignore
      timeslots.push(new Timeslot(data.id, data.date, data.from, data.til))
    }

    return timeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

async function getUserTimeslots() {
  try {
    const userId = user.state.personalData.id;
    const response =
        await httpClient.get(`/api/timeslot/${userId}`);

    const userTimeslots: Timeslot[] = [];

    // @ts-ignore
    for(const data of response.timeSlots) {
      // @ts-ignore
      userTimeslots.push(new Timeslot(data.id, data.date, data.from, data.til))
    }

    return userTimeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}



async function reserveTimeslot(userId: string, storeId: string, timeslotId: string) {
  try {
    const response =
        await httpClient.post(`/api/timeslot/reserve/${userId}/${storeId}/${timeslotId}`);

    const timeslots: Timeslot[] = [];

    // @ts-ignore
    for(const data of response.timeSlots) {
      // @ts-ignore
      timeslots.push(new Timeslot(data.id, data.date, data.from, data.til))
    }

    return timeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

async function removeUserTimeslot(userId: string, timeslotId: string) {
  try {
    const response =
        await httpClient.post(`/api/timeslot/invalidate/${userId}/${timeslotId}`);

    const timeslots: Timeslot[] = [];

    // @ts-ignore
    for(const data of response.timeSlots) {
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
  async reserveTimeslot(userId: string, storeId: string, timeslotId: string ) {
    return await reserveTimeslot(userId, storeId, timeslotId);
  },
  async getUserTimeslots() {
    return await getUserTimeslots();
  },
  async removeUserTimeslot(userId: string, timeslotId: string) {
    return await removeUserTimeslot(userId, timeslotId);
  },

};

export default timeslotsRepository;
