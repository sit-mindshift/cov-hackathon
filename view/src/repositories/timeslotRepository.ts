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

const timeslotsRepository = {
  async getTimeslots() {
    return await getTimeslots();
  },
};

export default timeslotsRepository;
