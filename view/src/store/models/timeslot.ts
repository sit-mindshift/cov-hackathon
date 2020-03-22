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

// mutations
function setTimeslotList(state: TimeslotState, payload: { timeslots: Timeslot[] }) {
  state.timeslots = payload.timeslots;
}

// action
async function readTimeslotList(context: BareActionContext<TimeslotState, RootState>) {
  const newTimeslot: Timeslot[] = await timeslotRepository.getTimeslots()
    || initialTimeslotState.timeslots;
  timeslots.setTimeslotList({timeslots: newTimeslot});
}

// action
async function readUserTimeslotList(context: BareActionContext<TimeslotState, RootState>) {
  const newUserTimeslot: Timeslot[] = await timeslotRepository.getUserTimeslots("5e77678014aff82a4c6318aa")
    || initialTimeslotState.userTimeslots;
  timeslots.setTimeslotList({timeslots: newUserTimeslot});
  // user.dispatchReadQRCodeData();
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

  // mutations
  setTimeslotList: b.commit(setTimeslotList),
  

  // actions
  dispatchReadTimeslotList: b.dispatch(readTimeslotList),
  dispatchReadUserTimeslotData: b.dispatch(readUserTimeslotList),

};

export default timeslots;




