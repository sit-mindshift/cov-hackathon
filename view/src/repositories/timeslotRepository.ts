/* tslint:disable:no-console */

import httpClient from '@/utils/HttpClient';
import {Timeslot} from '@/store/models/timeslot';

async function getTimeslots() {
  try {
    const response =
      await httpClient.get('http://localhost:8080/api/timeslots', {
        params: {
          storeId: "1"
        }});

    let timeslots: Timeslot[] = [];

    // @ts-ignore
    for(let data of response.Timeslot) {
      // @ts-ignore
      timeslots.push(new Timeslot(data.storeId, data.date, data.from, data.til))
    }

    return timeslots;
  } catch (error) {
    // @ts-ignore
    console.error(error);
  }
}

export default timeslotsRepository;
