/* tslint:disable:no-console */
import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import timeslotRepository from '@/repositories/timeslotRepository';
import user from "./user";

export class Timeslot {
  public id: number;
  public date: string;
  public from: string;
  public til: string;

  public constructor(id: number, date: string, from: string,
                     til: string) {
    this.id = id;
    this.date = date;
    this.from = from;
    this.til = til;
  }
}

export interface TimeslotState {
  timeslots: Timeslot[];
  userTimeslots: Timeslot[];
  
}

const initialTimeslotState: TimeslotState = {
  timeslots: [],
  userTimeslots: [],
};

const b = getStoreBuilder<RootState>().module('timeslots', initialTimeslotState);

// getters
const timeslotsGetter = b.read((state) => state.timeslots, 'productGetter');
const timeslotByIdGetter = b.read(
  (state) => (i: number) =>
    state.timeslots.filter((s) => {
      return s.id === i;
    }), 'timeslotsFilter');

const userTimeslotsGetter = b.read((state) => state.userTimeslots, 'userTimeSlotsGetter');
const userTimeslotByIdGetter = b.read(
  (state) => (i: number) =>
    state.userTimeslots.filter((s) => {
      return s.id === i;
    }), 'userTimeslotsFilter');


// mutations
function setTimeslotList(state: TimeslotState, payload: { timeslots: Timeslot[] }) {
  state.timeslots = payload.timeslots;
}

function setUserTimeslotList(state: TimeslotState, payload: { timeslots: Timeslot[] }) {
  state.userTimeslots = payload.timeslots;
}

// action
async function readTimeslotList(context: BareActionContext<TimeslotState, RootState>) {
  const newTimeslot: Timeslot[] = await timeslotRepository.getTimeslots()
    || initialTimeslotState.timeslots;
  timeslots.setTimeslotList({timeslots: newTimeslot});
}

// action
async function readUserTimeslotList(context: BareActionContext<TimeslotState, RootState>) {
  const newUserTimeslot: Timeslot[] = await timeslotRepository.getUserTimeslots()
    || initialTimeslotState.userTimeslots;
  timeslots.setUserTimeslotList({timeslots: newUserTimeslot});
  user.dispatchReadQRCodeData();
}




// state
const stateGetter = b.state();

// exported "model" module interface
const timeslots = {
  // state
  get state() {
    return stateGetter();
  },
  // getters
  get allTimeslots() {
    return timeslotsGetter();
  },
  getTimeslotById(i: number) {
    return timeslotByIdGetter()(i);
  },

  get allUserTimeslots() {
    return userTimeslotsGetter();
  },
  getUserTimeslotById(i: number) {
    return userTimeslotByIdGetter()(i);
  },

  // mutations
  setTimeslotList: b.commit(setTimeslotList),
  setUserTimeslotList: b.commit(setUserTimeslotList),

  // actions
  dispatchReadTimeslotList: b.dispatch(readTimeslotList),
  dispatchReadUserTimeslotData: b.dispatch(readUserTimeslotList),
  

};

export default timeslots;




