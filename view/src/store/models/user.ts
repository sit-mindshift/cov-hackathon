import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import shopRepository from '@/repositories/shopRepository';

export interface UserState {
  longitude: string;
  latitude: string;
}

const initialUserState: UserState = {
  longitude: "4857204",
  latitude: "926664",
};
const b = getStoreBuilder<RootState>().module('user', initialUserState);

// mutations
function changePosition(state: UserState, payload: {longitude: string, latitude: string}) {
  state.longitude = payload.longitude;
  state.latitude = payload.latitude;
}

// state
const stateGetter = b.state();

// exported "model" module interface
const user = {
  // state
  get state() {
    return stateGetter();
  },

  // mutations
  changePosition: b.commit(changePosition),

};

export default user;



